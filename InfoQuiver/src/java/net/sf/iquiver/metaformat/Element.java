/*
 * Created on 09.03.2004
 *
 */
package net.sf.iquiver.metaformat;

import java.util.List;
import java.util.Map;

/**
 * @author netseeker aka Michael Manske
 */
public interface Element extends Document
{
    public String[] getAttributeNames();
    public Map getAttributes();
    public void setAttributes(Map attributes);
    public String getAttributeValue(String name);
    public void setAttributeValue(String name, String value);
    public void removeAllAttributes();
}
