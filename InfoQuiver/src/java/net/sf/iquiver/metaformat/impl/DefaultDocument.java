/*
 * Created on 10.03.2004
 *
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
    private static final Log logger = LogFactory.getLog(DefaultDocument.class);
    private byte[] rawContent;
    
    public DefaultDocument()
    {        
    }
    
    public DefaultDocument(byte[] rawContent, String encoding) throws UnsupportedEncodingException
    {
        this(new String(rawContent, encoding), encoding);
    }
    
    public DefaultDocument(String rawContent, String encoding)
    {        
        try
        {
            this.rawContent = rawContent.getBytes(Document.DEFAULT_ENCODING);
            setEncoding(Document.DEFAULT_ENCODING);
        }
        catch ( UnsupportedEncodingException e )
        {
            logger.error("Unable to convert string to UTF8", e);
            this.rawContent = rawContent.getBytes();
            setEncoding(encoding);
        }
    }
    
    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#getRawContent()
     */
    public byte[] getRawContent()
    {
        return this.rawContent;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#clear()
     */
    public void clear()
    {
        super.clearDocumentMembers();
        this.rawContent = null;
    }
}
