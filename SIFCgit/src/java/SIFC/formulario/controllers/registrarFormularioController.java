/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.formulario.controllers;

import DAO.FormularioFacadeLocal;
import Entities.Formulario;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Cheswill
 */
@Named(value = "registrarFormularioController")
@RequestScoped
public class registrarFormularioController {

    @EJB
    private FormularioFacadeLocal ffl;
    private Formulario formularioNuevo;

    public registrarFormularioController() {
    }

    public Formulario getFormularioNuevo() {
        return formularioNuevo;
    }

    public void setFormularioNuevo(Formulario formularioNuevo) {
        this.formularioNuevo = formularioNuevo;
    }
    
    
    @PostConstruct
    public void init(){
    formularioNuevo = new Formulario();
    }
    
    public void registrarFormulario(){
    ffl.create(formularioNuevo);
    init();
    }
    
}
