/*
 * Created on 02.03.2004
 *  
 */
package net.sf.iquiver;

import java.io.IOException;

import net.sf.iquiver.configuration.Configurable;
import net.sf.iquiver.configuration.Configuration;
import net.sf.iquiver.configuration.ConfigurationConstants;
import net.sf.iquiver.configuration.Reconfigurable;
import net.sf.iquiver.configuration.impl.DefaultProperiesConfiguration;
import net.sf.iquiver.configuration.impl.LogConfigurator;
import net.sf.iquiver.configuration.impl.PersistenceConfigurator;
import net.sf.iquiver.util.om.CacheBackedPeer;

import org.apache.avalon.framework.activity.Disposable;
import org.apache.avalon.framework.activity.Startable;
import org.apache.avalon.framework.configuration.ConfigurationException;
import org.apache.avalon.framework.context.DefaultContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.SimpleLog;

/**
 * @author netseeker aka Michael Manske
 */
public class IQuiver extends Thread implements Disposable, Configurable, Startable
{
    /**
     * The one and only version information
     */
    public static final String VERSION = "0.0.1";

    /**
     * temporarily storage for all kinds of application wide variables and
     * objects
     */
    private static DefaultContext context;

    /**
     * holds the currently active configuration
     */
    private Configuration configuration;

    /**
     * the configurable default logger
     */
    private static Log logger;

    /**
     * for use when the default logger isn't initialized or not available
     * anymore
     */
    private static final SimpleLog log = new SimpleLog( "net.sf.iquiver" );

    /**
     * indicates if we are ready for configure()
     */
    private boolean isInitialized;

    /**
     * indicates if we are already successfully configured
     */
    private boolean isConfigured;

    /**
     * indicates the path of the currently used configuration directory
     * containing all configuration files
     */
    private String configDir;

    /**
     * a bunch of Configurators which are used to initialize the main
     * application components and/or services
     */
    private Reconfigurable logConfigurator;
    private Reconfigurable persistConfigurator;

