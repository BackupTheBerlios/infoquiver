/*
 * Created on 11.07.2004
 */
package net.sf.iquiver.search;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.iquiver.IQuiver;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.netseeker.util.Queue;

/**
 * @author netseeker aka Michael Manske
 */
public class IndexScheduler extends Thread
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( IndexScheduler.class );

    private static Map _schedulers = new HashMap();

    private Queue _queue = new Queue();
    private DocumentIndexer _indexer;

    /**
     * @param index
     */
    private IndexScheduler(String index)
    {
        _indexer = new DocumentIndexer( index );
        _indexer.addIndexChangeEventListener( IQuiver.getServerStats().getIndexListener() );
    }

    /**
     * @param documents
     */
    public synchronized void scheduleForIndexing( List documents )
    {
        _queue.add( documents );
    }

    public void run()
    {
        while ( !isInterrupted() )
        {
            List docs = (List) _queue.next();
            
            try
            {
                _indexer.indexDocuments( docs );
            }
            catch ( IOException e ) 
            {
                logger.error("Indexing fetched contents failed! IOException while accessing the search index.", e);
            }
            
            /*
            try
            {
                Thread.sleep( 1000 );
            }
            catch ( InterruptedException e )
            {
                logger.error( e );
            } 
            */           
        }
    }

    /**
     * @param index
     * @return
     */
    public static synchronized IndexScheduler getInstance( String index )
    {
        IndexScheduler scheduler = (IndexScheduler) _schedulers.get( index );

        if (scheduler == null)
        {
            scheduler = new IndexScheduler( index );
            _schedulers.put( index, scheduler );
            scheduler.start();
        }

        return scheduler;
    }
}