/*
 * Created on 01.04.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package net.sf.iquiver.admin.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.sf.iquiver.admin.delegate.UserDelegate;
import net.sf.iquiver.om.User;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

/**
 * @author netseeker
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class LoginPanelBuilder extends AdminPanelBuilder
{
    private JTextField      inp_login;
    private JPasswordField  inp_pwd;
    private JButton         btn_go;
    private JLabel          lbl_msg;

    /* (non-Javadoc)
     * @see net.sf.iquiver.admin.panels.AdminPanelBuilder#buildPanel()
     */
    public void buildPanel(AdminPanel panel)
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
        PanelBuilder builder = new PanelBuilder( panel, layout );
        CellConstraints cc = new CellConstraints();
        
        builder.add(lbl_msg, cc.xywh( 1, 3, 3, 1));
        builder.addSeparator( "Login");
        builder.addLabel( "Username", cc.xy( 1, 3));
        builder.add( inp_login, cc.xy( 3, 3));
        builder.addLabel( "Password", cc.xy( 1, 5));
        builder.add( inp_pwd, cc.xy( 3, 5));
        builder.add( btn_go, cc.xy( 5, 5));
    }
    
    private void displayErrorMessage( String msg )
    {
        lbl_msg.setText(msg);
    }    
}
