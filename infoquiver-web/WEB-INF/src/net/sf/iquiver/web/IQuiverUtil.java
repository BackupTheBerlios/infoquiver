/*********************************************************************
 * IQuiverUtil.java
 * created on 30.11.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/infoquiver-web/WEB-INF/src/net/sf/iquiver/web/IQuiverUtil.java,v $
 * $Date: 2004/11/29 23:44:41 $
 * $Revision: 1.1 $
 *********************************************************************/

package net.sf.iquiver.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.velocity.app.Velocity;

/**
 * @author netseeker aka Michael Manske
 */
public class IQuiverUtil
{
    /**
     * @param context
     */
    public static synchronized void loadResources( ServletContext context )
    {
        Hashtable bundles = new Hashtable();
        String path = context.getRealPath( "/" );
        File file = new File( path + "WEB-INF/resources" );
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
}