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
     * @param timeout
     * @param maxSessions
     */
    public SessionPoolFactory( long timeout )
    {
        this.timeout = timeout;
    }
    
    /* (non-Javadoc)
     * @see org.apache.commons.pool.KeyedPoolableObjectFactory#makeObject(java.lang.Object)
     */
    public Object makeObject( Object key ) throws Exception
    {        
        return new Session((String)key);
    }

    /* (non-Javadoc)
     * @see org.apache.commons.pool.KeyedPoolableObjectFactory#destroyObject(java.lang.Object, java.lang.Object)
     */
    public void destroyObject( Object key, Object session )  throws Exception
    {
        session = null;
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
        if(validateObject(key, session))
        {
            ((Session)session).setLastAccessTime(System.currentTimeMillis());
        }
        else
        {
            throw new Exception("Session timed out.");
        }
    }

    /* (non-Javadoc)
     * @see org.apache.commons.pool.KeyedPoolableObjectFactory#passivateObject(java.lang.Object, java.lang.Object)
     */
    public void passivateObject( Object key, Object session ) throws Exception
    {
        ((Session)session).setLastAccessTime(System.currentTimeMillis());
    }

}
