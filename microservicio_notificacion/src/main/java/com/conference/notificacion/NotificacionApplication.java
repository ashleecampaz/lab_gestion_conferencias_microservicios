package com.conference.notificacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NotificacionApplication {

	public static void main(String[] args) throws Exception {
                ConfigurableApplicationContext context= SpringApplication.run(NotificacionApplication.class, args);
		EmailPluginManager inicializador = context.getBean(EmailPluginManager.class);
                inicializador.run();
	}

}
