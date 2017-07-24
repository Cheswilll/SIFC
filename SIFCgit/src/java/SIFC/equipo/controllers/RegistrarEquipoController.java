/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.equipo.controllers;

import DAO.EquipoFacadeLocal;
import Entities.Equipo;
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
       efl.create(nuevoEquipo);
       init();
    }
    
    
}
