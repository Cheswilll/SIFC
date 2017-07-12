/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Partido;
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
public class PartidoFacade extends AbstractFacade<Partido> implements PartidoFacadeLocal {

    @PersistenceContext(unitName = "SIFCgitPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PartidoFacade() {
        super(Partido.class);
    }
    
    
    @Override
    public List<Partido> listarPartidosPorProfesor() {
        
        System.out.println("Ejecutando metodo buscar");
        Query q = em.createNativeQuery("SELECT p.* " +
                                "FROM partidos AS p " +
                                "WHERE p.noIdentificacionProfesor= ?;", Partido.class);
        q.setParameter(1, 44444444);
        List<Partido> partidos = q.getResultList();

        for (Partido p : partidos) {
            System.out.println("Listando usuarios Administrador");
        }
        System.out.println(partidos);
        return partidos;
    }
    
}
