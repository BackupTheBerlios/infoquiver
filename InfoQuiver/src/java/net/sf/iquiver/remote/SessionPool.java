/*
 * Created on 04.07.2004
 */
package net.sf.iquiver.remote;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.LinkedHashMap;

import org.apache.commons.pool.KeyedPoolableObjectFactory;

/**
 * @author netseeker aka Michael Manske
 */
public class SessionPool
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog(SessionPool.class);
    
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

    private LinkedHashMap pool;
    private KeyedPoolableObjectFactory factory;
    private int maxActive = DEFAULT_MAX_ACTIVE;
    private long collectorTimeSpan = DEFAULT_TIME_BETWEEN_SESSION_COLLECTOR_RUNS;

    /**
     * Creates a new SessionPool instance with default values for the supported max. amount of concurrent
     * sessions as well as the timespan between session collector runs
     * @param factory the object pool factory responsible for creating new sessions
     */
    public SessionPool(KeyedPoolableObjectFactory factory)
    {
        this.factory = factory;
        pool = new LinkedHashMap(DEFAULT_MAX_ACTIVE);
    }

    /**
     * Creates a new SessionPool instance with the default value for the timespan between session collector runs
     * @param factory the object pool factory responsible for creating new sessions
     * @param maxActive maximum amount of concurrent sessions we are able to handle
     */
    public SessionPool(KeyedPoolableObjectFactory factory, int maxActive)
    {
        this.factory = factory;
        this.maxActive = maxActive;
        pool = new LinkedHashMap(maxActive);
    }

    /**
     * Creates a new SessionPool instance
     * @param factory the object pool factory responsible for creating new sessions
     * @param maxActive maximum amount of concurrent sessions we are able to handle
     * @param collectorTimeSpan timespan between session collector runs
     */
    public SessionPool(KeyedPoolableObjectFactory factory, int maxActive, long collectorTimeSpan)
    {
        this(factory, maxActive);
        this.collectorTimeSpan = collectorTimeSpan;
    }
    
    /**
     * Creates a new session in this pool
     * @param key the session identifier
     */
    public synchronized void addSession( String key ) throws SessionLimitExceededException
    {
        Session session = (Session) pool.get( key );
        if (session == null)
        {
            if(pool.size() >= maxActive)
            {
                throw new SessionLimitExceededException(maxActive);
            }
            
            try
            {
                session = (Session) factory.makeObject( key );
                if(session != null)
                {
                    pool.put( key, session );
                    notifyAll();
                }
            }
            catch(Exception e)
            {
                //do nothing
            }
        }
    }
    
    /**
     * Returns an existing session for a given identifier or null if the identifier is unknown in this pool
     * @param key session identifier
     * @return a valid session for the given key or null 
     */
    public synchronized Session getSession( String key )
    {
        Session session = (Session)pool.get( key ); 
        if( session != null )
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
        
        return session;
    }

    /**
     * Clears all sessions from this pool
     */
    public void clear()
    {
        synchronized ( this )
        {
            pool.clear();
        }

        notifyAll();
    }

    /**
     * Removes a session from this pool
     * @param key
     */
    public synchronized void destroy( String key )
    {
        pool.remove( key );
        notifyAll();
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
        notifyAll();
    }
}