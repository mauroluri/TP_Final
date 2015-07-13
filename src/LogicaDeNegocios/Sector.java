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
    
       //En memoria (sin persistencia)    
    private static int[] sectores;
    //Metodos en memoria
    public int buscarCod(int cod){
        int res=-1;
        if (sectores.length>0) {
            for (int i=0;i<sectores.length;i++){
                if (sectores[i]==cod){
                    res=i;
                }
            }
        }        
        return res;
    }
    public void agregaSector(int cod){
        sectores[sectores.length]=cod;
    }
    public void eliminaSector(int cod){
        for (int i=0;i<sectores.length;i++){
            if (sectores[i]==cod){
                sectores[i]=sectores[i+1];
            }
        } 
    }
    public int[] darSectores(){
        return sectores;
    }
}
