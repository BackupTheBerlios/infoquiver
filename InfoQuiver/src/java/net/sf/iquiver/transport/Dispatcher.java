/*
 * Created on 06.03.2004
 *
 */
package net.sf.iquiver.transport;

import java.util.List;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.om.ContentSource;

/**
 * @author netseeker aka Michael Manske
 */
public interface Dispatcher
{
    /**
     * @param location
     */
    public void setDispatchLocation(ContentSource location) throws TransportConfigurationException;
    
    /**
     * Returns the last configured dispatch location or null if no dispatch location was configured
     * @return
     */
    public ContentSource getDispatchLocation();
    
    /**
     * Dispatches a list of Documents to the previously supplied dispatch location
     * @param docs List of net.sf.metaformat.Document objects
     * @return Array with transfered bytes per document
     */
    public long[] dispatch(List docs) throws TransportException;
    
    /**
     * Dispatches a single Document to the previously supplied dispatch location
     * @param doc
     * @return count of tranfered bytes
     */
    public long dispatch(Document doc) throws TransportException; 
}
