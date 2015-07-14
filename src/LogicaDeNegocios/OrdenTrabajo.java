package LogicaDeNegocios;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public abstract class OrdenTrabajo implements Serializable{
    @Id
    private long codOrden;
    @Basic
    private String descripcion;
    @Basic
    private boolean borrado;
    
    //Relaciones
        //Turno
    @OneToOne
    private Turno unTurno;
        //GrupoParte
    @OneToMany
    private List<OrdenTrabajo> vsOrdenTrabajo;
        //Actividad
    @ManyToMany
    private List<Actividad> vsActividadesRealizadas;
    @ManyToMany
    private List<Actividad> vsActividadesPendientes;

    //SETS
    public void setCodOrden(long codOrden) { this.codOrden = codOrden; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setVsOrdenTrabajo(List<OrdenTrabajo> vsOrdenTrabajo) { this.vsOrdenTrabajo = vsOrdenTrabajo; }
    public void setUnTurno(Turno unTurno) { this.unTurno = unTurno; }
    public void setBorrado (boolean borrado) {this.borrado = borrado;}
    public void setVsActividadesPendientes(List<Actividad> vsActividadesPendientes) { this.vsActividadesPendientes = vsActividadesPendientes; }
    public void setVsActividadesRealizadas(List<Actividad> vsActividadesRealizadas) { this.vsActividadesRealizadas = vsActividadesRealizadas; }
    
    //GETS
    public long getCodOrden() { return this.codOrden; }
    public String getDescripcion() { return this.descripcion; }
    public Turno getUnTurno() { return unTurno; }
    public List<OrdenTrabajo> getVsOrdenTrabajo() { return vsOrdenTrabajo; }
    public boolean getBorrado() {return this.borrado;}
    public List<Actividad> getVsActividadesPendientes() { return vsActividadesPendientes; }
    public List<Actividad> getVsActividadesRealizadas() { return vsActividadesRealizadas; }
    
    public String toString() {
        return "[Código: "+this.getCodOrden()+"] \n[Descripción: "+this.getDescripcion()+"]";
    }

    public OrdenTrabajo() { }

    public OrdenTrabajo(Turno unTur, long codOrden, String descripcion) {
        this.codOrden = codOrden;
        this.descripcion = descripcion;
        this.borrado = false;
        this.unTurno = unTur;
        this.vsOrdenTrabajo = new LinkedList<OrdenTrabajo>();
        this.vsActividadesRealizadas = new LinkedList<Actividad>();
        this.vsActividadesPendientes = new LinkedList<Actividad>();
    }  
    
       //En memoria (sin persistencia)    
    private static long[] ordenes;
    //Metodos en memoria
    public int buscarOrdenTrabajo(long codOrden){
        int res=-1;
        if (ordenes.length>0) {
            for (int i=0;i<ordenes.length;i++){
                if (ordenes[i]==codOrden){
                    res=i;
                }
            }
        }        
        return res;
    }
    public void agregaOrdenTrabajo(long codOrden){
        ordenes[ordenes.length]=codOrden;
    }
    public void eliminaOrdenTrabajo(long codOrden){
        for (int i=0;i<ordenes.length;i++){
            if (ordenes[i]==codOrden){
                ordenes[i]=ordenes[i+1];
            }
        } 
    }
    public long[] darOrdenTrabajos(){
        return ordenes;
    }
}
