/*
 * Created on 23.03.2004
 */
package net.sf.iquiver.admin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import net.sf.iquiver.admin.delegate.UserDelegate;
import net.sf.iquiver.om.User;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.rickyclarkson.java.awt.layout.PercentLayout;

/**
 * @author netseeker aka Michael Manske
 */
public class AdminDesk extends JFrame
{
    private JTextField      inp_login;
    private JPasswordField  inp_pwd;
    private JButton         btn_go;
    private JLabel          lbl_msg;

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
        desk.setTitle( "InfoQuiver Admin Desk");
        desk.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE);

        JComponent panel = desk.buildLoginPanel();
        desk.getContentPane( ).setLayout( new GridBagLayout() );
        desk.getContentPane( ).add( panel );
        desk.setSize( 600, 500);
        desk.setLocationRelativeTo( null);
        desk.show();
    }

    private JComponent buildLoginPanel()
    {
        inp_login = new JTextField();
        inp_pwd = new JPasswordField();
        lbl_msg = new JLabel();
        btn_go = new JButton( "login" );
        btn_go.setEnabled( false);
        btn_go.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent evt )
            {
                User user = UserDelegate.doLogin( inp_login.getText(), inp_pwd.getText());
                if ( user != null )
                {
                    displayErrorMessage( "Here we go...");
                }
                else
                {
                    displayErrorMessage( "Authenification failed. Please try again.");
                }
            }
        });

        FormLayout layout = new FormLayout( "pref, 4dlu, 75dlu, 4dlu, pref", "pref, 2dlu, pref, 2dlu, pref, 2dlu, pref" );
        PanelBuilder builder = new PanelBuilder( layout );
        CellConstraints cc = new CellConstraints();
        
        builder.add(lbl_msg, cc.xywh( 1, 3, 3, 1));
        builder.addSeparator( "Login");
        builder.addLabel( "Username", cc.xy( 1, 3));
        builder.add( inp_login, cc.xy( 3, 3));
        builder.addLabel( "Password", cc.xy( 1, 5));
        builder.add( inp_pwd, cc.xy( 3, 5));
        builder.add( btn_go, cc.xy( 5, 5));

        return builder.getPanel();
    }

    private void displayErrorMessage( String msg )
    {
        lbl_msg.setText(msg);
    }
}
