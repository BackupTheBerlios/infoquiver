/*
 * Created on 21.03.2004
 *
 */
package net.sf.iquiver.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * The base class of all service tasks.
 * @author netseeker aka Michael Manske
 */
public abstract class BaseService implements Service
{
    /**
     * Comment for <code>serviceStateListeners</code>
     */
    List serviceStateListeners = Collections.synchronizedList( new ArrayList() );

    /**
     * Comment for <code>serviceExecutionListeners</code>
     */
    List serviceExecutionListeners = Collections.synchronizedList( new ArrayList() );

    private int _state = ServiceStateListener.ST_STOPPED;

    private int _restartCount = 0;
    private long _startTime;

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.Service#addServiceStateListener(net.sf.iquiver.service.ServiceStateListener)
     */
    public final void addServiceStateListener( ServiceStateListener listener )
    {
        if (!serviceStateListeners.contains( listener ))
        {
            serviceStateListeners.add( listener );
        }
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.Service#removeServiceStateListener(net.sf.iquiver.service.ServiceStateListener)
     */
    public final void removeServiceStateListener( ServiceStateListener listener )
    {
        serviceStateListeners.remove( listener );
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.Service#addServiceExecutionListener(net.sf.iquiver.service.ServiceExecutionListener)
     */
    public final void addServiceExecutionListener( ServiceExecutionListener listener )
    {
        if (!serviceExecutionListeners.contains( listener ))
        {
            serviceExecutionListeners.add( listener );
        }
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.Service#removeServiceExecutionListener(net.sf.iquiver.service.ServiceExecutionListener)
     */
    public final void removeServiceExecutionListener( ServiceExecutionListener listener )
    {
        serviceExecutionListeners.remove( listener );
    }

    /**
     * The recommended method for all inherited classes to notify ServiceStateListeners
     * of a ServiceStateChangedEvent.
     * @param evt
     */
    protected final void notifyServiceStateListeners( final ServiceStateChangedEvent evt )
    {
        new Thread()
        {
            public void run()
            {
                for (Iterator it = serviceStateListeners.iterator(); it.hasNext();)
                {
                    ((ServiceStateListener) it.next()).serviceStateChanged( evt );
                }
            }
        }.start();
    }

    /**
     * The recommended method for all inherited classes to notify ServiceExecutionListeners
     * of a ServiceExecutionEvent.
     * @param evt
     */
    protected final void notifyServiceExecutionListeners( final ServiceExecutionEvent evt )
    {
        new Thread()
        {
            public void run()
            {
                for (Iterator it = serviceExecutionListeners.iterator(); it.hasNext();)
                {
                    ((ServiceExecutionListener) it.next()).executed( evt );
                }
            }
        }.start();
    }

    /**
     * The recommended method for all inherited classes to execute all neccessary actions/notifications
     * if the service state changes 
     * @param newState
     * @return the previous state of the service
     */
    protected int setState( int newState )
    {
        int oldState = this._state;
        this._state = newState;

        notifyServiceStateListeners( new ServiceStateChangedEvent( this, oldState, newState ) );

        return oldState;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.Service#getState()
     */
    public int getState()
    {
        return this._state;
    }

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.activity.Startable#start()
     */
    public void start()
    {
        this._startTime = System.currentTimeMillis();
        this._restartCount++;
        doStart();
        setState( ServiceStateListener.ST_STARTED );
    }

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.activity.Startable#stop()
     */
    public void stop()
    {
        doStop();
        setState( ServiceStateListener.ST_STOPPED );
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.Service#getStartTime()
     */
    public long getStartTime()
    {
        return this._startTime;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.Service#getRestartCount()
     */
    public int getRestartCount()
    {
        return _restartCount;
    }

    protected abstract void doStart();

    protected abstract void doStop();
}