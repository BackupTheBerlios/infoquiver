/*
 * Created on 08.03.2004
 *
 */
package net.sf.iquiver.parser;

import net.sf.iquiver.om.ContentType;

/**
 * @author netseeker aka Michael Manske
 */
public class UnsupportedContentTypeException extends Exception
{

    /**
     * 
     */
    public UnsupportedContentTypeException()
    {
        super( "The supplied content type is not supported (yet)." );
    }

    /**
     * @param s
     */
    public UnsupportedContentTypeException( String s )
    {
        super( s );
    }

    /**
     * @param error
     */
    public UnsupportedContentTypeException( Throwable error )
    {
        super( error );
    }

    /**
     * @param s
     * @param error
     */
    public UnsupportedContentTypeException( String s, Throwable error )
    {
        super( s, error );
    }

    /**
     * @param s
     */
    public UnsupportedContentTypeException( ContentType type )
    {
        this( "The supplied content type \"" + type.getContentTypeName() + "\" is not supported (yet)." );
    }
    
}
