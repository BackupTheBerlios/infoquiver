/*
 * Created on 06.07.2004
 */
package net.sf.iquiver.configuration.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.iquiver.configuration.Configuration;
import net.sf.iquiver.configuration.Reconfigurable;

import org.apache.avalon.framework.activity.Disposable;
import org.apache.avalon.framework.configuration.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author netseeker aka Michael Manske
 */
public class ServiceConfigurator implements Reconfigurable, Disposable
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( ServiceConfigurator.class );
    
    private List _timers;

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.configuration.Configurable#configure(net.sf.iquiver.configuration.Configuration)
     */
    public void configure( Configuration config ) throws ConfigurationException
    {
        
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.configuration.Reconfigurable#reconfigure(net.sf.iquiver.configuration.Configuration)
     */
    public void reconfigure( Configuration config ) throws ConfigurationException
    {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.avalon.framework.activity.Disposable#dispose()
     */
    public void dispose()
    {
        // TODO Auto-generated method stub

    }

    /**
     * @author netseeker aka Michael Manske
     */
    private class ServiceConfiguration
    {
        private String _className;
        private long _startTime;
        private boolean _scheduled, _autostart;
        private long _schedulePeriod;
        private int _restartOnFailure;

        /**
         * @param className
         * @param startTime
         * @param scheduled
         * @param autostart
         * @param period
         * @param onFailure
         */
        public ServiceConfiguration(String className, String startTime, String period, boolean autostart, int onFailure)
        {
            this._className = className;
            this._autostart = autostart;
            this._restartOnFailure = onFailure;
            setSchedule( startTime, period );
        }

        /**
         * @return Returns the _autostart.
         */
        public boolean isAutostart()
        {
            return this._autostart;
        }

        /**
         * @param _autostart The _autostart to set.
         */
        public void setAutostart( boolean _autostart )
        {
            this._autostart = _autostart;
        }

        /**
         * @return Returns the _className.
         */
        public String getClassName()
        {
            return this._className;
        }

        /**
         * @param name The _className to set.
         */
        public void setClassName( String name )
        {
            this._className = name;
        }

        /**
         * @return Returns the _restartOnFailure.
         */
        public int getRestartOnFailure()
        {
            return this._restartOnFailure;
        }

        /**
         * @param onFailure The _restartOnFailure to set.
         */
        public void setRestartOnFailure( int onFailure )
        {
            this._restartOnFailure = onFailure;
        }

        /**
         * @return Returns the _scheduled.
         */
        public boolean isScheduled()
        {
            return this._scheduled;
        }

        /**
         * @return Returns the _schedulePeriod.
         */
        public long getSchedulePeriod()
        {
            return this._schedulePeriod;
        }

        /**
         * @return Returns the _startTime.
         */
        public long getStartTime()
        {
            return this._startTime;
        }

        /**
         * @param startTime
         * @param period
         */
        public void setSchedule( String startTime, String period )
        {
            SimpleDateFormat df = new SimpleDateFormat();

            try
            {
                if (period.equalsIgnoreCase( "ONCE" ))
                {
                    this._schedulePeriod = -1;
                    df.applyPattern( "HH:mm:ss" );
                    this._startTime = df.parse( startTime ).getTime();
                    this._scheduled = false;
                }
                else if (period.equalsIgnoreCase( "EVERY" ))
                {
                    this._schedulePeriod = 0;
                    df.applyPattern( "HH:mm:ss" );
                    Date date = df.parse( startTime );
                    long now = System.currentTimeMillis();
                    long start = date.getHours() * 60 * 60 * 1000;
                    start += date.getMinutes() * 60 * 1000;
                    start += date.getSeconds() * 1000;
                    this._startTime = start + now;
                    this._schedulePeriod = start;
                    this._scheduled = true;
                }
                else if (period.equalsIgnoreCase( "DAYLY" ))
                {
                    this._schedulePeriod = 1;
                    df.applyPattern( "HH:mm:ss" );
                    this._startTime = df.parse( startTime ).getTime();
                    this._schedulePeriod = 24 * 60 * 60 * 1000;
                    this._scheduled = true;
                }
                else if (period.equalsIgnoreCase( "WEEKLY" ))
                {
                    this._schedulePeriod = 2;
                    df.applyPattern( "EEE, HH:mm:ss" );
                    this._startTime = df.parse( startTime ).getTime();
                    this._schedulePeriod = 7 * 24 * 60 * 60 * 1000;
                    this._scheduled = true;                    
                }
            }
            catch ( ParseException e )
            {
                logger.error( "Error while parsing start time for service " + _className, e );
            }
        }
    }
}