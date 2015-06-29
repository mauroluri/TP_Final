package LogicaDeNegocios;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
public abstract class Autoparte implements Serializable{
    @Id
    private int codParte;
    @Basic
    private String descripcion;
    @Basic
    private String caracteristicas;
    @Basic
    private float precio;
    @Basic
    private int impuesto;
    @Basic
    private boolean recambio;
    @Basic
    private long stock;
    @Basic
    private boolean borrado;
    
    //Relaciones
        //Vehiculo
    @OneToMany
    private List<Vehiculo> vsVehiculo;
        //Item
    @OneToMany
    private List<Item> vsItem;
        //Modelo
    @OneToMany
    private List<Modelo> vsModelo;
    
    
    //GETS
    public int getCodParte() { return this.codParte;}
    public String getDescripcion() { return this.descripcion; }
    public String getCaracteristicas() {return this.caracteristicas;}
    public float getPrecio() {  return this.precio;}
    public int getImpuesto() { return this.impuesto;}
    public List<Modelo> getVsModelo() { return this.vsModelo;}
    public boolean getRecambio(){ return this.recambio; }
    public long getStock() {return this.stock; }
    public boolean getBorrado() {return this.borrado;}
    public List<Item> getVsItem() { return vsItem; }
    public List<Vehiculo> getVsVehiculo() { return vsVehiculo; }
        
    //SETS
    public void setCodParte(int codParte) {  this.codParte = codParte;}
    public void setDescripcion(String descripcion) { this.descripcion = descripcion;}
    public void setCaracteristicas(String caracteristicas) { this.caracteristicas = caracteristicas;}
    public void setPrecio(float precio) { this.precio = precio;}
    public void setImpuesto(int impuesto) { this.impuesto = impuesto;}
    public void setVsModelo(List<Modelo> vsModelo) { this.vsModelo = vsModelo;}
    public void setRecambio(boolean recambio) { this.recambio = recambio;}
    public void setStock(long stock) { this.stock = stock;}
    public void setBorrado (boolean borrado) {this.borrado = borrado;}
    public void setVsItem(List<Item> vsItem) { this.vsItem = vsItem; }
    public void setVsVehiculo(List<Vehiculo> vsVehiculo) { this.vsVehiculo = vsVehiculo; }
    
    
    public String toString() {
        return "[Código: "+this.getCodParte()+"] \n[Descripción: "+this.getDescripcion()+"] \n"
                + "[Características: "+this.getCaracteristicas()+"] \n[Precio: "+this.getPrecio()+"] "
                + "\n[Impuesto: "+this.getImpuesto() + "\n[Recambio: "+this.getRecambio()+"] \n[Stock: "
                +this.getStock()+ "\n[Borrado: " +this.getBorrado()+"]";
    }
    
    //CONSTRUCTORES
    public Autoparte() {}

    public Autoparte(int codParte, String descripcion, String caracteristicas, float precio, int impuesto, 
            boolean recambio, long stock) {
        this.codParte = codParte;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
        this.precio = precio;
        this.impuesto = impuesto;
        this.vsModelo = new LinkedList<Modelo>();
        this.recambio = recambio;
        this.stock = stock;
        this.borrado = false;
        this.vsItem = new LinkedList<Item>();
        this.vsVehiculo = new LinkedList<Vehiculo>();
    }
}
