/*********************************************************************
 * DocumentUtil.java
 * created on 24.10.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/metaformat/impl/DocumentUtil.java,v $
 * $Date: 2004/10/24 16:28:09 $
 * $Revision: 1.1 $
 *********************************************************************/

package net.sf.iquiver.metaformat.impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.parser.UnsupportedContentTypeException;

import org.apache.commons.httpclient.util.DateParseException;
import org.apache.commons.httpclient.util.DateParser;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;

/**
 * Utility methods dealing with net.sf.metaformat.Document
 * @author netseeker aka Michael Manske
 */
public class DocumentUtil
{
    /**
     * @param doc
     * @return
     */
    public static String documentToString( Document doc )
    {
        StringBuffer sb = new StringBuffer();
        sb.append( "name:\t" );
        appendIfNotNull( sb, doc.getName() );
        sb.append( "\n" );
        sb.append( "file name:\t" );
        appendIfNotNull( sb, doc.getFileName() );
        sb.append( "\n" );
        sb.append( "created:\t" );
        appendIfNotNull( sb, doc.getDateOfCreation() );
        sb.append( "\n" );
        sb.append( "modified:\t" );
        appendIfNotNull( sb, doc.getDateOfLastModification() );
        sb.append( "\n" );
        sb.append( "info url:\t" );
        appendIfNotNull( sb, doc.getInfoURL() );
        sb.append( "\n" );
        sb.append( "title:\t" );
        appendIfNotNull( sb, doc.getTitle() );
        sb.append( "\n" );
        sb.append( "keywords:\t" );
        appendIfNotNull( sb, doc.getKeywords() );
        sb.append( "\n" );
        sb.append( "description:\t" );
        appendIfNotNull( sb, doc.getShortDescription() );
        sb.append( "\n" );
        sb.append( "uid:\t" );
        appendIfNotNull( sb, doc.getUID() );
        sb.append( "\n" );
        sb.append( "encoding:\t" );
        appendIfNotNull( sb, doc.getEncoding() );
        sb.append( "\n" );
        sb.append( "locale:\t" );
        appendIfNotNull( sb, doc.getLocale() );
        sb.append( "\n" );
        sb.append( "content type:\t" );
        appendIfNotNull( sb, doc.getContentTypeStr() );
        sb.append( "\n" );
        sb.append( "score:\t" );
        appendIfNotNull( sb, new Float( doc.getScore() ) );

        return sb.toString();
    }

    /**
     * @param doc
     * @return
     */
    public static String documentToXmlString( Document doc )
    {
        StringBuffer sb = new StringBuffer();
        sb.append( "<Document>\n" );
        appendXmlIfNotNull( sb, "Name", doc.getName() );
        appendXmlIfNotNull( sb, "FileName", doc.getFileName() );
        appendXmlIfNotNull( sb, "Created", doc.getDateOfCreation() );
        appendXmlIfNotNull( sb, "Modified", doc.getDateOfLastModification() );
        appendXmlIfNotNull( sb, "InfoUrl", doc.getInfoURL() );
        appendXmlIfNotNull( sb, "Title", doc.getTitle() );
        appendXmlIfNotNull( sb, "Keywords", doc.getKeywords() );
        appendXmlIfNotNull( sb, "Description", doc.getShortDescription() );
        appendXmlIfNotNull( sb, "UID", doc.getUID() );
        appendXmlIfNotNull( sb, "Encoding", doc.getEncoding() );
        appendXmlIfNotNull( sb, "Locale", doc.getLocale() );
        appendXmlIfNotNull( sb, "ContentType", doc.getContentTypeStr() );
        appendXmlIfNotNull( sb, "Score", new Float( doc.getScore() ) );
        sb.append( "</Document>" );

        return sb.toString();
    }

    /**
     * @param xml
     * @return
     */
    public static Document xmlStringToDocument( String xml )
    {
        org.dom4j.Document dom4jdoc = null;
        try
        {
            dom4jdoc = DocumentHelper.parseText( xml );
        }
        catch ( DocumentException e )
        {
        }

        return dom4JToDocument( dom4jdoc );
    }

    /**
     * Converts a net.sf.iquiver.metaformat.document into an dom4j xml document
     * @param doc
     * @return
     */
    public static org.dom4j.Document documentToDom4J( Document doc )
    {
        org.dom4j.Document dom4jdoc = null;
        try
        {
            dom4jdoc = DocumentHelper.parseText( documentToXmlString( doc ) );
        }
        catch ( DocumentException e )
        {
        }

        return dom4jdoc;
    }

    /**
     * Converts a Dom4J document into a net.sf.iquiver.metaformat.document
     * @param doc
     * @return
     */
    public static Document dom4JToDocument( org.dom4j.Document doc )
    {
        Document iqDoc = null;
        Node node = doc.selectSingleNode( "//ContentType" );
        String contentType = (node != null) ? node.getText() : ContentTypeFactory.CT_TEXT_PLAIN;
        try
        {
            iqDoc = MetaFormatFactory.createDocumentForContentType( contentType );
        }
        catch ( UnsupportedContentTypeException e )
        {
            return null;
        }

        node = doc.selectSingleNode( "//Name" );
        if (node != null)
        {
            iqDoc.setName( node.getText() );
        }
        node = doc.selectSingleNode( "//FileName" );
        if (node != null)
        {
            iqDoc.setFileName( node.getText() );
        }
        node = doc.selectSingleNode( "//Created" );
        if (node != null)
        {
            try
            {
                iqDoc.setDateOfCreation( DateParser.parseDate( node.getText() ) );
            }
            catch ( DateParseException e1 )
            {
            }
        }
        node = doc.selectSingleNode( "//Modified" );
        if (node != null)
        {
            try
            {
                iqDoc.setDateOfLastModification( DateParser.parseDate( node.getText() ) );
            }
            catch ( DateParseException e1 )
            {
            }
        }
        node = doc.selectSingleNode( "//InfoUrl" );
        if (node != null)
        {
            try
            {
                iqDoc.setInfoURL( new URL( node.getText() ) );
            }
            catch ( MalformedURLException e1 )
            {
            }
        }
        node = doc.selectSingleNode( "//Title" );
        if (node != null)
        {
            iqDoc.setTitle( node.getText() );
        }
        node = doc.selectSingleNode( "//Keywords" );
        if (node != null)
        {
            iqDoc.setKeywords( node.getText() );
        }
        node = doc.selectSingleNode( "//Description" );
        if (node != null)
        {
            iqDoc.setShortDescription( node.getText() );
        }
        node = doc.selectSingleNode( "//UID" );
        if (node != null)
        {
            iqDoc.setUID( node.getText() );
        }
        node = doc.selectSingleNode( "//Locale" );
        if (node != null)
        {
            iqDoc.setLocale( new Locale( node.getText() ) );
        }
        node = doc.selectSingleNode( "//Score" );
        if (node != null)
        {
            iqDoc.setScore( Float.parseFloat( node.getText() ) );
        }

        return iqDoc;

    }

    private static void appendIfNotNull( StringBuffer sb, Object value )
    {
        if (value != null)
        {
            sb.append( value );
        }
    }

    private static void appendXmlIfNotNull( StringBuffer sb, String name, Object value )
    {
        sb.append( "<" );
        sb.append( name );
        if (value != null)
        {
            sb.append( ">" );
            sb.append( value );
            sb.append( "</" );
            sb.append( name );
            sb.append( ">" );
        }
        else
        {
            sb.append( "/>" );
        }

        sb.append( "\n" );
    }
}