/*
 * Created on 02.07.2004
 */
package net.sf.iquiver.util;

import java.util.Iterator;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author netseeker aka Michael Manske
 */
public class ObjectSerializer
{
    private static XStream xstream = new XStream( new DomDriver() );

    /**
     * @param object
     * @return
     */
    public static String objectToXml( Object object )
    {
        if(object instanceof XmlSerializable)
        {
            return ((XmlSerializable)object).toXml();
        }
        
        return xstream.toXML( object );
    }

    /**
     * @param object
     * @param xml
     */
    public static void xmlToObject(Object object, String xml )
    {
        if(object instanceof XmlSerializable)
        {
            ((XmlSerializable)object).fromXml( xml );
        }
        else
        {
            object = xstream.fromXML( xml );
        }
    }
    
    /**
     * Method to convert an xml string into an object
     * @param xml xml string, MUST be formerly created via XStream
     * @return
     */
    public static Object xmlToObject( String xml )
    {
        return xstream.fromXML( xml );
    }
    
    /**
     * Converts an instance of net.sf.iquiver.util.Introspectable into an xml representation
     * @param obj the object to convert to xml string
     * @return a string containing the xml represantation of <code>obj</code>
     */
    public static String objectToXmlString( Introspectable obj )
    {
        List fieldNames = obj.getMemberNames();
        StringBuffer sb = new StringBuffer();
        String[] nameTokens = obj.getClass().getName().split("\\.");        
        
        sb.append("<");
        sb.append( nameTokens[ nameTokens.length - 1 ] );
        sb.append(">\n");
        
        for( Iterator it = fieldNames.iterator(); it.hasNext(); )
        {
            String name = (String)it.next();
            appendXmlIfNotNull( sb, name, obj.getMemberValueByName( name ) );
        }
        
        sb.append("</");
        sb.append( nameTokens[ nameTokens.length - 1 ] );
        sb.append(">\n");    

        return sb.toString();
    }
    
    
    
    private static void appendXmlIfNotNull( StringBuffer sb, String name, Object value )
    {
        sb.append( "<" );
        sb.append( name );
        if (value != null)
        {
            sb.append( ">" );
            sb.append( value );
            sb.append( "</" );
            sb.append( name );
            sb.append( ">" );
        }
        else
        {
            sb.append( "/>" );
        }

        sb.append( "\n" );
    }    
}