/*
 * Created on 18.03.2004
 *
 */
package net.sf.iquiver.service;

import org.apache.avalon.framework.activity.Startable;

/**
 * @author netseeker aka Michael Manske
 */
public interface Service extends Startable
{
    public long getStartTime();
    public int getRestartCount();
    public void addServiceStateListener(ServiceStateListener listener);
    public void removeServiceStateListener(ServiceStateListener listener);
    public void addServiceExecutionListener(ServiceExecutionListener listener);
    public void removeServiceExecutionListener(ServiceExecutionListener listener);   
}
