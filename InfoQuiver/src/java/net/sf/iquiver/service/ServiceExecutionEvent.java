/*
 * Created on 21.03.2004
 *
 */
package net.sf.iquiver.service;

import java.util.EventObject;

/**
 * @author netseeker aka Michael Manske
 */
public class ServiceExecutionEvent extends EventObject
{
    long executionTime;
    boolean successful;
    String message;
    
    public ServiceExecutionEvent( Service service, boolean successful, String message )
    {
        this(service, successful, message, System.currentTimeMillis());
    }
    
    public ServiceExecutionEvent( Service service, boolean successful, String message, long executionTime )
    {
        super( service );
        this.successful = successful;
        this.executionTime = executionTime;
        this.message = message;
    }
    
    /**
     * @return Returns the executionTime.
     */
    public long getExecutionTime()
    {
        return this.executionTime;
    }
    /**
     * @return Returns the message.
     */
    public String getMessage()
    {
        return this.message;
    }
    /**
     * @return Returns the successful.
     */
    public boolean isSuccessful()
    {
        return this.successful;
    }    
}
