package LogicaDeNegocios;

import java.io.Serializable;
import javax.persistence.Temporal;
import java.util.Date;
import java.util.*;
import javax.persistence.*;
   
@Entity
public class Turno implements Serializable{
    @Id
    private long codigo;
    @Basic
    private String descrip;
    @Basic
    private boolean borrado;
    @Basic
    private boolean realizado;
    @Basic
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    @Basic
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date duracionAprox;
    @Basic
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horaInicio;
    
    //Relaciones
        //Cliente
    @ManyToOne
    private Cliente unCliente;
        //Vehiculo
    @OneToOne
    private Vehiculo unVehiculo;
        //Empleado
    @OneToMany
    private List<Empleado> vsEmpleado;
        //OrdenTrabajo
    @OneToOne
    private OrdenTrabajo unaOrdenTrabajo;
        //Estado
    @OneToOne
    private Estado unEstado;
        //NivelSeveridad
    @OneToOne
    private NivelSeveridad unNivelSeveridad;
        
    //GETS
    public Date getFecha() { return this.fecha; }
    public Date getDuracionAprox() { return this.duracionAprox; }
    public long getCodigo() { return codigo; }
    public Cliente getUnCliente() { return unCliente; }
    public List<Empleado> getVsEmpleado() { return vsEmpleado; }
    public Vehiculo getUnVehiculo() { return unVehiculo; }
    public OrdenTrabajo getUnaOrdenTrabajo() { return unaOrdenTrabajo; }
    public Date getHoraInicio() { return this.horaInicio; }
    public boolean getBorrado() {return this.borrado;}
    public boolean getRealizado() {return this.realizado;}
    public Estado getUnEstado() { return unEstado; }
    public NivelSeveridad getUnNivelSeveridad() { return unNivelSeveridad; }
    public String getDescrip() { return this.descrip; }
    
    //SETS
    public void setFecha(Date fecha) { this.fecha = fecha; }
    public void setDuracionAprox(Date duracionAprox) { this.duracionAprox = duracionAprox; }
    public void setCodigo(long codigo) { this.codigo = codigo; }
    public void setUnCliente(Cliente unCliente) { this.unCliente = unCliente; }
    public void setVsEmpleado(List<Empleado> vsEmpleado) { this.vsEmpleado = vsEmpleado; }
    public void setUnVehiculo(Vehiculo unVehiculo) { this.unVehiculo = unVehiculo; }
    public void setUnaOrdenTrabajo(OrdenTrabajo unaOrdenTrabajo) { this.unaOrdenTrabajo = unaOrdenTrabajo; }
    public void setHoraInicio(Date horaInicio) { this.horaInicio = horaInicio; }
    public void setBorrado (boolean borrado) {this.borrado = borrado;}
    public void setRealizado (boolean realizado) {this.realizado = realizado;}
    public void setUnEstado(Estado unEstado) { this.unEstado = unEstado; }
    public void setUnNivelSeveridad(NivelSeveridad unNivelSeveridad) { this.unNivelSeveridad = unNivelSeveridad; }
    public void setDescrip(String descrip) { this.descrip = descrip; }
    
    public String toString() {
        return "[Codigo: "+this.getCodigo()+"] \n[Fecha: "+this.getFecha()
                + "] \n[Duración aprox.: "+this.getDuracionAprox()+"] \n[Hora: "+this.getHoraInicio()+"]";
    }
    
    public Turno() { }

    public Turno( Vehiculo veh, Cliente cli, long codigo, Date fecha, String des, 
            Date duracionAprox, Date horaInicio, Estado est, NivelSeveridad nivS, OrdenTrabajo orden) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.duracionAprox = duracionAprox;
        this.horaInicio = horaInicio;
        this.unCliente = cli;
        this.unVehiculo = veh;
        this.unaOrdenTrabajo = orden;
        this.vsEmpleado = new LinkedList<Empleado>();
        this.borrado = false;
        this.realizado = false;
        this.descrip = des;
        this.unEstado = est;
        this.unNivelSeveridad = nivS;
    }
    
        //En memoria (sin persistencia)    
    private static LinkedList<Turno> turnos = new LinkedList<Turno>();
    //Metodos en memoria
    public Turno buscarTurno(long codigo){
        Turno tu, ret=null;
        if (!turnos.isEmpty()) { 
            Iterator<Turno> it = turnos.iterator();
            while(it.hasNext()&& ret==null){
                tu= it.next();
                if (tu.getCodigo()==codigo){
                    ret=tu;
                }
            }
        }        
        return ret;
    }
    public Turno creaTurno(Vehiculo veh, Cliente cli, long codigo, Date fecha, String des, 
            Date duracionAprox, Date horaInicio, Estado est, NivelSeveridad nivS, OrdenTrabajo orden){
        Turno ret = buscarTurno(codigo);
        if (ret==null){
            ret=new Turno(veh, cli, codigo, fecha, des, duracionAprox, horaInicio, est, nivS, orden);
            turnos.add(ret);
        }else{
            ret=null; 
        }
        return ret;
    }    
    public Turno editaTurno(Vehiculo veh, Cliente cli, long codigo, Date fecha, String des, 
            Date duracionAprox, Date horaInicio, Estado est, NivelSeveridad nivS, OrdenTrabajo orden,
            LinkedList<Empleado> emp, boolean listo, boolean ok){
        Turno ret = buscarTurno( codigo);
        this.setBorrado(ok);
        this.setCodigo(codigo);
        this.setDescrip(des);
        this.setDuracionAprox(duracionAprox);
        this.setFecha(fecha);
        this.setHoraInicio(horaInicio);
        this.setRealizado(listo);
        this.setUnCliente(cli);
        this.setUnEstado(est);
        this.setUnNivelSeveridad(nivS);
        this.setUnVehiculo(veh);
        this.setUnaOrdenTrabajo(orden);
        this.setVsEmpleado(emp);
        if (ret!=null){
            turnos.removeFirstOccurrence(ret);
            ret = this;
            turnos.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaTurno(long codigo){
        Turno ret = buscarTurno (codigo);
        if (ret!=null){
            turnos.removeFirstOccurrence(ret);
        }
    }
    public LinkedList<Turno> darTurnos(){
        return turnos;
    }
}
