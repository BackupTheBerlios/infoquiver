/*
 * Created on 12.03.2004
 */
package net.sf.iquiver.transport.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.metaformat.impl.DefaultDocument;
import net.sf.iquiver.om.ContentSource;
import net.sf.iquiver.transport.Fetcher;
import net.sf.iquiver.transport.TransportConfigurationException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpRecoverableException;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.TorqueException;

/**
 * @author netseeker aka Michael Manske
 */
public class HTTPTransport implements Fetcher
{
    public static final String ATTRIBUTE_HTTP_SERVER    = "Server";
    public static final String ATTRIBUTE_HTTP_PORT      = "Port";
    public static final String ATTRIBUTE_HTTP_TIMEOUT   = "Timeout";
    public static final String ATTRIBUTE_HTTP_USER_NAME = "Login";
    public static final String ATTRIBUTE_HTTP_PASSWORD  = "Password";

    private static final Log   logger                   = LogFactory.getLog( HTTPTransport.class);

    private ContentSource      fetchLocation;
    private HttpClient         client;
    private HttpMethod         method;
    private boolean            useAuthentification      = false;

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.transport.Fetcher#setFetchLocation(net.sf.iquiver.om.ContentSource)
     */
    public void setFetchLocation( ContentSource source ) throws TransportConfigurationException
    {
        this.fetchLocation = source;
        this.client = new HttpClient();

        method = registerConfiguration();

        if ( source.getIsAuthentificationRequired() )
        {
            registerAuthentificationConfiguration();
            method.setDoAuthentication( true);
        }
    }

    /*
     * (non-Javadoc)
     * @see net.sf.iquiver.transport.Fetcher#fetch()
     */
    public List fetch()
    {
        List documents = new ArrayList();
        int statusCode = -1;
        
        // We will retry up to 3 times.
        for ( int attempt = 0; statusCode == -1 && attempt < 3; attempt++ )
        {
            try
            {
                // execute the method.
                statusCode = client.executeMethod( method);                
                Document doc = new DefaultDocument(method.getResponseBody());
                documents.add(doc);
            }
            catch ( HttpRecoverableException e )
            {
                logger.error( "A recoverable exception occurred, retrying.", e);
            }
            catch ( IOException e )
            {
                logger.error( "Failed to download file.", e);
                break;
            }
        }
        // Check that we didn't run out of retries.
        if ( statusCode == -1 )
        {
            logger.error( "Failed to recover from exception.");

        }
        
        return documents;
    }

    /**
     * @throws TransportConfigurationException
     */
    private void registerAuthentificationConfiguration() throws TransportConfigurationException
    {
        try
        {
            Map auth_attributes = this.fetchLocation.getAuthentificationAttributesAsNamedMap();
            String user = (String) auth_attributes.get( ATTRIBUTE_HTTP_USER_NAME);
            String pwd = (String) auth_attributes.get( ATTRIBUTE_HTTP_PASSWORD);

            if ( user != null && pwd != null )
            {
                client.getState( ).setCredentials( null, null, new UsernamePasswordCredentials( user, pwd ) );
            }
        }
        catch ( TorqueException e )
        {
            String msg = "Could not register authentification attributes.";
            logger.error( msg, e);
            throw new TransportConfigurationException( msg, e );
        }
    }

    /**
     * @return @throws
     *         TransportConfigurationException
     */
    private HttpMethod registerConfiguration() throws TransportConfigurationException
    {
        HttpMethod method = null;

        try
        {
            Map attributes = this.fetchLocation.getNonAuthentificationAttributesAsNamedMap();
            String host = (String) attributes.get( ATTRIBUTE_HTTP_SERVER);

            if ( host != null )
            {
                method = new GetMethod( host );
            }
        }
        catch ( TorqueException e )
        {
            String msg = "Could not register transport attributes.";
            logger.error( msg, e);
            throw new TransportConfigurationException( msg, e );
        }

        return method;
    }
}
