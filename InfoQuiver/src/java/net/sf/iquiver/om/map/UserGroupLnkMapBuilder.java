package net.sf.iquiver.om.map;

import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.map.DatabaseMap;
import org.apache.torque.map.MapBuilder;
import org.apache.torque.map.TableMap;

/**
  *  This class was autogenerated by Torque on:
  *
  * [Sat Apr 10 10:03:40 CEST 2004]
  *
  */
public class UserGroupLnkMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "net.sf.iquiver.om.map.UserGroupLnkMapBuilder";


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

        dbMap.addTable("iq_user_group_lnk");
        TableMap tMap = dbMap.getTable("iq_user_group_lnk");

        tMap.setPrimaryKeyMethod(TableMap.ID_BROKER);

        tMap.setPrimaryKeyMethodInfo(tMap.getName());

              tMap.addForeignPrimaryKey(
                "iq_user_group_lnk.USER_GROUP_ID", new Long(0) , "iq_user_group" ,
                "USER_GROUP_ID");
                    tMap.addForeignPrimaryKey(
                "iq_user_group_lnk.USER_ID", new Long(0) , "iq_user" ,
                "USER_ID");
          }
}
