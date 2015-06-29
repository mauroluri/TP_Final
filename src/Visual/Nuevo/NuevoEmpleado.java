package Visual.Nuevo;

import LogicaDeNegocios.*;
import Persistencia.exceptions.PreexistingEntityException;
import Visual.Controladora;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class NuevoEmpleado extends javax.swing.JInternalFrame {

    Controladora cLocal;
    DefaultComboBoxModel miModeloCombo;
    DefaultComboBoxModel miModeloCombo2;
    DefaultComboBoxModel miModeloCombo3;
    DefaultComboBoxModel miModeloCombo4;
    Date i, f;
    
    public NuevoEmpleado(Controladora c) {
        initComponents();
        cLocal = c;
        String nom = c.dameEmpresas().get(0).getNombre();
        setTitle(nom+" - Nuevo Empleado");
        cmbSucursal.setEnabled(false);
        cmbLocalidad.setEnabled(false);
        CargarComboProv();
        cmbEspecialidad.setVisible(false);
        lblEspecialidad.setVisible(false);
        HoraEntra.setEnabled(false);
        HoraSale.setEnabled(false);
        MinEntra.setEnabled(false);
        MinSale.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Rol = new javax.swing.ButtonGroup();
        jPanelNuevoEmpleado = new javax.swing.JPanel();
        jPanelDNI = new javax.swing.JPanel();
        lblDNI = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        jPanelDatos = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblSueldo = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JTextField();
        jPanelUbicacion = new javax.swing.JPanel();
        cmbProvincia = new javax.swing.JComboBox();
        lbProvincia = new javax.swing.JLabel();
        cmbLocalidad = new javax.swing.JComboBox();
        lblLocalidad = new javax.swing.JLabel();
        cmbSucursal = new javax.swing.JComboBox();
        lblCalle = new javax.swing.JLabel();
        btnAceptar1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanelDatos1 = new javax.swing.JPanel();
        lblNombre1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        lblEspecialidad = new javax.swing.JLabel();
        cmbEspecialidad = new javax.swing.JComboBox();
        jPanelDatos3 = new javax.swing.JPanel();
        lblPass = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        lblPassC = new javax.swing.JLabel();
        txtPassC = new javax.swing.JPasswordField();
        jPanelDatos2 = new javax.swing.JPanel();
        lblTelefono1 = new javax.swing.JLabel();
        lblHoraMIN = new javax.swing.JLabel();
        lblHoraMAX = new javax.swing.JLabel();
        HoraEntra = new javax.swing.JTextField();
        MinEntra = new javax.swing.JTextField();
        HoraSale = new javax.swing.JTextField();
        MinSale = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblHoraEnt = new javax.swing.JLabel();
        lblHoraSal = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jPanelNuevoEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Empleado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 36), new java.awt.Color(0, 0, 0))); // NOI18N

        jPanelDNI.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        lblDNI.setText("DNI:");

        txtDNI.setToolTipText("");

        javax.swing.GroupLayout jPanelDNILayout = new javax.swing.GroupLayout(jPanelDNI);
        jPanelDNI.setLayout(jPanelDNILayout);
        jPanelDNILayout.setHorizontalGroup(
            jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDNILayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDNI)
                .addGap(18, 18, 18)
                .addComponent(txtDNI)
                .addContainerGap())
        );
        jPanelDNILayout.setVerticalGroup(
            jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDNILayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDNI)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        lblNombre.setText("Apellido, Nombres:");

        lblTelefono.setText("Teléfono:");

        lblSueldo.setText("Sueldo:");

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(lblTelefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(lblSueldo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre)))
                .addContainerGap())
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSueldo)
                    .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelUbicacion.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        cmbProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProvinciaActionPerformed(evt);
            }
        });

        lbProvincia.setText("Provincia:");

        cmbLocalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLocalidadActionPerformed(evt);
            }
        });

        lblLocalidad.setText("Localidad:");

        cmbSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSucursalActionPerformed(evt);
            }
        });

        lblCalle.setText("Sucursal:");

        btnAceptar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1414891197_Redo.png"))); // NOI18N
        btnAceptar1.setText("Modificar");
        btnAceptar1.setToolTipText("");
        btnAceptar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAceptar1.setIconTextGap(2);
        btnAceptar1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAceptar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUbicacionLayout = new javax.swing.GroupLayout(jPanelUbicacion);
        jPanelUbicacion.setLayout(jPanelUbicacionLayout);
        jPanelUbicacionLayout.setHorizontalGroup(
            jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUbicacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCalle)
                    .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblLocalidad)
                        .addComponent(lbProvincia)))
                .addGap(18, 18, 18)
                .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbLocalidad, 0, 298, Short.MAX_VALUE)
                    .addComponent(cmbProvincia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(cmbSucursal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAceptar1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelUbicacionLayout.setVerticalGroup(
            jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUbicacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUbicacionLayout.createSequentialGroup()
                        .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbProvincia)
                            .addComponent(cmbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLocalidad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAceptar1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCalle))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDatos1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        lblNombre1.setText("Rol:");

        Rol.add(jRadioButton1);
        jRadioButton1.setText("Encargado");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });

        Rol.add(jRadioButton2);
        jRadioButton2.setText("Mecánico");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });

        Rol.add(jRadioButton3);
        jRadioButton3.setText("Atención al público");
        jRadioButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton3MouseClicked(evt);
            }
        });

        Rol.add(jRadioButton4);
        jRadioButton4.setText("Perito");
        jRadioButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelDatos1Layout = new javax.swing.GroupLayout(jPanelDatos1);
        jPanelDatos1.setLayout(jPanelDatos1Layout);
        jPanelDatos1Layout.setHorizontalGroup(
            jPanelDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatos1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatos1Layout.createSequentialGroup()
                        .addComponent(lblNombre1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelDatos1Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton4)
                        .addGap(0, 18, Short.MAX_VALUE))))
        );
        jPanelDatos1Layout.setVerticalGroup(
            jPanelDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatos1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblEspecialidad.setText("Seleccione la especialidad del Mecánico:");

        jPanelDatos3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        lblPass.setText("Contraseña:");

        lblPassC.setText("Repita contraseña:");

        javax.swing.GroupLayout jPanelDatos3Layout = new javax.swing.GroupLayout(jPanelDatos3);
        jPanelDatos3.setLayout(jPanelDatos3Layout);
        jPanelDatos3Layout.setHorizontalGroup(
            jPanelDatos3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatos3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(lblPassC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPassC, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelDatos3Layout.setVerticalGroup(
            jPanelDatos3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatos3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatos3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPass)
                    .addComponent(lblPassC)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDatos2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        lblTelefono1.setText("Horario Laboral:");

        lblHoraMIN.setText("MIN ( - )");

        lblHoraMAX.setText("MAX ( - )");

        HoraEntra.setText("00");

        MinEntra.setText("00");

        HoraSale.setText("00");

        MinSale.setText("00");

        jLabel1.setText(":");

        jLabel2.setText(":");

        lblHoraEnt.setText("Horario de entrada:");

        lblHoraSal.setText("Horario de salida:");

        javax.swing.GroupLayout jPanelDatos2Layout = new javax.swing.GroupLayout(jPanelDatos2);
        jPanelDatos2.setLayout(jPanelDatos2Layout);
        jPanelDatos2Layout.setHorizontalGroup(
            jPanelDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatos2Layout.createSequentialGroup()
                .addGroup(jPanelDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatos2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTelefono1))
                    .addGroup(jPanelDatos2Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanelDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHoraEnt)
                            .addComponent(lblHoraSal))
                        .addGap(36, 36, 36)
                        .addGroup(jPanelDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(HoraEntra)
                            .addComponent(HoraSale, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(MinEntra)
                            .addComponent(MinSale, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanelDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHoraMIN)
                            .addComponent(lblHoraMAX))))
                .addContainerGap(346, Short.MAX_VALUE))
        );
        jPanelDatos2Layout.setVerticalGroup(
            jPanelDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatos2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTelefono1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoraMIN)
                    .addComponent(HoraEntra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MinEntra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(lblHoraEnt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoraMAX)
                    .addComponent(MinSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(HoraSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHoraSal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelNuevoEmpleadoLayout = new javax.swing.GroupLayout(jPanelNuevoEmpleado);
        jPanelNuevoEmpleado.setLayout(jPanelNuevoEmpleadoLayout);
        jPanelNuevoEmpleadoLayout.setHorizontalGroup(
            jPanelNuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoEmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDatos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelNuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanelNuevoEmpleadoLayout.createSequentialGroup()
                            .addComponent(jPanelDNI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jPanelDatos3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelNuevoEmpleadoLayout.createSequentialGroup()
                            .addComponent(jPanelUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanelNuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanelDatos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblEspecialidad)
                                .addComponent(cmbEspecialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jPanelDatos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNuevoEmpleadoLayout.setVerticalGroup(
            jPanelNuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoEmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelDatos3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDNI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelNuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelNuevoEmpleadoLayout.createSequentialGroup()
                        .addComponent(jPanelDatos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblEspecialidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelDatos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(684, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNuevoEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNuevoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String nombre, contra;
        int sueldo;
        long dni, telefono;
        Localidad loc; 
        Especialidad esp;
        Sucursal suc;
        
        if(control() && controlPass() && controlHora()){
            try {
                dni = Long.valueOf(txtDNI.getText()); 
                telefono = Long.valueOf(txtTelefono.getText());
                nombre = txtNombre.getText();
                sueldo = Integer.parseInt(txtSueldo.getText());
                loc = obtenerLocalidad();
                suc = obtenerSuc(loc);
                contra = new String(txtPass.getPassword());
                
                if(Rol.getSelection().equals(jRadioButton1.getModel()))
                    cLocal.crearEncargado(loc, suc, nombre, dni, telefono, sueldo, contra, i, f);
                if(Rol.getSelection().equals(jRadioButton2.getModel())){
                    esp = obtenerEsp();
                    cLocal.crearMecanico(loc, suc, nombre, dni, telefono, sueldo, contra, i, f, esp);}
                if(Rol.getSelection().equals(jRadioButton3.getModel()))
                    cLocal.crearAtencionPublico(loc, suc, nombre, dni, telefono, sueldo, contra, i, f);
                if(Rol.getSelection().equals(jRadioButton4.getModel()))
                    cLocal.crearPerito(loc, suc, nombre, dni, telefono, sueldo, contra, i, f);
                
         
                this.hide();
                
                String err = "Se ha creado correctamente";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Carga Correcta", JOptionPane.PLAIN_MESSAGE);
            } catch (NumberFormatException a) {
                String err = "DNI Invalido";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Error de Carga", JOptionPane.ERROR_MESSAGE);
            } catch (PreexistingEntityException p) {
                String err = "Ya existe un empleado con ese DNI.";
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

    
    private Localidad obtenerLocalidad(){
        String m = cmbProvincia.getSelectedItem().toString();
                List<Provincia> p = cLocal.dameProvincias();
                int bb=0;
                
                Iterator<Provincia> it = null;
                it = p.iterator();
                Provincia prov = null;
                while(it.hasNext() && bb==0) {
                    prov = it.next();
                    if(prov.getNombre().equals(m)){ bb=1; }
                }
                String nom = cmbLocalidad.getSelectedItem().toString();
                List<Localidad> l = prov.getLocalidades();
                int b=0;
                
                Iterator<Localidad> it2 = null;
                it2 = l.iterator();
                Localidad loc = null;
                while(it2.hasNext() && b==0) {
                    loc = it2.next();
                    if(loc.getNombre().equals(nom)){ b=1; }
                }
                return loc;
    }
    
    private Sucursal obtenerSuc(Localidad l){
        int cod = Integer.parseInt(cmbSucursal.getSelectedItem().toString());
        List<Sucursal> misSuc = cLocal.dameSucursales();
        Sucursal suc = null;
        int b=0;

        Iterator<Sucursal> it = null;
        it = misSuc.iterator();
        while(it.hasNext() && b==0) {
            suc = it.next();
            if(suc.getCodSuc()==cod){ b=1; }
        }
        
        return suc;
    }
    
    private Especialidad obtenerEsp(){
        String nom = cmbEspecialidad.getSelectedItem().toString();
        Especialidad esppp = null;
                List<Especialidad> l = cLocal.dameEspecialidades();
                int b=0;
                
                Iterator<Especialidad> it = null;
                it = l.iterator();
                while(it.hasNext() && b==0) {
                    esppp = it.next();
                    if(esppp.getNombre().equals(nom)){ b=1; }
                }
        
        return esppp;
    }
    
    
    private void cmbProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProvinciaActionPerformed
        if(!(cmbProvincia.getSelectedItem().toString().equals("Seleccione una Provincia"))){
            try {
                String nom = cmbProvincia.getSelectedItem().toString();
                List<Provincia> p = cLocal.dameProvincias();
                int b=0;
                
                Iterator<Provincia> it = null;
                it = p.iterator();
                Provincia prov = null;
                while(it.hasNext() && b==0) {
                    prov = it.next();
                    if(prov.getNombre().equals(nom)){ b=1; }
                }
                
                CargarComboLoc(prov);
                cmbLocalidad.setEnabled(true);
                cmbProvincia.setEnabled(false);
                
            } catch (NumberFormatException a){
            } catch (Exception e){
            }
        }
    }//GEN-LAST:event_cmbProvinciaActionPerformed

    private void cmbLocalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLocalidadActionPerformed
        if(!(cmbLocalidad.getSelectedItem().toString().equals("Seleccione una Localidad"))){
            try {
                String nom = cmbLocalidad.getSelectedItem().toString();
                List<Localidad> l = cLocal.dameLocalidades();
                int b=0;
                
                Iterator<Localidad> it = null;
                it = l.iterator();
                Localidad loc = null;
                while(it.hasNext() && b==0) {
                    loc = it.next();
                    if(loc.getNombre().equals(nom)){ b=1; }
                }
                
                CargarComboSuc(loc);
                cmbSucursal.setEnabled(true);
                cmbLocalidad.setEnabled(false);
                
            } catch (NumberFormatException a){
            } catch (Exception e){
            }
        }
    }//GEN-LAST:event_cmbLocalidadActionPerformed

    private void btnAceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar1ActionPerformed
        if(!cmbProvincia.isEnabled()){
            
            CargarComboProv();
            cmbProvincia.setEnabled(true);
            int c;
            
            miModeloCombo2 = new DefaultComboBoxModel();
            miModeloCombo2.addElement("");
            cmbLocalidad.setModel(miModeloCombo2);
            cmbLocalidad.setEnabled(false);
                        
            if(!cmbLocalidad.isEnabled()){
                miModeloCombo3 = new DefaultComboBoxModel();
                miModeloCombo3.addElement("");
                cmbSucursal.setModel(miModeloCombo3);
                cmbSucursal.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnAceptar1ActionPerformed

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        cmbEspecialidad.setVisible(false);
        lblEspecialidad.setVisible(false);
    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
        cmbEspecialidad.setVisible(true);
        lblEspecialidad.setVisible(true);
        CargarComboEsp();
    }//GEN-LAST:event_jRadioButton2MouseClicked

    private void jRadioButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton3MouseClicked
        cmbEspecialidad.setVisible(false);
        lblEspecialidad.setVisible(false);
    }//GEN-LAST:event_jRadioButton3MouseClicked

    private void jRadioButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton4MouseClicked
        cmbEspecialidad.setVisible(false);
        lblEspecialidad.setVisible(false);
    }//GEN-LAST:event_jRadioButton4MouseClicked

    private void cmbSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSucursalActionPerformed
        if(!(cmbSucursal.getSelectedItem().toString().equals("Seleccione una Sucursal"))){
            Sucursal suc = null;
            try {
                int cod = Integer.parseInt(cmbSucursal.getSelectedItem().toString());
                List<Sucursal> l = cLocal.dameSucursales();
                int b=0;
                
                Iterator<Sucursal> it = null;
                it = l.iterator();
                while(it.hasNext() && b==0) {
                    suc = it.next();
                    if(suc.getCodSuc()==cod){ b=1; }
                }                
            } catch (NumberFormatException a){
            } catch (Exception e){
            }
            
            HoraEntra.setEnabled(true);
            HoraSale.setEnabled(true);
            MinEntra.setEnabled(true);
            MinSale.setEnabled(true);
            
            if(suc.getHoraInicio().getHours()<10){
                if(suc.getHoraInicio().getMinutes()<10)
                    lblHoraMIN.setText("MIN ( 0"+suc.getHoraInicio().getHours()+":0"+suc.getHoraInicio().getMinutes()+" ) ");
                else
                    lblHoraMIN.setText("MIN ( 0"+suc.getHoraInicio().getHours()+":"+suc.getHoraInicio().getMinutes()+" ) ");
            } else {
                if(suc.getHoraInicio().getMinutes()<10)
                    lblHoraMIN.setText("MIN ( "+suc.getHoraInicio().getHours()+":0"+suc.getHoraInicio().getMinutes()+" ) ");
                else
                    lblHoraMIN.setText("MIN ( "+suc.getHoraInicio().getHours()+":"+suc.getHoraInicio().getMinutes()+" ) ");
            }
            
            if(suc.getHoraFin().getHours()<10){
                if(suc.getHoraFin().getMinutes()<10)
                    lblHoraMAX.setText("MAX ( 0"+suc.getHoraFin().getHours()+":0"+suc.getHoraFin().getMinutes()+" ) ");
                else
                    lblHoraMAX.setText("MAX ( 0"+suc.getHoraFin().getHours()+":"+suc.getHoraFin().getMinutes()+" ) ");
            } else {
                if(suc.getHoraFin().getMinutes()<10)
                    lblHoraMAX.setText("MAX ( "+suc.getHoraFin().getHours()+":0"+suc.getHoraFin().getMinutes()+" ) ");
                else
                    lblHoraMAX.setText("MAX ( "+suc.getHoraFin().getHours()+":"+suc.getHoraFin().getMinutes()+" ) ");
            }
        }
        else{
            HoraEntra.setEnabled(false);
            HoraSale.setEnabled(false);
            MinEntra.setEnabled(false);
            MinSale.setEnabled(false);
            lblHoraMIN.setText("MIN ( - ) ");
            lblHoraMAX.setText("MAX ( - ) ");
            
        }
    }//GEN-LAST:event_cmbSucursalActionPerformed

    
    private boolean control(){
        boolean ok=true;        
        int l= txtDNI.getText().length();
        if (txtDNI.getText().equals("")) ok=false;
        if (cmbProvincia.getSelectedIndex()==0) ok=false;
        if (cmbLocalidad.getSelectedIndex()==0) ok=false;
        if (cmbSucursal.getSelectedIndex()==0) ok=false;
        if (txtSueldo.getText().equals("")) ok=false;
        if (txtNombre.getText().equals("")) ok=false;
        if (txtTelefono.getText().equals("")) ok=false;
        if (Rol.getSelection()==null) {
            System.out.println("NO ANDA");
            ok=false;}
        return ok;
    }
    
    private boolean controlHora(){
        boolean ok=true;
        try{
            Calendar cal = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY,Integer.parseInt(HoraEntra.getText()));
            cal.set(Calendar.MINUTE,Integer.parseInt(MinEntra.getText()));
            cal.set(Calendar.SECOND,0);
            i = cal.getTime();
            
            cal2.set(Calendar.HOUR_OF_DAY,Integer.parseInt(HoraSale.getText()));
            cal2.set(Calendar.MINUTE,Integer.parseInt(MinSale.getText()));
            cal2.set(Calendar.SECOND,0);
            f = cal2.getTime();
            
            if (i.getHours()<0 || i.getHours()>23 || f.getHours()<0 || f.getHours()>23){
                ok=false;
                String err = "Ingrese horarios válidos";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Horario erroneo", JOptionPane.PLAIN_MESSAGE);
            }
            if (i.getMinutes()<0 || i.getMinutes()>59 || f.getMinutes()<0 || f.getMinutes()>59){
                ok=false;
                String err = "Ingrese horarios válidos";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Horario erroneo", JOptionPane.PLAIN_MESSAGE);
            }
            if (i.after(f) || i.equals(f)){
                ok=false;
                String err = "La hora de salida debe ser mayor a la hora de entrada.";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Horario erroneo", JOptionPane.PLAIN_MESSAGE);
            }        
            Sucursal sucu = null;
            int nom = Integer.parseInt(cmbSucursal.getSelectedItem().toString());
            List<Sucursal> ada = cLocal.dameSucursales();
            int b=0;
            Iterator<Sucursal> it = ada.iterator();
            while(it.hasNext() && b==0) {
                sucu = it.next();
                if(sucu.getCodSuc()==nom){ b=1; }
            }
            if(i.getHours()<sucu.getHoraInicio().getHours()){
                ok=false;
                String err = "La hora de entrada es menor que la hora MINIMA de la Sucursal";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Horario erroneo", JOptionPane.PLAIN_MESSAGE);
            }
            if(i.getHours()==sucu.getHoraInicio().getHours() && i.getMinutes()<sucu.getHoraInicio().getMinutes()){   
                    ok=false;
                    String err = "La hora de entrada es menor que la hora MINIMA de la Sucursal";
                    System.err.println(err);
                    JOptionPane.showMessageDialog(this, err, "Horario erroneo", JOptionPane.PLAIN_MESSAGE);
            }        
            if(f.getHours()>sucu.getHoraFin().getHours()){
                ok=false;
                String err = "La hora de clausura es mayor que la hora MAXIMA de la Sucursal";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Horario erroneo", JOptionPane.PLAIN_MESSAGE);
            }
            if(f.getHours()==sucu.getHoraFin().getHours() && f.getMinutes()>sucu.getHoraFin().getMinutes()){
                ok=false;
                String err = "La hora de clausura es mayor que la hora MAXIMA de la Sucursal";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Horario erroneo", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (NumberFormatException e){
                ok= false;
                String err = "La hora ingresada posee caracteres inválidos";
                System.err.println(err);
                JOptionPane.showMessageDialog(this, err, "Horario erroneo", JOptionPane.PLAIN_MESSAGE);
        }
        return ok;
    }
    
    private boolean controlPass(){
        boolean ok=true; 
        String contra = new String(txtPass.getPassword());
        String repContra = new String(txtPass.getPassword());
        
        if (contra.equals("")) ok=false;
        if (repContra.equals("")) ok=false;
        
        if(!contra.equals(repContra)){
            ok = false;
            String err = "Las contraseñas no son iguales.";
            System.err.println(err);
            JOptionPane.showMessageDialog(this, err, "Error de Contraseña", JOptionPane.ERROR_MESSAGE);
        }
        return ok;
    }

    
    private void CargarComboProv(){
        miModeloCombo= new DefaultComboBoxModel();
        List<Provincia> misProv = cLocal.dameProvincias();
        miModeloCombo.addElement("Seleccione una Provincia");
        for(Provincia miProvincia:misProv){
            miModeloCombo.addElement(miProvincia.getNombre());            
        }
        cmbProvincia.setModel(miModeloCombo);
    }
    
    private void CargarComboLoc(Provincia prov){
        miModeloCombo2= new DefaultComboBoxModel();
        List<Localidad> misLocalidades = prov.getLocalidades();
        
        miModeloCombo2.addElement("Seleccione una Localidad");
        for(Localidad miLocalidad:misLocalidades){
            miModeloCombo2.addElement(miLocalidad.getNombre());            
        }
        cmbLocalidad.setModel(miModeloCombo2);
    }
    
    private void CargarComboSuc(Localidad loc){
        miModeloCombo3= new DefaultComboBoxModel();
        List<Sucursal> misSucursales = cLocal.dameSucursales();
        miModeloCombo3.addElement("Seleccione una Sucursal");
        for(Sucursal miSucursal:misSucursales){
            
            miModeloCombo3.addElement(miSucursal.getCodSuc());            
        }
        cmbSucursal.setModel(miModeloCombo3);
    }
    
    private void CargarComboEsp(){
        miModeloCombo4= new DefaultComboBoxModel();
        List<Especialidad> misEsp = cLocal.dameEspecialidades();
        
        miModeloCombo4.addElement("Seleccione una Especialidad");
        for(Especialidad miEsp:misEsp){
            miModeloCombo4.addElement(miEsp.getNombre());            
        }
        cmbEspecialidad.setModel(miModeloCombo4);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField HoraEntra;
    private javax.swing.JTextField HoraSale;
    private javax.swing.JTextField MinEntra;
    private javax.swing.JTextField MinSale;
    public static javax.swing.ButtonGroup Rol;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAceptar1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cmbEspecialidad;
    private javax.swing.JComboBox cmbLocalidad;
    private javax.swing.JComboBox cmbProvincia;
    private javax.swing.JComboBox cmbSucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelDNI;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelDatos1;
    private javax.swing.JPanel jPanelDatos2;
    private javax.swing.JPanel jPanelDatos3;
    private javax.swing.JPanel jPanelNuevoEmpleado;
    private javax.swing.JPanel jPanelUbicacion;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbProvincia;
    private javax.swing.JLabel lblCalle;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblEspecialidad;
    private javax.swing.JLabel lblHoraEnt;
    private javax.swing.JLabel lblHoraMAX;
    private javax.swing.JLabel lblHoraMIN;
    private javax.swing.JLabel lblHoraSal;
    private javax.swing.JLabel lblLocalidad;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblPassC;
    private javax.swing.JLabel lblSueldo;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTelefono1;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtPassC;
    private javax.swing.JTextField txtSueldo;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
