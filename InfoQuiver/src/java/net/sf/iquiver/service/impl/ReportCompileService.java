/*********************************************************************
 * ReportCompileService.java
 * created on 18.07.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/service/impl/ReportCompileService.java,v $
 * $Date: 2004/10/25 19:37:19 $
 * $Revision: 1.3 $
*********************************************************************/

package net.sf.iquiver.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Iterator;
import java.util.List;

import de.netseeker.util.FileUtil;
import dori.jasper.engine.JRException;
import dori.jasper.engine.JasperCompileManager;
import net.sf.iquiver.IQuiver;
import net.sf.iquiver.service.BaseService;

/**
 * Simple service which compiles all jasper report  templates,
 * so that a) new reports will be ready to use after next startup
 * and b) ensure usable compiled reports after possible jdk update because
 * jasper reports requires recompiling of templates after jdk/jre update
 * @author netseeker aka Michael Manske
 */
public class ReportCompileService extends BaseService
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog(ReportCompileService.class);

    private static String _targetDir = IQuiver.getConfiguration().getString( "reports.directory", "reports" );
    
    /* (non-Javadoc)
     * @see net.sf.iquiver.service.BaseService#doStart()
     */
    protected void doStart()
    {
        List reports = FileUtil.listFileNamesRecursive( _targetDir );
        
        for( Iterator it = reports.iterator(); it.hasNext(); )
        {
            String path = (String)it.next();
            try
            {
                if( path.endsWith("jrxml") )
                {
                    JasperCompileManager.compileReportToFile( path );
                }
            }
            catch ( JRException e )
            {
                logger.error( "Error while compiling report " + path, e );
            }
        }
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.BaseService#doStop()
     */
    protected void doStop()
    {
        //nothing to do
    }

}
