/*********************************************************************
 * ServerStats.java
 * created on 03.12.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/ServerStats.java,v $
 * $Date: 2004/12/11 23:25:12 $
 * $Revision: 1.2 $
 *********************************************************************/

package net.sf.iquiver;

import net.sf.iquiver.event.EventProcessor;
import net.sf.iquiver.util.XmlSerializable;

/**
 * @author netseeker aka Michael Manske
 */
public class ServerStats implements XmlSerializable
{
    private EventProcessor _serviceListener = new ServiceStats();
    private EventProcessor _indexListener = new IndexStats();

    public EventProcessor getIndexListener()
    {
        return this._indexListener;
    }

    public EventProcessor getServiceListener()
    {
        return this._serviceListener;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.util.XmlSerializable#toXml()
     */
    public String toXml()
    {
        StringBuffer sb = new StringBuffer();
        sb.append( "<ServerStats>\n" );
        sb.append( _serviceListener.toXml() );
        sb.append( _indexListener.toXml() );
        sb.append( "</ServerStats>" );
        
        return sb.toString();
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.util.XmlSerializable#fromXml(java.lang.String)
     */
    public void fromXml( String xml )
    {
        //not implemented yet        
    }
    
    
}