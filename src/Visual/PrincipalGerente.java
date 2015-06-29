package Visual;

import Visual.Nuevo.*;
import Images.ImagenFondo;
import LogicaDeNegocios.*;
import java.awt.Dimension;
import static java.awt.image.ImageObserver.HEIGHT;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;

public class PrincipalGerente extends javax.swing.JFrame {

    Controladora c;
    Empleado emp;
    
    public PrincipalGerente(Controladora c, Empleado user) {
        initComponents();
        Escritorio.setBorder(new ImagenFondo());
        setIconImage(new ImageIcon(getClass().getResource("/Images/Load.png")).getImage());
        this.c = c;
        emp = user;
        setLocationRelativeTo(null);
        String nom = c.dameEmpresas().get(0).getNombre();
        setTitle(nom+" - Inicio de Sesión");
        tipoUsuario(user);
    }

    private void tipoUsuario(Empleado user){
        int tipo=0;
        if (user instanceof Encargado)     tipo = 1;
        else if (user instanceof AtencionPublico)     tipo = 2;
        else if (user instanceof Mecanico)     tipo = 3;
        else if (user instanceof Perito)     tipo = 4;
        
        switch(tipo) {
            case 1:
                break;
            case 2:
                esATP(); break;
            case 3:
                esMecanico(); break;
            case 4:
                esPerito();break;
        }
    }
    
