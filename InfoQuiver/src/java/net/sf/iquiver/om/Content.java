package net.sf.iquiver.om;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.parser.UnsupportedContentTypeException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.TorqueException;
import org.apache.torque.om.Persistent;
import org.apache.torque.util.Criteria;

import com.workingdogs.village.DataSetException;
import com.workingdogs.village.Record;

/**
 * The skeleton for this class was autogenerated by Torque on: [Thu Mar 04 20:15:14 CET 2004] You should add additional
 * methods to this class to meet the application requirements. This class will only be generated as long as it does not
 * already exist in the output directory.
 */
public class Content extends net.sf.iquiver.om.BaseContent implements Persistent, Document
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( Content.class );

    private List _children;

    /**
     * Creates a new instance of Content
     */
    public Content()
    {
        super();
    }

    /**
     * Creates a new instance of Content out of an already existent instance of Document
     * 
     * @param doc the source document
     * @throws UnsupportedContentTypeException
     */
    public Content(Document doc) throws UnsupportedEncodingException, UnsupportedContentTypeException
    {
        this.setUID( doc.getUID() );
        this.setName( doc.getName() );
        this.setAuthor( doc.getAuthor() );
        this.setTitle( doc.getTitle() );
        this.setDateOfCreation( doc.getDateOfCreation() );
        this.setDateOfLastModification( doc.getDateOfLastModification() );
        this.setShortDescription( doc.getShortDescription() );
        this.setInfoURL( doc.getInfoURL() );
        this.setLocale( doc.getLocale() );
        this.setRawContent( doc.getRawContent() );
        this.setContentTypeStr( doc.getContentTypeStr() );
        this.setKeywords( doc.getKeywords() );
        if( doc.hasChildren() )
        {
            for( Iterator it = doc.getChildren().iterator(); it.hasNext();)
            {
                addChild( (Document)it.next() );
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#getName()
     */
    public String getName()
    {
        return getContentName();
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#setName(java.lang.String)
     */
    public void setName( String name )
    {
        setContentName( name );
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#getAuthor()
     */
    public String getAuthor()
    {
        return getContentAuthor();
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#setAuthor(java.lang.String)
     */
    public void setAuthor( String author )
    {
        setContentAuthor( author );
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#getTitle()
     */
    public String getTitle()
    {
        return getContentTitle();
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#setTitle(java.lang.String)
     */
    public void setTitle( String title )
    {
        setContentTitle( title );
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#getDateOfCreation()
     */
    public Date getDateOfCreation()
    {
        return getContentDateOfCreation();
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#setDateOfCreation(java.util.Date)
     */
    public void setDateOfCreation( Date date )
    {
        setContentDateOfCreation( date );
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#getDateOfLastModification()
     */
    public Date getDateOfLastModification()
    {
        return getContentDateOfLastModification();
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#setDateOfLastModification(java.util.Date)
     */
    public void setDateOfLastModification( Date date )
    {
        setContentDateOfLastModification( date );
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#getShortDescription()
     */
    public String getShortDescription()
    {
        return getContentShortDescription();
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#setShortDescription(java.lang.String)
     */
    public void setShortDescription( String desc )
    {
        setContentShortDescription( desc );
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#getInfoURL()
     */
    public URL getInfoURL()
    {
        URL url = null;

        if (getContentInfoUrl() != null)
        {
            try
            {
                url = new URL( getContentInfoUrl() );
            }
            catch ( MalformedURLException e )
            {
            }
        }

        return url;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#setInfoURL(java.net.URL)
     */
    public void setInfoURL( URL url )
    {
        if (url != null)
        {
            setContentInfoUrl( url.toString() );
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#getLocale()
     */
    public Locale getLocale()
    {
        Locale locale = null;
        if (getContentLocale() != null)
        {
            locale = new Locale( getContentLocale() );
        }

        return locale;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#setLocale(java.util.Locale)
     */
    public void setLocale( Locale locale )
    {
        if (locale != null)
        {
            setContentLocale( locale.toString() );
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#getRawContent()
     */
    public byte[] getRawContent()
    {
        if (getContentContent() != null)
        {
            return getContentContent();
        }

        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#clear()
     */
    public void clear()
    {
        this.setContentUid( null );
        this.setContentAuthor( null );
        this.setContentContent( null );
        this.setContentDateOfCreation( null );
        this.setContentDateOfLastModification( null );
        this.setContentInfoUrl( null );
        this.setContentLocale( null );
        this.setContentName( null );
        this.setContentShortDescription( null );
        this.setContentTitle( null );
        this.setContentKeywords( null );
        this._children = null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#getEncoding()
     */
    public String getEncoding()
    {
        return DEFAULT_ENCODING;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#getContentTypeStr()
     */
    public String getContentTypeStr()
    {
        String cTypeStr = null;
        try
        {
            ContentType type = this.getContentType();
            if (type != null)
            {
                cTypeStr = type.getContentTypeName();
            }
        }
        catch ( TorqueException e )
        {
        }

        return cTypeStr;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#setContentTypeStr(java.lang.String)
     */
    public void setContentTypeStr( String contentTypeStr ) throws UnsupportedContentTypeException
    {
        Criteria crit = new Criteria();
        crit.addSelectColumn( ContentTypePeer.CONTENT_TYPE_ID );
        crit.add( ContentTypePeer.CONTENT_TYPE_NAME, contentTypeStr );
        crit.setDistinct();

        try
        {
            List ids = ContentTypePeer.doSelectVillageRecords( crit );
            if (ids != null && !ids.isEmpty())
            {
                Record record = (Record) ids.get( 0 );
                this.setContentTypeId( record.getValue( 1 ).asInt() );
            }
            else
            {
                throw new UnsupportedContentTypeException( "Content type " + contentTypeStr + " is not supported!" );
            }
        }
        catch ( TorqueException e )
        {
            logger.error( "Error while fetching content types from database!", e );
        }
        catch ( DataSetException e )
        {
            logger.error( "Uknown error occured while setting content type id!", e );
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#setRawContent(byte[])
     */
    public void setRawContent( byte[] content ) throws UnsupportedEncodingException
    {
        this.setContentContent( content );
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#getKeywords()
     */
    public String getKeywords()
    {
        return this.getContentKeywords();
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#setKeywords(java.lang.String)
     */
    public void setKeywords( String keywords )
    {
        this.setContentKeywords( keywords );
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#getUID()
     */
    public String getUID()
    {
        return this.getContentUid();
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#setUID(java.lang.String)
     */
    public void setUID( String uid )
    {
        this.setContentUid( uid );
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#hasChildren()
     */
    public boolean hasChildren()
    {
        return (this._children != null && !this._children.isEmpty());
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#getChildren()
     */
    public List getChildren()
    {
        if (!hasChildren() && !isNew())
        {
            Criteria crit = new Criteria();
            crit.add( ContentPeer.CONTENT_PARENT_ID, this.getContentId() );

            try
            {
                this._children = ContentPeer.doSelect( crit );
            }
            catch ( TorqueException e )
            {
                logger.error( "Fetching child contents failed!", e );
            }
        }

        return this._children;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.metaformat.Document#addChild(net.sf.iquiver.metaformat.Document)
     */
    public void addChild( Document doc )
    {
        if (this._children == null)
        {
            this._children = new ArrayList();
        }
        
        Content content;
        try
        {
            content = new Content( doc );
            this._children.add( content );
        }
        catch ( Exception e )
        {
            logger.error( "Error occured while adding child document " + doc.getUID(), e );
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.torque.om.Persistent#save(java.sql.Connection)
     */
    public void save( Connection con ) throws TorqueException
    {
        super.save( con );
        
        if (hasChildren())
        {
            for (Iterator it = _children.iterator(); it.hasNext();)
            {
                Content content = (Content) it.next();
                content.setContentParentId( this.getContentId() );
                content.setContentSourceId( this.getContentSourceId() );
                content.save( con );
            }
        }
    }
}