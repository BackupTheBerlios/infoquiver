/*
 * Created on 09.03.2004
 *
 */
package net.sf.iquiver.parser;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;

import net.sf.iquiver.metaformat.Document;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.vfs.FileObject;
import org.apache.commons.vfs.FileSystemException;
import org.apache.commons.vfs.VFS;

/**
 * @author netseeker aka Michael Manske
 */
public abstract class Parser
{
    private static final Log logger = LogFactory.getLog(Parser.class);
    
    private long parseStartTime;
    private long parseEndTime;
    private long timeOut = 3000; 
    
    public Document parse( String source ) throws ParsingException
    {
        startParseMonitoring();
        Document doc = parse( new StringReader(source) );
        stopParseMonitoring();
        
        return doc;
    }

    public Document parse( byte[] source ) throws ParsingException, IOException
    {
        InputStream in = new ByteArrayInputStream(source);
        startParseMonitoring();
        Document doc = parse( in );
        stopParseMonitoring();
        in.close();
        
        return doc;
    }
        
    public Document parse( File source ) throws ParsingException, IOException
    {
        return parse( VFS.getManager().toFileObject(source) );
    }
    
    public Document parse( FileObject source) throws ParsingException, IOException
    {
        InputStream in = source.getContent().getInputStream();
        startParseMonitoring();
        Document doc = parse( in );
        stopParseMonitoring();
        in.close();
        
        return doc;
    }
    
    
    /**
     * @return
     */
    public long getLastParsingTimeExposure()
    {
        return parseEndTime - parseStartTime;
    }
    
    /**
     * @param millis
     */
    public void setParserTimeout(long millis)
    {
        this.timeOut = millis;
    }
    
    /**
     * @return
     */
    public long getParserTimeout() 
    {
        return this.timeOut;
    }
    
    private void startParseMonitoring()
    {
        parseStartTime = System.currentTimeMillis();
        logger.debug("Start Parsing at " + parseStartTime);        
    }
    
    private void stopParseMonitoring()
    {
        parseEndTime = System.currentTimeMillis();
        logger.debug("Parsing finished at " + parseEndTime);        
    }
    
    protected abstract Document parse( InputStream in ) throws ParsingException, IllegalArgumentException;    
    protected abstract Document parse( Reader in ) throws ParsingException, IllegalArgumentException;
}
