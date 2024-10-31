package co.unicauca.edu.conferencia_microservicio.Controladores;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConferenciaCreadaEvent implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private int cantidadMaxArticulos;
    
    public ConferenciaCreadaEvent(int id, String nombre, int cantidadMaxArticulos){
        this.id=id;
        this.nombre=nombre;
        this.cantidadMaxArticulos=cantidadMaxArticulos;
    }
}
