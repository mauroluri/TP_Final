package LogicaDeNegocios;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Iterator;
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
       
            //En memoria (sin persistencia)    
    private static LinkedList<Calle> calles = new LinkedList<Calle>();

    //Metodos en memoria
    public Calle buscarCalle(String nombre){
        Calle ca, ret=null;
        if (!calles.isEmpty()) { 
            Iterator<Calle> it = calles.iterator();
            while(it.hasNext()&& ret==null){
                ca= it.next();
                if (ca.getNombre().equalsIgnoreCase(nombre)){
                    ret=ca;
                }
            }
        }        
        return ret;
    }
    public Calle creaCalle (String nombre){
        Calle ret = buscarCalle(nombre);
        if (ret==null){
            ret=new Calle(nombre);
            calles.add(ret);
        }else{
            ret=null; 
        }
        return ret;
    }    
    public Calle editaCalle(String nombre, Sucursal suc, LinkedList<Cliente> cli, LinkedList<Localidad> loc){
        Calle ret = buscarCalle( nombre);
        this.setNombre(nombre);
        this.setUnaSucursal(suc);
        this.setVsCliente(cli);
        this.setVsLocalidad(loc);
        if (ret!=null){
            calles.removeFirstOccurrence(ret);
            ret = this;
            calles.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaCalle(String nombre){
        Calle ret = buscarCalle (nombre);
        if (ret!=null){
            calles.removeFirstOccurrence(ret);
        }
    }
    public LinkedList<Calle> darCalle(){
        return calles;
    }
}
