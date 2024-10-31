package co.unicauca.edu.conferencia_microservicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import co.unicauca.edu.conferencia_microservicio.App.Inicializador;

@SpringBootApplication
public class ConferenciaMicroservicioApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context= SpringApplication.run(ConferenciaMicroservicioApplication.class, args);
		Inicializador inicializador = context.getBean(Inicializador.class);
        inicializador.run();

	}

}