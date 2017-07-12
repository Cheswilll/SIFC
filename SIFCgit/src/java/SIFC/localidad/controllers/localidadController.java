/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.localidad.controllers;

import DAO.LocalidadFacadeLocal;
import Entities.Localidad;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Cheswill
 */
@Named(value = "localidadController")
@RequestScoped
public class localidadController {
    @EJB 
    private LocalidadFacadeLocal lfl;
    
    private List<Localidad> localidades;
    
    public localidadController() {
    }
    
    @PostConstruct
    public void init(){
    localidades = lfl.findAll();
    }

    public List<Localidad> getLocalidades() {
        return localidades;
    }
    
    
}
