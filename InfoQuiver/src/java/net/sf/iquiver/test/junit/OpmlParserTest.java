/*
 * Created on 12.07.2004
 */
package net.sf.iquiver.test.junit;

import java.io.IOException;
import java.net.URL;

import de.nava.informa.core.ParseException;
import de.nava.informa.parsers.OPMLParser;

/**
 * @author netseeker aka Michael Manske
 */
public class OpmlParserTest extends BaseIQuiverTestCase
{
    public void testGeneral()
    {
        try
        {
            OPMLParser.parse(new URL("http://www.golem.de/rss.php?tp=inet&feed=OPML"));
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        catch ( ParseException e )
        {
            e.printStackTrace();
        }        
    }
}
