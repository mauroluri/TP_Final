package LogicaDeNegocios;

import java.io.Serializable;
import javax.persistence.Temporal;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public abstract class Empleado implements Serializable{
    @Basic
    private String nombre;
    @Id
    private long dni;
    @Basic
    private long telefono;
    @Basic
    private int sueldo;
    @Basic
    private boolean borrado;
    @Basic
    private String pass;
    @Basic
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horaInicio;
    @Basic
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horaFin;
    
    //Relaciones
        //Sucursal
    @ManyToOne
    private Sucursal unaSucursal;
        //Turno
    @OneToMany
    private List<Turno> vsTurno;
        //Localidad
    @ManyToOne
    private Localidad unaLocalidad;
    
    
    //GETS
    public String getNombre() { return this.nombre; }
    public long getDni() { return this.dni; }
    public long getTelefono() { return this.telefono; }
    public int getSueldo() { return this.sueldo; }
    public boolean getBorrado() {return this.borrado;}
    public Sucursal getUnaSucursal() { return this.unaSucursal; }
    public List<Turno> getVsTurno() { return this.vsTurno; }
    public Localidad getUnaLocalidad() { return this.unaLocalidad; }
    public String getPass() { return this.pass; }
    public Date getHoraFin() { return this.horaFin; }
    public Date getHoraInicio() { return this.horaInicio; }
    
    
        
    //SETS
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDni(long dni) { this.dni = dni; }
    public void setTelefono(long telefono) { this.telefono = telefono; }
    public void setSueldo(int sueldo) { this.sueldo = sueldo; }
    public void setBorrado (boolean borrado) {this.borrado = borrado;}
    public void setUnaSucursal(Sucursal unaSucursal) { this.unaSucursal = unaSucursal; }
    public void setVsTurno(List<Turno> vsTurno) { this.vsTurno = vsTurno; }
    public void setUnaLocalidad(Localidad unaLocalidad) { this.unaLocalidad = unaLocalidad; }
    public void setPass(String pass) { this.pass = pass; }
    public void setHoraInicio(Date horaInicio) { this.horaInicio = horaInicio; }    
    public void setHoraFin(Date horaFin) { this.horaFin = horaFin; }
    
        
    public String toString() {
        return "[Nombre: "+this.getNombre()+"] \n[DNI: "+this.getDni()+"] \n"
                +"] \n[Teléfono: "+this.getTelefono()+"] "
                + "\n[Sueldo: "+this.getSueldo()+ "\n[Borrado: "+this.getBorrado()+"]"; }
    
    //CONSTRUCTORES
    public Empleado() { }

    public Empleado(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, long telefono, int sueldo, 
            String contra, Date horaInicio, Date horaFin) {
        this.nombre = nombre;
            this.dni = dni;
            this.telefono = telefono;
            this.sueldo = sueldo;
            this.borrado = false;
            this.horaInicio = horaInicio;
            this.horaFin = horaFin;
            this.unaSucursal = unaSuc;
            this.vsTurno = new LinkedList<Turno>();
            this.unaLocalidad = unaLoc;
            this.pass = contra;
    }    
    
        //En memoria (sin persistencia)    
    private static LinkedList<Empleado> empleados = new LinkedList<Empleado>();
//    private void setClientes(Cliente cli){
//        clientes.add(cli);
//    }
//    private LinkedList<Cliente> getClientes(){
//        return clientes;
//    }
    //Metodos en memoria
    public Empleado buscarEmpleado(long dni){
        Empleado emp, ret=null;
        if (!empleados.isEmpty()) { 
            Iterator<Empleado> it = empleados.iterator();
            while(it.hasNext()&& ret==null){
                emp= it.next();
                if (emp.getDni()==dni){
                    ret=emp;
                }
            }
        }        
        return ret;
    }
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
//    }    
    public Empleado editaEmpleado(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, long telefono, int sueldo, 
            String contra, Date horaInicio, Date horaFin, LinkedList<Turno> tu, boolean ok){
        Empleado ret = buscarEmpleado( dni);
        this.setNombre(nombre);
        this.setDni(dni);
        this.setTelefono(telefono);
        this.setSueldo(sueldo);
        this.setBorrado(ok);
        this.setHoraInicio(horaInicio);
        this.setHoraFin(horaFin);
        this.setUnaSucursal(unaSuc);
        this.setVsTurno(tu);
        this.setUnaLocalidad(unaLoc);
        this.setPass(contra);
        if (ret!=null){
            empleados.removeFirstOccurrence(ret);
            ret = this;
            empleados.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaEmpleado(long dni){
        Empleado ret = buscarEmpleado (dni);
        if (ret!=null){
            empleados.removeFirstOccurrence(ret);
        }
    }
    public LinkedList<Empleado> darEmpleado(){
        return empleados;
    }
}