/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.Charts;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

@ManagedBean (name="charts") 
@RequestScoped
public class ChartView {
    
    private Double velocidad;
    private Double altura;
    private Double resistencia;
    private Double fuerza;
    private Double agilidad;
    private Double peso;
    
    
    @PostConstruct
    public void init() {
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sifcnuevo","administrador","123456789");
            
            Statement sql = con.createStatement();
            ResultSet resultado = sql.executeQuery("SELECT velocidad, altura, resistencia, fuerza, agilidad, peso FROM testfisicos WHERE idTest=1;");
            
            while (resultado.next()) {
                velocidad=resultado.getDouble("velocidad");
                altura=resultado.getDouble("altura");
                resistencia=resultado.getDouble("resistencia");
                fuerza=resultado.getDouble("fuerza");
                agilidad=resultado.getDouble("agilidad");
                peso=resultado.getDouble("peso");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChartView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Double velocidad) {
        this.velocidad = velocidad;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getResistencia() {
        return resistencia;
    }

    public void setResistencia(Double resistencia) {
        this.resistencia = resistencia;
    }

    public Double getFuerza() {
        return fuerza;
    }

    public void setFuerza(Double fuerza) {
        this.fuerza = fuerza;
    }

    public Double getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(Double agilidad) {
        this.agilidad = agilidad;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
    
    
    
 
}
