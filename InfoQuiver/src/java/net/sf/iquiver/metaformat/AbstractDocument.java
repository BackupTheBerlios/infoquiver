/*
 * Created on 10.03.2004
 *
 */
package net.sf.iquiver.metaformat;

import java.net.URL;
import java.util.Date;
import java.util.Locale;

/**
 * @author netseeker aka Michael Manske
 */
public abstract class AbstractDocument implements Document
{
    private String name;
    private String author;
    private String title;
    private Date dateOfCreation;
    private Date dateOfLastModification;
    private String shortDescription;
    private URL infoURL;
    private Locale locale; 
    private String encoding;
    
    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#getName()
     */
    public String getName()
    {
        return this.name;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#setName(java.lang.String)
     */
    public void setName( String name )
    {
        this.name = name;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#getAuthor()
     */
    public String getAuthor()
    {
        return this.getAuthor();
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#setAuthor(java.lang.String)
     */
    public void setAuthor( String author )
    {
        this.author = author;

    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#getTitle()
     */
    public String getTitle()
    {
        return this.title;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#setTitle(java.lang.String)
     */
    public void setTitle( String title )
    {
        this.title = title;

    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#getDateOfCreation()
     */
    public Date getDateOfCreation()
    {
        return this.dateOfCreation;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#setDateOfCreation(java.util.Date)
     */
    public void setDateOfCreation( Date date )
    {
        this.dateOfCreation = date;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#getDateOfLastModification()
     */
    public Date getDateOfLastModification()
    {
        return this.dateOfLastModification;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#setDateOfLastModification(java.util.Date)
     */
    public void setDateOfLastModification( Date date )
    {
        this.dateOfLastModification = date;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#getShortDescription()
     */
    public String getShortDescription()
    {
        return this.shortDescription;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#setShortDescription(java.lang.String)
     */
    public void setShortDescription( String desc )
    {
        this.shortDescription = desc;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#getInfoURL()
     */
    public URL getInfoURL()
    {
        return this.infoURL;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#setInfoURL(java.net.URL)
     */
    public void setInfoURL( URL url )
    {
        this.infoURL = url;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#getLocale()
     */
    public Locale getLocale()
    {
        return this.locale;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#setLocale(java.util.Locale)
     */
    public void setLocale( Locale locale )
    {
        this.locale = locale;
    }
    
    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#getEncoding()
     */
    public String getEncoding()
    {
        return this.encoding;
    }

    public void setEncoding(String encoding)
    {
        this.encoding = encoding;
    }
    
    
    protected void clearDocumentMembers()
    {
        name = null;
        author = null;
        title = null;
        dateOfCreation = new Date();
        dateOfLastModification = dateOfCreation;
        shortDescription = null;
        infoURL = null;
        locale = Locale.getDefault();   
        encoding = null;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#getRawContent()
     */
    public abstract byte[] getRawContent();

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#clear()
     */
    public abstract void clear();
}
