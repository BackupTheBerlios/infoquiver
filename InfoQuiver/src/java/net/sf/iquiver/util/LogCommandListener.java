/*********************************************************************
 * LogCommandListener.java
 * created on 15.10.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/util/LogCommandListener.java,v $
 * $Date: 2004/10/15 17:18:43 $
 * $Revision: 1.1 $
*********************************************************************/

package net.sf.iquiver.util;

import org.apache.commons.logging.Log;
import org.apache.commons.net.ProtocolCommandEvent;
import org.apache.commons.net.ProtocolCommandListener;

/**
 * @author netseeker aka Michael Manske
 */
public class LogCommandListener implements ProtocolCommandListener
{
    private Log logger;

    /**
     * @param logger
     */
    public LogCommandListener(Log logger)
    {
        this.logger = logger;
    }
    
    /* (non-Javadoc)
     * @see org.apache.commons.net.ProtocolCommandListener#protocolCommandSent(org.apache.commons.net.ProtocolCommandEvent)
     */
    public void protocolCommandSent( ProtocolCommandEvent evt )
    {
        logger.debug(evt.getMessage());
    }

    /* (non-Javadoc)
     * @see org.apache.commons.net.ProtocolCommandListener#protocolReplyReceived(org.apache.commons.net.ProtocolCommandEvent)
     */
    public void protocolReplyReceived( ProtocolCommandEvent evt )
    {
        logger.debug(evt.getMessage());
    }
}
