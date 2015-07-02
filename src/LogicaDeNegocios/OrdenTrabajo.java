package LogicaDeNegocios;

import java.io.Serializable;
import java.util.Iterator;
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
        creaOrdenTrabajo(unTur, codOrden, descripcion);
    }  
    
            //En memoria (sin persistencia)    
    private static LinkedList<OrdenTrabajo> ordenes = new LinkedList<OrdenTrabajo>();
//    private void setClientes(Cliente cli){
//        clientes.add(cli);
//    }
//    private LinkedList<Cliente> getClientes(){
//        return clientes;
//    }
    //Metodos en memoria
    public OrdenTrabajo buscarOrdenTrabajo(long codOrden){
        OrdenTrabajo ord, ret=null;
        if (!ordenes.isEmpty()) { 
            Iterator<OrdenTrabajo> it = ordenes.iterator();
            while(it.hasNext()&& ret==null){
                ord= it.next();
                if (ord.getCodOrden()==codOrden){
                    ret=ord;
                }
            }
        }        
        return ret;
    }
    public OrdenTrabajo creaOrdenTrabajo(Turno unTur, long codOrden, String descripcion){
        OrdenTrabajo ret = buscarOrdenTrabajo( codOrden);
        if (ret==null){
            this.codOrden = codOrden;
            this.descripcion = descripcion;
            this.borrado = false;
            this.unTurno = unTur;
            this.vsAutoparte = new LinkedList<Autoparte>();
            this.vsActividadesRealizadas = new LinkedList<Actividad>();
            this.vsActividadesPendientes = new LinkedList<Actividad>();
            ret=this;
            ordenes.add(ret);
        }else{
            ret=null; 
        }
        return ret;
    }    
    public OrdenTrabajo editaOrdenTrabajo(Turno unTur, long codOrden, String descripcion, LinkedList<Autoparte> ap, 
            LinkedList<Actividad> acr, LinkedList<Actividad> acp, boolean ok){
        OrdenTrabajo ret = buscarOrdenTrabajo( codOrden);
        this.setCodOrden(codOrden);
        this.setUnTurno(unTur);
        this.setDescripcion(descripcion);
        this.setVsAutoparte(ap);
        this.setVsActividadesRealizadas(acr);
        this.setVsActividadesPendientes(acp);
        this.setBorrado(ok);
        if (ret!=null){
            ordenes.removeFirstOccurrence(ret);
            ret = this;
            ordenes.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaOrdenTrabajo(long codOrden){
        OrdenTrabajo ret = buscarOrdenTrabajo (codOrden);
        if (ret!=null){
            ordenes.removeFirstOccurrence(ret);
        }
    }
    public LinkedList<OrdenTrabajo> darOrdenTrabajo(){
        return ordenes;
    }
}
