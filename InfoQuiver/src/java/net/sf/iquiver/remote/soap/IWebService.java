/*
 * Created on 02.04.2004
 */
package net.sf.iquiver.remote.soap;



/**
 * @author netseeker aka Michael Manske
 */
public interface IWebService extends IBaseWebService
{
    public String doLogin(String username, String password);
}
