/*
 * Created on 08.03.2004
 *
 */
package net.sf.iquiver.parser;

import java.text.ParseException;

/**
 * @author netseeker aka Michael Manske
 */
public class ParsingException extends ParseException
{
    int errorOffsetEnd;
    int errorLine;
    
    /**
     * @param s
     * @param errorOffset
     */
    public ParsingException( String s, int errorOffset )
    {
        super( s, errorOffset );
    }
    
    /**
     * @param s
     * @param errorOffset
     */
    public ParsingException( String s, int errorOffsetStart, int errorOffsetEnd )
    {
        this( s, errorOffsetStart );
        this.errorOffsetEnd = errorOffsetEnd;
    }
    
    /**
     * @param s
     * @param errorOffset
     */
    public ParsingException( String s, int errorOffsetStart, int errorOffsetEnd, int line )
    {
        this( s, errorOffsetStart, errorOffsetEnd );
        this.errorLine = line;
    }    

    /**
     * @return Returns the errorLine.
     */
    public int getErrorLine()
    {
        return this.errorLine;
    }
    /**
     * @return Returns the errorOffsetEnd.
     */
    public int getErrorOffsetEnd()
    {
        return this.errorOffsetEnd;
    }    
}
