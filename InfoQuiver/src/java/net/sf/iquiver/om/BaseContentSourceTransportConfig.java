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
 * extended all references should be to ContentSourceTransportConfig
 */
public abstract class BaseContentSourceTransportConfig extends BaseObject
{
    /** The Peer class */
    private static final ContentSourceTransportConfigPeer peer =
        new ContentSourceTransportConfigPeer();

        
    /** The value for the contentSourceId field */
    private long contentSourceId;
      
    /** The value for the transportAttributeId field */
    private int transportAttributeId;
      
    /** The value for the transportAttributeValue field */
    private String transportAttributeValue;
  
    
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
    
                          
                if (aTransportAttribute != null && !(aTransportAttribute.getTransportAttributeId() == v))
                {
            aTransportAttribute = null;
        }
      
              }
  
    /**
     * Get the TransportAttributeValue
     *
     * @return String
     */
    public String getTransportAttributeValue()
    {
        return transportAttributeValue;
    }

                        
    /**
     * Set the value of TransportAttributeValue
     *
     * @param v new value
     */
    public void setTransportAttributeValue(String v) 
    {
    
                  if (!ObjectUtils.equals(this.transportAttributeValue, v))
              {
            this.transportAttributeValue = v;
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
               obj.addContentSourceTransportConfigs(this);
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
    
    
                  
    
        private TransportAttribute aTransportAttribute;

    /**
     * Declares an association between this object and a TransportAttribute object
     *
     * @param v TransportAttribute
     * @throws TorqueException
     */
    public void setTransportAttribute(TransportAttribute v) throws TorqueException
    {
            if (v == null)
        {
                    setTransportAttributeId(0);
                  }
        else
        {
            setTransportAttributeId(v.getTransportAttributeId());
        }
                aTransportAttribute = v;
    }

                                            
    /**
     * Get the associated TransportAttribute object
     *
     * @return the associated TransportAttribute object
     * @throws TorqueException
     */
    public TransportAttribute getTransportAttribute() throws TorqueException
    {
        if (aTransportAttribute == null && (this.transportAttributeId > 0))
        {
                          aTransportAttribute = TransportAttributePeer.retrieveByPK(SimpleKey.keyFor(this.transportAttributeId));
              
            /* The following can be used instead of the line above to
               guarantee the related object contains a reference
               to this object, but this level of coupling
               may be undesirable in many circumstances.
               As it can lead to a db query with many results that may
               never be used.
               TransportAttribute obj = TransportAttributePeer.retrieveByPK(this.transportAttributeId);
               obj.addContentSourceTransportConfigs(this);
            */
        }
        return aTransportAttribute;
    }

    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey.  e.g.
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
           */
    public void setTransportAttributeKey(ObjectKey key) throws TorqueException
    {
      
                        setTransportAttributeId(((NumberKey) key).intValue());
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
              fieldNames.add("ContentSourceId");
              fieldNames.add("TransportAttributeId");
              fieldNames.add("TransportAttributeValue");
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
          if (name.equals("ContentSourceId"))
        {
                return new Long(getContentSourceId());
            }
          if (name.equals("TransportAttributeId"))
        {
                return new Integer(getTransportAttributeId());
            }
          if (name.equals("TransportAttributeValue"))
        {
                return getTransportAttributeValue();
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
          if (name.equals(ContentSourceTransportConfigPeer.CONTENT_SOURCE_ID))
        {
                return new Long(getContentSourceId());
            }
          if (name.equals(ContentSourceTransportConfigPeer.TRANSPORT_ATTRIBUTE_ID))
        {
                return new Integer(getTransportAttributeId());
            }
          if (name.equals(ContentSourceTransportConfigPeer.TRANSPORT_ATTRIBUTE_VALUE))
        {
                return getTransportAttributeValue();
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
                return new Long(getContentSourceId());
            }
              if (pos == 1)
        {
                return new Integer(getTransportAttributeId());
            }
              if (pos == 2)
        {
                return getTransportAttributeValue();
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
          save(ContentSourceTransportConfigPeer.getMapBuilder()
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
                    ContentSourceTransportConfigPeer.doInsert((ContentSourceTransportConfig) this, con);
                    setNew(false);
                }
                else
                {
                    ContentSourceTransportConfigPeer.doUpdate((ContentSourceTransportConfig) this, con);
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
                      setContentSourceId(((NumberKey)keys[0]).longValue());
                        setTransportAttributeId(((NumberKey)keys[1]).intValue());
              }

    /**
     * Set the PrimaryKey using SimpleKeys.
     *
         * @param long contentSourceId
         * @param int transportAttributeId
         */
    public void setPrimaryKey( long contentSourceId, int transportAttributeId)
        throws TorqueException
    {
            setContentSourceId(contentSourceId);
            setTransportAttributeId(transportAttributeId);
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
              pks[0] = SimpleKey.keyFor(getContentSourceId());
                  pks[1] = SimpleKey.keyFor(getTransportAttributeId());
                  return comboPK;
      }

 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
       * It then fills all the association collections and sets the
     * related objects to isNew=true.
       */
      public ContentSourceTransportConfig copy() throws TorqueException
    {
        return copyInto(new ContentSourceTransportConfig());
    }
  
    protected ContentSourceTransportConfig copyInto(ContentSourceTransportConfig copyObj) throws TorqueException
    {
          copyObj.setContentSourceId(contentSourceId);
          copyObj.setTransportAttributeId(transportAttributeId);
          copyObj.setTransportAttributeValue(transportAttributeValue);
  
                    copyObj.setContentSourceId(0);
                              copyObj.setTransportAttributeId(0);
                  
        
        return copyObj;
    }

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public ContentSourceTransportConfigPeer getPeer()
    {
        return peer;
    }

    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("ContentSourceTransportConfig:\n");
        str.append("ContentSourceId = ")
           .append(getContentSourceId())
           .append("\n");
        str.append("TransportAttributeId = ")
           .append(getTransportAttributeId())
           .append("\n");
        str.append("TransportAttributeValue = ")
           .append(getTransportAttributeValue())
           .append("\n");
        return(str.toString());
    }
}