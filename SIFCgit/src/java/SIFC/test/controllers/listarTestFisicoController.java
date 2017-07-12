/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.test.controllers;

import DAO.TestFisicoFacadeLocal;
import Entities.TestFisico;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Cheswill
 */
@Named(value = "listarTestFisicoController")
@RequestScoped
public class listarTestFisicoController {

    @EJB
    private TestFisicoFacadeLocal tfsl;
    
    private List<TestFisico> testFisicos;
    
    public listarTestFisicoController() {
    }
    
    @PostConstruct
    public void init(){
    testFisicos = tfsl.findAll();
    }

    public List<TestFisico> getTestFisicos() {
        return testFisicos;
    }
    
    
}
