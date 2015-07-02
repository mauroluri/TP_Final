
package Visual.Nuevo;

import LogicaDeNegocios.Categoria;
import LogicaDeNegocios.Cliente;
import LogicaDeNegocios.DetalleActividad;
import LogicaDeNegocios.GrupoParte;
import LogicaDeNegocios.Mecanico;
import LogicaDeNegocios.Turno;
import LogicaDeNegocios.Vehiculo;
import Persistencia.exceptions.PreexistingEntityException;
import Visual.Controladora;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.*;

public class Turnos extends javax.swing.JInternalFrame {

    Controladora cLocal;
    DefaultComboBoxModel miModeloCombo;
    DefaultComboBoxModel miModeloCombo2;
    DefaultTableModel miModeloTabla= new DefaultTableModel();
    DefaultTableModel miModeloTabla2= new DefaultTableModel();
    List<DetalleActividad> nuevos;
    Date i;
    JDesktopPane escLocal;
    Time tiempo;
    
    public Turnos(JDesktopPane esc, Controladora c) {
        initComponents();
        cLocal = c;
        String nom = c.dameEmpresas().get(0).getNombre();
        setTitle(nom+" - Turnos");
        miModeloTabla.addColumn("Cod");
        miModeloTabla.addColumn("Hora Inicio");
        miModeloTabla.addColumn("Hora Fin");
        miModeloTabla.addColumn("Cliente");
        miModeloTabla.addColumn("Vehículo");
        miModeloTabla2.addColumn("Mecanicos");
        miModeloTabla2.addColumn("Sucursal");
        DATOS.setVisible(false);
        txtDni.setEnabled(false);
        txtCod.setEnabled(false);
        txtDomi.setEnabled(false);
        escLocal = esc;
        btnDiag.setEnabled(false);
        btnAju.setEnabled(false);
        CargarTblMecanicos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelNuevoModelo = new javax.swing.JPanel();
        jPanelDNI6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTurnos = new javax.swing.JTable();
        lblDetAct = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        Fechita = new com.toedter.calendar.JDateChooser();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMecanicos = new javax.swing.JTable();
        btnVerTurnos = new javax.swing.JButton();
        DATOS = new javax.swing.JPanel();
        btnEditTurno = new javax.swing.JButton();
        txtCodTur = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        txtVehic = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        txtCli = new javax.swing.JLabel();
        txtDomi = new javax.swing.JTextField();
        btnBorrarTurno = new javax.swing.JButton();
        DATOS1 = new javax.swing.JPanel();
        txtNuevo = new javax.swing.JLabel();
        btnDiag = new javax.swing.JButton();
        btnAju = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jPanelNuevoModelo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Turnos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 36), new java.awt.Color(0, 0, 0))); // NOI18N

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

        lblDetAct.setText("Turnos:");

        lblNombre.setText("Fecha:");

        lblCategoria.setText("Mecanicos:");

        Fechita.setDateFormatString("yyyy-MM-dd");
        Fechita.setMaxSelectableDate(new java.util.Date(253370779286000L));
        Fechita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FechitaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FechitaMousePressed(evt);
            }
        });

        tblMecanicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblMecanicos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblMecanicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMecanicosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblMecanicos);

        btnVerTurnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1414891154_Search.png"))); // NOI18N
        btnVerTurnos.setText("Ver turnos");
        btnVerTurnos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerTurnos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVerTurnos.setIconTextGap(2);
        btnVerTurnos.setMaximumSize(new java.awt.Dimension(95, 73));
        btnVerTurnos.setMinimumSize(new java.awt.Dimension(95, 73));
        btnVerTurnos.setPreferredSize(new java.awt.Dimension(95, 73));
        btnVerTurnos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnVerTurnos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVerTurnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTurnosActionPerformed(evt);
            }
        });

        DATOS.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        DATOS.setToolTipText("");

        btnEditTurno.setText("Editar");
        btnEditTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditTurnoActionPerformed(evt);
            }
        });

        txtCodTur.setText("Cod. Turno:");

        txtVehic.setText("Vehiculo:");

        txtCli.setText("Cliente nro.:");

        btnBorrarTurno.setText("Borrar");
        btnBorrarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarTurnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DATOSLayout = new javax.swing.GroupLayout(DATOS);
        DATOS.setLayout(DATOSLayout);
        DATOSLayout.setHorizontalGroup(
            DATOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DATOSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DATOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBorrarTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(DATOSLayout.createSequentialGroup()
                        .addComponent(txtVehic)
                        .addGap(35, 35, 35)
                        .addComponent(txtDomi, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                    .addGroup(DATOSLayout.createSequentialGroup()
                        .addGroup(DATOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCli)
                            .addComponent(txtCodTur))
                        .addGap(18, 18, 18)
                        .addGroup(DATOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCod)
                            .addComponent(txtDni))))
                .addContainerGap())
        );
        DATOSLayout.setVerticalGroup(
            DATOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DATOSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DATOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodTur)
                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DATOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCli)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DATOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVehic)
                    .addComponent(txtDomi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btnEditTurno)
                .addGap(18, 18, 18)
                .addComponent(btnBorrarTurno)
                .addContainerGap())
        );

        DATOS1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        DATOS1.setToolTipText("");

        txtNuevo.setText("Nuevo turno:");

        btnDiag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Diagnostico.png"))); // NOI18N
        btnDiag.setText("Diagnóstico");
        btnDiag.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDiag.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDiag.setIconTextGap(2);
        btnDiag.setMaximumSize(new java.awt.Dimension(95, 73));
        btnDiag.setMinimumSize(new java.awt.Dimension(95, 73));
        btnDiag.setPreferredSize(new java.awt.Dimension(95, 73));
        btnDiag.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDiag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiagActionPerformed(evt);
            }
        });

        btnAju.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Ajuste.png"))); // NOI18N
        btnAju.setText("Ajuste");
        btnAju.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAju.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAju.setIconTextGap(2);
        btnAju.setMaximumSize(new java.awt.Dimension(95, 73));
        btnAju.setMinimumSize(new java.awt.Dimension(95, 73));
        btnAju.setPreferredSize(new java.awt.Dimension(95, 73));
        btnAju.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DATOS1Layout = new javax.swing.GroupLayout(DATOS1);
        DATOS1.setLayout(DATOS1Layout);
        DATOS1Layout.setHorizontalGroup(
            DATOS1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DATOS1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DATOS1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DATOS1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnDiag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAju, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNuevo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DATOS1Layout.setVerticalGroup(
            DATOS1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DATOS1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNuevo)
                .addGap(7, 7, 7)
                .addGroup(DATOS1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDiag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAju, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelDNI6Layout = new javax.swing.GroupLayout(jPanelDNI6);
        jPanelDNI6.setLayout(jPanelDNI6Layout);
        jPanelDNI6Layout.setHorizontalGroup(
            jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDNI6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDetAct)
                    .addGroup(jPanelDNI6Layout.createSequentialGroup()
                        .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCategoria)
                            .addComponent(lblNombre))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Fechita, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelDNI6Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnVerTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DATOS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DATOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDNI6Layout.setVerticalGroup(
            jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDNI6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDNI6Layout.createSequentialGroup()
                        .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Fechita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCategoria)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelDNI6Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btnVerTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(DATOS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDetAct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DATOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanelDNI6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNuevoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblTurnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTurnosMouseClicked
        if(tblTurnos.getRowCount()!=0 && tblTurnos.getSelectedRow() != -1 && 
                tblTurnos.getValueAt(tblTurnos.getSelectedRow(), 3) != "" && 
                tblTurnos.getValueAt(tblTurnos.getSelectedRow(), 4) != ""){
            String n = tblTurnos.getValueAt(tblTurnos.getSelectedRow(), 3).toString();
            List<Cliente> p = cLocal.dameClientes();
                int bb=0;
                Iterator<Cliente> it = null;
                it = p.iterator();
                Cliente cli = null;
                while(it.hasNext() && bb==0) {
                    cli = it.next();
                    if(cli.getNombre().equals(n)){ bb=1; }
                }
            txtDni.setText(String.valueOf(cli.getDni()));
            txtCod.setText(tblTurnos.getValueAt(tblTurnos.getSelectedRow(), 0).toString());
            txtDomi.setText(tblTurnos.getValueAt(tblTurnos.getSelectedRow(), 4).toString());
            DATOS.setVisible(true);
            btnAju.setEnabled(false);
            btnDiag.setEnabled(false);
        } else {
            DATOS.setVisible(false);
            btnAju.setEnabled(true);
            btnDiag.setEnabled(true);
        }
    }//GEN-LAST:event_tblTurnosMouseClicked

    private void tblMecanicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMecanicosMouseClicked
        LimpiarTabla();
        btnAju.setEnabled(false);
        btnDiag.setEnabled(false);
    }//GEN-LAST:event_tblMecanicosMouseClicked

    private void btnVerTurnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTurnosActionPerformed
        
        btnAju.setEnabled(false);
        btnDiag.setEnabled(false);
        if(tblMecanicos.getRowCount()>0){
            if(tblMecanicos.getSelectedRow()>=0 && Fechita.getCalendar()!=null){
                DATOS.setVisible(false);
                try {
                    Date d1;
                    //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    
                    String mec = tblMecanicos.getValueAt(tblMecanicos.getSelectedRow(),0).toString();
                    Mecanico mecan = new Mecanico();
                    List<Mecanico> lista= cLocal.dameMecanicos();
                    Iterator<Mecanico> it;
                    int n;
                    for (n=tblMecanicos.getRowCount(); n>0; n--){
                        int b=1;
                        it = lista.iterator();
                        while(it.hasNext()&& b==1) {
                            mecan = it.next();
                            if(mecan.getNombre().equals(mec)){ 
                                b=0;
                            }
                        }
                    }  
            
                   
                    Calendar cal = Calendar.getInstance();
                    cal = Fechita.getCalendar();
                    d1 = cal.getTime();
                    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                    String date1 = format1.format(d1);
                    
                    DefaultTableModel miModeloTabla= new DefaultTableModel();
                    LimpiarTabla();
                    CargarTabla(mecan, date1);
                } catch (Exception e) {
                }
            } else {
                String err = "Seleccione una fecha, y un mecánico de la lista.";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Error de Carga", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            String err = "No existen mecánicos.";
            System.err.println(err);
            JOptionPane.showMessageDialog(this, err, "Error de Lectura", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVerTurnosActionPerformed

    private void btnEditTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditTurnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditTurnoActionPerformed

    private void btnBorrarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarTurnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBorrarTurnoActionPerformed

    private void btnAjuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAjuActionPerformed

    private void btnDiagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiagActionPerformed
        Calendar cale = Calendar.getInstance();
        cale = Fechita.getCalendar();
        Date dd1 = cale.getTime();
        
        String mec = tblMecanicos.getValueAt(tblMecanicos.getSelectedRow(),0).toString();
        Mecanico mecan = new Mecanico();
        List<Mecanico> lista= cLocal.dameMecanicos();
        Iterator<Mecanico> it3;
        int nop;
        for (nop=tblMecanicos.getRowCount(); nop>0; nop--){
            int b=1;
            it3 = lista.iterator();
            while(it3.hasNext()&& b==1) {
                mecan = it3.next();
                if(mecan.getNombre().equals(mec)){ 
                    b=0;
                }
            }
        }  
        
        NuevoTurnoDiag nt = new NuevoTurnoDiag(this, cLocal, dd1, mecan);
        Dimension desktopSize = escLocal.getSize();
        Dimension jInternalFrameSize = nt.getSize();
        nt.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height - jInternalFrameSize.height)/2);
        
        escLocal.add(nt);
        nt.show();
        DefaultTableModel miModeloTabla= new DefaultTableModel();
        LimpiarTabla();
        btnAju.setEnabled(false);
        btnDiag.setEnabled(false);
        this.hide();
    }//GEN-LAST:event_btnDiagActionPerformed

    private void FechitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FechitaMouseClicked
    }//GEN-LAST:event_FechitaMouseClicked

    private void FechitaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FechitaMousePressed
    }//GEN-LAST:event_FechitaMousePressed

    public void CargarTabla(Mecanico m, String date1){
        List<Turno> Lista= m.getVsTurno();
        Date f;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Object[]fila= new Object[5];
        
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
                System.out.println(unTurno.getCodigo());
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
                        if (min == 0)
                            fila[1] = hora +":"+ min + "0";
                        else
                            fila[1] = hora +":"+ min;
                        min = min + 30;
                        if(min == 60){
                            hora = hora+1;
                            min = 0;
                        }
                        if (min == 0)
                            fila[2] = hora +":"+ min + "0";
                        else
                            fila[2] = hora +":"+ min;
                        fila[0] = unTurno.getCodigo();
                        fila[3] = unTurno.getUnCliente().getNombre();
                        fila[4] = unTurno.getUnVehiculo().getDominio();
                        miModeloTabla.addRow(fila);
                        i++;
                    }
                    ban = 1;
                }
            }
            if(ban==0){
                if (min == 0)
                    fila[1] = hora +":"+ min + "0";
                else
                    fila[1] = hora +":"+ min;
                min = min + 30;
                if(min == 60){
                    hora = hora+1;
                    min = 0;
                }
                if (min == 0)
                    fila[2] = hora +":"+ min + "0";
                else
                    fila[2] = hora +":"+ min;
                
                fila[0] = "**Disponible";
                fila[3] = "";
                fila[4] = "";
                miModeloTabla.addRow(fila);
            } else {i--;}
        }
        tblTurnos.setModel(miModeloTabla);
    }
    public void CargarTblMecanicos(){
        List<Mecanico> Lista= cLocal.dameMecanicos();
        int cant;
        Date ini;
        Object[]fila= new Object[2];
        for(Mecanico unMecanico:Lista){
            fila[0]=unMecanico.getNombre();
            fila[1]=unMecanico.getUnaSucursal().getCodSuc();
            miModeloTabla2.addRow(fila);
        }
        tblMecanicos.setModel(miModeloTabla2);
    }
    
    public void LimpiarTabla(){
        DefaultTableModel modelo=(DefaultTableModel) tblTurnos.getModel();
        int filas=tblTurnos.getRowCount();
        for(int i=0; i<filas;i++){
            modelo.removeRow(0);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DATOS;
    private javax.swing.JPanel DATOS1;
    private com.toedter.calendar.JDateChooser Fechita;
    private javax.swing.JButton btnAju;
    private javax.swing.JButton btnBorrarTurno;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDiag;
    private javax.swing.JButton btnEditTurno;
    private javax.swing.JButton btnVerTurnos;
    private javax.swing.JPanel jPanelDNI6;
    private javax.swing.JPanel jPanelNuevoModelo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDetAct;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tblMecanicos;
    private javax.swing.JTable tblTurnos;
    private javax.swing.JLabel txtCli;
    private javax.swing.JTextField txtCod;
    private javax.swing.JLabel txtCodTur;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtDomi;
    private javax.swing.JLabel txtNuevo;
    private javax.swing.JLabel txtVehic;
    // End of variables declaration//GEN-END:variables
}
