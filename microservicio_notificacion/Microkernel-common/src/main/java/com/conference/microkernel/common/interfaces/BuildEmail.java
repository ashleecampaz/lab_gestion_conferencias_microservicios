/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.conference.microkernel.common.interfaces;

import com.conference.microkernel.common.entities.Email;
import java.util.ArrayList;

/**
 *
 * @author Ashlee Campaz
 */
public abstract class BuildEmail {
    protected Email email;
    
   
    public final void setMethod(){
        email.setMethod("sjm");
    }
    public abstract void build(String remitente, ArrayList<String> destinatarios, String asunto, String cuerpo);
    
    public Email getEmail(){
        return email; 
    }
    
    public void crearEmail(){
        email = new Email(); 
    }
}
