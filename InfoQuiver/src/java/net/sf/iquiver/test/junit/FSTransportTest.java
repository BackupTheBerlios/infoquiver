/*
 * Created on 13.07.2004
 */
package net.sf.iquiver.test.junit;

import java.util.List;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.om.ContentSource;
import net.sf.iquiver.om.ContentSourcePeer;
import net.sf.iquiver.transport.TransportConfigurationException;
import net.sf.iquiver.transport.TransportException;
import net.sf.iquiver.transport.impl.FSTransport;

import org.apache.torque.TorqueException;

/**
 * @author netseeker aka Michael Manske
 */
public class FSTransportTest extends BaseIQuiverTestCase
{
    public void testFetch()
    {                
        try
        {
            ContentSource source = ContentSourcePeer.retrieveByPK(109);
            FSTransport transport = new FSTransport();
            
            transport.setFetchLocation(source);
            List list = transport.fetch();
            assertNotNull( list );
            assertFalse( list.isEmpty() );           
            Document doc = (Document)list.get(0);
            assertNotNull( doc.getRawContent() );
            
        }
        catch ( TorqueException e )
        {
            e.printStackTrace();
        }                                
        catch ( TransportConfigurationException e1 )
        {
            e1.printStackTrace();
        }
        catch ( TransportException e )
        {
            e.printStackTrace();
        }        
    }
}
