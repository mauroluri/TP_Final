package LogicaDeNegocios;

import java.io.Serializable;
import javax.persistence.Temporal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Garantia implements Serializable {
    @Id
    private String detalle;
    @Basic    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    @Basic
    private int duracion;
    @Basic
    private boolean vigencia;
    
    //Relaciones
        //GrupoParte
    @OneToMany
    private List<Autoparte> vsAutoparte;

    //SETS  
    public void setFecha(Date fecha) { this.fecha = fecha; }
    public void setDuracion(int duracion) { this.duracion = duracion; }
    public void setDetalle(String detalle) { this.detalle = detalle; }
    public void setVigencia(boolean vigencia) { this.vigencia = vigencia; }
    public void setVsAutoparte(List<Autoparte> vsAutoparte) { this.vsAutoparte = vsAutoparte; }

    //GETS  
    public Date getFecha() { return this.fecha; }
    public int getDuracion() { return this.duracion; }
    public String getDetalle() { return this.detalle; }
    public boolean getVigencia() { return this.vigencia; }
    public List<Autoparte> getVsAutoparte() { return vsAutoparte; }
        
    public String toString() {
        return "[Fecha: "+this.getFecha()+"] \n[Duración: "+this.getDuracion()+"] \n"
                + "[Detalles: "+this.getDetalle()+"] \n[Vigencia: "+this.getVigencia();
    }

    public Garantia() { }

    public Garantia(Date fecha, int duracion, String detalle, boolean vigencia, List<Autoparte> partes) {
        this.fecha = fecha;
        this.duracion = duracion;
        this.detalle = detalle;
        this.vigencia = vigencia;
        this.vsAutoparte = partes;
    }    
}
