/*
 * Created on 15.03.2004
 *
 */
package net.sf.iquiver.parser.impl;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Properties;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.metaformat.impl.ContentTypeFactory;
import net.sf.iquiver.metaformat.impl.MetaFormatFactory;
import net.sf.iquiver.parser.Parser;
import net.sf.iquiver.parser.ParsingException;

import org.apache.commons.httpclient.util.DateParseException;
import org.apache.commons.httpclient.util.DateParser;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * A simple HTML parser using Lucenes demo html parser.
 * @author netseeker aka Michael Manske
 */
public class HtmlParser extends Parser
{
    private static final Log logger = LogFactory.getLog( HtmlParser.class );

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.parser.Parser#parse(java.io.InputStream)
     */
    public Document parse( byte[] rawContent ) throws ParsingException
    {
        org.apache.lucene.demo.html.HTMLParser parser = new org.apache.lucene.demo.html.HTMLParser(
                new BufferedInputStream( new ByteArrayInputStream( rawContent ) ) );
        Document doc = null;
        try
        {
            doc = MetaFormatFactory.createDocumentForContentType( ContentTypeFactory.CT_TEXT_HTML );
            doc.setRawContent( rawContent );
        }
        catch ( Exception e )
        {
            logger.error( e );
            throw new ParsingException( e.getMessage(), -1 );
        }

        try
        {
            doc.setTitle( parser.getTitle() );
            doc.setName( parser.getTitle() );
            //doc.setShortDescription( parser.getSummary() );
            Properties metas = parser.getMetaTags();
            doc.setAuthor( metas.getProperty( "author" ) );
            String date = metas.getProperty( "date" );
            if (date != null)
            {
                try
                {
                    doc.setDateOfLastModification( DateParser.parseDate( date ) );
                }
                catch ( DateParseException e )
                {
                    logger.warn( "Unable to parse creation date: " + date, e );
                }
            }
            doc.setShortDescription( metas.getProperty( "description" ) );
            doc.setKeywords( metas.getProperty( "keywords" ) );

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
        org.apache.lucene.demo.html.HTMLParser parser = new org.apache.lucene.demo.html.HTMLParser(
                new BufferedInputStream( new ByteArrayInputStream( rawContent ) ) );

        String content = null;
        try
        {
            content = IOUtils.toString( new BufferedReader( parser.getReader() ) );
        }
        catch ( IOException e )
        {
            throw new ParsingException( e.getMessage(), -1 );
        }

        return content;
    }
}