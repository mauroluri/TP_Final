package LogicaDeNegocios;

import javax.persistence.Temporal;
import java.util.Date;
import java.io.Serializable;
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
}
