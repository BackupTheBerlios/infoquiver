/*********************************************************************
 * ServerStats.java
 * created on 03.12.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/ServerStats.java,v $
 * $Date: 2004/12/11 23:20:54 $
 * $Revision: 1.1 $
 *********************************************************************/

package net.sf.iquiver;

import net.sf.iquiver.event.EventProcessor;

/**
 * @author netseeker aka Michael Manske
 */
public class ServerStats
{
    private EventProcessor _serviceListener = new ServiceStats();
    private EventProcessor _indexListener = new IndexStats();

    public EventProcessor getIndexListener()
    {
        return this._indexListener;
    }

    public EventProcessor getServiceListener()
    {
        return this._serviceListener;
    }
}