/*
 * Created on 02.04.2004
 */
package net.sf.iquiver.admin.panels;



/**
 * @author netseeker
 */
public abstract class AdminPanelBuilder
{   
    public AdminPanel build()
    {
        long buildStart = System.currentTimeMillis();
        AdminPanel panel = buildPanel();        
        panel.setBuidlEnd(System.currentTimeMillis());
        panel.setBuildStart(buildStart);
        
        return panel;
    }
    
    public abstract AdminPanel buildPanel();
}
