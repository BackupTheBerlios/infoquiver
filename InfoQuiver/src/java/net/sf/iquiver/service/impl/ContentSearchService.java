/*
 * Created on 15.07.2004
 */
package net.sf.iquiver.service.impl;

import java.util.Iterator;
import java.util.List;

import net.sf.iquiver.om.Client;
import net.sf.iquiver.om.ClientPeer;
import net.sf.iquiver.om.UserGroup;
import net.sf.iquiver.om.UserGroupLnkPeer;
import net.sf.iquiver.om.UserPeer;
import net.sf.iquiver.service.BaseService;

import org.apache.torque.TorqueException;
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
}
