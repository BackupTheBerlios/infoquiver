package net.sf.iquiver.om;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.torque.TorqueException;
import org.apache.torque.om.BaseObject;
import org.apache.torque.om.NumberKey;
import org.apache.torque.om.ObjectKey;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.util.Criteria;
import org.apache.torque.util.Transaction;

  
    
  
/**
 * This class was autogenerated by Torque on:
 *
 * [Mon Jun 28 22:47:06 CEST 2004]
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to User
 */
public abstract class BaseUser extends BaseObject
{
    /** The Peer class */
    private static final UserPeer peer =
        new UserPeer();

        
    /** The value for the userId field */
    private long userId;
      
    /** The value for the userPassword field */
    private String userPassword;
      
    /** The value for the userLogin field */
    private String userLogin;
      
    /** The value for the userFirstName field */
    private String userFirstName;
      
    /** The value for the userMidName field */
    private String userMidName;
      
    /** The value for the userLastName field */
    private String userLastName;
      
    /** The value for the userGender field */
    private String userGender;
      
    /** The value for the userDateOfBirth field */
    private Date userDateOfBirth;
      
    /** The value for the userPicture field */
    private byte[] userPicture;
      
    /** The value for the addressId field */
    private long addressId;
      
    /** The value for the clientId field */
    private int clientId;
  
    
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
    
          
                                  
