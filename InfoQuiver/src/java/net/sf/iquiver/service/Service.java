/*
 * Created on 18.03.2004
 *
 */
package net.sf.iquiver.service;

import org.apache.avalon.framework.activity.Startable;
import org.apache.avalon.framework.activity.Suspendable;
import org.apache.avalon.framework.service.Serviceable;

/**
 * @author netseeker aka Michael Manske
 */
public interface Service extends Startable, Suspendable
{
    public long getStartTime();
    public int getRestartCount();
    public long getSuccessfulExcecutionsCount();
    public long getFailedExcecutionsCount();
}
