/*********************************************************************
 * VelocityParser.java
 * created on 27.11.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/util/VelocityParser.java,v $
 * $Date: 2004/11/27 17:36:58 $
 * $Revision: 1.1 $
 *********************************************************************/

package net.sf.iquiver.util;

import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;

import net.sf.iquiver.IQuiver;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.RuntimeConstants;

/**
 * @author netseeker aka Michael Manske
 */
public class VelocityParser
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( VelocityParser.class );

    static boolean isInit;

    static
    {
        try
        {
            Velocity.init();
            Velocity.setProperty( RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS,
                    "org.apache.velocity.runtime.log.SimpleLog4JLogSystem" );
            isInit = true;
        }
        catch ( Exception e )
        {
            isInit = false;
            logger.error( "Error while initializing Velocity!", e );
        }
    }

    /**
     * Parses and evaluates a localized velocity template
     * @param template path to the velocity template without file extension
     * @param contextVars The variables to pass to the template
     * @param lang the required language
     * @return a String containing the evaluated template content
     * @throws Exception if parsing fails 
     */
    public static String parseI18n( String template, Map contextVars, String lang ) throws Exception
    {
        if (template.endsWith( ".vm" ))
        {
            template = template.substring( 0, template.indexOf( ".vm" ) );
        }

        return parse( template + "_" + lang, contextVars );
    }

    /**
     * Parses and evaluates a localized velocity template while using the default language (<var>default.language</var>)
     * configured in iquiver.properties 
     * @param template path to the velocity template without file extension
     * @param contextVars The variables to pass to the template
     * @return a String containing the evaluated template content
     * @throws Exception if parsing fails
     */
    public static String parseI18n( String template, Map contextVars ) throws Exception
    {
        return parseI18n( template, contextVars, IQuiver.getConfiguration().getString( "default.language" ) );
    }

    /**
     * Parses and evaluates an arbitary velocity template
     * @param template path to the velocity template with or without file extension 
     * @param contextVars The variables to pass to the template
     * @return a String containing the evaluated template content
     * @throws Exception if parsing fails 
     */
    public static String parse( String template, Map contextVars ) throws Exception
    {
        VelocityContext context = new VelocityContext();

        if (!template.endsWith( ".vm" ))
        {
            template += ".vm";
        }

        for (Iterator it = contextVars.keySet().iterator(); it.hasNext();)
        {
            String key = (String) it.next();
            context.put( key, contextVars.get( key ) );
        }

        StringWriter out = new StringWriter();
        Velocity.mergeTemplate( template, context, out );
        return out.toString();
    }
}