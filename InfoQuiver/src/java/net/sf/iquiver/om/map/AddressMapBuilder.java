package net.sf.iquiver.om.map;

import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.map.DatabaseMap;
import org.apache.torque.map.MapBuilder;
import org.apache.torque.map.TableMap;

/**
  *  This class was autogenerated by Torque on:
  *
  * [Mon Jun 28 22:47:06 CEST 2004]
  *
  */
public class AddressMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "net.sf.iquiver.om.map.AddressMapBuilder";


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

        dbMap.addTable("iq_address");
        TableMap tMap = dbMap.getTable("iq_address");

        tMap.setPrimaryKeyMethod(TableMap.ID_BROKER);

        tMap.setPrimaryKeyMethodInfo(tMap.getName());

              tMap.addPrimaryKey("iq_address.ADDRESS_ID", new Long(0));
                    tMap.addColumn("iq_address.ADDRESS_NAME", new String());
                    tMap.addColumn("iq_address.ADDRESS_STREET", new String());
                    tMap.addColumn("iq_address.ADDRESS_ZIP", new String());
                    tMap.addColumn("iq_address.ADDRESS_PO_BOX", new String());
                    tMap.addColumn("iq_address.ADDRESS_PO_BOX_ZIP", new String());
                    tMap.addColumn("iq_address.ADDRESS_PHONE", new String());
                    tMap.addColumn("iq_address.ADDRESS_MOBILE", new String());
                    tMap.addColumn("iq_address.ADDRESS_EMAIL", new String());
                    tMap.addColumn("iq_address.ADDRESS_URL", new String());
                    tMap.addColumn("iq_address.ADDRESS_NUMBER", new String());
                    tMap.addColumn("iq_address.ADDRESS_COUNTRY", new String());
          }
}
