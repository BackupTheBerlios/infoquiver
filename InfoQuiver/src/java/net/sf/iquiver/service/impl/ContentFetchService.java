/*
 * Created on 20.03.2004
 *
 */
package net.sf.iquiver.service.impl;

import net.sf.iquiver.service.BaseService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author netseeker aka Michael Manske
 */
public class ContentFetchService extends BaseService
{
    private static final Log logger = LogFactory.getLog(ContentFetchService.class);
    private int restartCount = 0;
    private long startTime;
    
    /**
     * 
     */
    public ContentFetchService()
    {
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.BaseService#start()
     */
    public void start() throws Exception
    {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.BaseService#stop()
     */
    public void stop() throws Exception
    {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.BaseService#getStartTime()
     */
    public long getStartTime()
    {
        return this.startTime;
    }

    /* (non-Javadoc)
     * @see net.sf.iquiver.service.BaseService#getRestartCount()
     */
    public int getRestartCount()
    {
        return restartCount;
    }
}
