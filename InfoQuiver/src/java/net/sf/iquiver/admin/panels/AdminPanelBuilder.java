/*
 * Created on 02.04.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package net.sf.iquiver.admin.panels;



/**
 * @author netseeker
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public abstract class AdminPanelBuilder
{   
    public AdminPanel build()
    {
        long buildStart = System.currentTimeMillis();
        AdminPanel panel =  buildPanel();
        panel.setBuidlEnd(System.currentTimeMillis());
        panel.setBuildStart(buildStart);
        
        return panel;
    }
    
    public abstract AdminPanel buildPanel();
}
