/*
 * Created on 20.03.2004
 *
 */
package net.sf.iquiver.service;

import java.util.EventListener;

/**
 * @author netseeker aka Michael Manske
 */
public interface ServiceExecutionListener extends EventListener
{
    public void executed(ServiceExecutionEvent evt);
}
