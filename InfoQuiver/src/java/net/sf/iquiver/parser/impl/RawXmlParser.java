/*
 * Created on 10.07.2004
 */
package net.sf.iquiver.parser.impl;

import java.io.UnsupportedEncodingException;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.metaformat.impl.ContentTypeFactory;
import net.sf.iquiver.metaformat.impl.DefaultDocument;
import net.sf.iquiver.parser.Parser;
import net.sf.iquiver.parser.ParsingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author netseeker aka Michael Manske
 */
public class RawXmlParser extends Parser
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( RawXmlParser.class );

    /* (non-Javadoc)
     * @see net.sf.iquiver.parser.Parser#parse(byte[])
     */
    public Document parse( byte[] rawContent ) throws ParsingException
    {
        Parser parser = ParserFactory.getParserForKnownXmlDialect( rawContent );
        if (parser != null)
        {
            return parser.parse( rawContent );
        }

        Document doc = new DefaultDocument( ContentTypeFactory.CT_TEXT_XML );
        try
        {
            doc.setRawContent( rawContent );
        }
        catch ( UnsupportedEncodingException e )
        {
            throw new ParsingException( e.getMessage(), -1 );
        }

        return doc;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.parser.Parser#getStripped(byte[])
     */
    public String getStripped( byte[] rawContent ) throws ParsingException
    {
        String result = null;
        Parser parser = ParserFactory.getParserForKnownXmlDialect( rawContent );

        if (parser != null)
        {
            result = parser.getStripped( rawContent );
        }
        else
        {
            try
            {
                result = new String( rawContent ).replaceAll("</[^</]+>" , "\n" );
                result = result.replaceAll("<", "");
                result = result.replaceAll("/>", "\n");
                result = result.replaceAll(">", "\n");
            }
            catch ( Exception e )
            {
                throw new ParsingException( e.getMessage(), -1 );
            }
        }

        if (logger.isDebugEnabled())
        {
            logger.debug( "getStripped() --> " + result );
        }

        return result;
    }
}