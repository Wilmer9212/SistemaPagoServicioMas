/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saivent.view;

import com.google.gson.Gson;
import com.saivent.util.ImageTable;
import com.saivent.util.MetodosValidar;
import com.sistema.util.Hilo;
import com.taecel.conexionservicio.metodosHTTP;
import com.taecel.modelo.ProductsDTO;
import com.taecel.modelo.StatusDTO;
import com.taecel.modelo.TransaccionDTO;
import com.taecel.modelo.carriersModelo;
import com.taecel.modelo.productoModel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wilmer
 */
public class FRecargas extends javax.swing.JInternalFrame {

    String comision = "", vigencia = "", nota = "", compania = "";
    metodosHTTP metodos = new metodosHTTP();
    Gson gson = new Gson();
    ProductsDTO productos = null;//new ProductsDTO();
    Timer time;
    ActionListener ac;
    int x = 0;

    public FRecargas() {
        initComponents();
        diseñoVentana();
    }

    public void diseñoVentana() {
        Dimension DimensionBarra = null;
        JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
        DimensionBarra = Barra.getPreferredSize();
        Barra.setSize(0, 0);
        Barra.setPreferredSize(new Dimension(0, 0));
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdVender = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jlVenta = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbMontoCompa = new javax.swing.JComboBox<>();
        pnlVentas = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtConfirmarNumero = new javax.swing.JTextField();
        lblCostoProducto = new javax.swing.JLabel();
        lblComisionServicio = new javax.swing.JLabel();
        lblVigencia = new javax.swing.JLabel();
        lblNota = new javax.swing.JLabel();
        jlabelCostoProducto = new javax.swing.JLabel();
        jlabelComisionServicio = new javax.swing.JLabel();
        jlabelVigencia = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        lblVigencia1 = new javax.swing.JLabel();
        jLabelCodProducto = new javax.swing.JLabel();
        loading = new javax.swing.JDialog();
        jProgressBar1 = new javax.swing.JProgressBar();
        porcentaje = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbProductos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnsalir = new javax.swing.JButton();

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlVenta.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jlVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setText("Monto ->");

        cbMontoCompa.setFont(new java.awt.Font("Noto Sans", 3, 12)); // NOI18N
        cbMontoCompa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));
        cbMontoCompa.setToolTipText("");
        cbMontoCompa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMontoCompaActionPerformed(evt);
            }
        });

        pnlVentas.setBackground(new java.awt.Color(253, 251, 251));
        pnlVentas.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlVentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setText("Numero :");
        pnlVentas.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 30));

        txtNumero.setToolTipText("ingresa tu numero\n");
        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumeroKeyReleased(evt);
            }
        });
        pnlVentas.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 193, -1));

        jLabel5.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(1, 1, 1));
        jLabel5.setText("confirma:");
        pnlVentas.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        txtConfirmarNumero.setToolTipText("confirmar tu numero\n");
        txtConfirmarNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConfirmarNumeroKeyReleased(evt);
            }
        });
        pnlVentas.add(txtConfirmarNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 63, 193, -1));

        lblCostoProducto.setFont(new java.awt.Font("Noto Sans", 3, 12)); // NOI18N
        lblCostoProducto.setForeground(new java.awt.Color(1, 1, 1));
        lblCostoProducto.setText("Costo del Producto :");
        pnlVentas.add(lblCostoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, 20));

        lblComisionServicio.setFont(new java.awt.Font("Noto Sans", 3, 12)); // NOI18N
        lblComisionServicio.setForeground(new java.awt.Color(1, 1, 1));
        lblComisionServicio.setText("Comision por Servicio :");
        pnlVentas.add(lblComisionServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        lblVigencia.setFont(new java.awt.Font("Noto Sans", 3, 12)); // NOI18N
        lblVigencia.setForeground(new java.awt.Color(1, 1, 1));
        lblVigencia.setText("Vigencia :");
        pnlVentas.add(lblVigencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        lblNota.setFont(new java.awt.Font("Noto Sans", 3, 12)); // NOI18N
        lblNota.setForeground(new java.awt.Color(1, 1, 1));
        lblNota.setText("Nota :");
        pnlVentas.add(lblNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 40, -1));

        jlabelCostoProducto.setForeground(new java.awt.Color(1, 1, 1));
        jlabelCostoProducto.setText("jLabel6");
        pnlVentas.add(jlabelCostoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 130, 20));

        jlabelComisionServicio.setForeground(new java.awt.Color(1, 1, 1));
        jlabelComisionServicio.setText("jLabel6");
        pnlVentas.add(jlabelComisionServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 130, -1));

        jlabelVigencia.setForeground(new java.awt.Color(1, 1, 1));
        jlabelVigencia.setText("jLabel6");
        pnlVentas.add(jlabelVigencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 200, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        pnlVentas.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, 50));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/OK.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlVentas.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, -1, -1));

        lblVigencia1.setFont(new java.awt.Font("Noto Sans", 3, 12)); // NOI18N
        lblVigencia1.setForeground(new java.awt.Color(1, 1, 1));
        lblVigencia1.setText("Nombre producto :");
        pnlVentas.add(lblVigencia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 110, -1));

        jLabelCodProducto.setForeground(new java.awt.Color(1, 1, 1));
        jLabelCodProducto.setText("jLabel6");
        pnlVentas.add(jLabelCodProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 100, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbMontoCompa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMontoCompa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jdVenderLayout = new javax.swing.GroupLayout(jdVender.getContentPane());
        jdVender.getContentPane().setLayout(jdVenderLayout);
        jdVenderLayout.setHorizontalGroup(
            jdVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdVenderLayout.setVerticalGroup(
            jdVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        porcentaje.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        porcentaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        porcentaje.setText("0%");

        javax.swing.GroupLayout loadingLayout = new javax.swing.GroupLayout(loading.getContentPane());
        loading.getContentPane().setLayout(loadingLayout);
        loadingLayout.setHorizontalGroup(
            loadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                    .addComponent(porcentaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        loadingLayout.setVerticalGroup(
            loadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(porcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel1.setText("Seleccione :");

        cbProductos.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        cbProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiempo Aire", "Paquete" }));
        cbProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProductosActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Noto Sans", 3, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COMPAÑIA", "IDENTIFICADOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setEditingRow(0);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/salir ventana.png"))); // NOI18N
        btnsalir.setText("CERRAR");
        btnsalir.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnsalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnsalir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnsalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnsalir)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProductosActionPerformed
        jTable1.removeAll();
        if (cbProductos.getSelectedIndex() == 0) {
            loading.setSize(430, 90);
            loading.setLocationRelativeTo(null);
            loading.setVisible(true);
            DefaultTableModel dtm = new DefaultTableModel();
            String titulos[] = {"COMPAÑIA", "IDENTIFICADOR"};
            ac = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (productos == null && x <= 2) {
                        x = 10;
                        productos = new metodosHTTP().getProducts();
                    }
                    if (productos != null && x < 30) {
                        x = 98;
                    }
                    jProgressBar1.setValue(x++);
                    porcentaje.setText(String.valueOf(jProgressBar1.getValue()) + "%");
                    jTable1.setDefaultRenderer(Object.class, new ImageTable());
                    dtm.setColumnIdentifiers(titulos);
                    if (cbProductos.getSelectedItem().toString().toUpperCase().contains("AIRE")) {
                        ArrayList<carriersModelo> carriers = productos.getData().getCarriers();
                        for (int i = 0; i < carriers.size(); i++) {
                            JLabel label = new JLabel();
                            Object[] fila = new Object[2];
                            carriersModelo carrier = carriers.get(i);
                            if (carrier.getCategoria().toLowerCase().contains("tiempo aire") && !carrier.getID().equals("264") && !carrier.getID().equals("227") && !carrier.getID().equals("225") && !carrier.getID().equals("243")) {
                                try {
                                    System.setProperty("http.agent", "Chrome");
                                    URL url = new URL(carrier.getLogotipo());
                                    Image image;
                                    try {
                                        image = ImageIO.read(url);
                                        label.setIcon(new ImageIcon(image));
                                    } catch (IOException ex) {
                                        Logger.getLogger(FRecargas.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                    fila[0] = carrier.getNombre();
                                    fila[1] = label;
                                    jTable1.setRowHeight(110);
                                    dtm.addRow(fila);
                                } catch (MalformedURLException ex) {
                                    Logger.getLogger(FRecargas.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                        if (jProgressBar1.getValue() == 100) {
                            time.stop();
                            loading.dispose();
                            jTable1.setModel(dtm);
                        }
                    }
                    // 

                }

            };

            time = new Timer(100, ac);
            time.start();
        }///Aqui termina productos tiempo aire
        else if (cbProductos.getSelectedIndex() == 1) {

            loading.setSize(430, 90);
            loading.setLocationRelativeTo(null);
            loading.setVisible(true);
            DefaultTableModel dtm = new DefaultTableModel();
            String titulos[] = {"COMPAÑIA", "IDENTIFICADOR"};
            ac = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (productos == null && x <= 2) {
                        x = 10;
                        productos = new metodosHTTP().getProducts();
                    }
                    if (productos != null && x < 30) {
                        x = 98;
                    }
                    jProgressBar1.setValue(x++);
                    porcentaje.setText(String.valueOf(jProgressBar1.getValue()) + "%");
                    jTable1.setDefaultRenderer(Object.class, new ImageTable());
                    dtm.setColumnIdentifiers(titulos);
                    if (cbProductos.getSelectedItem().toString().toUpperCase().contains("PAQUET")) {
                        ArrayList<carriersModelo> carriers = productos.getData().getCarriers();
                        for (int i = 0; i < carriers.size(); i++) {
                            JLabel label = new JLabel();
                            Object[] fila = new Object[2];
                            carriersModelo carrier = carriers.get(i);
                            System.out.println("" + carrier.getCategoria());
                            if (carrier.getCategoria().toLowerCase().contains("paque")) {
                                try {
                                    System.setProperty("http.agent", "Chrome");
                                    URL url = new URL(carrier.getLogotipo());
                                    Image image;
                                    try {
                                        image = ImageIO.read(url);
                                        label.setIcon(new ImageIcon(image));
                                    } catch (IOException ex) {
                                        Logger.getLogger(FRecargas.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                    fila[0] = carrier.getNombre();
                                    fila[1] = label;
                                    jTable1.setRowHeight(110);
                                    dtm.addRow(fila);
                                } catch (MalformedURLException ex) {
                                    Logger.getLogger(FRecargas.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                        if (jProgressBar1.getValue() == 100) {
                            time.stop();
                            loading.dispose();
                            jTable1.setModel(dtm);
                        }
                    }
                    // 

                }

            };

            time = new Timer(100, ac);
            time.start();
        }

    }//GEN-LAST:event_cbProductosActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int fila = jTable1.getSelectedRow();

        try {
            llenarComboProductos(jTable1.getValueAt(fila, 0).toString(), cbProductos.getSelectedItem().toString().toUpperCase());
            JDialog dialogov = new JDialog(jdVender, "MONTO RECARGA", true);
            dialogov.add(jdVender.getContentPane());
            dialogov.setSize(310, 400);
            dialogov.setLocationRelativeTo(null);
            ///Border bordejpanel = new TitledBorder(new EtchedBorder(), jTable1.getValueAt(fila, 0).toString());
            //pnlVentas.setBorder(bordejpanel);
            jlVenta.setText(cbProductos.getSelectedItem() + "," + jTable1.getValueAt(fila, 0).toString());
            dialogov.setVisible(true);
            jLabelCodProducto.setText(cbMontoCompa.getSelectedItem().toString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL CONECTAR A LA BASE DE DATOS", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void cbMontoCompaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMontoCompaActionPerformed

        try {
            String[] cadenaServ = jlVenta.getText().split(",");
            setDetallesTA(cadenaServ[1].toUpperCase(), cadenaServ[0].toUpperCase());
        } catch (Exception e) {
            System.out.println("Error al obtener desc:" + e.getMessage());
        }


    }//GEN-LAST:event_cbMontoCompaActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Icon icono = new ImageIcon(getClass().getResource("/Imagenes/oki.png"));
        try {
            if (!txtNumero.getText().equals("") && !txtConfirmarNumero.equals("") && !jLabelCodProducto.getText().equals("")) {
                if (txtNumero.getText().length() >= 10 || txtConfirmarNumero.getText().length() >= 10) {
                    if (!txtConfirmarNumero.getText().equals(txtNumero.getText())) {
                        JOptionPane.showMessageDialog(null, "LOS NUMEROS NO COINCIDEN", "", JOptionPane.ERROR_MESSAGE);
                    } else {
                        System.out.println("" + jLabelCodProducto.getText() + "," + txtConfirmarNumero.getText() + "," + cbMontoCompa.getSelectedItem().toString());
                        TransaccionDTO transaction = metodos.getTransaccion(jLabelCodProducto.getText(), txtConfirmarNumero.getText(), cbMontoCompa.getSelectedItem().toString());
                        System.out.println("Transaction:" + transaction);
                        StatusDTO estatus = metodos.getStatus(transaction.getData().getTransID());
                        if (!estatus.isSuccess()) {
                             
                            /*if (transaction.getError() > 0) {
                                System.out.println("Entro aqui");
                                JOptionPane.showMessageDialog(null, "Codigo de error:" + transaction.getError() + "\n"
                                        + "Descripcion:" + transaction.getMessage(), "", JOptionPane.ERROR_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "¡¡¡" + transaction.getMessage() + "!!! \n"
                                        + transaction.getData().getTransID(), "", JOptionPane.OK_OPTION, icono);
                            }*/
                        }else{
                            
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "LOS NUMEROS DEBEN SER 10 DIGITOS", "", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "INGRESE DATOS VALIDOS", "", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Error al enviar recarga:" + e.getMessage());
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtConfirmarNumeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmarNumeroKeyReleased
        new MetodosValidar().soloNumeros(txtConfirmarNumero, 10);
    }//GEN-LAST:event_txtConfirmarNumeroKeyReleased

    private void txtNumeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyReleased
        new MetodosValidar().soloNumeros(txtNumero, 10);
    }//GEN-LAST:event_txtNumeroKeyReleased

    public void llenarComboProductos(String compa, String serv) {
        cbMontoCompa.removeAllItems();
        limpiarControlesRecargar();
        cbMontoCompa.addItem("SELECCIONE");
        try {
            ProductsDTO prod = productos;// metodos.getProducts();
            ArrayList<productoModel> modelosProducto = prod.getData().getProductos();
            for (int i = 0; i < modelosProducto.size(); i++) {
                productoModel producto = modelosProducto.get(i);
                if (producto.getBolsaID().equals("1") && producto.getCarrier().equalsIgnoreCase(compa) && producto.getCategoria().toUpperCase().contains(serv)) {
                    cbMontoCompa.addItem(producto.getMonto());
                }
            }

        } catch (Exception e) {
            System.out.println("Error al cargar montos:" + e.getMessage());
        }

    }

    public void setDetallesTA(String compa, String tipa) {
        try {
            ProductsDTO prod = productos;//metodos.getProducts();
            ArrayList<productoModel> modelosProducto = prod.getData().getProductos();
            for (int i = 0; i < modelosProducto.size(); i++) {
                productoModel producto = modelosProducto.get(i);
                if (producto.getBolsaID().equals("1") && producto.getCarrier().toUpperCase().contains(compa) && producto.getCategoria().toUpperCase().contains(tipa) && producto.getMonto().equals(cbMontoCompa.getSelectedItem().toString())) {
                    jlabelCostoProducto.setText("$" + producto.getMonto() + " pesos.");
                    jlabelVigencia.setText(producto.getVigencia());
                    jlabelComisionServicio.setText("$0.00 pesos.");
                    jTextArea1.setText(producto.getDescripcion());
                    jLabelCodProducto.setText(producto.getCodigo());
                }
            }

        } catch (Exception e) {
            System.out.println("Error al cargar montos:" + e.getMessage());
        }
    }

    public void showBarProgress(boolean bandera) {
        try {
            JDialog dialogov = new JDialog(loading, "MONTO RECARGA", true);
            dialogov.add(loading.getContentPane());
            dialogov.setSize(430, 90);
            dialogov.setLocationRelativeTo(null);
            ///Border bordejpanel = new TitledBorder(new EtchedBorder(), jTable1.getValueAt(fila, 0).toString());
            //pnlVentas.setBorder(bordejpanel);

            dialogov.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL CONECTAR A LA BASE DE DATOS", "", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void limpiarControlesRecargar() {
        jlabelCostoProducto.setText("");
        jlabelComisionServicio.setText("");
        jlabelVigencia.setText("");
        jTextArea1.setText("");
        jLabelCodProducto.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> cbMontoCompa;
    public javax.swing.JComboBox<String> cbProductos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelCodProducto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JDialog jdVender;
    private javax.swing.JLabel jlVenta;
    private javax.swing.JLabel jlabelComisionServicio;
    private javax.swing.JLabel jlabelCostoProducto;
    private javax.swing.JLabel jlabelVigencia;
    private javax.swing.JLabel lblComisionServicio;
    private javax.swing.JLabel lblCostoProducto;
    private javax.swing.JLabel lblNota;
    private javax.swing.JLabel lblVigencia;
    private javax.swing.JLabel lblVigencia1;
    private javax.swing.JDialog loading;
    private javax.swing.JPanel pnlVentas;
    private javax.swing.JLabel porcentaje;
    private javax.swing.JTextField txtConfirmarNumero;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
