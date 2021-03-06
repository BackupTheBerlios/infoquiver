/*
 * Created on 13.07.2004
 */
package net.sf.iquiver.metaformat.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.netseeker.util.ArrayUtil;
import de.netseeker.util.StringUtil;
import de.netseeker.util.mime.ContentTypeFileTypeMap;
/**
 * @author netseeker aka Michael Manske
 */
public class ContentTypeFactory
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( ContentTypeFactory.class );

    public static final String CT_TEXT_PLAIN = "text/plain";
    public static final String CT_TEXT_HTML = "text/html";
    public static final String CT_TEXT_XML = "text/xml";
    public static final String CT_APPLICATION_XML = "application/xml";
    public static final String CT_APPLICATION_ATOM_XML = "application/atom+xml";
    public static final String CT_APPLICATION_RSS_XML = "application/rss+xml";
    public static final String CT_APPLICATION_OPML_XML = "application/opml+xml";
    public static final String CT_TEXT_TAB_SEPARATED = "text/tab-separated-values";
    public static final String CT_APPLICATION_RTF = "application/rtf";
    public static final String CT_APPLICATION_PS = "application/postscript";
    public static final String CT_APPLICATION_PDF = "application/pdf";
    public static final String CT_APPLICATION_MSWORD = "application/msword";
    public static final String CT_APPLICATION_MSEXCEL = "application/vnd.msexcel";    
    public static final String CT_APPLICATION_XSHAR = "application/x-shar";
    public static final String CT_APPLICATION_XTROFF = "application/x-troff";
    public static final String CT_APPLICATION_XTROFF_MS = "application/x-troff-ms";
    public static final String CT_APPLICATION_XTEX = "application/x-tex";
    public static final String CT_APPLICATION_XLATEX = "application/x-latex";
    public static final String CT_MULTIPART_MIXED = "multipart/mixed";
    public static final String CT_APPLICATION_OCTET_STREAM = "application/octet-stream";
    public static final String CT_APPLICATION_ZIP = "application/zip";    

    private static String[] TEXT_CTS = new String[] { CT_TEXT_PLAIN, CT_TEXT_HTML, CT_TEXT_XML,
            CT_APPLICATION_XML, CT_APPLICATION_ATOM_XML, CT_APPLICATION_RSS_XML, CT_APPLICATION_OPML_XML,
            CT_TEXT_TAB_SEPARATED, CT_APPLICATION_RTF, CT_APPLICATION_PS, CT_APPLICATION_XSHAR, CT_APPLICATION_XTROFF,
            CT_APPLICATION_XTROFF_MS, CT_APPLICATION_XTEX, CT_APPLICATION_XLATEX, CT_APPLICATION_MSWORD, CT_APPLICATION_MSEXCEL };

    private static final String[] NOT_SUPPORTET_CTS = new String[]{};
    
    /**
     * Tries to resolve the content type by the file extension
     * 
     * @param filename
     * @return the recognized content type if the file extension is known, otherwise application/octet-stream
     */
    public static String getContentTypeForFile( String filename )
    {
        String cType = ContentTypeFileTypeMap.getInstance().getContentType( filename );

        if (logger.isDebugEnabled())
        {
            if (cType != null)
            {
                logger.debug( "Recognized content Type for file " + filename + " is " + cType );
            }
            else
            {
                logger.debug( "No recognized content type for file " + filename + " found." );
            }
        }

        return StringUtil.defaultIfNull( cType, CT_APPLICATION_OCTET_STREAM );
    }

    /**
     * @param contentType
     * @return
     */
    public static boolean isTextBasedContentType( String contentType )
    {
        return ArrayUtil.contains( TEXT_CTS, contentType );
    }

    /**
     * @param contentType
     * @return
     */
    public static boolean isBinaryBasedContentType( String contentType )
    {
        return !ArrayUtil.contains( TEXT_CTS, contentType );
    }

    /**
     * @param contentType
     * @return
     */
    public static boolean isSupportedContentType( String contentType )
    {
        return !ArrayUtil.contains( NOT_SUPPORTET_CTS, contentType );
    }

    /**
     * @param contentType
     * @return
     */
    public static String[] getFileTypes( String contentType )
    {
        return ContentTypeFileTypeMap.getInstance().getFileTypes( contentType );
    }
    
    /**
     * @param contentType
     * @return
     */
    public static String getFirstFileType( String contentType )
    {
        return ContentTypeFileTypeMap.getInstance().getFirstFileType( contentType );
    }
    
    /**
     * Returns all known text based content types
     * @return
     */
    public static String[] getTextBasedContentTypes()
    {
        return TEXT_CTS;
    }
    
    /**
     * Use this method to add more known text based content types
     * @param contentType
     */
    public static synchronized void addTextBasedContentType( String contentType )
    {
        if( !ArrayUtil.contains( TEXT_CTS, contentType ) )
        {
            String[] array = new String[ TEXT_CTS.length + 1 ];
            System.arraycopy( TEXT_CTS, 0, array, 0, TEXT_CTS.length );
            array[ TEXT_CTS.length ] = contentType;
        }
    }
}