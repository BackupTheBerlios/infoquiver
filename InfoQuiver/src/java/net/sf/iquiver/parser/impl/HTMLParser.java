/*
 * Created on 15.03.2004
 *
 */
package net.sf.iquiver.parser.impl;

import java.io.InputStream;

import net.sf.iquiver.metaformat.Document;
import net.sf.iquiver.parser.Parser;
import net.sf.iquiver.parser.ParsingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author netseeker aka Michael Manske
 */
public class HTMLParser extends Parser
{
    private static final Log logger = LogFactory.getLog(HTMLParser.class);

    /* (non-Javadoc)
     * @see net.sf.iquiver.parser.Parser#parse(java.io.InputStream)
     */
    protected Document parse( InputStream in ) throws ParsingException
    {
        return null;
    }
}
