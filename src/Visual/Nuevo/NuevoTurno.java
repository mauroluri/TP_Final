package Visual.Nuevo;

import LogicaDeNegocios.Actividad;
import LogicaDeNegocios.Ajuste;
import LogicaDeNegocios.Cliente;
import LogicaDeNegocios.DetalleActividad;
import LogicaDeNegocios.Diagnostico;
import LogicaDeNegocios.Mecanico;
import LogicaDeNegocios.OrdenTrabajo;
import LogicaDeNegocios.Turno;
import LogicaDeNegocios.Vehiculo;
import Visual.Controladora;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.*;

public class NuevoTurno extends javax.swing.JInternalFrame {

    Controladora cLocal;
    DefaultComboBoxModel miModeloCombo;
    DefaultComboBoxModel miModeloCombo2;
    DefaultTableModel miModeloTabla= new DefaultTableModel();
    DefaultTableModel miModeloTabla2= new DefaultTableModel();
    DefaultTableModel miModeloTabla3= new DefaultTableModel();
    DefaultTableModel miModeloTabla4= new DefaultTableModel();
    DefaultTableModel miModeloTabla5= new DefaultTableModel();
    List<DetalleActividad> nuevos;
    Date i;
    JInternalFrame MAPALocal;
    Time tiempo;
    Mecanico mecLoc;
    Date fechaLoc;
    
