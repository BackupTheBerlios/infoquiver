/*********************************************************************
 * IndexStats.java
 * created on 11.12.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/IndexStats.java,v $
 * $Date: 2004/12/11 23:20:54 $
 * $Revision: 1.1 $
 *********************************************************************/

package net.sf.iquiver;

import java.util.EventObject;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import net.sf.iquiver.event.EventProcessor;
import net.sf.iquiver.search.IndexAdditionEvent;
import net.sf.iquiver.search.IndexDeletionEvent;
import net.sf.iquiver.util.ObjectSerializer;

/**
 * @author netseeker aka Michael Manske
 */
public class IndexStats extends EventProcessor
{
    public static final transient String DOCUMENTS_ADDED = "DOCUMENTS_ADDED";
    public static final transient String DOCUMENTS_REMOVED = "DOCUMENTS_REMOVED";
    
    private Hashtable _indexStats = new Hashtable();

    /* (non-Javadoc)
     * @see net.sf.iquiver.event.EventProcessor#processEvent(java.util.EventObject)
     */
    public void processEvent( EventObject evt )
    {
        Map store = null;
        
        if (evt instanceof IndexAdditionEvent)
        {
            IndexAdditionEvent iaEvt = (IndexAdditionEvent)evt;
            store = getStore( iaEvt.getIndex() );
            
            int count = safeIntegerToInt( (Integer)_indexStats.get( DOCUMENTS_ADDED ) );
            count++;
            _indexStats.put(DOCUMENTS_ADDED, new Integer( count) );
            
            count = safeIntegerToInt( (Integer)store.get( DOCUMENTS_ADDED ) );
            count++;
            store.put(DOCUMENTS_ADDED, new Integer( count) );                        
        }
        else if (evt instanceof IndexDeletionEvent)
        {
            IndexDeletionEvent idEvt = (IndexDeletionEvent)evt;
            store = getStore( idEvt.getIndex() );
            int count = safeIntegerToInt( (Integer)_indexStats.get( DOCUMENTS_REMOVED ) );
            count++;
            _indexStats.put(DOCUMENTS_REMOVED, new Integer( count) );
            
            count = safeIntegerToInt( (Integer)store.get( DOCUMENTS_REMOVED ) );
            count++;
            store.put(DOCUMENTS_REMOVED, new Integer( count) );            
        }
        else
        {
            throw new IllegalArgumentException(
                    "The given EventObject must be either an instance of IndexAdditionEvent or IndexDeletionEvent!" );
        }
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.util.XmlSerializable#toXml()
     */
    public String toXml()
    {
        return ObjectSerializer.objectToXml( _indexStats );
    }
    
    private Map getStore( String name )
    {
        Map store = (Map)_indexStats.get( name );
        if( store == null )
        {
            store = new HashMap();
            _indexStats.put( name, store );
        }
        
        return store;        
    }
    
    private int safeIntegerToInt( Integer number )
    {
        return number != null ? number.intValue() : 0;
    }    
}