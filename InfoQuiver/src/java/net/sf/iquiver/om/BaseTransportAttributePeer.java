package net.sf.iquiver.om;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import net.sf.iquiver.om.map.TransportAttributeMapBuilder;

import org.apache.torque.NoRowsException;
import org.apache.torque.TooManyRowsException;
import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.map.MapBuilder;
import org.apache.torque.map.TableMap;
import org.apache.torque.om.ObjectKey;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.util.BasePeer;
import org.apache.torque.util.Criteria;

import com.workingdogs.village.DataSetException;
import com.workingdogs.village.QueryDataSet;
import com.workingdogs.village.Record;


  
/**
 * This class was autogenerated by Torque on:
 *
 * [Mon Jun 28 22:47:06 CEST 2004]
 *
 */
public abstract class BaseTransportAttributePeer
    extends net.sf.iquiver.util.om.CacheBackedPeer
{

    /** the default database name for this class */
    public static final String DATABASE_NAME = "iquiver";

     /** the table name for this class */
    public static final String TABLE_NAME = "iq_transport_attribute";

    /**
     * @return the map builder for this peer
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static MapBuilder getMapBuilder()
        throws TorqueException
    {
        return getMapBuilder(TransportAttributeMapBuilder.CLASS_NAME);
    }

      /** the column name for the TRANSPORT_ATTRIBUTE_ID field */
    public static final String TRANSPORT_ATTRIBUTE_ID;
      /** the column name for the TRANSPORT_ID field */
    public static final String TRANSPORT_ID;
      /** the column name for the TRANSPORT_ATTRIBUTE_NAME field */
    public static final String TRANSPORT_ATTRIBUTE_NAME;
      /** the column name for the TRANSPORT_ATTRIBUTE_TYPE field */
    public static final String TRANSPORT_ATTRIBUTE_TYPE;
      /** the column name for the IS_PART_OF_AUTHENTIFICATION field */
    public static final String IS_PART_OF_AUTHENTIFICATION;
      /** the column name for the IS_MANDATORY field */
    public static final String IS_MANDATORY;
  
    static
    {
          TRANSPORT_ATTRIBUTE_ID = "iq_transport_attribute.TRANSPORT_ATTRIBUTE_ID";
          TRANSPORT_ID = "iq_transport_attribute.TRANSPORT_ID";
          TRANSPORT_ATTRIBUTE_NAME = "iq_transport_attribute.TRANSPORT_ATTRIBUTE_NAME";
          TRANSPORT_ATTRIBUTE_TYPE = "iq_transport_attribute.TRANSPORT_ATTRIBUTE_TYPE";
          IS_PART_OF_AUTHENTIFICATION = "iq_transport_attribute.IS_PART_OF_AUTHENTIFICATION";
          IS_MANDATORY = "iq_transport_attribute.IS_MANDATORY";
          if (Torque.isInit())
        {
            try
            {
                getMapBuilder(TransportAttributeMapBuilder.CLASS_NAME);
            }
            catch (Exception e)
            {
                log.error("Could not initialize Peer", e);
            }
        }
        else
        {
            Torque.registerMapBuilder(TransportAttributeMapBuilder.CLASS_NAME);
        }
    }
 
    /** number of columns for this peer */
    public static final int numColumns =  6;

    /** A class that can be returned by this peer. */
    protected static final String CLASSNAME_DEFAULT =
        "net.sf.iquiver.om.TransportAttribute";

    /** A class that can be returned by this peer. */
    protected static final Class CLASS_DEFAULT = initClass(CLASSNAME_DEFAULT);

    /**
     * Class object initialization method.
     *
     * @param className name of the class to initialize
     * @return the initialized class
     */
    private static Class initClass(String className)
    {
        Class c = null;
        try
        {
            c = Class.forName(className);
        }
        catch (Throwable t)
        {
            log.error("A FATAL ERROR has occurred which should not "
                + "have happened under any circumstance.  Please notify "
                + "the Torque developers <torque-dev@db.apache.org> "
                + "and give as many details as possible (including the error "
                + "stack trace).", t);

            // Error objects should always be propogated.
            if (t instanceof Error)
            {
                throw (Error) t.fillInStackTrace();
            }
        }
        return c;
    }

    /**
     * Get the list of objects for a ResultSet.  Please not that your
     * resultset MUST return columns in the right order.  You can use
     * getFieldNames() in BaseObject to get the correct sequence.
     *
     * @param results the ResultSet
     * @return the list of objects
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List resultSet2Objects(java.sql.ResultSet results)
            throws TorqueException
    {
        try
        {
            QueryDataSet qds = null;
            List rows = null;
            try
            {
                qds = new QueryDataSet(results);
                rows = getSelectResults(qds);
            }
            finally
            {
                if (qds != null)
                {
                    qds.close();
                }
            }

            return populateObjects(rows);
        }
        catch (SQLException e)
        {
            throw new TorqueException(e);
        }
        catch (DataSetException e)
        {
            throw new TorqueException(e);
        }
    }


  
    /**
     * Method to do inserts.
     *
     * @param criteria object used to create the INSERT statement.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static ObjectKey doInsert(Criteria criteria)
        throws TorqueException
    {
        return BaseTransportAttributePeer
            .doInsert(criteria, (Connection) null);
    }

    /**
     * Method to do inserts.  This method is to be used during a transaction,
     * otherwise use the doInsert(Criteria) method.  It will take care of
     * the connection details internally.
     *
     * @param criteria object used to create the INSERT statement.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static ObjectKey doInsert(Criteria criteria, Connection con)
        throws TorqueException
    {
                                      // check for conversion from boolean to Y/N
        if (criteria.containsKey(IS_PART_OF_AUTHENTIFICATION))
        {
            Object possibleBoolean = criteria.get(IS_PART_OF_AUTHENTIFICATION);
            if (possibleBoolean instanceof Boolean)
            {
                if (((Boolean) possibleBoolean).booleanValue())
                {
                    criteria.add(IS_PART_OF_AUTHENTIFICATION, "Y");
                }
                else
                {
                    criteria.add(IS_PART_OF_AUTHENTIFICATION, "N");
                }
            }
         }
                  // check for conversion from boolean to Y/N
        if (criteria.containsKey(IS_MANDATORY))
        {
            Object possibleBoolean = criteria.get(IS_MANDATORY);
            if (possibleBoolean instanceof Boolean)
            {
                if (((Boolean) possibleBoolean).booleanValue())
                {
                    criteria.add(IS_MANDATORY, "Y");
                }
                else
                {
                    criteria.add(IS_MANDATORY, "N");
                }
            }
         }
      
        // Set the correct dbName if it has not been overridden
        // criteria.getDbName will return the same object if not set to
        // another value so == check is okay and faster
        if (criteria.getDbName() == Torque.getDefaultDB())
        {
            criteria.setDbName(DATABASE_NAME);
        }
        if (con == null)
        {
            return BasePeer.doInsert(criteria);
        }
        else
        {
            return BasePeer.doInsert(criteria, con);
        }
    }

    /**
     * Add all the columns needed to create a new object.
     *
     * @param criteria object containing the columns to add.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void addSelectColumns(Criteria criteria)
            throws TorqueException
    {
          criteria.addSelectColumn(TRANSPORT_ATTRIBUTE_ID);
          criteria.addSelectColumn(TRANSPORT_ID);
          criteria.addSelectColumn(TRANSPORT_ATTRIBUTE_NAME);
          criteria.addSelectColumn(TRANSPORT_ATTRIBUTE_TYPE);
          criteria.addSelectColumn(IS_PART_OF_AUTHENTIFICATION);
          criteria.addSelectColumn(IS_MANDATORY);
      }

    /**
     * Create a new object of type cls from a resultset row starting
     * from a specified offset.  This is done so that you can select
     * other rows than just those needed for this object.  You may
     * for example want to create two objects from the same row.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static TransportAttribute row2Object(Record row,
                                             int offset,
                                             Class cls)
        throws TorqueException
    {
        try
        {
            TransportAttribute obj = (TransportAttribute) cls.newInstance();
            TransportAttributePeer.populateObject(row, offset, obj);
                  obj.setModified(false);
              obj.setNew(false);

            return obj;
        }
        catch (InstantiationException e)
        {
            throw new TorqueException(e);
        }
        catch (IllegalAccessException e)
        {
            throw new TorqueException(e);
        }
    }

    /**
     * Populates an object from a resultset row starting
     * from a specified offset.  This is done so that you can select
     * other rows than just those needed for this object.  You may
     * for example want to create two objects from the same row.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void populateObject(Record row,
                                      int offset,
                                      TransportAttribute obj)
        throws TorqueException
    {
        try
        {
                obj.setTransportAttributeId(row.getValue(offset + 0).asInt());
                  obj.setTransportId(row.getValue(offset + 1).asInt());
                  obj.setTransportAttributeName(row.getValue(offset + 2).asString());
                  obj.setTransportAttributeType(row.getValue(offset + 3).asString());
                  obj.setIsPartOfAuthentification(row.getValue(offset + 4).asBoolean());
                  obj.setIsMandatory(row.getValue(offset + 5).asBoolean());
              }
        catch (DataSetException e)
        {
            throw new TorqueException(e);
        }
    }

    /**
     * Method to do selects.
     *
     * @param criteria object used to create the SELECT statement.
     * @return List of selected Objects
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List doSelect(Criteria criteria) throws TorqueException
    {
        return populateObjects(doSelectVillageRecords(criteria));
    }

    /**
     * Method to do selects within a transaction.
     *
     * @param criteria object used to create the SELECT statement.
     * @param con the connection to use
     * @return List of selected Objects
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List doSelect(Criteria criteria, Connection con)
        throws TorqueException
    {
        return populateObjects(doSelectVillageRecords(criteria, con));
    }

    /**
     * Grabs the raw Village records to be formed into objects.
     * This method handles connections internally.  The Record objects
     * returned by this method should be considered readonly.  Do not
     * alter the data and call save(), your results may vary, but are
     * certainly likely to result in hard to track MT bugs.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List doSelectVillageRecords(Criteria criteria)
        throws TorqueException
    {
        return BaseTransportAttributePeer
            .doSelectVillageRecords(criteria, (Connection) null);
    }

    /**
     * Grabs the raw Village records to be formed into objects.
     * This method should be used for transactions
     *
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List doSelectVillageRecords(Criteria criteria, Connection con)
        throws TorqueException
    {
        if (criteria.getSelectColumns().size() == 0)
        {
            addSelectColumns(criteria);
        }

                                      // check for conversion from boolean to Y/N
        if (criteria.containsKey(IS_PART_OF_AUTHENTIFICATION))
        {
            Object possibleBoolean = criteria.get(IS_PART_OF_AUTHENTIFICATION);
            if (possibleBoolean instanceof Boolean)
            {
                if (((Boolean) possibleBoolean).booleanValue())
                {
                    criteria.add(IS_PART_OF_AUTHENTIFICATION, "Y");
                }
                else
                {
                    criteria.add(IS_PART_OF_AUTHENTIFICATION, "N");
                }
            }
         }
                  // check for conversion from boolean to Y/N
        if (criteria.containsKey(IS_MANDATORY))
        {
            Object possibleBoolean = criteria.get(IS_MANDATORY);
            if (possibleBoolean instanceof Boolean)
            {
                if (((Boolean) possibleBoolean).booleanValue())
                {
                    criteria.add(IS_MANDATORY, "Y");
                }
                else
                {
                    criteria.add(IS_MANDATORY, "N");
                }
            }
         }
      
        // Set the correct dbName if it has not been overridden
        // criteria.getDbName will return the same object if not set to
        // another value so == check is okay and faster
        if (criteria.getDbName() == Torque.getDefaultDB())
        {
            criteria.setDbName(DATABASE_NAME);
        }
        // BasePeer returns a List of Value (Village) arrays.  The array
        // order follows the order columns were placed in the Select clause.
        if (con == null)
        {
            return BasePeer.doSelect(criteria);
        }
        else
        {
            return BasePeer.doSelect(criteria, con);
        }
    }

    /**
     * The returned List will contain objects of the default type or
     * objects that inherit from the default.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List populateObjects(List records)
        throws TorqueException
    {
        List results = new ArrayList(records.size());

        // populate the object(s)
        for (int i = 0; i < records.size(); i++)
        {
            Record row = (Record) records.get(i);
              results.add(TransportAttributePeer.row2Object(row, 1,
                TransportAttributePeer.getOMClass()));
          }
        return results;
    }
 

    /**
     * The class that the Peer will make instances of.
     * If the BO is abstract then you must implement this method
     * in the BO.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static Class getOMClass()
        throws TorqueException
    {
        return CLASS_DEFAULT;
    }

    /**
     * Method to do updates.
     *
     * @param criteria object containing data that is used to create the UPDATE
     *        statement.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doUpdate(Criteria criteria) throws TorqueException
    {
         BaseTransportAttributePeer
            .doUpdate(criteria, (Connection) null);
    }

    /**
     * Method to do updates.  This method is to be used during a transaction,
     * otherwise use the doUpdate(Criteria) method.  It will take care of
     * the connection details internally.
     *
     * @param criteria object containing data that is used to create the UPDATE
     *        statement.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doUpdate(Criteria criteria, Connection con)
        throws TorqueException
    {
        Criteria selectCriteria = new Criteria(DATABASE_NAME, 2);
                   selectCriteria.put(TRANSPORT_ATTRIBUTE_ID, criteria.remove(TRANSPORT_ATTRIBUTE_ID));
                                                // check for conversion from boolean to int
        if (criteria.containsKey(IS_PART_OF_AUTHENTIFICATION))
        {
            Object possibleBoolean = criteria.get(IS_PART_OF_AUTHENTIFICATION);
            if (possibleBoolean instanceof Boolean)
            {
                if (((Boolean) possibleBoolean).booleanValue())
                {
                    criteria.add(IS_PART_OF_AUTHENTIFICATION, "Y");
                }
                else
                {
                    criteria.add(IS_PART_OF_AUTHENTIFICATION, "N");
                }
            }
         }
                      // check for conversion from boolean to int
        if (criteria.containsKey(IS_MANDATORY))
        {
            Object possibleBoolean = criteria.get(IS_MANDATORY);
            if (possibleBoolean instanceof Boolean)
            {
                if (((Boolean) possibleBoolean).booleanValue())
                {
                    criteria.add(IS_MANDATORY, "Y");
                }
                else
                {
                    criteria.add(IS_MANDATORY, "N");
                }
            }
         }
          
        // Set the correct dbName if it has not been overridden
        // criteria.getDbName will return the same object if not set to
        // another value so == check is okay and faster
        if (criteria.getDbName() == Torque.getDefaultDB())
        {
            criteria.setDbName(DATABASE_NAME);
        }
        if (con == null)
        {
            BasePeer.doUpdate(selectCriteria, criteria);
        }
        else
        {
            BasePeer.doUpdate(selectCriteria, criteria, con);
        }
    }

    /**
     * Method to do deletes.
     *
     * @param criteria object containing data that is used DELETE from database.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
     public static void doDelete(Criteria criteria) throws TorqueException
     {
         BaseTransportAttributePeer
            .doDelete(criteria, (Connection) null);
     }

    /**
     * Method to do deletes.  This method is to be used during a transaction,
     * otherwise use the doDelete(Criteria) method.  It will take care of
     * the connection details internally.
     *
     * @param criteria object containing data that is used DELETE from database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
     public static void doDelete(Criteria criteria, Connection con)
        throws TorqueException
     {
                                      // check for conversion from boolean to Y/N
        if (criteria.containsKey(IS_PART_OF_AUTHENTIFICATION))
        {
            Object possibleBoolean = criteria.get(IS_PART_OF_AUTHENTIFICATION);
            if (possibleBoolean instanceof Boolean)
            {
                if (((Boolean) possibleBoolean).booleanValue())
                {
                    criteria.add(IS_PART_OF_AUTHENTIFICATION, "Y");
                }
                else
                {
                    criteria.add(IS_PART_OF_AUTHENTIFICATION, "N");
                }
            }
         }
                  // check for conversion from boolean to Y/N
        if (criteria.containsKey(IS_MANDATORY))
        {
            Object possibleBoolean = criteria.get(IS_MANDATORY);
            if (possibleBoolean instanceof Boolean)
            {
                if (((Boolean) possibleBoolean).booleanValue())
                {
                    criteria.add(IS_MANDATORY, "Y");
                }
                else
                {
                    criteria.add(IS_MANDATORY, "N");
                }
            }
         }
      
        // Set the correct dbName if it has not been overridden
        // criteria.getDbName will return the same object if not set to
        // another value so == check is okay and faster
        if (criteria.getDbName() == Torque.getDefaultDB())
        {
            criteria.setDbName(DATABASE_NAME);
        }
        if (con == null)
        {
            BasePeer.doDelete(criteria);
        }
        else
        {
            BasePeer.doDelete(criteria, con);
        }
     }

    /**
     * Method to do selects
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List doSelect(TransportAttribute obj) throws TorqueException
    {
        return doSelect(buildCriteria(obj));
    }

    /**
     * Method to do inserts
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doInsert(TransportAttribute obj) throws TorqueException
    {
          obj.setPrimaryKey(doInsert(buildCriteria(obj)));
          obj.setNew(false);
        obj.setModified(false);
    }

    /**
     * @param obj the data object to update in the database.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doUpdate(TransportAttribute obj) throws TorqueException
    {
        doUpdate(buildCriteria(obj));
        obj.setModified(false);
    }

    /**
     * @param obj the data object to delete in the database.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doDelete(TransportAttribute obj) throws TorqueException
    {
        doDelete(buildCriteria(obj));
    }

    /**
     * Method to do inserts.  This method is to be used during a transaction,
     * otherwise use the doInsert(TransportAttribute) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to insert into the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doInsert(TransportAttribute obj, Connection con)
        throws TorqueException
    {
          obj.setPrimaryKey(doInsert(buildCriteria(obj), con));
          obj.setNew(false);
        obj.setModified(false);
    }

    /**
     * Method to do update.  This method is to be used during a transaction,
     * otherwise use the doUpdate(TransportAttribute) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to update in the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doUpdate(TransportAttribute obj, Connection con)
        throws TorqueException
    {
        doUpdate(buildCriteria(obj), con);
        obj.setModified(false);
    }

    /**
     * Method to delete.  This method is to be used during a transaction,
     * otherwise use the doDelete(TransportAttribute) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to delete in the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doDelete(TransportAttribute obj, Connection con)
        throws TorqueException
    {
        doDelete(buildCriteria(obj), con);
    }

    /**
     * Method to do deletes.
     *
     * @param pk ObjectKey that is used DELETE from database.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doDelete(ObjectKey pk) throws TorqueException
    {
        BaseTransportAttributePeer
           .doDelete(pk, (Connection) null);
    }

    /**
     * Method to delete.  This method is to be used during a transaction,
     * otherwise use the doDelete(ObjectKey) method.  It will take
     * care of the connection details internally.
     *
     * @param pk the primary key for the object to delete in the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doDelete(ObjectKey pk, Connection con)
        throws TorqueException
    {
        doDelete(buildCriteria(pk), con);
    }

    /** Build a Criteria object from an ObjectKey */
    public static Criteria buildCriteria( ObjectKey pk )
    {
        Criteria criteria = new Criteria();
              criteria.add(TRANSPORT_ATTRIBUTE_ID, pk);
          return criteria;
     }

    /** Build a Criteria object from the data object for this peer */
    public static Criteria buildCriteria( TransportAttribute obj )
    {
        Criteria criteria = new Criteria(DATABASE_NAME);
              if (!obj.isNew())
                criteria.add(TRANSPORT_ATTRIBUTE_ID, obj.getTransportAttributeId());
                  criteria.add(TRANSPORT_ID, obj.getTransportId());
                  criteria.add(TRANSPORT_ATTRIBUTE_NAME, obj.getTransportAttributeName());
                  criteria.add(TRANSPORT_ATTRIBUTE_TYPE, obj.getTransportAttributeType());
                  criteria.add(IS_PART_OF_AUTHENTIFICATION, obj.getIsPartOfAuthentification());
                  criteria.add(IS_MANDATORY, obj.getIsMandatory());
          return criteria;
    }
 
    
        /**
     * Retrieve a single object by pk
     *
     * @param pk the primary key
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @throws NoRowsException Primary key was not found in database.
     * @throws TooManyRowsException Primary key was not found in database.
     */
    public static TransportAttribute retrieveByPK(int pk)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        return retrieveByPK(SimpleKey.keyFor(pk));
    }
  
    /**
     * Retrieve a single object by pk
     *
     * @param pk the primary key
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @throws NoRowsException Primary key was not found in database.
     * @throws TooManyRowsException Primary key was not found in database.
     */
    public static TransportAttribute retrieveByPK(ObjectKey pk)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        Connection db = null;
        TransportAttribute retVal = null;
        try
        {
            db = Torque.getConnection(DATABASE_NAME);
            retVal = retrieveByPK(pk, db);
        }
        finally
        {
            Torque.closeConnection(db);
        }
        return(retVal);
    }

    /**
     * Retrieve a single object by pk
     *
     * @param pk the primary key
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @throws NoRowsException Primary key was not found in database.
     * @throws TooManyRowsException Primary key was not found in database.
     */
    public static TransportAttribute retrieveByPK(ObjectKey pk, Connection con)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        Criteria criteria = buildCriteria(pk);
        List v = doSelect(criteria, con);
        if (v.size() == 0)
        {
            throw new NoRowsException("Failed to select a row.");
        }
        else if (v.size() > 1)
        {
            throw new TooManyRowsException("Failed to select only one row.");
        }
        else
        {
            return (TransportAttribute)v.get(0);
        }
    }

    /**
     * Retrieve a multiple objects by pk
     *
     * @param pks List of primary keys
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List retrieveByPKs(List pks)
        throws TorqueException
    {
        Connection db = null;
        List retVal = null;
        try
        {
           db = Torque.getConnection(DATABASE_NAME);
           retVal = retrieveByPKs(pks, db);
        }
        finally
        {
            Torque.closeConnection(db);
        }
        return(retVal);
    }

    /**
     * Retrieve a multiple objects by pk
     *
     * @param pks List of primary keys
     * @param dbcon the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List retrieveByPKs( List pks, Connection dbcon )
        throws TorqueException
    {
        List objs = null;
        if (pks == null || pks.size() == 0)
        {
            objs = new LinkedList();
        }
        else
        {
            Criteria criteria = new Criteria();
              criteria.addIn( TRANSPORT_ATTRIBUTE_ID, pks );
          objs = doSelect(criteria, dbcon);
        }
        return objs;
    }

 



          
                                              
                
                

    /**
     * selects a collection of TransportAttribute objects pre-filled with their
     * Transport objects.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in TransportAttributePeer.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    protected static List doSelectJoinTransport(Criteria c)
        throws TorqueException
    {
        // Set the correct dbName if it has not been overridden
        // c.getDbName will return the same object if not set to
        // another value so == check is okay and faster
        if (c.getDbName() == Torque.getDefaultDB())
        {
            c.setDbName(DATABASE_NAME);
        }

        TransportAttributePeer.addSelectColumns(c);
        int offset = numColumns + 1;
        TransportPeer.addSelectColumns(c);


                        c.addJoin(TransportAttributePeer.TRANSPORT_ID,
            TransportPeer.TRANSPORT_ID);
        

                                                                                                  // check for conversion from boolean to Y/N
        if ( c.containsKey(IS_PART_OF_AUTHENTIFICATION) )
        {
            Object possibleBoolean = c.get(IS_PART_OF_AUTHENTIFICATION);
            if (possibleBoolean instanceof Boolean)
            {
                if (((Boolean) possibleBoolean).booleanValue())
                {
                    c.add(IS_PART_OF_AUTHENTIFICATION, "Y");
                }
                else
                {
                    c.add(IS_PART_OF_AUTHENTIFICATION, "N");
                }
            }
         }
                                    // check for conversion from boolean to Y/N
        if ( c.containsKey(IS_MANDATORY) )
        {
            Object possibleBoolean = c.get(IS_MANDATORY);
            if (possibleBoolean instanceof Boolean)
            {
                if (((Boolean) possibleBoolean).booleanValue())
                {
                    c.add(IS_MANDATORY, "Y");
                }
                else
                {
                    c.add(IS_MANDATORY, "N");
                }
            }
         }
                  
        List rows = BasePeer.doSelect(c);
        List results = new ArrayList();

        for (int i = 0; i < rows.size(); i++)
        {
            Record row = (Record) rows.get(i);

                            Class omClass = TransportAttributePeer.getOMClass();
                    TransportAttribute obj1 = (TransportAttribute) TransportAttributePeer
                .row2Object(row, 1, omClass);
                     omClass = TransportPeer.getOMClass();
                    Transport obj2 = (Transport)TransportPeer
                .row2Object(row, offset, omClass);

            boolean newObject = true;
            for (int j = 0; j < results.size(); j++)
            {
                TransportAttribute temp_obj1 = (TransportAttribute)results.get(j);
                Transport temp_obj2 = (Transport)temp_obj1.getTransport();
                if (temp_obj2.getPrimaryKey().equals(obj2.getPrimaryKey()))
                {
                    newObject = false;
                    temp_obj2.addTransportAttribute(obj1);
                    break;
                }
            }
            if (newObject)
            {
                obj2.initTransportAttributes();
                obj2.addTransportAttribute(obj1);
            }
            results.add(obj1);
        }
        return results;
    }
                    
  
    
  
      /**
     * Returns the TableMap related to this peer.  This method is not
     * needed for general use but a specific application could have a need.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    protected static TableMap getTableMap()
        throws TorqueException
    {
        return Torque.getDatabaseMap(DATABASE_NAME).getTable(TABLE_NAME);
    }
   }
