/*
 * Created on 02.07.2004
 */
package net.sf.iquiver.remote;

import net.sf.iquiver.configuration.Configurable;

/**
 * @author netseeker aka Michael Manske
 */
public interface IServer extends Configurable
{
    public void start();
    public void stop();
}
