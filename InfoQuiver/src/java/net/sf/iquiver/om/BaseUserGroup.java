package net.sf.iquiver.om;


import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.torque.TorqueException;
import org.apache.torque.om.BaseObject;
import org.apache.torque.om.ComboKey;
import org.apache.torque.om.DateKey;
import org.apache.torque.om.NumberKey;
import org.apache.torque.om.ObjectKey;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.om.StringKey;
import org.apache.torque.om.Persistent;
import org.apache.torque.util.Criteria;
import org.apache.torque.util.Transaction;

  
  
/**
 * This class was autogenerated by Torque on:
 *
 * [Sat Apr 03 15:42:57 CEST 2004]
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to UserGroup
 */
public abstract class BaseUserGroup extends BaseObject
{
    /** The Peer class */
    private static final UserGroupPeer peer =
        new UserGroupPeer();

        
    /** The value for the userGroupId field */
    private long userGroupId;
      
    /** The value for the userGroupName field */
    private String userGroupName;
      
    /** The value for the userGroupDesc field */
    private String userGroupDesc;
      
    /** The value for the clientId field */
    private int clientId;
  
    
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
    
          
                                  
        // update associated UserGroupLnk
        if (collUserGroupLnks != null)
        {
            for (int i = 0; i < collUserGroupLnks.size(); i++)
            {
                ((UserGroupLnk) collUserGroupLnks.get(i))
                    .setUserGroupId(v);
            }
        }
                                          
