package LogicaDeNegocios;

import Persistencia.AAAControladora;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import Visual.Bienvenido;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import java.util.LinkedList;
import java.util.List;

public class TP_Final {
    
    
    //PERSISTENCIA:
    AAAControladora miPersistencia = new AAAControladora();
        
        //Accesorio
    public void crearAccesorio(int codParte, String descripcion, String caracteristicas, float precio, 
            int impuesto, boolean recambio, long stock) throws 
            PreexistingEntityException, Exception{
        Accesorio miAccesorio = new Accesorio(codParte, descripcion, caracteristicas, precio, impuesto, 
                recambio,  stock);
        miPersistencia.crearAccesorio(miAccesorio);}
    public void editarAccesorio(int codParte, String descripcion, String caracteristicas, float precio, 
            int impuesto, boolean recambio, long stock, boolean ok
            , List<Item> it, List<Modelo> mo, List<Vehiculo> ve) throws 
            NonexistentEntityException, Exception{
        Accesorio miAccesorio = this.miPersistencia.dameUnAccesorio(codParte);
        miAccesorio.setCodParte(codParte);
        miAccesorio.setBorrado(recambio);
        miAccesorio.setCaracteristicas(caracteristicas);
        miAccesorio.setDescripcion(descripcion);
        miAccesorio.setImpuesto(impuesto);
        miAccesorio.setVsModelo(mo);
        miAccesorio.setPrecio(precio);
        miAccesorio.setStock(stock);
        miAccesorio.setBorrado(ok);
        miAccesorio.setVsItem(it);
        miAccesorio.setVsVehiculo(ve);
        this.miPersistencia.editarAccesorio(miAccesorio);}
    public void eliminarAccesorio(int cod) throws NonexistentEntityException{
        this.miPersistencia.eliminarAccesorio(cod);}
    public Accesorio dameUnAccesorio(int cod){
        return this.miPersistencia.dameUnAccesorio(cod);}
    public List<Accesorio> dameAccesorios(){
        return this.miPersistencia.dameAccesorios();}
        
    //Actividad
    public void crearActividad(String nombre, Categoria categ, Date duracionTotal, GrupoParte grupo, 
            List<DetalleActividad> ac) throws PreexistingEntityException, Exception{
        Actividad miActividad = new Actividad(nombre, categ, duracionTotal, grupo, ac);
        miPersistencia.crearActividad(miActividad);}
    public void editarActividad(String nombre, Categoria categ, Date duracionTotal, GrupoParte grupo, 
            List<DetalleActividad> ac) throws PreexistingEntityException, Exception{
        Actividad miActividad = this.miPersistencia.dameUnaActividad(nombre);
        miActividad.setNombre(nombre);
        miActividad.setDuracionTotal(duracionTotal);
        miActividad.setVsEspDetActividad(ac);
        miActividad.setUnGrupoParte(grupo);
        miActividad.setVsEspDetActividad(ac);
        this.miPersistencia.editarActividad(miActividad);}
    public void eliminarActividad(String codEspActividad) throws NonexistentEntityException{
        this.miPersistencia.eliminarActividad(codEspActividad);}
    public Actividad dameUnaActividad(String codEspActividad){
        return this.miPersistencia.dameUnaActividad(codEspActividad);}
    public List<Actividad> dameActividades(){
        return this.miPersistencia.dameActividades();}
    
    //Ajuste
    public void crearAjuste(Turno unTur, int codOrden, String descripcion) 
            throws PreexistingEntityException, Exception{
        Ajuste miAjuste = new Ajuste(unTur, codOrden, descripcion);
        miPersistencia.crearAjuste(miAjuste);}
    public void editarAjuste(Turno unTur, int codOrden, String descripcion, boolean borrado,
            List<Autoparte> gp) throws PreexistingEntityException, Exception{
        Ajuste miAjuste = this.miPersistencia.dameUnAjuste(codOrden);
        miAjuste.setCodOrden(codOrden);
        miAjuste.setDescripcion(descripcion);
        miAjuste.setUnTurno(unTur);
        miAjuste.setBorrado(borrado);
        miAjuste.setVsAutoparte(gp);
        this.miPersistencia.editarAjuste(miAjuste);}
    public void eliminarAjuste(int codOrden) throws NonexistentEntityException{
        this.miPersistencia.eliminarAjuste(codOrden);}
    public Ajuste dameUnAjuste(int codOrden){
        return this.miPersistencia.dameUnAjuste(codOrden);}
    public List<Ajuste> dameAjustes(){
        return this.miPersistencia.dameAjustes();}
   
    //AtencionPublico
    public void crearAtencionPublico(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String p, Date horaInicio, Date horaFin) throws PreexistingEntityException, Exception{
        AtencionPublico miAtencionPublico = new AtencionPublico( unaLoc, unaSuc, nombre, dni, telefono, 
                sueldo, p, horaInicio, horaFin);
        miPersistencia.crearAtencionPublico(miAtencionPublico);}
    public void editarAtencionPublico(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, 
            long telefono, int sueldo, String p, Date horaInicio, Date horaFin, List<Externo> ex, boolean ok,
            List<Turno> tu) throws PreexistingEntityException, Exception{
        AtencionPublico miAtencionPublico = this.miPersistencia.dameUnAtencionPublico(dni);
        miAtencionPublico.setDni(dni);
        miAtencionPublico.setNombre(nombre);
        miAtencionPublico.setPass(p);
        miAtencionPublico.setSueldo(sueldo);
        miAtencionPublico.setTelefono(telefono);
        miAtencionPublico.setUnaLocalidad(unaLoc);
        miAtencionPublico.setUnaSucursal(unaSuc);
        miAtencionPublico.setHoraInicio(horaInicio);
        miAtencionPublico.setHoraFin(horaFin);
        miAtencionPublico.setVsExterno(ex);
        miAtencionPublico.setBorrado(ok);
        miAtencionPublico.setVsTurno(tu);
        this.miPersistencia.editarAtencionPublico(miAtencionPublico);}
    public void eliminarAtencionPublico(long dni) throws NonexistentEntityException{
        this.miPersistencia.eliminarAtencionPublico(dni);}
    public AtencionPublico dameUnAtencionPublico(long dni){
        return this.miPersistencia.dameUnAtencionPublico(dni);}
    public List<AtencionPublico> dameAtencionesPublico(){
        return this.miPersistencia.dameAtencionesPublico();}
    
    
    //Calle
    public void crearCalle(String nombre) 
            throws PreexistingEntityException, Exception{
        Calle miCalle = new Calle(nombre);
        miPersistencia.crearCalle(miCalle);}
    public void editarCalle(List<Localidad> loc, String nombre, Sucursal suc, LinkedList<Cliente> cl) 
            throws PreexistingEntityException, Exception{
        Calle miCalle = this.miPersistencia.dameUnaCalle(nombre);
        miCalle.setNombre(nombre);
        miCalle.setVsLocalidad(loc);
        miCalle.setUnaSucursal(suc);
        miCalle.setVsCliente(cl);
        this.miPersistencia.editarCalle(miCalle);}
    public void eliminarCalle(String nombre) throws NonexistentEntityException{
        this.miPersistencia.eliminarCalle(nombre);}
    public Calle dameUnaCalle(String nombre){
        return this.miPersistencia.dameUnaCalle(nombre);}
    public List<Calle> dameCalles(){
        return this.miPersistencia.dameCalles();}
    
