/*
 * Created on 13.07.2004
 */
package net.sf.iquiver.metaformat;

import java.net.FileNameMap;
import java.net.URLConnection;

/**
 * @author netseeker aka Michael Manske
 */
public class ContentTypeFactory
{
    private static FileNameMap _fnMap = URLConnection.getFileNameMap();
    
    /**
     * Tries to resolve the content type by the file extension
     * @param filename
     * @return
     */
    public static String getContentTypeForFile( String filename )
    {
        return _fnMap.getContentTypeFor( filename );
    }
    
}
