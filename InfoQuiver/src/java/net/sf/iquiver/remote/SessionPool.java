/*
 * Created on 04.07.2004
 */
package net.sf.iquiver.remote;

import org.apache.avalon.framework.activity.Disposable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.pool.KeyedPoolableObjectFactory;

/**
 * @author netseeker aka Michael Manske
 */
public class SessionPool implements Disposable
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( SessionPool.class );

    /**
     * The default cap on the total number of active instances from the pool.
     * 
     * @see #getMaxActive
     */
    public static final int DEFAULT_MAX_ACTIVE = 8;

    /**
     * The default timespan between the runs of the session collector (which removes timed out sessions)
     */
    public static final long DEFAULT_TIME_BETWEEN_SESSION_COLLECTOR_RUNS = 5000;

    private int maxActive = DEFAULT_MAX_ACTIVE;
    private long collectorTimeSpan = DEFAULT_TIME_BETWEEN_SESSION_COLLECTOR_RUNS;

    private LinkedHashMap pool;
    private KeyedPoolableObjectFactory factory;
    private Timer collectorTimer = new Timer();

    /**
     * Creates a new SessionPool instance with default values for the supported max. amount of concurrent sessions as
     * well as the timespan between session collector runs
     * 
     * @param factory the object pool factory responsible for creating new sessions
     */
    public SessionPool(KeyedPoolableObjectFactory factory)
    {
        this.factory = factory;
        pool = new LinkedHashMap( DEFAULT_MAX_ACTIVE );
        collectorTimer.scheduleAtFixedRate(new SessionCollector(), DEFAULT_TIME_BETWEEN_SESSION_COLLECTOR_RUNS, DEFAULT_TIME_BETWEEN_SESSION_COLLECTOR_RUNS);
    }

    /**
     * Creates a new SessionPool instance with the default value for the timespan between session collector runs
     * 
     * @param factory the object pool factory responsible for creating new sessions
     * @param maxActive maximum amount of concurrent sessions we are able to handle
     */
    public SessionPool(KeyedPoolableObjectFactory factory, int maxActive)
    {
        this.factory = factory;
        this.maxActive = maxActive;
        pool = new LinkedHashMap( maxActive );
        collectorTimer.scheduleAtFixedRate(new SessionCollector(), DEFAULT_TIME_BETWEEN_SESSION_COLLECTOR_RUNS, DEFAULT_TIME_BETWEEN_SESSION_COLLECTOR_RUNS);
    }

    /**
     * Creates a new SessionPool instance
     * 
     * @param factory the object pool factory responsible for creating new sessions
     * @param maxActive maximum amount of concurrent sessions we are able to handle
     * @param collectorTimeSpan timespan between session collector runs
     */
    public SessionPool(KeyedPoolableObjectFactory factory, int maxActive, long collectorTimeSpan)
    {
        this( factory, maxActive );
        this.collectorTimeSpan = collectorTimeSpan;
        collectorTimer.scheduleAtFixedRate(new SessionCollector(), collectorTimeSpan, collectorTimeSpan);
    }

    /**
     * Creates a new session in this pool
     * 
     * @param key the session identifier
     */
    public void addSession( String key ) throws SessionLimitExceededException
    {
        synchronized ( pool )
        {
            Session session = (Session) pool.get( key );
            if (session == null)
            {
                if (pool.size() >= maxActive)
                {
                    throw new SessionLimitExceededException( maxActive );
                }

                try
                {
                    session = (Session) factory.makeObject( key );
                    if (session != null)
                    {
                        pool.put( key, session );
                    }
                }
                catch ( Exception e )
                {
                    //do nothing
                }
            }
        }

        pool.notifyAll();
    }

    /**
     * Returns an existing session for a given identifier or null if the identifier is unknown in this pool
     * 
     * @param key session identifier
     * @return a valid session for the given key or null
     */
    public Session getSession( String key )
    {
        synchronized ( pool )
        {
            Session session = (Session) pool.get( key );
            if (session != null)
            {
                try
                {
                    factory.activateObject( key, session );
                }
                catch ( Exception e )
                {
                    // do nothing
                }
            }

            pool.notifyAll();
            return session;
        }
    }

    /**
     * Clears all sessions from this pool
     */
    public void clear()
    {
        synchronized ( pool )
        {
            pool.clear();
        }

        pool.notifyAll();
    }

    /**
     * Removes a session from this pool
     * 
     * @param key
     */
    public void destroy( String key )
    {
        synchronized ( pool )
        {
            pool.remove( key );
        }

        pool.notifyAll();
    }

    /**
     * Returns the cap on the total number of active instances from my pool.
     * 
     * @return the cap on the total number of active instances from my pool.
     * @see #setMaxActive
     */
    public synchronized int getMaxActive()
    {
        return maxActive;
    }

    /**
     * Sets the cap on the total number of active instances from my pool.
     * 
     * @param maxActive The cap on the total number of active instances from my pool. Use a negative value for an
     *            infinite number of instances.
     * @see #getMaxActive
     */
    public synchronized void setMaxActive( int maxActive )
    {
        this.maxActive = maxActive;
    }

    /**
     * @author netseeker aka Michael Manske
     */
    private class SessionCollector extends TimerTask
    {
        /*
         * (non-Javadoc)
         * 
         * @see java.util.TimerTask#run()
         */
        public void run()
        {
            synchronized ( pool )
            {
                ArrayList garbage = new ArrayList(); 
                for (Iterator it = pool.keySet().iterator(); it.hasNext();)
                {
                    String id = (String) it.next();
                    if (!factory.validateObject( id, pool.get( id ) ))
                    {
                        garbage.add(id);
                    }
                }
                
                for(Iterator it = garbage.iterator(); it.hasNext();)
                {
                    pool.remove( it.next() );
                }
            }
            
            notifyAll();
        }
    }

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.activity.Disposable#dispose()
     */
    public void dispose()
    {
        collectorTimer.cancel();        
        clear();
    }
}