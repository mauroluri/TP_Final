package LogicaDeNegocios;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Cliente implements Serializable{
    @Id
    private long dni;
    @Basic
    private String nombre;
    @Basic
    private long telefono;
    @Basic
    private String email;
    @Basic
    private String cuit;
    @Basic
    private int altura;
    @Basic
    private boolean borrado;
    @Basic
    private String pass;
    
    //Relaciones
        //Localidad
    @ManyToOne
    private Localidad unaLocalidad;
        //Calle
    @ManyToOne
    private Calle unaCalle;
        //Vehiculo
    @OneToMany
    private List<Vehiculo> vsVehiculo;
        //OrdenTrabajo
    @OneToMany
    private List<OrdenTrabajo> vsOrdenTrabajo;
        //Turno
    @OneToMany
    private List<Turno> vsTurno;
    
    //SETS
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDni(long dni) { this.dni = dni; }
    public void setTelefono(long telefono) { this.telefono = telefono; }
    public void setEmail(String email) { this.email = email; }
    public void setCuit(String cuit) { this.cuit = cuit; }
    public void setAltura(int altura) { this.altura = altura; }
    public void setUnaLocalidad(Localidad localidad) { this.unaLocalidad = localidad; }
    public void setBorrado (boolean borrado) {this.borrado = borrado;}
    public void setUnaCalle(Calle unaCalle) { this.unaCalle = unaCalle; }
    public void setVsOrdenTrabajo(List<OrdenTrabajo> vsOrdenTrabajo) { this.vsOrdenTrabajo = vsOrdenTrabajo; }
    public void setVsTurno(List<Turno> vsTurno) { this.vsTurno = vsTurno; }
    public void setVsVehiculo(List<Vehiculo> vsVehiculo) { this.vsVehiculo = vsVehiculo; }
    public void setPass(String pass) { this.pass = pass; }
           
    //GETS
    public String getNombre() { return this.nombre; }
    public long getDni() { return this.dni; }
    public long getTelefono() { return this.telefono; }
    public String getEmail() { return this.email; }
    public String getCuit() { return this.cuit; }
    public int getAltura() { return this.altura; }
    public Localidad getUnaLocalidad() { return this.unaLocalidad; }
    public boolean getBorrado() {return this.borrado; }
    public Calle getUnaCalle() { return unaCalle; }
    public List<OrdenTrabajo> getVsOrdenTrabajo() { return vsOrdenTrabajo; }
    public List<Turno> getVsTurno() { return vsTurno; }
    public List<Vehiculo> getVsVehiculo() { return vsVehiculo; }
    public String getPass() { return pass; }
    
    public String toString() {
        return "[Nombre: "+this.getNombre()+"] \n[DNI: "+this.getDni()+"] \n"
                + "[Teléfono: "+this.getTelefono()+"] \n[E-mail: "+this.getEmail()+"] "
                + "\n[CUIT: "+this.getCuit()+"] \n[Altura: "+this.getAltura()+"] "
                + "\n[Localidad: "+this.getUnaLocalidad().getNombre()+"] "
                + "\n[Borrado: "+this.getBorrado()+"]";
    }
    
    //CONSTRUCTORES
    public Cliente (){}
    public Cliente(String nombre, long dni, long telefono, String email, String cuit, int altura, 
            Localidad localidad, Calle calle){
        creaCliente(nombre, dni, telefono, email, cuit, altura, localidad, calle);
    }
    
    //En memoria (sin persistencia)    
    private static LinkedList<Cliente> clientes = new LinkedList<Cliente>();
//    private void setClientes(Cliente cli){
//        clientes.add(cli);
//    }
//    private LinkedList<Cliente> getClientes(){
//        return clientes;
//    }
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
            this.setNombre(nombre);
            this.setDni(dni);
            this.setTelefono(telefono);
            this.setEmail(email);
            this.setCuit(cuit);
            this.setAltura(altura);
            this.setUnaLocalidad(localidad);
            this.setUnaCalle(calle);
            ret=this;
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
