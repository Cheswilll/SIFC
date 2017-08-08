/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.test.controllers;

import DAO.TestFisicoFacadeLocal;
import Entities.TestFisico;
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
@Named(value = "registrarTestController")
@RequestScoped
public class registrarTestController implements Serializable {
    
    @EJB
    private TestFisicoFacadeLocal tfsl;
    
    private TestFisico testFisico;
    
    @Inject
    private SessionController sc;
    
    public registrarTestController() {
    }
    
    @PostConstruct
    public void init() {
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
    
    public void registrarTestFisico() {
        if (sc.inicioSesion()) {
            testFisico.setNoIdentificacionProfesor(sc.getPersona());
            tfsl.create(testFisico);
        }else{
            System.out.println("Ha ocurrido un error al registrar el test");
        }
        init();
    }
}
