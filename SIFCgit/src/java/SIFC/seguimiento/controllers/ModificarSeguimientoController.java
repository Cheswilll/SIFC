/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.seguimiento.controllers;

import DAO.SeguimientoFacadeLocal;
import Entities.Seguimiento;
import SIFC.util.MessageUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Cheswill
 */
@Named(value = "modificarSeguimientoController")
@SessionScoped
public class ModificarSeguimientoController implements Serializable {

    
    @EJB
    private SeguimientoFacadeLocal sfl;
    
    private Seguimiento seguimientoSeleccionado;
    
    public ModificarSeguimientoController() {
    }

    public Seguimiento getSeguimientoSeleccionado() {
        return seguimientoSeleccionado;
    }

    public void setSeguimientoSeleccionado(Seguimiento seguimientoSeleccionado) {
        this.seguimientoSeleccionado = seguimientoSeleccionado;
    }
    
    public String preModificarSeguimiento(Seguimiento s){
        setSeguimientoSeleccionado(s);
        return "/app/profesor/actualizarSeguimiento.xhtml?faces-redirect=true";
    }
    
    public void actulaizarDatosSeguimiento(){
        try {
            sfl.edit(seguimientoSeleccionado);
            MessageUtil.enviarMensajeInformacion("form-editar", "Actualización", "Los datos del usuarios se han actualizado correctamente.");
        } catch (Exception e) {
            MessageUtil.enviarMensajeErrorGlobal("Error al modificar los datos del seguimiento", e.getStackTrace().toString());
        }
    }
    
    
}
