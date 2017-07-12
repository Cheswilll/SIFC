/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.partido.controllers;

import Entities.Partido;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;

/**
 *
 * @author Cheswill
 */
@Named(value = "verPartidoController")
@SessionScoped
public class VerPartidoController implements Serializable {

    private Partido partido;
    
    public VerPartidoController() {
    }
    
    @PostConstruct
    public void init()
    {
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
    
    public String verPartido(Partido p){
    this.partido  = p;
    return "verPartido.xhtml?faces-redirect=true";
    }
    
    
    
}
