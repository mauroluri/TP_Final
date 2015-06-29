package LogicaDeNegocios;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class NivelSeveridad implements Serializable{
    @Id
    private int nivel;
    @Basic
    private String nombre;

    //SETS
    public void setNivel(int nivel) { this.nivel = nivel; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    //GETS
    public int getNivel() { return this.nivel; }
    public String getNombre() { return nombre; }
    
    public String toString() { return "[Nivel: "+this.getNivel()+"] \n[Nombre: "+this.getNombre()+"]"; }
    
    public NivelSeveridad(){}
    
    public NivelSeveridad(int nivel, String nombre){ 
        this.nivel=nivel; 
        this.nombre=nombre; 
    }
}