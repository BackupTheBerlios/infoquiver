/*********************************************************************
 * ReportGeneratorTest.java
 * created on 19.07.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/test/junit/ReportDispatcherTest.java,v $
 * $Date: 2004/11/26 22:51:29 $
 * $Revision: 1.1 $
 *********************************************************************/

package net.sf.iquiver.test.junit;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import net.sf.iquiver.IQuiver;
import net.sf.iquiver.om.Client;
import net.sf.iquiver.om.ClientPeer;
import net.sf.iquiver.om.ContentSource;
import net.sf.iquiver.om.SearchQuery;
import net.sf.iquiver.report.ReportGeneratorFactory;
import net.sf.iquiver.search.QueryTask;

import org.apache.torque.TorqueException;

import de.netseeker.util.ArrayMap;
import de.netseeker.util.ListMap;

/**
 * @author netseeker aka Michael Manske
 */
public class ReportDispatcherTest extends BaseIQuiverTestCase
{
    public void testGenerate()
    {
        try
        {
            String _indexDirectory = IQuiver.getConfiguration().getString( "lucene.index.path" );
            Client client = ClientPeer.retrieveByPK( 101 );
            List queries = client.getSearchQuerys();
            List contentSources = client.getContentSources();
            List documents = null;
            ListMap queryResults = new ArrayMap();
            String[] tmp, indeces;

            // determine all indeces to use for searching, one index per content source
            tmp = new String[contentSources.size()];
            int count = 0;
            for (int i = 0; i < contentSources.size(); i++)
            {
                ContentSource source = (ContentSource) contentSources.get( i );
                String index = _indexDirectory + File.separator + String.valueOf( source.getContentSourceId() );
                File testFile = new File( index );
                if (testFile.exists())
                {
                    tmp[i] = index;
                    count++;
                }
            }

            indeces = new String[count];
            System.arraycopy( tmp, 0, indeces, 0, count );

            for (Iterator it = queries.iterator(); it.hasNext();)
            {
                SearchQuery query = (SearchQuery) it.next();
                try
                {
                    documents = QueryTask.search( indeces, query.getSearchQueryCriteria() );
                    queryResults.put( query, documents );
                }
                catch ( Exception e )
                {
                    e.printStackTrace();
                }
            }

            ReportGeneratorFactory.getReportGenerator().generate( client, queryResults );
        }
        catch ( TorqueException e )
        {
            e.printStackTrace();
        }
    }

}