/*
 * Created on 02.04.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package net.sf.iquiver.admin.panels;

import java.awt.LayoutManager;

import javax.swing.JPanel;


/**
 * @author netseeker
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class AdminPanel extends JPanel
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

    /**
     * 
     */
    public AdminPanel()
    {
        super();
    }
    
    /**
     * @param arg0
     */
    public AdminPanel(boolean arg0)
    {
        super(arg0);
    }
    
    /**
     * @param arg0
     */
    public AdminPanel(LayoutManager arg0)
    {
        super(arg0);
    }

    /**
     * @param arg0
     * @param arg1
     */
    public AdminPanel(LayoutManager arg0, boolean arg1)
    {
        super(arg0, arg1);
    }
}
