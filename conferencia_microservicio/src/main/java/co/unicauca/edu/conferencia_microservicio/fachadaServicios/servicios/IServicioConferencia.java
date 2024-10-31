package co.unicauca.edu.conferencia_microservicio.fachadaServicios.servicios;
import java.util.List;

import co.unicauca.edu.conferencia_microservicio.fachadaServicios.DTO.ConferenciaDTO;
public interface IServicioConferencia {
    public List<ConferenciaDTO> getConferencias();
    public ConferenciaDTO setConferencia(ConferenciaDTO prmConferencia);
    public boolean existeConferencia(int prmId);
    
}
