/*
 * Created on 05.03.2004
 *
 */
package net.sf.iquiver.configuration.impl;

import net.sf.iquiver.configuration.Configuration;
import net.sf.iquiver.configuration.Reconfigurable;

import org.apache.avalon.framework.activity.Disposable;
import org.apache.avalon.framework.configuration.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.Torque;

/**
 * @author netseeker aka Michael Manske
 */
public class PersistenceConfigurator implements Reconfigurable, Disposable
{
    private static final Log logger = LogFactory.getLog(PersistenceConfigurator.class);
    
    /* (non-Javadoc)
     * @see org.apache.avalon.framework.configuration.Configurable#configure(org.apache.avalon.framework.configuration.DefaultProperiesConfiguration)
     */
    public void configure( Configuration config ) throws ConfigurationException
    {
        //initialize torque
        try
        {
            Torque.init( config );
        }
        catch (Exception e)
        {
            logger.fatal("Couldn't initialize Torque");
            throw new ConfigurationException(e.getMessage());
        }       
    }

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.configuration.Reconfigurable#reconfigure(org.apache.avalon.framework.configuration.DefaultProperiesConfiguration)
     */
    public void reconfigure( Configuration config ) throws ConfigurationException
    {
        Torque.shutdown();
        configure(config);
    }

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.activity.Disposable#dispose()
     */
    public void dispose()
    {
        Torque.shutdown();
    }

}
