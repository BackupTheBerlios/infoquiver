/*
 * Created on 06.03.2004
 *
 */
package net.sf.iquiver.configuration;

/**
 * @author netseeker aka Michael Manske
 */
public abstract class ConfigurationConstants
{
    public final static String DEFAULT_CONFIG_DIR = "conf";
    public final static String CONFIG_FILE_MAIN = "iquiver.properties";
    public final static String CONFIG_FILE_LOGGER = "log.properties";
    public final static String CONFIG_FILE_CACHE = "cache.properties";
    public final static String CONFIG_FILE_PERSISTENCE = "torque.properties";
    
    public final static String OVERWRITE_KEY_CONFIG_DIR = "CUSTOM_CONFIG_DIR";
    public final static String OVERWRITE_KEY_CONFIG_LOGGER = "CUSTOM_CONFIG_FILE_LOGGER";
    public final static String OVERWRITE_KEY_CONFIG_CACHE = "CUSTOM_CONFIG_FILE_CACHE";
    public final static String OVERWRITE_KEY_CONFIG_PERSISTENCE = "CUSTOM_CONFIG_FILE_PERSISTENCE";
}
