/*
 * Created on 09.07.2004
 */
package net.sf.iquiver.parser.impl;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.metaformat.impl.ContentTypeFactory;
import net.sf.iquiver.metaformat.impl.MetaFormatFactory;
import net.sf.iquiver.parser.ParsingException;
import net.sf.iquiver.parser.UnsupportedContentTypeException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.nava.informa.core.ChannelIF;
import de.nava.informa.core.ItemIF;
import de.nava.informa.core.ParseException;
import de.nava.informa.impl.basic.ChannelBuilder;

/**
 * @author netseeker aka Michael Manske
 */
public class FeedParser extends RawXmlParser
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( FeedParser.class );

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

            ChannelIF channel = de.nava.informa.parsers.FeedParser.parse( new ChannelBuilder(),
                    new BufferedInputStream( new ByteArrayInputStream( rawContent ) ) );

            doc.setAuthor( channel.getPublisher() );
            doc.setDateOfCreation( channel.getPubDate() );
            doc.setDateOfLastModification( channel.getLastUpdated() );
            doc.setShortDescription( channel.getDescription() );
            doc.setInfoURL( channel.getSite() );
            doc.setTitle( channel.getTitle() );
            doc.setName( channel.getTitle() );
            doc.setRawContent( rawContent );

            for (Iterator it = channel.getItems().iterator(); it.hasNext();)
            {
                try
                {
                    ItemIF item = (ItemIF) it.next();
                    Document child = MetaFormatFactory.createDocumentForContentType( ContentTypeFactory.CT_TEXT_PLAIN );
                    child.setInfoURL( item.getLink() );
                    child.setAuthor( item.getCreator() );
                    child.setName( item.getTitle() );
                    child.setTitle( item.getTitle() );
                    child.setShortDescription( item.getSubject() );
                    child.setRawContent( item.getDescription().getBytes() );
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

        ChannelIF channel = null;
        try
        {
            channel = de.nava.informa.parsers.FeedParser.parse( new ChannelBuilder(), new BufferedInputStream(
                    new ByteArrayInputStream( rawContent ) ) );
        }
        catch ( Exception e )
        {
            throw new ParsingException( e.getMessage(), -1 );
        }

        sb.append( channel.getTitle() );
        sb.append( "\n\n" );
        sb.append( channel.getDescription() );
        sb.append( "\n\n" );

        for (Iterator it = channel.getItems().iterator(); it.hasNext();)
        {
            ItemIF item = (ItemIF) it.next();
            sb.append( item.getTitle() );
            sb.append( "\n\n" );
            sb.append( item.getSubject() );
            sb.append( "\n\n" );
            sb.append( item.getDescription() );

            if (it.hasNext())
            {
                sb.append( "\n\n" );
            }
        }

        return sb.toString();
    }
}