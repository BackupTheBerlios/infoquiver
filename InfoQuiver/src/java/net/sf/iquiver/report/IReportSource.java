/*********************************************************************
 * IReportSource.java
 * created on 17.07.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/report/IReportSource.java,v $
 * $Date: 2004/07/17 17:13:41 $
 * $Revision: 1.1 $
*********************************************************************/

package net.sf.iquiver.report;

import java.util.List;

import org.apache.torque.TorqueException;

/**
 * @author netseeker aka Michael Manske
 */
public interface IReportSource
{
    public List getSearchQuerys() throws TorqueException;
    public List getContentSources() throws TorqueException;
}
