/*********************************************************************
 * EventProcessor.java
 * created on 08.12.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/event/EventProcessor.java,v $
 * $Date: 2004/12/11 23:20:54 $
 * $Revision: 1.2 $
*********************************************************************/

package net.sf.iquiver.event;

import java.util.EventObject;

import net.sf.iquiver.util.XmlSerializable;
import de.netseeker.util.Queue;

/**
 * @author netseeker aka Michael Manske
 */
public abstract class EventProcessor extends Thread implements IQEventListener, XmlSerializable
{
    private transient Queue _queue = new Queue();
    
    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public void run()
    {
        while( !isInterrupted() )
        {
            EventObject obj = (EventObject)_queue.next();
            processEvent( obj );
        }
        
        _queue.clear();
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.event.IQEventListener#fireEvent(java.util.EventObject)
     */
    public void fireEvent( EventObject evt )
    {
        _queue.add( evt );
    }    
    
    /* (non-Javadoc)
     * @see net.sf.iquiver.util.XmlSerializable#fromXml(java.lang.String)
     */
    public void fromXml( String xml )
    {
        throw new UnsupportedOperationException( "net.sf.iquiver.util.XmlSerializable#fromXml(java.lang.String) is not supported! " );
    }

    /**
     * @param evt
     */
    abstract public void processEvent( EventObject evt );    
}
