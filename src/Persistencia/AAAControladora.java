package Persistencia;

import Persistencia.exceptions.*;
import LogicaDeNegocios.*;
import java.util.Date;
import java.util.List;

public class AAAControladora {
    AccesorioJpaControlle miAccesorioJpa = new AccesorioJpaControlle();
    ActividadJpaController miActividadJpa = new ActividadJpaController();
    AjusteJpaController miAjusteJpa = new AjusteJpaController();
    AtencionPublicoJpaController miAtencionPublicoJpa = new AtencionPublicoJpaController();
    CalleJpaController miCalleJpa = new CalleJpaController();
    CategoriaJpaController miCategoriaJpa = new CategoriaJpaController();
    ClienteJpaController miClienteJpa = new ClienteJpaController();
    DepositoJpaController miDepositoJpa = new DepositoJpaController();
    DetalleActividadJpaController miDetalleActividadJpa = new DetalleActividadJpaController();
    DiagnosticoJpaController miDiagnosticoJpa = new DiagnosticoJpaController();
    EmpresaJpaController miEmpresaJpa = new EmpresaJpaController();
    EncargadoJpaController miEncargadoJpa = new EncargadoJpaController();
    EquipamientoJpaController miEquipamientoJpa = new EquipamientoJpaController();
    EspecialidadJpaController miEspecialidadJpa = new EspecialidadJpaController();
    EstadoJpaController miEstadoJpa = new EstadoJpaController();
    ExternoJpaController miExternoJpa = new ExternoJpaController();
    GarantiaJpaController miGarantiaJpa = new GarantiaJpaController();
    GrupoParteJpaController miGrupoParteJpa = new GrupoParteJpaController();
    InternoJpaController miInternoJpa = new InternoJpaController();
    ItemJpaController miItemJpa = new ItemJpaController();
    LocalidadJpaController miLocalidadJpa = new LocalidadJpaController();
    MarcaJpaController miMarcaJpa = new MarcaJpaController();
    MecanicoJpaController miMecanicoJpa = new MecanicoJpaController();
    ModeloJpaController miModeloJpa = new ModeloJpaController();
    NivelImportanciaJpaController miNivelImportanciaJpa = new NivelImportanciaJpaController();
    NivelSeveridadJpaController miNivelSeveridadJpa = new NivelSeveridadJpaController();
    OrdenTrabajoJpaController miOrdenTrabajoJpa = new OrdenTrabajoJpaController();
    PeritoJpaController miPeritoJpa = new PeritoJpaController();
    ProveedorJpaController miProveedorJpa = new ProveedorJpaController();
    ProvinciaJpaController miProvinciaJpa = new ProvinciaJpaController();
    RecepcionJpaController miRecepcionJpa = new RecepcionJpaController();
    RepuestoJpaController miRepuestoJpa = new RepuestoJpaController();
    SegmentoJpaController miSegmentoJpa = new SegmentoJpaController();
    SucursalJpaController miSucursalJpa = new SucursalJpaController();
    TallerJpaController miTallerJpa = new TallerJpaController();
    TurnoJpaController miTurnoJpa = new TurnoJpaController();
    VehiculoJpaController miVehiculoJpa = new VehiculoJpaController();
    
    //Accesorio
    public void crearAccesorio (Accesorio miAcc) throws PreexistingEntityException, Exception{
        miAccesorioJpa.create(miAcc);}    
    public void editarAccesorio (Accesorio miAcc) throws NonexistentEntityException, Exception {
        miAccesorioJpa.edit(miAcc);}    
    public void eliminarAccesorio (int cod) throws NonexistentEntityException {
        miAccesorioJpa.destroy(cod);}    
    public Accesorio dameUnAccesorio (int cod) {
        return miAccesorioJpa.findAccesorio(cod);}    
    public List<Accesorio> dameAccesorios (){
        return miAccesorioJpa.findAccesorioEntities();}
    
