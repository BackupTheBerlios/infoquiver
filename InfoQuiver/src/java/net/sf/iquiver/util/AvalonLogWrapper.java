/*********************************************************************
 * AvalonLogWrapper.java
 * created on 24.10.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/util/AvalonLogWrapper.java,v $
 * $Date: 2004/10/24 16:28:38 $
 * $Revision: 1.1 $
*********************************************************************/

package net.sf.iquiver.util;

import org.apache.avalon.framework.logger.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author netseeker aka Michael Manske
 */
public class AvalonLogWrapper implements Logger
{
    Log logger;
    
    /**
     * @param logger
     */
    public AvalonLogWrapper( Log logger )
    {
        this.logger = logger;
    }
    
    /* (non-Javadoc)
     * @see org.apache.avalon.framework.logger.Logger#debug(java.lang.String)
     */
    public void debug( String arg0 )
    {
        logger.debug( arg0 );
    }

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.logger.Logger#debug(java.lang.String, java.lang.Throwable)
     */
    public void debug( String arg0, Throwable arg1 )
    {
        logger.debug( arg0, arg1 );

    }

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.logger.Logger#isDebugEnabled()
     */
    public boolean isDebugEnabled()
    {
        return logger.isDebugEnabled();
    }

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.logger.Logger#info(java.lang.String)
     */
    public void info( String arg0 )
    {
        logger.info( arg0 );
    }

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.logger.Logger#info(java.lang.String, java.lang.Throwable)
     */
    public void info( String arg0, Throwable arg1 )
    {
        logger.info( arg0, arg1 );
    }

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.logger.Logger#isInfoEnabled()
     */
    public boolean isInfoEnabled()
    {
        return logger.isInfoEnabled();
    }

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.logger.Logger#warn(java.lang.String)
     */
    public void warn( String arg0 )
    {
        logger.warn( arg0 );
    }

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.logger.Logger#warn(java.lang.String, java.lang.Throwable)
     */
    public void warn( String arg0, Throwable arg1 )
    {
        logger.warn( arg0, arg1 );
    }

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.logger.Logger#isWarnEnabled()
     */
    public boolean isWarnEnabled()
    {
        return logger.isWarnEnabled();
    }

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.logger.Logger#error(java.lang.String)
     */
    public void error( String arg0 )
    {       
        logger.error( arg0 );
    }

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.logger.Logger#error(java.lang.String, java.lang.Throwable)
     */
    public void error( String arg0, Throwable arg1 )
    {
        logger.error( arg0, arg1 );
    }

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.logger.Logger#isErrorEnabled()
     */
    public boolean isErrorEnabled()
    {
        return logger.isErrorEnabled();
    }

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.logger.Logger#fatalError(java.lang.String)
     */
    public void fatalError( String arg0 )
    {
        logger.fatal( arg0 );
    }

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.logger.Logger#fatalError(java.lang.String, java.lang.Throwable)
     */
    public void fatalError( String arg0, Throwable arg1 )
    {
        logger.fatal( arg0, arg1 );
    }

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.logger.Logger#isFatalErrorEnabled()
     */
    public boolean isFatalErrorEnabled()
    {
        return logger.isFatalEnabled();
    }

    /* (non-Javadoc)
     * @see org.apache.avalon.framework.logger.Logger#getChildLogger(java.lang.String)
     */
    public Logger getChildLogger( String arg0 )
    {        
        return new AvalonLogWrapper( LogFactory.getLog( arg0 ) );
    }

}
