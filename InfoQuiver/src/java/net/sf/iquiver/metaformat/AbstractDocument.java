/*
 * Created on 10.03.2004
 *
 */
package net.sf.iquiver.metaformat;

import java.net.URL;
import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @author netseeker aka Michael Manske
 */
public abstract class AbstractDocument implements Document
{
    private String _name;
    private String author;
    private String title;
    private Date dateOfCreation;
    private Date dateOfLastModification;
    private String shortDescription;
    private String keywords;
    private URL infoURL;
    private Locale locale;
    private String encoding;
    private String contentTypeStr;
    private String _uid;
    private List _children;

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#getName()
     */
    public String getName()
    {
        return this._name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#setName(java.lang.String)
     */
    public void setName( String name )
    {
        this._name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#getAuthor()
     */
    public String getAuthor()
    {
        return this.author;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#setAuthor(java.lang.String)
     */
    public void setAuthor( String author )
    {
        this.author = author;

    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#getTitle()
     */
    public String getTitle()
    {
        return this.title;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#setTitle(java.lang.String)
     */
    public void setTitle( String title )
    {
        this.title = title;

    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#getDateOfCreation()
     */
    public Date getDateOfCreation()
    {
        return this.dateOfCreation;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#setDateOfCreation(java.util.Date)
     */
    public void setDateOfCreation( Date date )
    {
        this.dateOfCreation = date;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#getDateOfLastModification()
     */
    public Date getDateOfLastModification()
    {
        return this.dateOfLastModification;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#setDateOfLastModification(java.util.Date)
     */
    public void setDateOfLastModification( Date date )
    {
        this.dateOfLastModification = date;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#getShortDescription()
     */
    public String getShortDescription()
    {
        return this.shortDescription;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#setShortDescription(java.lang.String)
     */
    public void setShortDescription( String desc )
    {
        this.shortDescription = desc;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#getInfoURL()
     */
    public URL getInfoURL()
    {
        return this.infoURL;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#setInfoURL(java.net.URL)
     */
    public void setInfoURL( URL url )
    {
        this.infoURL = url;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#getLocale()
     */
    public Locale getLocale()
    {
        return this.locale;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#setLocale(java.util.Locale)
     */
    public void setLocale( Locale locale )
    {
        this.locale = locale;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#getEncoding()
     */
    public String getEncoding()
    {
        return this.encoding;
    }

    /**
     * @param encoding
     */
    public void setEncoding( String encoding )
    {
        this.encoding = encoding;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#getContentTypeStr()
     */
    public String getContentTypeStr()
    {
        return this.contentTypeStr;
    }

    /**
     * @return Returns the keywords.
     */
    public String getKeywords()
    {
        return this.keywords;
    }

    /**
     * @param keywords The keywords to set.
     */
    public void setKeywords( String keywords )
    {
        this.keywords = keywords;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#setContentTypeStr(java.lang.String)
     */
    public void setContentTypeStr( String contentTypeStr )
    {
        this.contentTypeStr = contentTypeStr;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#getUID()
     */
    public String getUID()
    {
        if (this._uid == null)
        {
            this._uid = new UID().toString();
        }

        return _uid;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#setUID(long)
     */
    public void setUID( String id )
    {
        this._uid = id;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#addChild(net.sf.iquiver.metaformat.Document)
     */
    public void addChild( Document doc )
    {
        if (this._children == null)
        {
            this._children = new ArrayList();
        }

        this._children.add( doc );
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#getChildren()
     */
    public List getChildren()
    {
        return this._children;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#hasChildren()
     */
    public boolean hasChildren()
    {
        return (this._children != null && !this._children.isEmpty());
    }

    /**
     * 
     */
    protected void clearDocumentMembers()
    {
        _name = null;
        author = null;
        title = null;
        dateOfCreation = new Date();
        dateOfLastModification = dateOfCreation;
        shortDescription = null;
        infoURL = null;
        locale = Locale.getDefault();
        encoding = null;
        contentTypeStr = null;
        _uid = null;
        _children = null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#clear()
     */
    public abstract void clear();
}