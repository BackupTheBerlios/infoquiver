/*
 * Created on 01.04.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package net.sf.iquiver.admin.panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import net.sf.iquiver.om.User;
import net.sf.iquiver.om.UserPeer;
import net.sf.iquiver.util.StringUtil;

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
    public AdminPanel buildPanel()
    {
        AdminPanel panel = new AdminPanel();
        LoginListener listener = new LoginListener();
        inp_login = new JTextField();
        inp_login.getDocument().addDocumentListener(listener);
        inp_pwd = new JPasswordField();
        inp_pwd.getDocument().addDocumentListener(listener);
        lbl_msg = new JLabel();
        lbl_msg.setForeground(Color.RED);
        btn_go = new JButton( "login" );
        btn_go.setEnabled( false);
        btn_go.addActionListener( listener );

        FormLayout layout = new FormLayout( "pref, 4dlu, 75dlu, 4dlu, pref", "pref, 2dlu, pref, 2dlu, pref, 2dlu, pref, 2dlu, pref" );
        PanelBuilder builder = new PanelBuilder( panel, layout );
        CellConstraints cc = new CellConstraints();
        
        builder.add(lbl_msg, cc.xywh( 1, 1, 5, 1));
        builder.addSeparator( "Login", cc.xywh( 1, 3, 5, 1));
        builder.addLabel( "Username", cc.xy( 1, 5));
        builder.add( inp_login, cc.xy( 3, 5));
        builder.addLabel( "Password", cc.xy( 1, 7));
        builder.add( inp_pwd, cc.xy( 3, 7));
        builder.add( btn_go, cc.xy( 5, 7));
        
        return panel;               
    }       
       
    private class LoginListener implements DocumentListener, ActionListener
    {                
        /**
         * 
         */
        public LoginListener()
        {
            super();
        }

        /* (non-Javadoc)
         * @see javax.swing.event.DocumentListener#changedUpdate(javax.swing.event.DocumentEvent)
         */
        public void changedUpdate(DocumentEvent evt)
        {
            handleInputEvent(evt);
        }

        /* (non-Javadoc)
         * @see javax.swing.event.DocumentListener#insertUpdate(javax.swing.event.DocumentEvent)
         */
        public void insertUpdate(DocumentEvent evt)
        {
            handleInputEvent(evt);
        }

        /* (non-Javadoc)
         * @see javax.swing.event.DocumentListener#removeUpdate(javax.swing.event.DocumentEvent)
         */
        public void removeUpdate(DocumentEvent evt)
        {
            handleInputEvent(evt);
        }
        
        private void handleInputEvent(DocumentEvent evt)
        {
            String login = StringUtil.defaultIfNull(inp_login.getText(), "");
            String pwd = StringUtil.defaultIfNull(inp_pwd.getText(), "");
            
            btn_go.setEnabled(login.length() > 0 && pwd.length() > 0);
        }

        /* (non-Javadoc)
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        public void actionPerformed(ActionEvent evt)
        {
            User user = UserPeer.doLogin( inp_login.getText(), inp_pwd.getText());
            if ( user != null )
            {
                displayErrorMessage( "Here we go...");
            }
            else
            {
                displayErrorMessage( "Authenification failed. Please try again.");
            }
        }
        
        private void displayErrorMessage( String msg )
        {
            lbl_msg.setText(msg);
        }        
    }
}
