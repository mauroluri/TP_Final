package LogicaDeNegocios;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import javax.persistence.*;

@Entity
public class Repuesto extends Autoparte implements Serializable{

    public Repuesto() { }

    public Repuesto(int codParte, String descripcion, String caracteristicas, float precio, int impuesto, 
            boolean recambio, long stock) {
        super(codParte, descripcion, caracteristicas, precio, impuesto, recambio, stock); }
     
    //En memoria (sin persistencia)        
    //Metodos en memoria
    private static LinkedList<Repuesto> reps = new LinkedList<Repuesto>();
    
    public Repuesto buscarRepuesto(int codParte){
        Repuesto re, ret=null;
        if (!reps.isEmpty()) { 
            Iterator<Repuesto> it = reps.iterator();
            while(it.hasNext()&& ret==null){
                re= it.next();
                if (re.getCodParte()==codParte){
                    ret=re;
                }
            }
        }        
        return ret;
    }
    public Repuesto creaRepuesto(int codParte, String descripcion, String caracteristicas, float precio, int impuesto, 
            boolean recambio, long stock){
        Repuesto ret;
        if (super.buscarCodParte(codParte)<0){
            ret = new Repuesto(codParte, descripcion, caracteristicas, precio, impuesto, recambio, stock);
            reps.add(ret);
            super.agregaAutoparte(codParte);
        }else{
            ret=null; 
        }
        return ret;
    }
    public Repuesto editaRepuesto(int codParte, String descripcion, String caracteristicas, float precio, int impuesto, 
            boolean recambio, long stock, LinkedList<Item> it, LinkedList<Modelo> mo, LinkedList<Vehiculo> ve, boolean ok){
        Repuesto ret = buscarRepuesto(codParte);
        this.setBorrado(ok);
        this.setCaracteristicas(caracteristicas);
        this.setCodParte(codParte);
        this.setDescripcion(descripcion);
        this.setImpuesto(impuesto);
        this.setPrecio(precio);
        this.setRecambio(recambio);
        this.setStock(stock);
        this.setVsItem(it);
        this.setVsModelo(mo);
        this.setVsVehiculo(ve);
        if (ret!=null){
            reps.removeFirstOccurrence(ret);
            ret = this;
            reps.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaRepuesto(int codParte){
        Repuesto ret = buscarRepuesto (codParte);
        if (ret!=null){
            super.eliminaAutoparte(codParte);
            reps.removeFirstOccurrence(ret);
        }
    }
    public LinkedList<Repuesto> darRepuesto(){
        return reps;
    }
}