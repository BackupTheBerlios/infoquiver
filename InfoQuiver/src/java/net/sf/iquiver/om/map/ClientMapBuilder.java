package net.sf.iquiver.om.map;

import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.map.DatabaseMap;
import org.apache.torque.map.MapBuilder;
import org.apache.torque.map.TableMap;

/**
  *  This class was autogenerated by Torque on:
  *
  * [Sun Apr 04 20:29:12 CEST 2004]
  *
  */
public class ClientMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "net.sf.iquiver.om.map.ClientMapBuilder";


    /**
     * The database map.
     */
    private DatabaseMap dbMap = null;

    /**
     * Tells us if this DatabaseMapBuilder is built so that we
     * don't have to re-build it every time.
     *
     * @return true if this DatabaseMapBuilder is built
     */
    public boolean isBuilt()
    {
        return (dbMap != null);
    }

    /**
     * Gets the databasemap this map builder built.
     *
     * @return the databasemap
     */
    public DatabaseMap getDatabaseMap()
    {
        return this.dbMap;
    }

    /**
     * The doBuild() method builds the DatabaseMap
     *
     * @throws TorqueException
     */
    public void doBuild() throws TorqueException
    {
        dbMap = Torque.getDatabaseMap("iquiver");

        dbMap.addTable("iq_client");
        TableMap tMap = dbMap.getTable("iq_client");

        tMap.setPrimaryKeyMethod("none");


              tMap.addPrimaryKey("iq_client.CLIENT_ID", new Integer(0));
                    tMap.addColumn("iq_client.CLIENT_NAME", new String());
                    tMap.addForeignKey(
                "iq_client.ADDRESS_ID", new Long(0) , "iq_address" ,
                "ADDRESS_ID");
          }
}
