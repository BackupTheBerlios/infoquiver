/*
 * Created on 06.03.2004
 *
 */
package net.sf.iquiver.configuration.impl;

import java.io.IOException;

import net.sf.iquiver.configuration.Configuration;

import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * @author netseeker aka Michael Manske
 */
public class DefaultProperiesConfiguration extends PropertiesConfiguration implements Configuration
{
    public Configuration getSubset( String key )
    {
        DefaultProperiesConfiguration config = null;
        try
        {
            config = new DefaultProperiesConfiguration(super.subset( key));
        }
        catch ( IOException e )
        {            
            e.printStackTrace();
        }
        
        return config;
    }
    
    /**
     *  
     */
    public DefaultProperiesConfiguration()
    {
        super();
    }

    /**
     * @param arg0
     * @throws java.io.IOException
     */
    public DefaultProperiesConfiguration( org.apache.commons.configuration.Configuration arg0 ) throws IOException
    {
        super( arg0 );
    }

    /**
     * @param arg0
     * @throws java.io.IOException
     */
    public DefaultProperiesConfiguration( String arg0 ) throws IOException
    {
        super( arg0 );
        setFileName(arg0);
    }

    /**
     * @param arg0
     * @param arg1
     * @throws java.io.IOException
     */
    public DefaultProperiesConfiguration( String arg0, org.apache.commons.configuration.Configuration arg1 ) throws IOException
    {
        super( arg0, arg1 );
        setFileName(arg0);
    }

    /**
     * @param arg0
     * @param arg1
     * @throws java.io.IOException
     */
    public DefaultProperiesConfiguration( String arg0, String arg1 ) throws IOException
    {
        super( arg0, arg1 );
        setFileName(arg0);
    }
    
    public String getFileName()
    {
        return super.fileName;
    }

}
