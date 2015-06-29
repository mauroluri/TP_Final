package LogicaDeNegocios;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Vehiculo implements Serializable {
    @Id
    private String nroChasis;
    @Basic
    private String dominio;
    @Basic
    private String nroMotor;
    @Basic
    private int anio;
    @Basic
    private String color;
    @Basic
    private int puertas;
    @Basic
    private boolean borrado;
    
    //Relaciones
        //Segmento
    @OneToOne
    private Segmento unSegmento;
        //Modelo
    @OneToOne
    private Modelo unModelo;
        //Garantia
    @OneToOne
    private Garantia unGarantia;
        //Cliente
    @ManyToOne
    private Cliente unCliente;
        //ActividadesPendientes
    @OneToMany
    private List<Actividad> vsActividadesPend;
        //ActividadesRealizadas
    @OneToMany
    private List<Actividad> vsActividadesRealiz;
        //OrdenTrabajo
    @OneToMany
    private List<OrdenTrabajo> vsOrdenTrabajo;
        //TurnosPendientes
    @OneToMany
    private List<Turno> vsTurnos;
    
    //SETS
    public void setDominio(String dominio) { this.dominio = dominio; }
    public void setNroChasis(String nroChasis) { this.nroChasis = nroChasis; }
    public void setNroMotor(String nroMotor) { this.nroMotor = nroMotor; }
    public void setAnio(int anio) { this.anio = anio; }
    public void setColor(String color) { this.color = color; }
    public void setPuertas(int puertas) { this.puertas = puertas; }
    public void setBorrado(boolean borrado) { this.borrado = borrado; }
    public void setUnCliente(Cliente unCliente) { this.unCliente = unCliente; }
    public void setUnGarantia(Garantia unGarantia) { this.unGarantia = unGarantia; }
    public void setUnModelo(Modelo unModelo) { this.unModelo = unModelo; }
    public void setUnSegmento(Segmento unSegmento) { this.unSegmento = unSegmento; }
    public void setVsActividadesPend(List<Actividad> vsActividadesPend) { this.vsActividadesPend = vsActividadesPend; }
    public void setVsActividadesRealiz(List<Actividad> vsActividadesRealiz) { this.vsActividadesRealiz = vsActividadesRealiz; }
    public void setVsOrdenTrabajo(List<OrdenTrabajo> vsOrdenTrabajo) { this.vsOrdenTrabajo = vsOrdenTrabajo; }
    public void setVsTurnosPend(List<Turno> vsTurnosPend) { this.vsTurnos = vsTurnosPend; }
    
    //GETS
    public String getDominio() { return this.dominio; }
    public String getNroChasis() { return this.nroChasis; }
    public String getNroMotor() { return this.nroMotor; }
    public int getAnio() { return this.anio; }
    public String getColor() { return this.color; }
    public int getPuertas() { return this.puertas; }
    public boolean getBorrado() { return borrado; }
    public Cliente getUnCliente() { return unCliente; }
    public Garantia getUnGarantia() { return unGarantia; }
    public Modelo getUnModelo() { return unModelo; }
    public Segmento getUnSegmento() { return unSegmento; }
    public List<Actividad> getVsActividadesPend() { return vsActividadesPend; }
    public List<Actividad> getVsActividadesRealiz() { return vsActividadesRealiz; }
    public List<OrdenTrabajo> getVsOrdenTrabajo() { return vsOrdenTrabajo; }
    public List<Turno> getVsTurnosPend() { return vsTurnos; }
        
    public String toString() {
        return "[Dominio: "+this.getDominio()+"] \n[Número de chasis: "+this.getNroChasis()+"] \n"
                + "[Número de motor: "+this.getNroMotor()+"] \n[Año: "+this.getAnio()+"] "
                + "\n[Color: "+this.getColor()+"] \n[Puertas: "+this.getPuertas()
                + "] \n[Borrado: "+this.getBorrado()+"]";
    }
    
    public Vehiculo(){}
    
    public Vehiculo(Segmento seg, Modelo mod, Garantia gar, Cliente cli, String dominio, String nroChasis, String nroMotor, int anio, String color, int puertas){
        this.dominio=dominio;
        this.nroChasis=nroChasis;
        this.nroMotor=nroMotor;
        this.anio=anio;
        this.color=color;
        this.puertas=puertas;
        this.borrado=false;
        this.unSegmento = seg;
        this.unModelo = mod;
        this.unGarantia = gar;
        this.unCliente= cli;
        this.vsActividadesPend = new LinkedList<Actividad>();
        this.vsActividadesRealiz = new LinkedList<Actividad>();
        this.vsOrdenTrabajo = new LinkedList<OrdenTrabajo>();
        this.vsTurnos = new LinkedList<Turno>();
    }    
}