/*
 * Created on 08.03.2004
 *
 */
package net.sf.iquiver.parser;

import net.sf.iquiver.om.Content;

/**
 * @author netseeker aka Michael Manske
 */
public interface Parser
{
    public Content parse(Object source) throws ParsingException;
    public long getLastParsingTimeExposure();
}
