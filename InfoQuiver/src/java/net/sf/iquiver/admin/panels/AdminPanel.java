/*
 * Created on 02.04.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package net.sf.iquiver.admin.panels;

import javax.swing.JPanel;


/**
 * @author netseeker
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public abstract class AdminPanel extends JPanel
{
    private long buildStart;
    private long buidlEnd;
    
    
    /**
     * @return Returns the buidlEnd.
     */
    public long getBuidlEnd()
    {
        return buidlEnd;
    }
    /**
     * @param buidlEnd The buidlEnd to set.
     */
    public void setBuidlEnd(long buidlEnd)
    {
        this.buidlEnd = buidlEnd;
    }
    /**
     * @return Returns the buildStart.
     */
    public long getBuildStart()
    {
        return buildStart;
    }
    /**
     * @param buildStart The buildStart to set.
     */
    public void setBuildStart(long buildStart)
    {
        this.buildStart = buildStart;
    }
}
