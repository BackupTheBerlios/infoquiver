/*
 * Created on 10.07.2004
 */
package net.sf.iquiver.test.junit;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.om.Content;
import net.sf.iquiver.om.ContentPeer;
import net.sf.iquiver.parser.impl.PdfParser;

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
            Content content = ContentPeer.retrieveByPK(102);
            Document doc = parser.parse( content );
            System.out.println(doc.getRawContent());
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
        
    }

}
