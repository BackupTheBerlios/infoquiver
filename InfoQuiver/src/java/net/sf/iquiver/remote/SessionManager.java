/*
 * Created on 03.07.2004
 */
package net.sf.iquiver.remote;

import java.rmi.server.UID;

import net.sf.iquiver.service.BaseService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author netseeker aka Michael Manske
 */
public class SessionManager extends BaseService
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( SessionManager.class );

    /**
     * Default session timeout in milliseconds
     */
    public static final long DEFAULT_SESSION_TIMEOUT_MILLIS = 900000;

    /**
     * Default supported max. amount of concurrent sessions
     */
    public static final int DEFAULT_MAX_SESSIONS = 10;

    private SessionPool sessions;
    private long idCounter = 0;
    private long timeout;
    private int maxSessions;

    /**
     * Constructs a new instance of SessionManager with default values for session timeout and max active sessions
     */
    public SessionManager()
    {
        timeout = DEFAULT_SESSION_TIMEOUT_MILLIS;
        maxSessions = DEFAULT_MAX_SESSIONS;
    }

    /**
     * Constructs a new instance of SessionManager with custom values for session timeout and max active sessions
     * 
     * @param timeout
     * @param maxSessions
     */
    public SessionManager(long timeout, int maxSessions)
    {
        this.timeout = timeout;
        this.maxSessions = maxSessions;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.BaseService#doStart()
     */
    protected void doStart()
    {
        logger.info( "Starting Session Manager" );
        sessions = new SessionPool( new SessionPoolFactory( this.timeout ), maxSessions );
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.BaseService#doStop()
     */
    protected void doStop()
    {
        logger.info( "Stopping SessionManager" );
        sessions.dispose();
        idCounter = 0;
    }

    /**
     * Creates a new session id and adds it to the session store
     * 
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
            sessions.addSession( uid );
        }
        catch ( Exception e )
        {
            logger.error( "Failed to add session " + uid + " to the SessionPool.", e );
        }

        return uid;
    }

    /**
     * Retrieves a session from the session pool
     * 
     * @param id unique session identifier, MUST be an id returned by addSession()
     * @return the session for the given <code>id</code> or null if no such session exists
     */
    public synchronized Session getSession( String id )
    {
        try
        {
            return (Session) sessions.getSession( id );
        }
        catch ( Exception e )
        {
            logger.debug( "Session could not be retrieved from SessionPool", e );
            return null;
        }
    }
}