/*********************************************************************
 * FTPTransport.java
 * created on 23.10.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/transport/impl/FTPTransport.java,v $
 * $Date: 2004/10/24 16:28:38 $
 * $Revision: 1.2 $
 *********************************************************************/

package net.sf.iquiver.transport.impl;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.metaformat.impl.ContentTypeFactory;
import net.sf.iquiver.metaformat.impl.MetaFormatFactory;
import net.sf.iquiver.om.ContentSource;
import net.sf.iquiver.parser.UnsupportedContentTypeException;
import net.sf.iquiver.transport.Dispatcher;
import net.sf.iquiver.transport.Fetcher;
import net.sf.iquiver.transport.TransportConfigurationException;
import net.sf.iquiver.transport.TransportException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.torque.TorqueException;

import de.netseeker.util.StringUtil;

/**
 * A transport for retrieving and sending documents via FTP
 * @author netseeker aka Michael Manske
 */
public class FTPTransport implements Fetcher, Dispatcher
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( FTPTransport.class );

    public static final String ATTRIBUTE_FTP_SERVER = "Server";
    public static final String ATTRIBUTE_FTP_PORT = "Port";
    public static final String ATTRIBUTE_FTP_USER_NAME = "Login";
    public static final String ATTRIBUTE_FTP_PASSWORD = "Password";
    public static final String ATTRIBUTE_FTP_REMOTE_FILEPATH = "FetchRemoteFilePath";
    public static final String ATTRIBUTE_FTP_REMOTE_DIRECTORY = "RemoteDirectory";

    private ContentSource _fetchLocation;
    private ContentSource _dispatchLocation;
    private Map _fetchAttributes;
    private Map _dispatchAttributes;
    private boolean _useAuthentification = false;
    FTPClient client = new FTPClient();

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.transport.Fetcher#setFetchLocation(net.sf.iquiver.om.ContentSource)
     */
    public void setFetchLocation( ContentSource source ) throws TransportConfigurationException
    {
        this._fetchLocation = source;
        try
        {
            this._fetchAttributes = source.getAttributesAsNamedMap();
        }
        catch ( TorqueException e )
        {
            throw new TransportConfigurationException( e );
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.transport.Fetcher#getFetchLocation()
     */
    public ContentSource getFetchLocation()
    {
        return this._fetchLocation;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.transport.Fetcher#fetch()
     */
    public List fetch() throws TransportException
    {
        String host = (String) _fetchAttributes.get( ATTRIBUTE_FTP_SERVER );
        String login = (String) _fetchAttributes.get( ATTRIBUTE_FTP_USER_NAME );
        String pwd = (String) _fetchAttributes.get( ATTRIBUTE_FTP_PASSWORD );
        String remoteDir = (String) _fetchAttributes.get( ATTRIBUTE_FTP_REMOTE_DIRECTORY );
        String remoteFile = (String) _fetchAttributes.get( ATTRIBUTE_FTP_REMOTE_FILEPATH );

        List documents = new ArrayList();

        try
        {
            _connectAndLogin( false );

            if (remoteDir != null)
            {
                client.changeWorkingDirectory( remoteDir );
            }

            _retrieveFilesRecursive( remoteFile, documents );
        }
        catch ( IOException e )
        {
            throw new TransportException( e );
        }
        finally
        {
            if (client.isConnected())
            {
                try
                {
                    client.disconnect();
                }
                catch ( IOException e )
                {
                    // do nothing
                }
            }
        }

        return documents;
    }

    /**
     * Recursively retrieves all files of the current directory and it's subdirectories
     * @param client
     * @param documents
     * @throws IOException
     */
    private void _retrieveFilesRecursive( String singleFilePath, List documents ) throws IOException
    {
        FTPFile[] files = (singleFilePath == null) ? client.listFiles() : client.listFiles( singleFilePath );

        for (int i = 0; i < files.length; i++)
        {
            InputStream in = null;

            try
            {
                if (files[i].isFile())
                {
                    Document doc = MetaFormatFactory.createDocumentForContentType( ContentTypeFactory
                            .getContentTypeForFile( files[i].getName() ) );
                    in = client.retrieveFileStream( files[i].getName() );
                    doc.setRawContent( IOUtils.toByteArray( in ) );
                    doc.setDateOfCreation( files[i].getTimestamp().getTime() );
                    doc.setDateOfLastModification( files[i].getTimestamp().getTime() );
                    doc.setAuthor( files[i].getUser() );
                    doc.setFileName( client.printWorkingDirectory() + File.separator + files[i].getName() );
                    documents.add( doc );
                }
                else if (files[i].isDirectory())
                {
                    client.changeWorkingDirectory( files[i].getName() );
                    _retrieveFilesRecursive( null, documents );
                    client.changeToParentDirectory();
                }
                else
                {
                    logger.error( "Unsupported filesystem entry: " + client.printWorkingDirectory() + File.separator
                            + files[i].getName() );
                }
            }
            catch ( UnsupportedContentTypeException e )
            {
                logger.error( "ContentType of " + files[i].getName() + " is not supported" );
            }
            finally
            {
                IOUtils.closeQuietly( in );
            }
        }
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.transport.Fetcher#isParsingRequired()
     */
    public boolean isParsingRequired()
    {
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.transport.Dispatcher#setDispatchLocation(net.sf.iquiver.om.ContentSource)
     */
    public void setDispatchLocation( ContentSource location ) throws TransportConfigurationException
    {
        this._dispatchLocation = location;
        try
        {
            this._dispatchAttributes = location.getAttributesAsNamedMap();
        }
        catch ( TorqueException e )
        {
            throw new TransportConfigurationException( e );
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.transport.Dispatcher#getDispatchLocation()
     */
    public ContentSource getDispatchLocation()
    {
        return this._dispatchLocation;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.transport.Dispatcher#dispatch(java.util.List)
     */
    public long[] dispatch( List docs ) throws TransportException
    {
        String remoteDir = (String) _fetchAttributes.get( ATTRIBUTE_FTP_REMOTE_DIRECTORY );
        long[] sent = new long[docs.size()];

        try
        {
            _connectAndLogin( true );

            if (remoteDir != null)
            {
                client.changeWorkingDirectory( remoteDir );
            }

            for (int i = 0; i < docs.size(); i++)
            {
                sent[i] = dispatch( (Document) docs.get( i ) );
            }
        }
        catch ( IOException e )
        {
            throw new TransportException( e );
        }
        finally
        {
            if (client.isConnected())
            {
                try
                {
                    client.disconnect();
                }
                catch ( IOException e )
                {
                    // do nothing
                }
            }
        }

        return sent;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.transport.Dispatcher#dispatch(net.sf.iquiver.metaformat.Document)
     */
    public long dispatch( Document doc ) throws TransportException
    {
        boolean disconnect = false;
        String fName = doc.getFileName();

        try
        {
            if (!client.isConnected())
            {
                String remoteDir = (String) _fetchAttributes.get( ATTRIBUTE_FTP_REMOTE_DIRECTORY );
                disconnect = true;
                _connectAndLogin( true );

                if (remoteDir != null)
                {
                    client.changeWorkingDirectory( remoteDir );
                }
            }
            
            if (fName == null || fName.length() == 0)
            {
                fName = doc.getUID();
                String ext = ContentTypeFactory.getFirstFileType( doc.getContentTypeStr() );
                if (ext != null && ext.length() > 0)
                {
                    fName += "." + ext;
                }
            }            

            if (!client.storeFile( fName, new BufferedInputStream( new ByteArrayInputStream( doc
                    .getRawContent() ) ) ))
            {
                throw new TransportException( "Upload of " + doc.getFileName() + " failed. --> "
                        + client.getReplyString() );
            }
        }
        catch ( IOException e )
        {
            throw new TransportException( e );
        }
        finally
        {
            if (disconnect && client.isConnected())
            {
                try
                {
                    client.disconnect();
                }
                catch ( IOException e )
                {
                    // do nothing
                }
            }
        }

        return 0;
    }

    private void _connectAndLogin( boolean dispatch ) throws TransportException
    {
        String host = (String) (dispatch ? _dispatchAttributes.get( ATTRIBUTE_FTP_SERVER ) : _fetchAttributes
                .get( ATTRIBUTE_FTP_SERVER ));
        String login = (String) (dispatch ? _dispatchAttributes.get( ATTRIBUTE_FTP_USER_NAME ) : _fetchAttributes
                .get( ATTRIBUTE_FTP_USER_NAME ));
        String pwd = (String) (dispatch ? _dispatchAttributes.get( ATTRIBUTE_FTP_PASSWORD ) : _fetchAttributes
                .get( ATTRIBUTE_FTP_PASSWORD ));

        boolean isPassive;
        if (dispatch)
        {
            isPassive = Boolean.valueOf(
                    StringUtil.defaultIfNull( (String) _fetchAttributes.get( ATTRIBUTE_FTP_PASSWORD ), "true" ) )
                    .booleanValue();
        }
        else
        {
            isPassive = Boolean.valueOf(
                    StringUtil.defaultIfNull( (String) _dispatchAttributes.get( ATTRIBUTE_FTP_PASSWORD ), "true" ) )
                    .booleanValue();
        }

        try
        {
            client.connect( host );

            if (!FTPReply.isPositiveCompletion( client.getReply() ))
            {                
                throw new TransportException( "Connection failed --> server " + host + " returned: "
                        + client.getReplyString() );
            }

            if (!client.login( login, pwd ))
            {
                client.logout();
                throw new TransportException( "Login failed --> server " + host + " returned: "
                        + client.getReplyString() );
            }

            if (isPassive)
            {
                client.enterLocalPassiveMode();
            }
        }
        catch ( IOException e )
        {
            throw new TransportException( e );
        }
    }
}