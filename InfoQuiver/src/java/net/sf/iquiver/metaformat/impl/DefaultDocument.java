/*
 * Created on 10.03.2004
 *
 */
package net.sf.iquiver.metaformat.impl;

import net.sf.iquiver.metaformat.AbstractDocument;

/**
 * @author netseeker aka Michael Manske
 */
public class DefaultDocument extends AbstractDocument
{    
    byte[] rawContent;    
    
    public DefaultDocument()
    {        
    }
    
    public DefaultDocument(byte[] rawContent)
    {
        this.rawContent = rawContent;
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

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#getEncoding()
     */
    public String getEncoding()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#setEncoding()
     */
    public void setEncoding()
    {
        // TODO Auto-generated method stub
        
    }
}
