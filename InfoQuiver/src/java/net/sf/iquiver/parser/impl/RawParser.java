/*********************************************************************
 * RawParser.java
 * created on 18.07.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/parser/impl/RawParser.java,v $
 * $Date: 2004/07/18 17:19:19 $
 * $Revision: 1.1 $
*********************************************************************/

package net.sf.iquiver.parser.impl;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.util.Date;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.metaformat.impl.ContentTypeFactory;
import net.sf.iquiver.metaformat.impl.MetaFormatFactory;
import net.sf.iquiver.parser.Parser;
import net.sf.iquiver.parser.ParsingException;
import net.sf.iquiver.parser.UnsupportedContentTypeException;

/**
 * A raw parser for binary and text based data (kind of multipart), 
 * which will recognize all characters contained in the ISO-8859-1 charset
 * while ignoring all other characters.
 * @author netseeker aka Michael Manske
 */
public class RawParser extends Parser
{
    public static final Charset charset = Charset.forName("ISO-8859-1");
    private static CharsetDecoder decoder;
    
    static
    {
        decoder = charset.newDecoder();
        decoder.onMalformedInput( CodingErrorAction.IGNORE );
        decoder.onUnmappableCharacter( CodingErrorAction.IGNORE );
    }
    
    /* (non-Javadoc)
     * @see net.sf.iquiver.parser.Parser#parse(byte[])
     */
    public Document parse( byte[] rawContent ) throws ParsingException
    {
        Document doc = null;
        try
        {
            doc = MetaFormatFactory.createDocumentForContentType( ContentTypeFactory.CT_MULTIPART_MIXED );
        }
        catch ( UnsupportedContentTypeException e )
        {
            //can't happen because we are using an default content type
        }
        
        try
        {
            doc.setRawContent( rawContent );
        }
        catch ( UnsupportedEncodingException e1 )
        {
            throw new ParsingException( e1.getMessage(), -1 );
        }
        
        doc.setDateOfCreation( new Date() );
        doc.setDateOfLastModification( new Date() );
        
        return doc;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.parser.Parser#getStripped(byte[])
     */
    public String getStripped( byte[] rawContent ) throws ParsingException
    {
        ByteBuffer buf = ByteBuffer.wrap( rawContent );

        try
        {
            CharBuffer cBuf = decoder.decode( buf );
            if( cBuf != null )
            {
                return cBuf.toString();
            }            
        }
        catch ( CharacterCodingException e )
        {
            throw new ParsingException( e.getMessage(), -1 );
        }
        
        return null;
    }
}
