/*********************************************************************
 * ContentSearchService.java
 * created on 15.07.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/service/impl/ContentSearchService.java,v $
 * $Date: 2004/07/16 08:08:57 $
 * $Revision: 1.4 $
*********************************************************************/
package net.sf.iquiver.service.impl;

import java.util.Iterator;
import java.util.List;

import net.sf.iquiver.om.Client;
import net.sf.iquiver.om.ClientPeer;
import net.sf.iquiver.om.User;
import net.sf.iquiver.om.UserGroup;
import net.sf.iquiver.om.UserGroupLnkPeer;
import net.sf.iquiver.om.UserPeer;
import net.sf.iquiver.service.BaseService;

import org.apache.torque.TorqueException;
import org.apache.torque.om.BaseObject;
import org.apache.torque.util.Criteria;

/**
 * @author netseeker aka Michael Manske
 */
public class ContentSearchService extends BaseService
{

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.BaseService#doStart()
     */
    protected void doStart()
    {
        try
        {
            List clients = ClientPeer.doSelectAll();
            
            for( Iterator it = clients.iterator(); it.hasNext(); )
            {
                Client client = (Client)it.next();
                
                
                
                List groups = client.getUserGroups();
                
                for ( Iterator gIt = groups.iterator(); gIt.hasNext(); ) 
                {
                    UserGroup group = (UserGroup)gIt.next();
                    
                    
                    
                    Criteria crit = new Criteria();
                    crit.addJoin( UserPeer.USER_ID, UserGroupLnkPeer.USER_ID );
                    crit.add( UserGroupLnkPeer.USER_GROUP_ID, group.getUserGroupId() );
                    List users = UserPeer.doSelect( crit );
                    
                    for ( Iterator uIt = users.iterator(); uIt.hasNext(); )
                    {
                        
                    }
                }
            }            
        }
        catch ( TorqueException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.BaseService#doStop()
     */
    protected void doStop()
    {
        // TODO Auto-generated method stub

    }    
    
    /**
     * @param obj
     * @throws TorqueException
     */
    private void executeSearchQueries( BaseObject obj ) throws TorqueException
    {
        List queries = null;
        
        if( obj instanceof Client )
        {
            queries = ((Client)obj).getSearchQuerys();
        }
        else if ( obj instanceof UserGroup )
        {
            queries = ((UserGroup)obj).getSearchQuerys();
        }
        else
        {
            queries = ((User)obj).getSearchQuerysRelatedByUserId();
        }
        
        
    }
}
