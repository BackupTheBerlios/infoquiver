/*
 * Created on 12.03.2004
 */
package net.sf.iquiver.transport.impl;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.iquiver.IQuiver;
import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.metaformat.impl.MetaFormatFactory;
import net.sf.iquiver.om.ContentSource;
import net.sf.iquiver.transport.Fetcher;
import net.sf.iquiver.transport.TransportConfigurationException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.util.DateParseException;
import org.apache.commons.httpclient.util.DateParser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.TorqueException;

/**
 * A transport for retrieving documents via HTTP
 * @author netseeker aka Michael Manske
 */
public class HTTPTransport implements Fetcher
{
    public static final String ATTRIBUTE_HTTP_SERVER = "Server";
    public static final String ATTRIBUTE_HTTP_PORT = "Port";
    public static final String ATTRIBUTE_HTTP_USER_NAME = "Login";
    public static final String ATTRIBUTE_HTTP_PASSWORD = "Password";

    private static final Log logger = LogFactory.getLog( HTTPTransport.class );

    private ContentSource _fetchLocation;
    private HttpClient _client;
    private HttpMethod _method;
    private boolean _useAuthentification = false;

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.transport.Fetcher#setFetchLocation(net.sf.iquiver.om.ContentSource)
     */
    public void setFetchLocation( ContentSource source ) throws TransportConfigurationException
    {
        this._fetchLocation = source;
        this._client = new HttpClient();

        _method = _registerConfiguration();
        _method.setRequestHeader( "User-Agent", IQuiver.NAME + " " + IQuiver.VERSION
                + " (http://developer.berlios.de/projects/infoquiver/)" );

        if (source.getIsAuthentificationRequired())
        {
            _registerAuthentificationConfiguration();
            _method.setDoAuthentication( true );
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
    public List fetch()
    {
        List documents = new ArrayList();

        try
        {
            if( _method.hasBeenUsed() )
            {
                _method.recycle();
            }
            
            // execute the method.
            _client.executeMethod( _method );
            String encoding = ((GetMethod) _method).getResponseCharSet();
            Header header = ((GetMethod) _method).getResponseHeader( "Content-Type" );
            String contentType = header.getValue();

            //check for non-standard content type strings
            if (contentType.indexOf( ";" ) != -1)
            {
                contentType = contentType.substring( 0, contentType.indexOf( ";" ) );
            }

            header = ((GetMethod) _method).getResponseHeader( "Date" );
            String created = header.getValue();
            header = ((GetMethod) _method).getResponseHeader( "Last-Modified" );
            String modified = null;
            if (header != null)
            {
                modified = header.getValue();
            }
            else
            {
                modified = created;
            }

            Document doc = MetaFormatFactory.createDocumentForContentType( contentType, _method.getResponseBody(),
                    encoding );
                       
            if (created != null)
            {
                try
                {
                    doc.setDateOfCreation( DateParser.parseDate( created ) );
                }
                catch ( DateParseException e )
                {
                    logger.error( "Unparseable date of creation: " + created, e );
                }
            }
            if (modified != null)
            {
                try
                {
                    doc.setDateOfLastModification( DateParser.parseDate( modified ) );
                }
                catch ( DateParseException e )
                {
                    logger.error( "Unparseable date of last modification: " + modified, e );
                }
            }

            doc.setFileName( _method.getURI().getPath() );
            doc.setInfoURL( new URL( _method.getURI().getURI() ) );
            documents.add( doc );
        }
        catch ( UnsupportedEncodingException ue )
        {
            logger.error( "Failed to convert downloaded file content to " + Document.DEFAULT_ENCODING, ue );
        }
        catch ( Exception e )
        {
            logger.error( "Failed to download file.", e );
        }
        finally
        {
            //always release the connection after we're done
            _method.releaseConnection();            
        }

        return documents;
    }

    /**
     * @throws TransportConfigurationException
     */
    private void _registerAuthentificationConfiguration() throws TransportConfigurationException
    {
        try
        {
            Map auth_attributes = this._fetchLocation.getAuthentificationAttributesAsNamedMap();
            String user = (String) auth_attributes.get( ATTRIBUTE_HTTP_USER_NAME );
            String pwd = (String) auth_attributes.get( ATTRIBUTE_HTTP_PASSWORD );

            if (user != null && pwd != null)
            {
                _client.getState().setCredentials( null, null, new UsernamePasswordCredentials( user, pwd ) );
            }
        }
        catch ( TorqueException e )
        {
            String msg = "Could not register authentification attributes.";
            logger.error( msg, e );
            throw new TransportConfigurationException( msg, e );
        }
    }

    /**
     * @return @throws TransportConfigurationException
     */
    private HttpMethod _registerConfiguration() throws TransportConfigurationException
    {
        HttpMethod method = null;

        try
        {
            Map attributes = this._fetchLocation.getNonAuthentificationAttributesAsNamedMap();
            String host = (String) attributes.get( ATTRIBUTE_HTTP_SERVER );

            if (host != null)
            {
                method = new GetMethod( host );
            }
        }
        catch ( TorqueException e )
        {
            String msg = "Could not register transport attributes.";
            logger.error( msg, e );
            throw new TransportConfigurationException( msg, e );
        }

        return method;
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
}