/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.formulario.controllers;

import DAO.FormularioFacadeLocal;
import Entities.Formulario;
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

/**
 *
 * @author cheswill
 */
@Named(value = "validarCodigoController")
@RequestScoped
public class ValidarCodigoController {

    @EJB
    private FormularioFacadeLocal ffl;
    private Formulario formulario;
    private int codigo;
    
    public ValidarCodigoController() {
    }

    public FormularioFacadeLocal getFfl() {
        return ffl;
    }

    public void setFfl(FormularioFacadeLocal ffl) {
        this.ffl = ffl;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
    
    @PostConstruct
    public void init(){
    try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sifcnuevo","administrador","123456789");
            
            Statement sql = con.createStatement();
            ResultSet resultado = sql.executeQuery("select codigo from codigosvalidacion where codigo= 123456");
            
            while (resultado.next()) {
                System.out.println(resultado.getInt("codigo"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ValidarCodigoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
            
        }
    
    
    
    }
    
    