package co.unicauca.edu.conferencia_microservicio.AccesoADatos.Repositorio;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import co.unicauca.edu.conferencia_microservicio.AccesoADatos.modelos.Conferencia;

public interface IRepositorioConferencia extends JpaRepository<Conferencia, Integer> {
   
}
