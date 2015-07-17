package LogicaDeNegocios;

import java.util.Date;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import javax.persistence.*;

@Entity
public class Deposito extends Sector implements Serializable {
    
    //relaciones
        //Item
    @OneToMany
    private List<Item> vsItem;

    //GET
    public List<Item> getVsItem() { return vsItem; }

    //SET
    public void setVsItem(List<Item> vsItem) { this.vsItem = vsItem; }
    
    public Deposito() { }

    public Deposito(int cod, Date horaInicio, Date horaFin) { 
        super(cod, horaInicio, horaFin);
        this.vsItem = new LinkedList<Item>();}
    
        //En memoria (sin persistencia)        
    //Metodos en memoria
    private static List<Deposito> deps = new LinkedList<Deposito>();
    
    public Deposito buscarDeposito(int cod){
        Deposito de, ret=null;
        if (!deps.isEmpty()) { 
            Iterator<Deposito> it = deps.iterator();
            while(it.hasNext()&& ret==null){
                de= it.next();
                if (de.getCod()==cod){
                    ret=de;
                }
            }
        }        
        return ret;
    }
    public Deposito creaDeposito(int cod, Date horaInicio, Date horaFin){
        Deposito ret;
        if (super.buscarCod(cod)<0){
            ret = new Deposito(cod, horaInicio, horaFin);
            deps.add(ret);
            super.agregaSector(cod);
        }else{
            ret=null; 
        }
        return ret;
    }
    public Deposito editaDeposito(int cod, Date horaInicio, Date horaFin, List<Empleado> emps, List<Item> its ){
        Deposito ret = buscarDeposito(cod);
        this.setCod(cod);
        this.setHoraFin(horaFin);
        this.setHoraInicio(horaInicio);
        this.setVsEmpleado(emps);
        this.setVsItem(its);
        if (ret!=null){
            deps.remove(ret);
            ret = this;
            deps.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaDeposito(int cod){
        Deposito ret = buscarDeposito (cod);
        if (ret!=null){
            super.eliminaSector(cod);
            deps.remove(ret);
        }
    }
    public List<Deposito> darDeposito(){
        return deps;
    }    
}
