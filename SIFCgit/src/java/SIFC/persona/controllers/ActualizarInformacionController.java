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
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author cheswill
 */
@Named(value = "actualizarInformacionController")
@SessionScoped
public class ActualizarInformacionController implements Serializable {

     @EJB
    private PersonaFacadeLocal pfl;
    private Persona personaAct;
    private Persona p;
    
    @Inject
    private SessionController sc;
    
    public ActualizarInformacionController() {
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

    public Persona getP() {
        return p;
    }

    public void setP(Persona p) {
        this.p = p;
    }
    
    
    public String preModificar(){
        p = sc.getPersona();
        setPersonaAct(p);
        return "/sinproteccion/admin/actualizarInfoPersonal.xhtml?faces-redirect=true";
    }
    
    public void actualizarInfoPersonal() {
        try {
            pfl.edit(personaAct);
            MessageUtil.enviarMensajeInformacion("form-editar", "Actualización", "Los datos del usuarios se han actualizado correctamente.");
        } catch (Exception e) {
            MessageUtil.enviarMensajeErrorGlobal("Error al modificar los datos del usuario", e.getStackTrace().toString());
        }

    }
    
}
