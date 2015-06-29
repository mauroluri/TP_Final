package Visual.Nuevo;

import LogicaDeNegocios.*;
import Persistencia.exceptions.PreexistingEntityException;
import Visual.Controladora;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class NuevaSucursal extends javax.swing.JInternalFrame {

    Controladora cLocal;
    DefaultComboBoxModel miModeloCombo;
    DefaultComboBoxModel miModeloCombo2;
    DefaultComboBoxModel miModeloCombo3;
    Date i, f;
    Localidad loc; 
    Calle calle;
    int cod;

    
    public NuevaSucursal(Controladora c) {
        initComponents();
        cLocal = c;
        String nom = c.dameEmpresas().get(0).getNombre();
        setTitle(nom+" - Nueva Sucursal");
        cmbCalle.setEnabled(false);
        cmbLocalidad.setEnabled(false);
        CargarComboProv();
        cod = cLocal.dameSucursales().size()+1;
        txtCodigo.setEnabled(false);
        txtCodigo.setText(String.valueOf(cod));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelNuevoCliente = new javax.swing.JPanel();
        jPanelDNI = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jPanelDatos = new javax.swing.JPanel();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblTelefono1 = new javax.swing.JLabel();
        lblHoraEnt = new javax.swing.JLabel();
        lblHoraSal = new javax.swing.JLabel();
        HoraEntra = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        MinEntra = new javax.swing.JTextField();
        HoraSale = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        MinSale = new javax.swing.JTextField();
        jPanelUbicacion = new javax.swing.JPanel();
        cmbProvincia = new javax.swing.JComboBox();
        lbProvincia = new javax.swing.JLabel();
        cmbLocalidad = new javax.swing.JComboBox();
        lblLocalidad = new javax.swing.JLabel();
        lblAltura = new javax.swing.JLabel();
        txtAltura = new javax.swing.JTextField();
        cmbCalle = new javax.swing.JComboBox();
        lblCalle = new javax.swing.JLabel();
        btnAceptar1 = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jPanelNuevoCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nueva Sucursal", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 36), new java.awt.Color(0, 0, 0))); // NOI18N

        jPanelDNI.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        lblCodigo.setText("Codigo:");

        javax.swing.GroupLayout jPanelDNILayout = new javax.swing.GroupLayout(jPanelDNI);
        jPanelDNI.setLayout(jPanelDNILayout);
        jPanelDNILayout.setHorizontalGroup(
            jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDNILayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCodigo)
                .addGap(18, 18, 18)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDNILayout.setVerticalGroup(
            jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDNILayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        lblTelefono.setText("Teléfono:");

        lblTelefono1.setText("Horario Laboral:");

        lblHoraEnt.setText("Apertura:");

        lblHoraSal.setText("Clausura:");

        jLabel1.setText(":");

        jLabel2.setText(":");

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
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(lblTelefono1)
                        .addGap(78, 78, 78)
                        .addComponent(lblHoraEnt)
                        .addGap(18, 18, 18)
                        .addComponent(HoraEntra, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MinEntra, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)))
                .addGap(54, 54, 54)
                .addComponent(lblHoraSal)
                .addGap(18, 18, 18)
                .addComponent(HoraSale, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MinSale, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(MinSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(HoraSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblHoraSal))
                    .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTelefono1)
                        .addComponent(HoraEntra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(MinEntra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(lblHoraEnt)))
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

        lblAltura.setText("Numero:");

        lblCalle.setText("Calle:");

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

        javax.swing.GroupLayout jPanelUbicacionLayout = new javax.swing.GroupLayout(jPanelUbicacion);
        jPanelUbicacion.setLayout(jPanelUbicacionLayout);
        jPanelUbicacionLayout.setHorizontalGroup(
            jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUbicacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCalle)
                    .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblLocalidad)
                        .addComponent(lbProvincia)))
                .addGap(18, 18, 18)
                .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cmbCalle, 0, 350, Short.MAX_VALUE)
                        .addComponent(cmbProvincia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cmbLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUbicacionLayout.createSequentialGroup()
                        .addComponent(lblAltura)
                        .addGap(18, 18, 18)
                        .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAceptar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(24, 24, 24)
                        .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLocalidad)))
                    .addComponent(btnAceptar1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCalle)
                        .addComponent(cmbCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblAltura)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addComponent(jPanelNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
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
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        int altura;
        long telefono;        
        
        if(control() && controlHora()&& controlSuc()){
            try {                 
                telefono = Long.valueOf(txtTelefono.getText());
                altura = Integer.parseInt(txtAltura.getText());                
                                
                cLocal.crearSucursal(cod, loc, telefono, altura, calle, i, f);
         
                this.hide();
                
                String err = "Se ha creado correctamente";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Carga Correcta", JOptionPane.PLAIN_MESSAGE);
            } catch (NumberFormatException a) {
                String err = "Los números ingresados son inválidos";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Error de Carga", JOptionPane.ERROR_MESSAGE);
            } catch (PreexistingEntityException p) {
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

    
    private boolean controlSuc(){
        boolean b=true;
        loc = obtenerLocalidad();
        calle = obtenerCalle(loc);
        List<Sucursal> sucs=cLocal.dameSucursales();
        for (Sucursal miSuc:sucs){
            if (miSuc.getUnaLocalidad().getCodigo()==loc.getCodigo() && 
               miSuc.getCalleSuc().getNombre().equals(calle.getNombre())){
                    b=false;
                    String err = "Ya existe una Sucursal en esa Localidad y Calle.";
                    System.err.println(err);
                    JOptionPane.showMessageDialog(this, err, "Error de Carga", JOptionPane.ERROR_MESSAGE);
            }            
        }
        return b;
    }
    
    private Localidad obtenerLocalidad(){
        String m = cmbProvincia.getSelectedItem().toString();
                List<Provincia> p = cLocal.dameProvincias();
                int bb=0;
                
                Iterator<Provincia> it = p.iterator();
                Provincia prov = null;
                while(it.hasNext() && bb==0) {
                    prov = it.next();
                    if(prov.getNombre().equals(m)){ bb=1; }
                }
                String nom = cmbLocalidad.getSelectedItem().toString();
                List<Localidad> l = prov.getLocalidades();
                int b=0;
                
                Iterator<Localidad> it2 = l.iterator();
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
                
                Iterator<Calle> it = l.iterator();
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

    
    private boolean control(){
        boolean ok=true;
        
        if (cmbProvincia.getSelectedIndex()==0) ok=false;
        if (cmbLocalidad.getSelectedIndex()==0) ok=false;
        if (cmbCalle.getSelectedIndex()==0) ok=false;
        if (txtAltura.getText().equals("")) ok=false;
        if (txtTelefono.getText().equals("")) ok=false;
        if (txtCodigo.getText().equals("")) ok=false;
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
    
    private void CargarComboCalle(Localidad loc){
        miModeloCombo3= new DefaultComboBoxModel();
        List<Calle> misCalles = loc.getVsCalle();
        
        miModeloCombo3.addElement("Seleccione una Calle");
        for(Calle miCalle:misCalles){
            miModeloCombo3.addElement(miCalle.getNombre());            
        }
        cmbCalle.setModel(miModeloCombo3);
    }
    
    private boolean controlHora(){
        boolean ok=true;
        try{
            Calendar cal = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY,Integer.parseInt(HoraEntra.getText()));
            cal.set(Calendar.MINUTE,Integer.parseInt(MinEntra.getText()));
            cal.set(Calendar.SECOND,0);
            i = cal.getTime();

            cal2.set(Calendar.HOUR_OF_DAY,Integer.parseInt(HoraSale.getText()));
            cal2.set(Calendar.MINUTE,Integer.parseInt(MinSale.getText()));
            cal2.set(Calendar.SECOND,0);
            f = cal2.getTime();
            
            if (i.getHours()<0 || i.getHours()>23 || f.getHours()<0 || f.getHours()>23){
                ok=false;
                String err = "Las horas ingresadas son inexistentes";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Horario erroneo", JOptionPane.PLAIN_MESSAGE);
            }
            if (i.getMinutes()<0 || i.getMinutes()>59 || f.getMinutes()<0 || f.getMinutes()>59){
                ok=false;
                String err = "Los minutos ingresados son inexistentes";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Horario erroneo", JOptionPane.PLAIN_MESSAGE);
            }
            if (i.after(f) || i.equals(f)){
                ok=false;
                String err = "La hora de clausura debe ser mayor a la hora de apertura";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Horario erroneo", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (NumberFormatException e){
                ok= false;
                String err = "La hora ingresada posee caracteres inválidos";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Horario erroneo", JOptionPane.PLAIN_MESSAGE);
        }
        return ok;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField HoraEntra;
    private javax.swing.JTextField HoraSale;
    private javax.swing.JTextField MinEntra;
    private javax.swing.JTextField MinSale;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAceptar1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cmbCalle;
    private javax.swing.JComboBox cmbLocalidad;
    private javax.swing.JComboBox cmbProvincia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelDNI;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelNuevoCliente;
    private javax.swing.JPanel jPanelUbicacion;
    private javax.swing.JLabel lbProvincia;
    private javax.swing.JLabel lblAltura;
    private javax.swing.JLabel lblCalle;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblHoraEnt;
    private javax.swing.JLabel lblHoraSal;
    private javax.swing.JLabel lblLocalidad;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTelefono1;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
