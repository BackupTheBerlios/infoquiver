/*
 * Created on 02.07.2004
 */
package net.sf.iquiver.remote;

/**
 * @author netseeker aka Michael Manske
 */
public class RemoteException extends RuntimeException
{
    /**
     * 
     */
    public RemoteException()
    {
        super();
    }
    /**
     * @param arg0
     */
    public RemoteException(String arg0)
    {
        super( arg0 );
    }
    /**
     * @param arg0
     * @param arg1
     */
    public RemoteException(String arg0, Throwable arg1)
    {
        super( arg0, arg1 );
    }
    /**
     * @param arg0
     */
    public RemoteException(Throwable arg0)
    {
        super( arg0 );
    }
}
