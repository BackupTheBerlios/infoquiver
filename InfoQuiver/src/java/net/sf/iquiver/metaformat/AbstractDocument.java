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

import net.sf.iquiver.parser.UnsupportedContentTypeException;

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
    private String _fileName;
    private float _score;
    private boolean _isRemoved;

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
     * @see net.sf.iquiver.metaformat.Document#getFileName()
     */
    public String getFileName()
    {
        return this._fileName;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#setFileName(java.lang.String)
     */
    public void setFileName( String filename )
    {
        this._fileName = filename;
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

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#getScore()
     */
    public float getScore()
    {
        return this._score;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#setScore(float)
     */
    public void setScore( float score )
    {
        this._score = score;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#isRemoved()
     */
    public boolean isRemoved()
    {
        return _isRemoved;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.metaformat.Document#setRemoved(boolean)
     */
    public void setRemoved( boolean removed )
    {
        this._isRemoved = removed;
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
        _score = 0;
        _isRemoved = false;
    }

    /**
     * copies the member values from one document to another if a particular member is not set
     * in the target document 
     * @param source the Document to read the values from
     * @param result the Document to fill with values from <code>source</code>
     */
    public static synchronized void fillMissingContentValues( Document toRead, Document toFill )
    {
        if (toFill.getAuthor() == null && toRead.getAuthor() != null)
        {
            toFill.setAuthor( toRead.getAuthor() );
        }
        if (toFill.getContentTypeStr() == null && toRead.getContentTypeStr() != null)
        {
            try
            {
                toFill.setContentTypeStr( toRead.getContentTypeStr() );
            }
            catch ( UnsupportedContentTypeException e )
            {
                //do nothing
            }
        }
        if (toFill.getDateOfCreation() == null && toRead.getDateOfCreation() != null)
        {
            toFill.setDateOfCreation( toRead.getDateOfCreation() );
        }
        if (toFill.getDateOfLastModification() == null && toRead.getDateOfLastModification() != null)
        {
            toFill.setDateOfLastModification( toRead.getDateOfLastModification() );
        }
        /*
        if (toFill.getEncoding() == null && toRead.getEncoding() != null)
        {
            toFill..encoding = toRead.getEncoding();
        }
        */
        if (toFill.getFileName() == null && toRead.getFileName() != null)
        {
            toFill.setFileName( toRead.getFileName() );
        }
        if (toFill.getInfoURL() == null && toRead.getInfoURL() != null)
        {
            toFill.setInfoURL( toRead.getInfoURL() );
        }
        if (toFill.getKeywords() == null && toRead.getKeywords() != null)
        {
            toFill.setKeywords( toRead.getKeywords() );
        }
        if (toFill.getLocale() == null && toRead.getLocale() != null)
        {
            toFill.setLocale( toRead.getLocale() );
        }
        if (toFill.getName() == null && toRead.getName() != null)
        {
            toFill.setName( toRead.getName() );
        }
        if (toFill.getShortDescription() == null && toRead.getShortDescription() != null)
        {
            toFill.setShortDescription( toRead.getShortDescription() );
        }
        if (toFill.getTitle() == null && toRead.getTitle() != null)
        {
            toFill.setTitle( toRead.getTitle() );
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#clear()
     */
    public abstract void clear();
}