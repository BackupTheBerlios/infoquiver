/*
 * Created on 22.03.2004
 */
package net.sf.iquiver.metaformat.impl;

import java.io.UnsupportedEncodingException;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.parser.UnsupportedContentTypeException;
import de.netseeker.util.ArrayUtil;

/**
 * @author netseeker aka Michael Manske
 */
public class MetaFormatFactory
{
    public static final String    CT_TEXT_PLAIN            = "text/plain";
    public static final String    CT_TEXT_HTML             = "text/html";
    public static final String    CT_TEXT_TAB_SEPARATED    = "text/tab-separated-values";
    public static final String    CT_APPLICATION_RTF       = "application/rtf";
    public static final String    CT_APPLICATION_PS        = "application/postscript";
    public static final String    CT_APPLICATION_PDF       = "application/pdf";
    public static final String    CT_APPLICATION_XSHAR     = "application/x-shar";
    public static final String    CT_APPLICATION_XTROFF    = "application/x-troff";
    public static final String    CT_APPLICATION_XTROFF_MS = "application/x-troff-ms";
    public static final String    CT_APPLICATION_XTEX      = "application/x-tex";
    public static final String    CT_APPLICATION_XLATEX    = "application/x-latex";

    private static final String[] TEXT_CTS                 = new String[]{CT_TEXT_PLAIN, CT_TEXT_HTML,
            CT_TEXT_TAB_SEPARATED, CT_APPLICATION_RTF, CT_APPLICATION_PS, CT_APPLICATION_XSHAR, CT_APPLICATION_XTROFF,
            CT_APPLICATION_XTROFF_MS, CT_APPLICATION_XTEX, CT_APPLICATION_XLATEX};
    
    private static final String[] BINARY_CTS               = new String[] {CT_APPLICATION_PDF};

    
    /**
     * @param contentType
     * @return @throws UnsupportedContentTypeException
     */
    public static String getDocumentClassForContentType( String contentType ) throws UnsupportedContentTypeException
    {
        if ( isTextBasedContentType( contentType) )
        {
            return DefaultDocument.class.getName();
        }
        else if ( isBinaryBasedContentType( contentType ) )
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
        if ( isTextBasedContentType( contentType) )
        {
            return new DefaultDocument( contentType );
        }
        else if ( isBinaryBasedContentType( contentType ) )
        {
            return new BinaryDocument( contentType );
        }
        else
        {
            throw new UnsupportedContentTypeException( "The supplied content type \"" + contentType
                    + "\" is not supported yet." );
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
        if ( isTextBasedContentType( contentType) )
        {
            return new DefaultDocument( contentType, content, encoding );
        }
        else if ( isBinaryBasedContentType( contentType ) )
        {
            return new BinaryDocument(contentType, content);
        }
        else
        {
            throw new UnsupportedContentTypeException( "The supplied content type \"" + contentType
                    + "\" is not supported yet." );
        }                
    }
    
    public static Document createDocumentForContentType( String contentType, byte[] content ) throws UnsupportedEncodingException, UnsupportedContentTypeException
    {
        return createDocumentForContentType( contentType, content, Document.DEFAULT_ENCODING );
    }
    
    /**
     * @param contentType
     * @return
     */
    public static boolean isTextBasedContentType( String contentType )
    {
        return ArrayUtil.contains(TEXT_CTS, contentType);
    }

    /**
     * @param contentType
     * @return
     */
    public static boolean isBinaryBasedContentType( String contentType )
    {
        return ArrayUtil.contains(BINARY_CTS, contentType);
    }
        
    /**
     * @param contentType
     * @return
     */
    public static boolean isSupportedContentType( String contentType )
    {
        return isTextBasedContentType(contentType) || isBinaryBasedContentType(contentType);
    }
}
