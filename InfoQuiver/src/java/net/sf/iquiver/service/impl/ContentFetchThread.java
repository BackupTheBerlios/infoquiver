/*********************************************************************
 * ContentFetchThread.java
 * created on 22.07.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/service/impl/ContentFetchThread.java,v $
 * $Date: 2004/12/02 23:21:16 $
 * $Revision: 1.4 $
 *********************************************************************/

package net.sf.iquiver.service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimerTask;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.om.Content;
import net.sf.iquiver.om.ContentPeer;
import net.sf.iquiver.om.ContentSource;
import net.sf.iquiver.parser.Parser;
import net.sf.iquiver.parser.impl.ParserFactory;
import net.sf.iquiver.search.IndexScheduler;
import net.sf.iquiver.transport.Fetcher;
import net.sf.iquiver.transport.TransportException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

import com.workingdogs.village.Record;

/**
 * @author netseeker aka Michael Manske
 */
/**
 * Fetches and parses content from a content source Also adds the fetched content to the search index
 * 
 * @author netseeker aka Michael Manske
 */
class ContentFetchThread extends TimerTask
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( ContentFetchThread.class );

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
        if (!isRunning && failures < 3)
        {
            isRunning = true;

            //check if content needs update - this is neccessary because of
            //a) we could be in a cluster enviroment, so another iquiver instance might already
            //did update this content source and
            //b) maybe we had a transport failure in past
            if (checkForUpdate())
            {
                ContentSource source = fetcher.getFetchLocation();
                List contents = null;
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
                    contents = source.getContents();
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

                    //mark old contents as outdated
                    try
                    {
                        for (Iterator it = contents.iterator(); it.hasNext();)
                        {
                            Content tmp = (Content) it.next();
                            tmp.setContentToDelete( true );
                            tmp.save();
                        }
                    }
                    catch ( Exception e1 )
                    {
                        logger.error( "Error while marking old contents as outdated", e1 );
                    }

                }
                catch ( TransportException e )
                {
                    logger.error( e );
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
                    }

                    isRunning = false;
                    return;
                }
                catch ( TorqueException e )
                {
                    logger.error( "Database error occured while fetching already stored contents from database!", e );
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
     * @return
     */
    private boolean checkForUpdate()
    {
        ContentSource source = this.fetcher.getFetchLocation();
        boolean isFetchRequired = true;
        long fetchPeriod = new Date().getTime() - source.getContentSourceUpdateTimespan();
        Criteria crit = new Criteria();
        crit.add( ContentPeer.CONTENT_SOURCE_ID, source.getContentSourceId() );
        crit.add( ContentPeer.CONTENT_TO_DELETE, false );
        crit.add( ContentPeer.CONTENT_RECEIVE_DATETIME, new Date( fetchPeriod ), Criteria.GREATER_THAN );
        crit.addSelectColumn( "count(" + ContentPeer.CONTENT_ID + ") as size" );        

        try
        {
            List results = ContentPeer.doSelectVillageRecords( crit );
            if( !results.isEmpty() )
            {
                isFetchRequired = ( 0 == ((Record)results.get(0)).getValue(1).asLong() );
            }
        }
        catch ( Exception e )
        {
            logger.error( "Error while fetching contents for content source " + source.getContentSourceName()
                    + " from database.", e );
            isFetchRequired = true;
        }

        return isFetchRequired;
    }
}