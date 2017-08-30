/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.persona.controllers;

import DAO.PersonaFacadeLocal;
import Entities.Persona;
import SIFC.util.MessageUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

@Named(value = "modificarController")
@SessionScoped
public class ModificarController implements Serializable {

    @EJB
    private PersonaFacadeLocal pfl;
    
    private Persona personaSeleccionada;
    
    
    /**
     * Creates a new instance of ModificarController
     */
    public ModificarController() {
    }

    public Persona getPersonaSeleccionada() {
        return personaSeleccionada;
    }

    public void setPersonaSeleccionada(Persona personaSeleccionada) {
        this.personaSeleccionada = personaSeleccionada;
    }

    
    
    public void actulaizarDatos(){
        try {
            pfl.edit(personaSeleccionada);
            MessageUtil.enviarMensajeInformacion("form-editar", "Actualización", "Los datos del usuarios se han actualizado correctamente.");
        } catch (Exception e) {
            MessageUtil.enviarMensajeErrorGlobal("Error al modificar los datos del usuario", e.getStackTrace().toString());
        }
    }
    
    public String preModificar(Persona p){
        setPersonaSeleccionada(p);
        return "/sinproteccion/admin/actualizarInfo.xhtml?faces-redirect=true";
    }
    
    
    public String preModificarRol(Persona p){
        setPersonaSeleccionada(p);
        return "/sinproteccion/admin/ponerRoles.xhtml?faces-redirect=true";
    }
    
    public void cambioDeEstado(Persona p){
        try {
            if (p.getIdEstado() == 1) {
                p.setIdEstado(2);
            } else {
                p.setIdEstado(1);
            }
            pfl.edit(p);
            MessageUtil.enviarMensajeInformacion("form-data-table-usuarios", "Actualización", "Se ha cambiado el estado del usuario.");
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.enviarMensajeErrorGlobal("Errcambiar el estado del usuario", e.getStackTrace().toString());
        }
        
        
    }
    
    public String getIconUsuarioBloqueo(Persona p){
        return (p.getIdEstado() == 1) ? "lock": "unlock";
    }
}
