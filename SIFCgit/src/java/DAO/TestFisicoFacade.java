/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.TestFisico;
import SIFC.login.controllers.SessionController;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Cheswill
 */
@Stateless
public class TestFisicoFacade extends AbstractFacade<TestFisico> implements TestFisicoFacadeLocal, Serializable {

    @PersistenceContext(unitName = "SIFCgitPU")
    private EntityManager em;

    @Inject
    private SessionController sc;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TestFisicoFacade() {
        super(TestFisico.class);
    }

    @Override
    public List<TestFisico> listarTestPorProfesor() {

        System.out.println("Ejecutando metodo buscar");
        Query q = em.createNativeQuery("SELECT t.* "
                + "FROM testfisicos AS t "
                + "WHERE t.noIdentificacionProfesor = ?;", TestFisico.class);
        q.setParameter(1, sc.getPersona().getNoIdentificacion());
        List<TestFisico> testfisicos = q.getResultList();

        for (TestFisico s : testfisicos) {
            System.out.println("Listando seguimientos");
        }
        System.out.println(testfisicos);
        return testfisicos;
    }

    @Override
    public List<TestFisico> listarSeguimientoTestFisico() {

        System.out.println("Ejecutando metodo buscar");
        Query q = em.createNativeQuery("SELECT t.* FROM testfisicos as t JOIN familias JOIN personas "
                + "ON personas.noIdentificacion = t.noIdentificacionJugador "
                + "AND personas.noIdentificacion = t.noIdentificacionJugador "
                + "AND personas.noIdentificacion = familias.noIdentificacionJugador "
                + "AND familias.noIdentificacionPadre= ?;", TestFisico.class);
        q.setParameter(1, sc.getPersona().getNoIdentificacion());
        List<TestFisico> testFisicos = q.getResultList();

        for (TestFisico t : testFisicos) {
            System.out.println("Listando usuarios Administrador");
        }
        System.out.println(testFisicos);
        return testFisicos;
    }

    @Override
    public List<TestFisico> seguimientoGeneralTestFisico(Long noIdJug) {
        
        System.out.println("Ejecutando metodo buscar");
        Query q = em.createNativeQuery("SELECT t.* FROM testfisicos AS t "
                + "WHERE t.noIdentificacionJugador = ?;", TestFisico.class);
        q.setParameter(1, noIdJug);
        List<TestFisico> testFisicos = q.getResultList();

        for (TestFisico t : testFisicos) {
            System.out.println("Listando test del jugador");
        }
        System.out.println(testFisicos);
        return testFisicos;
    }

}
