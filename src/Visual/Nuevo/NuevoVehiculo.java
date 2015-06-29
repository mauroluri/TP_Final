package Visual.Nuevo;

import LogicaDeNegocios.Cliente;
import LogicaDeNegocios.Garantia;
import LogicaDeNegocios.Modelo;
import LogicaDeNegocios.Segmento;
import LogicaDeNegocios.Vehiculo;
import Persistencia.exceptions.PreexistingEntityException;
import Visual.Controladora;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class NuevoVehiculo extends javax.swing.JInternalFrame {

    Controladora cLocal;
    DefaultComboBoxModel miModeloCombo = new DefaultComboBoxModel();
    DefaultComboBoxModel miModeloCombo2 = new DefaultComboBoxModel();
    DefaultComboBoxModel miModeloCombo3 ;
    Segmento seg= null;
    Modelo mod=null;
    Garantia gar= null;
    Vehiculo vehi;
    Cliente cli;
    long dni;
    JDesktopPane escc;
    
    
    public NuevoVehiculo(Controladora c, JDesktopPane esc) {
        initComponents();
        cLocal = c;
        escc = esc;
        String nom = c.dameEmpresas().get(0).getNombre();
        setTitle(nom+" - Nuevo Vehículo");
        CargarComboSegmento();
        CargarComboModelo();
        CargarComboGarantia();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelNuevoVehiculo = new javax.swing.JPanel();
        jPanelDNI = new javax.swing.JPanel();
        txtDNI = new javax.swing.JTextField();
        lblDNI = new javax.swing.JLabel();
        jPanelDatos = new javax.swing.JPanel();
        lblPatente = new javax.swing.JLabel();
        txtPatente = new javax.swing.JTextField();
        lblNroChasis = new javax.swing.JLabel();
        txtNroChasis = new javax.swing.JTextField();
        lblAño = new javax.swing.JLabel();
        txtAño = new javax.swing.JTextField();
        txtNromotor = new javax.swing.JTextField();
        lblNromotor = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        lblColor = new javax.swing.JLabel();
        txtPuertas = new javax.swing.JTextField();
        lblPuertas = new javax.swing.JLabel();
        jPanelUbicacion = new javax.swing.JPanel();
        cmbSegmento = new javax.swing.JComboBox();
        lblSegmento = new javax.swing.JLabel();
        cmbModelo = new javax.swing.JComboBox();
        lblModelo = new javax.swing.JLabel();
        jPanelGarantia = new javax.swing.JPanel();
        cmbGarantia = new javax.swing.JComboBox();
        lblGarantia = new javax.swing.JLabel();
        btnNewGarantia = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jPanelNuevoVehiculo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Vehículo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 36), new java.awt.Color(0, 0, 0))); // NOI18N

        jPanelDNI.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        lblDNI.setText("DNI del titular:");

        javax.swing.GroupLayout jPanelDNILayout = new javax.swing.GroupLayout(jPanelDNI);
        jPanelDNI.setLayout(jPanelDNILayout);
        jPanelDNILayout.setHorizontalGroup(
            jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDNILayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDNI)
                .addGap(18, 18, 18)
                .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDNILayout.setVerticalGroup(
            jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDNILayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDNI))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        lblPatente.setText("Patente:");

        lblNroChasis.setText("Número de chasis:");

        lblAño.setText("Año de fabricación:");

        lblNromotor.setText("Número de motor:");

        lblColor.setText("Color:");

        lblPuertas.setText("Puertas:");

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanelDatosLayout.createSequentialGroup()
                                .addComponent(lblPatente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPatente))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDatosLayout.createSequentialGroup()
                                .addComponent(lblAño)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(41, 41, 41)
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNroChasis)
                            .addComponent(lblNromotor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNromotor, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                            .addComponent(txtNroChasis)))
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(lblPuertas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPuertas, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(lblColor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtColor)))
                .addContainerGap())
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPatente)
                    .addComponent(txtPatente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNroChasis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNroChasis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAño)
                    .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNromotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNromotor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPuertas)
                    .addComponent(txtPuertas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblColor))
                .addContainerGap())
        );

        jPanelUbicacion.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        cmbSegmento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSegmentoActionPerformed(evt);
            }
        });

        lblSegmento.setText("Segmento:");

        cmbModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbModeloActionPerformed(evt);
            }
        });

        lblModelo.setText("Modelo:");

        javax.swing.GroupLayout jPanelUbicacionLayout = new javax.swing.GroupLayout(jPanelUbicacion);
        jPanelUbicacion.setLayout(jPanelUbicacionLayout);
        jPanelUbicacionLayout.setHorizontalGroup(
            jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUbicacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSegmento)
                    .addComponent(lblModelo))
                .addGap(18, 18, 18)
                .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbSegmento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbModelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelUbicacionLayout.setVerticalGroup(
            jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUbicacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSegmento)
                    .addComponent(cmbSegmento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblModelo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelGarantia.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        cmbGarantia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGarantiaActionPerformed(evt);
            }
        });

        lblGarantia.setText("Garantia:");

        btnNewGarantia.setText("Nueva Garantia");
        btnNewGarantia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewGarantiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelGarantiaLayout = new javax.swing.GroupLayout(jPanelGarantia);
        jPanelGarantia.setLayout(jPanelGarantiaLayout);
        jPanelGarantiaLayout.setHorizontalGroup(
            jPanelGarantiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGarantiaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGarantia)
                .addGap(18, 18, 18)
                .addComponent(cmbGarantia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnNewGarantia)
                .addContainerGap())
        );
        jPanelGarantiaLayout.setVerticalGroup(
            jPanelGarantiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGarantiaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelGarantiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGarantia)
                    .addComponent(btnNewGarantia))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelNuevoVehiculoLayout = new javax.swing.GroupLayout(jPanelNuevoVehiculo);
        jPanelNuevoVehiculo.setLayout(jPanelNuevoVehiculoLayout);
        jPanelNuevoVehiculoLayout.setHorizontalGroup(
            jPanelNuevoVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoVehiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNuevoVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelNuevoVehiculoLayout.createSequentialGroup()
                        .addComponent(jPanelDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanelGarantia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNuevoVehiculoLayout.setVerticalGroup(
            jPanelNuevoVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoVehiculoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelNuevoVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDNI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jPanelGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addComponent(jPanelNuevoVehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNuevoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        int año, puertas;
        String dominio, chasis, motor, color;
        
        if(control() && controlChasis() && controlMotor() && seg!=null && mod!=null && gar!=null && cli!=null){
            try {                
                año = Integer.parseInt(txtAño.getText());
                puertas= Integer.parseInt(txtPuertas.getText());
                dominio = txtPatente.getText();
                chasis = txtNroChasis.getText();
                motor = txtNromotor.getText();
                color = txtColor.getText();
                
                cLocal.crearVehiculo(seg, mod, gar, cli, dominio, chasis, motor, año, color, puertas);

                this.hide();
                
                String err = "Se ha creado correctamente";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Carga Correcta", JOptionPane.PLAIN_MESSAGE);
            
            } catch (NumberFormatException a){
                String err = "EL Año y Puertas debe componerse sólo de numeros";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Error de Carga", JOptionPane.ERROR_MESSAGE);
            } catch (PreexistingEntityException p){
                String err = "¡Numero de Chasis ya existe!";
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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    
    private void cmbSegmentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSegmentoActionPerformed
        if(!(cmbSegmento.getSelectedItem().toString().equals("Seleccione un Segmento"))){
            try {
                String nom = cmbSegmento.getSelectedItem().toString();
                List<Segmento> p = cLocal.dameSegmentos();
                int b=0;

                Iterator<Segmento> it = p.iterator();
                seg = null;
                while(it.hasNext() && b==0) {
                    seg = it.next();
                    if(seg.getNombre().equals(nom)){ b=1; }
                }
            } catch (Exception e){
            }
        }else{
            mod = null;
        }
    }//GEN-LAST:event_cmbSegmentoActionPerformed

    private void cmbModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbModeloActionPerformed
        if(!(cmbModelo.getSelectedItem().toString().equals("Seleccione un Modelo"))){
            try {
                String nom = cmbModelo.getSelectedItem().toString();
                List<Modelo> p = cLocal.dameModelos();
                int b=0;

                Iterator<Modelo> it = p.iterator();
                mod = null;
                while(it.hasNext() && b==0) {
                    mod = it.next();
                    if(mod.getNombre().equals(nom)){ b=1; }
                }
            } catch (Exception e){
            }
        }else{
            mod = null;
        }
    }//GEN-LAST:event_cmbModeloActionPerformed

    private void cmbGarantiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGarantiaActionPerformed
        if(!(cmbGarantia.getSelectedItem().toString().equals("Seleccione un Garantia"))){
            try {
                String nom = cmbGarantia.getSelectedItem().toString();
                List<Garantia> p = cLocal.dameGarantias();
                int b=0;

                Iterator<Garantia> it = p.iterator();
                gar = null;
                while(it.hasNext() && b==0) {
                    gar = it.next();
                    if(gar.getDetalle().equals(nom)){ b=1; }
                }
            } catch (Exception e){
            }
        }else{
            gar = null;
        }
    }//GEN-LAST:event_cmbGarantiaActionPerformed

    private void btnNewGarantiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewGarantiaActionPerformed
        NuevaGarantia cat= new NuevaGarantia(cLocal, this);
        
        Dimension desktopSize = escc.getSize();
        Dimension jInternalFrameSize = cat.getSize();
        cat.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height - jInternalFrameSize.height)/2);
        
        this.setVisible(false);
        escc.add(cat);
        cat.show();   
    }//GEN-LAST:event_btnNewGarantiaActionPerformed

    private boolean control(){
        boolean b=true;
        try {
            dni = Long.valueOf(txtDNI.getText()); 
            List<Cliente> clis= cLocal.dameClientes();
            Iterator<Cliente> it = clis.iterator();
            int a=0;
            cli=null;
            while(it.hasNext() && a==0){
                cli = it.next();
                if (cli.getDni()==dni){a=1;}
            }
            if (a==0){
                b=false;
                cli =null;
                String err = "No existe un Cliente con ese DNI";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Error de Carga", JOptionPane.ERROR_MESSAGE);
            }
            } catch (NumberFormatException a){
                String err = "EL DNI debe componerse sólo de numeros";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Error de Carga", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e){
                System.out.println("error en control()");
            }
        if (cmbSegmento.getSelectedItem().toString().equals("Seleccione un Segmento")) {b=false;}
        if (cmbModelo.getSelectedItem().toString().equals("Seleccione un Modelo")) {b=false;}
        if (txtColor.getText().equals("")){ b=false;}
        if (txtNroChasis.getText().equals("")){ b=false;}
        if (txtNromotor.getText().equals("")){ b=false;}
        if (txtAño.getText().equals("")){ b=false;}
        if (txtPuertas.getText().equals("")){ b=false;}
        if (txtPatente.getText().equals("")){ b=false;}
        return b;
    }
    private boolean controlChasis(){
        boolean b=true;
        if (txtNroChasis.getText().length()!=17){
            b=false;
            String err = "Numero de Chasis Invalido.\n ¡Debe tener 17 caracteres!";
            System.err.println(err);
            JOptionPane.showMessageDialog(this, err, "Error de Carga", JOptionPane.ERROR_MESSAGE);
        }                
        if (txtNroChasis.getText().contains("I") ||
            txtNroChasis.getText().contains("i") ||
            txtNroChasis.getText().contains("O") ||
            txtNroChasis.getText().contains("o") ||
            txtNroChasis.getText().contains("Q") ||
            txtNroChasis.getText().contains("q") ||
            txtNroChasis.getText().contains("Ñ") ||
            txtNroChasis.getText().contains("ñ")){
                b=false;
                String err = "Numero de Chasis Invalido. No se admiten los caracteres I, O, Q, Ñ.";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Error de Carga", JOptionPane.ERROR_MESSAGE);
        }
        return b;
    }
    private boolean controlMotor(){
        boolean b=true;
        List<Vehiculo> misVehiculos = cLocal.dameVehiculos();        
        Iterator<Vehiculo> it = misVehiculos.iterator();
        vehi = null;
        while(it.hasNext() && b) {
            vehi = it.next();
            if(vehi.getNroMotor().equals(txtNromotor.getText())){ 
                b=false; 
                String err = "Numero de Motor ya existente";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Error de Carga", JOptionPane.ERROR_MESSAGE);
            }
        }
        return b;
    }
    private void CargarComboSegmento(){
         List<Segmento> misSeg = cLocal.dameSegmentos();
        miModeloCombo.addElement("Seleccione un Segmento");
        for(Segmento miSeg:misSeg){
            miModeloCombo.addElement(miSeg.getNombre());            
        }
        cmbSegmento.setModel(miModeloCombo);
    }
    private void CargarComboModelo(){
        List<Modelo> misMod = cLocal.dameModelos();        
        miModeloCombo2.addElement("Seleccione un Modelo");
        for(Modelo miModelo:misMod){
            miModeloCombo2.addElement(miModelo.getNombre());            
        }
        cmbModelo.setModel(miModeloCombo2);
    }
    public void CargarComboGarantia(){
        miModeloCombo3= new DefaultComboBoxModel(); 
        List<Garantia> misGar = cLocal.dameGarantias();        
        miModeloCombo3.addElement("Seleccione una Garantia");
        for(Garantia miGarantia:misGar){
            miModeloCombo3.addElement(miGarantia.getDetalle());            
        }
        cmbGarantia.setModel(miModeloCombo3);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNewGarantia;
    private javax.swing.JComboBox cmbGarantia;
    private javax.swing.JComboBox cmbModelo;
    private javax.swing.JComboBox cmbSegmento;
    private javax.swing.JPanel jPanelDNI;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelGarantia;
    private javax.swing.JPanel jPanelNuevoVehiculo;
    private javax.swing.JPanel jPanelUbicacion;
    private javax.swing.JLabel lblAño;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblGarantia;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNroChasis;
    private javax.swing.JLabel lblNromotor;
    private javax.swing.JLabel lblPatente;
    private javax.swing.JLabel lblPuertas;
    private javax.swing.JLabel lblSegmento;
    private javax.swing.JTextField txtAño;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtNroChasis;
    private javax.swing.JTextField txtNromotor;
    private javax.swing.JTextField txtPatente;
    private javax.swing.JTextField txtPuertas;
    // End of variables declaration//GEN-END:variables
}
