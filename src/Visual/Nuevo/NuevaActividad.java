
package Visual.Nuevo;

import LogicaDeNegocios.Categoria;
import LogicaDeNegocios.DetalleActividad;
import LogicaDeNegocios.GrupoParte;
import Persistencia.exceptions.PreexistingEntityException;
import Visual.Controladora;
import java.sql.Time;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NuevaActividad extends javax.swing.JInternalFrame {

    Controladora cLocal;
    DefaultComboBoxModel miModeloCombo;
    DefaultComboBoxModel miModeloCombo2;
    DefaultTableModel miModeloTabla= new DefaultTableModel();
    DefaultTableModel miModeloTabla2= new DefaultTableModel();
    List<DetalleActividad> nuevos;
    Date i;
    Time tiempo;
    
    public NuevaActividad(Controladora c) {
        initComponents();
        cLocal = c;
        String nom = c.dameEmpresas().get(0).getNombre();
        setTitle(nom+" - Nueva Actividad");
        CargarComboCat();
        CargarComboGrupoPartes();
        miModeloTabla.addColumn("Detalles");
        miModeloTabla2.addColumn("Detalles");
        CargarTabla();
        txtHora.setEnabled(false);
        txtMin.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelNuevoModelo = new javax.swing.JPanel();
        jPanelDNI6 = new javax.swing.JPanel();
        lblDescrip6 = new javax.swing.JLabel();
        lblDescrip7 = new javax.swing.JLabel();
        lblDescrip8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalles = new javax.swing.JTable();
        btnQuitar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnQuitarTodo = new javax.swing.JButton();
        btnAgregarTodo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetallesAct = new javax.swing.JTable();
        lblGrupopartesProv = new javax.swing.JLabel();
        lblDetAct = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        txtMin = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox();
        lblGrupoParte = new javax.swing.JLabel();
        cmbGrupoParte = new javax.swing.JComboBox();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jPanelNuevoModelo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nueva Actividad", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 36), new java.awt.Color(0, 0, 0))); // NOI18N

        jPanelDNI6.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        lblDescrip6.setText("Duración Total:");

        lblDescrip7.setText(":");

        lblDescrip8.setText("(MIN: 30min   -   MAX: 8hs)");

        tblDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDetalles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetallesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDetalles);

        btnQuitar.setText("< Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar >");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
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

        tblDetallesAct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDetallesAct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetallesActMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDetallesAct);

        lblGrupopartesProv.setText("Detalles de la nueva Actividad:");

        lblDetAct.setText("Detalles preexistentes:");

        txtHora.setText("0");

        txtMin.setText("0");

        lblNombre.setText("Nombre:");

        lblCategoria.setText("Categoria:");

        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });

        lblGrupoParte.setText("Grupo Partes:");

        cmbGrupoParte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGrupoParteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDNI6Layout = new javax.swing.GroupLayout(jPanelDNI6);
        jPanelDNI6.setLayout(jPanelDNI6Layout);
        jPanelDNI6Layout.setHorizontalGroup(
            jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDNI6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDNI6Layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre))
                    .addGroup(jPanelDNI6Layout.createSequentialGroup()
                        .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDNI6Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDNI6Layout.createSequentialGroup()
                                .addComponent(btnQuitarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDNI6Layout.createSequentialGroup()
                                .addComponent(lblGrupopartesProv)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2)))
                    .addGroup(jPanelDNI6Layout.createSequentialGroup()
                        .addComponent(lblCategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(lblGrupoParte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbGrupoParte, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(jPanelDNI6Layout.createSequentialGroup()
                        .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDNI6Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblDescrip6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblDescrip8)
                                .addGap(18, 18, 18)
                                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDescrip7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelDNI6Layout.createSequentialGroup()
                                .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDNI6Layout.createSequentialGroup()
                                        .addComponent(lblDetAct)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane1))
                                .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDNI6Layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(btnAgregar))
                                    .addGroup(jPanelDNI6Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnAgregarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        jPanelDNI6Layout.setVerticalGroup(
            jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDNI6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGrupoParte)
                    .addComponent(cmbGrupoParte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(lblDetAct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDNI6Layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregarTodo)
                        .addGap(42, 42, 42))
                    .addGroup(jPanelDNI6Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(lblGrupopartesProv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelDNI6Layout.createSequentialGroup()
                        .addComponent(btnQuitar)
                        .addGap(18, 18, 18)
                        .addComponent(btnQuitarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescrip7)
                    .addComponent(lblDescrip6)
                    .addComponent(lblDescrip8))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelNuevoModeloLayout = new javax.swing.GroupLayout(jPanelNuevoModelo);
        jPanelNuevoModelo.setLayout(jPanelNuevoModeloLayout);
        jPanelNuevoModeloLayout.setHorizontalGroup(
            jPanelNuevoModeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoModeloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDNI6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNuevoModeloLayout.setVerticalGroup(
            jPanelNuevoModeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoModeloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDNI6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        btnCancelar.setText("Cerrar");
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
                .addComponent(jPanelNuevoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNuevoModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String cod;
        nuevos=new LinkedList<>();
        Categoria categ;
        GrupoParte grupo;
        
        if(control()&& controlTiempo()){
            try {
                obtenerDetalles();
                cod = txtNombre.getText();
                categ= obtenerCateg();
                grupo = obtenerGrupo();                                
                cLocal.crearActividad(cod, categ, i, grupo, nuevos);
                String err = "Se ha creado correctamente";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Carga Correcta", JOptionPane.PLAIN_MESSAGE);
            } catch (PreexistingEntityException p) {
                String err = "Ya existe ese código de Especialidad de Actividad.";
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

    private void tblDetallesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetallesMouseClicked

    }//GEN-LAST:event_tblDetallesMouseClicked

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        if(tblDetallesAct.getRowCount()!=0 && tblDetallesAct.getSelectedRow() != -1){
            Object[]fila= new Object[1];
            fila[0] = tblDetallesAct.getValueAt(tblDetallesAct.getSelectedRow(),0).toString();
            miModeloTabla2.removeRow(tblDetallesAct.getSelectedRow());
            miModeloTabla.addRow(fila);

            tblDetalles.setModel(miModeloTabla);
            tblDetallesAct.setModel(miModeloTabla2);}
            actualizaHora();
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(tblDetalles.getRowCount()!=0 && tblDetalles.getSelectedRow() != -1){
            Object[]fila= new Object[1];
            fila[0] = tblDetalles.getValueAt(tblDetalles.getSelectedRow(),0).toString();
            miModeloTabla.removeRow(tblDetalles.getSelectedRow());
            miModeloTabla2.addRow(fila);

            tblDetallesAct.setModel(miModeloTabla2);
            tblDetalles.setModel(miModeloTabla);
            actualizaHora();}
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnQuitarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarTodoActionPerformed
        DefaultTableModel modelo3=(DefaultTableModel) tblDetallesAct.getModel();
        Object[]fila= new Object[1];

        int filas=tblDetallesAct.getRowCount();
        for(int i=0; i<filas;i++){
            fila[0] = tblDetallesAct.getValueAt(0,0).toString();
            miModeloTabla.addRow(fila);
            modelo3.removeRow(0);
        }

        tblDetalles.setModel(miModeloTabla);
        actualizaHora();
    }//GEN-LAST:event_btnQuitarTodoActionPerformed

    private void btnAgregarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTodoActionPerformed
        DefaultTableModel modelo2=(DefaultTableModel) tblDetalles.getModel();
        Object[]fila= new Object[1];

        int filas=tblDetalles.getRowCount();
        for(int i=0; i<filas;i++){
            fila[0] = tblDetalles.getValueAt(0,0).toString();
            miModeloTabla2.addRow(fila);
            modelo2.removeRow(0);
        }

        tblDetallesAct.setModel(miModeloTabla2);
        actualizaHora();
    }//GEN-LAST:event_btnAgregarTodoActionPerformed

    private void tblDetallesActMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetallesActMouseClicked

    }//GEN-LAST:event_tblDetallesActMouseClicked

    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed
    }//GEN-LAST:event_cmbCategoriaActionPerformed

    private void cmbGrupoParteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGrupoParteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGrupoParteActionPerformed

    
    private boolean control(){
        boolean ok=true;
        if (txtNombre.getText().equals("")) ok=false;
        if (cmbCategoria.getSelectedIndex()==0) ok=false;
        if (cmbGrupoParte.getSelectedIndex()==0) ok=false;
        if (tblDetallesAct.getRowCount()==0)ok = false;
        
        return ok;
    }
    
    private boolean controlTiempo(){
        boolean ok=true;
        tiempoTotal();
        if ((i.getMinutes()<30&&i.getHours()==0) || (i.getHours()>8&&i.getMinutes()==30)){
            ok=false;
        }
        return ok;
    }
    
   private void obtenerDetalles(){
        DetalleActividad detact = new DetalleActividad();
        List<DetalleActividad> lista= cLocal.dameDetallesActividad();
        Iterator<DetalleActividad> it;
        int n;
        for (n=tblDetallesAct.getRowCount(); n>0; n--){
            int b=1;
            it = lista.iterator();
            while(it.hasNext()&& b==1) {
                detact = it.next();
                if(detact.getCod().equals(tblDetallesAct.getValueAt(n-1, 0))){ 
                    b=0;
                }
            }
            nuevos.add(detact);
        }        
   }
   
   
    public void actualizaHora(){
        
        int n, hora=0, min=0, cant=tblDetallesAct.getRowCount();
        if(cant>0){
            for (n=0; n<cant; n++){
                int b=1;
                DetalleActividad detact = new DetalleActividad();
                List<DetalleActividad> lista= cLocal.dameDetallesActividad();
                Iterator<DetalleActividad> it;
                
                it = lista.iterator();
                while(it.hasNext()&& b==1) {
                    detact = it.next();
                    if(detact.getCod().equals(tblDetallesAct.getValueAt(n, 0))){ 
                        System.out.println(n);
                        hora = hora + detact.getDuracion().getHours();
                        min = min + detact.getDuracion().getMinutes();
                        if(min==60){
                            min = 0;
                            hora = hora+1;
                        }
                        txtHora.setText(String.valueOf(hora));
                        txtMin.setText(String.valueOf(min));
                        b=0;
                    }
                }
            }
        } else {
            txtHora.setText("0");
            txtMin.setText("0");
        } 
    }

   private void tiempoTotal(){ 
       Calendar cal = Calendar.getInstance();
       cal.set(Calendar.HOUR_OF_DAY,Integer.parseInt(txtHora.getText()));
       cal.set(Calendar.MINUTE,Integer.parseInt(txtMin.getText()));
       cal.set(Calendar.SECOND,0);
       cal.set(Calendar.MILLISECOND,0);
       i = cal.getTime();
   }
   
   private GrupoParte obtenerGrupo(){
        String nom= cmbGrupoParte.getSelectedItem().toString();
        List<GrupoParte> misGrup = cLocal.dameGruposParte();
        GrupoParte grupp = null;
        int b=0;
        Iterator<GrupoParte> it = misGrup.iterator();
        while(it.hasNext() && b==0) {
            grupp = it.next();
            if(grupp.getNombre().equals(nom)){ b=1; }
        }
        return grupp;
    }
   
   private Categoria obtenerCateg(){
        String nom= cmbCategoria.getSelectedItem().toString();
        List<Categoria> misCat = cLocal.dameCategorias();
        Categoria cat = null;
        int b=0;
        Iterator<Categoria> it = misCat.iterator();
        while(it.hasNext() && b==0) {
            cat = it.next();
            if(cat.getNombre().equals(nom)){ b=1; }
        }
        return cat;
    }
   
    public void CargarTabla(){
        List<DetalleActividad> Lista= cLocal.dameDetallesActividad();
        Object[]fila= new Object[1];
        
        Collections.sort(Lista, new Comparator<DetalleActividad>(){
            public int compare(DetalleActividad s1, DetalleActividad s2) {
                if (s1.getCod().compareToIgnoreCase(s2.getCod()) <=0)
             return -1;
                else
             return 1;
            }
        });
        
        for(DetalleActividad unDetalleActividad:Lista){
            fila[0]=unDetalleActividad.getCod();
            miModeloTabla.addRow(fila);
        }
        tblDetalles.setModel(miModeloTabla);
    }
    
    private void CargarComboCat(){
        miModeloCombo= new DefaultComboBoxModel();
        List<Categoria> misCat = cLocal.dameCategorias();
        miModeloCombo.addElement("Seleccione una Categoria");
        for(Categoria miCategoria:misCat){
            miModeloCombo.addElement(miCategoria.getNombre());            
        }
        cmbCategoria.setModel(miModeloCombo);
    }
    
    private void CargarComboGrupoPartes(){
        miModeloCombo2= new DefaultComboBoxModel();
        List<GrupoParte> misGrupPartes = cLocal.dameGruposParte();
        miModeloCombo2.addElement("Seleccione un GrupoParte");
        for(GrupoParte miGrupoParte:misGrupPartes){
            miModeloCombo2.addElement(miGrupoParte.getNombre());            
        }
        cmbGrupoParte.setModel(miModeloCombo2);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarTodo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnQuitarTodo;
    private javax.swing.JComboBox cmbCategoria;
    private javax.swing.JComboBox cmbGrupoParte;
    private javax.swing.JPanel jPanelDNI6;
    private javax.swing.JPanel jPanelNuevoModelo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDescrip6;
    private javax.swing.JLabel lblDescrip7;
    private javax.swing.JLabel lblDescrip8;
    private javax.swing.JLabel lblDetAct;
    private javax.swing.JLabel lblGrupoParte;
    private javax.swing.JLabel lblGrupopartesProv;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tblDetalles;
    private javax.swing.JTable tblDetallesAct;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtMin;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
