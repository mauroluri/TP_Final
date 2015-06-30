
package Visual.Nuevo;

import LogicaDeNegocios.Autoparte;
import LogicaDeNegocios.GrupoParte;
import LogicaDeNegocios.Modelo;
import Persistencia.exceptions.PreexistingEntityException;
import Visual.Controladora;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NuevoGrupoPartes extends javax.swing.JInternalFrame {

    Controladora cLocal;
    Modelo mod = null, Mode;
    DefaultComboBoxModel miModeloCombo;
    DefaultTableModel miModeloTabla= new DefaultTableModel();
    DefaultTableModel miModeloTabla2= new DefaultTableModel();    
    DefaultTableModel miModeloTabla3= new DefaultTableModel();    
    DefaultTableModel miModeloTabla4= new DefaultTableModel();
    String nombre;
    
    
    public NuevoGrupoPartes(Controladora c) {
        initComponents();
        cLocal = c;
        
        String nom = c.dameEmpresas().get(0).getNombre();
        setTitle(nom+" - Nuevo Grupo de partes");
        int cant= cLocal.dameGruposParte().size();
        txtCodigo.setEnabled(false);
        CargarComboModelo();
        txtCodigo.setText(String.valueOf(cant+1));
        miModeloTabla.addColumn("Nombre");
        miModeloTabla2.addColumn("Nombre");
        miModeloTabla3.addColumn("Nombre");
        miModeloTabla4.addColumn("Nombre");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelNuevoCliente = new javax.swing.JPanel();
        jPanelDNI = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jPanelUbicacion = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblModelo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblAutoparte = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblAutoparteExistente = new javax.swing.JTable();
        btnQuitarA = new javax.swing.JButton();
        btnAgregarA = new javax.swing.JButton();
        lblAutoparteGrup = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblAutoparteGrup = new javax.swing.JTable();
        btnQuitarTodoA = new javax.swing.JButton();
        btnAgregarTodoA = new javax.swing.JButton();
        cmbModelo = new javax.swing.JComboBox();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jPanelNuevoCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo GrupoParte", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 36), new java.awt.Color(0, 0, 0))); // NOI18N

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
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jPanelUbicacion.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        lblNombre.setText("Nombre:");

        javax.swing.GroupLayout jPanelUbicacionLayout = new javax.swing.GroupLayout(jPanelUbicacion);
        jPanelUbicacion.setLayout(jPanelUbicacionLayout);
        jPanelUbicacionLayout.setHorizontalGroup(
            jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUbicacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombre)
                .addContainerGap())
        );
        jPanelUbicacionLayout.setVerticalGroup(
            jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUbicacionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        lblModelo.setText("Modelo:");

        lblAutoparte.setText("Autopartes:");

        tblAutoparteExistente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblAutoparteExistente.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblAutoparteExistente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAutoparteExistenteMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tblAutoparteExistente);

        btnQuitarA.setText("< Quitar");
        btnQuitarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarAActionPerformed(evt);
            }
        });

        btnAgregarA.setText("Agregar >");
        btnAgregarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAActionPerformed(evt);
            }
        });

        lblAutoparteGrup.setText("Autopartes que contiene:");

        tblAutoparteGrup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblAutoparteGrup.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblAutoparteGrup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAutoparteGrupMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(tblAutoparteGrup);

        btnQuitarTodoA.setText("<< Quitar todo");
        btnQuitarTodoA.setMaximumSize(new java.awt.Dimension(115, 23));
        btnQuitarTodoA.setMinimumSize(new java.awt.Dimension(115, 23));
        btnQuitarTodoA.setPreferredSize(new java.awt.Dimension(115, 23));
        btnQuitarTodoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarTodoAActionPerformed(evt);
            }
        });

        btnAgregarTodoA.setText("Agregar todo >>");
        btnAgregarTodoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTodoAActionPerformed(evt);
            }
        });

        cmbModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbModeloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelNuevoClienteLayout = new javax.swing.GroupLayout(jPanelNuevoCliente);
        jPanelNuevoCliente.setLayout(jPanelNuevoClienteLayout);
        jPanelNuevoClienteLayout.setHorizontalGroup(
            jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNuevoClienteLayout.createSequentialGroup()
                        .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnQuitarA, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAgregarA)
                                        .addGap(10, 10, 10))
                                    .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnQuitarTodoA, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnAgregarTodoA, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                                .addComponent(lblAutoparte)
                                .addGap(346, 346, 346)))
                        .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAutoparteGrup)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                        .addComponent(jPanelDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                        .addComponent(lblModelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanelNuevoClienteLayout.setVerticalGroup(
            jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelUbicacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo)
                    .addComponent(cmbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNuevoClienteLayout.createSequentialGroup()
                        .addComponent(lblAutoparteGrup)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNuevoClienteLayout.createSequentialGroup()
                        .addComponent(lblAutoparte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnQuitarA)
                                    .addComponent(btnAgregarA))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnQuitarTodoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAgregarTodoA))
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblAutoparteExistenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAutoparteExistenteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblAutoparteExistenteMouseClicked

    private void btnQuitarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarAActionPerformed
        if(tblAutoparteGrup.getRowCount()!=0 && tblAutoparteGrup.getSelectedRow() != -1){
            Object[]fila= new Object[1];
            fila[0] = tblAutoparteGrup.getValueAt(tblAutoparteGrup.getSelectedRow(),0).toString();
            miModeloTabla4.removeRow(tblAutoparteGrup.getSelectedRow());
            miModeloTabla3.addRow(fila);

            tblAutoparteExistente.setModel(miModeloTabla3);
            tblAutoparteGrup.setModel(miModeloTabla4);}
    }//GEN-LAST:event_btnQuitarAActionPerformed

    private void btnAgregarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAActionPerformed
        if(tblAutoparteExistente.getRowCount()!=0 && tblAutoparteExistente.getSelectedRow() != -1){
            Object[]fila= new Object[1];
            fila[0] = tblAutoparteExistente.getValueAt(tblAutoparteExistente.getSelectedRow(),0).toString();
            miModeloTabla3.removeRow(tblAutoparteExistente.getSelectedRow());
            miModeloTabla4.addRow(fila);

            tblAutoparteGrup.setModel(miModeloTabla4);
            tblAutoparteExistente.setModel(miModeloTabla3);}
    }//GEN-LAST:event_btnAgregarAActionPerformed

    private void tblAutoparteGrupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAutoparteGrupMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblAutoparteGrupMouseClicked

    private void btnQuitarTodoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarTodoAActionPerformed
        DefaultTableModel modelo3=(DefaultTableModel) tblAutoparteGrup.getModel();
        Object[]fila= new Object[1];    
        
        int filas=tblAutoparteGrup.getRowCount();
        for(int i=0; i<filas;i++){
            fila[0] = tblAutoparteGrup.getValueAt(0,0).toString();
            miModeloTabla3.addRow(fila);
            modelo3.removeRow(0);
        }        
        tblAutoparteExistente.setModel(miModeloTabla3); 
        
    }//GEN-LAST:event_btnQuitarTodoAActionPerformed

    private void btnAgregarTodoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTodoAActionPerformed
        DefaultTableModel modelo4=(DefaultTableModel) tblAutoparteExistente.getModel();
        Object[]fila= new Object[1];
        
        int filas=tblAutoparteExistente.getRowCount();
        for(int i=0; i<filas;i++){
            fila[0] = tblAutoparteExistente.getValueAt(0,0).toString();
            miModeloTabla4.addRow(fila);
            modelo4.removeRow(0);
        }
        
        tblAutoparteGrup.setModel(miModeloTabla4);   
    }//GEN-LAST:event_btnAgregarTodoAActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if(control() && controlMod()){
            try {
                controlNombre();
                
                 //Catch de los Autoparte nuevos
                int cant = tblAutoparteGrup.getRowCount();
                List<Autoparte> Todos= new LinkedList<Autoparte>();
                    Todos.addAll(cLocal.dameAccesorios());
                    Todos.addAll(cLocal.dameRepuestos());
                    Todos.addAll(cLocal.dameEquipamientos());
                        
                LinkedList<Autoparte> Nuevos= new LinkedList<Autoparte>();
                String nom;
                Autoparte gp;
                int b;
                Iterator<Autoparte> it;
                for(int i=0; i<cant;i++){
                    nom = tblAutoparteGrup.getValueAt(i,0).toString();
                    it = Todos.iterator();
                    gp = null;
                    b=0;
                    while(it.hasNext() && b==0) {
                        gp = it.next();
                        if(gp.getDescripcion().equals(nom)){ b=1; }
                    }
                    Nuevos.add(gp); 
                }
                
                //Catch del modelo nuevo
                String m = cmbModelo.getSelectedItem().toString();
                
                List<Modelo> l = cLocal.dameModelos();
                int d=0;
                Iterator<Modelo> it2 = l.iterator();
                Modelo ma = null;
                while(it2.hasNext() && d==0) {
                    ma = it2.next();
                    if(ma.getNombre().equals(m)){ d=1; }
                }
                
                
                List<GrupoParte> g = cLocal.dameGruposParte();
                int cod = g.size()+1;
                nombre = txtNombre.getText();
                cLocal.crearGrupoParte(nombre, cod, ma, Nuevos);
                this.hide();

                String err = "Se ha creado correctamente";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Carga Correcta", JOptionPane.PLAIN_MESSAGE);
            } catch (PreexistingEntityException p) {
                String err = "Error de Pre-existencia";
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
        CargarTabla(mod); 
        }
        else{
        VaciarTabla();
        }
    }//GEN-LAST:event_cmbModeloActionPerformed

    public void CargarTabla(Modelo mod){
        
        List<Autoparte> Lista2 = new LinkedList<Autoparte>();
        Lista2.addAll(cLocal.dameAccesorios());
        Lista2.addAll(cLocal.dameEquipamientos());
        Lista2.addAll(cLocal.dameRepuestos());
        Object[]fila1= new Object[1];
        
        Collections.sort(Lista2, new Comparator<Autoparte>(){
            public int compare(Autoparte s1, Autoparte s2) {
                if (s1.getDescripcion().compareToIgnoreCase(s2.getDescripcion())<0)
             return -1;
                else
             return 1;
            }
        });
        
        for(Autoparte unaAutoparte:Lista2){
            if(unaAutoparte.getVsModelo().contains(mod)){
                fila1[0]=unaAutoparte.getDescripcion();
                miModeloTabla3.addRow(fila1);
            }
        }
        tblAutoparteExistente.setModel(miModeloTabla3);
    }
    
    public void VaciarTabla(){
        DefaultTableModel modelo =(DefaultTableModel) tblAutoparteGrup.getModel();
        int filas=tblAutoparteGrup.getRowCount();
        for(int i=0; i<filas;i++){
            modelo.removeRow(0);
        }
        DefaultTableModel modelo2 =(DefaultTableModel) tblAutoparteExistente.getModel();
        int filas2=tblAutoparteExistente.getRowCount();
        for(int i=0; i<filas2;i++){
            modelo2.removeRow(0);
        }
    }
    
    private boolean control(){
        boolean ok=true;        
        if (txtNombre.getText().equals("")) ok=false;
        if (tblAutoparteGrup.getRowCount()== 0) ok=false;
        return ok;
    }
    
    private boolean controlMod(){
        boolean b=true;
        /*List<Modelo> Mods=cLocal.dameModelos();
        for (Modelo miMod:Mods){
            if (miMod.getUnaLocalidad().getCodigo()==Mode.getCodigo() && 
               miMod.getCalleSuc().getNombre().equals(calle.getNombre())){
                    b=false;
                    String err = "Ya existe una Sucursal en esa Localidad y Calle.";
                    System.err.println(err);
                    JOptionPane.showMessageDialog(this, err, "Error de Carga", JOptionPane.ERROR_MESSAGE);
            }            
        }*/
        return b;
    }
    
    private boolean controlNombre() throws PreexistingEntityException{
        nombre = txtNombre.getText();
        List<GrupoParte> grupos= cLocal.dameGruposParte();
        Iterator<GrupoParte> it = grupos.iterator();
        GrupoParte parte = null;
        boolean b=true;
        while(it.hasNext() && b) {
            parte = it.next();
            if(parte.getNombre().equals(nombre)){
                b = false;
                throw new PreexistingEntityException("Ya existe Grupo de Partes con ese Nombre");
            }
        }
        return b;
    }
    
    private void CargarComboModelo(){
        miModeloCombo = new DefaultComboBoxModel();
        List<Modelo> misMod = cLocal.dameModelos();
        miModeloCombo.addElement("Seleccione un Modelo");
        for(Modelo miModelo:misMod){
            miModeloCombo.addElement(miModelo.getNombre());            
        }
        cmbModelo.setModel(miModeloCombo);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregarA;
    private javax.swing.JButton btnAgregarTodoA;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnQuitarA;
    private javax.swing.JButton btnQuitarTodoA;
    private javax.swing.JComboBox cmbModelo;
    private javax.swing.JPanel jPanelDNI;
    private javax.swing.JPanel jPanelNuevoCliente;
    private javax.swing.JPanel jPanelUbicacion;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAutoparte;
    private javax.swing.JLabel lblAutoparteGrup;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tblAutoparteExistente;
    private javax.swing.JTable tblAutoparteGrup;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
