/*
 * Created on 09.03.2004
 *
 */
package net.sf.iquiver.metaformat;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import net.sf.iquiver.om.Content;

/**
 * @author netseeker aka Michael Manske
 */
public interface Document
{
    public String getName();
    public void setName(String name);
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
