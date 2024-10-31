package co.unicauca.edu.conferencia_microservicio.Controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.unicauca.edu.conferencia_microservicio.fachadaServicios.DTO.ConferenciaDTO;
import co.unicauca.edu.conferencia_microservicio.fachadaServicios.servicios.IServicioConferencia;

@RestController
@RequestMapping("/api")
public class ControladorConferencia {
  @Autowired
  private IServicioConferencia servicioConferencia;
  @Autowired

  @GetMapping("/conferencias")
  public List<ConferenciaDTO> listarConferencia(){
    return servicioConferencia.getConferencias();
  } 
  @PostMapping("/registrarConferencia")
  public ResponseEntity<ConferenciaDTO> registrarConferencia(@RequestBody ConferenciaDTO conferenciaDTO) {
 
    ConferenciaDTO conferenciaRegistrada = servicioConferencia.setConferencia(conferenciaDTO);
    return ResponseEntity.ok(conferenciaRegistrada);
  }
  @GetMapping("/conferencia/{prmId}")
  public boolean consultarConferencia(@PathVariable Integer prmId){
    return servicioConferencia.existeConferencia(prmId);
  }
}
