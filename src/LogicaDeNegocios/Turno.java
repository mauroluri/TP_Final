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
    private static LinkedList<Cliente> clientes = new LinkedList<Cliente>();
    //Metodos en memoria
    public Cliente buscarCliente(long dni){
        Cliente cli, ret=null;
        if (!clientes.isEmpty()) { 
            Iterator<Cliente> it = clientes.iterator();
            while(it.hasNext()&& ret==null){
                cli= it.next();
                if (cli.getDni()==dni){
                    ret=cli;
                }
            }
        }        
        return ret;
    }
    public Cliente creaCliente(String nombre, long dni, long telefono, String email, String cuit, int altura, 
            Localidad localidad, Calle calle){
        Cliente ret = buscarCliente( dni);
        if (ret==null){
            ret=new Cliente(nombre, dni, telefono, email, cuit, altura, localidad, calle);
            clientes.add(ret);
        }else{
            ret=null; 
        }
        return ret;
    }    
    public Cliente editaCliente(String nombre, long dni, long telefono, String email, String cuit,
            int altura, Localidad localidad, Calle calle, String contra, LinkedList<Vehiculo> ve, LinkedList<OrdenTrabajo> or,
            LinkedList<Turno> tu, boolean ok){
        Cliente ret = buscarCliente( dni);
        this.setNombre(nombre);
        this.setDni(dni);
        this.setTelefono(telefono);
        this.setEmail(email);
        this.setAltura(altura);
        this.setCuit(cuit);
        this.setUnaLocalidad(localidad);
        this.setUnaCalle(calle);
        this.setPass(cuit);
        this.setVsOrdenTrabajo(or);
        this.setVsTurno(tu);
        this.setVsVehiculo(ve);
        this.setBorrado(ok);
        if (ret!=null){
            clientes.removeFirstOccurrence(ret);
            ret = this;
            clientes.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaCliente(long dni){
        Cliente ret = buscarCliente (dni);
        if (ret!=null){
            clientes.removeFirstOccurrence(ret);
        }
    }
    public LinkedList<Cliente> darClientes(){
        return clientes;
    }
}
