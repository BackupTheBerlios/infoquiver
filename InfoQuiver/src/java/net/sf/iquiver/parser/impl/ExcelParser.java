/*********************************************************************
 * ExcelParser.java
 * created on 21.10.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/parser/impl/ExcelParser.java,v $
 * $Date: 2004/10/23 19:43:12 $
 * $Revision: 1.4 $
 *********************************************************************/

package net.sf.iquiver.parser.impl;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.metaformat.impl.ContentTypeFactory;
import net.sf.iquiver.metaformat.impl.MetaFormatFactory;
import net.sf.iquiver.parser.Parser;
import net.sf.iquiver.parser.ParsingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * @author netseeker aka Michael Manske
 */
public class ExcelParser extends Parser
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( ExcelParser.class );

    /* (non-Javadoc)
     * @see net.sf.iquiver.parser.Parser#parse(byte[])
     */
    public Document parse( byte[] rawContent ) throws ParsingException
    {
        Document doc = null;
        HSSFWorkbook wb = null;

        try
        {
            doc = MetaFormatFactory.createDocumentForContentType( ContentTypeFactory.CT_APPLICATION_MSEXCEL );
            doc.setRawContent( rawContent );
            wb = new HSSFWorkbook( new BufferedInputStream( new ByteArrayInputStream( rawContent ) ) );
            StringBuffer sb = new StringBuffer();
            int currentSheet = 0;

            for (int i = 0; i < wb.getNumberOfSheets(); i++)
            {
                if (wb.getSheetName( i ) != null && wb.getSheetName( i ).length() > 0)
                {
                    if (currentSheet > 0)
                    {
                        sb.append( " " );
                    }

                    sb.append( wb.getSheetName( i ) );
                    ++currentSheet;
                }
            }

            doc.setKeywords( sb.toString() );
        }
        catch ( Exception e )
        {
            throw new ParsingException( e.getMessage(), -1 );
        }

        return doc;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.parser.Parser#getStripped(byte[])
     */
    public String getStripped( byte[] rawContent ) throws ParsingException
    {
        HSSFWorkbook wb = null;
        StringBuffer sb = new StringBuffer();

        try
        {
            wb = new HSSFWorkbook( new BufferedInputStream( new ByteArrayInputStream( rawContent ) ) );
            for (int i = 0; i < wb.getNumberOfSheets(); i++)
            {
                HSSFSheet sheet = wb.getSheetAt( i );
                String name = wb.getSheetName( i );
                if (name != null && name.length() > 0)
                {
                    sb.append( name );
                    sb.append( "\n\n" );
                }

                for (Iterator rowIt = sheet.rowIterator(); rowIt.hasNext();)
                {
                    HSSFRow row = (HSSFRow) rowIt.next();
                    for (Iterator cellIt = row.cellIterator(); cellIt.hasNext();)
                    {
                        HSSFCell cell = (HSSFCell) cellIt.next();
                        switch ( cell.getCellType() )
                        {
                            case HSSFCell.CELL_TYPE_STRING:
                                sb.append( cell.getStringCellValue() );
                                break;
                            case HSSFCell.CELL_TYPE_BOOLEAN:
                                sb.append( cell.getBooleanCellValue() );
                                break;
                            case HSSFCell.CELL_TYPE_NUMERIC:
                                sb.append( cell.getNumericCellValue() );
                                break;
                            case HSSFCell.CELL_TYPE_FORMULA:
                                sb.append( cell.getCellFormula() );
                                break;
                            case HSSFCell.CELL_TYPE_ERROR:
                                sb.append( cell.getErrorCellValue() );
                                break;      
                        }
                        
                        sb.append("\t");
                    }
                    if (rowIt.hasNext())
                    {
                        sb.append( "\n" );
                    }
                }

                if (i < wb.getNumberOfSheets())
                {
                    sb.append( "\n\n" );
                }
            }
        }
        catch ( IOException e )
        {
            throw new ParsingException( e.getMessage(), -1 );
        }

        if( logger.isDebugEnabled() )
        {
            logger.debug( "getStripped() --> " + sb );
        }
        
        return sb.toString();
    }
}