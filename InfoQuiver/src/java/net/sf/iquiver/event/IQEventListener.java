/*********************************************************************
 * IQEventListener.java
 * created on 08.12.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/event/IQEventListener.java,v $
 * $Date: 2004/12/08 21:06:40 $
 * $Revision: 1.1 $
*********************************************************************/

package net.sf.iquiver.event;

import java.util.EventListener;
import java.util.EventObject;

/**
 * @author netseeker aka Michael Manske
 */
public interface IQEventListener extends EventListener
{
    public void fireEvent( EventObject evt );
}
