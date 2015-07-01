package Visual.Nuevo;

import LogicaDeNegocios.*;
import Persistencia.exceptions.PreexistingEntityException;
import Visual.Controladora;
import java.util.Date;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NuevoInterno extends javax.swing.JInternalFrame {

    Controladora cLocal;
    DefaultTableModel miModeloTabla= new DefaultTableModel();
    DefaultTableModel miModeloTabla2= new DefaultTableModel();
    DefaultComboBoxModel miModeloCombo = new DefaultComboBoxModel();
    DefaultComboBoxModel miModeloCombo2;
    int cod;
    long codP;
    Empleado empLocal;
    
    public NuevoInterno(Controladora c, Empleado emp) {
        initComponents();
        cLocal = c;
        empLocal = emp;
        String nom = c.dameEmpresas().get(0).getNombre();
        setTitle(nom+" - Nuevo Pedido Interno");
        cod = cLocal.dameInternos().size()+1;
        txtCod.setEnabled(false);
        txtCod.setText(String.valueOf(cod));
        miModeloTabla.addColumn("Dominio");
        miModeloTabla2.addColumn("Nombre");
        cmbModelos.setEnabled(false);
        CargarComboMar();
        System.out.println(tblAutopartes.getSelectedRow());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelNuevoCliente = new javax.swing.JPanel();
        jPanelDatos = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        lblCUIT = new javax.swing.JLabel();
        txtCant = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAutopartes = new javax.swing.JTable();
        lblGrupopartes = new javax.swing.JLabel();
        lblGrupopartesProv = new javax.swing.JLabel();
        lblGrupopartes1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblVehiculos = new javax.swing.JTable();
        lbProvincia = new javax.swing.JLabel();
        cmbModelos = new javax.swing.JComboBox();
        lbProvincia1 = new javax.swing.JLabel();
        cmbMarcas = new javax.swing.JComboBox();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jPanelNuevoCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Pedido Interno", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 36), new java.awt.Color(0, 0, 0))); // NOI18N

        jPanelDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        lblNombre.setText("Código:");

        lblCUIT.setText("Cantidad:");

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCUIT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCUIT))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblAutopartes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblAutopartes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblAutopartes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAutopartesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAutopartes);

        lblGrupopartes.setText("Autoparte solicitada (Según modelo de vehículo seleccionado):");

        lblGrupopartes1.setText("Vehiculos:");

        tblVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblVehiculos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVehiculosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblVehiculos);

        lbProvincia.setText("Modelos:");

        cmbModelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbModelosActionPerformed(evt);
            }
        });

        lbProvincia1.setText("Marcas:");

        cmbMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMarcasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelNuevoClienteLayout = new javax.swing.GroupLayout(jPanelNuevoCliente);
        jPanelNuevoCliente.setLayout(jPanelNuevoClienteLayout);
        jPanelNuevoClienteLayout.setHorizontalGroup(
            jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                        .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGrupopartes)
                            .addComponent(lblGrupopartes1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblGrupopartesProv))
                    .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                        .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelDatos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelNuevoClienteLayout.createSequentialGroup()
                                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbProvincia)
                                    .addComponent(lbProvincia1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbMarcas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbModelos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelNuevoClienteLayout.setVerticalGroup(
            jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(lblGrupopartesProv)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNuevoClienteLayout.createSequentialGroup()
                .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProvincia1)
                    .addComponent(cmbMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProvincia)
                    .addComponent(cmbModelos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblGrupopartes1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblGrupopartes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jPanelNuevoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNuevoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        Mecanico m;
        int cant;
        Date dia;
        if(control()){
            if(empLocal instanceof Mecanico){
                m = (Mecanico) empLocal;
                try {
                    codP = Long.valueOf(txtCod.getText());
                    cant = Integer.valueOf(txtCant.getText());
                    
                    //Vehiculo
                    List<Vehiculo> vehiculos= cLocal.dameVehiculos();
                    String dom = tblVehiculos.getValueAt(tblVehiculos.getSelectedRow(), 0).toString();
                    int b=0;
                    Iterator<Vehiculo> it = vehiculos.iterator();
                    Vehiculo veh = null;
                    while(it.hasNext() && b==0) {
                        veh = it.next();
                        if(veh.getDominio().equals(dom)){ b=1; }
                    }
                    
                    //Autoparte
                    List<Autoparte> autopartes = new LinkedList<Autoparte>();
                        autopartes.addAll(cLocal.dameAccesorios());
                        autopartes.addAll(cLocal.dameEquipamientos());
                        autopartes.addAll(cLocal.dameRepuestos());
                    String desc = tblAutopartes.getValueAt(tblAutopartes.getSelectedRow(), 0).toString();
                    int bb=0;
                    Iterator<Autoparte> it2 = null;
                    it2 = autopartes.iterator();
                    Autoparte aut = null;
                    while(it.hasNext() && bb==0) {
                        aut = it2.next();
                        if(aut.getDescripcion().equals(desc)){ bb=1;}
                    }
                    
                    //fecha/hora
                    Calendar fecha = new GregorianCalendar();
                    dia = fecha.getTime();                    
                    
                    cLocal.crearInterno(m, veh, aut, codP, dia, cant);
                    this.hide();

                    String err = "Se ha creado correctamente";
                    System.err.println(err);
                    JOptionPane.showMessageDialog(this, err, "Carga Correcta", JOptionPane.PLAIN_MESSAGE);
                } catch (NumberFormatException a){
                    String err = "DNI Invalido";
                    System.err.println(err);
                    JOptionPane.showMessageDialog(this, err, "Error de Carga", JOptionPane.ERROR_MESSAGE);
               /* } catch (PreexistingEntityException p){
                    String err = "Ya existe un cliente con ese DNI.";
                    System.err.println(err);
                    JOptionPane.showMessageDialog(this, err, "Error de Carga", JOptionPane.ERROR_MESSAGE);*/
                } catch (Exception e){
                    System.out.println("Error de persistencia");
                    JOptionPane.showMessageDialog(this, "Error de persistencia", "Error de Carga", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                String err = "Un empleado que no sea 'mecanico' no debe estar aca!";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Error de Carga", JOptionPane.ERROR_MESSAGE);
            }
        }else {
            String err = "Complete todos los campos correctamente!";
            System.err.println(err);
            JOptionPane.showMessageDialog(this, err, "Error de Carga", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private boolean control(){
        boolean ok=true;
        
        if (cmbModelos.getSelectedIndex()==0) ok=false;
        if (cmbMarcas.getSelectedIndex()==0) ok=false;
        if (txtCant.getText().equals("") || Integer.parseInt(txtCant.getText())==0) ok=false;
        if(tblAutopartes.getRowCount()>0){
            if(tblAutopartes.getSelectedRow()<0){
                ok=false;
            }
        }
        if(tblVehiculos.getRowCount()>0){
            if(tblVehiculos.getSelectedRow()<0){
                ok=false;
            }
        }
        return ok;
    }
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVehiculosMouseClicked
    }//GEN-LAST:event_tblVehiculosMouseClicked

    private void tblAutopartesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAutopartesMouseClicked

    }//GEN-LAST:event_tblAutopartesMouseClicked

    private void cmbModelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbModelosActionPerformed
        if(!(cmbModelos.getSelectedItem().toString().equals("Seleccione un Modelo"))){
            try {
                String nom = cmbModelos.getSelectedItem().toString();
                List<Modelo> m = cLocal.dameModelos();
                int b=0;

                Iterator<Modelo> it = null;
                it = m.iterator();
                Modelo modelo = null;
                while(it.hasNext() && b==0) {
                    modelo = it.next();
                    if(modelo.getNombre().equals(nom)){ b=1; }
                }

                LimpiarTablaAut();
                LimpiarTablaVeh();
                CargarTablaVeh(modelo);
                CargarTablaAut(modelo);

            } catch (NumberFormatException a){
            } catch (Exception e){
            }
        } else { 
            LimpiarTablaVeh();
            LimpiarTablaAut(); }
    }//GEN-LAST:event_cmbModelosActionPerformed

    private void cmbMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMarcasActionPerformed
        if(!(cmbMarcas.getSelectedItem().toString().equals("Seleccione una Marca"))){
            try {
                String nom = cmbMarcas.getSelectedItem().toString();
                List<Marca> m = cLocal.dameMarcas();
                int b=0;

                Iterator<Marca> it = null;
                it = m.iterator();
                Marca marca = null;
                while(it.hasNext() && b==0) {
                    marca = it.next();
                    if(marca.getNombre().equals(nom)){ b=1; }
                }

                CargarComboMod(marca);
                LimpiarTablaAut();
                LimpiarTablaVeh();
                cmbModelos.setEnabled(true);

            } catch (NumberFormatException a){
            } catch (Exception e){
            }
        } else {
            miModeloCombo2 = new DefaultComboBoxModel();
            cmbModelos.setModel(miModeloCombo2);
            cmbModelos.setEnabled(false);
            LimpiarTablaAut();
            LimpiarTablaVeh();
        }
    }//GEN-LAST:event_cmbMarcasActionPerformed
    
    private void CargarComboMar(){
        List<Marca> misMar = cLocal.dameMarcas();
        miModeloCombo.addElement("Seleccione una Marca");
        for(Marca miMarca:misMar){
            miModeloCombo.addElement(miMarca.getNombre());            
        }
        cmbMarcas.setModel(miModeloCombo);
    }
        
    private void CargarComboMod(Marca m){
        miModeloCombo2 = new DefaultComboBoxModel();
        List<Modelo> misMod = cLocal.dameModelos();
        miModeloCombo2.addElement("Seleccione un Modelo");
        for(Modelo miModelo:misMod){
            if(miModelo.getUnaMarca().getNombre().equals(m.getNombre()))
                miModeloCombo2.addElement(miModelo.getNombre());            
        }
        cmbModelos.setModel(miModeloCombo2);
    }
     
    public void CargarTablaVeh(Modelo mod){
        List<Vehiculo> Lista= cLocal.dameVehiculos();
        Object[]fila= new Object[1];
        
        Collections.sort(Lista, new Comparator<Vehiculo>(){
            public int compare(Vehiculo s1, Vehiculo s2) {
                if (s1.getDominio().compareToIgnoreCase(s2.getDominio())<1)
             return -1;
                else
             return 1;
            }
        });
        
        for(Vehiculo unVehiculo:Lista){
            if(unVehiculo.getUnModelo().getNombre().equals(mod.getNombre())){
                fila[0]=unVehiculo.getDominio();
                miModeloTabla.addRow(fila);}
        }
        tblVehiculos.setModel(miModeloTabla);
    }
        
    public void CargarTablaAut(Modelo mod){
        
        List<Autoparte> Lista2 = new LinkedList<Autoparte>();
        Lista2.addAll(cLocal.dameAccesorios());
        Lista2.addAll(cLocal.dameEquipamientos());
        Lista2.addAll(cLocal.dameRepuestos());
        Object[]fila= new Object[1];
        
        Collections.sort(Lista2, new Comparator<Autoparte>(){
            public int compare(Autoparte s1, Autoparte s2) {
                if (s1.getDescripcion().compareToIgnoreCase(s2.getDescripcion())<0)
             return -1;
                else
             return 1;
            }
        });
        
        for(Autoparte unAutoparte:Lista2){
            List<Modelo> temp = new LinkedList<Modelo>();
            temp = unAutoparte.getVsModelo();
            
            for(Modelo unMod:temp){
                if(unMod.getNombre().equals(mod.getNombre())){
                    fila[0]=unAutoparte.getDescripcion();
                    miModeloTabla2.addRow(fila);}
            }
        }
        tblAutopartes.setModel(miModeloTabla2);
    }
    
    public void LimpiarTablaVeh(){
        DefaultTableModel modelo=(DefaultTableModel) tblVehiculos.getModel();
        int filas=tblVehiculos.getRowCount();
        for(int i=0; i<filas;i++){
            modelo.removeRow(0);
        }
        //tblVehiculos.setModel(modelo);
    }
    
    public void LimpiarTablaAut(){
        DefaultTableModel modelo2=(DefaultTableModel) tblAutopartes.getModel();
        int filas=tblAutopartes.getRowCount();
        for(int i=0; i<filas;i++){
            modelo2.removeRow(0);
        }
        //tblAutopartes.setModel(modelo2);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cmbMarcas;
    private javax.swing.JComboBox cmbModelos;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelNuevoCliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbProvincia;
    private javax.swing.JLabel lbProvincia1;
    private javax.swing.JLabel lblCUIT;
    private javax.swing.JLabel lblGrupopartes;
    private javax.swing.JLabel lblGrupopartes1;
    private javax.swing.JLabel lblGrupopartesProv;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tblAutopartes;
    private javax.swing.JTable tblVehiculos;
    private javax.swing.JTextField txtCant;
    private javax.swing.JTextField txtCod;
    // End of variables declaration//GEN-END:variables
}
