/*********************************************************************
 * InputStreamDataSource.java
 * created on 16.10.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/util/mail/InputStreamDataSource.java,v $
 * $Date: 2004/10/16 19:26:42 $
 * $Revision: 1.1 $
*********************************************************************/

package net.sf.iquiver.util.mail;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataSource;

/**
 * @author netseeker aka Michael Manske
 */
public class InputStreamDataSource implements DataSource
{
    private String contenType;
    private InputStream inputStream;
    
    /**
     * 
     */
    public InputStreamDataSource( InputStream inputStream, String contentType )
    {
        this.inputStream = inputStream;
        this.contenType = contentType;
    }

    /* (non-Javadoc)
     * @see javax.activation.DataSource#getContentType()
     */
    public String getContentType()
    {
        return this.contenType;
    }

    /* (non-Javadoc)
     * @see javax.activation.DataSource#getInputStream()
     */
    public InputStream getInputStream() throws IOException
    {        
        return this.inputStream;
    }

    /* (non-Javadoc)
     * @see javax.activation.DataSource#getName()
     */
    public String getName()
    {        
        return "InputStreamDataSource - a read only DataSource for wrapping InputStream into a DataSource.";
    }

    /* (non-Javadoc)
     * @see javax.activation.DataSource#getOutputStream()
     */
    public OutputStream getOutputStream() throws IOException
    {
        throw new IOException("InputStreamDataSource does not implement an OutputStream - it is read only!");
    }

}
