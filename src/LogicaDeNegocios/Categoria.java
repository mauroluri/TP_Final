
package LogicaDeNegocios;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Categoria implements Serializable {
    @Id
    private String nombre;
    
    //Relaciones
        //Actividad
    @OneToMany
    private List<Actividad> vsEspecialidadActividad;

    //SETS
    public void setNombre(String nombre) { this.nombre = nombre;}
    public void setVsEspecialidadActividad(List<Actividad> vsEspecialidadActividad) { this.vsEspecialidadActividad = vsEspecialidadActividad; }
    
    //GETS
    public String getNombre() { return this.nombre;}
    public List<Actividad> getVsEspecialidadActividad() { return vsEspecialidadActividad; }
    
    public String toString() {  return "[Nombre: "+this.getNombre()+"]"; }
    
    public Categoria(){}
    
    public Categoria(String nombre){ 
        this.nombre=nombre;
        this.vsEspecialidadActividad = new LinkedList<Actividad>(); 
    }
                //En memoria (sin persistencia)    
    private static List<Categoria> categs = new LinkedList<Categoria>();

    //Metodos en memoria
    public Categoria buscarCategoria(String nombre){
        Categoria cat, ret=null;
        if (!categs.isEmpty()) { 
            Iterator<Categoria> it = categs.iterator();
            while(it.hasNext()&& ret==null){
                cat= it.next();
                if (cat.getNombre().equalsIgnoreCase(nombre)){
                    ret=cat;
                }
            }
        }        
        return ret;
    }
    public Categoria creaCategoria (String nombre){
        Categoria ret = buscarCategoria(nombre);
        if (ret==null){
            ret=new Categoria(nombre);
            categs.add(ret);
        }else{
            ret=null; 
        }
        return ret;
    }    
    public Categoria editaCategoria(String nombre, List<Actividad> act){
        Categoria ret = buscarCategoria( nombre);
        this.setNombre(nombre);
        this.setVsEspecialidadActividad(act);
        if (ret!=null){
            categs.remove(ret);
            ret = this;
            categs.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaCategoria(String nombre){
        Categoria ret = buscarCategoria (nombre);
        if (ret!=null){
            categs.remove(ret);
        }
    }
    public List<Categoria> darCategoria(){
        return categs;
    }
}
