/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.test.controllers;

import DAO.TestFisicoFacadeLocal;
import Entities.TestFisico;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Cheswill
 */
@Named(value = "registrarTestController")
@RequestScoped
public class registrarTestController {

    @EJB
    private TestFisicoFacadeLocal tfsl;
    
    private TestFisico testFisico;
    
    public registrarTestController() {
    }
    
    @PostConstruct
    public void init(){
    testFisico = new TestFisico();
    }

    public TestFisicoFacadeLocal getTfsl() {
        return tfsl;
    }

    public void setTfsl(TestFisicoFacadeLocal tfsl) {
        this.tfsl = tfsl;
    }

    public TestFisico getTestFisico() {
        return testFisico;
    }

    public void setTestFisico(TestFisico testFisico) {
        this.testFisico = testFisico;
    }
    
    
    public void registrarTestFisico(){
        tfsl.create(testFisico);
        init();
    }
}
