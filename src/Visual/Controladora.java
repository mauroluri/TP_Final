package Visual;

import LogicaDeNegocios.*;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Controladora {
    
    TP_Final TP = new TP_Final();
        
        //Clase Accesorio
    public void crearAccesorio(int codParte, String descripcion, String caracteristicas, float precio, 
            int impuesto, boolean recambio, long stock) throws PreexistingEntityException, 
            Exception{
        TP.crearAccesorio(codParte, descripcion, caracteristicas, precio, impuesto, recambio, stock);}
    public void editarAccesorio(int codParte, String descripcion, String caracteristicas, float precio, 
            int impuesto, boolean recambio, long stock,boolean ok
            , List<Item> it, List<Modelo> mo, List<Vehiculo> ve) throws NonexistentEntityException, 
            Exception{
        TP.editarAccesorio(codParte, descripcion, caracteristicas, precio, impuesto, recambio, stock, ok
            , it, mo, ve);}
    public void eliminarAccesorio(int cod) throws NonexistentEntityException{
        TP.eliminarAccesorio(cod);}
    public Accesorio dameUnAccesorio(int cod){
        return TP.dameUnAccesorio(cod);}
    public List<Accesorio> dameAccesorios(){
        return TP.dameAccesorios();}
       
        //Clase Actividad
    public void crearActividad(String nombre, Categoria categ, Date duracionTotal, GrupoParte grupo, 
            List<DetalleActividad> ac)throws PreexistingEntityException, Exception{
        TP.crearActividad(nombre, categ, duracionTotal, grupo, ac);}
    public void editarActividad(String nombre, Categoria categ, Date duracionTotal, GrupoParte grupo, 
            List<DetalleActividad> ac) 
            throws PreexistingEntityException, Exception{
        TP.editarActividad(nombre, categ, duracionTotal, grupo, ac);}
    public void eliminarActividad(String codActividad) throws NonexistentEntityException{
        TP.eliminarActividad(codActividad);}
    public Actividad dameUnaActividad(String codActividad){
        return TP.dameUnaActividad(codActividad);}
    public List<Actividad> dameActividades(){
        return TP.dameActividades();}
        
    //Ajuste
    public void crearAjuste(Turno unTur, int codOrden, String descripcion) 
            throws PreexistingEntityException, Exception{
        TP.crearAjuste(unTur, codOrden, descripcion);}
    public void editarAjuste(Turno unTur, int codOrden, String descripcion, boolean borrado,
            List<Autoparte> gp) throws PreexistingEntityException, Exception{
        TP.editarAjuste(unTur, codOrden, descripcion, borrado, gp);}
    public void eliminarAjuste(int codOrden) throws NonexistentEntityException{
        TP.eliminarAjuste(codOrden);}
    public Ajuste dameUnAjuste(int codOrden){
        return TP.dameUnAjuste(codOrden);}
    public List<Ajuste> dameAjustes(){
        return TP.dameAjustes();}
   
    //AtencionPublico
    public void crearAtencionPublico(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String p, Date horaInicio, Date horaFin) throws PreexistingEntityException, Exception{
        TP.crearAtencionPublico(unaLoc, unaSuc, nombre, dni, telefono, sueldo, p, horaInicio, horaFin);}
    public void editarAtencionPublico(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, 
            long telefono, int sueldo, String p, Date horaInicio, Date horaFin, List<Externo> ex, boolean ok,
            List<Turno> tu) throws PreexistingEntityException, Exception{
        TP.editarAtencionPublico(unaLoc, unaSuc, nombre, dni, telefono, sueldo, p,horaInicio, horaFin, ex, ok, tu);}
    public void eliminarAtencionPublico(long dni) throws NonexistentEntityException{
        TP.eliminarAtencionPublico(dni);}
    public AtencionPublico dameUnAtencionPublico(long dni){
        return TP.dameUnAtencionPublico(dni);}
    public List<AtencionPublico> dameAtencionesPublico(){
        return TP.dameAtencionesPublico();}
   
    //Calle
    public void crearCalle(String nombre) 
            throws PreexistingEntityException, Exception{
        TP.crearCalle(nombre);}
    public void editarCalle(List<Localidad> loc, String nombre, Sucursal suc, LinkedList<Cliente> cl) 
            throws PreexistingEntityException, Exception{
        TP.editarCalle(loc, nombre, suc, cl);}
    public void eliminarCalle(String nombre) throws NonexistentEntityException{
        TP.eliminarCalle(nombre);}
    public Calle dameUnaCalle(String nombre){
        return TP.dameUnaCalle(nombre);}
    public List<Calle> dameCalles(){
        return TP.dameCalles();}
    
    //Categoria
    public void crearCategoria(String nombre) 
            throws PreexistingEntityException, Exception{
        TP.crearCategoria(nombre);}
    public void editarCategoria(String nombre, LinkedList<Actividad> ac) 
            throws PreexistingEntityException, Exception{
        TP.editarCategoria(nombre, ac);}
    public void eliminarCategoria(String nombre) throws NonexistentEntityException{
        TP.eliminarCategoria(nombre);}
    public Categoria dameUnaCategoria(String nombre){
        return TP.dameUnaCategoria(nombre);}
    public List<Categoria> dameCategorias(){
        return TP.dameCategorias();}
    
    //Cliente
    public void crearCliente(String nombre, long dni, long telefono, String email, String cuit, int altura, 
            Localidad localidad, Calle calle) throws PreexistingEntityException, Exception{
        TP.crearCliente(nombre, dni, telefono, email, cuit, altura, 
            localidad, calle);}
    public void editarCliente(String nombre, long dni, long telefono, String email, String cuit, int altura, 
            Localidad localidad, Calle calle, Empresa emp, String contra, LinkedList<Vehiculo> ve,
        LinkedList<OrdenTrabajo> or, LinkedList<Turno> tu, boolean ok) throws PreexistingEntityException, Exception{
        TP.editarCliente(nombre, dni, telefono, email, cuit, altura, 
            localidad, calle, contra,  ve, or, tu,  ok);}
    public void eliminarCliente(long dni) throws NonexistentEntityException{
        TP.eliminarCliente(dni);}
    public Cliente dameUnCliente(long dni){
        return TP.dameUnCliente(dni);}
    public List<Cliente> dameClientes(){
        return TP.dameClientes();}
    
    //Deposito
    public void crearDeposito(int cod, Date horaInicio, Date horaFin) throws PreexistingEntityException, Exception{
        TP.crearDeposito(cod, horaInicio, horaFin);}
    public void editarDeposito(int cod, LinkedList<Autoparte> au, LinkedList<Empleado> em, 
            Date horaInicio, Date horaFin,List<Item> it) throws PreexistingEntityException, Exception{
        TP.editarDeposito(cod, au, em, horaInicio, horaFin, it);}
    public void eliminarDeposito(int cod) throws NonexistentEntityException{
        TP.eliminarDeposito(cod);}
    public Deposito dameUnDeposito(int cod){
        return TP.dameUnDeposito(cod);}
    public List<Deposito> dameDepositos(){
        return TP.dameDepositos();}
    
    //DetalleActividad
    public void crearDetalleActividad(String cod, String descripcion, Date duracion
            ) throws PreexistingEntityException, Exception{
        TP.crearDetalleActividad(cod, descripcion, duracion);}
    public void editarDetalleActividad(String cod, String descripcion, Date duracion
            ) throws PreexistingEntityException, Exception{
        TP.editarDetalleActividad(cod, descripcion, duracion);}
    public void eliminarDetalleActividad(String nombre) throws NonexistentEntityException{
        TP.eliminarDetalleActividad(nombre);}
    public DetalleActividad dameUnDetalleActividad(String nombre){
        return TP.dameUnDetalleActividad(nombre);}
    public List<DetalleActividad> dameDetallesActividad(){
        return TP.dameDetallesActividad();}
    
    //Diagnostico
    public void crearDiagnostico( Turno unTur, int codOrden, String descripcion, 
            int kilometraje, boolean inicial) throws PreexistingEntityException, Exception{
        TP.crearDiagnostico( unTur, codOrden, descripcion, kilometraje, inicial);}
    public void editarDiagnostico( Turno unTur, 
            int codOrden, String descripcion, int kilometraje, boolean inicial, boolean borrado, List<Autoparte> a
            ,List<Actividad> ap, List<Actividad> ar) throws PreexistingEntityException, Exception{
        TP.editarDiagnostico(unTur, codOrden, descripcion, kilometraje, inicial, borrado, a,ap,ar);}
    public void eliminarDiagnostico(int cod) throws NonexistentEntityException{
        TP.eliminarDiagnostico(cod);}
    public Diagnostico dameUnDiagnostico(int cod){
        return TP.dameUnDiagnostico(cod);}
    public List<Diagnostico> dameDiagnosticos(){
        return TP.dameDiagnosticos();}
        
    //Empresa
    public void crearEmpresa(String nombre) throws PreexistingEntityException, Exception{
        TP.crearEmpresa(nombre);}
    public void editarEmpresa(String nombre, List<Actividad> ac, List<Autoparte> au, 
            List<Categoria> cat,  List<DetalleActividad> de, List<Especialidad> es, 
            List<Actividad> esa, List<DetalleActividad> esd, List<Estado> est, 
            List<GrupoParte> gr, List<Localidad> lo, List<Marca> ma, List<Modelo> mo, List<NivelSeveridad> ni, 
            List<Proveedor> pr, List<Provincia> pro, List<Segmento> seg, List<Sucursal> su, List<Vehiculo> ve)
            throws PreexistingEntityException, Exception{
        TP.editarEmpresa(nombre, ac, au, cat, de, es, esa, esd, est, gr, lo, ma, mo, ni, pr, pro, seg, su, ve);}
    public void eliminarEmpresa(String nombre) throws NonexistentEntityException{
        TP.eliminarEmpresa(nombre);}
    public Empresa dameUnaEmpresa(String nombre){
        return TP.dameUnaEmpresa(nombre);}
    public List<Empresa> dameEmpresas(){
        return TP.dameEmpresas();}
    
    //Encargado
    public void crearEncargado(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String p, Date horaInicio, Date horaFin) throws PreexistingEntityException, Exception{
        TP.crearEncargado(unaLoc, unaSuc, nombre, dni, telefono, sueldo, p, horaInicio, horaFin);}
    public void editarEncargado(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String p, Date horaInicio, Date horaFin, boolean ok, List<Interno> in, List<Item> it, 
            List<OrdenTrabajo> or, List<Turno> tu) throws PreexistingEntityException, Exception{
        TP.editarEncargado(unaLoc, unaSuc, nombre, dni, telefono, sueldo, p, horaInicio, horaFin, ok, in, it, 
            or, tu);}
    public void eliminarEncargado(long dni) throws NonexistentEntityException{
        TP.eliminarEncargado(dni);}
    public Encargado dameUnEncargado(long dni){
        return TP.dameUnEncargado(dni);}
    public List<Encargado> dameEncargados(){
        return TP.dameEncargados();}    
    
    //Equipamiento
    public void crearEquipamiento(int codParte, String descripcion, String caracteristicas, float precio, 
            int impuesto, boolean recambio, long stock) throws PreexistingEntityException, Exception{
        TP.crearEquipamiento(codParte, descripcion, caracteristicas, precio, 
            impuesto, recambio, stock);}
    public void editarEquipamiento(int codParte, String descripcion, String caracteristicas, float precio, 
            int impuesto, boolean recambio, long stock, boolean ok, 
            List<Item> it, List<Modelo> mo, List<Vehiculo> ve) throws PreexistingEntityException, Exception{
        TP.editarEquipamiento(codParte, descripcion, caracteristicas, precio, 
            impuesto, recambio, stock, ok, it, mo, ve);}
    public void eliminarEquipamiento(int codParte) throws NonexistentEntityException{
        TP.eliminarEquipamiento(codParte);}
    public Equipamiento dameUnEquipamiento(int codParte){
        return TP.dameUnEquipamiento(codParte);}
    public List<Equipamiento> dameEquipamientos(){
        return TP.dameEquipamientos();}
    
    //Especialidad
    public void crearEspecialidad(String nombre) throws PreexistingEntityException, Exception{
        TP.crearEspecialidad(nombre);}
    public void editarEspecialidad(String nombre, List<Mecanico> me) throws PreexistingEntityException, Exception{
        TP.editarEspecialidad(nombre, me);}
    public void eliminarEspecialidad(String nombre) throws NonexistentEntityException{
        TP.eliminarEspecialidad(nombre);}
    public Especialidad dameUnaEspecialidad(String nombre){
        return TP.dameUnaEspecialidad(nombre);}
    public List<Especialidad> dameEspecialidades(){
        return TP.dameEspecialidades();}
    
    //Estado
    public void crearEstado(String nombre) throws PreexistingEntityException, Exception{
        TP.crearEstado(nombre);}
    public void editarEstado(String nombre) 
            throws PreexistingEntityException, Exception{
        TP.editarEstado(nombre);}
    public void eliminarEstado(String nombre) throws NonexistentEntityException{
        TP.eliminarEstado(nombre);}
    public Estado dameUnEstado(String nombre){
        return TP.dameUnEstado(nombre);}
    public List<Estado> dameEstados(){
        return TP.dameEstados();}
    
    //Externo
    public void crearExterno(Mecanico mec, NivelImportancia niv, AtencionPublico remitente, Proveedor destinatario, 
            Vehiculo unVeh, Autoparte unaAut, long codPedido, Date fecha, int cantidad) 
            throws PreexistingEntityException, Exception{
        TP.crearExterno(mec, niv, remitente, destinatario, unVeh, unaAut, codPedido, fecha, cantidad);}
    public void editarExterno(Mecanico mec, NivelImportancia niv, AtencionPublico remitente, Proveedor destinatario, 
            Vehiculo unVeh, Autoparte unaAut, long codPedido, Date fecha, int cantidad, boolean ok, boolean re
            ) throws PreexistingEntityException, Exception{
        TP.editarExterno(mec, niv, remitente, destinatario, unVeh, unaAut, codPedido, fecha, cantidad, ok, re);}
    public void eliminarExterno(long codPedido) throws NonexistentEntityException{
        TP.eliminarExterno(codPedido);}
    public Externo dameUnExterno(long codPedido){
        return TP.dameUnExterno(codPedido);}
    public List<Externo> dameExternos(){
        return TP.dameExternos();}
    
    //Garantia
    public void crearGarantia( Date fecha, int duracion, String detalle, boolean vigencia, List<Autoparte> partes) 
            throws PreexistingEntityException, Exception{
        TP.crearGarantia( fecha, duracion, detalle, vigencia, partes);}
    public void editarGarantia( Date fecha, int duracion, String detalle, boolean vigencia 
            ,List<Autoparte> partes)throws PreexistingEntityException, Exception{
        TP.editarGarantia( fecha, duracion, detalle, vigencia, partes);}
    public void eliminarGarantia(String detalle) throws NonexistentEntityException{
        TP.eliminarGarantia(detalle);}
    public Garantia dameUnaGarantia(String detalle){
        return TP.dameUnaGarantia(detalle);}
    public List<Garantia> dameGarantias(){
        return TP.dameGarantias();}
   
    //GrupoParte
    public void crearGrupoParte(String nombre, int codGrupo, LinkedList<Modelo> mods, LinkedList<Autoparte> parts) throws PreexistingEntityException, Exception{
        TP.crearGrupoParte(nombre, codGrupo, mods, parts);}
    public void editarGrupoParte(String nombre, int codGrupo, Vehiculo auto, List<Actividad> ac, List<Modelo> mo, 
            List<Autoparte> au, List<Proveedor> pr) throws PreexistingEntityException, Exception{
        TP.editarGrupoParte(nombre, codGrupo, ac, mo, au, pr);}
    public void eliminarGrupoParte(int codGrupo) throws NonexistentEntityException{
        TP.eliminarGrupoParte(codGrupo);}
    public GrupoParte dameUnGrupoParte(int codGrupo){
        return TP.dameUnGrupoParte(codGrupo);}
    public List<GrupoParte> dameGruposParte(){
        return TP.dameGruposParte();}
    
    //Interno
    public void crearInterno(/*Encargado unEnc,*/ Mecanico unMec, Vehiculo unVeh, 
            Autoparte unaAut, long codPedido, Date fecha, 
            int cantidad) throws PreexistingEntityException, Exception{
        TP.crearInterno(/*unEnc,*/ unMec, unVeh, unaAut, codPedido, fecha, cantidad);}
    public void editarInterno(Encargado unEnc, Mecanico unMec, boolean resu, boolean aprobado, Vehiculo unVeh, 
            Autoparte unaAut, long codPedido, Date fecha, 
            int cantidad, boolean ok) throws PreexistingEntityException, Exception{
        TP.editarInterno(unEnc, unMec, resu, aprobado, unVeh, unaAut, codPedido, fecha, cantidad, ok);}
    public void eliminarInterno(long cod) throws NonexistentEntityException{
        TP.eliminarInterno(cod);}
    public Interno dameUnInterno(long cod){
        return TP.dameUnInterno(cod);}
    public List<Interno> dameInternos(){
        return TP.dameInternos();}
    
    //Item
    public void crearItem(Autoparte unaAut, int cod, boolean ok,Deposito dep) 
            throws PreexistingEntityException, Exception{
        TP.crearItem(unaAut, cod, ok, dep);}
    public void editarItem(Autoparte unaAut, int cod, boolean ok,Deposito dep) 
            throws PreexistingEntityException, Exception{
        TP.editarItem(unaAut, cod, ok, dep);}
    public void eliminarItem(int cod) throws NonexistentEntityException{
        TP.eliminarItem(cod);}
    public Item dameUnItem(int cod){
        return TP.dameUnItem(cod);}
    public List<Item> dameItems(){
        return TP.dameItems();}
    
    //Localidad
    public void crearLocalidad(int codigo, String nombre, int codPost, Provincia provincia) 
            throws PreexistingEntityException, Exception{
        TP.crearLocalidad(codigo, nombre, codPost, provincia);}
    public void editarLocalidad(int codigo, String nombre, int codPost, Provincia provincia, List<Calle> ca, 
            List<Cliente> cl, List<Empleado> em, List<Proveedor> pr, List<Sucursal> su) 
            throws PreexistingEntityException, Exception{
        TP.editarLocalidad(codigo, nombre,codPost, provincia, ca, cl, em, pr, su);}
    public void eliminarLocalidad(int cod) throws NonexistentEntityException{
        TP.eliminarLocalidad(cod);}
    public Localidad dameUnaLocalidad(int cod){
        return TP.dameUnaLocalidad(cod);}
    public List<Localidad> dameLocalidades(){
        return TP.dameLocalidades();}
    
    //Marca
    public void crearMarca(String nombre) throws PreexistingEntityException, Exception{
        TP.crearMarca(nombre);}
    public void editarMarca(String nombre) 
            throws PreexistingEntityException, Exception{
        TP.editarMarca(nombre);}
    public void eliminarMarca(String nombre) throws NonexistentEntityException{
        TP.eliminarMarca(nombre);}
    public Marca dameUnaMarca(String nombre){
        return TP.dameUnaMarca(nombre);}
    public List<Marca> dameMarcas(){
        return TP.dameMarcas();}
    
    //Mecanico
    public void crearMecanico(Localidad unaLoc,Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String p, Date horaInicio, Date horaFin, Especialidad profesion) throws PreexistingEntityException, Exception{
        TP.crearMecanico(unaLoc,unaSuc, nombre, dni, telefono, sueldo, p, horaInicio, horaFin, profesion);}
    public void editarMecanico(Localidad unaLoc,Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String p, Date horaInicio, Date horaFin, Especialidad profesion, boolean ok, List<Interno> in,
            List<OrdenTrabajo> or, List<Turno> tu) throws PreexistingEntityException, Exception{
        TP.editarMecanico(unaLoc,unaSuc, nombre, dni, telefono, sueldo, p, horaInicio, horaFin, profesion, ok, 
                in, or, tu);}
    public void eliminarMecanico(long cod) throws NonexistentEntityException{
        TP.eliminarInterno(cod);}
    public Mecanico dameUnMecanico(long cod){
        return TP.dameUnMecanico(cod);}
    public List<Mecanico> dameMecanicos(){
        return TP.dameMecanicos();}
    
    //Modelo
    public void crearModelo(Marca mar, String nombre, int anio) 
            throws PreexistingEntityException, Exception{
        TP.crearModelo(mar, nombre, anio);}
    public void editarModelo(Marca mar, String nombre, int anio) 
            throws PreexistingEntityException, Exception{
        TP.editarModelo(mar, nombre, anio);}
    public void eliminarModelo(String nombre) throws NonexistentEntityException{
        TP.eliminarModelo(nombre);}
    public Modelo dameUnModelo(String nombre){
        return TP.dameUnModelo(nombre);}
    public List<Modelo> dameModelos(){
        return TP.dameModelos();}
    
    //NivelImportancia
    public void crearNivelImportancia( String nombre) 
            throws PreexistingEntityException, Exception{
        TP.crearNivelImportancia(nombre);}
    public void editarNivelImportancia( String nombre) 
            throws PreexistingEntityException, Exception{
        TP.editarNivelImportancia(nombre);}
    public void eliminarNivelImportancia(String nombre) throws NonexistentEntityException{
        TP.eliminarNivelImportancia(nombre);}
    public NivelImportancia dameUnNivelImportancia(String nombre){
        return TP.dameUnNivelImportancia(nombre);}
    public List<NivelImportancia> dameNivelesImportancia(){
        return TP.dameNivelesImportancia();}
    
    //NivelSeveridad
    public void crearNivelSeveridad(int nivel, String nombre) 
            throws PreexistingEntityException, Exception{
        TP.crearNivelSeveridad(nivel, nombre);}
    public void editarNivelSeveridad(int nivel, String nombre) 
            throws PreexistingEntityException, Exception{
        TP.editarNivelSeveridad(nivel, nombre);}
    public void eliminarNivelSeveridad(int nivel) throws NonexistentEntityException{
        TP.eliminarNivelSeveridad(nivel);}
    public NivelSeveridad dameUnNivelSeveridad(int nivel){
        return TP.dameUnNivelSeveridad(nivel);}
    public List<NivelSeveridad> dameNivelesSeveridad(){
        return TP.dameNivelesSeveridad();}
    
    //Perito
    public void crearPerito(Localidad unaLoc,Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String p, Date horaInicio, Date horaFin) throws PreexistingEntityException, Exception{
        TP.crearPerito(unaLoc,unaSuc, nombre, dni, telefono, sueldo, p, horaInicio, horaFin);}
    public void editarPerito(Localidad unaLoc,Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String p, Date horaInicio, Date horaFin, boolean ok, List<Garantia> ga, List<Turno> tu
            ) throws PreexistingEntityException, Exception{
        TP.editarPerito(unaLoc,unaSuc, nombre, dni, telefono, sueldo, p, horaInicio, horaFin, ok, ga, tu);}
    public void eliminarPerito(long cod) throws NonexistentEntityException{
        TP.eliminarPerito(cod);}
    public Perito dameUnPerito(long cod){
        return TP.dameUnPerito(cod);}
    public List<Perito> damePeritos(){
        return TP.damePeritos();}
    
    //Proveedor
    public void crearProveedor(Localidad unaLoc, String nombre, long telefono, String cuit, long dni, 
            String responsabilidadFiscal, String eMail) throws PreexistingEntityException, Exception{
        TP.crearProveedor(unaLoc, nombre,  telefono, cuit, dni, 
            responsabilidadFiscal, eMail);}
    public void editarProveedor(Localidad unaLoc, String nombre,long telefono, String cuit, long dni, 
            String responsabilidadFiscal, String eMail, String tiempoEntrega, boolean ok, List<GrupoParte> gr
            ) throws PreexistingEntityException, Exception{
        TP.editarProveedor(unaLoc, nombre, telefono, cuit, dni, 
            responsabilidadFiscal, eMail, tiempoEntrega, ok, gr);}
    public void eliminarProveedor(long cod) throws NonexistentEntityException{
        TP.eliminarProveedor(cod);}
    public Proveedor dameUnProveedor(long cod){
        return TP.dameUnProveedor(cod);}
    public List<Proveedor> dameProveedores(){
        return TP.dameProveedores();}
    
    //Provincia
    public void crearProvincia(int codigo, String nombre) 
            throws PreexistingEntityException, Exception{
        TP.crearProvincia(codigo, nombre);}
    public void editarProvincia(int codigo, String nombre, List<Localidad> lo) 
            throws PreexistingEntityException, Exception{
        TP.editarProvincia(codigo, nombre, lo);}
    public void eliminarProvincia(int cod) throws NonexistentEntityException{
        TP.eliminarProvincia(cod);}
    public Provincia dameUnaProvincia(int cod){
        return TP.dameUnaProvincia(cod);}
    public List<Provincia> dameProvincias(){
        return TP.dameProvincias();}
    
    //Recepcion
    public void crearRecepcion(int cod, Date horaInicio, Date horaFin) 
            throws PreexistingEntityException, Exception{
        TP.crearRecepcion(cod, horaInicio, horaFin);}
    public void editarRecepcion(int cod, List<Empleado> em, List<Turno> tu, Date horaInicio, Date horaFin) 
            throws PreexistingEntityException, Exception{
        TP.editarRecepcion(cod, em, tu, horaInicio, horaFin);}
    public void eliminarRecepcion(int cod) throws NonexistentEntityException{
        TP.eliminarRecepcion(cod);}
    public Recepcion dameUnaRecepcion(int cod){
        return TP.dameUnaRecepcion(cod);}
    public List<Recepcion> dameRecepciones(){
        return TP.dameRecepciones();}
    
    //Repuesto
    public void crearRepuesto(int codParte, String descripcion, String caracteristicas, float precio, 
            int impuesto, boolean recambio, long stock) throws PreexistingEntityException, Exception{
        TP.crearRepuesto(codParte, descripcion, caracteristicas, precio, impuesto, recambio, stock);}
    public void editarRepuesto(int codParte, String descripcion, String caracteristicas, float precio, 
            int impuesto, boolean recambio, long stock, boolean ok
            , List<Item> it, List<Modelo> mo, List<Vehiculo> ve) throws PreexistingEntityException, Exception{
        TP.editarRepuesto(codParte, descripcion, caracteristicas, precio, impuesto, recambio, stock, ok
            , it, mo, ve);}
    public void eliminarRepuesto(int codParte) throws NonexistentEntityException{
        TP.eliminarRepuesto(codParte);}
    public Repuesto dameUnRepuesto(int codParte){
        return TP.dameUnRepuesto(codParte);}
    public List<Repuesto> dameRepuestos(){
        return TP.dameRepuestos();}
    
    //Segmento
    public void crearSegmento(String nombre) 
            throws PreexistingEntityException, Exception{
        TP.crearSegmento(nombre);}
    public void editarSegmento(String nombre) 
            throws PreexistingEntityException, Exception{
        TP.editarSegmento(nombre);}
    public void eliminarSegmento(String nombre) throws NonexistentEntityException{
        TP.eliminarSegmento(nombre);}
    public Segmento dameUnSegmento(String nombre){
        return TP.dameUnSegmento(nombre);}
    public List<Segmento> dameSegmentos(){
        return TP.dameSegmentos();}
    
    //Sucursal
    public void crearSucursal(int cod, Localidad unaLoc, long telefono, int altura, 
            Calle calleSuc,Date horaInicio, Date horaFin) throws PreexistingEntityException, Exception{
        TP.crearSucursal(cod, unaLoc, telefono, altura, calleSuc, horaInicio, horaFin);}
    public void editarSucursal(int cod, Localidad unaLoc, long telefono, int altura,  
            Calle calleSuc, boolean ok, List<Turno> tu, List<Sector> se, List<Pedido> pe, List<Empleado> em, 
            List<Calle> ca,Date horaInicio, Date horaFin,List<Cliente> cl) throws PreexistingEntityException, Exception{
        TP.editarSucursal(cod, unaLoc, telefono, altura, calleSuc, ok, tu, se, pe, em, ca, horaInicio, horaFin, cl);}
    public void eliminarSucursal(int codParte) throws NonexistentEntityException{
        TP.eliminarSucursal(codParte);}
    public Sucursal dameUnaSucursal(int codParte){
        return TP.dameUnaSucursal(codParte);}
    public List<Sucursal> dameSucursales(){
        return TP.dameSucursales();}
    
    //Taller
    public void crearTaller(int cod, Date horaInicio, Date horaFin) throws PreexistingEntityException, Exception{
        TP.crearTaller( cod, horaInicio, horaFin);}
    public void editarTaller(int cod, List<Empleado> em, List<OrdenTrabajo> or
            , Date horaInicio, Date horaFin) throws PreexistingEntityException, Exception{
        TP.editarTaller(cod, em, or, horaInicio, horaFin);}
    public void eliminarTaller(int cod) throws NonexistentEntityException{
        TP.eliminarTaller(cod);}
    public Taller dameUnTaller(int cod){
        return TP.dameUnTaller(cod);}
    public List<Taller> dameTalleres(){
        return TP.dameTalleres();}
    
    //Turno
    public void crearTurno(Vehiculo veh, Cliente cli, long codigo, Date fecha, String des, 
            Date duracionAprox, Date horaInicio, Estado est, NivelSeveridad nivS
            ) throws PreexistingEntityException, Exception{
        TP.crearTurno(veh, cli, codigo, fecha, des, duracionAprox, horaInicio, est, nivS);}
    public void editarTurno(Vehiculo veh, Cliente cli, long codigo, Date fecha, String des, 
            Date duracionAprox, Date horaInicio, Estado est, NivelSeveridad nivS, List<OrdenTrabajo> unaO,
            List<Empleado> vsEmp, boolean borrado
            ) throws PreexistingEntityException, Exception{
        TP.editarTurno(veh, cli, codigo, fecha, des, duracionAprox, horaInicio, est, nivS, 
                unaO, vsEmp, borrado);}
    public void eliminarTurno(long cod) throws NonexistentEntityException{
        TP.eliminarTurno(cod);}
    public Turno dameUnTurno(long cod){
        return TP.dameUnTurno(cod);}
    public List<Turno> dameTurnos(){
        return TP.dameTurnos();}
    
    //Vehiculo
    public void crearVehiculo(Segmento seg, Modelo mod, Garantia gar, Cliente cli, String dominio, 
            String nroChasis, String nroMotor, int anio, String color, int puertas) throws 
            PreexistingEntityException, Exception{
        TP.crearVehiculo(seg, mod, gar, cli, dominio, nroChasis, nroMotor, anio, color, puertas);}
    public void editarVehiculo(Segmento seg, Modelo mod, Garantia gar, Cliente cli, String dominio, 
            String nroChasis, String nroMotor, int anio, String color, int puertas, boolean ok
            , List<Turno> tup, List<OrdenTrabajo> or, List<Actividad> acr, List<Actividad> acp) throws 
            PreexistingEntityException, Exception{
        TP.editarVehiculo(seg, mod, gar, cli, dominio, nroChasis, nroMotor, anio, color, puertas, ok
            , tup, or, acr, acp);}
    public void eliminarVehiculo(String nroChasis) throws NonexistentEntityException{
        TP.eliminarVehiculo(nroChasis);}
    public Vehiculo dameUnVehiculo(String nroChasis){
        return TP.dameUnVehiculo(nroChasis);}
    public List<Vehiculo> dameVehiculos(){
        return TP.dameVehiculos();}
    
}
