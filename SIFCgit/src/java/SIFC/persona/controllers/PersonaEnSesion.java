/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.persona.controllers;

import DAO.PersonaFacadeLocal;
import Entities.Persona;
import SIFC.login.controllers.SessionController;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Cheswill
 */
@Named(value = "personaEnSesion")
@RequestScoped
public class PersonaEnSesion {

    @EJB
    private PersonaFacadeLocal pfl;

    private SessionController sc;
    private Persona personaEnSesion;

    private Persona persona;

    public PersonaEnSesion() {
    }

    @PostConstruct
    public void init() {
    }

    public Persona getPersonasEnSesion() {
        personaEnSesion = pfl.find(11111111);
        return personaEnSesion;
    }
}
