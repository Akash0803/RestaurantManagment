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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class BillForm extends javax.swing.JFrame {
         DBClass db=new DBClass();
    public static BillListForm parent;
    /**
     * Creates new form LoginForm
     */
    public BillForm() {
        initComponents();
        getContentPane().setBackground(new Color(255,255,204));
        Utility.resizeLabelImage(lblim);
        getRootPane().setBorder(BorderFactory.createEtchedBorder());
         txtdate2.setDate(LocalDate.now());
         db.fillCombo(cmbtbl,"select * from Ltable");
        //Handle key press on form
        KeyboardFocusManager kfm=KeyboardFocusManager.getCurrentKeyboardFocusManager();
        kfm.addKeyEventDispatcher(e->{
            if(e.getID()==KeyEvent.KEY_PRESSED){                
                if(e.getKeyCode()==KeyEvent.VK_F2){
                    MenuForm f=new MenuForm();
                    f.setVisible(true);
                    return true;
                }
                if(e.getKeyCode()==KeyEvent.VK_F4){
                    btnSelect2.doClick(); //Perform click action on select button
                    return true;
                }
                if(e.getKeyCode()==KeyEvent.VK_F5 ){
                    int i=tab3.getSelectedRow();
                    if(i!=-1){
                        DefaultTableModel dt=(DefaultTableModel)tab3.getModel();
                        dt.removeRow(i);
                        calculateTotal();
                    }
                    return true;
                }
                
            }
            return false;
        
        });
        
        //Attach code to txtdiscp to calculate disc and netamt
        txtdiscp2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                calculateDisc();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                calculateDisc();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
            
        });
        
        //Get ID
        txtqno2.setText(db.getID("BillNo"));
        txtname.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                 String n=txtname.getText();
                if(n.equals("")){
               lblerror.setText("Name Can't Be Left Empty");
               return false;
               }else{
                  return true;
              }
            }
        });
          txtmobileno.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                 String n=txtmobileno.getText();
                if(n.equals("")){
               lblerror.setText("Mobile No Can't Be Left Empty");
               return false;
               }else{
                  return true;
              }
            }
        });
           txtaddress.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                 String n=txtaddress.getText();
                if(n.equals("")){
               lblerror.setText("Address Can't Be Left Empty");
               return false;
               }else{
                  return true;
              }
            }
        });
            txtname2.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                 String n=txtname2.getText();
                if(n.equals("")){
               lblerror.setText("Must Add Material Before Save");
               return false;
               }else{
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
        jPanel5 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        txtdate2 = new com.github.lgooddatepicker.components.DatePicker();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtnetamt2 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        btnSelect2 = new javax.swing.JButton();
        txtid2 = new javax.swing.JTextField();
        txtname2 = new javax.swing.JTextField();
        txtqty2 = new javax.swing.JTextField();
        btnAdd2 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tab3 = new javax.swing.JTable();
        btnSave2 = new javax.swing.JButton();
        btnReset2 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtgst = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtprice2 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtqno2 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        txttotalamt2 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        txtdiscp2 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtdisc2 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtaddress = new javax.swing.JTextArea();
        cmbtbl = new javax.swing.JComboBox<>();
        txtname = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        btnSelect3 = new javax.swing.JButton();
        txtmobileno = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        cmbcash = new javax.swing.JComboBox<>();
        lblerror = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Category");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Inovice Generator");
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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Generate New Bill\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        jLabel31.setText("Date:");
        jLabel31.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txtdate2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel32.setText("Customer:");
        jLabel32.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel33.setText("NetAmt");
        jLabel33.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txtnetamt2.setEditable(false);
        txtnetamt2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtnetamt2.setForeground(new java.awt.Color(153, 0, 51));

        jLabel34.setText("Item No");
        jLabel34.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        btnSelect2.setText("Select");
        btnSelect2.setBackground(new java.awt.Color(204, 0, 0));
        btnSelect2.setContentAreaFilled(false);
        btnSelect2.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btnSelect2.setForeground(new java.awt.Color(255, 255, 255));
        btnSelect2.setOpaque(true);
        btnSelect2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelect2ActionPerformed(evt);
            }
        });

        txtid2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtid2.setForeground(new java.awt.Color(153, 0, 51));

        txtname2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtname2.setForeground(new java.awt.Color(153, 0, 51));

        txtqty2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtqty2.setForeground(new java.awt.Color(153, 0, 51));

        btnAdd2.setText("Add Item");
        btnAdd2.setBackground(new java.awt.Color(204, 0, 0));
        btnAdd2.setContentAreaFilled(false);
        btnAdd2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnAdd2.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd2.setOpaque(true);
        btnAdd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd2ActionPerformed(evt);
            }
        });

        tab3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ItemNo", "Item Name", "Qty", "GST %", "Price", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab3.setBackground(new java.awt.Color(255, 255, 204));
        tab3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tab3.setGridColor(new java.awt.Color(0, 0, 255));
        jScrollPane7.setViewportView(tab3);

        btnSave2.setText("Save");
        btnSave2.setBackground(new java.awt.Color(204, 0, 0));
        btnSave2.setContentAreaFilled(false);
        btnSave2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnSave2.setForeground(new java.awt.Color(255, 255, 255));
        btnSave2.setOpaque(true);
        btnSave2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave2ActionPerformed(evt);
            }
        });

        btnReset2.setText("Reset");
        btnReset2.setBackground(new java.awt.Color(204, 0, 0));
        btnReset2.setContentAreaFilled(false);
        btnReset2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnReset2.setForeground(new java.awt.Color(255, 255, 255));
        btnReset2.setOpaque(true);
        btnReset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset2ActionPerformed(evt);
            }
        });

        jLabel35.setText("Qty");
        jLabel35.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel36.setText("GST%");
        jLabel36.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txtgst.setText("7");
        txtgst.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtgst.setForeground(new java.awt.Color(153, 0, 51));

        jLabel37.setText("Add Item - F2     Select Item - F4  Delete Item - F5");
        jLabel37.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jLabel38.setText("Price");
        jLabel38.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txtprice2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtprice2.setForeground(new java.awt.Color(153, 0, 51));

        jLabel39.setText("Inovice No:");
        jLabel39.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txtqno2.setEditable(false);
        txtqno2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtqno2.setForeground(new java.awt.Color(153, 0, 51));

        jLabel40.setText("Total Amt");
        jLabel40.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txttotalamt2.setEditable(false);
        txttotalamt2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txttotalamt2.setForeground(new java.awt.Color(153, 0, 51));

        jLabel41.setText("Disc%");
        jLabel41.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txtdiscp2.setText("0");
        txtdiscp2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtdiscp2.setForeground(new java.awt.Color(153, 0, 51));

        jLabel42.setText("DiscAmt");
        jLabel42.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txtdisc2.setEditable(false);
        txtdisc2.setText("0");
        txtdisc2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtdisc2.setForeground(new java.awt.Color(153, 0, 51));

        jLabel43.setText("Address:");
        jLabel43.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txtaddress.setColumns(20);
        txtaddress.setRows(5);
        txtaddress.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jScrollPane8.setViewportView(txtaddress);

        cmbtbl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel44.setText("Table No:");
        jLabel44.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        btnSelect3.setText("....");
        btnSelect3.setBackground(new java.awt.Color(204, 0, 0));
        btnSelect3.setContentAreaFilled(false);
        btnSelect3.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btnSelect3.setForeground(new java.awt.Color(255, 255, 255));
        btnSelect3.setOpaque(true);
        btnSelect3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelect3ActionPerformed(evt);
            }
        });

        jLabel45.setText("Mobile No:");
        jLabel45.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel61.setText("Pay Mode:");
        jLabel61.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        cmbcash.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Credit", "Online" }));

        lblerror.setBackground(new java.awt.Color(153, 255, 255));
        lblerror.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblerror.setForeground(new java.awt.Color(255, 0, 0));
        lblerror.setOpaque(true);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(txtid2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtname2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtname)
                                    .addComponent(cmbtbl, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtdate2, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel45)
                                    .addComponent(jLabel34))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSelect2)
                                    .addComponent(txtmobileno))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSelect3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtqty2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel36))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtprice2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtgst, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdd2)
                                .addGap(25, 25, 25))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel43)
                                    .addComponent(jLabel39))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtqno2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel61)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbcash, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10))))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addComponent(lblerror, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(txtdisc2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtnetamt2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel40)
                                    .addComponent(jLabel41))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtdiscp2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttotalamt2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnSave2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReset2)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtdate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(txtqno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cmbtbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSelect3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel32))
                            .addComponent(jLabel43))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel45))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel61)
                                .addComponent(cmbcash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtmobileno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSelect2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtname2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtqty2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtprice2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtgst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(jLabel38)
                            .addComponent(jLabel36))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(txttotalamt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txtdiscp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel42)
                        .addComponent(txtdisc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblerror, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtnetamt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset2)
                    .addComponent(btnSave2))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    void calculateDisc(){
        try{
        String dp=txtdiscp2.getText();
        double dis;
        if(dp.equals("")){
            dis=0;
            //txtdiscp.setText("0");
        }else{
            dis=Double.parseDouble(dp);
        }
        double tamt=Double.parseDouble(txttotalamt2.getText());
        double disamt=tamt*(dis/100);
        txtdisc2.setText(disamt+"");
        double netamt=tamt-disamt;
        txtnetamt2.setText(netamt+"");
        }catch(Exception ex){}
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
        BillListForm f= new BillListForm();
        f.setVisible(true);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnSelect2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelect2ActionPerformed
        MenuForm f=new MenuForm();
        //MouseAdapter is a sub class of MouseListener
        f.table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==1){//double clicked
                    int i=f.table1.getSelectedRow();
                    txtid2.setText(f.table1.getValueAt(i, 0)+"");
                    txtname2.setText(f.table1.getValueAt(i, 1)+"");
                    txtprice2.setText(f.table1.getValueAt(i, 4)+"");
                    f.dispose();
                    txtqty2.requestFocus();
                }
            }

        });
        f.setVisible(true);
    }//GEN-LAST:event_btnSelect2ActionPerformed

    private void btnAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd2ActionPerformed
        // Add
       
        DefaultTableModel dt=(DefaultTableModel)tab3.getModel();
        double g=0;
        String gpr=txtgst.getText();
        Double gr=Double.parseDouble(gpr);
        double total= Integer.parseInt(txtqty2.getText())* Double.parseDouble(txtprice2.getText());
         g=total*(gr/100);
           total=total+g;
        dt.addRow(new Object[]{txtid2.getText(),txtname2.getText(),txtqty2.getText(),txtgst.getText(),txtprice2.getText(),total});
        calculateTotal();
        txtid2.requestFocus();
      

    }//GEN-LAST:event_btnAdd2ActionPerformed

    private void btnSave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave2ActionPerformed
        //Save
                      if(txtname2.getText().equals(""))
        {
            lblerror.setText("Must Add Items Before Save");
            txtname2.requestFocus();
            return;
        }

        String billno=txtqno2.getText();
        String qdate=txtdate2.getDate().format(DateTimeFormatter.ISO_DATE);
        String tabl=cmbtbl.getSelectedItem()+"";
        String paym=cmbcash.getSelectedItem()+"";
        String customer=txtname.getText();
        String address=txtaddress.getText();
        String mobile=txtmobileno.getText();
        String tamt=txttotalamt2.getText();
        String discp=txtdiscp2.getText();
        String discamt=txtdisc2.getText();
        String namt=txtnetamt2.getText();

        //Master Record Entry
        db.execute("Insert into Invoice values (?,?,?,?,?,?,?,?,?,?,?)",billno,qdate,tabl,customer,address,mobile,discp,discamt,paym,tamt,namt);

        //Details Entry
        for(int i=0;i<tab3.getRowCount();i++){
            String itemno=tab3.getValueAt(i, 0).toString();
            String itemname=tab3.getValueAt(i, 1).toString();
            String qty=tab3.getValueAt(i, 2).toString();
            String gst=tab3.getValueAt(i, 3).toString();
            String price=tab3.getValueAt(i, 4).toString();
            String total=tab3.getValueAt(i, 5).toString();
            db.execute("Insert into invitem values (?,?,?,?,?,?,?)",billno,itemno,itemname,qty,gst,price,total);
        }
        //Update ID
        db.updateID("BillNo");
        txtqno2.setText(db.getID("BillNo"));
