package net.sf.iquiver.om;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.torque.TorqueException;
import org.apache.torque.om.BaseObject;
import org.apache.torque.om.ComboKey;
import org.apache.torque.om.NumberKey;
import org.apache.torque.om.ObjectKey;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.util.Transaction;


/**
 * This class was autogenerated by Torque on:
 *
 * [Mon Jul 12 14:25:30 CEST 2004]
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to ContentSourceTypeTransportLnk
 */
public abstract class BaseContentSourceTypeTransportLnk extends BaseObject
{
    /** The Peer class */
    private static final ContentSourceTypeTransportLnkPeer peer =
        new ContentSourceTypeTransportLnkPeer();

        
    /** The value for the contentSourceTypeId field */
    private int contentSourceTypeId;
      
    /** The value for the transportId field */
    private int transportId;
  
    
    /**
     * Get the ContentSourceTypeId
     *
     * @return int
     */
    public int getContentSourceTypeId()
    {
        return contentSourceTypeId;
    }

                        
    /**
     * Set the value of ContentSourceTypeId
     *
     * @param v new value
     */
    public void setContentSourceTypeId(int v) 
    {
    
                  if (this.contentSourceTypeId != v)
              {
            this.contentSourceTypeId = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the TransportId
     *
     * @return int
     */
    public int getTransportId()
    {
        return transportId;
    }

                        
    /**
     * Set the value of TransportId
     *
     * @param v new value
     */
    public void setTransportId(int v) 
    {
    
                  if (this.transportId != v)
              {
            this.transportId = v;
            setModified(true);
        }
    
          
              }
  
         
                
    private static List fieldNames = null;

    /**
     * Generate a list of field names.
     *
     * @return a list of field names
     */
    public static synchronized List getFieldNames()
    {
        if (fieldNames == null)
        {
            fieldNames = new ArrayList();
              fieldNames.add("ContentSourceTypeId");
              fieldNames.add("TransportId");
              fieldNames = Collections.unmodifiableList(fieldNames);
        }
        return fieldNames;
    }

    /**
     * Retrieves a field from the object by name passed in as a String.
     *
     * @param name field name
     * @return value
     */
    public Object getByName(String name)
    {
          if (name.equals("ContentSourceTypeId"))
        {
                return new Integer(getContentSourceTypeId());
            }
          if (name.equals("TransportId"))
        {
                return new Integer(getTransportId());
            }
          return null;
    }
    
    /**
     * Retrieves a field from the object by name passed in
     * as a String.  The String must be one of the static
     * Strings defined in this Class' Peer.
     *
     * @param name peer name
     * @return value
     */
    public Object getByPeerName(String name)
    {
          if (name.equals(ContentSourceTypeTransportLnkPeer.CONTENT_SOURCE_TYPE_ID))
        {
                return new Integer(getContentSourceTypeId());
            }
          if (name.equals(ContentSourceTypeTransportLnkPeer.TRANSPORT_ID))
        {
                return new Integer(getTransportId());
            }
          return null;
    }

    /**
     * Retrieves a field from the object by Position as specified
     * in the xml schema.  Zero-based.
     *
     * @param pos position in xml schema
     * @return value
     */
    public Object getByPosition(int pos)
    {
            if (pos == 0)
        {
                return new Integer(getContentSourceTypeId());
            }
              if (pos == 1)
        {
                return new Integer(getTransportId());
            }
              return null;
    }
     
    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.
     *
     * @throws Exception
     */
    public void save() throws Exception
    {
          save(ContentSourceTypeTransportLnkPeer.getMapBuilder()
                .getDatabaseMap().getName());
      }

    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.
       * Note: this code is here because the method body is
     * auto-generated conditionally and therefore needs to be
     * in this file instead of in the super class, BaseObject.
       *
     * @param dbName
     * @throws TorqueException
     */
    public void save(String dbName) throws TorqueException
    {
        Connection con = null;
          try
        {
            con = Transaction.begin(dbName);
            save(con);
            Transaction.commit(con);
        }
        catch(TorqueException e)
        {
            Transaction.safeRollback(con);
            throw e;
        }
      }

      /** flag to prevent endless save loop, if this object is referenced
        by another object which falls in this transaction. */
    private boolean alreadyInSave = false;
      /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.  This method
     * is meant to be used as part of a transaction, otherwise use
     * the save() method and the connection details will be handled
     * internally
     *
     * @param con
     * @throws TorqueException
     */
    public void save(Connection con) throws TorqueException
    {
          if (!alreadyInSave)
        {
            alreadyInSave = true;


  
            // If this object has been modified, then save it to the database.
            if (isModified())
            {
                if (isNew())
                {
                    ContentSourceTypeTransportLnkPeer.doInsert((ContentSourceTypeTransportLnk) this, con);
                    setNew(false);
                }
                else
                {
                    ContentSourceTypeTransportLnkPeer.doUpdate((ContentSourceTypeTransportLnk) this, con);
                }
            }

                      alreadyInSave = false;
        }
      }


                                    
  
    private final SimpleKey[] pks = new SimpleKey[2];
    private final ComboKey comboPK = new ComboKey(pks);
    
    /**
     * Set the PrimaryKey with an ObjectKey
     *
     * @param key
     */
    public void setPrimaryKey(ObjectKey key) throws TorqueException
    {
        SimpleKey[] keys = (SimpleKey[]) key.getValue();
        SimpleKey tmpKey = null;
                      setContentSourceTypeId(((NumberKey)keys[0]).intValue());
                        setTransportId(((NumberKey)keys[1]).intValue());
              }

    /**
     * Set the PrimaryKey using SimpleKeys.
     *
         * @param int contentSourceTypeId
         * @param int transportId
         */
    public void setPrimaryKey( int contentSourceTypeId, int transportId)
        
    {
            setContentSourceTypeId(contentSourceTypeId);
            setTransportId(transportId);
        }

    /**
     * Set the PrimaryKey using a String.
     */
    public void setPrimaryKey(String key) throws TorqueException
    {
        setPrimaryKey(new ComboKey(key));
    }
  
    /**
     * returns an id that differentiates this object from others
     * of its class.
     */
    public ObjectKey getPrimaryKey()
    {
              pks[0] = SimpleKey.keyFor(getContentSourceTypeId());
                  pks[1] = SimpleKey.keyFor(getTransportId());
                  return comboPK;
      }

 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
       * It then fills all the association collections and sets the
     * related objects to isNew=true.
       */
      public ContentSourceTypeTransportLnk copy() throws TorqueException
    {
        return copyInto(new ContentSourceTypeTransportLnk());
    }
  
    protected ContentSourceTypeTransportLnk copyInto(ContentSourceTypeTransportLnk copyObj) throws TorqueException
    {
          copyObj.setContentSourceTypeId(contentSourceTypeId);
          copyObj.setTransportId(transportId);
  
                    copyObj.setContentSourceTypeId(0);
                              copyObj.setTransportId(0);
            
        
        return copyObj;
    }

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public ContentSourceTypeTransportLnkPeer getPeer()
    {
        return peer;
    }

    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("ContentSourceTypeTransportLnk:\n");
        str.append("ContentSourceTypeId = ")
           .append(getContentSourceTypeId())
           .append("\n");
        str.append("TransportId = ")
           .append(getTransportId())
           .append("\n");
        return(str.toString());
    }
}
