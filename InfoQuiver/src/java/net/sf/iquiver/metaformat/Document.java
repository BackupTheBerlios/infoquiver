/*
 * Created on 09.03.2004
 *
 */
package net.sf.iquiver.metaformat;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import net.sf.iquiver.parser.UnsupportedContentTypeException;

/**
 * @author netseeker aka Michael Manske
 */
public interface Document extends Serializable
{
    /**
     * Default encoding used when creating text based document from byte arrays
     */
    public static final String DEFAULT_ENCODING = "UTF8";
    
    public String getName();
    public void setName(String name);
    public String getEncoding();
    public String getAuthor();
    public void setAuthor(String author);
    public String getTitle();
    public void setTitle(String title);
    public Date getDateOfCreation();
    public void setDateOfCreation(Date date);
    public Date getDateOfLastModification();
    public void setDateOfLastModification(Date date);
    public String getShortDescription();
    public void setShortDescription(String desc);
    public String getKeywords();
    public void setKeywords(String desc);    
    public URL getInfoURL();
    public void setInfoURL(URL url);
    public Locale getLocale();
    public void setLocale(Locale locale);
    public byte[] getRawContent();
    public void setRawContent( byte[] content ) throws UnsupportedEncodingException;
    public String getContentTypeStr();
    public void setContentTypeStr( String contentTypeStr ) throws UnsupportedContentTypeException;
    public String getUID();
    public void setUID( String uid );
    public boolean hasChildren();
    public List getChildren();
    public void addChild( Document doc );
    public String getFileName();
    public void setFileName( String fileName );
    public float getScore();
    public void setScore( float score );
    public void clear();
    public boolean isRemoved();
    public void setRemoved( boolean removed );
    
}
