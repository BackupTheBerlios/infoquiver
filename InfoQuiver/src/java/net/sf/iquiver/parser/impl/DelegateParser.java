/*
 * Created on 13.07.2004
 */
package net.sf.iquiver.parser.impl;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.commons.io.IOUtils;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.parser.Parser;
import net.sf.iquiver.parser.ParsingException;

/**
 * A parser implementation which delegates parsing to an external application and reads
 * the result from the applications standard output.
 * @author netseeker aka Michael Manske
 */
public class DelegateParser extends Parser
{
    /* (non-Javadoc)
     * @see net.sf.iquiver.parser.Parser#parse(byte[])
     */
    public Document parse( byte[] rawContent ) throws ParsingException
    {        	
        Document doc = null;
        
        if( getArguments() != null )
        {
            String[] executable = getArguments().split(" ");
            Process child = null;
            InputStream in = null;
            
            try
            {
	            if(executable.length > 1)
	            {
	                child = Runtime.getRuntime().exec(executable[0]);
	            }
	            else
	            {
	                child = Runtime.getRuntime().exec(executable);
	            }
	            
	            in = new BufferedInputStream( child.getInputStream() );
	            doc.setRawContent( IOUtils.toByteArray( in ) );
	            doc.setDateOfCreation( new Date() );
	            doc.setDateOfLastModification( new Date() );
	            doc.setAuthor( "imported with " + executable[0] );
            }
            catch(IOException e)
            {
                throw new ParsingException( e.getMessage(), -1 );
            }
            finally
            {
                if( in != null )
                {
                    IOUtils.closeQuietly( in );
                }
            }            
        }
        else
        {
            throw new ParsingException("No Arguments found. You must specify at least an executable in the arguments.", -1);
        }
        
        return doc;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.parser.Parser#getStripped(byte[])
     */
    public String getStripped( byte[] rawContent ) throws ParsingException
    {
        return new String( rawContent );
    }
}
