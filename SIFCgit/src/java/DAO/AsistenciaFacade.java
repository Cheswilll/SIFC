/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Asistencia;
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
public class AsistenciaFacade extends AbstractFacade<Asistencia> implements AsistenciaFacadeLocal, Serializable {

    @PersistenceContext(unitName = "SIFCgitPU")
    private EntityManager em;

    @Inject
    private SessionController sc;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsistenciaFacade() {
        super(Asistencia.class);
    }

    @Override
    public List<Asistencia> listarAsistencias() {
        System.out.println("Ejecutando metodo buscar");
        Query q = em.createNativeQuery("SELECT a.* "
                + "FROM asistencias AS a "
                + " WHERE a.noIdentificacionProfesor= ?;", Asistencia.class);
        q.setParameter(1, sc.getPersona().getNoIdentificacion());
        List<Asistencia> asistencia = q.getResultList();

        for (Asistencia p : asistencia) {
            System.out.println("Listando Asistencia Correspondiente");
        }
        System.out.println(asistencia);
        return asistencia;
    }

    @Override
    public List<Asistencia> listarAsistenciasPorJugador(Long noidJug) {

           try {
            getEntityManager().getEntityManagerFactory().getCache().evictAll();
            System.out.println("Ejecutando metodo buscar");
            Query q = em.createNativeQuery("SELECT a.* "
                    + "FROM asistencias AS a "
                    + " WHERE a.noIdentificacionJugador= ?;", Asistencia.class);
            q.setParameter(1, noidJug);
            List<Asistencia> asistencias = q.getResultList();

            for (Asistencia p : asistencias) {
                System.out.println("Listando Asistencia Correspondiente");
            }
            System.out.println(asistencias);
            return asistencias;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Fallo la busqueda de la inscripcion por torneo");
            return null;
        }
        
    }

}
