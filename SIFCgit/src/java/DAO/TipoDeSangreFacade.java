/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.TipoDeSangre;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Cheswill
 */
@Stateless
public class TipoDeSangreFacade extends AbstractFacade<TipoDeSangre> implements TipoDeSangreFacadeLocal {

    @PersistenceContext(unitName = "SIFCgitPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoDeSangreFacade() {
        super(TipoDeSangre.class);
    }
    
}
