/*
 * Created on 20.03.2004
 *
 */
package net.sf.iquiver.service;

/**
 * @author netseeker aka Michael Manske
 */
public interface ServiceStateListener
{
    public final static int ST_STARTED = 1;
    public final static int ST_STOPPED = 2;
    public final static int ST_SUSPENDED = 3;
    public final static int ST_RESUMED = 4;
    
    public void serviceStateChanged(ServiceStateChangedEvent evt);
}
