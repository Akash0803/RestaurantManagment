package com.domcafe.db;


import com.birosoft.liquid.LiquidLookAndFeel;
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.awt.Image;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author star
 */
public class Utility {
    public static void resizeLabelImage(JLabel lbl){
        //Get Image/Icon of label
        Icon icon= lbl.getIcon(); //Returns an ImageIcon class object which implements Icon interface
        ImageIcon img=(ImageIcon)icon;
        
        
        //Resize Image
        //1 Get Image class object from ImageIcon
        Image im=img.getImage();
        //2 Scale Image object
        im=im.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH);
        //Image getScaledInstance(width,height,index of Scaling Algorithm)
        //3 set Image class object to ImageIcon
        img.setImage(im);
        //4 set icon to label
        lbl.setIcon(img); 
    }
    public static void setLabelImage(JLabel lbl,File f){
        //Get Image/Icon of label
        ImageIcon img=new ImageIcon(f.getAbsolutePath());
        //Resize Image
        //1 Get Image class object from ImageIcon
        Image im=img.getImage();
        //2 Scale Image object
        im=im.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH);
        //Image getScaledInstance(width,height,index of Scaling Algorithm)
        //3 set Image class object to ImageIcon
        img.setImage(im);
        //4 set icon to label
        lbl.setIcon(img); 
    }
    public static void showMsg(String msg,String title){
        JOptionPane.showMessageDialog(null, msg,title,JOptionPane.INFORMATION_MESSAGE);
    }
    public static void showWarn(String msg,String title){
        JOptionPane.showMessageDialog(null, msg,title,JOptionPane.WARNING_MESSAGE);
    }
    public static int showConfirm(String msg,String title){
        return JOptionPane.showConfirmDialog(null, msg,title,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
    }
    public static void LookAndFeel(String theme){
        try {
            UIManager.setLookAndFeel(theme);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    }
}