    //Categoria
    public void crearCategoria(String nombre) 
            throws PreexistingEntityException, Exception{
        Categoria miCategoria = new Categoria(nombre);
        miPersistencia.crearCategoria(miCategoria);}
    public void editarCategoria(String nombre, LinkedList<Actividad> ac) 
            throws PreexistingEntityException, Exception{
        Categoria miCategoria = this.miPersistencia.dameUnaCategoria(nombre);
        miCategoria.setNombre(nombre);
        miCategoria.setVsEspecialidadActividad(null);
        this.miPersistencia.editarCategoria(miCategoria);}
    public void eliminarCategoria(String nombre) throws NonexistentEntityException{
        this.miPersistencia.eliminarCategoria(nombre);}
    public Categoria dameUnaCategoria(String nombre){
        return this.miPersistencia.dameUnaCategoria(nombre);}
    public List<Categoria> dameCategorias(){
        return this.miPersistencia.dameCategorias();}
    
    //Cliente
    private LinkedList<Cliente> clientes = new LinkedList<Cliente>();
    public void crearCliente(String nombre, long dni, long telefono, String email, String cuit, int altura,
            Localidad localidad, Calle calle) throws PreexistingEntityException, Exception{
        Cliente miCliente = new Cliente();
        miCliente = miCliente.creaCliente(clientes, nombre, dni, telefono, email, cuit, altura, localidad, calle);
        if (miCliente!=null){
            miPersistencia.crearCliente(miCliente);
        }else{
            System.out.println("existe en memoria");
            throw new PreexistingEntityException("");
        }
    }
    public void editarCliente(String nombre, long dni, long telefono, String email, String cuit, int altura, 
            Localidad localidad, Calle calle, String contra, LinkedList<Vehiculo> ve, LinkedList<OrdenTrabajo> or,
            LinkedList<Turno> tu, boolean ok) throws PreexistingEntityException, Exception{
        Cliente miCliente = new Cliente();
        miCliente = miCliente.editaCliente(clientes, nombre, dni, telefono, email, cuit, altura, localidad, calle,
        contra, ve, or, tu, ok);        
        this.miPersistencia.editarCliente(miCliente);}
    public void eliminarCliente(long dni) throws NonexistentEntityException{
        
        this.miPersistencia.eliminarCliente(dni);}
    public Cliente dameUnCliente(long dni){
        return this.miPersistencia.dameUnCliente(dni);}
    public List<Cliente> dameClientes(){
        return this.miPersistencia.dameClientes();}
    
    //Deposito
    public void crearDeposito(int cod, Date horaInicio, Date horaFin) throws PreexistingEntityException, Exception{
        Deposito miDeposito = new Deposito(cod, horaInicio,  horaFin);
        miPersistencia.crearDeposito(miDeposito);}
    public void editarDeposito( int cod, LinkedList<Autoparte> au, LinkedList<Empleado> em, Date horaInicio, 
            Date horaFin,List<Item> it) throws PreexistingEntityException, Exception{
        Deposito miDeposito = this.miPersistencia.dameUnDeposito(cod);
        miDeposito.setCod(cod);
        miDeposito.setHoraInicio(horaInicio);
        miDeposito.setHoraFin(horaFin);
        miDeposito.setVsEmpleado(em);
        miDeposito.setVsItem(it);
        this.miPersistencia.editarDeposito(miDeposito);}
    public void eliminarDeposito(int cod) throws NonexistentEntityException{
        this.miPersistencia.eliminarDeposito(cod);}
    public Deposito dameUnDeposito(int cod){
        return this.miPersistencia.dameUnDeposito(cod);}
    public List<Deposito> dameDepositos(){
        return this.miPersistencia.dameDepositos();}
    
    //Diagnostico
    public void crearDiagnostico( Turno unTur, int codOrden, String descripcion, 
            int kilometraje, boolean inicial) throws PreexistingEntityException, Exception{
        Diagnostico miDiagnostico = new Diagnostico(unTur, codOrden, descripcion, kilometraje, inicial);
        miPersistencia.crearDiagnostico(miDiagnostico);}
    public void editarDiagnostico( Turno unTur, 
            int codOrden, String descripcion, int kilometraje, boolean inicial, boolean borrado, List<Autoparte> a
            , List<Actividad> ap, List<Actividad> ar) throws PreexistingEntityException, Exception{
        Diagnostico miDiagnostico = this.miPersistencia.dameUnDiagnostico(codOrden);
        miDiagnostico.setUnTurno(unTur);
        miDiagnostico.setCodOrden(codOrden);
        miDiagnostico.setKilometraje(kilometraje);
        miDiagnostico.setInicial(inicial);
        miDiagnostico.setDescripcion(descripcion);
        miDiagnostico.setBorrado(borrado);
        miDiagnostico.setVsAutoparte(a);
        miDiagnostico.setVsActividadesPendientes(ap);
        miDiagnostico.setVsActividadesRealizadas(ar);
        this.miPersistencia.editarDiagnostico(miDiagnostico);}
    public void eliminarDiagnostico(int cod) throws NonexistentEntityException{
        this.miPersistencia.eliminarDiagnostico(cod);}
    public Diagnostico dameUnDiagnostico(int cod){
        return this.miPersistencia.dameUnDiagnostico(cod);}
    public List<Diagnostico> dameDiagnosticos(){
        return this.miPersistencia.dameDiagnosticos();}
    
