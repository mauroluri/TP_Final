
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NuevoGrupoPartes extends javax.swing.JInternalFrame {

    Controladora cLocal;
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
        txtCodigo.setText(String.valueOf(cant+1));
        miModeloTabla.addColumn("Nombre");
        miModeloTabla2.addColumn("Nombre");
        miModeloTabla3.addColumn("Nombre");
        miModeloTabla4.addColumn("Nombre");
        CargarTabla(); 
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
        jScrollPane6 = new javax.swing.JScrollPane();
        tblModelosExistentes = new javax.swing.JTable();
        btnQuitarM = new javax.swing.JButton();
        btnAgregarM = new javax.swing.JButton();
        btnQuitarTodoM = new javax.swing.JButton();
        btnAgregarTodoM = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblModelosGrup = new javax.swing.JTable();
        lblModeloGrup = new javax.swing.JLabel();
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

        lblModelo.setText("Modelos:");

        tblModelosExistentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblModelosExistentes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblModelosExistentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblModelosExistentesMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblModelosExistentes);

        btnQuitarM.setText("< Quitar");
        btnQuitarM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarMActionPerformed(evt);
            }
        });

        btnAgregarM.setText("Agregar >");
        btnAgregarM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMActionPerformed(evt);
            }
        });

        btnQuitarTodoM.setText("<< Quitar todo");
        btnQuitarTodoM.setMaximumSize(new java.awt.Dimension(115, 23));
        btnQuitarTodoM.setMinimumSize(new java.awt.Dimension(115, 23));
        btnQuitarTodoM.setPreferredSize(new java.awt.Dimension(115, 23));
        btnQuitarTodoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarTodoMActionPerformed(evt);
            }
        });

        btnAgregarTodoM.setText("Agregar todo >>");
        btnAgregarTodoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTodoMActionPerformed(evt);
            }
        });

        tblModelosGrup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblModelosGrup.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblModelosGrup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblModelosGrupMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblModelosGrup);

        lblModeloGrup.setText("Modelos que conoce:");

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

        javax.swing.GroupLayout jPanelNuevoClienteLayout = new javax.swing.GroupLayout(jPanelNuevoCliente);
        jPanelNuevoCliente.setLayout(jPanelNuevoClienteLayout);
        jPanelNuevoClienteLayout.setHorizontalGroup(
            jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
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
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNuevoClienteLayout.createSequentialGroup()
                                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                                                .addComponent(btnQuitarM, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnAgregarM)
                                                .addGap(10, 10, 10))
                                            .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(btnQuitarTodoM, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnAgregarTodoM, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(jPanelNuevoClienteLayout.createSequentialGroup()
                                        .addComponent(lblModelo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblModeloGrup)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
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
                    .addComponent(lblModeloGrup))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelNuevoClienteLayout.createSequentialGroup()
                        .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnQuitarM)
                            .addComponent(btnAgregarM))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuitarTodoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarTodoM))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNuevoClienteLayout.createSequentialGroup()
                        .addGroup(jPanelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAutoparte)
                            .addComponent(lblAutoparteGrup))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblModelosExistentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblModelosExistentesMouseClicked

    }//GEN-LAST:event_tblModelosExistentesMouseClicked

    private void btnQuitarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarMActionPerformed
        if(tblModelosGrup.getRowCount()!=0 && tblModelosGrup.getSelectedRow() != -1){
            Object[]fila= new Object[1];
            fila[0] = tblModelosGrup.getValueAt(tblModelosGrup.getSelectedRow(),0).toString();
            miModeloTabla2.removeRow(tblModelosGrup.getSelectedRow());
            miModeloTabla.addRow(fila);

            tblModelosExistentes.setModel(miModeloTabla);
            tblModelosGrup.setModel(miModeloTabla2);}
    }//GEN-LAST:event_btnQuitarMActionPerformed

    private void btnAgregarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMActionPerformed
        if(tblModelosExistentes.getRowCount()!=0 && tblModelosExistentes.getSelectedRow() != -1){
            Object[]fila= new Object[1];
            fila[0] = tblModelosExistentes.getValueAt(tblModelosExistentes.getSelectedRow(),0).toString();
            miModeloTabla.removeRow(tblModelosExistentes.getSelectedRow());
            miModeloTabla2.addRow(fila);

            tblModelosGrup.setModel(miModeloTabla2);
            tblModelosExistentes.setModel(miModeloTabla);}
    }//GEN-LAST:event_btnAgregarMActionPerformed

    private void btnQuitarTodoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarTodoMActionPerformed
        DefaultTableModel modelo2=(DefaultTableModel) tblModelosGrup.getModel();
        Object[]fila= new Object[1];    
        
        int filas=tblModelosGrup.getRowCount();
        for(int i=0; i<filas;i++){
            fila[0] = tblModelosGrup.getValueAt(0,0).toString();
            miModeloTabla.addRow(fila);
            modelo2.removeRow(0);
        }        
        tblModelosExistentes.setModel(miModeloTabla);    
    }//GEN-LAST:event_btnQuitarTodoMActionPerformed

    private void btnAgregarTodoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTodoMActionPerformed
       DefaultTableModel modelo2=(DefaultTableModel) tblModelosExistentes.getModel();
        Object[]fila= new Object[1];
        
        int filas=tblModelosExistentes.getRowCount();
        for(int i=0; i<filas;i++){
            fila[0] = tblModelosExistentes.getValueAt(0,0).toString();
            miModeloTabla2.addRow(fila);
            modelo2.removeRow(0);
        }
        
        tblModelosGrup.setModel(miModeloTabla2);        
    }//GEN-LAST:event_btnAgregarTodoMActionPerformed

    private void tblModelosGrupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblModelosGrupMouseClicked

    }//GEN-LAST:event_tblModelosGrupMouseClicked

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
        if(control()){
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
                
                //Catch de los Modelos nuevos
                int cant2 = tblModelosGrup.getRowCount();
                List<Modelo> Todos2= cLocal.dameModelos();
                        
                LinkedList<Modelo> NuevosMod= new LinkedList<Modelo>();
                String nom2;
                Modelo mo;
                int bb;
                Iterator<Modelo> it2;
                for(int i=0; i<cant2;i++){
                    nom2 = tblModelosGrup.getValueAt(i,0).toString();
                    it2 = Todos2.iterator();
                    mo = null;
                    bb=0;
                    while(it2.hasNext() && bb==0) {
                        mo = it2.next();
                        if(mo.getNombre().equals(nom2)){ bb=1; }
                    }
                    NuevosMod.add(mo); 
                }
                
                List<GrupoParte> g = cLocal.dameGruposParte();
                int cod = g.size()+1;
                nombre = txtNombre.getText();
                cLocal.crearGrupoParte(nombre, cod, NuevosMod, Nuevos);
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

    public void CargarTabla(){
        List<Modelo> Lista= cLocal.dameModelos();
        Object[]fila= new Object[1];
        
        Collections.sort(Lista, new Comparator<Modelo>(){
            public int compare(Modelo s1, Modelo s2) {
                if (s1.getNombre().compareToIgnoreCase(s2.getNombre())<=0)
             return -1;
                else
             return 1;
            }
        });
        
        for(Modelo unModelo:Lista){
            fila[0]=unModelo.getNombre();
            miModeloTabla.addRow(fila);
        }
        tblModelosExistentes.setModel(miModeloTabla);
        
        //------------------------
        
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
            fila1[0]=unaAutoparte.getDescripcion();
            miModeloTabla3.addRow(fila1);
        }
        tblAutoparteExistente.setModel(miModeloTabla3);
    }
    
    private boolean control(){
        boolean ok=true;        
        if (txtNombre.getText().equals("")) ok=false;
        if (tblAutoparteGrup.getRowCount()== 0) ok=false;
        if (tblModelosGrup.getRowCount() == 0) ok=false;
        return ok;
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregarA;
    private javax.swing.JButton btnAgregarM;
    private javax.swing.JButton btnAgregarTodoA;
    private javax.swing.JButton btnAgregarTodoM;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnQuitarA;
    private javax.swing.JButton btnQuitarM;
    private javax.swing.JButton btnQuitarTodoA;
    private javax.swing.JButton btnQuitarTodoM;
    private javax.swing.JPanel jPanelDNI;
    private javax.swing.JPanel jPanelNuevoCliente;
    private javax.swing.JPanel jPanelUbicacion;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAutoparte;
    private javax.swing.JLabel lblAutoparteGrup;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblModeloGrup;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tblAutoparteExistente;
    private javax.swing.JTable tblAutoparteGrup;
    private javax.swing.JTable tblModelosExistentes;
    private javax.swing.JTable tblModelosGrup;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
