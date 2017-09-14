/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Seguimiento;
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
public class SeguimientoFacade extends AbstractFacade<Seguimiento> implements SeguimientoFacadeLocal, Serializable {

    @PersistenceContext(unitName = "SIFCgitPU")
    private EntityManager em;

    @Inject
    private SessionController sc;

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
        Query q = em.createNativeQuery("SELECT s.* "
                + "FROM seguimientos AS s "
                + "WHERE s.noIdentificacionProfesor = ?;", Seguimiento.class);
        q.setParameter(1, sc.getPersona().getNoIdentificacion());
        List<Seguimiento> seguimientos = q.getResultList();

        for (Seguimiento s : seguimientos) {
            System.out.println("Listando seguimientos");
        }
        System.out.println(seguimientos);
        return seguimientos;
    }

    @Override
    public List<Seguimiento> listarSeguimientosDeSeguimientos() {

        System.out.println("Ejecutando metodo buscar");
        Query q = em.createNativeQuery("SELECT s.* "
                + "FROM seguimientos AS s JOIN familias JOIN personas "
                + "ON personas.noIdentificacion = s.noIdentificacionJugador AND personas.noIdentificacion = s.noIdentificacionJugador AND personas.noIdentificacion = familias.noIdentificacionJugador  "
                + "AND familias.noIdentificacionPadre= ?;", Seguimiento.class);
        q.setParameter(1, sc.getPersona().getNoIdentificacion());
        List<Seguimiento> seguimientos = q.getResultList();

        for (Seguimiento s : seguimientos) {
            System.out.println("Listando usuarios Administrador");
        }
        System.out.println(seguimientos);
        return seguimientos;
    }

    @Override
    public List<Seguimiento> seguimientosEnGeneral(Long noIdJug) {

        System.out.println("Ejecutando metodo buscar");
        Query q = em.createNativeQuery("SELECT s.* "
                + "FROM seguimientos AS s "
                + " WHERE s.noIdentificacionJugador= ?;", Seguimiento.class);
        q.setParameter(1, noIdJug);
        List<Seguimiento> seguimientos = q.getResultList();

        for (Seguimiento s : seguimientos) {
            System.out.println("Listando seguimientos");
        }
        System.out.println(seguimientos);
        return seguimientos;
    }

}
