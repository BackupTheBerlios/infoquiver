/*
 * Created on 23.03.2004
 */
package net.sf.iquiver.admin;

import java.awt.GridBagLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import net.sf.iquiver.admin.panels.AdminPanelBuilder;
import net.sf.iquiver.admin.panels.LoginPanelBuilder;

/**
 * @author netseeker aka Michael Manske
 */
public class AdminDesk extends JFrame
{
    /**
     * @throws java.awt.HeadlessException
     */
    public AdminDesk() throws HeadlessException
    {
        super("InfoQuiver Admin Desk");
        setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE);
        
        AdminPanelBuilder builder = new LoginPanelBuilder();
        getContentPane( ).setLayout( new GridBagLayout() );
        getContentPane( ).add( builder.build() );        
    }

    
    public static void main( String[] args )
    {
        try
        {
            UIManager.setLookAndFeel( "com.jgoodies.plaf.plastic.PlasticXPLookAndFeel");
        }
        catch ( Exception e )
        {
            // Likely PlasticXP is not in the class path; ignore.
        }

        AdminDesk desk = new AdminDesk();        
        desk.setSize( 600, 500);
        desk.setLocationRelativeTo( null);
        desk.show();
    }
}
