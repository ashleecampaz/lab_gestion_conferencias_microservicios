/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.notificacion.services;

import com.conference.microkernel.common.entities.Email;
import com.conference.microkernel.common.interfaces.IEmailPlugin;
import com.conference.notificacion.EmailPluginManager;
import org.springframework.stereotype.Component;


/**
 *
 * @author Ashlee Campaz
 */
@Component
public class EmailService {
    
    public void EnviarEmail(Email e) throws Exception{
        String emailMethod = e.getMethod();
        EmailPluginManager manager = EmailPluginManager.getInstance();
        IEmailPlugin plugin = manager.getEmailPlugin(emailMethod);
        
        if (plugin == null) {
            throw new Exception("No hay un plugin disponible para el metodo indicado: " + emailMethod);
        }
        
        plugin.EnviarEmail(e);
    
    }
}
