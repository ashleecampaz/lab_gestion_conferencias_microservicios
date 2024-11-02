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
public class BasicEmailBuilder extends BuildEmail {

    @Override
    public void build(String remitente, ArrayList<String> destinarios, String asunto, String cuerpo) {
        email.setRemitente(remitente);
        email.setCuerpo(cuerpo);
        email.setDestinatarios(destinarios);
        email.setAsunto(asunto);
    }
    
}