    //Empresa
    public void crearEmpresa(String nombre) throws PreexistingEntityException, Exception{
        Empresa miEmpresa = new Empresa(nombre);
        miPersistencia.crearEmpresa(miEmpresa);}
    public void editarEmpresa(String nombre, List<Actividad> ac, List<Autoparte> au, 
            List<Categoria> cat, List<DetalleActividad> de, List<Especialidad> es, 
            List<Actividad> esa, List<DetalleActividad> esd, List<Estado> est, 
            List<GrupoParte> gr, List<Localidad> lo, List<Marca> ma, List<Modelo> mo, List<NivelSeveridad> ni, 
            List<Proveedor> pr, List<Provincia> pro, List<Segmento> seg, List<Sucursal> su, List<Vehiculo> ve)
            throws PreexistingEntityException, Exception{
        Empresa miEmpresa = this.miPersistencia.dameUnaEmpresa(nombre);
        miEmpresa.setNombre(nombre);
        miEmpresa.setVsActividad(ac);
        miEmpresa.setVsAutoparte(au);
        miEmpresa.setVsCategoria(cat);
        miEmpresa.setVsDetalleActividad(de);
        miEmpresa.setVsEspecialidad(es);
        miEmpresa.setVsEstado(est);
        miEmpresa.setVsGrupoParte(gr);
        miEmpresa.setVsLocalidad(lo);
        miEmpresa.setVsMarca(ma);
        miEmpresa.setVsModelo(mo);
        miEmpresa.setVsNivelSeveridad(ni);
        miEmpresa.setVsProveedor(pr);
        miEmpresa.setVsProvincia(pro);
        miEmpresa.setVsSegmento(seg);
        miEmpresa.setVsSucursal(su);
        miEmpresa.setVsVehiculo(ve);
        this.miPersistencia.editarEmpresa(miEmpresa);}
    public void eliminarEmpresa(String nombre) throws NonexistentEntityException{
        this.miPersistencia.eliminarEmpresa(nombre);}
    public Empresa dameUnaEmpresa(String nombre){
        return this.miPersistencia.dameUnaEmpresa(nombre);}
    public List<Empresa> dameEmpresas(){
        return this.miPersistencia.dameEmpresas();}
    
    //Encargado
    public void crearEncargado(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String p, Date horaInicio, Date horaFin) throws PreexistingEntityException, Exception{
        Encargado miEncargado = new Encargado( unaLoc, unaSuc, nombre, dni, telefono, sueldo, p, horaInicio, horaFin);
        miPersistencia.crearEncargado(miEncargado);}
    public void editarEncargado(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String p, Date horaInicio, Date horaFin, boolean ok, List<Interno> in, List<Item> it, 
            List<OrdenTrabajo> or, List<Turno> tu) throws PreexistingEntityException, Exception{
        Encargado miEncargado = this.miPersistencia.dameUnEncargado(dni);
        miEncargado.setDni(dni);
        miEncargado.setNombre(nombre);
        miEncargado.setSueldo(sueldo);
        miEncargado.setTelefono(telefono);
        miEncargado.setUnaSucursal(unaSuc);
        miEncargado.setUnaLocalidad(unaLoc);
        miEncargado.setPass(p);
        miEncargado.setHoraInicio(horaInicio);
        miEncargado.setHoraFin(horaFin);
        miEncargado.setBorrado(ok);
        //miEncargado.setVsInterno(in);l
        miEncargado.setVsItem(it);
        miEncargado.setVsOrdenTrabajo(or);
        miEncargado.setVsTurno(tu);
        this.miPersistencia.editarEncargado(miEncargado);}
    public void eliminarEncargado(long dni) throws NonexistentEntityException{
        this.miPersistencia.eliminarEncargado(dni);}
    public Encargado dameUnEncargado(long dni){
        return this.miPersistencia.dameUnEncargado(dni);}
    public List<Encargado> dameEncargados(){
        return this.miPersistencia.dameEncargados();}    
    
    //Equipamiento
    public void crearEquipamiento(int codParte, String descripcion, String caracteristicas, float precio, 
            int impuesto, boolean recambio, long stock) throws 
            PreexistingEntityException, Exception{
        Equipamiento miEquipamiento = new Equipamiento(codParte, descripcion, caracteristicas, precio, 
                impuesto, recambio, stock);
        miPersistencia.crearEquipamiento(miEquipamiento);}
    public void editarEquipamiento(int codParte, String descripcion, String caracteristicas, float precio, 
            int impuesto, boolean recambio, long stock, boolean ok, 
            List<Item> it, List<Modelo> mo, List<Vehiculo> ve) throws 
            PreexistingEntityException, Exception{
        Equipamiento miEquipamiento = this.miPersistencia.dameUnEquipamiento(codParte);
        miEquipamiento.setCodParte(codParte);
        miEquipamiento.setPrecio(precio);
        miEquipamiento.setDescripcion(descripcion);
        miEquipamiento.setCaracteristicas(caracteristicas);
        miEquipamiento.setImpuesto(impuesto);
        miEquipamiento.setVsModelo(mo);
        miEquipamiento.setRecambio(recambio);
        miEquipamiento.setStock(stock);
        miEquipamiento.setBorrado(recambio);
        miEquipamiento.setVsItem(it);
        miEquipamiento.setVsVehiculo(ve);
        this.miPersistencia.editarEquipamiento(miEquipamiento);}
    public void eliminarEquipamiento(int codParte) throws NonexistentEntityException{
        this.miPersistencia.eliminarEquipamiento(codParte);}
    public Equipamiento dameUnEquipamiento(int codParte){
        return this.miPersistencia.dameUnEquipamiento(codParte);}
    public List<Equipamiento> dameEquipamientos(){
        return this.miPersistencia.dameEquipamientos();}
    
    //Especialidad
    public void crearEspecialidad(String nombre) throws PreexistingEntityException, Exception{
        Especialidad miEspecialidad = new Especialidad(nombre);
        miPersistencia.crearEspecialidad(miEspecialidad);}
    public void editarEspecialidad(String nombre, List<Mecanico> me) throws PreexistingEntityException, Exception{
        Especialidad miEspecialidad = this.miPersistencia.dameUnaEspecialidad(nombre);
        miEspecialidad.setNombre(nombre);
        miEspecialidad.setVsMecanico(me);
        this.miPersistencia.editarEspecialidad(miEspecialidad);}
    public void eliminarEspecialidad(String nombre) throws NonexistentEntityException{
        this.miPersistencia.eliminarEspecialidad(nombre);}
    public Especialidad dameUnaEspecialidad(String nombre){
        return this.miPersistencia.dameUnaEspecialidad(nombre);}
    public List<Especialidad> dameEspecialidades(){
        return this.miPersistencia.dameEspecialidades();}
    
