/*
 * Created on 05.03.2004
 *  
 */
package net.sf.iquiver.configuration.impl;

import java.io.File;

import net.sf.iquiver.configuration.Configuration;
import net.sf.iquiver.configuration.ConfigurationConstants;
import net.sf.iquiver.configuration.Reconfigurable;

import org.apache.avalon.framework.configuration.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author netseeker aka Michael Manske
 */
public class LogConfigurator implements Reconfigurable
{
    private static Log logger;

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.avalon.framework.configuration.Configurable#configure(org.apache.avalon.framework.configuration.DefaultProperiesConfiguration)
     */
    public void configure( Configuration config ) throws ConfigurationException
    {
        if ( config == null )
        {
            System.setProperty( "log4j.configuration", ConfigurationConstants.DEFAULT_CONFIG_DIR + "/"
                    + ConfigurationConstants.CONFIG_FILE_CACHE);
            logger = LogFactory.getLog( LogConfigurator.class);
            logger.info( "Logging configured with settings from " + ConfigurationConstants.DEFAULT_CONFIG_DIR
                    + "/" + ConfigurationConstants.CONFIG_FILE_CACHE);
        }
        else
        {
            System.setProperty( "log4j.configuration", config.getFileName());
            logger = LogFactory.getLog( LogConfigurator.class);
            logger.info( "Logging configured with settings from " + config.getFileName());            
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.avalon.framework.configuration.Reconfigurable#reconfigure(org.apache.avalon.framework.configuration.DefaultProperiesConfiguration)
     */
    public void reconfigure( Configuration config ) throws ConfigurationException
    {
        LogFactory.releaseAll();
        configure( config);
    }

}
