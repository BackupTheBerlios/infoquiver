/*
 * Created on 16.03.2004
 *
 */
package net.sf.iquiver.test.junit;

import java.util.List;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.om.ContentSource;
import net.sf.iquiver.om.ContentSourcePeer;
import net.sf.iquiver.transport.TransportConfigurationException;
import net.sf.iquiver.transport.impl.HTTPTransport;

import org.apache.torque.TorqueException;

/**
 * @author netseeker aka Michael Manske
 */
public class HTTPTransportTest extends BaseIQuiverTestCase
{

    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception
    {
        super.setUp();
    }
    
    public void testFetch()
    {
        ContentSource sourceHtml = null;
        ContentSource sourcePdf = null;
        
        try
        {
            sourceHtml = ContentSourcePeer.retrieveByPK(101);
            sourcePdf = ContentSourcePeer.retrieveByPK(102);
        }
        catch ( TorqueException e )
        {
            e.printStackTrace();
        }
        
        HTTPTransport transport = new HTTPTransport();        
        try
        {
            transport.setFetchLocation(sourceHtml);
            List list = transport.fetch();
            Document doc = (Document)list.get(0);            
            transport.setFetchLocation(sourcePdf);
            list = transport.fetch();
            doc = (Document)list.get(0);
        }
        catch ( TransportConfigurationException e1 )
        {
            e1.printStackTrace();
        }
    }

}
