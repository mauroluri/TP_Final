package LogicaDeNegocios;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Temporal;
import java.util.Date;

@Entity
public abstract class Pedido implements Serializable{
    @Id
    private long codPedido;
    @Basic
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    @Basic
    private int cantidad;
    @Basic
    private boolean resuelto;
    @Basic
    private boolean borrado;
    
    //Relaciones
        //Vehiculo
    @OneToOne
    private Vehiculo unVehiculo;
        //Pedido
    @OneToOne
    private Autoparte unaAutoparte;

    //GETS    
    public long getCodPedido() { return this.codPedido; }
    public Date getFecha() { return this.fecha; }
    public int getCantidad() { return this.cantidad; }
    public boolean getResuelto() { return this.resuelto; }
    public boolean getBorrado() { return this.borrado; }
    public Autoparte getUnaAutoparte() { return unaAutoparte; }
    public Vehiculo getUnVehiculo() { return unVehiculo; }

    //SETS
    public void setCodPedido(long codPedido) { this.codPedido = codPedido; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setResuelto(boolean resuelto){ this.resuelto = resuelto; }
    public void setBorrado(boolean borrado) { this.borrado = borrado; }
    public void setUnVehiculo(Vehiculo unVehiculo) { this.unVehiculo = unVehiculo; }
    public void setUnaAutoparte(Autoparte unaAutoparte) { this.unaAutoparte = unaAutoparte; }
    
    
    public Pedido() { }

    public Pedido(Vehiculo unVeh, Autoparte unaAut, long codPedido, Date fecha, int cantidad) {
        this.codPedido = codPedido;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.resuelto = false;
        this.borrado = false;
        this.unVehiculo = unVeh;
        this.unaAutoparte = unaAut;
    }
    
    
        //En memoria (sin persistencia)    
    private static long[] pedidos;
    //Metodos en memoria
    public int buscarCodPedido(long codPedido){
        int res=-1;
        if (pedidos.length>0) {
            for (int i=0;i<pedidos.length;i++){
                if (pedidos[i]==codPedido){
                    res=i;
                }
            }
        }        
        return res;
    }
    public void agregaPedido(long codPedido){
        pedidos[pedidos.length]= codPedido;
    }
    public void eliminaPedido(long codPedido){
        for (int i=0;i<pedidos.length;i++){
            if (pedidos[i]==codPedido){
                pedidos[i]=pedidos[i+1];
            }
        } 
    }
    public long[] darPedidos(){
        return pedidos;
    }
}
