package LogicaDeNegocios;

import java.io.Serializable;
import javax.persistence.Temporal;
import java.util.Date;
import javax.persistence.*;

@Entity
public class DetalleActividad implements Serializable {
    @Id
    private String cod;
    @Basic
    private String descripcion;
    @Basic
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date duracion;

    //SETS
    public void setCod(String cod) { this.cod = cod; }
    public void setDuracion(Date duracion) { this.duracion = duracion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    //GETS
    public String getCod() { return this.cod; }
    public Date getDuracion() { return this.duracion; }
    public String getDescripcion() { return this.descripcion; }
        
    public String toString() { return "[Nombre: "+this.getCod()+"] \n[Descripción: "+this.getDescripcion()+
            " \n[Duración: "+this.getDuracion()+"]"; }

    public DetalleActividad() { }

    public DetalleActividad(String cod, String descripcion, Date duracion) {
        this.cod = cod;
        this.duracion = duracion;
        this.descripcion = descripcion;
    }
}
