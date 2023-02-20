package messangerdesignproject;

import Converstion.DataBaseOperation;
import static Converstion.DataBaseOperation.isRequestExist;
import Converstion.User;
import Converstion.UserStats;
import core.Defaults;
import java.awt.Color;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class AddFriend extends JScrollPane{
    
    Dimension size;
    Color color;
    
    ArrayList<User> requestList;

    public AddFriend() {
    }
    String query = "SELECT users.UID, users.unique_id, users.Username, users.Firstname, users.Lastname, (SELECT status FROM requests WHERE requests.From_Request_ID = '"+UserStats.unique_id+"' AND users.unique_id = requests.To_Request_ID LIMIT 1) as Status FROM users WHERE unique_id != '"+ UserStats.unique_id +"';";

    public AddFriend(Dimension size, Color color) {
        this.size = size;
        this.color = color;
        
//        String query = "SELECT users.UID, users.unique_id, users.Username, users.Firstname, users.Lastname,"
//                + " (SELECT status FROM requests WHERE requests.From_Request_ID = '"+UserStats.unique_id+"' LIMIT 1) as Status FROM users;";
    }
    
    int rowPanelHeight = 70;
    int totalHeight;
    
    public void drawScrollPanel(){
        setPreferredSize(size);
        setViewportView(addFreindContanirPanel);

        intiComponends();
    }

    public void intiComponends() {
        requestList = DataBaseOperation.getUsers(query, "requests");

        totalHeight = (requestList.size() * rowPanelHeight) + (requestList.size() + 2);
        addFreindContanirPanel.setPreferredSize(new Dimension(size.width - 25, totalHeight));
        
        for (final User user : requestList) {
            
            JPanel requestRowPanel = new JPanel(null);

            requestRowPanel.setPreferredSize(new Dimension(addFreindContanirPanel.getPreferredSize().width , rowPanelHeight));
            requestRowPanel.setBackground(color);
            
            JLabel userImageLbl = new JLabel(Defaults.rescaleIcon(70, 70, Defaults.Iconpath("student1", "png")));
            userImageLbl.setBounds(10, 0, 50, 70);
            
            JLabel userNameLbl = new JLabel(user.getUserName());
            userNameLbl.setBounds(60, - 10, 200, 50);
            userNameLbl.setForeground(Color.WHITE);
            
            // AddFriend Section:
            final JButton addFriendBtn = new JButton("Add Friend");
            
            if (isRequestExist(UserStats.unique_id, user.getUnique_id())) {
                addFriendBtn.setText("Cancel Request");
                addFriendBtn.setBackground(RED);
                addFriendBtn.setForeground(Color.WHITE);
                addFriendBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int result = JOptionPane.showConfirmDialog(null, "are u sure to cancel it ?", "cancel Request", JOptionPane.YES_NO_OPTION);
                        if (result == JOptionPane.YES_OPTION) {
                            DataBaseOperation.cancelRequested(user.getUnique_id());

                            addFreindContanirPanel.removeAll();
                            totalHeight = 0;

                            addFreindContanirPanel.repaint();
                            addFreindContanirPanel.revalidate();
                            repaint();
                            revalidate();
                            intiComponends();    
                        }
                        
                    }
                });
                
            }else if(isRequestExist(user.getUnique_id(), UserStats.unique_id)){
                addFriendBtn.setText("Cancel Request");
                addFriendBtn.setBackground(RED);
                addFriendBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int result = JOptionPane.showConfirmDialog(null, "are u sure to cancel it ?", "cancel Request", JOptionPane.YES_NO_OPTION);
                        if (result == JOptionPane.YES_OPTION) {
                            DataBaseOperation.cancelRequested(user.getUnique_id());

                            addFreindContanirPanel.removeAll();
                            totalHeight = 0;

                            addFreindContanirPanel.repaint();
                            addFreindContanirPanel.revalidate();
                            repaint();
                            revalidate();
                            intiComponends();
                        }
                        
                    }
                });
                
            }else if(DataBaseOperation.isFrind(user.getUnique_id(), UserStats.unique_id)){
                addFriendBtn.setText("Friend");
                addFriendBtn.setBackground(GREEN);
                
                addFriendBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        System.out.println("UserUniqueId: " + user.getUnique_id());
                        System.out.println("CurrentID: " + UserStats.unique_id);
                        
                        int result = JOptionPane.showConfirmDialog(null, "are u sure anFriend it ?", "cancel Request", JOptionPane.YES_NO_OPTION);
                      
                        if (result == JOptionPane.YES_OPTION) {
                            
                            addFreindContanirPanel.removeAll();
                            totalHeight = 0;

                            addFreindContanirPanel.repaint();
                            addFreindContanirPanel.revalidate();
                            repaint();
                            revalidate();
                            intiComponends();
                            
                        }
                        
                    }
                });
            }else if(DataBaseOperation.isFrind(UserStats.unique_id, user.getUnique_id())){
                addFriendBtn.setText("Friend");
                addFriendBtn.setBackground(GREEN);
                
                addFriendBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        System.out.println("CurrentID: " + UserStats.unique_id);
                        System.out.println("UserUniqueId: " + user.getUnique_id());

                        int result = JOptionPane.showConfirmDialog(null, "are u sure anFriend it ?", "cancel Request", JOptionPane.YES_NO_OPTION);
                        if (result == JOptionPane.YES_OPTION) {
                            DataBaseOperation.cancelRequested(user.getUnique_id());

                            addFreindContanirPanel.removeAll();
                            totalHeight = 0;

                            addFreindContanirPanel.repaint();
                            addFreindContanirPanel.revalidate();
                            repaint();
                            revalidate();
                            intiComponends();
                        }

                    }
                });
            }else{
                addFriendBtn.setText("Add Friend");
                addFriendBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        DataBaseOperation.sendRequest(
                            UserStats.userName,
                            user.getUserName(),
                            UserStats.unique_id, 
                            user.getUnique_id(), 
                            UserStats.firstName, 
                            user.getFirstName(), 
                            "Requesting"
                        );
                        
                        addFreindContanirPanel.removeAll();
                        totalHeight = 0;
                        
                        addFreindContanirPanel.repaint();
                        addFreindContanirPanel.revalidate();
                        repaint();
                        revalidate();
                        intiComponends();
                                
                    }
                });
            }
            
