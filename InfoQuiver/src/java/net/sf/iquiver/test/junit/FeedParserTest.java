/*
 * Created on 12.07.2004
 */
package net.sf.iquiver.test.junit;

import java.io.DataInputStream;
import java.net.URL;
import java.net.URLConnection;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.parser.impl.FeedParser;

import org.apache.commons.io.IOUtils;

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
            URLConnection connection = openConnection(new URL( "http://www.golem.de/rss.php?tp=inet&feed=RSS0.91" ));
            DataInputStream input = new DataInputStream(connection.getInputStream());
            Document doc = parser.parse( IOUtils.toByteArray( input ) );
            input.close();
            System.out.println( doc.getRawContent() );
            String stripped = parser.getStripped( doc.getRawContent() );
            System.out.println( stripped );
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
            URLConnection connection = openConnection(new URL( "http://www.golem.de/rss.php?tp=inet&feed=RSS1.0" ));
            DataInputStream input = new DataInputStream(connection.getInputStream());
            Document doc = parser.parse( IOUtils.toByteArray( input ) );
            input.close();
            System.out.println( doc.getRawContent() );
            String stripped = parser.getStripped( doc.getRawContent() );
            System.out.println( stripped );
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
            URLConnection connection = openConnection(new URL( "http://www.golem.de/rss.php?tp=inet&feed=RSS2.0" ));
            DataInputStream input = new DataInputStream(connection.getInputStream());
            Document doc = parser.parse( IOUtils.toByteArray( input ) );
            input.close();
            System.out.println(doc.getRawContent());
            String stripped = parser.getStripped( doc.getRawContent() );
            System.out.println( stripped );
            
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
            URLConnection connection = openConnection(new URL( "http://www.golem.de/rss.php?tp=inet&feed=ATOM0.3" ));
            DataInputStream input = new DataInputStream(connection.getInputStream());
            Document doc = parser.parse( IOUtils.toByteArray( input ) );
            input.close();
            System.out.println( doc.getRawContent() );
            String stripped = parser.getStripped( doc.getRawContent() );
            System.out.println( stripped );
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }        
    }    
}
