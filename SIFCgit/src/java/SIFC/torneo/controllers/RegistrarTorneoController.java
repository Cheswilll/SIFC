/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.torneo.controllers;

import DAO.TorneoFacadeLocal;
import Entities.Torneo;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Cheswill
 */
@Named(value = "registrarTorneoController")
@RequestScoped
public class RegistrarTorneoController {

    @EJB
    private TorneoFacadeLocal tfl;
    private Torneo nuevoTorneo;
    
    public RegistrarTorneoController() {
    }

    public TorneoFacadeLocal getTfl() {
        return tfl;
    }

    public void setTfl(TorneoFacadeLocal tfl) {
        this.tfl = tfl;
    }

    public Torneo getNuevoTorneo() {
        return nuevoTorneo;
    }

    public void setNuevoTorneo(Torneo nuevoTorneo) {
        this.nuevoTorneo = nuevoTorneo;
    }



    @PostConstruct
    public void init(){
    nuevoTorneo = new Torneo();
    }
    
    
    public void registrarTorneo(){
    tfl.create(nuevoTorneo);
    init();
    }
    
}
