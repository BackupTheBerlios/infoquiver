/*
 * Created on 20.03.2004
 *
 */
package net.sf.iquiver.service;

/**
 * @author netseeker aka Michael Manske
 */
public interface Excecution
{
    public boolean wasSuccessful();
    public long getStartTime();
    public long getEndTime();
    public String getMessage();
}
