/*
 * Created on 10.07.2004
 */
package net.sf.iquiver.parser.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

import net.sf.iquiver.om.ContentParser;
import net.sf.iquiver.om.ContentType;
import net.sf.iquiver.om.ContentTypePeer;
import net.sf.iquiver.parser.Parser;
import net.sf.iquiver.parser.UnsupportedContentTypeException;

/**
 * Factory for creating Parser instances. This implementation does cache all
 * already instantiated Parser objects.
 * 
 * @author netseeker aka Michael Manske
 */
public class ParserFactory
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( ParserFactory.class );

    /**
     * The default parser used in InfoQuiver
     */
    private static final Parser DEFAULT_PARSER = new HtmlParser();

    /**
     * used for caching already instanciated parsers
     */
    private static Map _parsers = new HashMap();

    /**
     * @param contentType
     * @return
     */
    public static Parser getParserForContentType( String contentType ) throws UnsupportedContentTypeException
    {
        Parser parser = (Parser) _parsers.get( contentType );
        
        if( parser == null )
        {
            Criteria crit = new Criteria();
            crit.add( ContentTypePeer.CONTENT_TYPE_NAME, contentType );
            List types;
            try
            {
                types = ContentTypePeer.doSelect( crit );
                if( types != null && !types.isEmpty() )
                {
                    parser = getParserForContentType( (ContentType)types.get(0) );
                }                
            }
            catch ( TorqueException e )
            {
                logger.error("Error while fetching content type \"" + contentType + "\" from database!", e);
                throw new UnsupportedContentTypeException( e );
            }            
        }
        
        return parser;
    }

    /**
     * @param contentType
     * @return
     */
    public static Parser getParserForContentType( ContentType contentType ) throws UnsupportedContentTypeException
    {
        Parser parser = (Parser) _parsers.get( contentType.getContentTypeName() );
        String clazz = null;

        if (parser == null)
        {
            try
            {
                ContentParser cParser = contentType.getContentParser();
                clazz = cParser.getContentParserImplementation();
                parser = (Parser) Class.forName( clazz ).newInstance();
                _parsers.put( contentType.getContentTypeName(), parser );
            }
            catch ( TorqueException e )
            {
                logger.error("Error while fetching content parser for \"" + contentType + "\" from database!", e);
                throw new UnsupportedContentTypeException( e );
            }
            catch ( InstantiationException e )
            {
                logger.error("Error while instantiating content parser \"" + clazz + "\"!", e);
                throw new UnsupportedContentTypeException( e );
            }
            catch ( IllegalAccessException e )
            {
                logger.error("Uknown access error while accessing content parser class \"" + clazz + "\"!", e);
                throw new UnsupportedContentTypeException( e );
            }
            catch ( ClassNotFoundException e )
            {
                logger.error("Can't locate content parser class \"" + clazz + "\"!", e);
                throw new UnsupportedContentTypeException( e );
            }
        }

        return parser;
    }

    /**
     * @return a basic default parser, capable of parsing simple text documents
     */
    public static final Parser getDefaultParser()
    {
        return DEFAULT_PARSER;
    }
}