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
public class UserGroupPermissionLnkMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "net.sf.iquiver.om.map.UserGroupPermissionLnkMapBuilder";


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

        dbMap.addTable("iq_user_group_permission_lnk");
        TableMap tMap = dbMap.getTable("iq_user_group_permission_lnk");

        tMap.setPrimaryKeyMethod("none");


              tMap.addPrimaryKey("iq_user_group_permission_lnk.USER_GROUP_ID", new Long(0));
                    tMap.addPrimaryKey("iq_user_group_permission_lnk.PERMISSION_ID", new Integer(0));
                    tMap.addColumn("iq_user_group_permission_lnk.IS_NEGATION", new String());
          }
}
