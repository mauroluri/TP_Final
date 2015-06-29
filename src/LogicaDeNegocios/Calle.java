package LogicaDeNegocios;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Calle implements Serializable {
    @Id
    private String nombre;
    
    //Relaciones
            //Sucursal
    @ManyToOne
    private Sucursal unaSucursal;
            //Cliente
    @OneToMany
    private List<Cliente> vsCliente; 
            //Localidad
    @ManyToMany
    private List<Localidad> vsLocalidad;
    
    //SET
    public void setNombre(String nombre) { this.nombre = nombre;}
    public void setUnaSucursal(Sucursal unaSucursal) { this.unaSucursal = unaSucursal; }
    public void setVsCliente(List<Cliente> vsCliente) { this.vsCliente = vsCliente; }
    public void setVsLocalidad(List<Localidad> vsLocalidad) { this.vsLocalidad = vsLocalidad; }
    
    //GET
    public String getNombre() {  return this.nombre;}
    public Sucursal getUnaSucursal() { return unaSucursal; }
    public List<Cliente> getVsCliente() { return vsCliente; }
    public List<Localidad> getVsLocalidad() { return vsLocalidad; }
        
    public String toString() {  return "[Nombre: "+this.getNombre()+"]";}
    
    public Calle(){}
    
    public Calle(String nombre){ 
        this.nombre = nombre;
        this.unaSucursal = null;
        this.vsCliente = new LinkedList<Cliente>();
        this.vsLocalidad = new LinkedList<Localidad>();
    }
    
}
