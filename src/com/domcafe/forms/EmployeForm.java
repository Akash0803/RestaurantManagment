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
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class EmployeForm extends javax.swing.JFrame {
         DBClass db=new DBClass();
         String oldname;
         File file;
         
    /**
     * Creates new form LoginForm
     */
    public EmployeForm() {
        initComponents();
        getContentPane().setBackground(new Color(255,255,204));
        Utility.resizeLabelImage(lblim);
        Utility.resizeLabelImage(lblim3);
         Utility.resizeLabelImage(lblim2);
        getRootPane().setBorder(BorderFactory.createEtchedBorder());
         getRootPane().setDefaultButton(btnsave);
         db.fillCombo(cmbdept1,"select * from department");
         db.fillCombo(cmbdept,"select * from department");
         db.fillCombo(cmbbank2,"select * from Bank","BankName","BankCode");
           db.fillCombo(cmbbank,"select * from Bank","BankName","BankCode");
         db.fillTable2(table1, "select * from employee");
         
    
          

          txtnme.requestFocus();
           txtbcode.setInputVerifier(new InputVerifier() {
            @Override
            
            public boolean verify(JComponent input) {
                String trs=txtbcode.getText();
                if(trs.equals("")){
               lblerror1.setText("Bank Code Can't be left empty");
               txtbcode.requestFocus();
               return false;
               }else{
                  return true;
              }
            }
        });
            txtbcode1.setInputVerifier(new InputVerifier() {
            @Override
            
            public boolean verify(JComponent input) {
                String trs=txtbcode1.getText();
                if(trs.equals("")){
               lblerror.setText("Bank Code Filed Can't be left empty");
               txtbcode1.requestFocus();
               return false;
               }else{
                  return true;
              }
            }
        });
             txtnme.setInputVerifier(new InputVerifier() {
            @Override
            
            public boolean verify(JComponent input) {
                String trs=txtnme.getText();
                if(trs.equals("")){
               lblerror1.setText("Name Can't be left empty");
               txtnme.requestFocus();
               return false;
               }else{
                  return true;
              }
            }
        });
                txtnme1.setInputVerifier(new InputVerifier() {
            @Override
            
            public boolean verify(JComponent input) {
                String trs=txtnme1.getText();
                if(trs.equals("")){
               lblerror.setText("Name Can't be left empty");
               txtnme1.requestFocus();
               return false;
               }else{
                  return true;
              }
            }
        });
                   txtac.setInputVerifier(new InputVerifier() {
            @Override
            
            public boolean verify(JComponent input) {
                String trs=txtac.getText();
                if(trs.equals("")){
               lblerror1.setText("Account No Can't be left empty");
               txtac.requestFocus();
               return false;
               }else{
                  return true;
              }
            }
        });
                           txtac1.setInputVerifier(new InputVerifier() {
            @Override
            
            public boolean verify(JComponent input) {
                String trs=txtac1.getText();
                if(trs.equals("")){
               lblerror.setText("Account No Can't be left empty");
               txtac1.requestFocus();
               return false;
               }else{
                  return true;
              }
            }
        });
               txtadhar.setInputVerifier(new InputVerifier() {
            @Override
            
            public boolean verify(JComponent input) {
                String trs=txtadhar.getText();
                if(trs.equals("")){
               lblerror1.setText("Adhar No Can't be left empty");
               txtadhar.requestFocus();
               return false;
               }else{
                  return true;
              }
            }
        });
                   txtadhar1.setInputVerifier(new InputVerifier() {
            @Override
            
            public boolean verify(JComponent input) {
                String trs=txtadhar1.getText();
                if(trs.equals("")){
               lblerror.setText("Adhar No Can't be left empty");
               txtadhar1.requestFocus();
               return false;
               }else{
                  return true;
              }
            }
        });
                       txtadd.setInputVerifier(new InputVerifier() {
            @Override
            
            public boolean verify(JComponent input) {
                String trs=txtadd.getText();
                if(trs.equals("")){
               lblerror1.setText("Address No Can't be left empty");
               txtadd.requestFocus();
               return false;
               }else{
                  return true;
              }
            }
        });
                                  txtaddress.setInputVerifier(new InputVerifier() {
            @Override
            
            public boolean verify(JComponent input) {
                String trs=txtaddress.getText();
                if(trs.equals("")){
               lblerror.setText("Address No Can't be left empty");
               txtaddress.requestFocus();
               return false;
               }else{
                  return true;
              }
            }
        });
                                   txtmobile.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String mobile=txtmobile.getText();
                if(mobile.equals("")){
                    lblerror1.setText("Mobile No is required");
                    return false;
                }else{
                    if(mobile.matches("^[0-9]{10}$")){
                        lblerror1.setText("");
                        return true;
                    }else{
                        lblerror1.setText("Mobile No must be of 10 digits");
                        return false;
                    }
                }
            }
        });
           txtmail.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String email=txtmail.getText();
                if(email.equals("")){
                    lblerror1.setText("Email ID is required");
                    return false;
                }else{
                    if(email.matches("^\\w+@\\w+\\.\\w{2,3}(\\.\\w{2,3})?$")){
                        lblerror1.setText("");
                        return true;
                    }else{
                        lblerror1.setText("Invalid format of Email ID");
                        return false;
                    }
                }
            }
        });
            txtmobile1.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String mobile=txtmobile1.getText();
                if(mobile.equals("")){
                    lblerror.setText("Mobile No is required");
                    return false;
                }else{
                    if(mobile.matches("^[0-9]{10}$")){
                        lblerror.setText("");
                        return true;
                    }else{
                        lblerror.setText("Mobile No must be of 10 digits");
                        return false;
                    }
                }
            }
        });
           txtmail1.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String email=txtmail1.getText();
                if(email.equals("")){
                    lblerror.setText("Email ID is required");
                    return false;
                }else{
                    if(email.matches("^\\w+@\\w+\\.\\w{2,3}(\\.\\w{2,3})?$")){
                        lblerror.setText("");
                        return true;
                    }else{
                        lblerror.setText("Invalid format of Email ID");
                        return false;
                    }
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        lblim = new javax.swing.JLabel();
        tabpan = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        txtsearch = new javax.swing.JTextField();
        cmbsearch = new javax.swing.JComboBox<>();
        bntedit1 = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        bntedit = new javax.swing.JButton();
        bntedit2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtno1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cmbdept1 = new javax.swing.JComboBox<>();
        txtmobile1 = new javax.swing.JTextField();
        cmbtype1 = new javax.swing.JComboBox<>();
        cmbbank2 = new javax.swing.JComboBox<>();
        txtnme1 = new javax.swing.JTextField();
        txtadhar1 = new javax.swing.JTextField();
        txtbcode1 = new javax.swing.JTextField();
        txtac1 = new javax.swing.JTextField();
        txtmail1 = new javax.swing.JTextField();
        btnclear1 = new javax.swing.JButton();
        btnsave3 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaddress = new javax.swing.JTextArea();
        jLabel26 = new javax.swing.JLabel();
        txtbdte = new com.github.lgooddatepicker.components.DatePicker();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        rbmale1 = new javax.swing.JRadioButton();
        rbfemale1 = new javax.swing.JRadioButton();
        jLabel29 = new javax.swing.JLabel();
        cmbblood = new javax.swing.JComboBox<>();
        btnbrw2 = new javax.swing.JButton();
        lblim3 = new javax.swing.JLabel();
        txtdl1 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        lblerror = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbdept = new javax.swing.JComboBox<>();
        txtmobile = new javax.swing.JTextField();
        cmbtype = new javax.swing.JComboBox<>();
        cmbbank = new javax.swing.JComboBox<>();
        txtnme = new javax.swing.JTextField();
        txtadhar = new javax.swing.JTextField();
        txtbcode = new javax.swing.JTextField();
        txtac = new javax.swing.JTextField();
        txtmail = new javax.swing.JTextField();
        lblim2 = new javax.swing.JLabel();
        btnbrw = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtadd = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        txtbdate = new com.github.lgooddatepicker.components.DatePicker();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        rbmale = new javax.swing.JRadioButton();
        rbfemale = new javax.swing.JRadioButton();
        cmbbld = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtdl = new javax.swing.JTextField();
        lblerror1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee Details");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Employee Details");
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

        lblim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/emp.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblim, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        tabpan.setForeground(new java.awt.Color(0, 0, 204));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "Department", "Type", "Name", "Address", "Birth Date", "Gender", "Blood Group", "Adhar No", "Mobile No", "Email", "Driving License ", "Bank", "IFSC", "Bank Account", "Photo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.setBackground(new java.awt.Color(204, 255, 204));
        jScrollPane3.setViewportView(table1);

        txtsearch.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        cmbsearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Department", "EmployeeType", "Name", "Gender", "blood", "Adhar", "Mobile" }));

        bntedit1.setText("New Employee");
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

        btndelete.setText("Delete");
        btndelete.setBackground(new java.awt.Color(204, 0, 0));
        btndelete.setContentAreaFilled(false);
        btndelete.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setOpaque(true);
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        bntedit.setText("Print");
        bntedit.setBackground(new java.awt.Color(204, 0, 0));
        bntedit.setContentAreaFilled(false);
        bntedit.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        bntedit.setForeground(new java.awt.Color(255, 255, 255));
        bntedit.setOpaque(true);
        bntedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnteditActionPerformed(evt);
            }
        });

        bntedit2.setText("Edit");
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bntedit1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntedit2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntedit, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(cmbsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsearch, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                .addGap(149, 149, 149))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bntedit2)
                    .addComponent(btndelete)
                    .addComponent(bntedit1)
                    .addComponent(bntedit))
                .addGap(16, 16, 16))
        );

        tabpan.addTab("Employee List", jPanel4);

        txtno1.setEditable(false);
        txtno1.setText("(auto)");
        txtno1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtno1ActionPerformed(evt);
            }
        });

        jLabel16.setText("Employee ID.");
        jLabel16.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel17.setText("Department:");
        jLabel17.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        cmbdept1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Member", "Non-Member" }));
        cmbdept1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cmbdept1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbdept1ActionPerformed(evt);
            }
        });

        txtmobile1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtmobile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmobile1ActionPerformed(evt);
            }
        });

        cmbtype1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Permenant", "Non-Permenant" }));
        cmbtype1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cmbtype1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbtype1ActionPerformed(evt);
            }
        });

        cmbbank2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbbank2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbbank2ItemStateChanged(evt);
            }
        });

        txtnme1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtnme1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnme1ActionPerformed(evt);
            }
        });

        txtadhar1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtadhar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtadhar1ActionPerformed(evt);
            }
        });

        txtbcode1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtbcode1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbcode1ActionPerformed(evt);
            }
        });

        txtac1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtac1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtac1ActionPerformed(evt);
            }
        });

        txtmail1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtmail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmail1ActionPerformed(evt);
            }
        });

        btnclear1.setText("Clear");
        btnclear1.setBackground(new java.awt.Color(204, 0, 0));
        btnclear1.setContentAreaFilled(false);
        btnclear1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnclear1.setForeground(new java.awt.Color(255, 255, 255));
        btnclear1.setOpaque(true);
        btnclear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclear1ActionPerformed(evt);
            }
        });

        btnsave3.setText("Save");
        btnsave3.setBackground(new java.awt.Color(204, 0, 0));
        btnsave3.setContentAreaFilled(false);
        btnsave3.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnsave3.setForeground(new java.awt.Color(255, 255, 255));
        btnsave3.setOpaque(true);
        btnsave3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsave3ActionPerformed(evt);
            }
        });

        jLabel18.setText("Employee Name:");
        jLabel18.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel19.setText("AdharCard No:");
        jLabel19.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel20.setText("Email ID:");
        jLabel20.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel21.setText("Account No:");
        jLabel21.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel22.setText("Bank Code:");
        jLabel22.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel23.setText("Bank:");
        jLabel23.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel24.setText("Contact No:");
        jLabel24.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel25.setText("Employee Type:");
        jLabel25.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        txtaddress.setColumns(20);
        txtaddress.setRows(5);
        jScrollPane2.setViewportView(txtaddress);

        jLabel26.setText("Address:");
        jLabel26.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel27.setText("Birth Date:");
        jLabel27.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel28.setText("Gender:");
        jLabel28.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        buttonGroup1.add(rbmale1);
        rbmale1.setText("Male");

        buttonGroup1.add(rbfemale1);
        rbfemale1.setText("Female");

        jLabel29.setText("Blood Group:");
        jLabel29.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        cmbblood.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "AB+", "AB-", "B+", "B-", "O+", "O-" }));
        cmbblood.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbbloodItemStateChanged(evt);
            }
        });

        btnbrw2.setText("Browse");
        btnbrw2.setBackground(new java.awt.Color(204, 0, 0));
        btnbrw2.setContentAreaFilled(false);
        btnbrw2.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnbrw2.setForeground(new java.awt.Color(255, 255, 255));
        btnbrw2.setOpaque(true);
        btnbrw2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbrw2ActionPerformed(evt);
            }
        });

        lblim3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/photo.jpg"))); // NOI18N
        lblim3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtdl1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtdl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdl1ActionPerformed(evt);
            }
        });

        jLabel31.setText("DL No:");
        jLabel31.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        lblerror.setBackground(new java.awt.Color(153, 255, 255));
        lblerror.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblerror.setForeground(new java.awt.Color(255, 0, 0));
        lblerror.setOpaque(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel25)
                            .addComponent(jLabel23)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21))
                        .addGap(223, 223, 223))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtadhar1)
                                    .addComponent(txtac1)
                                    .addComponent(cmbtype1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbdept1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtbcode1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbbank2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtno1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtdl1)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtmobile1)
                                    .addComponent(txtmail1))
                                .addGap(8, 8, 8)))))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtbdte, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnme1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnbrw2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblim3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbblood, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(rbmale1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbfemale1)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(btnsave3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnclear1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(lblerror, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(cmbdept1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbtype1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(cmbbank2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtbcode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtac1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtadhar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbblood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblerror, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(btnclear1)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(btnsave3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtdl1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel24)
                                    .addComponent(txtmobile1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnme1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbdte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(rbmale1)
                            .addComponent(rbfemale1)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblim3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnbrw2)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 45, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        tabpan.addTab("Employee Details", jPanel5);

        txtno.setEditable(false);
        txtno.setText("(auto)");
        txtno.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnoActionPerformed(evt);
            }
        });

        jLabel2.setText("Employee ID.");
        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel4.setText("Department:");
        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        cmbdept.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Member", "Non-Member" }));
        cmbdept.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cmbdept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbdeptActionPerformed(evt);
            }
        });

        txtmobile.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtmobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmobileActionPerformed(evt);
            }
        });

        cmbtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Permenant", "Non-Permenant" }));
        cmbtype.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cmbtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbtypeActionPerformed(evt);
            }
        });

        cmbbank.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbbank.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbbankItemStateChanged(evt);
            }
        });

        txtnme.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtnme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnmeActionPerformed(evt);
            }
        });

        txtadhar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtadhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtadharActionPerformed(evt);
            }
        });

        txtbcode.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtbcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbcodeActionPerformed(evt);
            }
        });

        txtac.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtacActionPerformed(evt);
            }
        });

        txtmail.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmailActionPerformed(evt);
            }
        });

        lblim2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/photo.jpg"))); // NOI18N
        lblim2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnbrw.setText("Browse");
        btnbrw.setBackground(new java.awt.Color(204, 0, 0));
        btnbrw.setContentAreaFilled(false);
        btnbrw.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnbrw.setForeground(new java.awt.Color(255, 255, 255));
        btnbrw.setOpaque(true);
        btnbrw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbrwActionPerformed(evt);
            }
        });

        btnclear.setText("Clear");
        btnclear.setBackground(new java.awt.Color(204, 0, 0));
        btnclear.setContentAreaFilled(false);
        btnclear.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnclear.setForeground(new java.awt.Color(255, 255, 255));
        btnclear.setOpaque(true);
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        btnsave.setText("Update ");
        btnsave.setBackground(new java.awt.Color(204, 0, 0));
        btnsave.setContentAreaFilled(false);
        btnsave.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnsave.setForeground(new java.awt.Color(255, 255, 255));
        btnsave.setOpaque(true);
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        jLabel3.setText("Employee Name:");
        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel5.setText("AdharCard No:");
        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel13.setText("Email ID:");
        jLabel13.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel12.setText("Account No:");
        jLabel12.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel6.setText("Bank Code:");
        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel7.setText("Bank:");
        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel11.setText("Contact No:");
        jLabel11.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel10.setText("Employee Type:");
        jLabel10.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        txtadd.setColumns(20);
        txtadd.setRows(5);
        jScrollPane1.setViewportView(txtadd);

        jLabel8.setText("Address:");
        jLabel8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel9.setText("Birth Date:");
        jLabel9.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel14.setText("Gender:");
        jLabel14.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        buttonGroup1.add(rbmale);
        rbmale.setText("Male");

        buttonGroup1.add(rbfemale);
        rbfemale.setText("Female");

        cmbbld.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "AB+", "AB-", "B+", "B-", "O+", "O-" }));
        cmbbld.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbbldItemStateChanged(evt);
            }
        });
        cmbbld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbbldActionPerformed(evt);
            }
        });

        jLabel15.setText("Blood Group:");
        jLabel15.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel30.setText("DL No:");
        jLabel30.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        txtdl.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtdl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdlActionPerformed(evt);
            }
        });

        lblerror1.setBackground(new java.awt.Color(153, 255, 255));
        lblerror1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblerror1.setForeground(new java.awt.Color(255, 0, 0));
        lblerror1.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmobile)
                            .addComponent(txtmail)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdl)
                            .addComponent(txtadhar)
                            .addComponent(txtac)
                            .addComponent(cmbtype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbdept, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtbcode, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbbank, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtno, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jLabel14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cmbbld, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(rbmale)
                                    .addGap(18, 18, 18)
                                    .addComponent(rbfemale)))
                            .addComponent(lblerror1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtbdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtnme, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnbrw, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblim2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(280, 280, 280))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(rbmale)
                            .addComponent(rbfemale))
                        .addGap(1, 1, 1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(cmbdept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cmbbank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtbcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtadhar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblim2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnbrw)))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbbld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblerror1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnsave)
                            .addComponent(btnclear)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(txtmobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        tabpan.addTab("Edit Employee Details", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tabpan)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabpan))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed

                          if(txtbdate.getText().equals(""))
        {
            lblerror1.setText("Birth Date is Required");
            txtbdate.requestFocus();
            return;
        }
                                  if(txtnme.getText().equals(""))
        {
            lblerror1.setText("Name is Required");
            txtnme.requestFocus();
            return;
        }
        String no=txtno.getText();
            String type=cmbtype.getSelectedItem()+"";
            String department=cmbdept.getSelectedItem()+"";
            String blood=cmbbld.getSelectedItem()+"";
            String name=txtnme.getText();
           String mobile=txtmobile.getText();
        String adhar=txtadhar.getText();
        String bankcode=txtbcode.getText();
        String address=txtadd.getText();
        String bankname=cmbbank.getSelectedItem()+"";
        String email=txtmail.getText();
        String dl=txtdl.getText();
         String gender;
        if(rbmale.isSelected()){
            gender="Male";
        }else{
            gender="Female";
        }
         LocalDate lbdate=txtbdate.getDate();
         String bdate=lbdate.format(DateTimeFormatter.ISO_DATE);
        
        String acname=txtac.getText();
       
            db.execute("Update employee set Section=?,EmployeeType=?,Name=?,Address=?,Bdate=?,Gender=?,blood=?,Adhar=?,Mobile=?,Email=?,DLNo=?,BankName=?,BankCode=?,AccountNo=?,Image=? where employeeID=?",department,type,name,address,bdate,gender,blood,adhar,mobile,email,dl,bankname,bankcode,acname,file,no);
            JOptionPane.showMessageDialog(this,"Employee Details is updated","Upated", JOptionPane.QUESTION_MESSAGE);
        
        db.fillTable2(table1, "select * from employee");
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        txtno.setText("(auto)");
           cmbtype.setSelectedIndex(-1);
            cmbdept.setSelectedIndex(-1);
          cmbbld.setSelectedIndex(-1);
          cmbbank.setSelectedIndex(-1);
          txtnme.setText("");
         txtmobile.setText("");
         txtbdate.setText("");
       txtadhar.setText("");
        txtbcode.setText("");
        txtadd.setText("");
        txtmail.setText("");
        txtdl.setText("");
       rbfemale.setSelected(false);
        rbmale.setSelected(false);
        txtac.setText("");
        File f=new File("src/images/photo.jpg");
         Utility.setLabelImage(lblim2,f); 
    }//GEN-LAST:event_btnclearActionPerformed

    private void btnbrwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbrwActionPerformed
        // TODO add your handling code here:
        JFileChooser jf=new JFileChooser();
        jf.setDialogTitle("Choose Image");
        int ans=jf.showOpenDialog(this);
        //If click on open button it returns JFileChooser.APPROVE_OPTION and on cancel
        //returns JFileChooser.CANCEL_OPTION
        if(ans==JFileChooser.APPROVE_OPTION){
            file=jf.getSelectedFile(); //returns selected file object
            Utility.setLabelImage(lblim2, file);
        }
    }//GEN-LAST:event_btnbrwActionPerformed

    private void txtmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmailActionPerformed

    private void txtacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtacActionPerformed

    private void txtbcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbcodeActionPerformed

    private void txtadharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadharActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtadharActionPerformed

    private void txtnmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnmeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnmeActionPerformed

    private void cmbbankItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbbankItemStateChanged
        // TODO add your handling code here:
        ComboItem ci=(ComboItem)cmbbank.getSelectedItem();
        //System.out.println(ci);
        if(ci!=null){
            txtbcode.setText(ci.data.get("BankCode")+"");
        }
    }//GEN-LAST:event_cmbbankItemStateChanged

    private void cmbtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbtypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtypeActionPerformed

    private void txtmobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmobileActionPerformed

    private void cmbdeptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbdeptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbdeptActionPerformed

    private void txtnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnoActionPerformed

    private void cmbbldItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbbldItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbldItemStateChanged

    private void txtno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtno1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtno1ActionPerformed

    private void cmbdept1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbdept1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbdept1ActionPerformed

    private void txtmobile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmobile1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmobile1ActionPerformed

    private void cmbtype1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbtype1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtype1ActionPerformed

    private void cmbbank2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbbank2ItemStateChanged
        // TODO add your handling code here:
         ComboItem ci=(ComboItem)cmbbank2.getSelectedItem();
        //System.out.println(ci);
        if(ci!=null){
        txtbcode1.setText(ci.data.get("BankCode")+"");
        }
    }//GEN-LAST:event_cmbbank2ItemStateChanged

    private void txtnme1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnme1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnme1ActionPerformed

    private void txtadhar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadhar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtadhar1ActionPerformed

    private void txtbcode1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbcode1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbcode1ActionPerformed

    private void txtac1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtac1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtac1ActionPerformed

    private void txtmail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmail1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmail1ActionPerformed

    private void btnclear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclear1ActionPerformed
        // TODO add your handling code here:
        txtno1.setText("(auto)");
           cmbtype1.setSelectedIndex(-1);
            cmbdept1.setSelectedIndex(-1);
          cmbblood.setSelectedIndex(-1);
          cmbbank2.setSelectedIndex(-1);
          txtnme1.setText("");
         txtmobile1.setText("");
       txtadhar1.setText("");
        txtbcode1.setText("");
        txtaddress.setText("");
        txtmail1.setText("");
        txtdl1.setText("");
       rbmale1.setSelected(false);
        rbfemale1.setSelected(false);
        txtac1.setText("");
        File f=new File("src/images/photo.jpg");
         Utility.setLabelImage(lblim3,f); 
        
    }//GEN-LAST:event_btnclear1ActionPerformed

    private void btnsave3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsave3ActionPerformed
                        if(txtbdate.getText().equals(""))
        {
            lblerror.setText("Birth Date is Required");
            txtbdate.requestFocus();
            return;
        }
                                  if(txtnme1.getText().equals(""))
        {
            lblerror.setText("Name is Required");
            txtnme1.requestFocus();
            return;
        }
           String no=txtno1.getText();
            String type=cmbtype.getSelectedItem()+"";
            String department=cmbdept1.getSelectedItem()+"";
            String blood=cmbblood.getSelectedItem()+"";
            String name=txtnme1.getText();
           String mobile=txtmobile1.getText();
        String adhar=txtadhar1.getText();
        String bankcode=txtbcode1.getText();
        String address=txtaddress.getText();
        String bankname=cmbbank2.getSelectedItem()+"";
        String email=txtmail1.getText();
        String dl=txtdl1.getName();
         String gender;
        if(rbmale1.isSelected()){
            gender="Male";
        }else{
            gender="Female";
        }
         LocalDate lbdate=txtbdte.getDate();
         String bdate=lbdate.format(DateTimeFormatter.ISO_DATE);
        
        String acname=txtac1.getText();
        
       
            db.execute("Insert into employee (Section,EmployeeType,Name,Address,Bdate,Gender,blood,Adhar,Mobile,Email,DLNo,BankName,BankCode,AccountNo,Image) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",department,type,name,address,bdate,gender,blood,adhar,mobile,email,dl,bankname,bankcode,acname,file);
            Utility.showMsg("Item entry is saved..","Saved");
       
        db.fillTable2(table1, "select * from employee");
    }//GEN-LAST:event_btnsave3ActionPerformed

    private void bntedit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntedit1ActionPerformed
         tabpan.setSelectedIndex(1);
    }//GEN-LAST:event_bntedit1ActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // delete
        try{
            int i=table1.getSelectedRow();
            if(i!=-1){
                if(Utility.showConfirm("Delete selected Employee record?", "Confirm Delete")==0){
                    String no=table1.getValueAt(i, 0)+"";
                    db.execute("delete from Employee where EmployeeID=?", no);
                    db.fillTable2(table1,"select * from employee");
                }
            }else{
                Utility.showWarn("Please select record for deletion....", "Select Record");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btndeleteActionPerformed

    private void bnteditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnteditActionPerformed
        // print
        db.showReport("src/reports/Employe.jrxml");
    }//GEN-LAST:event_bnteditActionPerformed

    private void bntedit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntedit2ActionPerformed
        try{
        int i=table1.getSelectedRow();
         if(i!=-1){
            
                tabpan.setSelectedIndex(2);
                String id=table1.getValueAt(i, 0)+"";
                ResultSet rs=db.getData("select * from employee where employeeID=?", id);
                if(rs.next()){
                    txtno.setText(rs.getString(1));
                    cmbdept.setSelectedItem(rs.getString(2));
                    cmbtype.setSelectedItem(rs.getString(3));
                    txtnme.setText(rs.getString(4));
                    txtadd.setText(rs.getString(5));
                    txtbdate.setDate(LocalDate.parse(rs.getString(6)));
                    String gender=rs.getString(7);
                if(gender.equals("Male")){
                rbmale1.setSelected(true);
                }else{
                rbfemale1.setSelected(true);
                }
                cmbbld.setSelectedItem(rs.getString(8));
                txtadhar.setText(rs.getString(9));
                txtmobile.setText(rs.getString(10));
                txtmail.setText(rs.getString(11));
                txtdl.setText(rs.getString(12));
                cmbbank.setSelectedItem(rs.getString(13));
                txtbcode.setText(rs.getString(14));
                txtac.setText(rs.getString(15));
                InputStream in=rs.getBinaryStream(16);                
                byte b[]=new byte[in.available()];
                in.read(b);
                file=File.createTempFile("item", null);                
                FileOutputStream fos=new FileOutputStream(file);
                fos.write(b);
                fos.close();
                Utility.setLabelImage(lblim2, file);  
                btnsave.setText("Update");
                txtnme.requestFocus();
                }
         
         }else{
            Utility.showWarn("Please select record for editing....", "Select Record");
         
        }
          }catch(Exception ex){
            ex.printStackTrace();
        }
        
         
         
    }//GEN-LAST:event_bntedit2ActionPerformed

    private void cmbbloodItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbbloodItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbloodItemStateChanged

    private void btnbrw2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbrw2ActionPerformed
        // TODO add your handling code here:
           JFileChooser jf=new JFileChooser();
        jf.setDialogTitle("Choose Image");
        int ans=jf.showOpenDialog(this);
        //If click on open button it returns JFileChooser.APPROVE_OPTION and on cancel
        //returns JFileChooser.CANCEL_OPTION
        if(ans==JFileChooser.APPROVE_OPTION){
            file=jf.getSelectedFile(); //returns selected file object            
            Utility.setLabelImage(lblim3, file);
        }
    }//GEN-LAST:event_btnbrw2ActionPerformed

    private void cmbbldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbldActionPerformed

    private void txtdlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdlActionPerformed

    private void txtdl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdl1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdl1ActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new EmployeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntedit;
    private javax.swing.JButton bntedit1;
    private javax.swing.JButton bntedit2;
    private javax.swing.JButton btnbrw;
    private javax.swing.JButton btnbrw2;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnclear1;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnsave3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbbank;
    private javax.swing.JComboBox<String> cmbbank2;
    private javax.swing.JComboBox<String> cmbbld;
    private javax.swing.JComboBox<String> cmbblood;
    private javax.swing.JComboBox<String> cmbdept;
    private javax.swing.JComboBox<String> cmbdept1;
    private javax.swing.JComboBox<String> cmbsearch;
    private javax.swing.JComboBox<String> cmbtype;
    private javax.swing.JComboBox<String> cmbtype1;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblerror;
    private javax.swing.JLabel lblerror1;
    private javax.swing.JLabel lblim;
    private javax.swing.JLabel lblim2;
    private javax.swing.JLabel lblim3;
    private javax.swing.JRadioButton rbfemale;
    private javax.swing.JRadioButton rbfemale1;
    private javax.swing.JRadioButton rbmale;
    private javax.swing.JRadioButton rbmale1;
    public javax.swing.JTable table1;
    private javax.swing.JTabbedPane tabpan;
    private javax.swing.JTextField txtac;
    private javax.swing.JTextField txtac1;
    private javax.swing.JTextArea txtadd;
    private javax.swing.JTextArea txtaddress;
    private javax.swing.JTextField txtadhar;
    private javax.swing.JTextField txtadhar1;
    private javax.swing.JTextField txtbcode;
    private javax.swing.JTextField txtbcode1;
    private com.github.lgooddatepicker.components.DatePicker txtbdate;
    private com.github.lgooddatepicker.components.DatePicker txtbdte;
    private javax.swing.JTextField txtdl;
    private javax.swing.JTextField txtdl1;
    private javax.swing.JTextField txtmail;
    private javax.swing.JTextField txtmail1;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JTextField txtmobile1;
    private javax.swing.JTextField txtnme;
    private javax.swing.JTextField txtnme1;
    private javax.swing.JTextField txtno;
    private javax.swing.JTextField txtno1;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