    //Actividad
    public void crearActividad (Actividad miEsp) throws PreexistingEntityException, Exception{
        miActividadJpa.create(miEsp);}    
    public void editarActividad (Actividad miEsp) throws NonexistentEntityException, Exception {
        miActividadJpa.edit(miEsp);}    
    public void eliminarActividad (String nom) throws NonexistentEntityException {
        miActividadJpa.destroy(nom);}    
    public Actividad dameUnaActividad (String nom) {
        return miActividadJpa.findActividad(nom);}    
    public List<Actividad> dameActividades (){
        return miActividadJpa.findActividadEntities();}
    
    //Ajuste
    public void crearAjuste (Ajuste miAju) throws PreexistingEntityException, Exception{
        miAjusteJpa.create(miAju);}    
    public void editarAjuste (Ajuste miAju) throws NonexistentEntityException, Exception {
        miAjusteJpa.edit(miAju);}    
    public void eliminarAjuste (long cod) throws NonexistentEntityException {
        miAjusteJpa.destroy(cod);}    
    public Ajuste dameUnAjuste (long cod) {
        return miAjusteJpa.findAjuste(cod);}    
    public List<Ajuste> dameAjustes (){
        return miAjusteJpa.findAjusteEntities();}
    
    //AtencionPublico
    public void crearAtencionPublico (AtencionPublico miAte) throws PreexistingEntityException, Exception{
        miAtencionPublicoJpa.create(miAte);}    
    public void editarAtencionPublico (AtencionPublico miAte) throws NonexistentEntityException, Exception {
        miAtencionPublicoJpa.edit(miAte);}    
    public void eliminarAtencionPublico (long dni) throws NonexistentEntityException {
        miAtencionPublicoJpa.destroy(dni);}    
    public AtencionPublico dameUnAtencionPublico (long dni) {
        return miAtencionPublicoJpa.findAtencionPublico(dni);}    
    public List<AtencionPublico> dameAtencionesPublico (){
        return miAtencionPublicoJpa.findAtencionPublicoEntities();}
    
    //Calle
    public void crearCalle (Calle miCal) throws PreexistingEntityException, Exception{
        miCalleJpa.create(miCal);}    
    public void editarCalle (Calle miCal) throws NonexistentEntityException, Exception {
        miCalleJpa.edit(miCal);}    
    public void eliminarCalle (String nom) throws NonexistentEntityException {
        miCalleJpa.destroy(nom);}    
    public Calle dameUnaCalle (String nom) {
        return miCalleJpa.findCalle(nom);}    
    public List<Calle> dameCalles (){
        return miCalleJpa.findCalleEntities();}
    
    //Categoria
    public void crearCategoria (Categoria miCat) throws PreexistingEntityException, Exception{
        miCategoriaJpa.create(miCat);}    
    public void editarCategoria (Categoria miCat) throws NonexistentEntityException, Exception {
        miCategoriaJpa.edit(miCat);}    
    public void eliminarCategoria (String nom) throws NonexistentEntityException {
        miCategoriaJpa.destroy(nom);}    
    public Categoria dameUnaCategoria (String nom) {
        return miCategoriaJpa.findCategoria(nom);}    
    public List<Categoria> dameCategorias (){
        return miCategoriaJpa.findCategoriaEntities();}
    
    //Cliente
    public void crearCliente (Cliente miCli) throws PreexistingEntityException, Exception{
        miClienteJpa.create(miCli);}    
    public void editarCliente (Cliente miCli) throws NonexistentEntityException, Exception {
        miClienteJpa.edit(miCli);}    
    public void eliminarCliente (long dni) throws NonexistentEntityException {
        miClienteJpa.destroy(dni);}    
    public Cliente dameUnCliente (long dni) {
        return miClienteJpa.findCliente(dni);}    
    public List<Cliente> dameClientes (){
        return miClienteJpa.findClienteEntities();}
    
