/*
 * Created on 06.07.2004
 */
package net.sf.iquiver.configuration.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import net.sf.iquiver.configuration.Configuration;
import net.sf.iquiver.configuration.Reconfigurable;
import net.sf.iquiver.service.Service;
import net.sf.iquiver.service.ServiceStateListener;

import org.apache.avalon.framework.activity.Disposable;
import org.apache.avalon.framework.configuration.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.netseeker.util.StringUtil;

/**
 * @author netseeker aka Michael Manske
 */
public class ServiceConfigurator implements Reconfigurable, Disposable
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( ServiceConfigurator.class );

    private static SimpleDateFormat df = new SimpleDateFormat();

    /**
     * List of timers, one for each scheduled Service
     */
    private List _timers;

    /**
     * List of configured service instances
     */
    private List _services;

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.configuration.Configurable#configure(net.sf.iquiver.configuration.Configuration)
     */
    public void configure( Configuration config ) throws ConfigurationException
    {
        _timers = new ArrayList();
        _services = new ArrayList();
        String nextKey = null;

        for (Iterator it = config.getKeys(); it.hasNext();)
        {
            String currentKey = StringUtil.defaultIfNull( nextKey, (String) it.next() );
            Configuration subSet = config.getSubset( currentKey );
            String clazz = config.getString( currentKey );
            Service service = null;
            boolean autostart = subSet.getBoolean( "autostart", false );
            int restartOnFailure = subSet.getInt( "restartOnFailure", -1 );
            long startTime = System.currentTimeMillis() + 60000;
            long schedulePeriod = -1;
            String[] schedule = subSet.getStringArray( "schedule" );
            String period = "ONCE";

            try
            {
                service = (Service) Class.forName( clazz ).newInstance();
            }
            catch ( ClassNotFoundException e )
            {
                logger.error( "Unable to locate service " + clazz + ". Check your configuration.", e );
                throw new ConfigurationException( e.getMessage() );
            }
            catch ( Exception e )
            {
                logger.error( "Unable to start service " + clazz + ". Check your configuration.", e );
                throw new ConfigurationException( e.getMessage() );
            }

            //SCHEDULING REQUIRED?
            if (!autostart && schedule != null)
            {
                if (schedule.length == 2)
                {
                    period = schedule[1];
                }

                try
                {
                    if (period.equalsIgnoreCase( "ONCE" ))
                    {
                        schedulePeriod = -1;
                        df.applyPattern( "HH:mm:ss" );
                        startTime = df.parse( schedule[0] ).getTime();
                    }
                    else if (period.equalsIgnoreCase( "EVERY" ))
                    {
                        df.applyPattern( "HH:mm:ss" );
                        Date date = df.parse( schedule[0] );
                        long now = System.currentTimeMillis();
                        long start = date.getHours() * 60 * 60 * 1000;
                        start += date.getMinutes() * 60 * 1000;
                        start += date.getSeconds() * 1000;
                        startTime = start + now;
                        schedulePeriod = start;
                    }
                    else if (period.equalsIgnoreCase( "DAYLY" ))
                    {
                        df.applyPattern( "HH:mm:ss" );
                        startTime = df.parse( schedule[0] ).getTime();
                        schedulePeriod = 24 * 60 * 60 * 1000;
                    }
                    else if (period.equalsIgnoreCase( "WEEKLY" ))
                    {
                        df.applyPattern( "EEE, HH:mm:ss" );
                        startTime = df.parse( schedule[0] ).getTime();
                        schedulePeriod = 7 * 24 * 60 * 60 * 1000;
                    }
                }
                catch ( ParseException e )
                {
                    logger.error( "Error while parsing start time for service " + clazz, e );
                }

                Timer timer = new Timer();
                if (schedulePeriod != -1)
                {
                    timer.scheduleAtFixedRate( new ServiceTask( service ), startTime, schedulePeriod );
                    logger.info("Scheduled service " + currentKey + ". First start: " + new Date(startTime).toLocaleString() + " Then every: " + (schedulePeriod * 1000 * 60) + "minutes" );
                }
                else
                {
                    timer.schedule( new ServiceTask( service ), new Date( startTime ) );
                    logger.info("Scheduled service for single start" + currentKey + ". Start: " + new Date(startTime).toLocaleString());                    
                }

                _timers.add( timer );
            }
            //NO SCHEDULING REQUIRED, START SERVICE IMMEDIATELY BUT ONLY ONCE
            else if (autostart)
            {
                try
                {
                    service.start();
                    _services.add( service );
                    logger.info("Started service without scheduling: " + currentKey);
                }
                catch ( Exception e )
                {
                    logger.error( "Error occured while starting service " + clazz, e );
                }
            }

            //loop through properties until next service found
            nextKey = currentKey;
            while ( nextKey.startsWith( currentKey ) && it.hasNext() )
            {
                nextKey = (String) it.next();
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.configuration.Reconfigurable#reconfigure(net.sf.iquiver.configuration.Configuration)
     */
    public void reconfigure( Configuration config ) throws ConfigurationException
    {
        dispose();
        configure( config );
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.avalon.framework.activity.Disposable#dispose()
     */
    public void dispose()
    {
        for (Iterator it = _timers.iterator(); it.hasNext();)
        {
            Timer timer = (Timer) it.next();
            timer.cancel();
        }
        _timers = null;

        for (Iterator it = _services.iterator(); it.hasNext();)
        {
            Service service = (Service) it.next();
            if (service.getState() == ServiceStateListener.ST_STOPPED)
            {
                try
                {
                    service.stop();
                }
                catch ( Exception e )
                {
                    logger.error( "Error occured while stopping service " + service.getClass().getName(), e );
                }
            }
        }
        _services = null;
    }

    /**
     * @author netseeker aka Michael Manske
     */
    private class ServiceTask extends TimerTask
    {
        private Service _service;

        public ServiceTask(Service service)
        {
            this._service = service;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.util.TimerTask#run()
         */
        public void run()
        {
            try
            {
                this._service.start();
            }
            catch ( Exception e )
            {
                logger.error( "Error occured while executing service " + this._service.getClass().getName(), e );
            }
        }

    }
}