package net.sf.iquiver.om.map;

import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.map.DatabaseMap;
import org.apache.torque.map.MapBuilder;
import org.apache.torque.map.TableMap;

/**
  *  This class was autogenerated by Torque on:
  *
  * [Mon Jul 12 14:25:30 CEST 2004]
  *
  */
public class PublisherMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "net.sf.iquiver.om.map.PublisherMapBuilder";


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

        dbMap.addTable("iq_publisher");
        TableMap tMap = dbMap.getTable("iq_publisher");

        tMap.setPrimaryKeyMethod(TableMap.ID_BROKER);

        tMap.setPrimaryKeyMethodInfo(tMap.getName());

              tMap.addPrimaryKey("iq_publisher.PUBLISHER_ID", new Integer(0));
                    tMap.addForeignKey(
                "iq_publisher.ADDRESS_ID", new Long(0) , "iq_address" ,
                "ADDRESS_ID");
                    tMap.addColumn("iq_publisher.PUBLISHER_NAME", new String());
                    tMap.addColumn("iq_publisher.PUBLISHER_LOGO", new Object());
          }
}