    //Deposito
    public void crearDeposito (Deposito miDep) throws PreexistingEntityException, Exception{
        miDepositoJpa.create(miDep);}    
    public void editarDeposito (Deposito miDep) throws NonexistentEntityException, Exception {
        miDepositoJpa.edit(miDep);}    
    public void eliminarDeposito (int nom) throws NonexistentEntityException {
        miDepositoJpa.destroy(nom);}    
    public Deposito dameUnDeposito (int nom) {
        return miDepositoJpa.findDeposito(nom);}    
    public List<Deposito> dameDepositos (){
        return miDepositoJpa.findDepositoEntities();}
    
    //DetalleActividad
    public void crearDetalleActividad (DetalleActividad miEsp) throws PreexistingEntityException, Exception{
        miDetalleActividadJpa.create(miEsp);}    
    public void editarDetalleActividad (DetalleActividad miEsp) throws NonexistentEntityException, Exception {
        miDetalleActividadJpa.edit(miEsp);}    
    public void eliminarDetalleActividad (String nom) throws NonexistentEntityException {
        miDetalleActividadJpa.destroy(nom);}    
    public DetalleActividad dameUnDetalleActividad (String nom) {
        return miDetalleActividadJpa.findDetalleActividad(nom);}    
    public List<DetalleActividad> dameDetallesActividad (){
        return miDetalleActividadJpa.findDetalleActividadEntities();}
        
    //Diagnostico
    public void crearDiagnostico (Diagnostico miDia) throws PreexistingEntityException, Exception{
        miDiagnosticoJpa.create(miDia);}    
    public void editarDiagnostico (Diagnostico miDia) throws NonexistentEntityException, Exception {
        miDiagnosticoJpa.edit(miDia);}    
    public void eliminarDiagnostico (long cod) throws NonexistentEntityException {
        miDiagnosticoJpa.destroy(cod);}    
    public Diagnostico dameUnDiagnostico (long cod) {
        return miDiagnosticoJpa.findDiagnostico(cod);}    
    public List<Diagnostico> dameDiagnosticos (){
        return miDiagnosticoJpa.findDiagnosticoEntities();}
    
    //Empresa
    public void crearEmpresa (Empresa miEmp) throws PreexistingEntityException, Exception{
        miEmpresaJpa.create(miEmp);}    
    public void editarEmpresa (Empresa miEmp) throws NonexistentEntityException, Exception {
        miEmpresaJpa.edit(miEmp);}    
    public void eliminarEmpresa (String nom) throws NonexistentEntityException {
        miEmpresaJpa.destroy(nom);}    
    public Empresa dameUnaEmpresa (String nom) {
        return miEmpresaJpa.findEmpresa(nom);}    
    public List<Empresa> dameEmpresas (){
        return miEmpresaJpa.findEmpresaEntities();}
    
    //Encargado
    public void crearEncargado (Encargado miEnc) throws PreexistingEntityException, Exception{
        miEncargadoJpa.create(miEnc);}    
    public void editarEncargado (Encargado miEnc) throws NonexistentEntityException, Exception {
        miEncargadoJpa.edit(miEnc);}    
    public void eliminarEncargado (long dni) throws NonexistentEntityException {
        miEncargadoJpa.destroy(dni);}    
    public Encargado dameUnEncargado (long dni) {
        return miEncargadoJpa.findEncargado(dni);}    
    public List<Encargado> dameEncargados (){
        return miEncargadoJpa.findEncargadoEntities();}
    
    //Equipamiento
    public void crearEquipamiento (Equipamiento miEqu) throws PreexistingEntityException, Exception{
        miEquipamientoJpa.create(miEqu);}    
    public void editarEquipamiento (Equipamiento miEqu) throws NonexistentEntityException, Exception {
        miEquipamientoJpa.edit(miEqu);}    
    public void eliminarEquipamiento (int cod) throws NonexistentEntityException {
        miEquipamientoJpa.destroy(cod);}    
    public Equipamiento dameUnEquipamiento (int cod) {
        return miEquipamientoJpa.findEquipamiento(cod);}    
    public List<Equipamiento> dameEquipamientos (){
        return miEquipamientoJpa.findEquipamientoEntities();}
    
