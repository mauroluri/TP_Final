package LogicaDeNegocios;

import javax.persistence.*;
import java.io.Serializable;

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
}
