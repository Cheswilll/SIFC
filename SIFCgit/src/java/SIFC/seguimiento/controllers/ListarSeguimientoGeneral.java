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
import java.util.Date;
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
    private Double velocidad6;
    private Double velocidad7;
    private Double velocidad8;
    private Double velocidad9;
    private Double velocidad10;
    
    
    private Double agilidad1;
    private Double agilidad2;
    private Double agilidad3;
    private Double agilidad4;
    private Double agilidad5;
    private Double agilidad6;
    private Double agilidad7;
    private Double agilidad8;
    private Double agilidad9;
    private Double agilidad10;
    
    private Double resistencia1;
    private Double resistencia2;
    private Double resistencia3;
    private Double resistencia4;
    private Double resistencia5;
    private Double resistencia6;
    private Double resistencia7;
    private Double resistencia8;
    private Double resistencia9;
    private Double resistencia10;
    
    
    private Double fuerza1;
    private Double fuerza2;
    private Double fuerza3;
    private Double fuerza4;
    private Double fuerza5;
    private Double fuerza6;
    private Double fuerza7;
    private Double fuerza8;
    private Double fuerza9;
    private Double fuerza10;
    
    
    private Double peso1;
    private Double peso2;
    private Double peso3;
    private Double peso4;
    private Double peso5;
    private Double peso6;
    private Double peso7;
    private Double peso8;
    private Double peso9;
    private Double peso10;
    
    private Double altura1;
    private Double altura2;
    private Double altura3;
    private Double altura4;
    private Double altura5;
    private Double altura6;
    private Double altura7;
    private Double altura8;
    private Double altura9;
    private Double altura10;
    
    
    private Date fecha1;
    private Date fecha2;
    private Date fecha3;
    private Date fecha4;
    private Date fecha5;
    private Date fecha6;
    private Date fecha7;
    private Date fecha8;
    private Date fecha9;
    private Date fecha10;
    
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

    public Double getVelocidad6() {
        return velocidad6;
    }

    public void setVelocidad6(Double velocidad6) {
        this.velocidad6 = velocidad6;
    }

    public Double getVelocidad7() {
        return velocidad7;
    }

    public void setVelocidad7(Double velocidad7) {
        this.velocidad7 = velocidad7;
    }

    public Double getVelocidad8() {
        return velocidad8;
    }

    public void setVelocidad8(Double velocidad8) {
        this.velocidad8 = velocidad8;
    }

    public Double getVelocidad9() {
        return velocidad9;
    }

    public void setVelocidad9(Double velocidad9) {
        this.velocidad9 = velocidad9;
    }

    public Double getVelocidad10() {
        return velocidad10;
    }

    public void setVelocidad10(Double velocidad10) {
        this.velocidad10 = velocidad10;
    }

    public Double getAgilidad1() {
        return agilidad1;
    }

    public void setAgilidad1(Double agilidad1) {
        this.agilidad1 = agilidad1;
    }

    public Double getAgilidad2() {
        return agilidad2;
    }

    public void setAgilidad2(Double agilidad2) {
        this.agilidad2 = agilidad2;
    }

    public Double getAgilidad3() {
        return agilidad3;
    }

    public void setAgilidad3(Double agilidad3) {
        this.agilidad3 = agilidad3;
    }

    public Double getAgilidad4() {
        return agilidad4;
    }

    public void setAgilidad4(Double agilidad4) {
        this.agilidad4 = agilidad4;
    }

    public Double getAgilidad5() {
        return agilidad5;
    }

    public void setAgilidad5(Double agilidad5) {
        this.agilidad5 = agilidad5;
    }

    public Double getAgilidad6() {
        return agilidad6;
    }

    public void setAgilidad6(Double agilidad6) {
        this.agilidad6 = agilidad6;
    }

    public Double getAgilidad7() {
        return agilidad7;
    }

    public void setAgilidad7(Double agilidad7) {
        this.agilidad7 = agilidad7;
    }

    public Double getAgilidad8() {
        return agilidad8;
    }

    public void setAgilidad8(Double agilidad8) {
        this.agilidad8 = agilidad8;
    }

    public Double getAgilidad9() {
        return agilidad9;
    }

    public void setAgilidad9(Double agilidad9) {
        this.agilidad9 = agilidad9;
    }

    public Double getAgilidad10() {
        return agilidad10;
    }

    public void setAgilidad10(Double agilidad10) {
        this.agilidad10 = agilidad10;
    }

    public Double getResistencia1() {
        return resistencia1;
    }

    public void setResistencia1(Double resistencia1) {
        this.resistencia1 = resistencia1;
    }

    public Double getResistencia2() {
        return resistencia2;
    }

    public void setResistencia2(Double resistencia2) {
        this.resistencia2 = resistencia2;
    }

    public Double getResistencia3() {
        return resistencia3;
    }

    public void setResistencia3(Double resistencia3) {
        this.resistencia3 = resistencia3;
    }

    public Double getResistencia4() {
        return resistencia4;
    }

    public void setResistencia4(Double resistencia4) {
        this.resistencia4 = resistencia4;
    }

    public Double getResistencia5() {
        return resistencia5;
    }

    public void setResistencia5(Double resistencia5) {
        this.resistencia5 = resistencia5;
    }

    public Double getResistencia6() {
        return resistencia6;
    }

    public void setResistencia6(Double resistencia6) {
        this.resistencia6 = resistencia6;
    }

    public Double getResistencia7() {
        return resistencia7;
    }

    public void setResistencia7(Double resistencia7) {
        this.resistencia7 = resistencia7;
    }

    public Double getResistencia8() {
        return resistencia8;
    }

    public void setResistencia8(Double resistencia8) {
        this.resistencia8 = resistencia8;
    }

    public Double getResistencia9() {
        return resistencia9;
    }

    public void setResistencia9(Double resistencia9) {
        this.resistencia9 = resistencia9;
    }

    public Double getResistencia10() {
        return resistencia10;
    }

    public void setResistencia10(Double resistencia10) {
        this.resistencia10 = resistencia10;
    }

    public Double getFuerza1() {
        return fuerza1;
    }

    public void setFuerza1(Double fuerza1) {
        this.fuerza1 = fuerza1;
    }

    public Double getFuerza2() {
        return fuerza2;
    }

    public void setFuerza2(Double fuerza2) {
        this.fuerza2 = fuerza2;
    }

    public Double getFuerza3() {
        return fuerza3;
    }

    public void setFuerza3(Double fuerza3) {
        this.fuerza3 = fuerza3;
    }

    public Double getFuerza4() {
        return fuerza4;
    }

    public void setFuerza4(Double fuerza4) {
        this.fuerza4 = fuerza4;
    }

    public Double getFuerza5() {
        return fuerza5;
    }

    public void setFuerza5(Double fuerza5) {
        this.fuerza5 = fuerza5;
    }

    public Double getFuerza6() {
        return fuerza6;
    }

    public void setFuerza6(Double fuerza6) {
        this.fuerza6 = fuerza6;
    }

    public Double getFuerza7() {
        return fuerza7;
    }

    public void setFuerza7(Double fuerza7) {
        this.fuerza7 = fuerza7;
    }

    public Double getFuerza8() {
        return fuerza8;
    }

    public void setFuerza8(Double fuerza8) {
        this.fuerza8 = fuerza8;
    }

    public Double getFuerza9() {
        return fuerza9;
    }

    public void setFuerza9(Double fuerza9) {
        this.fuerza9 = fuerza9;
    }

    public Double getFuerza10() {
        return fuerza10;
    }

    public void setFuerza10(Double fuerza10) {
        this.fuerza10 = fuerza10;
    }

    public Double getPeso1() {
        return peso1;
    }

    public void setPeso1(Double peso1) {
        this.peso1 = peso1;
    }

    public Double getPeso2() {
        return peso2;
    }

    public void setPeso2(Double peso2) {
        this.peso2 = peso2;
    }

    public Double getPeso3() {
        return peso3;
    }

    public void setPeso3(Double peso3) {
        this.peso3 = peso3;
    }

    public Double getPeso4() {
        return peso4;
    }

    public void setPeso4(Double peso4) {
        this.peso4 = peso4;
    }

    public Double getPeso5() {
        return peso5;
    }

    public void setPeso5(Double peso5) {
        this.peso5 = peso5;
    }

    public Double getPeso6() {
        return peso6;
    }

    public void setPeso6(Double peso6) {
        this.peso6 = peso6;
    }

    public Double getPeso7() {
        return peso7;
    }

    public void setPeso7(Double peso7) {
        this.peso7 = peso7;
    }

    public Double getPeso8() {
        return peso8;
    }

    public void setPeso8(Double peso8) {
        this.peso8 = peso8;
    }

    public Double getPeso9() {
        return peso9;
    }

    public void setPeso9(Double peso9) {
        this.peso9 = peso9;
    }

    public Double getPeso10() {
        return peso10;
    }

    public void setPeso10(Double peso10) {
        this.peso10 = peso10;
    }

    public Double getAltura1() {
        return altura1;
    }

    public void setAltura1(Double altura1) {
        this.altura1 = altura1;
    }

    public Double getAltura2() {
        return altura2;
    }

    public void setAltura2(Double altura2) {
        this.altura2 = altura2;
    }

    public Double getAltura3() {
        return altura3;
    }

    public void setAltura3(Double altura3) {
        this.altura3 = altura3;
    }

    public Double getAltura4() {
        return altura4;
    }

    public void setAltura4(Double altura4) {
        this.altura4 = altura4;
    }

    public Double getAltura5() {
        return altura5;
    }

    public void setAltura5(Double altura5) {
        this.altura5 = altura5;
    }

    public Double getAltura6() {
        return altura6;
    }

    public void setAltura6(Double altura6) {
        this.altura6 = altura6;
    }

    public Double getAltura7() {
        return altura7;
    }

    public void setAltura7(Double altura7) {
        this.altura7 = altura7;
    }

    public Double getAltura8() {
        return altura8;
    }

    public void setAltura8(Double altura8) {
        this.altura8 = altura8;
    }

    public Double getAltura9() {
        return altura9;
    }

    public void setAltura9(Double altura9) {
        this.altura9 = altura9;
    }

    public Double getAltura10() {
        return altura10;
    }

    public void setAltura10(Double altura10) {
        this.altura10 = altura10;
    }

    public Date getFecha1() {
        return fecha1;
    }

    public void setFecha1(Date fecha1) {
        this.fecha1 = fecha1;
    }

    public Date getFecha2() {
        return fecha2;
    }

    public void setFecha2(Date fecha2) {
        this.fecha2 = fecha2;
    }

    public Date getFecha3() {
        return fecha3;
    }

    public void setFecha3(Date fecha3) {
        this.fecha3 = fecha3;
    }

    public Date getFecha4() {
        return fecha4;
    }

    public void setFecha4(Date fecha4) {
        this.fecha4 = fecha4;
    }

    public Date getFecha5() {
        return fecha5;
    }

    public void setFecha5(Date fecha5) {
        this.fecha5 = fecha5;
    }

    public Date getFecha6() {
        return fecha6;
    }

    public void setFecha6(Date fecha6) {
        this.fecha6 = fecha6;
    }

    public Date getFecha7() {
        return fecha7;
    }

    public void setFecha7(Date fecha7) {
        this.fecha7 = fecha7;
    }

    public Date getFecha8() {
        return fecha8;
    }

    public void setFecha8(Date fecha8) {
        this.fecha8 = fecha8;
    }

    public Date getFecha9() {
        return fecha9;
    }

    public void setFecha9(Date fecha9) {
        this.fecha9 = fecha9;
    }

    public Date getFecha10() {
        return fecha10;
    }

    public void setFecha10(Date fecha10) {
        this.fecha10 = fecha10;
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
               agilidad1 = resultado.getDouble("agilidad");
               resistencia1 = resultado.getDouble("resistencia");
               fuerza1 = resultado.getDouble("fuerza");
               peso1 = resultado.getDouble("peso");
               altura1 = resultado.getDouble("altura");
               fecha1 = resultado.getDate("fechaTestFisico");
               
                
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
               agilidad2 = resultado.getDouble("agilidad");
               resistencia2 = resultado.getDouble("resistencia");
               fuerza2 = resultado.getDouble("fuerza");
               peso2 = resultado.getDouble("peso");
               altura2 = resultado.getDouble("altura");
               fecha2 = resultado.getDate("fechaTestFisico");
                
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
               agilidad3 = resultado.getDouble("agilidad");
               resistencia3 = resultado.getDouble("resistencia");
               fuerza3 = resultado.getDouble("fuerza");
               peso3 = resultado.getDouble("peso");
               altura3 = resultado.getDouble("altura");
               fecha3 = resultado.getDate("fechaTestFisico");
                
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
               agilidad4 = resultado.getDouble("agilidad");
               resistencia4 = resultado.getDouble("resistencia");
               fuerza4 = resultado.getDouble("fuerza");
               peso4 = resultado.getDouble("peso");
               altura4 = resultado.getDouble("altura");
               fecha4 = resultado.getDate("fechaTestFisico");
                
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
               agilidad5 = resultado.getDouble("agilidad");
               resistencia5 = resultado.getDouble("resistencia");
               fuerza5 = resultado.getDouble("fuerza");
               peso5 = resultado.getDouble("peso");
               altura5 = resultado.getDouble("altura");
               fecha5 = resultado.getDate("fechaTestFisico");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChartView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sifcnuevo","administrador","123456789");
            
            Statement sql = con.createStatement();
            ResultSet resultado = sql.executeQuery("SELECT*FROM testfisicos WHERE noIdentificacionJugador= "+getJugadorSeleccionado()+ " ORDER BY idTest  DESC LIMIT 1,5; ");
            
            while (resultado.next()) {
               velocidad6 = resultado.getDouble("velocidad");
               agilidad6 = resultado.getDouble("agilidad");
               resistencia6 = resultado.getDouble("resistencia");
               fuerza6 = resultado.getDouble("fuerza");
               peso6 = resultado.getDouble("peso");
               altura6 = resultado.getDouble("altura");
               fecha6 = resultado.getDate("fechaTestFisico");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChartView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sifcnuevo","administrador","123456789");
            
            Statement sql = con.createStatement();
            ResultSet resultado = sql.executeQuery("SELECT*FROM testfisicos WHERE noIdentificacionJugador= "+getJugadorSeleccionado()+ " ORDER BY idTest  DESC LIMIT 1,6; ");
            
            while (resultado.next()) {
               velocidad7 = resultado.getDouble("velocidad");
               agilidad7 = resultado.getDouble("agilidad");
               resistencia7 = resultado.getDouble("resistencia");
               fuerza7 = resultado.getDouble("fuerza");
               peso7 = resultado.getDouble("peso");
               altura7 = resultado.getDouble("altura");
               fecha7 = resultado.getDate("fechaTestFisico");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChartView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sifcnuevo","administrador","123456789");
            
            Statement sql = con.createStatement();
            ResultSet resultado = sql.executeQuery("SELECT*FROM testfisicos WHERE noIdentificacionJugador= "+getJugadorSeleccionado()+ " ORDER BY idTest  DESC LIMIT 1,7; ");
            
            while (resultado.next()) {
               velocidad8 = resultado.getDouble("velocidad");
               agilidad8 = resultado.getDouble("agilidad");
               resistencia8 = resultado.getDouble("resistencia");
               fuerza8 = resultado.getDouble("fuerza");
               peso8 = resultado.getDouble("peso");
               altura8 = resultado.getDouble("altura");
               fecha8 = resultado.getDate("fechaTestFisico");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChartView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sifcnuevo","administrador","123456789");
            
            Statement sql = con.createStatement();
            ResultSet resultado = sql.executeQuery("SELECT*FROM testfisicos WHERE noIdentificacionJugador= "+getJugadorSeleccionado()+ " ORDER BY idTest  DESC LIMIT 1,8; ");
            
            while (resultado.next()) {
               velocidad9 = resultado.getDouble("velocidad");
               agilidad9 = resultado.getDouble("agilidad");
               resistencia9 = resultado.getDouble("resistencia");
               fuerza9 = resultado.getDouble("fuerza");
               peso9 = resultado.getDouble("peso");
               altura9 = resultado.getDouble("altura");
               fecha9 = resultado.getDate("fechaTestFisico");
               
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChartView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sifcnuevo","administrador","123456789");
            
            Statement sql = con.createStatement();
            ResultSet resultado = sql.executeQuery("SELECT*FROM testfisicos WHERE noIdentificacionJugador= "+getJugadorSeleccionado()+ " ORDER BY idTest  DESC LIMIT 1,9; ");
            
            while (resultado.next()) {
               velocidad10 = resultado.getDouble("velocidad");
               agilidad10 = resultado.getDouble("agilidad");
               resistencia10 = resultado.getDouble("resistencia");
               fuerza10 = resultado.getDouble("fuerza");
               peso10 = resultado.getDouble("peso");
               altura10 = resultado.getDouble("altura");
               fecha10 = resultado.getDate("fechaTestFisico");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChartView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        testFisicosDelJugador = tffl.seguimientoGeneralTestFisico(getJugadorSeleccionado());
        return "/sinproteccion/profesor/verSeguimientoGeneralJugador.xhtml?faces-redirect=true";
        
    }
    
}
