/*
 * Created on 02.03.2004
 *  
 */
package net.sf.iquiver;

import java.io.IOException;

import net.sf.iquiver.configuration.Configurable;
import net.sf.iquiver.configuration.Configuration;
import net.sf.iquiver.configuration.ConfigurationConstants;
import net.sf.iquiver.configuration.impl.DefaultProperiesConfiguration;
import net.sf.iquiver.configuration.impl.LogConfigurator;
import net.sf.iquiver.configuration.impl.PersistenceConfigurator;
import net.sf.iquiver.configuration.impl.ServiceConfigurator;
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
     * The one and only name
     */
    public static final String NAME = "InfoQuiver";

    /**
     * The one and only version information
     */
    public static final String VERSION = "0.9.0";

    /**
     * temporarily storage for all kinds of application wide variables and objects
     */
    private static DefaultContext context;

    /**
     * holds the currently active configuration
     */
    private static Configuration _configuration;

    /**
     * the configurable default logger
     */
    private static Log logger = LogFactory.getLog( IQuiver.class );

    /**
     * for use when the default logger isn't initialized or not available anymore
     */
    private static final SimpleLog log = new SimpleLog( IQuiver.class.getName() );

    /**
     * indicates if we are ready for configure()
     */
    private boolean _isInitialized;

    /**
     * indicates if we are already successfully configured
     */
    private boolean _isConfigured;

    /**
     * indicates the path of the currently used configuration directory containing all configuration files
     */
    private String _configDir;

    /**
     * a bunch of Configurators which are used to initialize the main application components and/or services
     */
    private LogConfigurator _logConfigurator;
    private PersistenceConfigurator _persistConfigurator;
    private ServiceConfigurator _serviceConfigurator;

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
                sleep( 100 );
            }
            catch ( InterruptedException e )
            {
                throw new RuntimeException( e );
            }

            if (isInterrupted())
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
        if (!isAlive())
        {
            if (_isInitialized && _isConfigured)
            {
                super.start();
            }
            else if (!_isInitialized)
            {
                throw new IllegalStateException( "You must reinitialize IQuiver before restarting the server thread!" );
            }
            else if (!_isConfigured)
            {
                throw new IllegalStateException( "You MUST configure IQuiver before starting the server thread." );
            }
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
        this._logConfigurator = new LogConfigurator();
        this._persistConfigurator = new PersistenceConfigurator();
        this._serviceConfigurator = new ServiceConfigurator();
        this._configDir = ConfigurationConstants.DEFAULT_CONFIG_DIR;
        this._isConfigured = false;
        this._isInitialized = true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.avalon.framework.activity.Disposable#dispose()
     */
    public void dispose()
    {
        logger.info( "Shutting down..." );
        this._logConfigurator = null;
        this._persistConfigurator.dispose();
        this._serviceConfigurator.dispose();
        this._configDir = null;
        this._isConfigured = false;
        this._isInitialized = false;
        context = null;        
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.avalon.framework.configuration.Configurable#configure(org.apache.avalon.framework.configuration.DefaultProperiesConfiguration)
     */
    public void configure( Configuration conf ) throws ConfigurationException
    {
        if (this._isInitialized)
        {
            //check if we should use a custom location to look for our
            // configuration files
            if (conf.containsKey( ConfigurationConstants.OVERWRITE_KEY_CONFIG_DIR ))
            {
                this._configDir = conf.getString( ConfigurationConstants.OVERWRITE_KEY_CONFIG_DIR );
                log.info( "Custom configuration directory \"" + this._configDir + "\" specified." );
            }

            //store the current configuration, some services may need to read additional properties
            _configuration = conf;
           
            configureLogger( conf );
            //LogFactory should be configured now, so instanciate our default logger
            logger = LogFactory.getLog( IQuiver.class );

            configurePersistence( conf );
            configureCache( conf );
            _serviceConfigurator.configure( conf.getSubset("service") );
                        
            this._isConfigured = true;
        }
        else
        {
            throw new ConfigurationException( "IQuiver must be successfully initialized before invoking configure" );
        }
    }

    /**
     * Returns the application wide dynamic context
     * @return
     */
    public static DefaultContext getContext()
    {
        return context;
    }
    
    /**
     * Returns the last used configuration
     * @return
     */
    public static Configuration getConfiguration()
    {
        return _configuration;
    }

    private void configureLogger( Configuration conf ) throws ConfigurationException
    {
        Configuration logConfig = null;
        boolean configured = false;

        //check if we should especially use a custom logger configuration file
        if (conf.containsKey( ConfigurationConstants.OVERWRITE_KEY_CONFIG_LOGGER ))
        {
            try
            {
                logConfig = new DefaultProperiesConfiguration( conf
                        .getString( ConfigurationConstants.OVERWRITE_KEY_CONFIG_LOGGER ) );
                this._logConfigurator.configure( logConfig );
                configured = true;
            }
            catch ( ConfigurationException e )
            {
                log.error( "Configuration of the logging mechanism with custom configuration file \""
                        + conf.getString( ConfigurationConstants.OVERWRITE_KEY_CONFIG_LOGGER )
                        + "\"failed. Will use default location instead", e );
            }
            catch ( IOException e )
            {
                log.error( "Custom configuration file \""
                        + conf.getString( ConfigurationConstants.OVERWRITE_KEY_CONFIG_LOGGER )
                        + "\"does not exist. Will use default location instead", e );
            }
        }

        if (!configured)
        {
            try
            {
                logConfig = new DefaultProperiesConfiguration( this._configDir + "/"
                        + ConfigurationConstants.CONFIG_FILE_LOGGER );
                this._logConfigurator.configure( logConfig );
            }
            catch ( IOException e )
            {
                log.error( "Cache Configuration with default configuration file failed!", e );
                throw new ConfigurationException( e.getMessage() );
            }
        }
    }

    private void configureCache( Configuration conf ) throws ConfigurationException
    {
        Configuration cacheConfig = null;
        boolean configured = false;

        //check if we should especially use a custom cache configuration file
        if (conf.containsKey( ConfigurationConstants.OVERWRITE_KEY_CONFIG_CACHE ))
        {
            try
            {
                cacheConfig = new DefaultProperiesConfiguration( conf
                        .getString( ConfigurationConstants.OVERWRITE_KEY_CONFIG_CACHE ) );
                CacheBackedPeer.configure( cacheConfig.getSubset( "cache" ) );
                configured = true;
            }
            catch ( IOException e )
            {
                log.error( "Custom configuration file \""
                        + conf.getString( ConfigurationConstants.OVERWRITE_KEY_CONFIG_CACHE )
                        + "\"does not exist. Will use default location instead", e );
            }
            catch ( Exception e )
            {
                log.error( "Configuration of the caching mechanism with custom configuration file \""
                        + conf.getString( ConfigurationConstants.OVERWRITE_KEY_CONFIG_CACHE )
                        + "\"failed. Will use default location instead", e );
            }
        }

        if (!configured)
        {
            try
            {
                cacheConfig = new DefaultProperiesConfiguration( this._configDir + "/"
                        + ConfigurationConstants.CONFIG_FILE_CACHE );
                CacheBackedPeer.configure( cacheConfig.subset( "cache" ) );
            }
            catch ( Exception e )
            {
                logger.error( "Cache Configuration with default configuration file failed!", e );
                throw new ConfigurationException( e.getMessage() );
            }
        }
    }

    private void configurePersistence( Configuration conf ) throws ConfigurationException
    {
        Configuration persistConfig = null;

        //check if we should especially use a custom cache configuration file
        if (conf.containsKey( ConfigurationConstants.OVERWRITE_KEY_CONFIG_PERSISTENCE ))
        {
            try
            {
                persistConfig = new DefaultProperiesConfiguration( conf
                        .getString( ConfigurationConstants.OVERWRITE_KEY_CONFIG_PERSISTENCE ) );
            }
            catch ( IOException e )
            {
                log.error( "Custom configuration file \""
                        + conf.getString( ConfigurationConstants.OVERWRITE_KEY_CONFIG_PERSISTENCE )
                        + "\"does not exist. Will use default location instead", e );
            }
        }

        if (persistConfig == null)
        {
            try
            {
                persistConfig = new DefaultProperiesConfiguration( this._configDir + "/"
                        + ConfigurationConstants.CONFIG_FILE_PERSISTENCE );
                this._persistConfigurator.configure( persistConfig );
            }
            catch ( IOException e )
            {
                logger.error( "Persistence Configuration with default configuration file failed!", e );
                throw new ConfigurationException( e.getMessage() );
            }
        }
    }

}