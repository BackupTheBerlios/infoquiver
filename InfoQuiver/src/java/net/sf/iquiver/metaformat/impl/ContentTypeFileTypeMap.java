/*
 * Created on 15.07.2004
 */
package net.sf.iquiver.metaformat.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.activation.MimetypesFileTypeMap;

import net.sf.iquiver.configuration.impl.DefaultProperiesConfiguration;

import org.apache.commons.io.IOUtils;

import de.netseeker.util.FileUtil;
import de.netseeker.util.StringUtil;

/**
 * @author netseeker aka Michael Manske
 */
public class ContentTypeFileTypeMap extends MimetypesFileTypeMap
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog(ContentTypeFileTypeMap.class);
    
    
    private Map _mimeMap = new HashMap();
    private Map _extMap = new HashMap();

    /**
     * Creates a new instance of ContentTypeFileTypeMap prefilled with the mime types in
     * net.sf.iquiver.metaformat.mime.types
     */
    public ContentTypeFileTypeMap()
    {
        this( ContentTypeFileTypeMap.class.getResourceAsStream( "mime.types" ) );
    }

    /**
     * Creates a new instance of ContentTypeFileTypeMap prefilled with the mime types found in the given InputStream
     * @param in
     */
    public ContentTypeFileTypeMap(InputStream in)
    {
        super();
        DefaultProperiesConfiguration contents = new DefaultProperiesConfiguration();
        try
        {
            contents.load( in, "UTF8" );
            for (Iterator it = contents.getKeys(); it.hasNext();)
            {
                String key = (String) it.next();
                String[] values = contents.getStringArray( key );
                _mimeMap.put( key, values );

                for (int i = 0; i < values.length; i++)
                {
                    _extMap.put( values[i], key );
                }
            }
            
        }
        catch ( IOException e )
        {
            logger.error( "An IO error occured while accessing the given input stream!", e);
        }
        finally
        {
            if( in != null)
            {
                IOUtils.closeQuietly( in );
            }
        }        
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.activation.FileTypeMap#getContentType(java.io.File)
     */
    public String getContentType( File file )
    {
        String ext = FileUtil.getFileType( file ).toLowerCase();
        return StringUtil.defaultIfNull( (String) this._mimeMap.get( ext ), super.getContentType( file ) );
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.activation.FileTypeMap#getContentType(java.lang.String)
     */
    public synchronized String getContentType( String file )
    {
        String ext = FileUtil.getFileType( file ).toLowerCase();
        return StringUtil.defaultIfNull( (String) this._mimeMap.get( ext ), super.getContentType( file ) );
    }

    /**
     * Returns all known file types for a given content type (mime type)
     * @param contentType
     * @return
     */
    public String[] getFileTypes( String contentType )
    {
        return (String[]) this._mimeMap.get( contentType );
    }

    /**
     * Returns the first file type found in the known file types for a given content type (mime type) 
     * @param contentType
     * @return the first file type found or null if no file types are known for the given content type
     */
    public String getFirstFileType( String contentType )
    {
        String[] exts = (String[]) this._mimeMap.get( contentType );
        
        if( exts.length > 0)
        {
            return exts[0];
        }
        
        return null;
    }
}