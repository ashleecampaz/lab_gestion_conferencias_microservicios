/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.conferencia.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author Ashlee Campaz
 */
@Entity
@Table (name = "Usuario")
public class Usuario implements Serializable{
    private String name;
    private String lastName;
    private String email;

    @Id
    private Long id; 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("{\"id\": \"%d\",\"email\": \"%s\", \"name\": \"%s\", \"lastName\": \"%s\"}",id,email,name,lastName);
    }

    
    
    
}
