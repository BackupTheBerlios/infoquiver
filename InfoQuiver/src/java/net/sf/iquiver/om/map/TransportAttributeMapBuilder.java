package net.sf.iquiver.om.map;

import java.util.Date;
import java.math.BigDecimal;

import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.map.MapBuilder;
import org.apache.torque.map.DatabaseMap;
import org.apache.torque.map.TableMap;

/**
  *  This class was autogenerated by Torque on:
  *
  * [Sat Mar 20 16:37:12 CET 2004]
  *
  */
public class TransportAttributeMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "net.sf.iquiver.om.map.TransportAttributeMapBuilder";


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

        dbMap.addTable("iq_transport_attribute");
        TableMap tMap = dbMap.getTable("iq_transport_attribute");

        tMap.setPrimaryKeyMethod(TableMap.ID_BROKER);

        tMap.setPrimaryKeyMethodInfo(tMap.getName());

              tMap.addPrimaryKey("iq_transport_attribute.TRANSPORT_ATTRIBUTE_ID", new Integer(0));
                    tMap.addForeignKey(
                "iq_transport_attribute.TRANSPORT_ID", new Integer(0) , "iq_transport" ,
                "TRANSPORT_ID");
                    tMap.addColumn("iq_transport_attribute.TRANSPORT_ATTRIBUTE_NAME", new String());
                    tMap.addColumn("iq_transport_attribute.TRANSPORT_ATTRIBUTE_TYPE", new String());
                    tMap.addColumn("iq_transport_attribute.IS_PART_OF_AUTHENTIFICATION", new String());
                    tMap.addColumn("iq_transport_attribute.IS_MANDATORY", new String());
          }
}