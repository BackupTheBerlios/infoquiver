/*
 * Created on 02.07.2004
 */
package net.sf.iquiver.service;

import java.lang.reflect.Method;
import java.util.List;

import net.sf.iquiver.om.User;
import net.sf.iquiver.om.UserPeer;
import net.sf.iquiver.remote.RemoteException;
import net.sf.iquiver.util.ObjectSerializer;
import net.sf.iquiver.util.om.SimpleCriteria;

import org.apache.torque.om.ComboKey;
import org.apache.torque.util.Criteria;

/**
 * The base class of all server side remote interfaces and server implementations
 * @author netseeker aka Michael Manske
 */
public abstract class BaseRemoteService extends BaseService
{
    /**
     * @param clientId
     * @param login
     * @param password
     * @return
     */
    public String doLogin(long clientId, String login, String password )
    {
        User user = UserPeer.doLogin( clientId, login, password );
        if(user != null)
        {
            return ObjectSerializer.objectToXml( user );
        }
        else
        {
            throw new RemoteException( "Authentification failed. No such user." );
        }
    }
    
    /**
     * @param sessionId
     * @param objectType
     * @param key
     * @return
     */
    public String retrieveByPk( String sessionId, String objectType, String key )
    {
        ComboKey keyObject = (ComboKey)ObjectSerializer.xmlToObject( key );
        Object resultObject = null;
        
        try
        {
	        Class peerClass = Class.forName(objectType + "Peer");
	        Method method = peerClass.getMethod( "retrieveByPk" , new Class[] {ComboKey.class}) ;        
	        resultObject = method.invoke( null, new Object[]{ keyObject } );	        	        
        }
        catch (Exception e )
        {
            throw new RemoteException( e );
        }
        
        if( resultObject != null )
        {
            return ObjectSerializer.objectToXml( resultObject );            
        }
        
        return "";
    }
    
    /**
     * @param sessionId
     * @param objectType
     * @param keys
     * @return
     */
    public String retrieveByPks( String sessionId, String objectType, String keys )
    {        
        Object resultObject = null;
        List keyObjects = (List)ObjectSerializer.xmlToObject( keys );
        
        try
        {
	        Class peerClass = Class.forName(objectType + "Peer");
	        Method method = peerClass.getMethod( "retrieveByPks" , new Class[] {List.class}) ;        
	        resultObject = method.invoke( null, new Object[]{ keyObjects } );	        	        
        }
        catch (Exception e )
        {
            throw new RemoteException( e );
        }
        
        if( resultObject != null )
        {
            return ObjectSerializer.objectToXml( resultObject );            
        }
        
        return "";        
    }
    
    /**
     * @param sessionId
     * @param objectType
     * @param criteria
     * @return
     */
    public String doSelect( String sessionId, String objectType, String criteria )
    {
        Object resultObject = null;
        SimpleCriteria crit = (SimpleCriteria)ObjectSerializer.xmlToObject( criteria );
        
        try
        {
	        Class peerClass = Class.forName(objectType + "Peer");
	        Method method = peerClass.getMethod( "doSelect" , new Class[] {Criteria.class}) ;        
	        resultObject = method.invoke( null, new Object[]{ crit } );	        	                    
        }
        catch (Exception e )
        {
            throw new RemoteException( e );
        }

        if( resultObject != null )
        {
            return ObjectSerializer.objectToXml( resultObject );            
        }
        
        return "";                
    }
    
    /**
     * @param sessionId
     * @param objectType
     * @param object
     */
    public void doDelete( String sessionId, String objectType, String object )
    {
        Object obj = ObjectSerializer.xmlToObject( object );        
        
        try
        {
	        Class objClass = Class.forName( objectType );
            Class peerClass = Class.forName(objectType + "Peer");
	        Method method = peerClass.getMethod( "doDelete" , new Class[] {objClass}) ;        
	        method.invoke( null, new Object[]{ obj } );	        	                    
        }
        catch (Exception e )
        {
            throw new RemoteException( e );
        }        
    }
}
