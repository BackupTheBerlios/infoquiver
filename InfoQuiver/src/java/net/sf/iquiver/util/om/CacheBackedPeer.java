/*
 * Created on 04.03.2004
 *  
 */
package net.sf.iquiver.util.om;

import net.sf.iquiver.configuration.Configurable;
import net.sf.iquiver.configuration.Configuration;
import net.sf.swarmcache.CacheConfiguration;
import net.sf.swarmcache.CacheFactory;

import org.apache.avalon.framework.configuration.ConfigurationException;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.util.BasePeer;

/**
 * @author netseeker aka Michael Manske 
 */
public class CacheBackedPeer extends BasePeer implements Configurable
{
    protected static CacheFactory cacheFactory;
    private static final Log logger = LogFactory.getLog( CacheBackedPeer.class);

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.avalon.framework.configuration.Configurable#configure(org.apache.avalon.framework.configuration.DefaultProperiesConfiguration)
     */
    public final void configure( Configuration configuration ) throws ConfigurationException
    {
        CacheConfiguration cacheConfiguration = new CacheConfiguration();
        String cacheType = (String) ObjectUtils.defaultIfNull( configuration.getString( "type"),
                CacheConfiguration.TYPE_HYBRID);
        String cacheSize = (String) ObjectUtils.defaultIfNull( configuration.getString( "size"), "10000");
        String multicastIP = configuration.getString( "multicast.ip");
        boolean enabledAtStartUp = configuration.getBoolean( "enabledAtStartup");
        boolean enableCacheForCriteriaSelects = configuration.getBoolean( "enableCacheForCriteriaSelects");

        logger.info( "Initializing cache of type " + cacheType + " with a cache size of " + cacheSize);

        if ( enabledAtStartUp )
        {
            logger.info( "Cache will be activated (enabledAtStartup=true");
        }
        else
        {
            logger.info( "Cache will NOT be activated (enabledAtStartup=false or not set");
        }

        if ( enableCacheForCriteriaSelects )
        {
            logger.info( "CacheForCriteriaSelects will be activated");
        }
        else
        {
            logger.info( "CacheForCriteriaSelects will NOT be activated (enableCacheForCriteriaSelects=false or not set");
        }

        cacheConfiguration.setCacheType( cacheType);
        cacheConfiguration.setLRUCacheSize( cacheSize);
        if ( multicastIP != null && multicastIP.length() > 0 )
        {
            logger.info( "Setting multicast IP to " + multicastIP);
            cacheConfiguration.setMulticastIP( multicastIP);
        }

        cacheFactory = new CacheFactory( cacheConfiguration );
        logger.info( "Cache initialization completed");
    }

}
