/*
 * Created on 12.03.2004
 *
 */
package net.sf.iquiver.transport.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

import net.sf.iquiver.om.ContentSource;
import net.sf.iquiver.om.ContentSourceTransportConfig;
import net.sf.iquiver.om.ContentSourceTransportConfigPeer;
import net.sf.iquiver.om.Transport;
import net.sf.iquiver.om.TransportAttributePeer;
import net.sf.iquiver.transport.Fetcher;

/**
 * @author netseeker aka Michael Manske
 */
public class HTTPTransport implements Fetcher
{
    public static final int ATTRIBUTE_HTTP_SERVER = 8001;
    public static final int ATTRIBUTE_HTTP_PORT = 8002;
    public static final int ATTRIBUTE_HTTP_TIMEOUT = 8003;
    public static final int ATTRIBUTE_HTTP_USER_NAME = 8004;
    public static final int ATTRIBUTE_HTTP_PASSWORD = 8005;
    
    private ContentSource fetchLocation;
    private HttpClient client;
    private HttpMethod method;
    private boolean useAuthentification = false;
    
    /* (non-Javadoc)
     * @see net.sf.iquiver.transport.Fetcher#setFetchLocation(net.sf.iquiver.om.ContentSource)
     */
    public void setFetchLocation( ContentSource source )
    {
        this.fetchLocation = source;
        this.client = new HttpClient();
        
        method = registerConfiguration();
        
        if(source.getIsAuthentificationRequired())
        {            
            registerAuthentificationConfiguration();
            method.setDoAuthentication( true );
        }
        
        
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.transport.Fetcher#fetch()
     */
    public List fetch()
    {           
        return null;
    }

    private void registerAuthentificationConfiguration()
    {
        try
        {
            Map auth_attributes = this.fetchLocation.getAuthentificationAttributesAsMap();
            String user = (String)auth_attributes.get(new Integer(ATTRIBUTE_HTTP_USER_NAME));
            String pwd = (String)auth_attributes.get(new Integer(ATTRIBUTE_HTTP_PASSWORD));
            
            if(user != null && pwd != null)
            {
                client.getState().setCredentials("myrealm", "myhost", new UsernamePasswordCredentials(user, pwd));
            }
        }
        catch ( TorqueException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private HttpMethod registerConfiguration()
    {
        
        return null;
    }
    
}
