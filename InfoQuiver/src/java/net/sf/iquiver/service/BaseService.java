/*
 * Created on 21.03.2004
 *
 */
package net.sf.iquiver.service;

import javax.swing.event.EventListenerList;

import net.sf.iquiver.event.IQEventListener;

/**
 * The base class of all service tasks.
 * @author netseeker aka Michael Manske
 */
public abstract class BaseService implements Service
{
    /**
     * Comment for <code>serviceStateListeners</code>
     */
    EventListenerList serviceStateListeners = new EventListenerList();

    /**
     * Comment for <code>serviceExecutionListeners</code>
     */
    EventListenerList serviceExecutionListeners = new EventListenerList();

    private int _state = ServiceStateChangedEvent.ST_STOPPED;

    private int _restartCount = 0;
    private long _startTime;
    private String _name;

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.Service#addServiceStateListener(net.sf.iquiver.service.ServiceStateListener)
     */
    public final void addServiceStateListener( IQEventListener listener )
    {
        serviceStateListeners.add(IQEventListener.class, listener );
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.Service#removeServiceStateListener(net.sf.iquiver.service.ServiceStateListener)
     */
    public final void removeServiceStateListener( IQEventListener listener )
    {
        serviceStateListeners.remove(IQEventListener.class, listener );
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.Service#addServiceExecutionListener(net.sf.iquiver.service.ServiceExecutionListener)
     */
    public final void addServiceExecutionListener( IQEventListener listener )
    {
            serviceExecutionListeners.add(IQEventListener.class, listener );
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.Service#removeServiceExecutionListener(net.sf.iquiver.service.ServiceExecutionListener)
     */
    public final void removeServiceExecutionListener( IQEventListener listener )
    {
        serviceExecutionListeners.remove(IQEventListener.class, listener );
    }

    /**
     * The recommended method for all inherited classes to notify ServiceStateListeners
     * of a ServiceStateChangedEvent.
     * @param evt
     */
    protected final void notifyServiceStateListeners( ServiceStateChangedEvent evt )
    {
        Object[] listeners = serviceStateListeners.getListenerList();
        
        for ( int i = 0; i < listeners.length; i+=2 )
        {
            ((IQEventListener)listeners[i+1]).fireEvent( evt );
        }
    }

    /**
     * The recommended method for all inherited classes to notify ServiceExecutionListeners
     * of a ServiceExecutionEvent.
     * @param evt
     */
    protected final void notifyServiceExecutionListeners( ServiceExecutionEvent evt )
    {
        Object[] listeners = serviceExecutionListeners.getListenerList();
        
        for ( int i = 0; i < listeners.length; i+=2 )
        {
            ((IQEventListener)listeners[i+1]).fireEvent( evt );
        }        
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
     * @see net.sf.iquiver.service.Service#getName()
     */
    public String getName()
    {
        return this._name;
    }
    
    /* (non-Javadoc)
     * @see net.sf.iquiver.service.Service#setName(java.lang.String)
     */
    public void setName( String name )
    {
        this._name = name;
    }
    
    /* (non-Javadoc)
     * @see org.apache.avalon.framework.activity.Startable#start()
     */
    public void start()
    {
        this._startTime = System.currentTimeMillis();
        this._restartCount++;
        doStart();
        setState( ServiceStateChangedEvent.ST_STARTED );
    }

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.activity.Startable#stop()
     */
    public void stop()
    {
        doStop();
        setState( ServiceStateChangedEvent.ST_STOPPED );
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
        return _restartCount == 0 ? 0 : _restartCount - 1;
    }

    protected abstract void doStart();

    protected abstract void doStop();
}