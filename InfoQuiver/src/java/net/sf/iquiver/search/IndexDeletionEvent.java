/*********************************************************************
 * IndexDeletionEvent.java
 * created on 06.12.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/search/IndexDeletionEvent.java,v $
 * $Date: 2004/12/11 23:20:54 $
 * $Revision: 1.1 $
 *********************************************************************/

package net.sf.iquiver.search;

import java.util.EventObject;

import net.sf.iquiver.metaformat.Document;

/**
 * @author netseeker aka Michael Manske
 */
public class IndexDeletionEvent extends EventObject
{
    private Document document;
    private long timeOfDeletion;
    private String index;

    public IndexDeletionEvent(Object source, Document doc, String index)
    {
        super( source );
        this.timeOfDeletion = System.currentTimeMillis();
        this.document = doc;
        this.index = index;
    }

    /**
     * @return
     */
    public Document getDocument()
    {
        return this.document;
    }

    /**
     * @return
     */
    public long getTimeOfDeletion()
    {
        return this.timeOfDeletion;
    }

    public String getIndex()
    {
        return this.index;
    }
}