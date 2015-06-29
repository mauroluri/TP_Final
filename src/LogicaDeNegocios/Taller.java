package LogicaDeNegocios;

import javax.persistence.Temporal;
import java.util.Date;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Taller extends Sector implements Serializable{

    //Relaciones
        //OrdenTrabajo
    @OneToMany
    private List<OrdenTrabajo> vsOrdenTrabajo;

    public void setVsOrdenTrabajo(List<OrdenTrabajo> vsOrdenTrabajo) { this.vsOrdenTrabajo = vsOrdenTrabajo; }

    public List<OrdenTrabajo> getVsOrdenTrabajo() { return vsOrdenTrabajo; }
    
    public Taller() { }
    
    public Taller(int cod, Date horaInicio, Date horaFin) { 
        super(cod, horaInicio, horaFin);
        this.vsOrdenTrabajo = new LinkedList<OrdenTrabajo>();
    }
}