    //DetalleActividad
    public void crearDetalleActividad(String cod, String descripcion, Date duracion) 
            throws PreexistingEntityException, Exception{
        DetalleActividad miDetalleActividad = new 
                DetalleActividad(cod, descripcion, duracion);
        miPersistencia.crearDetalleActividad(miDetalleActividad);}
    public void editarDetalleActividad(String cod, String descripcion, Date duracion) 
            throws PreexistingEntityException, Exception{
        DetalleActividad miDetalleActividad = this.miPersistencia.dameUnDetalleActividad(cod);
        miDetalleActividad.setCod(cod);
        miDetalleActividad.setDuracion(duracion);
        miDetalleActividad.setDescripcion(descripcion);
        this.miPersistencia.editarDetalleActividad(miDetalleActividad);}
    public void eliminarDetalleActividad(String nombre) throws NonexistentEntityException{
        this.miPersistencia.eliminarDetalleActividad(nombre);}
    public DetalleActividad dameUnDetalleActividad(String nombre){
        return this.miPersistencia.dameUnDetalleActividad(nombre);}
    public List<DetalleActividad> dameDetallesActividad(){
        return this.miPersistencia.dameDetallesActividad();}
      
    //Estado
    public void crearEstado(String nombre) 
            throws PreexistingEntityException, Exception{
        Estado miEstado = new Estado(nombre);
        miPersistencia.crearEstado(miEstado);}
    public void editarEstado(String nombre) 
            throws PreexistingEntityException, Exception{
        Estado miEstado = this.miPersistencia.dameUnEstado(nombre);
        miEstado.setNombre(nombre);
        this.miPersistencia.editarEstado(miEstado);}
    public void eliminarEstado(String nombre) throws NonexistentEntityException{
        this.miPersistencia.eliminarEstado(nombre);}
    public Estado dameUnEstado(String nombre){
        return this.miPersistencia.dameUnEstado(nombre);}
    public List<Estado> dameEstados(){
        return this.miPersistencia.dameEstados();}
    
    //Externo
    public void crearExterno(Mecanico mec, NivelImportancia niv, AtencionPublico remitente, Proveedor destinatario, 
            Vehiculo unVeh, Autoparte unaAut, 
            long codPedido, Date fecha, int cantidad) throws PreexistingEntityException, Exception{
        Externo miExterno = new Externo(mec, niv, remitente, destinatario, unVeh, unaAut, codPedido, fecha, cantidad);
        miPersistencia.crearExterno(miExterno);}
    public void editarExterno(Mecanico mec, NivelImportancia niv, AtencionPublico remitente, Proveedor destinatario, 
            Vehiculo unVeh, Autoparte unaAut, long codPedido, Date fecha, int cantidad, boolean ok, boolean re) 
            throws PreexistingEntityException, Exception{
        Externo miExterno = this.miPersistencia.dameUnExterno(codPedido);
        miExterno.setCantidad(cantidad);
        miExterno.setCodPedido(codPedido);
        miExterno.setDestinatario(destinatario);
        miExterno.setFecha(fecha);
        miExterno.setRemitente(remitente);
        miExterno.setUnMecanico(mec);
        miExterno.setUnNivelImportancia(niv);
        miExterno.setUnVehiculo(unVeh);
        miExterno.setUnaAutoparte(unaAut);
        miExterno.setBorrado(ok);
        miExterno.setResuelto(re);
        this.miPersistencia.editarExterno(miExterno);}
    public void eliminarExterno(long codPedido) throws NonexistentEntityException{
        this.miPersistencia.eliminarExterno(codPedido);}
    public Externo dameUnExterno(long codPedido){
        return this.miPersistencia.dameUnExterno(codPedido);}
    public List<Externo> dameExternos(){
        return this.miPersistencia.dameExternos();}
    
    //Garantia
    public void crearGarantia( Date fecha, int duracion, String detalle, boolean vigencia, List<Autoparte> partes) 
            throws PreexistingEntityException, Exception{
        Garantia miGarantia = new Garantia( fecha, duracion, detalle, vigencia, partes);
        miPersistencia.crearGarantia(miGarantia);}
    public void editarGarantia( Date fecha, int duracion, String detalle, boolean vigencia, 
            List<Autoparte> partes) throws PreexistingEntityException, Exception{
        Garantia miGarantia = this.miPersistencia.dameUnaGarantia(detalle);
        miGarantia.setDetalle(detalle);
        miGarantia.setDuracion(duracion);
        miGarantia.setFecha(fecha);
        miGarantia.setVigencia(vigencia);
        miGarantia.setVsAutoparte(partes);
        this.miPersistencia.editarGarantia(miGarantia);}
    public void eliminarGarantia(String detalle) throws NonexistentEntityException{
        this.miPersistencia.eliminarGarantia(detalle);}
    public Garantia dameUnaGarantia(String detalle){
        return this.miPersistencia.dameUnaGarantia(detalle);}
    public List<Garantia> dameGarantias(){
        return this.miPersistencia.dameGarantias();}
   
    //GrupoParte
    public void crearGrupoParte(String nombre, int codGrupo,LinkedList<Modelo> mods, LinkedList<Autoparte> parts) throws 
            PreexistingEntityException, Exception{
        GrupoParte miGrupoParte = new GrupoParte(nombre, codGrupo, mods, parts);
        miPersistencia.crearGrupoParte(miGrupoParte);}
    public void editarGrupoParte(String nombre, int codGrupo, List<Actividad> ac, List<Modelo> mo, 
            List<Autoparte> au, List<Proveedor> pr) throws  PreexistingEntityException, Exception{
        GrupoParte miGrupoParte = this.miPersistencia.dameUnGrupoParte(codGrupo);
        miGrupoParte.setNombre(nombre);
        miGrupoParte.setCodGrupo(codGrupo);
        miGrupoParte.setVsModelo(mo);
        miGrupoParte.setVsAutoparte(au);
        miGrupoParte.setVsProveedor(pr);
        this.miPersistencia.editarGrupoParte(miGrupoParte);}
    public void eliminarGrupoParte(int codGrupo) throws NonexistentEntityException{
        this.miPersistencia.eliminarGrupoParte(codGrupo);}
    public GrupoParte dameUnGrupoParte(int codGrupo){
        return this.miPersistencia.dameUnGrupoParte(codGrupo);}
    public List<GrupoParte> dameGruposParte(){
        return this.miPersistencia.dameGruposParte();}
        
    
    //Interno
    public void crearInterno(/*Encargado unEnc,*/ Mecanico unMec, Vehiculo unVeh, Autoparte unaAut, 
            long codPedido, Date fecha, int cantidad) throws PreexistingEntityException, Exception{
        Interno miInterno = new Interno(/*unEnc, */unMec, unVeh, unaAut, codPedido, fecha, cantidad);
        miPersistencia.crearInterno(miInterno);}
    public void editarInterno(Encargado unEnc, Mecanico unMec, boolean resu, boolean aprobado, Vehiculo unVeh, 
            Autoparte unaAut, long codPedido, Date fecha, int cantidad, boolean ok) 
            throws PreexistingEntityException, Exception{
        Interno miInterno = this.miPersistencia.dameUnInterno(codPedido);
        miInterno.setAprobado(aprobado);
        miInterno.setCantidad(cantidad);
        miInterno.setCodPedido(codPedido);
        miInterno.setFecha(fecha);
        miInterno.setResuelto(resu);
        //miInterno.setUnEncargado(unEnc);l
        miInterno.setUnMecanico(unMec);
        miInterno.setUnVehiculo(unVeh);
        miInterno.setUnaAutoparte(unaAut);
        miInterno.setBorrado(ok);
        this.miPersistencia.editarInterno(miInterno);}
    public void eliminarInterno(long cod) throws NonexistentEntityException{
        this.miPersistencia.eliminarInterno(cod);}
    public Interno dameUnInterno(long cod){
        return this.miPersistencia.dameUnInterno(cod);}
    public List<Interno> dameInternos(){
        return this.miPersistencia.dameInternos();}
    
