package com.domcafe.db;




import com.sun.jndi.ldap.LdapPoolManager;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.io.FileUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author city
 */
public class DataAccess {
    public Connection cn;
    public Statement st;
    
    //Connect to server/database
    public void connect() 
    {
        try {
            //cn=DriverManager.getConnection("jdbc:mysql://localhost/<DatabaseName>","username","password");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Domdb","root","city");
            st=cn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Close connection with database
    public void close()
    {
        try {
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void execute(String sql,String ... args)
    {
        try {
            connect();
            PreparedStatement ps=cn.prepareStatement(sql);
            for(int i=0;i<args.length;i++)
            {
                ps.setString(i+1, args[i]);
            }
            ps.executeUpdate();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int executeId(String sql,String ... args)
    {
        int key=0;
        try {
            connect();
            PreparedStatement ps=cn.prepareStatement(sql);
            for(int i=0;i<args.length;i++)
            {
                ps.setString(i+1, args[i]);
            }
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            rs.next();
            key=rs.getInt(1);
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return key;
    }
    
    public void execute(String sql,int parameterIndex,File file,String ... args)
    {
        try {
            connect();
            PreparedStatement ps=cn.prepareStatement(sql);
            for(int i=0;i<args.length;i++)
            {
                ps.setString(i+1, args[i]);
            }
            FileInputStream fis=FileUtils.openInputStream(file);
            ps.setBinaryStream(parameterIndex,fis,(int)file.length());
            ps.executeUpdate();
            
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public int executeId(String sql,int parameterIndex,File file,String ... args)
    {
        int key=0;
        try {
            connect();
            PreparedStatement ps=cn.prepareStatement(sql);
            for(int i=0;i<args.length;i++)
            {
                ps.setString(i+1, args[i]);
            }
            FileInputStream fis=FileUtils.openInputStream(file);
            ps.setBinaryStream(parameterIndex,fis,(int)file.length());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            rs.next();
            key=rs.getInt(1);
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return key;
    }
    public ResultSet getRows(String sql,String ... args)
    {
        try {
            connect();
            PreparedStatement ps=cn.prepareStatement(sql);
            for(int i=0;i<args.length;i++)
            {
                ps.setString(i+1, args[i]);
            }
            ResultSet rs=ps.executeQuery();
            //donot close connection - because we cannot access resultset
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void fillTable(JTable tab,String sql)
    {
        DefaultTableModel dt=(DefaultTableModel) tab.getModel();
        //Remove all rows from table
        dt.setRowCount(0);
        try {
            ResultSet rs=getRows(sql);
            while(rs.next())
            {
                Object obj[]=new Object[tab.getColumnCount()];
                for(int j=0;j<obj.length;j++)
                {
                    obj[j]=rs.getString(j+1);
                }
                dt.addRow(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void fillTable(JTable tab,String sql,int photoIndex,String cols[])
    {   
        DefaultTableModel dt1=new DefaultTableModel(null,cols)
        {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if(columnIndex==photoIndex)
                {
                    return ImageIcon.class;
                }
                return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
            }
          
        };
        tab.setModel(dt1);
        
        try {
            ResultSet rs=getRows(sql);
            while(rs.next())
            {
                ImageIcon ic;
                Object obj[]=new Object[tab.getColumnCount()];                
                for(int j=0;j<obj.length;j++)
                {
                    if(j==photoIndex)
                    {
                        File fname=File.createTempFile("city", "img"); //city456546img.tmp
                        FileOutputStream fos=FileUtils.openOutputStream(fname);                
                        InputStream io=rs.getBinaryStream(j+1);
                        int i;
                        while((i=io.read())!=-1)
                        {
                            fos.write(i);
                        }
                        //Must close stream
                        fos.close();
                        io.close();                        
                        ic=getSizedImage(fname);
                        obj[j]=ic;
                    }
                    else
                    {
                    obj[j]=rs.getString(j+1);
                    }
                }
                
            dt1.addRow(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void fillTablewithStructure(JTable tab,String sql)
    {
        try {
            ResultSet rs=getRows(sql);
            ResultSetMetaData rsm=rs.getMetaData(); //Inform about resultset
            String cols[]=new String[rsm.getColumnCount()];
            for(int i=0;i<cols.length;i++)
            {
                cols[i]=rsm.getColumnName(i+1);
            }
            
            rs.last();
            int r=rs.getRow();
            rs.beforeFirst();            
            int i=0;
            Object obj[][]=new Object[r][cols.length];
            while(rs.next())
            {                
                for(int j=0;j<obj[i].length;j++)
                {
                    obj[i][j]=rs.getString(j+1);
                }         
                i++;
            }
            DefaultTableModel dt=new DefaultTableModel(obj, cols);
            tab.setModel(dt);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //db.fillCombo(cmbcat,"select * from category","Name","Id")
    public void fillCombo(JComboBox cmb,String sql,String display,String value)
    {
        
        Object obj[]=null;        
        try {
            ResultSet rs=getRows(sql);
            rs.last();
            int nr=rs.getRow();
            obj=new Object[nr];
            rs.beforeFirst();
            int i=0;
            while(rs.next())
            {                
                RowData rd=new RowData();
                rd.display=rs.getString(display);
                rd.value=rs.getString(value);
                obj[i]=rd;
                i++;
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ComboBoxModel cm=cmb.getModel();
        //ComboBoxModel cm=cmb.getModel();
        //ComboBoxModel cm=cmb.getModel();
        //ComboBoxModel cm=cmb.getModel();
        
        DefaultComboBoxModel cm=new DefaultComboBoxModel(obj);
        cmb.setModel(cm);
        
        
    }
    public RowData getRowData(JComboBox cmb,String id)
    {
        RowData d=null;
        for(int i=0;i<cmb.getItemCount();i++)
        {
            RowData rd=(RowData)cmb.getItemAt(i);
            if(rd.value.equals(id)){
                d=rd;
                break;
            }
        }
        return d;
        
    }
    public void displayReport(String reportFilePath)
    {
        try {
            connect();
            JasperReport jrp=JasperCompileManager.compileReport(reportFilePath);
            JasperPrint jp=JasperFillManager.fillReport(jrp, null,cn);
            JasperViewer jv=new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void displayReport(String reportFilePath,Map<String,Object> map)
    {
        try {
            connect();
            JasperReport jrp=JasperCompileManager.compileReport(reportFilePath);
            JasperPrint jp=JasperFillManager.fillReport(jrp, map,cn);
            JasperViewer jv=new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void displayReport2(String reportFilePath,Map<String,Object> map)
    {
        try {
            connect();            
            JasperPrint jp=JasperFillManager.fillReport(reportFilePath, map,cn);
            JasperViewer jv=new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ImageIcon getSizedImage(File fname)
    {
        ImageIcon ic=new ImageIcon(fname.getAbsolutePath());
        
        Image img=ic.getImage();
        img=img.getScaledInstance(60,60,Image.SCALE_SMOOTH );
        ic.setImage(img);
        return ic;    
    }
    public void setImageToLabel(File fname,JLabel lbl)
    {
        ImageIcon ic=new ImageIcon(fname.getAbsolutePath());
        
        Image img=ic.getImage();
        img=img.getScaledInstance(lbl.getWidth(),lbl.getHeight(),Image.SCALE_SMOOTH );
        ic.setImage(img);
        lbl.setIcon(ic);
    }
    public void enableSearch(JComboBox cb,JTextField tf,final JTable table,String sql)
    {
        
        tf.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String sq=sql+" where "+cb.getSelectedItem()+" like '%"+tf.getText()+"%'";
                fillTable(table, sq);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String sq=sql+" where "+cb.getSelectedItem()+" like '%"+tf.getText()+"%'";
                fillTable(table, sq);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
        });
    }
    public void enableSearchWithStructure(JComboBox cb,JTextField tf,final JTable table,String sql)
    {
        
        tf.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String sq=sql+" where "+cb.getSelectedItem()+" like '%"+tf.getText()+"%'";
                fillTablewithStructure(table, sq);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String sq=sql+" where "+cb.getSelectedItem()+" like '%"+tf.getText()+"%'";
                fillTablewithStructure(table, sq);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
        });
    }
    
    public void enableSearch(JComboBox cb,JTextField tf,final JTable table,String sql,int photocolindex,String cols[])
    {
        
        tf.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String sq=sql+" where "+cb.getSelectedItem()+" like '%"+tf.getText()+"%'";
                fillTable(table, sq,photocolindex,cols);                
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String sq=sql+" where "+cb.getSelectedItem()+" like '%"+tf.getText()+"%'";
                fillTable(table, sq,photocolindex,cols);   
                
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
        });
    }
   
    public void showRecordStatus(JLabel lbl,String table)
    {
        try {
            int ct=0;
            ResultSet rs=getRows("select count(*) from "+table);
            if(rs.next())
            {
                ct=rs.getInt(1);
            }
            lbl.setText("Total Record(s): "+ct);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
}