        // update associated UserGroupLnk
        if (collUserGroupLnks != null)
        {
            for (int i = 0; i < collUserGroupLnks.size(); i++)
            {
                ((UserGroupLnk) collUserGroupLnks.get(i))
                    .setUserId(v);
            }
        }
                      }
  
    /**
     * Get the UserPassword
     *
     * @return String
     */
    public String getUserPassword()
    {
        return userPassword;
    }

                        
    /**
     * Set the value of UserPassword
     *
     * @param v new value
     */
    public void setUserPassword(String v) 
    {
    
                  if (!ObjectUtils.equals(this.userPassword, v))
              {
            this.userPassword = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the UserLogin
     *
     * @return String
     */
    public String getUserLogin()
    {
        return userLogin;
    }

                        
    /**
     * Set the value of UserLogin
     *
     * @param v new value
     */
    public void setUserLogin(String v) 
    {
    
                  if (!ObjectUtils.equals(this.userLogin, v))
              {
            this.userLogin = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the UserFirstName
     *
     * @return String
     */
    public String getUserFirstName()
    {
        return userFirstName;
    }

                        
    /**
     * Set the value of UserFirstName
     *
     * @param v new value
     */
    public void setUserFirstName(String v) 
    {
    
                  if (!ObjectUtils.equals(this.userFirstName, v))
              {
            this.userFirstName = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the UserMidName
     *
     * @return String
     */
    public String getUserMidName()
    {
        return userMidName;
    }

                        
    /**
     * Set the value of UserMidName
     *
     * @param v new value
     */
    public void setUserMidName(String v) 
    {
    
                  if (!ObjectUtils.equals(this.userMidName, v))
              {
            this.userMidName = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the UserLastName
     *
     * @return String
     */
    public String getUserLastName()
    {
        return userLastName;
    }

                        
    /**
     * Set the value of UserLastName
     *
     * @param v new value
     */
    public void setUserLastName(String v) 
    {
    
                  if (!ObjectUtils.equals(this.userLastName, v))
              {
            this.userLastName = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the UserGender
     *
     * @return String
     */
    public String getUserGender()
    {
        return userGender;
    }

                        
    /**
     * Set the value of UserGender
     *
     * @param v new value
     */
    public void setUserGender(String v) 
    {
    
                  if (!ObjectUtils.equals(this.userGender, v))
              {
            this.userGender = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the UserDateOfBirth
     *
     * @return Date
     */
    public Date getUserDateOfBirth()
    {
        return userDateOfBirth;
    }

                        
    /**
     * Set the value of UserDateOfBirth
     *
     * @param v new value
     */
    public void setUserDateOfBirth(Date v) 
    {
    
                  if (!ObjectUtils.equals(this.userDateOfBirth, v))
              {
            this.userDateOfBirth = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the UserPicture
     *
     * @return byte[]
     */
    public byte[] getUserPicture()
    {
        return userPicture;
    }

                        
    /**
     * Set the value of UserPicture
     *
     * @param v new value
     */
    public void setUserPicture(byte[] v) 
    {
    
                  if (!ObjectUtils.equals(this.userPicture, v))
              {
            this.userPicture = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the AddressId
     *
     * @return long
     */
    public long getAddressId()
    {
        return addressId;
    }

                              
    /**
     * Set the value of AddressId
     *
     * @param v new value
     */
    public void setAddressId(long v) throws TorqueException
    {
    
                  if (this.addressId != v)
              {
            this.addressId = v;
            setModified(true);
        }
    
                          
                if (aAddress != null && !(aAddress.getAddressId() == v))
                {
            aAddress = null;
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
               obj.addUsers(this);
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
    
    
                  
    
        private Address aAddress;

    /**
     * Declares an association between this object and a Address object
     *
     * @param v Address
     * @throws TorqueException
     */
    public void setAddress(Address v) throws TorqueException
    {
            if (v == null)
        {
                    setAddressId(0);
                  }
        else
        {
            setAddressId(v.getAddressId());
        }
                aAddress = v;
    }

                                            
    /**
     * Get the associated Address object
     *
     * @return the associated Address object
     * @throws TorqueException
     */
    public Address getAddress() throws TorqueException
    {
        if (aAddress == null && (this.addressId > 0))
        {
                          aAddress = AddressPeer.retrieveByPK(SimpleKey.keyFor(this.addressId));
              
            /* The following can be used instead of the line above to
               guarantee the related object contains a reference
               to this object, but this level of coupling
               may be undesirable in many circumstances.
               As it can lead to a db query with many results that may
               never be used.
               Address obj = AddressPeer.retrieveByPK(this.addressId);
               obj.addUsers(this);
            */
        }
        return aAddress;
    }

    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey.  e.g.
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
           */
    public void setAddressKey(ObjectKey key) throws TorqueException
    {
      
                        setAddressId(((NumberKey) key).longValue());
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
        l.setUser((User) this);
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
     * Otherwise if this User has previously
     * been saved, it will retrieve related UserGroupLnks from storage.
     * If this User is new, it will return
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
                      criteria.add(UserGroupLnkPeer.USER_ID, getUserId() );
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
                      criteria.add(UserGroupLnkPeer.USER_ID, getUserId());
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
     * Otherwise if this User has previously
     * been saved, it will retrieve related UserGroupLnks from storage.
     * If this User is new, it will return
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
                       criteria.add(UserGroupLnkPeer.USER_ID, getUserId());
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
                       criteria.add(UserGroupLnkPeer.USER_ID, getUserId());
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
     * Otherwise if this User is new, it will return
     * an empty collection; or if this User has previously
     * been saved, it will retrieve related UserGroupLnks from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in User.
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
                            criteria.add(UserGroupLnkPeer.USER_ID, getUserId());
                            collUserGroupLnks = UserGroupLnkPeer.doSelectJoinUserGroup(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            boolean newCriteria = true;
                        criteria.add(UserGroupLnkPeer.USER_ID, getUserId());
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
     * Otherwise if this User is new, it will return
     * an empty collection; or if this User has previously
     * been saved, it will retrieve related UserGroupLnks from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in User.
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
                            criteria.add(UserGroupLnkPeer.USER_ID, getUserId());
                            collUserGroupLnks = UserGroupLnkPeer.doSelectJoinUser(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            boolean newCriteria = true;
                        criteria.add(UserGroupLnkPeer.USER_ID, getUserId());
                        if (!lastUserGroupLnksCriteria.equals(criteria))
            {
                collUserGroupLnks = UserGroupLnkPeer.doSelectJoinUser(criteria);
            }
        }
        lastUserGroupLnksCriteria = criteria;

        return collUserGroupLnks;
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
              fieldNames.add("UserPassword");
              fieldNames.add("UserLogin");
              fieldNames.add("UserFirstName");
              fieldNames.add("UserMidName");
              fieldNames.add("UserLastName");
              fieldNames.add("UserGender");
              fieldNames.add("UserDateOfBirth");
              fieldNames.add("UserPicture");
              fieldNames.add("AddressId");
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
          if (name.equals("UserId"))
        {
                return new Long(getUserId());
            }
          if (name.equals("UserPassword"))
        {
                return getUserPassword();
            }
          if (name.equals("UserLogin"))
        {
                return getUserLogin();
            }
          if (name.equals("UserFirstName"))
        {
                return getUserFirstName();
            }
          if (name.equals("UserMidName"))
        {
                return getUserMidName();
            }
          if (name.equals("UserLastName"))
        {
                return getUserLastName();
            }
          if (name.equals("UserGender"))
        {
                return getUserGender();
            }
          if (name.equals("UserDateOfBirth"))
        {
                return getUserDateOfBirth();
            }
          if (name.equals("UserPicture"))
        {
                return getUserPicture();
            }
          if (name.equals("AddressId"))
        {
                return new Long(getAddressId());
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
          if (name.equals(UserPeer.USER_ID))
        {
                return new Long(getUserId());
            }
          if (name.equals(UserPeer.USER_PASSWORD))
        {
                return getUserPassword();
            }
          if (name.equals(UserPeer.USER_LOGIN))
        {
                return getUserLogin();
            }
          if (name.equals(UserPeer.USER_FIRST_NAME))
        {
                return getUserFirstName();
            }
          if (name.equals(UserPeer.USER_MID_NAME))
        {
                return getUserMidName();
            }
          if (name.equals(UserPeer.USER_LAST_NAME))
        {
                return getUserLastName();
            }
          if (name.equals(UserPeer.USER_GENDER))
        {
                return getUserGender();
            }
          if (name.equals(UserPeer.USER_DATE_OF_BIRTH))
        {
                return getUserDateOfBirth();
            }
          if (name.equals(UserPeer.USER_PICTURE))
        {
                return getUserPicture();
            }
          if (name.equals(UserPeer.ADDRESS_ID))
        {
                return new Long(getAddressId());
            }
          if (name.equals(UserPeer.CLIENT_ID))
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
                return new Long(getUserId());
            }
              if (pos == 1)
        {
                return getUserPassword();
            }
              if (pos == 2)
        {
                return getUserLogin();
            }
              if (pos == 3)
        {
                return getUserFirstName();
            }
              if (pos == 4)
        {
                return getUserMidName();
            }
              if (pos == 5)
        {
                return getUserLastName();
            }
              if (pos == 6)
        {
                return getUserGender();
            }
              if (pos == 7)
        {
                return getUserDateOfBirth();
            }
              if (pos == 8)
        {
                return getUserPicture();
            }
              if (pos == 9)
        {
                return new Long(getAddressId());
            }
              if (pos == 10)
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
          save(UserPeer.getMapBuilder()
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
                    UserPeer.doInsert((User) this, con);
                    setNew(false);
                }
                else
                {
                    UserPeer.doUpdate((User) this, con);
                }
            }

                                      
                
            if (collUserGroupLnks != null)
            {
                for (int i = 0; i < collUserGroupLnks.size(); i++)
                {
                    ((UserGroupLnk) collUserGroupLnks.get(i)).save(con);
                }
            }
                          alreadyInSave = false;
        }
      }


                          
      /**
     * Set the PrimaryKey using ObjectKey.
     *
     * @param  userId ObjectKey
     */
    public void setPrimaryKey(ObjectKey key)
        throws TorqueException
    {
            setUserId(((NumberKey) key).longValue());
        }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) throws TorqueException
    {
            setUserId(Long.parseLong(key));
        }

  
    /**
     * returns an id that differentiates this object from others
     * of its class.
     */
    public ObjectKey getPrimaryKey()
    {
          return SimpleKey.keyFor(getUserId());
      }

 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
       * It then fills all the association collections and sets the
     * related objects to isNew=true.
       */
      public User copy() throws TorqueException
    {
        return copyInto(new User());
    }
  
    protected User copyInto(User copyObj) throws TorqueException
    {
          copyObj.setUserId(userId);
          copyObj.setUserPassword(userPassword);
          copyObj.setUserLogin(userLogin);
          copyObj.setUserFirstName(userFirstName);
          copyObj.setUserMidName(userMidName);
          copyObj.setUserLastName(userLastName);
          copyObj.setUserGender(userGender);
          copyObj.setUserDateOfBirth(userDateOfBirth);
          copyObj.setUserPicture(userPicture);
          copyObj.setAddressId(addressId);
          copyObj.setClientId(clientId);
  
                    copyObj.setUserId(0);
                                                                        
                                      
                
        List v = getUserGroupLnks();
        for (int i = 0; i < v.size(); i++)
        {
            UserGroupLnk obj = (UserGroupLnk) v.get(i);
            copyObj.addUserGroupLnk(obj.copy());
        }
                    
        return copyObj;
    }

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public UserPeer getPeer()
    {
        return peer;
    }

    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("User:\n");
        str.append("UserId = ")
           .append(getUserId())
           .append("\n");
        str.append("UserPassword = ")
           .append(getUserPassword())
           .append("\n");
        str.append("UserLogin = ")
           .append(getUserLogin())
           .append("\n");
        str.append("UserFirstName = ")
           .append(getUserFirstName())
           .append("\n");
        str.append("UserMidName = ")
           .append(getUserMidName())
           .append("\n");
        str.append("UserLastName = ")
           .append(getUserLastName())
           .append("\n");
        str.append("UserGender = ")
           .append(getUserGender())
           .append("\n");
        str.append("UserDateOfBirth = ")
           .append(getUserDateOfBirth())
           .append("\n");
        str.append("UserPicture = ")
           .append(getUserPicture())
           .append("\n");
        str.append("AddressId = ")
           .append(getAddressId())
           .append("\n");
        str.append("ClientId = ")
           .append(getClientId())
           .append("\n");
        return(str.toString());
    }
}
