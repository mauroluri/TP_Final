package LogicaDeNegocios;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class AtencionPublico extends Empleado implements Serializable{

    //Relaciones
            //Externo
    @OneToMany
    private List<Externo> vsExterno;

    public void setVsExterno(List<Externo> vsExterno) { this.vsExterno = vsExterno; }

    public List<Externo> getVsExterno() { return vsExterno; }
        
    public AtencionPublico() { }
    
    public AtencionPublico(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String p, Date horaInicio, Date horaFin) {
        super(unaLoc, unaSuc, nombre, dni,  telefono, sueldo, p, horaInicio, horaFin);
        this.vsExterno = new LinkedList<Externo>();
    }
          
    
    //En memoria (sin persistencia)        
    //Metodos en memoria
    private static List<AtencionPublico> atps = new LinkedList<AtencionPublico>();
    
    public AtencionPublico buscarAtencionPublico(long dni){
        AtencionPublico at, ret=null;
        if (!atps.isEmpty()) { 
            Iterator<AtencionPublico> it = atps.iterator();
            while(it.hasNext()&& ret==null){
                at= it.next();
                if (at.getDni()==dni){
                    ret=at;
                }
            }
        }        
        return ret;
    }
    public AtencionPublico creaAtencionPublico(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String pass, Date horaInicio, Date horaFin){
        AtencionPublico ret;
        if (super.buscarDni(dni)<0){
            ret = new AtencionPublico(unaLoc, unaSuc, nombre, dni, telefono, sueldo, pass, horaInicio, horaFin);
            atps.add(ret);
            super.agregaEmpleado(dni);
        }else{
            ret=null; 
        }
        return ret;
    }
    public AtencionPublico editaAtencionPublico(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, long telefono, 
            int sueldo, String pass, Date horaInicio, Date horaFin, List<Externo> ex, boolean ok){
        AtencionPublico ret = buscarAtencionPublico(dni);
        this.setNombre(nombre);
        this.setDni(dni);
        this.setTelefono(telefono);
        this.setSueldo(sueldo);
        this.setBorrado(ok);
        this.setHoraInicio(horaInicio);
        this.setHoraFin(horaFin);
        this.setUnaSucursal(unaSuc);
        this.setVsExterno(ex);
        this.setUnaLocalidad(unaLoc);
        this.setPass(pass);
        if (ret!=null){
            atps.remove(ret);
            ret = this;
            atps.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaAtencionPublico(long dni){
        AtencionPublico ret = buscarAtencionPublico (dni);
        if (ret!=null){
            super.eliminaEmpleado(dni);
            atps.remove(ret);
        }
    }
    public List<AtencionPublico> darAtencionPublico(){
        return atps;
    }
}
