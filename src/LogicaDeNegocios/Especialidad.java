package LogicaDeNegocios;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Especialidad implements Serializable {
    @Id
    private String nombre;
    
    //Relaciones
        //Mecanico
    @OneToMany
    private List<Mecanico> vsMecanico;

    //SET
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setVsMecanico(List<Mecanico> vsMecanico) { this.vsMecanico = vsMecanico; }

    //GETS
    public String getNombre() { return this.nombre; }
    public List<Mecanico> getVsMecanico() { return vsMecanico; }
    
    public String toString() { return "[Nombre: "+this.getNombre()+"]"; }

    public Especialidad() { }

    public Especialidad(String nombre) { 
        this.nombre = nombre;
        this.vsMecanico = new LinkedList<Mecanico>();
    }
}
