/*
 * Created on 20.03.2004
 *
 */
package net.sf.iquiver.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.om.Content;
import net.sf.iquiver.om.ContentSource;
import net.sf.iquiver.om.ContentSourcePeer;
import net.sf.iquiver.om.Transport;
import net.sf.iquiver.service.BaseService;
import net.sf.iquiver.transport.Fetcher;
import net.sf.iquiver.transport.TransportConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.TorqueException;

/**
 * @author netseeker aka Michael Manske
 */
public class ContentFetchService extends BaseService
{
    /**
     * default fetch interval between contacting content sources
     */
    public static final long DEFAULT_FETCH_UPDATE_INTERVAL = 3600000;

    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( ContentFetchService.class );

    private List _timers;

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.BaseService#doStart()
     */
    protected void doStart()
    {
        logger.info( "Starting..." );
        this._timers = new ArrayList();

        List transports = _getTransports();
        for (Iterator it = transports.iterator(); it.hasNext();)
        {
            Fetcher fetcher = (Fetcher) it.next();
            long interval = fetcher.getFetchLocation().getContentSourceUpdateTimespan();
            if (interval <= 0)
            {
                interval = DEFAULT_FETCH_UPDATE_INTERVAL;
            }

            ContentFetchThread thread = new ContentFetchThread( fetcher );
            Timer timer = new Timer();
            timer.scheduleAtFixedRate( thread, 1000, interval );
            _timers.add(timer);
        }                
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.BaseService#doStop()
     */
    protected void doStop()
    {        
        //shut down all timers
        for(Iterator it = _timers.iterator(); it.hasNext();)
        {
            ((Timer)it.next()).cancel();
        }
        _timers = null;                        
    }

    /**
     * @return
     */
    private List _getTransports()
    {
        List transports = new ArrayList();

        try
        {
            List sources = ContentSourcePeer.doSelectAll();
            for (Iterator it = sources.iterator(); it.hasNext();)
            {
                ContentSource source = (ContentSource) it.next();
                Transport transport = source.getTransport();
                if (transport != null)
                {
                    String className = transport.getTransportImplementation();

                    try
                    {
                        Fetcher impl = (Fetcher) Class.forName( className ).newInstance();
                        impl.setFetchLocation( source );
                    }
                    catch ( ClassNotFoundException e1 )
                    {
                        logger.error( "The implementation class " + className + " could not be found.", e1 );
                    }
                    catch ( TransportConfigurationException e )
                    {
                        logger.error( "Configuration of transport id=" + transport.getTransportId() + " failed.", e );
                    }
                    catch ( Exception e )
                    {
                        logger.error( "Unknown error occurred while loading transport implementation for transport id="
                                + transport.getTransportId(), e );
                    }
                }
                else
                {
                    logger.warn( "No transport found for ContentSource id=" + source.getContentSourceId() );
                }
            }
        }
        catch ( TorqueException e )
        {
            logger.error( "Error while fetching content sources from database.", e );
        }

        return transports;
    }

    /**
     * @author netseeker aka Michael Manske
     */
    private class ContentFetchThread extends TimerTask
    {
        /**
         * The transport used to fetch content from a content source
         */
        private Fetcher fetcher;

        private boolean isRunning = false;

        /**
         * Creates a new instance of ContentFetchThread
         * 
         * @param fetcher transport used to fetch content from a content source
         */
        public ContentFetchThread(Fetcher fetcher)
        {
            this.fetcher = fetcher;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Runnable#run()
         */
        public void run()
        {
            if (!isRunning)
            {
                isRunning = true;
                long contentSourceId = fetcher.getFetchLocation().getContentSourceId();
                List documents = fetcher.fetch();

                for (Iterator it = documents.iterator(); it.hasNext();)
                {
                    Document doc = (Document) it.next();
                    Content content = new Content( doc );
                    try
                    {
                        content.setContentSourceId( contentSourceId );
                        content.save();
                    }
                    catch ( Exception e )
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}