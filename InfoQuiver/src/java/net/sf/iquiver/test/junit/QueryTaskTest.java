/*
 * Created on 12.07.2004
 */
package net.sf.iquiver.test.junit;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.queryParser.ParseException;

import net.sf.iquiver.IQuiver;
import net.sf.iquiver.search.QueryTask;

/**
 * @author netseeker aka Michael Manske
 */
public class QueryTaskTest extends BaseIQuiverTestCase
{
    public void testSearch()
    {
        String indexDirectory = IQuiver.getConfiguration().getString( "lucene.index.path" );
        try
        {
            List docs = QueryTask.search( indexDirectory, "torque AND cache" );
            assertNotNull( docs );
            assertFalse( docs.isEmpty() );
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        catch ( ParseException e )
        {
            e.printStackTrace();
        }
    }

}