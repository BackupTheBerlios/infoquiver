/*********************************************************************
 * QueryResultMapDataSource.java
 * created on 17.07.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/report/QueryResultMapDataSource.java,v $
 * $Date: 2004/07/17 17:13:41 $
 * $Revision: 1.1 $
 *********************************************************************/

package net.sf.iquiver.report;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Method;

import net.sf.iquiver.om.SearchQuery;
import de.netseeker.util.ListMap;
import dori.jasper.engine.JRDataSource;
import dori.jasper.engine.JRException;
import dori.jasper.engine.JRField;

/**
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
    private int index = -1;

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
        index++;
        return (index < _queryResults.size());
    }

    /* (non-Javadoc)
     * @see dori.jasper.engine.JRDataSource#getFieldValue(dori.jasper.engine.JRField)
     */
    public Object getFieldValue( JRField field ) throws JRException
    {
        Object value = null;
        String fieldName = field.getName();

        if (fieldName.equals( "SearchCriteria" ))
        {
            SearchQuery query = (SearchQuery) _queryResults.getKeyAt( index );
            value = query.getSearchQueryCriteria();
        }
        else
        {
            Object doc = _queryResults.getValueAt( index );
            try
            {
                Method method = doc.getClass().getMethod( field.getName(), null );
                value = method.invoke( doc, null );
            }
            catch ( Exception e )
            {
                logger.error( "Error while calling method for fieldname " + field.getName(), e );
            }
        }

        return value;
    }
}