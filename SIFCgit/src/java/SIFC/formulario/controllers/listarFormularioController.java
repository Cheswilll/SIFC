/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.formulario.controllers;

import DAO.FormularioFacadeLocal;
import Entities.Formulario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Cheswill
 */
@Named(value = "listarFormularioController")
@ViewScoped
public class listarFormularioController implements Serializable{

    @EJB
    private FormularioFacadeLocal ffl;
    private List<Formulario> formularios;
    
    public listarFormularioController() {
    }
    
    @PostConstruct
    public void init(){
        formularios = ffl.findAll();
    }

    public List<Formulario> getFormularios() {
        return formularios;
    }
    
    
    
}
