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
 * [Sun Jul 11 21:19:50 CEST 2004]
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to UserContentSourceLnk
 */
public abstract class BaseUserContentSourceLnk extends BaseObject
{
    /** The Peer class */
    private static final UserContentSourceLnkPeer peer =
        new UserContentSourceLnkPeer();

        
    /** The value for the userId field */
    private long userId;
      
    /** The value for the contentSourceId field */
    private long contentSourceId;
  
    
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
  
    /**
     * Get the ContentSourceId
     *
     * @return long
     */
    public long getContentSourceId()
    {
        return contentSourceId;
    }

                              
    /**
     * Set the value of ContentSourceId
     *
     * @param v new value
     */
    public void setContentSourceId(long v) throws TorqueException
    {
    
                  if (this.contentSourceId != v)
              {
            this.contentSourceId = v;
            setModified(true);
        }
    
                          
                if (aContentSource != null && !(aContentSource.getContentSourceId() == v))
                {
            aContentSource = null;
        }
      
              }
  
      
    
                  
    
        private ContentSource aContentSource;

    /**
     * Declares an association between this object and a ContentSource object
     *
     * @param v ContentSource
     * @throws TorqueException
     */
    public void setContentSource(ContentSource v) throws TorqueException
    {
            if (v == null)
        {
                    setContentSourceId(0);
                  }
        else
        {
            setContentSourceId(v.getContentSourceId());
        }
                aContentSource = v;
    }

                                            
    /**
     * Get the associated ContentSource object
     *
     * @return the associated ContentSource object
     * @throws TorqueException
     */
    public ContentSource getContentSource() throws TorqueException
    {
        if (aContentSource == null && (this.contentSourceId > 0))
        {
                          aContentSource = ContentSourcePeer.retrieveByPK(SimpleKey.keyFor(this.contentSourceId));
              
            /* The following can be used instead of the line above to
               guarantee the related object contains a reference
               to this object, but this level of coupling
               may be undesirable in many circumstances.
               As it can lead to a db query with many results that may
               never be used.
               ContentSource obj = ContentSourcePeer.retrieveByPK(this.contentSourceId);
               obj.addUserContentSourceLnks(this);
            */
        }
        return aContentSource;
    }

    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey.  e.g.
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
           */
    public void setContentSourceKey(ObjectKey key) throws TorqueException
    {
      
                        setContentSourceId(((NumberKey) key).longValue());
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
               obj.addUserContentSourceLnks(this);
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
              fieldNames.add("UserId");
              fieldNames.add("ContentSourceId");
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
          if (name.equals("UserId"))
        {
                return new Long(getUserId());
            }
          if (name.equals("ContentSourceId"))
        {
                return new Long(getContentSourceId());
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
          if (name.equals(UserContentSourceLnkPeer.USER_ID))
        {
                return new Long(getUserId());
            }
          if (name.equals(UserContentSourceLnkPeer.CONTENT_SOURCE_ID))
        {
                return new Long(getContentSourceId());
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
                return new Long(getUserId());
            }
              if (pos == 1)
        {
                return new Long(getContentSourceId());
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
          save(UserContentSourceLnkPeer.getMapBuilder()
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
                    UserContentSourceLnkPeer.doInsert((UserContentSourceLnk) this, con);
                    setNew(false);
                }
                else
                {
                    UserContentSourceLnkPeer.doUpdate((UserContentSourceLnk) this, con);
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
                      setUserId(((NumberKey)keys[0]).longValue());
                        setContentSourceId(((NumberKey)keys[1]).longValue());
              }

    /**
     * Set the PrimaryKey using SimpleKeys.
     *
         * @param long userId
         * @param long contentSourceId
         */
    public void setPrimaryKey( long userId, long contentSourceId)
        throws TorqueException
    {
            setUserId(userId);
            setContentSourceId(contentSourceId);
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
              pks[0] = SimpleKey.keyFor(getUserId());
                  pks[1] = SimpleKey.keyFor(getContentSourceId());
                  return comboPK;
      }

 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
       * It then fills all the association collections and sets the
     * related objects to isNew=true.
       */
      public UserContentSourceLnk copy() throws TorqueException
    {
        return copyInto(new UserContentSourceLnk());
    }
  
    protected UserContentSourceLnk copyInto(UserContentSourceLnk copyObj) throws TorqueException
    {
          copyObj.setUserId(userId);
          copyObj.setContentSourceId(contentSourceId);
  
                    copyObj.setUserId(0);
                              copyObj.setContentSourceId(0);
            
        
        return copyObj;
    }

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public UserContentSourceLnkPeer getPeer()
    {
        return peer;
    }

    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("UserContentSourceLnk:\n");
        str.append("UserId = ")
           .append(getUserId())
           .append("\n");
        str.append("ContentSourceId = ")
           .append(getContentSourceId())
           .append("\n");
        return(str.toString());
    }
}
