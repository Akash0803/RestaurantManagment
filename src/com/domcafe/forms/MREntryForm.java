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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class MREntryForm extends javax.swing.JFrame {
         DBClass db=new DBClass();
         String oldname;
         File file;
         public static MRListForm parent;
         String qt; 
    /**
     * Creates new form LoginForm
     */
    public MREntryForm() {
        initComponents();
        getContentPane().setBackground(new Color(255,255,204));
        Utility.resizeLabelImage(lblim);
        getRootPane().setBorder(BorderFactory.createEtchedBorder());
        db.fillCombo(cmbsupplier,"select * from Branch");
        db.fillCombo(cmbpo, "select * from POrder", "OrderNo", "OrderNo");
        txtdate.setDate(LocalDate.now());
        txtinvdate.setDate(LocalDate.now());        
        //Handle key press on form
        KeyboardFocusManager kfm=KeyboardFocusManager.getCurrentKeyboardFocusManager();
        kfm.addKeyEventDispatcher(e->{
            if(e.getID()==KeyEvent.KEY_PRESSED){
                if(e.getKeyCode()==KeyEvent.VK_F3){
                    SupplyProviderForm f=new SupplyProviderForm ();
                    //WIndowAdapter implements WindowListener interface
                    f.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            db.fillCombo(cmbsupplier, "select * from Branch", "DomSupp", "DomSupp");
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
                    btnSelect.doClick(); //Perform click action on select button
                    return true;
                }
                if(e.getKeyCode()==KeyEvent.VK_F5 ){
                    int i=tab1.getSelectedRow();
                    if(i!=-1){
                        DefaultTableModel dt=(DefaultTableModel)tab1.getModel();
                        dt.removeRow(i);
                        calculateTotal();
                    }
                    return true;
                }
                
            }
            return false;
        
        });
        
        //Get ID
        txtmrno.setText(db.getID("MRNo"));
        txttransport.setInputVerifier(new InputVerifier() {
            @Override
            
            public boolean verify(JComponent input) {
                String trs=txttransport.getText();
                if(trs.equals("")){
               lblerror.setText("Transport Field cannot be left empty");
               txttransport.requestFocus();
               return false;
               }else{
                  return true;
              }
            }
        });
        txtinvno.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String inv=txtinvno.getText();
                if(inv.equals("")){
               lblerror.setText("Invoice Number cannot be left empty");
               txtinvno.requestFocus();
               return false;
               }else{
                  return true;
              }
              
            }
        });
        txtname.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                 String n=txtname.getText();
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
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtdate = new com.github.lgooddatepicker.components.DatePicker();
        jLabel4 = new javax.swing.JLabel();
        cmbsupplier = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtinvtotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txttransport = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnSelect = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        txtqty = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tab1 = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtunit = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtinvno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtinvdate = new com.github.lgooddatepicker.components.DatePicker();
        cmbpo = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtmrno = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        lblerror = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Category");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Material Recieved Entry");
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Add New Material Receipt", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        jLabel3.setText("Material Recived Date:");
        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txtdate.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel4.setText("Supply Office:");
        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        cmbsupplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbsupplier.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmbsupplier.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbsupplierItemStateChanged(evt);
            }
        });

        jLabel8.setText("Total Amt");
        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txtinvtotal.setEditable(false);
        txtinvtotal.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtinvtotal.setForeground(new java.awt.Color(153, 0, 51));

        jLabel2.setText("Transport:");
        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txttransport.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txttransport.setForeground(new java.awt.Color(153, 0, 51));

        jLabel12.setText("Item");
        jLabel12.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        btnSelect.setText("Select");
        btnSelect.setBackground(new java.awt.Color(204, 0, 0));
        btnSelect.setContentAreaFilled(false);
        btnSelect.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btnSelect.setForeground(new java.awt.Color(255, 255, 255));
        btnSelect.setOpaque(true);
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        txtid.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtid.setForeground(new java.awt.Color(153, 0, 51));

        txtname.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtname.setForeground(new java.awt.Color(153, 0, 51));

        txtqty.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtqty.setForeground(new java.awt.Color(153, 0, 51));

        btnAdd.setText("Add Item");
        btnAdd.setBackground(new java.awt.Color(204, 0, 0));
        btnAdd.setContentAreaFilled(false);
        btnAdd.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setOpaque(true);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        tab1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ItemNo", "Item Name", "Qty", "Unit", "Price", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab1.setBackground(new java.awt.Color(255, 255, 204));
        tab1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tab1.setGridColor(new java.awt.Color(0, 0, 255));
        jScrollPane2.setViewportView(tab1);

        btnSave.setText("Save");
        btnSave.setBackground(new java.awt.Color(204, 0, 0));
        btnSave.setContentAreaFilled(false);
        btnSave.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setOpaque(true);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.setBackground(new java.awt.Color(204, 0, 0));
        btnReset.setContentAreaFilled(false);
        btnReset.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setOpaque(true);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel10.setText("Qty");
        jLabel10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel13.setText("Unit");
        jLabel13.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txtunit.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtunit.setForeground(new java.awt.Color(153, 0, 51));

        jLabel11.setText("Add Product - F2   Select Supplier - F3     Select Product - F4  Delete Row - F5");
        jLabel11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        jLabel20.setText("Purchase Order No:");
        jLabel20.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel21.setText("Invoice No:");
        jLabel21.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txtinvno.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtinvno.setForeground(new java.awt.Color(153, 0, 51));

        jLabel5.setText("Invoice Date:");
        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txtinvdate.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        cmbpo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbpo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmbpo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbpoItemStateChanged(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txtprice.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtprice.setForeground(new java.awt.Color(153, 0, 51));

        jLabel22.setText("Material Reciept No:");
        jLabel22.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txtmrno.setEditable(false);
        txtmrno.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtmrno.setForeground(new java.awt.Color(153, 0, 51));

        jLabel15.setText("Price");
        jLabel15.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lblerror.setBackground(new java.awt.Color(153, 255, 255));
        lblerror.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblerror.setForeground(new java.awt.Color(255, 0, 0));
        lblerror.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtunit, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addComponent(btnAdd)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblerror, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtinvtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addGap(48, 48, 48))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtdate, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                    .addComponent(cmbsupplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20)))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtinvdate, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addComponent(txtinvno, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbpo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmrno, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttransport))
                        .addGap(60, 60, 60)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txttransport, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(cmbsupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtmrno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbpo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtinvno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtinvdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel3)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAdd))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtunit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtprice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtqty, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 299, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtinvtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblerror, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset)
                    .addComponent(btnSave)
                    .addComponent(jLabel11))
                .addGap(22, 22, 22))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(231, 231, 231)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(86, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
        MRListForm f=new MRListForm();
        f.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cmbsupplierItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbsupplierItemStateChanged
        // Display Address
       

    }//GEN-LAST:event_cmbsupplierItemStateChanged

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
       RawItemForm f=new RawItemForm();
        //MouseAdapter is a sub class of MouseListener
        f.table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==1){//double clicked
                    int i=f.table1.getSelectedRow();
                    txtid.setText(f.table1.getValueAt(i, 0)+"");
                    txtname.setText(f.table1.getValueAt(i, 1)+"");
                    txtunit.setText(f.table1.getValueAt(i, 3)+"");
                    txtprice.setText(f.table1.getValueAt(i, 4)+"");
                    f.dispose();
                    txtqty.requestFocus();
                }
            }
            
        });
        f.setVisible(true);
    }//GEN-LAST:event_btnSelectActionPerformed

      void calculateTotal(){
        double t=0;
        for(int i=0;i<tab1.getRowCount();i++){
            t=t+Double.parseDouble(tab1.getValueAt(i, 5)+"");
        }
        txtinvtotal.setText(t+"");
    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Add
        DefaultTableModel dt=(DefaultTableModel)tab1.getModel();
        double total= Integer.parseInt(txtqty.getText())* Double.parseDouble(txtprice.getText());
        dt.addRow(new Object[]{txtid.getText(),txtname.getText(),txtqty.getText(),txtunit.getText(),txtprice.getText(),total});
        calculateTotal();
        txtid.requestFocus();

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        //Save
             if(txttransport.getText().equals(""))
        {
            lblerror.setText("Field is Required");
            txttransport.requestFocus();
            return;
        }
        String mrno=txtmrno.getText();
        String mrdate=txtdate.getDate().format(DateTimeFormatter.ISO_DATE);
        String invno=txtinvno.getText();
        String invdate=txtinvdate.getDate().format(DateTimeFormatter.ISO_DATE);
        String pono=cmbpo.getSelectedItem()+"";
        String suppname=cmbsupplier.getSelectedItem()+"";
        String transport=txttransport.getText();
        String invtotal=txtinvtotal.getText();
        //Master Record Entry
        db.execute("Insert into MR values (?,?,?,?,?,?,?,?)", mrno,mrdate,invno,invdate,pono,suppname,transport,invtotal);

        //Details Entry
        for(int i=0;i<tab1.getRowCount();i++){
            String itemno=tab1.getValueAt(i, 0).toString();
            String itemname=tab1.getValueAt(i, 1).toString();
            String qty=tab1.getValueAt(i, 2).toString();
            String unit=tab1.getValueAt(i, 3).toString();
            String price=tab1.getValueAt(i, 4).toString();
            String total=tab1.getValueAt(i, 5).toString();
            db.execute("Insert into mritem values (?,?,?,?,?,?,?)", mrno,itemno,itemname,qty,unit,price,total);
            //Update Stock in item table
            db.execute("Update Material set Qty=Qty+? where MrNo=?", qty,itemno);
        }
       
        //Update ID
        db.updateID("MRNo");
        txtmrno.setText(db.getID("MRNo"));
       
        Utility.showMsg("Material Entered Successfully..", "Success");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // Reset
        //Get ID
        txtmrno.setText(db.getID("MRNo"));
        txtdate.setText("");
        txtinvdate.setText("");
        txtinvno.setText("");
        txttransport.setText("");
        txtinvtotal.setText("");
        txtid.setText("");
        txtname.setText("");
        txtqty.setText("");
        txtunit.setText("");
        cmbsupplier.setSelectedIndex(-1);
        cmbpo.setSelectedIndex(-1);
        txtdate.requestFocus();
    }//GEN-LAST:event_btnResetActionPerformed

    private void cmbpoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbpoItemStateChanged
        // Display Supplier on selection of PONo
      
    }//GEN-LAST:event_cmbpoItemStateChanged

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
            java.util.logging.Logger.getLogger(MREntryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MREntryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MREntryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MREntryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new MREntryForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSelect;
    private javax.swing.JComboBox<String> cmbpo;
    private javax.swing.JComboBox<String> cmbsupplier;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblerror;
    private javax.swing.JLabel lblim;
    private javax.swing.JTable tab1;
    private com.github.lgooddatepicker.components.DatePicker txtdate;
    private javax.swing.JTextField txtid;
    private com.github.lgooddatepicker.components.DatePicker txtinvdate;
    private javax.swing.JTextField txtinvno;
    private javax.swing.JTextField txtinvtotal;
    private javax.swing.JTextField txtmrno;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtqty;
    private javax.swing.JTextField txttransport;
    private javax.swing.JTextField txtunit;
    // End of variables declaration//GEN-END:variables
}
