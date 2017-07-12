/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.persona.controllers;

import DAO.PersonaFacadeLocal;
import Entities.Persona;
import SIFC.login.controllers.SessionController;
import SIFC.util.MessageUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.jms.Message;

/**
 *
 * @author Cheswill
 */
@Named(value = "listarPersonasController")
@ViewScoped
public class ListarPersonasController implements Serializable {

    
    @Inject
    private SessionController sc;
    
    @EJB
    private PersonaFacadeLocal pfl;
    
    
    private List<Persona> personas;
    private Persona personaSelecionada;
    private List<Persona> personasAdmins;
    private List<Persona> personasProfes;
    private List<Persona> personasJugadores;
    private List<Persona> personasNormales;
    private List<Persona> categoria;
    
    public ListarPersonasController() {
    }
    
    
    @PostConstruct
    public void init(){
    recargarPersonas();
    }
    
    private void recargarPersonas(){
    personas = pfl.findAll();
    }

    public List<Persona> getPersonasAdmins() {
        return personasAdmins;
    }
    
    

    public List<Persona> getPersonas() {
        return personas;
    }

    public PersonaFacadeLocal getPfl() {
        return pfl;
    }

    public void setPfl(PersonaFacadeLocal pfl) {
        this.pfl = pfl;
    }
    
    
    public Persona getPersonaSeleccionada(){
    return personaSelecionada;
    }
    
    public void setPersonaSeleccionada(Persona personaSeleccionada){
        System.out.println(personaSeleccionada.getNoIdentificacion());
        this.personaSelecionada = personaSeleccionada;
    }
    
    public void eliminarPersona(){
    Persona pS = sc.getPersona();
        System.out.println("El usuario que inicio sesion es: " +pS.getNoIdentificacion() + " " + pS.getNombre1());
        System.out.println("Eliminar usuario: " +personaSelecionada.getNoIdentificacion() + personaSelecionada.getNombre1());
        if (pS.getNoIdentificacion().intValue() != personaSelecionada.getNoIdentificacion()) {
            pfl.remove(personaSelecionada);
            recargarPersonas();
        }else{
            MessageUtil.enviarMensajeError(null, "Error", "No se puede eliminar usted mismo");
        }
    }
    
    public List<Persona> listarRolAdmin(){
        personasAdmins = pfl.buscarPorRol();
        return personasAdmins;
    }
    public List<Persona> listarRolProfesor(){
        personasProfes = pfl.buscarPorRolProfesor();
        return personasProfes;
    }
    public List<Persona> listarRolJugador(){
        personasJugadores = pfl.buscarPorRolJugador();
        return personasJugadores;
    }
    public List<Persona> listarRolNormal(){
        personasNormales = pfl.buscarPorRolNormal();
        return personasNormales;
    }
   
}
