/*
 * Created on 13.07.2004
 */
package net.sf.iquiver.transport.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.CountingOutputStream;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.TorqueException;

import de.netseeker.util.FileUtil;

/**
 * An transport implementation which can be used for both, fetching and dispatching. This transport can use the local
 * filesystem as content source or dispatch target.
 * 
 * @author netseeker aka Michael Manske
 */
public class FSTransport implements Fetcher, Dispatcher
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( FSTransport.class );

    public static final String ATTRIBUTE_FS_DIRECTORY = "Directory";
    public static final String ATTRIBUTE_FS_TIMEOUT = "Timeout";
    public static final String ATTRIBUTE_FS_CLEAN_DIRECTORY = "CleanDirectory";

    private ContentSource _fetchLocation;
    private ContentSource _dispatchLocation;
    private Map _fetchAttributes;
    private Map _dispatchAttributes;

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
            this._fetchAttributes = source.getNonAuthentificationAttributesAsNamedMap();
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

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.transport.Fetcher#fetch()
     */
    public List fetch() throws TransportException
    {
        String dir = (String) this._fetchAttributes.get( ATTRIBUTE_FS_DIRECTORY );
        List filePaths = FileUtil.listFileNamesRecursive( dir );
        List documents = new ArrayList();

        if (filePaths != null)
        {
            for (Iterator it = filePaths.iterator(); it.hasNext();)
            {
                String path = (String) it.next();
                File file = new File( path );

                try
                {
                    Document doc = MetaFormatFactory.createDocumentForContentType( ContentTypeFactory
                            .getContentTypeForFile( file.getName() ) );
                    doc.setName( file.getName() );
                    doc.setFileName( file.getName() );
                    Date date = new Date( file.lastModified() );
                    doc.setDateOfCreation( date );
                    doc.setDateOfLastModification( date );
                    doc.setRawContent( FileUtil.fastToByteArray( file ) );
                    documents.add( doc );
                }
                catch ( UnsupportedContentTypeException e )
                {
                    logger.error( "File " + path + " has an unsupported content type.", e );
                }
                catch ( IOException e )
                {
                    logger.error( "An IOException occured while accessing file " + path, e );
                }
            }
        }

        //shall we delete the contents in the scanned directory?
        String del = (String) ObjectUtils.defaultIfNull( this._fetchAttributes.get( ATTRIBUTE_FS_CLEAN_DIRECTORY ),
                "false" );
        if (Boolean.valueOf( del ).booleanValue())
        {
            try
            {
                FileUtils.cleanDirectory( new File( dir ) );
            }
            catch ( IOException e )
            {
                logger.error( "Cleaning directory " + dir + " failed!", e );
            }
        }
        else
        {
            logger.warn( "Directory " + dir
                    + " was not cleaned after fetching. This might cause refetching/reindexing on the next run." );
        }

        return documents;
    }

    /*
     * (non-Javadoc)
     * 
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
            this._dispatchAttributes = location.getNonAuthentificationAttributesAsNamedMap();
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

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.transport.Dispatcher#dispatch(java.util.List)
     */
    public long[] dispatch( List docs ) throws TransportException
    {
        long[] written = new long[docs.size()];
        String dir = (String) this._fetchAttributes.get( ATTRIBUTE_FS_DIRECTORY );
        File fDir = new File( dir );
        if (!fDir.exists())
        {
            fDir.mkdir();
        }

        for (int i = 0; i < docs.size(); i++)
        {
            Document doc = (Document) docs.get( i );
            written[i] = writeFile( doc, fDir );

        }

        return written;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.transport.Dispatcher#dispatch(net.sf.iquiver.metaformat.Document)
     */
    public long dispatch( Document doc ) throws TransportException
    {
        String dir = (String) this._fetchAttributes.get( ATTRIBUTE_FS_DIRECTORY );
        File fDir = new File( dir );
        if (!fDir.exists())
        {
            fDir.mkdir();
        }

        return writeFile( doc, fDir );
    }

    /**
     * @param doc
     * @param fDir
     * @param fName
     * @return
     * @throws TransportException
     */
    private long writeFile( Document doc, File fDir ) throws TransportException
    {
        long written = -1;
        CountingOutputStream cout = null;
        String fName = doc.getFileName();
        
        try
        {
            if (fName == null || fName.length() == 0)
            {
                fName = new UID().toString();
                String ext = ContentTypeFactory.getFirstFileType( doc.getContentTypeStr() );                
                if( ext != null && ext.length() > 0)
                {
                    fName += "." + ext;
                }
            }

            cout = new CountingOutputStream( new BufferedOutputStream( new FileOutputStream( fDir.getAbsolutePath()
                    + File.pathSeparator + fName ) ) );
            cout.write( doc.getRawContent() );
            written = cout.getCount();
        }
        catch ( IOException e )
        {
            written = -1;
            logger.error( "IO Error occured while saving file " + fName, e );
            throw new TransportException( e );
        }
        finally
        {
            if (cout != null)
            {
                IOUtils.closeQuietly( cout );
            }
        }

        return written;
    }
}