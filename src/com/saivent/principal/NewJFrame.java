/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saivent.principal;

import com.saivent.reportes.PlantillaReporteNota;
import com.saivent.util.MetodosValidar;
import com.saivent.view.FCategorias1;
import com.saivent.view.FEstados1;
import com.saivent.view.FLocalidades1;
import com.saivent.view.FMunicipios1;
import com.saivent.view.FUnidadesM1;
import com.sistema.controller.CategoriaController;
import com.sistema.controller.ClientesController;
import com.sistema.controller.EstadosController;
import com.sistema.controller.LocalidadesController;
import com.sistema.controller.MunicipiosController;
import com.sistema.controller.NegocioController;
import com.sistema.controller.ProductoController;
import com.sistema.controller.ProveedorController;
import com.sistema.controller.UnidadesMedidaController;
import com.sistema.controller.VentasController;
import com.sistema.modelo.CategoriaDTO;
import com.sistema.modelo.ClienteDTO;
import com.sistema.modelo.ColoniaDTO;
import com.sistema.modelo.DetalleVentaDTO;
import com.sistema.modelo.ProductoDTO;
import com.sistema.modelo.ProveedorDTO;
import com.sistema.modelo.ReporteNotaVentaModelo;
import com.sistema.modelo.TiposVentaDTO;
import com.sistema.modelo.UnidadesMedidaDTO;
import com.sistema.modelo.VentaRealizadaDTO;
import com.taecel.conexionservicio.MyComboBoxUI;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wilmer
 */
