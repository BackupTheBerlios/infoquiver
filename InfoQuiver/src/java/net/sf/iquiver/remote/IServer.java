/*
 * Created on 02.07.2004
 */
package net.sf.iquiver.remote;

import net.sf.iquiver.configuration.Configuration;

/**
 * @author netseeker aka Michael Manske
 */
public interface IServer
{
    public void start( Configuration config );
    public void stop();
}
