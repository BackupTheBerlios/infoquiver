/*
 * Created on 12.07.2004
 */
package net.sf.iquiver.parser.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.metaformat.impl.ContentTypeFactory;
import net.sf.iquiver.metaformat.impl.MetaFormatFactory;
import net.sf.iquiver.parser.ParsingException;
import net.sf.iquiver.parser.UnsupportedContentTypeException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.nava.informa.core.FeedIF;
import de.nava.informa.core.ParseException;
import de.nava.informa.parsers.OPMLParser;

/**
 * @author netseeker aka Michael Manske
 */
public class OpmlParser extends RawXmlParser
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( OpmlParser.class );

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.parser.Parser#parse(byte[])
     */
    public Document parse( byte[] rawContent ) throws ParsingException
    {
        Document doc = null;
        try
        {
            doc = MetaFormatFactory.createDocumentForContentType( ContentTypeFactory.CT_APPLICATION_XML );
            doc.setRawContent( rawContent );
            Collection feeds = OPMLParser.parse( new ByteArrayInputStream( rawContent ) );

            for (Iterator it = feeds.iterator(); it.hasNext();)
            {
                try
                {
                    FeedIF item = (FeedIF) it.next();
                    Document child = MetaFormatFactory.createDocumentForContentType( ContentTypeFactory.CT_TEXT_PLAIN );
                    child.setInfoURL( item.getSite() );
                    child.setDateOfCreation( item.getDateFound() );
                    child.setDateOfLastModification( item.getLastUpdated() );
                    child.setName( item.getTitle() );
                    child.setTitle( item.getTitle() );
                    child.setRawContent( item.getText().getBytes() );
                    doc.addChild( child );
                }
                catch ( Exception e )
                {
                    logger.error( "Error occured while adding child document to docUID=" + doc.getUID(), e );
                }
            }
        }
        catch ( UnsupportedContentTypeException e )
        {
            throw new ParsingException( e.getMessage(), -1 );
        }
        catch ( IOException e )
        {
            throw new ParsingException( e.getMessage(), -1 );
        }
        catch ( ParseException e )
        {
            throw new ParsingException( e.getMessage(), -1 );
        }

        return doc;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.parser.Parser#getStripped(byte[])
     */
    public String getStripped( byte[] rawContent ) throws ParsingException
    {
        StringBuffer sb = new StringBuffer();

        try
        {
            Collection feeds = OPMLParser.parse( new ByteArrayInputStream( rawContent ) );
            for (Iterator it = feeds.iterator(); it.hasNext();)
            {
                FeedIF item = (FeedIF) it.next();
                sb.append( item.getTitle() );
                sb.append( "\n\n" );
                sb.append( item.getText() );
                if( it.hasNext() )
                {
                    sb.append( "\n\n" );
                }
            }            
        }
        catch ( Exception e )
        {
            throw new ParsingException( e.getMessage(), -1 );
        }
        

        return sb.toString();
    }
}