        // update associated UserGroupClientLnk
        if (collUserGroupClientLnks != null)
        {
            for (int i = 0; i < collUserGroupClientLnks.size(); i++)
            {
                ((UserGroupClientLnk) collUserGroupClientLnks.get(i))
                    .setUserGroupId(v);
            }
        }
                      }
  
    /**
     * Get the UserGroupName
     *
     * @return String
     */
    public String getUserGroupName()
    {
        return userGroupName;
    }

                        
    /**
     * Set the value of UserGroupName
     *
     * @param v new value
     */
    public void setUserGroupName(String v) 
    {
    
                  if (!ObjectUtils.equals(this.userGroupName, v))
              {
            this.userGroupName = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the UserGroupDesc
     *
     * @return String
     */
    public String getUserGroupDesc()
    {
        return userGroupDesc;
    }

                        
    /**
     * Set the value of UserGroupDesc
     *
     * @param v new value
     */
    public void setUserGroupDesc(String v) 
    {
    
                  if (!ObjectUtils.equals(this.userGroupDesc, v))
              {
            this.userGroupDesc = v;
            setModified(true);
        }
    
          
              }
  
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
    public void setClientId(int v) throws TorqueException
    {
    
                  if (this.clientId != v)
              {
            this.clientId = v;
            setModified(true);
        }
    
                          
                if (aClient != null && !(aClient.getClientId() == v))
                {
            aClient = null;
        }
      
              }
  
      
    
                  
    
        private Client aClient;

    /**
     * Declares an association between this object and a Client object
     *
     * @param v Client
     * @throws TorqueException
     */
    public void setClient(Client v) throws TorqueException
    {
            if (v == null)
        {
                    setClientId(0);
                  }
        else
        {
            setClientId(v.getClientId());
        }
                aClient = v;
    }

                                            
    /**
     * Get the associated Client object
     *
     * @return the associated Client object
     * @throws TorqueException
     */
    public Client getClient() throws TorqueException
    {
        if (aClient == null && (this.clientId > 0))
        {
                          aClient = ClientPeer.retrieveByPK(SimpleKey.keyFor(this.clientId));
              
            /* The following can be used instead of the line above to
               guarantee the related object contains a reference
               to this object, but this level of coupling
               may be undesirable in many circumstances.
               As it can lead to a db query with many results that may
               never be used.
               Client obj = ClientPeer.retrieveByPK(this.clientId);
               obj.addUserGroups(this);
            */
        }
        return aClient;
    }

    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey.  e.g.
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
           */
    public void setClientKey(ObjectKey key) throws TorqueException
    {
      
                        setClientId(((NumberKey) key).intValue());
                  }
       
                                
            
    /**
     * Collection to store aggregation of collUserGroupLnks
     */
    protected List collUserGroupLnks;

    /**
     * Temporary storage of collUserGroupLnks to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initUserGroupLnks()
    {
        if (collUserGroupLnks == null)
        {
            collUserGroupLnks = new ArrayList();
        }
    }

    /**
     * Method called to associate a UserGroupLnk object to this object
     * through the UserGroupLnk foreign key attribute
     *
     * @param l UserGroupLnk
     * @throws TorqueException
     */
    public void addUserGroupLnk(UserGroupLnk l) throws TorqueException
    {
        getUserGroupLnks().add(l);
        l.setUserGroup((UserGroup) this);
    }

    /**
     * The criteria used to select the current contents of collUserGroupLnks
     */
    private Criteria lastUserGroupLnksCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getUserGroupLnks(new Criteria())
     *
     * @throws TorqueException
     */
    public List getUserGroupLnks() throws TorqueException
    {
        if (collUserGroupLnks == null)
        {
            collUserGroupLnks = getUserGroupLnks(new Criteria(10));
        }
        return collUserGroupLnks;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this UserGroup has previously
     * been saved, it will retrieve related UserGroupLnks from storage.
     * If this UserGroup is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List getUserGroupLnks(Criteria criteria) throws TorqueException
    {
        if (collUserGroupLnks == null)
        {
            if (isNew())
            {
               collUserGroupLnks = new ArrayList();
            }
            else
            {
                      criteria.add(UserGroupLnkPeer.USER_GROUP_ID, getUserGroupId() );
                      collUserGroupLnks = UserGroupLnkPeer.doSelect(criteria);
            }
        }
        else
        {
            // criteria has no effect for a new object
            if (!isNew())
            {
                // the following code is to determine if a new query is
                // called for.  If the criteria is the same as the last
                // one, just return the collection.
                      criteria.add(UserGroupLnkPeer.USER_GROUP_ID, getUserGroupId());
                      if (!lastUserGroupLnksCriteria.equals(criteria))
                {
                    collUserGroupLnks = UserGroupLnkPeer.doSelect(criteria);
                }
            }
        }
        lastUserGroupLnksCriteria = criteria;

        return collUserGroupLnks;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getUserGroupLnks(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List getUserGroupLnks(Connection con) throws TorqueException
    {
        if (collUserGroupLnks == null)
        {
            collUserGroupLnks = getUserGroupLnks(new Criteria(10), con);
        }
        return collUserGroupLnks;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this UserGroup has previously
     * been saved, it will retrieve related UserGroupLnks from storage.
     * If this UserGroup is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List getUserGroupLnks(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collUserGroupLnks == null)
        {
            if (isNew())
            {
               collUserGroupLnks = new ArrayList();
            }
            else
            {
                       criteria.add(UserGroupLnkPeer.USER_GROUP_ID, getUserGroupId());
                       collUserGroupLnks = UserGroupLnkPeer.doSelect(criteria, con);
             }
         }
         else
         {
             // criteria has no effect for a new object
             if (!isNew())
             {
                 // the following code is to determine if a new query is
                 // called for.  If the criteria is the same as the last
                 // one, just return the collection.
                       criteria.add(UserGroupLnkPeer.USER_GROUP_ID, getUserGroupId());
                       if (!lastUserGroupLnksCriteria.equals(criteria))
                 {
                     collUserGroupLnks = UserGroupLnkPeer.doSelect(criteria, con);
                 }
             }
         }
         lastUserGroupLnksCriteria = criteria;

         return collUserGroupLnks;
     }

                        
              
                    
                              
                                
                                                              
                                        
                    
                    
          
    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this UserGroup is new, it will return
     * an empty collection; or if this UserGroup has previously
     * been saved, it will retrieve related UserGroupLnks from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in UserGroup.
     */
    protected List getUserGroupLnksJoinUserGroup(Criteria criteria)
        throws TorqueException
    {
        if (collUserGroupLnks == null)
        {
            if (isNew())
            {
               collUserGroupLnks = new ArrayList();
            }
            else
            {
                            criteria.add(UserGroupLnkPeer.USER_GROUP_ID, getUserGroupId());
                            collUserGroupLnks = UserGroupLnkPeer.doSelectJoinUserGroup(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            boolean newCriteria = true;
                        criteria.add(UserGroupLnkPeer.USER_GROUP_ID, getUserGroupId());
                        if (!lastUserGroupLnksCriteria.equals(criteria))
            {
                collUserGroupLnks = UserGroupLnkPeer.doSelectJoinUserGroup(criteria);
            }
        }
        lastUserGroupLnksCriteria = criteria;

        return collUserGroupLnks;
    }
                  
                    
                    
                                
                                                              
                                        
                    
                    
          
    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this UserGroup is new, it will return
     * an empty collection; or if this UserGroup has previously
     * been saved, it will retrieve related UserGroupLnks from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in UserGroup.
     */
    protected List getUserGroupLnksJoinUser(Criteria criteria)
        throws TorqueException
    {
        if (collUserGroupLnks == null)
        {
            if (isNew())
            {
               collUserGroupLnks = new ArrayList();
            }
            else
            {
                            criteria.add(UserGroupLnkPeer.USER_GROUP_ID, getUserGroupId());
                            collUserGroupLnks = UserGroupLnkPeer.doSelectJoinUser(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            boolean newCriteria = true;
                        criteria.add(UserGroupLnkPeer.USER_GROUP_ID, getUserGroupId());
                        if (!lastUserGroupLnksCriteria.equals(criteria))
            {
                collUserGroupLnks = UserGroupLnkPeer.doSelectJoinUser(criteria);
            }
        }
        lastUserGroupLnksCriteria = criteria;

        return collUserGroupLnks;
    }
                            


                          
            
    /**
     * Collection to store aggregation of collUserGroupClientLnks
     */
    protected List collUserGroupClientLnks;

    /**
     * Temporary storage of collUserGroupClientLnks to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initUserGroupClientLnks()
    {
        if (collUserGroupClientLnks == null)
        {
            collUserGroupClientLnks = new ArrayList();
        }
    }

    /**
     * Method called to associate a UserGroupClientLnk object to this object
     * through the UserGroupClientLnk foreign key attribute
     *
     * @param l UserGroupClientLnk
     * @throws TorqueException
     */
    public void addUserGroupClientLnk(UserGroupClientLnk l) throws TorqueException
    {
        getUserGroupClientLnks().add(l);
        l.setUserGroup((UserGroup) this);
    }

    /**
     * The criteria used to select the current contents of collUserGroupClientLnks
     */
    private Criteria lastUserGroupClientLnksCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getUserGroupClientLnks(new Criteria())
     *
     * @throws TorqueException
     */
    public List getUserGroupClientLnks() throws TorqueException
    {
        if (collUserGroupClientLnks == null)
        {
            collUserGroupClientLnks = getUserGroupClientLnks(new Criteria(10));
        }
        return collUserGroupClientLnks;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this UserGroup has previously
     * been saved, it will retrieve related UserGroupClientLnks from storage.
     * If this UserGroup is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List getUserGroupClientLnks(Criteria criteria) throws TorqueException
    {
        if (collUserGroupClientLnks == null)
        {
            if (isNew())
            {
               collUserGroupClientLnks = new ArrayList();
            }
            else
            {
                      criteria.add(UserGroupClientLnkPeer.USER_GROUP_ID, getUserGroupId() );
                      collUserGroupClientLnks = UserGroupClientLnkPeer.doSelect(criteria);
            }
        }
        else
        {
            // criteria has no effect for a new object
            if (!isNew())
            {
                // the following code is to determine if a new query is
                // called for.  If the criteria is the same as the last
                // one, just return the collection.
                      criteria.add(UserGroupClientLnkPeer.USER_GROUP_ID, getUserGroupId());
                      if (!lastUserGroupClientLnksCriteria.equals(criteria))
                {
                    collUserGroupClientLnks = UserGroupClientLnkPeer.doSelect(criteria);
                }
            }
        }
        lastUserGroupClientLnksCriteria = criteria;

        return collUserGroupClientLnks;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getUserGroupClientLnks(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List getUserGroupClientLnks(Connection con) throws TorqueException
    {
        if (collUserGroupClientLnks == null)
        {
            collUserGroupClientLnks = getUserGroupClientLnks(new Criteria(10), con);
        }
        return collUserGroupClientLnks;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this UserGroup has previously
     * been saved, it will retrieve related UserGroupClientLnks from storage.
     * If this UserGroup is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List getUserGroupClientLnks(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collUserGroupClientLnks == null)
        {
            if (isNew())
            {
               collUserGroupClientLnks = new ArrayList();
            }
            else
            {
                       criteria.add(UserGroupClientLnkPeer.USER_GROUP_ID, getUserGroupId());
                       collUserGroupClientLnks = UserGroupClientLnkPeer.doSelect(criteria, con);
             }
         }
         else
         {
             // criteria has no effect for a new object
             if (!isNew())
             {
                 // the following code is to determine if a new query is
                 // called for.  If the criteria is the same as the last
                 // one, just return the collection.
                       criteria.add(UserGroupClientLnkPeer.USER_GROUP_ID, getUserGroupId());
                       if (!lastUserGroupClientLnksCriteria.equals(criteria))
                 {
                     collUserGroupClientLnks = UserGroupClientLnkPeer.doSelect(criteria, con);
                 }
             }
         }
         lastUserGroupClientLnksCriteria = criteria;

         return collUserGroupClientLnks;
     }

                        
              
                    
                    
                                
                                                              
                                        
                    
                    
          
    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this UserGroup is new, it will return
     * an empty collection; or if this UserGroup has previously
     * been saved, it will retrieve related UserGroupClientLnks from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in UserGroup.
     */
    protected List getUserGroupClientLnksJoinClient(Criteria criteria)
        throws TorqueException
    {
        if (collUserGroupClientLnks == null)
        {
            if (isNew())
            {
               collUserGroupClientLnks = new ArrayList();
            }
            else
            {
                            criteria.add(UserGroupClientLnkPeer.USER_GROUP_ID, getUserGroupId());
                            collUserGroupClientLnks = UserGroupClientLnkPeer.doSelectJoinClient(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            boolean newCriteria = true;
                        criteria.add(UserGroupClientLnkPeer.USER_GROUP_ID, getUserGroupId());
                        if (!lastUserGroupClientLnksCriteria.equals(criteria))
            {
                collUserGroupClientLnks = UserGroupClientLnkPeer.doSelectJoinClient(criteria);
            }
        }
        lastUserGroupClientLnksCriteria = criteria;

        return collUserGroupClientLnks;
    }
                  
                    
                              
                                
                                                              
                                        
                    
                    
          
    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this UserGroup is new, it will return
     * an empty collection; or if this UserGroup has previously
     * been saved, it will retrieve related UserGroupClientLnks from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in UserGroup.
     */
    protected List getUserGroupClientLnksJoinUserGroup(Criteria criteria)
        throws TorqueException
    {
        if (collUserGroupClientLnks == null)
        {
            if (isNew())
            {
               collUserGroupClientLnks = new ArrayList();
            }
            else
            {
                            criteria.add(UserGroupClientLnkPeer.USER_GROUP_ID, getUserGroupId());
                            collUserGroupClientLnks = UserGroupClientLnkPeer.doSelectJoinUserGroup(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            boolean newCriteria = true;
                        criteria.add(UserGroupClientLnkPeer.USER_GROUP_ID, getUserGroupId());
                        if (!lastUserGroupClientLnksCriteria.equals(criteria))
            {
                collUserGroupClientLnks = UserGroupClientLnkPeer.doSelectJoinUserGroup(criteria);
            }
        }
        lastUserGroupClientLnksCriteria = criteria;

        return collUserGroupClientLnks;
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
              fieldNames.add("UserGroupName");
              fieldNames.add("UserGroupDesc");
              fieldNames.add("ClientId");
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
          if (name.equals("UserGroupName"))
        {
                return getUserGroupName();
            }
          if (name.equals("UserGroupDesc"))
        {
                return getUserGroupDesc();
            }
          if (name.equals("ClientId"))
        {
                return new Integer(getClientId());
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
          if (name.equals(UserGroupPeer.USER_GROUP_ID))
        {
                return new Long(getUserGroupId());
            }
          if (name.equals(UserGroupPeer.USER_GROUP_NAME))
        {
                return getUserGroupName();
            }
          if (name.equals(UserGroupPeer.USER_GROUP_DESC))
        {
                return getUserGroupDesc();
            }
          if (name.equals(UserGroupPeer.CLIENT_ID))
        {
                return new Integer(getClientId());
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
                return getUserGroupName();
            }
              if (pos == 2)
        {
                return getUserGroupDesc();
            }
              if (pos == 3)
        {
                return new Integer(getClientId());
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
          save(UserGroupPeer.getMapBuilder()
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
                    UserGroupPeer.doInsert((UserGroup) this, con);
                    setNew(false);
                }
                else
                {
                    UserGroupPeer.doUpdate((UserGroup) this, con);
                }
            }

                                      
                
            if (collUserGroupLnks != null)
            {
                for (int i = 0; i < collUserGroupLnks.size(); i++)
                {
                    ((UserGroupLnk) collUserGroupLnks.get(i)).save(con);
                }
            }
                                          
                
            if (collUserGroupClientLnks != null)
            {
                for (int i = 0; i < collUserGroupClientLnks.size(); i++)
                {
                    ((UserGroupClientLnk) collUserGroupClientLnks.get(i)).save(con);
                }
            }
                          alreadyInSave = false;
        }
      }


                          
      /**
     * Set the PrimaryKey using ObjectKey.
     *
     * @param  userGroupId ObjectKey
     */
    public void setPrimaryKey(ObjectKey key)
        throws TorqueException
    {
            setUserGroupId(((NumberKey) key).longValue());
        }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) throws TorqueException
    {
            setUserGroupId(Long.parseLong(key));
        }

  
    /**
     * returns an id that differentiates this object from others
     * of its class.
     */
    public ObjectKey getPrimaryKey()
    {
          return SimpleKey.keyFor(getUserGroupId());
      }

 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
       * It then fills all the association collections and sets the
     * related objects to isNew=true.
       */
      public UserGroup copy() throws TorqueException
    {
        return copyInto(new UserGroup());
    }
  
    protected UserGroup copyInto(UserGroup copyObj) throws TorqueException
    {
          copyObj.setUserGroupId(userGroupId);
          copyObj.setUserGroupName(userGroupName);
          copyObj.setUserGroupDesc(userGroupDesc);
          copyObj.setClientId(clientId);
  
                    copyObj.setUserGroupId(0);
                              
                                      
                
        List v = getUserGroupLnks();
        for (int i = 0; i < v.size(); i++)
        {
            UserGroupLnk obj = (UserGroupLnk) v.get(i);
            copyObj.addUserGroupLnk(obj.copy());
        }
                                                  
                
        v = getUserGroupClientLnks();
        for (int i = 0; i < v.size(); i++)
        {
            UserGroupClientLnk obj = (UserGroupClientLnk) v.get(i);
            copyObj.addUserGroupClientLnk(obj.copy());
        }
                    
        return copyObj;
    }

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public UserGroupPeer getPeer()
    {
        return peer;
    }

    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("UserGroup:\n");
        str.append("UserGroupId = ")
           .append(getUserGroupId())
           .append("\n");
        str.append("UserGroupName = ")
           .append(getUserGroupName())
           .append("\n");
        str.append("UserGroupDesc = ")
           .append(getUserGroupDesc())
           .append("\n");
        str.append("ClientId = ")
           .append(getClientId())
           .append("\n");
        return(str.toString());
    }
}
