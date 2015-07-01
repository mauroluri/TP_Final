package Visual;

import LogicaDeNegocios.*;
import Persistencia.exceptions.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.*;

public class Inicial extends javax.swing.JFrame {

    Controladora c = new Controladora();
    DefaultComboBoxModel miModeloCombo;

    public Inicial() {
        initComponents();
        setLocationRelativeTo(null);
        String nom = c.dameEmpresas().get(0).getNombre();
        setTitle(nom+" - Inicio de Sesión");

        //Carga icono
        setIconImage(new ImageIcon(getClass().getResource("/Images/Load.png")).getImage());
        //Carga fondo
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/Images/login.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());
        cargaOpcion();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cmbOpcion = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        lblPass = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        btnIniciarsesion = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 562));
        setMinimumSize(new java.awt.Dimension(900, 562));
        setPreferredSize(new java.awt.Dimension(900, 562));
        setResizable(false);

        jPanel1.setOpaque(false);

        jLabel1.setText("Rol:");

        lblPass.setText("Contraseña:");

        lblUsuario.setText("Usuario (DNI):");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 173, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPass)
                        .addGap(18, 18, 18)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblUsuario)
                        .addGap(18, 18, 18)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cmbOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPass))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnIniciarsesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user.png"))); // NOI18N
        btnIniciarsesion.setText("Iniciar sesión");
        btnIniciarsesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciarsesion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIniciarsesion.setIconTextGap(2);
        btnIniciarsesion.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnIniciarsesion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnIniciarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarsesionActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1414891140_Log Out.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setIconTextGap(2);
        btnSalir.setMaximumSize(new java.awt.Dimension(95, 73));
        btnSalir.setMinimumSize(new java.awt.Dimension(95, 73));
        btnSalir.setPreferredSize(new java.awt.Dimension(95, 73));
        btnSalir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(424, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnIniciarsesion, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(358, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIniciarsesion, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargaOpcion(){
        if(c.dameEmpresas().isEmpty()){
            PrimeraVez pg = new PrimeraVez(c);
            pg.setResizable(false);
            pg.setVisible(true);
            pg.getFocusOwner();
        } else {
            miModeloCombo= new DefaultComboBoxModel();
            List<Empleado> misEmp = new LinkedList<Empleado>();
            Empleado emp;

            List<Encargado> e = c.dameEncargados();
            List<Perito> p = c.damePeritos();
            List<Mecanico> m = c.dameMecanicos();
            List<AtencionPublico> a = c.dameAtencionesPublico();

            Iterator<Empleado> it = misEmp.iterator();

            miModeloCombo.addElement("Seleccione un Rol");
            if (!e.isEmpty()){
                miModeloCombo.addElement("Encargado");
            }
            if (!a.isEmpty()){
                miModeloCombo.addElement("Atención al público");
            }
            if (!m.isEmpty()){
                miModeloCombo.addElement("Mecánico");
            }
            if (!p.isEmpty()){
                miModeloCombo.addElement("Perito");
            }

            cmbOpcion.setModel(miModeloCombo);
        }

    }
    
    private void btnIniciarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarsesionActionPerformed
        if(!(txtUsuario.getText().equals("") || txtPass.getPassword().equals("") || 
                cmbOpcion.getSelectedItem().equals("Seleccione un Rol"))){
            try {
                long dni = Long.parseLong(txtUsuario.getText());
                String contra = new String(txtPass.getPassword());
                String rol = cmbOpcion.getSelectedItem().toString();
                                
                
                
                //Encargado
                if(rol.equals("Encargado")){
                    try{
                        Encargado user = c.dameUnEncargado(dni);
                        if(user.getPass().equals(contra)){
                            PrincipalGerente pg = new PrincipalGerente(c, user);
                            pg.setResizable(false);
                            pg.setVisible(true);
                            this.dispose();
                        } else {
                            String err = "Contraseña incorrecta.";
                            JOptionPane.showMessageDialog(this, err, "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception e) {
                        String err = "No existe ese Encargado.";
                        System.err.println(err);
                        JOptionPane.showMessageDialog(this, err, "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
                    } 
                }
                
                //Atencion al Publico
                if(rol.equals("Atención al público")){
                    try{
                        AtencionPublico user = c.dameUnAtencionPublico(dni);
                        if(user.getPass().equals(contra)){
                            PrincipalGerente pg = new PrincipalGerente(c, user);
                            pg.setResizable(false);
                            pg.setVisible(true);
                            this.dispose();
                        } else {
                            String err = "Contraseña incorrecta.";
                            JOptionPane.showMessageDialog(this, err, "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception e) {
                        String err = "No existe ese Atención al público.";
                        System.err.println(err);
                        JOptionPane.showMessageDialog(this, err, "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
                    } 
                }
                
                //Mecánico
                if(rol.equals("Mecánico")){
                    try{
                        Mecanico user = c.dameUnMecanico(dni);
                        if(user.getPass().equals(contra)){
                            PrincipalGerente pg = new PrincipalGerente(c, user);
                            pg.setResizable(false);
                            pg.setVisible(true);
                            this.dispose();
                        } else {
                            String err = "Contraseña incorrecta.";
                            JOptionPane.showMessageDialog(this, err, "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception e) {
                        String err = "No existe ese Mecánico.";
                        System.err.println(err);
                        JOptionPane.showMessageDialog(this, err, "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
                    } 
                }
                
                if(rol.equals("Perito")){
                    try{
                        Perito user = c.dameUnPerito(dni);
                        if(user.getPass().equals(contra)){
                            PrincipalGerente pg = new PrincipalGerente(c, user);
                            pg.setResizable(false);
                            pg.setVisible(true);
                            this.dispose();
                        } else {
                            String err = "Contraseña incorrecta.";
                            JOptionPane.showMessageDialog(this, err, "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception e) {
                        String err = "No existe ese Perito.";
                        System.err.println(err);
                        JOptionPane.showMessageDialog(this, err, "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
                    } 
                }
                                
            } catch (NumberFormatException a){
                String err = "Usuario Invalido";
                JOptionPane.showMessageDialog(this, err, "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
            //} catch (PreexistingEntityException e){
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnIniciarsesionActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarsesion;
    private javax.swing.JButton btnSalir;
    public static javax.swing.JComboBox cmbOpcion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
