/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.persona.controllers;

import DAO.PersonaFacadeLocal;
import Entities.Persona;
import SIFC.login.controllers.SessionController;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Cheswill
 */
@Named(value = "actualizarController")
@SessionScoped
public class ActualizarController implements Serializable{

    @EJB
    private PersonaFacadeLocal pfl;
    private Persona personaAct;
    private SessionController sc;
    
    public ActualizarController() {
    }

    public PersonaFacadeLocal getPfl() {
        return pfl;
    }

    public void setPfl(PersonaFacadeLocal pfl) {
        this.pfl = pfl;
    }

    public Persona getPersonaAct() {
        return personaAct;
    }

    public void setPersonaAct(Persona personaAct) {
        this.personaAct = personaAct;
    }
    
    public String preEditar(){
        setPersonaAct(sc.getPersona());
        return "/app/admin/actualizarInfoPersonal.xhtml?faces-redirect=true";
    }
    
    public void ActualizarInfoPersonal(){
    pfl.edit(personaAct);
    }
    
   
    
}
