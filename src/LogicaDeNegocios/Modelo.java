package LogicaDeNegocios;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Modelo implements Serializable {
    @Id
    private String nombre;
    @Basic
    private int anio;
    
    //Relaciones
            //Marca
    @OneToOne
    private Marca unaMarca;

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setAnio(int anio) { this.anio = anio; }
    public void setUnaMarca(Marca unaMarca) { this.unaMarca = unaMarca; }
    

    public String getNombre() { return this.nombre; }
    public int getAnio() { return this.anio; }
    public Marca getUnaMarca() { return unaMarca; }
    
    
    public String toString() {
        return "[Nombre: "+this.getNombre()+"] \n[Año: "+this.getAnio()+"]";
    }
    
    public Modelo(){}
    
    public Modelo(Marca mar, String nombre, int anio){
        this.nombre=nombre;
        this.anio=anio;
        this.unaMarca = mar;
    }
       
            //En memoria (sin persistencia)    
    private static List<Modelo> mods = new LinkedList<Modelo>();

    //Metodos en memoria
    public Modelo buscarModelo(String nombre){
        Modelo mo, ret=null;
        if (!mods.isEmpty()) { 
            Iterator<Modelo> it = mods.iterator();
            while(it.hasNext()&& ret==null){
                mo= it.next();
                if (mo.getNombre().equalsIgnoreCase(nombre)){
                    ret=mo;
                }
            }
        }        
        return ret;
    }
    public Modelo creaModelo (Marca mar, String nombre, int anio){
        Modelo ret = buscarModelo(nombre);
        if (ret==null){
            ret=new Modelo(mar, nombre, anio);
            mods.add(ret);
        }else{
            ret=null; 
        }
        return ret;
    }    
    public Modelo editaModelo(Marca mar, String nombre, int anio){
        Modelo ret = buscarModelo( nombre);
        this.setNombre(nombre);
        this.setAnio(anio);
        this.setUnaMarca(mar);
        if (ret!=null){
            mods.remove(ret);
            ret = this;
            mods.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaModelo(String nombre){
        Modelo ret = buscarModelo (nombre);
        if (ret!=null){
            mods.remove(ret);
        }
    }
    public List<Modelo> darModelo(){
        return mods;
    }
}
