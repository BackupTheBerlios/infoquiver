/*
 * Created on 10.03.2004
 */
package net.sf.iquiver.metaformat.impl;

import java.io.UnsupportedEncodingException;

import net.sf.iquiver.metaformat.AbstractDocument;
import net.sf.iquiver.metaformat.Document;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author netseeker aka Michael Manske
 */
public class DefaultDocument extends AbstractDocument
{
    private static final Log logger = LogFactory.getLog( DefaultDocument.class);
    private byte[] rawContent;

    /**
     * 
     */
    public DefaultDocument()
    {
    }
    
    /**
     * Constructs a new DefaultDocument and sets it's Content by calling
     * DefaultDocument( String rawContent ) with rawContent transformed into
     * a String with the supplied encoding.
     * @param rawContent
     * @param encoding
     * @throws UnsupportedEncodingException
     */
    public DefaultDocument( byte[] rawContent, String encoding ) throws UnsupportedEncodingException
    {
        //this( new String( rawContent, encoding ) );
        this.rawContent = rawContent;
        setEncoding( encoding );
    }

    /**
     * Constructs a new DefaultDocument and sets it's content. The content will
     * be converted to UTF8, if this fails an UnsupportedEncodingException will be thrown.
     * @param rawContent
     * @throws UnsupportedEncodingException
     */
    public DefaultDocument( String rawContent ) throws UnsupportedEncodingException
    {
        this.rawContent = rawContent.getBytes( Document.DEFAULT_ENCODING);
        setEncoding( Document.DEFAULT_ENCODING);
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#getRawContent()
     */
    public byte[] getRawContent()
    {
        return this.rawContent;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#clear()
     */
    public void clear()
    {
        super.clearDocumentMembers();
        this.rawContent = null;
    }
}
