package LogicaDeNegocios;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Provincia implements Serializable {
    @Id
    private int codigo;
    @Basic
    private String nombre;
    
    //Relaciones
        //Localidad
    @OneToMany
    private List<Localidad> localidades;
    
    //SETS
    public void setCodigo(int codigo) { this.codigo = codigo; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setLocalidades(List<Localidad> localidades) { this.localidades = localidades; }

    //GETS
    public int getCodigo() { return this.codigo; }
    public String getNombre() { return this.nombre; }
    public List<Localidad> getLocalidades() { return this.localidades; }
    
    public Provincia() { }

    public Provincia(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre; 
        this.localidades = new LinkedList<Localidad>(); }    
    
    
        //En memoria (sin persistencia)    
    private static LinkedList<Provincia> provs = new LinkedList<Provincia>();
    //Metodos en memoria
    public Provincia buscarProvincia(int codigo){
        Provincia pro, ret=null;
        if (!provs.isEmpty()) { 
            Iterator<Provincia> it = provs.iterator();
            while(it.hasNext()&& ret==null){
                pro= it.next();
                if (pro.getCodigo()==codigo){
                    ret=pro;
                }
            }
        }        
        return ret;
    }
    public Provincia creaProvincia(int codigo, String nombre){
        Provincia ret = buscarProvincia( codigo);
        if (ret==null){
            ret=new Provincia(codigo, nombre);
            provs.add(ret);
        }else{
            ret=null; 
        }
        return ret;
    }    
    public Provincia editaProvincia(int codigo, String nombre, LinkedList<Localidad> locs){
        Provincia ret = buscarProvincia( codigo);
        this.setNombre(nombre);
        this.setCodigo(codigo);
        this.setLocalidades(localidades);
        if (ret!=null){
            provs.removeFirstOccurrence(ret);
            ret = this;
            provs.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaProvincia(int codigo){
        Provincia ret = buscarProvincia (codigo);
        if (ret!=null){
            provs.removeFirstOccurrence(ret);
        }
    }
    public LinkedList<Provincia> darProvincias(){
        return provs;
    }
}