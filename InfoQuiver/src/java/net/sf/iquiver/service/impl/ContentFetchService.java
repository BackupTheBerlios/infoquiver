/*********************************************************************
 * ContentFetchService.java
 * created on 20.03.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/service/impl/ContentFetchService.java,v $
 * $Date: 2004/07/18 17:27:08 $
 * $Revision: 1.25 $
 *********************************************************************/

package net.sf.iquiver.service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import net.sf.iquiver.IQuiver;
import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.om.Content;
import net.sf.iquiver.om.ContentPeer;
import net.sf.iquiver.om.ContentSource;
import net.sf.iquiver.om.ContentSourcePeer;
import net.sf.iquiver.om.Transport;
import net.sf.iquiver.parser.Parser;
import net.sf.iquiver.parser.impl.ParserFactory;
import net.sf.iquiver.search.IndexScheduler;
import net.sf.iquiver.service.BaseService;
import net.sf.iquiver.transport.Fetcher;
import net.sf.iquiver.transport.TransportConfigurationException;
import net.sf.iquiver.transport.TransportException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

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

    /**
     * List of active timers, which are responsible for starting content fetching per content source
     */
    private Map _timers;

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.service.BaseService#doStart()
     */
    protected void doStart()
    {
        this._timers = new LinkedHashMap();
        String indexDirectory = IQuiver.getConfiguration().getString( "lucene.index.path" );

        List transports = _getTransports();
        for (Iterator it = transports.iterator(); it.hasNext();)
        {
            Fetcher fetcher = (Fetcher) it.next();
            long interval = fetcher.getFetchLocation().getContentSourceUpdateTimespan();
            if (interval <= 0)
            {
                interval = DEFAULT_FETCH_UPDATE_INTERVAL;
            }

            ContentFetchThread thread = new ContentFetchThread( fetcher, indexDirectory );
            Timer timer = new Timer();
            timer.scheduleAtFixedRate( thread, 5000, interval );
            _timers.put( fetcher.getFetchLocation().getContentSourceName(), timer );
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.service.BaseService#doStop()
     */
    protected void doStop()
    {
        //shut down all timers
        for (Iterator it = _timers.values().iterator(); it.hasNext();)
        {
            ((Timer) it.next()).cancel();
        }
        _timers = null;
    }

    /**
     * @return
     */
    private List _getTransports()
    {
        List transports = new ArrayList();
        List sources = null;

        try
        {
            sources = ContentSourcePeer.doSelectAll();
        }
        catch ( TorqueException e )
        {
            logger.error( "Error while fetching content sources from database. Cannot proceed!", e );
            return transports;
        }

        for (Iterator it = sources.iterator(); it.hasNext();)
        {
            ContentSource source = (ContentSource) it.next();

            try
            {
                Transport transport = source.getTransport();
                if (transport != null)
                {
                    String className = transport.getTransportImplementation();

                    try
                    {
                        Fetcher impl = (Fetcher) Class.forName( className ).newInstance();
                        impl.setFetchLocation( source );
                        transports.add( impl );
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
            catch ( TorqueException e )
            {
                logger.error( "Error while fetching transport for ContentSource id=" + source.getContentSourceId() );
            }
        }
        return transports;
    }

    /**
     * Fetches and parses content from a content source Also adds the fetched content to the search index
     * 
     * @author netseeker aka Michael Manske
     */
    private class ContentFetchThread extends TimerTask
    {
        /**
         * The transport used to fetch content from a content source
         */
        private Fetcher fetcher;

        private String indexDir;

        private boolean isRunning = false;

        private short failures = 0;

        /**
         * Creates a new instance of ContentFetchThread
         * 
         * @param fetcher transport used to fetch content from a content source
         */
        public ContentFetchThread(Fetcher fetcher, String indexDir)
        {
            this.fetcher = fetcher;
            this.indexDir = indexDir;
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

                //check if content needs update - this is neccessary because of
                //a) we could be in a cluster enviroment, so another iquiver instance might already
                //did update this content source and
                //b) maybe we had a transport failure in past
                if (checkForUpdate())
                {
                    ContentSource source = fetcher.getFetchLocation();
                    String contentType = null;
                    //does the content source explicit overwrite the content type?
                    try
                    {
                        if (source.getContentType() != null)
                        {
                            contentType = source.getContentType().getContentTypeName();
                        }
                    }
                    catch ( TorqueException e )
                    {
                        logger.error( "Check for explicit overwritten content type of content source "
                                + source.getContentSourceName() + " failed!", e );
                    }

                    List documents = null;
                    try
                    {
                        documents = fetcher.fetch();
                        //restet failure count on success
                        if (failures != 0)
                        {
                            failures = 0;
                        }

                        //Parse and convert the document into net.sf.iquiver.om.Content instances and save them into
                        // the database
                        List contentDocs = new ArrayList();
                        for (Iterator it = documents.iterator(); it.hasNext();)
                        {
                            Document doc = (Document) it.next();

                            try
                            {
                                Content content = null;
                                //does the content source explicit overwrite the content type?
                                if (contentType != null)
                                {
                                    doc.setContentTypeStr( contentType );
                                }

                                //transports might be able to set all neccessary document values without a special
                                // parser
                                if (fetcher.isParsingRequired())
                                {
                                    Parser parser = ParserFactory.getParserForContentType( doc.getContentTypeStr() );
                                    content = new Content( parser.parse( doc ) );
                                    //does the content source explicit overwrite the content type?
                                    if (contentType != null)
                                    {
                                        //the used parser might have set another content type
                                        content.setContentTypeStr( contentType );
                                    }
                                }
                                else
                                {
                                    content = new Content( doc );
                                }

                                content.setContentReceiveDatetime( new Date() );
                                content.setContentSourceId( source.getContentSourceId() );
                                content.save();
                                contentDocs.add( content );
                            }
                            catch ( UnsupportedEncodingException e )
                            {
                                logger.error( "Encoding of retrieved content is not supported!", e );
                            }
                            catch ( Exception e )
                            {
                                logger.error( "Error while saving retrieved content!", e );
                            }
                        }

                        if (!contentDocs.isEmpty())
                        {
                            // Add the documents to the search index - we use one index per content source
                            IndexScheduler scheduler = IndexScheduler.getInstance( indexDir + File.separator
                                    + String.valueOf( source.getContentSourceId() ) );
                            scheduler.scheduleForIndexing( contentDocs );
                        }
                    }
                    catch ( TransportException e )
                    {
                        logger.error( e );
                        handleFailure();
                        isRunning = false;
                        return;
                    }
                }
                else
                {
                    if (logger.isDebugEnabled())
                    {
                        logger.debug( "Found up-to-date data, ignoring content source "
                                + fetcher.getFetchLocation().getContentSourceName() );
                    }
                }

                isRunning = false;
            }
        }

        /**
         * 
         */
        private void handleFailure()
        {
            failures++;

            // stopping this content fetch thread for the current application session after three sequenced
            // failures
            if (failures >= 3)
            {
                String id = fetcher.getFetchLocation().getContentSourceName();
                logger
                        .error( "Content fetching from content source \""
                                + id
                                + "\" failed for three times. Content fetching for this source will be stopped now for this session." );
                Timer timer = (Timer) _timers.get( id );
                timer.cancel();
                _timers.remove( id );
            }
        }

        /**
         * @return
         */
        private boolean checkForUpdate()
        {
            ContentSource source = this.fetcher.getFetchLocation();
            boolean isFetchRequired = true;
            long fetchPeriod = new Date().getTime() - source.getContentSourceUpdateTimespan();
            Criteria crit = new Criteria();
            crit.addSelectColumn( ContentPeer.CONTENT_ID );
            crit.add( ContentPeer.CONTENT_SOURCE_ID, source.getContentSourceId() );
            crit.add( ContentPeer.CONTENT_TO_DELETE, false );

            try
            {
                //first fetch for this content source?
                isFetchRequired = ContentPeer.doSelectVillageRecords( crit ).isEmpty();
                //already fetched this content source in past, check if update is neccessary
                if (!isFetchRequired)
                {
                    crit.clear();
                    crit.addSelectColumn( ContentPeer.CONTENT_ID );
                    crit.add( ContentPeer.CONTENT_SOURCE_ID, source.getContentSourceId() );
                    crit.add( ContentPeer.CONTENT_TO_DELETE, false );
                    crit.add( ContentPeer.CONTENT_RECEIVE_DATETIME, new Date( fetchPeriod ), Criteria.GREATER_THAN );
                    crit.setDistinct();

                    isFetchRequired = ContentPeer.doSelectVillageRecords( crit ).isEmpty();
                }
            }
            catch ( TorqueException e )
            {
                logger.error( "Error while fetching contents for content source " + source.getContentSourceName()
                        + " from database.", e );
                isFetchRequired = true;
            }

            return isFetchRequired;
        }
    }
}