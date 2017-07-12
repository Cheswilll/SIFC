/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Seguimiento;
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
public class SeguimientoFacade extends AbstractFacade<Seguimiento> implements SeguimientoFacadeLocal {

    @PersistenceContext(unitName = "SIFCgitPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeguimientoFacade() {
        super(Seguimiento.class);
    }
    
    @Override
    public List<Seguimiento> seguimeintosPorProfesor() {
        
        System.out.println("Ejecutando metodo buscar");
        Query q = em.createNativeQuery("SELECT s.* " +
                                "FROM seguimientos AS s " +
                                "WHERE s.noIdentificacionProfesor = ?;", Seguimiento.class);
        q.setParameter(1, 44444444);
        List<Seguimiento> seguimientos = q.getResultList();

        for (Seguimiento s : seguimientos) {
            System.out.println("Listando usuarios Administrador");
        }
        System.out.println(seguimientos);
        return seguimientos;
    }
    
}
