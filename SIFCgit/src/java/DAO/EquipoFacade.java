/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Equipo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Cheswill
 */
@Stateless
public class EquipoFacade extends AbstractFacade<Equipo> implements EquipoFacadeLocal {

    @PersistenceContext(unitName = "SIFCgitPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipoFacade() {
        super(Equipo.class);
    }
    
     @Override
    public List<Equipo> listarCategoria() {
        
        
        System.out.println("Ejecutando metodo buscar");
        Query q = em.createNativeQuery("SELECT e.* " +
                                "FROM equipos AS e " +
                                " WHERE e.codigoEquipo= ?;", Equipo.class);
        q.setParameter(1, 12);
        List<Equipo> categoria = q.getResultList();

        for (Equipo p : categoria) {
            System.out.println("Listando categoria Correspondiente");
        }
        System.out.println(categoria);
        return categoria;
    }
    
    
}
