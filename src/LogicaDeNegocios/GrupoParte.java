package LogicaDeNegocios;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class GrupoParte implements Serializable{
    @Basic
    private String nombre;
    @Id
    private int codGrupo;
    
    //Relaciones
        //Vehiculo
    @OneToMany
    private List<Modelo> vsModelo;
        //Autoparte
    @OneToMany
    private List<Autoparte> vsAutoparte;
        //Proveedor
    @ManyToMany
    private List<Proveedor> vsProveedor;

    //SETS
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCodGrupo(int codGrupo) { this.codGrupo = codGrupo; }
    public void setVsModelo(List<Modelo> vsModelo) { this.vsModelo = vsModelo; }
    public void setVsAutoparte(List<Autoparte> vsAutoparte) { this.vsAutoparte = vsAutoparte; }
    public void setVsProveedor(List<Proveedor> vsProveedor) { this.vsProveedor = vsProveedor; }

    

    //GETS
    public String getNombre() { return this.nombre; }
    public int getCodGrupo() { return this.codGrupo; }
    public List<Autoparte> getVsAutoparte() { return vsAutoparte; }
    public List<Modelo> getVsModelo() { return vsModelo; }    
    public List<Proveedor> getVsProveedor() { return vsProveedor; }

    
    public String toString() {
        return "[Nombre: "+this.getNombre()+"] \n[codGrupo: "+this.getCodGrupo()+"]";
    }

    public GrupoParte() { }

    public GrupoParte(String nombre, int codGrupo, LinkedList<Modelo> mods, LinkedList<Autoparte> parts) {
        this.nombre = nombre;
        this.codGrupo = codGrupo;
        this.vsModelo = mods;
        this.vsAutoparte = parts;
        this.vsProveedor = new LinkedList<Proveedor>();
    }
}