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

/**
 * @author netseeker aka Michael Manske
 */
public class RawXmlParser extends Parser
{

    /* (non-Javadoc)
     * @see net.sf.iquiver.parser.Parser#parse(byte[])
     */
    public Document parse( byte[] rawContent ) throws ParsingException
    {
        Parser parser = ParserFactory.getParserForKnownXmlDialect( rawContent );
        if( parser != null )
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
            throw new ParsingException( e.getMessage(), -1);
        }
        
        return doc;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.parser.Parser#getStripped(byte[])
     */
    public String getStripped( byte[] rawContent ) throws ParsingException
    {        
        Parser parser = ParserFactory.getParserForKnownXmlDialect( rawContent );
        if( parser != null )
        {
            return parser.getStripped( rawContent );
        }
        
        return new String( rawContent );
    }    
}
