package Visual.Nuevo;

import LogicaDeNegocios.Marca;
import LogicaDeNegocios.Modelo;
import Persistencia.exceptions.PreexistingEntityException;
import Visual.Controladora;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class NuevoModelo extends javax.swing.JInternalFrame {

    Controladora cLocal;
    DefaultComboBoxModel miModeloCombo;
    List<Modelo> m;
    Modelo mod;
    Marca mar;
    
    public NuevoModelo(Controladora c) {
        initComponents();
        cLocal = c;
        String nom = c.dameEmpresas().get(0).getNombre();
        setTitle(nom+" - Nuevo Modelo");
        CargarComboMar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelNuevoModelo = new javax.swing.JPanel();
        jPanelDNI = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblAño = new javax.swing.JLabel();
        txtAño = new javax.swing.JTextField();
        cmbMarca = new javax.swing.JComboBox();
        lblMarca = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        jPanelNuevoModelo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Modelo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 36), new java.awt.Color(0, 0, 0))); // NOI18N

        jPanelDNI.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        lblNombre.setText("Nombre:");

        lblAño.setText("Año:");

        cmbMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMarcaActionPerformed(evt);
            }
        });

        lblMarca.setText("Marca:");

        javax.swing.GroupLayout jPanelDNILayout = new javax.swing.GroupLayout(jPanelDNI);
        jPanelDNI.setLayout(jPanelDNILayout);
        jPanelDNILayout.setHorizontalGroup(
            jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDNILayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addComponent(lblMarca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDNILayout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(lblAño)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelDNILayout.setVerticalGroup(
            jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDNILayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAño))
                .addGap(18, 18, 18)
                .addGroup(jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMarca))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelNuevoModeloLayout = new javax.swing.GroupLayout(jPanelNuevoModelo);
        jPanelNuevoModelo.setLayout(jPanelNuevoModeloLayout);
        jPanelNuevoModeloLayout.setHorizontalGroup(
            jPanelNuevoModeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoModeloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNuevoModeloLayout.setVerticalGroup(
            jPanelNuevoModeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoModeloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDNI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNuevoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNuevoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        int anio;
        String nombre;
        if(control() && controlModelo() && mar!=null){
            try {                
                nombre = txtNombre.getText();
                anio = Integer.parseInt(txtAño.getText());
                
                cLocal.crearModelo(mar, nombre, anio);

                this.hide();

                String err = "Se ha creado correctamente";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Carga Correcta", JOptionPane.PLAIN_MESSAGE);
            } catch (NumberFormatException a) {
                String err = "Año invalido";
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

    private void cmbMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMarcaActionPerformed
        if(!(cmbMarca.getSelectedItem().toString().equals("Seleccione una Marca"))){
            try {
                String nom = cmbMarca.getSelectedItem().toString();
                List<Marca> p = cLocal.dameMarcas();
                int b=0;

                Iterator<Marca> it = p.iterator();
                mar = null;
                while(it.hasNext() && b==0) {
                    mar = it.next();
                    if(mar.getNombre().equals(nom)){ b=1; }
                }
                if (b==0){ mar=null;}
            } catch (Exception e){
            }
        }else{
            mar=null;
        }
    }//GEN-LAST:event_cmbMarcaActionPerformed

    
    private void CargarComboMar(){
        miModeloCombo= new DefaultComboBoxModel();
        List<Marca> misMar = cLocal.dameMarcas();
        miModeloCombo.addElement("Seleccione una Marca");
        for(Marca miMarca:misMar){
            miModeloCombo.addElement(miMarca.getNombre());            
        }
        cmbMarca.setModel(miModeloCombo);
    }
    
    private boolean control(){
        boolean b;
        if ((!txtNombre.getText().equals("")) && (!txtAño.getText().equals(""))){
            b=true;
        }else{
            b=false;
        }
        return b;
    }
    
    private boolean controlModelo(){
        m = cLocal.dameModelos();
        boolean b=true;
        Iterator<Modelo> it2 = m.iterator();
        while(it2.hasNext() && b) {
            mod = it2.next();
            if(mod.getNombre().equals(txtNombre.getText())){ 
                String err = "Ya existe ese Modelo";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Error de Carga", JOptionPane.ERROR_MESSAGE);
                b=false; 
            }
        }
        return b;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cmbMarca;
    private javax.swing.JPanel jPanelDNI;
    private javax.swing.JPanel jPanelNuevoModelo;
    private javax.swing.JLabel lblAño;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtAño;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
    }
