/*
 * Created on 04.07.2004
 */
package net.sf.iquiver.remote;

/**
 * @author netseeker aka Michael Manske
 */
public class SessionLimitExceededException extends Exception
{
    /**
     * 
     */
    public SessionLimitExceededException(int maxSessions)
    {
        super("Can't create new Session, can't handle more than " + maxSessions + " concurrent sessions.");
    }

    /**
     * @param arg0
     */
    public SessionLimitExceededException(Throwable arg0)
    {
        super( arg0 );
    }

    /**
     * @param arg0
     * @param arg1
     */
    public SessionLimitExceededException(String arg0, Throwable arg1)
    {
        super( arg0, arg1 );
    }

}
