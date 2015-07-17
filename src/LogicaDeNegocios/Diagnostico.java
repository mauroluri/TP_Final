package LogicaDeNegocios;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Diagnostico extends OrdenTrabajo implements Serializable{
    @Basic
    private int kilometraje;
    @Basic
    private boolean inicial;
    

    //SETS
    public void setKilometraje(int kilometraje) { this.kilometraje = kilometraje; }
    public void setInicial(boolean inicial) { this.inicial = inicial; }
    
    //GETS
    public int getKilometraje() { return this.kilometraje; }
    public boolean getInicial() { return inicial; }
    
    public String toString() { return "[Kilometraje: "+this.getKilometraje()+"]"; }
    
    public Diagnostico(){}
    
    public Diagnostico( Turno unTur, long codOrden, String descripcion, int kilometraje, boolean inicial){
        super(unTur, codOrden, descripcion);
        this.kilometraje=kilometraje;
        this.inicial = inicial;
    }
       //En memoria (sin persistencia)        
    //Metodos en memoria
    private static List<Diagnostico> diags = new LinkedList<Diagnostico>();
    
    public Diagnostico buscarDiagnostico(long codOrden){
        Diagnostico di, ret=null;
        if (!diags.isEmpty()) { 
            Iterator<Diagnostico> it = diags.iterator();
            while(it.hasNext()&& ret==null){
                di= it.next();
                if (di.getCodOrden()==codOrden){
                    ret=di;
                }
            }
        }        
        return ret;
    }
    public Diagnostico creaDiagnostico(Turno unTur, long codOrden, String descripcion, int kilometraje, boolean inicial){
        Diagnostico ret;
        if (super.buscarOrdenTrabajo(codOrden)<0){
            ret = new Diagnostico(unTur, codOrden, descripcion, kilometraje, inicial);
            diags.add(ret);
            super.agregaOrdenTrabajo(codOrden);
        }else{
            ret=null; 
        }
        return ret;
    }
    public Diagnostico editaDiagnostico(Turno unTur, long codOrden, String descripcion, List<OrdenTrabajo> or, List<Actividad> acr,
            List<Actividad> acp, boolean ok, int kilometraje, boolean inicial){
        Diagnostico ret = buscarDiagnostico(codOrden);
        this.setBorrado(ok);
        this.setKilometraje(kilometraje);
        this.setInicial(inicial);
        this.setCodOrden(codOrden);
        this.setDescripcion(descripcion);
        this.setUnTurno(unTur);
        this.setVsOrdenTrabajo(or);
        this.setVsActividadesRealizadas(acr);
        this.setVsActividadesPendientes(acp);
        if (ret!=null){
            diags.remove(ret);
            ret = this;
            diags.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaDiagnostico(long codOrden){
        Diagnostico ret = buscarDiagnostico (codOrden);
        if (ret!=null){
            super.eliminaOrdenTrabajo(codOrden);
            diags.remove(ret);
        }
    }
    public List<Diagnostico> darDiagnostico(){
        return diags;
    }
}
