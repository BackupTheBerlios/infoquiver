/*
 * Created on 06.03.2004
 *
 */
package net.sf.iquiver.transport;

/**
 * @author netseeker aka Michael Manske
 */
public interface Fetchable
{
    public long getLastFetchTime();
    public int getFetchIdent();
    public int getContentSourceIdent();
}
