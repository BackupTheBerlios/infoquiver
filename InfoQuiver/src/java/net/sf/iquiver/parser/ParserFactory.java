/*
 * Created on 08.03.2004
 */
package net.sf.iquiver.parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

import net.sf.iquiver.om.Content;
import net.sf.iquiver.om.ContentParser;
import net.sf.iquiver.om.ContentParserPeer;
import net.sf.iquiver.om.ContentType;
import net.sf.iquiver.om.ContentTypePeer;

/**
 * Factory for creating Parser instances. This implementation does cache all
 * already instantiated Parser objects.
 * 
 * @author netseeker aka Michael Manske
 */
public abstract class ParserFactory
{
    private static final Log logger = LogFactory.getLog( ParserFactory.class);

    /**
     * HashMap backed cache containing already instanciated Parser objects
     */
    private static Map parserCache = new HashMap();

    
    /**
     * @param contentTypeId
     * @return A adequate Parser for the supplied content type
     * @throws UnsupportedContentTypeException
     * @throws TorqueException
     */
    public static Parser getParser( int contentTypeId ) throws UnsupportedContentTypeException, TorqueException
    {
        Integer objTypeId = new Integer( contentTypeId );
        //first try getting a adequate Parser from cache
        Parser parser = (Parser) parserCache.get( objTypeId);

        //first call for the supplied content type?
        if ( parser == null )
        {
            ContentParser cParser = null;
            Criteria crit = new Criteria();
            crit.addJoin( ContentParserPeer.CONTENT_PARSER_ID, ContentTypePeer.CONTENT_PARSER_ID);
            crit.add( ContentTypePeer.CONTENT_TYPE_ID, contentTypeId);

            //try fetching available content parsers
            List results = ContentParserPeer.doSelect( crit);

            if ( results != null && !results.isEmpty() )
            {
                cParser = (ContentParser) results.get( 0);
                String implClass = cParser.getContentParserImplementation();
                try
                {
                    //IMPLEMENTATION is a mandatory field in database, so only
                    //physical missing or bad parser implementations could cause errors
                    parser = (Parser) Class.forName( implClass ).newInstance( );
                }
                catch ( InstantiationException e )
                {
                    logger.error( "Instantiation of parser \"" + implClass + "\" failed.", e);
                    throw new UnsupportedContentTypeException( e );
                }
                catch ( IllegalAccessException e )
                {
                    logger.error( "Cannot access parser \"" + implClass + "\".", e);
                    throw new UnsupportedContentTypeException( e );
                }
                catch ( ClassNotFoundException e )
                {
                    logger.error( "Parser \"" + implClass + "\" not found.", e);
                    throw new UnsupportedContentTypeException( e );
                }
            }
            else
            {
                throw new UnsupportedContentTypeException("Illegal content type identifier supplied");
            }
        
            //add Parser to cache
            parserCache.put(objTypeId, parser);
        }

        return parser;
    }

    /**
     * This method does NOT immediately wrap to getParser( int contentTypeId ) it will first fetch
     * the content type instead to get the contentTypeId of the required content type. This isn't
     * really bad, because this method does count on the PeerCachingMechanism 
     * @param contentTypeName
     * @return A adequate Parser for the supplied content type
     * @throws UnsupportedContentTypeException
     * @throws TorqueException
     */
    public static Parser getParser( String contentTypeName ) throws UnsupportedContentTypeException, TorqueException
    {                
        //first try getting a adequate Parser from cache
        Parser parser = (Parser)parserCache.get(contentTypeName);
        
        //first call for the supplied content type?
        if(parser == null)
        {    
            ContentType cType = null;
            Criteria crit = new Criteria();
            crit.add( ContentTypePeer.CONTENT_TYPE_NAME, contentTypeName);
    
            //try fetching the content type
            List results = ContentTypePeer.doSelect( crit);
    
            if ( results != null && !results.isEmpty() )
            {
                cType = (ContentType) results.get( 0);
                parser = getParser(cType.getContentTypeId());
                //add the parser another time to the cache, this time with the name as key
                parserCache.put(contentTypeName, parser);
            }
            else
            {
                throw new UnsupportedContentTypeException("Illegal content type name supplied");
            }            
        }

        return parser;
    }

    /**
     * This method wraps to getParser( int contentTypeId )
     * @param contentType
     * @return A adequate Parser for the supplied content type
     * @throws UnsupportedContentTypeException
     * @throws TorqueException
     */
    public static Parser getParser( ContentType contentType ) throws UnsupportedContentTypeException, TorqueException
    {
        return getParser( contentType.getContentTypeId());
    }

    /**
     * This method wraps to getParser( int contentTypeId ) 
     * @param content
     * @return A adequate Parser for the supplied content type
     * @throws UnsupportedContentTypeException
     * @throws TorqueException
     */
    public static Parser getParser( Content content ) throws UnsupportedContentTypeException, TorqueException
    {
        return getParser( content.getContentTypeId());
    }
}
