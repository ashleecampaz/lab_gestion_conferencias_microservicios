/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.conferencia.services;

import com.conference.conferencia.access.ConferenciaRepository;
import com.conference.conferencia.access.UsuarioRepository;
import com.conference.conferencia.domain.Conferencia;
import com.conference.conferencia.domain.Usuario;
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
        
        return accesoConferencia.save(con); 
    }

    @Override
    public Usuario getOrganizator(Long id) {
       return accesoUsuario.findById(id).orElse(null); 
    }

    @Override
    public Usuario createOrganizator(Usuario us) {
        return accesoUsuario.save(us); 
    }
    
}
