/*
 * Created on 10.07.2004
 */
package net.sf.iquiver.transport.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.metaformat.impl.MetaFormatFactory;
import net.sf.iquiver.om.ContentSource;
import net.sf.iquiver.transport.Fetcher;
import net.sf.iquiver.transport.TransportConfigurationException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.TorqueException;

/**
 * @author netseeker aka Michael Manske
 */
public class POP3Transport implements Fetcher
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( POP3Transport.class );

    public static final String ATTRIBUTE_POP_SERVER = "Server";
    public static final String ATTRIBUTE_POP_PORT = "Port";
    public static final String ATTRIBUTE_POP_LOGIN = "Login";
    public static final String ATTRIBUTE_POP_PASSWORD = "Password";
    public static final String ATTRIBUTE_POP_TIMEOUT = "Timeout";
    public static final String ATTRIBUTE_POP_DELETE_FROM_SERVER = "DeleteMessagesFromServer";

    private ContentSource _fetchLocation;
    private Map _attributes;
    private Map _authentAttributes;

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.transport.Fetcher#setFetchLocation(net.sf.iquiver.om.ContentSource)
     */
    public void setFetchLocation( ContentSource source ) throws TransportConfigurationException
    {
        try
        {
            this._fetchLocation = source;
            this._attributes = this._fetchLocation.getNonAuthentificationAttributesAsNamedMap();
            this._authentAttributes = this._fetchLocation.getAuthentificationAttributesAsNamedMap();
        }
        catch ( TorqueException e )
        {
            String msg = "Could not register transport attributes.";
            logger.error( msg, e );
            throw new TransportConfigurationException( msg, e );
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.transport.Fetcher#getFetchLocation()
     */
    public ContentSource getFetchLocation()
    {
        return this._fetchLocation;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.transport.Fetcher#fetch()
     */
    public List fetch()
    {
        List documents = new ArrayList();
        Properties props = new Properties();
        int timeout = ((Integer) ObjectUtils.defaultIfNull( _attributes.get( ATTRIBUTE_POP_TIMEOUT ), new Integer(
                60000 ) )).intValue();
        String host = (String) _attributes.get( ATTRIBUTE_POP_SERVER );
        String login = (String) _authentAttributes.get( ATTRIBUTE_POP_LOGIN );
        String password = (String) _authentAttributes.get( ATTRIBUTE_POP_PASSWORD );
        boolean remove = ((Boolean) ObjectUtils.defaultIfNull( _attributes.get( ATTRIBUTE_POP_DELETE_FROM_SERVER ),
                Boolean.FALSE )).booleanValue();

        try
        {
            // Connect to the POP3 server
            Session session = Session.getDefaultInstance( props, null );
            Store store = session.getStore( "pop3" );
            store.connect( host, login, password );
            Folder inbox = store.getFolder( "INBOX" );
            inbox.open( Folder.READ_ONLY );
            Message[] messages = inbox.getMessages();

            for (int i = 0; i < messages.length; i++)
            {
                try
                {
                    String contentType = messages[i].getContentType();
                    if( contentType.indexOf(";") != -1)
                    {
                        contentType = contentType.substring( 0, contentType.indexOf(";") );
                    }
                    Document doc = MetaFormatFactory.createDocumentForContentType( contentType );

                    doc.setRawContent( IOUtils.toByteArray( messages[i].getInputStream() ) );
                    doc.setAuthor( InternetAddress.toString( messages[i].getFrom() ) );
                    doc.setDateOfCreation( messages[i].getSentDate() );
                    doc.setDateOfLastModification( messages[i].getReceivedDate() );
                    doc.setShortDescription( messages[i].getSubject() );
                    doc.setTitle( doc.getShortDescription() );
                    documents.add( doc );
                }
                catch ( Exception e )
                {
                    logger.error( e );
                }
            }

            inbox.close( remove );
        }
        catch ( NoSuchProviderException e )
        {
            logger.error( e );
        }
        catch ( MessagingException e )
        {
            logger.error( e );
        }
        return documents;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.iquiver.transport.Fetcher#isParsingRequired()
     */
    public boolean isParsingRequired()
    {
        return false;
    }

}