
package LogicaDeNegocios;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Categoria implements Serializable {
    @Id
    private String nombre;
    
    //Relaciones
        //Actividad
    @OneToMany
    private List<Actividad> vsEspecialidadActividad;

    //SETS
    public void setNombre(String nombre) { this.nombre = nombre;}
    public void setVsEspecialidadActividad(List<Actividad> vsEspecialidadActividad) { this.vsEspecialidadActividad = vsEspecialidadActividad; }
    
    //GETS
    public String getNombre() { return this.nombre;}
    public List<Actividad> getVsEspecialidadActividad() { return vsEspecialidadActividad; }
    
    public String toString() {  return "[Nombre: "+this.getNombre()+"]"; }
    
    public Categoria(){}
    
    public Categoria(String nombre){ 
        this.nombre=nombre;
        this.vsEspecialidadActividad = new LinkedList<Actividad>(); }
    
}
