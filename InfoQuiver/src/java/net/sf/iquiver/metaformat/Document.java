/*
 * Created on 09.03.2004
 *
 */
package net.sf.iquiver.metaformat;

import java.net.URL;
import java.util.Date;
import java.util.Locale;

/**
 * @author netseeker aka Michael Manske
 */
public interface Document
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
    public URL getInfoURL();
    public void setInfoURL(URL url);
    public Locale getLocale();
    public void setLocale(Locale locale);
    public byte[] getRawContent();
    public void clear();
}