public class NewJFrame extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();

    VentasController venController = new VentasController();
    ProductoController productoController = new ProductoController();
    UnidadesMedidaController unidadesController = new UnidadesMedidaController();
    ProveedorController proveedoresController = new ProveedorController();
    CategoriaController categoriaController = new CategoriaController();
    ClientesController clientesController = new ClientesController();

    String codCliente = "0000000";//variable q acumula el codigo del cliente cuando se selecciona y misma que nos sirve para validar nombre al insertar venta
    DefaultComboBoxModel dfcb = new DefaultComboBoxModel();
    DefaultTableModel dtm = new DefaultTableModel();
    DefaultTableModel dtmTicket = new DefaultTableModel();

    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Catalogos");
    JMenuItem estados = new JMenuItem("Estados");
    JMenuItem municipios = new JMenuItem("Municipios");
    JMenuItem colonias = new JMenuItem("Colonias");
    JMenuItem Unidades_medida = new JMenuItem("Unidades Medida");
    JMenuItem Categorias = new JMenuItem("Categorias");

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
        jTabbedPane1.setUI(new javax.swing.plaf.metal.MetalTabbedPaneUI() {
            protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
            }
        });
        diseñarVentana();
        diseñarJDateChooser();
        llenarNombreNegocio();
        this.setLocationRelativeTo(null);
        jComboBox2.setUI(new MyComboBoxUI());
        setMenuBar();
        accionItemEstados();
        accionItemMunicipios();
        accionItemLocalidades();
        accionItemCategorias();
        accionItemUnidadesM();
        //jComboBox2.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        //jComboBox2.getEditor().getEditorComponent().setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }

    private void setMenuBar() {
        menuBar.setSize(panelImg.getWidth(), 30);
        panelImg.add(menuBar);
        Font f = new Font("Helvetica", Font.BOLD, 12);
        menu.setFont(f);
        menu.add(estados);
        menu.add(municipios);
        menu.add(colonias);
        menu.add(Unidades_medida);
        menu.add(Categorias);
        menuBar.add(menu);
        if (menuBar != null) {
            GridBagConstraints gBconstraints = new GridBagConstraints();
            gBconstraints.gridx = 0;
            gBconstraints.gridy = 0;
            gBconstraints.gridwidth = 1;
            gBconstraints.gridheight = 1;
            gBconstraints.fill = GridBagConstraints.HORIZONTAL;
            gBconstraints.weightx = 1;
            //adding this JMenuBar
            panelImg.add(menuBar, gBconstraints);
        }

    }

    //Accion al item estados
    public void accionItemEstados() {
        //Evento estado
        estados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FEstados1 rpv = new FEstados1();
                try {
                    JDialog dialogov = new JDialog(rpv, "ADMINISTRACION ESTADOS", true);
                    dialogov.add(rpv.getContentPane());
                    dialogov.setSize(430, 400);
                    dialogov.setLocationRelativeTo(null);
                    dialogov.setVisible(true);
                    dialogov.setModal(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "ERROR AL CONECTAR A LA BASE DE DATOS", "", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void accionItemMunicipios() {
        //Evento estado
        municipios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FMunicipios1 rpv = new FMunicipios1();
                try {
                    JDialog dialogov = new JDialog(rpv, "ADMINISTRACION MUNICIPIOS", true);
                    dialogov.add(rpv.getContentPane());
                    dialogov.setSize(430, 400);
                    dialogov.setLocationRelativeTo(null);
                    dialogov.setVisible(true);
                    dialogov.setModal(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "ERROR AL CONECTAR A LA BASE DE DATOS", "", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void accionItemLocalidades() {
        //Evento colonias
        colonias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FLocalidades1 rpv = new FLocalidades1();
                try {
                    JDialog dialogov = new JDialog(rpv, "ADMINISTRACION COLONIAS", true);
                    dialogov.add(rpv.getContentPane());
                    dialogov.setSize(430, 400);
                    dialogov.setLocationRelativeTo(null);
                    dialogov.setVisible(true);
                    dialogov.setModal(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "ERROR AL CONECTAR A LA BASE DE DATOS", "", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void accionItemCategorias() {
        //Evento colonias
        Categorias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FCategorias1 rpv = new FCategorias1();
                try {
                    JDialog dialogov = new JDialog(rpv, "ADMINISTRACION CATEGORIAS", true);
                    dialogov.add(rpv.getContentPane());
                    dialogov.setSize(430, 400);
                    dialogov.setLocationRelativeTo(null);
                    dialogov.setVisible(true);
                    dialogov.setModal(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "ERROR AL CONECTAR A LA BASE DE DATOS", "", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void accionItemUnidadesM() {
        //Evento colonias
        Unidades_medida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FUnidadesM1 rpv = new FUnidadesM1();
                try {
                    JDialog dialogov = new JDialog(rpv, "ADMINISTRACION UNIDADES MEDIDA", true);
                    dialogov.add(rpv.getContentPane());
                    dialogov.setSize(430, 400);
                    dialogov.setLocationRelativeTo(null);
                    dialogov.setVisible(true);
                    dialogov.setModal(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "ERROR AL CONECTAR A LA BASE DE DATOS", "", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    //Metodo para diseñar mi ventana
    public void diseñarVentana() {
        //Inserto item a mi combo default
        dfcb.addElement("SELECCIONE");
        //añado columnas a mi modelo tabla
        dtmTicket.addColumn("ID");
        dtmTicket.addColumn("PRODUCTO");
        dtmTicket.addColumn("PRECIO");
        dtmTicket.addColumn("CANTIDAD");
        dtmTicket.addColumn("TOTAL");
        tbTicket.setModel(dtmTicket);
        //llamo el metodo para cargar los metodos de venta
        llenarCBM();

        //Txt cliente inicia con valor xxx por si es venta a publico el cliente se van con XXXXXXXXXXXXXXXXXXXX
        txtCliente.setText("XXXXXXXXXXXXXXXXXXXXXXXXX");
        //como mi ticket inicia vacio mi boton debe estar inabilitado
        btnVaciarTicket.setEnabled(false);
        //A mi objeto de calendar le paso la fecha actual del sistema
        setFechaTiempoReal();
        //Inicio botones desabilitados
        btnAdd.setEnabled(false);
        inicioFrame();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogClientes = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtclientesb = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jpanelJDClientesTB = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbClientes1 = new javax.swing.JTable();
        jDialogProducto = new javax.swing.JDialog();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtProductoB = new javax.swing.JTextField();
        btnsalir = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        btnaddProd = new javax.swing.JButton();
        jDialogProductosAdmin = new javax.swing.JDialog();
        plista = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbproductosAdmin = new javax.swing.JTable();
        pnlDatos1 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btnaceptar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        pcontenido = new javax.swing.JPanel();
        txtnombre = new javax.swing.JTextField();
        sppcliente = new javax.swing.JSpinner();
        cbunidad = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        spppublico = new javax.swing.JSpinner();
        spcantidad = new javax.swing.JSpinner();
        cbproveedor = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnNuevaVenta = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnConfig = new javax.swing.JButton();
        LabelVendedor = new javax.swing.JLabel();
        tipo = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        btnVender = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        txtDescripcionVenta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        cbTipoVenta = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        txtCantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        Midate = new com.toedter.calendar.JDateChooser();
        jPanel23 = new javax.swing.JPanel();
        txtStockDisponible = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTicket = new javax.swing.JTable();
        txtTotal = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnGenerarVenta = new javax.swing.JButton();
        txtIdCV = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        txtCliente = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        txtRucVenta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnVaciarTicket = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        lblcodigo = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        lbldireccion = new javax.swing.JLabel();
        lbltelefono = new javax.swing.JLabel();
        txtcodigoClienteIndex = new javax.swing.JTextField();
        txtnombreClienteIndex = new javax.swing.JTextField();
        txttelefonoClienteIndex = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        btnaceptarClienteIndex = new javax.swing.JButton();
        btncancelarClienteIndex = new javax.swing.JButton();
        txtemailClienteIndex = new javax.swing.JTextField();
        lblgenero = new javax.swing.JLabel();
        lblemail = new javax.swing.JLabel();
        cbcolClienteIndex = new javax.swing.JComboBox<>();
        cbmuniClienteIndex = new javax.swing.JComboBox<>();
        cbestadoClienteIndex = new javax.swing.JComboBox<>();
        cbgeneroClienteIndex = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbclientesIndex = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnnuevoClienteIndex = new javax.swing.JButton();
        btnmodificarClienteIndex = new javax.swing.JButton();
        btneliminarClienteIndex = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        pnlDatos = new javax.swing.JPanel();
        j1 = new javax.swing.JLabel();
        btnaceptarProveedorIndex = new javax.swing.JButton();
        txtCodigoProveedorIndex = new javax.swing.JTextField();
        btncancelarProveedorIndex = new javax.swing.JButton();
        txtemailProveedorIndex = new javax.swing.JTextField();
        j2 = new javax.swing.JLabel();
        txttelefonoProveedorIndex = new javax.swing.JTextField();
        j4 = new javax.swing.JLabel();
        txtEmpresaProveedorIndex = new javax.swing.JTextField();
        j5 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        pnlLista = new javax.swing.JPanel();
        btnnuevoProveedorIndex = new javax.swing.JButton();
        btneliminarProveedorIndex = new javax.swing.JButton();
        btnmodificarProveedorIndex = new javax.swing.JButton();
        btnsalir2 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        txtbuscarProveedorIndex = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbProveedorIndex = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        plista1 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        btnnuevoProductosIndex = new javax.swing.JButton();
        txtBuscarProductosIndex = new javax.swing.JTextField();
        btnmodificarProductosIndex = new javax.swing.JButton();
        btneliminarProductosIndex = new javax.swing.JButton();
        btnsalir3 = new javax.swing.JButton();
        padquisicion = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tbProductosIndex = new javax.swing.JTable();
        pnlDatos2 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        btnaceptarProductosIndex = new javax.swing.JButton();
        btncancelarProductosIndex = new javax.swing.JButton();
        pcontenido1 = new javax.swing.JPanel();
        txtnombreProductoIndex = new javax.swing.JTextField();
        sppclienteProductoIndex = new javax.swing.JSpinner();
        cbunidadProductoIndex = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtcodigoProductoIndex = new javax.swing.JTextField();
        spppublicoProductoIndex = new javax.swing.JSpinner();
        spcantidadProductosIndex = new javax.swing.JSpinner();
        cbproveedorProductosIndex = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabelCat = new javax.swing.JLabel();
        cbcategoriaProductosIndex = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelImg = new FondoPanel();
        lblTitulo = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel2.setText("BUSCAR");

        txtclientesb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtclientesbKeyReleased(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/salir ventana.png"))); // NOI18N
        jButton3.setText("SALIR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(0, 111, 111));

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("SELECCION DE CLIENTES");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel11)
                .addContainerGap(153, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
        );

        jpanelJDClientesTB.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        tbClientes1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        tbClientes1.setModel(new javax.swing.table.DefaultTableModel(
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
        tbClientes1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClientes1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbClientes1);

        javax.swing.GroupLayout jpanelJDClientesTBLayout = new javax.swing.GroupLayout(jpanelJDClientesTB);
        jpanelJDClientesTB.setLayout(jpanelJDClientesTBLayout);
        jpanelJDClientesTBLayout.setHorizontalGroup(
            jpanelJDClientesTBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelJDClientesTBLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpanelJDClientesTBLayout.setVerticalGroup(
            jpanelJDClientesTBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelJDClientesTBLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtclientesb, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jpanelJDClientesTB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtclientesb, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpanelJDClientesTB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jDialogClientesLayout = new javax.swing.GroupLayout(jDialogClientes.getContentPane());
        jDialogClientes.getContentPane().setLayout(jDialogClientesLayout);
        jDialogClientesLayout.setHorizontalGroup(
            jDialogClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jDialogClientesLayout.setVerticalGroup(
            jDialogClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel12.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel12.setText("BUSCAR");

        txtProductoB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProductoBKeyReleased(evt);
            }
        });

        btnsalir.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/salir ventana.png"))); // NOI18N
        btnsalir.setText("SALIR");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(0, 111, 111));

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("SELECCION DE PRODUCTOS");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        tbProductos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbProductos);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnaddProd.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnaddProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/gestiones-menu.png"))); // NOI18N
        btnaddProd.setText("Productos");
        btnaddProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnsalir)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtProductoB, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnaddProd)))))
                .addGap(19, 19, 19))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProductoB, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnaddProd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jDialogProductoLayout = new javax.swing.GroupLayout(jDialogProducto.getContentPane());
        jDialogProducto.getContentPane().setLayout(jDialogProductoLayout);
        jDialogProductoLayout.setHorizontalGroup(
            jDialogProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogProductoLayout.setVerticalGroup(
            jDialogProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        plista.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        plista.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel14.setText("BUSCAR");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        tbproductosAdmin.setBackground(new java.awt.Color(204, 204, 255));
        tbproductosAdmin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbproductosAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbproductosAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbproductosAdminMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbproductosAdmin);

        javax.swing.GroupLayout plistaLayout = new javax.swing.GroupLayout(plista);
        plista.setLayout(plistaLayout);
        plistaLayout.setHorizontalGroup(
            plistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plistaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plistaLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE))
                .addContainerGap())
        );
        plistaLayout.setVerticalGroup(
            plistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plistaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDatos1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        btnaceptar.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnaceptar.setText("MODIFICAR");
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

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btncancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnaceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnaceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(btncancelar)
                .addContainerGap())
        );

        pcontenido.setForeground(new java.awt.Color(102, 255, 102));

        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreKeyReleased(evt);
            }
        });

        sppcliente.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        cbunidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---" }));
        cbunidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbunidadActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel15.setText("CODIGO");

        jLabel16.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel16.setText("NOMBRE");

        jLabel17.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel17.setText("UNIDAD MEDIDA");

        jLabel18.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel18.setText("PRECIO CLIENTE");

        txtcod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcodKeyReleased(evt);
            }
        });

        spppublico.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        cbproveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---" }));

        jLabel19.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel19.setText("PRECIO PUBLICO");

        jLabel20.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel20.setText("CANTIDAD");

        jLabel21.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel21.setText("PROVEEDOR");

        javax.swing.GroupLayout pcontenidoLayout = new javax.swing.GroupLayout(pcontenido);
        pcontenido.setLayout(pcontenidoLayout);
        pcontenidoLayout.setHorizontalGroup(
            pcontenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pcontenidoLayout.createSequentialGroup()
                .addGroup(pcontenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pcontenidoLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel15))
                    .addGroup(pcontenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pcontenidoLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(pcontenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGroup(pcontenidoLayout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pcontenidoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17)))
                .addGap(18, 18, 18)
                .addGroup(pcontenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtcod)
                    .addComponent(txtnombre)
                    .addComponent(cbunidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spcantidad)
                    .addComponent(cbproveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spppublico)
                    .addComponent(sppcliente))
                .addGap(21, 21, 21))
        );
        pcontenidoLayout.setVerticalGroup(
            pcontenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pcontenidoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pcontenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pcontenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pcontenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbunidad, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pcontenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sppcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pcontenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spppublico, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pcontenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pcontenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlDatos1Layout = new javax.swing.GroupLayout(pnlDatos1);
        pnlDatos1.setLayout(pnlDatos1Layout);
        pnlDatos1Layout.setHorizontalGroup(
            pnlDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatos1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pcontenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        pnlDatos1Layout.setVerticalGroup(
            pnlDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatos1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatos1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pcontenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialogProductosAdminLayout = new javax.swing.GroupLayout(jDialogProductosAdmin.getContentPane());
        jDialogProductosAdmin.getContentPane().setLayout(jDialogProductosAdminLayout);
        jDialogProductosAdminLayout.setHorizontalGroup(
            jDialogProductosAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogProductosAdminLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jDialogProductosAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDatos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(plista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jDialogProductosAdminLayout.setVerticalGroup(
            jDialogProductosAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogProductosAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDatos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(plista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowIconified(java.awt.event.WindowEvent evt) {
                formWindowIconified(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(85, 112, 148));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logo_pdf.png"))); // NOI18N

        btnNuevaVenta.setBackground(new java.awt.Color(0, 0, 0));
        btnNuevaVenta.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnNuevaVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevaVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nventa.png"))); // NOI18N
        btnNuevaVenta.setText("Nueva Venta");
        btnNuevaVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevaVenta.setFocusable(false);
        btnNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaVentaActionPerformed(evt);
            }
        });

        btnClientes.setBackground(new java.awt.Color(0, 0, 0));
        btnClientes.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Clientes.png"))); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClientes.setFocusable(false);
        btnClientes.setPreferredSize(new java.awt.Dimension(103, 37));
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnProveedor.setBackground(new java.awt.Color(0, 0, 0));
        btnProveedor.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/proveedor.png"))); // NOI18N
        btnProveedor.setText("Proveedor");
        btnProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProveedor.setFocusable(false);
        btnProveedor.setPreferredSize(new java.awt.Dimension(103, 37));
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        btnProductos.setBackground(new java.awt.Color(0, 0, 0));
        btnProductos.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/producto.png"))); // NOI18N
        btnProductos.setText("Productos");
        btnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductos.setFocusable(false);
        btnProductos.setPreferredSize(new java.awt.Dimension(103, 37));
        btnProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductosMouseClicked(evt);
            }
        });
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnConfig.setBackground(new java.awt.Color(0, 0, 0));
        btnConfig.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnConfig.setForeground(new java.awt.Color(255, 255, 255));
        btnConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/config.png"))); // NOI18N
        btnConfig.setText("Config");
        btnConfig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfig.setFocusable(false);
        btnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigActionPerformed(evt);
            }
        });

        LabelVendedor.setForeground(new java.awt.Color(255, 255, 255));
        LabelVendedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelVendedor.setText("Administrador");

        tipo.setForeground(new java.awt.Color(255, 255, 255));

        btnUsuarios.setBackground(new java.awt.Color(0, 0, 0));
        btnUsuarios.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/editar_user.png"))); // NOI18N
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarios.setFocusable(false);
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevaVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
            .addComponent(btnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnConfig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LabelVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(tipo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LabelVendedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jComboBox2.getAccessibleContext().setAccessibleName("");

        jPanel19.setBackground(new java.awt.Color(0, 110, 255));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel20.setBackground(new java.awt.Color(0, 110, 255));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        txtDescripcionVenta.setEditable(false);
        txtDescripcionVenta.setBackground(new java.awt.Color(204, 204, 204));
        txtDescripcionVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDescripcionVenta.setBorder(null);
        txtDescripcionVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionVentaKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Descripción");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Código");

        txtCod.setBackground(new java.awt.Color(204, 204, 204));
        txtCod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCod.setBorder(null);
        txtCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodKeyTyped(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BUSCAR2.1.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cbTipoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCod, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addComponent(txtDescripcionVenta)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(cbTipoVenta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDescripcionVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbTipoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );

        txtCantidad.setBackground(new java.awt.Color(204, 204, 204));
        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidad.setBorder(null);
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Cant");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Precio");

        txtPrecioVenta.setEditable(false);
        txtPrecioVenta.setBackground(new java.awt.Color(204, 204, 204));
        txtPrecioVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioVenta.setBorder(null);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Create.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jPanel22.setBackground(new java.awt.Color(0, 110, 255));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel21.setBackground(new java.awt.Color(0, 110, 255));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecioVenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd)
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(5, 5, 5)
                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioVenta))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );

        Midate.setBackground(new java.awt.Color(204, 204, 204));

        jPanel23.setBackground(new java.awt.Color(0, 110, 255));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        txtStockDisponible.setEditable(false);
        txtStockDisponible.setBackground(new java.awt.Color(204, 204, 204));
        txtStockDisponible.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStockDisponible.setBorder(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("Stock Disponible");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Midate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtStockDisponible)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(Midate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStockDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(68, 68, 68))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbTicket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DESCRIPCIÓN", "CANTIDAD", "PRECIO U.", "PRECIO TOTAL"
            }
        ));
        jScrollPane1.setViewportView(tbTicket);

        txtTotal.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        txtTotal.setText("0.0");

        jLabel10.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/money.png"))); // NOI18N
        jLabel10.setText("Total a Pagar $:");

        btnGenerarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/print.png"))); // NOI18N
        btnGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarVentaActionPerformed(evt);
            }
        });

        jPanel25.setBackground(new java.awt.Color(0, 110, 255));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        txtCliente.setEditable(false);
        txtCliente.setBackground(new java.awt.Color(204, 204, 204));
        txtCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCliente.setBorder(null);

        jPanel24.setBackground(new java.awt.Color(0, 110, 255));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        txtRucVenta.setBackground(new java.awt.Color(204, 204, 204));
        txtRucVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRucVenta.setBorder(null);
        txtRucVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRucVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucVentaKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Dni/Ruc");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Nombre");

        btnVaciarTicket.setText("jButton1");

        javax.swing.GroupLayout btnVenderLayout = new javax.swing.GroupLayout(btnVender);
        btnVender.setLayout(btnVenderLayout);
        btnVenderLayout.setHorizontalGroup(
            btnVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnVenderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnVenderLayout.createSequentialGroup()
                        .addComponent(btnVaciarTicket)
                        .addGap(51, 51, 51)
                        .addGroup(btnVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(btnVenderLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addGap(375, 375, 375))
                            .addGroup(btnVenderLayout.createSequentialGroup()
                                .addGroup(btnVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(btnVenderLayout.createSequentialGroup()
                                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(btnVenderLayout.createSequentialGroup()
                                        .addComponent(txtRucVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtIdCV, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(btnGenerarVenta)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        btnVenderLayout.setVerticalGroup(
            btnVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnVenderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addGroup(btnVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btnVenderLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(btnVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnVaciarTicket)
                            .addComponent(btnGenerarVenta, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(btnVenderLayout.createSequentialGroup()
                                .addGroup(btnVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(3, 3, 3)
                                .addGroup(btnVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtRucVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdCV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(btnVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(btnVenderLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(btnVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotal))))
                .addGap(46, 46, 46))
        );

        jTabbedPane1.addTab("tab1", btnVender);

        jPanel13.setBackground(new java.awt.Color(0, 111, 111));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblcodigo.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblcodigo.setForeground(new java.awt.Color(254, 254, 254));
        lblcodigo.setText("CODIGO");

        lblnombre.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblnombre.setForeground(new java.awt.Color(254, 254, 254));
        lblnombre.setText("NOMBRE");

        lbldireccion.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lbldireccion.setForeground(new java.awt.Color(254, 254, 254));
        lbldireccion.setText("DIRECCION");

        lbltelefono.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lbltelefono.setForeground(new java.awt.Color(254, 254, 254));
        lbltelefono.setText("TELEFONO");

        txtcodigoClienteIndex.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcodigoClienteIndexKeyReleased(evt);
            }
        });

        txtnombreClienteIndex.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreClienteIndexKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreClienteIndexKeyTyped(evt);
            }
        });

        txttelefonoClienteIndex.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttelefonoClienteIndexKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttelefonoClienteIndexKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoClienteIndexKeyTyped(evt);
            }
        });

        jPanel14.setBackground(new java.awt.Color(0, 111, 111));

        btnaceptarClienteIndex.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnaceptarClienteIndex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/aceptar.png"))); // NOI18N
        btnaceptarClienteIndex.setText("ACEPTAR");
        btnaceptarClienteIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceptarClienteIndexActionPerformed(evt);
            }
        });

        btncancelarClienteIndex.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btncancelarClienteIndex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cancelar.png"))); // NOI18N
        btncancelarClienteIndex.setText("CANCELAR");
        btncancelarClienteIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarClienteIndexActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnaceptarClienteIndex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btncancelarClienteIndex, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnaceptarClienteIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(btncancelarClienteIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        txtemailClienteIndex.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtemailClienteIndexKeyTyped(evt);
            }
        });

        lblgenero.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblgenero.setForeground(new java.awt.Color(254, 254, 254));
        lblgenero.setText("GENERO");

        lblemail.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblemail.setForeground(new java.awt.Color(254, 254, 254));
        lblemail.setText("EMAIL");

        cbcolClienteIndex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---" }));
        cbcolClienteIndex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbcolClienteIndexMouseClicked(evt);
            }
        });
        cbcolClienteIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbcolClienteIndexActionPerformed(evt);
            }
        });

        cbmuniClienteIndex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---" }));

        cbestadoClienteIndex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---" }));

        cbgeneroClienteIndex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONA", "HOMBRE", "MUJER" }));

        jLabel22.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(254, 254, 254));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("CLIENTES");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblgenero)
                            .addComponent(lblemail)
                            .addComponent(lbltelefono)
                            .addComponent(lbldireccion)
                            .addComponent(lblnombre)
                            .addComponent(lblcodigo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtemailClienteIndex, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbgeneroClienteIndex, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                                .addComponent(cbcolClienteIndex, 0, 227, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbmuniClienteIndex, 0, 227, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbestadoClienteIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txttelefonoClienteIndex, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcodigoClienteIndex, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnombreClienteIndex, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcodigoClienteIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblcodigo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnombreClienteIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblnombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbestadoClienteIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbcolClienteIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbldireccion))
                            .addComponent(cbmuniClienteIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttelefonoClienteIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbltelefono))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblgenero)
                            .addComponent(cbgeneroClienteIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtemailClienteIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblemail)))
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(0, 111, 111));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tbclientesIndex = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        tbclientesIndex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbclientesIndex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbclientesIndexMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbclientesIndex);

        jLabel23.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(253, 251, 251));
        jLabel23.setText("BUSCAR");

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        btnnuevoClienteIndex.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnnuevoClienteIndex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/nuevo.png"))); // NOI18N
        btnnuevoClienteIndex.setText("NUEVO");
        btnnuevoClienteIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoClienteIndexActionPerformed(evt);
            }
        });

        btnmodificarClienteIndex.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnmodificarClienteIndex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/modiicar.png"))); // NOI18N
        btnmodificarClienteIndex.setText("MODIFICAR");
        btnmodificarClienteIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarClienteIndexActionPerformed(evt);
            }
        });

        btneliminarClienteIndex.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btneliminarClienteIndex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/eliminar.png"))); // NOI18N
        btneliminarClienteIndex.setText("ELIMINAR");
        btneliminarClienteIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarClienteIndexActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(btnnuevoClienteIndex)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnmodificarClienteIndex)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btneliminarClienteIndex))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnuevoClienteIndex)
                    .addComponent(btnmodificarClienteIndex)
                    .addComponent(btneliminarClienteIndex))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        pnlDatos.setBackground(new java.awt.Color(0, 111, 111));
        pnlDatos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        j1.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        j1.setForeground(new java.awt.Color(254, 254, 254));
        j1.setText("CODIGO");

        btnaceptarProveedorIndex.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnaceptarProveedorIndex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/aceptar.png"))); // NOI18N
        btnaceptarProveedorIndex.setText("ACEPTAR");
        btnaceptarProveedorIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceptarProveedorIndexActionPerformed(evt);
            }
        });

        txtCodigoProveedorIndex.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtCodigoProveedorIndex.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoProveedorIndexKeyReleased(evt);
            }
        });

        btncancelarProveedorIndex.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btncancelarProveedorIndex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cancelar.png"))); // NOI18N
        btncancelarProveedorIndex.setText("CANCELAR");
        btncancelarProveedorIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarProveedorIndexActionPerformed(evt);
            }
        });

        txtemailProveedorIndex.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtemailProveedorIndex.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtemailProveedorIndexKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtemailProveedorIndexKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtemailProveedorIndexKeyTyped(evt);
            }
        });

        j2.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        j2.setForeground(new java.awt.Color(254, 254, 254));
        j2.setText("EMPRESA");

        txttelefonoProveedorIndex.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txttelefonoProveedorIndex.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttelefonoProveedorIndexKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttelefonoProveedorIndexKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoProveedorIndexKeyTyped(evt);
            }
        });

        j4.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        j4.setForeground(new java.awt.Color(254, 254, 254));
        j4.setText("TELEFONO");

        txtEmpresaProveedorIndex.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtEmpresaProveedorIndex.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmpresaProveedorIndexKeyReleased(evt);
            }
        });

        j5.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        j5.setForeground(new java.awt.Color(254, 254, 254));
        j5.setText("EMAIL");

        jLabel24.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(254, 254, 254));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("PROVEEDORES");

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDatosLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addComponent(j4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(j2)
                                    .addComponent(j1)
                                    .addComponent(j5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlDatosLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(btnaceptarProveedorIndex)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 605, Short.MAX_VALUE)
                                        .addComponent(btncancelarProveedorIndex))
                                    .addComponent(txttelefonoProveedorIndex)
                                    .addComponent(txtCodigoProveedorIndex)
                                    .addComponent(txtemailProveedorIndex, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtEmpresaProveedorIndex))))))
                .addGap(15, 15, 15))
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoProveedorIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmpresaProveedorIndex, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(j2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttelefonoProveedorIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemailProveedorIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j5))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnaceptarProveedorIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncancelarProveedorIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pnlLista.setBackground(new java.awt.Color(0, 111, 111));
        pnlLista.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        btnnuevoProveedorIndex.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnnuevoProveedorIndex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/nuevo.png"))); // NOI18N
        btnnuevoProveedorIndex.setText("NUEVO");
        btnnuevoProveedorIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoProveedorIndexActionPerformed(evt);
            }
        });

        btneliminarProveedorIndex.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btneliminarProveedorIndex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/eliminar.png"))); // NOI18N
        btneliminarProveedorIndex.setText("ELIMINAR");
        btneliminarProveedorIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarProveedorIndexActionPerformed(evt);
            }
        });

        btnmodificarProveedorIndex.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnmodificarProveedorIndex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/modiicar.png"))); // NOI18N
        btnmodificarProveedorIndex.setText("MODIFICAR");
        btnmodificarProveedorIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarProveedorIndexActionPerformed(evt);
            }
        });

        btnsalir2.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnsalir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/salir ventana.png"))); // NOI18N
        btnsalir2.setText("CERRAR");
        btnsalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalir2ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(254, 254, 254));
        jLabel25.setText("BUSCAR");

        txtbuscarProveedorIndex.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarProveedorIndexKeyReleased(evt);
            }
        });

        tbProveedorIndex = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        tbProveedorIndex.setModel(new javax.swing.table.DefaultTableModel(
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
        tbProveedorIndex.setEditingColumn(0);
        tbProveedorIndex.setEditingRow(0);
        tbProveedorIndex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProveedorIndexMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbProveedorIndex);

        javax.swing.GroupLayout pnlListaLayout = new javax.swing.GroupLayout(pnlLista);
        pnlLista.setLayout(pnlListaLayout);
        pnlListaLayout.setHorizontalGroup(
            pnlListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlListaLayout.createSequentialGroup()
                        .addComponent(btnnuevoProveedorIndex)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnmodificarProveedorIndex)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneliminarProveedorIndex)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 486, Short.MAX_VALUE)
                        .addComponent(btnsalir2))
                    .addComponent(jScrollPane6)
                    .addGroup(pnlListaLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbuscarProveedorIndex)))
                .addContainerGap())
        );
        pnlListaLayout.setVerticalGroup(
            pnlListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListaLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(pnlListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscarProveedorIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addGroup(pnlListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlListaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnsalir2))
                    .addGroup(pnlListaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnlListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btneliminarProveedorIndex, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnmodificarProveedorIndex)
                                .addComponent(btnnuevoProveedorIndex)))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlLista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab3", jPanel16);

        plista1.setBackground(new java.awt.Color(17, 140, 140));
        plista1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        plista1.setEnabled(false);

        jLabel26.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(254, 254, 254));
        jLabel26.setText("PRODUCTO");

        btnnuevoProductosIndex.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnnuevoProductosIndex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/nuevo.png"))); // NOI18N
        btnnuevoProductosIndex.setText("NUEVO");
        btnnuevoProductosIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoProductosIndexActionPerformed(evt);
            }
        });

        txtBuscarProductosIndex.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProductosIndexKeyReleased(evt);
            }
        });

        btnmodificarProductosIndex.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnmodificarProductosIndex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/modiicar.png"))); // NOI18N
        btnmodificarProductosIndex.setText("MODIFICAR");
        btnmodificarProductosIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarProductosIndexActionPerformed(evt);
            }
        });

        btneliminarProductosIndex.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btneliminarProductosIndex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/eliminar.png"))); // NOI18N
        btneliminarProductosIndex.setText("ELIMINAR");
        btneliminarProductosIndex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btneliminarProductosIndexMouseClicked(evt);
            }
        });
        btneliminarProductosIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarProductosIndexActionPerformed(evt);
            }
        });

        btnsalir3.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnsalir3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/salir ventana.png"))); // NOI18N
        btnsalir3.setText("CERRAR");
        btnsalir3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalir3ActionPerformed(evt);
            }
        });

        padquisicion.setText("jLabel2");

        tbProductosIndex.setModel(new javax.swing.table.DefaultTableModel(
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
        tbProductosIndex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductosIndexMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tbProductosIndex);

        javax.swing.GroupLayout plista1Layout = new javax.swing.GroupLayout(plista1);
        plista1.setLayout(plista1Layout);
        plista1Layout.setHorizontalGroup(
            plista1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plista1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plista1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9)
                    .addGroup(plista1Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscarProductosIndex))
                    .addGroup(plista1Layout.createSequentialGroup()
                        .addComponent(btnnuevoProductosIndex)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnmodificarProductosIndex)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btneliminarProductosIndex)
                        .addGap(31, 31, 31)
                        .addComponent(padquisicion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 414, Short.MAX_VALUE)
                        .addComponent(btnsalir3)))
                .addContainerGap())
        );
        plista1Layout.setVerticalGroup(
            plista1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plista1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plista1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtBuscarProductosIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addGroup(plista1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsalir3)
                    .addComponent(btneliminarProductosIndex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnmodificarProductosIndex)
                    .addComponent(btnnuevoProductosIndex)
                    .addComponent(padquisicion))
                .addContainerGap())
        );

        pnlDatos2.setBackground(new java.awt.Color(0, 111, 111));
        pnlDatos2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        btnaceptarProductosIndex.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnaceptarProductosIndex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/aceptar.png"))); // NOI18N
        btnaceptarProductosIndex.setText("ACEPTAR");
        btnaceptarProductosIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceptarProductosIndexActionPerformed(evt);
            }
        });

        btncancelarProductosIndex.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btncancelarProductosIndex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cancelar.png"))); // NOI18N
        btncancelarProductosIndex.setText("CANCELAR");
        btncancelarProductosIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarProductosIndexActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btncancelarProductosIndex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnaceptarProductosIndex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnaceptarProductosIndex)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(btncancelarProductosIndex)
                .addContainerGap())
        );

        pcontenido1.setBackground(new java.awt.Color(0, 111, 111));
        pcontenido1.setForeground(new java.awt.Color(102, 255, 102));

        txtnombreProductoIndex.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreProductoIndexKeyReleased(evt);
            }
        });

        sppclienteProductoIndex.setModel(new javax.swing.SpinnerNumberModel(0.0f, null, null, 5.0f));

        cbunidadProductoIndex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---" }));
        cbunidadProductoIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbunidadProductoIndexActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(254, 254, 254));
        jLabel27.setText("CODIGO");

        jLabel28.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(254, 254, 254));
        jLabel28.setText("NOMBRE");

        jLabel29.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(254, 254, 254));
        jLabel29.setText("UNIDAD MEDIDA");

        jLabel30.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(254, 254, 254));
        jLabel30.setText("PRECIO CLIENTE");

        txtcodigoProductoIndex.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcodigoProductoIndexKeyReleased(evt);
            }
        });

        spppublicoProductoIndex.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        cbproveedorProductosIndex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---" }));

        jLabel31.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(254, 254, 254));
        jLabel31.setText("PRECIO PUBLICO");

        jLabel32.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(254, 254, 254));
        jLabel32.setText("CANTIDAD");

        jLabel33.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(254, 254, 254));
        jLabel33.setText("PROVEEDOR");

        jLabelCat.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabelCat.setForeground(new java.awt.Color(254, 254, 254));
        jLabelCat.setText("CATEGORIA");

        cbcategoriaProductosIndex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---" }));

        javax.swing.GroupLayout pcontenido1Layout = new javax.swing.GroupLayout(pcontenido1);
        pcontenido1.setLayout(pcontenido1Layout);
        pcontenido1Layout.setHorizontalGroup(
            pcontenido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pcontenido1Layout.createSequentialGroup()
                .addGroup(pcontenido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pcontenido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pcontenido1Layout.createSequentialGroup()
                            .addGap(67, 67, 67)
                            .addComponent(jLabel28))
                        .addGroup(pcontenido1Layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addGroup(pcontenido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel32)
                                .addComponent(jLabel33)
                                .addGroup(pcontenido1Layout.createSequentialGroup()
                                    .addComponent(jLabel27)
                                    .addGap(3, 3, 3)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pcontenido1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pcontenido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCat, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(30, 30, 30)
                .addGroup(pcontenido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbproveedorProductosIndex, 0, 651, Short.MAX_VALUE)
                    .addComponent(spcantidadProductosIndex)
                    .addComponent(spppublicoProductoIndex)
                    .addComponent(sppclienteProductoIndex)
                    .addComponent(cbunidadProductoIndex, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtnombreProductoIndex)
                    .addComponent(txtcodigoProductoIndex)
                    .addComponent(cbcategoriaProductosIndex, 0, 651, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        pcontenido1Layout.setVerticalGroup(
            pcontenido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pcontenido1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pcontenido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcodigoProductoIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pcontenido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombreProductoIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pcontenido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbunidadProductoIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pcontenido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sppclienteProductoIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pcontenido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spppublicoProductoIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pcontenido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spcantidadProductosIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pcontenido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbproveedorProductosIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pcontenido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCat)
                    .addComponent(cbcategoriaProductosIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel34.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(254, 254, 254));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("PRODUCTOS");

        javax.swing.GroupLayout pnlDatos2Layout = new javax.swing.GroupLayout(pnlDatos2);
        pnlDatos2.setLayout(pnlDatos2Layout);
        pnlDatos2Layout.setHorizontalGroup(
            pnlDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatos2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pcontenido1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlDatos2Layout.setVerticalGroup(
            pnlDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatos2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatos2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlDatos2Layout.createSequentialGroup()
                        .addComponent(pcontenido1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(plista1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlDatos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDatos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(plista1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab4", jPanel17);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(370, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(415, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab5", jPanel26);

        lblTitulo.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("jLabel2");

        javax.swing.GroupLayout panelImgLayout = new javax.swing.GroupLayout(panelImg);
        panelImg.setLayout(panelImgLayout);
        panelImgLayout.setHorizontalGroup(
            panelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelImgLayout.setVerticalGroup(
            panelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImgLayout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(panelImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jTabbedPane1))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaVentaActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btnNuevaVentaActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        ListarClientes("");
        llenarCombosClientes();
        desabilitarControlerCliente();
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        carga_informacion_Prov("");
        DesabilitarControlesProveedor();
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosMouseClicked

    }//GEN-LAST:event_btnProductosMouseClicked

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        
        desabPanContenidoProductos();
        llenarUnidades(cbunidadProductoIndex);
        llenarProveedores(cbproveedorProductosIndex);  
        llenarCategoria();
        llenarTbProductos("");
        jTabbedPane1.setSelectedIndex(3);
        

    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigActionPerformed
        // TODO add your handling code here:

        jTabbedPane1.setSelectedIndex(2);

    }//GEN-LAST:event_btnConfigActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed

    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void txtDescripcionVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionVentaKeyTyped

    }//GEN-LAST:event_txtDescripcionVentaKeyTyped

    private void txtCodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodKeyPressed
        new MetodosValidar().soloNumeros(txtCod, 10);
    }//GEN-LAST:event_txtCodKeyPressed

    private void txtCodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodKeyTyped
        char c = evt.getKeyChar();
        if (c == KeyEvent.VK_ENTER && !txtCod.getText().equals("")) {
            ProductoDTO prod = productoController.productoById(Integer.parseInt(txtCod.getText()));
            if (prod.getIdproducto() != null) {
                txtDescripcionVenta.setText(prod.getNombre());
                if (cbTipoVenta.getSelectedItem().toString().toUpperCase().contains("CLIEN")) {
                    txtPrecioVenta.setText(String.valueOf(prod.getPreciocliente()));
                } else {
                    txtPrecioVenta.setText(String.valueOf(prod.getPrecio()));
                }
                txtStockDisponible.setText(String.valueOf(prod.getStock()));
                txtCantidad.requestFocus();
                btnAdd.setEnabled(true);
                if (prod.getStock() > 0) {
                    txtCantidad.setText("0");
                    txtCantidad.setEditable(true);
                } else {
                    new MetodosValidar().advertencia("VERIFIQUE EXISTENCIAS");
                }
            } else {
                JOptionPane.showMessageDialog(null, "PRODUCTO NO EXISTE", "", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_txtCodKeyTyped

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
        new MetodosValidar().soloNumeros(txtCantidad, 3);
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char c = evt.getKeyChar();
        if (c == KeyEvent.VK_ENTER) {
            if (!txtCantidad.getText().trim().equals("") && Integer.parseInt(txtCantidad.getText().trim()) > 0) {
                ProductoDTO prod = productoController.productoById(Integer.parseInt(txtCod.getText()));
                if (prod.getStock() >= Integer.parseInt(txtCantidad.getText())) {
                    insertarDatosTicket();
                    btnVender.setEnabled(true);
                    txtCantidad.setText("");
                } else {
                    new MetodosValidar().advertencia("VERIFIQUE EXISTENCIAS");

                }
            } else {
                JOptionPane.showMessageDialog(null, "INGRESE CANTIDAD CORRECTA", "", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (!txtCantidad.getText().equals("") && Integer.parseInt(txtCantidad.getText().trim()) > 0) {
            ProductoDTO prod = productoController.productoById(Integer.parseInt(txtCod.getText()));
            if (prod.getStock() >= Integer.parseInt(txtCantidad.getText())) {
                insertarDatosTicket();
                btnVender.setEnabled(true);
                txtCantidad.setText("");
            } else {
                new MetodosValidar().advertencia("VERIFIQUE EXISTENCIAS");
            }
        } else {
            JOptionPane.showMessageDialog(null, "INGRESE CANTIDAD CORRECTA", "", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnAddActionPerformed

    private void btnGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarVentaActionPerformed

    }//GEN-LAST:event_btnGenerarVentaActionPerformed

    private void txtRucVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucVentaKeyPressed

    }//GEN-LAST:event_txtRucVentaKeyPressed

    private void txtRucVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucVentaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucVentaKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cargarTBP("");
        try {
            jDialogProducto.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Shopping_cart.png")).getImage());
            jDialogProducto.setModal(true);
            jDialogProducto.setTitle("LISTA PRODUCTOS");
            jDialogProducto.setSize(556, 400);
            jDialogProducto.setLocationRelativeTo(null);
            jDialogProducto.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL CONECTAR A LA BASE DE DATOS", "", JOptionPane.ERROR_MESSAGE);
        }
        txtCantidad.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtclientesbKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtclientesbKeyReleased
        this.txtclientesb.setText(this.txtclientesb.getText().toUpperCase());
        cargarTBC(txtclientesb.getText());
    }//GEN-LAST:event_txtclientesbKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jDialogClientes.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbClientes1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClientes1MouseClicked
        int fs = tbClientes1.getSelectedRow();
        if (fs >= 0) {
            txtCliente.setText(tbClientes1.getValueAt(fs, 1).toString());
            codCliente = tbClientes1.getValueAt(fs, 0).toString();
            txtRucVenta.setText(codCliente);
            cbTipoVenta.setEnabled(false);
            jDialogClientes.setVisible(false);
        }
    }//GEN-LAST:event_tbClientes1MouseClicked

    private void txtProductoBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoBKeyReleased
        txtProductoB.setText(this.txtProductoB.getText().toUpperCase());
        cargarTBP(txtProductoB.getText());
    }//GEN-LAST:event_txtProductoBKeyReleased

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.jDialogProducto.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_btnsalirActionPerformed

    private void tbProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductosMouseClicked
        int fs = tbProductos.getSelectedRow();
        if (fs >= 0) {
            txtCod.setText(tbProductos.getValueAt(fs, 0).toString());
            txtDescripcionVenta.setText(tbProductos.getValueAt(fs, 1).toString());
            txtStockDisponible.setText(tbProductos.getValueAt(fs, 5).toString());
            if (cbTipoVenta.getSelectedItem().toString().toUpperCase().contains("CLIENT")) {
                txtPrecioVenta.setText(tbProductos.getValueAt(fs, 3).toString());
            } else {
                txtPrecioVenta.setText(tbProductos.getValueAt(fs, 2).toString());
            }
            if (Integer.parseInt(tbProductos.getValueAt(fs, 5).toString()) <= 0) {
                JOptionPane.showMessageDialog(null, "¡¡¡VERIFIQUE SU EXISTENCIA!!!", "", JOptionPane.WARNING_MESSAGE);
            } else {
                jDialogProducto.setVisible(false);
                btnAdd.setEnabled(true);
                txtCantidad.setEditable(true);
            }

        }
    }//GEN-LAST:event_tbProductosMouseClicked

    private void btnaddProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddProdActionPerformed
        desabComponentesInit();
        productosView();
    }//GEN-LAST:event_btnaddProdActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        //llenarTbProductos(txtBuscar.getText());
        txtBuscar.setText(this.txtBuscar.getText().toUpperCase());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tbproductosAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbproductosAdminMouseClicked
        EventoTbProductoMouseClicked();
    }//GEN-LAST:event_tbproductosAdminMouseClicked

    private void btnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarActionPerformed
        try {
            int confirmar2 = JOptionPane.showConfirmDialog(null, "¿CONFIRMAR CAMBIO?", "", JOptionPane.YES_NO_OPTION);
            if (confirmar2 == JOptionPane.YES_OPTION) {
                if (Integer.parseInt(spcantidad.getValue().toString()) > 0) {
                    int cantidad = Integer.parseInt(spcantidad.getValue().toString());
                    int updates = productoController.modificarProductoStock(Integer.parseInt(txtcod.getText()), cantidad);
                    if (updates > 0) {
                        JOptionPane.showMessageDialog(null, "Stock modificado a:" + spcantidad.getValue());
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al modificar existencias", "", JOptionPane.ERROR_MESSAGE);
                    }
                }
                llenarTbProductos("");
                cargarTBP("");
            }
        } catch (Exception e) {
            System.out.println("Error al modificar productos:" + e.getMessage());
        }
    }//GEN-LAST:event_btnaceptarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        jDialogProductosAdmin.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void txtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyReleased

        this.txtnombre.setText(this.txtnombre.getText().toUpperCase());
    }//GEN-LAST:event_txtnombreKeyReleased

    private void cbunidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbunidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbunidadActionPerformed

    private void txtcodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodKeyReleased

    }//GEN-LAST:event_txtcodKeyReleased

    private void cbTipoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoVentaActionPerformed
        cargarTBC("");
        if (cbTipoVenta.getSelectedItem().toString().toUpperCase().contains("CLIENTE")) {
            jDialogClientes.setModal(true);
            jDialogClientes.setTitle("LISTA CLIENTES");
            jDialogClientes.setSize(483, 400);
            jDialogClientes.setLocationRelativeTo(null);
            jDialogClientes.setVisible(true);
            jDialogClientes.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Person.png")).getImage());

        } else {
            txtCliente.setEditable(false);
        }
    }//GEN-LAST:event_cbTipoVentaActionPerformed

    private void txtcodigoClienteIndexKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoClienteIndexKeyReleased
        //  MetodosValidar.soloNumeros(txtcodigo,6);
    }//GEN-LAST:event_txtcodigoClienteIndexKeyReleased

    private void txtnombreClienteIndexKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreClienteIndexKeyReleased
        this.txtnombreClienteIndex.setText(txtnombreClienteIndex.getText().toUpperCase());
    }//GEN-LAST:event_txtnombreClienteIndexKeyReleased

    private void txtnombreClienteIndexKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreClienteIndexKeyTyped
        // MetodosValidar.soloLetrasNumeros(txtnombre, 100);
    }//GEN-LAST:event_txtnombreClienteIndexKeyTyped

    private void txttelefonoClienteIndexKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoClienteIndexKeyReleased
        //     MetodosValidar.soloNumeros(txttelefono,13);
    }//GEN-LAST:event_txttelefonoClienteIndexKeyReleased

    private void txttelefonoClienteIndexKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoClienteIndexKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            if (txttelefonoClienteIndex.getText().length() < 10) {
                evt.consume();
            }
        }       // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoClienteIndexKeyTyped

    private void btnaceptarClienteIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarClienteIndexActionPerformed
        if (valEntradasCliente() == true) {
            guardarClientes();
        }

    }//GEN-LAST:event_btnaceptarClienteIndexActionPerformed

    private void btncancelarClienteIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarClienteIndexActionPerformed
        desabilitarControlerCliente();
        limpiarControlesCliente();
        this.btnnuevoClienteIndex.setEnabled(true);
    }//GEN-LAST:event_btncancelarClienteIndexActionPerformed

    private void txtemailClienteIndexKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailClienteIndexKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car < 'A' || car > 'Z') && (car < 'a' || car > 'z') && (car < '@' || car > '@') && (car < '_' || car > '_') && (car < '.' || car > '.')) {
            evt.consume();
        }       // TODO add your handling code here:
    }//GEN-LAST:event_txtemailClienteIndexKeyTyped

    private void cbcolClienteIndexMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbcolClienteIndexMouseClicked

    }//GEN-LAST:event_cbcolClienteIndexMouseClicked

    private void cbcolClienteIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbcolClienteIndexActionPerformed

    }//GEN-LAST:event_cbcolClienteIndexActionPerformed

    private void tbclientesIndexMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbclientesIndexMouseClicked
        EventMouseClick();
        btncancelarClienteIndex.setEnabled(true);
        btnaceptarClienteIndex.setEnabled(false);
    }//GEN-LAST:event_tbclientesIndexMouseClicked

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        txtbuscar.setText(txtbuscar.getText().toUpperCase());
        ListarClientes(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void btnnuevoClienteIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoClienteIndexActionPerformed
        this.btnnuevoClienteIndex.setEnabled(false);
        habilitarControlesCliente();
        generarId(1);
    }//GEN-LAST:event_btnnuevoClienteIndexActionPerformed

    private void btnmodificarClienteIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarClienteIndexActionPerformed
        if (valEntradasCliente()) {
            modificar();
        }
    }//GEN-LAST:event_btnmodificarClienteIndexActionPerformed

    private void btneliminarClienteIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarClienteIndexActionPerformed
        eliminar();
    }//GEN-LAST:event_btneliminarClienteIndexActionPerformed

    private void btnnuevoProveedorIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoProveedorIndexActionPerformed
        limpiarControlesProveedor();
        habFieldComponentesProveedor();
        this.btneliminarProveedorIndex.setEnabled(false);
        this.btnmodificarProveedorIndex.setEnabled(false);
        this.btnnuevoProveedorIndex.setEnabled(false);

        generarId(2);

    }//GEN-LAST:event_btnnuevoProveedorIndexActionPerformed

    private void btneliminarProveedorIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarProveedorIndexActionPerformed
       
        try {
            int confirmar = JOptionPane.showConfirmDialog(null, "¿ELIMINAR DATOS?", "", JOptionPane.YES_NO_OPTION);
            if (confirmar == JOptionPane.YES_NO_OPTION) {
                boolean b = proveedoresController.delete(Integer.parseInt(txtCodigoProveedorIndex.getText()));
                if (b) {
                    DesabilitarControlesProveedor();
                    limpiarControlesProveedor();
                    btnmodificarProveedorIndex.setEnabled(false);
                    btneliminarProveedorIndex.setEnabled(false);
                    carga_informacion_Prov("");
                    new MetodosValidar().ok_eliminar();
                } else {
                    new MetodosValidar().error_eliminar();
                }
            }
        } catch (Exception ex) {
            System.out.println("Error al eliminar:" + ex.getMessage());
        }
    }//GEN-LAST:event_btneliminarProveedorIndexActionPerformed

    private void btnmodificarProveedorIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarProveedorIndexActionPerformed
        ProveedorDTO prov = new ProveedorDTO();
        if (valEntradasProveedor() == true) {
            try {
                prov.setIdproveedor(Integer.parseInt(txtCodigoProveedorIndex.getText()));
                prov.setNombre(txtEmpresaProveedorIndex.getText());
                prov.setTelefono(txttelefonoProveedorIndex.getText());
                prov.setMail(txtemailProveedorIndex.getText());
                int confirmar = JOptionPane.showConfirmDialog(null, "¿DATOS CORRECTOS?", "", JOptionPane.YES_NO_OPTION);
                if (confirmar == JOptionPane.YES_NO_OPTION) {
                    boolean bandera = proveedoresController.update(prov);
                    if (bandera) {
                        new MetodosValidar().ok_modificar();
                        carga_informacion_Prov("");
                        limpiarControlesProveedor();
                        DesabilitarControlesProveedor();
                    } else {
                        new MetodosValidar().error_modificar();
                    }

                }
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_btnmodificarProveedorIndexActionPerformed

    private void btnsalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalir2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnsalir2ActionPerformed

    private void txtbuscarProveedorIndexKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarProveedorIndexKeyReleased
        carga_informacion_Prov(txtbuscar.getText());
        txtbuscar.setText(txtbuscar.getText().toUpperCase());
    }//GEN-LAST:event_txtbuscarProveedorIndexKeyReleased

    private void tbProveedorIndexMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProveedorIndexMouseClicked
        int filaS = tbProveedorIndex.getSelectedRow();
        if (filaS >= 0) {
            habFieldComponentesProveedor();
            btneliminarProveedorIndex.setEnabled(true);
            btnmodificarProveedorIndex.setEnabled(true);
            btnnuevoProveedorIndex.setEnabled(false);
            btnaceptarProveedorIndex.setEnabled(false);
            txtCodigoProveedorIndex.setText(tbProveedorIndex.getValueAt(filaS, 0).toString());
            txtEmpresaProveedorIndex.setText(tbProveedorIndex.getValueAt(filaS, 1).toString());
            txttelefonoProveedorIndex.setText(tbProveedorIndex.getValueAt(filaS, 3).toString());
            txtemailProveedorIndex.setText(tbProveedorIndex.getValueAt(filaS, 2).toString());

        }
    }//GEN-LAST:event_tbProveedorIndexMouseClicked

    private void btnnuevoProductosIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoProductosIndexActionPerformed
        habPanContenidoProductos();
        generarId(3);
    }//GEN-LAST:event_btnnuevoProductosIndexActionPerformed

    private void txtBuscarProductosIndexKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductosIndexKeyReleased
        llenarTbProductos(txtBuscar.getText());
        txtBuscar.setText(this.txtBuscar.getText().toUpperCase());
    }//GEN-LAST:event_txtBuscarProductosIndexKeyReleased

    private void btnmodificarProductosIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarProductosIndexActionPerformed
        try {
            ProductoDTO pr = new ProductoDTO();
            double pad = 0;
            if (valEntradasProductos() == true) {
                int confirmar2 = JOptionPane.showConfirmDialog(null, "¿INGRESAR PRECIO DE AQUISICION?", "", JOptionPane.YES_NO_OPTION);
                if (confirmar2 == JOptionPane.YES_OPTION) {
                    pad = Double.parseDouble(JOptionPane.showInputDialog("PRECIO AQUIRIDO"));
                }
                int confirmar = JOptionPane.showConfirmDialog(null, "¿MDIFICAR?", "", JOptionPane.YES_NO_OPTION);
                if (confirmar == JOptionPane.YES_OPTION) {
                    pr.setIdproducto(Integer.parseInt(txtcodigoProductoIndex.getText()));
                    pr.setNombre(txtnombreProductoIndex.getText());
                    pr.setPrecio(Double.parseDouble(spppublicoProductoIndex.getValue().toString()));
                    if (Double.parseDouble(sppclienteProductoIndex.getValue().toString()) == 0.0) {
                        pr.setPreciocliente(0.0);
                        pr.setActivarpreciocliente(false);
                    } else {
                        pr.setPreciocliente(Double.parseDouble(sppclienteProductoIndex.getValue().toString()));
                        pr.setActivarpreciocliente(true);
                    }
                    pr.setStock(Integer.parseInt(spcantidadProductosIndex.getValue().toString()));
                    pr.setPreciodeproveedor(pad);

                    CategoriaDTO cat = categoriaController.categoriaByNombre(cbcategoriaProductosIndex.getSelectedItem().toString());
                    pr.setIdcategoria(cat.getIdcategoria());
                    ProveedorDTO prove = proveedoresController.proveedorByNombre(cbproveedorProductosIndex.getSelectedItem().toString());
                    pr.setIdproveedor(prove.getIdproveedor());
                    UnidadesMedidaDTO uni = unidadesController.unidadByNombre(cbunidadProductoIndex.getSelectedItem().toString());
                    pr.setIdunidadm(uni.getIdunidadm());
                    boolean bandera = productoController.update(pr);
                    if (bandera) {
                        new MetodosValidar().ok_modificar();
                        limpiarControlesProducto();
                        llenarTbProductos("");
                        desabPanContenidoProductos();
                    } else {
                        new MetodosValidar().error_modificar();
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AL GUARDAR PRODUCTO:" + e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnmodificarProductosIndexActionPerformed

    private void btneliminarProductosIndexMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneliminarProductosIndexMouseClicked

    }//GEN-LAST:event_btneliminarProductosIndexMouseClicked

    private void btneliminarProductosIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarProductosIndexActionPerformed
        try {
            boolean ba = productoController.detelete(Integer.parseInt(txtcodigoProductoIndex.getText()));
            int conf = JOptionPane.showConfirmDialog(null, "¿ELIMINAR REGISTROS?", "", JOptionPane.YES_NO_OPTION);
            if (conf == JOptionPane.YES_OPTION) {
                if (ba) {
                    new MetodosValidar().ok_eliminar();
                    desabPanContenidoProductos();
                    limpiarControlesProducto();
                    llenarTbProductos("");
                } else {
                    new MetodosValidar().error_eliminar();
                }
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar productos:" + e.getMessage());
        }
    }//GEN-LAST:event_btneliminarProductosIndexActionPerformed

    private void btnsalir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalir3ActionPerformed
        dispose();
    }//GEN-LAST:event_btnsalir3ActionPerformed

    private void btnaceptarProductosIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarProductosIndexActionPerformed
        try {
            ProductoDTO pr = new ProductoDTO();
            double pad = 0;
            if (valEntradasProductos() == true) {
                int confirmar2 = JOptionPane.showConfirmDialog(null, "¿INGRESAR PRECIO DE AQUISICION?", "", JOptionPane.YES_NO_OPTION);
                if (confirmar2 == JOptionPane.YES_OPTION) {
                    pad = Double.parseDouble(JOptionPane.showInputDialog("PRECIO AQUIRIDO"));
                }
                int confirmar = JOptionPane.showConfirmDialog(null, "¿SUS DATOS SON CORRECTOS?", "", JOptionPane.YES_NO_OPTION);
                if (confirmar == JOptionPane.YES_OPTION) {
                    pr.setIdproducto(Integer.parseInt(txtcodigoProductoIndex.getText()));
                    pr.setNombre(txtnombreProductoIndex.getText());
                    pr.setPrecio(Double.parseDouble(spppublicoProductoIndex.getValue().toString()));
                    if (Double.parseDouble(sppclienteProductoIndex.getValue().toString()) == 0.0) {
                        pr.setPreciocliente(0.0);
                        pr.setActivarpreciocliente(false);
                    } else {
                        pr.setPreciocliente(Double.parseDouble(sppclienteProductoIndex.getValue().toString()));
                        pr.setActivarpreciocliente(true);
                    }
                    pr.setStock(Integer.parseInt(spcantidadProductosIndex.getValue().toString()));
                    pr.setPreciodeproveedor(pad);

                    CategoriaDTO cat = categoriaController.categoriaByNombre(cbcategoriaProductosIndex.getSelectedItem().toString());
                    pr.setIdcategoria(cat.getIdcategoria());
                    ProveedorDTO prove = proveedoresController.proveedorByNombre(cbproveedorProductosIndex.getSelectedItem().toString());
                    pr.setIdproveedor(prove.getIdproveedor());
                    UnidadesMedidaDTO uni = unidadesController.unidadByNombre(cbunidadProductoIndex.getSelectedItem().toString());
                    pr.setIdunidadm(uni.getIdunidadm());
                    boolean bandera = productoController.save(pr);
                    if (bandera) {
                        new MetodosValidar().ok();
                        limpiarControlesProducto();
                        llenarTbProductos("");
                        desabPanContenidoProductos();
                        
                    } else {
                        new MetodosValidar().error();
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AL GUARDAR PRODUCTO:" + e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnaceptarProductosIndexActionPerformed

    private void btncancelarProductosIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarProductosIndexActionPerformed
        desabPanContenidoProductos();
        limpiarControlesProducto();
        this.btnnuevoClienteIndex.setEnabled(true);
        this.btnmodificarClienteIndex.setEnabled(false);
        this.btneliminarClienteIndex.setEnabled(false);
    }//GEN-LAST:event_btncancelarProductosIndexActionPerformed

    private void txtnombreProductoIndexKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreProductoIndexKeyReleased
        this.txtnombreProductoIndex.setText(this.txtnombreProductoIndex.getText().toUpperCase());
    }//GEN-LAST:event_txtnombreProductoIndexKeyReleased

    private void cbunidadProductoIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbunidadProductoIndexActionPerformed

    }//GEN-LAST:event_cbunidadProductoIndexActionPerformed

    private void txtcodigoProductoIndexKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoProductoIndexKeyReleased

    }//GEN-LAST:event_txtcodigoProductoIndexKeyReleased

    private void txttelefonoClienteIndexKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoClienteIndexKeyPressed
        new MetodosValidar().soloNumeros(txttelefonoClienteIndex, 10);
    }//GEN-LAST:event_txttelefonoClienteIndexKeyPressed

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
        System.out.println("se minimizo");
    }//GEN-LAST:event_formWindowIconified

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        setMenuBar();
    }//GEN-LAST:event_formComponentResized

    private void txtEmpresaProveedorIndexKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmpresaProveedorIndexKeyReleased
        txtEmpresaProveedorIndex.setText(this.txtEmpresaProveedorIndex.getText().toUpperCase());
    }//GEN-LAST:event_txtEmpresaProveedorIndexKeyReleased

    private void txttelefonoProveedorIndexKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoProveedorIndexKeyTyped

    }//GEN-LAST:event_txttelefonoProveedorIndexKeyTyped

    private void txttelefonoProveedorIndexKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoProveedorIndexKeyReleased
        new MetodosValidar().soloNumeros(txttelefonoClienteIndex, 13);
    }//GEN-LAST:event_txttelefonoProveedorIndexKeyReleased

    private void txtemailProveedorIndexKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailProveedorIndexKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car < 'A' || car > 'Z') && (car < 'a' || car > 'z') && (car < '@' || car > '@') && (car < '_' || car > '_') && (car < '.' || car > '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtemailProveedorIndexKeyTyped

    private void txtemailProveedorIndexKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailProveedorIndexKeyReleased
        this.txtemailClienteIndex.setText(txtemailClienteIndex.getText().toLowerCase());       // TODO add your handling code here:
    }//GEN-LAST:event_txtemailProveedorIndexKeyReleased

    private void txtemailProveedorIndexKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailProveedorIndexKeyPressed
        //        MetodosValidar.soloNumeros(txttelefono, 14);
    }//GEN-LAST:event_txtemailProveedorIndexKeyPressed

    private void btncancelarProveedorIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarProveedorIndexActionPerformed
        DesabilitarControlesProveedor();
        limpiarControlesProveedor();
    }//GEN-LAST:event_btncancelarProveedorIndexActionPerformed

    private void txtCodigoProveedorIndexKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProveedorIndexKeyReleased
        //MetodosValidar.soloNumeros(txtcodigo, 6);
    }//GEN-LAST:event_txtCodigoProveedorIndexKeyReleased

    private void btnaceptarProveedorIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarProveedorIndexActionPerformed
        ProveedorDTO prov = new ProveedorDTO();
        if (valEntradasProveedor() == true) {
            try {
                prov.setIdproveedor(Integer.parseInt(txtCodigoProveedorIndex.getText()));
                prov.setNombre(txtEmpresaProveedorIndex.getText());
                prov.setMail(txtemailProveedorIndex.getText());
                prov.setTelefono(txttelefonoProveedorIndex.getText());

                int confirmar = JOptionPane.showConfirmDialog(null, "¿DATOS CORRECTOS?", "", JOptionPane.YES_NO_OPTION);
                if (confirmar == JOptionPane.YES_NO_OPTION) {
                    boolean guardar = proveedoresController.save(prov);
                    if (guardar) {
                        new MetodosValidar().ok();
                        carga_informacion_Prov("");
                        limpiarControlesProveedor();
                        DesabilitarControlesProveedor();
                    } else {
                        new MetodosValidar().error();
                    }

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al registrar proveedor:" + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnaceptarProveedorIndexActionPerformed

    private void txttelefonoProveedorIndexKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoProveedorIndexKeyPressed
        new MetodosValidar().soloNumeros(txttelefonoProveedorIndex, 10);
    }//GEN-LAST:event_txttelefonoProveedorIndexKeyPressed

    private void tbProductosIndexMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductosIndexMouseClicked
       EventoTbProductMC();
    }//GEN-LAST:event_tbProductosIndexMouseClicked

    public void inicioFrame() {
        //txtSubTotal.setEditable(false);
        //txtTotalIva.setEditable(false);
        txtCantidad.setEditable(false);
        btnVender.setEnabled(false);

    }

    public void calcTot() {
        double total = 0;
        double IVA = 0;

        double a;
        double b = 0;
        for (int i = 0; i < dtmTicket.getRowCount(); i++) {
            String Calculo = String.valueOf(dtmTicket.getValueAt(i, 4));
            a = Double.parseDouble(Calculo);
            b = b + a;
            if (i == dtmTicket.getRowCount() - 1) {
                IVA = b * 0.16;
                total = b;
            }
        }
        //txtTotalIva.setText("0.0");//String.valueOf(IVA));
        //txtSubTotal.setText(String.valueOf(b));
        //double total_venta = Double.parseDouble(txtSubTotal.getText()) + Double.parseDouble(txtTotalIva.getText());
        //txtTotalVenta.setText(String.valueOf(total_venta));
        txtTotal.setText(String.valueOf(b));
    }

    public void productosView() {

        try {
            llenarTbProductos("");
            jDialogProductosAdmin.setTitle("ADMINISTRACION DE PRODUCTOS");
            jDialogProductosAdmin.setModal(true);
            jDialogProductosAdmin.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Shopping_cart.png")).getImage());
            jDialogProductosAdmin.setSize(850, 525);
            jDialogProductosAdmin.setLocationRelativeTo(null);
            jDialogProductosAdmin.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL CONECTAR A LA BASE DE DATOS", "", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void EventoTbProductoMouseClicked() {
        desabComponentesProductos();
        llenarProveedores(cbproveedorProductosIndex);
        int fseleccionada = tbproductosAdmin.getSelectedRow();
        if (fseleccionada >= 0) {
            txtcod.setText(tbproductosAdmin.getValueAt(fseleccionada, 0).toString());
            txtnombre.setText(tbproductosAdmin.getValueAt(fseleccionada, 1).toString());
            cbunidad.setSelectedItem(tbproductosAdmin.getValueAt(fseleccionada, 9));
            if (!tbproductosAdmin.getValueAt(fseleccionada, 5).toString().toUpperCase().contains("FALSE")) {
                sppcliente.setValue(Double.parseDouble(tbproductosAdmin.getValueAt(fseleccionada, 3).toString()));
            }
            spppublico.setValue(Double.parseDouble(tbproductosAdmin.getValueAt(fseleccionada, 2).toString()));
            spcantidad.setValue(Integer.parseInt(tbproductosAdmin.getValueAt(fseleccionada, 4).toString()));
            cbproveedor.setSelectedItem(tbproductosAdmin.getValueAt(fseleccionada, 8));
            btnaceptar.setEnabled(true);
        }

    }

    public void llenarUnidades(JComboBox combo) {
        List<UnidadesMedidaDTO> lista = unidadesController.unidadesAll("");

        for (int x = 0; x < lista.size(); x++) {
            UnidadesMedidaDTO unidad = lista.get(x);
            combo.addItem(unidad.getDescripcion());
        }
    }

    public void llenarProveedores(JComboBox combo) {
        List<ProveedorDTO> lista = proveedoresController.proveedoresAll("");
        for (int x = 0; x < lista.size(); x++) {
            ProveedorDTO provedor = lista.get(x);
            combo.addItem(provedor.getNombre());
        }
    }

    public void llenarTbProductos(String nombre) {
        try {
            DefaultTableModel dtmProductos = new DefaultTableModel();
            dtmProductos.addColumn("CODIGO");
            dtmProductos.addColumn("NOMBRE");
            dtmProductos.addColumn("P.PUBLICO");
            dtmProductos.addColumn("P.CLIENTE");
            dtmProductos.addColumn("STOCK");
            dtmProductos.addColumn("ACTIVA P.CLIENTE");
            dtmProductos.addColumn("PRECIO DE COMPRA");
            dtmProductos.addColumn("CATEGORIA");
            dtmProductos.addColumn("PROVEEDOR");
            dtmProductos.addColumn("U.MEDIDA");
            tbProductosIndex.setModel(dtmProductos);
            List<ProductoDTO> listaProductos = null;
            if (nombre.trim().equals("")) {
                listaProductos = productoController.productosAll("");
            } else {
                listaProductos = productoController.productosAll(nombre);
            }
            System.out.println("Tamaño de la lista:"+listaProductos.size());
            for (int i = 0; i < listaProductos.size(); i++) {
                ProductoDTO producto = listaProductos.get(i);
                Object[] fila = new Object[11];
                fila[0] = producto.getIdproducto();
                fila[1] = producto.getNombre();
                fila[2] = producto.getPrecio();
                if (producto.isActivarpreciocliente()) {
                    fila[3] = producto.getPreciocliente();
                } else {
                    fila[3] = "SIN PRECIO CLIENTE";
                }
                fila[4] = producto.getStock();
                fila[5] = producto.isActivarpreciocliente();
                fila[6] = producto.getPreciodeproveedor();

                CategoriaDTO cat = categoriaController.categoriaById(producto.getIdcategoria());
                fila[7] = cat.getDescripcion();
                ProveedorDTO prov = proveedoresController.proveedorById(producto.getIdproveedor());
                fila[8] = prov.getNombre();
                UnidadesMedidaDTO unidad = unidadesController.unidadById(producto.getIdunidadm());
                fila[9] = unidad.getDescripcion();
                dtmProductos.addRow(fila);

            }
            tbProductosIndex.setModel(dtmProductos);
        } catch (Exception ex) {
            System.out.println("Error al llenar tabla de productos:"+ex.getMessage());
        }

    }

    public void desabComponentesProductos() {
        txtcod.setEnabled(false);
        txtnombre.setEnabled(false);
        cbunidad.setEnabled(false);
        spppublico.setEnabled(false);
        sppcliente.setEnabled(false);
        cbproveedor.setEnabled(false);
        spcantidad.setEnabled(true);

    }

    public void desabComponentesInit() {
        txtcod.setEnabled(false);
        txtnombre.setEnabled(false);
        cbunidad.setEnabled(false);
        spppublico.setEnabled(false);
        sppcliente.setEnabled(false);
        cbproveedor.setEnabled(false);
        spcantidad.setEnabled(false);

    }

    /*-----------------------------Metodo para preparar tabla para ticket----------------------------*/
    public void insertarDatosTicket() {
        btnVaciarTicket.setEnabled(true);
        try {
            //Obtenemos la descripcion completa del producto por nombre
            List<String> lista_id = new ArrayList<>();
            int cantidad = 0;// Integer.parseInt(txtCantidad.getText());
            boolean bandera = false;
            ProductoDTO producto = productoController.productoById(Integer.parseInt(txtCod.getText()));
            double precio = producto.getPrecio();
            for (int i = 0; i < tbTicket.getRowCount(); i++) {
                lista_id.add(tbTicket.getValueAt(i, 0).toString());
            }

            String id = txtCod.getText();
            Object[] fila = new Object[5];

            if (lista_id.size() > 0) {
                for (int i = 0; i < lista_id.size(); i++) {
                    int idd = Integer.parseInt(lista_id.get(i));
                    if (idd == Integer.parseInt(txtCod.getText())) {
                        tbTicket.setValueAt(Integer.parseInt(tbTicket.getValueAt(i, 3).toString()) + Integer.parseInt(txtCantidad.getText()), i, 3);
                        tbTicket.setValueAt(Double.parseDouble(tbTicket.getValueAt(i, 2).toString()) * Integer.parseInt(tbTicket.getValueAt(i, 3).toString()), i, 4);
                        bandera = true;
                    }
                }
            }
            if (!bandera) {
                fila[0] = id;
                fila[1] = producto.getNombre();
                if (cbTipoVenta.getSelectedItem().toString().toLowerCase().contains("cliente")) {
                    fila[2] = producto.getPreciocliente();
                } else {
                    fila[2] = producto.getPrecio();
                }
                fila[3] = Integer.parseInt(txtCantidad.getText());
                if (cbTipoVenta.getSelectedItem().toString().toUpperCase().contains("CLIENTE")) {
                    fila[4] = producto.getPreciocliente() * Integer.parseInt(txtCantidad.getText());
                } else {
                    fila[4] = producto.getPrecio() * Integer.parseInt(txtCantidad.getText());
                }
                dtmTicket.addRow(fila);

            }
            tbTicket.setModel(dtmTicket);
            calcTot();

        } catch (Exception e) {
            System.out.println("Error al obtener descripcion del producto:" + e.getMessage());
        }
    }

    public void calculoTotal() {
        for (int x = 0; x < tbTicket.getRowCount(); x++) {
            //txtSubTotal.setText(tbproductosAdmin.getValueAt(x, 4).toString());
        }
    }

    /*-----------------------------Metodo para obtener la fecha actual del sistema-------------------*/
    public void setFechaTiempoReal() {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = new GregorianCalendar();
        String dia = Integer.toString(c2.get(Calendar.DATE));
        int mes = Integer.parseInt(Integer.toString(c2.get(Calendar.MONTH))) + 1;
        String annio = Integer.toString(c2.get(Calendar.YEAR));
        String mesr = String.valueOf(mes);
        if ((Integer.parseInt(dia) < 10)) {
            dia = "0" + Integer.toString(c2.get(Calendar.DATE));
        }
        if (mes < 10) {
            mesr = "0" + String.valueOf(mes);
        }

    }

    /*-----------------------------Metodo para llenar combo de tipos de ventas-------------------*/
    public void llenarCBM() {
        List<TiposVentaDTO> lista = venController.tiposVenta();
        for (int i = 0; i < lista.size(); i++) {
            cbTipoVenta.addItem(lista.get(i).getIdtipoventa() + ".- " + lista.get(i).getDescripcion());
        }
    }

    /*-----------------------------Metodo para llenar el catalogo de clientes-------------------*/
    public void cargarTBC(String valorB) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("CODIGO");
        modelo.addColumn("NOMBRES");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("TELEFONO");
        this.tbClientes1.setModel(modelo);
        try {
            List<ClienteDTO> clientes = clientesController.findAll(valorB);
            for (int i = 0; i < clientes.size(); i++) {
                Object[] obj = new Object[4];
                obj[0] = clientes.get(i).getIdcliente();
                obj[1] = clientes.get(i).getNombre();
                obj[2] = clientes.get(i).getDomicilio();
                obj[3] = clientes.get(i).getTelefono();
                modelo.addRow(obj);
            }
            tbClientes1.setModel(modelo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL CARGAR DATOS CLIENTES", "", JOptionPane.ERROR_MESSAGE);

        }
    }

    /*-----------------------------Metodo para cargar el catalogo de productos-------------------*/
    public void cargarTBP(String valorB) {
        try {
            dtm = new DefaultTableModel();
            dtm.addColumn("CODIGO");
            dtm.addColumn("NOMBRE");
            dtm.addColumn("P.PUBLICO");
            dtm.addColumn("P.CLIENTE");
            dtm.addColumn("U.MEDIDA");
            dtm.addColumn("STOCK");
            tbProductos.setModel(dtm);
            List<ProductoDTO> listaProductos = null;
            if (valorB.trim().equals("")) {
                listaProductos = productoController.productosAll("");
            } else {
                listaProductos = productoController.productosAll(valorB);
            }
            for (int i = 0; i < listaProductos.size(); i++) {
                ProductoDTO producto = listaProductos.get(i);
                Object[] fila = new Object[6];
                fila[0] = producto.getIdproducto();
                fila[1] = producto.getNombre();
                fila[2] = producto.getPrecio();
                if (producto.isActivarpreciocliente()) {
                    fila[3] = producto.getPreciocliente();
                } else {
                    fila[3] = "SIN PRECIO CLIENTE";
                }
                UnidadesMedidaDTO unidad = unidadesController.unidadById(producto.getIdunidadm());

                fila[4] = unidad.getDescripcion();
                fila[5] = producto.getStock();
                dtm.addRow(fila);

            }
            tbProductos.setModel(dtm);

        } catch (Exception e) {
            System.out.println("Error al llenar catalogo de productos:" + e.getMessage());
        }

    }

    public void generarVenta() {
        Random r = new Random();
        int random = r.nextInt(90000) + 10000;
        int opcion = JOptionPane.showConfirmDialog(null, "¿CONFIRMAR VENTA?", "", JOptionPane.YES_NO_OPTION);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String jd = sdf.format(Midate.getDate());
        String hoy = sdf.format(new Date());
        int insertaDetalles = 0;
        ReporteNotaVentaModelo rpNota = new ReporteNotaVentaModelo();
        rpNota.setFecha(fecha());
        rpNota.setNombreNegocio(lblTitulo.getText());
        rpNota.setTotalVenta(Double.parseDouble(txtTotal.getText()));

        List<DetalleVentaDTO> listaReporte = new ArrayList<>();
        if (opcion == JOptionPane.YES_OPTION) {
            //primero descontamos de la base de datos el total de productos
            //Insertamos la venta
            VentaRealizadaDTO venta = new VentaRealizadaDTO();
            venta.setIdticket(random);
            Timestamp timestamp = null;
            if (!jd.equals(hoy)) {
                timestamp = new java.sql.Timestamp(Midate.getDate().getTime());
            } else {
                timestamp = new java.sql.Timestamp(new Date().getTime());

            }
            venta.setFecha(timestamp);
            venta.setTipoventa(cbTipoVenta.getSelectedItem().toString());
            venta.setTotalventa(Double.parseDouble(txtTotal.getText()));
            venta.setUsuario(1);

            int insertaRegistro = venController.insertarVentaRealizada(venta);
            for (int y = 0; y < tbTicket.getRowCount(); y++) {
                ProductoDTO producto = productoController.productoById(Integer.parseInt(tbTicket.getValueAt(y, 0).toString()));
                int eliminarProductos = productoController.modificarProductoStock(Integer.parseInt(tbTicket.getValueAt(y, 0).toString()), producto.getStock() - Integer.parseInt(tbTicket.getValueAt(y, 3).toString()));

                DetalleVentaDTO detalle_venta = new DetalleVentaDTO();
                detalle_venta.setTicket(venta.getIdticket());
                detalle_venta.setProducto(producto.getNombre());
                detalle_venta.setTotalProducto(Integer.parseInt(tbTicket.getValueAt(y, 3).toString()));
                detalle_venta.setTotal(Double.parseDouble(tbTicket.getValueAt(y, 4).toString()));
                detalle_venta.setCliente(txtCliente.getText());
                listaReporte.add(detalle_venta);
                insertaDetalles = venController.insertarDetalleVenta(detalle_venta);

            }
            rpNota.setDetallesVenta(listaReporte);

            if (insertaRegistro > 0 && insertaDetalles > 0) {
                Icon icono = new ImageIcon(getClass().getResource("/Imagenes/applicated.gif"));
                JOptionPane.showMessageDialog(null, "VENTA EXITOSA" + "\n"
                        + "TIKCET:" + venta.getIdticket() + "\n"
                        + "TOTAL:" + txtTotal.getText() + "\n"
                        + "FECHA:" + fecha(), "", JOptionPane.PLAIN_MESSAGE, icono);
                int opcionr = JOptionPane.showConfirmDialog(null, "¿IMPRIMIR NOTA?", "", JOptionPane.YES_NO_OPTION);
                if (opcionr == JOptionPane.YES_OPTION) {
                    if (cbTipoVenta.getSelectedItem().toString().contains("CLIE")) {
                        new PlantillaReporteNota(rpNota).generar_y_guardar(2);
                    } else {
                        new PlantillaReporteNota(rpNota).generar_y_guardar(1);
                    }

                }
            }
            vaciarTicketMethod();
        }
    }

    public String fecha() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
        String fecha = "";
        try {
            fecha = sdf.format(Midate.getDate());
        } catch (Exception e) {
            System.out.println("Error al parsear fecha:" + e.getMessage());
        }
        return fecha;
    }

    public void diseñarJDateChooser() {
        ((JTextField) this.Midate.getDateEditor()).setEditable(false);
        Midate.setDate(new Date());

    }

    public void vaciarTicketMethod() {
        for (int i = 0; i < tbTicket.getRowCount(); i++) {
            dtmTicket.removeRow(i);
        }
    }

    public void llenarNombreNegocio() {
        NegocioController negocio = new NegocioController();
        try {
            lblTitulo.setText(negocio.nombre());
        } catch (Exception e) {
            System.out.println("Error al obtener nombre neogcio:" + e.getMessage());
        }

    }

    public void btnCancelar() {
        cbTipoVenta.setSelectedIndex(0);
        cbTipoVenta.setEnabled(true);
        txtCantidad.setText("");
        txtCod.setText("");
        txtCliente.setText("XXXXXXXXXXXXXXXXXXXX");
        btnVender.setEnabled(false);
        btnAdd.setEnabled(false);
        btnVaciarTicket.setEnabled(false);
        for (int i = 0; i < dtmTicket.getRowCount(); i++) {
            dtmTicket.removeRow(i);
        }
        // txtSubTotal.setText("0.0");
        // txtTotalIva.setText("0.0");
        txtTotal.setText("0.0");
    }

    /*================================================================================*/
    private void ListarClientes(String nombre) {
        String[] titulos = {"CODIGO", "NOMBRE COMPLETO", "DIRECCION", "CORREO", "TELEFONO", "GENERO"};
        DefaultTableModel dtmClienteIndex = new DefaultTableModel(null, titulos);
        try {
            Object o[] = null;
            List<ClienteDTO> listC = clientesController.findAll(nombre);
            for (int i = 0; i < listC.size(); i++) {
                dtmClienteIndex.addRow(o);
                dtmClienteIndex.setValueAt(listC.get(i).getIdcliente(), i, 0);
                dtmClienteIndex.setValueAt(listC.get(i).getNombre(), i, 1);
                dtmClienteIndex.setValueAt(listC.get(i).getDomicilio(), i, 2);
                dtmClienteIndex.setValueAt(listC.get(i).getMail(), i, 3);
                dtmClienteIndex.setValueAt(listC.get(i).getTelefono(), i, 4);
                dtmClienteIndex.setValueAt(listC.get(i).getGenero(), i, 5);

            }
            tbclientesIndex.setModel(dtmClienteIndex);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void guardarClientes() {
        ClienteDTO cliente = new ClienteDTO();
        try {
            cliente.setIdcliente(Integer.parseInt(txtcodigoClienteIndex.getText()));
            cliente.setNombre(txtnombreClienteIndex.getText());
            cliente.setDomicilio(cbcolClienteIndex.getSelectedItem().toString() + "," + cbmuniClienteIndex.getSelectedItem().toString() + "," + cbestadoClienteIndex.getSelectedItem().toString());
            cliente.setMail(txtemailClienteIndex.getText());
            if (!txttelefonoClienteIndex.getText().equals("")) {
                cliente.setTelefono(txttelefonoClienteIndex.getText());
            } else {
                cliente.setTelefono("0");
            }
            cliente.setGenero(cbgeneroClienteIndex.getSelectedItem().toString());
            ColoniaDTO colonia = new LocalidadesController().coloniaByNombre(cbcolClienteIndex.getSelectedItem().toString());
            cliente.setIdcolonia(colonia.getIdcolonia());
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Guardar registros?", "", JOptionPane.YES_NO_OPTION);
            if (confirmar == JOptionPane.YES_OPTION) {
                boolean registro = clientesController.save(cliente);
                if (registro) {
                    new MetodosValidar().ok();
                    limpiarControlesCliente();
                    desabilitarControlerCliente();
                    ListarClientes("");
                } else {
                    new MetodosValidar().error();
                }
            }
        } catch (Exception e) {
            System.out.println("Error al guardar estado:" + e.getMessage());
        }

    }

    public void modificar() {
        ClienteDTO cliente = new ClienteDTO();
        try {
            cliente.setIdcliente(Integer.parseInt(txtcodigoClienteIndex.getText()));
            cliente.setNombre(txtnombreClienteIndex.getText());
            cliente.setDomicilio(cbcolClienteIndex.getSelectedItem().toString() + "," + cbmuniClienteIndex.getSelectedItem().toString() + "," + cbestadoClienteIndex.getSelectedItem().toString());
            cliente.setMail(txtemailClienteIndex.getText());
            if (!txttelefonoClienteIndex.getText().equals("")) {
                cliente.setTelefono(txttelefonoClienteIndex.getText());
            } else {
                cliente.setTelefono("0");
            }
            cliente.setGenero(cbgeneroClienteIndex.getSelectedItem().toString());
            ColoniaDTO colonia = new LocalidadesController().coloniaByNombre(cbcolClienteIndex.getSelectedItem().toString());
            cliente.setIdcolonia(colonia.getIdcolonia());
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Modificar registros?", "", JOptionPane.YES_NO_OPTION);
            if (confirmar == JOptionPane.YES_OPTION) {
                boolean registro = clientesController.update(cliente);
                if (registro) {
                    new MetodosValidar().ok_modificar();
                    limpiarControlesCliente();
                    desabilitarControlerCliente();
                    ListarClientes("");
                } else {
                    new MetodosValidar().error_modificar();
                }
            }
        } catch (Exception e) {
            System.out.println("Error al moficar registros:" + e.getMessage());
        }
    }

    public void eliminar() {
        try {
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Eliminar registros?", "", JOptionPane.YES_NO_OPTION);
            if (confirmar == JOptionPane.YES_OPTION) {
                boolean registro = clientesController.delete(Integer.parseInt(txtcodigoClienteIndex.getText()));
                if (registro) {
                    new MetodosValidar().ok_eliminar();
                    limpiarControlesCliente();
                    desabilitarControlerCliente();
                    ListarClientes("");
                } else {
                    new MetodosValidar().error_eliminar();
                }
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar registros");
        }
    }

    public void llenarCombosClientes() {

        for (int i = 0; i < new LocalidadesController().coloniasAll("").size(); i++) {
            cbcolClienteIndex.addItem(new LocalidadesController().coloniasAll("").get(i).getNombre());
        }

        for (int i = 0; i < new MunicipiosController().municipiosAll("").size(); i++) {
            cbmuniClienteIndex.addItem(new MunicipiosController().municipiosAll("").get(i).getNombre());
        }

        for (int i = 0; i < new EstadosController().estadosAll("").size(); i++) {
            cbestadoClienteIndex.addItem(new EstadosController().estadosAll("").get(i).getNombre());
        }

    }

    public void particionarDom(String cadena) {
        String c, m, e;
        String[] Part = cadena.split(",");
        for (int i = 0; i < Part.length; i++) {
            c = Part[0];
            m = Part[1];
            e = Part[2];
            cbcolClienteIndex.setSelectedItem(c);
            cbmuniClienteIndex.setSelectedItem(m);
            cbestadoClienteIndex.setSelectedItem(e);
        }
    }

    public void EventMouseClick() {
        int filas = tbclientesIndex.getSelectedRow();
        if (filas >= 0) {
            this.habilitarControlesCliente();
            this.btnaceptar.setEnabled(false);
            this.btnmodificarClienteIndex.setEnabled(true);
            this.btneliminarClienteIndex.setEnabled(true);
            this.btnnuevoClienteIndex.setEnabled(false);
            txtcodigoClienteIndex.setText(tbclientesIndex.getValueAt(filas, 0).toString());
            txtnombreClienteIndex.setText(tbclientesIndex.getValueAt(filas, 1).toString());
            particionarDom(tbclientesIndex.getValueAt(filas, 2).toString());
            txttelefonoClienteIndex.setText(tbclientesIndex.getValueAt(filas, 4).toString());
            if (tbclientesIndex.getValueAt(filas, 5) != null) {
                cbgeneroClienteIndex.setSelectedItem(tbclientesIndex.getValueAt(filas, 5).toString());
            } else {
                cbgeneroClienteIndex.setSelectedIndex(0);
            }
            if (!tbclientesIndex.getValueAt(filas, 3).toString().equals("")) {
                txtemailClienteIndex.setText(tbclientesIndex.getValueAt(filas, 3).toString());
            } else {
                txtemailClienteIndex.setText("");
            }

        }
    }//EventoDeMouseClicked

    public boolean valEntradasCliente() {
        String mensaje = "";
        boolean estado = true;
        if (txtcodigoClienteIndex.getText().isEmpty()) {
            mensaje += "ID NO DEBE ESTAR VACIO \n";
            estado = false;
        }
        if (txtnombreClienteIndex.getText().isEmpty()) {
            mensaje += "NO SE INSERTO UN NOMBRE VALIDO \n";
            estado = false;
        }

        if (cbgeneroClienteIndex.getSelectedIndex() == 0) {
            mensaje += "NO SE SELECCIONO GENERO \n";
            estado = false;
        }
        if (txtemailClienteIndex.getText().isEmpty() == false && valcorreo(txtemailClienteIndex.getText()) == false) {
            mensaje += "VERIFICA DIRECCION DE CORREO @";
            estado = false;
        }
        if (mensaje.length() >= 6) {
            JOptionPane.showMessageDialog(null, mensaje, "", JOptionPane.WARNING_MESSAGE);

        }

        return estado;
    }

    public boolean valcorreo(String email) {
        boolean correo = false;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                correo = true;
            }
        }
        return correo;
    }

    public void desabilitarControlerCliente() {
        //this.lblcodigo.setEnabled(false);
        //this.lblnombre.setEnabled(false);
        //this.lbldireccion.setEnabled(false);
        //this.lbltelefono.setEnabled(false);
        //lblgenero.setEnabled(false);
        //lblemail.setEnabled(false);
        this.btnaceptarClienteIndex.setEnabled(false);
        this.btncancelarClienteIndex.setEnabled(false);
        this.btnmodificarClienteIndex.setEnabled(false);
        this.btneliminarClienteIndex.setEnabled(false);
        this.txtcodigoClienteIndex.setEnabled(false);
        this.txtnombreClienteIndex.setEnabled(false);
        this.txttelefonoClienteIndex.setEnabled(false);
        cbgeneroClienteIndex.setEnabled(false);
        txtemailClienteIndex.setEnabled(false);
        cbcolClienteIndex.setEnabled(false);
        cbmuniClienteIndex.setEnabled(false);
        cbestadoClienteIndex.setEnabled(false);
        btnnuevoClienteIndex.setEnabled(true);
    }

    public void habilitarControlesCliente() {
        this.lblcodigo.setEnabled(true);
        this.lblnombre.setEnabled(true);
        this.lbldireccion.setEnabled(true);
        this.lbltelefono.setEnabled(true);
        lblgenero.setEnabled(true);
        lblemail.setEnabled(true);
        this.btnaceptarClienteIndex.setEnabled(true);
        this.btncancelarClienteIndex.setEnabled(true);
        this.btnmodificarClienteIndex.setEnabled(false);
        this.btneliminarClienteIndex.setEnabled(false);
        this.txtcodigoClienteIndex.setEnabled(true);
        this.txtnombreClienteIndex.setEnabled(true);
        this.txttelefonoClienteIndex.setEnabled(true);
        cbgeneroClienteIndex.setEnabled(true);
        txtemailClienteIndex.setEnabled(true);
        cbcolClienteIndex.setEnabled(true);
        cbmuniClienteIndex.setEnabled(true);
        cbestadoClienteIndex.setEnabled(true);
        txttelefonoClienteIndex.setText("0");

    }

    public void limpiarControlesCliente() {
//        this.Generarnumeracion();
        this.txtnombreClienteIndex.setText("");
        this.txttelefonoClienteIndex.setText("");
        txtcodigoClienteIndex.setText("");
        cbgeneroClienteIndex.setSelectedIndex(0);
        txtemailClienteIndex.setText("");
        cbcolClienteIndex.setSelectedIndex(0);
        cbmuniClienteIndex.setSelectedIndex(0);
        cbestadoClienteIndex.setSelectedIndex(0);
    }

    public void generarId(int op) {
        if (op == 1) {
            txtcodigoClienteIndex.setText(String.valueOf(clientesController.generarSecuenciaId()));
        } else if (op == 2) {
            txtCodigoProveedorIndex.setText(String.valueOf(proveedoresController.generarSecuenciaId()));
        } else if (op == 3) {
            txtcodigoProductoIndex.setText(String.valueOf(productoController.generarSecuenciaId()));
        }

    }

    /*=======================FINISH CLIENTE========================*/
 /*======================INICIA PROVEEDOR=======================*/
    private void carga_informacion_Prov(String nombre) {
        List<ProveedorDTO> listaProv = null;
        String[] titulos = {"CODIGO", "NOMBRE", "EMAIL", "TELEFONO"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        try {
            Object o[] = null;
            listaProv = proveedoresController.proveedoresAll(nombre);
            for (int i = 0; i < listaProv.size(); i++) {
                dtm.addRow(o);
                dtm.setValueAt(listaProv.get(i).getIdproveedor(), i, 0);
                dtm.setValueAt(listaProv.get(i).getNombre(), i, 1);
                dtm.setValueAt(listaProv.get(i).getMail(), i, 2);
                dtm.setValueAt(listaProv.get(i).getTelefono(), i, 3);
            }
            tbProveedorIndex.setModel(dtm);

        } catch (Exception e) {
            System.out.println("Error al listar proveedores:" + e.getMessage());
        }
    }

    public void DesabilitarControlesProveedor() {
        txtCodigoProveedorIndex.setEnabled(false);
        txttelefonoProveedorIndex.setEnabled(false);
        txtemailProveedorIndex.setEnabled(false);
        txtEmpresaProveedorIndex.setEnabled(false);
        btnaceptarProveedorIndex.setEnabled(false);
        btncancelarProveedorIndex.setEnabled(false);
        btneliminarProveedorIndex.setEnabled(false);
        btnmodificarProveedorIndex.setEnabled(false);
        btnnuevoProveedorIndex.setEnabled(true);

    }

    public void habFieldComponentesProveedor() {
        txtCodigoProveedorIndex.setEnabled(true);
        txttelefonoProveedorIndex.setEnabled(true);
        txtemailProveedorIndex.setEnabled(true);
        txtEmpresaProveedorIndex.setEnabled(true);
        btnaceptarProveedorIndex.setEnabled(true);
        btncancelarProveedorIndex.setEnabled(true);

    }

    public void limpiarControlesProveedor() {
        txttelefonoProveedorIndex.setText("");
        txtemailProveedorIndex.setText("");
        txtEmpresaProveedorIndex.setText("");
        txtCodigoProveedorIndex.setText("");
    }

    public boolean valEntradasProveedor() {
        String msj = "";
        boolean es = true;
        if (this.txtCodigoProveedorIndex.getText().isEmpty() == true) {
            msj += "NO SE INSERTO CODIGO \n";
            es = false;
        }
        if (txtEmpresaProveedorIndex.getText().isEmpty() == true) {
            msj += "NO SE INSERTO NOMBRE \n";
            es = false;
        }
        if (txtemailProveedorIndex.getText().isEmpty() == false && valcorreo(txtemailProveedorIndex.getText()) == false) {
            msj += "VERIFICA DIRECCION DE CORREO @";
            es = false;
        }

        if (msj.length() >= 6) {
            JOptionPane.showMessageDialog(null, msj, "", JOptionPane.WARNING_MESSAGE);

        }

        return es;
    }

    /*========================TERMINA PROVEEDORES===========================*/
 /*=========================INICIA PRODUCTOS=============================================*/
    public void desabPanContenidoProductos() {       
        txtcodigoProductoIndex.setEnabled(false);
        txtnombreProductoIndex.setEnabled(false);
        cbunidadProductoIndex.setEnabled(false);
        sppclienteProductoIndex.setEnabled(false);
        spppublicoProductoIndex.setEnabled(false);
        spcantidadProductosIndex.setEnabled(false);
        cbproveedorProductosIndex.setEnabled(false);
        btnaceptarProductosIndex.setEnabled(false);
        btncancelarProductosIndex.setEnabled(false);
        cbcategoriaProductosIndex.setEnabled(false);
        btnmodificarProductosIndex.setEnabled(false);
        btneliminarProductosIndex.setEnabled(false);
        btnnuevoProductosIndex.setEnabled(true);
    }

    public void habPanContenidoProductos() {
        jLabel1.setEnabled(true);
        jLabel6.setEnabled(true);
        jLabel7.setEnabled(true);
        jLabel8.setEnabled(true);
        jLabel9.setEnabled(true);
        jLabel10.setEnabled(true);
        jLabel11.setEnabled(true);
        txtcodigoProductoIndex.setEnabled(true);
        txtnombreProductoIndex.setEnabled(true);
        cbunidadProductoIndex.setEnabled(true);
        sppclienteProductoIndex.setEnabled(true);
        spppublicoProductoIndex.setEnabled(true);
        spcantidadProductosIndex.setEnabled(true);
        cbproveedorProductosIndex.setEnabled(true);
        btnaceptarProductosIndex.setEnabled(true);
        btncancelarProductosIndex.setEnabled(true);
        cbcategoriaProductosIndex.setEnabled(true);
        btnnuevoProductosIndex.setEnabled(false);
        jLabelCat.setEnabled(true);
    }

    public boolean valEntradasProductos() {
        String mensaje = "";
        boolean estado = true;
        Double pcliente = Double.parseDouble(sppclienteProductoIndex.getValue().toString());
        Double ppublico = Double.parseDouble(spppublicoProductoIndex.getValue().toString());
        Double cantidad = Double.parseDouble(spcantidadProductosIndex.getValue().toString());
        if (this.txtcodigoProductoIndex.getText().isEmpty() == true) {
            mensaje += "NO SE GENERO CODIGO \n";
            estado = false;
        }
        if (txtnombreProductoIndex.getText().isEmpty() == true) {
            mensaje += "NO SE INSERTO NOMBRE \n";
            estado = false;
        }
        if (cbunidadProductoIndex.getSelectedIndex() == 0) {
            mensaje += "NO SE SELECCIONO UNIDAD DE MEDIDA \n";
            estado = false;
        }
        /* if (pcliente <= 0) {
            mensaje += "PRECIO CLIENTE DEBE SER MAYOR A CERO \n";
            sppcliente.setValue(0);
            estado = false;
        }*/
        if (ppublico <= 0) {
            mensaje += "PRECIO PUBLICO DEBE SER MAYOR A CERO \n";
            spppublicoProductoIndex.setValue(0);
            estado = false;
        }
        if (cantidad <= 0) {
            mensaje += "CANTIDAD DEBE SER MAYOR A CERO \n";
            spcantidadProductosIndex.setValue(0);
            estado = false;
        }
        if (cbproveedorProductosIndex.getSelectedIndex() == 0) {
            mensaje += "NO SE SELECCIONO PROVEEDOR \n";
            estado = false;
        }
        if (cbcategoriaProductosIndex.getSelectedIndex() == 0) {
            mensaje += "NO SE SELECCIONO CATEGORIA \n";
            estado = false;
        }

        if (mensaje.length() >= 4) {
            JOptionPane.showMessageDialog(null, mensaje, "", JOptionPane.WARNING_MESSAGE);

        }
        return estado;

    }//MetodoParaValidarCajasDeTexto

    public void limpiarControlesProducto() {//MetodoLimpiarCajaasDeTexto
        txtnombreProductoIndex.setText("");
        cbunidadProductoIndex.setSelectedIndex(0);
        sppclienteProductoIndex.setValue(0.0);
        spppublicoProductoIndex.setValue(0.0);
        spcantidadProductosIndex.setValue(0);
        cbproveedorProductosIndex.setSelectedIndex(0);
        cbcategoriaProductosIndex.setSelectedIndex(0);
        this.btnmodificarProductosIndex.setEnabled(false);
        this.btneliminarProductosIndex.setEnabled(false);
    }

    public void EventoTbProductMC() {
        int fseleccionada = tbProductosIndex.getSelectedRow();
        if (fseleccionada >= 0) {
            habPanContenidoProductos();
            this.btnmodificarProductosIndex.setEnabled(true);
            this.btneliminarProductosIndex.setEnabled(true);
            txtcodigoProductoIndex.setText(tbProductosIndex.getValueAt(fseleccionada, 0).toString());
            txtnombreProductoIndex.setText(tbProductosIndex.getValueAt(fseleccionada, 1).toString());
            cbunidadProductoIndex.setSelectedItem(tbProductosIndex.getValueAt(fseleccionada, 9).toString());
            if (tbProductosIndex.getValueAt(fseleccionada, 3).toString().toUpperCase().contains("SIN")) {
                sppclienteProductoIndex.setValue(0.0);
            } else {
                sppclienteProductoIndex.setValue(Double.parseDouble(tbProductosIndex.getValueAt(fseleccionada, 3).toString()));
            }
            spppublicoProductoIndex.setValue(Double.parseDouble(tbProductosIndex.getValueAt(fseleccionada, 2).toString()));
            spcantidadProductosIndex.setValue(Integer.parseInt(tbProductosIndex.getValueAt(fseleccionada, 4).toString()));
            cbproveedorProductosIndex.setSelectedItem(tbProductosIndex.getValueAt(fseleccionada, 8).toString());
            cbcategoriaProductosIndex.setSelectedItem(tbProductosIndex.getValueAt(fseleccionada, 7).toString());
            // padquisicion.setText(tbproductos.getValueAt(fseleccionada, 7).toString());
            btnaceptarProductosIndex.setEnabled(false);
            btnnuevoProductosIndex.setEnabled(false);
        }

    }
     
     public void llenarCategoria() {
        CategoriaController controllerCat = new CategoriaController();
        for (int i = 0; i < controllerCat.categoriasAll("").size(); i++) {
            cbcategoriaProductosIndex.addItem(controllerCat.categoriasAll("").get(i).getDescripcion());
        }
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelVendedor;
    private com.toedter.calendar.JDateChooser Midate;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnConfig;
    private javax.swing.JButton btnGenerarVenta;
    private javax.swing.JButton btnNuevaVenta;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JButton btnVaciarTicket;
    private javax.swing.JPanel btnVender;
    private javax.swing.JButton btnaceptar;
    private javax.swing.JButton btnaceptarClienteIndex;
    private javax.swing.JButton btnaceptarProductosIndex;
    private javax.swing.JButton btnaceptarProveedorIndex;
    private javax.swing.JButton btnaddProd;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btncancelarClienteIndex;
    private javax.swing.JButton btncancelarProductosIndex;
    private javax.swing.JButton btncancelarProveedorIndex;
    private javax.swing.JButton btneliminarClienteIndex;
    private javax.swing.JButton btneliminarProductosIndex;
    private javax.swing.JButton btneliminarProveedorIndex;
    private javax.swing.JButton btnmodificarClienteIndex;
    private javax.swing.JButton btnmodificarProductosIndex;
    private javax.swing.JButton btnmodificarProveedorIndex;
    private javax.swing.JButton btnnuevoClienteIndex;
    private javax.swing.JButton btnnuevoProductosIndex;
    private javax.swing.JButton btnnuevoProveedorIndex;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton btnsalir2;
    private javax.swing.JButton btnsalir3;
    private javax.swing.JComboBox<String> cbTipoVenta;
    private javax.swing.JComboBox<String> cbcategoriaProductosIndex;
    private javax.swing.JComboBox<String> cbcolClienteIndex;
    private javax.swing.JComboBox<String> cbestadoClienteIndex;
    private javax.swing.JComboBox<String> cbgeneroClienteIndex;
    private javax.swing.JComboBox<String> cbmuniClienteIndex;
    private javax.swing.JComboBox<String> cbproveedor;
    private javax.swing.JComboBox<String> cbproveedorProductosIndex;
    private javax.swing.JComboBox<String> cbunidad;
    private javax.swing.JComboBox<String> cbunidadProductoIndex;
    private javax.swing.JLabel j1;
    private javax.swing.JLabel j2;
    private javax.swing.JLabel j4;
    private javax.swing.JLabel j5;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JDialog jDialogClientes;
    private javax.swing.JDialog jDialogProducto;
    private javax.swing.JDialog jDialogProductosAdmin;
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
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCat;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel jpanelJDClientesTB;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JLabel lbldireccion;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblgenero;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lbltelefono;
    private javax.swing.JLabel padquisicion;
    private javax.swing.JPanel panelImg;
    private javax.swing.JPanel pcontenido;
    private javax.swing.JPanel pcontenido1;
    private javax.swing.JPanel plista;
    private javax.swing.JPanel plista1;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlDatos1;
    private javax.swing.JPanel pnlDatos2;
    private javax.swing.JPanel pnlLista;
    private javax.swing.JSpinner spcantidad;
    private javax.swing.JSpinner spcantidadProductosIndex;
    private javax.swing.JSpinner sppcliente;
    private javax.swing.JSpinner sppclienteProductoIndex;
    private javax.swing.JSpinner spppublico;
    private javax.swing.JSpinner spppublicoProductoIndex;
    private javax.swing.JTable tbClientes1;
    private javax.swing.JTable tbProductos;
    private javax.swing.JTable tbProductosIndex;
    private javax.swing.JTable tbProveedorIndex;
    private javax.swing.JTable tbTicket;
    private javax.swing.JTable tbclientesIndex;
    public javax.swing.JTable tbproductosAdmin;
    private javax.swing.JLabel tipo;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscarProductosIndex;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtCodigoProveedorIndex;
    private javax.swing.JTextField txtDescripcionVenta;
    private javax.swing.JTextField txtEmpresaProveedorIndex;
    private javax.swing.JTextField txtIdCV;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtProductoB;
    private javax.swing.JTextField txtRucVenta;
    private javax.swing.JTextField txtStockDisponible;
    private javax.swing.JLabel txtTotal;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtbuscarProveedorIndex;
    private javax.swing.JTextField txtclientesb;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtcodigoClienteIndex;
    private javax.swing.JTextField txtcodigoProductoIndex;
    private javax.swing.JTextField txtemailClienteIndex;
    private javax.swing.JTextField txtemailProveedorIndex;
    public javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnombreClienteIndex;
    public javax.swing.JTextField txtnombreProductoIndex;
    private javax.swing.JTextField txttelefonoClienteIndex;
    private javax.swing.JTextField txttelefonoProveedorIndex;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel {

        private Image image;

        @Override
        public void paint(Graphics g) {
            image = new ImageIcon(getClass().getResource("/Imagenes/waves.png")).getImage();
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);

        }

    }
}
