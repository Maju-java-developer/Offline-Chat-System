package messangerdesignproject;

import Converstion.DataBaseOperation;
import core.Defaults;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Requesing extends JScrollPane{

    Dimension size;
    Color color;
    public Requesing() {
    }

    int rowPanelHeight = 70;
    int totalHeight = 0;
    
    ArrayList<Requests> requestList;
    
    public Requesing(Dimension size, Color color) {
        this.size = size;
        this.color = color;
        
    }
    
    public void drawScrollPanel(){
        setPreferredSize(size);
        setViewportView(requestingContanirPanel);
        
        intiComponends();
    }
   
    public void intiComponends(){

        requestList = DataBaseOperation.getRequests();
        
        totalHeight = (requestList.size() * rowPanelHeight) + (requestList.size() + 2);
        requestingContanirPanel.setPreferredSize(new Dimension(size.width - 10, totalHeight));
        requestingContanirPanel.setBackground(Color.WHITE);
        
        if (!requestList.isEmpty()) {
            JPanel countRequestPanel = new JPanel(new GridLayout(1, 1));
            JLabel countRequestLbl = new JLabel("FREIND REQUEST: "+DataBaseOperation.getRequests().size());

            countRequestPanel.setPreferredSize(new Dimension(requestingContanirPanel.getPreferredSize().width, 30));
            countRequestPanel.setBackground(new Color(20, 30, 80));

            countRequestLbl.setForeground(Color.WHITE);

            requestingContanirPanel.add(countRequestPanel);
            countRequestPanel.add(countRequestLbl);
            
            totalHeight += countRequestPanel.getPreferredSize().height;
        }
        
        for (final Requests requests : requestList) {
            JPanel requestingRowPanel = new JPanel(null);
            
            requestingRowPanel.setPreferredSize(new Dimension(requestingContanirPanel.getPreferredSize().width, rowPanelHeight));
            requestingRowPanel.setBackground(color);

            JLabel userImageLbl = new JLabel(Defaults.rescaleIcon(60, 60, Defaults.Iconpath("student1", "png")));
            userImageLbl.setBounds(5, 0, 50, 70);
            
            JLabel userNameLbl = new JLabel(requests.getFrom_Username());
            
            userNameLbl.setBounds(55, - 10, 200, 50);
            userNameLbl.setForeground(Color.WHITE);

            final JButton acceptReqBtn = new JButton("Confrim");
            final JButton cancelReqBtn = new JButton("cancel");

            cancelReqBtn.setBounds(userNameLbl.getX() - 5, userNameLbl.getY() + userNameLbl.getHeight() - 10, 80, 35);
            acceptReqBtn.setBounds((cancelReqBtn.getX() + cancelReqBtn.getWidth()), userNameLbl.getY() + userNameLbl.getHeight() - 10, 100, 35);
            
            requestingRowPanel.add(userImageLbl);
            requestingRowPanel.add(userNameLbl);
            requestingRowPanel.add(cancelReqBtn);
            requestingRowPanel.add(acceptReqBtn);
        
            cancelReqBtn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    int result = JOptionPane.showConfirmDialog(null, "are u sure ?", "cancel Request", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        requestingContanirPanel.removeAll();
                        requestingContanirPanel.repaint();
                        requestingContanirPanel.revalidate();
                        
                        totalHeight = 0;

                        DataBaseOperation.cancelRequest(requests.From_Request_ID);
                        intiComponends();
                        repaint();
                        revalidate();
                    }else {
                        System.out.println("not Canceling Requesting!");
                    }
                    
                }
            });
            
            acceptReqBtn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                        
                        requestingContanirPanel.removeAll();
                        requestingContanirPanel.repaint();
                        requestingContanirPanel.revalidate();
                        
                        totalHeight = 0;

                        DataBaseOperation.ApproveRequest(requests.From_Request_ID);
                        intiComponends();
                        repaint();
                        revalidate();
                        
                }
            });
            
            requestingContanirPanel.add(requestingRowPanel);
        }

    }
    JPanel requestingContanirPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 1));
    
}
