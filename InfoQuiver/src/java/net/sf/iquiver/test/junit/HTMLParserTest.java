/*
 * Created on 09.07.2004
 */
package net.sf.iquiver.test.junit;

import java.io.IOException;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.om.Content;
import net.sf.iquiver.om.ContentPeer;
import net.sf.iquiver.parser.ParsingException;
import net.sf.iquiver.parser.impl.HTMLParser;

import org.apache.torque.TorqueException;

/**
 * @author netseeker aka Michael Manske
 */
public class HTMLParserTest extends BaseIQuiverTestCase
{

    /*
     * Class under test for Document parse(Document)
     */
    public void testParseDocument()
    {
        HTMLParser parser = new HTMLParser();
        
        try
        {
            Content content = ContentPeer.retrieveByPK(1060);
            Document doc = parser.parse( content );
            System.out.println(doc.getRawContent());
        }
        catch ( TorqueException e )
        {
            e.printStackTrace();
        }
        catch ( ParsingException e )
        {
            e.printStackTrace();
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        
    }

}
