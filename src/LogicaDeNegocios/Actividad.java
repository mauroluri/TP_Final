package LogicaDeNegocios;

import java.io.Serializable;
import javax.persistence.Temporal;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Actividad implements Serializable {
    @Id
    private String nombre;
    @Basic
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date duracionTotal;
    
    //Relaciones
        //Actividad
    @OneToMany
    private List<DetalleActividad> vsEspDetActividad;
        //Categoria
    @ManyToOne
    private Categoria unaCategoria;
        //GrupoParte
    @ManyToOne
    private GrupoParte unGrupoParte;

    //SETS
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDuracionTotal(Date duracionTotal) { this.duracionTotal = duracionTotal; }
    public void setVsEspDetActividad(List<DetalleActividad> vsEspDetActividad) { this.vsEspDetActividad = vsEspDetActividad; }
    public void setUnGrupoParte(GrupoParte unGrupoParte) { this.unGrupoParte = unGrupoParte; }
    public void setUnaCategoria(Categoria unaCategoria) { this.unaCategoria = unaCategoria; }
    
    //GETS
    public String getNombre() { return this.nombre; }
    public Date getDuracionTotal() { return this.duracionTotal; }
    public List<DetalleActividad> getVsEspDetActividad() { return vsEspDetActividad; }
    public GrupoParte getUnGrupoParte() { return unGrupoParte; }
    public Categoria getUnaCategoria() { return unaCategoria; }
        
    public String toString() {
        return "[Codigo: "+this.getNombre()+"] \n"
                + "[Duración total: "+this.getDuracionTotal()+"]";
    }
    
    //CONSTRUCTORES
    public Actividad() { }
    public Actividad(String nombre, Categoria categ, Date duracionTotal, GrupoParte grupo,List<DetalleActividad> ac) {
        this.nombre = nombre;
        this.duracionTotal = duracionTotal;
        this.unGrupoParte = grupo;
        this.unaCategoria = categ;
        this.vsEspDetActividad = ac;    
    }
    
            //En memoria (sin persistencia)    
    private static LinkedList<Actividad> actividades = new LinkedList<Actividad>();

    //Metodos en memoria
    public Actividad buscarActividad(String nombre){
        Actividad act, ret=null;
        if (!actividades.isEmpty()) { 
            Iterator<Actividad> it = actividades.iterator();
            while(it.hasNext()&& ret==null){
                act= it.next();
                if (act.getNombre().equalsIgnoreCase(nombre)){
                    ret=act;
                }
            }
        }        
        return ret;
    }
    public Actividad creaActividad (String nombre, Categoria categ, Date duracionTotal, GrupoParte grupo,List<DetalleActividad> ac){
        Actividad ret = buscarActividad(nombre);
        if (ret==null){
            ret=new Actividad(nombre, categ, duracionTotal, grupo, ac);
            actividades.add(ret);
        }else{
            ret=null; 
        }
        return ret;
    }    
    public Actividad editaActividad(String nombre, Categoria categ, Date duracionTotal, GrupoParte grupo,List<DetalleActividad> ac){
        Actividad ret = buscarActividad( nombre);
        this.setNombre(nombre);
        this.setUnaCategoria(categ);
        this.setDuracionTotal(duracionTotal);
        this.setUnGrupoParte(grupo);
        this.setVsEspDetActividad(ac);
        if (ret!=null){
            actividades.removeFirstOccurrence(ret);
            ret = this;
            actividades.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaActividad(String nombre){
        Actividad ret = buscarActividad (nombre);
        if (ret!=null){
            actividades.removeFirstOccurrence(ret);
        }
    }
    public LinkedList<Actividad> darActividad(){
        return actividades;
    }
}
