/*
 * Created on 05.03.2004
 *
 */
package net.sf.iquiver.util;

import java.util.regex.Pattern;

import org.apache.commons.lang.ArrayUtils;

/**
 * @author netseeker aka Michael Manske
 */
public class ArrayUtil extends ArrayUtils
{
    public static boolean containsMatchingRegExString(String[] array, String key)
    {
        for(int i = 0; i < array.length; i++)
        {
            Pattern pattern = Pattern.compile(array[i]);
            if(pattern.matcher(key).matches())
            {
                return true;
            }
        }
        
        return false;
    }    
}
