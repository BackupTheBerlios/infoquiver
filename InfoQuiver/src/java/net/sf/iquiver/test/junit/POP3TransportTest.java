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
import net.sf.iquiver.transport.impl.POP3Transport;

import org.apache.torque.TorqueException;

/**
 * @author netseeker aka Michael Manske
 */
public class POP3TransportTest extends BaseIQuiverTestCase
{
    public void testFetch()
    {
        ContentSource source = null;
        
        try
        {
            source = ContentSourcePeer.retrieveByPK(103);
        }
        catch ( TorqueException e )
        {
            e.printStackTrace();
        }
        
        POP3Transport transport = new POP3Transport();        
        try
        {
            transport.setFetchLocation(source);
            List list = transport.fetch();
            assertNotNull( list );
            assertFalse( list.isEmpty() );           
            Document doc = (Document)list.get(0);
            assertNotNull( doc.getRawContent() );                                         
        }
        catch ( TransportConfigurationException e1 )
        {
            e1.printStackTrace();
        }
    }
}
