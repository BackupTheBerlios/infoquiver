/*********************************************************************
 * ReportDispatcher.java
 * created on 26.11.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/report/impl/ReportDispatcher.java,v $
 * $Date: 2004/11/28 13:24:03 $
 * $Revision: 1.2 $
 *********************************************************************/

package net.sf.iquiver.report.impl;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import net.sf.iquiver.IQuiver;
import net.sf.iquiver.om.Address;
import net.sf.iquiver.om.User;
import net.sf.iquiver.om.UserGroup;
import net.sf.iquiver.report.ReportGenerator;
import net.sf.iquiver.util.VelocityParser;
import net.sf.iquiver.util.mail.EMail;
import net.sf.iquiver.util.mail.SmtpClient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.TorqueException;

import de.netseeker.util.StringUtil;

/**
 * Sends the following reports of the current day to a user
 * <ul>
 *  <li>his own report</li>
 *  <li>the reports of all usergroups the user is a member of</li>
 *  <li>the report of the client the user belongs to</li>
 * </ul> 
 * The reports will be send as attachement, the choosen report format depends on BaseUserPeer.USER_PREFERED_REPORT_FORMAT.
 * Default report format is HTML.
 * @author netseeker aka Michael Manske
 */
public class ReportDispatcher extends Thread
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( ReportDispatcher.class );

    private static String smtp_host = IQuiver.getConfiguration().getString( "smtp.host" );
    private static String smtp_login = IQuiver.getConfiguration().getString( "smtp.user" );
    private static String smtp_pwd = IQuiver.getConfiguration().getString( "smtp.password" );
    private static String smtp_from = IQuiver.getConfiguration().getString( "smtp.from" );

    private User user;

    /**
     * Creates a new instance of ReportDispatcher
     * @param user
     */
    public ReportDispatcher(User user)
    {
        this.user = user;
    }

    public void run()
    {
        try
        {
            Address adr = user.getAddress();
            //only dispatch an email if the user has an email address
            if (adr != null && adr.getAddressEmail() != null)
            {
                //collect the filepaths for all report files
                String fileName = ReportGenerator.FILE_DATE_FORMATTER.format( new Date() );
                String mailAddress = adr.getAddressEmail();
                String format = StringUtil.defaultIfNull( user.getUserPreferedReportFormat(), "html" ).toLowerCase();
                List groups = user.getUserGroupsRelatedByUserGroupLnk();
                String[] paths = new String[groups.size() + 2];
                paths[0] = ReportGenerator.getReportFilePathForReportSource( user );
                paths[1] = ReportGenerator.getReportFilePathForReportSource( user.getClient() );

                for (int i = 0; i < groups.size(); i++)
                {
                    UserGroup group = (UserGroup) groups.get( i );
                    paths[i + 2] = ReportGenerator.getReportFilePathForReportSource( group );
                }

                //parse the velocity email template
                Map veloVars = new HashMap();
                Map results = new HashMap();
                veloVars.put( "user", user );
                veloVars.put( "client", user );
                veloVars.put( "usergroups", groups );
                veloVars.put( "reportFormatExtension", format );
                String msg = VelocityParser.parseI18n( "resources/mail/searchresults", veloVars, user
                        .getLanguageRecursive(), results );
                String subject = results.get( "subject" ) != null ? (String) results.get( "subject" )
                        : "InfoQuiver SearchReports";

                //generate the email with the results of the parsed velocity email template
                EMail mail = new EMail( smtp_from, mailAddress, subject );
                mail.addContent( msg );

                //add all reports as attachements
                for (int i = 0; i < paths.length; i++)
                {
                    File file = new File( paths[i] + fileName + "." + format );
                    if (file.exists())
                    {
                        //use the attachment description returned by the parsed velocity email template
                        String displayName = ((i == 0) ? (String) results.get( "personalReportName" )
                                : (i == 1) ? (String) results.get( "clientwideReportName" ) : (String) results
                                        .get( "usergroupReportPrefix" )
                                        + ((UserGroup) groups.get( i - 2 )).getUserGroupName());

                        mail.addAttachment( file.getAbsolutePath(), null, displayName, null );
                    }
                    else
                    {
                        logger.warn( "Report file " + file.getAbsolutePath() + " not found!" );
                    }
                }

                //add all neccessary graphics as attachements
                if (format.equals( "html" ))
                {
                    File dir = new File( "images" );
                    File[] images = dir.listFiles();
                    for (int i = 0; i < images.length; i++)
                    {
                        if (images[i].isFile())
                        {
                            mail.addAttachment( images[i].getAbsolutePath(), images[i].getName() );
                        }
                    }
                }

                SmtpClient client = new SmtpClient( smtp_host, smtp_login, smtp_pwd );
                client.send( mail );
            }
        }
        catch ( TorqueException e )
        {
            logger.error( "Database error while peparing dispatching of reports for user " + user.getUserId()
                    + " failed!", e );
        }
        catch ( MessagingException e )
        {
            logger.error( "Mail error while dispatching reports for user " + user.getUserId() + "!", e );
        }
        catch ( Exception e )
        {
            logger.error( "Error while generating content of mail message for user " + user.getUserId() + "!", e );
        }
    }
}