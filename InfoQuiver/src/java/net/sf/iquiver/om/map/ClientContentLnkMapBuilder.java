package net.sf.iquiver.om.map;

import java.util.Date;

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
public class ClientContentLnkMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "net.sf.iquiver.om.map.ClientContentLnkMapBuilder";


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

        dbMap.addTable("iq_client_content_lnk");
        TableMap tMap = dbMap.getTable("iq_client_content_lnk");

        tMap.setPrimaryKeyMethod("none");


              tMap.addForeignPrimaryKey(
                "iq_client_content_lnk.CLIENT_ID", new Integer(0) , "iq_client" ,
                "CLIENT_ID");
                    tMap.addForeignPrimaryKey(
                "iq_client_content_lnk.CONTENT_ID", new Long(0) , "iq_content" ,
                "CONTENT_ID");
                    tMap.addColumn("iq_client_content_lnk.REQUEST_DATETIME", new Date());
          }
}
