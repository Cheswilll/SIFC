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
    
    private List<Persona> personasPadres;
    private List<Persona> personasAdmins;
    private List<Persona> personasProfes;
    private List<Persona> personasJugadores;
    private List<Persona> personasNormales;
    private List<Persona> categoria;
    
    public ListarPersonasController() {
    }
    
    
    @PostConstruct
    public void init(){
        personasProfes = pfl.buscarPorRolProfesor();
        personasAdmins = pfl.buscarPorRol();    
        personasJugadores = pfl.buscarPorRolJugador();
        personasNormales = pfl.buscarPorRolNormal();
        personasPadres = pfl.buscarPorRolPadre();
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

    public Persona getPersonaSelecionada() {
        return personaSelecionada;
    }

    public void setPersonaSelecionada(Persona personaSelecionada) {
        this.personaSelecionada = personaSelecionada;
    }

    public List<Persona> getPersonasProfes() {
        return personasProfes;
    }

    public void setPersonasProfes(List<Persona> personasProfes) {
        this.personasProfes = personasProfes;
    }

    public List<Persona> getPersonasJugadores() {
        return personasJugadores;
    }

    public void setPersonasJugadores(List<Persona> personasJugadores) {
        this.personasJugadores = personasJugadores;
    }

    public List<Persona> getPersonasNormales() {
        return personasNormales;
    }

    public void setPersonasNormales(List<Persona> personasNormales) {
        this.personasNormales = personasNormales;
    }

    public List<Persona> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Persona> categoria) {
        this.categoria = categoria;
    }

    public List<Persona> getPersonasPadres() {
        return personasPadres;
    }

    public void setPersonasPadres(List<Persona> personasPadres) {
        this.personasPadres = personasPadres;
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
    
   
   
}
