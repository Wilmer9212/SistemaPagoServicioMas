/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saivent.view;

import com.saivent.util.MetodosValidar;
import com.sistema.controller.EstadosController;
import com.sistema.modelo.EstadoDTO;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Elliot
 */
public class FEstados1 extends javax.swing.JFrame {

    EstadosController controller = new EstadosController();

    public FEstados1() {
        initComponents();
        desabilitar();
        llenartb("");
        
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
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnaceptar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        txtNombreBuscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnnuevo = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbestado = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(17, 140, 140));

        jPanel1.setBackground(new java.awt.Color(85, 112, 148));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ESTADOS");

        jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Codigo :");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("Nombre :");

        btnaceptar.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnaceptar.setText("ACEPTAR");
        btnaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceptarActionPerformed(evt);
            }
        });

        btncancelar.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btncancelar.setText("CANCELAR");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        txtNombreBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreBuscarKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("Nombre :");

        btnnuevo.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/nuevo.png"))); // NOI18N
        btnnuevo.setText("NUEVO");
        btnnuevo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnnuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnnuevo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnnuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnmodificar.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/modiicar.png"))); // NOI18N
        btnmodificar.setText("MODIFICAR");
        btnmodificar.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnmodificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnmodificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        btneliminar.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/eliminar.png"))); // NOI18N
        btneliminar.setText("ELIMINAR");
        btneliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btneliminar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btneliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnsalir.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
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

        tbestado = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        tbestado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbestado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbestadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbestado);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnnuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnmodificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsalir))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnaceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 34, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreBuscar)))
                .addGap(4, 4, 4))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnaceptar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btncancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnsalir, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btneliminar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnmodificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        txtNombre.setText(txtNombre.getText().toUpperCase());
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyReleased

    private void btnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarActionPerformed
        if (valEntradas() == true) {
            guardar();
        }
    }//GEN-LAST:event_btnaceptarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        btnnuevo.setEnabled(true);
        desabilitar();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void txtNombreBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreBuscarKeyReleased
        txtNombreBuscar.setText(txtNombreBuscar.getText().toUpperCase());
        llenartb(txtNombreBuscar.getText());
    }//GEN-LAST:event_txtNombreBuscarKeyReleased

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        habilitar();
        generarNumercion();

    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed

        if (valEntradas() == true) {
            modificar();
        }
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed

        eliminar();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnsalirActionPerformed

    private void tbestadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbestadoMouseClicked
        MouseE();
        int fila = tbestado.getSelectedRow();
        if (fila >= 0) {
            txtCodigo.setText(tbestado.getValueAt(fila, 0).toString());
            txtNombre.setText(tbestado.getValueAt(fila, 1).toString());
        }
    }//GEN-LAST:event_tbestadoMouseClicked
    public void generarNumercion() {
        int cod = controller.generarSecuenciaId();
        txtCodigo.setText(String.valueOf(cod));
    }

    public void guardar() {
        EstadoDTO estado = new EstadoDTO();
        try {
            estado.setId(Integer.parseInt(txtCodigo.getText()));
            estado.setNombre(txtNombre.getText());
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Guardar registros?", "", JOptionPane.YES_NO_OPTION);
            if (confirmar == JOptionPane.YES_OPTION) {
                boolean registro = controller.save(estado);
                if (registro) {
                    new MetodosValidar().ok();
                    limipiar();
                    desabilitar();
                    llenartb("");
                } else {
                    new MetodosValidar().error();
                }
            }
        } catch (Exception e) {
            System.out.println("Error al guardar estado:" + e.getMessage());
        }

    }

    public void modificar() {
        EstadoDTO estado = new EstadoDTO();
        try {
            estado.setId(Integer.parseInt(txtCodigo.getText()));
            estado.setNombre(txtNombre.getText());
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Modificar registros?", "", JOptionPane.YES_NO_OPTION);
            if (confirmar == JOptionPane.YES_OPTION) {
                boolean registro = controller.update(estado);
                if (registro) {
                    new MetodosValidar().ok_modificar();
                    limipiar();
                    desabilitar();
                    llenartb("");
                } else {
                    new MetodosValidar().error_modificar();
                }
            }
        } catch (Exception e) {
            System.out.println("Error al moficar registros");
        }
    }

    public void eliminar() {
        try {
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Eliminar registros?", "", JOptionPane.YES_NO_OPTION);
            if (confirmar == JOptionPane.YES_OPTION) {
                boolean registro = controller.delete(Integer.parseInt(txtCodigo.getText()));
                if (registro) {
                    new MetodosValidar().ok_eliminar();
                    limipiar();
                    desabilitar();
                    llenartb("");
                } else {
                    new MetodosValidar().error_eliminar();
                }
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar registros");
        }
    }

    public void llenartb(String descripcion) {
        String[] titulos = {"CODIGO", "DESCRIPCION"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        int ide = 0;
        try {
            Object o[] = null;
            List<EstadoDTO> lista = controller.estadosAll(descripcion);
            for (int i = 0; i < lista.size(); i++) {
                dtm.addRow(o);
                dtm.setValueAt(lista.get(i).getId().toString(), i, 0);
                dtm.setValueAt(lista.get(i).getNombre(), i, 1);
            }
            tbestado.setModel(dtm);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "NO SE RECONOCE LA TABLA ESTADOS", "", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean valEntradas() {
        String mensaje = "";
        boolean estado = true;
        if (txtCodigo.getText().isEmpty()) {
            mensaje += "CODIGO NO DEBE ESTAR VACIO \n";
            estado = false;
        }
        if (txtNombre.getText().isEmpty()) {
            mensaje += "NO SE INSERTO UNA DESCRIPCION \n";
            estado = false;
        }

        if (mensaje.length() >= 6) {
            JOptionPane.showMessageDialog(null, mensaje, "", JOptionPane.WARNING_MESSAGE);

        }
        return estado;
    }

    public void desabilitar() {
        txtCodigo.setEnabled(false);
        txtNombre.setEnabled(false);
        btnaceptar.setEnabled(false);
        btnmodificar.setEnabled(false);
        btneliminar.setEnabled(false);
        txtNombre.setText("");
        btnnuevo.setEnabled(true);
        btncancelar.setEnabled(false);
    }

    public void habilitar() {
        txtCodigo.setEnabled(true);
        txtCodigo.setEditable(false);
        txtNombre.setEnabled(true);
        btnaceptar.setEnabled(true);
        btnnuevo.setEnabled(false);
        btneliminar.setEnabled(false);
        btnmodificar.setEnabled(false);
        btncancelar.setEnabled(true);
    }

    public void MouseE() {
        btnnuevo.setEnabled(false);
        btneliminar.setEnabled(true);
        btnmodificar.setEnabled(true);
        btnaceptar.setEnabled(false);
        txtCodigo.setEnabled(true);
        txtCodigo.setEditable(false);
        txtNombre.setEnabled(true);
        btncancelar.setEnabled(true);

    }

    public void limipiar() {
        txtNombre.setText("");
    }

    
    public static void main(String[] args) {
        new FEstados1().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaceptar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbestado;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreBuscar;
    // End of variables declaration//GEN-END:variables
}
