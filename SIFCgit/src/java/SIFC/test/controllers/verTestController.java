/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.test.controllers;

import Entities.TestFisico;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;

/**
 *
 * @author Cheswill
 */
@Named(value = "verTestController")
@SessionScoped
public class verTestController implements Serializable {

    private TestFisico testFisico;
    
    public verTestController() {
    }
    
    @PostConstruct
    public void init(){}

    public TestFisico getTestFisico() {
        return testFisico;
    }

    public void setTestFisico(TestFisico testFisico) {
        this.testFisico = testFisico;
    }
    
    public String verTestFisico(TestFisico tf){
    this.testFisico = tf;
    return "/sinproteccion/profesor/verTest.xhtml?faces-redirect=true";
    }
    
}
