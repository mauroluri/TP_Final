package LogicaDeNegocios;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Diagnostico extends OrdenTrabajo implements Serializable{
    @Basic
    private int kilometraje;
    @Basic
    private boolean inicial;
    

    //SETS
    public void setKilometraje(int kilometraje) { this.kilometraje = kilometraje; }
    public void setInicial(boolean inicial) { this.inicial = inicial; }
    
    //GETS
    public int getKilometraje() { return this.kilometraje; }
    public boolean getInicial() { return inicial; }
    
    public String toString() { return "[Kilometraje: "+this.getKilometraje()+"]"; }
    
    public Diagnostico(){}
    
    public Diagnostico( Turno unTur, int codOrden, String descripcion, int kilometraje, boolean inicial){
        super(unTur, codOrden, descripcion);
        this.kilometraje=kilometraje;
        this.inicial = inicial;
    }
}
