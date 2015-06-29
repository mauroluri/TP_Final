package LogicaDeNegocios;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Segmento implements Serializable {
    @Id
    private String nombre;

    public void setNombre(String nombre) { this.nombre = nombre; }

    //GET
    public String getNombre() { return this.nombre; }
    
    //SET
    public String toString() { return "[Nombre: "+this.getNombre()+"]"; }
    
    public Segmento(){}
    
    public Segmento(String nombre){
        this.nombre=nombre;
    }
}
