/*
 * Created on 12.07.2004
 */
package net.sf.iquiver.test.junit;

import junit.framework.TestCase;
import net.sf.iquiver.parser.impl.RawXmlParser;

/**
 * @author netseeker aka Michael Manske
 */
public class RawXMLParserTest extends TestCase
{
    public void testGeneral()
    {
        try
        {
            String xml = "<transport>" +
                    "<name>Basic HTTP transport</name>" +
                    "<type>0</type>" +
                    "<attribute name=\"Server\" mandatory=\"true\" type=\"java.lang.String\"/>" +
                    "<attribute name=\"Port\" type=\"java.lang.Integer\"/>" +
                    "<attribute name=\"Login\" partOfAuthentification=\"yes\" type=\"java.lang.String\"/>" +
                    "<attribute name=\"Password\" partOfAuthentification=\"yes\" type=\"java.lang.String\"/>" +
                    "<attribute name=\"Timeout\" type=\"java.lang.Integer\"/>" +
                    "</transport>";
            
            RawXmlParser parser = new RawXmlParser();
            String stripped = parser.getStripped( xml.getBytes() );
            assertNotNull( stripped );
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }
}