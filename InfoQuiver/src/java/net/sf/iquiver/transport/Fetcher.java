/*
 * Created on 06.03.2004
 *
 */
package net.sf.iquiver.transport;

import java.util.List;

import net.sf.iquiver.om.ContentSource;

/**
 * @author netseeker aka Michael Manske
 */
public interface Fetcher
{
    /**
     * @param source
     */
    public void setFetchLocation(ContentSource source) throws TransportConfigurationException;
    
    /**
     * Returns the last configured fetch location or null if no fetch location was configured
     * @return
     */
    public ContentSource getFetchLocation();
    
    /**
     * @return
     */
    public List fetch();
}
