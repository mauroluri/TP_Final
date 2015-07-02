package LogicaDeNegocios;

import java.io.Serializable;
import java.util.Date;
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
//           
//    //En memoria (sin persistencia)        
//    public AtencionPublico editaAtencionPublico(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, long telefono, int sueldo, 
//            String contra, Date horaInicio, Date horaFin, LinkedList<Turno> tu, boolean ok, List<Externo> vsExterno){
//        Empleado e= super.editaEmpleado(unaLoc, unaSuc, nombre, dni, telefono, sueldo, contra, horaInicio, horaFin, tu, ok);
//        if (e!=null && e instanceof AtencionPublico){
//            this.setVsExterno(vsExterno);
//            return this;
//        }else{
//            return null;
//        }
//        Empleado ret = buscarEmpleado( dni);
//        this.setNombre(nombre);
//        this.setDni(dni);
//        this.setTelefono(telefono);
//        this.setSueldo(sueldo);
//        this.setBorrado(ok);
//        this.setHoraInicio(horaInicio);
//        this.setHoraFin(horaFin);
//        this.setUnaSucursal(unaSuc);
//        this.setVsTurno(tu);
//        this.setUnaLocalidad(unaLoc);
//        this.setPass(contra);
//        if (ret!=null){
//            empleados.removeFirstOccurrence(ret);
//            ret = this;
//            empleados.add(ret);
//        }else{
//            ret = this;
//        }
//        return ret;
//    }
//    
//
//    private static LinkedList<Empleado> empleados = new LinkedList<Empleado>();
//    //Metodos en memoria
//    public Empleado buscarEmpleado(long dni){
//        Empleado emp, ret=null;
//        if (!empleados.isEmpty()) { 
//            Iterator<Empleado> it = empleados.iterator();
//            while(it.hasNext()&& ret==null){
//                emp= it.next();
//                if (emp.getDni()==dni){
//                    ret=emp;
//                }
//            }
//        }        
//        return ret;
//    }
//    public Empleado creaEmpleado(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, long telefono, int sueldo, 
//            String contra, Date horaInicio, Date horaFin){
//        Empleado ret = buscarEmpleado( dni);
//        if (ret==null){
//            this.nombre = nombre;
//            this.dni = dni;
//            this.telefono = telefono;
//            this.sueldo = sueldo;
//            this.borrado = false;
//            this.horaInicio = horaInicio;
//            this.horaFin = horaFin;
//            this.unaSucursal = unaSuc;
//            this.vsTurno = new LinkedList<Turno>();
//            this.unaLocalidad = unaLoc;
//            this.pass = contra;
//            ret=this;
//            empleados.add(ret);
//        }else{
//            ret=null; 
//        }
//        return ret;
////    }    
//    public Empleado editaEmpleado(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, long telefono, int sueldo, 
//            String contra, Date horaInicio, Date horaFin, LinkedList<Turno> tu, boolean ok){
//        Empleado ret = buscarEmpleado( dni);
//        this.setNombre(nombre);
//        this.setDni(dni);
//        this.setTelefono(telefono);
//        this.setSueldo(sueldo);
//        this.setBorrado(ok);
//        this.setHoraInicio(horaInicio);
//        this.setHoraFin(horaFin);
//        this.setUnaSucursal(unaSuc);
//        this.setVsTurno(tu);
//        this.setUnaLocalidad(unaLoc);
//        this.setPass(contra);
//        if (ret!=null){
//            empleados.removeFirstOccurrence(ret);
//            ret = this;
//            empleados.add(ret);
//        }else{
//            ret = this;
//        }
//        return ret;
//    }
//    public void eliminaEmpleado(long dni){
//        Empleado ret = buscarEmpleado (dni);
//        if (ret!=null){
//            empleados.removeFirstOccurrence(ret);
//        }
//    }
//    public LinkedList<Empleado> darEmpleado(){
//        return empleados;
//    }
//    
}
