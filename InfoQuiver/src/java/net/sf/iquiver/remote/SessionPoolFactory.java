/*
 * Created on 04.07.2004
 */
package net.sf.iquiver.remote;

import org.apache.commons.pool.KeyedPoolableObjectFactory;

/**
 * @author netseeker aka Michael Manske
 */
public class SessionPoolFactory implements KeyedPoolableObjectFactory
{    
    /**
     * session timeout, default is 15 min
     */
    private long timeout = 900000;
    
    /**
     * max. supported amount of concurrent sessions, default is 10
     */
    private int maxSessions = 10;
    
    /**
     * 
     */
    public SessionPoolFactory()
    {        
    }
    
    /**
     * @param timeout
     * @param maxSessions
     */
    public SessionPoolFactory(int timeout, int maxSessions)
    {
        this.timeout = timeout * 1000;
        this.maxSessions = 10;
    }
    
    /* (non-Javadoc)
     * @see org.apache.commons.pool.KeyedPoolableObjectFactory#makeObject(java.lang.Object)
     */
    public Object makeObject( Object key ) throws Exception
    {        
        return new Session();
    }

    /* (non-Javadoc)
     * @see org.apache.commons.pool.KeyedPoolableObjectFactory#destroyObject(java.lang.Object, java.lang.Object)
     */
    public void destroyObject( Object key, Object session ) throws Exception
    {
        //not supported
    }

    /* (non-Javadoc)
     * @see org.apache.commons.pool.KeyedPoolableObjectFactory#validateObject(java.lang.Object, java.lang.Object)
     */
    public boolean validateObject( Object key, Object session )
    {
        if(session != null)
        {
            long lastAccess = ((Session)session).getLastAccessTime();
            if((System.currentTimeMillis() - lastAccess) >= this.timeout)
            {
                return false;
            }                
        }
        else
        {
            return false;
        }
        
        return true;
    }

    /* (non-Javadoc)
     * @see org.apache.commons.pool.KeyedPoolableObjectFactory#activateObject(java.lang.Object, java.lang.Object)
     */
    public void activateObject( Object key, Object session ) throws Exception
    {
        ((Session)session).setLastAccessTime(System.currentTimeMillis());
    }

    /* (non-Javadoc)
     * @see org.apache.commons.pool.KeyedPoolableObjectFactory#passivateObject(java.lang.Object, java.lang.Object)
     */
    public void passivateObject( Object key, Object session ) throws Exception
    {
        // not supported
    }

}
