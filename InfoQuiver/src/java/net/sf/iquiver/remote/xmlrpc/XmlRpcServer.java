/*
 * Created on 02.07.2004
 */
package net.sf.iquiver.remote.xmlrpc;

import net.sf.iquiver.configuration.Configuration;
import net.sf.iquiver.remote.BaseRemoteService;
import net.sf.iquiver.remote.IServer;

import org.apache.avalon.framework.configuration.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xmlrpc.WebServer;

/**
 * @author netseeker aka Michael Manske
 */
public class XmlRpcServer extends BaseRemoteService implements IServer
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog(XmlRpcServer.class);
        
    private WebServer webServer;
    private int port = 80;
    private boolean isRunning = false;
    
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
        boolean restart = isRunning;
        if(restart)
        {
            stop();
        }
        configure( config );
        if( restart)
        {
            start();
        }
    }
    

    /* (non-Javadoc)
     * @see net.sf.iquiver.remote.IServer#start(net.sf.iquiver.configuration.Configuration)
     */
    public void start( )
    {
        logger.info( "Starting XmlRpcServer at port " + port);
        webServer = new WebServer( port );
        webServer.addHandler("default", this);
        isRunning = true;
        logger.info( "XmlRpcServer running at port " + port );
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.remote.IServer#stop()
     */
    public void stop()
    {
        logger.info( "Stopping XmlRpcServer");
        if( isRunning && webServer != null )
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
        
        isRunning = false;
    }
}
