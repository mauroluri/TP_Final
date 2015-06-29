package LogicaDeNegocios;

import java.io.Serializable;
import javax.persistence.Temporal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Encargado extends Empleado implements Serializable{

    //Relaciones
    /*    //Interno            PROBLEMA TABLAS CON VARIOS PK     ??
    @OneToMany
    private List<Interno> vsInterno;*/
        //Item
    @OneToMany
    private List<Item> vsItem;
        //OrdenTrabajo
    @OneToMany
    private List<OrdenTrabajo> vsOrdenTrabajo;

    //SET
    //public void setVsInterno(List<Interno> vsInterno) { this.vsInterno = vsInterno; }
    public void setVsItem(List<Item> vsItem) { this.vsItem = vsItem; }
    public void setVsOrdenTrabajo(List<OrdenTrabajo> vsOrdenTrabajo) { this.vsOrdenTrabajo = vsOrdenTrabajo; }
    
    //GET
    //public List<Interno> getVsInterno() { return vsInterno; }
    public List<Item> getVsItem() { return vsItem; }
    public List<OrdenTrabajo> getVsOrdenTrabajo() { return vsOrdenTrabajo; }
        
    public Encargado() { }
    
    public Encargado(Localidad unaLoc, Sucursal unaSuc, String nombre, long dni, long telefono, int sueldo, 
            String p, Date horaInicio, Date horaFin) {
        super(unaLoc, unaSuc, nombre, dni,  telefono, sueldo, p, horaInicio, horaFin);
        //this.vsInterno = new LinkedList<Interno>();
        this.vsItem = new LinkedList<Item>();
        this.vsOrdenTrabajo = new LinkedList<OrdenTrabajo>();
    }
}
