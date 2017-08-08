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
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Cheswill
 */
@Named(value = "registrarFormularioController")
@RequestScoped
public class registrarFormularioController implements Serializable{

    @EJB
    private FormularioFacadeLocal ffl;
    private PersonaFacadeLocal pfl;
    
    private Persona persona;
    
    private Formulario formularioNuevo;
    
    @Inject
    private SessionController sc;
    
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
        if (sc.inicioSesion()) {
            formularioNuevo.setNoIdentificacion(sc.getPersona());
            ffl.create(formularioNuevo);
        }else{
            System.out.println("Ha ocurrido un error al realizar el registro del formulario");
        }
            init();
    }
    
}
