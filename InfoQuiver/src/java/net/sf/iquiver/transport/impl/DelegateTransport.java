/*********************************************************************
 * DelegateTransport.java
 * created on 18.07.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/transport/impl/DelegateTransport.java,v $
 * $Date: 2004/07/18 19:34:43 $
 * $Revision: 1.1 $
*********************************************************************/

package net.sf.iquiver.transport.impl;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
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
import org.apache.commons.io.output.CountingOutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.TorqueException;

/**
 * An transport implementation which is able to invoke external applications for fetching
 * and dispatching. Extremely useful for transport types/protocols which aren't supported by InfoQuiver.
 * NOTICE: when used for dispatching this Transport might indicate that the data (documents) are dispatched
 * successfully (by returning a correct amount of written/dispatched bytes). That amount of bytes is only
 * an indicator that this Transport has delegated all documents correct to the external application, but isn't an
 * indicator whether that application has correctly dispatched all data.
 * @author netseeker aka Michael Manske
 */
public class DelegateTransport implements Fetcher, Dispatcher
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog(DelegateTransport.class);

    public static final String ATTRIBUTE_EXECUTABLE = "Executable";
    public static final String ATTRIBUTE_ARGUMENTS = "Arguments";
    public static final String ATTRIBUTE_REPARSING_REQUIRED = "FetchResultRequiresParsing";
    public static final String ATTRIBUTE_TIMEOUT = "Timeout";
    
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

    /* (non-Javadoc)
     * @see net.sf.iquiver.transport.Fetcher#fetch()
     */
    public List fetch() throws TransportException
    {
        String executable = (String) this._fetchAttributes.get( ATTRIBUTE_EXECUTABLE );
        String args = executable + "," + (String)this._fetchAttributes.get( ATTRIBUTE_ARGUMENTS );        
        String[] arguments = args.split(",");
        List documents = new ArrayList();
        Document doc = null;
        try
        {
            doc = MetaFormatFactory.createDocumentForContentType( ContentTypeFactory.CT_MULTIPART_MIXED );
        }
        catch ( UnsupportedContentTypeException e1 )
        {
            //can't happen because we are using an default content type
        }
        
        InputStream in = null;
        
        try
        {
            Date date = new Date();
            Process child = Runtime.getRuntime().exec( arguments );
            in = child.getInputStream();
            doc.setRawContent( IOUtils.toByteArray( in ) );
            doc.setDateOfCreation( date );
            doc.setDateOfLastModification( date );
            doc.setAuthor( "Imported using " + executable );            
            documents.add( doc );            
        }
        catch ( IOException e )
        {
            throw new TransportException( e );
        }
        finally
        {
            if ( in != null )
            {
                IOUtils.closeQuietly( in );
            }
        }
        
        return documents;
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

    /* (non-Javadoc)
     * @see net.sf.iquiver.transport.Dispatcher#dispatch(java.util.List)
     */
    public long[] dispatch( List docs ) throws TransportException
    {
        long[] written = new long[docs.size()];        
        for( int i = 0; i < docs.size(); i++ )
        {
            Document doc = (Document)docs.get( i );
            CountingOutputStream cout = new CountingOutputStream( invokeForOutput() );
            
            try
            {                
                cout.write( doc.getRawContent() );
                written[ i ] = cout.getCount();
            }
            catch ( IOException e )
            {                
                logger.error( "IO Error occured while dispatching to " + (String) this._fetchAttributes.get( ATTRIBUTE_EXECUTABLE ));
            }
            finally
            {
                if( cout != null )
                {
                    IOUtils.closeQuietly( cout );
                }
            }
            
        }
        
        return written;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.transport.Dispatcher#dispatch(net.sf.iquiver.metaformat.Document)
     */
    public long dispatch( Document doc ) throws TransportException
    {
        long written = -1;
        CountingOutputStream cout = new CountingOutputStream( invokeForOutput() );
       
        try
        {                
            cout.write( doc.getRawContent() );
            written = cout.getCount();
        }
        catch ( IOException e )
        {                
            logger.error( "IO Error occured while dispatching to " + (String) this._fetchAttributes.get( ATTRIBUTE_EXECUTABLE ));
            throw new TransportException( e );
        }
        finally
        {
            if( cout != null )
            {
                IOUtils.closeQuietly( cout );
            }
        }
                
        return -1;
    }

    private OutputStream invokeForOutput() throws TransportException
    {
        String executable = (String) this._fetchAttributes.get( ATTRIBUTE_EXECUTABLE );
        String args = executable + "," + (String)this._fetchAttributes.get( ATTRIBUTE_ARGUMENTS );        
        String[] arguments = args.split(",");        
        Process child = null;
        try
        {
            child = Runtime.getRuntime().exec( arguments );
        }
        catch ( IOException e )
        {
            throw new TransportException( e );
        }
        
        return new BufferedOutputStream( child.getOutputStream() );
    }
    
}
