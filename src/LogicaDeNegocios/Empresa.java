package LogicaDeNegocios;

import java.io.Serializable;
import java.util.List;
import java.util.LinkedList;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Empresa implements Serializable {
    @Id
    private String nombre;
    
    //Relaciones
        //Sucursal
    @OneToMany
    private List<Sucursal> vsSucursal;
        //Especialidad
    @OneToMany
    private List<Especialidad> vsEspecialidad;
        //Localidad
    @OneToMany
    private List<Localidad> vsLocalidad;
        //Provincia
    @OneToMany
    private List<Provincia> vsProvincia;
        //Vehiculo
    @OneToMany
    private List<Vehiculo> vsVehiculo;
        //Segmento
    @OneToMany
    private List<Segmento> vsSegmento;
        //Marca
    @OneToMany
    private List<Marca> vsMarca;
        //Modelo
    @OneToMany
    private List<Modelo> vsModelo;
        //Proveedor
    @OneToMany
    private List<Proveedor> vsProveedor;
        //GrupoParte
    @OneToMany
    private List<GrupoParte> vsGrupoParte;
        //Autoparte
    @OneToMany
    private List<Autoparte> vsAutoparte;
        //NivelSeveridad
    @OneToMany
    private List<NivelSeveridad> vsNivelSeveridad;
        //Estado
    @OneToMany
    private List<Estado> vsEstado;
        //Categoria
    @OneToMany
    private List<Categoria> vsCategoria;
        //DetalleActividad
    @OneToMany
    private List<DetalleActividad> vsDetalleActividad;
        //Actividad
    @OneToMany
    private List<Actividad> vsActividad;
       
    
    //SETS
    public void setNombre(String nombre){this.nombre= nombre;}
    public void setVsAutoparte(List<Autoparte> vsAutoparte) { this.vsAutoparte = vsAutoparte; }
    public void setVsCategoria(List<Categoria> vsCategoria) { this.vsCategoria = vsCategoria; }
    public void setVsEspecialidad(List<Especialidad> vsEspecialidad) { this.vsEspecialidad = vsEspecialidad; }
    public void setVsActividad(List<Actividad> vsActividad) { this.vsActividad = vsActividad; }
    public void setVsDetalleActividad(List<DetalleActividad> vsDetalleActividad) { this.vsDetalleActividad = vsDetalleActividad; }
    public void setVsEstado(List<Estado> vsEstado) { this.vsEstado = vsEstado; }
    public void setVsGrupoParte(List<GrupoParte> vsGrupoParte) { this.vsGrupoParte = vsGrupoParte; }
    public void setVsLocalidad(List<Localidad> vsLocalidad) { this.vsLocalidad = vsLocalidad; }
    public void setVsMarca(List<Marca> vsMarca) { this.vsMarca = vsMarca; }
    public void setVsModelo(List<Modelo> vsModelo) { this.vsModelo = vsModelo; }
    public void setVsNivelSeveridad(List<NivelSeveridad> vsNivelSeveridad) { this.vsNivelSeveridad = vsNivelSeveridad; }
    public void setVsProveedor(List<Proveedor> vsProveedor) { this.vsProveedor = vsProveedor; }
    public void setVsProvincia(List<Provincia> vsProvincia) { this.vsProvincia = vsProvincia; }
    public void setVsSegmento(List<Segmento> vsSegmento) { this.vsSegmento = vsSegmento; }
    public void setVsSucursal(List<Sucursal> vsSucursal) { this.vsSucursal = vsSucursal; }
    public void setVsVehiculo(List<Vehiculo> vsVehiculo) { this.vsVehiculo = vsVehiculo; }
        
    //GETS
    public String getNombre() {return this.nombre;}
    public List<Autoparte> getVsAutoparte() { return vsAutoparte; }
    public List<Categoria> getVsCategoria() { return vsCategoria; }
    public List<Especialidad> getVsEspecialidad() { return vsEspecialidad; }
    public List<Actividad> getVsActividad() { return vsActividad; }
    public List<DetalleActividad> getVsDetalleActividad() { return vsDetalleActividad; }
    public List<Estado> getVsEstado() { return vsEstado; }
    public List<GrupoParte> getVsGrupoParte() { return vsGrupoParte; }
    public List<Localidad> getVsLocalidad() { return vsLocalidad; }
    public List<Marca> getVsMarca() { return vsMarca; }
    public List<Modelo> getVsModelo() { return vsModelo; }
    public List<NivelSeveridad> getVsNivelSeveridad() { return vsNivelSeveridad; }
    public List<Proveedor> getVsProveedor() { return vsProveedor; }
    public List<Provincia> getVsProvincia() { return vsProvincia; }
    public List<Segmento> getVsSegmento() { return vsSegmento; }
    public List<Sucursal> getVsSucursal() { return vsSucursal; }
    public List<Vehiculo> getVsVehiculo() { return vsVehiculo; }
    
    
    
    public String toString() { return "[Nombre: "+this.getNombre()+"]"; }
    
    //CONSTRUCTORES
    public Empresa(){ }
    
    public Empresa(String nombre){
        this.nombre=nombre;
        this.vsSucursal = new LinkedList<Sucursal>();
        this.vsEspecialidad = new LinkedList<Especialidad>();
        this.vsLocalidad = new LinkedList<Localidad>();
        this.vsProvincia = new LinkedList<Provincia>();
        this.vsVehiculo = new LinkedList<Vehiculo>();
        this.vsSegmento = new LinkedList<Segmento>();
        this.vsMarca = new LinkedList<Marca>();
        this.vsModelo = new LinkedList<Modelo>();
        this.vsProveedor = new LinkedList<Proveedor>();
        this.vsGrupoParte = new LinkedList<GrupoParte>();
        this.vsAutoparte = new LinkedList<Autoparte>();
        this.vsNivelSeveridad = new LinkedList<NivelSeveridad>();
        this.vsEstado = new LinkedList<Estado>();
        this.vsCategoria = new LinkedList<Categoria>();
        this.vsDetalleActividad = new LinkedList<DetalleActividad>();
        this.vsActividad = new LinkedList<Actividad>();
    }
    
}

