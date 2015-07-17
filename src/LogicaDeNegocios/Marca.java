package LogicaDeNegocios;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Marca implements Serializable {
    @Id
    private String nombre;

    //SETS
    public void setNombre(String nombre) { this.nombre = nombre; }

    //GETS
    public String getNombre() { return this.nombre; }
    
    public String toString() { return "[Nombre: "+this.getNombre()+"]"; }
    
    public Marca(){}
    
    public Marca(String nombre){
        this.nombre=nombre;
    }
    
       
            //En memoria (sin persistencia)    
    private static List<Marca> marcas = new LinkedList<Marca>();

    //Metodos en memoria
    public Marca buscarMarca(String nombre){
        Marca ma, ret=null;
        if (!marcas.isEmpty()) { 
            Iterator<Marca> it = marcas.iterator();
            while(it.hasNext()&& ret==null){
                ma= it.next();
                if (ma.getNombre().equalsIgnoreCase(nombre)){
                    ret=ma;
                }
            }
        }        
        return ret;
    }
    public Marca creaMarca (String nombre){
        Marca ret = buscarMarca(nombre);
        if (ret==null){
            ret=new Marca(nombre);
            marcas.add(ret);
        }else{
            ret=null; 
        }
        return ret;
    }    
    public Marca editaMarca(String nombre){
        Marca ret = buscarMarca( nombre);
        this.setNombre(nombre);
        if (ret!=null){
            marcas.remove(ret);
            ret = this;
            marcas.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaMarca(String nombre){
        Marca ret = buscarMarca (nombre);
        if (ret!=null){
            marcas.remove(ret);
        }
    }
    public List<Marca> darMarca(){
        return marcas;
    }
}