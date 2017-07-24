/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.categoria.controller;

import DAO.CategoriaFacadeLocal;
import Entities.Categoria;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Cheswill
 */
@Named(value = "listarCategoriaController")
@RequestScoped
public class ListarCategoriaController {

    
    @EJB
    private CategoriaFacadeLocal cfl;
    
    private List<Categoria> categorias;
    private Categoria categoria;
    
    public ListarCategoriaController() {
    }


    @PostConstruct
    public void init(){
    categorias = cfl.findAll();
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }
}
