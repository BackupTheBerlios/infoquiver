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
public class UserMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "net.sf.iquiver.om.map.UserMapBuilder";


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

        dbMap.addTable("iq_user");
        TableMap tMap = dbMap.getTable("iq_user");

        tMap.setPrimaryKeyMethod(TableMap.ID_BROKER);

        tMap.setPrimaryKeyMethodInfo(tMap.getName());

              tMap.addPrimaryKey("iq_user.USER_ID", new Long(0));
                    tMap.addColumn("iq_user.USER_PASSWORD", new String());
                    tMap.addColumn("iq_user.USER_LOGIN", new String());
                    tMap.addColumn("iq_user.USER_FIRST_NAME", new String());
                    tMap.addColumn("iq_user.USER_MID_NAME", new String());
                    tMap.addColumn("iq_user.USER_LAST_NAME", new String());
                    tMap.addColumn("iq_user.USER_GENDER", new String());
                    tMap.addColumn("iq_user.USER_DATE_OF_BIRTH", new Date());
                    tMap.addColumn("iq_user.USER_PICTURE", new Object());
                    tMap.addForeignKey(
                "iq_user.ADDRESS_ID", new Long(0) , "iq_address" ,
                "ADDRESS_ID");
                    tMap.addForeignKey(
                "iq_user.CLIENT_ID", new Integer(0) , "iq_client" ,
                "CLIENT_ID");
          }
}
