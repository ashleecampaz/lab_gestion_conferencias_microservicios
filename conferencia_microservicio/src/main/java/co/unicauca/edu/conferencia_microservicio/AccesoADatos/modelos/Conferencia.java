package co.unicauca.edu.conferencia_microservicio.AccesoADatos.modelos;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Conferencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    private int cantidadMaxArticulos;
    /**Se define la relacion uno a muchos */
    /**Cascade asegura que todas las operaciones de conferencia, afecten a articulo */
    /**FetchType.LAZI hará que los articulos solo se carguen cuando se intente acceder a ellos */
    @OneToMany(mappedBy = "conferencia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Articulo> articuloList= new ArrayList<>();
    
    public Conferencia(){

    }
}
