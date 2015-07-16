package LogicaDeNegocios;

import java.io.Serializable;
import java.util.Date;
import java.util.*;
import javax.persistence.*;

@Entity
public class Mecanico extends Empleado implements Serializable{

    //Relaciones
        //Turno
    @OneToMany
    private List<Turno> vsTurno;
        //Especialidad
    @ManyToOne
    private Especialidad unaEspecialidad;
        //Interno
    @OneToMany
    private List<Interno> vsInterno;
        //OrdenTrabajo
    @OneToMany
    private List<OrdenTrabajo> vsOrdenTrabajo;
    
    //SETS    
    public void setVsTurno(List<Turno> vsTurno) { this.vsTurno = vsTurno; }
    public void setVsInterno(List<Interno> vsInterno) { this.vsInterno = vsInterno; }
    public void setUnaEspecialidad(Especialidad unaEspecialidad) { this.unaEspecialidad = unaEspecialidad; }
    public void setVsOrdenTrabajo(List<OrdenTrabajo> vsOrdenTrabajo) { this.vsOrdenTrabajo = vsOrdenTrabajo; }
    
    //GETS
    public List<Turno> getVsTurno() { return vsTurno; }
    public List<Interno> getVsInterno() { return vsInterno; }
    public Especialidad getUnaEspecialidad() { return unaEspecialidad; }
    public List<OrdenTrabajo> getVsOrdenTrabajo() { return vsOrdenTrabajo; }
    
    public Mecanico() { }
    
    public Mecanico(Localidad unaLoc,Sucursal unaSuc, String nombre, long dni, long telefono, int sueldo, 
            String p, Date horaInicio, Date horaFin, Especialidad profesion) {
        super(unaLoc, unaSuc, nombre, dni, telefono, sueldo, p, horaInicio, horaFin);
        this.vsTurno = new LinkedList<Turno>();
        this.vsInterno = new LinkedList<Interno>();
        this.unaEspecialidad = profesion;
        this.vsOrdenTrabajo = new LinkedList<OrdenTrabajo>();
    }
    
    
    
    //En memoria (sin persistencia)        
    //Metodos en memoria
    private static LinkedList<Mecanico> mecs = new LinkedList<Mecanico>();
    
    public Mecanico buscarMecanico(long dni){
        Mecanico me, ret=null;
        if (!mecs.isEmpty()) { 
            Iterator<Mecanico> it = mecs.iterator();
            while(it.hasNext()&& ret==null){
                me= it.next();
                if (me.getDni()==dni){
                    ret=me;
                }
            }
        }        
        return ret;
    }
    public Mecanico creaMecanico(Localidad unaLoc,Sucursal unaSuc, String nombre, long dni, long telefono, int sueldo, 
            String pass, Date horaInicio, Date horaFin, Especialidad profesion){
        Mecanico ret;
        if (super.buscarDni(dni)<0){
            ret = new Mecanico(unaLoc, unaSuc, nombre, dni, telefono, sueldo, pass, horaInicio, horaFin, profesion);
            mecs.add(ret);
            super.agregaEmpleado(dni);
        }else{
            ret=null; 
        }
        return ret;
    }
    public Mecanico editaMecanico(Localidad unaLoc,Sucursal unaSuc, String nombre, long dni, long telefono, int sueldo, 
            String pass, Date horaInicio, Date horaFin, Especialidad profesion, LinkedList<Interno> in, LinkedList<OrdenTrabajo> or,
            boolean ok,LinkedList<Turno> tu){
        Mecanico ret = buscarMecanico(dni);
        this.setNombre(nombre);
        this.setDni(dni);
        this.setTelefono(telefono);
        this.setSueldo(sueldo);
        this.setBorrado(ok);
        this.setHoraInicio(horaInicio);
        this.setHoraFin(horaFin);
        this.setUnaSucursal(unaSuc);
        this.setVsInterno(in);
        this.setVsTurno(tu);
        this.setVsOrdenTrabajo(or);
        this.setUnaEspecialidad(profesion);
        this.setUnaLocalidad(unaLoc);
        this.setPass(pass);
        if (ret!=null){
            mecs.removeFirstOccurrence(ret);
            ret = this;
            mecs.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaMecanico(long dni){
        Mecanico ret = buscarMecanico (dni);
        if (ret!=null){
            super.eliminaEmpleado(dni);
            mecs.removeFirstOccurrence(ret);
        }
    }
    public LinkedList<Mecanico> darMecanico(){
        return mecs;
    }
}