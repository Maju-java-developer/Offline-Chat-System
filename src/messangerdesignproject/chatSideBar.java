package messangerdesignproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import core.Defaults;
import core.Instances;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class chatSideBar extends JPanel{
    
    int posX, posY, width, heigth;

    int iconSizeX = 25, iconSizeY = 25;
    
    public chatSideBar() {}
    public chatSideBar(int posX, int posY, int width, int heigth) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.heigth = heigth;
    }
    
    public void drawPanel(){
        intiComponends();
    }
    
    public void intiComponends(){
        setBounds(posX, posY, width, heigth);
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 1));

        // Upper Panel Section:
        dotPanel.setPreferredSize(new Dimension(width, 25));
        dotPanel.setBackground(getBackground());
        
        for (int i = 0; i < dotsIcon.length; i++) {
            dotsIcon[i] = new JLabel(Defaults.rescaleIcon(15, 15, Defaults.Iconpath(dotSpath[i], "png")));
            dotPanel.add(dotsIcon[i]);
        }

        add(dotPanel);
        // Upper Panel Section:

        // Main Function Panel Section:
        mainFunctionPanel.setPreferredSize(new Dimension(width, 40));
        mainFunctionPanel.setBackground(getBackground());
        
        mainFunctionPanel.add(chattingLbl);
        mainFunctionPanel.add(addFriendLbl);
        mainFunctionPanel.add(requestListLbl);
        mainFunctionPanel.add(settingLbl);
        
        add(mainFunctionPanel);
        // Main Function Panel Section:
        
        // User Search Section:
        userSearchPanel.setPreferredSize(new Dimension(width, 40));
        userSearchPanel.setBackground(getBackground());
        
        userSearchLbl.setBounds(width / 3, 0, 100, 30);
        userSearchLbl.setIcon(Defaults.rescaleIcon(20, 20, Defaults.Iconpath("searchBlack", "png")));
        userSearchLbl.setEnabled(false);
        
        userSearchTxt.setBackground(getBackground());
        userSearchTxt.setForeground(Color.WHITE);
        userSearchTxt.setBounds(20, 5, width - 40, 30);
        userSearchTxt.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                if(userSearchTxt.getText().isEmpty()) {
                    userSearchLbl.setVisible(true);
                }else {
                    userSearchLbl.setVisible(false);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (userSearchTxt.getText().isEmpty()) {
                    userSearchLbl.setVisible(true);
                }else {
                    userSearchLbl.setVisible(false);
                }
            }
        });
        userSearchPanel.add(userSearchTxt);
        userSearchTxt.add(userSearchLbl);
        add(userSearchPanel);
        // User Search Section:
        
        // User Section:
        users = new users(new Dimension(width - 10, heigth - 110) , getBackground());
        users.drawUserPanel();
//        add(users);
        // User Section:
        
        // Chating Section:
        friends = new Friends(new Dimension(width - 10, heigth - 110), getBackground());
        friends.drawScrollPanel();
        add(friends);
        
        chattingLbl.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

                friends.friendListContanirPanel.removeAll();
                friends.friendListContanirPanel.repaint();
                friends.friendListContanirPanel.revalidate();
                friends.totalHeight = 0;

                remove(addFriend);
                remove(requesing);
                add(friends);

                repaint();
                revalidate();
                
                friends.intiComponends();
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
        // Chating Section:
        
        // Add Freind Section:
        addFriend = new AddFriend(new Dimension(width - 10, heigth - 110), getBackground());
        addFriend.drawScrollPanel();

        addFriendLbl.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                
                addFriend.addFreindContanirPanel.removeAll();
                addFriend.addFreindContanirPanel.repaint();
                addFriend.addFreindContanirPanel.repaint();
                addFriend.totalHeight = 0;
                
                remove(friends);
                remove(requesing);
                add(addFriend);
                
                repaint();
                revalidate();
                addFriend.intiComponends();

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
        // Add Freind Section:
       
        // RequesingList Section: 
        requesing = new Requesing(new Dimension(width - 10, heigth - 110), getBackground());
        requesing.drawScrollPanel();
        
        requestListLbl.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                
                requesing.requestingContanirPanel.removeAll();
                requesing.requestingContanirPanel.repaint();
                requesing.requestingContanirPanel.revalidate();
                
                remove(friends);
                remove(addFriend);
                add(requesing);
                
                repaint();
                revalidate();
                requesing.intiComponends();
                
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
        // RequesingList Section: 
        
        //Setting Section!        
        settingPanel = new SettingPanel(new Dimension(width - 10, heigth - 110), getBackground());
        settingPanel.intiComponends();
        
//        settingLbl.addMouseListener(new MouseListener() {
//
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                remove(friends);
//                remove(addFriend);
//                remove(requesing);
//                add(settingPanel);
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//            }
//        });
    }

    JPanel dotPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 2));
    
    String dotSpath[] = {"redDot","orange_dot","yellowDot"};
    JLabel dotsIcon[] = new JLabel[3];
    
    JPanel mainFunctionPanel = new JPanel(new GridLayout(1, 4, 5, 5));
    
    JLabel chattingLbl = new JLabel(Defaults.rescaleIcon(iconSizeX, iconSizeY, Defaults.Iconpath("chatting", "png")));
    JLabel addFriendLbl = new JLabel(Defaults.rescaleIcon(iconSizeX, iconSizeY, Defaults.Iconpath("twoPerson", "png")));
    JLabel requestListLbl = new JLabel(Defaults.rescaleIcon(iconSizeX, iconSizeY, Defaults.Iconpath("freindRequest_1", "png")));
    JLabel settingLbl = new JLabel(Defaults.rescaleIcon(iconSizeX, iconSizeY, Defaults.Iconpath("setting", "png")));
    
    JPanel userSearchPanel = new JPanel(null);
    JTextField userSearchTxt = new JTextField();
    JLabel userSearchLbl = new JLabel("Search");
    
    users users;
    AddFriend addFriend;
    Requesing requesing;
    Friends friends;
    SettingPanel settingPanel;
    
}

class Test{
    public void approveRequest(){
        String queryShowRequests = "SELECT * FROM requests WHERE ToRqID = 'CurrentID'";

        String queryApproveRequest = ""
                + "UPDATE requests SET status = 'Approved'"
                + " WHERE ToRqID = 'CurrentID' AND FromRqID = 'FromID'";
        
        String queryFriends = "SELECT * FROM rquest WHERE ToReqID = 'CurrentID' AND Status = 'Approved'";
    }
}