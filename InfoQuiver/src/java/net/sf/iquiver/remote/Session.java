/*
 * Created on 04.07.2004
 */
package net.sf.iquiver.remote;

import java.io.Serializable;
import java.util.Hashtable;

/**
 * @author netseeker aka Michael Manske
 */
public class Session implements Serializable
{
    private long lastAccessTime;
    private Hashtable sessionData;
    private String id;

    public Session(String id)
    {
        this.sessionData = new Hashtable();
        this.lastAccessTime = System.currentTimeMillis();
        this.id = id;
    }

    /**
     * @param key
     * @param object
     */
    public synchronized void add( String key, Object object )
    {
        sessionData.put( key, object );
    }

    /**
     * @param key
     * @return
     */
    public Object get( String key )
    {
        return sessionData.get( key );
    }

    /**
     * @return Returns the lastAccessTime.
     */
    public long getLastAccessTime()
    {
        return this.lastAccessTime;
    }

    /**
     * @param lastAccessTime The lastAccessTime to set.
     */
    public void setLastAccessTime( long lastAccessTime )
    {
        this.lastAccessTime = lastAccessTime;
    }

    /**
     * @return Returns the id.
     */
    public String getId()
    {
        return this.id;
    }

    /**
     * @param id The id to set.
     */
    public void setId( String id )
    {
        this.id = id;
    }
}