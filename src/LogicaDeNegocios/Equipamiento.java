package LogicaDeNegocios;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import javax.persistence.*;

@Entity
public class Equipamiento extends Autoparte implements Serializable{

    public Equipamiento() { }

    public Equipamiento(int codParte, String descripcion, String caracteristicas, float precio, int impuesto, 
            boolean recambio, long stock) {
        super(codParte, descripcion, caracteristicas, precio, impuesto, recambio, stock); }
    
    //En memoria (sin persistencia)        
    //Metodos en memoria
    private static LinkedList<Equipamiento> eqps = new LinkedList<Equipamiento>();
    
    public Equipamiento buscarEquipamiento(int codParte){
        Equipamiento eq, ret=null;
        if (!eqps.isEmpty()) { 
            Iterator<Equipamiento> it = eqps.iterator();
            while(it.hasNext()&& ret==null){
                eq= it.next();
                if (eq.getCodParte()==codParte){
                    ret=eq;
                }
            }
        }        
        return ret;
    }
    public Equipamiento creaEquipamiento(int codParte, String descripcion, String caracteristicas, float precio, int impuesto, 
            boolean recambio, long stock){
        Equipamiento ret;
        if (super.buscarCodParte(codParte)<0){
            ret = new Equipamiento(codParte, descripcion, caracteristicas, precio, impuesto, recambio, stock);
            eqps.add(ret);
            super.agregaAutoparte(codParte);
        }else{
            ret=null; 
        }
        return ret;
    }
    public Equipamiento editaEquipamiento(int codParte, String descripcion, String caracteristicas, float precio, int impuesto, 
            boolean recambio, long stock, LinkedList<Item> it, LinkedList<Modelo> mo, LinkedList<Vehiculo> ve, boolean ok){
        Equipamiento ret = buscarEquipamiento(codParte);
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
            eqps.removeFirstOccurrence(ret);
            ret = this;
            eqps.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaEquipamiento(int codParte){
        Equipamiento ret = buscarEquipamiento (codParte);
        if (ret!=null){
            super.eliminaAutoparte(codParte);
            eqps.removeFirstOccurrence(ret);
        }
    }
    public LinkedList<Equipamiento> darEquipamiento(){
        return eqps;
    }
}