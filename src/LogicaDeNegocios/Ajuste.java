package LogicaDeNegocios;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class Ajuste extends OrdenTrabajo implements Serializable{
        
    public Ajuste(){}
    
    public Ajuste(Turno unTur, long codOrden, String descripcion){
        super(unTur, codOrden, descripcion);
    }
    
        //En memoria (sin persistencia)        
    //Metodos en memoria
    private static List<Ajuste> ajustes = new LinkedList<Ajuste>();
    
    public Ajuste buscarAjuste(long codOrden){
        Ajuste aj, ret=null;
        if (!ajustes.isEmpty()) { 
            Iterator<Ajuste> it = ajustes.iterator();
            while(it.hasNext()&& ret==null){
                aj= it.next();
                if (aj.getCodOrden()==codOrden){
                    ret=aj;
                }
            }
        }        
        return ret;
    }
    public Ajuste creaAjuste(Turno unTur, long codOrden, String descripcion){
        Ajuste ret;
        if (super.buscarOrdenTrabajo(codOrden)<0){
            ret = new Ajuste(unTur, codOrden, descripcion);
            ajustes.add(ret);
            super.agregaOrdenTrabajo(codOrden);
        }else{
            ret=null; 
        }
        return ret;
    }
    public Ajuste editaAjuste(Turno unTur, long codOrden, String descripcion, List<OrdenTrabajo> or, List<Actividad> acr,
            List<Actividad> acp, boolean ok){
        Ajuste ret = buscarAjuste(codOrden);
        this.setBorrado(ok);
        this.setCodOrden(codOrden);
        this.setDescripcion(descripcion);
        this.setUnTurno(unTur);
        this.setVsOrdenTrabajo(or);
        this.setVsActividadesRealizadas(acr);
        this.setVsActividadesPendientes(acp);
        if (ret!=null){
            ajustes.remove(ret);
            ret = this;
            ajustes.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaAjuste(long codOrden){
        Ajuste ret = buscarAjuste (codOrden);
        if (ret!=null){
            super.eliminaOrdenTrabajo(codOrden);
            ajustes.remove(ret);
        }
    }
    public List<Ajuste> darAjustes(){
        return ajustes;
    }
}
