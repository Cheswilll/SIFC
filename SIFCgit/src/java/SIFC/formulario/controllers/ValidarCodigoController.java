/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.formulario.controllers;

import DAO.CodigoValidacionFacadeLocal;
import DAO.FormularioFacadeLocal;
import Entities.CodigoValidacion;
import Entities.Formulario;
import SIFC.login.controllers.SessionController;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author cheswill
 */
@Named(value = "validarCodigoController")
@RequestScoped
public class ValidarCodigoController {

    @EJB
    private CodigoValidacionFacadeLocal cvfl;
    @Inject    
    private SessionController sc;
    
    private CodigoValidacion cv;
    

    public ValidarCodigoController() {
    }
    
    
    @PostConstruct
    public void init() {
       cv = cvfl.findByUsuario(sc.getNoidentificacion());

    }

    public CodigoValidacion getCv() {
        return cv;
    }

    public void setCv(CodigoValidacion cv) {
        this.cv = cv;
    }
    
    


   
}
