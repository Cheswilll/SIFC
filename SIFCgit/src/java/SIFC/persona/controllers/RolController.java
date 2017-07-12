/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.persona.controllers;

import DAO.RolFacadeLocal;
import Entities.Rol;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Ismael
 */
@Named(value = "rolController")
@RequestScoped
public class RolController {

    @EJB
    private RolFacadeLocal tdfl;
    
    private List<Rol> roles;
    /**
     * Creates a new instance of RolController
     */
    public RolController() {
    }
    
    @PostConstruct
    public void init(){
        roles = tdfl.findAll();
    }

    public List<Rol> getRoles() {
        return roles;
    }
    
    
}
