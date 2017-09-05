/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.familia.controllers;

import SIFC.Charts.ChartView;
import SIFC.login.controllers.SessionController;
import com.mysql.jdbc.Connection;
import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
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
@Named(value = "chartSeguimientoDeSeguimientosController")
@RequestScoped
public class ChartSeguimientoDeSeguimientosController implements Serializable {

    @Inject
    private SessionController sc;

    private Integer tallaGuayos;
    private Integer tallaPantaloneta;
    private Integer tallaCamisa;

    public ChartSeguimientoDeSeguimientosController() {
    }

    @PostConstruct
    public void init() {
        consultaTallaGuayos();
        consultaTallaPantaloneta();
        consultaTallaCamisa();
    }

    public Integer getTallaGuayos() {
        return tallaGuayos;
    }

    public void setTallaGuayos(Integer tallaGuayos) {
        this.tallaGuayos = tallaGuayos;
    }

    public Integer getTallaPantaloneta() {
        return tallaPantaloneta;
    }

    public void setTallaPantaloneta(Integer tallaPantaloneta) {
        this.tallaPantaloneta = tallaPantaloneta;
    }

    public Integer getTallaCamisa() {
        return tallaCamisa;
    }

    public void setTallaCamisa(Integer tallaCamisa) {
        this.tallaCamisa = tallaCamisa;
    }
    
    
    
    public void consultaTallaGuayos() {
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sifcnuevo", "administrador", "123456789");

            Statement sql = con.createStatement();
            ResultSet resultado = sql.executeQuery("SELECT seguimientos.tallaGuayos AS tallG FROM seguimientos, familias, personas "
                    + "WHERE personas.noIdentificacion = seguimientos.noIdentificacionJugador  "
                    + "AND personas.noIdentificacion = seguimientos.noIdentificacionJugador  "
                    + "AND personas.noIdentificacion = familias.noIdentificacionJugador  "
                    + "AND familias.noIdentificacionPadre= " + sc.getPersona().getNoIdentificacion() + " ;");

            while (resultado.next()) {
                tallaGuayos = resultado.getInt("tallG");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChartView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void consultaTallaPantaloneta() {
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sifcnuevo", "administrador", "123456789");

            Statement sql = con.createStatement();
            ResultSet resultado = sql.executeQuery("SELECT seguimientos.tallaPantaloneta AS tallG FROM seguimientos, familias, personas "
                    + "WHERE personas.noIdentificacion = seguimientos.noIdentificacionJugador  "
                    + "AND personas.noIdentificacion = seguimientos.noIdentificacionJugador  "
                    + "AND personas.noIdentificacion = familias.noIdentificacionJugador  "
                    + "AND familias.noIdentificacionPadre= " + sc.getPersona().getNoIdentificacion() + " ;");

            while (resultado.next()) {
                tallaPantaloneta = resultado.getInt("tallG");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChartView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void consultaTallaCamisa() {
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sifcnuevo", "administrador", "123456789");

            Statement sql = con.createStatement();
            ResultSet resultado = sql.executeQuery("SELECT seguimientos.tallaCamisa AS tallG FROM seguimientos, familias, personas "
                    + "WHERE personas.noIdentificacion = seguimientos.noIdentificacionJugador  "
                    + "AND personas.noIdentificacion = seguimientos.noIdentificacionJugador  "
                    + "AND personas.noIdentificacion = familias.noIdentificacionJugador  "
                    + "AND familias.noIdentificacionPadre= " + sc.getPersona().getNoIdentificacion() + " ;");

            while (resultado.next()) {
                tallaCamisa = resultado.getInt("tallG");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChartView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}

