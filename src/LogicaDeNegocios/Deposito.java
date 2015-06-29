package LogicaDeNegocios;

import javax.persistence.Temporal;
import java.util.Date;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Deposito extends Sector implements Serializable {
    
    //relaciones
        //Item
    @OneToMany
    private List<Item> vsItem;

    //GET
    public List<Item> getVsItem() { return vsItem; }

    //SET
    public void setVsItem(List<Item> vsItem) { this.vsItem = vsItem; }
    
    public Deposito() { }

    public Deposito(int cod, Date horaInicio, Date horaFin) { 
        super(cod, horaInicio, horaFin);
        this.vsItem = new LinkedList<Item>();}
}
