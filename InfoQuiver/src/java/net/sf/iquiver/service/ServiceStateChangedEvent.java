/*
 * Created on 21.03.2004
 *
 */
package net.sf.iquiver.service;

import java.util.EventObject;

/**
 * @author netseeker aka Michael Manske
 */
public class ServiceStateChangedEvent extends EventObject
{    
    public final static int ST_STARTED = 1;
    public final static int ST_STOPPED = 2;
    public final static int ST_SUSPENDED = 3;
    public final static int ST_RESUMED = 4;

    private int oldState;
    private int newState;
    private long time;
    
    public ServiceStateChangedEvent( Service service, int oldState, int newState)
    {
        this( service, oldState, newState, System.currentTimeMillis() );
    }
    
    public ServiceStateChangedEvent( Service service, int oldState, int newState, long time )
    {
        super( service );
        this.oldState = oldState;
        this.newState = newState;
        this.time = time;
    }

    /**
     * @return Returns the newState.
     */
    public int getNewState()
    {
        return this.newState;
    }
    /**
     * @return Returns the oldState.
     */
    public int getOldState()
    {
        return this.oldState;
    }
    /**
     * @return Returns the time.
     */
    public long getTime()
    {
        return this.time;
    }
    
}
