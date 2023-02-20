package Converstion;

import core.Defaults;
import core.Instances;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Chat extends JScrollPane{
    
    int posX, posY, width, height;

    String tablename;
    
    public ArrayList<Converstion> converstionList;
    
    public Chat() {
    }

    public Chat(int posX, int posY, int width, int height , String tablename) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.tablename = tablename;
    }
    
    public void drawScrollPanel(){
        intiComponends();
    }
     
    int rowDataHeight = 120;
    int rowDataImageHeight = 200;
    int messageLength;
    
    int lineCount = 1;
    
    public void intiComponends(){
        setBounds(posX, posY, width, height);
        setViewportView(chatContnairPanel);
        
        getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {  
            public void adjustmentValueChanged(AdjustmentEvent e) {  
                e.getAdjustable().setValue(e.getAdjustable().getMaximum());  
            }
        });
        
        converstions();
    }

    int lineHeight = 5;
    JLabel messageLbl;

    public void converstions(){

        converstionList = DataBaseOperation.converstions(tablename);
        
        chatContnairPanel.setBackground(Color.DARK_GRAY);
        
        JPanel imageContanirPanel = new JPanel(new GridLayout(1, 1));
        
        imageContanirPanel.setPreferredSize(new Dimension(width / 2, rowDataImageHeight));
        imageContanirPanel.setBackground(Color.red);
        
        final String imagePath = "majid_pic1";
        final String imgExtension = "jpg";
        
        final JLabel imageLabel = new JLabel(
            core.Defaults.rescaleIcon(
            imageContanirPanel.getPreferredSize().width,
            imageContanirPanel.getPreferredSize().height, core.Defaults.Iconpath(imagePath, imgExtension))
        );
        
        imageLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                JDialog displayImageDialog = new JDialog();
                
                displayImageDialog.setTitle("Show Image:");
                displayImageDialog.setSize(720, 480);
                displayImageDialog.setLocationRelativeTo(null);
                displayImageDialog.setLayout(new GridLayout(1, 1));
                displayImageDialog.setVisible(true);
                
                JPanel displayPanel = new JPanel(new GridLayout(1, 1));
                
                JLabel displayImageLabel = new JLabel(
                        Defaults.rescaleIcon(720,
                                480, 
                                Defaults.Iconpath(imagePath, imgExtension))
                );
                
                displayImageDialog.add(displayPanel);
                displayPanel.add(displayImageLabel);
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
        imageContanirPanel.add(imageLabel);
        imageContanirPanel.setAlignmentX((int)CENTER_ALIGNMENT);
        imageLabel.setForeground(Color.WHITE);
        
        lineHeight += imageContanirPanel.getPreferredSize().getHeight();
        chatContnairPanel.add(imageContanirPanel);
        
        for (int i = 0; i < converstionList.size(); i++) {
            if (converstionList.size() == 0) {
                JOptionPane.showMessageDialog(null, "Your chat is empty!");
            }else {
                
                JPanel rowDataPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));
                
                rowDataPanel.setPreferredSize(new Dimension(width - 30, rowDataHeight));
                rowDataPanel.setBackground(chatContnairPanel.getBackground());

                JPanel rowSubPanel = new JPanel(null);
                rowSubPanel.setPreferredSize(new Dimension(rowDataPanel.getPreferredSize().width - 70, rowDataHeight));
                rowSubPanel.setBackground(rowDataPanel.getBackground());
                
                String htmlFormattedMessage;
                messageLbl = new JLabel();
                messageLbl.setHorizontalAlignment(SwingConstants.CENTER);
                
                if (converstionList.get(i).getMessage().length() > (22 * lineCount)) {
                    converstionList.get(i).Message = converstionList.get(i).Message + "<br>";
                    lineCount++;
                }
                
                String formattedMessage = "";
                
                if (converstionList.get(i).getMessage().length() <= 30) {
                    formattedMessage = "<html>" + converstionList.get(i).getTitle() + ": " + converstionList.get(i).getMessage() + "</html>";
                    rowDataPanel.setPreferredSize(new Dimension(rowDataPanel.getPreferredSize().width, 40));
                    rowSubPanel.setPreferredSize(new Dimension((rowDataPanel.getPreferredSize().width/2+30), 40));
                }else if (converstionList.get(i).getMessage().length() <= 60) {
                    formattedMessage = "<html>" + converstionList.get(i).getTitle() + ": " + converstionList.get(i).getMessage() + "</html>";
                    rowDataPanel.setPreferredSize(new Dimension(rowDataPanel.getPreferredSize().width, 80));
                    rowSubPanel.setPreferredSize(new Dimension((rowDataPanel.getPreferredSize().width/2+30), 80));
                }else if (converstionList.get(i).getMessage().length() <= 90) {
                    formattedMessage = "<html>" + converstionList.get(i).getTitle() + ": " + converstionList.get(i).getMessage() + "</html>";
                    rowDataPanel.setPreferredSize(new Dimension(rowDataPanel.getPreferredSize().width, 120));
                    rowSubPanel.setPreferredSize(new Dimension((rowDataPanel.getPreferredSize().width/2+30), 120));
                }else if (converstionList.get(i).getMessage().length() <= 120) {
                    formattedMessage = "<html>" + converstionList.get(i).getTitle() + ": " + converstionList.get(i).getMessage() + "</html>";
                    rowDataPanel.setPreferredSize(new Dimension(rowDataPanel.getPreferredSize().width, 160));
                    rowSubPanel.setPreferredSize(new Dimension((rowDataPanel.getPreferredSize().width/2+30), 160));
                }else if (converstionList.get(i).getMessage().length() <= 150) {
                    formattedMessage = "<html>" + converstionList.get(i).getTitle() + ": " + converstionList.get(i).getMessage() + "</html>";
                    rowDataPanel.setPreferredSize(new Dimension(rowDataPanel.getPreferredSize().width, 200));
                    rowSubPanel.setPreferredSize(new Dimension((rowDataPanel.getPreferredSize().width/2+30), 200));
                }else if (converstionList.get(i).getMessage().length() <= 180) {
                    formattedMessage = "<html>" + converstionList.get(i).getTitle() + ": " + converstionList.get(i).getMessage() + "</html>";
                    rowDataPanel.setPreferredSize(new Dimension(rowDataPanel.getPreferredSize().width, 240));
                    rowSubPanel.setPreferredSize(new Dimension((rowDataPanel.getPreferredSize().width/2+30), 240));
                }else if (converstionList.get(i).getMessage().length() <= 210) {
                    formattedMessage = "<html>" + converstionList.get(i).getTitle() + ": " + converstionList.get(i).getMessage() + "</html>";
                    rowDataPanel.setPreferredSize(new Dimension(rowDataPanel.getPreferredSize().width, 280));
                    rowSubPanel.setPreferredSize(new Dimension((rowDataPanel.getPreferredSize().width/2+30), 280));
                }
                
                lineHeight += rowDataPanel.getPreferredSize().height;
                lineHeight += 2;
                
                chatContnairPanel.setPreferredSize(new Dimension(width - 25, lineHeight));
                final boolean isCurrentMsg;
                
                if (converstionList.get(i).FromUID.equals(UserStats.unique_id)) {
                    isCurrentMsg = true;
                    htmlFormattedMessage = "<html><font color='white'>" +converstionList.get(i).getMessage() + "</font></html>";
                    messageLbl.setText(htmlFormattedMessage);
                    rowDataPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                    rowSubPanel.setBackground(new Color(20, 30, 50));
                }else{
                    isCurrentMsg = false;
                    htmlFormattedMessage = "<html><font color='red'><b>"+converstionList.get(i).getTitle() + ":&nbsp;&nbsp;&nbsp;</b></font><font color='black'>"  + converstionList.get(i).getMessage() + "</font></html>";
                    messageLbl.setText(htmlFormattedMessage);
                    rowDataPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
                    rowSubPanel.setBackground(new Color(240, 240, 240));
                }
                
                messageLbl.setBounds(10, 10, rowSubPanel.getPreferredSize().width-20, rowSubPanel.getPreferredSize().height-20);
                messageLbl.setVerticalAlignment(JLabel.TOP);
                messageLbl.setVerticalTextPosition(JLabel.TOP);
                messageLbl.setHorizontalAlignment(SwingConstants.LEFT);
                
                rowDataPanel.add(rowSubPanel);
                chatContnairPanel.add(rowDataPanel);
                rowSubPanel.add(messageLbl);
                
                String messageStr = converstionList.get(i).getMessage();
                int userID = converstionList.get(i).getUserID();
                String titleStr = converstionList.get(i).getTitle();
                
                rowSubPanel.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
//                        JOptionPane.showMessageDialog(null, "Testing Boolean Value: " + isCurrentMsg);
//                        System.out.println("Testing Boolean Value: " + isCurrentMsg);
                        if (isCurrentMsg == true) {
                            if (e.getButton() == MouseEvent.BUTTON3) {
                                actionPopupUp(
                                        e.getLocationOnScreen().x - Instances.mainApp.getLocation().x - 280,
                                        e.getLocationOnScreen().y - Instances.mainApp.getLocation().y - 100,
                                        messageStr,
                                        userID,
                                        titleStr,
                                        ""
                                );
                            }
                        }else if (isCurrentMsg == false) {
                            if (e.getButton() == MouseEvent.BUTTON3) {
                                actionPopupUp(
                                        e.getLocationOnScreen().x - Instances.mainApp.getLocation().x - 280,
                                        e.getLocationOnScreen().y - Instances.mainApp.getLocation().y - 100,
                                        messageStr,
                                        userID,
                                        titleStr,
                                        "EditMenuHide"
                                );
                            }
                        }
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
            }
        }

    }
    JPanel chatContnairPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 2));
    
    public JPopupMenu actionPopupMenu;
    public JMenuItem  MenuItem;
    
    public void actionPopupUp(int posX, int posY, String messageStr, int userID, String titleStr, String hideMenutext){
        actionPopupMenu = new JPopupMenu();

        MenuItem = new JMenuItem("Delete:");
        if (hideMenutext == "deleteMenuHide") {
            MenuItem.setVisible(false);
        }else {
            MenuItem.setVisible(true);
        }
        
        MenuItem.setIcon(Defaults.rescaleIcon(15, 15, Defaults.Iconpath("delete_1", "png")));
        MenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                JDialog deleteMsgDialog = new JDialog();

                deleteMsgDialog.setTitle("Delete Message: " + messageStr);
                deleteMsgDialog.setSize(400, 300);
                deleteMsgDialog.setLayout(null);
                deleteMsgDialog.setLocationRelativeTo(null);
                deleteMsgDialog.setVisible(true);

                JTextArea deleteTxtArea = new JTextArea(messageStr);
                JButton deleteBtn = new JButton("Delete");

                deleteTxtArea.setBounds(20, 20, 300, 150);
                deleteTxtArea.setEditable(false);
                
                deleteBtn.setBounds(20, 180, 200, 30);
                deleteBtn.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int result = JOptionPane.showConfirmDialog(null, "are u sure delete it?", "Deleing message", JOptionPane.YES_NO_OPTION);
                        if (result == JOptionPane.YES_OPTION) {
                            DataBaseOperation.deleteMessage(userID, tablename);
                            chatContnairPanel.removeAll();
                            lineHeight = 5;

                            chatContnairPanel.repaint();
                            chatContnairPanel.revalidate();
                            repaint();
                            revalidate();

                            converstions();
                            deleteMsgDialog.dispose();    
                        }else {
                            JOptionPane.showMessageDialog(null, "Cancel deleteing message:");
                        }
                    }
                });
                
                deleteMsgDialog.add(deleteTxtArea);
                deleteMsgDialog.add(deleteBtn);
                
            }
        });
        actionPopupMenu.add(MenuItem);
        
        MenuItem = new JMenuItem("Edit:");
        if (hideMenutext == "EditMenuHide") {
            MenuItem.setVisible(false);
        }else {
            MenuItem.setVisible(true);
        }

        MenuItem.setIcon(Defaults.rescaleIcon(15, 15, Defaults.Iconpath("edit_1", "png")));
        MenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                JDialog editMsgDialog = new JDialog();

                editMsgDialog.setTitle("Edit Message: " + messageStr);
                editMsgDialog.setSize(400, 300);
                editMsgDialog.setLayout(null);
                editMsgDialog.setLocationRelativeTo(null);
                editMsgDialog.setVisible(true);

                JTextArea editTxtArea = new JTextArea(messageStr);
                JButton editBtn = new JButton("Edit");

                editTxtArea.setBounds(20, 20, 300, 150);

                editBtn.setBounds(20, 180, 200, 30);
                editBtn.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        DataBaseOperation.editMessage(userID, tablename, editTxtArea.getText());
                       
                        chatContnairPanel.removeAll();
                        lineHeight = 5;
                        
                        chatContnairPanel.repaint();
                        chatContnairPanel.revalidate();
                        
                        repaint();
                        revalidate();
                        converstions();
                        editMsgDialog.dispose();
                    }
                });
                editMsgDialog.add(editTxtArea);
                editMsgDialog.add(editBtn);
            }
        });
        
        actionPopupMenu.add(MenuItem);
        actionPopupMenu.show(this, posX, posY);
    }
}