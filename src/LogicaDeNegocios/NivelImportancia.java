package LogicaDeNegocios;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class NivelImportancia implements Serializable {
    @Id
    private String estado;

    public void setEstado(String estado) { this.estado = estado; }

    public String getEstado() { return this.estado; }
    
    public String toString() { return "[Estado: "+this.getEstado()+"]"; }

    public NivelImportancia() { }

    public NivelImportancia(String estado) { this.estado = estado; }
}
