/*
 * Created on 22.03.2004
 *
 */
package net.sf.iquiver.metaformat.impl;

import net.sf.iquiver.metaformat.AbstractDocument;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author netseeker aka Michael Manske
 */
public class BinaryDocument extends AbstractDocument
{
    private static final Log logger = LogFactory.getLog( BinaryDocument.class);
    private byte[] rawContent;
    
    
    public BinaryDocument(String contentType)
    {
        setContentTypeStr( contentType );
    }
    
    public BinaryDocument(String contentType, byte[] content)
    {
        setContentTypeStr( contentType );
        this.rawContent = content;
    }
    
    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#getRawContent()
     */
    public byte[] getRawContent()
    {
        return this.rawContent;
    }
    
    /**
     * @param content
     */
    public void setRawContent(byte[] content)
    {
        this.rawContent = content;
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
