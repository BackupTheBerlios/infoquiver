/*********************************************************************
 * IReportSource.java
 * created on 17.07.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/report/IReportSource.java,v $
 * $Date: 2004/11/26 22:51:18 $
 * $Revision: 1.3 $
*********************************************************************/

package net.sf.iquiver.report;

import java.util.List;

import net.sf.iquiver.util.Introspectable;

import org.apache.torque.TorqueException;

/**
 * @author netseeker aka Michael Manske
 */
public interface IReportSource extends Introspectable
{
    public List getSearchQuerys() throws TorqueException;
    public List getContentSources() throws TorqueException;
    public int getClientId();
}
