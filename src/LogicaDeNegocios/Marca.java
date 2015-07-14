package LogicaDeNegocios;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import javax.persistence.*;

@Entity
public class Marca implements Serializable {
    @Id
    private String nombre;

    //SETS
    public void setNombre(String nombre) { this.nombre = nombre; }

    //GETS
    public String getNombre() { return this.nombre; }
    
    public String toString() { return "[Nombre: "+this.getNombre()+"]"; }
    
    public Marca(){}
    
    public Marca(String nombre){
        this.nombre=nombre;
    }
    
       
            //En memoria (sin persistencia)    
    private static LinkedList<Marca> marcas = new LinkedList<Marca>();

    //Metodos en memoria
    public Marca buscarMarca(String nombre){
        Marca ma, ret=null;
        if (!marcas.isEmpty()) { 
            Iterator<Marca> it = marcas.iterator();
            while(it.hasNext()&& ret==null){
                ma= it.next();
                if (ma.getNombre().equalsIgnoreCase(nombre)){
                    ret=ma;
                }
            }
        }        
        return ret;
    }
    public Marca creaMarca (String nombre){
        Marca ret = buscarMarca(nombre);
        if (ret==null){
            ret=new Marca(nombre);
            marcas.add(ret);
        }else{
            ret=null; 
        }
        return ret;
    }    
    public Marca editaMarca(String nombre){
        Marca ret = buscarMarca( nombre);
        this.setNombre(nombre);
        if (ret!=null){
            marcas.removeFirstOccurrence(ret);
            ret = this;
            marcas.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaMarca(String nombre){
        Marca ret = buscarMarca (nombre);
        if (ret!=null){
            marcas.removeFirstOccurrence(ret);
        }
    }
    public LinkedList<Marca> darMarca(){
        return marcas;
    }
}



//Cliente
    public void crearCliente(String nombre, long dni, long telefono, String email, String cuit, int altura,
            Localidad localidad, Calle calle) throws PreexistingEntityException, Exception{
        Cliente miCliente = new Cliente();
        miCliente = miCliente.creaCliente(nombre, dni, telefono, email, cuit, altura, localidad, calle);
        if (miCliente!=null){
            miPersistencia.crearCliente(miCliente);
        }else{
            throw new PreexistingEntityException("");
        }
    }
    public void editarCliente(String nombre, long dni, long telefono, String email, String cuit, int altura, 
            Localidad localidad, Calle calle, String contra, LinkedList<Vehiculo> ve, LinkedList<OrdenTrabajo> or,
            LinkedList<Turno> tu, boolean ok) throws PreexistingEntityException, Exception{
        Cliente miCliente = new Cliente();
        miCliente = miCliente.editaCliente(nombre, dni, telefono, email, cuit, altura, localidad, calle,
        contra, ve, or, tu, ok);        
        this.miPersistencia.editarCliente(miCliente);}
    public void eliminarCliente(long dni) throws NonexistentEntityException{
        Cliente miCliente = new Cliente();
        miCliente.eliminaCliente(dni);
        this.miPersistencia.eliminarCliente(dni);}
    public Cliente dameUnCliente(long dni){
        Cliente miCliente = new Cliente();
        miCliente = miCliente.buscarCliente(dni);
        if (miCliente==null){        
            miCliente= this.miPersistencia.dameUnCliente(dni);
        }
        return miCliente;
    }
    public List<Cliente> dameClientes(){
        Cliente miCliente = new Cliente();
        List<Cliente> misClientes = miCliente.darClientes();
        if (misClientes.isEmpty()){
            misClientes = this.miPersistencia.dameClientes();
        }
        return misClientes;
    }