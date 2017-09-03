/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Persona;
import SIFC.login.controllers.SessionController;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Cheswill
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> implements PersonaFacadeLocal, Serializable {

    @PersistenceContext(unitName = "SIFCgitPU")
    private EntityManager em;

    
    @Inject
    private SessionController sc;

    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
    
    public Persona login(Long noidentificacion, String contraseña) {
        try {

            TypedQuery<Persona> q = getEntityManager().createNamedQuery("Persona.findLogin", Persona.class);
            q.setParameter("noIdentificacion", noidentificacion);
            q.setParameter("contraseña", contraseña);
            return q.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List<Persona> buscarPorRol() {
        
        
        System.out.println("Ejecutando metodo buscar");
        Query q = em.createNativeQuery("SELECT p.* " +
                                "FROM personas AS p join rolesdepersonas join roles " +
                                "on p.noIdentificacion = rolesdepersonas.noIdentificacion and rolesdepersonas.idRol "
                                + "= roles.idRol AND roles.idRol=?;", Persona.class);
        q.setParameter(1, 1);
        List<Persona> personas = q.getResultList();

        for (Persona p : personas) {
            System.out.println("Listando usuarios Administrador");
        }
        System.out.println(personas);
        return personas;
    }
    
    @Override
    public List<Persona> buscarPorRolJugador() {
        
        
        System.out.println("Ejecutando metodo buscar");
        Query q = em.createNativeQuery("SELECT p.* " +
                                "FROM personas AS p join rolesdepersonas join roles " +
                                "on p.noIdentificacion = rolesdepersonas.noIdentificacion and rolesdepersonas.idRol "
                                + "= roles.idRol AND roles.idRol=?;", Persona.class);
        q.setParameter(1, 3);
        List<Persona> personas = q.getResultList();

        for (Persona p : personas) {
            System.out.println("Listando usuarios Jugadores");
        }
        System.out.println(personas);
        return personas;
    }
    
    @Override
    public List<Persona> buscarPorRolProfesor() {
        
        
        System.out.println("Ejecutando metodo buscar");
        Query q = em.createNativeQuery("SELECT p.* " +
                                "FROM personas AS p join rolesdepersonas join roles " +
                                "on p.noIdentificacion = rolesdepersonas.noIdentificacion and rolesdepersonas.idRol "
                                + "= roles.idRol AND roles.idRol=?;", Persona.class);
        q.setParameter(1, 2);
        List<Persona> personas = q.getResultList();

        for (Persona p : personas) {
            System.out.println("Listando usuarios Jugadores");
        }
        System.out.println(personas);
        return personas;
    }
    
    @Override
    public List<Persona> buscarPorRolNormal() {
        
        
        System.out.println("Ejecutando metodo buscar");
        Query q = em.createNativeQuery("SELECT p.* " +
                                "FROM personas AS p join rolesdepersonas join roles " +
                                "on p.noIdentificacion = rolesdepersonas.noIdentificacion and rolesdepersonas.idRol "
                                + "= roles.idRol AND roles.idRol=?;", Persona.class);
        q.setParameter(1, 4);
        List<Persona> personas = q.getResultList();

        for (Persona p : personas) {
            System.out.println("Listando usuarios Jugadores");
        }
        System.out.println(personas);
        return personas;
    }

    @Override
    public List<Persona> listarJugadoresPorProfesor() {
        
        
        System.out.println("Ejecutando metodo buscar");
        Query q = em.createNativeQuery("SELECT p.* " +
                                "FROM personas AS p JOIN equipos " +
                                "ON p.noIdentificacion = equipos.noIdentificacionJugador AND  "
                                + "equipos.noIdentificacionnProfesor = ?;", Persona.class);
        q.setParameter(1, sc.getPersona().getNoIdentificacion());
        List<Persona> personasJugadores = q.getResultList();

        for (Persona p : personasJugadores) {
            System.out.println("Listando usuarios Jugadores");
        }
        System.out.println(personasJugadores);
        return personasJugadores;
    }
    
}
