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
 * [Sat Mar 20 16:37:12 CET 2004]
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to ContentSourceType
 */
public abstract class BaseContentSourceType extends BaseObject
{
    /** The Peer class */
    private static final ContentSourceTypePeer peer =
        new ContentSourceTypePeer();

        
    /** The value for the contentSourceTypeId field */
    private int contentSourceTypeId;
      
    /** The value for the contentSourceTypeName field */
    private String contentSourceTypeName;
      
    /** The value for the contentSourceTypeDesc field */
    private String contentSourceTypeDesc;
  
    
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
    public void setContentSourceTypeId(int v) throws TorqueException
    {
    
                  if (this.contentSourceTypeId != v)
              {
            this.contentSourceTypeId = v;
            setModified(true);
        }
    
          
                                  
        // update associated ContentSource
        if (collContentSources != null)
        {
            for (int i = 0; i < collContentSources.size(); i++)
            {
                ((ContentSource) collContentSources.get(i))
                    .setContentSourceTypeId(v);
            }
        }
                      }
  
    /**
     * Get the ContentSourceTypeName
     *
     * @return String
     */
    public String getContentSourceTypeName()
    {
        return contentSourceTypeName;
    }

                        
    /**
     * Set the value of ContentSourceTypeName
     *
     * @param v new value
     */
    public void setContentSourceTypeName(String v) 
    {
    
                  if (!ObjectUtils.equals(this.contentSourceTypeName, v))
              {
            this.contentSourceTypeName = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the ContentSourceTypeDesc
     *
     * @return String
     */
    public String getContentSourceTypeDesc()
    {
        return contentSourceTypeDesc;
    }

                        
    /**
     * Set the value of ContentSourceTypeDesc
     *
     * @param v new value
     */
    public void setContentSourceTypeDesc(String v) 
    {
    
                  if (!ObjectUtils.equals(this.contentSourceTypeDesc, v))
              {
            this.contentSourceTypeDesc = v;
            setModified(true);
        }
    
          
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
        l.setContentSourceType((ContentSourceType) this);
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
     * Otherwise if this ContentSourceType has previously
     * been saved, it will retrieve related ContentSources from storage.
     * If this ContentSourceType is new, it will return
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
                      criteria.add(ContentSourcePeer.CONTENT_SOURCE_TYPE_ID, getContentSourceTypeId() );
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
                      criteria.add(ContentSourcePeer.CONTENT_SOURCE_TYPE_ID, getContentSourceTypeId());
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
     * Otherwise if this ContentSourceType has previously
     * been saved, it will retrieve related ContentSources from storage.
     * If this ContentSourceType is new, it will return
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
                       criteria.add(ContentSourcePeer.CONTENT_SOURCE_TYPE_ID, getContentSourceTypeId());
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
                       criteria.add(ContentSourcePeer.CONTENT_SOURCE_TYPE_ID, getContentSourceTypeId());
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
     * Otherwise if this ContentSourceType is new, it will return
     * an empty collection; or if this ContentSourceType has previously
     * been saved, it will retrieve related ContentSources from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in ContentSourceType.
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
                            criteria.add(ContentSourcePeer.CONTENT_SOURCE_TYPE_ID, getContentSourceTypeId());
                            collContentSources = ContentSourcePeer.doSelectJoinContentSourceType(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            boolean newCriteria = true;
                        criteria.add(ContentSourcePeer.CONTENT_SOURCE_TYPE_ID, getContentSourceTypeId());
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
     * Otherwise if this ContentSourceType is new, it will return
     * an empty collection; or if this ContentSourceType has previously
     * been saved, it will retrieve related ContentSources from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in ContentSourceType.
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
                            criteria.add(ContentSourcePeer.CONTENT_SOURCE_TYPE_ID, getContentSourceTypeId());
                            collContentSources = ContentSourcePeer.doSelectJoinTransport(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            boolean newCriteria = true;
                        criteria.add(ContentSourcePeer.CONTENT_SOURCE_TYPE_ID, getContentSourceTypeId());
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
     * Otherwise if this ContentSourceType is new, it will return
     * an empty collection; or if this ContentSourceType has previously
     * been saved, it will retrieve related ContentSources from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in ContentSourceType.
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
                            criteria.add(ContentSourcePeer.CONTENT_SOURCE_TYPE_ID, getContentSourceTypeId());
                            collContentSources = ContentSourcePeer.doSelectJoinPublisher(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            boolean newCriteria = true;
                        criteria.add(ContentSourcePeer.CONTENT_SOURCE_TYPE_ID, getContentSourceTypeId());
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
              fieldNames.add("ContentSourceTypeId");
              fieldNames.add("ContentSourceTypeName");
              fieldNames.add("ContentSourceTypeDesc");
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
          if (name.equals("ContentSourceTypeName"))
        {
                return getContentSourceTypeName();
            }
          if (name.equals("ContentSourceTypeDesc"))
        {
                return getContentSourceTypeDesc();
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
          if (name.equals(ContentSourceTypePeer.CONTENT_SOURCE_TYPE_ID))
        {
                return new Integer(getContentSourceTypeId());
            }
          if (name.equals(ContentSourceTypePeer.CONTENT_SOURCE_TYPE_NAME))
        {
                return getContentSourceTypeName();
            }
          if (name.equals(ContentSourceTypePeer.CONTENT_SOURCE_TYPE_DESC))
        {
                return getContentSourceTypeDesc();
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
                return getContentSourceTypeName();
            }
              if (pos == 2)
        {
                return getContentSourceTypeDesc();
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
          save(ContentSourceTypePeer.getMapBuilder()
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
                    ContentSourceTypePeer.doInsert((ContentSourceType) this, con);
                    setNew(false);
                }
                else
                {
                    ContentSourceTypePeer.doUpdate((ContentSourceType) this, con);
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
     * @param  contentSourceTypeId ObjectKey
     */
    public void setPrimaryKey(ObjectKey key)
        throws TorqueException
    {
            setContentSourceTypeId(((NumberKey) key).intValue());
        }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) throws TorqueException
    {
            setContentSourceTypeId(Integer.parseInt(key));
        }

  
    /**
     * returns an id that differentiates this object from others
     * of its class.
     */
    public ObjectKey getPrimaryKey()
    {
          return SimpleKey.keyFor(getContentSourceTypeId());
      }

 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
       * It then fills all the association collections and sets the
     * related objects to isNew=true.
       */
      public ContentSourceType copy() throws TorqueException
    {
        return copyInto(new ContentSourceType());
    }
  
    protected ContentSourceType copyInto(ContentSourceType copyObj) throws TorqueException
    {
          copyObj.setContentSourceTypeId(contentSourceTypeId);
          copyObj.setContentSourceTypeName(contentSourceTypeName);
          copyObj.setContentSourceTypeDesc(contentSourceTypeDesc);
  
                    copyObj.setContentSourceTypeId(0);
                        
                                      
                
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
    public ContentSourceTypePeer getPeer()
    {
        return peer;
    }

    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("ContentSourceType:\n");
        str.append("ContentSourceTypeId = ")
           .append(getContentSourceTypeId())
           .append("\n");
        str.append("ContentSourceTypeName = ")
           .append(getContentSourceTypeName())
           .append("\n");
        str.append("ContentSourceTypeDesc = ")
           .append(getContentSourceTypeDesc())
           .append("\n");
        return(str.toString());
    }
}
