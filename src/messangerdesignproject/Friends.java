package messangerdesignproject;

import Converstion.Chat;
import Converstion.DataBaseOperation;
import Converstion.User;
import Converstion.UserStats;
import core.Defaults;
import core.Instances;
import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Friends extends JScrollPane{
    
    Dimension size;
    Color color;
    
    ArrayList<Friend> friendList;
    
    public Friends(Dimension size, Color color) {
        this.size = size;
        this.color = color;
        
        timer();
    }
    
    int rowPanelHeight = 40;
    int totalHeight = 0;
    
    String otherUniqueID = "";
    String otherUserName = "";
    
    String tableName = "";
    ChatRoomPanel chatRoomPanel;

    Chat chat;

    Timer updateTimer = null;
    int delay = 1500;
    
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

    public void drawScrollPanel(){
        setPreferredSize(size);
        setViewportView(friendListContanirPanel);
    
        intiComponends();
        
    }

    public void intiComponends() {
        
        friendList = DataBaseOperation.getFriendList();
        System.out.println("Friendlist: " +DataBaseOperation.getFriendList().size());
        
        totalHeight = (friendList.size() * rowPanelHeight) + (friendList.size() + 1);

        friendListContanirPanel.setBackground(Color.WHITE);
        friendListContanirPanel.setPreferredSize(new Dimension(size.width - 10, totalHeight));

        for (final Friend friend : friendList) {
            
            if (friend.getStatus().equals("Approved")) {
                JPanel userRowPanel = new JPanel(new GridLayout(1, 1));
                JLabel userNameLbl = new JLabel(Defaults.rescaleIcon(30, 30 ,Defaults.Iconpath("student1", "png")));

//                System.out.println("");
//                System.out.println("FromID: " +friend.getFrom_Request_ID());
//                System.out.println("ToID: " +friend.getTo_Request_ID());
//                System.out.println("FromName: " +friend.getFrom_Username());
//                System.out.println("ToName: " +friend.getTo_Username());
//                System.out.println("FromTitle: " +friend.getFrom_Title());
//                System.out.println("ToTitel: " +friend.getTo_Title());
//                System.out.println("------------------------------------------");

                if (friend.getFrom_Request_ID().equals(UserStats.unique_id)) {
                    userNameLbl.setText(friend.getTo_Username());
                }else if (friend.getTo_Request_ID().equals(UserStats.unique_id)) {
                    userNameLbl.setText(friend.getFrom_Username());
                }

                userNameLbl.setHorizontalAlignment(SwingConstants.LEFT);
                userNameLbl.setForeground(Color.WHITE);

                System.out.println("");
                userRowPanel.setPreferredSize(new Dimension(friendListContanirPanel.getPreferredSize().width, rowPanelHeight));
                userRowPanel.setBackground(color);

                userRowPanel.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        userChatPanel(friend);
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

                friendListContanirPanel.add(userRowPanel);
                userRowPanel.add(userNameLbl);
            }
            
        }        
    }

    JPanel friendListContanirPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5,1));
    
        public void userChatPanel(Friend friend){

            if (friend.getFrom_Request_ID().equals(UserStats.unique_id)) {

                otherUniqueID = friend.getTo_Request_ID();
                otherUserName = friend.getTo_Username();

                if (DataBaseOperation.ifChatTableExists(friend.getTo_Request_ID(), UserStats.unique_id)) {
                    tableName = "chat_" + friend.getTo_Request_ID() + "_" + UserStats.unique_id;
                    System.out.println("TableName: " +tableName);
                    System.out.println("Table already Exists!");
                } else if (DataBaseOperation.ifChatTableExists(UserStats.unique_id, friend.getTo_Request_ID())) {
                    tableName = "chat_" + UserStats.unique_id + "_" + friend.getTo_Request_ID();
                    System.out.println("TableName: " +tableName);
                    System.out.println("Table already Exists!");
                } else {
                    DataBaseOperation.createChatTable(friend.getTo_Request_ID(), UserStats.unique_id);
                    tableName = "chat_" + friend.getTo_Request_ID() + "_" + UserStats.unique_id;
                    System.out.println("TableName: " +tableName);
                }

            }else if (friend.getTo_Request_ID().equals(UserStats.unique_id)) {
                
                otherUniqueID = friend.getFrom_Request_ID();
                otherUserName = friend.getFrom_Username();

                if (DataBaseOperation.ifChatTableExists(friend.getFrom_Request_ID(), UserStats.unique_id)) {
                    tableName = "chat_" + friend.getFrom_Request_ID() + "_" + UserStats.unique_id;
                    System.out.println("Table already Exists!");
                    System.out.println("TableName: " +tableName);
                } else if (DataBaseOperation.ifChatTableExists(UserStats.unique_id, friend.getFrom_Request_ID())) {
                    tableName = "chat_" + UserStats.unique_id + "_" + friend.getFrom_Request_ID();
                    System.out.println("Table already Exists!");
                    System.out.println("TableName: " +tableName);
                } else {
                    DataBaseOperation.createChatTable(friend.getFrom_Request_ID(), UserStats.unique_id);
                    tableName = "chat_" + friend.getFrom_Request_ID() + "_" + UserStats.unique_id;
                    System.out.println("TableName: " +tableName);
                }
                
        }

//        if (DataBaseOperation.ifChatTableExists(user.getUnique_id(), UserStats.unique_id)) {
//            tableName = "chat_" + user.getUnique_id() + "_" + UserStats.unique_id;
//            System.out.println("Table already Exists!");
//        } else if (DataBaseOperation.ifChatTableExists(UserStats.unique_id, user.getUnique_id())) {
//            tableName = "chat_" + UserStats.unique_id + "_" + user.getUnique_id();
//            System.out.println("Table already Exists!");
//        } else {
//            DataBaseOperation.createChatTable(user.getUnique_id(), UserStats.unique_id);
//            tableName = "chat_" + user.getUnique_id() + "_" + UserStats.unique_id;
//        }
        
        // ChatPanel Section:
        chatRoomPanel = new ChatRoomPanel(
                Instances.mainApp.chatSideBar.getWidth(), 
                0, 
                (Instances.mainApp.getWidth() - (Instances.mainApp.chatSideBar.getWidth() + 30)),
                Instances.mainApp.getHeight() - 35
        );
        
        chatRoomPanel.setBackground(Color.WHITE);
        chatRoomPanel.drawPanel();
        chatRoomPanel.userNameLbl.setText("" + otherUserName);

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
                            otherUniqueID, 
                            UserStats.firstName, 
                            sendMessageTxt.getText()
                    );
                    
                    sendMessageTxt.setText("");
                    userChatPanel(friend);
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
