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

import net.sf.iquiver.metaformat.Document;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.vfs.FileObject;
import org.apache.commons.vfs.VFS;

/**
 * @author netseeker aka Michael Manske
 */
public abstract class Parser
{
    private static final Log logger = LogFactory.getLog(Parser.class);
    
    private long parseStartTime;
    private long parseEndTime;    
    
    /**
     * @param source
     * @return
     * @throws ParsingException
     */
    public Document parse( String source ) throws ParsingException, IOException
    {
        startParseMonitoring();
        Document doc = parse( source.getBytes() );
        stopParseMonitoring();
        
        return doc;
    }

    /**
     * @param source
     * @return
     * @throws ParsingException
     * @throws IOException
     */
    public Document parse( byte[] source ) throws ParsingException, IOException
    {
        InputStream in = new ByteArrayInputStream(source);
        startParseMonitoring();
        Document doc = parse( in );
        stopParseMonitoring();
        in.close();
        
        return doc;
    }
        
    /**
     * @param source
     * @return
     * @throws ParsingException
     * @throws IOException
     */
    public Document parse( File source ) throws ParsingException, IOException
    {
        return parse( VFS.getManager().toFileObject(source) );
    }
    
    /**
     * @param source
     * @return
     * @throws ParsingException
     * @throws IOException
     */
    public Document parse( FileObject source) throws ParsingException, IOException
    {
        InputStream in = source.getContent().getInputStream();
        startParseMonitoring();
        Document doc = parse( in );
        stopParseMonitoring();
        in.close();
        
        return doc;
    }
    
    public Document parse( Document source) throws ParsingException, IOException
    {
        return parse(source.getRawContent());
    }
    
    
    /**
     * @return
     */
    public long getLastParsingTimeExposure()
    {
        return parseEndTime - parseStartTime;
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
    
    protected abstract Document parse( InputStream in ) throws ParsingException;    
 }
