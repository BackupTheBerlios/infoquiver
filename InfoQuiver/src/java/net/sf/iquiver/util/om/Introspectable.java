/*********************************************************************
 * Introspectable.java
 * created on 24.10.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/util/om/Attic/Introspectable.java,v $
 * $Date: 2004/10/24 12:20:41 $
 * $Revision: 1.1 $
*********************************************************************/

package net.sf.iquiver.util.om;

import java.util.List;

/**
 * @author netseeker aka Michael Manske
 */
public interface Introspectable
{    
    /**
     * Returns a List containing all identifiers of the contained member variables
     * @return a List containing all identifiers of the contained member variables
     */
    public List getFieldNames();
    
    /**
     * Returns the value of the member variable for the given variable name
     * @return the value of the member variable for the given variable name
     */
    public Object getByName(String name);
}
