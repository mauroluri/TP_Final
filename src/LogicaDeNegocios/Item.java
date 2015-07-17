package LogicaDeNegocios;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Item implements Serializable{
    @Id
    private int cod;
    @Basic
    private boolean ok;
    
    //Relaciones
        //Autoparte
    @ManyToOne
    private Autoparte unaAutoparte;
        //Deposito
    @ManyToOne
    private Deposito unDeposito;
    
    //GETS
    public int getCod() { return this.cod; }
    public boolean getok() { return this.ok; }
    public Autoparte getUnaAutoparte() { return unaAutoparte; }
    public Deposito getUnDeposito() { return unDeposito; }
        
    //SETS
    public void setCod(int cod) { this.cod = cod; }
    public void setOk(boolean ok) { this.ok = ok; }
    public void setUnaAutoparte(Autoparte unaAutoparte) { this.unaAutoparte = unaAutoparte; }
    public void setUnDeposito(Deposito unDeposito) { this.unDeposito = unDeposito; }
        
    public String toString() {
        if(this.getok())
            return "[Codigo: "+this.getCod()+"] \n[El repuesto está en condiciones]";
        else
            return "[Codigo: "+this.getCod()+"] \n[El repuesto NO está en condiciones]";
    }
    
    public Item() { }

    public Item(Autoparte unaAut, int cod, boolean ok,Deposito unD) {
        this.cod = cod;
        this.ok = ok;
        this.unaAutoparte = unaAut;
        this.unDeposito = unD;
    }
    
        //En memoria (sin persistencia)    
    private static List<Item> items = new LinkedList<Item>();
    //Metodos en memoria
    public Item buscarItem(int cod){
        Item im, ret=null;
        if (!items.isEmpty()) { 
            Iterator<Item> it = items.iterator();
            while(it.hasNext()&& ret==null){
                im= it.next();
                if (im.getCod()==cod){
                    ret=im;
                }
            }
        }        
        return ret;
    }
    public Item creaItem(Autoparte unaAut, int cod, boolean ok,Deposito unD){
        Item ret = buscarItem( cod);
        if (ret==null){
            ret=new Item(unaAut, cod, ok, unD);
            items.add(ret);
        }else{
            ret=null; 
        }
        return ret;
    }    
    public Item editaItem(Autoparte unaAut, int cod, boolean ok,Deposito unD){
        Item ret = buscarItem( cod);
        this.setCod(cod);
        this.setOk(ok);
        this.setUnDeposito(unDeposito);
        this.setUnaAutoparte(unaAutoparte);
        if (ret!=null){
            items.remove(ret);
            ret = this;
            items.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaItem(int cod){
        Item ret = buscarItem (cod);
        if (ret!=null){
            items.remove(ret);
        }
    }
    public List<Item> darItems(){
        return items;
    }
}
