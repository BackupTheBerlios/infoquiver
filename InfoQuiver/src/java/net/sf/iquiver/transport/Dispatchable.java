/*
 * Created on 06.03.2004
 *
 */
package net.sf.iquiver.transport;

/**
 * @author netseeker aka Michael Manske
 */
public interface Dispatchable
{
    public long getLastDispatchTime();
    public int getDispatcherIdent();
}
