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
 * extended all references should be to UserGroupPermissionLnk
 */
public abstract class BaseUserGroupPermissionLnk extends BaseObject
{
    /** The Peer class */
    private static final UserGroupPermissionLnkPeer peer =
        new UserGroupPermissionLnkPeer();

        
    /** The value for the userGroupId field */
    private long userGroupId;
      
    /** The value for the permissionId field */
    private int permissionId;
      
    /** The value for the isNegation field */
    private boolean isNegation;
  
    
    /**
     * Get the UserGroupId
     *
     * @return long
     */
    public long getUserGroupId()
    {
        return userGroupId;
    }

                        
    /**
     * Set the value of UserGroupId
     *
     * @param v new value
     */
    public void setUserGroupId(long v) 
    {
    
                  if (this.userGroupId != v)
              {
            this.userGroupId = v;
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
  
    /**
     * Get the IsNegation
     *
     * @return boolean
     */
    public boolean getIsNegation()
    {
        return isNegation;
    }

                        
    /**
     * Set the value of IsNegation
     *
     * @param v new value
     */
    public void setIsNegation(boolean v) 
    {
    
                  if (this.isNegation != v)
              {
            this.isNegation = v;
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
              fieldNames.add("UserGroupId");
              fieldNames.add("PermissionId");
              fieldNames.add("IsNegation");
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
          if (name.equals("UserGroupId"))
        {
                return new Long(getUserGroupId());
            }
          if (name.equals("PermissionId"))
        {
                return new Integer(getPermissionId());
            }
          if (name.equals("IsNegation"))
        {
                return new Boolean(getIsNegation());
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
          if (name.equals(UserGroupPermissionLnkPeer.USER_GROUP_ID))
        {
                return new Long(getUserGroupId());
            }
          if (name.equals(UserGroupPermissionLnkPeer.PERMISSION_ID))
        {
                return new Integer(getPermissionId());
            }
          if (name.equals(UserGroupPermissionLnkPeer.IS_NEGATION))
        {
                return new Boolean(getIsNegation());
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
                return new Long(getUserGroupId());
            }
              if (pos == 1)
        {
                return new Integer(getPermissionId());
            }
              if (pos == 2)
        {
                return new Boolean(getIsNegation());
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
          save(UserGroupPermissionLnkPeer.getMapBuilder()
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
                    UserGroupPermissionLnkPeer.doInsert((UserGroupPermissionLnk) this, con);
                    setNew(false);
                }
                else
                {
                    UserGroupPermissionLnkPeer.doUpdate((UserGroupPermissionLnk) this, con);
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
                      setUserGroupId(((NumberKey)keys[0]).longValue());
                        setPermissionId(((NumberKey)keys[1]).intValue());
              }

    /**
     * Set the PrimaryKey using SimpleKeys.
     *
         * @param long userGroupId
         * @param int permissionId
         */
    public void setPrimaryKey( long userGroupId, int permissionId)
        
    {
            setUserGroupId(userGroupId);
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
              pks[0] = SimpleKey.keyFor(getUserGroupId());
                  pks[1] = SimpleKey.keyFor(getPermissionId());
                  return comboPK;
      }

 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
       * It then fills all the association collections and sets the
     * related objects to isNew=true.
       */
      public UserGroupPermissionLnk copy() throws TorqueException
    {
        return copyInto(new UserGroupPermissionLnk());
    }
  
    protected UserGroupPermissionLnk copyInto(UserGroupPermissionLnk copyObj) throws TorqueException
    {
          copyObj.setUserGroupId(userGroupId);
          copyObj.setPermissionId(permissionId);
          copyObj.setIsNegation(isNegation);
  
                    copyObj.setUserGroupId(0);
                              copyObj.setPermissionId(0);
                  
        
        return copyObj;
    }

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public UserGroupPermissionLnkPeer getPeer()
    {
        return peer;
    }

    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("UserGroupPermissionLnk:\n");
        str.append("UserGroupId = ")
           .append(getUserGroupId())
           .append("\n");
        str.append("PermissionId = ")
           .append(getPermissionId())
           .append("\n");
        str.append("IsNegation = ")
           .append(getIsNegation())
           .append("\n");
        return(str.toString());
    }
}
