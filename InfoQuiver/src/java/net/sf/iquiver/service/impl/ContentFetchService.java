/*********************************************************************
 * ContentFetchService.java
 * created on 20.03.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/service/impl/ContentFetchService.java,v $
 * $Date: 2004/07/22 18:26:28 $
 * $Revision: 1.26 $
 *********************************************************************/

package net.sf.iquiver.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import net.sf.iquiver.IQuiver;
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
}