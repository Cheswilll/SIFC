/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Familia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cheswill
 */
@Stateless
public class FamiliaFacade extends AbstractFacade<Familia> implements FamiliaFacadeLocal {

    @PersistenceContext(unitName = "SIFCgitPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FamiliaFacade() {
        super(Familia.class);
    }
    
}
