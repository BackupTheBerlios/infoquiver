/*
 * Created on 12.07.2004
 */
package net.sf.iquiver.test.junit;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.om.Content;
import net.sf.iquiver.om.ContentPeer;
import net.sf.iquiver.parser.impl.FeedParser;

/**
 * @author netseeker aka Michael Manske
 */
public class FeedParserTest extends BaseIQuiverTestCase
{
    FeedParser parser = new FeedParser();
    
    public void testRSS_091()
    {
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
    
    public void testRSS_10()
    {
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

    public void testRSS_20()
    {
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

    public void testATOM_03()
    {
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

    public void testOPML_10()
    {
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
