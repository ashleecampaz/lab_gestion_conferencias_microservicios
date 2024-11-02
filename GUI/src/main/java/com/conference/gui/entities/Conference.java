/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.gui.entities;





/**
 *
 * @author Ashlee Campaz
 */


public class Conference {
    private String name; 
    private String organization;
    
    private Long organizator_id; 

    private Long id;
    
    public Conference(String name, String organization, Long organizator_id){
        this.organizator_id = organizator_id;
        this.organization = organization;
        this.name = name; 
    }
    
    public Conference(){}
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Long getOrganizator_id() {
        return organizator_id;
    }

    public void setOrganizator_id(Long organizator_id) {
        this.organizator_id = organizator_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
