/*********************************************************************
 * ServiceStats.java
 * created on 08.12.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/event/Attic/ServiceStats.java,v $
 * $Date: 2004/12/11 18:12:20 $
 * $Revision: 1.1 $
*********************************************************************/

package net.sf.iquiver.event;

import java.util.Date;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import net.sf.iquiver.service.Service;
import net.sf.iquiver.service.ServiceExecutionEvent;
import net.sf.iquiver.service.ServiceStateChangedEvent;
import net.sf.iquiver.util.ObjectSerializer;

/**
 * @author netseeker aka Michael Manske
 */
public class ServiceStats extends EventProcessor
{    
    private transient Hashtable _serviceEvtMap = new Hashtable();
    public static final String SERVICE_STATE = "SERVICE_STATE";
    public static final String SERVICE_STATECHANGE_TIME = "SERVICE_STATECHANGE_TIME";
    public static final String SERVICE_STATE_OLD = "SERVICE_STATE_OLD";
    public static final String SERVICE_STATE_NEW = "SERVICE_STATE_NEW";
    public static final String SERVICE_EXEC_COUNT = "SERVICE_EXEC_COUNT";
    public static final String SERVICE_EXEC_SUCCESS_COUNT = "SERVICE_EXEC_SUCCESS_COUNT";
    public static final String SERVICE_EXEC_FAILED_COUNT = "SERVICE_EXEC_FAILED_COUNT";
    public static final String SERVICE_EXEC_TIME = "SERVICE_EXEC_TIME";
    public static final String SERVICE_EXEC_MSG = "SERVICE_EXEC_MSG";
    public static final String SERVICE_EXEC_SUCCESS = "SERVICE_EXEC_SUCCESS";
        
    void processEvent( EventObject evt )
    {
        Service service = (Service)evt.getSource();
        Map store = getServiceStore( service.getName() );
        
        if( evt instanceof ServiceExecutionEvent )
        {
            ServiceExecutionEvent execEvt = (ServiceExecutionEvent)evt;
            store.put(SERVICE_EXEC_TIME, new Date( execEvt.getExecutionTime() ) );
            store.put(SERVICE_EXEC_MSG, execEvt.getMessage() );
            store.put(SERVICE_EXEC_SUCCESS, Boolean.valueOf( execEvt.isSuccessful() ) );
            int count = safeIntegerToInt( (Integer)store.get(SERVICE_EXEC_COUNT) );
            store.put(SERVICE_EXEC_COUNT, new Integer( count + 1 ) );
                        
            if( execEvt.isSuccessful() )
            {
                count = safeIntegerToInt( (Integer)store.get(SERVICE_EXEC_SUCCESS_COUNT) );
                store.put(SERVICE_EXEC_SUCCESS_COUNT, new Integer( count + 1 ) );
            }
            else
            {
                count = safeIntegerToInt( (Integer)store.get(SERVICE_EXEC_FAILED_COUNT) );
                store.put(SERVICE_EXEC_FAILED_COUNT, new Integer( count + 1 ) );                
            }
        }
        else if( evt instanceof ServiceStateChangedEvent )
        {
            ServiceStateChangedEvent stateEvt = (ServiceStateChangedEvent)evt;
            store.put( SERVICE_STATE_OLD, new Integer( stateEvt.getOldState() ) );
            store.put( SERVICE_STATE_NEW, new Integer( stateEvt.getNewState() ) );
            store.put( SERVICE_STATECHANGE_TIME, new Date( stateEvt.getTime() ) );            
        }
        else
        {
            throw new IllegalArgumentException("Event objects of type " + evt.getClass().getName() + " are not allowed!" );
        }
    }
    
    private Map getServiceStore( String name )
    {
        Map store = (Map)_serviceEvtMap.get( name );
        if( store == null )
        {
            store = new HashMap();
            _serviceEvtMap.put( name, store );
        }
        
        return store;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.util.XmlSerializable#toXml()
     */
    public String toXml()
    {
        return ObjectSerializer.objectToXml( _serviceEvtMap );
    }
    
    private int safeIntegerToInt( Integer number )
    {
        return number != null ? number.intValue() : 0;
    }
}
