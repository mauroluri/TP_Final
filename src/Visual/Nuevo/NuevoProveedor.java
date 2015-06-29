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

public class NuevoProveedor extends javax.swing.JInternalFrame {

    Controladora cLocal;
    DefaultTableModel miModeloTabla= new DefaultTableModel();
    DefaultTableModel miModeloTabla2= new DefaultTableModel();
    DefaultComboBoxModel miModeloCombo = new DefaultComboBoxModel();
    DefaultComboBoxModel miModeloCombo2 = new DefaultComboBoxModel();
    
    public NuevoProveedor(Controladora c) {
        initComponents();
        cLocal = c;
        String nom = c.dameEmpresas().get(0).getNombre();
        setTitle(nom+" - Nuevo Proveedor");
        cmbLocalidad.setEnabled(false);
        miModeloTabla.addColumn("Nombre");
        miModeloTabla2.addColumn("Nombre");
        CargarTabla();
        CargarComboProv();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelNuevoCliente = new javax.swing.JPanel();
        jPanelDatos = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblCUIT = new javax.swing.JLabel();
        txtCUIT = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblEmail1 = new javax.swing.JLabel();
        txtRespFiscal = new javax.swing.JTextField();
        lblDNI = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jPanelUbicacion = new javax.swing.JPanel();
        cmbProvincia = new javax.swing.JComboBox();
        lbProvincia = new javax.swing.JLabel();
        cmbLocalidad = new javax.swing.JComboBox();
        lblLocalidad = new javax.swing.JLabel();
        btnAceptar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGrupopartes = new javax.swing.JTable();
        lblGrupopartes = new javax.swing.JLabel();
        lblGrupopartesProv = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGrupopartesProv = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        btnQuitarTodo = new javax.swing.JButton();
        btnAgregarTodo = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jPanelNuevoCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Proveedor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 36), new java.awt.Color(0, 0, 0))); // NOI18N

        jPanelDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        lblNombre.setText("Apellido, Nombres:");

        lblCUIT.setText("CUIT:");

        lblEmail.setText("Correo electrónico:");

        lblEmail1.setText("Responsabilidad Fiscal (RI, RNI, Monotributista, etc.):");

        lblDNI.setText("DNI:");

        lblTelefono.setText("Teléfono:");

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(lblEmail1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRespFiscal))
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDatosLayout.createSequentialGroup()
                                .addComponent(lblEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEmail))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDatosLayout.createSequentialGroup()
                                .addComponent(lblDNI)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50)
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCUIT)
                            .addComponent(lblTelefono))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefono)
                            .addComponent(txtCUIT)))
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDNI)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCUIT)
                    .addComponent(txtCUIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail1)
                    .addComponent(txtRespFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanelUbicacion.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        cmbProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProvinciaActionPerformed(evt);
            }
        });

        lbProvincia.setText("Provincia:");

        cmbLocalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLocalidadActionPerformed(evt);
            }
        });

        lblLocalidad.setText("Localidad:");

        btnAceptar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Redo_small.png"))); // NOI18N
        btnAceptar1.setText("Modificar");
        btnAceptar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAceptar1.setIconTextGap(2);
        btnAceptar1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAceptar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUbicacionLayout = new javax.swing.GroupLayout(jPanelUbicacion);
        jPanelUbicacion.setLayout(jPanelUbicacionLayout);
        jPanelUbicacionLayout.setHorizontalGroup(
            jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUbicacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelUbicacionLayout.createSequentialGroup()
                        .addComponent(lbProvincia)
                        .addGap(18, 18, 18)
                        .addComponent(cmbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelUbicacionLayout.createSequentialGroup()
                        .addComponent(lblLocalidad)
                        .addGap(18, 18, 18)
                        .addComponent(cmbLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanelUbicacionLayout.setVerticalGroup(
            jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUbicacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProvincia)
                    .addComponent(cmbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLocalidad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUbicacionLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(btnAceptar1)
                .addContainerGap())
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

        lblGrupopartes.setText("Grupos de Partes disponibles:");

        lblGrupopartesProv.setText("Grupos de Partes ofrecidas por nuevo proveedor:");

        tblGrupopartesProv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblGrupopartesProv.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblGrupopartesProv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGrupopartesProvMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGrupopartesProv);

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
                .addGap(29, 29, 29)
                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                        .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNuevoClienteLayout.createSequentialGroup()
                                        .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAgregar))
                                    .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                                        .addGap(69, 69, 69)
                                        .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnQuitarTodo, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                            .addComponent(btnAgregarTodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(lblGrupopartes))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGrupopartesProv)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanelUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                        .addComponent(lblGrupopartes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                        .addComponent(lblGrupopartesProv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAgregar)
                                    .addComponent(btnQuitar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnQuitarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAgregarTodo)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(10, 10, 10))
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
                .addComponent(jPanelNuevoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(562, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String nombre, mail, cuit, respFisc;
        long dni, telefono;
        Localidad loc;
        
        if(control()){
            try {
                dni = Long.valueOf(txtDNI.getText()); 
                telefono = Long.valueOf(txtTelefono.getText());
                nombre = txtNombre.getText();
                respFisc = txtRespFiscal.getText();
                mail = txtEmail.getText();
                cuit = txtCUIT.getText();
                loc = obtenerLocalidad();
                
                //Catch de los GrupoParte nuevos
                int cant = tblGrupopartesProv.getRowCount();
                List<GrupoParte> Todos= cLocal.dameGruposParte();
                List<GrupoParte> Nuevos= new LinkedList<GrupoParte>();
                String nom;
                GrupoParte gp;
                int b;
                Iterator<GrupoParte> it;
                for(int i=0; i<cant;i++){
                    nom = tblGrupopartesProv.getValueAt(i,0).toString();
                    it = Todos.iterator();
                    gp = null;
                    b=0;
                    while(it.hasNext() && b==0) {
                        gp = it.next();
                        if(gp.getNombre().equals(nom)){ b=1; }
                    }
                    Nuevos.add(gp); 
                }
                
                cLocal.crearProveedor(loc, nombre, telefono, cuit, dni, respFisc, mail);
                cLocal.editarProveedor(loc, nombre, telefono, cuit, dni, respFisc, mail, "", false, Nuevos);
                this.hide();
                
                String err = "Se ha creado correctamente";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Carga Correcta", JOptionPane.PLAIN_MESSAGE);
            } catch (NumberFormatException a){
                String err = "DNI Invalido";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Error de Carga", JOptionPane.ERROR_MESSAGE);
            } catch (PreexistingEntityException p){
                String err = "Ya existe un cliente con ese DNI.";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Error de Carga", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e){
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
        int l= txtDNI.getText().length();
        
        if (cmbProvincia.getSelectedIndex()==0) ok=false;
        if (cmbLocalidad.getSelectedIndex()==0) ok=false;
        if (txtRespFiscal.getText().equals("")) ok=false;
        if (txtEmail.getText().equals("")) ok=false;
        if (txtNombre.getText().equals("")) ok=false;
        if (txtTelefono.getText().equals("")) ok=false;
        if (txtCUIT.getText().equals("")) ok=false;
        if (txtDNI.getText().equals("")) ok=false;
        if (!(txtDNI.getText().equals(""))){
             int c = Integer.parseInt(txtCUIT.getText().substring(2, l+2));
             int d = Integer.parseInt(txtDNI.getText());
             if (c!=d) {ok=false;}
        }else{
                ok=false;
            }
        
        return ok;
    }
    
        private Localidad obtenerLocalidad(){
        String m = cmbProvincia.getSelectedItem().toString();
                List<Provincia> p = cLocal.dameProvincias();
                int bb=0;
                
                Iterator<Provincia> it = null;
                it = p.iterator();
                Provincia prov = null;
                while(it.hasNext() && bb==0) {
                    prov = it.next();
                    if(prov.getNombre().equals(m)){ bb=1; }
                }
                String nom = cmbLocalidad.getSelectedItem().toString();
                List<Localidad> l = prov.getLocalidades();
                int b=0;
                
                Iterator<Localidad> it2 = null;
                it2 = l.iterator();
                Localidad loc = null;
                while(it2.hasNext() && b==0) {
                    loc = it2.next();
                    if(loc.getNombre().equals(nom)){ b=1; }
                }
                return loc;
    }
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    
    private void cmbProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProvinciaActionPerformed
        if(!(cmbProvincia.getSelectedItem().toString().equals("Seleccione una Provincia"))){
            try {
                String nom = cmbProvincia.getSelectedItem().toString();
                List<Provincia> p = cLocal.dameProvincias();
                int b=0;
                
                Iterator<Provincia> it = null;
                it = p.iterator();
                Provincia prov = null;
                while(it.hasNext() && b==0) {
                    prov = it.next();
                    if(prov.getNombre().equals(nom)){ b=1; }
                }
                
                CargarComboLoc(prov);
                cmbLocalidad.setEnabled(true);
                cmbProvincia.setEnabled(false);
                
            } catch (NumberFormatException a){
            } catch (Exception e){
            }
        }
    }//GEN-LAST:event_cmbProvinciaActionPerformed

    private void cmbLocalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLocalidadActionPerformed
        if(!(cmbLocalidad.getSelectedItem().toString().equals("Seleccione una Localidad"))){
            try {
                String nom = cmbLocalidad.getSelectedItem().toString();
                List<Localidad> l = cLocal.dameLocalidades();
                int b=0;
                
                Iterator<Localidad> it = null;
                it = l.iterator();
                Localidad loc = null;
                while(it.hasNext() && b==0) {
                    loc = it.next();
                    if(loc.getNombre().equals(nom)){ b=1; }
                }
                cmbLocalidad.setEnabled(false);
                
            } catch (NumberFormatException a){
            } catch (Exception e){
            }
        }
    }//GEN-LAST:event_cmbLocalidadActionPerformed

    private void tblGrupopartesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGrupopartesMouseClicked
        
    }//GEN-LAST:event_tblGrupopartesMouseClicked

    private void tblGrupopartesProvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGrupopartesProvMouseClicked
    }//GEN-LAST:event_tblGrupopartesProvMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(tblGrupopartes.getRowCount()!=0 && tblGrupopartes.getSelectedRow() != -1){
            Object[]fila= new Object[1];
            fila[0] = tblGrupopartes.getValueAt(tblGrupopartes.getSelectedRow(),0).toString();
            miModeloTabla.removeRow(tblGrupopartes.getSelectedRow());
            miModeloTabla2.addRow(fila);

            tblGrupopartesProv.setModel(miModeloTabla2);
            tblGrupopartes.setModel(miModeloTabla);}
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAgregarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTodoActionPerformed
        DefaultTableModel modelo2=(DefaultTableModel) tblGrupopartes.getModel();
        Object[]fila= new Object[1];
        
        int filas=tblGrupopartes.getRowCount();
        for(int i=0; i<filas;i++){
            fila[0] = tblGrupopartes.getValueAt(0,0).toString();
            miModeloTabla2.addRow(fila);
            modelo2.removeRow(0);
        }
        
        tblGrupopartesProv.setModel(miModeloTabla2);        
    }//GEN-LAST:event_btnAgregarTodoActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        if(tblGrupopartesProv.getRowCount()!=0 && tblGrupopartesProv.getSelectedRow() != -1){
            Object[]fila= new Object[1];
            fila[0] = tblGrupopartesProv.getValueAt(tblGrupopartesProv.getSelectedRow(),0).toString();
            miModeloTabla2.removeRow(tblGrupopartesProv.getSelectedRow());
            miModeloTabla.addRow(fila);

            tblGrupopartes.setModel(miModeloTabla);
            tblGrupopartesProv.setModel(miModeloTabla2);}
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnQuitarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarTodoActionPerformed
        DefaultTableModel modelo2=(DefaultTableModel) tblGrupopartesProv.getModel();
        Object[]fila= new Object[1];
        
        int filas=tblGrupopartesProv.getRowCount();
        for(int i=0; i<filas;i++){
            fila[0] = tblGrupopartesProv.getValueAt(0,0).toString();
            miModeloTabla.addRow(fila);
            modelo2.removeRow(0);
        }
        
        tblGrupopartes.setModel(miModeloTabla);    
    }//GEN-LAST:event_btnQuitarTodoActionPerformed

    private void btnAceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar1ActionPerformed
        if(!cmbProvincia.isEnabled()){

            CargarComboProv();
            cmbProvincia.setEnabled(true);
            int c;

            miModeloCombo2 = new DefaultComboBoxModel();
            miModeloCombo2.addElement("");
            cmbLocalidad.setModel(miModeloCombo2);
            cmbLocalidad.setEnabled(false);
        }
    }//GEN-LAST:event_btnAceptar1ActionPerformed

    
    private void CargarComboProv(){
        List<Provincia> misProv = cLocal.dameProvincias();
        miModeloCombo.addElement("Seleccione una Provincia");
        for(Provincia miProvincia:misProv){
            miModeloCombo.addElement(miProvincia.getNombre());            
        }
        cmbProvincia.setModel(miModeloCombo);
    }
    
    private void CargarComboLoc(Provincia prov){
        List<Localidad> misLocalidades = prov.getLocalidades();
        
        miModeloCombo2.addElement("Seleccione una Localidad");
        for(Localidad miLocalidad:misLocalidades){
            miModeloCombo2.addElement(miLocalidad.getNombre());            
        }
        cmbLocalidad.setModel(miModeloCombo2);
    }
    
    
    public void CargarTabla(){
        List<GrupoParte> Lista= cLocal.dameGruposParte();
        Object[]fila= new Object[1];
        
        Collections.sort(Lista, new Comparator<GrupoParte>(){
            public int compare(GrupoParte s1, GrupoParte s2) {
                if (s1.getCodGrupo() < s2.getCodGrupo())
             return -1;
                else
             return 1;
            }
        });
        
        for(GrupoParte unGrupoParte:Lista){
            fila[0]=unGrupoParte.getNombre();
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
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAceptar1;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarTodo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnQuitarTodo;
    private javax.swing.JComboBox cmbLocalidad;
    private javax.swing.JComboBox cmbProvincia;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelNuevoCliente;
    private javax.swing.JPanel jPanelUbicacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbProvincia;
    private javax.swing.JLabel lblCUIT;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmail1;
    private javax.swing.JLabel lblGrupopartes;
    private javax.swing.JLabel lblGrupopartesProv;
    private javax.swing.JLabel lblLocalidad;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTable tblGrupopartes;
    private javax.swing.JTable tblGrupopartesProv;
    private javax.swing.JTextField txtCUIT;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRespFiscal;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
