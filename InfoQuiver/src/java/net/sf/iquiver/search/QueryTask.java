/*
 * Created on 12.07.2004
 */
package net.sf.iquiver.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sf.iquiver.om.Content;
import net.sf.iquiver.om.ContentPeer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MultiSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Searchable;
import org.apache.torque.TorqueException;

/**
 * TODO add support for caching query results 
 * @author netseeker aka Michael Manske
 */
public class QueryTask
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( QueryTask.class );
    
    /**
     * List of used search fields
     */
    public static final String[] SEARCH_FIELDS = { "author", "name", "title",
            "keywords", "description", "url", "created", "modified", "contents", "filename" };

    /**
     * Searches all hits for the given search criteria on an existing lucene index
     * 
     * @param index the lucene index to search
     * @param searchCriteria the human readable query string
     * @return a list of net.sf.iquiver.metaformat.Document objects
     * @throws IOException
     * @throws ParseException
     */
    public static List search( String index, String searchCriteria ) throws IOException, ParseException
    {
        if (logger.isDebugEnabled())
        {
            logger.debug( "Starting search for \"" + searchCriteria + "\" on index \"" + index + "\"..." );
        }

        List contents = null;
        IndexSearcher is = new IndexSearcher( index );
        Analyzer analyzer = new StandardAnalyzer();
        try
        {
	        Query query = MultiFieldQueryParser.parse( searchCriteria, SEARCH_FIELDS, analyzer );
	        contents = hits2Documents( is.search( query ) );		
        }
        finally
        {
            is.close();
        }

        if (logger.isDebugEnabled())
        {
            logger.debug( "Finished search for \"" + searchCriteria + "\" on index \"" + index + "\". Found "
                    + contents.size() + " documents." );
        }

        return contents;
    }    
    
    /**
     * Searches all hits for the given search criteria on multiple existing lucene indeces 
     * @param indeces
     * @param searchCriteria
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static List search( String[] indeces, String searchCriteria ) throws IOException, ParseException
    {
        if (logger.isDebugEnabled())
        {
            logger.debug( "Starting search for \"" + searchCriteria + "\" on indeces \"" + indeces + "\"..." );
        }
        
        List contents = null;
        Searchable[] searchers = new Searchable[indeces.length];
        
        for( int i = 0; i < indeces.length; i++ )
        {
            searchers[i] = new IndexSearcher( indeces[i]);
        }
        
        MultiSearcher is = new MultiSearcher ( searchers );
        Analyzer analyzer = new StandardAnalyzer();
        try
        {
	        Query query = MultiFieldQueryParser.parse( searchCriteria, SEARCH_FIELDS, analyzer );
	        contents = hits2Documents( is.search( query ) );	
        }
        finally
        {
            is.close();
        }

        if (logger.isDebugEnabled())
        {
            logger.debug( "Finished search for \"" + searchCriteria + "\" on index \"" + indeces + "\". Found "
                    + contents.size() + " documents." );
        }

        return contents;        
    }
    
    /**
     * @param hits
     * @return
     * @throws IOException
     */
    private static List hits2Documents( Hits hits ) throws IOException
    {
        List contents = new ArrayList();
        
        for (int i = 0; i < hits.length(); i++)
        {
            Document doc = hits.doc( i );
            String uid = doc.get( "uid" );
            try
            {
                Content content = ContentPeer.retrieveByUID( uid );
                contents.add( uid );
            }
            catch ( TorqueException e )
            {
                logger.error( "Fetching document with uid=" + uid + " failed!", e );
            }
        }
        
        return contents;
    }
}