/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.familia.controllers;

import SIFC.Charts.*;
import SIFC.login.controllers.SessionController;
import com.mysql.jdbc.Connection;
import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author cheswill
 */
@Named(value = "chartSeguimientoAsistenciaController")
@RequestScoped
public class ChartSeguimientoAsistenciaController implements  Serializable{
    
    @Inject
    private SessionController sc;
    
    private Integer asistencias;
    private Integer inasistencias;
    private Integer retardos;
    private Integer excusas;

    public ChartSeguimientoAsistenciaController() {
    }

    public Integer getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(Integer asistencias) {
        this.asistencias = asistencias;
    }

    public Integer getInasistencias() {
        return inasistencias;
    }

    public void setInasistencias(Integer inasistencias) {
        this.inasistencias = inasistencias;
    }

    public Integer getRetardos() {
        return retardos;
    }

    public void setRetardos(Integer retardos) {
        this.retardos = retardos;
    }

    public Integer getExcusas() {
        return excusas;
    }

    public void setExcusas(Integer excusas) {
        this.excusas = excusas;
    }

    @PostConstruct
    public void init() {
        listarA();
        listarF();
        listarE();
        listarR();
    }

    public void listarA() {
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sifcnuevo", "administrador", "123456789");

            Statement sql = con.createStatement();
            ResultSet resultado = sql.executeQuery("SELECT count(asistencias.asistencia) as asis FROM asistencias, familias, personas " +
                    "WHERE personas.noIdentificacion = asistencias.noIdentificacionJugador " +
                    "AND personas.noIdentificacion = asistencias.noIdentificacionJugador AND personas.noIdentificacion = familias.noIdentificacionJugador " +
                    " AND asistencias.asistencia='a' AND familias.noIdentificacionPadre=  "+sc.getPersona().getNoIdentificacion()+" ;");

            while (resultado.next()) {
                asistencias = resultado.getInt("asis");

            }
        } catch (SQLException ex) {
            Logger.getLogger(ChartView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarF() {

        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sifcnuevo", "administrador", "123456789");

            Statement sql = con.createStatement();
            ResultSet resultado = sql.executeQuery("SELECT count(asistencias.asistencia) as asis FROM asistencias, familias, personas " +
                    "WHERE personas.noIdentificacion = asistencias.noIdentificacionJugador " +
                    "AND personas.noIdentificacion = asistencias.noIdentificacionJugador AND personas.noIdentificacion = familias.noIdentificacionJugador  " +
                    " AND asistencias.asistencia='f' AND familias.noIdentificacionPadre=  "+sc.getPersona().getNoIdentificacion()+" ;");

            while (resultado.next()) {
                inasistencias = resultado.getInt("asis");

            }
        } catch (SQLException ex) {
            Logger.getLogger(ChartView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarE() {
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sifcnuevo", "administrador", "123456789");

            Statement sql = con.createStatement();
            ResultSet resultado = sql.executeQuery("SELECT count(asistencias.asistencia) as asis FROM asistencias, familias, personas " +
                    "WHERE personas.noIdentificacion = asistencias.noIdentificacionJugador " +
                    "AND personas.noIdentificacion = asistencias.noIdentificacionJugador AND personas.noIdentificacion = familias.noIdentificacionJugador  " +
                    " AND asistencias.asistencia='e' AND familias.noIdentificacionPadre=  "+sc.getPersona().getNoIdentificacion()+" ;");

            while (resultado.next()) {
                excusas= resultado.getInt("asis");

            }
        } catch (SQLException ex) {
            Logger.getLogger(ChartView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listarR(){
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sifcnuevo", "administrador", "123456789");

            Statement sql = con.createStatement();
            ResultSet resultado = sql.executeQuery("SELECT count(asistencias.asistencia) as asis FROM asistencias, familias, personas " +
                    "WHERE personas.noIdentificacion = asistencias.noIdentificacionJugador " +
                    "AND personas.noIdentificacion = asistencias.noIdentificacionJugador AND personas.noIdentificacion = familias.noIdentificacionJugador  " +
                    " AND asistencias.asistencia='r' AND familias.noIdentificacionPadre=  "+sc.getPersona().getNoIdentificacion()+" ;");

            while (resultado.next()) {
                retardos = resultado.getInt("asis");

            }
        } catch (SQLException ex) {
            Logger.getLogger(ChartView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
