/*
 * Created on 11.07.2004
 */
package net.sf.iquiver.parser.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.metaformat.impl.ContentTypeFactory;
import net.sf.iquiver.metaformat.impl.MetaFormatFactory;
import net.sf.iquiver.parser.Parser;
import net.sf.iquiver.parser.ParsingException;
import net.sf.iquiver.parser.UnsupportedContentTypeException;

/**
 * Dummy Parser for plain/text content
 * @author netseeker aka Michael Manske
 */
public class TextParser extends Parser
{

    /* (non-Javadoc)
     * @see net.sf.iquiver.parser.Parser#parse(byte[])
     */
    public Document parse( byte[] rawContent ) throws ParsingException
    {
        Document doc = null;
        
        try
        {
            doc = MetaFormatFactory.createDocumentForContentType( ContentTypeFactory.CT_TEXT_PLAIN );
            doc.setRawContent( rawContent );
            doc.setDateOfCreation( new Date() );
            doc.setDateOfLastModification( new Date() );
        }
        catch ( UnsupportedContentTypeException e )
        {
            //can't happen because we use a default content type
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
        return new String( rawContent );
    }

}
