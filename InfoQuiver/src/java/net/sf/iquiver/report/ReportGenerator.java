/*********************************************************************
 * ReportGenerator.java
 * created on 16.07.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/report/ReportGenerator.java,v $
 * $Date: 2004/11/24 21:21:19 $
 * $Revision: 1.5 $
 *********************************************************************/

package net.sf.iquiver.report;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import net.sf.iquiver.IQuiver;
import net.sf.iquiver.om.Client;
import net.sf.iquiver.om.UserGroup;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.netseeker.util.ListMap;

/**
 * @author netseeker aka Michael Manske
 */
public abstract class ReportGenerator
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( ReportGenerator.class );

    protected static String _reportDir = IQuiver.getConfiguration().getString( "reports.directory", "reports" );
    /**
     * directory where the generated report will be saved, default: reports/tmp
     */
    protected static String _targetDir = _reportDir + File.separator + "tmp";
    protected static String _template = IQuiver.getConfiguration().getString( "reports.templates.searchresults" );  
    
    protected static DateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
    
    /**
     * Returns the path to use when saving a report result for a IReportSource.
     * If the directory structure doesn't already exist it will be created.
     * @param searcher
     * @return
     */
    protected String getReportFilePathForReportSource( IReportSource searcher )
    {
        StringBuffer path = new StringBuffer( _targetDir );
        path.append( File.separator );

        if (searcher instanceof Client)
        {
            path.append( ((Client) searcher).getClientId() );
        }
        else if (searcher instanceof UserGroup)
        {
            UserGroup group = (UserGroup) searcher;
            path.append( group.getClientId() );
            path.append( File.separator );
            path.append( group.getUserGroupId() );
        }
        
        File file = new File( path.toString() );
        if( !file.exists() )
        {
            file.mkdirs();
        }
        
        path.append( File.separator );     
        
        return path.toString();
    }
    
    public abstract void generate(IReportSource searcher, ListMap queryresults);
}

