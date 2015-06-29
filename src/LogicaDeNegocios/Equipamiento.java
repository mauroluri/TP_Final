package LogicaDeNegocios;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Equipamiento extends Autoparte implements Serializable{

    public Equipamiento() { }

    public Equipamiento(int codParte, String descripcion, String caracteristicas, float precio, int impuesto, 
            boolean recambio, long stock) {
        super(codParte, descripcion, caracteristicas, precio, impuesto, recambio, stock); }
}