/*
 * Created on 09.07.2004
 */
package net.sf.iquiver.test.junit;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.om.Content;
import net.sf.iquiver.om.ContentPeer;
import net.sf.iquiver.parser.impl.HtmlParser;

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
            Content content = ContentPeer.retrieveByPK(1001);
            Document doc = parser.parse( content );
            System.out.println(doc.getRawContent());
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }

}
