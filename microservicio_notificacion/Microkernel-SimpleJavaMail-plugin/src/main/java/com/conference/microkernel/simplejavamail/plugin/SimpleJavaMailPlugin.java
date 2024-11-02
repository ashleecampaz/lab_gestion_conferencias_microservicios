/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.microkernel.simplejavamail.plugin;

import com.conference.microkernel.common.entities.Email;
import com.conference.microkernel.common.interfaces.IEmailPlugin;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

/**
 *
 * @author Ashlee Campaz
 */
public class SimpleJavaMailPlugin implements IEmailPlugin {

    @Override
    public void EnviarEmail(Email e) {
        String correos = "";
        
        for (int i=0; i<e.getDestinatarios().size(); i++){
           
            if(i!=e.getDestinatarios().size()-1)
              correos = correos + e.getDestinatarios().get(i) + ", ";
            else 
                correos = correos + e.getDestinatarios().get(i);
        }
        
        org.simplejavamail.api.email.Email email = EmailBuilder.startingBlank()
        .from(e.getRemitente())
        .to(correos)
        .withSubject(e.getAsunto())
        .withPlainText(e.getCuerpo())
        .buildEmail();
        
        Mailer mailer = MailerBuilder
        .withSMTPServer("smtp.gmail.com", 587, "easy.conference.prueba@gmail.com", "iinjvivwcikfnkxf")
        .buildMailer();
        if(mailer.validate(email)){
             mailer.sendMail(email);
        }
        else{
            System.out.println("Hay un problema con el email");
        }
       
    }
    
}
