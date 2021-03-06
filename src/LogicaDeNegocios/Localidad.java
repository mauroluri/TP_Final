package LogicaDeNegocios;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Localidad implements Serializable {
    @Id
    private int codigo;
    @Basic
    private String nombre;
    @Basic
    private int codPost;
    
    //Relaciones
        //Provincia
    @ManyToOne
    private Provincia provincia;
        //Calle
    @ManyToMany
    private List<Calle> vsCalle;
        //Sucursal
    @OneToMany
    private List<Sucursal> vsSucursal;
        //Cliente
    @OneToMany
    private List<Cliente> vsCliente;
        //Proveedor
    @OneToMany
    private List<Proveedor> vsProveedor;
        //Empleado
    @OneToMany
    private List<Empleado> vsEmpleado;
    
    //SETS
    public void setCodigo(int codigo) { this.codigo = codigo; }
    public void setCodPost(int codPost) { this.codPost = codPost; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setProvincia(Provincia provincia) { this.provincia = provincia; }
    public void setVsCalle(List<Calle> vsCalle) { this.vsCalle = vsCalle; }
    public void setVsCliente(List<Cliente> vsCliente) { this.vsCliente = vsCliente; }
    public void setVsEmpleado(List<Empleado> vsEmpleado) { this.vsEmpleado = vsEmpleado; }
    public void setVsProveedor(List<Proveedor> vsProveedor) { this.vsProveedor = vsProveedor; }
    public void setVsSucursal(List<Sucursal> vsSucursal) { this.vsSucursal = vsSucursal; }
       
    //GETS
    public int getCodigo() { return this.codigo; }
    public int getCodPost() { return this.codPost; }
    public String getNombre() { return this.nombre; }
    public Provincia getProvincia() { return this.provincia; }
    public List<Calle> getVsCalle() { return vsCalle; }
    public List<Cliente> getVsCliente() { return vsCliente; }
    public List<Empleado> getVsEmpleado() { return vsEmpleado; }
    public List<Proveedor> getVsProveedor() { return vsProveedor; }
    public List<Sucursal> getVsSucursal() { return vsSucursal; }
    
    public Localidad() { }

    public Localidad(int codigo, String nombre,int codPost, Provincia provincia) {
        this.codigo = codigo;
        this.codPost = codPost;
        this.nombre = nombre;
        this.provincia = provincia;
        this.vsCalle = new LinkedList<Calle>();
        this.vsSucursal = new LinkedList<Sucursal>();
        this.vsCliente = new LinkedList<Cliente>();
        this.vsProveedor = new LinkedList<Proveedor>();
        this.vsEmpleado = new LinkedList<Empleado>();
    }
    
        //En memoria (sin persistencia)    
    private static List<Localidad> locs = new LinkedList<Localidad>();
    //Metodos en memoria
    public Localidad buscarLocalidad(int cod){
        Localidad cli, ret=null;
        if (!locs.isEmpty()) { 
            Iterator<Localidad> it = locs.iterator();
            while(it.hasNext()&& ret==null){
                cli= it.next();
                if (cli.getCodigo()==cod){
                    ret=cli;
                }
            }
        }        
        return ret;
    }
    public Localidad creaLocalidad(int codigo, String nombre,int codPost, Provincia provincia){
        Localidad ret = buscarLocalidad(codigo);
        if (ret==null){
            ret=new Localidad(codigo, nombre, codPost, provincia);
            locs.add(ret);
        }else{
            ret=null; 
        }
        return ret;
    }    
    public Localidad editaLocalidad(int cod, String nombre,int codPost, Provincia provincia, List<Calle> ca,
            List<Sucursal> suc, List<Cliente> cli, List<Proveedor> pro, List<Empleado> em,
            boolean ok){
        Localidad ret = buscarLocalidad( cod);
        this.setCodPost(codPost);
        this.setCodigo(cod);
        this.setNombre(nombre);
        this.setProvincia(provincia);
        this.setVsCalle(ca);
        this.setVsCliente(cli);
        this.setVsEmpleado(em);
        this.setVsProveedor(pro);
        this.setVsSucursal(suc);
        if (ret!=null){
            locs.remove(ret);
            ret = this;
            locs.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaLocalidad(int cod){
        Localidad ret = buscarLocalidad (cod);
        if (ret!=null){
            locs.remove(ret);
        }
    }
    public List<Localidad> darLocalidads(){
        return locs;
    }
}
