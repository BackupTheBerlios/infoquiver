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
 * [Sun Jul 04 16:22:33 CEST 2004]
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to ContentType
 */
public abstract class BaseContentType extends BaseObject
{
    /** The Peer class */
    private static final ContentTypePeer peer =
        new ContentTypePeer();

        
    /** The value for the contentTypeId field */
    private int contentTypeId;
      
    /** The value for the contentTypeName field */
    private String contentTypeName;
      
    /** The value for the contentTypeDesc field */
    private String contentTypeDesc;
      
    /** The value for the contentParserId field */
    private int contentParserId;
  
    
    /**
     * Get the ContentTypeId
     *
     * @return int
     */
    public int getContentTypeId()
    {
        return contentTypeId;
    }

                                              
    /**
     * Set the value of ContentTypeId
     *
     * @param v new value
     */
    public void setContentTypeId(int v) throws TorqueException
    {
    
                  if (this.contentTypeId != v)
              {
            this.contentTypeId = v;
            setModified(true);
        }
    
          
                                  
        // update associated Content
        if (collContents != null)
        {
            for (int i = 0; i < collContents.size(); i++)
            {
                ((Content) collContents.get(i))
                    .setContentTypeId(v);
            }
        }
                      }
  
    /**
     * Get the ContentTypeName
     *
     * @return String
     */
    public String getContentTypeName()
    {
        return contentTypeName;
    }

                        
    /**
     * Set the value of ContentTypeName
     *
     * @param v new value
     */
    public void setContentTypeName(String v) 
    {
    
                  if (!ObjectUtils.equals(this.contentTypeName, v))
              {
            this.contentTypeName = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the ContentTypeDesc
     *
     * @return String
     */
    public String getContentTypeDesc()
    {
        return contentTypeDesc;
    }

                        
    /**
     * Set the value of ContentTypeDesc
     *
     * @param v new value
     */
    public void setContentTypeDesc(String v) 
    {
    
                  if (!ObjectUtils.equals(this.contentTypeDesc, v))
              {
            this.contentTypeDesc = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the ContentParserId
     *
     * @return int
     */
    public int getContentParserId()
    {
        return contentParserId;
    }

                              
    /**
     * Set the value of ContentParserId
     *
     * @param v new value
     */
    public void setContentParserId(int v) throws TorqueException
    {
    
                  if (this.contentParserId != v)
              {
            this.contentParserId = v;
            setModified(true);
        }
    
                          
                if (aContentParser != null && !(aContentParser.getContentParserId() == v))
                {
            aContentParser = null;
        }
      
              }
  
      
    
                  
    
        private ContentParser aContentParser;

    /**
     * Declares an association between this object and a ContentParser object
     *
     * @param v ContentParser
     * @throws TorqueException
     */
    public void setContentParser(ContentParser v) throws TorqueException
    {
            if (v == null)
        {
                    setContentParserId(0);
                  }
        else
        {
            setContentParserId(v.getContentParserId());
        }
                aContentParser = v;
    }

                                            
    /**
     * Get the associated ContentParser object
     *
     * @return the associated ContentParser object
     * @throws TorqueException
     */
    public ContentParser getContentParser() throws TorqueException
    {
        if (aContentParser == null && (this.contentParserId > 0))
        {
                          aContentParser = ContentParserPeer.retrieveByPK(SimpleKey.keyFor(this.contentParserId));
              
            /* The following can be used instead of the line above to
               guarantee the related object contains a reference
               to this object, but this level of coupling
               may be undesirable in many circumstances.
               As it can lead to a db query with many results that may
               never be used.
               ContentParser obj = ContentParserPeer.retrieveByPK(this.contentParserId);
               obj.addContentTypes(this);
            */
        }
        return aContentParser;
    }

    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey.  e.g.
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
           */
    public void setContentParserKey(ObjectKey key) throws TorqueException
    {
      
                        setContentParserId(((NumberKey) key).intValue());
                  }
       
                                
            
    /**
     * Collection to store aggregation of collContents
     */
    protected List collContents;

    /**
     * Temporary storage of collContents to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initContents()
    {
        if (collContents == null)
        {
            collContents = new ArrayList();
        }
    }

    /**
     * Method called to associate a Content object to this object
     * through the Content foreign key attribute
     *
     * @param l Content
     * @throws TorqueException
     */
    public void addContent(Content l) throws TorqueException
    {
        getContents().add(l);
        l.setContentType((ContentType) this);
    }

    /**
     * The criteria used to select the current contents of collContents
     */
    private Criteria lastContentsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getContents(new Criteria())
     *
     * @throws TorqueException
     */
    public List getContents() throws TorqueException
    {
        if (collContents == null)
        {
            collContents = getContents(new Criteria(10));
        }
        return collContents;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this ContentType has previously
     * been saved, it will retrieve related Contents from storage.
     * If this ContentType is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List getContents(Criteria criteria) throws TorqueException
    {
        if (collContents == null)
        {
            if (isNew())
            {
               collContents = new ArrayList();
            }
            else
            {
                      criteria.add(ContentPeer.CONTENT_TYPE_ID, getContentTypeId() );
                      collContents = ContentPeer.doSelect(criteria);
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
                      criteria.add(ContentPeer.CONTENT_TYPE_ID, getContentTypeId());
                      if (!lastContentsCriteria.equals(criteria))
                {
                    collContents = ContentPeer.doSelect(criteria);
                }
            }
        }
        lastContentsCriteria = criteria;

        return collContents;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getContents(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List getContents(Connection con) throws TorqueException
    {
        if (collContents == null)
        {
            collContents = getContents(new Criteria(10), con);
        }
        return collContents;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this ContentType has previously
     * been saved, it will retrieve related Contents from storage.
     * If this ContentType is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List getContents(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collContents == null)
        {
            if (isNew())
            {
               collContents = new ArrayList();
            }
            else
            {
                       criteria.add(ContentPeer.CONTENT_TYPE_ID, getContentTypeId());
                       collContents = ContentPeer.doSelect(criteria, con);
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
                       criteria.add(ContentPeer.CONTENT_TYPE_ID, getContentTypeId());
                       if (!lastContentsCriteria.equals(criteria))
                 {
                     collContents = ContentPeer.doSelect(criteria, con);
                 }
             }
         }
         lastContentsCriteria = criteria;

         return collContents;
     }

                        
              
                    
                    
                                
                                                              
                                        
                    
                    
          
    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this ContentType is new, it will return
     * an empty collection; or if this ContentType has previously
     * been saved, it will retrieve related Contents from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in ContentType.
     */
    protected List getContentsJoinContentSource(Criteria criteria)
        throws TorqueException
    {
        if (collContents == null)
        {
            if (isNew())
            {
               collContents = new ArrayList();
            }
            else
            {
                            criteria.add(ContentPeer.CONTENT_TYPE_ID, getContentTypeId());
                            collContents = ContentPeer.doSelectJoinContentSource(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            boolean newCriteria = true;
                        criteria.add(ContentPeer.CONTENT_TYPE_ID, getContentTypeId());
                        if (!lastContentsCriteria.equals(criteria))
            {
                collContents = ContentPeer.doSelectJoinContentSource(criteria);
            }
        }
        lastContentsCriteria = criteria;

        return collContents;
    }
                  
                    
                              
                                
                                                              
                                        
                    
                    
          
    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this ContentType is new, it will return
     * an empty collection; or if this ContentType has previously
     * been saved, it will retrieve related Contents from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in ContentType.
     */
    protected List getContentsJoinContentType(Criteria criteria)
        throws TorqueException
    {
        if (collContents == null)
        {
            if (isNew())
            {
               collContents = new ArrayList();
            }
            else
            {
                            criteria.add(ContentPeer.CONTENT_TYPE_ID, getContentTypeId());
                            collContents = ContentPeer.doSelectJoinContentType(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            boolean newCriteria = true;
                        criteria.add(ContentPeer.CONTENT_TYPE_ID, getContentTypeId());
                        if (!lastContentsCriteria.equals(criteria))
            {
                collContents = ContentPeer.doSelectJoinContentType(criteria);
            }
        }
        lastContentsCriteria = criteria;

        return collContents;
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
              fieldNames.add("ContentTypeId");
              fieldNames.add("ContentTypeName");
              fieldNames.add("ContentTypeDesc");
              fieldNames.add("ContentParserId");
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
          if (name.equals("ContentTypeId"))
        {
                return new Integer(getContentTypeId());
            }
          if (name.equals("ContentTypeName"))
        {
                return getContentTypeName();
            }
          if (name.equals("ContentTypeDesc"))
        {
                return getContentTypeDesc();
            }
          if (name.equals("ContentParserId"))
        {
                return new Integer(getContentParserId());
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
          if (name.equals(ContentTypePeer.CONTENT_TYPE_ID))
        {
                return new Integer(getContentTypeId());
            }
          if (name.equals(ContentTypePeer.CONTENT_TYPE_NAME))
        {
                return getContentTypeName();
            }
          if (name.equals(ContentTypePeer.CONTENT_TYPE_DESC))
        {
                return getContentTypeDesc();
            }
          if (name.equals(ContentTypePeer.CONTENT_PARSER_ID))
        {
                return new Integer(getContentParserId());
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
                return new Integer(getContentTypeId());
            }
              if (pos == 1)
        {
                return getContentTypeName();
            }
              if (pos == 2)
        {
                return getContentTypeDesc();
            }
              if (pos == 3)
        {
                return new Integer(getContentParserId());
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
          save(ContentTypePeer.getMapBuilder()
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
                    ContentTypePeer.doInsert((ContentType) this, con);
                    setNew(false);
                }
                else
                {
                    ContentTypePeer.doUpdate((ContentType) this, con);
                }
            }

                                      
                
            if (collContents != null)
            {
                for (int i = 0; i < collContents.size(); i++)
                {
                    ((Content) collContents.get(i)).save(con);
                }
            }
                          alreadyInSave = false;
        }
      }


                          
      /**
     * Set the PrimaryKey using ObjectKey.
     *
     * @param  contentTypeId ObjectKey
     */
    public void setPrimaryKey(ObjectKey key)
        throws TorqueException
    {
            setContentTypeId(((NumberKey) key).intValue());
        }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) throws TorqueException
    {
            setContentTypeId(Integer.parseInt(key));
        }

  
    /**
     * returns an id that differentiates this object from others
     * of its class.
     */
    public ObjectKey getPrimaryKey()
    {
          return SimpleKey.keyFor(getContentTypeId());
      }

 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
       * It then fills all the association collections and sets the
     * related objects to isNew=true.
       */
      public ContentType copy() throws TorqueException
    {
        return copyInto(new ContentType());
    }
  
    protected ContentType copyInto(ContentType copyObj) throws TorqueException
    {
          copyObj.setContentTypeId(contentTypeId);
          copyObj.setContentTypeName(contentTypeName);
          copyObj.setContentTypeDesc(contentTypeDesc);
          copyObj.setContentParserId(contentParserId);
  
                    copyObj.setContentTypeId(0);
                              
                                      
                
        List v = getContents();
        for (int i = 0; i < v.size(); i++)
        {
            Content obj = (Content) v.get(i);
            copyObj.addContent(obj.copy());
        }
                    
        return copyObj;
    }

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public ContentTypePeer getPeer()
    {
        return peer;
    }

    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("ContentType:\n");
        str.append("ContentTypeId = ")
           .append(getContentTypeId())
           .append("\n");
        str.append("ContentTypeName = ")
           .append(getContentTypeName())
           .append("\n");
        str.append("ContentTypeDesc = ")
           .append(getContentTypeDesc())
           .append("\n");
        str.append("ContentParserId = ")
           .append(getContentParserId())
           .append("\n");
        return(str.toString());
    }
}
