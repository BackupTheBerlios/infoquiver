/*
 * Created on 14.07.2004
 */
package net.sf.iquiver.samples.transport;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.iquiver.IQuiver;
import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.metaformat.impl.MetaFormatFactory;
import net.sf.iquiver.om.ContentSource;
import net.sf.iquiver.parser.UnsupportedContentTypeException;
import net.sf.iquiver.transport.Fetcher;
import net.sf.iquiver.transport.TransportConfigurationException;
import net.sf.iquiver.transport.TransportException;

import org.apache.commons.io.IOUtils;
import org.apache.torque.TorqueException;

/**
 * Sample HTTP Fetcher Transport class
 * @author netseeker aka Michael Manske
 */
public class SimpleFetchTransport implements Fetcher
{
    public static final String ATTRIBUTE_SERVER = "Server";
    public static final String ATTRIBUTE_PORT = "Port";
    public static final String ATTRIBUTE_USER_NAME = "Login";
    public static final String ATTRIBUTE_PASSWORD = "Password";

    private ContentSource _fetchLocation;
    private Map _attributes;
    private Map _authentAttributes;    
    
    /* (non-Javadoc)
     * @see net.sf.iquiver.transport.Fetcher#setFetchLocation(net.sf.iquiver.om.ContentSource)
     */
    public void setFetchLocation( ContentSource source ) throws TransportConfigurationException
    {
        try
        {
            this._fetchLocation = source;
            this._attributes = this._fetchLocation.getNonAuthentificationAttributesAsNamedMap();
            this._authentAttributes = this._fetchLocation.getAuthentificationAttributesAsNamedMap();
            if( !this._attributes.containsKey( ATTRIBUTE_SERVER ) )
            {
                throw new TransportConfigurationException( "The mandatory attribute \"Server\" is missing!" );
            }
        }
        catch ( TorqueException e )
        {
            throw new TransportConfigurationException( "Could not register transport attributes.", e );
        }
    }

    /* (non-Javadoc)
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
        List documents = new ArrayList();
        DataInputStream input = null;
        URLConnection connection = null;

        try
        {
            URL url = new URL( (String)this._attributes.get( ATTRIBUTE_SERVER ) );
            connection = url.openConnection();
            connection.setRequestProperty( "User-Agent",
                IQuiver.NAME + " " + IQuiver.VERSION
                + " (http://developer.berlios.de/projects/infoquiver/)" );
            input = new DataInputStream( connection.getInputStream() );
            //create a new Document for the current contentType and encoding
            Document doc = MetaFormatFactory.createDocumentForContentType( connection.getContentType() );
            doc.setRawContent( IOUtils.toByteArray( input ) );
            documents.add( doc );
        }
        catch ( UnsupportedContentTypeException ue )
        {
            throw new TransportException( "Content type " + connection.getContentType() + " is not supported", ue );
        }        
        catch( IOException e )
        {
            throw new TransportException("IOException occured while fetching content from "
                    + (String)this._attributes.get( ATTRIBUTE_SERVER ), e );
        }
        finally
        {
            if( input != null )
            {
                try
                {
                    input.close();
                }
                catch( IOException e )
                {
                }
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
}
