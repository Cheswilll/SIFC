/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.formulario.controllers;

import Entities.Formulario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;

/**
 *
 * @author Cheswill
 */
@Named(value = "verFormularioController")
@SessionScoped
public class VerFormularioController implements Serializable {

    private Formulario formulario;
    
    public VerFormularioController() {
    }
    
    @PostConstruct
    public void init(){}

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }
    
    
    public String verFormulario(Formulario f){
    this.formulario = f;
    return "/sinproteccion/admin/verFormulario.xhtml?faces-redirect=true";
    }
    
}
