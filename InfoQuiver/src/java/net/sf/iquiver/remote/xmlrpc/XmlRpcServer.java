/*
 * Created on 02.07.2004
 */
package net.sf.iquiver.remote.xmlrpc;

import net.sf.iquiver.configuration.Configuration;
import net.sf.iquiver.configuration.Reconfigurable;
import net.sf.iquiver.service.BaseRemoteService;
import net.sf.iquiver.service.ServiceStateListener;

import org.apache.avalon.framework.configuration.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xmlrpc.WebServer;

/**
 * XML-RPC Server interface, allowing clients to communicate with the infoquiver
 * server demon via XML-RPC.
 * @author netseeker aka Michael Manske
 */
public class XmlRpcServer extends BaseRemoteService implements Reconfigurable
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog(XmlRpcServer.class);
        
    private WebServer webServer;
    private int port = 80;
    
    
    /* (non-Javadoc)
     * @see net.sf.iquiver.configuration.Configurable#configure(net.sf.iquiver.configuration.Configuration)
     */
    public void configure( Configuration config ) throws ConfigurationException
    {       
        port = config.getInt( "net.sf.iquiver.remote.xmlrpc.XmlRpcServer.port", 80 );
    }
    
    /* (non-Javadoc)
     * @see net.sf.iquiver.configuration.Reconfigurable#reconfigure(net.sf.iquiver.configuration.Configuration)
     */
    public void reconfigure( Configuration config ) throws ConfigurationException
    {        
        boolean restart = false;
        if(getState() == ServiceStateListener.ST_STARTED)
        {
            super.stop();
            restart = true;
        }
        configure( config );
        if( restart)
        {
            super.start();
        }
    }
    
    /* (non-Javadoc)
     * @see net.sf.iquiver.remote.IServer#start(net.sf.iquiver.configuration.Configuration)
     */
    protected void doStart( )
    {
        logger.info( "Starting XmlRpcServer at port " + port);
        webServer = new WebServer( port );
        webServer.addHandler("default", this);
        logger.info( "XmlRpcServer running at port " + port );
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.remote.IServer#stop()
     */
    public void doStop()
    {
        logger.info( "Stopping XmlRpcServer");
        if( webServer != null )
        {
            try
            {
                webServer.shutdown();
                logger.info( "XmlRpcServer stopped");
            }
            catch (Exception e)
            {
                logger.error( "Exception occured while stopping the XmlRpcServer.", e);
            }
        }
        else
        {
            logger.warn( "XmlRpcServer was not running!");
        }        
    }
}
