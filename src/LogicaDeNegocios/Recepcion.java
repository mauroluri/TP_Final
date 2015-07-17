package LogicaDeNegocios;

import java.util.Date;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Recepcion extends Sector implements Serializable {

    //Relaciones
        //Turno
    @OneToMany
    private List<Turno> vsTurno;

    //SET
    public void setVsTurno(List<Turno> vsTurno) { this.vsTurno = vsTurno; }

    //GET
    public List<Turno> getVsTurno() { return vsTurno; }
    
    public Recepcion() { }

    public Recepcion(int cod, Date horaInicio, Date horaFin) { 
        super(cod, horaInicio, horaFin);
        this.vsTurno = new LinkedList<Turno>();
    }
    
        //En memoria (sin persistencia)        
    //Metodos en memoria
    private static List<Recepcion> deps = new LinkedList<Recepcion>();
    
    public Recepcion buscarRecepcion(int cod){
        Recepcion de, ret=null;
        if (!deps.isEmpty()) { 
            Iterator<Recepcion> it = deps.iterator();
            while(it.hasNext()&& ret==null){
                de= it.next();
                if (de.getCod()==cod){
                    ret=de;
                }
            }
        }        
        return ret;
    }
    public Recepcion creaRecepcion(int cod, Date horaInicio, Date horaFin){
        Recepcion ret;
        if (super.buscarCod(cod)<0){
            ret = new Recepcion(cod, horaInicio, horaFin);
            deps.add(ret);
            super.agregaSector(cod);
        }else{
            ret=null; 
        }
        return ret;
    }
    public Recepcion editaRecepcion(int cod, Date horaInicio, Date horaFin, List<Empleado> emps,
            List<Turno> turs ){
        Recepcion ret = buscarRecepcion(cod);
        this.setCod(cod);
        this.setHoraFin(horaFin);
        this.setHoraInicio(horaInicio);
        this.setVsEmpleado(emps);
        this.setVsTurno(turs);
        if (ret!=null){
            deps.remove(ret);
            ret = this;
            deps.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaRecepcion(int cod){
        Recepcion ret = buscarRecepcion (cod);
        if (ret!=null){
            super.eliminaSector(cod);
            deps.remove(ret);
        }
    }
    public List<Recepcion> darRecepcion(){
        return deps;
    }
}
