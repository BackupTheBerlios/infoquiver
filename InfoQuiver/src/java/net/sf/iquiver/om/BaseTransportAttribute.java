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
 * [Sat Apr 10 10:03:40 CEST 2004]
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to TransportAttribute
 */
public abstract class BaseTransportAttribute extends BaseObject
{
    /** The Peer class */
    private static final TransportAttributePeer peer =
        new TransportAttributePeer();

        
    /** The value for the transportAttributeId field */
    private int transportAttributeId;
      
    /** The value for the transportId field */
    private int transportId;
      
    /** The value for the transportAttributeName field */
    private String transportAttributeName;
      
    /** The value for the transportAttributeType field */
    private String transportAttributeType;
      
    /** The value for the isPartOfAuthentification field */
    private boolean isPartOfAuthentification;
      
    /** The value for the isMandatory field */
    private boolean isMandatory;
  
    
    /**
     * Get the TransportAttributeId
     *
     * @return int
     */
    public int getTransportAttributeId()
    {
        return transportAttributeId;
    }

                                              
    /**
     * Set the value of TransportAttributeId
     *
     * @param v new value
     */
    public void setTransportAttributeId(int v) throws TorqueException
    {
    
                  if (this.transportAttributeId != v)
              {
            this.transportAttributeId = v;
            setModified(true);
        }
    
          
                                  
        // update associated ContentSourceTransportConfig
        if (collContentSourceTransportConfigs != null)
        {
            for (int i = 0; i < collContentSourceTransportConfigs.size(); i++)
            {
                ((ContentSourceTransportConfig) collContentSourceTransportConfigs.get(i))
                    .setTransportAttributeId(v);
            }
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
    public void setTransportId(int v) throws TorqueException
    {
    
                  if (this.transportId != v)
              {
            this.transportId = v;
            setModified(true);
        }
    
                          
                if (aTransport != null && !(aTransport.getTransportId() == v))
                {
            aTransport = null;
        }
      
              }
  
    /**
     * Get the TransportAttributeName
     *
     * @return String
     */
    public String getTransportAttributeName()
    {
        return transportAttributeName;
    }

                        
    /**
     * Set the value of TransportAttributeName
     *
     * @param v new value
     */
    public void setTransportAttributeName(String v) 
    {
    
                  if (!ObjectUtils.equals(this.transportAttributeName, v))
              {
            this.transportAttributeName = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the TransportAttributeType
     *
     * @return String
     */
    public String getTransportAttributeType()
    {
        return transportAttributeType;
    }

                        
    /**
     * Set the value of TransportAttributeType
     *
     * @param v new value
     */
    public void setTransportAttributeType(String v) 
    {
    
                  if (!ObjectUtils.equals(this.transportAttributeType, v))
              {
            this.transportAttributeType = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the IsPartOfAuthentification
     *
     * @return boolean
     */
    public boolean getIsPartOfAuthentification()
    {
        return isPartOfAuthentification;
    }

                        
    /**
     * Set the value of IsPartOfAuthentification
     *
     * @param v new value
     */
    public void setIsPartOfAuthentification(boolean v) 
    {
    
                  if (this.isPartOfAuthentification != v)
              {
            this.isPartOfAuthentification = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the IsMandatory
     *
     * @return boolean
     */
    public boolean getIsMandatory()
    {
        return isMandatory;
    }

                        
    /**
     * Set the value of IsMandatory
     *
     * @param v new value
     */
    public void setIsMandatory(boolean v) 
    {
    
                  if (this.isMandatory != v)
              {
            this.isMandatory = v;
            setModified(true);
        }
    
          
              }
  
      
    
                  
    
        private Transport aTransport;

    /**
     * Declares an association between this object and a Transport object
     *
     * @param v Transport
     * @throws TorqueException
     */
    public void setTransport(Transport v) throws TorqueException
    {
            if (v == null)
        {
                    setTransportId(0);
                  }
        else
        {
            setTransportId(v.getTransportId());
        }
                aTransport = v;
    }

                                            
    /**
     * Get the associated Transport object
     *
     * @return the associated Transport object
     * @throws TorqueException
     */
    public Transport getTransport() throws TorqueException
    {
        if (aTransport == null && (this.transportId > 0))
        {
                          aTransport = TransportPeer.retrieveByPK(SimpleKey.keyFor(this.transportId));
              
            /* The following can be used instead of the line above to
               guarantee the related object contains a reference
               to this object, but this level of coupling
               may be undesirable in many circumstances.
               As it can lead to a db query with many results that may
               never be used.
               Transport obj = TransportPeer.retrieveByPK(this.transportId);
               obj.addTransportAttributes(this);
            */
        }
        return aTransport;
    }

    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey.  e.g.
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
           */
    public void setTransportKey(ObjectKey key) throws TorqueException
    {
      
                        setTransportId(((NumberKey) key).intValue());
                  }
       
                                
            
    /**
     * Collection to store aggregation of collContentSourceTransportConfigs
     */
    protected List collContentSourceTransportConfigs;

    /**
     * Temporary storage of collContentSourceTransportConfigs to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initContentSourceTransportConfigs()
    {
        if (collContentSourceTransportConfigs == null)
        {
            collContentSourceTransportConfigs = new ArrayList();
        }
    }

    /**
     * Method called to associate a ContentSourceTransportConfig object to this object
     * through the ContentSourceTransportConfig foreign key attribute
     *
     * @param l ContentSourceTransportConfig
     * @throws TorqueException
     */
    public void addContentSourceTransportConfig(ContentSourceTransportConfig l) throws TorqueException
    {
        getContentSourceTransportConfigs().add(l);
        l.setTransportAttribute((TransportAttribute) this);
    }

    /**
     * The criteria used to select the current contents of collContentSourceTransportConfigs
     */
    private Criteria lastContentSourceTransportConfigsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getContentSourceTransportConfigs(new Criteria())
     *
     * @throws TorqueException
     */
    public List getContentSourceTransportConfigs() throws TorqueException
    {
        if (collContentSourceTransportConfigs == null)
        {
            collContentSourceTransportConfigs = getContentSourceTransportConfigs(new Criteria(10));
        }
        return collContentSourceTransportConfigs;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this TransportAttribute has previously
     * been saved, it will retrieve related ContentSourceTransportConfigs from storage.
     * If this TransportAttribute is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List getContentSourceTransportConfigs(Criteria criteria) throws TorqueException
    {
        if (collContentSourceTransportConfigs == null)
        {
            if (isNew())
            {
               collContentSourceTransportConfigs = new ArrayList();
            }
            else
            {
                      criteria.add(ContentSourceTransportConfigPeer.TRANSPORT_ATTRIBUTE_ID, getTransportAttributeId() );
                      collContentSourceTransportConfigs = ContentSourceTransportConfigPeer.doSelect(criteria);
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
                      criteria.add(ContentSourceTransportConfigPeer.TRANSPORT_ATTRIBUTE_ID, getTransportAttributeId());
                      if (!lastContentSourceTransportConfigsCriteria.equals(criteria))
                {
                    collContentSourceTransportConfigs = ContentSourceTransportConfigPeer.doSelect(criteria);
                }
            }
        }
        lastContentSourceTransportConfigsCriteria = criteria;

        return collContentSourceTransportConfigs;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getContentSourceTransportConfigs(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List getContentSourceTransportConfigs(Connection con) throws TorqueException
    {
        if (collContentSourceTransportConfigs == null)
        {
            collContentSourceTransportConfigs = getContentSourceTransportConfigs(new Criteria(10), con);
        }
        return collContentSourceTransportConfigs;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this TransportAttribute has previously
     * been saved, it will retrieve related ContentSourceTransportConfigs from storage.
     * If this TransportAttribute is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List getContentSourceTransportConfigs(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collContentSourceTransportConfigs == null)
        {
            if (isNew())
            {
               collContentSourceTransportConfigs = new ArrayList();
            }
            else
            {
                       criteria.add(ContentSourceTransportConfigPeer.TRANSPORT_ATTRIBUTE_ID, getTransportAttributeId());
                       collContentSourceTransportConfigs = ContentSourceTransportConfigPeer.doSelect(criteria, con);
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
                       criteria.add(ContentSourceTransportConfigPeer.TRANSPORT_ATTRIBUTE_ID, getTransportAttributeId());
                       if (!lastContentSourceTransportConfigsCriteria.equals(criteria))
                 {
                     collContentSourceTransportConfigs = ContentSourceTransportConfigPeer.doSelect(criteria, con);
                 }
             }
         }
         lastContentSourceTransportConfigsCriteria = criteria;

         return collContentSourceTransportConfigs;
     }

                        
              
                    
                    
                                
                                                              
                                        
                    
                    
          
    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this TransportAttribute is new, it will return
     * an empty collection; or if this TransportAttribute has previously
     * been saved, it will retrieve related ContentSourceTransportConfigs from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in TransportAttribute.
     */
    protected List getContentSourceTransportConfigsJoinContentSource(Criteria criteria)
        throws TorqueException
    {
        if (collContentSourceTransportConfigs == null)
        {
            if (isNew())
            {
               collContentSourceTransportConfigs = new ArrayList();
            }
            else
            {
                            criteria.add(ContentSourceTransportConfigPeer.TRANSPORT_ATTRIBUTE_ID, getTransportAttributeId());
                            collContentSourceTransportConfigs = ContentSourceTransportConfigPeer.doSelectJoinContentSource(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            boolean newCriteria = true;
                        criteria.add(ContentSourceTransportConfigPeer.TRANSPORT_ATTRIBUTE_ID, getTransportAttributeId());
                        if (!lastContentSourceTransportConfigsCriteria.equals(criteria))
            {
                collContentSourceTransportConfigs = ContentSourceTransportConfigPeer.doSelectJoinContentSource(criteria);
            }
        }
        lastContentSourceTransportConfigsCriteria = criteria;

        return collContentSourceTransportConfigs;
    }
                  
                    
                              
                                
                                                              
                                        
                    
                    
          
    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this TransportAttribute is new, it will return
     * an empty collection; or if this TransportAttribute has previously
     * been saved, it will retrieve related ContentSourceTransportConfigs from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in TransportAttribute.
     */
    protected List getContentSourceTransportConfigsJoinTransportAttribute(Criteria criteria)
        throws TorqueException
    {
        if (collContentSourceTransportConfigs == null)
        {
            if (isNew())
            {
               collContentSourceTransportConfigs = new ArrayList();
            }
            else
            {
                            criteria.add(ContentSourceTransportConfigPeer.TRANSPORT_ATTRIBUTE_ID, getTransportAttributeId());
                            collContentSourceTransportConfigs = ContentSourceTransportConfigPeer.doSelectJoinTransportAttribute(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            boolean newCriteria = true;
                        criteria.add(ContentSourceTransportConfigPeer.TRANSPORT_ATTRIBUTE_ID, getTransportAttributeId());
                        if (!lastContentSourceTransportConfigsCriteria.equals(criteria))
            {
                collContentSourceTransportConfigs = ContentSourceTransportConfigPeer.doSelectJoinTransportAttribute(criteria);
            }
        }
        lastContentSourceTransportConfigsCriteria = criteria;

        return collContentSourceTransportConfigs;
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
              fieldNames.add("TransportAttributeId");
              fieldNames.add("TransportId");
              fieldNames.add("TransportAttributeName");
              fieldNames.add("TransportAttributeType");
              fieldNames.add("IsPartOfAuthentification");
              fieldNames.add("IsMandatory");
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
          if (name.equals("TransportAttributeId"))
        {
                return new Integer(getTransportAttributeId());
            }
          if (name.equals("TransportId"))
        {
                return new Integer(getTransportId());
            }
          if (name.equals("TransportAttributeName"))
        {
                return getTransportAttributeName();
            }
          if (name.equals("TransportAttributeType"))
        {
                return getTransportAttributeType();
            }
          if (name.equals("IsPartOfAuthentification"))
        {
                return new Boolean(getIsPartOfAuthentification());
            }
          if (name.equals("IsMandatory"))
        {
                return new Boolean(getIsMandatory());
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
          if (name.equals(TransportAttributePeer.TRANSPORT_ATTRIBUTE_ID))
        {
                return new Integer(getTransportAttributeId());
            }
          if (name.equals(TransportAttributePeer.TRANSPORT_ID))
        {
                return new Integer(getTransportId());
            }
          if (name.equals(TransportAttributePeer.TRANSPORT_ATTRIBUTE_NAME))
        {
                return getTransportAttributeName();
            }
          if (name.equals(TransportAttributePeer.TRANSPORT_ATTRIBUTE_TYPE))
        {
                return getTransportAttributeType();
            }
          if (name.equals(TransportAttributePeer.IS_PART_OF_AUTHENTIFICATION))
        {
                return new Boolean(getIsPartOfAuthentification());
            }
          if (name.equals(TransportAttributePeer.IS_MANDATORY))
        {
                return new Boolean(getIsMandatory());
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
                return new Integer(getTransportAttributeId());
            }
              if (pos == 1)
        {
                return new Integer(getTransportId());
            }
              if (pos == 2)
        {
                return getTransportAttributeName();
            }
              if (pos == 3)
        {
                return getTransportAttributeType();
            }
              if (pos == 4)
        {
                return new Boolean(getIsPartOfAuthentification());
            }
              if (pos == 5)
        {
                return new Boolean(getIsMandatory());
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
          save(TransportAttributePeer.getMapBuilder()
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
                    TransportAttributePeer.doInsert((TransportAttribute) this, con);
                    setNew(false);
                }
                else
                {
                    TransportAttributePeer.doUpdate((TransportAttribute) this, con);
                }
            }

                                      
                
            if (collContentSourceTransportConfigs != null)
            {
                for (int i = 0; i < collContentSourceTransportConfigs.size(); i++)
                {
                    ((ContentSourceTransportConfig) collContentSourceTransportConfigs.get(i)).save(con);
                }
            }
                          alreadyInSave = false;
        }
      }


                          
      /**
     * Set the PrimaryKey using ObjectKey.
     *
     * @param  transportAttributeId ObjectKey
     */
    public void setPrimaryKey(ObjectKey key)
        throws TorqueException
    {
            setTransportAttributeId(((NumberKey) key).intValue());
        }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) throws TorqueException
    {
            setTransportAttributeId(Integer.parseInt(key));
        }

  
    /**
     * returns an id that differentiates this object from others
     * of its class.
     */
    public ObjectKey getPrimaryKey()
    {
          return SimpleKey.keyFor(getTransportAttributeId());
      }

 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
       * It then fills all the association collections and sets the
     * related objects to isNew=true.
       */
      public TransportAttribute copy() throws TorqueException
    {
        return copyInto(new TransportAttribute());
    }
  
    protected TransportAttribute copyInto(TransportAttribute copyObj) throws TorqueException
    {
          copyObj.setTransportAttributeId(transportAttributeId);
          copyObj.setTransportId(transportId);
          copyObj.setTransportAttributeName(transportAttributeName);
          copyObj.setTransportAttributeType(transportAttributeType);
          copyObj.setIsPartOfAuthentification(isPartOfAuthentification);
          copyObj.setIsMandatory(isMandatory);
  
                    copyObj.setTransportAttributeId(0);
                                          
                                      
                
        List v = getContentSourceTransportConfigs();
        for (int i = 0; i < v.size(); i++)
        {
            ContentSourceTransportConfig obj = (ContentSourceTransportConfig) v.get(i);
            copyObj.addContentSourceTransportConfig(obj.copy());
        }
                    
        return copyObj;
    }

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public TransportAttributePeer getPeer()
    {
        return peer;
    }

    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("TransportAttribute:\n");
        str.append("TransportAttributeId = ")
           .append(getTransportAttributeId())
           .append("\n");
        str.append("TransportId = ")
           .append(getTransportId())
           .append("\n");
        str.append("TransportAttributeName = ")
           .append(getTransportAttributeName())
           .append("\n");
        str.append("TransportAttributeType = ")
           .append(getTransportAttributeType())
           .append("\n");
        str.append("IsPartOfAuthentification = ")
           .append(getIsPartOfAuthentification())
           .append("\n");
        str.append("IsMandatory = ")
           .append(getIsMandatory())
           .append("\n");
        return(str.toString());
    }
}
