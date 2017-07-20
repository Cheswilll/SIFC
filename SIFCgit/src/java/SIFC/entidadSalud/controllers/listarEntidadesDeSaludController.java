/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.entidadSalud.controllers;

import DAO.EntidadDeSaludFacadeLocal;
import Entities.EntidadDeSalud;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Cheswill
 */
@Named(value = "listarEntidadesDeSaludController")
@RequestScoped
public class listarEntidadesDeSaludController {

    
    
    @EJB
    private EntidadDeSaludFacadeLocal efl;
    
    private List<EntidadDeSalud> entidadesDeSalud;
    private EntidadDeSalud entidadDeSalud;
    
    public listarEntidadesDeSaludController() {
    }
    
    @PostConstruct
    public void init(){
    entidadesDeSalud = efl.findAll();
    }

    public List<EntidadDeSalud> getEntidadesDeSalud() {
        return entidadesDeSalud;
    }
    
    
    
    
}
