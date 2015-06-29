package LogicaDeNegocios;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Ajuste extends OrdenTrabajo implements Serializable{
        
    public Ajuste(){}
    
    public Ajuste(Turno unTur, int codOrden, String descripcion){
        super(unTur, codOrden, descripcion);
        
    }
}
