/*********************************************************************
 * SmtpClient.java
 * created on 15.10.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/util/mail/SmtpClient.java,v $
 * $Date: 2004/10/17 16:46:45 $
 * $Revision: 1.3 $
*********************************************************************/

package net.sf.iquiver.util.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * A simple SMTP client providing functionality to send multipart emails via the javax.mail package.
 * @author netseeker aka Michael Manske
 */
public class SmtpClient
{
    private static final Log logger = LogFactory.getLog( SmtpClient.class );
     
    private String host = "";
    private String login;
    private String password;

    /**
     * Creates a new instance of SmtpClient
     * @param host the SMTP server to use
     * @param login username for the SMTP server, can be null
     * @param password password for the SMTP server, can be null
     */
    public SmtpClient(String host, String login, String password)
    {
        this.host = host;
        this.login = login;
        this.password = password;
    }

    /**
     * Creates a new instance of SmtpClient
     * @param host the SMTP server to use
     * @param login username for the SMTP server, can be null
     * @param password password for the SMTP server, can be null
     * @param port the port to use when connecting to the SMTP server
     */
    public SmtpClient(String host, String login, String password, int port)
    {
        this( host + ":" + port, login, password );
    }
       
    /**
     * Sends a single email
     * @param mail the mail to send
     * @throws MessagingException
     */
    public long send(EMail mail) throws MessagingException
    {
        return send( new EMail[] { mail } )[0];
    }
    
    /**
     * Sends a bunch of emails
     * @param mails the mails to send
     * @throws MessagingException
     */
    public long[] send(EMail[] mails) throws MessagingException
    {
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        Transport bus = null;
        Session session = Session.getInstance(props);
        long size[] = new long[mails.length];
        
        try
        {
            bus = session.getTransport("smtp");
            if( login == null )
            {
                bus.connect();
            }
            else
            {
                bus.connect( host, login, password );
            }
            
            for( int i = 0; i < mails.length; i++ )
            {
                EMail mail = mails[i];
                Message msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress(mail.getSender()) );                
                msg.setRecipients(Message.RecipientType.TO, stringsToAddress( mail.getReceipients() ) );
                if( mail.getCc() != null && mail.getCc().length > 0 )
                {
                    msg.setRecipients(Message.RecipientType.CC, stringsToAddress(mail.getCc()) );
                }
                msg.setSubject( mail.getSubject() );
                msg.setSentDate( new Date() );
                msg.saveChanges();
                bus.send( msg );
                size[i] = msg.getSize();
            }            
        }
        catch ( NoSuchProviderException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            if( bus != null && bus.isConnected() )
            {
                bus.close();
            }
        }
        
        return size;
    }    
    
    private InternetAddress[] stringsToAddress(String[] adrs ) throws AddressException
    {
        InternetAddress[] adresses = new InternetAddress[adrs.length];
        
        for( int i = 0; i < adrs.length; i++ )
        {
            adresses[i] = new InternetAddress( adrs[i] );
        }
        
        return adresses;
    }
}
