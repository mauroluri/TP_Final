package LogicaDeNegocios;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Interno extends Pedido implements Serializable {
    @Basic
    private boolean aprobado;
    
    //Relaciones
    /*    //Encargado            PROBLEMA TABLAS CON VARIOS PK     ??
    @ManyToOne
    private Encargado unEncargado;*/
        //Mecanico
    @ManyToOne
    private Mecanico unMecanico;

    //SETS  
    public void setAprobado(boolean aprobado) { this.aprobado = aprobado; }
    public void setUnMecanico(Mecanico unMecanico) { this.unMecanico = unMecanico; }
    //public void setUnEncargado(Encargado unEncargado) { this.unEncargado = unEncargado; }
    
    //GETS  
    public boolean getAprobado() { return this.aprobado; }
    //public Encargado getUnEncargado() { return unEncargado; }
    public Mecanico getUnMecanico() { return unMecanico; }
   
    public String toString() {
        return "[Aprobado: "+this.getAprobado()+"]";
    }

    public Interno() { }

    public Interno(/*Encargado unEnc,*/ Mecanico unMec, Vehiculo unVeh, 
            Autoparte unaAut, long codPedido, Date fecha, int cantidad) {
        super(unVeh, unaAut, codPedido, fecha, cantidad);
        this.aprobado = false;
        //this.unEncargado = unEnc;
        this.unMecanico = unMec;
    }
    
        //En memoria (sin persistencia)        
    //Metodos en memoria
    private static List<Interno> ints = new LinkedList<Interno>();
    
    public Interno buscarInterno(long codPedido){
        Interno in, ret=null;
        if (!ints.isEmpty()) { 
            Iterator<Interno> it = ints.iterator();
            while(it.hasNext()&& ret==null){
                in= it.next();
                if (in.getCodPedido()==codPedido){
                    ret=in;
                }
            }
        }        
        return ret;
    }
    public Interno creaInterno(Mecanico unMec, Vehiculo unVeh, Autoparte unaAut, long codPedido, Date fecha,
            int cantidad){
        Interno ret;
        if (super.buscarCodPedido(codPedido)<0){
            ret = new Interno(unMec, unVeh, unaAut, codPedido, fecha, cantidad);
            ints.add(ret);
            super.agregaPedido(codPedido);
        }else{
            ret=null; 
        }
        return ret;
    }
    public Interno editaInterno(Mecanico unMec, Vehiculo unVeh, Autoparte unaAut, long codPedido, Date fecha,
            int cantidad,boolean aprobado, boolean borrado, boolean resuelto){
        Interno ret = buscarInterno(codPedido);
        this.setAprobado(aprobado);
        this.setBorrado(borrado);
        this.setCantidad(cantidad);
        this.setCodPedido(codPedido);
        this.setFecha(fecha);
        this.setResuelto(resuelto);
        this.setUnMecanico(unMec);
        this.setUnVehiculo(unVeh);
        this.setUnaAutoparte(unaAut);
        if (ret!=null){
            ints.remove(ret);
            ret = this;
            ints.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaInterno(long codPedido){
        Interno ret = buscarInterno (codPedido);
        if (ret!=null){
            super.eliminaPedido(codPedido);
            ints.remove(ret);
        }
    }
    public List<Interno> darInterno(){
        return ints;
    }
    
}