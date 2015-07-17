package LogicaDeNegocios;

import java.util.Date;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Taller extends Sector implements Serializable{

    //Relaciones
        //OrdenTrabajo
    @OneToMany
    private List<OrdenTrabajo> vsOrdenTrabajo;

    public void setVsOrdenTrabajo(List<OrdenTrabajo> vsOrdenTrabajo) { this.vsOrdenTrabajo = vsOrdenTrabajo; }

    public List<OrdenTrabajo> getVsOrdenTrabajo() { return vsOrdenTrabajo; }
    
    public Taller() { }
    
    public Taller(int cod, Date horaInicio, Date horaFin) { 
        super(cod, horaInicio, horaFin);
        this.vsOrdenTrabajo = new LinkedList<OrdenTrabajo>();
    }
    
        //En memoria (sin persistencia)        
    //Metodos en memoria
    private static List<Taller> deps = new LinkedList<Taller>();
    
    public Taller buscarTaller(int cod){
        Taller de, ret=null;
        if (!deps.isEmpty()) { 
            Iterator<Taller> it = deps.iterator();
            while(it.hasNext()&& ret==null){
                de= it.next();
                if (de.getCod()==cod){
                    ret=de;
                }
            }
        }        
        return ret;
    }
    public Taller creaTaller(int cod, Date horaInicio, Date horaFin){
        Taller ret;
        if (super.buscarCod(cod)<0){
            ret = new Taller(cod, horaInicio, horaFin);
            deps.add(ret);
            super.agregaSector(cod);
        }else{
            ret=null; 
        }
        return ret;
    }
    public Taller editaTaller(int cod, Date horaInicio, Date horaFin, List<Empleado> emps, List<OrdenTrabajo> ords ){
        Taller ret = buscarTaller(cod);
        this.setCod(cod);
        this.setHoraFin(horaFin);
        this.setHoraInicio(horaInicio);
        this.setVsEmpleado(emps);
        this.setVsOrdenTrabajo(ords);
        if (ret!=null){
            deps.remove(ret);
            ret = this;
            deps.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaTaller(int cod){
        Taller ret = buscarTaller (cod);
        if (ret!=null){
            super.eliminaSector(cod);
            deps.remove(ret);
        }
    }
    public List<Taller> darTaller(){
        return deps;
    }
    
}
