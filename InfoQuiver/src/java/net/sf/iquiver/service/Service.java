/*
 * Created on 18.03.2004
 *
 */
package net.sf.iquiver.service;

import net.sf.iquiver.event.IQEventListener;

import org.apache.avalon.framework.activity.Startable;

/**
 * @author netseeker aka Michael Manske
 */
public interface Service extends Startable
{
    public String getName();
    public void setName(String name);
    public long getStartTime();
    public int getRestartCount();
    public void addServiceStateListener(IQEventListener listener);
    public void removeServiceStateListener(IQEventListener listener);
    public void addServiceExecutionListener(IQEventListener listener);
    public void removeServiceExecutionListener(IQEventListener listener);
    public int getState ();
}
