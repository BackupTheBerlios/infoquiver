/*********************************************************************
 * I18nManager.java
 * created on 29.11.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/infoquiver-web/WEB-INF/src/net/sf/iquiver/web/I18nManager.java,v $
 * $Date: 2004/11/29 23:44:41 $
 * $Revision: 1.1 $
 *********************************************************************/

package net.sf.iquiver.web;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.velocity.tools.view.context.ViewContext;
import org.apache.velocity.tools.view.tools.ViewTool;

/**
 * @author netseeker aka Michael Manske
 */
public class I18nManager implements ViewTool
{
    private ServletContext servContext;
    private HttpServletRequest request;
    
    /* (non-Javadoc)
     * @see org.apache.velocity.tools.view.tools.ViewTool#init(java.lang.Object)
     */
    public void init( Object obj )
    {
        ViewContext context = (ViewContext) obj;
        servContext = context.getServletContext();
        request = context.getRequest();
        if (servContext.getAttribute( "net.sf.iquiver.web.RESOURCES" ) == null)
        {
            IQuiverUtil.loadResources( servContext );
        }
    }

    /**
     * @param key
     * @return
     */
    public String get( String key )
    {
        Locale locale = IQuiverUtil.getLocale( request, request.getSession( false ) );        
        return get( key, locale.toString() );
    }

    /**
     * @param key
     * @param locale
     * @return
     */
    public String get( String key, String locale )
    {
        Map bundles = (Map)servContext.getAttribute( "net.sf.iquiver.web.RESOURCES" );
        ResourceBundle rb = (ResourceBundle) (bundles.containsKey( locale ) ? bundles.get( locale ) : bundles
                .get( "default" ));

        return rb.getString( key );
    }
}