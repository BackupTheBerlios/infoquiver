/*********************************************************************
 * DefaultReportGenerator.java
 * created on 24.10.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/report/impl/DefaultReportGenerator.java,v $
 * $Date: 2004/11/24 21:27:25 $
 * $Revision: 1.6 $
 *********************************************************************/

package net.sf.iquiver.report.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import net.sf.iquiver.IQuiver;
import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.metaformat.impl.DocumentUtil;
import net.sf.iquiver.report.IReportSource;
import net.sf.iquiver.report.ReportGenerator;
import net.sf.iquiver.util.AvalonLogWrapper;
import net.sf.iquiver.util.Introspectable;
import net.sf.iquiver.util.ObjectSerializer;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.fop.apps.Driver;
import org.dom4j.DocumentHelper;
import org.dom4j.io.DocumentSource;

import de.netseeker.util.FileUtil;
import de.netseeker.util.ListMap;

/**
 * The default XSLT based report generator.
 * It uses a standard xslt transformation for html output and
 * a FOP based transformation for pdf output.
 * @author netseeker aka Michael Manske
 */
public class DefaultReportGenerator extends ReportGenerator
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( DefaultReportGenerator.class );

    /* (non-Javadoc)
     * @see net.sf.iquiver.report.ReportGenerator#generate(net.sf.iquiver.report.IReportSource, de.netseeker.util.ListMap)
     */
    public void generate( IReportSource searcher, ListMap queryresults )
    {
        try
        {
            String path = getReportFilePathForReportSource( searcher );
            String templatePath = path + filename_formatter.format( new Date() );
            TransformerFactory tFactory = TransformerFactory.newInstance();

            //build an xml string which contains the searcher, all queries and there coressponding query results
            StringBuffer sb = new StringBuffer();
            sb.append( "<root>\n" );
            sb.append( "<path>" );
            sb.append( _reportDir );
            sb.append( "</path>\n" );
            sb.append( "<created>");
            sb.append( formatter.format( new Date() ));
            sb.append( "</created>");            
            sb.append( ObjectSerializer.objectToXmlString( searcher ) );

            for (int i = 0; i < queryresults.size(); i++)
            {
                sb.append( "<queryresult>\n" );
                Introspectable query = (Introspectable) queryresults.getKeyAt( i );
                sb.append( ObjectSerializer.objectToXmlString( query ) );
                List docs = (List) queryresults.getValueAt( i );
                for (Iterator it = docs.iterator(); it.hasNext();)
                {
                    sb.append( DocumentUtil.documentToXmlString( (Document) it.next() ) );
                }
                sb.append( "</queryresult>\n" );
            }

            sb.append( "</root>" );
            
            logger.debug( "generate report for xml:\n" + sb );

            //build a dom4j document from the report result xml string
            org.dom4j.Document document = DocumentHelper.parseText( sb.toString() );
            DocumentSource source = new DocumentSource( document );

            //get the report template for html output
            Templates xslTemplate = createXSLTemplate( _template + "_html.xsl", tFactory );
            //create html report
            try
            {
                transform( xslTemplate, source, new StreamResult( new FileOutputStream( templatePath + ".html" ) ) );
            }
            catch ( TransformerException te )
            {
                logger.error( "!!!HTML Report generation failed!!!", te );
            }

            //get the report template for fop output
            xslTemplate = createXSLTemplate( _template + "_fop.xsl", tFactory );

            //create pdf report
            try
            {
                transformFop( xslTemplate, source, new FileOutputStream( templatePath + ".pdf" ), Driver.RENDER_PDF );
            }
            catch ( TransformerException te )
            {
                logger.error( "!!!PDF Report generation failed!!!", te );
            }
            
            File dir = new File("images");
            File[] images = dir.listFiles();
            for( int i = 0; i < images.length; i++)
            {
                FileUtil.fastFileCopy( images[i].getAbsolutePath(), path + images[i].getName() );
            }
/*
            //create xml report            
            try
            {
                transformFop( xslTemplate, source, new FileOutputStream( path + ".xml" ), Driver.RENDER_XML );
            }
            catch ( TransformerException te )
            {
                logger.error( "!!!XML Report generation failed!!!", te );
            }
*/            
        }
        catch ( Exception e )
        {
            logger.error( "!!!Report generation failed!!!", e );
        }
    }

    private void transform( Templates template, DocumentSource source, StreamResult result )
            throws TransformerException
    {
        Transformer transformer = template.newTransformer();
        long timer = System.currentTimeMillis();
        transformer.transform( source, result );
        logger.debug( "XSL Transforming time for HTML is: " + (System.currentTimeMillis() - timer) + "ms" );
    }

    private void transformFop( Templates template, DocumentSource source, OutputStream out, int type )
            throws TransformerException
    {
        Driver driver = new Driver();
        driver.setLogger( new AvalonLogWrapper( logger ) );
        driver.setRenderer( type );
        driver.setOutputStream( out );
        Transformer transformer = template.newTransformer();
        long timer = System.currentTimeMillis();
        transformer.transform( source, new SAXResult( driver.getContentHandler() ) );
        logger.debug( "XSL Transforming time for PDF is: " + (System.currentTimeMillis() - timer) + "ms" );
    }

    /**
     * Either returns an already created template instance from the cache or returns a
     * new instance
     * @param xslPath path to the xsl file
     * @param tFactory the TransformerFactory to use
     * @return an instance of  
     * @throws TransformerConfigurationException
     * @throws FileNotFoundException
     */
    protected Templates createXSLTemplate( String xslPath, TransformerFactory tFactory )
            throws TransformerConfigurationException, FileNotFoundException
    {
        Templates xslTemplate = null;
        //first check if the xsl template file does exist
        File xslFile = new File( xslPath );
        if (!xslFile.exists())
        {
            throw new FileNotFoundException( "Stylesheet not found: " + xslFile );
        }

        // check if file was modified since last call
        long lastModified = xslFile.lastModified();
        Long timeStamp = (Long) ObjectUtils
                .defaultIfNull( IQuiver.getContext().get( xslFile + ".time" ), new Long( -1 ) );

        if (logger.isDebugEnabled())
        {
            logger.debug( "file last modified: " + new Date( lastModified ).toLocaleString() );
            logger.debug( "the time we know: " + new Date( timeStamp.longValue() ).toLocaleString() );
        }

        //check if this is the first time we use the xsl template or the template
        //got modified since last usage
        if (timeStamp == null || IQuiver.getContext().get( "xslFile" ) == null
                || !(timeStamp.longValue() == lastModified))
        {
            logger.debug( "XSL File has changed: reparsing...!" );
            StreamSource ss = new StreamSource( new FileInputStream( xslPath ) );

            xslTemplate = tFactory.newTemplates( ss );
            IQuiver.getContext().put( xslFile, xslTemplate );
            IQuiver.getContext().put( xslFile + ".time", new Long( lastModified ) );
        }
        //otherwise we just use the cached xsl template
        else
        {
            logger.debug( "RECYCLE existing XSL File!" );
            xslTemplate = (Templates) IQuiver.getContext().get( xslFile );
        }

        return xslTemplate;
    }
}