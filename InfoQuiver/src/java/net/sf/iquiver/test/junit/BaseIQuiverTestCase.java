/*
 * Created on 16.03.2004
 *
 */
package net.sf.iquiver.test.junit;

import java.io.IOException;

import org.apache.avalon.framework.configuration.ConfigurationException;

import junit.framework.TestCase;
import net.sf.iquiver.IQuiver;
import net.sf.iquiver.configuration.Configuration;
import net.sf.iquiver.configuration.ConfigurationConstants;
import net.sf.iquiver.configuration.impl.DefaultProperiesConfiguration;

/**
 * @author netseeker aka Michael Manske
 */
public class BaseIQuiverTestCase extends TestCase
{

    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception
    {
        super.setUp();
        try
        {
            IQuiver iquiver = new IQuiver();
            Configuration configuration = new DefaultProperiesConfiguration( "src/conf/" + ConfigurationConstants.CONFIG_FILE_MAIN );
            configuration.addProperty(ConfigurationConstants.OVERWRITE_KEY_CONFIG_DIR, "src/conf");
            iquiver.configure(configuration);
        }
        catch ( IOException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch ( ConfigurationException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
    }
    /**
     * 
     */
    public BaseIQuiverTestCase()
    {
        super();        
    }

    /**
     * @param arg0
     */
    public BaseIQuiverTestCase( String arg0 )
    {
        super( arg0 );
        // TODO Auto-generated constructor stub
    }

}
