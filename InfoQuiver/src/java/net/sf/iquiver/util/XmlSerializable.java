/*
 * Created on 08.07.2004
 */
package net.sf.iquiver.util;

import java.io.Serializable;

/**
 * @author netseeker aka Michael Manske
 */
public interface XmlSerializable extends Serializable
{
    /**
     * Common method to convert an object to a well formed xml string
     * @return the object in it's xml string representation
     */
    public String toXml();
    
    /**
     * @param xml an xml string representation of an object
     */
    public void fromXml(String xml);
}