    //Item
    public void crearItem(Autoparte unaAut, int cod, boolean ok,Deposito dep) 
            throws PreexistingEntityException, Exception{
        Item miItem = new Item(unaAut, cod, ok, dep);
        miPersistencia.crearItem(miItem);}
    public void editarItem(Autoparte unaAut, int cod, boolean ok,Deposito dep) 
            throws PreexistingEntityException, Exception{
        Item miItem = this.miPersistencia.dameUnItem(cod);
        miItem.setOk(ok);
        miItem.setUnaAutoparte(unaAut);
        miItem.setCod(cod);
        miItem.setUnDeposito(dep);
        this.miPersistencia.editarItem(miItem);}
    public void eliminarItem(int cod) throws NonexistentEntityException{
        this.miPersistencia.eliminarItem(cod);}
    public Item dameUnItem(int cod){
        return this.miPersistencia.dameUnItem(cod);}
    public List<Item> dameItems(){
        return this.miPersistencia.dameItems();}
    
    //Localidad
    public void crearLocalidad(int codigo, String nombre, int codPost, Provincia provincia) 
            throws PreexistingEntityException, Exception{
        Localidad miLocalidad = new Localidad(codigo, nombre, codPost, provincia);
        miPersistencia.crearLocalidad(miLocalidad);}
    public void editarLocalidad(int codigo, String nombre, int codPost, Provincia provincia, List<Calle> ca, 
            List<Cliente> cl, List<Empleado> em, List<Proveedor> pr, List<Sucursal> su) 
            throws PreexistingEntityException, Exception{
        Localidad miLocalidad = this.miPersistencia.dameUnaLocalidad(codigo);
        miLocalidad.setCodigo(codigo);
        miLocalidad.setCodPost(codPost);
        miLocalidad.setProvincia(provincia);
        miLocalidad.setNombre(nombre);
        miLocalidad.setVsCalle(ca);
        miLocalidad.setVsCliente(cl);
        miLocalidad.setVsEmpleado(em);
        miLocalidad.setVsProveedor(pr);
        miLocalidad.setVsSucursal(su);
        this.miPersistencia.editarLocalidad(miLocalidad);}
    public void eliminarLocalidad(int cod) throws NonexistentEntityException{
        this.miPersistencia.eliminarLocalidad(cod);}
    public Localidad dameUnaLocalidad(int cod){
        return this.miPersistencia.dameUnaLocalidad(cod);}
    public List<Localidad> dameLocalidades(){
        return this.miPersistencia.dameLocalidades();}
    
    //Marca
    public void crearMarca(String nombre) throws PreexistingEntityException, Exception{
        Marca miMarca = new Marca(nombre);
        miPersistencia.crearMarca(miMarca);}
    public void editarMarca(String nombre) 
            throws PreexistingEntityException, Exception{
        Marca miMarca = this.miPersistencia.dameUnaMarca(nombre);
        miMarca.setNombre(nombre);
        this.miPersistencia.editarMarca(miMarca);}
    public void eliminarMarca(String nombre) throws NonexistentEntityException{
        this.miPersistencia.eliminarMarca(nombre);}
    public Marca dameUnaMarca(String nombre){
        return this.miPersistencia.dameUnaMarca(nombre);}
    public List<Marca> dameMarcas(){
        return this.miPersistencia.dameMarcas();}
    
    //Mecanico
    public void crearMecanico(Localidad unaLoc,Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String p, Date horaInicio, Date horaFin, Especialidad profesion) throws 
            PreexistingEntityException, Exception{
        Mecanico miMecanico = new Mecanico(unaLoc,unaSuc, nombre, dni, telefono, sueldo, p,horaInicio,horaFin, profesion);
        miPersistencia.crearMecanico(miMecanico);}
    public void editarMecanico(Localidad unaLoc,Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String p, Date horaInicio, Date horaFin, Especialidad profesion, boolean ok, List<Interno> in,
            List<OrdenTrabajo> or, List<Turno> tu) throws PreexistingEntityException, Exception{
        Mecanico miMecanico = this.miPersistencia.dameUnMecanico(dni);
        miMecanico.setDni(dni);
        miMecanico.setNombre(nombre);
        miMecanico.setPass(p);
        miMecanico.setSueldo(sueldo);
        miMecanico.setTelefono(telefono);
        miMecanico.setUnaLocalidad(unaLoc);
        miMecanico.setUnaSucursal(unaSuc);
        miMecanico.setHoraInicio(horaInicio);
        miMecanico.setHoraFin(horaFin);
        miMecanico.setUnaEspecialidad(profesion);
        miMecanico.setBorrado(ok);
        miMecanico.setVsInterno(in);
        miMecanico.setVsOrdenTrabajo(or);
        miMecanico.setVsTurno(tu);
        this.miPersistencia.editarMecanico(miMecanico);}
    public void eliminarMecanico(long cod) throws NonexistentEntityException{
        this.miPersistencia.eliminarInterno(cod);}
    public Mecanico dameUnMecanico(long cod){
        return this.miPersistencia.dameUnMecanico(cod);}
    public List<Mecanico> dameMecanicos(){
        return this.miPersistencia.dameMecanicos();}
    