//        db.fillTable(parent.table1, "select * Invoice");
        Utility.showMsg("Invoice Generated Successfully..", "Success");
    }//GEN-LAST:event_btnSave2ActionPerformed

    private void btnReset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset2ActionPerformed
        // Reset
        //Get ID
        txtqno2.setText(db.getID("BillNo"));
        txtdate2.setText("");
        txtname.setText("");
        txtaddress.setText("");
        txtmobileno.setText("");
        txtdiscp2.setText("0");
        txtdisc2.setText("");
        cmbcash.setSelectedIndex(-1);
        cmbtbl.setSelectedIndex(-1);
        txttotalamt2.setText("");
        txtnetamt2.setText("");
        txtid2.setText("");
        txtname2.setText("");
        txtqty2.setText("");
        txtgst.setText("18");
        txtdate2.requestFocus();
    }//GEN-LAST:event_btnReset2ActionPerformed

    private void btnSelect3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelect3ActionPerformed
        // TODO add your handling code here:
        CustomerForm f=new CustomerForm();
        f.table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==1){//double clicked
                    int i=f.table1.getSelectedRow();
                    txtname.setText(f.table1.getValueAt(i, 1)+"");
                    txtmobileno.setText(f.table1.getValueAt(i, 3)+"");
                    txtaddress.setText(f.table1.getValueAt(i, 2)+"");
                    f.dispose();
                    
                }
            }

        });
        f.setVisible(true);
        
        
    }//GEN-LAST:event_btnSelect3ActionPerformed

      void calculateTotal(){
        double t=0,g=0;
        
        for(int i=0;i<tab3.getRowCount();i++){
            t=t+Double.parseDouble(tab3.getValueAt(i, 5)+"");
            
        }
        txttotalamt2.setText(t+"");
        calculateDisc();
    }
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
            java.util.logging.Logger.getLogger(BillForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new BillForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd2;
    private javax.swing.JButton btnReset2;
    private javax.swing.JButton btnSave2;
    private javax.swing.JButton btnSelect2;
    private javax.swing.JButton btnSelect3;
    private javax.swing.JComboBox<String> cmbcash;
    private javax.swing.JComboBox<String> cmbtbl;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lblerror;
    private javax.swing.JLabel lblim;
    private javax.swing.JTable tab3;
    private javax.swing.JTextArea txtaddress;
    private com.github.lgooddatepicker.components.DatePicker txtdate2;
    private javax.swing.JTextField txtdisc2;
    private javax.swing.JTextField txtdiscp2;
    private javax.swing.JTextField txtgst;
    private javax.swing.JTextField txtid2;
    private javax.swing.JTextField txtmobileno;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtname2;
    private javax.swing.JTextField txtnetamt2;
    private javax.swing.JTextField txtprice2;
    private javax.swing.JTextField txtqno2;
    private javax.swing.JTextField txtqty2;
    private javax.swing.JTextField txttotalamt2;
    // End of variables declaration//GEN-END:variables
}
