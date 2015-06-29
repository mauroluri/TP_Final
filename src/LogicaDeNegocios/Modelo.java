package LogicaDeNegocios;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Modelo implements Serializable {
    @Id
    private String nombre;
    @Basic
    private int anio;
    
    //Relaciones
            //Marca
    @OneToOne
    private Marca unaMarca;

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setAnio(int anio) { this.anio = anio; }
    public void setUnaMarca(Marca unaMarca) { this.unaMarca = unaMarca; }
    

    public String getNombre() { return this.nombre; }
    public int getAnio() { return this.anio; }
    public Marca getUnaMarca() { return unaMarca; }
    
    
    public String toString() {
        return "[Nombre: "+this.getNombre()+"] \n[Año: "+this.getAnio()+"]";
    }
    
    public Modelo(){}
    
    public Modelo(Marca mar, String nombre, int anio){
        this.nombre=nombre;
        this.anio=anio;
        this.unaMarca = mar;
    }
}
