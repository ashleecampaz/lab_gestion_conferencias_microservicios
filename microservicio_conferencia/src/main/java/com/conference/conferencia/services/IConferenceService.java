/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.conference.conferencia.services;

import com.conference.conferencia.domain.Conferencia;
import com.conference.conferencia.domain.Usuario;
import java.util.List;

/**
 *
 * @author Ashlee Campaz
 */
public interface IConferenceService {
    
    public List<Conferencia> findAll();
    public Conferencia findById(Long id); 
    public Conferencia createConference(Conferencia con); 
    public Usuario createOrganizator(Usuario us);
    public Usuario getOrganizator(Long id); 
}
