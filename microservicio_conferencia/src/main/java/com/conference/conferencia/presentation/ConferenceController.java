/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.conferencia.presentation;

import com.conference.conferencia.domain.Conferencia;
import com.conference.conferencia.domain.Usuario;
import com.conference.conferencia.services.IConferenceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ashlee Campaz
 */
@RestController
@RequestMapping("/Conference")
public class ConferenceController {
    @Autowired
    IConferenceService conferenceService; 
    
    @RequestMapping(method = RequestMethod.GET, produces =
    "application/json")
     @ResponseBody
     public List<Conferencia> findAll() {
        return conferenceService.findAll();
    }
     
     @RequestMapping(method = RequestMethod.POST, produces =
    "application/json", consumes = "application/json")
     @ResponseBody
        public ResponseEntity<Conferencia> create(@RequestBody Conferencia con) {
        Conferencia conf = conferenceService.createConference(con);
        if( conf!=null){
            return ResponseEntity.ok( conf);
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
     }
     /* Get a Event by ID */
     @GetMapping("/{id}")
     public Conferencia getConferenceById(@PathVariable Long id) {
        return conferenceService.findById(id);
    }
    
    @GetMapping("/{id}/Organizator")
     public Usuario getOrganizator(@PathVariable Long id) {
         Conferencia con = conferenceService.findById(id);
        return conferenceService.getOrganizator(con.getOrganizator_id());
    } 
    
    @PostMapping(value="/Organizator", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario us){
        Usuario user = conferenceService.createOrganizator(us); 
        if(user!=null){
            return ResponseEntity.ok(us);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    } 
}
