/*********************************************************************
 * Client.java
 * created on 12.06.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/om/Client.java,v $
 * $Date: 2004/07/17 17:14:42 $
 * $Revision: 1.5 $
 *********************************************************************/

package net.sf.iquiver.om;

import java.util.List;

import net.sf.iquiver.report.IReportSource;

import org.apache.torque.TorqueException;
import org.apache.torque.om.Persistent;
import org.apache.torque.util.Criteria;

public class Client extends net.sf.iquiver.om.BaseClient implements Persistent, IReportSource
{
    /** Fetches all ContentSources related to this Client via ClientContentSourceLnk
     * @return a list of net.sf.iquiver.om.ContentSource objects
     * @throws TorqueException
     */
    public List getContentSources() throws TorqueException
    {
        Criteria crit = new Criteria();
        crit.addJoin( ContentSourcePeer.CONTENT_SOURCE_ID, ClientContentSourceLnkPeer.CONTENT_SOURCE_ID );
        crit.add( ClientContentSourceLnkPeer.CLIENT_ID, this.getClientId() );

        return ContentSourcePeer.doSelect( crit );
    }
}