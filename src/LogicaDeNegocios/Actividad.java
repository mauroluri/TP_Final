package LogicaDeNegocios;

import java.io.Serializable;
import javax.persistence.Temporal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Actividad implements Serializable {
    @Id
    private String nombre;
    @Basic
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date duracionTotal;
    
    //Relaciones
        //Actividad
    @OneToMany
    private List<DetalleActividad> vsEspDetActividad;
        //Categoria
    @ManyToOne
    private Categoria unaCategoria;
        //GrupoParte
    @ManyToOne
    private GrupoParte unGrupoParte;

    //SETS
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDuracionTotal(Date duracionTotal) { this.duracionTotal = duracionTotal; }
    public void setVsEspDetActividad(List<DetalleActividad> vsEspDetActividad) { this.vsEspDetActividad = vsEspDetActividad; }
    public void setUnGrupoParte(GrupoParte unGrupoParte) { this.unGrupoParte = unGrupoParte; }
    public void setUnaCategoria(Categoria unaCategoria) { this.unaCategoria = unaCategoria; }
    
    //GETS
    public String getNombre() { return this.nombre; }
    public Date getDuracionTotal() { return this.duracionTotal; }
    public List<DetalleActividad> getVsEspDetActividad() { return vsEspDetActividad; }
    public GrupoParte getUnGrupoParte() { return unGrupoParte; }
    public Categoria getUnaCategoria() { return unaCategoria; }
        
    public String toString() {
        return "[Codigo: "+this.getNombre()+"] \n"
                + "[Duración total: "+this.getDuracionTotal()+"]";
    }

    public Actividad() { }

    public Actividad(String nombre, Categoria categ, Date duracionTotal, GrupoParte grupo,List<DetalleActividad> ac) {
        this.nombre = nombre;
        this.duracionTotal = duracionTotal;
        this.unGrupoParte = grupo;
        this.unaCategoria = categ;
        this.vsEspDetActividad = ac;
    }
}
