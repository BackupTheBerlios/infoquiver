/*
 * Created on 06.03.2004
 *
 */
package net.sf.iquiver.util;


/**
 * @author netseeker aka Michael Manske
 */
public abstract class StringUtil
{
    public static String defaultIfNullOrEmpty(String value, String def)
    {
        if(value == null || value.length() == 0)
        {
            return def;
        }
        
        return value;
    }
}
