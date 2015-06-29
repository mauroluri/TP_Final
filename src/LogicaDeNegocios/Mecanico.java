package LogicaDeNegocios;

import java.io.Serializable;
import javax.persistence.Temporal;
import java.util.Date;
import java.util.*;
import javax.persistence.*;

@Entity
public class Mecanico extends Empleado implements Serializable{

    //Relaciones
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
    public void setVsInterno(List<Interno> vsInterno) { this.vsInterno = vsInterno; }
    public void setUnaEspecialidad(Especialidad unaEspecialidad) { this.unaEspecialidad = unaEspecialidad; }
    public void setVsOrdenTrabajo(List<OrdenTrabajo> vsOrdenTrabajo) { this.vsOrdenTrabajo = vsOrdenTrabajo; }
    
    //GETS
    public List<Interno> getVsInterno() { return vsInterno; }
    public Especialidad getUnaEspecialidad() { return unaEspecialidad; }
    public List<OrdenTrabajo> getVsOrdenTrabajo() { return vsOrdenTrabajo; }
    
    public Mecanico() { }
    
    public Mecanico(Localidad unaLoc,Sucursal unaSuc, String nombre, long dni, long telefono, int sueldo, 
            String p, Date horaInicio, Date horaFin, Especialidad profesion) {
        super(unaLoc, unaSuc, nombre, dni, telefono, sueldo, p, horaInicio, horaFin);
        this.vsInterno = new LinkedList<Interno>();
        this.unaEspecialidad = profesion;
        this.vsOrdenTrabajo = new LinkedList<OrdenTrabajo>();
    }
}