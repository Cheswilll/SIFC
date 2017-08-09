/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.familia.controllers;

import DAO.FamiliaFacadeLocal;
import Entities.Familia;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author cheswill
 */
@Named(value = "listarFamiliaController")
@ViewScoped
public class ListarFamiliaController implements Serializable{

    @EJB
    private FamiliaFacadeLocal ffl;
    private Familia familia;
    private List<Familia> familias;

    public FamiliaFacadeLocal getFfl() {
        return ffl;
    }

    public void setFfl(FamiliaFacadeLocal ffl) {
        this.ffl = ffl;
    }

    public List<Familia> getFamilias() {
        return familias;
    }

    public void setFamilias(List<Familia> familias) {
        this.familias = familias;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }
    
    
    @PostConstruct
    private void init(){
        familias = ffl.findAll();
    }
    
    public ListarFamiliaController() {
    }
    
}
