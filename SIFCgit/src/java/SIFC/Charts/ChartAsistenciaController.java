/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.Charts;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author cheswill
 */
@Named(value = "chartAsistenciaController")
@RequestScoped
public class ChartAsistenciaController {

    private int asistencias;
    
    public ChartAsistenciaController() {
    }
    
    @PostConstruct
    public void init() {
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sifcnuevo","administrador","123456789");
            
            Statement sql = con.createStatement();
            ResultSet resultado = sql.executeQuery("SELECT count(asistencia)  as asis FROM asistencias WHERE asistencia='a';");
            
            while (resultado.next()) {
                asistencias=resultado.getInt("asis");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChartView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getAsistencias() {
        return asistencias;
    }
    
    

    
    
}
