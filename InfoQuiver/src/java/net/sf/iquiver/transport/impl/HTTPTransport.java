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

import org.apache.commons.httpclient.Header;
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
     * 
     * @see net.sf.iquiver.transport.Fetcher#fetch()
     */
    public List fetch()
    {
        List documents = new ArrayList();

        try
        {
            // execute the method.
            client.executeMethod( method);
            DefaultDocument doc = new DefaultDocument(method.getResponseBody());
            doc.setEncoding(((GetMethod)method).getResponseCharSet());
            documents.add(doc);
            Header[] headers = method.getResponseHeaders();
            for(int i = 0; i < headers.length; i++)
            {
                Header header = headers[i];
                logger.debug(header.toExternalForm());
            }
        }
        catch ( Exception e )
        {
            logger.error( "Failed to download file.", e);
        }
        finally
        {
            //always release the connection after we're done
            method.releaseConnection();
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
