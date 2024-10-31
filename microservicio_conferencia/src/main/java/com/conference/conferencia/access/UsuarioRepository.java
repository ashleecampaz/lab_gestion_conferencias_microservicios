/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.conference.conferencia.access;

import com.conference.conferencia.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Ashlee Campaz
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
    
}
