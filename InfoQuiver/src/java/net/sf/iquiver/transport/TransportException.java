/*
 * Created on 14.03.2004
 *
 */
package net.sf.iquiver.transport;

/**
 * @author netseeker aka Michael Manske
 */
public class TransportException extends Exception
{

    /**
     * 
     */
    public TransportException()
    {
        super();
    }

    /**
     * @param arg0
     */
    public TransportException( String arg0 )
    {
        super( arg0 );
    }

    /**
     * @param arg0
     */
    public TransportException( Throwable arg0 )
    {
        super( arg0 );
    }

    /**
     * @param arg0
     * @param arg1
     */
    public TransportException( String arg0, Throwable arg1 )
    {
        super( arg0, arg1 );
    }

}
