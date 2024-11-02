/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.microkernel.common.entities;

import com.conference.microkernel.common.interfaces.BuildEmail;
import java.util.ArrayList;

/**
 *
 * @author Ashlee Campaz
 */
public class EmailDirector {
    BuildEmail email; 
    
    public void setEmailBuilder(BuildEmail eb){
        this.email = eb;
    }
    
    public Email getEmail(){
        return email.getEmail();
    }
    
    public void construirEmail(String remitente, String cuerpo, String asunto, ArrayList<String> destinatarios){
        email.crearEmail();
        email.setMethod();
        email.build(remitente, destinatarios, asunto, cuerpo);
    }
}
