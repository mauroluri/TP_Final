package LogicaDeNegocios;

import java.io.Serializable;
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
}
