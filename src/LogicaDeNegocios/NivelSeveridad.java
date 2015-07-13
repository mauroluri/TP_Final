package LogicaDeNegocios;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import javax.persistence.*;

@Entity
public class NivelSeveridad implements Serializable{
    @Id
    private int nivel;
    @Basic
    private String nombre;

    //SETS
    public void setNivel(int nivel) { this.nivel = nivel; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    //GETS
    public int getNivel() { return this.nivel; }
    public String getNombre() { return nombre; }
    
    public String toString() { return "[Nivel: "+this.getNivel()+"] \n[Nombre: "+this.getNombre()+"]"; }
    
    public NivelSeveridad(){}
    
    public NivelSeveridad(int nivel, String nombre){ 
        this.nivel=nivel; 
        this.nombre=nombre; 
    }
    
        //En memoria (sin persistencia)    
    private static LinkedList<NivelSeveridad> clientes = new LinkedList<NivelSeveridad>();
    //Metodos en memoria
    public NivelSeveridad buscarNivelSeveridad(int nivel){
        NivelSeveridad cli, ret=null;
        if (!clientes.isEmpty()) { 
            Iterator<NivelSeveridad> it = clientes.iterator();
            while(it.hasNext()&& ret==null){
                cli= it.next();
                if (cli.getNivel()==nivel){
                    ret=cli;
                }
            }
        }        
        return ret;
    }
    public NivelSeveridad creaNivelSeveridad(int nivel, String nombre){
        NivelSeveridad ret = buscarNivelSeveridad( nivel);
        if (ret==null){
            ret=new NivelSeveridad(nivel, nombre);
            clientes.add(ret);
        }else{
            ret=null; 
        }
        return ret;
    }    
    public NivelSeveridad editaNivelSeveridad(int nivel, String nombre){
        NivelSeveridad ret = buscarNivelSeveridad( nivel);
        this.setNombre(nombre);
        this.setNivel(nivel);
        if (ret!=null){
            clientes.removeFirstOccurrence(ret);
            ret = this;
            clientes.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaNivelSeveridad(int nivel){
        NivelSeveridad ret = buscarNivelSeveridad (nivel);
        if (ret!=null){
            clientes.removeFirstOccurrence(ret);
        }
    }
    public LinkedList<NivelSeveridad> darNivelSeveridads(){
        return clientes;
    }
}