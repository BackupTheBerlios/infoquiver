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
 * [Sat Jul 10 18:13:33 CEST 2004]
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to ClientPermissionLnk
 */
public abstract class BaseClientPermissionLnk extends BaseObject
{
    /** The Peer class */
    private static final ClientPermissionLnkPeer peer =
        new ClientPermissionLnkPeer();

        
    /** The value for the clientId field */
    private int clientId;
      
    /** The value for the permissionId field */
    private int permissionId;
  
    
    /**
     * Get the ClientId
     *
     * @return int
     */
    public int getClientId()
    {
        return clientId;
    }

                        
    /**
     * Set the value of ClientId
     *
     * @param v new value
     */
    public void setClientId(int v) 
    {
    
                  if (this.clientId != v)
              {
            this.clientId = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the PermissionId
     *
     * @return int
     */
    public int getPermissionId()
    {
        return permissionId;
    }

                        
    /**
     * Set the value of PermissionId
     *
     * @param v new value
     */
    public void setPermissionId(int v) 
    {
    
                  if (this.permissionId != v)
              {
            this.permissionId = v;
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
              fieldNames.add("ClientId");
              fieldNames.add("PermissionId");
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
          if (name.equals("ClientId"))
        {
                return new Integer(getClientId());
            }
          if (name.equals("PermissionId"))
        {
                return new Integer(getPermissionId());
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
          if (name.equals(ClientPermissionLnkPeer.CLIENT_ID))
        {
                return new Integer(getClientId());
            }
          if (name.equals(ClientPermissionLnkPeer.PERMISSION_ID))
        {
                return new Integer(getPermissionId());
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
                return new Integer(getClientId());
            }
              if (pos == 1)
        {
                return new Integer(getPermissionId());
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
          save(ClientPermissionLnkPeer.getMapBuilder()
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
                    ClientPermissionLnkPeer.doInsert((ClientPermissionLnk) this, con);
                    setNew(false);
                }
                else
                {
                    ClientPermissionLnkPeer.doUpdate((ClientPermissionLnk) this, con);
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
                      setClientId(((NumberKey)keys[0]).intValue());
                        setPermissionId(((NumberKey)keys[1]).intValue());
              }

    /**
     * Set the PrimaryKey using SimpleKeys.
     *
         * @param int clientId
         * @param int permissionId
         */
    public void setPrimaryKey( int clientId, int permissionId)
        
    {
            setClientId(clientId);
            setPermissionId(permissionId);
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
              pks[0] = SimpleKey.keyFor(getClientId());
                  pks[1] = SimpleKey.keyFor(getPermissionId());
                  return comboPK;
      }

 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
       * It then fills all the association collections and sets the
     * related objects to isNew=true.
       */
      public ClientPermissionLnk copy() throws TorqueException
    {
        return copyInto(new ClientPermissionLnk());
    }
  
    protected ClientPermissionLnk copyInto(ClientPermissionLnk copyObj) throws TorqueException
    {
          copyObj.setClientId(clientId);
          copyObj.setPermissionId(permissionId);
  
                    copyObj.setClientId(0);
                              copyObj.setPermissionId(0);
            
        
        return copyObj;
    }

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public ClientPermissionLnkPeer getPeer()
    {
        return peer;
    }

    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("ClientPermissionLnk:\n");
        str.append("ClientId = ")
           .append(getClientId())
           .append("\n");
        str.append("PermissionId = ")
           .append(getPermissionId())
           .append("\n");
        return(str.toString());
    }
}
