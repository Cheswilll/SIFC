/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.persona.controllers;

import DAO.PersonaFacadeLocal;
import DAO.RolFacadeLocal;
import Entities.Persona;
import Entities.Rol;
import SIFC.util.MessageUtil;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author cheswill
 */
@Named(value = "registroController")
@RequestScoped
public class RegistroController {

    @EJB
    private PersonaFacadeLocal pfl;
    @EJB
    private RolFacadeLocal rfl;
    
    private Persona personaNueva;
    
    public RegistroController() {
    }
    
    @PostConstruct
    public void init(){
        personaNueva = new Persona();
    }

    public Persona getPersonaNueva() {
        return personaNueva;
    }

    public void setPersonaNueva(Persona personaNueva) {
        this.personaNueva = personaNueva;
    }
    
    public void registrar(){
        if (personaNueva != null) {
            personaNueva.setRoles(new ArrayList<Rol>());
            personaNueva.getRoles().add(rfl.find(4));
            personaNueva.setIdEstado(1);
            pfl.create(personaNueva);
            MessageUtil.enviarMensajeInformacion("form-crear", "Registro exitoso", "El usuasrio ha sido registrado correctamente");
            init();
        }else{
        MessageUtil.enviarMensajeError("form-crear", "Error", "No se han diligenciado datos");
        }
    }
    
}
