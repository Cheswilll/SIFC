/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.persona.controllers;

import Entities.Persona;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;

/**
 *
 * @author Cheswill
 */
@Named(value = "verPersonaController")
@SessionScoped
public class verPersonaController implements Serializable {
    
    private Persona persona;
    
    public verPersonaController() {
    }
    
    @PostConstruct
    public void init(){
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public String verPersona(Persona p){
    this.persona  = p;
    return "/sinproteccion/admin/vermas.xhtml?faces-redirect=true";
    }
    

    
    
}
