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
 * extended all references should be to Content
 */
public abstract class BaseContent extends BaseObject
{
    /** The Peer class */
    private static final ContentPeer peer =
        new ContentPeer();

        
    /** The value for the contentId field */
    private long contentId;
      
    /** The value for the contentTypeId field */
    private int contentTypeId;
      
    /** The value for the contentSourceId field */
    private long contentSourceId;
      
    /** The value for the contentReceiveDatetime field */
    private Date contentReceiveDatetime;
      
    /** The value for the contentLocale field */
    private String contentLocale;
      
    /** The value for the contentDateOfCreation field */
    private Date contentDateOfCreation;
      
    /** The value for the contentDateOfLastModification field */
    private Date contentDateOfLastModification;
      
    /** The value for the contentName field */
    private String contentName;
      
    /** The value for the contentTitle field */
    private String contentTitle;
      
    /** The value for the contentShortDescription field */
    private String contentShortDescription;
      
    /** The value for the contentInfoUrl field */
    private String contentInfoUrl;
      
    /** The value for the contentAuthor field */
    private String contentAuthor;
      
    /** The value for the contentContent field */
    private String contentContent;
  
    
    /**
     * Get the ContentId
     *
     * @return long
     */
    public long getContentId()
    {
        return contentId;
    }

                                              
    /**
     * Set the value of ContentId
     *
     * @param v new value
     */
    public void setContentId(long v) throws TorqueException
    {
    
                  if (this.contentId != v)
              {
            this.contentId = v;
            setModified(true);
        }
    
          
                                  
        // update associated ClientContentLnk
        if (collClientContentLnks != null)
        {
            for (int i = 0; i < collClientContentLnks.size(); i++)
            {
                ((ClientContentLnk) collClientContentLnks.get(i))
                    .setContentId(v);
            }
        }
                      }
  
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
    public void setContentTypeId(int v) 
    {
    
                  if (this.contentTypeId != v)
              {
            this.contentTypeId = v;
            setModified(true);
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
  
    /**
     * Get the ContentReceiveDatetime
     *
     * @return Date
     */
    public Date getContentReceiveDatetime()
    {
        return contentReceiveDatetime;
    }

                        
    /**
     * Set the value of ContentReceiveDatetime
     *
     * @param v new value
     */
    public void setContentReceiveDatetime(Date v) 
    {
    
                  if (!ObjectUtils.equals(this.contentReceiveDatetime, v))
              {
            this.contentReceiveDatetime = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the ContentLocale
     *
     * @return String
     */
    public String getContentLocale()
    {
        return contentLocale;
    }

                        
    /**
     * Set the value of ContentLocale
     *
     * @param v new value
     */
    public void setContentLocale(String v) 
    {
    
                  if (!ObjectUtils.equals(this.contentLocale, v))
              {
            this.contentLocale = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the ContentDateOfCreation
     *
     * @return Date
     */
    public Date getContentDateOfCreation()
    {
        return contentDateOfCreation;
    }

                        
    /**
     * Set the value of ContentDateOfCreation
     *
     * @param v new value
     */
    public void setContentDateOfCreation(Date v) 
    {
    
                  if (!ObjectUtils.equals(this.contentDateOfCreation, v))
              {
            this.contentDateOfCreation = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the ContentDateOfLastModification
     *
     * @return Date
     */
    public Date getContentDateOfLastModification()
    {
        return contentDateOfLastModification;
    }

                        
    /**
     * Set the value of ContentDateOfLastModification
     *
     * @param v new value
     */
    public void setContentDateOfLastModification(Date v) 
    {
    
                  if (!ObjectUtils.equals(this.contentDateOfLastModification, v))
              {
            this.contentDateOfLastModification = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the ContentName
     *
     * @return String
     */
    public String getContentName()
    {
        return contentName;
    }

                        
    /**
     * Set the value of ContentName
     *
     * @param v new value
     */
    public void setContentName(String v) 
    {
    
                  if (!ObjectUtils.equals(this.contentName, v))
              {
            this.contentName = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the ContentTitle
     *
     * @return String
     */
    public String getContentTitle()
    {
        return contentTitle;
    }

                        
    /**
     * Set the value of ContentTitle
     *
     * @param v new value
     */
    public void setContentTitle(String v) 
    {
    
                  if (!ObjectUtils.equals(this.contentTitle, v))
              {
            this.contentTitle = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the ContentShortDescription
     *
     * @return String
     */
    public String getContentShortDescription()
    {
        return contentShortDescription;
    }

                        
    /**
     * Set the value of ContentShortDescription
     *
     * @param v new value
     */
    public void setContentShortDescription(String v) 
    {
    
                  if (!ObjectUtils.equals(this.contentShortDescription, v))
              {
            this.contentShortDescription = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the ContentInfoUrl
     *
     * @return String
     */
    public String getContentInfoUrl()
    {
        return contentInfoUrl;
    }

                        
    /**
     * Set the value of ContentInfoUrl
     *
     * @param v new value
     */
    public void setContentInfoUrl(String v) 
    {
    
                  if (!ObjectUtils.equals(this.contentInfoUrl, v))
              {
            this.contentInfoUrl = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the ContentAuthor
     *
     * @return String
     */
    public String getContentAuthor()
    {
        return contentAuthor;
    }

                        
    /**
     * Set the value of ContentAuthor
     *
     * @param v new value
     */
    public void setContentAuthor(String v) 
    {
    
                  if (!ObjectUtils.equals(this.contentAuthor, v))
              {
            this.contentAuthor = v;
            setModified(true);
        }
    
          
              }
  
    /**
     * Get the ContentContent
     *
     * @return String
     */
    public String getContentContent()
    {
        return contentContent;
    }

                        
    /**
     * Set the value of ContentContent
     *
     * @param v new value
     */
    public void setContentContent(String v) 
    {
    
                  if (!ObjectUtils.equals(this.contentContent, v))
              {
            this.contentContent = v;
            setModified(true);
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
               obj.addContents(this);
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
       
                                
            
    /**
     * Collection to store aggregation of collClientContentLnks
     */
    protected List collClientContentLnks;

    /**
     * Temporary storage of collClientContentLnks to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initClientContentLnks()
    {
        if (collClientContentLnks == null)
        {
            collClientContentLnks = new ArrayList();
        }
    }

    /**
     * Method called to associate a ClientContentLnk object to this object
     * through the ClientContentLnk foreign key attribute
     *
     * @param l ClientContentLnk
     * @throws TorqueException
     */
    public void addClientContentLnk(ClientContentLnk l) throws TorqueException
    {
        getClientContentLnks().add(l);
        l.setContent((Content) this);
    }

    /**
     * The criteria used to select the current contents of collClientContentLnks
     */
    private Criteria lastClientContentLnksCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getClientContentLnks(new Criteria())
     *
     * @throws TorqueException
     */
    public List getClientContentLnks() throws TorqueException
    {
        if (collClientContentLnks == null)
        {
            collClientContentLnks = getClientContentLnks(new Criteria(10));
        }
        return collClientContentLnks;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Content has previously
     * been saved, it will retrieve related ClientContentLnks from storage.
     * If this Content is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List getClientContentLnks(Criteria criteria) throws TorqueException
    {
        if (collClientContentLnks == null)
        {
            if (isNew())
            {
               collClientContentLnks = new ArrayList();
            }
            else
            {
                      criteria.add(ClientContentLnkPeer.CONTENT_ID, getContentId() );
                      collClientContentLnks = ClientContentLnkPeer.doSelect(criteria);
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
                      criteria.add(ClientContentLnkPeer.CONTENT_ID, getContentId());
                      if (!lastClientContentLnksCriteria.equals(criteria))
                {
                    collClientContentLnks = ClientContentLnkPeer.doSelect(criteria);
                }
            }
        }
        lastClientContentLnksCriteria = criteria;

        return collClientContentLnks;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getClientContentLnks(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List getClientContentLnks(Connection con) throws TorqueException
    {
        if (collClientContentLnks == null)
        {
            collClientContentLnks = getClientContentLnks(new Criteria(10), con);
        }
        return collClientContentLnks;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Content has previously
     * been saved, it will retrieve related ClientContentLnks from storage.
     * If this Content is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List getClientContentLnks(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collClientContentLnks == null)
        {
            if (isNew())
            {
               collClientContentLnks = new ArrayList();
            }
            else
            {
                       criteria.add(ClientContentLnkPeer.CONTENT_ID, getContentId());
                       collClientContentLnks = ClientContentLnkPeer.doSelect(criteria, con);
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
                       criteria.add(ClientContentLnkPeer.CONTENT_ID, getContentId());
                       if (!lastClientContentLnksCriteria.equals(criteria))
                 {
                     collClientContentLnks = ClientContentLnkPeer.doSelect(criteria, con);
                 }
             }
         }
         lastClientContentLnksCriteria = criteria;

         return collClientContentLnks;
     }

                        
              
                    
                    
                                
                                                              
                                        
                    
                    
          
    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Content is new, it will return
     * an empty collection; or if this Content has previously
     * been saved, it will retrieve related ClientContentLnks from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Content.
     */
    protected List getClientContentLnksJoinClient(Criteria criteria)
        throws TorqueException
    {
        if (collClientContentLnks == null)
        {
            if (isNew())
            {
               collClientContentLnks = new ArrayList();
            }
            else
            {
                            criteria.add(ClientContentLnkPeer.CONTENT_ID, getContentId());
                            collClientContentLnks = ClientContentLnkPeer.doSelectJoinClient(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            boolean newCriteria = true;
                        criteria.add(ClientContentLnkPeer.CONTENT_ID, getContentId());
                        if (!lastClientContentLnksCriteria.equals(criteria))
            {
                collClientContentLnks = ClientContentLnkPeer.doSelectJoinClient(criteria);
            }
        }
        lastClientContentLnksCriteria = criteria;

        return collClientContentLnks;
    }
                  
                    
                              
                                
                                                              
                                        
                    
                    
          
    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Content is new, it will return
     * an empty collection; or if this Content has previously
     * been saved, it will retrieve related ClientContentLnks from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Content.
     */
    protected List getClientContentLnksJoinContent(Criteria criteria)
        throws TorqueException
    {
        if (collClientContentLnks == null)
        {
            if (isNew())
            {
               collClientContentLnks = new ArrayList();
            }
            else
            {
                            criteria.add(ClientContentLnkPeer.CONTENT_ID, getContentId());
                            collClientContentLnks = ClientContentLnkPeer.doSelectJoinContent(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            boolean newCriteria = true;
                        criteria.add(ClientContentLnkPeer.CONTENT_ID, getContentId());
                        if (!lastClientContentLnksCriteria.equals(criteria))
            {
                collClientContentLnks = ClientContentLnkPeer.doSelectJoinContent(criteria);
            }
        }
        lastClientContentLnksCriteria = criteria;

        return collClientContentLnks;
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
              fieldNames.add("ContentId");
              fieldNames.add("ContentTypeId");
              fieldNames.add("ContentSourceId");
              fieldNames.add("ContentReceiveDatetime");
              fieldNames.add("ContentLocale");
              fieldNames.add("ContentDateOfCreation");
              fieldNames.add("ContentDateOfLastModification");
              fieldNames.add("ContentName");
              fieldNames.add("ContentTitle");
              fieldNames.add("ContentShortDescription");
              fieldNames.add("ContentInfoUrl");
              fieldNames.add("ContentAuthor");
              fieldNames.add("ContentContent");
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
          if (name.equals("ContentId"))
        {
                return new Long(getContentId());
            }
          if (name.equals("ContentTypeId"))
        {
                return new Integer(getContentTypeId());
            }
          if (name.equals("ContentSourceId"))
        {
                return new Long(getContentSourceId());
            }
          if (name.equals("ContentReceiveDatetime"))
        {
                return getContentReceiveDatetime();
            }
          if (name.equals("ContentLocale"))
        {
                return getContentLocale();
            }
          if (name.equals("ContentDateOfCreation"))
        {
                return getContentDateOfCreation();
            }
          if (name.equals("ContentDateOfLastModification"))
        {
                return getContentDateOfLastModification();
            }
          if (name.equals("ContentName"))
        {
                return getContentName();
            }
          if (name.equals("ContentTitle"))
        {
                return getContentTitle();
            }
          if (name.equals("ContentShortDescription"))
        {
                return getContentShortDescription();
            }
          if (name.equals("ContentInfoUrl"))
        {
                return getContentInfoUrl();
            }
          if (name.equals("ContentAuthor"))
        {
                return getContentAuthor();
            }
          if (name.equals("ContentContent"))
        {
                return getContentContent();
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
          if (name.equals(ContentPeer.CONTENT_ID))
        {
                return new Long(getContentId());
            }
          if (name.equals(ContentPeer.CONTENT_TYPE_ID))
        {
                return new Integer(getContentTypeId());
            }
          if (name.equals(ContentPeer.CONTENT_SOURCE_ID))
        {
                return new Long(getContentSourceId());
            }
          if (name.equals(ContentPeer.CONTENT_RECEIVE_DATETIME))
        {
                return getContentReceiveDatetime();
            }
          if (name.equals(ContentPeer.CONTENT_LOCALE))
        {
                return getContentLocale();
            }
          if (name.equals(ContentPeer.CONTENT_DATE_OF_CREATION))
        {
                return getContentDateOfCreation();
            }
          if (name.equals(ContentPeer.CONTENT_DATE_OF_LAST_MODIFICATION))
        {
                return getContentDateOfLastModification();
            }
          if (name.equals(ContentPeer.CONTENT_NAME))
        {
                return getContentName();
            }
          if (name.equals(ContentPeer.CONTENT_TITLE))
        {
                return getContentTitle();
            }
          if (name.equals(ContentPeer.CONTENT_SHORT_DESCRIPTION))
        {
                return getContentShortDescription();
            }
          if (name.equals(ContentPeer.CONTENT_INFO_URL))
        {
                return getContentInfoUrl();
            }
          if (name.equals(ContentPeer.CONTENT_AUTHOR))
        {
                return getContentAuthor();
            }
          if (name.equals(ContentPeer.CONTENT_CONTENT))
        {
                return getContentContent();
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
                return new Long(getContentId());
            }
              if (pos == 1)
        {
                return new Integer(getContentTypeId());
            }
              if (pos == 2)
        {
                return new Long(getContentSourceId());
            }
              if (pos == 3)
        {
                return getContentReceiveDatetime();
            }
              if (pos == 4)
        {
                return getContentLocale();
            }
              if (pos == 5)
        {
                return getContentDateOfCreation();
            }
              if (pos == 6)
        {
                return getContentDateOfLastModification();
            }
              if (pos == 7)
        {
                return getContentName();
            }
              if (pos == 8)
        {
                return getContentTitle();
            }
              if (pos == 9)
        {
                return getContentShortDescription();
            }
              if (pos == 10)
        {
                return getContentInfoUrl();
            }
              if (pos == 11)
        {
                return getContentAuthor();
            }
              if (pos == 12)
        {
                return getContentContent();
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
          save(ContentPeer.getMapBuilder()
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
                    ContentPeer.doInsert((Content) this, con);
                    setNew(false);
                }
                else
                {
                    ContentPeer.doUpdate((Content) this, con);
                }
            }

                                      
                
            if (collClientContentLnks != null)
            {
                for (int i = 0; i < collClientContentLnks.size(); i++)
                {
                    ((ClientContentLnk) collClientContentLnks.get(i)).save(con);
                }
            }
                          alreadyInSave = false;
        }
      }


                          
      /**
     * Set the PrimaryKey using ObjectKey.
     *
     * @param  contentId ObjectKey
     */
    public void setPrimaryKey(ObjectKey key)
        throws TorqueException
    {
            setContentId(((NumberKey) key).longValue());
        }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) throws TorqueException
    {
            setContentId(Long.parseLong(key));
        }

  
    /**
     * returns an id that differentiates this object from others
     * of its class.
     */
    public ObjectKey getPrimaryKey()
    {
          return SimpleKey.keyFor(getContentId());
      }

 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
       * It then fills all the association collections and sets the
     * related objects to isNew=true.
       */
      public Content copy() throws TorqueException
    {
        return copyInto(new Content());
    }
  
    protected Content copyInto(Content copyObj) throws TorqueException
    {
          copyObj.setContentId(contentId);
          copyObj.setContentTypeId(contentTypeId);
          copyObj.setContentSourceId(contentSourceId);
          copyObj.setContentReceiveDatetime(contentReceiveDatetime);
          copyObj.setContentLocale(contentLocale);
          copyObj.setContentDateOfCreation(contentDateOfCreation);
          copyObj.setContentDateOfLastModification(contentDateOfLastModification);
          copyObj.setContentName(contentName);
          copyObj.setContentTitle(contentTitle);
          copyObj.setContentShortDescription(contentShortDescription);
          copyObj.setContentInfoUrl(contentInfoUrl);
          copyObj.setContentAuthor(contentAuthor);
          copyObj.setContentContent(contentContent);
  
                    copyObj.setContentId(0);
                                                                                    
                                      
                
        List v = getClientContentLnks();
        for (int i = 0; i < v.size(); i++)
        {
            ClientContentLnk obj = (ClientContentLnk) v.get(i);
            copyObj.addClientContentLnk(obj.copy());
        }
                    
        return copyObj;
    }

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public ContentPeer getPeer()
    {
        return peer;
    }

    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Content:\n");
        str.append("ContentId = ")
           .append(getContentId())
           .append("\n");
        str.append("ContentTypeId = ")
           .append(getContentTypeId())
           .append("\n");
        str.append("ContentSourceId = ")
           .append(getContentSourceId())
           .append("\n");
        str.append("ContentReceiveDatetime = ")
           .append(getContentReceiveDatetime())
           .append("\n");
        str.append("ContentLocale = ")
           .append(getContentLocale())
           .append("\n");
        str.append("ContentDateOfCreation = ")
           .append(getContentDateOfCreation())
           .append("\n");
        str.append("ContentDateOfLastModification = ")
           .append(getContentDateOfLastModification())
           .append("\n");
        str.append("ContentName = ")
           .append(getContentName())
           .append("\n");
        str.append("ContentTitle = ")
           .append(getContentTitle())
           .append("\n");
        str.append("ContentShortDescription = ")
           .append(getContentShortDescription())
           .append("\n");
        str.append("ContentInfoUrl = ")
           .append(getContentInfoUrl())
           .append("\n");
        str.append("ContentAuthor = ")
           .append(getContentAuthor())
           .append("\n");
        str.append("ContentContent = ")
           .append(getContentContent())
           .append("\n");
        return(str.toString());
    }
}