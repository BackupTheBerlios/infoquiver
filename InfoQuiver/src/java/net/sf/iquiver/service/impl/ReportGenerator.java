/*********************************************************************
 * ReportGenerator.java
 * created on 16.07.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/service/impl/Attic/ReportGenerator.java,v $
 * $Date: 2004/07/21 22:34:10 $
 * $Revision: 1.5 $
 *********************************************************************/

package net.sf.iquiver.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.sf.iquiver.IQuiver;
import net.sf.iquiver.om.Client;
import net.sf.iquiver.om.UserGroup;
import net.sf.iquiver.report.IReportSource;
import net.sf.iquiver.report.QueryResultMapDataSource;

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
public class ReportGenerator
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( ReportGenerator.class );

    /**
     * directory where the generated report will be saved, default: reports/tmp
     */
    private static String _targetDir = IQuiver.getConfiguration().getString( "reports.directory", "reports" ) + File.separator + "tmp";
    private static String _template = IQuiver.getConfiguration().getString( "reports.templates.searchresults" ) + ".jasper";

    public static void generate(IReportSource searcher, ListMap queryresults)
    {
        String path = _targetDir + File.separator;

        if (searcher instanceof Client)
        {
            path += String.valueOf( ((Client) searcher).getClientId() );
        }
        else if (searcher instanceof UserGroup)
        {
            UserGroup group = (UserGroup) searcher;
            path += String.valueOf( group.getClientId() );
            path += File.separator;
            path += String.valueOf( group.getUserGroupId() );
        }
        
        File file = new File( path );
        if( !file.exists() )
        {
            file.mkdirs();
        }
        
        path += File.separator;
        path += String.valueOf( System.currentTimeMillis() );

        QueryResultMapDataSource dataSource = new QueryResultMapDataSource( searcher, queryresults );
        Map parameters = new HashMap();
        parameters.put( "ReportTitle", "InfoQuiver - Search Results" );
        try
        {
            JasperPrint data = JasperFillManager.fillReport( _template, parameters, dataSource );
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

