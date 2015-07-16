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
        Accesorio miAccesorio = new Accesorio();
        miAccesorio = miAccesorio.creaAccesorio(codParte, descripcion, caracteristicas, precio, impuesto, recambio, stock);
        if (miAccesorio!=null){
            miPersistencia.crearAccesorio(miAccesorio);
        }else{
            throw new PreexistingEntityException("");
        }
    }
    public void editarAccesorio(int codParte, String descripcion, String caracteristicas, float precio, 
            int impuesto, boolean recambio, long stock, boolean ok
            , LinkedList<Item> it, LinkedList<Modelo> mo, LinkedList<Vehiculo> ve) throws 
            NonexistentEntityException, Exception{
        Accesorio miAccesorio = new Accesorio();
        miAccesorio = miAccesorio.editaAccesorio(codParte, descripcion, caracteristicas, precio, impuesto, recambio, stock,
                it, mo,ve, ok);
        this.miPersistencia.editarAccesorio(miAccesorio);}
    public void eliminarAccesorio(int cod) throws NonexistentEntityException{
        Accesorio miAccesorio = new Accesorio();
        miAccesorio.eliminaAccesorio(cod);
        this.miPersistencia.eliminarAccesorio(cod);}
    public Accesorio dameUnAccesorio(int cod){
        Accesorio miAccesorio = new Accesorio();
        miAccesorio = miAccesorio.buscarAccesorio(cod);
        if (miAccesorio==null){        
            miAccesorio= this.miPersistencia.dameUnAccesorio(cod);
        }
        return miAccesorio;
    }
    public List<Accesorio> dameAccesorios(){
        Accesorio miAccesorio = new Accesorio();
        List<Accesorio> misAccesorios = miAccesorio.darAccesorio();
        if (misAccesorios.isEmpty()){
            misAccesorios = this.miPersistencia.dameAccesorios();
        }
        return misAccesorios;
    }
        
    //Actividad
    public void crearActividad(String nombre, Categoria categ, Date duracionTotal, GrupoParte grupo, 
            List<DetalleActividad> ac) throws PreexistingEntityException, Exception{
        Actividad miActividad = new Actividad();
        miActividad = miActividad.creaActividad(nombre, categ, duracionTotal, grupo, ac);
        if (miActividad!=null){
            miPersistencia.crearActividad(miActividad);
        }else{
            throw new PreexistingEntityException("");
        }
    }
    public void editarActividad(String nombre, Categoria categ, Date duracionTotal, GrupoParte grupo, 
            List<DetalleActividad> ac) throws PreexistingEntityException, Exception{
        Actividad miActividad = new Actividad();
        miActividad = miActividad.editaActividad(nombre, categ, duracionTotal, grupo, ac);
        this.miPersistencia.editarActividad(miActividad);}
    public void eliminarActividad(String nombre) throws NonexistentEntityException{
        Actividad miActividad = new Actividad();
        miActividad.eliminaActividad(nombre);
        this.miPersistencia.eliminarActividad(nombre);}
    public Actividad dameUnaActividad(String nombre){
        Actividad miActividad = new Actividad();
        miActividad = miActividad.buscarActividad(nombre);
        if (miActividad==null){        
            miActividad= this.miPersistencia.dameUnaActividad(nombre);
        }
        return miActividad;
    }
    public List<Actividad> dameActividades(){
        Actividad miActividad = new Actividad();
        List<Actividad> misActividad= miActividad.darActividad();
        if (misActividad.isEmpty()){
            misActividad = this.miPersistencia.dameActividades();
        }
        return misActividad;
    }
    
    //Ajuste
    public void crearAjuste(Turno unTur, long codOrden, String descripcion) 
            throws PreexistingEntityException, Exception{
        Ajuste miAjuste = new Ajuste();
        miAjuste = miAjuste.creaAjuste(unTur, codOrden, descripcion);
        if (miAjuste!=null){
            miPersistencia.crearAjuste(miAjuste);
        }else{
            throw new PreexistingEntityException("");
        }
    }
    public void editarAjuste(Turno unTur, long codOrden, String descripcion, boolean borrado,
            List<Autoparte> gp) throws PreexistingEntityException, Exception{
        Ajuste miAjuste = new Ajuste();
        miAjuste = miAjuste.editaAjuste(unTur, codOrden, descripcion, null, null, null, borrado);
        this.miPersistencia.editarAjuste(miAjuste);}
    public void eliminarAjuste(long codOrden) throws NonexistentEntityException{
        Ajuste miAjuste = new Ajuste();
        miAjuste.eliminaAjuste(codOrden);
        this.miPersistencia.eliminarAjuste(codOrden);}
    public Ajuste dameUnAjuste(long codOrden){
        Ajuste miAjuste = new Ajuste();
        miAjuste = miAjuste.buscarAjuste(codOrden);
        if (miAjuste==null){        
            miAjuste= this.miPersistencia.dameUnAjuste(codOrden);
        }
        return miAjuste;
    }
    public List<Ajuste> dameAjustes(){
        Ajuste miAjuste = new Ajuste();
        List<Ajuste> misAjuste = miAjuste.darAjustes();
        if (misAjuste.isEmpty()){
            misAjuste = this.miPersistencia.dameAjustes();
        }
        return misAjuste;
    }
   
    //AtencionPublico
    public void crearAtencionPublico(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String p, Date horaInicio, Date horaFin) throws PreexistingEntityException, Exception{
        AtencionPublico miAtencionPublico = new AtencionPublico();
        miAtencionPublico = miAtencionPublico.creaAtencionPublico(unaLoc, unaSuc, nombre, dni, telefono, sueldo, p, horaInicio, horaFin);
        if (miAtencionPublico!=null){
            miPersistencia.crearAtencionPublico(miAtencionPublico);
        }else{
            throw new PreexistingEntityException("");
        }
    }
    public void editarAtencionPublico(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, 
            long telefono, int sueldo, String p, Date horaInicio, Date horaFin, LinkedList<Externo> ex, boolean ok,
            List<Turno> tu) throws PreexistingEntityException, Exception{
        AtencionPublico miAtencionPublico = new AtencionPublico();
        miAtencionPublico = miAtencionPublico.editaAtencionPublico(unaLoc, unaSuc, nombre, dni, telefono, sueldo, p, horaInicio, horaFin, ex, ok);
        this.miPersistencia.editarAtencionPublico(miAtencionPublico);}
    public void eliminarAtencionPublico(long dni) throws NonexistentEntityException{
        AtencionPublico miAtencionPublico = new AtencionPublico();
        miAtencionPublico.eliminaAtencionPublico(dni);
        this.miPersistencia.eliminarAtencionPublico(dni);}
    public AtencionPublico dameUnAtencionPublico(long dni){
        AtencionPublico miAtencionPublico = new AtencionPublico();
        miAtencionPublico = miAtencionPublico.buscarAtencionPublico(dni);
        if (miAtencionPublico==null){        
            miAtencionPublico= this.miPersistencia.dameUnAtencionPublico(dni);
        }
        return miAtencionPublico;
    }
    public List<AtencionPublico> dameAtencionesPublico(){
        AtencionPublico miAtencionPublico = new AtencionPublico();
        List<AtencionPublico> misAtencionPublico = miAtencionPublico.darAtencionPublico();
        if (misAtencionPublico.isEmpty()){
            misAtencionPublico = this.miPersistencia.dameAtencionesPublico();
        }
        return misAtencionPublico;
    }
    
    
    //Calle
    public void crearCalle(String nombre) 
            throws PreexistingEntityException, Exception{
        Calle miCalle = new Calle();
        miCalle = miCalle.creaCalle(nombre);
        if (miCalle!=null){
            miPersistencia.crearCalle(miCalle);
        }else{
            throw new PreexistingEntityException("");
        }
    }
    public void editarCalle(LinkedList<Localidad> loc, String nombre, Sucursal suc, LinkedList<Cliente> cl) 
            throws PreexistingEntityException, Exception{
        Calle miCalle = new Calle();
        miCalle = miCalle.editaCalle(nombre, suc, cl, loc);
        this.miPersistencia.editarCalle(miCalle);}
    public void eliminarCalle(String nombre) throws NonexistentEntityException{
        Calle miCalle = new Calle();
        miCalle.eliminaCalle(nombre);
        this.miPersistencia.eliminarCalle(nombre);}
    public Calle dameUnaCalle(String nombre){
        Calle miCalle = new Calle();
        miCalle = miCalle.buscarCalle(nombre);
        if (miCalle==null){        
            miCalle= this.miPersistencia.dameUnaCalle(nombre);
        }
        return miCalle;
    }
    public List<Calle> dameCalles(){
        Calle miCalle = new Calle();
        List<Calle> misCalles = miCalle.darCalle();
        if (misCalles.isEmpty()){
            misCalles = this.miPersistencia.dameCalles();
        }
        return misCalles;
    }
    
    //Categoria
    public void crearCategoria(String nombre) 
            throws PreexistingEntityException, Exception{
        Categoria miCategoria = new Categoria();
        miCategoria = miCategoria.creaCategoria(nombre);
        if (miCategoria!=null){
            miPersistencia.crearCategoria(miCategoria);
        }else{
            throw new PreexistingEntityException("");
        }
    }
    public void editarCategoria(String nombre, LinkedList<Actividad> ac) 
            throws PreexistingEntityException, Exception{
        Categoria miCategoria = new Categoria();
        miCategoria = miCategoria.editaCategoria(nombre, ac);
        this.miPersistencia.editarCategoria(miCategoria);}
    public void eliminarCategoria(String nombre) throws NonexistentEntityException{
        Categoria miCategoria = new Categoria();
        miCategoria.eliminaCategoria(nombre);
        this.miPersistencia.eliminarCategoria(nombre);}    public Categoria dameUnaCategoria(String nombre){
        Categoria miCategoria = new Categoria();
        miCategoria = miCategoria.buscarCategoria(nombre);
        if (miCategoria==null){        
            miCategoria= this.miPersistencia.dameUnaCategoria(nombre);
        }
        return miCategoria;
    }
    public List<Categoria> dameCategorias(){
        Categoria miCategoria = new Categoria();
        List<Categoria> misCategorias = miCategoria.darCategoria();
        if (misCategorias.isEmpty()){
            misCategorias = this.miPersistencia.dameCategorias();
        }
        return misCategorias;
    }
    
    //Cliente
    public void crearCliente(String nombre, long dni, long telefono, String email, String cuit, int altura,
            Localidad localidad, Calle calle) throws PreexistingEntityException, Exception{
        Cliente miCliente = new Cliente();
        miCliente = miCliente.creaCliente(nombre, dni, telefono, email, cuit, altura, localidad, calle);
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
        miCliente = miCliente.editaCliente(nombre, dni, telefono, email, cuit, altura, localidad, calle,
        contra, ve, or, tu, ok);        
        this.miPersistencia.editarCliente(miCliente);}
    public void eliminarCliente(long dni) throws NonexistentEntityException{
        Cliente miCliente = new Cliente();
        miCliente.eliminaCliente(dni);
        this.miPersistencia.eliminarCliente(dni);}
    public Cliente dameUnCliente(long dni){
        Cliente miCliente = new Cliente();
        miCliente = miCliente.buscarCliente(dni);
        if (miCliente==null){        
            miCliente= this.miPersistencia.dameUnCliente(dni);
        }
        return miCliente;
    }
    public List<Cliente> dameClientes(){
        Cliente miCliente = new Cliente();
        List<Cliente> misClientes = miCliente.darClientes();
        if (misClientes.isEmpty()){
            misClientes = this.miPersistencia.dameClientes();
        }
        return misClientes;
    }
     
    //Deposito
    public void crearDeposito(int cod, Date horaInicio, Date horaFin) throws PreexistingEntityException, Exception{
        Deposito miDeposito = new Deposito();
        miDeposito = miDeposito.creaDeposito(cod, horaInicio, horaFin);
        if (miDeposito!=null){
            miPersistencia.crearDeposito(miDeposito);
        }else{
            throw new PreexistingEntityException("");
        }
    }
    public void editarDeposito( int cod, LinkedList<Autoparte> au, LinkedList<Empleado> em, Date horaInicio, 
            Date horaFin,LinkedList<Item> it) throws PreexistingEntityException, Exception{
        Deposito miDeposito = new Deposito();
        miDeposito = miDeposito.editaDeposito(cod, horaInicio, horaFin, em, it);
        this.miPersistencia.editarDeposito(miDeposito);}
    public void eliminarDeposito(int cod) throws NonexistentEntityException{
        Deposito miDeposito = new Deposito();
        miDeposito.eliminaDeposito(cod);
        this.miPersistencia.eliminarDeposito(cod);}
    public Deposito dameUnDeposito(int cod){
        Deposito miDeposito = new Deposito();
        miDeposito = miDeposito.buscarDeposito(cod);
        if (miDeposito==null){        
            miDeposito= this.miPersistencia.dameUnDeposito(cod);
        }
        return miDeposito;
    }
    public List<Deposito> dameDepositos(){
        Deposito miDeposito = new Deposito();
        List<Deposito> misDepositos = miDeposito.darDeposito();
        if (misDepositos.isEmpty()){
            misDepositos = this.miPersistencia.dameDepositos();
        }
        return misDepositos;
    }
    
    //Diagnostico
    public void crearDiagnostico( Turno unTur, long codOrden, String descripcion, 
            int kilometraje, boolean inicial) throws PreexistingEntityException, Exception{
        Diagnostico miDiagnostico = new Diagnostico();
        miDiagnostico = miDiagnostico.creaDiagnostico(unTur, codOrden, descripcion, kilometraje, inicial);
        if (miDiagnostico!=null){
            miPersistencia.crearDiagnostico(miDiagnostico);
        }else{
            throw new PreexistingEntityException("");
        }
    }
    public void editarDiagnostico( Turno unTur, 
            long codOrden, String descripcion, int kilometraje, boolean inicial, boolean borrado, LinkedList<OrdenTrabajo> or
            , LinkedList<Actividad> ar, LinkedList<Actividad> ap) throws PreexistingEntityException, Exception{
        Diagnostico miDiagnostico = new Diagnostico();
        miDiagnostico = miDiagnostico.editaDiagnostico(unTur, codOrden, descripcion, or, ar, ap, borrado, kilometraje, inicial);
        this.miPersistencia.editarDiagnostico(miDiagnostico);}
    public void eliminarDiagnostico(long codOrden) throws NonexistentEntityException{
        Diagnostico miDiagnostico = new Diagnostico();
        miDiagnostico.eliminaDiagnostico(codOrden);
        this.miPersistencia.eliminarDiagnostico(codOrden);}
    public Diagnostico dameUnDiagnostico(long codOrden){
        Diagnostico miDiagnostico = new Diagnostico();
        miDiagnostico = miDiagnostico.buscarDiagnostico(codOrden);
        if (miDiagnostico==null){        
            miDiagnostico= this.miPersistencia.dameUnDiagnostico(codOrden);
        }
        return miDiagnostico;
    }
    public List<Diagnostico> dameDiagnosticos(){
        Diagnostico miDiagnostico = new Diagnostico();
        List<Diagnostico> misDiagnosticos = miDiagnostico.darDiagnostico();
        if (misDiagnosticos.isEmpty()){
            misDiagnosticos = this.miPersistencia.dameDiagnosticos();
        }
        return misDiagnosticos;
    }
    
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
        Encargado miEncargado = new Encargado();
        miEncargado = miEncargado.creaEncargado(unaLoc, unaSuc, nombre, dni, telefono, sueldo, p, horaInicio, horaFin);
        if (miEncargado!=null){
            miPersistencia.crearEncargado(miEncargado);
        }else{
            throw new PreexistingEntityException("");
        }
    }
    public void editarEncargado(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String p, Date horaInicio, Date horaFin, boolean ok, LinkedList<Interno> in, LinkedList<Item> it, 
            LinkedList<OrdenTrabajo> or) throws PreexistingEntityException, Exception{
        Encargado miEncargado = new Encargado();
        miEncargado = miEncargado.editaEncargado(unaLoc, unaSuc, nombre, dni, telefono, sueldo, p, horaInicio, horaFin, it, or, ok);
        this.miPersistencia.editarEncargado(miEncargado);}
    public void eliminarEncargado(long dni) throws NonexistentEntityException{
        Encargado miEncargado = new Encargado();
        miEncargado.eliminaEncargado(dni);
        this.miPersistencia.eliminarEncargado(dni);}
    public Encargado dameUnEncargado(long dni){
        Encargado miEncargado = new Encargado();
        miEncargado = miEncargado.buscarEncargado(dni);
        if (miEncargado==null){        
            miEncargado= this.miPersistencia.dameUnEncargado(dni);
        }
        return miEncargado;
    }
    public List<Encargado> dameEncargados(){
        Encargado miEncargado = new Encargado();
        List<Encargado> misEncargados = miEncargado.darEncargado();
        if (misEncargados.isEmpty()){
            misEncargados = this.miPersistencia.dameEncargados();
        }
        return misEncargados;
    }
    
    //Equipamiento
    public void crearEquipamiento(int codParte, String descripcion, String caracteristicas, float precio, 
            int impuesto, boolean recambio, long stock) throws 
            PreexistingEntityException, Exception{
        Equipamiento miEquipamiento = new Equipamiento();
        miEquipamiento = miEquipamiento.creaEquipamiento(codParte, descripcion, caracteristicas, precio, impuesto, recambio, stock);
        if (miEquipamiento!=null){
            miPersistencia.crearEquipamiento(miEquipamiento);
        }else{
            throw new PreexistingEntityException("");
        }
    }
    public void editarEquipamiento(int codParte, String descripcion, String caracteristicas, float precio, 
            int impuesto, boolean recambio, long stock, boolean ok, 
            LinkedList<Item> it, LinkedList<Modelo> mo, LinkedList<Vehiculo> ve) throws 
            PreexistingEntityException, Exception{
        Equipamiento miEquipamiento = new Equipamiento();
        miEquipamiento = miEquipamiento.editaEquipamiento(codParte, descripcion, caracteristicas, precio, impuesto, recambio, stock, it, mo, ve, ok);
        this.miPersistencia.editarEquipamiento(miEquipamiento);}
    public void eliminarEquipamiento(int codParte) throws NonexistentEntityException{
        Equipamiento miEquipamiento = new Equipamiento();
        miEquipamiento.eliminaEquipamiento(codParte);
        this.miPersistencia.eliminarEquipamiento(codParte);}
    public Equipamiento dameUnEquipamiento(int codParte){
        Equipamiento miEquipamiento = new Equipamiento();
        miEquipamiento = miEquipamiento.buscarEquipamiento(codParte);
        if (miEquipamiento==null){        
            miEquipamiento= this.miPersistencia.dameUnEquipamiento(codParte);
        }
        return miEquipamiento;
    }
    public List<Equipamiento> dameEquipamientos(){
        Equipamiento miEquipamiento = new Equipamiento();
        List<Equipamiento> misEquipamientos = miEquipamiento.darEquipamiento();
        if (misEquipamientos.isEmpty()){
            misEquipamientos = this.miPersistencia.dameEquipamientos();
        }
        return misEquipamientos;
    }
    
    //Especialidad
    public void crearEspecialidad(String nombre) throws PreexistingEntityException, Exception{
        Especialidad miEspecialidad = new Especialidad();
        miEspecialidad = miEspecialidad.creaEspecialidad(nombre);
        if (miEspecialidad!=null){
            miPersistencia.crearEspecialidad(miEspecialidad);
        }else{
            throw new PreexistingEntityException("");
        }
    }    public void editarEspecialidad(String nombre, LinkedList<Mecanico> me) throws PreexistingEntityException, Exception{
        Especialidad miEspecialidad = new Especialidad();
        miEspecialidad = miEspecialidad.editaEspecialidad(nombre, me);
        this.miPersistencia.editarEspecialidad(miEspecialidad);}
    public void eliminarEspecialidad(String nombre) throws NonexistentEntityException{
        Especialidad miEspecialidad = new Especialidad();
        miEspecialidad.eliminaEspecialidad(nombre);
        this.miPersistencia.eliminarEspecialidad(nombre);}
    public Especialidad dameUnaEspecialidad(String nombre){
        Especialidad miEspecialidad = new Especialidad();
        miEspecialidad = miEspecialidad.buscarEspecialidad(nombre);
        if (miEspecialidad==null){        
            miEspecialidad= this.miPersistencia.dameUnaEspecialidad(nombre);
        }
        return miEspecialidad;
    }
    public List<Especialidad> dameEspecialidades(){
        Especialidad miEspecialidad = new Especialidad();
        List<Especialidad> misEspecialidads = miEspecialidad.darEspecialidad();
        if (misEspecialidads.isEmpty()){
            misEspecialidads = this.miPersistencia.dameEspecialidades();
        }
        return misEspecialidads;
    }
    
    //DetalleActividad
    public void crearDetalleActividad(String cod, String descripcion, Date duracion) 
            throws PreexistingEntityException, Exception{
        DetalleActividad miDetalleActividad = new DetalleActividad();
        miDetalleActividad = miDetalleActividad.creaDetalleActividad(cod, descripcion, duracion);
        if (miDetalleActividad!=null){
            miPersistencia.crearDetalleActividad(miDetalleActividad);
        }else{
            throw new PreexistingEntityException("");
        }
    }
    public void editarDetalleActividad(String cod, String descripcion, Date duracion) 
            throws PreexistingEntityException, Exception{
        DetalleActividad miDetalleActividad = new DetalleActividad();
        miDetalleActividad = miDetalleActividad.editaDetalleActividad(cod, descripcion, duracion);
        this.miPersistencia.editarDetalleActividad(miDetalleActividad);}
    public void eliminarDetalleActividad(String cod) throws NonexistentEntityException{
        DetalleActividad miDetalleActividad = new DetalleActividad();
        miDetalleActividad.eliminaDetalleActividad(cod);
        this.miPersistencia.eliminarDetalleActividad(cod);}
    public DetalleActividad dameUnDetalleActividad(String cod){
        DetalleActividad miDetalleActividad = new DetalleActividad();
        miDetalleActividad = miDetalleActividad.buscarDetalleActividad(cod);
        if (miDetalleActividad==null){        
            miDetalleActividad= this.miPersistencia.dameUnDetalleActividad(cod);
        }
        return miDetalleActividad;
    }
    public List<DetalleActividad> dameDetallesActividad(){
        DetalleActividad miDetalleActividad = new DetalleActividad();
        List<DetalleActividad> misDetalleActividades = miDetalleActividad.darDetalleActividad();
        if (misDetalleActividades.isEmpty()){
            misDetalleActividades = this.miPersistencia.dameDetallesActividad();
        }
        return misDetalleActividades;
    }
      
    //Estado
    public void crearEstado(String nombre) 
            throws PreexistingEntityException, Exception{
        Estado miEstado = new Estado();
        miEstado = miEstado.creaEstado(nombre);
        if (miEstado!=null){
            miPersistencia.crearEstado(miEstado);
        }else{
            throw new PreexistingEntityException("");
        }
    }
    public void editarEstado(String nombre) 
            throws PreexistingEntityException, Exception{
        Estado miEstado = new Estado();
        miEstado = miEstado.editaEstado(nombre);
        this.miPersistencia.editarEstado(miEstado);}
    public void eliminarEstado(String nombre) throws NonexistentEntityException{
        Estado miEstado = new Estado();
        miEstado.eliminaEstado(nombre);
        this.miPersistencia.eliminarEstado(nombre);}
    public Estado dameUnEstado(String nombre){
        Estado miEstado = new Estado();
        miEstado = miEstado.buscarEstado(nombre);
        if (miEstado==null){        
            miEstado= this.miPersistencia.dameUnEstado(nombre);
        }
        return miEstado;
    }
    public List<Estado> dameEstados(){
        Estado miEstado = new Estado();
        List<Estado> misEstados = miEstado.darEstado();
        if (misEstados.isEmpty()){
            misEstados = this.miPersistencia.dameEstados();
        }
        return misEstados;
    }
    
    //Externo
    public void crearExterno(Mecanico mec, NivelImportancia niv, AtencionPublico remitente, Proveedor destinatario, 
            Vehiculo unVeh, Autoparte unaAut, 
            long codPedido, Date fecha, int cantidad) throws PreexistingEntityException, Exception{
        Externo miExterno = new Externo();
        miExterno = miExterno.creaExterno(mec, niv, remitente, destinatario, unVeh, unaAut, codPedido, fecha, cantidad);
        if (miExterno!=null){
            miPersistencia.crearExterno(miExterno);
        }else{
            throw new PreexistingEntityException("");
        }
    }
    public void editarExterno(Mecanico mec, NivelImportancia niv, AtencionPublico remitente, Proveedor destinatario, 
            Vehiculo unVeh, Autoparte unaAut, long codPedido, Date fecha, int cantidad, boolean ok, boolean re) 
            throws PreexistingEntityException, Exception{
        Externo miExterno = new Externo();
        miExterno = miExterno.editaExterno(mec, niv, remitente, destinatario, unVeh, unaAut, codPedido, fecha, cantidad, ok, re);
        this.miPersistencia.editarExterno(miExterno);}
    public void eliminarExterno(long codPedido) throws NonexistentEntityException{
        Externo miExterno = new Externo();
        miExterno.eliminaExterno(codPedido);
        this.miPersistencia.eliminarExterno(codPedido);}
    public Externo dameUnExterno(long codPedido){
        Externo miExterno = new Externo();
        miExterno = miExterno.buscarExterno(codPedido);
        if (miExterno==null){        
            miExterno= this.miPersistencia.dameUnExterno(codPedido);
        }
        return miExterno;
    }
    public List<Externo> dameExternos(){
        Externo miExterno = new Externo();
        List<Externo> misExternos = miExterno.darExterno();
        if (misExternos.isEmpty()){
            misExternos = this.miPersistencia.dameExternos();
        }
        return misExternos;
    }
    
    //Garantia
    public void crearGarantia( Date fecha, int duracion, String detalle, boolean vigencia, List<Autoparte> partes) 
            throws PreexistingEntityException, Exception{
        Garantia miGarantia = new Garantia();
        miGarantia = miGarantia.creaGarantia(fecha, duracion, detalle, vigencia, partes);
        if (miGarantia!=null){
            miPersistencia.crearGarantia(miGarantia);
        }else{
            throw new PreexistingEntityException("");
        }
    }
    public void editarGarantia( Date fecha, int duracion, String detalle, boolean vigencia, 
            List<Autoparte> partes) throws PreexistingEntityException, Exception{
        Garantia miGarantia = new Garantia();
        miGarantia = miGarantia.editaGarantia(fecha, duracion, detalle, vigencia, partes);
        this.miPersistencia.editarGarantia(miGarantia);}
    public void eliminarGarantia(String detalle) throws NonexistentEntityException{
        Garantia miGarantia = new Garantia();
        miGarantia.eliminaGarantia(detalle);
        this.miPersistencia.eliminarGarantia(detalle);}
    public Garantia dameUnaGarantia(String detalle){
        Garantia miGarantia = new Garantia();
        miGarantia = miGarantia.buscarGarantia(detalle);
        if (miGarantia==null){        
            miGarantia= this.miPersistencia.dameUnaGarantia(detalle);
        }
        return miGarantia;
    }
    public List<Garantia> dameGarantias(){
        Garantia miGarantia = new Garantia();
        List<Garantia> misGarantias = miGarantia.darGarantia();
        if (misGarantias.isEmpty()){
            misGarantias = this.miPersistencia.dameGarantias();
        }
        return misGarantias;
    }
   
    //GrupoParte
    public void crearGrupoParte(String nombre, int codGrupo, Modelo mods, LinkedList<Autoparte> parts) throws 
            PreexistingEntityException, Exception{
        GrupoParte miGrupoParte = new GrupoParte();
        miGrupoParte = miGrupoParte.creaGrupoParte(nombre, codGrupo, mods, parts);
        if (miGrupoParte!=null){
            miPersistencia.crearGrupoParte(miGrupoParte);
        }else{
            throw new PreexistingEntityException("");
        }
    }
    public void editarGrupoParte(String nombre, int codGrupo, Modelo mo, 
            LinkedList<Autoparte> au, LinkedList<Proveedor> pr) throws  PreexistingEntityException, Exception{
        GrupoParte miGrupoParte = new GrupoParte();
        miGrupoParte = miGrupoParte.editaGrupoParte(nombre, codGrupo, mo, au, pr);
        this.miPersistencia.editarGrupoParte(miGrupoParte);}
    public void eliminarGrupoParte(int codGrupo) throws NonexistentEntityException{
        GrupoParte miGrupoParte = new GrupoParte();
        miGrupoParte.eliminaGrupoParte(codGrupo);
        this.miPersistencia.eliminarGrupoParte(codGrupo);}
    public GrupoParte dameUnGrupoParte(int codGrupo){
        GrupoParte miGrupoParte = new GrupoParte();
        miGrupoParte = miGrupoParte.buscarGrupoParte(codGrupo);
        if (miGrupoParte==null){        
            miGrupoParte= this.miPersistencia.dameUnGrupoParte(codGrupo);
        }
        return miGrupoParte;
    }
    public List<GrupoParte> dameGruposParte(){
        GrupoParte miGrupoParte = new GrupoParte();
        List<GrupoParte> misGrupoPartes = miGrupoParte.darGrupoPartes();
        if (misGrupoPartes.isEmpty()){
            misGrupoPartes = this.miPersistencia.dameGruposParte();
        }
        return misGrupoPartes;
    }
        
    
    //Interno
    public void crearInterno(/*Encargado unEnc,*/ Mecanico unMec, Vehiculo unVeh, Autoparte unaAut, 
            long codPedido, Date fecha, int cantidad) throws PreexistingEntityException, Exception{
        Interno miInterno = new Interno();
        miInterno = miInterno.creaInterno(unMec, unVeh, unaAut, codPedido, fecha, cantidad);
        if (miInterno!=null){
            miPersistencia.crearInterno(miInterno);
        }else{
            throw new PreexistingEntityException("");
        }
    }
    public void editarInterno(Encargado unEnc, Mecanico unMec, boolean resu, boolean aprobado, Vehiculo unVeh, 
            Autoparte unaAut, long codPedido, Date fecha, int cantidad, boolean ok) 
            throws PreexistingEntityException, Exception{
        Interno miInterno = new Interno();
        miInterno = miInterno.editaInterno(unMec, unVeh, unaAut, codPedido, fecha, cantidad, aprobado, aprobado, resu);
        this.miPersistencia.editarInterno(miInterno);}
    public void eliminarInterno(long cod) throws NonexistentEntityException{
        Interno miInterno = new Interno();
        miInterno.eliminaInterno(cod);
        this.miPersistencia.eliminarInterno(cod);}
    public Interno dameUnInterno(long cod){
        Interno miInterno = new Interno();
        miInterno = miInterno.buscarInterno(cod);
        if (miInterno==null){        
            miInterno= this.miPersistencia.dameUnInterno(cod);
        }
        return miInterno;
    }
    public List<Interno> dameInternos(){
        Interno miInterno = new Interno();
        List<Interno> misInternos = miInterno.darInterno();
        if (misInternos.isEmpty()){
            misInternos = this.miPersistencia.dameInternos();
        }
        return misInternos;
    }
    
    //Item
    public void crearItem(Autoparte unaAut, int cod, boolean ok,Deposito dep) 
            throws PreexistingEntityException, Exception{
        Item miItem = new Item();
        miItem = miItem.creaItem(unaAut, cod, ok, dep);
        if (miItem!=null){
            miPersistencia.crearItem(miItem);
        }else{
            throw new PreexistingEntityException("");
        }
    }
    public void editarItem(Autoparte unaAut, int cod, boolean ok,Deposito dep) 
            throws PreexistingEntityException, Exception{
        Item miItem = new Item();
        miItem = miItem.editaItem(unaAut, cod, ok, dep);
        this.miPersistencia.editarItem(miItem);}
    public void eliminarItem(int cod) throws NonexistentEntityException{
        Item miItem = new Item();
        miItem.eliminaItem(cod);
        this.miPersistencia.eliminarItem(cod);}
    public Item dameUnItem(int cod){
        Item miItem = new Item();
        miItem = miItem.buscarItem(cod);
        if (miItem==null){        
            miItem= this.miPersistencia.dameUnItem(cod);
        }
        return miItem;
    }
    public List<Item> dameItems(){
        Item miItem = new Item();
        List<Item> misItems = miItem.darItems();
        if (misItems.isEmpty()){
            misItems = this.miPersistencia.dameItems();
        }
        return misItems;
    }
    
    //Localidad
    public void crearLocalidad(int codigo, String nombre, int codPost, Provincia provincia) 
            throws PreexistingEntityException, Exception{
        Localidad miLocalidad = new Localidad();
        miLocalidad = miLocalidad.creaLocalidad(codigo, nombre, codPost, provincia);
        if (miLocalidad!=null){
            miPersistencia.crearLocalidad(miLocalidad);
        }else{
            throw new PreexistingEntityException("");
        }
    }
    public void editarLocalidad(int codigo, String nombre, int codPost, Provincia provincia, LinkedList<Calle> ca, 
            LinkedList<Cliente> cl, LinkedList<Empleado> em, LinkedList<Proveedor> pr, LinkedList<Sucursal> su, boolean ok) 
            throws PreexistingEntityException, Exception{
        Localidad miLocalidad = new Localidad();
        miLocalidad = miLocalidad.editaLocalidad(codigo, nombre, codPost, provincia, ca, su, cl, pr, em, ok);
        this.miPersistencia.editarLocalidad(miLocalidad);}
    public void eliminarLocalidad(int cod) throws NonexistentEntityException{
        Localidad miLocalidad = new Localidad();
        miLocalidad.eliminaLocalidad(cod);
        this.miPersistencia.eliminarLocalidad(cod);}
    public Localidad dameUnaLocalidad(int cod){
        Localidad miLocalidad = new Localidad();
        miLocalidad = miLocalidad.buscarLocalidad(cod);
        if (miLocalidad==null){        
            miLocalidad= this.miPersistencia.dameUnaLocalidad(cod);
        }
        return miLocalidad;
    }
    public List<Localidad> dameLocalidades(){
        Localidad miLocalidad = new Localidad();
        List<Localidad> misLocalidads = miLocalidad.darLocalidads();
        if (misLocalidads.isEmpty()){
            misLocalidads = this.miPersistencia.dameLocalidades();
        }
        return misLocalidads;
    }
    
    //Marca
    public void crearMarca(String nombre) throws PreexistingEntityException, Exception{
        Marca miMarca = new Marca();
        miMarca = miMarca.creaMarca(nombre);
        if (miMarca!=null){
            miPersistencia.crearMarca(miMarca);
        }else{
            throw new PreexistingEntityException("");
        }
    }
    public void editarMarca(String nombre) 
            throws PreexistingEntityException, Exception{
        Marca miMarca = new Marca();
        miMarca = miMarca.editaMarca(nombre);
        this.miPersistencia.editarMarca(miMarca);}
    public void eliminarMarca(String nombre) throws NonexistentEntityException{
        Marca miMarca = new Marca();
        miMarca.eliminaMarca(nombre);
        this.miPersistencia.eliminarMarca(nombre);}
    public Marca dameUnaMarca(String nombre){
        Marca miMarca = new Marca();
        miMarca = miMarca.buscarMarca(nombre);
        if (miMarca==null){        
            miMarca= this.miPersistencia.dameUnaMarca(nombre);
        }
        return miMarca;
    }
    public List<Marca> dameMarcas(){
        Marca miMarca = new Marca();
        List<Marca> misMarcas = miMarca.darMarca();
        if (misMarcas.isEmpty()){
            misMarcas = this.miPersistencia.dameMarcas();
        }
        return misMarcas;
    }
    
    //Mecanico
    public void crearMecanico(Localidad unaLoc,Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String p, Date horaInicio, Date horaFin, Especialidad profesion) throws 
            PreexistingEntityException, Exception{
        Mecanico miMecanico = new Mecanico();
        miMecanico = miMecanico.creaMecanico(unaLoc, unaSuc, nombre, dni, telefono, sueldo, p, horaInicio, horaFin, profesion);
        if (miMecanico!=null){
            miPersistencia.crearMecanico(miMecanico);
        }else{
            throw new PreexistingEntityException("");
        }
    }
    public void editarMecanico(Localidad unaLoc,Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String p, Date horaInicio, Date horaFin, Especialidad profesion, boolean ok, LinkedList<Interno> in,
            LinkedList<OrdenTrabajo> or, LinkedList<Turno> tu) throws PreexistingEntityException, Exception{
        Mecanico miMecanico = new Mecanico();
        miMecanico = miMecanico.editaMecanico(unaLoc, unaSuc, nombre, dni, telefono, sueldo, p, horaInicio, horaFin, profesion, in, or, ok, tu);
        this.miPersistencia.editarMecanico(miMecanico);}
    public void eliminarMecanico(long dni) throws NonexistentEntityException{
        Mecanico miMecanico = new Mecanico();
        miMecanico.eliminaMecanico(dni);
        this.miPersistencia.eliminarMecanico(dni);}
    public Mecanico dameUnMecanico(long dni){
        Mecanico miMecanico = new Mecanico();
        miMecanico = miMecanico.buscarMecanico(dni);
        if (miMecanico==null){        
            miMecanico= this.miPersistencia.dameUnMecanico(dni);
        }
        return miMecanico;
    }
    public List<Mecanico> dameMecanicos(){
        Mecanico miMecanico = new Mecanico();
        List<Mecanico> misMecanicos = miMecanico.darMecanico();
        if (misMecanicos.isEmpty()){
            misMecanicos = this.miPersistencia.dameMecanicos();
        }
        return misMecanicos;
    }
    
    //Modelo
    public void crearModelo(Marca mar, String nombre, int anio) 
            throws PreexistingEntityException, Exception{
        Modelo miModelo = new Modelo();
        miModelo = miModelo.creaModelo(mar, nombre, anio);
        if (miModelo!=null){
            miPersistencia.crearModelo(miModelo);
        }else{
            throw new PreexistingEntityException("");
        }
    }
    public void editarModelo(Marca mar, String nombre, int anio) 
            throws PreexistingEntityException, Exception{
        Modelo miModelo = new Modelo();
        miModelo = miModelo.editaModelo(mar, nombre, anio);
        this.miPersistencia.editarModelo(miModelo);}
    public void eliminarModelo(String nombre) throws NonexistentEntityException{
        Modelo miModelo = new Modelo();
        miModelo.eliminaModelo(nombre);
        this.miPersistencia.eliminarModelo(nombre);}
    public Modelo dameUnModelo(String nombre){
        Modelo miModelo = new Modelo();
        miModelo = miModelo.buscarModelo(nombre);
        if (miModelo==null){        
            miModelo= this.miPersistencia.dameUnModelo(nombre);
        }
        return miModelo;
    }
    public List<Modelo> dameModelos(){
        Modelo miModelo = new Modelo();
        List<Modelo> misModelos = miModelo.darModelo();
        if (misModelos.isEmpty()){
            misModelos = this.miPersistencia.dameModelos();
        }
        return misModelos;
    }
    
    //NivelImportancia
    public void crearNivelImportancia( String nombre) 
            throws PreexistingEntityException, Exception{
        NivelImportancia miNivel = new NivelImportancia();
        miNivel = miNivel.creaNivelImportancia(nombre);
        if (miNivel!=null){
            miPersistencia.crearNivelImportancia(miNivel);
        }else{
            throw new PreexistingEntityException("");
        }
    }
    public void editarNivelImportancia( String nombre) 
            throws PreexistingEntityException, Exception{
        NivelImportancia miNivel = new NivelImportancia();
        miNivel = miNivel.editaNivelImportancia(nombre);
        this.miPersistencia.editarNivelImportancia(miNivel);}
    public void eliminarNivelImportancia(String nombre) throws NonexistentEntityException{
        NivelImportancia miNivel = new NivelImportancia();
        miNivel.eliminaNivelImportancia(nombre);
        this.miPersistencia.eliminarNivelImportancia(nombre);}
    public NivelImportancia dameUnNivelImportancia(String nombre){
        NivelImportancia miNivel = new NivelImportancia();
        miNivel = miNivel.buscarNivelImportancia(nombre);
        if (miNivel==null){        
            miNivel= this.miPersistencia.dameUnNivelImportancia(nombre);
        }
        return miNivel;
    }
    public List<NivelImportancia> dameNivelesImportancia(){
        NivelImportancia miNivel = new NivelImportancia();
        List<NivelImportancia> misNiveles = miNivel.darNivelImportancia();
        if (misNiveles.isEmpty()){
            misNiveles = this.miPersistencia.dameNivelesImportancia();
        }
        return misNiveles;
    }
    
    //NivelSeveridad
    public void crearNivelSeveridad(int nivel, String nombre) 
            throws PreexistingEntityException, Exception{
        NivelSeveridad miNivelSeveridad = new NivelSeveridad();
        miNivelSeveridad = miNivelSeveridad.creaNivelSeveridad(nivel, nombre);
        if (miNivelSeveridad!=null){
            miPersistencia.crearNivelSeveridad(miNivelSeveridad);
        }else{
            throw new PreexistingEntityException("");
        }
    }
    public void editarNivelSeveridad(int nivel, String nombre) 
            throws PreexistingEntityException, Exception{
        NivelSeveridad miNivelSeveridad = new NivelSeveridad();
        miNivelSeveridad = miNivelSeveridad.editaNivelSeveridad(nivel, nombre);
        this.miPersistencia.editarNivelSeveridad(miNivelSeveridad);}
    public void eliminarNivelSeveridad(int nivel) throws NonexistentEntityException{
        NivelSeveridad miNivelSeveridad = new NivelSeveridad();
        miNivelSeveridad.eliminaNivelSeveridad(nivel);
        this.miPersistencia.eliminarNivelSeveridad(nivel);}
    public NivelSeveridad dameUnNivelSeveridad(int nivel){
        NivelSeveridad miNivelSeveridad = new NivelSeveridad();
        miNivelSeveridad = miNivelSeveridad.buscarNivelSeveridad(nivel);
        if (miNivelSeveridad==null){        
            miNivelSeveridad= this.miPersistencia.dameUnNivelSeveridad(nivel);
        }
        return miNivelSeveridad;
    }
    public List<NivelSeveridad> dameNivelesSeveridad(){
        NivelSeveridad miNivelSeveridad = new NivelSeveridad();
        List<NivelSeveridad> misNiveles = miNivelSeveridad.darNivelSeveridads();
        if (misNiveles.isEmpty()){
            misNiveles = this.miPersistencia.dameNivelesSeveridad();
        }
        return misNiveles;
    }
    
    
    //Perito
    public void crearPerito(Localidad unaLoc,Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String p, Date horaInicio, Date horaFin) throws PreexistingEntityException, Exception{
        Perito miPerito = new Perito();
        miPerito = miPerito.creaPerito(unaLoc, unaSuc, nombre, dni, telefono, sueldo, p, horaInicio, horaFin);
        if (miPerito!=null){
            miPersistencia.crearPerito(miPerito);
        }else{
            throw new PreexistingEntityException("");
        }
    }
    public void editarPerito(Localidad unaLoc,Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String p, Date horaInicio, Date horaFin, boolean ok, LinkedList<Garantia> ga) 
            throws PreexistingEntityException, Exception{
        Perito miPerito = new Perito();
        miPerito = miPerito.editaPerito(unaLoc, unaSuc, nombre, dni, telefono, sueldo, p, horaInicio, horaFin, ga, ok);
        this.miPersistencia.editarPerito(miPerito);}
    public void eliminarPerito(long dni) throws NonexistentEntityException{
        Perito miPerito = new Perito();
        miPerito.eliminaPerito(dni);
        this.miPersistencia.eliminarPerito(dni);}
    public Perito dameUnPerito(long dni){
        Perito miPerito = new Perito();
        miPerito = miPerito.buscarPerito(dni);
        if (miPerito==null){        
            miPerito= this.miPersistencia.dameUnPerito(dni);
        }
        return miPerito;
    }
    public List<Perito> damePeritos(){
        Perito miPerito = new Perito();
        List<Perito> misPeritos = miPerito.darPerito();
        if (misPeritos.isEmpty()){
            misPeritos = this.miPersistencia.damePeritos();
        }
        return misPeritos;
    }
    
    //Proveedor
    public void crearProveedor(Localidad unaLoc, String nombre, long telefono, String cuit, long dni, 
            String responsabilidadFiscal, String eMail) throws PreexistingEntityException, Exception{
        Proveedor miProveedor= new Proveedor();
        miProveedor = miProveedor.creaProveedor(unaLoc, nombre, telefono, cuit, dni, responsabilidadFiscal, eMail);
        if (miProveedor!=null){
            miPersistencia.crearProveedor(miProveedor);
        }else{
            throw new PreexistingEntityException("");
        }
    }
    public void editarProveedor(Localidad unaLoc, String nombre,long telefono, String cuit, long dni, 
            String responsabilidadFiscal, String eMail, String tiempoEntrega, boolean ok, LinkedList<GrupoParte> gr) 
            throws PreexistingEntityException, Exception{
        Proveedor miProveedor = new Proveedor();
        miProveedor = miProveedor.editaProveedor(nombre, telefono, cuit, dni, responsabilidadFiscal, eMail, tiempoEntrega, gr, unaLoc, ok);
        this.miPersistencia.editarProveedor(miProveedor);}
    public void eliminarProveedor(long dni) throws NonexistentEntityException{
        Proveedor miProveedor = new Proveedor();
        miProveedor.eliminaProveedor(dni);
        this.miPersistencia.eliminarProveedor(dni);}
    public Proveedor dameUnProveedor(long dni){
        Proveedor miProveedor = new Proveedor();
        miProveedor = miProveedor.buscarProveedor(dni);
        if (miProveedor==null){        
            miProveedor= this.miPersistencia.dameUnProveedor(dni);
        }
        return miProveedor;
    }
    public List<Proveedor> dameProveedores(){
        Proveedor miProveedor = new Proveedor();
        List<Proveedor> misProveedors = miProveedor.darProveedors();
        if (misProveedors.isEmpty()){
            misProveedors = this.miPersistencia.dameProveedores();
        }
        return misProveedors;
    }
    
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
            Date duracionAprox, Date horaInicio, Estado est, NivelSeveridad nivS, OrdenTrabajo orden
            ) throws PreexistingEntityException, Exception{
        Turno miTurno = new Turno(veh, cli, codigo, fecha, des, duracionAprox, horaInicio, est, nivS, orden);
        miPersistencia.crearTurno(miTurno);}
    public void editarTurno(Vehiculo veh, Cliente cli, long codigo, Date fecha, String des, 
            Date duracionAprox, Date horaInicio, Estado est, NivelSeveridad nivS, OrdenTrabajo unaO,
            List<Empleado> vsEmp, boolean borrado) 
            throws PreexistingEntityException, Exception{
        Turno miTurno = this.miPersistencia.dameUnTurno(codigo);
        miTurno.setCodigo(codigo);
        miTurno.setDuracionAprox(duracionAprox);
        miTurno.setFecha(fecha);
        miTurno.setUnCliente(cli);
        miTurno.setHoraInicio(horaInicio);
        miTurno.setUnVehiculo(veh);
        miTurno.setUnaOrdenTrabajo(unaO);
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