    //Modelo
    public void crearModelo(Marca mar, String nombre, int anio) 
            throws PreexistingEntityException, Exception{
        Modelo miModelo = new Modelo(mar, nombre, anio);
        miPersistencia.crearModelo(miModelo);}
    public void editarModelo(Marca mar, String nombre, int anio) 
            throws PreexistingEntityException, Exception{
        Modelo miModelo = this.miPersistencia.dameUnModelo(nombre);
        miModelo.setAnio(anio);
        miModelo.setNombre(nombre);
        miModelo.setUnaMarca(mar);
        this.miPersistencia.editarModelo(miModelo);}
    public void eliminarModelo(String nombre) throws NonexistentEntityException{
        this.miPersistencia.eliminarModelo(nombre);}
    public Modelo dameUnModelo(String nombre){
        return this.miPersistencia.dameUnModelo(nombre);}
    public List<Modelo> dameModelos(){
        return this.miPersistencia.dameModelos();}
    
    //NivelImportancia
    public void crearNivelImportancia( String nombre) 
            throws PreexistingEntityException, Exception{
        NivelImportancia miNivelImportancia = new NivelImportancia(nombre);
        miPersistencia.crearNivelImportancia(miNivelImportancia);}
    public void editarNivelImportancia( String nombre) 
            throws PreexistingEntityException, Exception{
        NivelImportancia miNivelImportancia = this.miPersistencia.dameUnNivelImportancia(nombre);
        miNivelImportancia.setEstado(nombre);
        this.miPersistencia.editarNivelImportancia(miNivelImportancia);}
    public void eliminarNivelImportancia(String nombre) throws NonexistentEntityException{
        this.miPersistencia.eliminarNivelImportancia(nombre);}
    public NivelImportancia dameUnNivelImportancia(String nombre){
        return this.miPersistencia.dameUnNivelImportancia(nombre);}
    public List<NivelImportancia> dameNivelesImportancia(){
        return this.miPersistencia.dameNivelesImportancia();}
    
    //NivelSeveridad
    public void crearNivelSeveridad(int nivel, String nombre) 
            throws PreexistingEntityException, Exception{
        NivelSeveridad miNivelSeveridad = new NivelSeveridad(nivel, nombre);
        miPersistencia.crearNivelSeveridad(miNivelSeveridad);}
    public void editarNivelSeveridad(int nivel, String nombre) 
            throws PreexistingEntityException, Exception{
        NivelSeveridad miNivelSeveridad = this.miPersistencia.dameUnNivelSeveridad(nivel);
        miNivelSeveridad.setNivel(nivel);
        miNivelSeveridad.setNombre(nombre);
        this.miPersistencia.editarNivelSeveridad(miNivelSeveridad);}
    public void eliminarNivelSeveridad(int nivel) throws NonexistentEntityException{
        this.miPersistencia.eliminarNivelSeveridad(nivel);}
    public NivelSeveridad dameUnNivelSeveridad(int nivel){
        return this.miPersistencia.dameUnNivelSeveridad(nivel);}
    public List<NivelSeveridad> dameNivelesSeveridad(){
        return this.miPersistencia.dameNivelesSeveridad();}
    
    //OrdenTrabajo
    public void crearOrdenTrabajo(String nombre, long dni, long telefono, String email, String cuit, int altura, 
            Localidad localidad, Calle calle) throws PreexistingEntityException, Exception{
        Cliente miCliente = new Cliente(nombre, dni, telefono, email, cuit, altura, localidad, calle);
        miPersistencia.crearCliente(miCliente);}
    public void editarOrdenTrabajo(String nombre, long dni, long telefono, String email, String cuit, int altura, 
            Localidad localidad, Calle calle, Empresa emp, String contra, LinkedList<Vehiculo> ve,
        LinkedList<OrdenTrabajo> or, LinkedList<Turno> tu, boolean ok) throws PreexistingEntityException, Exception{
        Cliente miCliente = this.miPersistencia.dameUnCliente(dni);
        miCliente.setNombre(nombre);
        miCliente.setDni(dni);
        miCliente.setTelefono(telefono);
        miCliente.setEmail(email);
        miCliente.setAltura(altura);
        miCliente.setCuit(cuit);
        miCliente.setUnaLocalidad(localidad);
        miCliente.setUnaCalle(calle);
        miCliente.setPass(cuit);
        miCliente.setVsOrdenTrabajo(or);
        miCliente.setVsTurno(tu);
        miCliente.setVsVehiculo(ve);
        miCliente.setBorrado(ok);
        this.miPersistencia.editarCliente(miCliente);}
    public void eliminarOrdenTrabajo(int cod) throws NonexistentEntityException{
        this.miPersistencia.eliminarCliente(cod);}
    public OrdenTrabajo dameUnaOrdenTrabajo(int cod){
        return this.miPersistencia.dameUnaOrdenTrabajo(cod);}
    public List<OrdenTrabajo> dameOrdenesTrabajo(){
        return this.miPersistencia.dameOrdenesTrabajo();}
    
    //Perito
    public void crearPerito(Localidad unaLoc,Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String p, Date horaInicio, Date horaFin) throws PreexistingEntityException, Exception{
        Perito miPerito = new Perito(unaLoc,unaSuc, nombre, dni, telefono, sueldo, p, horaInicio,horaFin );
        miPersistencia.crearPerito(miPerito);}
    public void editarPerito(Localidad unaLoc,Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String p, Date horaInicio, Date horaFin, boolean ok, List<Garantia> ga, List<Turno> tu) 
            throws PreexistingEntityException, Exception{
        Perito miPerito = this.miPersistencia.dameUnPerito(dni);
        miPerito.setDni(dni);
        miPerito.setNombre(nombre);
        miPerito.setPass(p);
        miPerito.setSueldo(sueldo);
        miPerito.setTelefono(telefono);
        miPerito.setUnaLocalidad(unaLoc);
        miPerito.setUnaSucursal(unaSuc);
        miPerito.setHoraInicio(horaInicio);
        miPerito.setHoraFin(horaFin);
        miPerito.setBorrado(ok);
        miPerito.setVsGarantia(ga);
        miPerito.setVsTurno(tu);
        this.miPersistencia.editarPerito(miPerito);}
    public void eliminarPerito(long cod) throws NonexistentEntityException{
        this.miPersistencia.eliminarPerito(cod);}
    public Perito dameUnPerito(long cod){
        return this.miPersistencia.dameUnPerito(cod);}
    public List<Perito> damePeritos(){
        return this.miPersistencia.damePeritos();}
    
