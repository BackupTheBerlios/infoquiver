/*
 * Created on 09.03.2004
 *
 */
package net.sf.iquiver.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import net.sf.iquiver.metaformat.Document;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
     * @param in
     * @return
     * @throws ParsingException
     */
    public Document parse( InputStream in ) throws ParsingException
    {
        startParseMonitoring();
        Document doc = null;
        try
        {
            doc = parse( IOUtils.toByteArray( in ) );
        }
        catch ( Exception e )
        {
            throw new ParsingException( e.getMessage(), -1);
        }
        stopParseMonitoring();
        
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
        return parse( new FileInputStream(source) );
    }
       
    /**
     * @param source
     * @return
     * @throws ParsingException
     * @throws IOException
     */
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
       
    public abstract Document parse ( byte[] rawContent ) throws ParsingException;
 }
