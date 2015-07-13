package LogicaDeNegocios;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
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
    
                //En memoria (sin persistencia)    
    private static LinkedList<NivelImportancia> nivs = new LinkedList<NivelImportancia>();

    //Metodos en memoria
    public NivelImportancia buscarNivelImportancia(String estado){
        NivelImportancia nv, ret=null;
        if (!nivs.isEmpty()) { 
            Iterator<NivelImportancia> it = nivs.iterator();
            while(it.hasNext()&& ret==null){
                nv= it.next();
                if (nv.getEstado().equalsIgnoreCase(estado)){
                    ret=nv;
                }
            }
        }        
        return ret;
    }
    public NivelImportancia creaNivelImportancia (String estado){
        NivelImportancia ret = buscarNivelImportancia(estado);
        if (ret==null){
            ret=new NivelImportancia(estado);
            nivs.add(ret);
        }else{
            ret=null; 
        }
        return ret;
    }    
    public NivelImportancia editaNivelImportancia(String estado){
        NivelImportancia ret = buscarNivelImportancia( estado);
        this.setEstado(estado);
        if (ret!=null){
            nivs.removeFirstOccurrence(ret);
            ret = this;
            nivs.add(ret);
        }else{
            ret = this;
        }
        return ret;
    }
    public void eliminaNivelImportancia(String estado){
        NivelImportancia ret = buscarNivelImportancia (estado);
        if (ret!=null){
            nivs.removeFirstOccurrence(ret);
        }
    }
    public LinkedList<NivelImportancia> darNivelImportancia(){
        return nivs;
    }
}
