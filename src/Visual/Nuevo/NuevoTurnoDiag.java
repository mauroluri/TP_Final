package Visual.Nuevo;

import LogicaDeNegocios.Actividad;
import LogicaDeNegocios.Ajuste;
import LogicaDeNegocios.Cliente;
import LogicaDeNegocios.DetalleActividad;
import LogicaDeNegocios.Diagnostico;
import LogicaDeNegocios.Mecanico;
import LogicaDeNegocios.OrdenTrabajo;
import LogicaDeNegocios.Sucursal;
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

public class NuevoTurnoDiag extends javax.swing.JInternalFrame {

    Controladora cLocal;
    DefaultComboBoxModel miModeloCombo;
    DefaultComboBoxModel miModeloCombo2;
    DefaultTableModel miModeloTabla= new DefaultTableModel();
    DefaultTableModel miModeloTabla2= new DefaultTableModel();
    List<DetalleActividad> nuevos;
    Date i;
    JInternalFrame MAPALocal;
    Time tiempo;
    Mecanico mecLoc;
    Date fechaLoc;
    
    public NuevoTurnoDiag(JInternalFrame MAPA, Controladora c, Date fecha, Mecanico mec) {
        initComponents();
        cLocal = c;
        mecLoc = mec;
        fechaLoc = fecha;
        String nom = c.dameEmpresas().get(0).getNombre();
        setTitle(nom+" - Nuevo Turno");
        MAPALocal = MAPA;
        miModeloTabla.addColumn("Hora Inicio");
        miModeloTabla2.addColumn("Nombre");
        tblVehic.setVisible(false);
        txtCod.setEnabled(false);
        txtCod.setText(String.valueOf(cLocal.dameTurnos().size()+1));
        txtFin.setEnabled(false);
        
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = format1.format(fecha);
        txtFecha.setText(date1);
        txtFecha.setEnabled(false);
        CargarTablaClientes(mecLoc);
        CargarComboHorarios(mecLoc, date1);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCategoria = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox();
        Tipo = new javax.swing.ButtonGroup();
        jPanelNuevoModelo = new javax.swing.JPanel();
        jPanelDNI6 = new javax.swing.JPanel();
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
        HoraReq = new javax.swing.JPanel();
        lblNombre2 = new javax.swing.JLabel();
        cmbIni = new javax.swing.JComboBox();
        lblNombre3 = new javax.swing.JLabel();
        txtFin = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        lblCategoria.setText("Categoria:");

        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });

        jPanelNuevoModelo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Turno para Diagnóstico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 36), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanelNuevoModelo.setToolTipText("");

        jPanelDNI6.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        lblDetAct.setText("Hora de inicio:");

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

        HoraReq.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        lblNombre2.setText("Tiempo requerido: 1 hora.");

        javax.swing.GroupLayout HoraReqLayout = new javax.swing.GroupLayout(HoraReq);
        HoraReq.setLayout(HoraReqLayout);
        HoraReqLayout.setHorizontalGroup(
            HoraReqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HoraReqLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(lblNombre2)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        HoraReqLayout.setVerticalGroup(
            HoraReqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HoraReqLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cmbIni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIniActionPerformed(evt);
            }
        });

        lblNombre3.setText("Hora de fin:");

        javax.swing.GroupLayout jPanelDNI6Layout = new javax.swing.GroupLayout(jPanelDNI6);
        jPanelDNI6.setLayout(jPanelDNI6Layout);
        jPanelDNI6Layout.setHorizontalGroup(
            jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDNI6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(HoraReq, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDNI6Layout.createSequentialGroup()
                        .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre1)
                            .addComponent(lblNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCod)
                            .addComponent(txtFecha)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDNI6Layout.createSequentialGroup()
                        .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDetAct)
                            .addComponent(lblNombre3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbIni, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelDNI6Layout.createSequentialGroup()
                                .addComponent(txtFin, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDetAct2)
                    .addComponent(lblDetAct1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDNI6Layout.setVerticalGroup(
            jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDNI6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelDNI6Layout.createSequentialGroup()
                        .addComponent(lblDetAct1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblDetAct2))
                    .addGroup(jPanelDNI6Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre1)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(HoraReq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDNI6Layout.createSequentialGroup()
                        .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDetAct)
                            .addComponent(cmbIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDNI6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre3)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        btnAceptar.setMaximumSize(new java.awt.Dimension(95, 73));
        btnAceptar.setMinimumSize(new java.awt.Dimension(95, 73));
        btnAceptar.setPreferredSize(new java.awt.Dimension(95, 73));
        btnAceptar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAceptar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelNuevoModeloLayout = new javax.swing.GroupLayout(jPanelNuevoModelo);
        jPanelNuevoModelo.setLayout(jPanelNuevoModeloLayout);
        jPanelNuevoModeloLayout.setHorizontalGroup(
            jPanelNuevoModeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoModeloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDNI6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNuevoModeloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanelNuevoModeloLayout.setVerticalGroup(
            jPanelNuevoModeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoModeloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDNI6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelNuevoModeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.hide();
        MAPALocal.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        String nom = tblClientes.getValueAt(tblClientes.getSelectedRow(), 0).toString();
        tblVehic.setVisible(true);
        
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
        
    }//GEN-LAST:event_tblVehicMouseClicked

    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed

    }//GEN-LAST:event_cmbCategoriaActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void cmbIniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIniActionPerformed
        int hora=-1, min=-1;
        if(!cmbIni.getSelectedItem().toString().equals("Hora..")){
            if(cmbIni.getSelectedItem().toString().substring(1, 2).equals(":")){
                hora = Integer.parseInt(cmbIni.getSelectedItem().toString().substring(0, 1));
                min = Integer.parseInt(cmbIni.getSelectedItem().toString().substring(2, 4));
            }
            else{
                hora = Integer.parseInt(cmbIni.getSelectedItem().toString().substring(0, 2));
                min = Integer.parseInt(cmbIni.getSelectedItem().toString().substring(3, 5));
            }
        }
        String alas;
        if(hora!=-1 && min !=-1){
            hora++;
            if (min == 0)
                alas= hora +":"+ min + "0";
            else
                alas= hora +":"+ min;
            txtFin.setText(alas);
        }
        else txtFin.setText("");
    }//GEN-LAST:event_cmbIniActionPerformed
    
    private void CargarComboHorarios(Mecanico m, String date1){
        miModeloCombo= new DefaultComboBoxModel();
        List<Turno> Lista = m.getVsTurno();
        miModeloCombo.addElement("Hora..");
        Date f;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Object[]fila= new Object[1];
        
        int a = (m.getHoraFin().getHours() - m.getHoraInicio().getHours())*2;
        int b = (m.getHoraFin().getMinutes() - m.getHoraInicio().getMinutes());
        if(b==30) { a = a + 1;}
        else if (b==-30) {a = a - 1;}
        
        int hora = m.getHoraInicio().getHours();
        int min = m.getHoraInicio().getMinutes();
        for(int i = 0;i<a;i++){
            int ban = 0;
            Iterator<Turno> it = Lista.iterator();
            while(it.hasNext()){
                Turno unTurno=it.next();
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
                        miModeloCombo.addElement("-----");
                        min = min + 30;
                        if(min == 60){
                            hora = hora+1;
                            min = 0;
                        }
                        i++;
                    }
                    ban = 1;
                }
            }
            if(ban==0){
                String s;
                if (min == 0)
                    s = hora +":"+ min + "0";
                else
                    s = hora +":"+ min;
                min = min + 30;
                if(min == 60){
                    hora = hora+1;
                    min = 0;
                }
                int p = i+1;
                if(p<a)
                    miModeloCombo.addElement(s);
            } else {i--;}
        }
        cmbIni.setModel(miModeloCombo);
    }
    
    public void CargarTablaClientes(Mecanico mec){
                
        List<Cliente> ListaCli= cLocal.dameUnMecanico(mec.getDni()).getUnaSucursal().getVsCliente();
        Object[]fila= new Object[1];
        
        Collections.sort(ListaCli, new Comparator<Cliente>(){
            public int compare(Cliente s1, Cliente s2) {
                if (s1.getNombre().compareTo(s2.getNombre())<1)
             return -1;
                else
             return 1;
            }
        });
        
        Iterator<Cliente> it = null;
        it = ListaCli.iterator();
        Cliente cli = null;
        while(it.hasNext()) {
            cli = it.next();
            fila[0]=cli.getNombre();
            miModeloTabla2.addRow(fila);
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HoraReq;
    private javax.swing.ButtonGroup Tipo;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cmbCategoria;
    private javax.swing.JComboBox cmbIni;
    private javax.swing.JPanel jPanelDNI6;
    private javax.swing.JPanel jPanelNuevoModelo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDetAct;
    private javax.swing.JLabel lblDetAct1;
    private javax.swing.JLabel lblDetAct2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblVehic;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFin;
    // End of variables declaration//GEN-END:variables
}
