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
 * [Thu Jul 08 20:48:16 CEST 2004]
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to UserGroupLnk
 */
public abstract class BaseUserGroupLnk extends BaseObject
{
    /** The Peer class */
    private static final UserGroupLnkPeer peer =
        new UserGroupLnkPeer();

        
    /** The value for the userGroupId field */
    private long userGroupId;
      
    /** The value for the userId field */
    private long userId;
  
    
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
    public void setUserGroupId(long v) throws TorqueException
    {
    
                  if (this.userGroupId != v)
              {
            this.userGroupId = v;
            setModified(true);
        }
    
                          
                if (aUserGroup != null && !(aUserGroup.getUserGroupId() == v))
                {
            aUserGroup = null;
        }
      
              }
  
    /**
     * Get the UserId
     *
     * @return long
     */
    public long getUserId()
    {
        return userId;
    }

                              
    /**
     * Set the value of UserId
     *
     * @param v new value
     */
    public void setUserId(long v) throws TorqueException
    {
    
                  if (this.userId != v)
              {
            this.userId = v;
            setModified(true);
        }
    
                          
                if (aUser != null && !(aUser.getUserId() == v))
                {
            aUser = null;
        }
      
              }
  
      
    
                  
    
        private UserGroup aUserGroup;

    /**
     * Declares an association between this object and a UserGroup object
     *
     * @param v UserGroup
     * @throws TorqueException
     */
    public void setUserGroup(UserGroup v) throws TorqueException
    {
            if (v == null)
        {
                    setUserGroupId(0);
                  }
        else
        {
            setUserGroupId(v.getUserGroupId());
        }
                aUserGroup = v;
    }

                                            
    /**
     * Get the associated UserGroup object
     *
     * @return the associated UserGroup object
     * @throws TorqueException
     */
    public UserGroup getUserGroup() throws TorqueException
    {
        if (aUserGroup == null && (this.userGroupId > 0))
        {
                          aUserGroup = UserGroupPeer.retrieveByPK(SimpleKey.keyFor(this.userGroupId));
              
            /* The following can be used instead of the line above to
               guarantee the related object contains a reference
               to this object, but this level of coupling
               may be undesirable in many circumstances.
               As it can lead to a db query with many results that may
               never be used.
               UserGroup obj = UserGroupPeer.retrieveByPK(this.userGroupId);
               obj.addUserGroupLnks(this);
            */
        }
        return aUserGroup;
    }

    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey.  e.g.
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
           */
    public void setUserGroupKey(ObjectKey key) throws TorqueException
    {
      
                        setUserGroupId(((NumberKey) key).longValue());
                  }
    
    
                  
    
        private User aUser;

    /**
     * Declares an association between this object and a User object
     *
     * @param v User
     * @throws TorqueException
     */
    public void setUser(User v) throws TorqueException
    {
            if (v == null)
        {
                    setUserId(0);
                  }
        else
        {
            setUserId(v.getUserId());
        }
                aUser = v;
    }

                                            
    /**
     * Get the associated User object
     *
     * @return the associated User object
     * @throws TorqueException
     */
    public User getUser() throws TorqueException
    {
        if (aUser == null && (this.userId > 0))
        {
                          aUser = UserPeer.retrieveByPK(SimpleKey.keyFor(this.userId));
              
            /* The following can be used instead of the line above to
               guarantee the related object contains a reference
               to this object, but this level of coupling
               may be undesirable in many circumstances.
               As it can lead to a db query with many results that may
               never be used.
               User obj = UserPeer.retrieveByPK(this.userId);
               obj.addUserGroupLnks(this);
            */
        }
        return aUser;
    }

    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey.  e.g.
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
           */
    public void setUserKey(ObjectKey key) throws TorqueException
    {
      
                        setUserId(((NumberKey) key).longValue());
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
              fieldNames.add("UserId");
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
          if (name.equals("UserId"))
        {
                return new Long(getUserId());
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
          if (name.equals(UserGroupLnkPeer.USER_GROUP_ID))
        {
                return new Long(getUserGroupId());
            }
          if (name.equals(UserGroupLnkPeer.USER_ID))
        {
                return new Long(getUserId());
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
                return new Long(getUserId());
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
          save(UserGroupLnkPeer.getMapBuilder()
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
                    UserGroupLnkPeer.doInsert((UserGroupLnk) this, con);
                    setNew(false);
                }
                else
                {
                    UserGroupLnkPeer.doUpdate((UserGroupLnk) this, con);
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
                        setUserId(((NumberKey)keys[1]).longValue());
              }

    /**
     * Set the PrimaryKey using SimpleKeys.
     *
         * @param long userGroupId
         * @param long userId
         */
    public void setPrimaryKey( long userGroupId, long userId)
        throws TorqueException
    {
            setUserGroupId(userGroupId);
            setUserId(userId);
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
                  pks[1] = SimpleKey.keyFor(getUserId());
                  return comboPK;
      }

 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
       * It then fills all the association collections and sets the
     * related objects to isNew=true.
       */
      public UserGroupLnk copy() throws TorqueException
    {
        return copyInto(new UserGroupLnk());
    }
  
    protected UserGroupLnk copyInto(UserGroupLnk copyObj) throws TorqueException
    {
          copyObj.setUserGroupId(userGroupId);
          copyObj.setUserId(userId);
  
                    copyObj.setUserGroupId(0);
                              copyObj.setUserId(0);
            
        
        return copyObj;
    }

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public UserGroupLnkPeer getPeer()
    {
        return peer;
    }

    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("UserGroupLnk:\n");
        str.append("UserGroupId = ")
           .append(getUserGroupId())
           .append("\n");
        str.append("UserId = ")
           .append(getUserId())
           .append("\n");
        return(str.toString());
    }
}
