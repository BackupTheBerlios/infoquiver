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
public class ContentSourceTransportConfigMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "net.sf.iquiver.om.map.ContentSourceTransportConfigMapBuilder";


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

        dbMap.addTable("iq_content_source_transport_config");
        TableMap tMap = dbMap.getTable("iq_content_source_transport_config");

        tMap.setPrimaryKeyMethod("none");


              tMap.addForeignPrimaryKey(
                "iq_content_source_transport_config.CONTENT_SOURCE_ID", new Long(0) , "iq_content_source" ,
                "CONTENT_SOURCE_ID");
                    tMap.addForeignPrimaryKey(
                "iq_content_source_transport_config.TRANSPORT_ATTRIBUTE_ID", new Integer(0) , "iq_transport_attribute" ,
                "TRANSPORT_ATTRIBUTE_ID");
                    tMap.addColumn("iq_content_source_transport_config.TRANSPORT_ATTRIBUTE_VALUE", new String());
          }
}
