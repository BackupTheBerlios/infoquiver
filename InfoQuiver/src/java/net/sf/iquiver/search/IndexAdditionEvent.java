/*********************************************************************
 * IndexAdditionEvent.java
 * created on 06.12.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/search/IndexAdditionEvent.java,v $
 * $Date: 2004/12/11 23:20:54 $
 * $Revision: 1.1 $
 *********************************************************************/

package net.sf.iquiver.search;

import java.util.EventObject;

import net.sf.iquiver.metaformat.Document;

/**
 * @author netseeker aka Michael Manske
 */
public class IndexAdditionEvent extends EventObject
{
    private Document document;
    private long timeOfAddition;
    private String index;

    /**
     * @param source
     * @param doc
     */
    public IndexAdditionEvent(Object source, Document doc, String index)
    {
        super( source );
        this.timeOfAddition = System.currentTimeMillis();
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
    public long getTimeOfAddition()
    {
        return this.timeOfAddition;
    }

    public String getIndex()
    {
        return this.index;
    }
}