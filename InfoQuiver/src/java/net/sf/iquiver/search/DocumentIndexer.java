/*
 * Created on 10.07.2004
 */
package net.sf.iquiver.search;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.parser.Parser;
import net.sf.iquiver.parser.ParsingException;
import net.sf.iquiver.parser.UnsupportedContentTypeException;
import net.sf.iquiver.parser.impl.ParserFactory;

/**
 * @author netseeker aka Michael Manske
 */
public class DocumentIndexer
{
    /**
     * Commons Logger for this class
     */
    private static final Log logger = LogFactory.getLog( DocumentIndexer.class );

    /**
     * path to the used lucene index
     */
    private String _directory;

    /**
     * Creates a new instance of DocumentIndexer, which will use the given directory path to store the index
     * 
     * @param indexDirectory path to the directory containing the lucene search index, the directory will be created if
     *            it doesn't exist
     */
    public DocumentIndexer(String indexDirectory)
    {
        _directory = indexDirectory;

        File file = new File( _directory + "/segments" );

        if (!file.exists())
        {
            IndexWriter writer = null;
            try
            {
                writer = new IndexWriter( _directory, new StandardAnalyzer(), true );
            }
            catch ( IOException e )
            {
                logger.error( "Error occured while creating a new lucene index at: " + _directory );
            }
            finally
            {
                if (writer != null)
                {
                    try
                    {
                        writer.close();
                    }
                    catch ( IOException e1 )
                    {
                        logger.error( e1 );
                    }
                }
            }
        }
    }

    /**
     * Converts a iquiver document into an lucene document
     * 
     * @param doc
     * @return the created lucene document
     */
    private org.apache.lucene.document.Document convertDocument( Document doc )
    {
        org.apache.lucene.document.Document lDoc = new org.apache.lucene.document.Document();

        lDoc.add( Field.Keyword( "uid", doc.getUID() ) );

        if (doc.getAuthor() != null)
        {
            lDoc.add( Field.Text( "author", doc.getAuthor() ) );
        }
        if (doc.getName() != null)
        {
            lDoc.add( Field.Text( "name", doc.getName() ) );
        }
        if (doc.getTitle() != null)
        {
            lDoc.add( Field.Text( "title", doc.getTitle() ) );
        }
        if (doc.getKeywords() != null)
        {
            lDoc.add( Field.Text( "keywords", doc.getKeywords() ) );
        }
        if (doc.getShortDescription() != null)
        {
            lDoc.add( Field.Text( "description", doc.getShortDescription() ) );
        }
        if (doc.getInfoURL() != null)
        {
            lDoc.add( Field.Keyword( "url", doc.getInfoURL().toString() ) );
        }
        if (doc.getDateOfCreation() != null)
        {
            lDoc.add( Field.Keyword( "created", doc.getDateOfCreation() ) );
        }
        if (doc.getDateOfLastModification() != null)
        {
            lDoc.add( Field.Keyword( "modified", doc.getDateOfLastModification() ) );
        }
        if (doc.getFileName() != null)
        {
            lDoc.add( Field.Keyword( "filename", doc.getFileName() ) );
        }

        if (doc.getRawContent() != null)
        {
            try
            {
                Parser parser = ParserFactory.getParserForContentType( doc.getContentTypeStr() );
                if (doc.getRawContent() != null)
                {
                    String stripped = parser.getStripped( doc.getRawContent() );
                    if( stripped != null )
                    lDoc.add( Field.Text( "contents",  stripped ) );
                }
            }
            catch ( UnsupportedContentTypeException e )
            {
                logger.warn( "Can't add raw content to lucene index!", e );
            }
            catch ( ParsingException e )
            {
                logger.warn( "Can't add raw content to lucene index!", e );
            }
        }

        return lDoc;
    }

    /**
     * Adds a document to the search index
     * 
     * @param doc the net.sf.iquiver.metaformat.Document object
     * @throws IOException if the index can't be accessed
     */
    public synchronized void indexDocument( Document doc ) throws IOException
    {
        org.apache.lucene.document.Document lDoc = convertDocument( doc );
        IndexReader reader = IndexReader.open( _directory );
        try
        {
            deleteDocument( doc, reader );
        }
        finally
        {
            reader.close();
        }

        Analyzer analyzer = new StandardAnalyzer();
        IndexWriter writer = new IndexWriter( _directory, analyzer, false );
        try
        {
            addDocument( doc, writer );
        }
        finally
        {
            writer.close();
        }
    }

    /**
     * Deletes an document from an lucene index, also deletes all child documents recursively
     * 
     * @param doc
     * @param reader
     * @throws IOException
     */
    private synchronized void deleteDocument( Document doc, IndexReader reader ) throws IOException
    {
        reader.delete( new Term( "uid", doc.getUID() ) );
        if (doc.hasChildren())
        {
            for (Iterator it = doc.getChildren().iterator(); it.hasNext();)
            {
                deleteDocument( (Document) it.next(), reader );
            }
        }
    }

    /**
     * Adds an document to an lucene index, also adds all child documents recursively
     * 
     * @param doc
     * @param writer
     * @throws IOException
     */
    private void addDocument( Document doc, IndexWriter writer ) throws IOException
    {
        org.apache.lucene.document.Document lDoc = convertDocument( doc );

        if (logger.isDebugEnabled())
        {
            logger.debug( "Indexing document UID="
                    + doc.getUID()
                    + " --> "
                    + ObjectUtils.defaultIfNull( doc.getName(), ObjectUtils.defaultIfNull( doc.getTitle(), ObjectUtils
                            .defaultIfNull( doc.getShortDescription(), doc.getFileName() ) ) ) );
        }

        writer.addDocument( lDoc );
        // according to http://www.javaranch.com/newsletter/200404/Lucene.html
        // we should optimize the index after EACH document
        writer.optimize();

        if (doc.hasChildren())
        {
            for (Iterator it = doc.getChildren().iterator(); it.hasNext();)
            {
                addDocument( (Document) it.next(), writer );
            }
        }
    }

    /**
     * Adds a list of documents to the search index
     * 
     * @param docs list of net.sf.iquiver.metaformat.Document objects
     * @throws IOException if the index can't be accessed
     */
    public synchronized void indexDocuments( List docs ) throws IOException
    {
        Analyzer analyzer = null;
        IndexWriter writer = null;
        IndexReader reader = IndexReader.open( _directory );

        //delete the docs from index
        try
        {
            for (Iterator it = docs.iterator(); it.hasNext();)
            {
                deleteDocument( (Document) it.next(), reader );
            }
        }
        finally
        {
            reader.close();
        }

        analyzer = new StandardAnalyzer();
        writer = new IndexWriter( _directory, analyzer, false );

        //add the docs to index
        try
        {
            for (Iterator it = docs.iterator(); it.hasNext();)
            {
                Document doc = (Document) it.next();
                if (!doc.isRemoved())
                {
                    addDocument( doc, writer );
                }
            }
        }
        finally
        {
            writer.close();
        }
    }
}