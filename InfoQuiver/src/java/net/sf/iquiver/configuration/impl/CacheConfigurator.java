/*
 * Created on 05.03.2004
 *
 */
package net.sf.iquiver.configuration.impl;

import java.util.StringTokenizer;

import net.sf.iquiver.configuration.Configuration;
import net.sf.iquiver.configuration.Reconfigurable;
import net.sf.iquiver.om.cache.CacheBackedPeerInitializer;
import net.sf.iquiver.util.om.CacheBackedPeer;

import org.apache.avalon.framework.configuration.ConfigurationException;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author netseeker aka Michael Manske
 */
public class CacheConfigurator implements Reconfigurable
{
    final private static Log logger = LogFactory.getLog(CacheConfigurator.class);
    final private CacheBackedPeer cacheBackedPeer = new CacheBackedPeer();

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.configuration.Configurable#configure(org.apache.avalon.framework.configuration.DefaultProperiesConfiguration)
     */
    public void configure( Configuration config ) throws ConfigurationException
    {
        logger.info("Caching is getting initialized...");
        
        boolean enabledAtStartup = config.getBoolean("enabledAtStartup");
        
        if(enabledAtStartup)
        {    
            final boolean enableCriteriaCache = config.getBoolean("enableCacheForCriteriaSelects");            
            final String[] excludeEnableAtStartUp = config.getStringArray("excludeEnableAtStartUp");
            final String[] excludeEnableCacheForCriteriaSelects = config.getStringArray("excludeEnableCacheForCriteriaSelects");;
            
            cacheBackedPeer.configure(config);            
            new Thread() 
            {
                public void run()
                {            
                    CacheBackedPeerInitializer.intialize(enableCriteriaCache, excludeEnableAtStartUp, excludeEnableCacheForCriteriaSelects);
                    logger.info("Cache initialization complete...");
                }
            }.start();
        }        
    }

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.configuration.Reconfigurable#reconfigure(org.apache.avalon.framework.configuration.DefaultProperiesConfiguration)
     */
    public void reconfigure( Configuration config ) throws ConfigurationException
    {
        configure(config);
    }

}
