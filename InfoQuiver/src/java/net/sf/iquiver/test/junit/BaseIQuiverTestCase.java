/*
 * Created on 16.03.2004
 *
 */
package net.sf.iquiver.test.junit;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;
import net.sf.iquiver.IQuiver;
import net.sf.iquiver.configuration.Configuration;
import net.sf.iquiver.configuration.ConfigurationConstants;
import net.sf.iquiver.configuration.impl.DefaultProperiesConfiguration;

import org.apache.avalon.framework.configuration.ConfigurationException;

/**
 * @author netseeker aka Michael Manske
 */
public class BaseIQuiverTestCase extends TestCase
{

    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception
    {
        super.setUp();
        try
        {
            IQuiver iquiver = new IQuiver();
            Configuration configuration = new DefaultProperiesConfiguration( "src/conf/"
                    + ConfigurationConstants.CONFIG_FILE_MAIN );
            configuration.addProperty( ConfigurationConstants.OVERWRITE_KEY_CONFIG_DIR, "src/conf" );

            List toRemove = new ArrayList();
            for (Iterator it = configuration.getKeys( "service.ContentFetchService" ); it.hasNext();)
            {
                toRemove.add( it.next() );
            }

            for (Iterator it = toRemove.iterator(); it.hasNext();)
            {
                configuration.clearProperty( (String) it.next() );
            }

            iquiver.configure( configuration );
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
    public BaseIQuiverTestCase(String arg0)
    {
        super( arg0 );
        // TODO Auto-generated constructor stub
    }

    public URLConnection openConnection( URL url ) throws IOException
    {
        URLConnection connection = url.openConnection();
        connection.setRequestProperty( "User-Agent", IQuiver.NAME + " " + IQuiver.VERSION + " (http://developer.berlios.de/projects/infoquiver/)" );
        return connection;
    }

}