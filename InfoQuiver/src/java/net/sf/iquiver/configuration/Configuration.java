/*
 * Created on 06.03.2004
 *
 */
package net.sf.iquiver.configuration;

/**
 * @author netseeker aka Michael Manske
 */
public interface Configuration extends org.apache.commons.configuration.Configuration
{
    public String getFileName();
    public String getFilePath();
    public Configuration getSubset(String key);
}