//            if (user.getStatus() == null) {
//                addFriendBtn.setText("Add Friend");
//                addFriendBtn.addActionListener(new ActionListener() {
//
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//
//                        String status = "Requesting";
//                        
//                        DataBaseOperation.sendRequest(
//                            UserStats.unique_id, 
//                            user.getUnique_id(), 
//                            UserStats.userName, 
//                            user.getUserName(), 
//                            status
//                        );
//                        
//                        addFreindContanirPanel.removeAll();
//                        totalHeight = 0;
//                        
//                        addFreindContanirPanel.repaint();
//                        addFreindContanirPanel.revalidate();
//                        repaint();
//                        revalidate();
//                        intiComponends();
//                                
//                    }
//                });
//                
//            }else{
//                addFriendBtn.setText(user.getStatus());
//            }
//            addFriendBtn.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//
//                    DataBaseOperation.sendRequest(
//                            UserStats.unique_id, 
//                            user.getUnique_id(), 
//                            UserStats.firstName, 
//                            user.getFirstName(), 
//                            "Requesting"
//                    );
//                    addFriendBtn.setText("Request Sent");
//                }
//            });
//
//            try {
//                String query = "SELECT * FROM requests";
//                Connection myConn = MySQLConnection.getConnection();
//                try {
//                    Statement statement =  myConn.createStatement();
//                    ResultSet resultSet = statement.executeQuery(query);
//                    
//                    if (resultSet.isBeforeFirst()) {
//                        while (resultSet.next()) {
//                            if (resultSet.getString("To_Request_ID").equals(user.getUnique_id())) {
//                                addFriendBtn.setText("Request Sent");
//                                addFriendBtn.addActionListener(null);
//                                addFriendBtn.addActionListener(new ActionListener() {
//                                    @Override
//                                    public void actionPerformed(ActionEvent e) {
//                                        
//                                        try {
//                                            String query1 = "UPDATE requests SET status = 'Cancelled' WHERE "
//                                                    + "To_Request_ID = '"+ user.getUnique_id() +"'"; 
//                                            Connection myConn = MySQLConnection.getConnection();
//                                            try {
//                                                Statement statement = myConn.createStatement();
//                                                statement.executeUpdate(query1);
//                                                addFriendBtn.setText("Add Friend");
//                                            } catch (Exception ex) {
//                                            }
//                                        } catch (Exception ex) {
//                                        }
//                                    }
//                                });
//                            }else{
//                                addFriendBtn.addActionListener(null);
//                                addFriendBtn.setText("Add Friend");
//                                addFriendBtn.addActionListener(new ActionListener() {
//                                    @Override
//                                    public void actionPerformed(ActionEvent e) {
//
//                                        DataBaseOperation.sendRequest(
//                                                UserStats.unique_id, 
//                                                user.getUnique_id(), 
//                                                UserStats.firstName, 
//                                                user.getFirstName(), 
//                                                "Requesting"
//                                        );
//
//                                        addFriendBtn.setText("Request Sent");
//
//                                    }
//                                });
//                            }
//                        }
//                    }
//                } catch (Exception e) {
//                }
//            } catch (Exception e) {
//            }
            
            addFriendBtn.setBounds(userNameLbl.getX() - 5, userNameLbl.getY() + userNameLbl.getHeight() - 10, 175, 35);
            
            // AddFriend Section:

            requestRowPanel.add(userImageLbl);
            requestRowPanel.add(userNameLbl);
            requestRowPanel.add(addFriendBtn);
            addFreindContanirPanel.add(requestRowPanel);
            
        }
        
    }
    
    JPanel addFreindContanirPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 1));
    
}
