/*********************************************************************
 * EMail.java
 * created on 16.10.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/util/mail/EMail.java,v $
 * $Date: 2004/10/16 19:26:42 $
 * $Revision: 1.1 $
 *********************************************************************/

package net.sf.iquiver.util.mail;

import java.io.InputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import de.netseeker.util.mime.ContentTypeFileTypeMap;

/**
 * @author netseeker aka Michael Manske
 */
public class EMail
{
    private String sender;
    private String[] receipients;
    private String[] cc;
    private String subject;
    private Multipart mp = new MimeMultipart();

    /**
     * @param from
     * @param to
     * @param subject
     */
    public EMail(String from, String to, String subject)
    {
        sender = from;
        receipients = new String[] { to };
        this.subject = subject;
    }

    /**
     * @param from
     * @param to
     * @param subject
     */
    public EMail(String from, String[] to, String subject)
    {
        sender = from;
        receipients = to;
        this.subject = subject;
    }

    /**
     * @param from
     * @param to
     * @param cc
     * @param subject
     */
    public EMail(String from, String[] to, String[] cc, String subject)
    {
        this( from, to, subject );
        this.cc = cc;
    }

    /**
     * @param content
     */
    public void addContent( String content )
    {
        MimeBodyPart mbp = new MimeBodyPart();
        try
        {
            mbp.setText( content );
            mp.addBodyPart( mbp );
        }
        catch ( MessagingException e )
        {
            e.printStackTrace();
        }
    }

    /**
     * @param in
     * @param fileName
     */
    public void addAttachment( InputStream in, String fileName )
    {
        MimeBodyPart mbp = new MimeBodyPart();
        ContentTypeFileTypeMap ctfm = ContentTypeFileTypeMap.getInstance();

        try
        {
            String contentType = ctfm.getContentTypeFor( fileName );
            mbp.setDataHandler( new DataHandler( new InputStreamDataSource( in, contentType ) ) );
            mbp.setFileName( fileName );
            mp.addBodyPart( mbp );
        }
        catch ( MessagingException e )
        {
            e.printStackTrace();
        }
    }

    /**
     * @param filePath
     */
    public void addAttachment( String filePath )
    {
        MimeBodyPart mbp = new MimeBodyPart();
        try
        {
            FileDataSource fds = new FileDataSource( filePath );
            mbp.setDataHandler( new DataHandler( fds ) );
            mbp.setFileName( fds.getFile().getName() );
            mp.addBodyPart( mbp );
        }
        catch ( MessagingException e )
        {
            e.printStackTrace();
        }
    }

    /**
     * @return
     */
    public Multipart getParts()
    {
        return this.mp;
    }

    public String[] getCc()
    {
        return this.cc;
    }

    public void setCc( String[] cc )
    {
        this.cc = cc;
    }

    public String[] getReceipients()
    {
        return this.receipients;
    }

    public void setReceipients( String[] receipients )
    {
        this.receipients = receipients;
    }

    public String getSender()
    {
        return this.sender;
    }

    public void setSender( String sender )
    {
        this.sender = sender;
    }

    public String getSubject()
    {
        return this.subject;
    }

    public void setSubject( String subject )
    {
        this.subject = subject;
    }
}