/*
 * Created on 21.03.2004
 *
 */
package net.sf.iquiver.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author netseeker aka Michael Manske
 */
public abstract class BaseService implements Service
{
    /**
     * Comment for <code>serviceStateListeners</code>
     */
    List serviceStateListeners = Collections.synchronizedList(new ArrayList());
    
    /**
     * Comment for <code>serviceExecutionListeners</code>
     */
    List serviceExecutionListeners = Collections.synchronizedList(new ArrayList());

    
    /* (non-Javadoc)
     * @see net.sf.iquiver.service.Service#addServiceStateListener(net.sf.iquiver.service.ServiceStateListener)
     */
    public final void addServiceStateListener( ServiceStateListener listener )
    {
        if(!serviceStateListeners.contains(listener))
        {    
            serviceStateListeners.add(listener);
        }
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.Service#removeServiceStateListener(net.sf.iquiver.service.ServiceStateListener)
     */
    public final void removeServiceStateListener( ServiceStateListener listener )
    {
        serviceStateListeners.remove(listener);
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.Service#addServiceExecutionListener(net.sf.iquiver.service.ServiceExecutionListener)
     */
    public final void addServiceExecutionListener( ServiceExecutionListener listener )
    {
        if(!serviceExecutionListeners.contains(listener))
        {    
            serviceExecutionListeners.add(listener);
        }
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.Service#removeServiceExecutionListener(net.sf.iquiver.service.ServiceExecutionListener)
     */
    public final void removeServiceExecutionListener( ServiceExecutionListener listener )
    {
        serviceExecutionListeners.remove(listener);
    }
    
    /**
     * The recommended method for all inherited classes to notify ServiceStateListeners
     * of a ServiceStateChangedEvent.
     * @param evt
     */
    protected final void notifyServiceStateListeners(final ServiceStateChangedEvent evt)
    {
        new Thread() {
            public void run()
            {
                for(Iterator it = serviceStateListeners.iterator(); it.hasNext(); )
                {
                    ((ServiceStateListener)it.next()).serviceStateChanged(evt);
                }
            }
        }.start();        
    }

    /**
     * The recommended method for all inherited classes to notify ServiceExecutionListeners
     * of a ServiceExecutionEvent.
     * @param evt
     */
    protected final void notifyServiceExecutionListeners(final ServiceExecutionEvent evt)
    {
        new Thread() {
            public void run()
            {
                for(Iterator it = serviceExecutionListeners.iterator(); it.hasNext(); )
                {
                    ((ServiceExecutionListener)it.next()).executed(evt);
                }
            }
        }.start();
    }
    
    /* (non-Javadoc)
     * @see org.apache.avalon.framework.activity.Startable#start()
     */
    public abstract void start() throws Exception;

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.activity.Startable#stop()
     */
    public abstract void stop() throws Exception;

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.activity.Suspendable#suspend()
     */
    public abstract void suspend();

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.activity.Suspendable#resume()
     */
    public abstract void resume();
    
    /* (non-Javadoc)
     * @see net.sf.iquiver.service.Service#getStartTime()
     */
    public abstract long getStartTime();

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.Service#getRestartCount()
     */
    public abstract int getRestartCount();
}
