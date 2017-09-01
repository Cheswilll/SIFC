/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.CodigoValidacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Cheswill
 */
@Stateless
public class CodigoValidacionFacade extends AbstractFacade<CodigoValidacion> implements CodigoValidacionFacadeLocal {

    @PersistenceContext(unitName = "SIFCgitPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CodigoValidacionFacade() {
        super(CodigoValidacion.class);
    }

    @Override
    public CodigoValidacion findByUsuario(Long documento) {
        try {
            getEntityManager().getEntityManagerFactory().getCache().evictAll();
            TypedQuery<CodigoValidacion> c = getEntityManager().createNamedQuery("CodigoValidacion.findByUsuario", CodigoValidacion.class);
            c.setParameter("noIdentificacionPersona", documento);
            return c.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
