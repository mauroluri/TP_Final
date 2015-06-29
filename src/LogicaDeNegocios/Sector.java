package LogicaDeNegocios;

import java.io.Serializable;
import javax.persistence.Temporal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public abstract class Sector implements Serializable {
    @Id
    private int cod;
    @Basic
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horaInicio;
    @Basic
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horaFin;
    
    //Relaciones
        //Empleado
    @OneToMany
    private List<Empleado> vsEmpleado;

    //SETS
    public void setCod(int cod) { this.cod = cod; }
    public void setVsEmpleado(List<Empleado> vsEmpleado) { this.vsEmpleado = vsEmpleado; }
    public void setHoraInicio(Date horaInicio) { this.horaInicio = horaInicio; }
    public void setHoraFin(Date horaFin) { this.horaFin = horaFin; }
    
    
    //GETS
    public int getCod() { return this.cod; }
    public List<Empleado> getVsEmpleado() { return this.vsEmpleado; }
    public Date getHoraInicio() { return this.horaInicio; }
    public Date getHoraFin() { return this.horaFin; }
    
    
    public Sector() { }
    
    public String toString() {
        return "[Nombre: "+this.getCod()+"]";
    }

    public Sector(int cod, Date horaInicio, Date horaFin) {
        this.cod = cod;
        this.horaInicio=horaInicio;
        this.horaFin=horaFin;
        this.vsEmpleado = new LinkedList<Empleado>();
    }       
}
