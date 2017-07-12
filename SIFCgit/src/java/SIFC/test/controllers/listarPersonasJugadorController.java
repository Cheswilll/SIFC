/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.test.controllers;

import DAO.PersonaFacadeLocal;
import Entities.Persona;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Cheswill
 */
@Named(value = "listarPersonasJugadorController")
@RequestScoped
public class listarPersonasJugadorController {

    @EJB
    private PersonaFacadeLocal pfl;
    
    private List<Persona> personasJugadores;
    
    public listarPersonasJugadorController() {
    }
    
    @PostConstruct
    public void init(){
    personasJugadores = pfl.findAll();
    }

    public List<Persona> getPersonasJugadores() {
        return personasJugadores;
    }
    
    
}
