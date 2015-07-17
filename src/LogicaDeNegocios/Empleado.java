package LogicaDeNegocios;

import java.io.Serializable;
import javax.persistence.Temporal;
import java.util.Date;
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
            this.unaLocalidad = unaLoc;
            this.pass = contra;
    }    
    
    
        //En memoria (sin persistencia)    
    private static long[] empleados;
    //Metodos en memoria
    public int buscarDni(long dni){
        int res=-1;
        if (empleados.length>0) {
            for (int i=0;i<empleados.length;i++){
                if (empleados[i]==dni){
                    res=i;
                }
            }
        }        
        return res;
    }
    public void agregaEmpleado(long dni){
        empleados[empleados.length]=dni;
    }
    public void eliminaEmpleado(long dni){
        for (int i=0;i<empleados.length;i++){
            if (empleados[i]==dni){
                empleados[i]=empleados[i+1];
            }
        } 
    }
    public long[] darEmpleados(){
        return empleados;
    }
}