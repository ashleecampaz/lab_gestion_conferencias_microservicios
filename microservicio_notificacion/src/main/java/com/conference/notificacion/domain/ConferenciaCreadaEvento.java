/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.notificacion.domain; 

/**
 *
 * @author Ashlee Campaz
 */
public class ConferenciaCreadaEvento {
    
    private String organizator_name;
    private String organizator_lastName;
    private String organizator_email;
    private String conference_name; 

    public String getOrganizator_name() {
        return organizator_name;
    }

    public void setOrganizator_name(String organizator_name) {
        this.organizator_name = organizator_name;
    }

    public String getOrganizator_lastName() {
        return organizator_lastName;
    }

    public void setOrganizator_lastName(String organizator_lastName) {
        this.organizator_lastName = organizator_lastName;
    }

    public String getOrganizator_email() {
        return organizator_email;
    }

    public void setOrganizator_email(String organizator_email) {
        this.organizator_email = organizator_email;
    }

    public String getConference_name() {
        return conference_name;
    }

    public void setConference_name(String conference_name) {
        this.conference_name = conference_name;
    }

    @Override
    public String toString() {
        return String.format("{\"conference_name\": \"%s\",\"organizator_email\": \"%s\", \"organizator_name\": \"%s\", \"organizator_lastName\": \"%s\"}",conference_name,organizator_email,organizator_name,organizator_lastName);
    }
    
    
}
