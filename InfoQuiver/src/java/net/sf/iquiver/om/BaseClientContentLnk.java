package net.sf.iquiver.om;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
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
 * [Sun Apr 04 20:29:12 CEST 2004]
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to ClientContentLnk
 */
public abstract class BaseClientContentLnk extends BaseObject
{
    /** The Peer class */
    private static final ClientContentLnkPeer peer =
        new ClientContentLnkPeer();

        
    /** The value for the clientId field */
    private int clientId;
      
    /** The value for the contentId field */
    private long contentId;
      
    /** The value for the requestDatetime field */
    private Date requestDatetime;
  
    
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
    
                          
                if (aContent != null && !(aContent.getContentId() == v))
                {
            aContent = null;
        }
      
              }
  
    /**
     * Get the RequestDatetime
     *
     * @return Date
     */
    public Date getRequestDatetime()
    {
        return requestDatetime;
    }

                        
    /**
     * Set the value of RequestDatetime
     *
     * @param v new value
     */
    public void setRequestDatetime(Date v) 
    {
    
                  if (!ObjectUtils.equals(this.requestDatetime, v))
              {
            this.requestDatetime = v;
            setModified(true);
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
               obj.addClientContentLnks(this);
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
    
    
                  
    
        private Content aContent;

    /**
     * Declares an association between this object and a Content object
     *
     * @param v Content
     * @throws TorqueException
     */
    public void setContent(Content v) throws TorqueException
    {
            if (v == null)
        {
                    setContentId(0);
                  }
        else
        {
            setContentId(v.getContentId());
        }
                aContent = v;
    }

                                            
    /**
     * Get the associated Content object
     *
     * @return the associated Content object
     * @throws TorqueException
     */
    public Content getContent() throws TorqueException
    {
        if (aContent == null && (this.contentId > 0))
        {
                          aContent = ContentPeer.retrieveByPK(SimpleKey.keyFor(this.contentId));
              
            /* The following can be used instead of the line above to
               guarantee the related object contains a reference
               to this object, but this level of coupling
               may be undesirable in many circumstances.
               As it can lead to a db query with many results that may
               never be used.
               Content obj = ContentPeer.retrieveByPK(this.contentId);
               obj.addClientContentLnks(this);
            */
        }
        return aContent;
    }

    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey.  e.g.
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
           */
    public void setContentKey(ObjectKey key) throws TorqueException
    {
      
                        setContentId(((NumberKey) key).longValue());
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
              fieldNames.add("ClientId");
              fieldNames.add("ContentId");
              fieldNames.add("RequestDatetime");
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
          if (name.equals("ClientId"))
        {
                return new Integer(getClientId());
            }
          if (name.equals("ContentId"))
        {
                return new Long(getContentId());
            }
          if (name.equals("RequestDatetime"))
        {
                return getRequestDatetime();
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
          if (name.equals(ClientContentLnkPeer.CLIENT_ID))
        {
                return new Integer(getClientId());
            }
          if (name.equals(ClientContentLnkPeer.CONTENT_ID))
        {
                return new Long(getContentId());
            }
          if (name.equals(ClientContentLnkPeer.REQUEST_DATETIME))
        {
                return getRequestDatetime();
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
                return new Integer(getClientId());
            }
              if (pos == 1)
        {
                return new Long(getContentId());
            }
              if (pos == 2)
        {
                return getRequestDatetime();
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
          save(ClientContentLnkPeer.getMapBuilder()
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
                    ClientContentLnkPeer.doInsert((ClientContentLnk) this, con);
                    setNew(false);
                }
                else
                {
                    ClientContentLnkPeer.doUpdate((ClientContentLnk) this, con);
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
                      setClientId(((NumberKey)keys[0]).intValue());
                        setContentId(((NumberKey)keys[1]).longValue());
              }

    /**
     * Set the PrimaryKey using SimpleKeys.
     *
         * @param int clientId
         * @param long contentId
         */
    public void setPrimaryKey( int clientId, long contentId)
        throws TorqueException
    {
            setClientId(clientId);
            setContentId(contentId);
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
              pks[0] = SimpleKey.keyFor(getClientId());
                  pks[1] = SimpleKey.keyFor(getContentId());
                  return comboPK;
      }

 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
       * It then fills all the association collections and sets the
     * related objects to isNew=true.
       */
      public ClientContentLnk copy() throws TorqueException
    {
        return copyInto(new ClientContentLnk());
    }
  
    protected ClientContentLnk copyInto(ClientContentLnk copyObj) throws TorqueException
    {
          copyObj.setClientId(clientId);
          copyObj.setContentId(contentId);
          copyObj.setRequestDatetime(requestDatetime);
  
                    copyObj.setClientId(0);
                              copyObj.setContentId(0);
                  
        
        return copyObj;
    }

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public ClientContentLnkPeer getPeer()
    {
        return peer;
    }

    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("ClientContentLnk:\n");
        str.append("ClientId = ")
           .append(getClientId())
           .append("\n");
        str.append("ContentId = ")
           .append(getContentId())
           .append("\n");
        str.append("RequestDatetime = ")
           .append(getRequestDatetime())
           .append("\n");
        return(str.toString());
    }
}
