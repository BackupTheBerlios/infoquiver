/*
 * Created on 09.07.2004
 */
package net.sf.iquiver.parser.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.metaformat.impl.MetaFormatFactory;
import net.sf.iquiver.parser.ParsingException;
import net.sf.iquiver.parser.UnsupportedContentTypeException;
import de.nava.informa.core.ChannelIF;
import de.nava.informa.core.ItemIF;
import de.nava.informa.core.ParseException;
import de.nava.informa.impl.basic.ChannelBuilder;

/**
 * @author netseeker aka Michael Manske
 */
public class FeedParser
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog(FeedParser.class);
    
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
            doc = MetaFormatFactory.createDocumentForContentType( MetaFormatFactory.CT_TEXT_XML );
            ChannelIF channel = de.nava.informa.parsers.FeedParser.parse( new ChannelBuilder(),
                    new ByteArrayInputStream( rawContent ) );
            
            doc.setAuthor( channel.getPublisher() );
            doc.setDateOfCreation( channel.getPubDate() );
            doc.setDateOfLastModification( channel.getLastUpdated() );
            doc.setShortDescription( channel.getDescription() );
            doc.setInfoURL( channel.getSite() );
            doc.setTitle( channel.getTitle() );
            doc.setName( channel.getTitle() );
            
            for ( Iterator it = channel.getItems().iterator(); it.hasNext();)
            {
                try
                {
	                ItemIF item = (ItemIF)it.next();
	                Document child = MetaFormatFactory.createDocumentForContentType( MetaFormatFactory.CT_TEXT_XML );
	                child.setInfoURL( item.getLink() );
	                child.setAuthor( item.getCreator() );
	                child.setName( item.getTitle() );
	                child.setTitle( item.getTitle() );
	                child.setShortDescription( item.getSubject() );
	                child.setRawContent( item.getDescription().getBytes() );
	                doc.addChild( child );
                }
                catch( Exception e)
                {
                    logger.error( "Error occured while adding child document to docUID=" + doc.getUID(), e);
                }
            }
        }
        catch ( UnsupportedContentTypeException e )
        {
            throw new ParsingException( e.getMessage(), -1);
        }
        catch ( IOException e )
        {
            throw new ParsingException( e.getMessage(), -1);            
        }
        catch ( ParseException e )
        {
            throw new ParsingException( e.getMessage(), -1);
        }

        return doc;
    }
}