/*
 * Created on 03.07.2004
 */
package net.sf.iquiver.remote;

import java.rmi.server.UID;

import net.sf.iquiver.service.BaseService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.pool.impl.GenericKeyedObjectPool;

/**
 * @author netseeker aka Michael Manske
 */
public class SessionManager extends BaseService
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog(SessionManager.class);
    
    private int restartCount = -1;
    private long startTime;
    private boolean isRunning = false; 
    private GenericKeyedObjectPool sessions;
    private long idCounter = 0;
    /**
     * session timeout, default is 15 min
     */
    private long timeout = 900000;
    
    /**
     * max. supported amount of concurrent sessions, default is 10
     */
    private int maxSessions = 10;
    
    /**
     * Constructs a new instance of SessionManager with default values for session timeout and max active sessions
     */
    public SessionManager()
    {       
    }
    
    /**
     * Constructs a new instance of SessionManager with custom values for session timeout and max active sessions
     * @param timeout
     * @param maxSessions
     */
    public SessionManager(long timeout, int maxSessions)
    {
        this.timeout = timeout;
        this.maxSessions = maxSessions;
    }
    
    /* (non-Javadoc)
     * @see net.sf.iquiver.service.Service#getStartTime()
     */
    public long getStartTime()
    {
        return this.startTime;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.Service#getRestartCount()
     */
    public int getRestartCount()
    {
        return this.restartCount;
    }

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.activity.Startable#start()
     */
    public void start() throws Exception
    {
        logger.info("Starting Session Manager");
        sessions = new GenericKeyedObjectPool(new SessionPoolFactory(this.timeout));
        isRunning = true;
    }

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.activity.Startable#stop()
     */
    public void stop() throws Exception
    {
        logger.info("Stopping SessionManager");
        sessions = null;
        idCounter = 0;
        isRunning = false;
    }
    
    /**
     * Creates a new session id and adds it to the session store
     * @param client client id of the user
     * @param user login name of the user
     * @return
     */
    public synchronized String addSession()
    {
        String uid = new UID().toString();
        idCounter++;        
        uid = uid + idCounter;
       
        try
        {
            sessions.addObject(uid);
        }
        catch ( Exception e )
        {
            logger.error("Failed to add session " + uid + " to the SessionPool.", e);
        }
        
        return uid;
    }
    
    public synchronized Session getSession(String id)
    {
        try
        {
            return (Session) sessions.borrowObject(id);
        }
        catch ( Exception e )
        {
            logger.debug("Session could not be retrieved from SessionPool", e);
            return null;
        }
    }
}
