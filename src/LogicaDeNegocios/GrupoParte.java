package LogicaDeNegocios;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class GrupoParte implements Serializable{
    @Basic
    private String nombre;
    @Id
    private int codGrupo;
    
    //Relaciones
        //Vehiculo
    @OneToOne
    private Modelo unModelo;
        //Autoparte
    @OneToMany
    private List<Autoparte> vsAutoparte;
        //Proveedor
    @ManyToMany
    private List<Proveedor> vsProveedor;

    //SETS
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCodGrupo(int codGrupo) { this.codGrupo = codGrupo; }
    public void setUnModelo(Modelo unModelo) { this.unModelo = unModelo; }
    public void setVsAutoparte(List<Autoparte> vsAutoparte) { this.vsAutoparte = vsAutoparte; }
    public void setVsProveedor(List<Proveedor> vsProveedor) { this.vsProveedor = vsProveedor; }

    

    //GETS
    public String getNombre() { return this.nombre; }
    public int getCodGrupo() { return this.codGrupo; }
    public List<Autoparte> getVsAutoparte() { return vsAutoparte; }
    public Modelo getUnModelo() { return unModelo; }    
    public List<Proveedor> getVsProveedor() { return vsProveedor; }

    
    public String toString() {
        return "[Nombre: "+this.getNombre()+"] \n[codGrupo: "+this.getCodGrupo()+"]";
    }

    public GrupoParte() { }

    public GrupoParte(String nombre, int codGrupo, Modelo mod, LinkedList<Autoparte> parts) {
        this.nombre = nombre;
        this.codGrupo = codGrupo;
        this.unModelo = mod;
        this.vsAutoparte = parts;
        this.vsProveedor = new LinkedList<Proveedor>();
    }
    
    
    //En memoria (sin persistencia)    
    private static LinkedList<GrupoParte> grupos = new LinkedList<GrupoParte>();
    //Metodos en memoria
    public GrupoParte buscarGrupoParte(long codGrupo){
        GrupoParte gr, ret=null;
        if (!grupos.isEmpty()) { 
            Iterator<GrupoParte> it = grupos.iterator();
            while(it.hasNext()&& ret==null){
                gr= it.next();
                if (gr.getCodGrupo()==codGrupo){
                    ret=gr;
                }
            }
        }        
        return ret;
    }
    public GrupoParte creaGrupoParte(String nombre, int codGrupo, Modelo mod, LinkedList<Autoparte> parts){
        GrupoParte ret = buscarGrupoParte( codGrupo);
        if (ret==null){
            ret=new GrupoParte(nombre, codGrupo, mod, parts);
            grupos.add(ret);
        }else{
            ret=null; 
        }
        return ret;
    }    
    public GrupoParte editaGrupoParte(String nombre, int codGrupo, Modelo mod, LinkedList<Autoparte> parts, 
            LinkedList<Proveedor> provs){
        GrupoParte ret = buscarGrupoParte( codGrupo);
        this.setNombre(nombre);
        this.setCodGrupo(codGrupo);
        this.setUnModelo(mod);
        this.setVsAutoparte(parts);
        this.setVsProveedor(provs);
        if (ret!=null){
            grupos.removeFirstOccurrence(ret);
            ret = this;
            grupos.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaGrupoParte(long codGrupo){
        GrupoParte ret = buscarGrupoParte (codGrupo);
        if (ret!=null){
            grupos.removeFirstOccurrence(ret);
        }
    }
    public LinkedList<GrupoParte> darGrupoPartes(){
        return grupos;
    }
}