/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.formulario.controllers;

import DAO.FormularioFacadeLocal;
import DAO.PersonaFacadeLocal;
import Entities.Formulario;
import Entities.Persona;
import SIFC.login.controllers.SessionController;
import SIFC.util.MessageUtil;
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
    private SessionController sc;
    private PersonaFacadeLocal pfl;
    
    private Persona persona;
    
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
        persona =sc.getPersona();
            formularioNuevo.setNoIdentificacion(sc.getPersona());
            ffl.create(formularioNuevo);
            init();
    }
    
}