    private void esATP(){
        enComun();
        btnMenuAutorizaciones.hide();
        btnAPedidoInterno.hide();
        btnAOrdenTrabajo.hide();
        btnMPedidoInterno.hide();
        btnMOrdenTrabajo.hide();
        btnBPedidoInterno.hide();
        btnBOrdenTrabajo.hide();
    }
    private void esMecanico(){
        enComun();
        btnMenuBuscar.hide();
        btnMenuAutorizaciones.hide();        
        btnACliente.hide();
        btnAVehiculo.hide();
        btnAPedidoExterno.hide();
        btnMenuTurnos.hide();
        spA1.hide();
        btnMCliente.hide();
        btnMPedidoExterno.hide();
        btnMVehiculo.hide();
        spM1.hide();
        btnBCliente.hide();
        btnBVehiculo.hide();
        btnBPedidoExterno.hide();
        spB1.hide();

    }
    private void esPerito(){
        enComun();
        btnMenuBuscar.hide();
        btnAlta.hide();
        btnModificacion.hide();
        btnBaja.hide();

        
//        btnMenuTurnos.hide();
//        btnAOrdenTrabajo.hide();
//        btnACliente.hide();
//        btnAVehiculo.hide();
//        btnAPedidoExterno.hide();
//        btnAPedidoInterno.hide();
//        
//        btnMOrdenTrabajo.hide();        
//        btnMCliente.hide();
//        btnMVehiculo.hide();
//        btnMPedidoExterno.hide();
//        btnMPedidoInterno.hide();
//        
//        btnBOrdenTrabajo.hide();
//        btnBCliente.hide();
//        btnBVehiculo.hide();
//        btnBPedidoExterno.hide();
//        btnBPedidoInterno.hide();

    }
    private void enComun(){
        btnMenuMapa.hide();
        btnAProveedor.hide();
        btnASucursal.hide();
        btnASegmento.hide();
        btnAMarca.hide();
        btnAModelo.hide();
        btnAGrupoParte.hide();
        btnAAutoparte.hide();
        btnANivelSeveridad.hide();
        btnANivelImportancia.hide();
        btnAEstado.hide();
        btnAEspecialidad.hide();
        btnAActividad.hide();
        btnADetalleActividad.hide();
        btnASector.hide();
        btnAEmpleado.hide();
        btnACategoria.hide();
        spA2.hide();
        spA3.hide();
        spA4.hide();
        spA5.hide();
        
        btnMProveedor.hide();        
        btnMSucursal.hide();
        btnMSegmento.hide();
        btnMMarca.hide();
        btnMModelo.hide();
        btnMGrupoParte.hide();
        btnMAutoparte.hide();
        btnMNivelSeveridad.hide();
        btnMNivelImportancia.hide();
        btnMEstado.hide();
        btnMEspecialidad.hide();
        btnMActividad.hide();
        btnMDetalleActividad.hide();
        btnMSector.hide();
        btnMEmpleado.hide();
        btnMCategoria.hide();
        spM2.hide();
        spM3.hide();
        spM4.hide();
        spM5.hide();
        
        btnBProveedor.hide();
        btnBSucursal.hide();
        btnBSegmento.hide();
        btnBMarca.hide();
        btnBModelo.hide();
        btnBGrupoParte.hide();
        btnBAutoparte.hide();
        btnBNivelSeveridad.hide();
        btnBNivelImportancia.hide();
        btnBEstado.hide();
        btnBEspecialidad.hide();
        btnBActividad.hide();
        btnBDetalleActividad.hide();
        btnBSector.hide();
        btnBEmpleado.hide();
        btnBCategoria.hide();
        spB2.hide();
        spB3.hide();
        spB4.hide();
        spB5.hide();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem37 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        Escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnMenuArchivo = new javax.swing.JMenu();
        btnAlta = new javax.swing.JMenu();
        btnACliente = new javax.swing.JMenuItem();
        btnAVehiculo = new javax.swing.JMenuItem();
        btnAProveedor = new javax.swing.JMenuItem();
        btnASucursal = new javax.swing.JMenuItem();
        spA1 = new javax.swing.JPopupMenu.Separator();
        btnASegmento = new javax.swing.JMenuItem();
        btnAMarca = new javax.swing.JMenuItem();
        btnAModelo = new javax.swing.JMenuItem();
        spA2 = new javax.swing.JPopupMenu.Separator();
        btnAGrupoParte = new javax.swing.JMenuItem();
        btnAAutoparte = new javax.swing.JMenuItem();
        spA3 = new javax.swing.JPopupMenu.Separator();
        btnANivelSeveridad = new javax.swing.JMenuItem();
        btnAEstado = new javax.swing.JMenuItem();
        btnANivelImportancia = new javax.swing.JMenuItem();
        spA4 = new javax.swing.JPopupMenu.Separator();
        btnAEspecialidad = new javax.swing.JMenuItem();
        btnACategoria = new javax.swing.JMenuItem();
        btnAActividad = new javax.swing.JMenuItem();
        btnADetalleActividad = new javax.swing.JMenuItem();
        spA5 = new javax.swing.JPopupMenu.Separator();
        btnASector = new javax.swing.JMenuItem();
        btnAEmpleado = new javax.swing.JMenuItem();
        btnAOrdenTrabajo = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        btnAPedidoExterno = new javax.swing.JMenuItem();
        btnAPedidoInterno = new javax.swing.JMenuItem();
        btnModificacion = new javax.swing.JMenu();
        btnMCliente = new javax.swing.JMenuItem();
        btnMVehiculo = new javax.swing.JMenuItem();
        btnMProveedor = new javax.swing.JMenuItem();
        btnMSucursal = new javax.swing.JMenuItem();
        spM1 = new javax.swing.JPopupMenu.Separator();
        btnMSegmento = new javax.swing.JMenuItem();
        btnMMarca = new javax.swing.JMenuItem();
        btnMModelo = new javax.swing.JMenuItem();
        spM2 = new javax.swing.JPopupMenu.Separator();
        btnMGrupoParte = new javax.swing.JMenuItem();
        btnMAutoparte = new javax.swing.JMenuItem();
        spM3 = new javax.swing.JPopupMenu.Separator();
        btnMNivelSeveridad = new javax.swing.JMenuItem();
        btnMEstado = new javax.swing.JMenuItem();
        btnMNivelImportancia = new javax.swing.JMenuItem();
        spM4 = new javax.swing.JPopupMenu.Separator();
        btnMEspecialidad = new javax.swing.JMenuItem();
        btnMCategoria = new javax.swing.JMenuItem();
        btnMActividad = new javax.swing.JMenuItem();
        btnMDetalleActividad = new javax.swing.JMenuItem();
        spM5 = new javax.swing.JPopupMenu.Separator();
        btnMSector = new javax.swing.JMenuItem();
        btnMEmpleado = new javax.swing.JMenuItem();
        btnMOrdenTrabajo = new javax.swing.JMenuItem();
        spM6 = new javax.swing.JPopupMenu.Separator();
        btnMPedidoExterno = new javax.swing.JMenuItem();
        btnMPedidoInterno = new javax.swing.JMenuItem();
        btnBaja = new javax.swing.JMenu();
        btnBCliente = new javax.swing.JMenuItem();
        btnBVehiculo = new javax.swing.JMenuItem();
        btnBProveedor = new javax.swing.JMenuItem();
        btnBSucursal = new javax.swing.JMenuItem();
        spB1 = new javax.swing.JPopupMenu.Separator();
        btnBSegmento = new javax.swing.JMenuItem();
        btnBMarca = new javax.swing.JMenuItem();
        btnBModelo = new javax.swing.JMenuItem();
        spB2 = new javax.swing.JPopupMenu.Separator();
        btnBGrupoParte = new javax.swing.JMenuItem();
        btnBAutoparte = new javax.swing.JMenuItem();
        spB3 = new javax.swing.JPopupMenu.Separator();
        btnBNivelSeveridad = new javax.swing.JMenuItem();
        btnBEstado = new javax.swing.JMenuItem();
        btnBNivelImportancia = new javax.swing.JMenuItem();
        spB4 = new javax.swing.JPopupMenu.Separator();
        btnBEspecialidad = new javax.swing.JMenuItem();
        btnBCategoria = new javax.swing.JMenuItem();
        btnBActividad = new javax.swing.JMenuItem();
        btnBDetalleActividad = new javax.swing.JMenuItem();
        spB5 = new javax.swing.JPopupMenu.Separator();
        btnBSector = new javax.swing.JMenuItem();
        btnBEmpleado = new javax.swing.JMenuItem();
        btnBOrdenTrabajo = new javax.swing.JMenuItem();
        spB6 = new javax.swing.JPopupMenu.Separator();
        btnBPedidoExterno = new javax.swing.JMenuItem();
        btnBPedidoInterno = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        btnCerrarSesion = new javax.swing.JMenuItem();
        btnMenuBuscar = new javax.swing.JMenu();
        btnSucCercana = new javax.swing.JMenuItem();
        btnMenuAutorizaciones = new javax.swing.JMenu();
        btnAutorizaPedidoInterno = new javax.swing.JMenuItem();
        btnMenuMapa = new javax.swing.JMenu();
        btnAGeografia = new javax.swing.JMenuItem();
        btnMGeografia = new javax.swing.JMenuItem();
        btnBGeografia = new javax.swing.JMenuItem();
        btnMenuTurnos = new javax.swing.JMenu();
        btnTurnos = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem14.setText("jMenuItem14");

        jMenuItem37.setText("jMenuItem37");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem8.setText("jMenuItem8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        btnMenuArchivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMenuArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1414891425_edit-notes.png"))); // NOI18N
        btnMenuArchivo.setText("Archivo");
        btnMenuArchivo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnAlta.setText("Nuevo");

        btnACliente.setText("Cliente");
        btnACliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAClienteActionPerformed(evt);
            }
        });
        btnAlta.add(btnACliente);

        btnAVehiculo.setText("Vehículo");
        btnAVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAVehiculoActionPerformed(evt);
            }
        });
        btnAlta.add(btnAVehiculo);

        btnAProveedor.setText("Proveedor");
        btnAProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAProveedorActionPerformed(evt);
            }
        });
        btnAlta.add(btnAProveedor);

        btnASucursal.setText("Sucursal");
        btnASucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnASucursalActionPerformed(evt);
            }
        });
        btnAlta.add(btnASucursal);
        btnAlta.add(spA1);

        btnASegmento.setText("Segmento");
        btnASegmento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnASegmentoActionPerformed(evt);
            }
        });
        btnAlta.add(btnASegmento);

        btnAMarca.setText("Marca");
        btnAMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAMarcaActionPerformed(evt);
            }
        });
        btnAlta.add(btnAMarca);

        btnAModelo.setText("Modelo");
        btnAModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAModeloActionPerformed(evt);
            }
        });
        btnAlta.add(btnAModelo);
        btnAlta.add(spA2);

        btnAGrupoParte.setText("Grupo de Partes");
        btnAGrupoParte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAGrupoParteActionPerformed(evt);
            }
        });
        btnAlta.add(btnAGrupoParte);

        btnAAutoparte.setText("Autoparte");
        btnAAutoparte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAAutoparteActionPerformed(evt);
            }
        });
        btnAlta.add(btnAAutoparte);
        btnAlta.add(spA3);

        btnANivelSeveridad.setText("Nivel de Severidad");
        btnANivelSeveridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnANivelSeveridadActionPerformed(evt);
            }
        });
        btnAlta.add(btnANivelSeveridad);

        btnAEstado.setText("Estado ");
        btnAEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAEstadoActionPerformed(evt);
            }
        });
        btnAlta.add(btnAEstado);

        btnANivelImportancia.setText("Nivel de Importancia");
        btnANivelImportancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnANivelImportanciaActionPerformed(evt);
            }
        });
        btnAlta.add(btnANivelImportancia);
        btnAlta.add(spA4);

        btnAEspecialidad.setText("Especialidad");
        btnAEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAEspecialidadActionPerformed(evt);
            }
        });
        btnAlta.add(btnAEspecialidad);

        btnACategoria.setText("Categoria");
        btnACategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnACategoriaActionPerformed(evt);
            }
        });
        btnAlta.add(btnACategoria);

        btnAActividad.setText("Actividad");
        btnAActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAActividadActionPerformed(evt);
            }
        });
        btnAlta.add(btnAActividad);

        btnADetalleActividad.setText("Detalle de Actividad");
        btnADetalleActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADetalleActividadActionPerformed(evt);
            }
        });
        btnAlta.add(btnADetalleActividad);
        btnAlta.add(spA5);

        btnASector.setText("Sector");
        btnASector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnASectorActionPerformed(evt);
            }
        });
        btnAlta.add(btnASector);

        btnAEmpleado.setText("Empleado");
        btnAEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAEmpleadoActionPerformed(evt);
            }
        });
        btnAlta.add(btnAEmpleado);

        btnAOrdenTrabajo.setText("Orden de Trabajo");
        btnAlta.add(btnAOrdenTrabajo);
        btnAlta.add(jSeparator6);

        btnAPedidoExterno.setText("Pedido Externo");
        btnAlta.add(btnAPedidoExterno);

        btnAPedidoInterno.setText("Pedido Interno");
        btnAPedidoInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAPedidoInternoActionPerformed(evt);
            }
        });
        btnAlta.add(btnAPedidoInterno);

        btnMenuArchivo.add(btnAlta);

        btnModificacion.setText("Editar");

        btnMCliente.setText("Cliente");
        btnModificacion.add(btnMCliente);

        btnMVehiculo.setText("Vehiculo");
        btnModificacion.add(btnMVehiculo);

        btnMProveedor.setText("Proveedor");
        btnMProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMProveedorActionPerformed(evt);
            }
        });
        btnModificacion.add(btnMProveedor);

        btnMSucursal.setText("Sucursal");
        btnModificacion.add(btnMSucursal);
        btnModificacion.add(spM1);

        btnMSegmento.setText("Segmento");
        btnModificacion.add(btnMSegmento);

        btnMMarca.setText("Marca");
        btnModificacion.add(btnMMarca);

        btnMModelo.setText("Modelo");
        btnMModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMModeloActionPerformed(evt);
            }
        });
        btnModificacion.add(btnMModelo);
        btnModificacion.add(spM2);

        btnMGrupoParte.setText("Grupo de Partes");
        btnModificacion.add(btnMGrupoParte);

        btnMAutoparte.setText("Autoparte");
        btnModificacion.add(btnMAutoparte);
        btnModificacion.add(spM3);

        btnMNivelSeveridad.setText("Nivel de Severidad");
        btnModificacion.add(btnMNivelSeveridad);

        btnMEstado.setText("Estado");
        btnModificacion.add(btnMEstado);

        btnMNivelImportancia.setText("Nivel de Importancia");
        btnMNivelImportancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMNivelImportanciaActionPerformed(evt);
            }
        });
        btnModificacion.add(btnMNivelImportancia);
        btnModificacion.add(spM4);

        btnMEspecialidad.setText("Especialidad");
        btnModificacion.add(btnMEspecialidad);

        btnMCategoria.setText("Categoria");
        btnModificacion.add(btnMCategoria);

        btnMActividad.setText("Actividad");
        btnModificacion.add(btnMActividad);

        btnMDetalleActividad.setText("Detalle de Actividad");
        btnModificacion.add(btnMDetalleActividad);
        btnModificacion.add(spM5);

        btnMSector.setText("Sector");
        btnModificacion.add(btnMSector);

        btnMEmpleado.setText("Empleado");
        btnMEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMEmpleadoActionPerformed(evt);
            }
        });
        btnModificacion.add(btnMEmpleado);

        btnMOrdenTrabajo.setText("Orden de Trabajo");
        btnModificacion.add(btnMOrdenTrabajo);
        btnModificacion.add(spM6);

        btnMPedidoExterno.setText("Pedido Externo");
        btnModificacion.add(btnMPedidoExterno);

        btnMPedidoInterno.setText("Pedido Interno");
        btnMPedidoInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMPedidoInternoActionPerformed(evt);
            }
        });
        btnModificacion.add(btnMPedidoInterno);

        btnMenuArchivo.add(btnModificacion);

        btnBaja.setText("Baja");

        btnBCliente.setText("Cliente");
        btnBaja.add(btnBCliente);

        btnBVehiculo.setText("Vehiculo");
        btnBaja.add(btnBVehiculo);

        btnBProveedor.setText("Proveedor");
        btnBProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBProveedorActionPerformed(evt);
            }
        });
        btnBaja.add(btnBProveedor);

        btnBSucursal.setText("Sucursal");
        btnBaja.add(btnBSucursal);
        btnBaja.add(spB1);

        btnBSegmento.setText("Segmento");
        btnBaja.add(btnBSegmento);

        btnBMarca.setText("Marca");
        btnBaja.add(btnBMarca);

        btnBModelo.setText("Modelo");
        btnBModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBModeloActionPerformed(evt);
            }
        });
        btnBaja.add(btnBModelo);
        btnBaja.add(spB2);

        btnBGrupoParte.setText("Grupo de Partes");
        btnBaja.add(btnBGrupoParte);

        btnBAutoparte.setText("Autoparte");
        btnBaja.add(btnBAutoparte);
        btnBaja.add(spB3);

        btnBNivelSeveridad.setText("Nivel de Severidad");
        btnBaja.add(btnBNivelSeveridad);

        btnBEstado.setText("Estado");
        btnBaja.add(btnBEstado);

        btnBNivelImportancia.setText("Nivel de Importancia");
        btnBaja.add(btnBNivelImportancia);
        btnBaja.add(spB4);

        btnBEspecialidad.setText("Especialidad");
        btnBaja.add(btnBEspecialidad);

        btnBCategoria.setText("Categoria");
        btnBaja.add(btnBCategoria);

        btnBActividad.setText("Actividad");
        btnBaja.add(btnBActividad);

        btnBDetalleActividad.setText("Detalle de Actividad");
        btnBaja.add(btnBDetalleActividad);
        btnBaja.add(spB5);

        btnBSector.setText("Sector");
        btnBaja.add(btnBSector);

        btnBEmpleado.setText("Empleado");
        btnBEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBEmpleadoActionPerformed(evt);
            }
        });
        btnBaja.add(btnBEmpleado);

        btnBOrdenTrabajo.setText("Orden de Trabajo");
        btnBaja.add(btnBOrdenTrabajo);
        btnBaja.add(spB6);

        btnBPedidoExterno.setText("Pedido Externo");
        btnBaja.add(btnBPedidoExterno);

        btnBPedidoInterno.setText("Pedido Interno");
        btnBPedidoInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBPedidoInternoActionPerformed(evt);
            }
        });
        btnBaja.add(btnBPedidoInterno);

        btnMenuArchivo.add(btnBaja);
        btnMenuArchivo.add(jSeparator1);

        btnCerrarSesion.setText("Cerrar Sesion");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        btnMenuArchivo.add(btnCerrarSesion);

        jMenuBar1.add(btnMenuArchivo);

        btnMenuBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMenuBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1414891466_search.png"))); // NOI18N
        btnMenuBuscar.setText("Buscar");

        btnSucCercana.setText("Sucursal más cercana");
        btnSucCercana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSucCercanaActionPerformed(evt);
            }
        });
        btnMenuBuscar.add(btnSucCercana);

        jMenuBar1.add(btnMenuBuscar);

        btnMenuAutorizaciones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMenuAutorizaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1414891425_edit-notes.png"))); // NOI18N
        btnMenuAutorizaciones.setText("Autorizaciones");

        btnAutorizaPedidoInterno.setText("Pedido Interno");
        btnMenuAutorizaciones.add(btnAutorizaPedidoInterno);

        jMenuBar1.add(btnMenuAutorizaciones);

        btnMenuMapa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMenuMapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mundo.png"))); // NOI18N
        btnMenuMapa.setText("Mapa");

        btnAGeografia.setText("Nuevo");
        btnAGeografia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAGeografiaActionPerformed(evt);
            }
        });
        btnMenuMapa.add(btnAGeografia);

        btnMGeografia.setText("Editar");
        btnMenuMapa.add(btnMGeografia);

        btnBGeografia.setText("Baja");
        btnBGeografia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBGeografiaActionPerformed(evt);
            }
        });
        btnMenuMapa.add(btnBGeografia);

        jMenuBar1.add(btnMenuMapa);

        btnMenuTurnos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMenuTurnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1414891509_add-address.png"))); // NOI18N
        btnMenuTurnos.setText("Turnos");

        btnTurnos.setText("Ver turnos");
        btnTurnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTurnosActionPerformed(evt);
            }
        });
        btnMenuTurnos.add(btnTurnos);

        jMenuBar1.add(btnMenuTurnos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAVehiculoActionPerformed
        NuevoVehiculo nv = new NuevoVehiculo(c, Escritorio);
        
        Dimension desktopSize = Escritorio.getSize();
        Dimension jInternalFrameSize = nv.getSize();
        nv.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height - jInternalFrameSize.height)/2);
        
        Escritorio.add(nv);
        nv.show();
    }//GEN-LAST:event_btnAVehiculoActionPerformed

    private void btnASucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnASucursalActionPerformed
        NuevaSucursal nsuc = new NuevaSucursal(c);
        
        Dimension desktopSize = Escritorio.getSize();
        Dimension jInternalFrameSize = nsuc.getSize();
        nsuc.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height - jInternalFrameSize.height)/2);
        
        Escritorio.add(nsuc);
        nsuc.show();
    }//GEN-LAST:event_btnASucursalActionPerformed

    private void btnAGrupoParteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAGrupoParteActionPerformed
        NuevoGrupoPartes ngp = new NuevoGrupoPartes(c);
        
        Dimension desktopSize = Escritorio.getSize();
        Dimension jInternalFrameSize = ngp.getSize();
        ngp.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height - jInternalFrameSize.height)/2);
        
        Escritorio.add(ngp);
        ngp.show();
    }//GEN-LAST:event_btnAGrupoParteActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        Inicial pg = new Inicial();
        pg.setResizable(false);
        pg.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnAModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAModeloActionPerformed
        NuevoModelo nmod = new NuevoModelo(c);
        
        Dimension desktopSize = Escritorio.getSize();
        Dimension jInternalFrameSize = nmod.getSize();
        nmod.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height - jInternalFrameSize.height)/2);
        
        Escritorio.add(nmod);
        nmod.show();
    }//GEN-LAST:event_btnAModeloActionPerformed

    private void btnAClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAClienteActionPerformed
        NuevoCliente nc = new NuevoCliente(c);
        
        Dimension desktopSize = Escritorio.getSize();
        Dimension jInternalFrameSize = nc.getSize();
        nc.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height - jInternalFrameSize.height)/2);
        
        Escritorio.add(nc);
        nc.show();
    }//GEN-LAST:event_btnAClienteActionPerformed

    private void btnMProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMProveedorActionPerformed

    private void btnMModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMModeloActionPerformed

    private void btnMPedidoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMPedidoInternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMPedidoInternoActionPerformed

    private void btnMEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMEmpleadoActionPerformed

    private void btnBProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBProveedorActionPerformed

    private void btnBModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBModeloActionPerformed

    private void btnBEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBEmpleadoActionPerformed

    private void btnBPedidoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBPedidoInternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBPedidoInternoActionPerformed

    private void btnAProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAProveedorActionPerformed
        NuevoProveedor np = new NuevoProveedor(c);
        
        Dimension desktopSize = Escritorio.getSize();
        Dimension jInternalFrameSize = np.getSize();
        np.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height - jInternalFrameSize.height)/2);
        
        Escritorio.add(np);
        np.show();
    }//GEN-LAST:event_btnAProveedorActionPerformed

    private void btnAGeografiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAGeografiaActionPerformed
        Mapa map = new Mapa(Escritorio, c);
        
        Dimension desktopSize = Escritorio.getSize();
        Dimension jInternalFrameSize = map.getSize();
        map.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height - jInternalFrameSize.height)/2);
        
        Escritorio.add(map);
        map.show();        
    }//GEN-LAST:event_btnAGeografiaActionPerformed

    private void btnASegmentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnASegmentoActionPerformed
        NuevoSegmento nseg = new NuevoSegmento(c);
        
        Dimension desktopSize = Escritorio.getSize();
        Dimension jInternalFrameSize = nseg.getSize();
        nseg.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height - jInternalFrameSize.height)/2);
        
        Escritorio.add(nseg);
        nseg.show();  
    }//GEN-LAST:event_btnASegmentoActionPerformed

    private void btnAMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAMarcaActionPerformed
        NuevaMarca nmar = new NuevaMarca(c);
        
        Dimension desktopSize = Escritorio.getSize();
        Dimension jInternalFrameSize = nmar.getSize();
        nmar.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height - jInternalFrameSize.height)/2);
        
        Escritorio.add(nmar);
        nmar.show(); 
    }//GEN-LAST:event_btnAMarcaActionPerformed

    private void btnAAutoparteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAAutoparteActionPerformed
        NuevaAutoparte na = new NuevaAutoparte(c);
        
        Dimension desktopSize = Escritorio.getSize();
        Dimension jInternalFrameSize = na.getSize();
        na.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height - jInternalFrameSize.height)/2);
        
        Escritorio.add(na);
        na.show();
    }//GEN-LAST:event_btnAAutoparteActionPerformed


    private void btnSucCercanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSucCercanaActionPerformed
    }//GEN-LAST:event_btnSucCercanaActionPerformed

    private void btnAEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAEstadoActionPerformed
        NuevoEstado nest = new NuevoEstado(c);
        
        Dimension desktopSize = Escritorio.getSize();
        Dimension jInternalFrameSize = nest.getSize();
        nest.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height - jInternalFrameSize.height)/2);
        
        Escritorio.add(nest);
        nest.show();
    }//GEN-LAST:event_btnAEstadoActionPerformed

    private void btnANivelImportanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnANivelImportanciaActionPerformed
       NuevoNivelImportancia nimp = new NuevoNivelImportancia(c);
        
        Dimension desktopSize = Escritorio.getSize();
        Dimension jInternalFrameSize = nimp.getSize();
        nimp.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height - jInternalFrameSize.height)/2);
        
        Escritorio.add(nimp);
        nimp.show();
    }//GEN-LAST:event_btnANivelImportanciaActionPerformed

    private void btnAEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAEmpleadoActionPerformed
        NuevoEmpleado ne = new NuevoEmpleado(c);
        
        Dimension desktopSize = Escritorio.getSize();
        Dimension jInternalFrameSize = ne.getSize();
        ne.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height - jInternalFrameSize.height)/2);
        
        Escritorio.add(ne);
        ne.show();
    }//GEN-LAST:event_btnAEmpleadoActionPerformed

    private void btnAActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAActividadActionPerformed
        NuevaActividad ne = new NuevaActividad(c);
        
        Dimension desktopSize = Escritorio.getSize();
        Dimension jInternalFrameSize = ne.getSize();
        ne.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height - jInternalFrameSize.height)/2);
        
        Escritorio.add(ne);
        ne.show();
    }//GEN-LAST:event_btnAActividadActionPerformed

    private void btnADetalleActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADetalleActividadActionPerformed
        NuevoDetalleActividad ne = new NuevoDetalleActividad(c);
        
        Dimension desktopSize = Escritorio.getSize();
        Dimension jInternalFrameSize = ne.getSize();
        ne.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height - jInternalFrameSize.height)/2);
        
        Escritorio.add(ne);
        ne.show();    }//GEN-LAST:event_btnADetalleActividadActionPerformed

    private void btnANivelSeveridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnANivelSeveridadActionPerformed
        NuevoNivelSeveridad nn = new NuevoNivelSeveridad(c);
        
        Dimension desktopSize = Escritorio.getSize();
        Dimension jInternalFrameSize = nn.getSize();
        nn.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height - jInternalFrameSize.height)/2);
        
        Escritorio.add(nn);
        nn.show();
    }//GEN-LAST:event_btnANivelSeveridadActionPerformed

    private void btnASectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnASectorActionPerformed
        NuevoSector nsec = new NuevoSector(c);
        
        Dimension desktopSize = Escritorio.getSize();
        Dimension jInternalFrameSize = nsec.getSize();
        nsec.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height - jInternalFrameSize.height)/2);
        
        Escritorio.add(nsec);
        nsec.show();
    }//GEN-LAST:event_btnASectorActionPerformed

    private void btnACategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnACategoriaActionPerformed
        NuevaCategoria ncat = new NuevaCategoria(c);
        
        Dimension desktopSize = Escritorio.getSize();
        Dimension jInternalFrameSize = ncat.getSize();
        ncat.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height - jInternalFrameSize.height)/2);
        
        Escritorio.add(ncat);
        ncat.show();
    }//GEN-LAST:event_btnACategoriaActionPerformed

    private void btnAEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAEspecialidadActionPerformed
        NuevaEspecialidad ne = new NuevaEspecialidad(c);
        
        Dimension desktopSize = Escritorio.getSize();
        Dimension jInternalFrameSize = ne.getSize();
        ne.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height - jInternalFrameSize.height)/2);
        
        Escritorio.add(ne);
        ne.show();
    }//GEN-LAST:event_btnAEspecialidadActionPerformed

    private void btnAPedidoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAPedidoInternoActionPerformed
        NuevoInterno ni = new NuevoInterno(c, emp);
        
        Dimension desktopSize = Escritorio.getSize();
        Dimension jInternalFrameSize = ni.getSize();
        ni.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height - jInternalFrameSize.height)/2);
        
        Escritorio.add(ni);
        ni.show();
    }//GEN-LAST:event_btnAPedidoInternoActionPerformed

    private void btnMNivelImportanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMNivelImportanciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMNivelImportanciaActionPerformed

    private void btnBGeografiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBGeografiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBGeografiaActionPerformed

    private void btnTurnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurnosActionPerformed
        Turnos ni = new Turnos(Escritorio, c);
        
        Dimension desktopSize = Escritorio.getSize();
        Dimension jInternalFrameSize = ni.getSize();
        ni.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height - jInternalFrameSize.height)/2);
        
        Escritorio.add(ni);
        ni.show();
    }//GEN-LAST:event_btnTurnosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenuItem btnAActividad;
    private javax.swing.JMenuItem btnAAutoparte;
    private javax.swing.JMenuItem btnACategoria;
    private javax.swing.JMenuItem btnACliente;
    private javax.swing.JMenuItem btnADetalleActividad;
    private javax.swing.JMenuItem btnAEmpleado;
    private javax.swing.JMenuItem btnAEspecialidad;
    private javax.swing.JMenuItem btnAEstado;
    private javax.swing.JMenuItem btnAGeografia;
    private javax.swing.JMenuItem btnAGrupoParte;
    private javax.swing.JMenuItem btnAMarca;
    private javax.swing.JMenuItem btnAModelo;
    private javax.swing.JMenuItem btnANivelImportancia;
    private javax.swing.JMenuItem btnANivelSeveridad;
    private javax.swing.JMenuItem btnAOrdenTrabajo;
    private javax.swing.JMenuItem btnAPedidoExterno;
    private javax.swing.JMenuItem btnAPedidoInterno;
    private javax.swing.JMenuItem btnAProveedor;
    private javax.swing.JMenuItem btnASector;
    private javax.swing.JMenuItem btnASegmento;
    private javax.swing.JMenuItem btnASucursal;
    private javax.swing.JMenuItem btnAVehiculo;
    private javax.swing.JMenu btnAlta;
    private javax.swing.JMenuItem btnAutorizaPedidoInterno;
    private javax.swing.JMenuItem btnBActividad;
    private javax.swing.JMenuItem btnBAutoparte;
    private javax.swing.JMenuItem btnBCategoria;
    private javax.swing.JMenuItem btnBCliente;
    private javax.swing.JMenuItem btnBDetalleActividad;
    private javax.swing.JMenuItem btnBEmpleado;
    private javax.swing.JMenuItem btnBEspecialidad;
    private javax.swing.JMenuItem btnBEstado;
    private javax.swing.JMenuItem btnBGeografia;
    private javax.swing.JMenuItem btnBGrupoParte;
    private javax.swing.JMenuItem btnBMarca;
    private javax.swing.JMenuItem btnBModelo;
    private javax.swing.JMenuItem btnBNivelImportancia;
    private javax.swing.JMenuItem btnBNivelSeveridad;
    private javax.swing.JMenuItem btnBOrdenTrabajo;
    private javax.swing.JMenuItem btnBPedidoExterno;
    private javax.swing.JMenuItem btnBPedidoInterno;
    private javax.swing.JMenuItem btnBProveedor;
    private javax.swing.JMenuItem btnBSector;
    private javax.swing.JMenuItem btnBSegmento;
    private javax.swing.JMenuItem btnBSucursal;
    private javax.swing.JMenuItem btnBVehiculo;
    private javax.swing.JMenu btnBaja;
    private javax.swing.JMenuItem btnCerrarSesion;
    private javax.swing.JMenuItem btnMActividad;
    private javax.swing.JMenuItem btnMAutoparte;
    private javax.swing.JMenuItem btnMCategoria;
    private javax.swing.JMenuItem btnMCliente;
    private javax.swing.JMenuItem btnMDetalleActividad;
    private javax.swing.JMenuItem btnMEmpleado;
    private javax.swing.JMenuItem btnMEspecialidad;
    private javax.swing.JMenuItem btnMEstado;
    private javax.swing.JMenuItem btnMGeografia;
    private javax.swing.JMenuItem btnMGrupoParte;
    private javax.swing.JMenuItem btnMMarca;
    private javax.swing.JMenuItem btnMModelo;
    private javax.swing.JMenuItem btnMNivelImportancia;
    private javax.swing.JMenuItem btnMNivelSeveridad;
    private javax.swing.JMenuItem btnMOrdenTrabajo;
    private javax.swing.JMenuItem btnMPedidoExterno;
    private javax.swing.JMenuItem btnMPedidoInterno;
    private javax.swing.JMenuItem btnMProveedor;
    private javax.swing.JMenuItem btnMSector;
    private javax.swing.JMenuItem btnMSegmento;
    private javax.swing.JMenuItem btnMSucursal;
    private javax.swing.JMenuItem btnMVehiculo;
    private javax.swing.JMenu btnMenuArchivo;
    private javax.swing.JMenu btnMenuAutorizaciones;
    private javax.swing.JMenu btnMenuBuscar;
    private javax.swing.JMenu btnMenuMapa;
    private javax.swing.JMenu btnMenuTurnos;
    private javax.swing.JMenu btnModificacion;
    private javax.swing.JMenuItem btnSucCercana;
    private javax.swing.JMenuItem btnTurnos;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem37;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator spA1;
    private javax.swing.JPopupMenu.Separator spA2;
    private javax.swing.JPopupMenu.Separator spA3;
    private javax.swing.JPopupMenu.Separator spA4;
    private javax.swing.JPopupMenu.Separator spA5;
    private javax.swing.JPopupMenu.Separator spB1;
    private javax.swing.JPopupMenu.Separator spB2;
    private javax.swing.JPopupMenu.Separator spB3;
    private javax.swing.JPopupMenu.Separator spB4;
    private javax.swing.JPopupMenu.Separator spB5;
    private javax.swing.JPopupMenu.Separator spB6;
    private javax.swing.JPopupMenu.Separator spM1;
    private javax.swing.JPopupMenu.Separator spM2;
    private javax.swing.JPopupMenu.Separator spM3;
    private javax.swing.JPopupMenu.Separator spM4;
    private javax.swing.JPopupMenu.Separator spM5;
    private javax.swing.JPopupMenu.Separator spM6;
    // End of variables declaration//GEN-END:variables
}
