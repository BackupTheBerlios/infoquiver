/*********************************************************************
 * IQuiverUtil.java
 * created on 30.11.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/infoquiver-web/WEB-INF/src/net/sf/iquiver/web/IQuiverUtil.java,v $
 * $Date: 2004/12/02 22:35:05 $
 * $Revision: 1.4 $
 *********************************************************************/

package net.sf.iquiver.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.velocity.app.Velocity;
import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author netseeker aka Michael Manske
 */
public class IQuiverUtil
{
    private static XStream xstream = new XStream( new DomDriver() );

    /**
     * @param context
     */
    public static synchronized void loadResources( ServletContext context )
    {
        Hashtable bundles = new Hashtable();
        String path = context.getRealPath( "/" );
        File file = new File( path + "WEB-INF/resources" );
        if (file.exists())
        {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++)
            {
                if (files[i].isFile() && files[i].getName().endsWith( ".properties" ))
                {
                    try
                    {
                        ResourceBundle rb = new PropertyResourceBundle( new FileInputStream( files[i] ) );
                        String name = rb.getLocale().toString();
                        if (name.length() == 0)
                        {
                            name = "default";
                        }
                        bundles.put( name, rb );
                    }
                    catch ( IOException e )
                    {
                        Velocity.error( e );
                    }
                }
            }
        }
        else
        {
            Velocity.error( "Resource directory " + path + "WEB-INF/resources could not be found!" );
        }
        
        context.setAttribute( "net.sf.iquiver.web.RESOURCES", bundles );
    }

    /**
     * @param request
     * @param session
     * @return
     */
    public static Locale getLocale( HttpServletRequest request, HttpSession session )
    {
        Locale locale = null;
        if (session != null)
        {
            locale = (Locale) session.getAttribute( "net.sf.iquiver.web.LOCALE" );
        }
        if (locale == null)
        {
            locale = request.getLocale();
        }

        return locale;
    }

    /**
     * @param object
     * @return
     */
    public static String objectToXml( Object object )
    {
        return xstream.toXML( object );
    }
    
    /**
     * @param xml
     * @return
     */
    public static Object xmlToObject( String xml )
    {
        return xstream.fromXML( xml );
    }
    
    /**
     * @param xml
     * @return
     */
    public static Object xmlToObject( Document xml )
    {
        return xstream.fromXML( xml.asXML() );
    }
    
    /**
     * @param request
     * @return
     */
    public static XmlRpcClient getXmlRpcClient( HttpServletRequest request )
    {
        HttpSession session = request.getSession();
        XmlRpcClient client = (XmlRpcClient)session.getAttribute("net.sf.iquiver.web.XmlRpcClient");
        
        if( client == null )
        {
            String path = session.getServletContext().getRealPath("/");
            try
            {
                Properties properties = new Properties();
                properties.load( new FileInputStream( path + "/WEB-INF/iquiver-web.properties") );
                client = new XmlRpcClient(properties.getProperty("host"), Integer.parseInt( properties.getProperty("port") ) );
                session.setAttribute( "net.sf.iquiver.web.XmlRpcClient", client );
            }
            catch ( IOException e )
            {
                Velocity.error( e );
            }            
        }
        
        return client;
    }
    
    /**
     * @param rpcClient
     * @param method
     * @param params
     * @return
     * @throws XmlRpcException
     * @throws IOException
     * @throws DocumentException
     */
    public static Document execute(XmlRpcClient rpcClient, String method, Vector params ) throws XmlRpcException, IOException, DocumentException
    {
        String xml = (String)rpcClient.execute("default." + method, params );
        if( xml != null && xml.length() > 0 )
        {
            return DocumentHelper.parseText( xml );
        }
        
        return null;
    }     
}