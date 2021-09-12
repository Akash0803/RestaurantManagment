/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domcafe.db;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author city
 */
public class Utility1 {
    public static String username;
    public static String role;
    public static String password;
    public static int userid;
    public static int Id;
    
    public static String getCurrentDateTime()
    {
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
        return sdf.format(d);
    }
    public static String getSystemDateTime()
    {
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        return sdf.format(d);
    }
    public static String getCurrentDate()
    {
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(d);
    }
    public static String getCurrentTime()
    {
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("hh:mm");
        return sdf.format(d);
    }
    public static File getFileFromStream(InputStream in) throws Exception
    {
        File f=File.createTempFile("city", ".tmp");
        FileOutputStream fos=new FileOutputStream(f);
        byte b[]=new byte[100];
        int i;
        while((i=in.read(b))!=-1)
        {
            fos.write(b,0,i);
        }
        fos.close();
        return f;
    }
    public static void setBackgroundImage(JFrame frame,String path)
    {
        //System.out.println(new File(path).getAbsolutePath());
        ImageIcon img=new ImageIcon(path);
        Image im=img.getImage();                
        frame.setLayout(new BorderLayout());
        
        JPanel jp=new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
                g.drawImage(im,0,0,getWidth(),getHeight() ,frame);
            }
          
        };
        frame.getContentPane().add(jp);
    }
    public static void setBackgroundImage(JDialog dialog,String path)
    {
        //System.out.println(new File(path).getAbsolutePath());
        ImageIcon img=new ImageIcon(path);
        Image im=img.getImage();                
        dialog.setLayout(new BorderLayout());
        
        JPanel jp=new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
                g.drawImage(im,0,0,getWidth(),getHeight() ,dialog);
            }
          
        };
        dialog.getContentPane().add(jp);
    }
    public static void setDateTimeTimer(JLabel lbl,int interval)
    {
        Timer t=new Timer(interval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbl.setText(getSystemDateTime());
            }
        });
        t.start();
    }
    public static void setScrollingTextTimer(JLabel lbl,String text,int interval)
    {
        
        Timer t=new Timer(interval, new ActionListener() {
            int i=1;
            @Override
            public void actionPerformed(ActionEvent e) {
                lbl.setText(text.substring(0,i));
                i++;
                if(i>text.length())
                {
                    i=1;
                }
            }
        });
        t.start();
    }
    
    public static void setMovingTextTimer(JPanel jp,String text,int interval)
    {
        jp.setLayout(null);
        JLabel lbl=new JLabel(text);        
        lbl.setText(text);        
        lbl.setLocation(jp.getWidth(), 6);
        lbl.setSize(300,25);
        lbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl.setForeground(Color.red);
        jp.add(lbl);
        Timer t=new Timer(interval, new ActionListener() {
            int w=jp.getWidth();            
            int y=6;
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(w);
                lbl.setLocation(w, y);                
                w-=10;
                if(w<400)
                {
                    w=jp.getWidth();
                }
            }
        });
        t.start();
    }
    public static void executeApp(String appname)
    {
         try {
            Runtime obj=Runtime.getRuntime();
            //obj.exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
            obj.exec("rundll32 SHELL32.DLL,ShellExec_RunDLL "+appname);
        } catch (IOException ex) {
             JOptionPane.showMessageDialog(null, ex.toString());
        }

    }
    public static Process executeProcess(String appname)
    {
        Process p=null;
         try {
            Runtime obj=Runtime.getRuntime();
            //obj.exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
            p=obj.exec(appname);
        } catch (IOException ex) {
             JOptionPane.showMessageDialog(null, ex.toString());
        }
         return p;

    }
    public static  String toDigits(String amt)
    {
        DecimalFormat dc=new DecimalFormat(".00");
        return dc.format(amt);
    }
    public static void setLabelImage(JLabel lbl,String path)
    {
        //System.out.println(new File(path).getAbsolutePath());
        ImageIcon img=new ImageIcon(path);
        Image im=img.getImage();                
        //Resize image to label size
        im=im.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH);
        img.setImage(im);
        lbl.setIcon(img);
        
    }
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
}
