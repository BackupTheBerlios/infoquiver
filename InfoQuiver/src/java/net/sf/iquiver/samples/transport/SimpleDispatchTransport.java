/*********************************************************************
 * SimpleDispatchTransport.java
 * created on 17.10.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/samples/transport/SimpleDispatchTransport.java,v $
 * $Date: 2004/10/17 17:52:30 $
 * $Revision: 1.1 $
 *********************************************************************/

package net.sf.iquiver.samples.transport;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.server.UID;
import java.util.List;
import java.util.Map;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.metaformat.impl.ContentTypeFactory;
import net.sf.iquiver.om.ContentSource;
import net.sf.iquiver.transport.Dispatcher;
import net.sf.iquiver.transport.TransportConfigurationException;
import net.sf.iquiver.transport.TransportException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.CountingOutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.TorqueException;

/**
 * @author netseeker aka Michael Manske
 */
public class SimpleDispatchTransport implements Dispatcher
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( SimpleDispatchTransport.class );

    public static final String ATTRIBUTE_FS_DIRECTORY = "Directory";

    private ContentSource _dispatchLocation;
    private Map _dispatchAttributes;

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

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.transport.Dispatcher#dispatch(java.util.List)
     */
    public long[] dispatch( List docs ) throws TransportException
    {
        long[] written = new long[docs.size()];

        for (int i = 0; i < docs.size(); i++)
        {
            Document doc = (Document) docs.get( i );
            written[i] = dispatch( doc );
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
        String dir = (String) this._dispatchAttributes.get( ATTRIBUTE_FS_DIRECTORY );
        File fDir = new File( dir );
        
        if ( !fDir.exists() )
        {
            fDir.mkdir();
        }

        return writeFile( doc, fDir );
    }

    /**
     * Saves a document to a file
     * @param doc the Document to save
     * @param fDir the target file
     * @return the written filesize
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
                if (ext != null && ext.length() > 0)
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