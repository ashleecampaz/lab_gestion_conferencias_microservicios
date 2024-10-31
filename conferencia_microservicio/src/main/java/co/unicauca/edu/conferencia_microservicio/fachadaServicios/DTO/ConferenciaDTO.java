package co.unicauca.edu.conferencia_microservicio.fachadaServicios.DTO;
import java.util.ArrayList;
import java.util.List;

import co.unicauca.edu.conferencia_microservicio.AccesoADatos.modelos.Articulo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConferenciaDTO {
    int id;
    String nombre;
    int cantidadMaxArticulos;
    private List<Articulo> articuloList= new ArrayList<>();
    public ConferenciaDTO(){

    }
}
