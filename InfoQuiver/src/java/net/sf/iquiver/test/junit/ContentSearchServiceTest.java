/*********************************************************************
 * ContentSearchServiceTest.java
 * created on 19.07.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/test/junit/ContentSearchServiceTest.java,v $
 * $Date: 2004/07/18 23:29:57 $
 * $Revision: 1.1 $
*********************************************************************/

package net.sf.iquiver.test.junit;

import net.sf.iquiver.service.impl.ContentSearchService;

/**
 * @author netseeker aka Michael Manske
 */
public class ContentSearchServiceTest extends BaseIQuiverTestCase
{

    public void testDoStart()
    {
        ContentSearchService service = new ContentSearchService();
        service.start();
    }

}
