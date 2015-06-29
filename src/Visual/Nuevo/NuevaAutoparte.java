package Visual.Nuevo;

import LogicaDeNegocios.*;
import Persistencia.exceptions.PreexistingEntityException;
import Visual.Controladora;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NuevaAutoparte extends javax.swing.JInternalFrame {

    Controladora cLocal;
    DefaultTableModel miModeloTabla= new DefaultTableModel();
    DefaultTableModel miModeloTabla2= new DefaultTableModel();
    int cant, impuesto;
    long stock;
    float precio;
    Autoparte parte;
    String descripcion;
    

    
    public NuevaAutoparte(Controladora c) {
        initComponents();
        cLocal = c;
        String nom = c.dameEmpresas().get(0).getNombre();
        setTitle(nom+" - Nueva Autoparte");
        miModeloTabla.addColumn("Marca");
        miModeloTabla.addColumn("Modelo");
        miModeloTabla2.addColumn("Marca");
        miModeloTabla2.addColumn("Modelo");
        CargarTabla();
        txtCodigo.setEnabled(false);
        
        txtPrecio.setText("0.0");
        txtImpuesto.setText("0");
        txtStock.setText("0");
        cant= cLocal.dameAccesorios().size() + cLocal.dameRepuestos().size() + cLocal.dameEquipamientos().size();
        txtCodigo.setText(String.valueOf(cant+1));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tipo = new javax.swing.ButtonGroup();
        jPanelNuevoCliente = new javax.swing.JPanel();
        jPanelDatos = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        lblCUIT = new javax.swing.JLabel();
        txtImpuesto = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        lblDNI = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        lblCUIT1 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        cbxRecambio = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtCaract = new javax.swing.JTextArea();
        jPanelUbicacion = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblCodigo1 = new javax.swing.JLabel();
        rbtnAccesorio = new javax.swing.JRadioButton();
        rbtnEquipamiento = new javax.swing.JRadioButton();
        rbtnRepuesto = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGrupopartes = new javax.swing.JTable();
        lblGrupopartes = new javax.swing.JLabel();
        lblGrupopartesProv = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblModelosAutop = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        btnQuitarTodo = new javax.swing.JButton();
        btnAgregarTodo = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jPanelNuevoCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nueva Autoparte", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 36), new java.awt.Color(0, 0, 0))); // NOI18N

        jPanelDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        lblNombre.setText("Nombre (Breve descripción):");

        lblCUIT.setText("Impuesto (%):");

        lblEmail.setText("Características:");

        lblDNI.setText("Precio:");

        lblCUIT1.setText("Stock:");

        cbxRecambio.setText("Recambio");

        txtCaract.setColumns(20);
        txtCaract.setRows(5);
        jScrollPane3.setViewportView(txtCaract);

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDescripcion))
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3))
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(lblDNI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(lblCUIT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCUIT1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(cbxRecambio)))
                .addContainerGap())
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDNI)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCUIT)
                    .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCUIT1)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxRecambio))
                .addGap(18, 18, 18)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmail)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelUbicacion.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        lblCodigo.setText("Código:");

        lblCodigo1.setText("Tipo:");

        Tipo.add(rbtnAccesorio);
        rbtnAccesorio.setText("Accesorio");

        Tipo.add(rbtnEquipamiento);
        rbtnEquipamiento.setText("Equipamiento");

        Tipo.add(rbtnRepuesto);
        rbtnRepuesto.setText("Repuesto");

        javax.swing.GroupLayout jPanelUbicacionLayout = new javax.swing.GroupLayout(jPanelUbicacion);
        jPanelUbicacion.setLayout(jPanelUbicacionLayout);
        jPanelUbicacionLayout.setHorizontalGroup(
            jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUbicacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(lblCodigo1)
                .addGap(18, 18, 18)
                .addComponent(rbtnAccesorio)
                .addGap(18, 18, 18)
                .addComponent(rbtnEquipamiento)
                .addGap(18, 18, 18)
                .addComponent(rbtnRepuesto)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanelUbicacionLayout.setVerticalGroup(
            jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUbicacionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigo1)
                    .addComponent(rbtnAccesorio)
                    .addComponent(rbtnEquipamiento)
                    .addComponent(rbtnRepuesto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblGrupopartes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblGrupopartes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblGrupopartes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGrupopartesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGrupopartes);

        lblGrupopartes.setText("Modelos de autos existentes:");

        lblGrupopartesProv.setText("Modelos de autos a los que pertenece la autoparte:");

        tblModelosAutop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblModelosAutop.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblModelosAutop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblModelosAutopMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblModelosAutop);

        btnAgregar.setText("Agregar >");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnQuitar.setText("< Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        btnQuitarTodo.setText("<< Quitar todo");
        btnQuitarTodo.setMaximumSize(new java.awt.Dimension(115, 23));
        btnQuitarTodo.setMinimumSize(new java.awt.Dimension(115, 23));
        btnQuitarTodo.setPreferredSize(new java.awt.Dimension(115, 23));
        btnQuitarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarTodoActionPerformed(evt);
            }
        });

        btnAgregarTodo.setText("Agregar todo >>");
        btnAgregarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelNuevoClienteLayout = new javax.swing.GroupLayout(jPanelNuevoCliente);
        jPanelNuevoCliente.setLayout(jPanelNuevoClienteLayout);
        jPanelNuevoClienteLayout.setHorizontalGroup(
            jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                        .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAgregar)
                            .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                                    .addGap(159, 159, 159)
                                    .addComponent(btnAgregarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblGrupopartes)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblGrupopartesProv)
                                    .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnQuitarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNuevoClienteLayout.setVerticalGroup(
            jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNuevoClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGrupopartes)
                    .addComponent(lblGrupopartesProv))
                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNuevoClienteLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnQuitar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarTodo)
                    .addComponent(btnQuitarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1414891160_Check.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAceptar.setIconTextGap(2);
        btnAceptar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAceptar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1414891178_Cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setIconTextGap(2);
        btnCancelar.setMaximumSize(new java.awt.Dimension(95, 73));
        btnCancelar.setMinimumSize(new java.awt.Dimension(95, 73));
        btnCancelar.setPreferredSize(new java.awt.Dimension(95, 73));
        btnCancelar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String caract = txtCaract.getText();
        
        List<Modelo> Lista= cLocal.dameModelos();
        if(control() && controlNumeros()){
            try {
                controlNombre();
                
                //Catch de los Autoparte nuevos
                int cantr = tblModelosAutop.getRowCount();
                List<Modelo> Nuevos= new LinkedList<Modelo>();
                String nom;
                Modelo gp;
                int b;
                Iterator<Modelo> it;
                for(int i=0; i<cantr;i++){
                    nom = tblModelosAutop.getValueAt(i,1).toString();
                    it = Lista.iterator();
                    gp = null;
                    b=0;
                    while(it.hasNext() && b==0) {
                        gp = it.next();
                        if(gp.getNombre().equals(nom)){ b=1; }
                    }
                    Nuevos.add(gp);
                }
                String precito = txtPrecio.getText().toString()+"f";
                precio = Float.parseFloat(precito);
                
                    
                if(rbtnAccesorio.isSelected()){
                    cLocal.crearAccesorio(Integer.parseInt(txtCodigo.getText()), descripcion, caract, precio, impuesto, cbxRecambio.isSelected(), stock);
                    cLocal.editarAccesorio(Integer.parseInt(txtCodigo.getText()), descripcion, caract, precio, impuesto, cbxRecambio.isSelected(), stock, false, new LinkedList<Item>(), Nuevos, new LinkedList<Vehiculo>());
                }
                if(rbtnEquipamiento.isSelected()){
                    cLocal.crearEquipamiento(Integer.parseInt(txtCodigo.getText()), descripcion, caract, precio, impuesto, cbxRecambio.isSelected(), stock);
                    cLocal.editarEquipamiento(Integer.parseInt(txtCodigo.getText()), descripcion, caract, precio, impuesto, cbxRecambio.isSelected(), stock, false, new LinkedList<Item>(), Nuevos, new LinkedList<Vehiculo>());
                }
                if(rbtnRepuesto.isSelected()){
                    cLocal.crearRepuesto(Integer.parseInt(txtCodigo.getText()), descripcion, caract, precio, impuesto, cbxRecambio.isSelected(), stock);
                    cLocal.editarRepuesto(Integer.parseInt(txtCodigo.getText()), descripcion, caract, precio, impuesto, cbxRecambio.isSelected(), stock, false, new LinkedList<Item>(), Nuevos, new LinkedList<Vehiculo>());
                }
                this.hide();
                
                String err = "Se ha creado correctamente";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Carga Correcta", JOptionPane.PLAIN_MESSAGE);            
            } catch (PreexistingEntityException p) {
                String err = "Ya existe una Autoparte con ese Nombre";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Error de Carga", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                System.out.println("Error de persistencia");
                JOptionPane.showMessageDialog(this, "Error de persistencia", "Error de Carga", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            String err = "Complete todos los campos correctamente!";
            System.err.println(err);
            JOptionPane.showMessageDialog(this, err, "Error de Carga", JOptionPane.ERROR_MESSAGE);
        }    
    }//GEN-LAST:event_btnAceptarActionPerformed

    
    private boolean control(){
        boolean ok=true;        
        if (txtDescripcion.getText().equals("")) ok=false;
        if (txtCaract.getText().equals("")) {
            ok=false;
            String err = "Por favor complete el cuadro de Características";
            System.err.println(err);
            JOptionPane.showMessageDialog(this, err, "Error de Carga", JOptionPane.ERROR_MESSAGE);
        }
        if (tblModelosAutop.getRowCount()==0) {
            ok=false;
            String err = "Por favor agregue un modelo como mínimo";
            System.err.println(err);
            JOptionPane.showMessageDialog(this, err, "Error de Carga", JOptionPane.ERROR_MESSAGE);
        }
        if (!rbtnAccesorio.isSelected() && !rbtnEquipamiento.isSelected() && !rbtnRepuesto.isSelected()) ok=false;
        return ok;
    }
    private boolean controlNumeros(){
        boolean ok=true;        
        try{
            if (txtPrecio.getText().equals("0.0")){
                ok=false;
            }
            if (txtImpuesto.getText().equals("")){
                ok=false;
            }else{
                impuesto = Integer.parseInt(txtImpuesto.getText());
            }
            if (txtStock.getText().equals("")){
                ok=false;
            }else{
                stock = Long.parseLong(txtStock.getText());
            }
        } catch (NumberFormatException a) {
            ok=false;
            String err = "Números ingresados de manera incorrecta";
            System.err.println(err);
            JOptionPane.showMessageDialog(this, err, "Error de Carga", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            ok=false;
            System.out.println("Error en carga de números");
            JOptionPane.showMessageDialog(this, "Error en carga de números", "Error de Carga", JOptionPane.ERROR_MESSAGE);
        }        
        return ok;
    }
    private void controlNombre() throws PreexistingEntityException {
        descripcion = txtDescripcion.getText();
        LinkedList<Autoparte> partes=new LinkedList<Autoparte>();
        partes.addAll(cLocal.dameEquipamientos());
        partes.addAll(cLocal.dameAccesorios());
        partes.addAll(cLocal.dameRepuestos());
        Iterator<Autoparte> it = partes.iterator();
        parte = null;
        boolean b=true;
        while(it.hasNext() && b) {
            parte = it.next();
            if(parte.getDescripcion().equals(descripcion)){
                throw new PreexistingEntityException("error cn nombre");
            }
        }
    }
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    
    private void tblGrupopartesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGrupopartesMouseClicked
        
    }//GEN-LAST:event_tblGrupopartesMouseClicked

    private void tblModelosAutopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblModelosAutopMouseClicked
    }//GEN-LAST:event_tblModelosAutopMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(tblGrupopartes.getRowCount()!=0 && tblGrupopartes.getSelectedRow() != -1){
            Object[]fila= new Object[2];
            fila[0] = tblGrupopartes.getValueAt(tblGrupopartes.getSelectedRow(),0).toString();
            fila[1] = tblGrupopartes.getValueAt(tblGrupopartes.getSelectedRow(),1).toString();
            miModeloTabla.removeRow(tblGrupopartes.getSelectedRow());
            miModeloTabla2.addRow(fila);

            tblModelosAutop.setModel(miModeloTabla2);
            tblGrupopartes.setModel(miModeloTabla);}
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAgregarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTodoActionPerformed
        DefaultTableModel modelo2=(DefaultTableModel) tblGrupopartes.getModel();
        Object[]fila= new Object[2];
        
        int filas=tblGrupopartes.getRowCount();
        for(int i=0; i<filas;i++){
            fila[0] = tblGrupopartes.getValueAt(0,0).toString();
            fila[1] = tblGrupopartes.getValueAt(0,1).toString();
            miModeloTabla2.addRow(fila);
            modelo2.removeRow(0);
        }
        
        tblModelosAutop.setModel(miModeloTabla2);        
    }//GEN-LAST:event_btnAgregarTodoActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        if(tblModelosAutop.getRowCount()!=0 && tblModelosAutop.getSelectedRow() != -1){
            Object[]fila= new Object[2];
            fila[0] = tblModelosAutop.getValueAt(tblModelosAutop.getSelectedRow(),0).toString();
            fila[1] = tblModelosAutop.getValueAt(tblModelosAutop.getSelectedRow(),1).toString();
            miModeloTabla2.removeRow(tblModelosAutop.getSelectedRow());
            miModeloTabla.addRow(fila);

            tblGrupopartes.setModel(miModeloTabla);
            tblModelosAutop.setModel(miModeloTabla2);}
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnQuitarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarTodoActionPerformed
        DefaultTableModel modelo2=(DefaultTableModel) tblModelosAutop.getModel();
        Object[]fila= new Object[2];
        
        int filas=tblModelosAutop.getRowCount();
        for(int i=0; i<filas;i++){
            fila[0] = tblModelosAutop.getValueAt(0,0).toString();
            fila[1] = tblModelosAutop.getValueAt(0,1).toString();
            miModeloTabla.addRow(fila);
            modelo2.removeRow(0);
        }
        
        tblGrupopartes.setModel(miModeloTabla);    
    }//GEN-LAST:event_btnQuitarTodoActionPerformed

    
    
    public void CargarTabla(){
        List<Modelo> Lista= cLocal.dameModelos();
        Object[]fila= new Object[2];
        
        Collections.sort(Lista, new Comparator<Modelo>(){
            public int compare(Modelo s1, Modelo s2) {
                if (s1.getUnaMarca().getNombre().compareToIgnoreCase(s2.getUnaMarca().getNombre()) <= 0)
             return -1;
                else
             return 1;
            }
        });
        
        for(Modelo unModelo:Lista){
            fila[0]=unModelo.getUnaMarca().getNombre();
            fila[1]=unModelo.getNombre();
            miModeloTabla.addRow(fila);
        }
        tblGrupopartes.setModel(miModeloTabla);
    }
    
    public void LimpiarTabla(){
        DefaultTableModel modelo2=(DefaultTableModel) tblGrupopartes.getModel();
        int filas=tblGrupopartes.getRowCount();
        for(int i=0; i<filas;i++){
            modelo2.removeRow(0);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Tipo;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarTodo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnQuitarTodo;
    private javax.swing.JCheckBox cbxRecambio;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelNuevoCliente;
    private javax.swing.JPanel jPanelUbicacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCUIT;
    private javax.swing.JLabel lblCUIT1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigo1;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGrupopartes;
    private javax.swing.JLabel lblGrupopartesProv;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JRadioButton rbtnAccesorio;
    private javax.swing.JRadioButton rbtnEquipamiento;
    private javax.swing.JRadioButton rbtnRepuesto;
    private javax.swing.JTable tblGrupopartes;
    private javax.swing.JTable tblModelosAutop;
    private javax.swing.JTextArea txtCaract;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtImpuesto;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