    //Especialidad
    public void crearEspecialidad (Especialidad miEsp) throws PreexistingEntityException, Exception{
        miEspecialidadJpa.create(miEsp);}    
    public void editarEspecialidad (Especialidad miEsp) throws NonexistentEntityException, Exception {
        miEspecialidadJpa.edit(miEsp);}    
    public void eliminarEspecialidad (String nom) throws NonexistentEntityException {
        miEspecialidadJpa.destroy(nom);}    
    public Especialidad dameUnaEspecialidad (String nom) {
        return miEspecialidadJpa.findEspecialidad(nom);}    
    public List<Especialidad> dameEspecialidades (){
        return miEspecialidadJpa.findEspecialidadEntities();}
    
    
    
    //Estado
    public void crearEstado (Estado miEst) throws PreexistingEntityException, Exception{
        miEstadoJpa.create(miEst);}    
    public void editarEstado (Estado miEst) throws NonexistentEntityException, Exception {
        miEstadoJpa.edit(miEst);}    
    public void eliminarEstado (String nom) throws NonexistentEntityException {
        miEstadoJpa.destroy(nom);}    
    public Estado dameUnEstado (String nom) {
        return miEstadoJpa.findEstado(nom);}    
    public List<Estado> dameEstados (){
        return miEstadoJpa.findEstadoEntities();}
    
    //Externo
    public void crearExterno (Externo miExt) throws PreexistingEntityException, Exception{
        miExternoJpa.create(miExt);}    
    public void editarExterno (Externo miExt) throws NonexistentEntityException, Exception {
        miExternoJpa.edit(miExt);}    
    public void eliminarExterno (long cod) throws NonexistentEntityException {
        miExternoJpa.destroy(cod);}    
    public Externo dameUnExterno (long cod) {
        return miExternoJpa.findExterno(cod);}    
    public List<Externo> dameExternos (){
        return miExternoJpa.findExternoEntities();}
    
    //Garantia
    public void crearGarantia (Garantia miGar) throws PreexistingEntityException, Exception{
        miGarantiaJpa.create(miGar);}    
    public void editarGarantia (Garantia miGar) throws NonexistentEntityException, Exception {
        miGarantiaJpa.edit(miGar);}    
    public void eliminarGarantia (String detalle) throws NonexistentEntityException {
        miGarantiaJpa.destroy(detalle);}    
    public Garantia dameUnaGarantia (String detalle) {
        return miGarantiaJpa.findGarantia(detalle);}    
    public List<Garantia> dameGarantias (){
        return miGarantiaJpa.findGarantiaEntities();}
    
    //GrupoParte
    public void crearGrupoParte (GrupoParte miGru) throws PreexistingEntityException, Exception{
        miGrupoParteJpa.create(miGru);}    
    public void editarGrupoParte (GrupoParte miGru) throws NonexistentEntityException, Exception {
        miGrupoParteJpa.edit(miGru);}    
    public void eliminarGrupoParte (int cod) throws NonexistentEntityException {
        miGrupoParteJpa.destroy(cod);}    
    public GrupoParte dameUnGrupoParte (int cod) {
        return miGrupoParteJpa.findGrupoParte(cod);}    
    public List<GrupoParte> dameGruposParte (){
        return miGrupoParteJpa.findGrupoParteEntities();}
    
    //Interno
    public void crearInterno (Interno miInt) throws PreexistingEntityException, Exception{
        miInternoJpa.create(miInt);}    
    public void editarInterno (Interno miInt) throws NonexistentEntityException, Exception {
        miInternoJpa.edit(miInt);}    
    public void eliminarInterno (long cod) throws NonexistentEntityException {
        miInternoJpa.destroy(cod);}    
    public Interno dameUnInterno (long cod) {
        return miInternoJpa.findInterno(cod);}    
    public List<Interno> dameInternos (){
        return miInternoJpa.findInternoEntities();}
    
