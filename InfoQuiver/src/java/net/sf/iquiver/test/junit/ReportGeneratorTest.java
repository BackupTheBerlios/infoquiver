/*********************************************************************
 * ReportGeneratorTest.java
 * created on 19.07.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/test/junit/ReportGeneratorTest.java,v $
 * $Date: 2004/11/26 23:42:41 $
 * $Revision: 1.3 $
 *********************************************************************/

package net.sf.iquiver.test.junit;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import net.sf.iquiver.IQuiver;
import net.sf.iquiver.om.Client;
import net.sf.iquiver.om.ClientPeer;
import net.sf.iquiver.om.ContentSource;
import net.sf.iquiver.om.SearchQuery;
import net.sf.iquiver.om.User;
import net.sf.iquiver.om.UserGroup;
import net.sf.iquiver.om.UserGroupPeer;
import net.sf.iquiver.om.UserPeer;
import net.sf.iquiver.report.IReportSource;
import net.sf.iquiver.report.ReportGeneratorFactory;
import net.sf.iquiver.report.impl.ReportDispatcher;
import net.sf.iquiver.search.QueryTask;

import org.apache.lucene.queryParser.ParseException;
import org.apache.torque.TorqueException;

import de.netseeker.util.ArrayMap;
import de.netseeker.util.ListMap;

/**
 * @author netseeker aka Michael Manske
 */
public class ReportGeneratorTest extends BaseIQuiverTestCase
{
    public void testGenerate()
    {
        try
        {
            List clients = ClientPeer.doSelectAll();

            for (Iterator it = clients.iterator(); it.hasNext();)
            {
                Client client = (Client) it.next();
                createSearchReports( client );
            }
            List groups = UserGroupPeer.doSelectAll();

            for (Iterator gIt = groups.iterator(); gIt.hasNext();)
            {
                UserGroup group = (UserGroup) gIt.next();
                createSearchReports( group );
            }
            List users = UserPeer.doSelectAll();

            for (Iterator uIt = users.iterator(); uIt.hasNext();)
            {
                User user = (User) uIt.next();
                if (!user.getSearchQuerys().isEmpty())
                {
                    createSearchReports( user );
                    ReportDispatcher dispatcher = new ReportDispatcher( user );
                    dispatcher.run();
                }
            }
        }
        catch ( TorqueException e )
        {
            e.printStackTrace();
        }
    }

    /**
     * @param obj
     * @throws TorqueException
     */
    private void createSearchReports( IReportSource obj ) throws TorqueException
    {
        List queries = obj.getSearchQuerys();
        List contentSources = obj.getContentSources();
        List documents = null;
        ListMap queryResults = new ArrayMap();
        String[] tmp, indeces;

        // determine all indeces to use for searching, one index per content source
        tmp = new String[contentSources.size()];
        int count = 0;
        for (int i = 0; i < contentSources.size(); i++)
        {
            ContentSource source = (ContentSource) contentSources.get( i );
            String index = IQuiver.getConfiguration().getString( "lucene.index.path" ) + File.separator
                    + source.getContentSourceId();
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
            catch ( IOException e )
            {
                e.printStackTrace();
            }
            catch ( ParseException e )
            {
                e.printStackTrace();
            }
        }

        ReportGeneratorFactory.getReportGenerator().generate( obj, queryResults );
    }
}