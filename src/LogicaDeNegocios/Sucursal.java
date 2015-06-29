package LogicaDeNegocios;

import java.io.Serializable;
import javax.persistence.Temporal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Sucursal implements Serializable{
    @Id
    private int codSuc;
    @Basic
    private long telefono;
    @Basic
    private int altura;
    @Basic
    private boolean borrado;
    @Basic
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horaInicio;
    @Basic
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horaFin;
    
    //Relaciones
        //Turno
    @OneToMany
    private List<Turno> vsTurno;
        //Sector
    @OneToMany
    private List<Sector> vsSector;
        //Empleado
    @OneToMany
    private List<Empleado> vsEmpleado;
        //Pedido
    @OneToMany
    private List<Pedido> vsPedido;
        //Calle
    @OneToOne
    private Calle calleSuc;
    @OneToMany
    private List<Calle> vsCalle;
        //Localidad
    @ManyToOne
    private Localidad unaLocalidad;
        //Cliente
    @OneToMany
    private List<Cliente> vsCliente;
    
    //SETS
    public void setTelefono(long telefono) { this.telefono = telefono; }
    public void setAltura(int altura) { this.altura = altura; }
    public void setCalleSuc(Calle calleSuc) { this.calleSuc = calleSuc; }
    public void setCodSuc(int codSuc) { this.codSuc = codSuc; }
    public void setBorrado(boolean borrado) { this.borrado = borrado; }
    public void setVsCalle(List<Calle> vsCalle) { this.vsCalle = vsCalle; }
    public void setVsEmpleado(List<Empleado> vsEmpleado) { this.vsEmpleado = vsEmpleado; }
    public void setVsPedido(List<Pedido> vsPedido) { this.vsPedido = vsPedido; }
    public void setVsSector(List<Sector> vsSector) { this.vsSector = vsSector; }
    public void setVsTurno(List<Turno> vsTurno) { this.vsTurno = vsTurno; }
    public void setUnaLocalidad(Localidad unaLocalidad) { this.unaLocalidad = unaLocalidad; }
    public void setHoraInicio(Date horaInicio) { this.horaInicio = horaInicio; }
    public void setHoraFin(Date horaFin) { this.horaFin = horaFin;}
    public void setVsCliente(List<Cliente> vsCliente) { this.vsCliente = vsCliente; }
    
    //GETS
    public long getTelefono(){ return this.telefono; }
    public int getAltura() { return this.altura; }
    public Calle getCalleSuc() { return this.calleSuc; }
    public int getCodSuc() { return codSuc; }
    public boolean getBorrado() { return borrado; }
    public List<Calle> getVsCalle() { return vsCalle; }
    public List<Empleado> getVsEmpleado() { return vsEmpleado; }
    public List<Pedido> getVsPedido() { return vsPedido; }
    public List<Sector> getVsSector() { return vsSector; }
    public List<Turno> getVsTurno() { return vsTurno; }
    public Localidad getUnaLocalidad() { return unaLocalidad; }
    public Date getHoraInicio() { return horaInicio;}
    public Date getHoraFin() {return horaFin;}
    public List<Cliente> getVsCliente() { return vsCliente; }
     
        
    public String toString() {
        return "[Teléfono: "+this.getTelefono()+"] \n[Calle: "+this.getCalleSuc()+"] "
                + "[Altura: "+this.getAltura()+"\n[Localidad: "+this.getUnaLocalidad()
                + "] \n[Código postal: "+this.getUnaLocalidad().getCodPost()+"] \n"+ "\n[Borrado: "+this.getBorrado()+"]";
    }

    public Sucursal() { }

    public Sucursal(int cod, Localidad unaLoc, long telefono, int altura, Calle calleSuc, Date horaInicio, Date horaFin) {
        this.codSuc = cod;
        this.telefono = telefono;
        this.unaLocalidad = unaLoc;
        this.altura = altura;
        this.calleSuc = calleSuc;
        this.borrado = false;
        this.horaInicio=horaInicio;
        this.horaFin=horaFin;
        this.vsTurno = new LinkedList<Turno>();
        this.vsSector = new LinkedList<Sector>();
        this.vsEmpleado = new LinkedList<Empleado>();
        this.vsPedido = new LinkedList<Pedido>();
        this.vsCliente = new LinkedList<Cliente>();
        this.vsCalle = new LinkedList<Calle>();
    }
}
