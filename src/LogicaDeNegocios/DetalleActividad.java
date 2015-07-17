package LogicaDeNegocios;

import java.io.Serializable;
import javax.persistence.Temporal;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class DetalleActividad implements Serializable {
    @Id
    private String cod;
    @Basic
    private String descripcion;
    @Basic
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date duracion;

    //SETS
    public void setCod(String cod) { this.cod = cod; }
    public void setDuracion(Date duracion) { this.duracion = duracion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    //GETS
    public String getCod() { return this.cod; }
    public Date getDuracion() { return this.duracion; }
    public String getDescripcion() { return this.descripcion; }
        
    public String toString() { return "[Cod: "+this.getCod()+"] \n[Descripción: "+this.getDescripcion()+
            " \n[Duración: "+this.getDuracion()+"]"; }

    public DetalleActividad() { }

    public DetalleActividad(String cod, String descripcion, Date duracion) {
        this.cod = cod;
        this.duracion = duracion;
        this.descripcion = descripcion;
    }
               //En memoria (sin persistencia)    
    private static List<DetalleActividad> detalles = new LinkedList<DetalleActividad>();

    //Metodos en memoria
    public DetalleActividad buscarDetalleActividad(String cod){
        DetalleActividad dact, ret=null;
        if (!detalles.isEmpty()) { 
            Iterator<DetalleActividad> it = detalles.iterator();
            while(it.hasNext()&& ret==null){
                dact= it.next();
                if (dact.getCod().equalsIgnoreCase(cod)){
                    ret=dact;
                }
            }
        }        
        return ret;
    }
    public DetalleActividad creaDetalleActividad (String cod, String descripcion, Date duracion){
        DetalleActividad ret = buscarDetalleActividad(cod);
        if (ret==null){
            ret=new DetalleActividad(cod, descripcion, duracion);
            detalles.add(ret);
        }else{
            ret=null; 
        }
        return ret;
    }    
    public DetalleActividad editaDetalleActividad(String cod, String descripcion, Date duracion){
        DetalleActividad ret = buscarDetalleActividad( cod);
        this.setCod(cod);
        this.setDescripcion(descripcion);
        this.setDuracion(duracion);
        if (ret!=null){
            detalles.remove(ret);
            ret = this;
            detalles.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaDetalleActividad(String cod){
        DetalleActividad ret = buscarDetalleActividad (cod);
        if (ret!=null){
            detalles.remove(ret);
        }
    }
    public List<DetalleActividad> darDetalleActividad(){
        return detalles;
    }
}
