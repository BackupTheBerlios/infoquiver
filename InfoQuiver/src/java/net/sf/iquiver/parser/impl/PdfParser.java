/*
 * Created on 09.07.2004
 */
package net.sf.iquiver.parser.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.GregorianCalendar;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.metaformat.impl.ContentTypeFactory;
import net.sf.iquiver.metaformat.impl.MetaFormatFactory;
import net.sf.iquiver.parser.Parser;
import net.sf.iquiver.parser.ParsingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.pdfbox.encryption.DecryptDocument;
import org.pdfbox.exceptions.CryptographyException;
import org.pdfbox.exceptions.InvalidPasswordException;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.pdmodel.PDDocumentInformation;
import org.pdfbox.util.PDFTextStripper;

/**
 * @author netseeker aka Michael Manske
 */
public class PdfParser extends Parser
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( PdfParser.class );

    /*
     * (non-Javadoc)
     * 
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
            doc = MetaFormatFactory.createDocumentForContentType( ContentTypeFactory.CT_APPLICATION_PDF );
            doc.setRawContent( rawContent );
        }
        catch ( Exception e )
        {
            logger.error( e );
            throw new ParsingException( e.getMessage(), -1 );
        }

        try
        {
            parser.parse();
            pdfDoc = parser.getPDDocument();
            PDDocumentInformation docInfo = getDocumentInfo( pdfDoc );
            doc.setAuthor( docInfo.getAuthor() );
            if( docInfo.getCreationDate() != null )
            {
                doc.setDateOfCreation( docInfo.getCreationDate().getTime() );
            }
            else
            {
                doc.setDateOfCreation( new GregorianCalendar().getTime() );
            }
            if( docInfo.getModificationDate() != null )
            {
                doc.setDateOfLastModification( docInfo.getModificationDate().getTime() );
            }
            else
            {
                doc.setDateOfLastModification( new GregorianCalendar().getTime() );
            }
            doc.setTitle( docInfo.getTitle() );
            doc.setShortDescription( docInfo.getSubject() );
            doc.setKeywords( docInfo.getKeywords() );
        }
        catch ( IOException e1 )
        {
            logger.error( e1 );
            throw new ParsingException( e1.getMessage(), 0 );
        }
        finally
        {
            if (pdfDoc != null)
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

    /* (non-Javadoc)
     * @see net.sf.iquiver.parser.Parser#getStripped(byte[])
     */
    public String getStripped( byte[] rawContent ) throws ParsingException
    {
        PDDocument pdfDoc = null;
        org.pdfbox.pdfparser.PDFParser parser = null;
        String content = "";

        try
        {
            parser = new org.pdfbox.pdfparser.PDFParser( new ByteArrayInputStream( rawContent ) );
        }
        catch ( Exception e )
        {
            logger.error( e );
            throw new ParsingException( e.getMessage(), -1 );
        }

        try
        {
            parser.parse();
            pdfDoc = parser.getPDDocument();            
            PDDocumentInformation docInfo = getDocumentInfo( pdfDoc );
            PDFTextStripper stripper = new PDFTextStripper();
            content = stripper.getText(pdfDoc);
        }
        catch ( IOException e1 )
        {
            logger.error( e1 );
            throw new ParsingException( e1.getMessage(), 0 );
        }
        finally
        {
            if (pdfDoc != null)
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
        
        return content;
    }
    
    /**
     * @param pdfDoc
     * @return
     * @throws ParsingException
     */
    private PDDocumentInformation getDocumentInfo( PDDocument pdfDoc ) throws ParsingException
    {
        if( pdfDoc.isEncrypted() )
        {
            DecryptDocument decryptor = new DecryptDocument( pdfDoc );
            try
            {
                //Just try using the default password and move on
                decryptor.decryptDocument( "" );
            }
            catch ( IOException e1 )
            {
                logger.error( e1 );
                throw new ParsingException( e1.getMessage(), 0 );
            }
            catch ( CryptographyException e )
            {
                logger.error("Error decrypting document!", e);
                throw new ParsingException(e.getMessage(), 0);
            }
            catch ( InvalidPasswordException e )
            {
                logger.error("Invalid passwort for encrypted document!", e);
                throw new ParsingException(e.getMessage(), 0);
            }
        }            
        
        return pdfDoc.getDocumentInformation();        
    }

}