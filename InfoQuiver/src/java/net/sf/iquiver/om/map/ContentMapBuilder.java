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
  * [Sun Jul 11 21:19:50 CEST 2004]
  *
  */
public class ContentMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "net.sf.iquiver.om.map.ContentMapBuilder";


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

        dbMap.addTable("iq_content");
        TableMap tMap = dbMap.getTable("iq_content");

        tMap.setPrimaryKeyMethod(TableMap.ID_BROKER);

        tMap.setPrimaryKeyMethodInfo(tMap.getName());

              tMap.addPrimaryKey("iq_content.CONTENT_ID", new Long(0));
                    tMap.addForeignKey(
                "iq_content.CONTENT_TYPE_ID", new Integer(0) , "iq_content_type" ,
                "CONTENT_TYPE_ID");
                    tMap.addForeignKey(
                "iq_content.CONTENT_SOURCE_ID", new Long(0) , "iq_content_source" ,
                "CONTENT_SOURCE_ID");
                    tMap.addColumn("iq_content.CONTENT_UID", new String());
                    tMap.addColumn("iq_content.CONTENT_RECEIVE_DATETIME", new Date());
                    tMap.addColumn("iq_content.CONTENT_LOCALE", new String());
                    tMap.addColumn("iq_content.CONTENT_DATE_OF_CREATION", new Date());
                    tMap.addColumn("iq_content.CONTENT_DATE_OF_LAST_MODIFICATION", new Date());
                    tMap.addColumn("iq_content.CONTENT_INFO_URL", new String());
                    tMap.addColumn("iq_content.CONTENT_AUTHOR", new String());
                    tMap.addColumn("iq_content.CONTENT_NAME", new String());
                    tMap.addColumn("iq_content.CONTENT_TITLE", new String());
                    tMap.addColumn("iq_content.CONTENT_SHORT_DESCRIPTION", new String());
                    tMap.addColumn("iq_content.CONTENT_KEYWORDS", new String());
                    tMap.addColumn("iq_content.CONTENT_CONTENT", new Object());
                    tMap.addColumn("iq_content.CONTENT_TO_DELETE", new Integer(0));
          }
}
