/*
 * Created on 05.03.2004
 *  
 */
package net.sf.iquiver.configuration.impl;

import java.util.Iterator;
import java.util.Properties;

import net.sf.iquiver.configuration.Configuration;
import net.sf.iquiver.configuration.Reconfigurable;

import org.apache.avalon.framework.configuration.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author netseeker aka Michael Manske
 */
public class LogConfigurator implements Reconfigurable
{
    private static final Log logger = LogFactory.getLog( LogConfigurator.class );

    /**
     * The logger prefix.
     */
    public static final String loggerPrefix = "log4j";

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.avalon.framework.configuration.Configurable#configure(org.apache.avalon.framework.configuration.DefaultProperiesConfiguration)
     */
    public void configure( Configuration config ) throws ConfigurationException
    {
        //LogFactory.releaseAll();

        Properties props = new Properties();

        for (Iterator it = config.getKeys(); it.hasNext();)
        {
            String key = (String) it.next();

            // We only want log4j properties.
            if (key.startsWith( loggerPrefix ) == false)
            {
                continue;
            }
            // We have to deal with Configuration way
            // of dealing with "," in properties which is to
            // make them separate values. Log4j logger
            // properties contain commas so we must stick them
            // back together for log4j.
            String[] values = config.getStringArray( key );

            String value;
            if (values.length == 1)
            {
                value = values[0];
            }
            else
            {
                value = "";
                for (int i = 0; i < values.length; i++)
                {
                    value += values[i];
                    if (i < values.length - 1)
                    {
                        value += ",";
                    }
                }
            }

            props.put( key, value );
        }

        try
        {
            PropertyConfigurator.configure( props );
        }
        catch ( Exception e )
        {
            logger.error( e );
            BasicConfigurator.configure();
        }

        logger.info( "Logging configured with settings from " + config.getFilePath() );
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.avalon.framework.configuration.Reconfigurable#reconfigure(org.apache.avalon.framework.configuration.DefaultProperiesConfiguration)
     */
    public void reconfigure( Configuration config ) throws ConfigurationException
    {
        configure( config );
    }

}