/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.microkernel.common.entities;

import java.util.ArrayList;

/**
 *
 * @author Ashlee Campaz
 */
public class Email {
    private String asunto;
    private ArrayList<String> destinatarios;
    private String remitente; 
    private String cuerpo; 
    
    private String method;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    public Email(String asunto,ArrayList<String> destinatarios, String remitente,
                 String cuerpo){
        this.asunto = asunto;
        this.destinatarios = destinatarios;
        this.cuerpo = cuerpo;
        this.remitente = remitente; 
    }
    
    public Email(){}
    
    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public ArrayList<String> getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatarios(ArrayList<String> destinatarios) {
        this.destinatarios = destinatarios;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
    
    
}
