/*********************************************************************
 * RemoteInterfaceConfigurator.java
 * created on 1.12.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/configuration/impl/RemoteInterfaceConfigurator.java,v $
 * $Date: 2004/12/11 23:20:54 $
 * $Revision: 1.2 $
 *********************************************************************/

package net.sf.iquiver.configuration.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.iquiver.configuration.Configuration;
import net.sf.iquiver.configuration.Reconfigurable;
import net.sf.iquiver.event.IQEventListener;
import net.sf.iquiver.service.BaseRemoteService;
import net.sf.iquiver.service.ServiceStateChangedEvent;

import org.apache.avalon.framework.activity.Disposable;
import org.apache.avalon.framework.configuration.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author netseeker aka Michael Manske
 */
public class RemoteInterfaceConfigurator implements Reconfigurable, Disposable
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( RemoteInterfaceConfigurator.class );

    private IQEventListener _listener;
    
    /**
     * List of configured service instances
     */
    private List _services;

    /**
     * @param listener
     */
    public RemoteInterfaceConfigurator( IQEventListener listener )
    {
        this._listener = listener;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.configuration.Configurable#configure(net.sf.iquiver.configuration.Configuration)
     */
    public void configure( Configuration config ) throws ConfigurationException
    {
        _services = new ArrayList();
        String[] remotes = config.getStringArray( "startRemoteInterfaces" );

        if (remotes != null)
        {
            for (int i = 0; i < remotes.length; i++)
            {
                BaseRemoteService service = null;

                try
                {
                    service = (BaseRemoteService) Class.forName( remotes[i] ).newInstance();
                    service.addServiceExecutionListener( this._listener );
                    service.addServiceStateListener( this._listener );
                }
                catch ( ClassNotFoundException e )
                {
                    logger.error( "Unable to locate remote interface " + remotes[i] + ". Check your configuration.", e );
                    throw new ConfigurationException( e.getMessage() );
                }
                catch ( ClassCastException e )
                {
                    logger.error( "Remote interface " + remotes[i] + " does not extend "
                            + BaseRemoteService.class.getName(), e );
                    throw new ConfigurationException( e.getMessage() );
                }
                catch ( Exception e )
                {
                    logger.error( "Unable to start remote interface " + remotes[i] + ". Check your configuration.", e );
                    throw new ConfigurationException( e.getMessage() );
                }

                try
                {
                    service.configure( config );
                    service.start();
                    _services.add( service );
                    logger.info( "Started remote interface: " + remotes[i] );
                }
                catch ( Exception e )
                {
                    logger.error( "Error occured while starting remote interface " + remotes[i], e );
                }
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.configuration.Reconfigurable#reconfigure(net.sf.iquiver.configuration.Configuration)
     */
    public void reconfigure( Configuration config ) throws ConfigurationException
    {
        dispose();
        configure( config );
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.avalon.framework.activity.Disposable#dispose()
     */
    public void dispose()
    {
        for (Iterator it = _services.iterator(); it.hasNext();)
        {
            BaseRemoteService service = (BaseRemoteService) it.next();
            if (service.getState() == ServiceStateChangedEvent.ST_STOPPED)
            {
                try
                {
                    service.stop();
                }
                catch ( Exception e )
                {
                    logger.error( "Error occured while stopping remote interface " + service.getClass().getName(), e );
                }
            }
        }
        _services = null;
    }
}