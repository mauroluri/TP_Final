package LogicaDeNegocios;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Provincia implements Serializable {
    @Id
    private int codigo;
    @Basic
    private String nombre;
    
    //Relaciones
        //Localidad
    @OneToMany
    private List<Localidad> localidades;
    
    //SETS
    public void setCodigo(int codigo) { this.codigo = codigo; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setLocalidades(List<Localidad> localidades) { this.localidades = localidades; }

    //GETS
    public int getCodigo() { return this.codigo; }
    public String getNombre() { return this.nombre; }
    public List<Localidad> getLocalidades() { return this.localidades; }
    
    public Provincia() { }

    public Provincia(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre; 
        this.localidades = new LinkedList<Localidad>(); }    
}