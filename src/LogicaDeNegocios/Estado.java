package LogicaDeNegocios;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import javax.persistence.*;

@Entity
public class Estado implements Serializable {
    @Id
    private String nombre;
    
    //GET
    public String getNombre() { return this.nombre; }
    
    //SET
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String toString() { return "[Nombre: "+this.getNombre()+"]"; }
    
    public Estado() { }

    public Estado(String nombre) { this.nombre = nombre; }
    
    //En memoria (sin persistencia)    
    private static LinkedList<Estado> estados = new LinkedList<Estado>();

    //Metodos en memoria
    public Estado buscarEstado(String nombre){
        Estado est, ret=null;
        if (!estados.isEmpty()) { 
            Iterator<Estado> it = estados.iterator();
            while(it.hasNext()&& ret==null){
                est= it.next();
                if (est.getNombre().equalsIgnoreCase(nombre)){
                    ret=est;
                }
            }
        }        
        return ret;
    }
    public Estado creaEstado (String nombre){
        Estado ret = buscarEstado(nombre);
        if (ret==null){
            ret=new Estado(nombre);
            estados.add(ret);
        }else{
            ret=null; 
        }
        return ret;
    }    
    public Estado editaEstado(String nombre){
        Estado ret = buscarEstado( nombre);
        this.setNombre(nombre);
        if (ret!=null){
            estados.removeFirstOccurrence(ret);
            ret = this;
            estados.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaEstado(String nombre){
        Estado ret = buscarEstado (nombre);
        if (ret!=null){
            estados.removeFirstOccurrence(ret);
        }
    }
    public LinkedList<Estado> darEstado(){
        return estados;
    }
}
