/*********************************************************************
 * QueryResultMapDataSource.java
 * created on 17.07.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/report/QueryResultMapDataSource.java,v $
 * $Date: 2004/11/26 19:29:29 $
 * $Revision: 1.5 $
 *********************************************************************/

package net.sf.iquiver.report;

import java.lang.reflect.Method;
import java.util.List;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.om.SearchQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.netseeker.util.ListMap;
import dori.jasper.engine.JRDataSource;
import dori.jasper.engine.JRException;
import dori.jasper.engine.JRField;

/**
 * A custom jasper datasource, which is able to deal with searchresults
 * created by net.sf.iquiver.services.impl.ContentSearchService
 * @author netseeker aka Michael Manske
 */
public class QueryResultMapDataSource implements JRDataSource
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( QueryResultMapDataSource.class );

    private IReportSource _source;
    private ListMap _queryResults;
    private int _index = -1;
    private int _counter = 0;
    
    /**
     * @param source
     * @param queryResults
     */
    public QueryResultMapDataSource(IReportSource source, ListMap queryResults)
    {
        this._source = source;
        this._queryResults = queryResults;
    }

    /* (non-Javadoc)
     * @see dori.jasper.engine.JRDataSource#next()
     */
    public boolean next() throws JRException
    {
        if( _queryResults.size() > 0 )
        {
	        List docs = (List)_queryResults.getValueAt( 0 );
	        _index++;
	        _counter++;
	        if( _index > 0 )
	        {            
	            docs.remove( 0 );
	            
	            if( docs.isEmpty() )
	            {
	                _queryResults.removeAt( 0 );
	                _counter = 0;
	            }
	        }
	        
	        return _queryResults.size() > 0 && docs.size() > 1;
        }
        
        return false;
    }

    /* (non-Javadoc)
     * @see dori.jasper.engine.JRDataSource#getFieldValue(dori.jasper.engine.JRField)
     */
    public Object getFieldValue( JRField field ) throws JRException
    {
        Object value = null;
        String fieldName = field.getName();

        if (fieldName.equals( "Criteria" ))
        {
            SearchQuery query = (SearchQuery) _queryResults.getKeyAt( 0 );
            value = query.getSearchQueryCriteria();
        }
        else if( fieldName.equals( "Counter") )
        {
            value = new Integer( _counter );
        }
        else
        {
            if (logger.isDebugEnabled())
            {
                logger.debug( "Requested field is: " + fieldName );
            }
            
            List docs = (List)_queryResults.getValueAt( 0 );
            Object doc = docs.get( 0 );
            
            try
            {
                StringBuffer sb = new StringBuffer( fieldName );
                char upperChar = Character.toUpperCase( fieldName.charAt( 0 ) );
                sb.delete( 0, 1 );
                sb.insert( 0, upperChar );
                fieldName = "get" + sb.toString();
                if (logger.isDebugEnabled())
                {
                    logger.debug( "Will invoke method: " + fieldName );
                }
                Method method = doc.getClass().getMethod( fieldName, null );
                value = method.invoke( doc, null );
                
                if( fieldName.equals("getName") && ( value == null || value.toString().length() == 0))
                {
                    value = ((Document)doc).getTitle();
                }
            }
            catch ( Exception e )
            {
                logger.error( "Error while calling method for fieldname " + fieldName, e );
            }
        }

        return value;
    }
}