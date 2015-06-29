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
}
