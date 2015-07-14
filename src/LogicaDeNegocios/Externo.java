package LogicaDeNegocios;

import java.util.Date;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import javax.persistence.*;

@Entity
public class Externo extends Pedido implements Serializable{
        
    //Relaciones
        //NivelImportancia
    @OneToOne
    private NivelImportancia unNivelImportancia;
        //Mecanico
    @OneToOne
    private Mecanico unMecanico;
        //AtencionPublico
    @ManyToOne
    private AtencionPublico remitente;
        //Proveedor
    @OneToOne
    private Proveedor destinatario;
    
    //SETS  
    public void setRemitente(AtencionPublico remitente) { this.remitente = remitente; }
    public void setDestinatario(Proveedor destinatario) { this.destinatario = destinatario; }
    public void setUnNivelImportancia(NivelImportancia unNivelImportancia) { this.unNivelImportancia = unNivelImportancia; }
    public void setUnMecanico(Mecanico unMecanico) { this.unMecanico = unMecanico; }

    //GETS  
    public AtencionPublico getRemitente() { return this.remitente; }
    public Proveedor getDestinatario() { return this.destinatario; }
    public Mecanico getUnMecanico() { return unMecanico; }
    public NivelImportancia getUnNivelImportancia() { return unNivelImportancia; }
    
    public String toString() {
        return "[Remitente: "+this.getRemitente()+"] \n[Destinatario: "+this.getDestinatario()+"]";
    }

    public Externo() { }

    public Externo(Mecanico mec, NivelImportancia niv, AtencionPublico remitente, Proveedor destinatario, 
            Vehiculo unVeh, Autoparte unaAut, long codPedido, Date fecha, int cantidad) {
        super(unVeh, unaAut, codPedido, fecha, cantidad);
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.unMecanico = mec;
        this.unNivelImportancia = niv;
    }
    
        //En memoria (sin persistencia)        
    //Metodos en memoria
    private static LinkedList<Externo> exs = new LinkedList<Externo>();
    
    public Externo buscarExterno(long codPedido){
        Externo ex, ret=null;
        if (!exs.isEmpty()) { 
            Iterator<Externo> it = exs.iterator();
            while(it.hasNext()&& ret==null){
                ex= it.next();
                if (ex.getCodPedido()==codPedido){
                    ret=ex;
                }
            }
        }        
        return ret;
    }
    public Externo creaExterno(Mecanico mec, NivelImportancia niv, AtencionPublico remitente, Proveedor destinatario, 
            Vehiculo unVeh, Autoparte unaAut, long codPedido, Date fecha, int cantidad){
        Externo ret;
        if (super.buscarCodPedido(codPedido)<0){
            ret = new Externo(mec, niv, remitente, destinatario, unVeh, unaAut, codPedido, fecha, cantidad);
            exs.add(ret);
            super.agregaPedido(codPedido);
        }else{
            ret=null; 
        }
        return ret;
    }
    public Externo editaExterno(Mecanico mec, NivelImportancia niv, AtencionPublico remitente, Proveedor destinatario, 
            Vehiculo unVeh, Autoparte unaAut, long codPedido, Date fecha, int cantidad, boolean borrado, boolean resuelto){
        Externo ret = buscarExterno(codPedido);
        this.setBorrado(borrado);
        this.setCantidad(cantidad);
        this.setCodPedido(codPedido);
        this.setDestinatario(destinatario);
        this.setFecha(fecha);
        this.setRemitente(remitente);
        this.setResuelto(resuelto);
        this.setUnMecanico(mec);
        this.setUnNivelImportancia(niv);
        this.setUnVehiculo(unVeh);
        this.setUnaAutoparte(unaAut);
        if (ret!=null){
            exs.removeFirstOccurrence(ret);
            ret = this;
            exs.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaExterno(long codPedido){
        Externo ret = buscarExterno (codPedido);
        if (ret!=null){
            super.eliminaPedido(codPedido);
            exs.removeFirstOccurrence(ret);
        }
    }
    public LinkedList<Externo> darExterno(){
        return exs;
    }
}
