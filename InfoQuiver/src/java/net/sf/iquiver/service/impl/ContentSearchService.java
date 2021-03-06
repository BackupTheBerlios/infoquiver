/*********************************************************************
 * ContentSearchService.java
 * created on 15.07.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/service/impl/ContentSearchService.java,v $
 * $Date: 2004/11/26 23:42:19 $
 * $Revision: 1.15 $
 *********************************************************************/

package net.sf.iquiver.service.impl;

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
import net.sf.iquiver.service.BaseService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.queryParser.ParseException;
import org.apache.torque.TorqueException;

import de.netseeker.util.ArrayMap;
import de.netseeker.util.ListMap;

/**
 * This is one of InfoQuivers core services. It starts searches for all clients, usergroups and users
 * according to their search parameters. This service invokes report generation for all search results. 
 * @author netseeker aka Michael Manske
 */
public class ContentSearchService extends BaseService
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( ContentSearchService.class );

    private static String _indexDirectory = IQuiver.getConfiguration().getString( "lucene.index.path" );

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.BaseService#doStart()
     */
    protected void doStart()
    {
        try
        {
            List reportsources = ClientPeer.doSelectAll();
            for (Iterator it = reportsources.iterator(); it.hasNext();)
            {
                Client client = (Client) it.next();
                createSearchReports( client );
            }
            
            reportsources = UserGroupPeer.doSelectAll();
            for (Iterator gIt = reportsources.iterator(); gIt.hasNext();)
            {
                UserGroup group = (UserGroup) gIt.next();
                createSearchReports( group );
            }
            
            reportsources = UserPeer.doSelectAll();
            for (Iterator uIt = reportsources.iterator(); uIt.hasNext();)
            {
                User user = (User) uIt.next();
                if (!user.getSearchQuerys().isEmpty())
                {
                    createSearchReports( user );
                    ReportDispatcher dispatcher = new ReportDispatcher( user );
                    dispatcher.start();
                }
            }
        }
        catch ( TorqueException e )
        {
            logger.error( e );
        }

    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.BaseService#doStop()
     */
    protected void doStop()
    {
        // TODO Auto-generated method stub

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
            String index = _indexDirectory + File.separator + source.getContentSourceId();
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
                logger.error( e );
            }
            catch ( ParseException e )
            {
                logger.error( e );
            }
        }

        ReportGeneratorFactory.getReportGenerator().generate( obj, queryResults );
    }
}