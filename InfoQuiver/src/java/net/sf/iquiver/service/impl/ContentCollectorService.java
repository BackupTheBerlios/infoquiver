/*
 * Created on 08.07.2004
 */
package net.sf.iquiver.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

import net.sf.iquiver.om.ContentPeer;
import net.sf.iquiver.service.BaseService;

/**
 * @author netseeker aka Michael Manske
 */
public class ContentCollectorService extends BaseService
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog(ContentCollectorService.class);
    
    /* (non-Javadoc)
     * @see net.sf.iquiver.service.BaseService#doStart()
     */
    protected void doStart()
    {
        Criteria crit = new Criteria();
        crit.add( ContentPeer.CONTENT_TO_DELETE, true );
        
        try
        {
            ContentPeer.doDelete( crit );
        }
        catch ( TorqueException e )
        {            
            logger.error( "Error occured while deleting all marked contents from database!", e);
        }
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.BaseService#doStop()
     */
    protected void doStop()
    {
        //not implemented
    }

}
