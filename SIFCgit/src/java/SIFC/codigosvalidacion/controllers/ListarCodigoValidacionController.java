/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.codigosvalidacion.controllers;

import DAO.CodigoValidacionFacadeLocal;
import Entities.CodigoValidacion;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author cheswill
 */
@Named(value = "listarCodigoValidacionController")
@RequestScoped
public class ListarCodigoValidacionController {

    @EJB
    private CodigoValidacionFacadeLocal cvfl;
    private List<CodigoValidacion> codigosValidacion;
    
    public ListarCodigoValidacionController() {
    }

    public List<CodigoValidacion> getCodigosValidacion() {
        return codigosValidacion;
    }
    
    @PostConstruct
    public void init(){
    codigosValidacion=cvfl.findAll();
    }
    
    
}
