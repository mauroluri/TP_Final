
package Visual.Nuevo;

import LogicaDeNegocios.Localidad;
import LogicaDeNegocios.Provincia;
import LogicaDeNegocios.Sector;
import LogicaDeNegocios.Sucursal;
import LogicaDeNegocios.Taller;
import Persistencia.exceptions.PreexistingEntityException;
import Visual.Controladora;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class NuevoSector extends javax.swing.JInternalFrame {
    Controladora cLocal;
    DefaultComboBoxModel miModeloCombo, miModeloCombo2, miModeloCombo3;
    Date i, f;
    
    public NuevoSector(Controladora c) {
        initComponents();
        cLocal=c;
        cLocal = c;
        String nom = c.dameEmpresas().get(0).getNombre();
        setTitle(nom+" - Nuevo Empleado");
        cmbSucursal.setEnabled(false);
        cmbLocalidad.setEnabled(false);
        CargarComboProv();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnCancelar = new javax.swing.JButton();
        jPanelNuevaGeografia = new javax.swing.JPanel();
        jPanelUbicacion = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        cmbSucursal = new javax.swing.JComboBox();
        lblSucursal = new javax.swing.JLabel();
        rbtnAtencionPublico = new javax.swing.JRadioButton();
        rbtnDeposito = new javax.swing.JRadioButton();
        rbtnTaller = new javax.swing.JRadioButton();
        cmbProvincia = new javax.swing.JComboBox();
        lbProvincia = new javax.swing.JLabel();
        lblLocalidad = new javax.swing.JLabel();
        cmbLocalidad = new javax.swing.JComboBox();
        btnAceptar1 = new javax.swing.JButton();
        jPanelDatos = new javax.swing.JPanel();
        lblHorario = new javax.swing.JLabel();
        lblHoraEnt = new javax.swing.JLabel();
        lblHoraSal = new javax.swing.JLabel();
        txtHoraEntra = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtMinEntra = new javax.swing.JTextField();
        txtHoraSale = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMinSale = new javax.swing.JTextField();
        lblHoraMIN = new javax.swing.JLabel();
        lblHoraMAX = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();

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

        jPanelNuevaGeografia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Sector", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 36), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanelNuevaGeografia.setName(""); // NOI18N

        jPanelUbicacion.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        lblNombre.setText("Tipo de Sector:");

        cmbSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSucursalActionPerformed(evt);
            }
        });

        lblSucursal.setText("Sucursal:");

        buttonGroup1.add(rbtnAtencionPublico);
        rbtnAtencionPublico.setText("Atención al Publico");

        buttonGroup1.add(rbtnDeposito);
        rbtnDeposito.setText("Depósito");

        buttonGroup1.add(rbtnTaller);
        rbtnTaller.setText("Taller");

        cmbProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProvinciaActionPerformed(evt);
            }
        });

        lbProvincia.setText("Provincia:");

        lblLocalidad.setText("Localidad:");

        cmbLocalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLocalidadActionPerformed(evt);
            }
        });

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
                    .addGroup(jPanelUbicacionLayout.createSequentialGroup()
                        .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelUbicacionLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(rbtnAtencionPublico)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnDeposito)
                                .addGap(32, 32, 32)
                                .addComponent(rbtnTaller))
                            .addComponent(lblNombre))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelUbicacionLayout.createSequentialGroup()
                        .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblLocalidad)
                                .addComponent(lbProvincia))
                            .addComponent(lblSucursal))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbLocalidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbProvincia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbSucursal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnAceptar1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLocalidad)
                            .addComponent(cmbLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSucursal)))
                    .addComponent(btnAceptar1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnAtencionPublico)
                    .addComponent(rbtnDeposito)
                    .addComponent(rbtnTaller))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        lblHorario.setText("Horario Laboral:");

        lblHoraEnt.setText("Apertura:");

        lblHoraSal.setText("Clausura:");

        txtHoraEntra.setText("00");

        jLabel1.setText(":");

        txtMinEntra.setText("00");

        txtHoraSale.setText("00");

        jLabel2.setText(":");

        txtMinSale.setText("00");

        lblHoraMIN.setText("MIN ( - )");

        lblHoraMAX.setText("MAX ( - )");

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHorario)
                .addGap(41, 41, 41)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(lblHoraEnt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtHoraEntra, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMinEntra, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(lblHoraSal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtHoraSale, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMinSale, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHoraMIN)
                    .addComponent(lblHoraMAX))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblHorario)
                .addGap(4, 4, 4)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoraEntra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMinEntra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(lblHoraEnt)
                    .addComponent(lblHoraMIN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtHoraSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHoraSal)
                    .addComponent(lblHoraMAX))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelNuevaGeografiaLayout = new javax.swing.GroupLayout(jPanelNuevaGeografia);
        jPanelNuevaGeografia.setLayout(jPanelNuevaGeografiaLayout);
        jPanelNuevaGeografiaLayout.setHorizontalGroup(
            jPanelNuevaGeografiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevaGeografiaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNuevaGeografiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNuevaGeografiaLayout.setVerticalGroup(
            jPanelNuevaGeografiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevaGeografiaLayout.createSequentialGroup()
                .addContainerGap()
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNuevaGeografia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNuevaGeografia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.hide();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cmbSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSucursalActionPerformed
        if(!(cmbSucursal.getSelectedItem().toString().equals("Seleccione una Sucursal"))){
            Sucursal suc = null;
            try {
                int cod = Integer.parseInt(cmbSucursal.getSelectedItem().toString());
                List<Sucursal> l = cLocal.dameSucursales();
                int b=0;
                
                Iterator<Sucursal> it = null;
                it = l.iterator();
                while(it.hasNext() && b==0) {
                    suc = it.next();
                    if(suc.getCodSuc()==cod){ b=1; }
                }                
            } catch (NumberFormatException a){
            } catch (Exception e){
            }
            
            txtHoraEntra.setEnabled(true);
            txtHoraSale.setEnabled(true);
            txtMinEntra.setEnabled(true);
            txtMinSale.setEnabled(true);
            
            if(suc.getHoraInicio().getHours()<10){
                if(suc.getHoraInicio().getMinutes()<10)
                    lblHoraMIN.setText("MIN ( 0"+suc.getHoraInicio().getHours()+":0"+suc.getHoraInicio().getMinutes()+" ) ");
                else
                    lblHoraMIN.setText("MIN ( 0"+suc.getHoraInicio().getHours()+":"+suc.getHoraInicio().getMinutes()+" ) ");
            } else {
                if(suc.getHoraInicio().getMinutes()<10)
                    lblHoraMIN.setText("MIN ( "+suc.getHoraInicio().getHours()+":0"+suc.getHoraInicio().getMinutes()+" ) ");
                else
                    lblHoraMIN.setText("MIN ( "+suc.getHoraInicio().getHours()+":"+suc.getHoraInicio().getMinutes()+" ) ");
            }
            
            if(suc.getHoraFin().getHours()<10){
                if(suc.getHoraFin().getMinutes()<10)
                    lblHoraMAX.setText("MAX ( 0"+suc.getHoraFin().getHours()+":0"+suc.getHoraFin().getMinutes()+" ) ");
                else
                    lblHoraMAX.setText("MAX ( 0"+suc.getHoraFin().getHours()+":"+suc.getHoraFin().getMinutes()+" ) ");
            } else {
                if(suc.getHoraFin().getMinutes()<10)
                    lblHoraMAX.setText("MAX ( "+suc.getHoraFin().getHours()+":0"+suc.getHoraFin().getMinutes()+" ) ");
                else
                    lblHoraMAX.setText("MAX ( "+suc.getHoraFin().getHours()+":"+suc.getHoraFin().getMinutes()+" ) ");
            }
        }
        else{
            txtHoraEntra.setEnabled(false);
            txtHoraSale.setEnabled(false);
            txtMinEntra.setEnabled(false);
            txtMinSale.setEnabled(false);
            lblHoraMIN.setText("MIN ( - ) ");
            lblHoraMAX.setText("MAX ( - ) ");
            
        }
    }//GEN-LAST:event_cmbSucursalActionPerformed
         
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String nombre;
        int cod;
        
        if(control() && controlHora()){
            try {
                cod = nuevoCod();
                if(buttonGroup1.getSelection().equals(rbtnAtencionPublico.getModel()))
                    cLocal.crearRecepcion(cod, i, f);
                if(buttonGroup1.getSelection().equals(rbtnDeposito.getModel()))
                    cLocal.crearDeposito(cod, i, f);
                if(buttonGroup1.getSelection().equals(rbtnTaller.getModel()))
                    cLocal.crearTaller(cod, i, f);
                this.hide();

                String err = "Se ha creado correctamente";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Carga Correcta", JOptionPane.PLAIN_MESSAGE);
            //} catch (PreexistingEntityException p){
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

                CargarComboSuc(loc);
                cmbSucursal.setEnabled(true);
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
                cmbSucursal.setModel(miModeloCombo3);
                cmbSucursal.setEnabled(false);
            }
        }
        txtHoraEntra.setEnabled(false);
        txtHoraSale.setEnabled(false);
        txtMinEntra.setEnabled(false);
        txtMinSale.setEnabled(false);
        lblHoraMIN.setText("MIN ( - ) ");
        lblHoraMAX.setText("MAX ( - ) ");
    }//GEN-LAST:event_btnAceptar1ActionPerformed

    private boolean control(){
        boolean ok=true;        
        if (cmbSucursal.getSelectedIndex()==0) ok=false;
        if (!(rbtnAtencionPublico.isSelected() || rbtnDeposito.isSelected() || rbtnTaller.isSelected())) ok=false;
        return ok;
    }    
    
    private boolean controlHora(){
        boolean ok=true;
        try{
            Calendar cal = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY,Integer.parseInt(txtHoraEntra.getText()));
            cal.set(Calendar.MINUTE,Integer.parseInt(txtMinEntra.getText()));
            cal.set(Calendar.SECOND,0);
            i = cal.getTime();
            
            cal2.set(Calendar.HOUR_OF_DAY,Integer.parseInt(txtHoraSale.getText()));
            cal2.set(Calendar.MINUTE,Integer.parseInt(txtMinSale.getText()));
            cal2.set(Calendar.SECOND,0);
            f = cal2.getTime();
            
            if (i.getHours()<0 || i.getHours()>23 || f.getHours()<0 || f.getHours()>23){
                ok=false;
                String err = "Ingrese horarios válidos";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Horario erroneo", JOptionPane.PLAIN_MESSAGE);
            }
            if (i.getMinutes()<0 || i.getMinutes()>59 || f.getMinutes()<0 || f.getMinutes()>59){
                ok=false;
                String err = "Ingrese horarios válidos";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Horario erroneo", JOptionPane.PLAIN_MESSAGE);
            }
            if (i.after(f) || i.equals(f)){
                ok=false;
                String err = "La hora de clausura debe ser mayor a la hora de apertura";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Horario erroneo", JOptionPane.PLAIN_MESSAGE);
            }        
            Sucursal sucu = null;
            int nom = Integer.parseInt(cmbSucursal.getSelectedItem().toString());
            List<Sucursal> ada = cLocal.dameSucursales();
            int b=0;
            Iterator<Sucursal> it = ada.iterator();
            while(it.hasNext() && b==0) {
                sucu = it.next();
                if(sucu.getCodSuc()==nom){ b=1; }
            }
            if(i.getHours()<sucu.getHoraInicio().getHours()){
                ok=false;
                String err = "La hora de entrada es menor que la hora MINIMA de la Sucursal";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Horario erroneo", JOptionPane.PLAIN_MESSAGE);
            }
            if(i.getHours()==sucu.getHoraInicio().getHours() && i.getMinutes()<sucu.getHoraInicio().getMinutes()){   
                ok=false;
                String err = "La hora de entrada es menor que la hora MINIMA de la Sucursal";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Horario erroneo", JOptionPane.PLAIN_MESSAGE);
            }        
            if(f.getHours()>sucu.getHoraFin().getHours()){
                ok=false;
                String err = "La hora de clausura es mayor que la hora MAXIMA de la Sucursal";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Horario erroneo", JOptionPane.PLAIN_MESSAGE);
            }
            if(f.getHours()==sucu.getHoraFin().getHours() && f.getMinutes()>sucu.getHoraFin().getMinutes()){
                ok=false;
                String err = "La hora de clausura es mayor que la hora MAXIMA de la Sucursal";
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
    
    private int nuevoCod(){
        int cod;
        List<Sector> sectores= new LinkedList<Sector>();
        sectores.addAll(cLocal.dameDepositos());
        sectores.addAll(cLocal.dameTalleres());
        sectores.addAll(cLocal.dameRecepciones());
        cod= sectores.size() +1;
        return cod;
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
        miModeloCombo3= new DefaultComboBoxModel();
        List<Sucursal> misSucursales = cLocal.dameSucursales();
        miModeloCombo3.addElement("Seleccione una Sucursal");
        for(Sucursal miSucursal:misSucursales){
            
            miModeloCombo3.addElement(miSucursal.getCodSuc());            
        }
        cmbSucursal.setModel(miModeloCombo3);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAceptar1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbLocalidad;
    private javax.swing.JComboBox cmbProvincia;
    private javax.swing.JComboBox cmbSucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelNuevaGeografia;
    private javax.swing.JPanel jPanelUbicacion;
    private javax.swing.JLabel lbProvincia;
    private javax.swing.JLabel lblHoraEnt;
    private javax.swing.JLabel lblHoraMAX;
    private javax.swing.JLabel lblHoraMIN;
    private javax.swing.JLabel lblHoraSal;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblLocalidad;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSucursal;
    private javax.swing.JRadioButton rbtnAtencionPublico;
    private javax.swing.JRadioButton rbtnDeposito;
    private javax.swing.JRadioButton rbtnTaller;
    private javax.swing.JTextField txtHoraEntra;
    private javax.swing.JTextField txtHoraSale;
    private javax.swing.JTextField txtMinEntra;
    private javax.swing.JTextField txtMinSale;
    // End of variables declaration//GEN-END:variables
}
