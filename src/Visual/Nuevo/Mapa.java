package Visual.Nuevo;

import Visual.Controladora;
import java.awt.Dimension;
import javax.swing.JDesktopPane;

public class Mapa extends javax.swing.JInternalFrame {

    Controladora cLocal;
    JDesktopPane escLocal;
    
    public Mapa(JDesktopPane esc, Controladora c) {
        initComponents();
        cLocal = c;
        escLocal = esc;
        String nom = c.dameEmpresas().get(0).getNombre();
        setTitle(nom+" - MAPA");
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAceptar = new javax.swing.JButton();
        btnAceptar4 = new javax.swing.JButton();
        jPanelMapa = new javax.swing.JPanel();
        btnNProvincia = new javax.swing.JButton();
        btnNLocalidad = new javax.swing.JButton();
        btnNCalle = new javax.swing.JButton();

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

        btnAceptar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1414891160_Check.png"))); // NOI18N
        btnAceptar4.setText("Aceptar");
        btnAceptar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAceptar4.setIconTextGap(2);
        btnAceptar4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAceptar4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAceptar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar4ActionPerformed(evt);
            }
        });

        jPanelMapa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mapa", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 36), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanelMapa.setName(""); // NOI18N

        btnNProvincia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Provincia.png"))); // NOI18N
        btnNProvincia.setText("Nueva Provincia");
        btnNProvincia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNProvincia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNProvincia.setIconTextGap(2);
        btnNProvincia.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnNProvincia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNProvinciaActionPerformed(evt);
            }
        });

        btnNLocalidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Localidad.png"))); // NOI18N
        btnNLocalidad.setText("Nueva Localidad");
        btnNLocalidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNLocalidad.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNLocalidad.setIconTextGap(2);
        btnNLocalidad.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnNLocalidad.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNLocalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNLocalidadActionPerformed(evt);
            }
        });

        btnNCalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Calle.png"))); // NOI18N
        btnNCalle.setText("Nueva Calle");
        btnNCalle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNCalle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNCalle.setIconTextGap(2);
        btnNCalle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnNCalle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNCalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNCalleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMapaLayout = new javax.swing.GroupLayout(jPanelMapa);
        jPanelMapa.setLayout(jPanelMapaLayout);
        jPanelMapaLayout.setHorizontalGroup(
            jPanelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMapaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelMapaLayout.setVerticalGroup(
            jPanelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMapaLayout.createSequentialGroup()
                .addGroup(jPanelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnNLocalidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNProvincia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnNCalle))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMapa, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAceptar4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnNProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNProvinciaActionPerformed
        NuevaProvincia np = new NuevaProvincia(this, cLocal);
        
        Dimension desktopSize = escLocal.getSize();
        Dimension jInternalFrameSize = np.getSize();
        np.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height - jInternalFrameSize.height)/2);
        
        escLocal.add(np);
        np.show();            
        this.hide();
    }//GEN-LAST:event_btnNProvinciaActionPerformed

    private void btnNLocalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNLocalidadActionPerformed
        NuevaLocalidad nl = new NuevaLocalidad(this, cLocal);
        
        Dimension desktopSize = escLocal.getSize();
        Dimension jInternalFrameSize = nl.getSize();
        nl.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height - jInternalFrameSize.height)/2);
        
        escLocal.add(nl);
        nl.show();            
        this.hide();
    }//GEN-LAST:event_btnNLocalidadActionPerformed

    private void btnNCalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNCalleActionPerformed
        NuevaCalle nc = new NuevaCalle(this, cLocal);
        
        Dimension desktopSize = escLocal.getSize();
        Dimension jInternalFrameSize = nc.getSize();
        nc.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height - jInternalFrameSize.height)/2);
        
        escLocal.add(nc);
        nc.show();            
        this.hide();
    }//GEN-LAST:event_btnNCalleActionPerformed

    private void btnAceptar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar4ActionPerformed
        this.hide();
    }//GEN-LAST:event_btnAceptar4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAceptar4;
    private javax.swing.JButton btnNCalle;
    private javax.swing.JButton btnNLocalidad;
    private javax.swing.JButton btnNProvincia;
    private javax.swing.JPanel jPanelMapa;
    // End of variables declaration//GEN-END:variables
}
