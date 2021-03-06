package Visual.Nuevo;

import LogicaDeNegocios.*;
import Persistencia.exceptions.PreexistingEntityException;
import Visual.Controladora;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class NuevoCliente extends javax.swing.JInternalFrame {

    Controladora cLocal;
    DefaultComboBoxModel miModeloCombo;
    DefaultComboBoxModel miModeloCombo2;
    DefaultComboBoxModel miModeloCombo3;
    DefaultComboBoxModel miModeloCombo4;
    
    public NuevoCliente(Controladora c) {
        initComponents();
        cLocal = c;
        String nom = c.dameEmpresas().get(0).getNombre();
        setTitle(nom+" - Nuevo Cliente");
        cmbCalle.setEnabled(false);
        cmbLocalidad.setEnabled(false);
        cmbSucursal.setEnabled(false);
        CargarComboProv();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelNuevoCliente = new javax.swing.JPanel();
        jPanelDNI = new javax.swing.JPanel();
        lblDNI = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        jPanelDatos = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblCUIT = new javax.swing.JLabel();
        txtCUIT = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblCalle = new javax.swing.JLabel();
        cmbCalle = new javax.swing.JComboBox();
        lblAltura = new javax.swing.JLabel();
        txtAltura = new javax.swing.JTextField();
        jPanelUbicacion = new javax.swing.JPanel();
        cmbProvincia = new javax.swing.JComboBox();
        lbProvincia = new javax.swing.JLabel();
        cmbLocalidad = new javax.swing.JComboBox();
        lblLocalidad = new javax.swing.JLabel();
        btnAceptar1 = new javax.swing.JButton();
        cmbSucursal = new javax.swing.JComboBox();
        lblCalle1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jPanelNuevoCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 36), new java.awt.Color(0, 0, 0))); // NOI18N

        jPanelDNI.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        lblDNI.setText("DNI:");

        javax.swing.GroupLayout jPanelDNILayout = new javax.swing.GroupLayout(jPanelDNI);
        jPanelDNI.setLayout(jPanelDNILayout);
        jPanelDNILayout.setHorizontalGroup(
            jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDNILayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDNI)
                .addGap(18, 18, 18)
                .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDNILayout.setVerticalGroup(
            jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDNILayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDNI)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        lblNombre.setText("Apellido, Nombres:");

        lblTelefono.setText("Teléfono:");

        lblCUIT.setText("CUIT:");

        lblEmail.setText("Correo electrónico:");

        lblCalle.setText("Calle:");

        lblAltura.setText("Numero:");

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(lblTelefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(lblCUIT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCUIT, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre))
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDatosLayout.createSequentialGroup()
                        .addComponent(lblCalle)
                        .addGap(18, 18, 18)
                        .addComponent(cmbCalle, 0, 360, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(lblAltura)
                        .addGap(18, 18, 18)
                        .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCUIT)
                    .addComponent(txtCUIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCalle)
                        .addComponent(cmbCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblAltura)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        btnAceptar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1414891197_Redo.png"))); // NOI18N
        btnAceptar1.setText("Modificar");
        btnAceptar1.setToolTipText("");
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

        cmbSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSucursalActionPerformed(evt);
            }
        });

        lblCalle1.setText("Sucursal:");

        javax.swing.GroupLayout jPanelUbicacionLayout = new javax.swing.GroupLayout(jPanelUbicacion);
        jPanelUbicacion.setLayout(jPanelUbicacionLayout);
        jPanelUbicacionLayout.setHorizontalGroup(
            jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUbicacionLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUbicacionLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lbProvincia))
                    .addComponent(lblLocalidad)
                    .addComponent(lblCalle1))
                .addGap(18, 18, 18)
                .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbProvincia, 0, 350, Short.MAX_VALUE)
                    .addComponent(cmbLocalidad, 0, 350, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(cmbSucursal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelUbicacionLayout.setVerticalGroup(
            jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUbicacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUbicacionLayout.createSequentialGroup()
                        .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbProvincia)
                            .addComponent(cmbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLocalidad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCalle1)))
                    .addComponent(btnAceptar1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelNuevoClienteLayout = new javax.swing.GroupLayout(jPanelNuevoCliente);
        jPanelNuevoCliente.setLayout(jPanelNuevoClienteLayout);
        jPanelNuevoClienteLayout.setHorizontalGroup(
            jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNuevoClienteLayout.setVerticalGroup(
            jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jPanelNuevoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
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
        String nombre, mail, cuit;
        int altura;
        long dni, telefono;
        Localidad loc; 
        Calle calle;
        
        if(control()){
            try {
                dni = Long.valueOf(txtDNI.getText()); 
                telefono = Long.valueOf(txtTelefono.getText());
                altura = Integer.parseInt(txtAltura.getText());
                nombre = txtNombre.getText();
                mail = txtEmail.getText();
                cuit = txtCUIT.getText();
                loc = obtenerLocalidad();
                calle = obtenerCalle(loc);
                                
                cLocal.crearCliente(nombre, dni, telefono, mail, cuit, altura, loc, calle);
                Sucursal suc = cLocal.dameUnaSucursal(Integer.parseInt(cmbSucursal.getSelectedItem().toString()));
                List<Cliente> clis = suc.getVsCliente();
                clis.add(cLocal.dameUnCliente(dni));
                cLocal.editarSucursal(suc.getCodSuc(), suc.getUnaLocalidad(), suc.getTelefono(), suc.getAltura(), suc.getCalleSuc(), 
                        suc.getBorrado(), suc.getVsTurno(), suc.getVsSector(), suc.getVsPedido(), suc.getVsEmpleado(), suc.getVsCalle(), 
                        suc.getHoraInicio(), suc.getHoraFin(), clis);
                
                this.hide();
                
                String err = "Se ha creado correctamente";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Carga Correcta", JOptionPane.PLAIN_MESSAGE);
            } catch (NumberFormatException a) {
                String err = "DNI Invalido";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Error de Carga", JOptionPane.ERROR_MESSAGE);
            } catch (PreexistingEntityException p) {
                String err = "Ya existe un cliente con ese DNI.";
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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    
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
    
    private Calle obtenerCalle(Localidad loc){
        String nom = cmbCalle.getSelectedItem().toString();
                List<Calle> l = loc.getVsCalle();
                int b=0;
                
                Iterator<Calle> it = null;
                it = l.iterator();
                Calle calle = null;
                while(it.hasNext() && b==0) {
                    calle = it.next();
                    if(calle.getNombre().equals(nom)){ b=1; }
                }
                return calle;
    }
    
    
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
                CargarComboCalle(loc);
                CargarComboSuc(loc);
                cmbSucursal.setEnabled(true);
                cmbCalle.setEnabled(true);
                cmbLocalidad.setEnabled(false);
                
            } catch (NumberFormatException a){
            } catch (Exception e){
            }
        }
    }//GEN-LAST:event_cmbLocalidadActionPerformed

    private void btnAceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar1ActionPerformed
        if(!cmbProvincia.isEnabled()){
            
            CargarComboProv();
            cmbProvincia.setEnabled(true);
            int c;
            
            miModeloCombo2 = new DefaultComboBoxModel();
            miModeloCombo2.addElement("");
            cmbLocalidad.setModel(miModeloCombo2);
            cmbLocalidad.setEnabled(false);
                        
            if(!cmbLocalidad.isEnabled()){
                miModeloCombo3 = new DefaultComboBoxModel();
                miModeloCombo3.addElement("");
                cmbCalle.setModel(miModeloCombo3);
                cmbCalle.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnAceptar1ActionPerformed

    private void cmbSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSucursalActionPerformed
           
    }//GEN-LAST:event_cmbSucursalActionPerformed

    
    private boolean control(){
        boolean ok=true;        
        int l= txtDNI.getText().length();
        
        if (cmbProvincia.getSelectedIndex()==0) ok=false;
        if (cmbLocalidad.getSelectedIndex()==0) ok=false;
        if (cmbCalle.getSelectedIndex()==0) ok=false;
        if (txtAltura.getText().equals("")) ok=false;
        if (txtEmail.getText().equals("")) ok=false;
        if (txtNombre.getText().equals("")) ok=false;
        if (txtTelefono.getText().equals("")) ok=false;
        if (txtCUIT.getText().equals("")) ok=false;
        if (txtDNI.getText().equals("")) ok=false;
        if (!(txtDNI.getText().equals(""))&& !(txtCUIT.getText().equals(""))){
             int c = Integer.parseInt(txtCUIT.getText().substring(2, l+2));
             int d = Integer.parseInt(txtDNI.getText());
             if (c!=d) {ok=false;}
        }else{
                ok=false;
            }
        
        return ok;
    }

    
    private void CargarComboProv(){
        miModeloCombo= new DefaultComboBoxModel();
        List<Provincia> misProv = cLocal.dameProvincias();
        miModeloCombo.addElement("Seleccione una Provincia");
        for(Provincia miProvincia:misProv){
            miModeloCombo.addElement(miProvincia.getNombre());            
        }
        cmbProvincia.setModel(miModeloCombo);
    }
    
    private void CargarComboLoc(Provincia prov){
        miModeloCombo2= new DefaultComboBoxModel();
        List<Localidad> misLocalidades = prov.getLocalidades();
        
        miModeloCombo2.addElement("Seleccione una Localidad");
        for(Localidad miLocalidad:misLocalidades){
            miModeloCombo2.addElement(miLocalidad.getNombre());            
        }
        cmbLocalidad.setModel(miModeloCombo2);
    }
    
    private void CargarComboSuc(Localidad loc){
        miModeloCombo4= new DefaultComboBoxModel();
        List<Sucursal> misSucursales = cLocal.dameSucursales();
        miModeloCombo4.addElement("Seleccione una Sucursal");
        for(Sucursal miSucursal:misSucursales){
            
            miModeloCombo4.addElement(miSucursal.getCodSuc());            
        }
        cmbSucursal.setModel(miModeloCombo4);
    }
    
    private void CargarComboCalle(Localidad loc){
        miModeloCombo3= new DefaultComboBoxModel();
        List<Calle> misCalles = loc.getVsCalle();
        
        miModeloCombo3.addElement("Seleccione una Calle");
        for(Calle miCalle:misCalles){
            miModeloCombo3.addElement(miCalle.getNombre());            
        }
        cmbCalle.setModel(miModeloCombo3);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAceptar1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cmbCalle;
    private javax.swing.JComboBox cmbLocalidad;
    private javax.swing.JComboBox cmbProvincia;
    private javax.swing.JComboBox cmbSucursal;
    private javax.swing.JPanel jPanelDNI;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelNuevoCliente;
    private javax.swing.JPanel jPanelUbicacion;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbProvincia;
    private javax.swing.JLabel lblAltura;
    private javax.swing.JLabel lblCUIT;
    private javax.swing.JLabel lblCalle;
    private javax.swing.JLabel lblCalle1;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblLocalidad;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JTextField txtCUIT;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
