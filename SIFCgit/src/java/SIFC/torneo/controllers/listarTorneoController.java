/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.torneo.controllers;

import DAO.TorneoFacadeLocal;
import Entities.Torneo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author APRENDIZ
 */
@Named(value = "listarTorneoController")
@RequestScoped
public class listarTorneoController {

    @EJB
    private TorneoFacadeLocal tfl;
    
    private List<Torneo> torneos; 
    
    public listarTorneoController() {
    }
    
    @PostConstruct
    public void init(){
    torneos = tfl.findAll();
    }

    public List<Torneo> getTorneos() {
        return torneos;
    }
    
    
    
}
