/*
 * Created on 22.03.2004
 */
package net.sf.iquiver.metaformat.impl;

import java.io.UnsupportedEncodingException;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.parser.UnsupportedContentTypeException;

/**
 * @author netseeker aka Michael Manske
 */
public class MetaFormatFactory
{
    
    /**
     * @param contentType
     * @return @throws UnsupportedContentTypeException
     */
    public static String getDocumentClassForContentType( String contentType ) throws UnsupportedContentTypeException
    {
        if( !ContentTypeFactory.isSupportedContentType( contentType ))
        {
            throw new UnsupportedContentTypeException( "Content type " + contentType + " is not supported.");
        }
        
        if ( ContentTypeFactory.isTextBasedContentType( contentType) )
        {
            return DefaultDocument.class.getName();
        }
        else if ( ContentTypeFactory.isBinaryBasedContentType( contentType ) )
        {
            return BinaryDocument.class.getName();
        }
        else
        {
            throw new UnsupportedContentTypeException( "The supplied content type \"" + contentType
                    + "\" is not supported yet." );
        }
    }
    
    /**
     * @param contentType
     * @return
     * @throws UnsupportedContentTypeException
     */
    public static Document createDocumentForContentType( String contentType ) throws UnsupportedContentTypeException
    {
        if( !ContentTypeFactory.isSupportedContentType( contentType ))
        {
            throw new UnsupportedContentTypeException( "Content type " + contentType + " is not supported.");
        }

        if ( ContentTypeFactory.isTextBasedContentType( contentType) )
        {
            return new DefaultDocument( contentType );
        }
        else
        {
            return new BinaryDocument( contentType );
        }
    }
    
    /**
     * @param contentType
     * @param content
     * @return
     * @throws UnsupportedEncodingException
     * @throws UnsupportedContentTypeException
     */
    public static Document createDocumentForContentType( String contentType, byte[] content, String encoding ) throws UnsupportedEncodingException, UnsupportedContentTypeException
    {
        if( !ContentTypeFactory.isSupportedContentType( contentType ))
        {
            throw new UnsupportedContentTypeException( "Content type " + contentType + " is not supported.");
        }

        if ( ContentTypeFactory.isTextBasedContentType( contentType) )
        {
            return new DefaultDocument( contentType, content, encoding );
        }
        else
        {
            return new BinaryDocument(contentType, content);
        }
    }
    
    /**
     * @param contentType
     * @param content
     * @return
     * @throws UnsupportedEncodingException
     * @throws UnsupportedContentTypeException
     */
    public static Document createDocumentForContentType( String contentType, byte[] content ) throws UnsupportedEncodingException, UnsupportedContentTypeException
    {
        return createDocumentForContentType( contentType, content, Document.DEFAULT_ENCODING );
    }
    
}
