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
    @ManyToOne
    private Turno unTurno;
        //GrupoParte
    @OneToMany
    private List<Autoparte> vsAutoparte;
        //Actividad
    @ManyToMany
    private List<Actividad> vsActividadesRealizadas;
    @ManyToMany
    private List<Actividad> vsActividadesPendientes;

    //SETS
    public void setCodOrden(long codOrden) { this.codOrden = codOrden; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setVsAutoparte(List<Autoparte> vsAutoparte) { this.vsAutoparte = vsAutoparte; }
    public void setUnTurno(Turno unTurno) { this.unTurno = unTurno; }
    public void setBorrado (boolean borrado) {this.borrado = borrado;}
    public void setVsActividadesPendientes(List<Actividad> vsActividadesPendientes) { this.vsActividadesPendientes = vsActividadesPendientes; }
    public void setVsActividadesRealizadas(List<Actividad> vsActividadesRealizadas) { this.vsActividadesRealizadas = vsActividadesRealizadas; }
    
    //GETS
    public long getCodOrden() { return this.codOrden; }
    public String getDescripcion() { return this.descripcion; }
    public Turno getUnTurno() { return unTurno; }
    public List<Autoparte> getVsAutoparte() { return vsAutoparte; }
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
        this.vsAutoparte = new LinkedList<Autoparte>();
        this.vsActividadesRealizadas = new LinkedList<Actividad>();
        this.vsActividadesPendientes = new LinkedList<Actividad>();
    }    
}
