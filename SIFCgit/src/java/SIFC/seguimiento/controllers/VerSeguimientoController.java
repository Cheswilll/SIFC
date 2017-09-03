/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.seguimiento.controllers;

import Entities.Seguimiento;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;

/**
 *
 * @author cheswill
 */
@Named(value = "verSeguimientoController")
@SessionScoped
public class VerSeguimientoController implements Serializable {

    private Seguimiento seguimiento;
    
    public VerSeguimientoController() {
    }

    @PostConstruct
    public void init(){
        
    }
    
    public Seguimiento getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(Seguimiento seguimiento) {
        this.seguimiento = seguimiento;
    }
    
    public String verSeguimiento(Seguimiento s){
    this.seguimiento  = s;
    return "/sinproteccion/profesor/verSeguimiento.xhtml?faces-redirect=true";
    }

    
}
