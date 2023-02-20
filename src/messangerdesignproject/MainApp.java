package messangerdesignproject;

import Converstion.DataBaseOperation;
import Converstion.UserStats;
import core.Defaults;
import core.Instances;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainApp extends JFrame{
    public MainApp(){
        
        Instances.mainApp = this;
        
        loginPagel = new LoginAccount(new Dimension(500, 400));
        loginPagel.drawFrame();
        loginPagel.setVisible(true);
        
        loginPagel.loginBtn.setBounds(150, 200, 250, 30);
        loginPagel.loginBtn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (DataBaseOperation.isLogin(loginPagel.userNameTxt.getText(), loginPagel.passwordTxt.getText())) {
                    JOptionPane.showMessageDialog(null, "Most Welcome Dear " +loginPagel.userNameTxt.getText());
                    setVisible(true);
                    intiComponends();
                    loginPagel.setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null, "Something went Wrong Dear " + loginPagel.userNameTxt.getText());
                    loginPagel.forgetPasswordLbl.setVisible(true);
                }
            }
            
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void intiComponends(){
        setTitle("Active: " +UserStats.userName);
        setSize(750, 570);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
                
//        DataBaseOperation.freindsList();
        
        mainPanel.setBackground(Color.WHITE);
        
        chatSideBar = new chatSideBar(0, 0, 270, getHeight() - 35);
        chatSideBar.setBackground(new Color(116, 111, 195));
        chatSideBar.drawPanel();
        
        mainPanel.add(chatSideBar);
        add(mainPanel);
    }
    
    public LoginAccount loginPagel;
    
    JPanel mainPanel = new JPanel(null);
    chatSideBar chatSideBar;
    
    public static void main(String[] args) {
    
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        new MainApp().setVisible(false);
    }
    
}
