package LogicaDeNegocios;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Estado implements Serializable {
    @Id
    private String nombre;
    
    //GET
    public String getNombre() { return this.nombre; }
    
    //SET
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String toString() { return "[Nombre: "+this.getNombre()+"]"; }
    
    public Estado() { }

    public Estado(String nombre) { this.nombre = nombre; }
}
