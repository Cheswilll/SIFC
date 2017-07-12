/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.seguimiento.controllers;

import DAO.SeguimientoFacadeLocal;
import Entities.Seguimiento;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Cheswill
 */
@Named(value = "registrarSeguimientoController")
@RequestScoped
public class RegistrarSeguimientoController {

    @EJB
    private SeguimientoFacadeLocal sfl;
    
    private Seguimiento nuevoSeguimiento;

    public SeguimientoFacadeLocal getSfl() {
        return sfl;
    }

    public void setSfl(SeguimientoFacadeLocal sfl) {
        this.sfl = sfl;
    }

    public Seguimiento getNuevoSeguimiento() {
        return nuevoSeguimiento;
    }

    public void setNuevoSeguimiento(Seguimiento nuevoSeguimiento) {
        this.nuevoSeguimiento = nuevoSeguimiento;
    }
            
    
    
    
    public RegistrarSeguimientoController() {
    }
    
    
    @PostConstruct
    public void init()
    {
        nuevoSeguimiento = new Seguimiento();
    }
    
    public void registrarSeguimiento()
    {
       sfl.create(nuevoSeguimiento);
       init();
    }
    
    
    
}
