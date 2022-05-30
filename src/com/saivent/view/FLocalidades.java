/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saivent.view;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.management.remote.JMXConnectorFactory.connect;
import javax.swing.JComponent;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Elliot
 */

public class FLocalidades extends javax.swing.JInternalFrame {

    /**
     * Creates new form FLocalidades
     */
    public FLocalidades() {
        initComponents();
        Generarnumeracion();
        desabilitar();
        llenartb("");
        llenarCB();diseñoVentana();
    }
    
    public void diseñoVentana(){
        Dimension DimensionBarra = null;
        JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
        DimensionBarra = Barra.getPreferredSize();
        Barra.setSize(0, 0);
        Barra.setPreferredSize(new Dimension(0, 0));
        repaint();
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
        ttcodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtdescripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnaceptar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnnuevo = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbcolonias = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        cbmun = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOCALIDADES");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("CODIGO");

        txtdescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdescripcionKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("NOMBRE");

        btnaceptar.setText("ACEPTAR");
        btnaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceptarActionPerformed(evt);
            }
        });

        btncancelar.setText("CANCELAR");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        jLabel4.setText("NOMBRE");

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

        tbcolonias = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        tbcolonias.setModel(new javax.swing.table.DefaultTableModel(
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
        tbcolonias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbcoloniasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbcolonias);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("MUNICIPIO");

        cbmun.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(ttcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnaceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbmun, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtbuscar)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ttcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnaceptar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btncancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbmun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnnuevo)
                    .addComponent(btnmodificar)
                    .addComponent(btneliminar)
                    .addComponent(btnsalir))
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
     public void llenarCB() {
        /*listV = control1.findMunicipioEntities();
        for (int i = 0; i < listV.size(); i++) {
           cbmun.addItem(listV.get(i).getNombrem());
        }*/
    }
    private void txtdescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcionKeyReleased
        txtdescripcion.setText(txtdescripcion.getText().toUpperCase());
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescripcionKeyReleased

    private void btnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarActionPerformed
        /*Colonia um =new Colonia();
        um.setIdcolonia(Integer.parseInt(ttcodigo.getText()));
        um.setNombre(txtdescripcion.getText());
        for(int i=0;i<listV.size();i++){
            if(listV.get(i).getNombrem().equals(cbmun.getSelectedItem())){
                um.setIdmunicipio(listV.get(i).getIdmunicipio());
            }
        }
        if(valEntradas()==true){
            int preg=JOptionPane.showConfirmDialog(null,"¿DATOS CORRECTOS?","",JOptionPane.YES_NO_OPTION);
            if(preg==JOptionPane.YES_OPTION){
                try {
                    control.create(um);
                    llenartb("");
                    limipiar();
                    desabilitar();
                    
                } catch (Exception ex) {
                    Logger.getLogger(FUnidadesM.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }*/
    }//GEN-LAST:event_btnaceptarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        btnnuevo.setEnabled(true);
        desabilitar();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        txtbuscar.setText(txtbuscar.getText().toUpperCase());
        llenartb(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        habilitar();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        /*Colonia um=new Colonia();
        List<Municipio>lm=control1.findMunicipioEntities();
        int idm = 0;
        if(valEntradas()==true){
            int preg=JOptionPane.showConfirmDialog(null,"¿MODIFICAR?","",JOptionPane.YES_NO_OPTION);
            if(preg==JOptionPane.YES_OPTION){
                try {
                     um.setIdcolonia(Integer.parseInt(ttcodigo.getText()));
                     um.setNombre(txtdescripcion.getText()); 
                    for(int i=0;i<lm.size();i++){
                    if(lm.get(i).getNombrem().equals(cbmun.getSelectedItem())){
                        idm=Integer.parseInt(lm.get(i).getIdmunicipio().toString()); 
                    }
                    }                 
                    um.setIdmunicipio(idm);
                    control.edit(um); 
                    
                    Generarnumeracion();
                    desabilitar();
                    llenartb("");
                    limipiar();
                } catch (Exception ex) {
                    Logger.getLogger(FUnidadesM.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }*/

    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        int preg=JOptionPane.showConfirmDialog(null,"¿ELIMINAR?","",JOptionPane.YES_NO_OPTION);
        if(preg==JOptionPane.YES_OPTION){
            try {
           //     control.destroy(Integer.parseInt(ttcodigo.getText()));
                llenartb("");
                Generarnumeracion();
                desabilitar();
                limipiar();
                
            } catch (Exception ex) {
                Logger.getLogger(FUnidadesM.class.getName()).log(Level.SEVERE, null, ex);

            }
        }

    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnsalirActionPerformed

    private void tbcoloniasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbcoloniasMouseClicked
        MouseE();        
       /* int fis=tbcolonias.getSelectedRow();
        List<Municipio>lm=control1.findMunicipioEntities();
        if(fis>=0){
             ttcodigo.setText(tbcolonias.getValueAt(fis, 0).toString());
             txtdescripcion.setText(tbcolonias.getValueAt(fis,1).toString());
            for(int i=0;i<lm.size();i++){
            cbmun.setSelectedItem(tbcolonias.getValueAt(fis,2).toString());
            }
            
        }*/
    }//GEN-LAST:event_tbcoloniasMouseClicked
 public void llenartb(String descripcion){
      String[] titulos = {"CODIGO","COLONIA","MUNICIPIO"};
      DefaultTableModel dtm = new DefaultTableModel(null, titulos);
      String nombre="";
    /* try{
        Object o[] = null;
        List<Colonia>lista = buscarU(descripcion);
         List<Municipio>lista2 = control1.findMunicipioEntities();
         String idmm="";         
          for (int i = 0; i < lista.size(); i++) {  
                dtm.addRow(o);
                dtm.setValueAt(lista.get(i).getIdcolonia().toString(),i, 0);
                dtm.setValueAt(lista.get(i).getNombre().toString(),i, 1);  
              for(int x=0;x < lista2.size(); x++){
              idmm=String.valueOf(lista2.get(x).getIdmunicipio());
              if(idmm.equals(String.valueOf(lista.get(i).getIdmunicipio()))){
                nombre=lista2.get(x).getNombrem();
                }
              }
              dtm.setValueAt(nombre, i, 2);
            }
          tbcolonias.setModel(dtm);
       
     }catch(Exception ex){
         JOptionPane.showMessageDialog(null,"NO SE RECONOCE LA TABLA LOCALIDADES","",JOptionPane.ERROR_MESSAGE);
     }*/                 
  }

  /*  private List<Colonia> buscarU(String nombre) {
        EntityManager em = control.getEntityManager();
        Query query = em.createQuery("SELECT u FROM Colonia u WHERE u.nombre LIKE :nombre");
        query.setParameter("nombre","%"+nombre+"%");
        List<Colonia> lista = query.getResultList();
        return lista;
    }*/
 
    public void Generarnumeracion() {
      /*  String SQL = "select max(idcolonia) from colonia";

        int c = 0;
        int b = 0;
        try {
            Statement st = null;// (Statement) connect.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                c = rs.getInt(1);
            }
            if (c == 0) {
                ttcodigo.setText("1");
            } else {
                ttcodigo.setText("" + (+c + 1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FProducto.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//MetodoGenerarNumEnId*/ 
    
    public boolean valEntradas() {
        String mensaje = "";
        boolean estado = true;
        if (ttcodigo.getText().isEmpty()) {
            mensaje += "CODIGO NO DEBE ESTAR VACIO \n";
            estado = false;
        }
        if (txtdescripcion.getText().isEmpty()) {
            mensaje += "NO SE INSERTO UNA DESCRIPCION \n";
            estado = false;
        }
        if (cbmun.getSelectedIndex()==0) {
            mensaje += "MUNUCIPIO NO VALIDO \n";
            estado = false;
        }     
          if (mensaje.length() >= 6) {
            JOptionPane.showMessageDialog(null, mensaje, "", JOptionPane.WARNING_MESSAGE);

        }
        return estado;
    }
      public void desabilitar(){
        ttcodigo.setEnabled(false);
        txtdescripcion.setEnabled(false);
        btnaceptar.setEnabled(false);
        btnmodificar.setEnabled(false);
        btneliminar.setEnabled(false);
        txtdescripcion.setText("");
        cbmun.setEnabled(false);
        Generarnumeracion();
        btnnuevo.setEnabled(true);
        btncancelar.setEnabled(false);
    }
    public void habilitar(){
        ttcodigo.setEnabled(true);
        ttcodigo.setEditable(false);
        txtdescripcion.setEnabled(true);
        btnaceptar.setEnabled(true);        
        btnnuevo.setEnabled(false);
        cbmun.setEnabled(true);
        btneliminar.setEnabled(false);
        btnmodificar.setEnabled(false);
        btncancelar.setEnabled(true);
    }
    public void MouseE(){
     btnnuevo.setEnabled(false);
     btneliminar.setEnabled(true);
     btnmodificar.setEnabled(true);
     btnaceptar.setEnabled(false);
     ttcodigo.setEnabled(true);
     ttcodigo.setEditable(false);
     txtdescripcion.setEnabled(true);
     cbmun.setEnabled(true);
     btncancelar.setEnabled(true);
     
    }
    public void limipiar(){
        Generarnumeracion();
        txtdescripcion.setText("");
        cbmun.setSelectedIndex(0);
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaceptar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> cbmun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbcolonias;
    private javax.swing.JTextField ttcodigo;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtdescripcion;
    // End of variables declaration//GEN-END:variables
}