    public NuevoTurno(JInternalFrame MAPA, Controladora c, Date fecha, Mecanico mec) {
        initComponents();
        cLocal = c;
        mecLoc = mec;
        fechaLoc = fecha;
        String nom = c.dameEmpresas().get(0).getNombre();
        setTitle(nom+" - Nuevo Turno");
        MAPALocal = MAPA;
        miModeloTabla.addColumn("Hora Inicio");
        miModeloTabla.addColumn("Hora Fin");
        miModeloTabla2.addColumn("Nombre");
        miModeloTabla4.addColumn("Descripcion");
        miModeloTabla5.addColumn("Descripcion");
        Object[]fila= new Object[1];
        fila[0]="SELECCIONE UN CLIENTE";
        miModeloTabla3.addColumn("Dominio");
        miModeloTabla3.addRow(fila);
        tblVehic.setModel(miModeloTabla3);
        txtCod.setEnabled(false);
        txtCod.setText(String.valueOf(cLocal.dameTurnos().size()+1));
        txtHora.setEnabled(false);
        txtMin.setEnabled(false);
        
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = format1.format(fecha);
        txtFecha.setText(date1);
        txtFecha.setEnabled(false);
        CargarTablaHorarios(mecLoc, date1);
        CargarTablaClientes(mecLoc);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCategoria = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox();
        Tipo = new javax.swing.ButtonGroup();
        jPanelNuevoModelo = new javax.swing.JPanel();
        jPanelDNI6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTurnos = new javax.swing.JTable();
        lblDetAct = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        lblDetAct1 = new javax.swing.JLabel();
        lblDetAct2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblVehic = new javax.swing.JTable();
        jPanelDNI = new javax.swing.JPanel();
        lblDetAct3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblActividadesPend = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblActividadesPendTurno = new javax.swing.JTable();
        lblGrupopartesProv = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnAgregarTodo = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        btnQuitarTodo = new javax.swing.JButton();
        lblDescrip7 = new javax.swing.JLabel();
        txtMin = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        lblDescrip6 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();

        lblCategoria.setText("Categoria:");

        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });

        jPanelNuevoModelo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Turno", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 36), new java.awt.Color(0, 0, 0))); // NOI18N

        jPanelDNI6.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        tblTurnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblTurnos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblTurnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTurnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTurnos);

        lblDetAct.setText("Turnos disponibles:");

        lblNombre.setText("Fecha:");

        lblNombre1.setText("Código:");

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblClientes);

        lblDetAct1.setText("Clientes:");

        lblDetAct2.setText("Vehiculos:");

        tblVehic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblVehic.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblVehic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVehicMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblVehic);

        jPanelDNI.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        lblDetAct3.setText("Actividades pendientes:");

        tblActividadesPend.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblActividadesPend.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblActividadesPend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblActividadesPendMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblActividadesPend);

        tblActividadesPendTurno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblActividadesPendTurno.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblActividadesPendTurno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblActividadesPendTurnoMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblActividadesPendTurno);

        lblGrupopartesProv.setText("Actividades a realizar:");

        btnAgregar.setText("Agregar >");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnAgregarTodo.setText("Agregar todo >>");
        btnAgregarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTodoActionPerformed(evt);
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

        lblDescrip7.setText(":");

        txtMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinActionPerformed(evt);
            }
        });

        lblDescrip6.setText("Duración Total:");

        javax.swing.GroupLayout jPanelDNILayout = new javax.swing.GroupLayout(jPanelDNI);
        jPanelDNI.setLayout(jPanelDNILayout);
        jPanelDNILayout.setHorizontalGroup(
            jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDNILayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDNILayout.createSequentialGroup()
                        .addGroup(jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDNILayout.createSequentialGroup()
                                .addGroup(jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDetAct3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(209, 209, 209))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDNILayout.createSequentialGroup()
                        .addGroup(jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanelDNILayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnQuitarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanelDNILayout.createSequentialGroup()
                                        .addComponent(btnAgregarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(165, 165, 165))
                                    .addGroup(jPanelDNILayout.createSequentialGroup()
                                        .addComponent(lblDescrip6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblDescrip7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(207, 207, 207))
                    .addGroup(jPanelDNILayout.createSequentialGroup()
                        .addComponent(lblGrupopartesProv)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelDNILayout.setVerticalGroup(
            jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDNILayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDetAct3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregarTodo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnQuitarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnQuitar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGrupopartesProv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescrip7)
                    .addComponent(lblDescrip6))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelDNI6Layout = new javax.swing.GroupLayout(jPanelDNI6);
        jPanelDNI6.setLayout(jPanelDNI6Layout);
        jPanelDNI6Layout.setHorizontalGroup(
            jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDNI6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDNI6Layout.createSequentialGroup()
                        .addComponent(lblNombre1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDNI6Layout.createSequentialGroup()
                        .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDetAct)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblDetAct1)
                            .addComponent(lblDetAct2)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jPanelDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDNI6Layout.setVerticalGroup(
            jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDNI6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDNI6Layout.createSequentialGroup()
                        .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre1)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDNI6Layout.createSequentialGroup()
                                .addComponent(lblDetAct)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(jPanelDNI6Layout.createSequentialGroup()
                                .addComponent(lblDetAct1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblDetAct2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                    .addComponent(jPanelDNI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1414891160_Check.png"))); // NOI18N
        btnCancelar.setText("Listo");
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

        javax.swing.GroupLayout jPanelNuevoModeloLayout = new javax.swing.GroupLayout(jPanelNuevoModelo);
        jPanelNuevoModelo.setLayout(jPanelNuevoModeloLayout);
        jPanelNuevoModeloLayout.setHorizontalGroup(
            jPanelNuevoModeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoModeloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNuevoModeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelDNI6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNuevoModeloLayout.setVerticalGroup(
            jPanelNuevoModeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoModeloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDNI6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNuevoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNuevoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.hide();
        MAPALocal.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblTurnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTurnosMouseClicked
        
    }//GEN-LAST:event_tblTurnosMouseClicked

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        String nom = tblClientes.getValueAt(tblClientes.getSelectedRow(), 0).toString();
        
        List<Cliente> l = cLocal.dameUnMecanico(mecLoc.getDni()).getUnaSucursal().getVsCliente();
        int b=0;

        Iterator<Cliente> it = null;
        it = l.iterator();
        Cliente cli = null;
        while(it.hasNext() && b==0) {
            cli = it.next();
            if(cli.getNombre().equals(nom)){ b=1; }
        }
        CargarTablaVehic(cli);
    }//GEN-LAST:event_tblClientesMouseClicked

    private void tblVehicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVehicMouseClicked
        String dom = tblVehic.getValueAt(tblVehic.getSelectedRow(), 0).toString();
        List<Vehiculo> l = cLocal.dameVehiculos();
        int b=0;

        Iterator<Vehiculo> it = null;
        it = l.iterator();
        Vehiculo ve = null;
        while(it.hasNext() && b==0) {
            ve = it.next();
            if(ve.getDominio().equals(dom)){ b=1; }
        }
       
        List<OrdenTrabajo> or = new LinkedList<OrdenTrabajo>();
        int pos = ve.getVsTurnosPend().size();
        
        if(pos>0){
            if(!ve.getVsTurnosPend().get(pos-1).getVsOrdenTrabajo().isEmpty()){
                or = ve.getVsTurnosPend().get(pos-1).getVsOrdenTrabajo();
                OrdenTrabajo orTra = or.get(or.size()-1);
                if(orTra instanceof Ajuste){
                    LimpiarTablaActPend();
                    String err = "El vehículo sigue en la empresa. Aún no hay diagnóstico final para el nuevo turno.";
                    System.err.println(err);
                    JOptionPane.showMessageDialog(this, err, "", JOptionPane.ERROR_MESSAGE);
                } else {
                    Diagnostico diag = (Diagnostico) orTra;
                    if(diag.getInicial()){
                        LimpiarTablaActPend();
                        String err = "El vehículo sigue en la empresa. Aún no hay diagnóstico final para el nuevo turno.";
                        System.err.println(err);
                        JOptionPane.showMessageDialog(this, err, "", JOptionPane.ERROR_MESSAGE);
                    } else {
                        CargarTablaActPend(diag);
                    }
                }
                actualizaHora();
            } else {
                LimpiarTablaActPend();
                actualizaHora();
                System.out.println("hay turno pero sin ordenes creadas");
            }
        } else {
            LimpiarTablaActPend();
            String err = "Nunca se ha realizado un Diagnóstico.";
            System.err.println(err);
            JOptionPane.showMessageDialog(this, err, "", JOptionPane.ERROR_MESSAGE);
            actualizaHora();
        }
    }//GEN-LAST:event_tblVehicMouseClicked

    private void tblActividadesPendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblActividadesPendMouseClicked

    }//GEN-LAST:event_tblActividadesPendMouseClicked

    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed

    }//GEN-LAST:event_cmbCategoriaActionPerformed

    private void btnQuitarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarTodoActionPerformed
        DefaultTableModel modelo3=(DefaultTableModel) tblActividadesPendTurno.getModel();
        Object[]fila= new Object[1];

        int filas=tblActividadesPendTurno.getRowCount();
        for(int i=0; i<filas;i++){
            fila[0] = tblActividadesPendTurno.getValueAt(0,0).toString();
            miModeloTabla4.addRow(fila);
            modelo3.removeRow(0);
        }

        tblActividadesPend.setModel(miModeloTabla4);
        actualizaHora();
    }//GEN-LAST:event_btnQuitarTodoActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        if(tblActividadesPendTurno.getRowCount()!=0 && tblActividadesPendTurno.getSelectedRow() != -1){
            Object[]fila= new Object[1];
            fila[0] = tblActividadesPendTurno.getValueAt(tblActividadesPendTurno.getSelectedRow(),0).toString();
            miModeloTabla5.removeRow(tblActividadesPendTurno.getSelectedRow());
            miModeloTabla4.addRow(fila);

            tblActividadesPend.setModel(miModeloTabla4);
            tblActividadesPendTurno.setModel(miModeloTabla5);}
        actualizaHora();
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnAgregarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTodoActionPerformed
        DefaultTableModel modelo2=(DefaultTableModel) tblActividadesPend.getModel();
        Object[]fila= new Object[1];

        int filas=tblActividadesPend.getRowCount();
        for(int i=0; i<filas;i++){
            fila[0] = tblActividadesPend.getValueAt(0,0).toString();
            miModeloTabla5.addRow(fila);
            modelo2.removeRow(0);
        }

        tblActividadesPendTurno.setModel(miModeloTabla5);
        actualizaHora();
    }//GEN-LAST:event_btnAgregarTodoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(tblActividadesPend.getRowCount()!=0 && tblActividadesPend.getSelectedRow() != -1){
            Object[]fila= new Object[1];
            fila[0] = tblActividadesPend.getValueAt(tblActividadesPend.getSelectedRow(),0).toString();
            miModeloTabla4.removeRow(tblActividadesPend.getSelectedRow());
            miModeloTabla5.addRow(fila);

            tblActividadesPendTurno.setModel(miModeloTabla5);
            tblActividadesPend.setModel(miModeloTabla4);
            actualizaHora();}
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tblActividadesPendTurnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblActividadesPendTurnoMouseClicked

    }//GEN-LAST:event_tblActividadesPendTurnoMouseClicked

    private void txtMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinActionPerformed

    public void CargarTablaHorarios(Mecanico m, String date1){
        List<Turno> Lista= m.getVsTurno();
        Date f;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Object[]fila= new Object[2];
        
        int a = (m.getHoraFin().getHours() - m.getHoraInicio().getHours())*2;
        int b = (m.getHoraFin().getMinutes() - m.getHoraInicio().getMinutes());
        if(b==30) { a = a + 1;}
        else if (b==-30) {a = a - 1;}
        
        int hora = m.getHoraInicio().getHours();
        int min = m.getHoraInicio().getMinutes();
        for(int i = 0;i<a;i++){
            int ban = 0;
            for(Turno unTurno:Lista){
                String aaaaa;
                f = unTurno.getFecha();
                SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
                String date2 = format2.format(f);
                
                SimpleDateFormat format3 = new SimpleDateFormat("HH:mm");
                String horita = format3.format(unTurno.getHoraInicio());
                
                if (min == 0)
                    aaaaa= hora +":"+ min + "0";
                else
                    aaaaa= hora +":"+ min;
                
                if(date2.equals(date1) && horita.contains(aaaaa)){
                    int aa = (unTurno.getDuracionAprox().getHours())*2;
                    int bb = (unTurno.getDuracionAprox().getMinutes());
                    if(bb==30) { aa = aa + 1;}
                    else if (bb==-30) {aa = aa - 1;}
                    
                    for(int j = 0;j<aa;j++){
                        fila[0] = "-----";
                        min = min + 30;
                        if(min == 60){
                            hora = hora+1;
                            min = 0;
                        }
                        fila[1] = "-----";
                        miModeloTabla.addRow(fila);
                        i++;
                    }
                    ban = 1;
                }
            }
            if(ban==0){
                if (min == 0)
                    fila[0] = hora +":"+ min + "0";
                else
                    fila[0] = hora +":"+ min;
                min = min + 30;
                if(min == 60){
                    hora = hora+1;
                    min = 0;
                }
                if (min == 0)
                    fila[1] = hora +":"+ min + "0";
                else
                    fila[1] = hora +":"+ min;
                miModeloTabla.addRow(fila);
            } else {i--;}
        }
        tblTurnos.setModel(miModeloTabla);
    }
    
    
    public void CargarTablaClientes(Mecanico mec){
        
        List<Cliente> ListaCli= cLocal.dameClientes();
        Object[]fila= new Object[1];
        
        Collections.sort(ListaCli, new Comparator<Cliente>(){
            public int compare(Cliente s1, Cliente s2) {
                if (s1.getNombre().compareTo(s2.getNombre())<1)
             return -1;
                else
             return 1;
            }
        });
        
        for(Cliente unCliente:ListaCli){
            
            List<Cliente> l = cLocal.dameUnMecanico(mec.getDni()).getUnaSucursal().getVsCliente();
            int b=0;

            Iterator<Cliente> it = null;
            it = l.iterator();
            Cliente cli = null;
            while(it.hasNext() && b==0) {
                cli = it.next();
                if(cli.getDni() == unCliente.getDni()){ b=1; }
            }
            if(b==1) {     
                fila[0]=unCliente.getNombre();
                miModeloTabla2.addRow(fila);
            }
        }
        tblClientes.setModel(miModeloTabla2);
    }
    
    public void CargarTablaVehic(Cliente cli){
        DefaultTableModel miModeloTabla3= new DefaultTableModel();
        miModeloTabla3.addColumn("Dominio");
        List<Vehiculo> ListaVeh= cLocal.dameVehiculos();
        Object[]fila= new Object[1];
                
        Collections.sort(ListaVeh, new Comparator<Vehiculo>(){
            public int compare(Vehiculo s1, Vehiculo s2) {
                if (s1.getDominio().compareTo(s2.getDominio())<1)
             return -1;
                else
             return 1;
            }
        });
        
        for(Vehiculo unVehiculo:ListaVeh){
            
            List<Vehiculo> l = cli.getVsVehiculo();
            int b=0;

            Iterator<Vehiculo> it = null;
            it = l.iterator();
            Vehiculo ve = null;
            while(it.hasNext() && b==0) {
                ve = it.next();
                if(ve.getDominio().equals(unVehiculo.getDominio())){ b=1; }
            }
            if(b==1){
                fila[0]=ve.getDominio();
                miModeloTabla3.addRow(fila);
            }
        }
        tblVehic.setModel(miModeloTabla3);
    }
    
    public void LimpiarTabla(){
        DefaultTableModel modelo=(DefaultTableModel) tblTurnos.getModel();
        int filas=tblTurnos.getRowCount();
        for(int i=0; i<filas;i++){
            modelo.removeRow(0);
        }
    }
    
    public void LimpiarTablaActPend(){
        DefaultTableModel modelo=(DefaultTableModel) tblActividadesPend.getModel();
        int filas=tblActividadesPend.getRowCount();
        for(int i=0; i<filas;i++){
            modelo.removeRow(0);
        }
    }
    
    public void CargarTablaActPend(Diagnostico diag){
        List<Actividad> Lista= diag.getVsActividadesPendientes();
        System.out.println("Cargo Actividades pendientes");
        Object[]fila= new Object[1];
        
        Collections.sort(Lista, new Comparator<Actividad>(){
            public int compare(Actividad s1, Actividad s2) {
                if (s1.getNombre().compareTo(s2.getNombre())<1)
             return -1;
                else
             return 1;
            }
        });
        
        for(Actividad unaActividad:Lista){
            fila[0]=unaActividad.getNombre();
            miModeloTabla4.addRow(fila);
        }
        tblActividadesPend.setModel(miModeloTabla4);
    }
    
    public void actualizaHora(){
        
        int n, hora=0, min=0, cant=tblActividadesPendTurno.getRowCount();
        if(cant>0){
            for (n=0; n<cant; n++){
                int b=1;
                DetalleActividad detact = new DetalleActividad();
                List<DetalleActividad> lista= cLocal.dameDetallesActividad();
                Iterator<DetalleActividad> it;
                
                it = lista.iterator();
                while(it.hasNext()&& b==1) {
                    detact = it.next();
                    if(detact.getCod().equals(tblActividadesPendTurno.getValueAt(n, 0))){
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Tipo;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarTodo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnQuitarTodo;
    private javax.swing.JComboBox cmbCategoria;
    private javax.swing.JPanel jPanelDNI;
    private javax.swing.JPanel jPanelDNI6;
    private javax.swing.JPanel jPanelNuevoModelo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDescrip6;
    private javax.swing.JLabel lblDescrip7;
    private javax.swing.JLabel lblDetAct;
    private javax.swing.JLabel lblDetAct1;
    private javax.swing.JLabel lblDetAct2;
    private javax.swing.JLabel lblDetAct3;
    private javax.swing.JLabel lblGrupopartesProv;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JTable tblActividadesPend;
    private javax.swing.JTable tblActividadesPendTurno;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblTurnos;
    private javax.swing.JTable tblVehic;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtMin;
    // End of variables declaration//GEN-END:variables
}
