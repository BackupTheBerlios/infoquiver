/*
 * Created on 04.03.2004
 *  
 */
package net.sf.iquiver.util.om;

import net.sf.swarmcache.CacheConfiguration;
import net.sf.swarmcache.CacheFactory;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.util.BasePeer;

/**
 * CacheBackedPeer is the base class of all torque peers used in iquiver. Basically CacheBackedPeer guarantees to
 * configure SwarmCache for each generated torque object type. All subclasses use the net.sf.swarmcache.CacheFactory
 * provided by this class.
 * 
 * @author netseeker aka Michael Manske
 */
public class CacheBackedPeer extends BasePeer
{
    private static CacheFactory cacheFactory;
    private static final Log logger = LogFactory.getLog( CacheBackedPeer.class );
    private static boolean enabledAtStartup = false;
    private static boolean enableCacheForCriteriaSelects = false;
    private static String[] excludeEnableAtStartUp;
    private static String[] excludeEnableCacheForCriteriaSelects;

    /**
     * Initializes and configures the cache
     * 
     * @param configuration the subset ("cache") of the cache configuration file
     */
    public static final synchronized void configure( Configuration configuration )
    {
        enabledAtStartup = configuration.getBoolean( "enabledAtStartup" );
        enableCacheForCriteriaSelects = configuration.getBoolean( "enableCacheForCriteriaSelects" );
        excludeEnableAtStartUp = configuration.getStringArray( "excludeEnableAtStartUp" );
        excludeEnableCacheForCriteriaSelects = configuration.getStringArray( "excludeEnableCacheForCriteriaSelects" );

        if (enabledAtStartup)
        {
            logger.info( "Cache will be activated (enabledAtStartup=true" );

            CacheConfiguration cacheConfiguration = new CacheConfiguration();
            String cacheType = (String) ObjectUtils.defaultIfNull( configuration.getString( "type" ),
                    CacheConfiguration.TYPE_HYBRID );
            String cacheSize = (String) ObjectUtils.defaultIfNull( configuration.getString( "size" ), "10000" );
            String channelProps = configuration.getString( "multicast.properties" );
            String multicastIP = configuration.getString( "multicast.ip" );

            logger.info( "Initializing cache of type " + cacheType + " with a cache size of " + cacheSize );

            cacheConfiguration.setCacheType( cacheType );
            cacheConfiguration.setLRUCacheSize( cacheSize );
            if (channelProps != null && channelProps.length() > 0)
            {
                logger.info( "Setting channel properties:\t" + channelProps );
                cacheConfiguration.setChannelProperties( channelProps );
            }
            else if (multicastIP != null && multicastIP.length() > 0)
            {
                logger.info( "Setting multicast IP to " + multicastIP );
                cacheConfiguration.setMulticastIP( multicastIP );
            }

            cacheFactory = new CacheFactory( cacheConfiguration );

            if (enableCacheForCriteriaSelects)
            {
                logger.info( "CacheForCriteriaSelects will be activated" );
            }
            else
            {
                logger
                        .info( "CacheForCriteriaSelects will NOT be activated (enableCacheForCriteriaSelects=false or not set" );
            }
            logger.info( "Cache initialization completed" );
        }
        else
        {
            logger.info( "Cache will NOT be activated (enabledAtStartup=false or not set" );
        }
    }

    /**
     * @return Returns the cacheFactory.
     */
    public static CacheFactory getCacheFactory()
    {
        return cacheFactory;
    }

    /**
     * @return Returns the enableCacheForCriteriaSelects.
     */
    public static boolean isEnableCacheForCriteriaSelects()
    {
        return enableCacheForCriteriaSelects;
    }

    /**
     * @return Returns the enabledAtStartup.
     */
    public static boolean isEnabledAtStartup()
    {
        return enabledAtStartup;
    }

    /**
     * @return Returns the excludeEnableAtStartUp.
     */
    public static String[] getExcludeEnableAtStartUp()
    {
        return excludeEnableAtStartUp;
    }

    /**
     * @return Returns the excludeEnableCacheForCriteriaSelects.
     */
    public static String[] getExcludeEnableCacheForCriteriaSelects()
    {
        return excludeEnableCacheForCriteriaSelects;
    }
}