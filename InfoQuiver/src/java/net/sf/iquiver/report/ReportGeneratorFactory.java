/*********************************************************************
 * ReportGeneratorFactory.java
 * created on 24.10.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/report/ReportGeneratorFactory.java,v $
 * $Date: 2004/10/24 16:32:58 $
 * $Revision: 1.2 $
 *********************************************************************/

package net.sf.iquiver.report;

import net.sf.iquiver.IQuiver;
import net.sf.iquiver.report.impl.DefaultReportGenerator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.netseeker.util.StringUtil;

/**
 * @author netseeker aka Michael Manske
 */
public class ReportGeneratorFactory
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( ReportGeneratorFactory.class );

    public static final String CONFIG_REPORT_GENERATOR = "reports.ReportGenerator.impl";
    private static ReportGenerator generator;

    /**
     * @return
     */
    public static ReportGenerator getReportGenerator()
    {
        if (generator == null)
        {
            String clazz = StringUtil.defaultIfNullOrEmpty( IQuiver.getConfiguration().getString(
                    CONFIG_REPORT_GENERATOR ), DefaultReportGenerator.class.getName() );
            try
            {
                generator = (ReportGenerator) Class.forName( clazz ).newInstance();
            }
            catch ( Exception e )
            {
                logger.fatal( "!!!Failed to instantiate a ReportGenerator!!!", e );
            }
        }

        return generator;
    }
}