    /**
     *  
     */
    public IQuiver()
    {
        //setDaemon( true);
        initialize();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    public void run()
    {
        //Server loop
        while ( true )
        {
            try
            {
                sleep( 100);
            }
            catch ( InterruptedException e )
            {
                throw new RuntimeException( e );
            }

            if ( isInterrupted() )
            {
                break;
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Thread#start()
     */
    public void start()
    {
        if ( !isAlive() )
        {
            if ( isInitialized && isConfigured )
            {
                super.start();
            }
            else if ( !isInitialized )
            {
                throw new IllegalStateException( "You must reinitialize IQuiver before restarting the server thread!" );
            }
            else if ( !isConfigured ) { throw new IllegalStateException( 
                    "You MUST configure IQuiver before starting the server thread." ); }
        }
        else
        {
            throw new IllegalStateException( "IQuiver already running" );
        }
        
        IQuiver iq = this;
    }

    private void initialize()
    {
        context = new DefaultContext();
        this.logConfigurator = new LogConfigurator();
        this.persistConfigurator = new PersistenceConfigurator();
        this.configDir = ConfigurationConstants.DEFAULT_CONFIG_DIR;
        this.isConfigured = false;
        this.isInitialized = true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.avalon.framework.activity.Disposable#dispose()
     */
    public void dispose()
    {
        logger.info( "Shutting down...");
        this.logConfigurator = null;
        this.persistConfigurator = null;
        this.configDir = null;
        context = null;
        this.isConfigured = false;
        this.isInitialized = false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.avalon.framework.configuration.Configurable#configure(org.apache.avalon.framework.configuration.DefaultProperiesConfiguration)
     */
    public void configure( Configuration conf ) throws ConfigurationException
    {
        if ( this.isInitialized )
        {
            //check if we should use a custom location to look for our
            // configuration files
            if ( conf.containsKey( ConfigurationConstants.OVERWRITE_KEY_CONFIG_DIR) )
            {
                this.configDir = conf.getString( ConfigurationConstants.OVERWRITE_KEY_CONFIG_DIR);
                log.info( "Custom configuration directory \"" + this.configDir + "\" specified.");
            }

            configureLogger( conf);

            //LogFactory should be configured now, so instanciate our default logger
            logger = LogFactory.getLog( IQuiver.class);

            configurePersistence( conf);
            configureCache( conf);            

            context.put( "net.sf.iquiver.IQuiver:CONFIGURATION", conf );
            this.isConfigured = true;
        }
        else
        {
            throw new ConfigurationException( "IQuiver must be successfully initialized before invoking configure" );
        }
    }
    
    /**
     * @return
     */
    public static DefaultContext getContext()
    {
        return context;
    }

    private void configureLogger( Configuration conf ) throws ConfigurationException
    {
        Configuration logConfig = null;
        boolean configured = false;

        //check if we should especially use a custom logger configuration file
        if ( conf.containsKey( ConfigurationConstants.OVERWRITE_KEY_CONFIG_LOGGER) )
        {
            try
            {
                logConfig = new DefaultProperiesConfiguration( conf
                        .getString( ConfigurationConstants.OVERWRITE_KEY_CONFIG_LOGGER) );
                this.logConfigurator.configure( logConfig);
                configured = true;
            }
            catch ( ConfigurationException e )
            {
                log.error( "Configuration of the logging mechanism with custom configuration file \""
                        + conf.getString( ConfigurationConstants.OVERWRITE_KEY_CONFIG_LOGGER)
                        + "\"failed. Will use default location instead", e);
            }
            catch ( IOException e )
            {
                log.error( "Custom configuration file \""
                        + conf.getString( ConfigurationConstants.OVERWRITE_KEY_CONFIG_LOGGER)
                        + "\"does not exist. Will use default location instead", e);
            }
        }

        if ( !configured )
        {
            try
            {
                logConfig = new DefaultProperiesConfiguration( this.configDir + "/"
                        + ConfigurationConstants.CONFIG_FILE_LOGGER );
                this.logConfigurator.configure( logConfig);
            }
            catch ( IOException e )
            {
                log.error( "Cache Configuration with default configuration file failed!", e);
                throw new ConfigurationException( e.getMessage() );
            }
        }
    }

    private void configureCache( Configuration conf ) throws ConfigurationException
    {
        Configuration cacheConfig = null;
        boolean configured = false;

        //check if we should especially use a custom cache configuration file
        if ( conf.containsKey( ConfigurationConstants.OVERWRITE_KEY_CONFIG_CACHE) )
        {
            try
            {
                cacheConfig = new DefaultProperiesConfiguration( conf
                        .getString( ConfigurationConstants.OVERWRITE_KEY_CONFIG_CACHE) );
                CacheBackedPeer.configure( cacheConfig.getSubset( "cache" ) );
                configured = true;
            }
            catch ( IOException e )
            {
                log.error( "Custom configuration file \""
                        + conf.getString( ConfigurationConstants.OVERWRITE_KEY_CONFIG_CACHE)
                        + "\"does not exist. Will use default location instead", e);
            }
            catch ( Exception e )
            {
                log.error( "Configuration of the caching mechanism with custom configuration file \""
                        + conf.getString( ConfigurationConstants.OVERWRITE_KEY_CONFIG_CACHE)
                        + "\"failed. Will use default location instead", e);
            }
        }

        if ( !configured )
        {
            try
            {
                cacheConfig = new DefaultProperiesConfiguration( this.configDir + "/"
                        + ConfigurationConstants.CONFIG_FILE_CACHE );
                CacheBackedPeer.configure(cacheConfig.subset("cache") );
            }
            catch ( Exception e )
            {
                logger.error( "Cache Configuration with default configuration file failed!", e);
                throw new ConfigurationException( e.getMessage() );
            }
        }
    }

    private void configurePersistence( Configuration conf ) throws ConfigurationException
    {
        Configuration persistConfig = null;

        //check if we should especially use a custom cache configuration file
        if ( conf.containsKey( ConfigurationConstants.OVERWRITE_KEY_CONFIG_PERSISTENCE) )
        {
            try
            {
                persistConfig = new DefaultProperiesConfiguration( conf
                        .getString( ConfigurationConstants.OVERWRITE_KEY_CONFIG_PERSISTENCE) );
            }
            catch ( IOException e )
            {
                log.error( "Custom configuration file \""
                        + conf.getString( ConfigurationConstants.OVERWRITE_KEY_CONFIG_PERSISTENCE)
                        + "\"does not exist. Will use default location instead", e);
            }
        }

        if ( persistConfig == null )
        {
            try
            {
                persistConfig = new DefaultProperiesConfiguration( this.configDir + "/"
                        + ConfigurationConstants.CONFIG_FILE_PERSISTENCE );
                this.persistConfigurator.configure( persistConfig);
            }
            catch ( IOException e )
            {
                logger.error( "Persistence Configuration with default configuration file failed!", e);
                throw new ConfigurationException( e.getMessage() );
            }
        }
    }

}
