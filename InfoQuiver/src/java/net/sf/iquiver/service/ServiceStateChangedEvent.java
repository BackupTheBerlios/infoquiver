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
    private int oldState;
    private int newState;
    private long time;
    
    public ServiceStateChangedEvent( Object obj, int oldState, int newState)
    {
        this( obj, oldState, newState, System.currentTimeMillis() );
    }
    
    public ServiceStateChangedEvent( Object obj, int oldState, int newState, long time )
    {
        super( obj );
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
