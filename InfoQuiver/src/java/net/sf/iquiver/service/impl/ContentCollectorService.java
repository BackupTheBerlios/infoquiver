/*
 * Created on 08.07.2004
 */
package net.sf.iquiver.service.impl;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import net.sf.iquiver.IQuiver;
import net.sf.iquiver.om.Content;
import net.sf.iquiver.om.ContentPeer;
import net.sf.iquiver.om.ContentSource;
import net.sf.iquiver.om.ContentSourcePeer;
import net.sf.iquiver.search.IndexScheduler;
import net.sf.iquiver.service.BaseService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

/**
 * This is a very simple "garbage collector" which simply does
 * delete all contents from the iq_content table which are marked as content_to_delete=true
 * @author netseeker aka Michael Manske
 */
public class ContentCollectorService extends BaseService
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( ContentCollectorService.class );

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.BaseService#doStart()
     */
    protected void doStart()
    {
        String indexDirectory = IQuiver.getConfiguration().getString( "lucene.index.path" );

        Criteria crit = new Criteria();

        try
        {
            List sources = ContentSourcePeer.doSelectAll();

            for (Iterator iter = sources.iterator(); iter.hasNext();)
            {
                ContentSource source = (ContentSource) iter.next();
                crit.clear();
                crit.add( ContentPeer.CONTENT_TO_DELETE, true );
                crit.add( ContentPeer.CONTENT_SOURCE_ID, source.getContentSourceId() );
                List docs = ContentPeer.doSelect( crit );

                if (docs != null)
                {
                    for( Iterator it = docs.iterator(); it.hasNext(); )
                    {
                        Content content = (Content)it.next();
                        content.setRemoved( true );                        
                    }
                    
                    IndexScheduler scheduler = IndexScheduler.getInstance( indexDirectory + File.separator
                            + String.valueOf( source.getContentSourceId() ) );
                    scheduler.scheduleForIndexing( docs );
                }
                
                ContentPeer.doDelete( crit );
            }
        }
        catch ( TorqueException e )
        {
            logger.error( "Error occured while deleting all marked contents from database!", e );
        }
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.BaseService#doStop()
     */
    protected void doStop()
    {
        //not implemented
    }

}