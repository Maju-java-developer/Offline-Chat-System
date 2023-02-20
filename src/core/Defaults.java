/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import messangerdesignproject.ChatRoomPanel;

/**
 *
 * @author Majid Hussain
 */

public class Defaults {
    public static ImageIcon rescaleIcon(int posX, int posY, String path){
        
        ImageIcon icon = new ImageIcon(
                new ImageIcon(path).
                        getImage().
                        getScaledInstance(
                                posX, 
                                posY, 
                                Image.SCALE_SMOOTH)
        );
        
        return icon;
    }
        
    public static String Iconpath(String Imagepath, String extention){
        return new File("").getAbsolutePath() +"\\src\\res\\" +Imagepath+"."+extention;
    }

    public static String generateID(){
        
        int rondomiseOne = new Random().nextInt(99999);
        int rondomiseTwo = new Random().nextInt(99999);
        
        int extraRandomise = new Random().nextInt(99999);
        
        String totalRandom = rondomiseOne +"_" +rondomiseTwo+"_"+extraRandomise;
        
        return totalRandom;
    }
    
}
