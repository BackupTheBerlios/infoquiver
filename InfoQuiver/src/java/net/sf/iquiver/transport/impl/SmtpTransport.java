/*********************************************************************
 * SmtpTransport.java
 * created on 15.10.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/transport/impl/SmtpTransport.java,v $
 * $Date: 2004/11/26 22:50:17 $
 * $Revision: 1.3 $
 *********************************************************************/

package net.sf.iquiver.transport.impl;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.om.ContentSource;
import net.sf.iquiver.transport.Dispatcher;
import net.sf.iquiver.transport.TransportConfigurationException;
import net.sf.iquiver.transport.TransportException;
import net.sf.iquiver.util.mail.EMail;
import net.sf.iquiver.util.mail.SmtpClient;

import org.apache.torque.TorqueException;

import de.netseeker.util.mime.ContentTypeFileTypeMap;

/**
 * @author netseeker aka Michael Manske
 */
public class SmtpTransport implements Dispatcher
{
    public static final String ATTRIBUTE_SMTP_SERVER = "Server";
    public static final String ATTRIBUTE_SMTP_PORT = "Port";
    public static final String ATTRIBUTE_SMTP_LOGIN = "Login";
    public static final String ATTRIBUTE_SMTP_PASSWORD = "Password";
    public static final String ATTRIBUTE_SMTP_FROM = "From";
    public static final String ATTRIBUTE_SMTP_TO = "To";
    public static final String ATTRIBUTE_SMTP_SUBJECT = "Subject";
    public static final String ATTRIBUTE_SMTP_TIMEOUT = "Timeout";

    private ContentSource _dispatchLocation;
    private Map _dispatchAttributes;

    /* (non-Javadoc)
     * @see net.sf.iquiver.transport.Dispatcher#setDispatchLocation(net.sf.iquiver.om.ContentSource)
     */
    public void setDispatchLocation( ContentSource location ) throws TransportConfigurationException
    {
        this._dispatchLocation = location;
        try
        {
            this._dispatchAttributes = location.getAttributesAsNamedMap();
        }
        catch ( TorqueException e )
        {
            throw new TransportConfigurationException( e );
        }
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.transport.Dispatcher#getDispatchLocation()
     */
    public ContentSource getDispatchLocation()
    {
        return this._dispatchLocation;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.transport.Dispatcher#dispatch(java.util.List)
     */
    public long[] dispatch( List docs ) throws TransportException
    {
        SmtpClient client = null;
        if (!_dispatchAttributes.containsKey( ATTRIBUTE_SMTP_PORT ))
        {
            client = new SmtpClient( (String) _dispatchAttributes.get( ATTRIBUTE_SMTP_SERVER ),
                    (String) _dispatchAttributes.get( ATTRIBUTE_SMTP_LOGIN ), (String) _dispatchAttributes
                            .get( ATTRIBUTE_SMTP_PASSWORD ) );
        }
        else
        {
            Integer port = (Integer) _dispatchAttributes.get( ATTRIBUTE_SMTP_PORT );
            client = new SmtpClient( (String) _dispatchAttributes.get( ATTRIBUTE_SMTP_SERVER ),
                    (String) _dispatchAttributes.get( ATTRIBUTE_SMTP_LOGIN ), (String) _dispatchAttributes
                            .get( ATTRIBUTE_SMTP_PASSWORD ), port.intValue() );
        }

        String from = (String) _dispatchAttributes.get( ATTRIBUTE_SMTP_FROM );
        String[] to = ((String) _dispatchAttributes.get( ATTRIBUTE_SMTP_TO )).split( "," );
        String subject = (String) _dispatchAttributes.get( ATTRIBUTE_SMTP_SUBJECT );
        EMail mail = new EMail( from, to, subject );
        long[] size = new long[docs.size()];

        try
        {

            for (int i = 0; i < docs.size(); i++)
            {
                Document doc = (Document) docs.get( i );
                String fileName = doc.getFileName();
                if (fileName == null)
                {
                    fileName = doc.getUID();
                    if (doc.getContentTypeStr() != null)
                    {
                        String ext = ContentTypeFileTypeMap.getInstance().getFirstFileType( doc.getContentTypeStr() );
                        if (ext != null)
                        {
                            fileName += "." + ext;
                        }
                    }

                }

                size[i] = doc.getRawContent().length;
                mail.addAttachment( new ByteArrayInputStream( doc.getRawContent() ), fileName );
            }

            client.send( mail );
        }
        catch ( MessagingException e )
        {
            throw new TransportException( e );
        }

        return size;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.transport.Dispatcher#dispatch(net.sf.iquiver.metaformat.Document)
     */
    public long dispatch( Document doc ) throws TransportException
    {
        SmtpClient client = null;
        long sent = -1;

        if (!_dispatchAttributes.containsKey( ATTRIBUTE_SMTP_PORT ))
        {
            client = new SmtpClient( (String) _dispatchAttributes.get( ATTRIBUTE_SMTP_SERVER ),
                    (String) _dispatchAttributes.get( ATTRIBUTE_SMTP_LOGIN ), (String) _dispatchAttributes
                            .get( ATTRIBUTE_SMTP_PASSWORD ) );
        }
        else
        {
            Integer port = (Integer) _dispatchAttributes.get( ATTRIBUTE_SMTP_PORT );
            client = new SmtpClient( (String) _dispatchAttributes.get( ATTRIBUTE_SMTP_SERVER ),
                    (String) _dispatchAttributes.get( ATTRIBUTE_SMTP_LOGIN ), (String) _dispatchAttributes
                            .get( ATTRIBUTE_SMTP_PASSWORD ), port.intValue() );
        }

        String from = (String) _dispatchAttributes.get( ATTRIBUTE_SMTP_FROM );
        String[] to = ((String) _dispatchAttributes.get( ATTRIBUTE_SMTP_TO )).split( "," );
        String subject = (String) _dispatchAttributes.get( ATTRIBUTE_SMTP_SUBJECT );
        EMail mail = new EMail( from, to, subject );

        String fileName = doc.getFileName();
        if (fileName == null)
        {
            fileName = doc.getUID();
            if (doc.getContentTypeStr() != null)
            {
                String ext = ContentTypeFileTypeMap.getInstance().getFirstFileType( doc.getContentTypeStr() );
                if (ext != null)
                {
                    fileName += "." + ext;
                }
            }
        }

        try
        {
            mail.addAttachment( new BufferedInputStream( new ByteArrayInputStream( doc.getRawContent() ) ), fileName );
            sent = client.send( mail );
        }
        catch ( MessagingException e )
        {
            throw new TransportException( e );
        }

        return sent;
    }
}