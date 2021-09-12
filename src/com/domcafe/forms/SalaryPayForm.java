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
import com.github.lgooddatepicker.components.DateTimePicker;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
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
public class SalaryPayForm extends javax.swing.JFrame {
         DBClass db=new DBClass();
         String oldname;
         File file;
         public static SalaryForm parent;
         
         
    /**
     * Creates new form LoginForm
     */
    public SalaryPayForm() {
        initComponents();
        getContentPane().setBackground(new Color(255,255,204));
        Utility.resizeLabelImage(lblim);
        getRootPane().setBorder(BorderFactory.createEtchedBorder());
         getRootPane().setDefaultButton(btnsave);
          db.fillTable(table1, "select * from salarypay");
          db.applySearch(table1, cmbsearch, txtsearch, "select * salarypay");
          //db.fillCombo(cmbvcode,"Select * From Village");
          txtbasic.requestFocus();
          txtdt.setDateTimePermissive(LocalDateTime.now());
          txtname.setInputVerifier(new InputVerifier() {
            @Override
            
            public boolean verify(JComponent input) {
                String trs=txtname.getText();
                if(trs.equals("")){
               lblerror.setText("Name Can't Be left empty");
               txtname.requestFocus();
               return false;
               }else{
                    lblerror.setText("");
                  return true;
              }
            }
        });
           txtbasic.setInputVerifier(new InputVerifier() {
            @Override
            
            public boolean verify(JComponent input) {
                String trs=txtbasic.getText();
                if(trs.equals("")){
               lblerror.setText("Field Can't Be left empty");
               txtbasic.requestFocus();
               return false;
               }else{
                    lblerror.setText("");
                  return true;
              }
            }
        });
            txtins.setInputVerifier(new InputVerifier() {
            @Override
            
            public boolean verify(JComponent input) {
                String trs=txtins.getText();
                if(trs.equals("")){
               lblerror.setText("Field Can't Be left empty");
               txtins.requestFocus();
               return false;
               }else{
                    lblerror.setText("");
                  return true;
              }
            }
        });
              txtpf.setInputVerifier(new InputVerifier() {
            @Override
            
            public boolean verify(JComponent input) {
                String trs=txtpf.getText();
                if(trs.equals("")){
               lblerror.setText("Field Can't Be left empty");
               txtpf.requestFocus();
               return false;
               }else{
                    lblerror.setText("");
                  return true;
              }
            }
        });
               txtincent.setInputVerifier(new InputVerifier() {
            @Override
            
            public boolean verify(JComponent input) {
                String trs=txtincent.getText();
                if(trs.equals("")){
               lblerror.setText("Field Can't Be left empty");
               txtincent.requestFocus();
               return false;
               }else{
                    lblerror.setText("");
                  return true;
              }
            }
        });
                  txtda.setInputVerifier(new InputVerifier() {
            @Override
            
            public boolean verify(JComponent input) {
                String trs=txtda.getText();
                if(trs.equals("")){
               lblerror.setText("Field Can't Be left empty");
               txtda.requestFocus();
               return false;
               }else{
                    lblerror.setText("");
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtno = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtins = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txttax = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtda = new javax.swing.JTextField();
        txtincent = new javax.swing.JTextField();
        txtpf = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnsave1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtbasic = new javax.swing.JTextField();
        txtnet = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        cmbpay = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtdt = new com.github.lgooddatepicker.components.DateTimePicker();
        lblerror = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        bntedit = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cmbsearch = new javax.swing.JComboBox<>();
        txtsearch = new javax.swing.JTextField();
        bntedit1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Category");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Salary Details");
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

        lblim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/farmer icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblim, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 317, Short.MAX_VALUE)
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Add/Edit"));
        jPanel2.setToolTipText("");

        jLabel2.setText("Sr.No");
        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        txtno.setEditable(false);
        txtno.setText("(auto)");
        txtno.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnoActionPerformed(evt);
            }
        });

        btnsave.setText("Save");
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