    //Item
    public void crearItem (Item miIt) throws PreexistingEntityException, Exception{
        miItemJpa.create(miIt);}    
    public void editarItem (Item miIt) throws NonexistentEntityException, Exception {
        miItemJpa.edit(miIt);}    
    public void eliminarItem (int cod) throws NonexistentEntityException {
        miItemJpa.destroy(cod);}    
    public Item dameUnItem (int cod) {
        return miItemJpa.findItem(cod);}    
    public List<Item> dameItems (){
        return miItemJpa.findItemEntities();}
    
    //Localidad
    public void crearLocalidad (Localidad miLoc) throws PreexistingEntityException, Exception{
        miLocalidadJpa.create(miLoc);}    
    public void editarLocalidad (Localidad miLoc) throws NonexistentEntityException, Exception {
        miLocalidadJpa.edit(miLoc);}    
    public void eliminarLocalidad (int cod) throws NonexistentEntityException {
        miLocalidadJpa.destroy(cod);}    
    public Localidad dameUnaLocalidad (int cod) {
        return miLocalidadJpa.findLocalidad(cod);}    
    public List<Localidad> dameLocalidades (){
        return miLocalidadJpa.findLocalidadEntities();}
    
    //Marca
    public void crearMarca (Marca miMar) throws PreexistingEntityException, Exception{
        miMarcaJpa.create(miMar);}    
    public void editarMarca (Marca miMar) throws NonexistentEntityException, Exception {
        miMarcaJpa.edit(miMar);}    
    public void eliminarMarca (String nom) throws NonexistentEntityException {
        miMarcaJpa.destroy(nom);}    
    public Marca dameUnaMarca (String nom) {
        return miMarcaJpa.findMarca(nom);}    
    public List<Marca> dameMarcas (){
        return miMarcaJpa.findMarcaEntities();}
    
    //Mecanico
    public void crearMecanico (Mecanico miMec) throws PreexistingEntityException, Exception{
        miMecanicoJpa.create(miMec);}    
    public void editarMecanico (Mecanico miMec) throws NonexistentEntityException, Exception {
        miMecanicoJpa.edit(miMec);}    
    public void eliminarMecanico (long dni) throws NonexistentEntityException {
        miMecanicoJpa.destroy(dni);}    
    public Mecanico dameUnMecanico (long dni) {
        return miMecanicoJpa.findMecanico(dni);}    
    public List<Mecanico> dameMecanicos (){
        return miMecanicoJpa.findMecanicoEntities();}
    
    //Modelo
    public void crearModelo (Modelo miMod) throws PreexistingEntityException, Exception{
        miModeloJpa.create(miMod);}    
    public void editarModelo (Modelo miMod) throws NonexistentEntityException, Exception {
        miModeloJpa.edit(miMod);}    
    public void eliminarModelo (String nom) throws NonexistentEntityException {
        miModeloJpa.destroy(nom);}    
    public Modelo dameUnModelo (String nom) {
        return miModeloJpa.findModelo(nom);}    
    public List<Modelo> dameModelos (){
        return miModeloJpa.findModeloEntities();}
    
    //NivelImportancia
    public void crearNivelImportancia (NivelImportancia miNiv) throws PreexistingEntityException, Exception{
        miNivelImportanciaJpa.create(miNiv);}    
    public void editarNivelImportancia (NivelImportancia miNiv) throws NonexistentEntityException, Exception {
        miNivelImportanciaJpa.edit(miNiv);}    
    public void eliminarNivelImportancia (String nom) throws NonexistentEntityException {
        miNivelImportanciaJpa.destroy(nom);}    
    public NivelImportancia dameUnNivelImportancia (String nom) {
        return miNivelImportanciaJpa.findNivelImportancia(nom);}    
    public List<NivelImportancia> dameNivelesImportancia (){
        return miNivelImportanciaJpa.findNivelImportanciaEntities();}
    
