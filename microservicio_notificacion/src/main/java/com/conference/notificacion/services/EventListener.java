/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.notificacion.services;

import com.conference.microkernel.common.entities.BasicEmailBuilder;
import com.conference.microkernel.common.entities.Email;
import com.conference.microkernel.common.entities.EmailDirector;
import com.conference.notificacion.domain.ConferenciaCreadaEvento;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ashlee Campaz
 */
@Component
public class EventListener {
    @Autowired
    EmailService emailService;
    
    @RabbitListener(queues = "conferencia-creada")
    public void handleConferenciaCreada(String conferenciaCreadaEvento) {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(conferenciaCreadaEvento);
        ConferenciaCreadaEvento evento = new ConferenciaCreadaEvento();
        try {
             evento = objectMapper.readValue(conferenciaCreadaEvento, ConferenciaCreadaEvento.class);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(EventListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<String> destinatario = new ArrayList();
        destinatario.add(evento.getOrganizator_email());
       /**Email e = new Email();
        e.setAsunto("Conferencia enviada");
        e.setCuerpo(String.format("Cordial saludo.\n\n Señor(a) %s %s, la conferencia %s fue creada exitosamente. \n\nNuestros mejores deseos,\nEquipo EasyConference", evento.getOrganizator_name(), evento.getOrganizator_lastName(),evento.getConference_name()));
        e.setDestinatarios(destinatario);
        e.setRemitente("easy.conference.prueba@gmail.com");
        e.setMethod("sjm");*/
       
       
        EmailDirector ed = new EmailDirector();
        BasicEmailBuilder builder = new BasicEmailBuilder();
        ed.setEmailBuilder(builder);
        ed.construirEmail("easy.conference.prueba@gmail.com", 
                String.format("Cordial saludo.\n\nSeñor(a) %s %s la conferencia \"%s\" fue creada exitosamente. \n\nNuestros mejores deseos,\nEquipo EasyConference", 
                        evento.getOrganizator_name(), 
                        evento.getOrganizator_lastName(),
                        evento.getConference_name()), 
                "Conferencia enviada", destinatario);
        Email e = ed.getEmail(); 
        try {
            emailService.EnviarEmail(e);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
