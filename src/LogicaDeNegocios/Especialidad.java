package LogicaDeNegocios;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Especialidad implements Serializable {
    @Id
    private String nombre;
    
    //Relaciones
        //Mecanico
    @OneToMany
    private List<Mecanico> vsMecanico;

    //SET
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setVsMecanico(List<Mecanico> vsMecanico) { this.vsMecanico = vsMecanico; }

    //GETS
    public String getNombre() { return this.nombre; }
    public List<Mecanico> getVsMecanico() { return vsMecanico; }
    
    public String toString() { return "[Nombre: "+this.getNombre()+"]"; }

    public Especialidad() { }

    public Especialidad(String nombre) { 
        this.nombre = nombre;
        this.vsMecanico = new LinkedList<Mecanico>();
    }
    
    //En memoria (sin persistencia)    
    private static LinkedList<Especialidad> esps = new LinkedList<Especialidad>();

    //Metodos en memoria
    public Especialidad buscarEspecialidad(String nombre){
        Especialidad esp, ret=null;
        if (!esps.isEmpty()) { 
            Iterator<Especialidad> it = esps.iterator();
            while(it.hasNext()&& ret==null){
                esp= it.next();
                if (esp.getNombre().equalsIgnoreCase(nombre)){
                    ret=esp;
                }
            }
        }        
        return ret;
    }
    public Especialidad creaEspecialidad (String nombre){
        Especialidad ret = buscarEspecialidad(nombre);
        if (ret==null){
            ret=new Especialidad(nombre);
            esps.add(ret);
        }else{
            ret=null; 
        }
        return ret;
    }    
    public Especialidad editaEspecialidad(String nombre, LinkedList<Mecanico> me){
        Especialidad ret = buscarEspecialidad( nombre);
        this.setNombre(nombre);
        this.setVsMecanico(me);
        if (ret!=null){
            esps.removeFirstOccurrence(ret);
            ret = this;
            esps.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaEspecialidad(String nombre){
        Especialidad ret = buscarEspecialidad (nombre);
        if (ret!=null){
            esps.removeFirstOccurrence(ret);
        }
    }
    public LinkedList<Especialidad> darEspecialidad(){
        return esps;
    }
}
