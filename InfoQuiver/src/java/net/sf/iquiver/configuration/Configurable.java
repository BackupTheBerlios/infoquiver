/*
 * Created on 05.03.2004
 *
 */
package net.sf.iquiver.configuration;

import org.apache.avalon.framework.configuration.ConfigurationException;

/**
 * @author netseeker aka Michael Manske
 */
public interface Configurable
{
    public void configure(Configuration config) throws ConfigurationException;    
}
