/*
 * Created on 28.03.2004
 *
 */
package net.sf.iquiver.admin.delegate;

import net.sf.iquiver.om.User;
import net.sf.iquiver.om.UserPeer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

/**
 * @author netseeker aka Michael Manske
 */
public class UserDelegate
{
    private static final Log logger = LogFactory.getLog(UserDelegate.class);
    
    public static User doLogin(String username, String password)
    {
        User user = null;
        Criteria crit = new Criteria();
        crit.add(UserPeer.USER_LOGIN, username);
        crit.add(UserPeer.USER_PASSWORD, password);
        
        try
        {
            user = (User)UserPeer.doSelect(crit).get(0); 
        }
        catch ( TorqueException e )
        {            
            logger.error("Database error while fetching user \"" + username + "\"", e);
        }
        catch ( NullPointerException e )
        {
            // do nothing
        }
        
        return user;
    }
}
