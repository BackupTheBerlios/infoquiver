/*
 * Created on 09.03.2004
 *
 */
package net.sf.iquiver.parser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import net.sf.iquiver.metaformat.AbstractDocument;
import net.sf.iquiver.metaformat.Document;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.netseeker.util.CompatibleDate;
import de.netseeker.util.FileUtil;

/**
 * @author netseeker aka Michael Manske
 */
public abstract class Parser
{
    private Log logger = LogFactory.getLog( getClass() );

    private long parseStartTime;
    private long parseEndTime;

    private String _arguments;

    /**
     * @param source
     * @return
     * @throws ParsingException
     */
    public Document parse( String source ) throws ParsingException, IOException
    {
        startParseMonitoring();
        Document doc = parse( source.getBytes() );
        fillSafeDocumentDates( doc );
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
            fillSafeDocumentDates( doc );
        }
        catch ( Exception e )
        {
            throw new ParsingException( e.getMessage(), -1 );
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
        Document doc = parse( FileUtil.fastToByteArray( source ) );
        doc.setFileName( source.getAbsolutePath() );
        if (doc.getName() == null)
        {
            doc.setName( source.getName() );
        }
        if (doc.getDateOfCreation() == null)
        {
            doc.setDateOfCreation( new CompatibleDate( source.lastModified() ).getDate() );
        }
        if (doc.getDateOfLastModification() == null)
        {
            doc.setDateOfLastModification( new CompatibleDate( source.lastModified() ).getDate() );
        }

        return doc;
    }

    /**
     * @param source
     * @return
     * @throws ParsingException
     * @throws IOException
     */
    public Document parse( Document source ) throws ParsingException, IOException
    {
        startParseMonitoring();
        Document doc = parse( source.getRawContent() );
        AbstractDocument.fillMissingContentValues( source, doc );
        fillSafeDocumentDates( doc );
        stopParseMonitoring();
        return doc;
    }

    private void fillSafeDocumentDates( Document doc )
    {
        Date now = new Date();
        if (doc.getDateOfCreation() == null)
        {
            doc.setDateOfCreation( now );
        }
        if (doc.getDateOfLastModification() == null)
        {
            doc.setDateOfLastModification( now );
        }
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
        logger.debug( "Start Parsing at " + parseStartTime );
    }

    private void stopParseMonitoring()
    {
        parseEndTime = System.currentTimeMillis();
        logger.debug( "Parsing finished at " + parseEndTime );
    }

    /**
     * @param arguments
     */
    public void setArguments( String arguments )
    {
        this._arguments = arguments;
    }

    /**
     * @return
     */
    public String getArguments()
    {
        return this._arguments;
    }

    public abstract Document parse( byte[] rawContent ) throws ParsingException;

    public abstract String getStripped( byte[] rawContent ) throws ParsingException;
}