package LogicaDeNegocios;

import javax.persistence.Temporal;
import java.util.Date;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Recepcion extends Sector implements Serializable {

    //Relaciones
        //Turno
    @OneToMany
    private List<Turno> vsTurno;

    //SET
    public void setVsTurno(List<Turno> vsTurno) { this.vsTurno = vsTurno; }

    //GET
    public List<Turno> getVsTurno() { return vsTurno; }
    
    public Recepcion() { }

    public Recepcion(int cod, Date horaInicio, Date horaFin) { 
        super(cod, horaInicio, horaFin);
        this.vsTurno = new LinkedList<Turno>();
    }
}
