/*
 * Created on 10.03.2004
 *
 */
package net.sf.iquiver.metaformat;

import java.io.Serializable;
import java.util.List;

/**
 * @author netseeker aka Michael Manske
 */
public interface Branch extends Serializable
{
    public List getElements();
    public void setElements(List elements);
    public List getElements(String name);
    public void setElements(String name, List elements);
    public Element addElement(Element element);
    public void removeAllElements();    
}
