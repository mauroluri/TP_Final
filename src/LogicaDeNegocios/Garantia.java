package LogicaDeNegocios;

import java.io.Serializable;
import javax.persistence.Temporal;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
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
    
                //En memoria (sin persistencia)    
    private static List<Garantia> garantias = new LinkedList<Garantia>();

    //Metodos en memoria
    public Garantia buscarGarantia(String detalle){
        Garantia ga, ret=null;
        if (!garantias.isEmpty()) { 
            Iterator<Garantia> it = garantias.iterator();
            while(it.hasNext()&& ret==null){
                ga= it.next();
                if (ga.getDetalle().equalsIgnoreCase(detalle)){
                    ret=ga;
                }
            }
        }        
        return ret;
    }
    public Garantia creaGarantia (Date fecha, int duracion, String detalle, boolean vigencia, List<Autoparte> partes){
        Garantia ret = buscarGarantia(detalle);
        if (ret==null){
            ret=new Garantia(fecha, duracion, detalle, vigencia, partes);
            garantias.add(ret);
        }else{
            ret=null; 
        }
        return ret;
    }    
    public Garantia editaGarantia(Date fecha, int duracion, String detalle, boolean vigencia, List<Autoparte> partes){
        Garantia ret = buscarGarantia( detalle);
        this.setDetalle(detalle);
        this.setDuracion(duracion);
        this.setFecha(fecha);
        this.setVigencia(vigencia);
        this.setVsAutoparte(partes);
        if (ret!=null){
            garantias.remove(ret);
            ret = this;
            garantias.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaGarantia(String detalle){
        Garantia ret = buscarGarantia (detalle);
        if (ret!=null){
            garantias.remove(ret);
        }
    }
    public List<Garantia> darGarantia(){
        return garantias;
    }
}
