/*
 * Created on 12.03.2004
 *
 */
package net.sf.iquiver.transport.impl;

import java.util.List;

import net.sf.iquiver.om.ContentSource;
import net.sf.iquiver.om.Transport;
import net.sf.iquiver.transport.Fetcher;

/**
 * @author netseeker aka Michael Manske
 */
public class HTTPTransport implements Fetcher
{
    private ContentSource fetchLocation;
    
    /* (non-Javadoc)
     * @see net.sf.iquiver.transport.Fetcher#setFetchLocation(net.sf.iquiver.om.ContentSource)
     */
    public void setFetchLocation( ContentSource source )
    {
        this.fetchLocation = source;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.transport.Fetcher#fetch()
     */
    public List fetch()
    {           
        return null;
    }

}
