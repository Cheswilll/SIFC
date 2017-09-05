/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Partido;
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
public class PartidoFacade extends AbstractFacade<Partido> implements PartidoFacadeLocal, Serializable {

    @PersistenceContext(unitName = "SIFCgitPU")
    private EntityManager em;

    @Inject
    private SessionController sc;

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
        Query q = em.createNativeQuery("SELECT p.* "
                + "FROM partidos AS p "
                + "WHERE p.noIdentificacionProfesor= ?;", Partido.class);
        q.setParameter(1, sc.getPersona().getNoIdentificacion());
        List<Partido> partidos = q.getResultList();

        for (Partido p : partidos) {
            System.out.println("Listando partidos");
        }
        System.out.println(partidos);
        return partidos;
    }

    @Override
    public List<Partido> listarSeguimientoPartidos() {

        System.out.println("Ejecutando metodo buscar");
        Query q = em.createNativeQuery("SELECT p.* "
                + "FROM partidos AS p JOIN familias JOIN personas "
                + "ON personas.noIdentificacion = p.noIdentificacionProfesor AND personas.noIdentificacion = familias.noIdentificacionJugador AND personas.noIdentificacion = familias.noIdentificacionPadre  "
                + "AND familias.noIdentificacionPadre= ?;", Partido.class);
        q.setParameter(1, sc.getPersona().getNoIdentificacion());
        List<Partido> partidos = q.getResultList();

        for (Partido p : partidos) {
            System.out.println("Listando usuarios Administrador");
        }
        System.out.println(partidos);
        return partidos;
    }

    @Override
    public List<Partido> listarPartidosPorEquipo(Integer codigoEquipo) {

        System.out.println("Ejecutando metodo buscar");
        Query q = em.createNativeQuery("SELECT p.* FROM partidos AS p JOIN personas JOIN equipos "
                + "ON personas.noIdentificacion = equipos.noIdentificacionJugador "
                + "AND equipos.codigoEquipo= ? GROUP BY p.idPartido;", Partido.class);
        q.setParameter(1,codigoEquipo);
        List<Partido> partidos = q.getResultList();

        for (Partido p : partidos) {
            System.out.println("Listando usuarios Administrador");
        }
        System.out.println(partidos);
        return partidos;

    }

   

}
