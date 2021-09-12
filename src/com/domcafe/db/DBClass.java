/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domcafe.db;

import com.domcafe.forms.ReportFrame;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author star
 */
public class DBClass {
    Connection cn;
    //Connect to Database
    public void connect(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/domdb", "root", "city");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    //Close connection
    public void close(){
        try{
        cn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    public void fillTable(JTable table,String sql,Object ... args){
        try{
        connect();
        DefaultTableModel dt=(DefaultTableModel)table.getModel();
        dt.setRowCount(0);
        PreparedStatement ps=cn.prepareStatement(sql);
        int i=1;
            for(Object obj : args){
                ps.setObject(i, obj);
                i++;
            }
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Object obj[]=new Object[dt.getColumnCount()];
            for(int j=0;j<obj.length;j++){
                obj[j]=rs.getObject(j+1);
            }
            dt.addRow(obj);
        }
        close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    public void fillTable2(JTable table,String sql,Object ... args){
        try{
        connect();
        table.setRowHeight(50);
        //Get column names from table
        Object cols[]=new Object[table.getColumnCount()];
        for(int i=0;i<cols.length;i++){
            cols[i]=table.getColumnName(i);            
        }
        PreparedStatement ps=cn.prepareStatement(sql);
        int i=1;
            for(Object obj : args){
                ps.setObject(i, obj);
                i++;
            }
        ResultSet rs=ps.executeQuery();
        ResultSetMetaData rsd=rs.getMetaData();
        //4 cols ==> Object  Roll  Name  Address Photo[ImageIcon]        
        DefaultTableModel dt=new DefaultTableModel()
        {            
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                
                try {                   
                        if(rsd.getColumnTypeName(columnIndex+1).equals("MEDIUMBLOB")){
                            return ImageIcon.class; //Returns Class type object                        }
                        }else{
                            return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
                        }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(DBClass.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
            }
        }; 
        //set column names in dt
        dt.setColumnIdentifiers(cols);
        table.setModel(dt);
        while(rs.next()){
            Object obj[]=new Object[dt.getColumnCount()];
            for(int j=0;j<obj.length;j++){
                if(rsd.getColumnTypeName(j+1).equals("MEDIUMBLOB")){
                    InputStream in=rs.getBinaryStream(j+1);
                    byte b[]=new byte[in.available()];
                    in.read(b); //Read data from InputStream and store in byte array
                    ImageIcon img=new ImageIcon(b); //ImageIcon(byte b[])
                    Image im=img.getImage();
                    im=im.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                    img.setImage(im);
                    obj[j]=img;
                }else{
                obj[j]=rs.getObject(j+1);
                }
            }
            dt.addRow(obj);
        }
        close();
        
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    public void applySearch(JTable table,JComboBox cmbfield,JTextField txtsearch,String sql,Object ... args){
        txtsearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                fillTable(table, sql+ " where "+cmbfield.getSelectedItem()+" like '%"+txtsearch.getText()+"%'", args);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                fillTable(table, sql+ " where "+cmbfield.getSelectedItem()+" like '%"+txtsearch.getText()+"%'", args);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
        });
    }
    //Scond version for images
    public void applySearch2(JTable table,JComboBox cmbfield,JTextField txtsearch,String sql,Object ... args){
        txtsearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                fillTable2(table, sql+ " where "+cmbfield.getSelectedItem()+" like '%"+txtsearch.getText()+"%'", args);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                fillTable2(table, sql+ " where "+cmbfield.getSelectedItem()+" like '%"+txtsearch.getText()+"%'", args);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
        });
    }
    //Execute Insert,Update and Delete command
    public void execute(String sql,Object ... args){
        try{
            connect();
            PreparedStatement ps=cn.prepareStatement(sql);
            int i=1;
            for(Object obj : args){
                if(obj instanceof File){ // type of obj is File
                    //FileInputStream is derived from InputStream class
                FileInputStream fis=new FileInputStream((File)obj);
                ps.setBinaryStream(i, fis);
                }else{
                ps.setObject(i, obj);
                }
                i++;
            }
            ps.executeUpdate();
            close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    //Get Data
    public ResultSet getData(String sql,Object ... args){
        ResultSet rs=null;
        try{
            connect();
            PreparedStatement ps=cn.prepareStatement(sql);
            int i=1;
            for(Object obj : args){
                ps.setObject(i, obj);
                i++;
            }
            rs=ps.executeQuery();
            //close(); //Dont close connection
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return rs;
        
    }
    public void showReport(String reportPath){
        try {
            connect();
            JasperReport jr=JasperCompileManager.compileReport(new File(reportPath).getAbsolutePath()); //path from abs/root drive
            //Fill report object with data thru connection
            JasperPrint jp=JasperFillManager.fillReport(jr, null, cn);
            //Returns PrintPreview object of filled jasper report
            JRViewer jv=new JRViewer(jp);
            ReportFrame f=new ReportFrame();
            f.add(jv); //add JRViewer in your Frame
            f.setVisible(true);
            close();
        } catch (JRException ex) {
            Logger.getLogger(DBClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void showReport(String reportPath,HashMap<String,Object> map){
        try {
            connect();
            JasperReport jr=JasperCompileManager.compileReport(new File(reportPath).getAbsolutePath()); //path from abs/root drive
            //Fill report object with data thru connection
            JasperPrint jp=JasperFillManager.fillReport(jr, map, cn);
            //Returns PrintPreview object of filled jasper report
            JRViewer jv=new JRViewer(jp);
            ReportFrame f=new ReportFrame();
            f.add(jv); //add JRViewer in your Frame
            f.setVisible(true);
            close();
        } catch (JRException ex) {
            Logger.getLogger(DBClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void fillCombo(JComboBox cmb,String sql){
        try {
            cmb.removeAllItems();
            ResultSet rs=getData(sql);
            while(rs.next()){
                cmb.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void fillCombo(JComboBox cmb,String sql,String showfield,String returnfield){
        try {
            cmb.removeAllItems();
            ResultSet rs=getData(sql);
            ResultSetMetaData rsd=rs.getMetaData();
            while(rs.next()){                
                ComboItem ci=new ComboItem();
                ci.displayField=rs.getString(showfield);
                ci.returnField=rs.getString(returnfield);
                for(int i=1;i<=rsd.getColumnCount();i++){
                    ci.data.put(rsd.getColumnName(i), rs.getObject(i));
                }                
                cmb.addItem(ci);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getID(String field){
        String retval="0";
        try {            
            ResultSet rs=getData("select "+field+" from lookuptbl");
            if(rs.next()){
                retval=rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retval;
    }
    public void updateID(String field){
        execute("Update lookuptbl set "+field+"="+field+"+1");        
    }
    public ComboItem getItem(JComboBox cmb, String retid){
        for(int i=0;i<cmb.getItemCount();i++){
            ComboItem ci=(ComboItem) cmb.getItemAt(i);
            if(ci.returnField.equals(retid))
                return ci;
        }
        return null;
    }
}
