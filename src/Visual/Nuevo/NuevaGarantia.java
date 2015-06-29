
package Visual.Nuevo;

import LogicaDeNegocios.Autoparte;
import LogicaDeNegocios.GrupoParte;
import Persistencia.exceptions.PreexistingEntityException;
import Visual.Controladora;
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


public class NuevaGarantia extends javax.swing.JInternalFrame {

    Controladora cLocal;
    DefaultComboBoxModel miModeloCombo2;
    DefaultTableModel miModeloTabla3= new DefaultTableModel();
    DefaultTableModel miModeloTabla4= new DefaultTableModel();
    NuevoVehiculo padre= null;
    Date fecha;
    LinkedList<Autoparte> Nuevos;
    
    public NuevaGarantia(Controladora c, NuevoVehiculo nv) {
        initComponents();
        cLocal = c;
        padre = nv;
        miModeloTabla3.addColumn("Descripcion");
        miModeloTabla4.addColumn("Descripcion");
        CargarComboGrupoPartes();
    }
    public NuevaGarantia(Controladora c) {
        initComponents();
        cLocal = c;
        miModeloTabla3.addColumn("Descripcion");
        miModeloTabla4.addColumn("Descripcion");
        CargarComboGrupoPartes();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelNuevoModelo = new javax.swing.JPanel();
        jPanelDNI = new javax.swing.JPanel();
        lblDescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        lblFechaIni = new javax.swing.JLabel();
        lblDuracion = new javax.swing.JLabel();
        lblMeses = new javax.swing.JLabel();
        Fechita = new com.toedter.calendar.JDateChooser();
        txtDuracion = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblAutoparteExistente = new javax.swing.JTable();
        lblAutoparte = new javax.swing.JLabel();
        lblAutoparteGrup = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblAutoparteGar = new javax.swing.JTable();
        btnAgregarA = new javax.swing.JButton();
        btnAgregarTodoA = new javax.swing.JButton();
        cmbGrupoParte = new javax.swing.JComboBox();
        lblGrupoParte = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jPanelNuevoModelo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nueva Garantia", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 36), new java.awt.Color(0, 0, 0))); // NOI18N

        jPanelDNI.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        lblDescripcion.setText("Descripción:");

        lblFechaIni.setText("Fecha de Inicio:");

        lblDuracion.setText("Duración:");

        lblMeses.setText("Meses");

        Fechita.setDateFormatString("yyyy-MM-dd");
        Fechita.setMaxSelectableDate(new java.util.Date(253370779286000L));

        txtDuracion.setText("6");
        txtDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuracionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDNILayout = new javax.swing.GroupLayout(jPanelDNI);
        jPanelDNI.setLayout(jPanelDNILayout);
        jPanelDNILayout.setHorizontalGroup(
            jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDNILayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDescripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDNILayout.createSequentialGroup()
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanelDNILayout.createSequentialGroup()
                        .addComponent(lblFechaIni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Fechita, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDuracion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMeses)
                        .addGap(153, 153, 153))))
        );
        jPanelDNILayout.setVerticalGroup(
            jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDNILayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescripcion)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFechaIni)
                        .addComponent(lblDuracion)
                        .addComponent(lblMeses)
                        .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Fechita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));

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

        lblAutoparte.setText("Autopartes:");

        lblAutoparteGrup.setText("Autopartes que contiene:");

        tblAutoparteGar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblAutoparteGar.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblAutoparteGar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAutoparteGarMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(tblAutoparteGar);

        btnAgregarA.setText("Agregar >");
        btnAgregarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAActionPerformed(evt);
            }
        });

        btnAgregarTodoA.setText("Agregar todo >>");
        btnAgregarTodoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTodoAActionPerformed(evt);
            }
        });

        cmbGrupoParte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGrupoParteActionPerformed(evt);
            }
        });

        lblGrupoParte.setText("Grupo Partes:");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAutoparte)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblGrupoParte)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmbGrupoParte, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnAgregarA)
                            .addGap(68, 68, 68)
                            .addComponent(btnAgregarTodoA, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(lblAutoparteGrup)
                        .addContainerGap(108, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblAutoparteGrup)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblGrupoParte)
                                    .addComponent(cmbGrupoParte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 20, Short.MAX_VALUE)
                                .addComponent(lblAutoparte)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAgregarTodoA)
                                    .addComponent(btnAgregarA)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16))))
        );

        javax.swing.GroupLayout jPanelNuevoModeloLayout = new javax.swing.GroupLayout(jPanelNuevoModelo);
        jPanelNuevoModelo.setLayout(jPanelNuevoModeloLayout);
        jPanelNuevoModeloLayout.setHorizontalGroup(
            jPanelNuevoModeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNuevoModeloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNuevoModeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDNI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelNuevoModeloLayout.setVerticalGroup(
            jPanelNuevoModeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoModeloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDNI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelDNI.getAccessibleContext().setAccessibleDescription("");

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
                .addContainerGap()
                .addComponent(jPanelNuevoModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNuevoModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String nombre;
        int duracion;
        if((!txtDescripcion.getText().equals("")) && catchPartesGtia()>0){
            try {
                boolean validez = validarGarantia();
                nombre = txtDescripcion.getText();
                duracion = Integer.parseInt(txtDuracion.getText());                
                
                cLocal.crearGarantia(fecha,duracion , nombre, validez, Nuevos);
                this.hide();
                if (padre!=null){
                    padre.setVisible(true);
                    padre.CargarComboGarantia();
                }

                String err = "Se ha creado correctamente";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Carga Correcta", JOptionPane.PLAIN_MESSAGE);
            } catch (PreexistingEntityException p) {
                String err = "Ya existe esa Categoria.";
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
        if (padre!=null) padre.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblAutoparteExistenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAutoparteExistenteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblAutoparteExistenteMouseClicked

    private void btnAgregarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAActionPerformed
        if(tblAutoparteExistente.getRowCount()!=0 && tblAutoparteExistente.getSelectedRow() != -1){
            Object[]fila= new Object[1];
            fila[0] = tblAutoparteExistente.getValueAt(tblAutoparteExistente.getSelectedRow(),0).toString();
            miModeloTabla3.removeRow(tblAutoparteExistente.getSelectedRow());
            miModeloTabla4.addRow(fila);

            tblAutoparteGar.setModel(miModeloTabla4);
            tblAutoparteExistente.setModel(miModeloTabla3);}
    }//GEN-LAST:event_btnAgregarAActionPerformed

    private void btnAgregarTodoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTodoAActionPerformed
        DefaultTableModel modelo4=(DefaultTableModel) tblAutoparteExistente.getModel();
        Object[]fila= new Object[1];

        int filas=tblAutoparteExistente.getRowCount();
        for(int i=0; i<filas;i++){
            fila[0] = tblAutoparteExistente.getValueAt(0,0).toString();
            miModeloTabla4.addRow(fila);
            modelo4.removeRow(0);
        }

        tblAutoparteGar.setModel(miModeloTabla4);
    }//GEN-LAST:event_btnAgregarTodoAActionPerformed

    private void tblAutoparteGarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAutoparteGarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblAutoparteGarMouseClicked

    private void txtDuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDuracionActionPerformed

    private void cmbGrupoParteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGrupoParteActionPerformed
        LimpiarTabla();
        miModeloTabla3 = new DefaultTableModel();
        miModeloTabla3.addColumn("Descripcion");
        GrupoParte grup = obtenerGrupo();
        List<Autoparte> lista2 = grup.getVsAutoparte();  
        Object[]fila1= new Object[1];
        
        Collections.sort(lista2, new Comparator<Autoparte>(){
            public int compare(Autoparte s1, Autoparte s2) {
                if (s1.getDescripcion().compareToIgnoreCase(s2.getDescripcion())<0)
             return -1;
                else
             return 1;
            }
        });
        
        for(Autoparte unaAutoparte:lista2){
            fila1[0]=unaAutoparte.getDescripcion();
            miModeloTabla3.addRow(fila1);
        }
        tblAutoparteExistente.setModel(miModeloTabla3);
    }//GEN-LAST:event_cmbGrupoParteActionPerformed

            //Catch de los Autoparte nuevos
    private int catchPartesGtia(){
        int cant = tblAutoparteGar.getRowCount();
        List<Autoparte> Todos= new LinkedList<Autoparte>();
            Todos.addAll(cLocal.dameAccesorios());
            Todos.addAll(cLocal.dameRepuestos());
            Todos.addAll(cLocal.dameEquipamientos());

        Nuevos= new LinkedList<Autoparte>();
        String nom;
        Autoparte gp;
        int b;
        Iterator<Autoparte> it;
        for(int i=0; i<cant;i++){
            nom = tblAutoparteGar.getValueAt(i,0).toString();
            it = Todos.iterator();
            gp = null;
            b=0;
            while(it.hasNext() && b==0) {
                gp = it.next();
                if(gp.getDescripcion().equals(nom)){ b=1; }
            }
            Nuevos.add(gp); 
        }
        int x = Nuevos.size();
        return x;
    }
    
    private boolean validarGarantia(){
        boolean b;
        Calendar cale = Calendar.getInstance();
        cale = Fechita.getCalendar();
        Date fecha2 = cale.getTime();
        fecha = fecha2;
        int mes= fecha2.getMonth() + Integer.parseInt(txtDuracion.getText());
        int año= fecha2.getYear();
        while (mes>11){
            mes= mes-11;
            año=año+1;
        }
        fecha2.setMonth(mes);
        fecha2.setYear(año);
        if (Calendar.getInstance().getTime().before(fecha2)) {
            b=true;
        }else{
            b=false;
        }
        return b;
    }
    
    
    public void LimpiarTabla(){
        miModeloTabla3=(DefaultTableModel) tblAutoparteExistente.getModel();
        int filas=tblAutoparteExistente.getRowCount();
        for(int i=0; i<filas;i++){
            miModeloTabla3.removeRow(0);
        }
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Fechita;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregarA;
    private javax.swing.JButton btnAgregarTodoA;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cmbGrupoParte;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelDNI;
    private javax.swing.JPanel jPanelNuevoModelo;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAutoparte;
    private javax.swing.JLabel lblAutoparteGrup;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDuracion;
    private javax.swing.JLabel lblFechaIni;
    private javax.swing.JLabel lblGrupoParte;
    private javax.swing.JLabel lblMeses;
    private javax.swing.JTable tblAutoparteExistente;
    private javax.swing.JTable tblAutoparteGar;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDuracion;
    // End of variables declaration//GEN-END:variables
}
