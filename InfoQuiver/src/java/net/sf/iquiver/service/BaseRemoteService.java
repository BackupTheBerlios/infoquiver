/*
 * Created on 02.07.2004
 */
package net.sf.iquiver.service;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import net.sf.iquiver.IQuiver;
import net.sf.iquiver.configuration.Reconfigurable;
import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.metaformat.impl.DocumentUtil;
import net.sf.iquiver.om.ContentSource;
import net.sf.iquiver.om.User;
import net.sf.iquiver.om.UserPeer;
import net.sf.iquiver.remote.RemoteException;
import net.sf.iquiver.report.IReportSource;
import net.sf.iquiver.search.QueryTask;
import net.sf.iquiver.util.ObjectSerializer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.TorqueException;
import org.apache.torque.om.BaseObject;
import org.apache.torque.om.ComboKey;
import org.apache.torque.util.Criteria;

/**
 * The base class of all server side remote interfaces and server implementations
 * @author netseeker aka Michael Manske
 */
public abstract class BaseRemoteService extends BaseService implements Reconfigurable
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog(BaseRemoteService.class);

    private static String _indexDirectory = IQuiver.getConfiguration().getString( "lucene.index.path" );

    /**
     * @param clientId
     * @param login
     * @param password
     * @return
     */
    public String doLogin( /* long clientId,*/String login, String password )
    {
        User user = UserPeer.doLogin( /* clientId, */login, password );
        if (user != null)
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
        ComboKey keyObject = (ComboKey) ObjectSerializer.xmlToObject( key );
        Object resultObject = null;

        try
        {
            Class peerClass = Class.forName( objectType + "Peer" );
            Method method = peerClass.getMethod( "retrieveByPk", new Class[] { ComboKey.class } );
            resultObject = method.invoke( null, new Object[] { keyObject } );
        }
        catch ( Exception e )
        {
            throw new RemoteException( e );
        }

        if (resultObject != null)
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
        List keyObjects = (List) ObjectSerializer.xmlToObject( keys );

        try
        {
            Class peerClass = Class.forName( objectType + "Peer" );
            Method method = peerClass.getMethod( "retrieveByPks", new Class[] { List.class } );
            resultObject = method.invoke( null, new Object[] { keyObjects } );
        }
        catch ( Exception e )
        {
            throw new RemoteException( e );
        }

        if (resultObject != null)
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
        Criteria crit = (Criteria) ObjectSerializer.xmlToObject( criteria );

        try
        {
            Class peerClass = Class.forName( objectType + "Peer" );
            Method method = peerClass.getMethod( "doSelect", new Class[] { Criteria.class } );
            resultObject = method.invoke( null, new Object[] { crit } );
        }
        catch ( Exception e )
        {
            throw new RemoteException( e );
        }

        if (resultObject != null)
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
    public void doDelete( String sessionId, String object )
    {
        Object obj = ObjectSerializer.xmlToObject( object );

        try
        {
            String objClassName = obj.getClass().getName();
            Class objClass = Class.forName( objClassName );
            Class peerClass = Class.forName( objClassName + "Peer" );
            Method method = peerClass.getMethod( "doDelete", new Class[] { objClass } );
            method.invoke( null, new Object[] { obj } );
        }
        catch ( Exception e )
        {
            throw new RemoteException( e );
        }
    }

    /**
     * @param sessionId
     * @param objectType
     * @param object
     * @return
     */
    public String doSave( String sessionId, String object )
    {
        Object obj = ObjectSerializer.xmlToObject( object );

        if (!(obj instanceof BaseObject))
        {
            throw new RemoteException( "Given object does not subclass " + BaseObject.class.getName() );
        }

        try
        {
            ((BaseObject) obj).save();
        }
        catch ( Exception e )
        {
            throw new RemoteException( e );
        }

        return ObjectSerializer.objectToXml( obj );
    }

    /**
     * @param sessionId
     * @param entity
     * @param query
     * @return
     * @throws TorqueException
     */
    public Vector doSearch( String sessionId, String entity, String query )
    {
        IReportSource obj = (IReportSource) ObjectSerializer.xmlToObject( entity );
        Vector results = new Vector();
        
        try
        {
            List contentSources = obj.getContentSources();
            String[] tmp, indeces;

            // determine all indeces to use for searching, one index per content source
            tmp = new String[contentSources.size()];
            int count = 0;
            for (int i = 0; i < contentSources.size(); i++)
            {
                ContentSource source = (ContentSource) contentSources.get( i );
                String index = _indexDirectory + File.separator + source.getContentSourceId();
                File testFile = new File( index );
                if (testFile.exists())
                {
                    tmp[i] = index;
                    count++;
                }
            }

            indeces = new String[count];
            System.arraycopy( tmp, 0, indeces, 0, count );
            List documents = QueryTask.search( indeces, query );            
            for( Iterator it = documents.iterator(); it.hasNext(); )
            {
                Document doc = (Document)it.next();
                results.add( DocumentUtil.documentToXmlString( doc ) );
            }
        }
        catch ( Exception e )
        {
            logger.error( e );
            throw new RemoteException( e );
        }
        
        return results;
    }
}