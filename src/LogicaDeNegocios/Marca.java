package LogicaDeNegocios;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Marca implements Serializable {
    @Id
    private String nombre;

    //SETS
    public void setNombre(String nombre) { this.nombre = nombre; }

    //GETS
    public String getNombre() { return this.nombre; }
    
    public String toString() { return "[Nombre: "+this.getNombre()+"]"; }
    
    public Marca(){}
    
    public Marca(String nombre){
        this.nombre=nombre;
    }
}