    //NivelSeveridad
    public void crearNivelSeveridad (NivelSeveridad miNiv) throws PreexistingEntityException, Exception{
        miNivelSeveridadJpa.create(miNiv);}    
    public void editarNivelSeveridad (NivelSeveridad miNiv) throws NonexistentEntityException, Exception {
        miNivelSeveridadJpa.edit(miNiv);}    
    public void eliminarNivelSeveridad (int cod) throws NonexistentEntityException {
        miNivelSeveridadJpa.destroy(cod);}    
    public NivelSeveridad dameUnNivelSeveridad (int cod) {
        return miNivelSeveridadJpa.findNivelSeveridad(cod);}    
    public List<NivelSeveridad> dameNivelesSeveridad (){
        return miNivelSeveridadJpa.findNivelSeveridadEntities();}
    
    //OrdenTrabajo
    public void crearOrdenTrabajo (OrdenTrabajo miOr) throws PreexistingEntityException, Exception{
        miOrdenTrabajoJpa.create(miOr);}    
    public void editarOrdenTrabajo (OrdenTrabajo miOr) throws NonexistentEntityException, Exception {
        miOrdenTrabajoJpa.edit(miOr);}    
    public void eliminarOrdenTrabajo (int cod) throws NonexistentEntityException {
        miOrdenTrabajoJpa.destroy(cod);}    
    public OrdenTrabajo dameUnaOrdenTrabajo (int cod) {
        return miOrdenTrabajoJpa.findOrdenTrabajo(cod);}    
    public List<OrdenTrabajo> dameOrdenesTrabajo (){
        return miOrdenTrabajoJpa.findOrdenTrabajoEntities();}
        
    //Perito
    public void crearPerito (Perito miPer) throws PreexistingEntityException, Exception{
        miPeritoJpa.create(miPer);}    
    public void editarPerito (Perito miPer) throws NonexistentEntityException, Exception {
        miPeritoJpa.edit(miPer);}    
    public void eliminarPerito (long dni) throws NonexistentEntityException {
        miPeritoJpa.destroy(dni);}    
    public Perito dameUnPerito (long dni) {
        return miPeritoJpa.findPerito(dni);}    
    public List<Perito> damePeritos (){
        return miPeritoJpa.findPeritoEntities();}
    
    //Proveedor
    public void crearProveedor (Proveedor miPro) throws PreexistingEntityException, Exception{
        miProveedorJpa.create(miPro);}    
    public void editarProveedor (Proveedor miPro) throws NonexistentEntityException, Exception {
        miProveedorJpa.edit(miPro);}    
    public void eliminarProveedor (long dni) throws NonexistentEntityException {
        miProveedorJpa.destroy(dni);}    
    public Proveedor dameUnProveedor (long dni) {
        return miProveedorJpa.findProveedor(dni);}    
    public List<Proveedor> dameProveedores (){
        return miProveedorJpa.findProveedorEntities();}
    
    //Provincia
    public void crearProvincia (Provincia miPro) throws PreexistingEntityException, Exception{
        miProvinciaJpa.create(miPro);}    
    public void editarProvincia (Provincia miPro) throws NonexistentEntityException, Exception {
        miProvinciaJpa.edit(miPro);}    
    public void eliminarProvincia (int cod) throws NonexistentEntityException {
        miProvinciaJpa.destroy(cod);}    
    public Provincia dameUnaProvincia (int cod) {
        return miProvinciaJpa.findProvincia(cod);}    
    public List<Provincia> dameProvincias (){
        return miProvinciaJpa.findProvinciaEntities();}
    
    //Recepcion
    public void crearRecepcion (Recepcion miRec) throws PreexistingEntityException, Exception{
        miRecepcionJpa.create(miRec);}    
    public void editarRecepcion (Recepcion miRec) throws NonexistentEntityException, Exception {
        miRecepcionJpa.edit(miRec);}    
    public void eliminarRecepcion (int nom) throws NonexistentEntityException {
        miRecepcionJpa.destroy(nom);}    
    public Recepcion dameUnaRecepcion (int nom) {
        return miRecepcionJpa.findRecepcion(nom);}    
    public List<Recepcion> dameRecepciones (){
        return miRecepcionJpa.findRecepcionEntities();}
    
