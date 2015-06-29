package LogicaDeNegocios;

import java.io.Serializable;
import javax.persistence.Temporal;
import java.util.Date;
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
}