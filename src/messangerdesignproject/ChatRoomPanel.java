package messangerdesignproject;

import Converstion.DataBaseOperation;
import Converstion.UserStats;
import core.Defaults;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChatRoomPanel extends JPanel{
    
    int posX, posY, width, height;
    
    public ChatRoomPanel(){
    }

    public ChatRoomPanel(int posX, int posY, int width, int height) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }
     
    public void drawPanel(){
        intiComponends();
    }
    
    public void intiComponends(){
        setBounds(posX, posY, width, height);
        setLayout(null);
        
        ChatRoomHeaderPanel.setBounds(0, 0, width, 80);
        ChatRoomHeaderPanel.setName("ChatRoomHeader");
        
        // ChatRoom Header Panel Section:
        userActiveInfoPanel.setPreferredSize(new Dimension(width - 150, ChatRoomHeaderPanel.getHeight()));
        userActiveInfoPanel.setBackground(getBackground());
        
        callActionPanel.setPreferredSize(new Dimension(150, ChatRoomHeaderPanel.getHeight()));
        callActionPanel.setBackground(getBackground()); 
        
        ChatRoomHeaderPanel.add(userActiveInfoPanel);
        ChatRoomHeaderPanel.add(callActionPanel);
        
        userNameLbl.setBounds(30, 5, 200, userActiveInfoPanel.getPreferredSize().height);
        userNameLbl.setIcon(Defaults.rescaleIcon(45, 45, Defaults.Iconpath("student1", "png")));
        userNameLbl.addMouseListener(new MouseListener() {

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
        userActiveLbl.setBounds(80, 45, 100, 30);
        userActiveLbl.setIcon(Defaults.rescaleIcon(10, 10, Defaults.Iconpath("green_dot", "png")));
        
        userActiveInfoPanel.add(userNameLbl);
        userActiveInfoPanel.add(userActiveLbl);
        
        callActionPanel.add(personIcon);
        callActionPanel.add(voiceCallIcon);
        callActionPanel.add(vedioCallIcon);
        
        add(ChatRoomHeaderPanel);
        // ChatRoom Header Panel Section:
        
    }

    JPanel ChatRoomHeaderPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));
        
    JPanel callActionPanel = new JPanel(new GridLayout(1, 3));
    
    JLabel personIcon = new JLabel(Defaults.rescaleIcon(30, 30, Defaults.Iconpath("person", "png")));
    JLabel voiceCallIcon = new JLabel(Defaults.rescaleIcon(25, 25, Defaults.Iconpath("voiceCall", "png")));
    JLabel vedioCallIcon = new JLabel(Defaults.rescaleIcon(30, 30, Defaults.Iconpath("videoCall", "png")));

    JPanel userActiveInfoPanel = new JPanel(null);
    
    JLabel userNameLbl = new JLabel();
    JLabel userActiveLbl = new JLabel("Active");
}
