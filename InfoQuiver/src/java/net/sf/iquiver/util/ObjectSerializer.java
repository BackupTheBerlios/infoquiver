/*
 * Created on 02.07.2004
 */
package net.sf.iquiver.util;

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
}