        jLabel3.setText("Name:");
        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel10.setText("Employe ID:");
        jLabel10.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        txtname.setEditable(false);
        txtname.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        txtid.setEditable(false);
        txtid.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        jLabel8.setText("Insurance:");
        jLabel8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        txtins.setEditable(false);
        txtins.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtins.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtinsFocusLost(evt);
            }
        });
        txtins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtinsActionPerformed(evt);
            }
        });

        jLabel15.setText("Income Tax:");
        jLabel15.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        txttax.setEditable(false);
        txttax.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txttax.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txttaxFocusLost(evt);
            }
        });
        txttax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttaxActionPerformed(evt);
            }
        });

        jLabel16.setText("DA:");
        jLabel16.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel17.setText("Incentive Performance:");
        jLabel17.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        txtda.setEditable(false);
        txtda.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtdaFocusLost(evt);
            }
        });
        txtda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdaActionPerformed(evt);
            }
        });

        txtincent.setEditable(false);
        txtincent.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtincent.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtincentFocusLost(evt);
            }
        });
        txtincent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtincentActionPerformed(evt);
            }
        });

        txtpf.setEditable(false);
        txtpf.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtpfFocusLost(evt);
            }
        });
        txtpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpfActionPerformed(evt);
            }
        });

        jLabel11.setText("PF Amount:");
        jLabel11.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        btnsave1.setText("Select");
        btnsave1.setBackground(new java.awt.Color(204, 0, 0));
        btnsave1.setContentAreaFilled(false);
        btnsave1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnsave1.setForeground(new java.awt.Color(255, 255, 255));
        btnsave1.setOpaque(true);
        btnsave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsave1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Basic:");
        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        txtbasic.setEditable(false);
        txtbasic.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtbasic.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtbasicFocusLost(evt);
            }
        });
        txtbasic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbasicActionPerformed(evt);
            }
        });

        txtnet.setEditable(false);
        txtnet.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtnet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnetActionPerformed(evt);
            }
        });

        jLabel19.setText("Net Salary:");
        jLabel19.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        cmbpay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paid" }));
        cmbpay.setSelectedIndex(-1);

        jLabel20.setText("Status:");
        jLabel20.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel12.setText("Payment Date:");
        jLabel12.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        lblerror.setBackground(new java.awt.Color(153, 255, 255));
        lblerror.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblerror.setForeground(new java.awt.Color(255, 0, 0));
        lblerror.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtname)
                            .addComponent(txtdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txttax)
                                    .addComponent(txtda)
                                    .addComponent(txtincent, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbpay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtnet, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(48, 48, 48))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtpf, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtins, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtbasic, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblerror, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnsave1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(167, 167, 167))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbasic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttax, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtincent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbpay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtpf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblerror, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnsave1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnsave, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnclear, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(32, 32, 32))
        );

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Sr No", "ID", "Name", "Basic", "Insurance", "Pf", "Tax", "DA", "Incentive", "Net Salary", "Status", "Date/Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.setBackground(new java.awt.Color(255, 255, 102));
        jScrollPane1.setViewportView(table1);

        bntedit.setText("Print List");
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

        jLabel9.setText("Search:");
        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        cmbsearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name", "Mobile", "FarmerType", "Adhar", " " }));

        txtsearch.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        bntedit1.setBackground(new java.awt.Color(204, 0, 0));
        bntedit1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        bntedit1.setForeground(new java.awt.Color(255, 255, 255));
        bntedit1.setText("Print ");
        bntedit1.setContentAreaFilled(false);
        bntedit1.setOpaque(true);
        bntedit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntedit1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtsearch))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bntedit1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bntedit)))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndelete)
                    .addComponent(bntedit)
                    .addComponent(bntedit1))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnoActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
   
                         if(txtnet.getText().equals(""))
        {
            lblerror.setText("Must Fill Mandatory Fields");
            txtnet.requestFocus();
            return;
        }
           String no=txtno.getText();
            String id=txtid.getText();
            String name=txtname.getText();
           String basic=txtbasic.getText();
        String insurance=txtins.getText();
        String pf=txtpf.getText();
        String tax=txttax.getText();
        String da=txtda.getText();
        String incent=txtincent.getText();
        String netsal=txtnet.getText();
        String btnname=btnsave.getText();
        String status=cmbpay.getSelectedItem()+"";
        LocalDateTime time=txtdt.getDateTimePermissive();
        if(btnname.equals("Save")){
            db.execute("Insert into salarypay (employeeID,Name,Basic,Insurance,PfAmount,Tax,DA,Incentive,NetSalary,Status,Pdate) values(?,?,?,?,?,?,?,?,?,?,?)",id,name,basic,insurance,pf,tax,da,incent,netsal,status,time);
            Utility.showMsg("Employee salary Paid successfully..","Successfully");
        }
        db.fillTable2(table1, "select * from salarypay");
             
                 
        
    }//GEN-LAST:event_btnsaveActionPerformed
 
    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
          
           txtno.setText("");
            txtid.setText("");
            txtname.setText("");
           txtbasic.setText("");
        txtins.setText("");
        txtpf.setText("");
        txttax.setText("");
        txtda.setText("");
        txtincent.setText("");
        cmbpay.setSelectedIndex(-1);
       
        txtnet.setText("");
        txtbasic.requestFocus();
        btnsave.setText("Save"); 
       
    }//GEN-LAST:event_btnclearActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // delete
        try{
        int i=table1.getSelectedRow();
        if(i!=-1){            
            if(Utility.showConfirm("Delete selected Salary Payment Histroy?", "Confirm Delete")==0){
                String no=table1.getValueAt(i, 0)+"";
                db.execute("delete from Salarypay where SalaryNo=?", no);
                db.fillTable(table1, "select * from Salarypay");
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
        db.showReport("src/reports/Salarypay.jrxml");
    }//GEN-LAST:event_bnteditActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void txtinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtinsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtinsActionPerformed

    private void txttaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttaxActionPerformed

    private void txtdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdaActionPerformed

    private void txtincentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtincentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtincentActionPerformed

    private void txtpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpfActionPerformed

    private void btnsave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsave1ActionPerformed
        // TODO add your handling code here:
        SalaryForm f=new SalaryForm();
         f.table1.addMouseListener(new MouseAdapter() {
                 @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==1){//double clicked
                    int i=f.table1.getSelectedRow();
                    
                    txtid.setText(f.table1.getValueAt(i, 1)+"");
                    txtname.setText(f.table1.getValueAt(i, 2)+"");
                    txtbasic.setText(f.table1.getValueAt(i, 3)+"");
                    txtins.setText(f.table1.getValueAt(i, 4)+"");
                    txtpf.setText(f.table1.getValueAt(i, 5)+"");
                    txttax.setText(f.table1.getValueAt(i, 6)+"");
                    txtda.setText(f.table1.getValueAt(i, 7)+"");
                    txtincent.setText(f.table1.getValueAt(i, 8)+"");
                    txtnet.setText(f.table1.getValueAt(i, 10)+"");
                    f.dispose();
                    txtbasic.requestFocus();
                }
            }
            
        });
        f.setVisible(true);
    }//GEN-LAST:event_btnsave1ActionPerformed

    private void txtbasicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbasicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbasicActionPerformed

    private void txtnetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnetActionPerformed

    private void txtbasicFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbasicFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtbasicFocusLost

    private void txtinsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtinsFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtinsFocusLost

    private void txtpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpfFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtpfFocusLost

    private void txttaxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttaxFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txttaxFocusLost

    private void txtdaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdaFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtdaFocusLost

    private void txtincentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtincentFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtincentFocusLost

    private void bntedit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntedit1ActionPerformed
        // TODO add your handling code here:
          try{
        int i=table1.getSelectedRow();
        if(i!=-1){
            String roll=table1.getValueAt(i, 1)+"";
            HashMap<String,Object> map=new HashMap<>(); //collection of key/value pairs
            map.put("p1", roll);
            db.showReport("src/Reports/SalarySlip.jrxml",map);
            
       
        }else{
            Utility.showWarn("Please select raw to print ","Select");
        }
         }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_bntedit1ActionPerformed

    /**
     * @param args the command line arguments
     * 
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
            java.util.logging.Logger.getLogger(SalaryPayForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalaryPayForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalaryPayForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalaryPayForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new SalaryPayForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntedit;
    private javax.swing.JButton bntedit1;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnsave1;
    private javax.swing.JComboBox<String> cmbpay;
    private javax.swing.JComboBox<String> cmbsearch;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblerror;
    private javax.swing.JLabel lblim;
    private javax.swing.JTable table1;
    private javax.swing.JTextField txtbasic;
    private javax.swing.JTextField txtda;
    private com.github.lgooddatepicker.components.DateTimePicker txtdt;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtincent;
    private javax.swing.JTextField txtins;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnet;
    private javax.swing.JTextField txtno;
    private javax.swing.JTextField txtpf;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txttax;
    // End of variables declaration//GEN-END:variables
}
