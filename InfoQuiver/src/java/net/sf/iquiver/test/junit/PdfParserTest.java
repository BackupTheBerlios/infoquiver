/*
 * Created on 10.07.2004
 */
package net.sf.iquiver.test.junit;

import java.io.DataInputStream;
import java.net.URL;
import java.net.URLConnection;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.parser.impl.PdfParser;

import org.apache.commons.io.IOUtils;

/**
 * @author netseeker aka Michael Manske
 */
public class PdfParserTest extends BaseIQuiverTestCase
{

    /*
     * Class under test for Document parse(byte[])
     */
    public void testParsebyteArray()
    {
        PdfParser parser = new PdfParser();
        
        try
        {
            URL url = new URL( "http://www.manskes.de/cms/upload/pdf/torque_caching_manual.pdf" );
            URLConnection connection = url.openConnection();
            DataInputStream input = new DataInputStream(connection.getInputStream());
            Document doc = parser.parse( IOUtils.toByteArray( input ) );
            assertNotNull( doc.getRawContent() );
            String stripped = parser.getStripped( doc.getRawContent() );
            assertNotNull( stripped );
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }        
    }

}
