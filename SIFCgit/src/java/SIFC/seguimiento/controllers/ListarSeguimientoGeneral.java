/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.seguimiento.controllers;

import DAO.TestFisicoFacadeLocal;
import Entities.Equipo;
import Entities.TestFisico;
import SIFC.Charts.ChartView;
import SIFC.login.controllers.SessionController;
import com.mysql.jdbc.Connection;
import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cheswill
 */
@Named(value = "listarSeguimientoGeneral")
@SessionScoped
public class ListarSeguimientoGeneral implements Serializable{
    
    @PersistenceContext(unitName = "SIFCgitPU")
    private EntityManager em;
    
    
    
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @EJB
    private TestFisicoFacadeLocal tffl;

    @Inject
    private SessionController sc;
   
    
    private Double velocidad1;
    private Double velocidad2;
    private Double velocidad3;
    private Double velocidad4;
    private Double velocidad5;
    
    private Equipo equipo;
    private List<TestFisico> testFisicosDelJugador;
    private Long jugadorSeleccionado;
    
    
    public ListarSeguimientoGeneral() {
    }
    
    @PostConstruct
    public void init(){
        
    
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Long getJugadorSeleccionado() {
        return jugadorSeleccionado;
    }

    public void setJugadorSeleccionado(Long jugadorSeleccionado) {
        this.jugadorSeleccionado = jugadorSeleccionado;
    }

    public List<TestFisico> getTestFisicosDelJugador() {
        return testFisicosDelJugador;
    }

    public void setTestFisicosDelJugador(List<TestFisico> testFisicosDelJugador) {
        this.testFisicosDelJugador = testFisicosDelJugador;
    }

    public Double getVelocidad1() {
        return velocidad1;
    }

    public void setVelocidad1(Double velocidad1) {
        this.velocidad1 = velocidad1;
    }

    public Double getVelocidad2() {
        return velocidad2;
    }

    public void setVelocidad2(Double velocidad2) {
        this.velocidad2 = velocidad2;
    }

    public Double getVelocidad3() {
        return velocidad3;
    }

    public void setVelocidad3(Double velocidad3) {
        this.velocidad3 = velocidad3;
    }

    public Double getVelocidad4() {
        return velocidad4;
    }

    public void setVelocidad4(Double velocidad4) {
        this.velocidad4 = velocidad4;
    }

    public Double getVelocidad5() {
        return velocidad5;
    }

    public void setVelocidad5(Double velocidad5) {
        this.velocidad5 = velocidad5;
    }
    
    

    
    
    
    
    public String preConsultarSeguimiento(Equipo e){
        setEquipo(e);
        
        
        jugadorSeleccionado = getEquipo().getNoIdentificacionJugador().getNoIdentificacion();
        
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sifcnuevo","administrador","123456789");
            
            Statement sql = con.createStatement();
            ResultSet resultado = sql.executeQuery("SELECT*FROM testfisicos WHERE noIdentificacionJugador= "+getJugadorSeleccionado()+ " ORDER BY idTest  DESC LIMIT 1; ");
            
            while (resultado.next()) {
               velocidad1 = resultado.getDouble("velocidad");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChartView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sifcnuevo","administrador","123456789");
            
            Statement sql = con.createStatement();
            ResultSet resultado = sql.executeQuery("SELECT*FROM testfisicos WHERE noIdentificacionJugador= "+getJugadorSeleccionado()+ " ORDER BY idTest  DESC LIMIT 1,1; ");
            
            while (resultado.next()) {
               velocidad2 = resultado.getDouble("velocidad");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChartView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sifcnuevo","administrador","123456789");
            
            Statement sql = con.createStatement();
            ResultSet resultado = sql.executeQuery("SELECT*FROM testfisicos WHERE noIdentificacionJugador= "+getJugadorSeleccionado()+ " ORDER BY idTest  DESC LIMIT 1,2; ");
            
            while (resultado.next()) {
               velocidad3 = resultado.getDouble("velocidad");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChartView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sifcnuevo","administrador","123456789");
            
            Statement sql = con.createStatement();
            ResultSet resultado = sql.executeQuery("SELECT*FROM testfisicos WHERE noIdentificacionJugador= "+getJugadorSeleccionado()+ " ORDER BY idTest  DESC LIMIT 1,3; ");
            
            while (resultado.next()) {
               velocidad4 = resultado.getDouble("velocidad");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChartView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sifcnuevo","administrador","123456789");
            
            Statement sql = con.createStatement();
            ResultSet resultado = sql.executeQuery("SELECT*FROM testfisicos WHERE noIdentificacionJugador= "+getJugadorSeleccionado()+ " ORDER BY idTest  DESC LIMIT 1,4; ");
            
            while (resultado.next()) {
               velocidad5 = resultado.getDouble("velocidad");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChartView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        testFisicosDelJugador = tffl.seguimientoGeneralTestFisico(getJugadorSeleccionado());
        return "/sinproteccion/profesor/verSeguimientoGeneralJugador.xhtml?faces-redirect=true";
        
    }
    
}
