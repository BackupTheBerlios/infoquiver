/*********************************************************************
 * WordParser.java
 * created on 21.10.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/parser/impl/WordParser.java,v $
 * $Date: 2004/10/23 13:02:00 $
 * $Revision: 1.1 $
 *********************************************************************/

package net.sf.iquiver.parser.impl;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.metaformat.impl.ContentTypeFactory;
import net.sf.iquiver.metaformat.impl.MetaFormatFactory;
import net.sf.iquiver.parser.Parser;
import net.sf.iquiver.parser.ParsingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.textmining.text.extraction.WordExtractor;

/**
 * @author netseeker aka Michael Manske
 */
public class WordParser extends Parser
{
    private static final Log logger = LogFactory.getLog( WordParser.class );

    /* (non-Javadoc)
     * @see net.sf.iquiver.parser.Parser#parse(byte[])
     */
    public Document parse( byte[] rawContent ) throws ParsingException
    {
        Document doc = null;
        try
        {
            doc = MetaFormatFactory.createDocumentForContentType( ContentTypeFactory.CT_APPLICATION_MSWORD );
            doc.setRawContent( rawContent );
        }
        catch ( Exception e )
        {
            logger.error( e );
            throw new ParsingException( e.getMessage(), -1 );
        }

        return doc;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.parser.Parser#getStripped(byte[])
     */
    public String getStripped( byte[] rawContent ) throws ParsingException
    {
        WordExtractor extractor = new WordExtractor();
        String s;

        try
        {
            s = extractor.extractText( new BufferedInputStream( new ByteArrayInputStream( rawContent ) ) );
        }
        catch ( Exception e )
        {
            throw new ParsingException( e.getMessage(), -1 );
        }

        return s;
    }

}