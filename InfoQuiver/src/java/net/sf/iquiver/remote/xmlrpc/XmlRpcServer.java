/*
 * Created on 02.07.2004
 */
package net.sf.iquiver.remote.xmlrpc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.avalon.framework.configuration.ConfigurationException;
import org.apache.xmlrpc.WebServer;

import net.sf.iquiver.configuration.Configuration;
import net.sf.iquiver.remote.BaseRemoteService;
import net.sf.iquiver.remote.IServer;

/**
 * @author netseeker aka Michael Manske
 */
public class XmlRpcServer extends BaseRemoteService implements IServer
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog(XmlRpcServer.class);
        
    WebServer webServer;
    int port = 80;
    
    /* (non-Javadoc)
     * @see net.sf.iquiver.configuration.Configurable#configure(net.sf.iquiver.configuration.Configuration)
     */
    public void configure( Configuration config ) throws ConfigurationException
    {       
        stop();
        port = config.getInt( "net.sf.iquiver.remote.xmlrpc.XmlRpcServer.port", 80 );
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.remote.IServer#start(net.sf.iquiver.configuration.Configuration)
     */
    public void start( )
    {
        webServer = new WebServer( port );
        webServer.addHandler("default", this);
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.remote.IServer#stop()
     */
    public void stop()
    {
        if( webServer != null )
        {
            try
            {
                webServer.shutdown();
            }
            catch (Exception e)
            {
                logger.error( "Exception occured while stopping the XmlRpcServer.", e);
            }
        }
    }
}