    //Proveedor
    public void crearProveedor(Localidad unaLoc, String nombre, long telefono, String cuit, long dni, 
            String responsabilidadFiscal, String eMail) throws PreexistingEntityException, Exception{
        Proveedor miProveedor = new Proveedor(unaLoc, nombre, telefono, cuit, dni, 
            responsabilidadFiscal, eMail);
        miPersistencia.crearProveedor(miProveedor);}
    public void editarProveedor(Localidad unaLoc, String nombre,long telefono, String cuit, long dni, 
            String responsabilidadFiscal, String eMail, String tiempoEntrega, boolean ok, List<GrupoParte> gr) 
            throws PreexistingEntityException, Exception{
        Proveedor miProveedor = this.miPersistencia.dameUnProveedor(dni);
        miProveedor.setCuit(cuit);
        miProveedor.setDni(dni);
        miProveedor.setNombre(nombre);
        miProveedor.setResponsabilidadFiscal(responsabilidadFiscal);
        miProveedor.setTelefono(telefono);
        miProveedor.setTiempoEntrega(tiempoEntrega);
        miProveedor.setUnaLocalidad(unaLoc);
        miProveedor.seteMail(eMail);
        miProveedor.setBorrado(ok);
        miProveedor.setVsGrupoParte(gr);
        this.miPersistencia.editarProveedor(miProveedor);}
    public void eliminarProveedor(long cod) throws NonexistentEntityException{
        this.miPersistencia.eliminarProveedor(cod);}
    public Proveedor dameUnProveedor(long cod){
        return this.miPersistencia.dameUnProveedor(cod);}
    public List<Proveedor> dameProveedores(){
        return this.miPersistencia.dameProveedores();}
    
    //Provincia
    public void crearProvincia(int codigo, String nombre) 
            throws PreexistingEntityException, Exception{
        Provincia miProvincia = new Provincia(codigo, nombre);
        miPersistencia.crearProvincia(miProvincia);}
    public void editarProvincia(int codigo, String nombre, List<Localidad> lo) 
            throws PreexistingEntityException, Exception{
        Provincia miProvincia = this.miPersistencia.dameUnaProvincia(codigo);
        miProvincia.setCodigo(codigo);
        miProvincia.setNombre(nombre);
        miProvincia.setLocalidades(lo);
        this.miPersistencia.editarProvincia(miProvincia);}
    public void eliminarProvincia(int cod) throws NonexistentEntityException{
        this.miPersistencia.eliminarProvincia(cod);}
    public Provincia dameUnaProvincia(int cod){
        return this.miPersistencia.dameUnaProvincia(cod);}
    public List<Provincia> dameProvincias(){
        return this.miPersistencia.dameProvincias();}
    
    //Recepcion
    public void crearRecepcion(int cod, Date horaInicio, Date horaFin) 
            throws PreexistingEntityException, Exception{
        Recepcion miRecepcion = new Recepcion( cod, horaInicio, horaFin);
        miPersistencia.crearRecepcion(miRecepcion);}
    public void editarRecepcion(int cod, List<Empleado> em, List<Turno> tu, Date horaInicio, Date horaFin) 
            throws PreexistingEntityException, Exception{
        Recepcion miRecepcion = this.miPersistencia.dameUnaRecepcion(cod);
        miRecepcion.setCod(cod);
        miRecepcion.setHoraInicio(horaInicio);
        miRecepcion.setHoraFin(horaFin);
        miRecepcion.setVsEmpleado(em);
        miRecepcion.setVsTurno(tu);
        this.miPersistencia.editarRecepcion(miRecepcion);}
    public void eliminarRecepcion(int cod) throws NonexistentEntityException{
        this.miPersistencia.eliminarRecepcion(cod);}
    public Recepcion dameUnaRecepcion(int cod){
        return this.miPersistencia.dameUnaRecepcion(cod);}
    public List<Recepcion> dameRecepciones(){
        return this.miPersistencia.dameRecepciones();}
    
    //Repuesto
    public void crearRepuesto(int codParte, String descripcion, String caracteristicas, float precio, 
            int impuesto, boolean recambio, long stock) throws 
            PreexistingEntityException, Exception{
        Repuesto miRepuesto = new Repuesto(codParte, descripcion, caracteristicas, precio, impuesto, 
                recambio, stock);
        miPersistencia.crearRepuesto(miRepuesto);}
    public void editarRepuesto(int codParte, String descripcion, String caracteristicas, float precio, 
            int impuesto, boolean recambio, long stock, boolean ok
            , List<Item> it, List<Modelo> mo, List<Vehiculo> ve) throws 
            PreexistingEntityException, Exception{
        Repuesto miRepuesto = this.miPersistencia.dameUnRepuesto(codParte);
        miRepuesto.setCodParte(codParte);
        miRepuesto.setPrecio(precio);
        miRepuesto.setDescripcion(descripcion);
        miRepuesto.setCaracteristicas(caracteristicas);
        miRepuesto.setImpuesto(impuesto);
        miRepuesto.setVsModelo(mo);
        miRepuesto.setRecambio(recambio);
        miRepuesto.setStock(stock);
        miRepuesto.setBorrado(ok);
        miRepuesto.setVsItem(it);
        miRepuesto.setVsVehiculo(ve);
        this.miPersistencia.editarRepuesto(miRepuesto);}
    public void eliminarRepuesto(int codParte) throws NonexistentEntityException{
        this.miPersistencia.eliminarRepuesto(codParte);}
    public Repuesto dameUnRepuesto(int codParte){
        return this.miPersistencia.dameUnRepuesto(codParte);}
    public List<Repuesto> dameRepuestos(){
        return this.miPersistencia.dameRepuestos();}
    
    //Segmento
    public void crearSegmento(String nombre) 
            throws PreexistingEntityException, Exception{
        Segmento miSegmento = new Segmento(nombre);
        miPersistencia.crearSegmento(miSegmento);}
    public void editarSegmento(String nombre) 
            throws PreexistingEntityException, Exception{
        Segmento miSegmento = this.miPersistencia.dameUnSegmento(nombre);
        miSegmento.setNombre(nombre);
        this.miPersistencia.editarSegmento(miSegmento);}
    public void eliminarSegmento(String nombre) throws NonexistentEntityException{
        this.miPersistencia.eliminarSegmento(nombre);}
    public Segmento dameUnSegmento(String nombre){
        return this.miPersistencia.dameUnSegmento(nombre);}
    public List<Segmento> dameSegmentos(){
        return this.miPersistencia.dameSegmentos();}
    
