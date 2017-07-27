/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.equipo.controllers;

import DAO.EquipoFacadeLocal;
import Entities.Equipo;
import SIFC.login.controllers.SessionController;
import SIFC.util.MessageUtil;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Cheswill
 */
@Named(value = "registrarEquipoController")
@RequestScoped
public class RegistrarEquipoController {

    @EJB
    private EquipoFacadeLocal efl;
    private Equipo nuevoEquipo;
    
    private SessionController sc;
    
    public RegistrarEquipoController() {
    }

    public EquipoFacadeLocal getEfl() {
        return efl;
    }

    public void setEfl(EquipoFacadeLocal efl) {
        this.efl = efl;
    }

    public Equipo getNuevoEquipo() {
        return nuevoEquipo;
    }

    public void setNuevoEquipo(Equipo nuevoEquipo) {
        this.nuevoEquipo = nuevoEquipo;
    }
    
    @PostConstruct
    public void init()
    {
        nuevoEquipo = new Equipo();
    }
    
    public void registrarEquipo()
    {
        if (nuevoEquipo != null) {
            efl.create(nuevoEquipo);
            MessageUtil.enviarMensajeInformacion("form-crear", "Registro exitoso", "El usuasrio ha sido registrado correctamente");
            init();
        }else{
        MessageUtil.enviarMensajeError("form-crear", "Error", "No se han diligenciado datos");
        }
    }
    
    
}
