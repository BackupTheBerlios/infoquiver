/*********************************************************************
 * EMail.java
 * created on 16.10.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/util/mail/EMail.java,v $
 * $Date: 2004/11/28 13:23:33 $
 * $Revision: 1.5 $
 *********************************************************************/

package net.sf.iquiver.util.mail;

import java.io.InputStream;
import java.rmi.server.UID;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import de.netseeker.util.mime.ContentTypeFileTypeMap;

/**
 * A simple wrapper around a javax.mail.Multipart object extended with fields for from, to, cc and subject
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
     * Adds an attachment while adding the contents of <var>in</var>.
     * using <var>targetName</var> as attachement name. 
     * @param in InputStream which contents will be used as attachment
     * @param targetName name of the body part (attachment)
     * @return the CID of the added attachment
     * @throws MessagingException
     */
    public String addAttachment( InputStream in, String targetName ) throws MessagingException
    {
        return addAttachment( in, targetName, false );
    }

    /**
     * Adds an attachment while adding the contents of <var>in</var>.
     * using <var>targetName</var> as attachement name.
     * @param in InputStream which contents will be used as attachment
     * @param targetName name of the body part (attachment)
     * @param useTargetNameAsCID if true <var>targetName</var> will be used as CID of the attachment
     * otherwise a new unique one will be generated
     * @return the CID of the added attachment
     * @throws MessagingException
     */
    public String addAttachment( InputStream in, String targetName, boolean useTargetNameAsCID ) throws MessagingException
    {
        MimeBodyPart mbp = new MimeBodyPart();
        ContentTypeFileTypeMap ctfm = ContentTypeFileTypeMap.getInstance();

        String contentType = ctfm.getContentTypeFor( targetName );
        mbp.setDataHandler( new DataHandler( new InputStreamDataSource( in, contentType ) ) );
        mbp.setFileName( targetName );
        
        if( useTargetNameAsCID )
        {
            mbp.setContentID( targetName );
        }
        else
        {
            mbp.setContentID( new UID().toString() );
        }        
        mp.addBodyPart( mbp );
        
        return mbp.getContentID();
    }
    
    /**
     * Adds an attachement while adding the file specified by <var>filePath</var>.
     * The orignal fileName will be used as name of the attachment
     * @param filePath path to the file to add as attachment
     * @return the CID of the added attachment 
     */
    public String addAttachment( String filePath ) throws MessagingException
    {
        MimeBodyPart mbp = new MimeBodyPart();
        FileDataSource fds = new FileDataSource( filePath );
        mbp.setDataHandler( new DataHandler( fds ) );
        mbp.setContentID( new UID().toString() );
        mp.addBodyPart( mbp );
        
        return mbp.getContentID();

    }

    /**
     * Adds an attachment while adding the file specified by <var>filePath</var> using <var>targetName</var> as attachement name.
     * @param filePath path to the file to add as attachment
     * @param targetName name of the body part (attachment)
     * @return the CID of the added attachment
     * @throws MessagingException
     */
    public String addAttachment( String filePath, String targetName ) throws MessagingException
    {
        return addAttachment( filePath, targetName, false );
    }    

    /**
     * Adds an attachement while adding the file specified by <var>filePath</var> using <var>targetName</var> as attachement name.
     * @param filePath path to the file to add as attachment
     * @param targetName name of the body part (attachement)
     * @param useTargetNameAsCID if true <var>targetName</var> will be used as CID of the attachment
     * otherwise a new unique one will be generated
     * @return the CID of the added attachment
     * @throws MessagingException
     */
    public String addAttachment( String filePath, String targetName, boolean useTargetNameAsCID ) throws MessagingException
    {
        MimeBodyPart mbp = new MimeBodyPart();
        FileDataSource fds = new FileDataSource( filePath );
        mbp.setDataHandler( new DataHandler( fds ) );
        mbp.setFileName( targetName );
        if( useTargetNameAsCID )
        {
            mbp.setContentID( targetName );
        }
        else
        {
            mbp.setContentID( new UID().toString() );
        }
        
        mp.addBodyPart( mbp );
        
        return mbp.getContentID();
    }    

    /**
     * Adds an attachement while adding the file specified by <var>filePath</var> using <var>targetName</var> as attachement name.
     * @param filePath path to the file to add as attachment
     * @param targetName name of the body part (attachment), can be null
     * @param displayName the description of the attachment most clients will show this as attachment name, can be null
     * @param cid the CID to use for the attachement, can be null
     * @return the CID of the added attachment
     * @throws MessagingException
     */
    public String addAttachment( String filePath, String targetName, String displayName, String cid ) throws MessagingException
    {
        MimeBodyPart mbp = new MimeBodyPart();
        FileDataSource fds = new FileDataSource( filePath );
        mbp.setDataHandler( new DataHandler( fds ) );
        if( targetName != null )
        {
            mbp.setFileName( targetName );
        }
        
        if( cid != null )
        {
            mbp.setContentID( cid );
        }
        else
        {
            mbp.setContentID( new UID().toString() );
        }
        
        if( displayName != null )
        {
            mbp.setDescription( displayName );
        }
        
        mp.addBodyPart( mbp );
        
        return mbp.getContentID();
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