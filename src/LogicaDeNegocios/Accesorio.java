package LogicaDeNegocios;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Accesorio extends Autoparte implements Serializable{
    
    public Accesorio() { }

    public Accesorio(int codParte, String descripcion, String caracteristicas, float precio, int impuesto, 
            boolean recambio, long stock) {
        super(codParte, descripcion, caracteristicas, precio, impuesto, recambio, stock); }
    
    //En memoria (sin persistencia)        
    //Metodos en memoria
    private static List<Accesorio> accs = new LinkedList<Accesorio>();
    
    public Accesorio buscarAccesorio(int codParte){
        Accesorio at, ret=null;
        if (!accs.isEmpty()) { 
            Iterator<Accesorio> it = accs.iterator();
            while(it.hasNext()&& ret==null){
                at= it.next();
                if (at.getCodParte()==codParte){
                    ret=at;
                }
            }
        }        
        return ret;
    }
    public Accesorio creaAccesorio(int codParte, String descripcion, String caracteristicas, float precio, int impuesto, 
            boolean recambio, long stock){
        Accesorio ret;
        if (super.buscarCodParte(codParte)<0){
            ret = new Accesorio(codParte, descripcion, caracteristicas, precio, impuesto, recambio, stock);
            accs.add(ret);
            super.agregaAutoparte(codParte);
        }else{
            ret=null; 
        }
        return ret;
    }
    public Accesorio editaAccesorio(int codParte, String descripcion, String caracteristicas, float precio, int impuesto, 
            boolean recambio, long stock, List<Item> it, List<Modelo> mo, List<Vehiculo> ve, boolean ok){
        Accesorio ret = buscarAccesorio(codParte);
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
            accs.remove(ret);
            ret = this;
            accs.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaAccesorio(int codParte){
        Accesorio ret = buscarAccesorio (codParte);
        if (ret!=null){
            super.eliminaAutoparte(codParte);
            accs.remove(ret);
        }
    }
    public List<Accesorio> darAccesorio(){
        return accs;
    }
}
