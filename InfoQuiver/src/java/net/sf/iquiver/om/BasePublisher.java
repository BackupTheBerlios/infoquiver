package net.sf.iquiver.om;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
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
 * [Tue Jul 06 01:21:59 CEST 2004]
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to Publisher
 */
public abstract class BasePublisher extends BaseObject
{
    /** The Peer class */
    private static final PublisherPeer peer =
        new PublisherPeer();

        
    /** The value for the publisherId field */
    private int publisherId;
      
    /** The value for the addressId field */
    private long addressId;
      
    /** The value for the publisherName field */
    private String publisherName;
      
    /** The value for the publisherLogo field */
    private byte[] publisherLogo;
  
    
    /**
     * Get the PublisherId
     *
     * @return int
     */
    public int getPublisherId()
    {
        return publisherId;
    }

                                              
    /**
     * Set the value of PublisherId
     *
     * @param v new value
     */
    public void setPublisherId(int v) throws TorqueException
    {
    
                  if (this.publisherId != v)
              {
            this.publisherId = v;
            setModified(true);
        }
    
          
                                  
        // update associated ContentSource
        if (collContentSources != null)
        {
            for (int i = 0; i < collContentSources.size(); i++)
            {
                ((ContentSource) collContentSources.get(i))
                    .setPublisherId(v);
            }
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
     * Get the PublisherName
     *
     * @return String
     */
    public String getPublisherName()
    {
        return publisherName;
    }

                        
    /**
     * Set the value of PublisherName
     *
     * @param v new value
     */
    public void setPublisherName(String v) 
    {
    
                  if (!ObjectUtils.equals(this.publisherName, v))
              {
            this.publisherName = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the PublisherLogo
     *
     * @return byte[]
     */
    public byte[] getPublisherLogo()
    {
        return publisherLogo;
    }

                        
    /**
     * Set the value of PublisherLogo
     *
     * @param v new value
     */
    public void setPublisherLogo(byte[] v) 
    {
    
                  if (!ObjectUtils.equals(this.publisherLogo, v))
              {
            this.publisherLogo = v;
            setModified(true);
        }
    
          
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
               obj.addPublishers(this);
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
     * Collection to store aggregation of collContentSources
     */
    protected List collContentSources;

    /**
     * Temporary storage of collContentSources to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initContentSources()
    {
        if (collContentSources == null)
        {
            collContentSources = new ArrayList();
        }
    }

    /**
     * Method called to associate a ContentSource object to this object
     * through the ContentSource foreign key attribute
     *
     * @param l ContentSource
     * @throws TorqueException
     */
    public void addContentSource(ContentSource l) throws TorqueException
    {
        getContentSources().add(l);
        l.setPublisher((Publisher) this);
    }

    /**
     * The criteria used to select the current contents of collContentSources
     */
    private Criteria lastContentSourcesCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getContentSources(new Criteria())
     *
     * @throws TorqueException
     */
    public List getContentSources() throws TorqueException
    {
        if (collContentSources == null)
        {
            collContentSources = getContentSources(new Criteria(10));
        }
        return collContentSources;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Publisher has previously
     * been saved, it will retrieve related ContentSources from storage.
     * If this Publisher is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List getContentSources(Criteria criteria) throws TorqueException
    {
        if (collContentSources == null)
        {
            if (isNew())
            {
               collContentSources = new ArrayList();
            }
            else
            {
                      criteria.add(ContentSourcePeer.PUBLISHER_ID, getPublisherId() );
                      collContentSources = ContentSourcePeer.doSelect(criteria);
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
                      criteria.add(ContentSourcePeer.PUBLISHER_ID, getPublisherId());
                      if (!lastContentSourcesCriteria.equals(criteria))
                {
                    collContentSources = ContentSourcePeer.doSelect(criteria);
                }
            }
        }
        lastContentSourcesCriteria = criteria;

        return collContentSources;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getContentSources(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List getContentSources(Connection con) throws TorqueException
    {
        if (collContentSources == null)
        {
            collContentSources = getContentSources(new Criteria(10), con);
        }
        return collContentSources;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Publisher has previously
     * been saved, it will retrieve related ContentSources from storage.
     * If this Publisher is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List getContentSources(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collContentSources == null)
        {
            if (isNew())
            {
               collContentSources = new ArrayList();
            }
            else
            {
                       criteria.add(ContentSourcePeer.PUBLISHER_ID, getPublisherId());
                       collContentSources = ContentSourcePeer.doSelect(criteria, con);
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
                       criteria.add(ContentSourcePeer.PUBLISHER_ID, getPublisherId());
                       if (!lastContentSourcesCriteria.equals(criteria))
                 {
                     collContentSources = ContentSourcePeer.doSelect(criteria, con);
                 }
             }
         }
         lastContentSourcesCriteria = criteria;

         return collContentSources;
     }

                              
              
                    
                    
                                
                                                              
                                        
                    
                    
          
    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Publisher is new, it will return
     * an empty collection; or if this Publisher has previously
     * been saved, it will retrieve related ContentSources from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Publisher.
     */
    protected List getContentSourcesJoinContentSourceType(Criteria criteria)
        throws TorqueException
    {
        if (collContentSources == null)
        {
            if (isNew())
            {
               collContentSources = new ArrayList();
            }
            else
            {
                            criteria.add(ContentSourcePeer.PUBLISHER_ID, getPublisherId());
                            collContentSources = ContentSourcePeer.doSelectJoinContentSourceType(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            boolean newCriteria = true;
                        criteria.add(ContentSourcePeer.PUBLISHER_ID, getPublisherId());
                        if (!lastContentSourcesCriteria.equals(criteria))
            {
                collContentSources = ContentSourcePeer.doSelectJoinContentSourceType(criteria);
            }
        }
        lastContentSourcesCriteria = criteria;

        return collContentSources;
    }
                  
                    
                    
                                
                                                              
                                        
                    
                    
          
    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Publisher is new, it will return
     * an empty collection; or if this Publisher has previously
     * been saved, it will retrieve related ContentSources from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Publisher.
     */
    protected List getContentSourcesJoinTransport(Criteria criteria)
        throws TorqueException
    {
        if (collContentSources == null)
        {
            if (isNew())
            {
               collContentSources = new ArrayList();
            }
            else
            {
                            criteria.add(ContentSourcePeer.PUBLISHER_ID, getPublisherId());
                            collContentSources = ContentSourcePeer.doSelectJoinTransport(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            boolean newCriteria = true;
                        criteria.add(ContentSourcePeer.PUBLISHER_ID, getPublisherId());
                        if (!lastContentSourcesCriteria.equals(criteria))
            {
                collContentSources = ContentSourcePeer.doSelectJoinTransport(criteria);
            }
        }
        lastContentSourcesCriteria = criteria;

        return collContentSources;
    }
                  
                    
                              
                                
                                                              
                                        
                    
                    
          
    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Publisher is new, it will return
     * an empty collection; or if this Publisher has previously
     * been saved, it will retrieve related ContentSources from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Publisher.
     */
    protected List getContentSourcesJoinPublisher(Criteria criteria)
        throws TorqueException
    {
        if (collContentSources == null)
        {
            if (isNew())
            {
               collContentSources = new ArrayList();
            }
            else
            {
                            criteria.add(ContentSourcePeer.PUBLISHER_ID, getPublisherId());
                            collContentSources = ContentSourcePeer.doSelectJoinPublisher(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            boolean newCriteria = true;
                        criteria.add(ContentSourcePeer.PUBLISHER_ID, getPublisherId());
                        if (!lastContentSourcesCriteria.equals(criteria))
            {
                collContentSources = ContentSourcePeer.doSelectJoinPublisher(criteria);
            }
        }
        lastContentSourcesCriteria = criteria;

        return collContentSources;
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
              fieldNames.add("PublisherId");
              fieldNames.add("AddressId");
              fieldNames.add("PublisherName");
              fieldNames.add("PublisherLogo");
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
          if (name.equals("PublisherId"))
        {
                return new Integer(getPublisherId());
            }
          if (name.equals("AddressId"))
        {
                return new Long(getAddressId());
            }
          if (name.equals("PublisherName"))
        {
                return getPublisherName();
            }
          if (name.equals("PublisherLogo"))
        {
                return getPublisherLogo();
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
          if (name.equals(PublisherPeer.PUBLISHER_ID))
        {
                return new Integer(getPublisherId());
            }
          if (name.equals(PublisherPeer.ADDRESS_ID))
        {
                return new Long(getAddressId());
            }
          if (name.equals(PublisherPeer.PUBLISHER_NAME))
        {
                return getPublisherName();
            }
          if (name.equals(PublisherPeer.PUBLISHER_LOGO))
        {
                return getPublisherLogo();
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
                return new Integer(getPublisherId());
            }
              if (pos == 1)
        {
                return new Long(getAddressId());
            }
              if (pos == 2)
        {
                return getPublisherName();
            }
              if (pos == 3)
        {
                return getPublisherLogo();
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
          save(PublisherPeer.getMapBuilder()
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
                    PublisherPeer.doInsert((Publisher) this, con);
                    setNew(false);
                }
                else
                {
                    PublisherPeer.doUpdate((Publisher) this, con);
                }
            }

                                      
                
            if (collContentSources != null)
            {
                for (int i = 0; i < collContentSources.size(); i++)
                {
                    ((ContentSource) collContentSources.get(i)).save(con);
                }
            }
                          alreadyInSave = false;
        }
      }


                          
      /**
     * Set the PrimaryKey using ObjectKey.
     *
     * @param  publisherId ObjectKey
     */
    public void setPrimaryKey(ObjectKey key)
        throws TorqueException
    {
            setPublisherId(((NumberKey) key).intValue());
        }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) throws TorqueException
    {
            setPublisherId(Integer.parseInt(key));
        }

  
    /**
     * returns an id that differentiates this object from others
     * of its class.
     */
    public ObjectKey getPrimaryKey()
    {
          return SimpleKey.keyFor(getPublisherId());
      }

 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
       * It then fills all the association collections and sets the
     * related objects to isNew=true.
       */
      public Publisher copy() throws TorqueException
    {
        return copyInto(new Publisher());
    }
  
    protected Publisher copyInto(Publisher copyObj) throws TorqueException
    {
          copyObj.setPublisherId(publisherId);
          copyObj.setAddressId(addressId);
          copyObj.setPublisherName(publisherName);
          copyObj.setPublisherLogo(publisherLogo);
  
                    copyObj.setPublisherId(0);
                              
                                      
                
        List v = getContentSources();
        for (int i = 0; i < v.size(); i++)
        {
            ContentSource obj = (ContentSource) v.get(i);
            copyObj.addContentSource(obj.copy());
        }
                    
        return copyObj;
    }

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public PublisherPeer getPeer()
    {
        return peer;
    }

    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Publisher:\n");
        str.append("PublisherId = ")
           .append(getPublisherId())
           .append("\n");
        str.append("AddressId = ")
           .append(getAddressId())
           .append("\n");
        str.append("PublisherName = ")
           .append(getPublisherName())
           .append("\n");
        str.append("PublisherLogo = ")
           .append(getPublisherLogo())
           .append("\n");
        return(str.toString());
    }
}
