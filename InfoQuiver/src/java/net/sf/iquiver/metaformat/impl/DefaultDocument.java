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
