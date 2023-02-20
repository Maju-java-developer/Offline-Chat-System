package messangerdesignproject;

import Converstion.DataBaseOperation;
import Converstion.UserStats;
import core.Defaults;
import core.Instances;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginAccount extends JDialog{
        
    Dimension size;
    
    MainApp mainApp;
    
    public LoginAccount(Dimension size) {
        this.size = size;
    }
    
    public void drawFrame(){
        intiComponends();
    }
    
    String secquestionOne[] = {"-- SELECT QUESTION --",
        "Where was your parents first meeting",
        "What was your childhood friends name",
        "What was the name of your primary school"
    };
    
    String secquestionTwo[] = {"-- SELECT QUESTION --",
        "Who is your best friend",
        "What is your dream job",
        "What is your lucky number"
    };
    
    private void intiComponends(){
        setTitle("Login your account:");
        setSize(size.width, size.height);
        setLayout(new GridLayout(1, 1));
        setLocationRelativeTo(null);
                
        // -----------------------------------
        // ---- Login Account Seciton: ----
        // -----------------------------------
        userNameLbl.setBounds(50, 100, 100, 50);
        userNameTxt.setBounds(150, 110, 250, 30);
        
        passwordLbl.setBounds(50, 150, 100, 50);
        passwordTxt.setBounds(150, 160, 250, 30);
        
        forgetPasswordLbl.setBounds(200, 230, 200, 30);
        forgetPasswordLbl.setForeground(Color.red);
        forgetPasswordLbl.setVisible(false);
        // END LOGIN SECTION:
        
        // -----------------------------------
        // ---- Forget Password Seciton: ----
        // -----------------------------------
        forgetPasswordLbl.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                forgetPasswordDialog();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        // END Password Seciton: 

        // -----------------------------------
        // ---- Create New Account Seciton: ----
        // -----------------------------------

        createNewAccountLbl.setBounds(170, 270, 250, 40);
        createNewAccountLbl.setFont(new Font("Souge UI Light", 0, 15));
        createNewAccountLbl.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                createNewAccount();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        // -----------------------------------
        // ---- END: ----
        // -----------------------------------
        
        mainPanel.add(createNewAccountLbl);
        mainPanel.add(userNameLbl);
        mainPanel.add(passwordLbl);
        mainPanel.add(userNameTxt);
        mainPanel.add(passwordTxt);
        mainPanel.add(forgetPasswordLbl);
        mainPanel.add(loginBtn);
        add(mainPanel);
        
    }
   
    JPanel mainPanel = new JPanel(null);
    
    JLabel userNameLbl = new JLabel("UserName:");
    JLabel passwordLbl = new JLabel("Password:");
    
    JTextField userNameTxt = new JTextField();
    JTextField passwordTxt = new JTextField();
    
    JButton loginBtn = new JButton("Login");
    JLabel createNewAccountLbl = new JLabel("don't have account click here!");
    
    JLabel forgetPasswordLbl = new JLabel("Forget Password?!");
    
    public void createNewAccount(){
        JDialog createNewAccountDialog = new JDialog();

        createNewAccountDialog.setTitle("Create New Account:");
        createNewAccountDialog.setSize(720, 480);
        createNewAccountDialog.setLayout(null);
        createNewAccountDialog.setLocationRelativeTo(null);
        createNewAccountDialog.setVisible(true);

        JLabel chooseSecQuestionLbl = new JLabel("Choose Securety Question:");
        JComboBox secQuestionOneBox = new JComboBox(secquestionOne);
        JComboBox secQuestionTwoBox = new JComboBox(secquestionTwo);

        JLabel firstnameLbl = new JLabel("First Name:");
        JTextField firstnameTxt = new JTextField();

        JLabel lastnameLbl = new JLabel("Last Name");
        JTextField lastnameTxt = new JTextField();

        JLabel passwordLbl = new JLabel("Password:");
        JTextField passwordTxt = new JTextField();

        JLabel resetPasswordLbl = new JLabel("Reset:");
        JTextField resetPasswordTxt = new JTextField();
        
        JLabel friendLbl = new JLabel("Friend:");
        JTextField secQuestionOneTxt = new JTextField();
        
        JLabel parentMeetLbl = new JLabel("Parent Meet:");
        JTextField secQuestionTwoTxt = new JTextField();
        
        JButton saveBtn = new JButton("Save");
        
        firstnameLbl.setBounds(50, 50, 200, 50);
        firstnameTxt.setBounds(150, 60, 250, 30);

        lastnameLbl.setBounds(50, 100, 200, 50);
        lastnameTxt.setBounds(150, 110, 250, 30);

        passwordLbl.setBounds(50, 150, 200, 50);
        passwordTxt.setBounds(150, 160, 250, 30);

        resetPasswordLbl.setBounds(50, 200, 200, 50);
        resetPasswordTxt.setBounds(150, 210, 250, 30);
        
        chooseSecQuestionLbl.setBounds(450, 20, 200, 30);

        secQuestionOneBox.setBounds(420, 60, 250, 30);
        secQuestionOneTxt.setBounds(420, 110, 250, 30);

        secQuestionTwoBox.setBounds(420, 160, 250, 30);
        secQuestionTwoTxt.setBounds(420, 210, 250, 30);

        saveBtn.setBounds(150, 260, 250, 30);
        saveBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                String firstNameStr = firstnameTxt.getText();
                String lastNameStr = lastnameTxt.getText();
                String passwordStr = passwordTxt.getText();
                String resetPasswordStr = resetPasswordTxt.getText();
                String questionOneStr = secQuestionOneBox.getSelectedItem().toString();
                String answerOneStr = secQuestionOneTxt.getText();
                String questionTwoStr = secQuestionTwoBox.getSelectedItem().toString();
                String answerTwoStr = secQuestionTwoTxt.getText();
                
                if (firstNameStr.equals("")) {
                    JOptionPane.showMessageDialog(null, "Type First Name First!");
                }else if (lastNameStr.equals("")){
                    JOptionPane.showMessageDialog(null, "Type Last Name First!");
                }else if (passwordStr.equals("")){
                    JOptionPane.showMessageDialog(null, "Type password First!");
                }else if (resetPasswordStr.equals("")) {
                    JOptionPane.showMessageDialog(null, "Write your password that you entered!");
                }else if (questionOneStr.equals("-- SELECT QUESTION --")) {
                    JOptionPane.showMessageDialog(null, "Choose Any One Question!");
                }else if (answerOneStr.equals("")) {
                    JOptionPane.showMessageDialog(null, "Write Answer First!");
                }else if (questionTwoStr.equals("-- SELECT QUESTION --")) {
                    JOptionPane.showMessageDialog(null, "Choose Any One Questio!");
                }else if (answerTwoStr.equals("")) {
                    JOptionPane.showMessageDialog(null, "Write Answer First!");
                }
                else {
                    if (passwordStr.equals(resetPasswordStr)) {
                        DataBaseOperation.InsertUserRecord(
                                firstNameStr, 
                                lastNameStr,
                                passwordStr, 
                                questionOneStr, 
                                questionTwoStr, 
                                answerOneStr, 
                                answerTwoStr
                        );
                        createNewAccountDialog.dispose();

                    }else {
                        JOptionPane.showMessageDialog(null, "type Right password that u entered!");
                    }
                }
                
            }
        });
        
        createNewAccountDialog.add(firstnameLbl);
        createNewAccountDialog.add(lastnameLbl);
        createNewAccountDialog.add(passwordLbl);
        createNewAccountDialog.add(resetPasswordLbl);
        createNewAccountDialog.add(friendLbl);
        createNewAccountDialog.add(parentMeetLbl);
        createNewAccountDialog.add(firstnameTxt);
        createNewAccountDialog.add(lastnameTxt);
        createNewAccountDialog.add(passwordTxt);
        createNewAccountDialog.add(resetPasswordTxt);
        createNewAccountDialog.add(secQuestionOneTxt);
        createNewAccountDialog.add(secQuestionTwoTxt);
        createNewAccountDialog.add(chooseSecQuestionLbl);
        createNewAccountDialog.add(secQuestionOneBox);
        createNewAccountDialog.add(secQuestionTwoBox);
        createNewAccountDialog.add(saveBtn);
    }
    
    public void forgetPasswordDialog(){
        
        JDialog accountVerifyDialog = new JDialog();
        
        accountVerifyDialog.setTitle("Account Verify");
        accountVerifyDialog.setSize(600, 450);
        accountVerifyDialog.setLayout(null);
        accountVerifyDialog.setLocationRelativeTo(null);
        accountVerifyDialog.setVisible(true);
    
        JLabel userNameLbl = new JLabel("UserName:");
        JTextField userNameTxt = new JTextField();
        
        JLabel chooseQuestionLbl = new JLabel("CHOOSE QUESTION:");
        
        JComboBox secQuestionOneBox = new JComboBox(secquestionOne);
        JTextField secQuestionOneTxt = new JTextField();
        
        JComboBox secQuestionTwoBox = new JComboBox(secquestionTwo);
        JTextField secQuestionTwoTxt = new JTextField();

        JButton verifyAccountBtn = new JButton("Verify");
        
        userNameLbl.setBounds(170, 20, 150, 50);
        userNameTxt.setBounds(170, 60, 250, 30);
        
        chooseQuestionLbl.setBounds(190, 90, 150, 30);
        
        secQuestionOneBox.setBounds(170, 130, 250, 30);
        secQuestionOneTxt.setBounds(170, 170, 250, 30);
        
        secQuestionTwoBox.setBounds(170, 210, 250, 30);
        secQuestionTwoTxt.setBounds(170, 250, 250, 30);
        
        verifyAccountBtn.setBounds(170, 290, 250, 30);
        verifyAccountBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                String userNameStr = userNameTxt.getText();
                String questionOneStr = secQuestionOneBox.getSelectedItem().toString();
                String answerOneStr = secQuestionOneTxt.getText();
                String questionTwoStr = secQuestionTwoBox.getSelectedItem().toString();
                String answerTwoStr = secQuestionTwoTxt.getText();
                
                if (DataBaseOperation.verifyUserAccount(
                        userNameStr, 
                        questionOneStr, 
                        questionTwoStr, 
                        answerOneStr, 
                        answerTwoStr)) {
                    JOptionPane.showMessageDialog(null, "Your Account is verifying!");
                    
                    String userUniqueID = DataBaseOperation.getUserUniqueID(
                            userNameStr,
                            questionOneStr,
                            questionTwoStr, 
                            answerOneStr,
                            answerTwoStr
                    );
                    
                    System.out.println("UserUniqueID:" + userUniqueID);
                    
                    updateRecordDialog(userUniqueID, userNameStr);
                    accountVerifyDialog.dispose();
                    
                }else {
                    JOptionPane.showMessageDialog(null, "UnMatch User Question With Answer!");
                }
                
            }
        });
        
        accountVerifyDialog.add(userNameLbl);
        accountVerifyDialog.add(userNameTxt);
        accountVerifyDialog.add(chooseQuestionLbl);
        accountVerifyDialog.add(secQuestionOneBox);
        accountVerifyDialog.add(secQuestionOneTxt);
        accountVerifyDialog.add(secQuestionTwoTxt);
        accountVerifyDialog.add(secQuestionTwoBox);
        accountVerifyDialog.add(verifyAccountBtn);
        
    }
    
    private void updateRecordDialog(String getUserUniqueID ,String userName){
        
        JDialog updatePasswordJdialog = new JDialog();
        
        updatePasswordJdialog.setTitle("Update Password:");
        updatePasswordJdialog.setSize(400, 300);
        updatePasswordJdialog.setLayout(null);
        updatePasswordJdialog.setLocationRelativeTo(null);
        updatePasswordJdialog.setVisible(true);
        
        JLabel newPasswordLbl = new JLabel("Password:");
        JTextField newPasswordTxt = new JTextField();
        
        JLabel resetPasswordLbl = new JLabel("Reset:");
        JTextField resetPasswordTxt = new JTextField();

        JButton updateBtn = new JButton("Update");
        
        newPasswordLbl.setBounds(50, 30, 120, 50);
        newPasswordTxt.setBounds(120, 40, 250, 30);
        
        resetPasswordLbl.setBounds(50, 80, 120, 50);
        resetPasswordTxt.setBounds(120, 90, 250, 30);
        
        System.out.println("ID:" + getUserUniqueID);
        System.out.println("UserName:" + userName);
        
        updateBtn.setBounds(120, 130, 150, 30);
        updateBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                String newPasswordStr = newPasswordTxt.getText();
                String resetPasswordStr = resetPasswordTxt.getText();
                
                if (newPasswordStr.equals(resetPasswordStr)) {
                    DataBaseOperation.updateUserPassword(getUserUniqueID, userName, newPasswordStr);
                    updatePasswordJdialog.dispose();
                }else {
                    JOptionPane.showMessageDialog(null, "Recheck your password!");
                }
            }
        });
        
        updatePasswordJdialog.add(newPasswordLbl);
        updatePasswordJdialog.add(newPasswordTxt);
        updatePasswordJdialog.add(resetPasswordLbl);
        updatePasswordJdialog.add(resetPasswordTxt);
        updatePasswordJdialog.add(updateBtn);
    }
}
