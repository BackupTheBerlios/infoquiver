/*********************************************************************
 * IQuiverDelegate.java
 * created on 28.11.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/infoquiver-web/WEB-INF/src/net/sf/iquiver/web/IQuiverDelegate.java,v $
 * $Date: 2004/12/01 00:09:37 $
 * $Revision: 1.3 $
*********************************************************************/

package net.sf.iquiver.web;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.iquiver.configuration.impl.DefaultProperiesConfiguration;
import net.sf.iquiver.util.ObjectSerializer;
import net.sf.iquiver.util.om.SimpleCriteria;

import org.apache.commons.configuration.Configuration;
import org.apache.torque.om.ComboKey;
import org.apache.velocity.tools.view.context.ViewContext;
import org.apache.velocity.tools.view.tools.ViewTool;
import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

/**
 * @author netseeker aka Michael Manske
 */
public class IQuiverDelegate implements ViewTool
{
    private XmlRpcClient rpcClient;
    private String rpcSessionId = "";
    
    /* (non-Javadoc)
     * @see org.apache.velocity.tools.view.tools.ViewTool#init(java.lang.Object)
     */
    public void init( Object obj )
    {
        if( rpcClient == null )
        {
            ViewContext context = (ViewContext)obj;
            String path = context.getServletContext().getRealPath("/");

            try
            {
                Configuration config = new DefaultProperiesConfiguration(path + "/WEB-INF/iquiver-web.properties");
                rpcClient = new XmlRpcClient(config.getString("host"), config.getInt("port") );
            }
            catch ( IOException e )
            {
                e.printStackTrace();
            }
        }
    }    
    
    /**
     * @param login
     * @param password
     * @return
     * @throws XmlRpcException
     * @throws IOException
     * @throws DocumentException
     */
    public Document doLogin( String login, String password, HttpServletRequest request ) throws XmlRpcException, IOException, DocumentException
    {
        Vector params = new Vector(2);
        params.add( login );
        params.add( password );
        Document user = execute( "doLogin", params );
        HttpSession session = request.getSession();
        
        if( user != null )
        {
            session.setAttribute("user", user );
        }
        
        return user;
    }
    
    /**
     * @return
     */
    public boolean isLoggedIn( HttpServletRequest request )
    {
        HttpSession session = request.getSession(false);
        return ( session != null && session.getAttribute("user") != null );
    }
    
    /**
     * @return
     */
    public Document getUser( HttpServletRequest request )
    {
        HttpSession session = request.getSession(false);
        return session != null ? (Document)session.getAttribute("user") : null; 
    }
    
    /**
     * @param objectType
     * @param criteria
     * @return
     * @throws XmlRpcException
     * @throws IOException
     * @throws DocumentException
     */
    public Document doSelect( String objectType, SimpleCriteria criteria ) throws XmlRpcException, IOException, DocumentException
    {
        Vector params = new Vector(3);
        params.add( rpcSessionId );
        params.add( objectType );
        params.add( ObjectSerializer.objectToXml( criteria ) );
        return execute( "doSelect", params );        
    }
    
    /**
     * @param objectType
     * @param object
     * @throws XmlRpcException
     * @throws IOException
     * @throws DocumentException
     */
    public void doDelete( Document object ) throws XmlRpcException, IOException, DocumentException
    {
        Vector params = new Vector(2);
        params.add( rpcSessionId );
        params.add( object.asXML() );
        rpcClient.execute( "doDelete", params );              
    }
    
    /**
     * @param objectType
     * @param object
     * @return
     * @throws XmlRpcException
     * @throws IOException
     * @throws DocumentException
     */
    public Document doSave( Document object ) throws XmlRpcException, IOException, DocumentException
    {
        Vector params = new Vector(2);
        params.add( rpcSessionId );
        params.add( object.asXML() );
        return execute( "doSave", params );                
    }
    
    /**
     * @param objectType
     * @param key
     * @return
     * @throws XmlRpcException
     * @throws IOException
     * @throws DocumentException
     */
    public Document retrieveByPk( String objectType, ComboKey key ) throws XmlRpcException, IOException, DocumentException
    {
        Vector params = new Vector(3);
        params.add( rpcSessionId );
        params.add( objectType );
        params.add( ObjectSerializer.objectToXml( key ) );
        return execute( "retrieveByPk", params );                
    }
    
    /**
     * @param objectType
     * @param keys
     * @return
     * @throws XmlRpcException
     * @throws IOException
     * @throws DocumentException
     */
    public Document retrieveByPks( String objectType, Vector keys ) throws XmlRpcException, IOException, DocumentException
    {
        Vector params = new Vector(3);
        params.add( rpcSessionId );
        params.add( objectType );
        params.add( ObjectSerializer.objectToXml( keys ) );
        return execute( "retrieveByPks", params );        
    }
    
    /**
     * @param method
     * @param params
     * @return
     * @throws XmlRpcException
     * @throws IOException
     * @throws DocumentException
     */
    private Document execute( String method, Vector params ) throws XmlRpcException, IOException, DocumentException
    {
        String xml = (String)rpcClient.execute( method, params );
        if( xml != null && xml.length() > 0 )
        {
            return DocumentHelper.parseText( xml );
        }
        
        return null;
    }
}