    //Sucursal
    public void crearSucursal(int cod, Localidad unaLoc, long telefono, int altura, 
            Calle calleSuc,Date horaInicio, Date horaFin) throws PreexistingEntityException, Exception{
        Sucursal miSucursal = new Sucursal (cod, unaLoc, telefono, altura, calleSuc, horaInicio,horaFin );
        miPersistencia.crearSucursal(miSucursal);}
    public void editarSucursal(int cod, Localidad unaLoc, long telefono, int altura, 
            Calle calleSuc, boolean ok, List<Turno> tu, List<Sector> se, List<Pedido> pe, List<Empleado> em, 
            List<Calle> ca, Date horaInicio, Date horaFin, List<Cliente> cl) throws PreexistingEntityException, Exception{
        Sucursal miSucursal = this.miPersistencia.dameUnaSucursal(cod);
        miSucursal.setAltura(altura);
        miSucursal.setCalleSuc(calleSuc);
        miSucursal.setCodSuc(cod);
        miSucursal.setTelefono(telefono);
        miSucursal.setHoraInicio(horaInicio);
        miSucursal.setHoraFin(horaFin);
        miSucursal.setUnaLocalidad(unaLoc);
        miSucursal.setBorrado(ok);
        miSucursal.setVsCliente(cl);
        miSucursal.setVsTurno(tu);
        miSucursal.setVsSector(se);
        miSucursal.setVsPedido(pe);
        miSucursal.setVsEmpleado(em);
        miSucursal.setVsCalle(ca);
        this.miPersistencia.editarSucursal(miSucursal);}
    public void eliminarSucursal(int codParte) throws NonexistentEntityException{
        this.miPersistencia.eliminarSucursal(codParte);}
    public Sucursal dameUnaSucursal(int codParte){
        return this.miPersistencia.dameUnaSucursal(codParte);}
    public List<Sucursal> dameSucursales(){
        return this.miPersistencia.dameSucursales();}
    
    //Taller
    public void crearTaller(int cod, Date horaInicio, Date horaFin) throws PreexistingEntityException, Exception{
        Taller miTaller = new Taller( cod, horaInicio, horaFin);
        miPersistencia.crearTaller(miTaller);}
    public void editarTaller(int cod, List<Empleado> em, List<OrdenTrabajo> or, Date horaInicio, Date horaFin) 
            throws PreexistingEntityException, Exception{
        Taller miTaller = this.miPersistencia.dameUnTaller(cod);
        miTaller.setCod(cod);
        miTaller.setHoraInicio(horaInicio);
        miTaller.setHoraFin(horaFin);
        miTaller.setVsEmpleado(em);
        miTaller.setVsOrdenTrabajo(or);
        this.miPersistencia.editarTaller(miTaller);}
    public void eliminarTaller(int cod) throws NonexistentEntityException{
        this.miPersistencia.eliminarTaller(cod);}
    public Taller dameUnTaller(int cod){
        return this.miPersistencia.dameUnTaller(cod);}
    public List<Taller> dameTalleres(){
        return this.miPersistencia.dameTalleres();}
    
    //Turno
    public void crearTurno(Vehiculo veh, Cliente cli, long codigo, Date fecha, String des, 
            Date duracionAprox, Date horaInicio, Estado est, NivelSeveridad nivS
            ) throws PreexistingEntityException, Exception{
        Turno miTurno = new Turno(veh, cli, codigo, fecha, des, duracionAprox, horaInicio, est, nivS);
        miPersistencia.crearTurno(miTurno);}
    public void editarTurno(Vehiculo veh, Cliente cli, long codigo, Date fecha, String des, 
            Date duracionAprox, Date horaInicio, Estado est, NivelSeveridad nivS, List<OrdenTrabajo> unaO,
            List<Empleado> vsEmp, boolean borrado) 
            throws PreexistingEntityException, Exception{
        Turno miTurno = this.miPersistencia.dameUnTurno(codigo);
        miTurno.setCodigo(codigo);
        miTurno.setDuracionAprox(duracionAprox);
        miTurno.setFecha(fecha);
        miTurno.setUnCliente(cli);
        miTurno.setHoraInicio(horaInicio);
        miTurno.setUnVehiculo(veh);
        miTurno.setVsOrdenTrabajo(unaO);
        miTurno.setVsEmpleado(vsEmp);
        miTurno.setBorrado(borrado);
        miTurno.setDescrip(des);
        this.miPersistencia.editarTurno(miTurno);}
    public void eliminarTurno(long cod) throws NonexistentEntityException{
        this.miPersistencia.eliminarTurno(cod);}
    public Turno dameUnTurno(long cod){
        return this.miPersistencia.dameUnTurno(cod);}
    public List<Turno> dameTurnos(){
        return this.miPersistencia.dameTurnos();}
    
    //Vehiculo
    public void crearVehiculo(Segmento seg, Modelo mod, Garantia gar, Cliente cli, String dominio, 
            String nroChasis, String nroMotor, int anio, String color, int puertas) throws 
            PreexistingEntityException, Exception{
        Vehiculo miVehiculo = new Vehiculo(seg, mod, gar, cli, dominio, nroChasis, nroMotor, anio, color, puertas);
        miPersistencia.crearVehiculo(miVehiculo);}
    public void editarVehiculo(Segmento seg, Modelo mod, Garantia gar, Cliente cli, String dominio, 
            String nroChasis, String nroMotor, int anio, String color, int puertas, boolean ok,
            List<Turno> tup, List<OrdenTrabajo> or, List<Actividad> acr, List<Actividad> acp) throws 
            PreexistingEntityException, Exception{
        Vehiculo miVehiculo = this.miPersistencia.dameUnVehiculo(nroChasis);
        miVehiculo.setAnio(anio);
        miVehiculo.setColor(color);
        miVehiculo.setDominio(dominio);
        miVehiculo.setNroChasis(nroChasis);
        miVehiculo.setNroMotor(nroMotor);
        miVehiculo.setPuertas(puertas);
        miVehiculo.setUnCliente(cli);
        miVehiculo.setUnGarantia(gar);
        miVehiculo.setUnSegmento(seg);
        miVehiculo.setUnModelo(mod);
        miVehiculo.setBorrado(ok);
        miVehiculo.setVsTurnosPend(tup);
        miVehiculo.setVsOrdenTrabajo(or);
        miVehiculo.setVsActividadesRealiz(acr);
        miVehiculo.setVsActividadesPend(acp);
        this.miPersistencia.editarVehiculo(miVehiculo);}
    public void eliminarVehiculo(String nroChasis) throws NonexistentEntityException{
        this.miPersistencia.eliminarVehiculo(nroChasis);}
    public Vehiculo dameUnVehiculo(String nroChasis){
        return this.miPersistencia.dameUnVehiculo(nroChasis);}
    public List<Vehiculo> dameVehiculos(){
        return this.miPersistencia.dameVehiculos();}
    
    
    public static void main(String[] args) {
        Bienvenido inicio = new Bienvenido();
        inicio.setResizable(false);
        inicio.setVisible(true);
    }
}

