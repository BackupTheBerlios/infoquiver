/*
 * Created on 12.07.2004
 */
package net.sf.iquiver.test.junit;

import java.io.DataInputStream;
import java.net.URL;
import java.net.URLConnection;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.parser.impl.OpmlParser;

import org.apache.commons.io.IOUtils;

/**
 * @author netseeker aka Michael Manske
 */
public class OpmlParserTest extends BaseIQuiverTestCase
{
    public void testGeneral()
    {
        try
        {
            OpmlParser parser = new OpmlParser();
            URLConnection connection = openConnection( new URL( "http://www.golem.de/rss.php?tp=inet&feed=OPML" ) );
            DataInputStream input = new DataInputStream( connection.getInputStream() );
            Document doc = parser.parse( IOUtils.toByteArray( input ) );
            input.close();
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