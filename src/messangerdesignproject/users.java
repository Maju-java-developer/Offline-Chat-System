package messangerdesignproject;

import Converstion.Chat;
import Converstion.DataBaseOperation;
import Converstion.User;
import Converstion.UserStats;
import core.Defaults;
import core.Instances;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class users extends JScrollPane{
    
    Dimension size;
    Color color;

    ArrayList<User> userList;
    
    int userContanirHeight;
    int rowPanelHeight = 40;

    String tableName = "";
    ChatRoomPanel chatRoomPanel;

    Chat chat;
    
    Timer updateTimer = null;
    int delay = 1500;
    String query;

    public users(){}
    public users(Dimension size , Color color) {
        this.size = size;
        this.color = color;
        
        query = ""
                + "SELECT\n" +
"	users.UID, users.unique_id, users.Username,\n" +
"    users.Firstname, users.Lastname,\n" +
"    (SELECT Status FROM requests WHERE\n" +
"     requests.From_Request_ID = '"+ UserStats.unique_id +"'"
                + " AND users.unique_id = requests.To_Request_ID "
                + "OR users.unique_id = requests.From_Request_ID LIMIT 1) as Status FROM users"
                + " WHERE unique_id != '"+ UserStats.unique_id +"';"
                + "";

//        query = ""
//                + "SELECT " +
//"	users.UID, users.unique_id, users.Username, " +
//"    users.Firstname, users.Lastname, " +
//"    (SELECT Status FROM requests WHERE " +
//"     requests.From_Request_ID = '"+UserStats.unique_id+"'"
//                + " OR requests.To_Request_ID = '"+UserStats.unique_id+"' "
//                + "AND users.unique_id = requests.To_Request_ID "
//                + "OR users.unique_id = requests.From_Request_ID LIMIT 1) as Status"
//                + " FROM users WHERE unique_id != '"+UserStats.unique_id+"';"
//                + "";
//        query = "SELECT users.UID, users.unique_id, users.Username, users.Firstname, users.Lastname, (SELECT Status FROM requests WHERE requests.From_Request_ID = '" + UserStats.unique_id + "' AND users.unique_id = requests.To_Request_ID LIMIT 1) as Status FROM users WHERE unique_id != '"+ UserStats.unique_id +"';";
        
//        if (DataBaseOperation.isRequestFromApproved(UserStats.unique_id)) {
//            query = "SELECT users.UID, users.unique_id, users.Username, users.Firstname, users.Lastname, (SELECT status FROM requests WHERE requests.From_Request_ID = '"+UserStats.unique_id+"' AND users.unique_id = requests.To_Request_ID LIMIT 1) as Status FROM users WHERE unique_id != '"+ UserStats.unique_id +"';";
//        }else if(DataBaseOperation.isRequestToApproved(UserStats.unique_id)){
//            query = "SELECT users.UID, users.unique_id, users.Username, users.Firstname, users.Lastname, (SELECT status FROM requests WHERE requests.From_Request_ID = '"+UserStats.unique_id+"' AND users.unique_id = requests.To_Request_ID LIMIT 1) as Status FROM users WHERE unique_id != '"+ UserStats.unique_id +"';";
//        }
//        String query = "SELECT * FROM users WHERE unique_id != '"+ UserStats.unique_id +"'";
        
        timer();
    }
    
    public void timer(){
        updateTimer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (chatRoomPanel != null) {
                    
                    chatRoomPanel.remove(2);
                    chat = new Chat(
                        0,
                        chatRoomPanel.ChatRoomHeaderPanel.getHeight(),
                        chatRoomPanel.width,
                        (chatRoomPanel.height - chatRoomPanel.ChatRoomHeaderPanel.getHeight() - 50),
                        tableName
                    );
                    
                    chat.setName("Chat");
                    chat.drawScrollPanel();

                    chatRoomPanel.add(chat);

                    chatRoomPanel.repaint();
                    chatRoomPanel.validate();
                }
                
            }
        });
        updateTimer.start();

    }
    
    public void drawUserPanel(){
        setPreferredSize(new Dimension(size));
        setViewportView(userContanriPanel);
    
        intiComponends();
    }
    
    public void intiComponends(){
        userList = DataBaseOperation.getUsers(query, "users");
    
        System.out.println("Size:" + userList.size());

        userContanirHeight = (userList.size() * rowPanelHeight) + (userList.size() + 1);

        userContanriPanel.setBackground(Color.WHITE);
        userContanriPanel.setPreferredSize(new Dimension(size.width - 10, userContanirHeight));
        
        for (User user : userList) {
            System.out.println("UserList: " +user.getUserName());
            
            if (DataBaseOperation.isRequestFromApproved(UserStats.unique_id)) {
                if (user.getStatus() != null && user.getStatus().equals("Approved")) {
                    JPanel userRowPanel = new JPanel(new GridLayout(1, 1));
                    userRowPanel.setPreferredSize(new Dimension(userContanriPanel.getPreferredSize().width, rowPanelHeight));
                    userRowPanel.setBackground(color);

                    JLabel userNameLbl = new JLabel(Defaults.rescaleIcon(30, 30 ,Defaults.Iconpath("student1", "png")));

                    userNameLbl.setHorizontalAlignment(SwingConstants.LEFT);
                    userNameLbl.setText(""+user.getUserName());
                    userNameLbl.setForeground(Color.WHITE);

                    System.out.println("UniqueID:  " +user.getUnique_id());

                    userRowPanel.addMouseListener(new MouseListener() {

                        @Override
                        public void mouseClicked(MouseEvent e) {
                            userChatPanel(user);
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
                    userRowPanel.add(userNameLbl);
                    userContanriPanel.add(userRowPanel);
                }
            } else if(DataBaseOperation.isRequestToApproved(UserStats.unique_id)){
                if (user.getStatus() != null && user.getStatus().equals("Approved")) {
                    JPanel userRowPanel = new JPanel(new GridLayout(1, 1));
                    userRowPanel.setPreferredSize(new Dimension(userContanriPanel.getPreferredSize().width, rowPanelHeight));
                    userRowPanel.setBackground(color);

                    JLabel userNameLbl = new JLabel(Defaults.rescaleIcon(30, 30 ,Defaults.Iconpath("student1", "png")));

                    userNameLbl.setHorizontalAlignment(SwingConstants.LEFT);
                    userNameLbl.setText(""+user.getUserName());
                    userNameLbl.setForeground(Color.WHITE);

                    userRowPanel.addMouseListener(new MouseListener() {

                        @Override
                        public void mouseClicked(MouseEvent e) {
                            userChatPanel(user);
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
                    userRowPanel.add(userNameLbl);
                    userContanriPanel.add(userRowPanel);
                }
            }
            
//            else{
//                JOptionPane.showMessageDialog(null, "Not Exists");

//                JPanel userRowPanel = new JPanel(new GridLayout(1, 1));
//                userRowPanel.setPreferredSize(new Dimension(userContanriPanel.getPreferredSize().width, rowPanelHeight));
//                userRowPanel.setBackground(color);
//
//                JLabel userNameLbl = new JLabel(Defaults.rescaleIcon(30, 30 ,Defaults.Iconpath("student1", "png")));
//
//                userNameLbl.setHorizontalAlignment(SwingConstants.LEFT);
//                userNameLbl.setText(""+user.getUserName());
//                userNameLbl.setForeground(Color.WHITE);
//
//                userRowPanel.addMouseListener(new MouseListener() {
//
//                    @Override
//                    public void mouseClicked(MouseEvent e) {
//                        userChatPanel(user);
//                    }
//
//                    @Override
//                    public void mousePressed(MouseEvent e) {
//                    }
//
//                    @Override
//                    public void mouseReleased(MouseEvent e) {
//                    }
//
//                    @Override
//                    public void mouseEntered(MouseEvent e) {
//                    }
//
//                    @Override
//                    public void mouseExited(MouseEvent e) {
//                    }
//                });
//                userRowPanel.add(userNameLbl);
//                userContanriPanel.add(userRowPanel);
//            }
            
        }
    }
    
    JPanel userContanriPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5,1));
    
    public void userChatPanel(User user){
        if (DataBaseOperation.ifChatTableExists(user.getUnique_id(), UserStats.unique_id)) {
            tableName = "chat_" + user.getUnique_id() + "_" + UserStats.unique_id;
            System.out.println("Table already Exists!");
        } else if (DataBaseOperation.ifChatTableExists(UserStats.unique_id, user.getUnique_id())) {
            tableName = "chat_" + UserStats.unique_id + "_" + user.getUnique_id();
            System.out.println("Table already Exists!");
        } else {
            DataBaseOperation.createChatTable(user.getUnique_id(), UserStats.unique_id);
            tableName = "chat_" + user.getUnique_id() + "_" + UserStats.unique_id;
        }
        
        // ChatPanel Section:
        chatRoomPanel = new ChatRoomPanel(
                Instances.mainApp.chatSideBar.getWidth(), 
                0, 
                (Instances.mainApp.getWidth() - (Instances.mainApp.chatSideBar.getWidth() + 30)),
                Instances.mainApp.getHeight() - 35
        );

        chatRoomPanel.setBackground(Color.WHITE);
        chatRoomPanel.drawPanel();
        chatRoomPanel.userNameLbl.setText("" + user.getUserName());

        chat = new Chat(
                0, 
                chatRoomPanel.ChatRoomHeaderPanel.getHeight(),
                chatRoomPanel.width,
                (chatRoomPanel.height - chatRoomPanel.ChatRoomHeaderPanel.getHeight() - 50),
                tableName
        );
        chat.setName("Chat");
        chat.drawScrollPanel();

        chatRoomPanel.repaint();
        chatRoomPanel.validate();

        if (Instances.mainApp.mainPanel.getComponentCount() > 1) {
            Instances.mainApp.mainPanel.remove(1);
        }
        // ChatPanel Section:

        // SendMessagePanel Section:
        JPanel sendMessagesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        sendMessagesPanel.setName("SendMessagePanel");

        JLabel imageLbl = new JLabel(Defaults.rescaleIcon(20, 20, Defaults.Iconpath("image", "png")));
        JLabel emojiIcon = new JLabel(Defaults.rescaleIcon(20, 20, Defaults.Iconpath("emoji", "png")));
        JLabel shareIcon = new JLabel(Defaults.rescaleIcon(20, 20, Defaults.Iconpath("share", "png")));

        JTextField sendMessageTxt = new JTextField();
        JLabel sendMessageTxtLbl = new JLabel("Type a message and Emoji");

        sendMessagesPanel.setBounds(0, chatRoomPanel.getHeight()- 50, chatRoomPanel.getWidth(), 50);
        sendMessagesPanel.setBackground(chatRoomPanel.getBackground());

        imageLbl.setPreferredSize(new Dimension(50, sendMessagesPanel.getHeight()));
        
        sendMessageTxt.setPreferredSize(new Dimension(280, 30));
        emojiIcon.setPreferredSize(new Dimension(50, sendMessagesPanel.getHeight()));
        shareIcon.setPreferredSize(new Dimension(50, sendMessagesPanel.getHeight()));

        sendMessageTxtLbl.setBounds(5, 0, 300, 30);
        sendMessageTxtLbl.setEnabled(false);
        sendMessageTxt.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (sendMessageTxt.getText().isEmpty()) {
                    sendMessageTxtLbl.setVisible(true);
                }else {
                    sendMessageTxtLbl.setVisible(false);
                }
                
                if (!sendMessageTxt.getText().equals("") && e.getKeyCode() == KeyEvent.VK_ENTER) {
                    DataBaseOperation.insertChat(
                            tableName, 
                            UserStats.unique_id, 
                            user.getUnique_id(), 
                            UserStats.firstName, 
                            sendMessageTxt.getText()
                    );
                    
                    sendMessageTxt.setText("");
                    userChatPanel(user);
                }
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (sendMessageTxt.getText().isEmpty()) {
                    sendMessageTxtLbl.setVisible(true);
                }else {
                    sendMessageTxtLbl.setVisible(false);
                }
            }
        });

        imageLbl.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                
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
        
        sendMessagesPanel.repaint();
        sendMessagesPanel.revalidate();

        sendMessagesPanel.add(imageLbl);
        sendMessagesPanel.add(sendMessageTxt);
        sendMessagesPanel.add(emojiIcon);
        sendMessagesPanel.add(shareIcon);
        sendMessageTxt.add(sendMessageTxtLbl);

        chatRoomPanel.add(sendMessagesPanel);
        // SendMessagePanel Section:
        chatRoomPanel.add(chat);

        Instances.mainApp.mainPanel.add(chatRoomPanel);
        Instances.mainApp.mainPanel.repaint();
        Instances.mainApp.mainPanel.revalidate();
    }
    
}

