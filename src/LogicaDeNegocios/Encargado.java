package LogicaDeNegocios;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Encargado extends Empleado implements Serializable{

    //Relaciones
    /*    //Interno            PROBLEMA TABLAS CON VARIOS PK     ??
    @OneToMany
    private List<Interno> vsInterno;*/
        //Item
    @OneToMany
    private List<Item> vsItem;
        //OrdenTrabajo
    @OneToMany
    private List<OrdenTrabajo> vsOrdenTrabajo;

    //SET
    //public void setVsInterno(List<Interno> vsInterno) { this.vsInterno = vsInterno; }
    public void setVsItem(List<Item> vsItem) { this.vsItem = vsItem; }
    public void setVsOrdenTrabajo(List<OrdenTrabajo> vsOrdenTrabajo) { this.vsOrdenTrabajo = vsOrdenTrabajo; }
    
    //GET
    //public List<Interno> getVsInterno() { return vsInterno; }
    public List<Item> getVsItem() { return vsItem; }
    public List<OrdenTrabajo> getVsOrdenTrabajo() { return vsOrdenTrabajo; }
        
    public Encargado() { }
    
    public Encargado(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, long telefono, int sueldo, 
            String p, Date horaInicio, Date horaFin) {
        super(unaLoc, unaSuc, nombre, dni,  telefono, sueldo, p, horaInicio, horaFin);
        //this.vsInterno = new LinkedList<Interno>();
        this.vsItem = new LinkedList<Item>();
        this.vsOrdenTrabajo = new LinkedList<OrdenTrabajo>();
    }
           
    //En memoria (sin persistencia)        
    //Metodos en memoria
    private static LinkedList<Encargado> encs = new LinkedList<Encargado>();
    
    public Encargado buscarEncargado(long dni){
        Encargado en, ret=null;
        if (!encs.isEmpty()) { 
            Iterator<Encargado> it = encs.iterator();
            while(it.hasNext()&& ret==null){
                en= it.next();
                if (en.getDni()==dni){
                    ret=en;
                }
            }
        }        
        return ret;
    }
    public Encargado creaEncargado(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String pass, Date horaInicio, Date horaFin){
        Encargado ret;
        if (super.buscarDni(dni)<0){
            ret = new Encargado(unaLoc, unaSuc, nombre, dni, telefono, sueldo, pass, horaInicio, horaFin);
            encs.add(ret);
            super.agregaEmpleado(dni);
        }else{
            ret=null; 
        }
        return ret;
    }
    public Encargado editaEncargado(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String pass, Date horaInicio, Date horaFin, LinkedList<Item> it, LinkedList<OrdenTrabajo> or, boolean ok){
        Encargado ret = buscarEncargado(dni);
        this.setNombre(nombre);
        this.setDni(dni);
        this.setTelefono(telefono);
        this.setSueldo(sueldo);
        this.setBorrado(ok);
        this.setHoraInicio(horaInicio);
        this.setHoraFin(horaFin);
        this.setUnaSucursal(unaSuc);
        this.setVsItem(it);
        this.setVsOrdenTrabajo(or);
        this.setUnaLocalidad(unaLoc);
        this.setPass(pass);
        if (ret!=null){
            encs.removeFirstOccurrence(ret);
            ret = this;
            encs.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaEncargado(long dni){
        Encargado ret = buscarEncargado (dni);
        if (ret!=null){
            super.eliminaEmpleado(dni);
            encs.removeFirstOccurrence(ret);
        }
    }
    public LinkedList<Encargado> darEncargado(){
        return encs;
    }   
}
