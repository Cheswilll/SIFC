/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.asistencia.controllers;

import DAO.AsistenciaFacadeLocal;
import Entities.Asistencia;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Cheswill
 */
@Named(value = "listarAsistenciaController")
@ViewScoped
public class ListarAsistenciaController implements Serializable{

    @EJB
    private AsistenciaFacadeLocal afl;
    private List<Asistencia> asistencias;
    
    public ListarAsistenciaController() {
    }
    
    @PostConstruct
    public void init(){
        asistencias = afl.findAll();
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }
    
    

    
    
    
    
}
