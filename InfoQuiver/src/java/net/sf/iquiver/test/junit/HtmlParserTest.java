/*
 * Created on 09.07.2004
 */
package net.sf.iquiver.test.junit;

import java.io.DataInputStream;
import java.net.URL;
import java.net.URLConnection;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.parser.impl.HtmlParser;

import org.apache.commons.io.IOUtils;

/**
 * @author netseeker aka Michael Manske
 */
public class HtmlParserTest extends BaseIQuiverTestCase
{

    /*
     * Class under test for Document parse(Document)
     */
    public void testParseDocument()
    {
        HtmlParser parser = new HtmlParser();
        
        try
        {
            URL url = new URL( "http://www.manskes.de/iquiver/" );
            URLConnection connection = url.openConnection();
            DataInputStream input = new DataInputStream(connection.getInputStream());
            Document doc = parser.parse( IOUtils.toByteArray( input ) );
            input.close();
            System.out.println(doc.getRawContent());
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }

}
