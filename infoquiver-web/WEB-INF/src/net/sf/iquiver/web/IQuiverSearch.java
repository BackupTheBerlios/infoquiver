/*********************************************************************
 * IQuiverSearch.java
 * created on 02.12.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/infoquiver-web/WEB-INF/src/net/sf/iquiver/web/IQuiverSearch.java,v $
 * $Date: 2004/12/02 22:35:05 $
 * $Revision: 1.1 $
 *********************************************************************/

package net.sf.iquiver.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.tools.view.tools.AbstractSearchTool;
import org.apache.velocity.tools.view.tools.ParameterParser;
import org.apache.xmlrpc.XmlRpcClient;
import org.dom4j.Document;

/**
 * @author netseeker aka Michael Manske
 */
public class IQuiverSearch extends AbstractSearchTool
{
    private XmlRpcClient rpcClient;
    private String rpcSessionId = "";
    private HttpSession session;

    /* (non-Javadoc)
     * @see org.apache.velocity.tools.view.tools.AbstractSearchTool#setup(javax.servlet.http.HttpServletRequest)
     */
    public void setup( HttpServletRequest request )
    {
        if (rpcClient == null)
        {
            rpcClient = IQuiverUtil.getXmlRpcClient( request );
        }

        session = request.getSession();
        ParameterParser pp = new ParameterParser( request );
        setCriteria( pp.getString( "criteria", "" ) );
        setIndex( pp.getInt( "index", 0 ) );
        setItemsPerPage( pp.getInt( "show", DEFAULT_ITEMS_PER_PAGE ) );
    }

    /* (non-Javadoc)
     * @see org.apache.velocity.tools.view.tools.AbstractSearchTool#executeQuery(java.lang.Object)
     */
    protected List executeQuery( Object criteria )
    {        
        Document user = (Document)session.getAttribute("user");
        Vector params = new Vector(3);
        params.add( rpcSessionId );
        params.add( user.asXML() );
        params.add( (String)criteria );
        try
        {
            return( List) rpcClient.execute("default.doSearch", params );
        }
        catch ( Exception e )
        {
            Velocity.error( e );
        }
        
        return new ArrayList();
    }

}