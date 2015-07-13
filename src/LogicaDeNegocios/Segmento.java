package LogicaDeNegocios;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import javax.persistence.*;

@Entity
public class Segmento implements Serializable {
    @Id
    private String nombre;

    public void setNombre(String nombre) { this.nombre = nombre; }

    //GET
    public String getNombre() { return this.nombre; }
    
    //SET
    public String toString() { return "[Nombre: "+this.getNombre()+"]"; }
    
    public Segmento(){}
    
    public Segmento(String nombre){
        this.nombre=nombre;
    }
           
            //En memoria (sin persistencia)    
    private static LinkedList<Segmento> segs = new LinkedList<Segmento>();

    //Metodos en memoria
    public Segmento buscarSegmento(String nombre){
        Segmento se, ret=null;
        if (!segs.isEmpty()) { 
            Iterator<Segmento> it = segs.iterator();
            while(it.hasNext()&& ret==null){
                se= it.next();
                if (se.getNombre().equalsIgnoreCase(nombre)){
                    ret=se;
                }
            }
        }        
        return ret;
    }
    public Segmento creaSegmento (String nombre){
        Segmento ret = buscarSegmento(nombre);
        if (ret==null){
            ret=new Segmento(nombre);
            segs.add(ret);
        }else{
            ret=null; 
        }
        return ret;
    }    
    public Segmento editaSegmento(String nombre){
        Segmento ret = buscarSegmento( nombre);
        this.setNombre(nombre);
        if (ret!=null){
            segs.removeFirstOccurrence(ret);
            ret = this;
            segs.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaSegmento(String nombre){
        Segmento ret = buscarSegmento (nombre);
        if (ret!=null){
            segs.removeFirstOccurrence(ret);
        }
    }
    public LinkedList<Segmento> darSegmento(){
        return segs;
    }
}
