package LogicaDeNegocios;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Proveedor implements Serializable{
    @Id
    private long dni;
    @Basic
    private String nombre;
    @Basic
    private long telefono;
    @Basic
    private String cuit;
    @Basic
    private String responsabilidadFiscal;
    @Basic
    private String eMail;
    @Basic
    private String tiempoEntrega;
    @Basic
    private boolean borrado;
    
    //Relaciones
        //Autoparte
    @ManyToMany
    private List<GrupoParte> vsGrupoParte;
        //Localidad
    @ManyToOne
    private Localidad unaLocalidad;

    //SETS
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTelefono(long telefono) { this.telefono = telefono; }
    public void setCuit(String cuit) { this.cuit = cuit; }
    public void setDni(long dni) { this.dni = dni; }
    public void setResponsabilidadFiscal(String responsabilidadFiscal) { this.responsabilidadFiscal = responsabilidadFiscal; }
    public void seteMail(String eMail) { this.eMail = eMail; }
    public void setTiempoEntrega(String tiempoEntrega) { this.tiempoEntrega = tiempoEntrega; }
    public void setBorrado(boolean borrado) { this.borrado = borrado; }
    public void setVsGrupoParte(List<GrupoParte> vsGrupoParte) { this.vsGrupoParte = vsGrupoParte; }
    public void setUnaLocalidad(Localidad unaLocalidad) { this.unaLocalidad = unaLocalidad; }
    
    //GETS
    public String getNombre() { return this.nombre; }
    public long getTelefono() { return this.telefono; }
    public String getCuit() { return this.cuit; }
    public long getDni() { return this.dni; }
    public String getResponsabilidadFiscal() { return this.responsabilidadFiscal; }
    public String geteMail() { return this.eMail; }
    public String getTiempoEntrega() { return this.tiempoEntrega; }
    public boolean getBorrado(){ return this.borrado; }
    public List<GrupoParte> getVsGrupoParte() { return vsGrupoParte; }
    public Localidad getUnaLocalidad() { return unaLocalidad; }
        
    public String toString() {
        return "[Nombre: "+this.getNombre()+"] \n" + "[Teléfono: "+this.getTelefono()+ "\n[DNI: "+this.getDni()+"] "
                + "\n[CUIT: "+this.getCuit()+"] \n[Responsabilidad Fiscal: "+this.getResponsabilidadFiscal()+"] "
                + "\n[E-mail: "+this.geteMail()+"] \n[Tiempo de entrega aproximado: "+this.getTiempoEntrega()
                + "\n[Borrado: "+this.getBorrado()+"]";
    }

    public Proveedor() { }

    public Proveedor(Localidad unaLoc, String nombre, long telefono, String cuit, long dni, 
            String resp, String eMail) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.cuit = cuit;
        this.dni = dni;
        this.responsabilidadFiscal = resp;
        this.eMail = eMail;
        this.tiempoEntrega = "";
        this.borrado = false;
        this.vsGrupoParte = new LinkedList<GrupoParte>();
        this.unaLocalidad = unaLoc;
    } 
    
        //En memoria (sin persistencia)    
    private static LinkedList<Proveedor> provs = new LinkedList<Proveedor>();
    //Metodos en memoria
    public Proveedor buscarProveedor(long dni){
        Proveedor pro, ret=null;
        if (!provs.isEmpty()) { 
            Iterator<Proveedor> it = provs.iterator();
            while(it.hasNext()&& ret==null){
                pro= it.next();
                if (pro.getDni()==dni){
                    ret=pro;
                }
            }
        }        
        return ret;
    }
    public Proveedor creaProveedor(Localidad unaLoc, String nombre, long telefono, String cuit, long dni, 
            String resp, String eMail){
        Proveedor ret = buscarProveedor( dni);
        if (ret==null){
            ret=new Proveedor(unaLoc, nombre, telefono, cuit, dni, resp, eMail);
            provs.add(ret);
        }else{
            ret=null; 
        }
        return ret;
    }    
    public Proveedor editaProveedor(String nombre, long telefono, String cuit, long dni, 
            String resp, String eMail,String tiempo, LinkedList<GrupoParte> gp, Localidad loc, boolean ok){
        Proveedor ret = buscarProveedor( dni);
        this.setNombre(nombre);
        this.setResponsabilidadFiscal(resp);
        this.seteMail(eMail);
        this.setVsGrupoParte(gp);
        this.setTiempoEntrega(tiempo);
        this.setDni(dni);
        this.setTelefono(telefono);
        this.setCuit(cuit);
        this.setUnaLocalidad(loc);
        this.setBorrado(ok);
        if (ret!=null){
            provs.removeFirstOccurrence(ret);
            ret = this;
            provs.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaProveedor(long dni){
        Proveedor ret = buscarProveedor (dni);
        if (ret!=null){
            provs.removeFirstOccurrence(ret);
        }
    }
    public LinkedList<Proveedor> darProveedors(){
        return provs;
    }
}
