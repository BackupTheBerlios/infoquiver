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
 * [Sun Jul 04 16:22:33 CEST 2004]
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to ClientTransportLnk
 */
public abstract class BaseClientTransportLnk extends BaseObject
{
    /** The Peer class */
    private static final ClientTransportLnkPeer peer =
        new ClientTransportLnkPeer();

        
    /** The value for the clientId field */
    private int clientId;
      
    /** The value for the transportId field */
    private int transportId;
  
    
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
               obj.addClientTransportLnks(this);
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
               obj.addClientTransportLnks(this);
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
              fieldNames.add("TransportId");
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
          if (name.equals("TransportId"))
        {
                return new Integer(getTransportId());
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
          if (name.equals(ClientTransportLnkPeer.CLIENT_ID))
        {
                return new Integer(getClientId());
            }
          if (name.equals(ClientTransportLnkPeer.TRANSPORT_ID))
        {
                return new Integer(getTransportId());
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
                return new Integer(getTransportId());
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
          save(ClientTransportLnkPeer.getMapBuilder()
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
                    ClientTransportLnkPeer.doInsert((ClientTransportLnk) this, con);
                    setNew(false);
                }
                else
                {
                    ClientTransportLnkPeer.doUpdate((ClientTransportLnk) this, con);
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
                        setTransportId(((NumberKey)keys[1]).intValue());
              }

    /**
     * Set the PrimaryKey using SimpleKeys.
     *
         * @param int clientId
         * @param int transportId
         */
    public void setPrimaryKey( int clientId, int transportId)
        throws TorqueException
    {
            setClientId(clientId);
            setTransportId(transportId);
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
                  pks[1] = SimpleKey.keyFor(getTransportId());
                  return comboPK;
      }

 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
       * It then fills all the association collections and sets the
     * related objects to isNew=true.
       */
      public ClientTransportLnk copy() throws TorqueException
    {
        return copyInto(new ClientTransportLnk());
    }
  
    protected ClientTransportLnk copyInto(ClientTransportLnk copyObj) throws TorqueException
    {
          copyObj.setClientId(clientId);
          copyObj.setTransportId(transportId);
  
                    copyObj.setClientId(0);
                              copyObj.setTransportId(0);
            
        
        return copyObj;
    }

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public ClientTransportLnkPeer getPeer()
    {
        return peer;
    }

    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("ClientTransportLnk:\n");
        str.append("ClientId = ")
           .append(getClientId())
           .append("\n");
        str.append("TransportId = ")
           .append(getTransportId())
           .append("\n");
        return(str.toString());
    }
}