    //Repuesto
    public void crearRepuesto (Repuesto miRep) throws PreexistingEntityException, Exception{
        miRepuestoJpa.create(miRep);}    
    public void editarRepuesto (Repuesto miRep) throws NonexistentEntityException, Exception {
        miRepuestoJpa.edit(miRep);}    
    public void eliminarRepuesto (int cod) throws NonexistentEntityException {
        miRepuestoJpa.destroy(cod);}    
    public Repuesto dameUnRepuesto (int cod) {
        return miRepuestoJpa.findRepuesto(cod);}    
    public List<Repuesto> dameRepuestos (){
        return miRepuestoJpa.findRepuestoEntities();}
    
    //Segmento
    public void crearSegmento (Segmento miSeg) throws PreexistingEntityException, Exception{
        miSegmentoJpa.create(miSeg);}    
    public void editarSegmento (Segmento miSeg) throws NonexistentEntityException, Exception {
        miSegmentoJpa.edit(miSeg);}    
    public void eliminarSegmento (String nom) throws NonexistentEntityException {
        miSegmentoJpa.destroy(nom);}    
    public Segmento dameUnSegmento (String nom) {
        return miSegmentoJpa.findSegmento(nom);}    
    public List<Segmento> dameSegmentos (){
        return miSegmentoJpa.findSegmentoEntities();}
    
    //Sucursal
    public void crearSucursal (Sucursal miSuc) throws PreexistingEntityException, Exception{
        miSucursalJpa.create(miSuc);}    
    public void editarSucursal (Sucursal miSuc) throws NonexistentEntityException, Exception {
        miSucursalJpa.edit(miSuc);}    
    public void eliminarSucursal (int cod) throws NonexistentEntityException {
        miSucursalJpa.destroy(cod);}    
    public Sucursal dameUnaSucursal (int cod) {
        return miSucursalJpa.findSucursal(cod);}    
    public List<Sucursal> dameSucursales (){
        return miSucursalJpa.findSucursalEntities();}
    
    //Taller
    public void crearTaller (Taller miTal) throws PreexistingEntityException, Exception{
        miTallerJpa.create(miTal);}    
    public void editarTaller (Taller miTal) throws NonexistentEntityException, Exception {
        miTallerJpa.edit(miTal);}    
    public void eliminarTaller (int nom) throws NonexistentEntityException {
        miTallerJpa.destroy(nom);}    
    public Taller dameUnTaller (int nom) {
        return miTallerJpa.findTaller(nom);}    
    public List<Taller> dameTalleres (){
        return miTallerJpa.findTallerEntities();}
    
    //Turno
    public void crearTurno (Turno miTur) throws PreexistingEntityException, Exception{
        miTurnoJpa.create(miTur);}    
    public void editarTurno (Turno miTur) throws NonexistentEntityException, Exception {
        miTurnoJpa.edit(miTur);}    
    public void eliminarTurno (long cod) throws NonexistentEntityException {
        miTurnoJpa.destroy(cod);}    
    public Turno dameUnTurno (long cod) {
        return miTurnoJpa.findTurno(cod);}    
    public List<Turno> dameTurnos (){
        return miTurnoJpa.findTurnoEntities();}
    
    //Vehiculo
    public void crearVehiculo (Vehiculo miVeh) throws PreexistingEntityException, Exception{
        miVehiculoJpa.create(miVeh);}    
    public void editarVehiculo (Vehiculo miVeh) throws NonexistentEntityException, Exception {
        miVehiculoJpa.edit(miVeh);}    
    public void eliminarVehiculo (String nroChasis) throws NonexistentEntityException {
        miVehiculoJpa.destroy(nroChasis);}    
    public Vehiculo dameUnVehiculo (String nroChasis) {
        return miVehiculoJpa.findVehiculo(nroChasis);}    
    public List<Vehiculo> dameVehiculos (){
        return miVehiculoJpa.findVehiculoEntities();}
}