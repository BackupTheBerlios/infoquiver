/*********************************************************************
 * JasperReportGenerator.java
 * created on 24.10.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/report/impl/JasperReportGenerator.java,v $
 * $Date: 2004/11/24 21:27:25 $
 * $Revision: 1.3 $
*********************************************************************/

package net.sf.iquiver.report.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.iquiver.report.IReportSource;
import net.sf.iquiver.report.QueryResultMapDataSource;
import net.sf.iquiver.report.ReportGenerator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.netseeker.util.ListMap;
import dori.jasper.engine.JRException;
import dori.jasper.engine.JasperExportManager;
import dori.jasper.engine.JasperFillManager;
import dori.jasper.engine.JasperPrint;

/**
 * @author netseeker aka Michael Manske
 */
public class JasperReportGenerator extends ReportGenerator
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog(JasperReportGenerator.class);

    public void generate(IReportSource searcher, ListMap queryresults)
    {
        
        String path = getReportFilePathForReportSource( searcher );
        String templatePath = path + filename_formatter.format( new Date() );
        QueryResultMapDataSource dataSource = new QueryResultMapDataSource( searcher, queryresults );
        Map parameters = new HashMap();
        parameters.put( "ReportTitle", "InfoQuiver - Search Results" );
        try
        {
            JasperPrint data = JasperFillManager.fillReport( _template + ".jasper", parameters, dataSource );
            JasperExportManager.exportReportToPdfFile( data, path + ".pdf" );
            JasperExportManager.exportReportToHtmlFile( data, path + ".html" );
            JasperExportManager.exportReportToXmlFile( data, path + ".xml", true );
        }
        catch ( JRException e )
        {
            logger.error( e );
        }
    }
}
