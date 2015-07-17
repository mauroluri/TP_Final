package LogicaDeNegocios;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Perito extends Empleado implements Serializable{

    //Relaciones
        //Garantia
    @OneToMany
    private List<Garantia> vsGarantia;

    //SET
    public void setVsGarantia(List<Garantia> vsGarantia) { this.vsGarantia = vsGarantia; }

    //GET
    public List<Garantia> getVsGarantia() { return vsGarantia; }
    
    public Perito() { }
    
    public Perito(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, long telefono, int sueldo, 
            String p, Date horaInicio, Date horaFin) {
        super(unaLoc, unaSuc, nombre, dni, telefono, sueldo, p, horaInicio, horaFin);
        this.vsGarantia = new LinkedList<Garantia>();
    }
    
         
   
    //En memoria (sin persistencia)        
    //Metodos en memoria
    private static List<Perito> pers = new LinkedList<Perito>();
    
    public Perito buscarPerito(long dni){
        Perito pe, ret=null;
        if (!pers.isEmpty()) { 
            Iterator<Perito> it = pers.iterator();
            while(it.hasNext()&& ret==null){
                pe= it.next();
                if (pe.getDni()==dni){
                    ret=pe;
                }
            }
        }        
        return ret;
    }
    public Perito creaPerito(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String pass, Date horaInicio, Date horaFin){
        Perito ret;
        if (super.buscarDni(dni)<0){
            ret = new Perito(unaLoc, unaSuc, nombre, dni, telefono, sueldo, pass, horaInicio, horaFin);
            pers.add(ret);
            super.agregaEmpleado(dni);
        }else{
            ret=null; 
        }
        return ret;
    }
    public Perito editaPerito(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String pass, Date horaInicio, Date horaFin, List<Garantia> ga, boolean ok){
        Perito ret = buscarPerito(dni);
        this.setNombre(nombre);
        this.setDni(dni);
        this.setTelefono(telefono);
        this.setSueldo(sueldo);
        this.setBorrado(ok);
        this.setHoraInicio(horaInicio);
        this.setHoraFin(horaFin);
        this.setUnaSucursal(unaSuc);
        this.setVsGarantia(ga);
        this.setUnaLocalidad(unaLoc);
        this.setPass(pass);
        if (ret!=null){
            pers.remove(ret);
            ret = this;
            pers.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaPerito(long dni){
        Perito ret = buscarPerito (dni);
        if (ret!=null){
            super.eliminaEmpleado(dni);
            pers.remove(ret);
        }
    }
    public List<Perito> darPerito(){
        return pers;
    }
}
