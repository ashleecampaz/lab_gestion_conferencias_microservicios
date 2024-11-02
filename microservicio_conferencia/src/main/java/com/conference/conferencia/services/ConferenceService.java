/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.conferencia.services;

import com.conference.conferencia.access.ConferenciaRepository;
import com.conference.conferencia.access.UsuarioRepository;
import com.conference.conferencia.config.RabbitConfig;
import com.conference.conferencia.domain.Conferencia;
import com.conference.conferencia.domain.ConferenciaCreadaEvento;
import com.conference.conferencia.domain.Usuario;
import com.rabbitmq.client.Channel;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ashlee Campaz
 */
@Service
public class ConferenceService implements IConferenceService {
    @Autowired
    UsuarioRepository accesoUsuario;
    @Autowired
    ConferenciaRepository accesoConferencia;
    @Autowired
    Channel channel; 
    @Override
    public List<Conferencia> findAll() {
       List<Conferencia> conferencias = (List<Conferencia>) accesoConferencia.findAll();

       return conferencias; 
    }

    @Override
    public Conferencia findById(Long id) {
        return accesoConferencia.findById(id).orElse(null); 
    }

    @Override
    public Conferencia createConference(Conferencia con) {
       
        Usuario us = getOrganizator(con.getOrganizator_id());
        ConferenciaCreadaEvento evento = new ConferenciaCreadaEvento();
        evento.setConference_name(con.getName());
        evento.setOrganizator_email(us.getEmail());
        evento.setOrganizator_name(us.getName());
        evento.setOrganizator_lastName(us.getLastName());
         String msgjson = evento.toString();  
        try{
            channel.basicPublish("", RabbitConfig.getQUEUE_NAME(), null, msgjson.getBytes(StandardCharsets.UTF_8));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return accesoConferencia.save(con); 
    }

    @Override
    public Usuario getOrganizator(Long id) {
       return accesoUsuario.findById(id).orElse(null); 
    }

    @Override
    public Usuario createOrganizator(Usuario us) {
       Usuario user = accesoUsuario.findById(us.getId()).orElse(null);
       if(user==null){
        return accesoUsuario.save(us); 
       }
       return user; 
    }
    
}
