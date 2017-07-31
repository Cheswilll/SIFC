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
public class ActualizarController implements Serializable {

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

    public String preModificar(Persona p){
        setPersonaAct(p);
        return "/sinproteccion/admin/actualizarInfoPersonal.xhtml?faces-redirect=true";
    }
    
    public void ActualizarInfoPersonal() {
        try {
            personaAct.setIdTipoIdentificacion(sc.getPersona().getIdTipoIdentificacion());
            personaAct.setNoIdentificacion(sc.getPersona().getNoIdentificacion());
            personaAct.setNombre1(sc.getPersona().getNombre1());
            personaAct.setNombre2(sc.getPersona().getNombre2());
            personaAct.setApellido1(sc.getPersona().getApellido1());
            personaAct.setApellido2(sc.getPersona().getApellido2());
            personaAct.setFechaNacimiento(sc.getPersona().getFechaNacimiento());
            personaAct.setIdLocalidad(sc.getPersona().getIdLocalidad());
            personaAct.setDireccion(sc.getPersona().getDireccion());
            personaAct.setBarrio(sc.getPersona().getBarrio());
            pfl.edit(personaAct);
            MessageUtil.enviarMensajeInformacion("form-editar", "Actualización", "Los datos del usuarios se han actualizado correctamente.");
        } catch (Exception e) {
            MessageUtil.enviarMensajeErrorGlobal("Error al modificar los datos del usuario", e.getStackTrace().toString());
        }

    }

}
