package LogicaDeNegocios;

import java.io.Serializable;
import javax.persistence.Temporal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Perito extends Empleado implements Serializable{

    //Relaciones
        //Garantia
    @OneToMany
    private List<Garantia> vsGarantia;

    //SET
    public void setVsGarantia(List<Garantia> vsGarantia) { this.vsGarantia = vsGarantia; }

    //GET
    public List<Garantia> getVsGarantia() { return vsGarantia; }
    
    public Perito() { }
    
    public Perito(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, long telefono, int sueldo, 
            String p, Date horaInicio, Date horaFin) {
        super(unaLoc, unaSuc, nombre, dni, telefono, sueldo, p, horaInicio, horaFin);
        this.vsGarantia = new LinkedList<Garantia>();
    }
}
