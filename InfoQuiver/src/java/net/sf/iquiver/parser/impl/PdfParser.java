/*
 * Created on 09.07.2004
 */
package net.sf.iquiver.parser.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.metaformat.impl.MetaFormatFactory;
import net.sf.iquiver.parser.Parser;
import net.sf.iquiver.parser.ParsingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.pdmodel.PDDocumentInformation;

/**
 * @author netseeker aka Michael Manske
 */
public class PdfParser extends Parser
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog(PdfParser.class);
    
    /* (non-Javadoc)
     * @see net.sf.iquiver.parser.Parser#parse(byte[])
     */
    public Document parse( byte[] rawContent ) throws ParsingException
    {
        Document doc = null;
        PDDocument pdfDoc = null;
        org.pdfbox.pdfparser.PDFParser parser = null;
        
        try
        {
            parser = new org.pdfbox.pdfparser.PDFParser( new ByteArrayInputStream( rawContent ) );
            doc = MetaFormatFactory.createDocumentForContentType( MetaFormatFactory.CT_APPLICATION_PDF ) ;
            doc.setRawContent( rawContent );            
        }
        catch ( Exception e )
        {
            logger.error( e );
            throw new ParsingException( e.getMessage(), -1);            
        }

        try
        {
            parser.parse();
            pdfDoc = parser.getPDDocument();
            PDDocumentInformation docInfo = pdfDoc.getDocumentInformation();
            doc.setAuthor( docInfo.getAuthor() );
            doc.setDateOfCreation( docInfo.getCreationDate().getTime() );
            doc.setDateOfLastModification( docInfo.getModificationDate().getTime() );
            doc.setTitle( docInfo.getTitle() );
            doc.setShortDescription( docInfo.getSubject() );
        }
        catch ( IOException e1 )
        {
            logger.error( e1 );
            throw new ParsingException( e1.getMessage(), 0);
        }
        finally
        {
            if( pdfDoc != null)
            {
                try
                {
                    pdfDoc.close();
                }
                catch ( IOException e2 )
                {
                    logger.error( e2 );                    
                }
            }
        }
                
        return doc;
    }

}
