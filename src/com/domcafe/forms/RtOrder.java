/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domcafe.forms;

import com.domcafe.db.AppStatus;
import com.domcafe.db.ComboItem;
import com.domcafe.db.DBClass;
import com.domcafe.db.Utility;
import java.awt.Color;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class RtOrder extends javax.swing.JFrame {
         DBClass db=new DBClass();
         String oldname;
         
    /**
     * Creates new form LoginForm
     */
    public RtOrder() {
        initComponents();
        getContentPane().setBackground(new Color(255,255,204));
        Utility.resizeLabelImage(lblim);
       
        getRootPane().setBorder(BorderFactory.createEtchedBorder());
         db.fillTable(table1, "select * from POrder");
          db.applySearch(table1, cmbsearch, txtsearch, "select * from POrder");
           db.fillCombo(cmbsupplier,"select * from Branch");
           db.fillCombo(cmbsupplier1,"select * from Branch");
        txtdate.setDate(LocalDate.now());
        txtdate1.setDate(LocalDate.now());
        //Handle key press on form
        KeyboardFocusManager kfm=KeyboardFocusManager.getCurrentKeyboardFocusManager();
        kfm.addKeyEventDispatcher(e->{
            if(e.getID()==KeyEvent.KEY_PRESSED){
                if(e.getKeyCode()==KeyEvent.VK_F3){
                    RawItemForm f=new RawItemForm();
                    //WIndowAdapter implements WindowListener interface
                    f.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            db.fillCombo(cmbsupplier1, "select * from Branch");
                        }
                        
                    });
                    f.setVisible(true);
                    return true;
                }
                if(e.getKeyCode()==KeyEvent.VK_F2){
                    RawItemForm f=new RawItemForm();
                    f.setVisible(true);
                    return true;
                }
                if(e.getKeyCode()==KeyEvent.VK_F4){
                  // btnSelect.doClick(); //Perform click action on select button
                    return true;
                }
                if(e.getKeyCode()==KeyEvent.VK_F5 ){
                    int i=table2.getSelectedRow();
                    if(i!=-1){
                        DefaultTableModel dt=(DefaultTableModel)table2.getModel();
                        dt.removeRow(i);
                    }
                    return true;
                }
                if(e.getKeyCode()==KeyEvent.VK_F6 ){
                    int i=tab2.getSelectedRow();
                    if(i!=-1){
                        DefaultTableModel dt=(DefaultTableModel)tab2.getModel();
                        dt.removeRow(i);
                    }
                    return true;
                }
            }
            return false;
        
        });
        
        //Get ID
        txtpono.setText(db.getID("OrderNo"));
        txttransport.setInputVerifier(new InputVerifier() {
            @Override
            
            public boolean verify(JComponent input) {
                String trs=txttransport.getText();
                if(trs.equals("")){
               lblerror.setText("Transport Field Can't be left empty");
               txttransport.requestFocus();
               return false;
               }else{
                    lblerror.setText("");
                  return true;
              }
            }
        });
        txttransport1.setInputVerifier(new InputVerifier() {
            @Override
            
            public boolean verify(JComponent input) {
                String trs=txttransport1.getText();
                if(trs.equals("")){
               lblerror1.setText("Transport Field Can't be left empty");
               txttransport1.requestFocus();
               return false;
               }else{
                    lblerror1.setText("");
                  return true;
              }
            }
        });
        txtprepared.setInputVerifier(new InputVerifier() {
            @Override
            
            public boolean verify(JComponent input) {
                String trs=txtprepared.getText();
                if(trs.equals("")){
               lblerror.setText("Field Can't be left empty");
               txtprepared.requestFocus();
               return false;
               }else{
                    lblerror.setText("");
                  return true;
              }
            }
        });
        txtprepared1.setInputVerifier(new InputVerifier() {
            @Override
            
            public boolean verify(JComponent input) {
                String trs=txtprepared1.getText();
                if(trs.equals("")){
               lblerror1.setText("Field Can't be left empty");
               txtprepared1.requestFocus();
               return false;
               }else{
                    lblerror1.setText("");
                  return true;
              }
            }
        });
          

          
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        lblim = new javax.swing.JLabel();
        TabPanel1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        cmbsearch = new javax.swing.JComboBox<>();
        txtsearch = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        bntedit1 = new javax.swing.JButton();
        bntedit2 = new javax.swing.JButton();
        bntedit3 = new javax.swing.JButton();
        bntedit4 = new javax.swing.JButton();
        bntedit5 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtpono = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtprepared = new javax.swing.JTextField();
        txttransport = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbsupplier = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtname = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtunit = new javax.swing.JTextField();
        txtqty = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        txtdate = new com.github.lgooddatepicker.components.DatePicker();
        lblerror = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        txtunit1 = new javax.swing.JTextField();
        txtqty1 = new javax.swing.JTextField();
        txtname1 = new javax.swing.JTextField();
        txtid1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtpono1 = new javax.swing.JTextField();
        txtprepared1 = new javax.swing.JTextField();
        txttransport1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cmbsupplier1 = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        tab2 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        txtdate1 = new com.github.lgooddatepicker.components.DatePicker();
        lblerror1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Category");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Raw Material Order List");
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));

        jButton3.setText("X");
        jButton3.setBackground(new java.awt.Color(204, 0, 0));
        jButton3.setContentAreaFilled(false);
        jButton3.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setOpaque(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        lblim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/item icon.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblim, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblim, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        TabPanel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Order No", "Order Date", "Branch", "Transport", "Transport Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table1);

        cmbsearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OrderNo", "ODate", "SuppBranch", "Transport" }));

        txtsearch.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        jLabel9.setText("Search:");
        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        bntedit1.setText("New Order");
        bntedit1.setBackground(new java.awt.Color(204, 0, 0));
        bntedit1.setContentAreaFilled(false);
        bntedit1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        bntedit1.setForeground(new java.awt.Color(255, 255, 255));
        bntedit1.setOpaque(true);
        bntedit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntedit1ActionPerformed(evt);
            }
        });

        bntedit2.setText("Edit Order");
        bntedit2.setBackground(new java.awt.Color(204, 0, 0));
        bntedit2.setContentAreaFilled(false);
        bntedit2.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        bntedit2.setForeground(new java.awt.Color(255, 255, 255));
        bntedit2.setOpaque(true);
        bntedit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntedit2ActionPerformed(evt);
            }
        });

        bntedit3.setText("Remove Order");
        bntedit3.setBackground(new java.awt.Color(204, 0, 0));
        bntedit3.setContentAreaFilled(false);
        bntedit3.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        bntedit3.setForeground(new java.awt.Color(255, 255, 255));
        bntedit3.setOpaque(true);
        bntedit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntedit3ActionPerformed(evt);
            }
        });

        bntedit4.setText("Print Order");
        bntedit4.setBackground(new java.awt.Color(204, 0, 0));
        bntedit4.setContentAreaFilled(false);
        bntedit4.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        bntedit4.setForeground(new java.awt.Color(255, 255, 255));
        bntedit4.setOpaque(true);
        bntedit4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntedit4ActionPerformed(evt);
            }
        });

        bntedit5.setText("Print Order List");
        bntedit5.setBackground(new java.awt.Color(204, 0, 0));
        bntedit5.setContentAreaFilled(false);
        bntedit5.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        bntedit5.setForeground(new java.awt.Color(255, 255, 255));
        bntedit5.setOpaque(true);
        bntedit5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntedit5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsearch))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(bntedit1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntedit2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntedit3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntedit4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntedit5)
                        .addGap(0, 241, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bntedit1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bntedit2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bntedit3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bntedit4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bntedit5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        TabPanel1.addTab("Purchase Order List", jPanel3);

        txtpono.setEditable(false);
        txtpono.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtpono.setForeground(new java.awt.Color(153, 0, 51));

        jLabel20.setText("Order No:");
        jLabel20.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel4.setText("Prepared By");
        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txtprepared.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtprepared.setForeground(new java.awt.Color(153, 0, 51));

        txttransport.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txttransport.setForeground(new java.awt.Color(153, 0, 51));

        jLabel2.setText("Transport");
        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel3.setText("Order Date:");
        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel5.setText("Branch:");
        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        cmbsupplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbsupplier.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmbsupplier.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbsupplierItemStateChanged(evt);
            }
        });

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ItemNo", "Item Name", "Qty", "Unit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table2.setBackground(new java.awt.Color(255, 255, 51));
        table2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        table2.setGridColor(new java.awt.Color(0, 0, 255));
        jScrollPane2.setViewportView(table2);

        jLabel11.setText("Add Product - F2   Select Supplier - F3     Select Product - F4  Delete Row - F5");
        jLabel11.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jButton4.setText(" Reset");
        jButton4.setBackground(new java.awt.Color(204, 0, 0));
        jButton4.setContentAreaFilled(false);
        jButton4.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setOpaque(true);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Save");
        jButton5.setBackground(new java.awt.Color(204, 0, 0));
        jButton5.setContentAreaFilled(false);
        jButton5.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setOpaque(true);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txtname.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtname.setForeground(new java.awt.Color(153, 0, 51));

        txtid.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtid.setForeground(new java.awt.Color(153, 0, 51));

        jLabel8.setText("Item");
        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel10.setText("Qty");
        jLabel10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel12.setText("Unit");
        jLabel12.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txtunit.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtunit.setForeground(new java.awt.Color(153, 0, 51));

        txtqty.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtqty.setForeground(new java.awt.Color(153, 0, 51));

        jButton6.setText("Add Item");
        jButton6.setBackground(new java.awt.Color(204, 0, 0));
        jButton6.setContentAreaFilled(false);
        jButton6.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setOpaque(true);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Select");
        jButton7.setBackground(new java.awt.Color(204, 0, 0));
        jButton7.setContentAreaFilled(false);
        jButton7.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setOpaque(true);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton12.setText("Delete Raw");
        jButton12.setBackground(new java.awt.Color(204, 0, 0));
        jButton12.setContentAreaFilled(false);
        jButton12.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setOpaque(true);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        lblerror.setBackground(new java.awt.Color(153, 255, 255));
        lblerror.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblerror.setForeground(new java.awt.Color(255, 0, 0));
        lblerror.setOpaque(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(17, 17, 17)
                        .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtunit, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel12)
                                .addGap(28, 28, 28)))
                        .addGap(58, 58, 58)
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(65, 65, 65))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblerror, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbsupplier, 0, 174, Short.MAX_VALUE)
                                    .addComponent(txtdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel20))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtprepared)
                                    .addComponent(txttransport, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtpono, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(txttransport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbsupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtprepared, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtpono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(lblerror, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jButton7))
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtunit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6))
                    .addComponent(txtid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtqty, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton12))
                .addGap(19, 19, 19))
        );

        TabPanel1.addTab("New Purchase Order", jPanel4);

        jButton8.setText("Add Item");
        jButton8.setBackground(new java.awt.Color(204, 0, 0));
        jButton8.setContentAreaFilled(false);
        jButton8.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setOpaque(true);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        txtunit1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtunit1.setForeground(new java.awt.Color(153, 0, 51));

        txtqty1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtqty1.setForeground(new java.awt.Color(153, 0, 51));

        txtname1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtname1.setForeground(new java.awt.Color(153, 0, 51));

        txtid1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtid1.setForeground(new java.awt.Color(153, 0, 51));

        jLabel13.setText("Item");
        jLabel13.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jButton9.setText("Select");
        jButton9.setBackground(new java.awt.Color(204, 0, 0));
        jButton9.setContentAreaFilled(false);
        jButton9.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setOpaque(true);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel14.setText("Qty");
        jLabel14.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel15.setText("Unit");
        jLabel15.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel21.setText("Order No:");
        jLabel21.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel6.setText("Prepared By:");
        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel16.setText("Transport:");
        jLabel16.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txtpono1.setEditable(false);
        txtpono1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtpono1.setForeground(new java.awt.Color(153, 0, 51));

        txtprepared1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtprepared1.setForeground(new java.awt.Color(153, 0, 51));

        txttransport1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txttransport1.setForeground(new java.awt.Color(153, 0, 51));

        jLabel17.setText("Order Date:");
        jLabel17.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel18.setText("Branch:");
        jLabel18.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        cmbsupplier1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbsupplier1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmbsupplier1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbsupplier1ItemStateChanged(evt);
            }
        });

        tab2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ItemNo", "Item Name", "Qty", "Unit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab2.setBackground(new java.awt.Color(255, 255, 51));
        tab2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tab2.setGridColor(new java.awt.Color(0, 0, 255));
        jScrollPane5.setViewportView(tab2);

        jButton10.setText("Update");
        jButton10.setBackground(new java.awt.Color(204, 0, 0));
        jButton10.setContentAreaFilled(false);
        jButton10.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setOpaque(true);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Reset");
        jButton11.setBackground(new java.awt.Color(204, 0, 0));
        jButton11.setContentAreaFilled(false);
        jButton11.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setOpaque(true);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel22.setText("Delete Row - F6");
        jLabel22.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jButton13.setText("Delete Row");
        jButton13.setBackground(new java.awt.Color(204, 0, 0));
        jButton13.setContentAreaFilled(false);
        jButton13.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setOpaque(true);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        lblerror1.setBackground(new java.awt.Color(153, 255, 255));
        lblerror1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblerror1.setForeground(new java.awt.Color(255, 0, 0));
        lblerror1.setOpaque(true);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtid1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtname1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtqty1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtunit1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(301, 301, 301)
                                .addComponent(jLabel14)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel15)
                                .addGap(28, 28, 28)))
                        .addGap(58, 58, 58)
                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(65, 65, 65))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblerror1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbsupplier1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtdate1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel21))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtprepared1)
                                    .addComponent(txttransport1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtpono1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16)
                    .addComponent(txttransport1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cmbsupplier1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtprepared1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtpono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(lblerror1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(jButton9))
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtunit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton8))
                            .addComponent(txtid1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtname1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtqty1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jLabel22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton11)
                        .addComponent(jButton10)
                        .addComponent(jButton13)))
                .addContainerGap())
        );

        TabPanel1.addTab("Edit Purchase Order", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TabPanel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void bntedit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntedit1ActionPerformed
        
         TabPanel1.setSelectedIndex(1);
    }//GEN-LAST:event_bntedit1ActionPerformed

    private void bntedit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntedit2ActionPerformed
        // TODO add your handling code here:
        try{
        int i=table1.getSelectedRow();
        if(i!=-1){
            TabPanel1.setSelectedIndex(2);
            String pono=table1.getValueAt(i, 0)+"";
            ResultSet rs=db.getData("select * from POrder where OrderNo=?", pono);
            if(rs.next()){
                txtpono1.setText(rs.getString(1));
                txtdate1.setDate(LocalDate.parse(rs.getString(2)));
                cmbsupplier1.setSelectedItem(rs.getString(3)+"");
                txttransport1.setText(rs.getString(4));
                txtprepared1.setText(rs.getString(5));
                db.fillTable(tab2, "select OrderNo,ItemName,Qty,Unit From Porderitems where OrderNo=?",txtpono1.getText());
                
                txtdate1.requestFocus();
                
            }
        }else{
            Utility.showWarn("Please select record for editing....", "Select Record");
        }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_bntedit2ActionPerformed

    private void bntedit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntedit3ActionPerformed
        // TODO add your handling code here:
                try{
        int i=table1.getSelectedRow();
        if(i!=-1){            
            if(Utility.showConfirm("Delete selected Order?", "Confirm Delete")==0){
                String no=table1.getValueAt(i, 0)+"";
                db.execute("delete from POrder where OrderNo=?", no);
                db.fillTable(table1, "select * from POrder");
            }
        }else{
            Utility.showWarn("Please select record for deletion....", "Select Record");
        }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_bntedit3ActionPerformed

    private void bntedit4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntedit4ActionPerformed
        // TODO add your handling code here:
         try{
        int i=table1.getSelectedRow();
        if(i!=-1){
            String roll=table1.getValueAt(i, 0)+"";
            HashMap<String,Object> map=new HashMap<>(); //collection of key/value pairs
            map.put("p1", roll);
            db.showReport("src/Reports/Pordermas.jrxml",map);
            
       
        }else{
            Utility.showWarn("Please select raw to print ","Select");
        }
         }catch(Exception ex){
            ex.printStackTrace();
        }
                        
        
    }//GEN-LAST:event_bntedit4ActionPerformed

    private void bntedit5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntedit5ActionPerformed
        // TODO add your handling code here:
        db.showReport("src/Reports/Porder.jrxml");
    }//GEN-LAST:event_bntedit5ActionPerformed

    private void cmbsupplierItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbsupplierItemStateChanged
        // Display Address
      

    }//GEN-LAST:event_cmbsupplierItemStateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
          txtpono.setText(db.getID("OrderNo"));
        txtdate.setDate(LocalDate.now());
        txttransport.setText("");
        txtprepared.setText("");
        txtid.setText("");
        txtname.setText("");
        txtqty.setText("");
        txtunit.setText("");
        cmbsupplier.setSelectedIndex(-1);
        txtdate.requestFocus();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         if(txtname.getText().equals(""))
        {
            lblerror.setText("Add Item First");
            txtname.requestFocus();
            return;
        }
         String orderno=txtpono.getText();
        String orderdate=txtdate.getDate().format(DateTimeFormatter.ISO_DATE);
        String branch=cmbsupplier.getSelectedItem()+"";
        String transport=txttransport.getText();
        String prepared=txtprepared.getText();
        //Master Record Entry
        db.execute("Insert into POrder values(?,?,?,?,?)", orderno,orderdate,branch,transport,prepared);
        
        //Details Entry
        for(int i=0;i<table2.getRowCount();i++){
            String itemno=table2.getValueAt(i, 0).toString();
            String itemname=table2.getValueAt(i, 1).toString();
            String qty=table2.getValueAt(i, 2).toString();
            String unit=table2.getValueAt(i, 3).toString();
            db.execute("Insert into porderitems values(?,?,?,?,?)",orderno,itemno,itemname,qty,unit);
        }
        //Update ID
        db.updateID("OrderNo");
        txtpono.setText(db.getID("OrderNo"));
        db.fillTable(table1, "select * from Porder");
        Utility.showMsg("Material pOrder Generated Successfully..", "Success");  
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         DefaultTableModel dt=(DefaultTableModel)table2.getModel();
        dt.addRow(new Object[]{txtid.getText(),txtname.getText(),txtqty.getText(),txtunit.getText()});
        txtid.requestFocus();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        RawItemForm f=new RawItemForm();
         f.table1.addMouseListener(new MouseAdapter() {
                 @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==1){//double clicked
                    int i=f.table1.getSelectedRow();
                    txtid.setText(f.table1.getValueAt(i, 0)+"");
                    txtname.setText(f.table1.getValueAt(i, 1)+"");
                    txtunit.setText(f.table1.getValueAt(i, 3)+"");
                    f.dispose();
                    txtqty.requestFocus();
                }
            }
            
        });
        f.setVisible(true);
         
        
                                        
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
         DefaultTableModel dt=(DefaultTableModel)tab2.getModel();
        dt.addRow(new Object[]{txtid1.getText(),txtname1.getText(),txtqty1.getText(),txtunit1.getText()});
        txtid1.requestFocus();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        RawItemForm f=new RawItemForm();
         f.table1.addMouseListener(new MouseAdapter() {
                 @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==1){//double clicked
                    int i=f.table1.getSelectedRow();
                    txtid1.setText(f.table1.getValueAt(i, 0)+"");
                    txtname1.setText(f.table1.getValueAt(i, 1)+"");
                    txtunit1.setText(f.table1.getValueAt(i, 3)+"");
                    f.dispose();
                    txtqty.requestFocus();
                }
            }
            
        });
        f.setVisible(true);
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void cmbsupplier1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbsupplier1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbsupplier1ItemStateChanged

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
          if(txtprepared1.getText().equals(""))
        {
            lblerror.setText("Field Is Required");
            txtprepared1.requestFocus();
            return;
        }
        String orderno=txtpono1.getText();
        String odate=txtdate1.getDate().format(DateTimeFormatter.ISO_DATE);
        String branch=cmbsupplier1.getSelectedItem()+"";
        
        String transport=txttransport1.getText();
        String transp=txtprepared1.getText();
        //Master Record Entry
        db.execute("Update POrder set ODate=?,SuppBranch=?,Transport=?,TransportName=? where OrderNo=?",odate,branch,transport,transp,orderno);
        
        //Delete Details Entry
        db.execute("delete from porderitems where OrderNo=?",orderno);
        
        //Details Entry
        for(int i=0;i<tab2.getRowCount();i++){
            String itemno=tab2.getValueAt(i, 0).toString();
            String itemname=tab2.getValueAt(i, 1).toString();
            String qty=tab2.getValueAt(i, 2).toString();
            String unit=tab2.getValueAt(i, 3).toString();
            db.execute("Insert into porderitems values (?,?,?,?,?)",orderno,itemno,itemname,qty,unit);
        }
        db.fillTable(table1, "select * from POrder");
        Utility.showMsg("Purchase Order Modified Successfully..", "Success"); 
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
          txtpono1.setText(db.getID("OrderNo"));
        txtdate1.setDate(LocalDate.now());
        txttransport1.setText("");
        txtprepared1.setText("");
        txtid1.setText("");
        txtname1.setText("");
        txtqty1.setText("");
        txtunit1.setText("");
        cmbsupplier1.setSelectedIndex(-1);
        txtdate1.requestFocus();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        try{
             int i=table2.getSelectedRow();
                    if(i!=-1){
                        DefaultTableModel dt=(DefaultTableModel)table2.getModel();
                        dt.removeRow(i);
        }else{
            Utility.showWarn("Please select Raw for deletion....", "Raw Record");
        }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
         try{
             int i=tab2.getSelectedRow();
                    if(i!=-1){
                        DefaultTableModel dt=(DefaultTableModel)tab2.getModel();
                        dt.removeRow(i);
        }else{
            Utility.showWarn("Please select Raw for deletion....", "Select Raw");
        }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton13ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RtOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RtOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RtOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RtOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RtOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TabPanel1;
    private javax.swing.JButton bntedit1;
    private javax.swing.JButton bntedit2;
    private javax.swing.JButton bntedit3;
    private javax.swing.JButton bntedit4;
    private javax.swing.JButton bntedit5;
    private javax.swing.JComboBox<String> cmbsearch;
    private javax.swing.JComboBox<String> cmbsupplier;
    private javax.swing.JComboBox<String> cmbsupplier1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblerror;
    private javax.swing.JLabel lblerror1;
    private javax.swing.JLabel lblim;
    private javax.swing.JTable tab2;
    public javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private com.github.lgooddatepicker.components.DatePicker txtdate;
    private com.github.lgooddatepicker.components.DatePicker txtdate1;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtid1;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtname1;
    private javax.swing.JTextField txtpono;
    private javax.swing.JTextField txtpono1;
    private javax.swing.JTextField txtprepared;
    private javax.swing.JTextField txtprepared1;
    private javax.swing.JTextField txtqty;
    private javax.swing.JTextField txtqty1;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txttransport;
    private javax.swing.JTextField txttransport1;
    private javax.swing.JTextField txtunit;
    private javax.swing.JTextField txtunit1;
    // End of variables declaration//GEN-END:variables
}
