/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.rh.controllers;

import DAO.TipoDeSangreFacadeLocal;
import Entities.TipoDeSangre;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author APRENDIZ
 */
@Named(value = "listarRhController")
@RequestScoped
public class listarRhController {

    @EJB
    private TipoDeSangreFacadeLocal tdsfl;
    private List<TipoDeSangre> tiposDeSangre;
    
    public listarRhController() {
    }
    
    @PostConstruct
    public void init(){
    tiposDeSangre = tdsfl.findAll();
    }

    public List<TipoDeSangre> getTiposDeSangre() {
        return tiposDeSangre;
    }
    
    
    
}
