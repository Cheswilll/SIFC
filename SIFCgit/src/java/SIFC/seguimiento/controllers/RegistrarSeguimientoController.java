/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.seguimiento.controllers;

import DAO.SeguimientoFacadeLocal;
import Entities.Seguimiento;
import SIFC.login.controllers.SessionController;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Cheswill
 */
@Named(value = "registrarSeguimientoController")
@RequestScoped
public class RegistrarSeguimientoController implements Serializable {
    
    @EJB
    private SeguimientoFacadeLocal sfl;
    
    private Seguimiento nuevoSeguimiento;
    
    @Inject
    private SessionController sc;
    
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
    public void init() {
        nuevoSeguimiento = new Seguimiento();
    }
    
    public void registrarSeguimiento() {
        if (sc.inicioSesion()) {
            nuevoSeguimiento.setNoIdentificacionProfesor(sc.getPersona());
            sfl.create(nuevoSeguimiento);
        }else{
            System.out.println("Ha ocurrido un error al registrar el seguimiento");
        }
        init();
    }
    
}
