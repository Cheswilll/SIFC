/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cheswill
 */
@Local
public interface PersonaFacadeLocal {

    void create(Persona persona);

    void edit(Persona persona);

    void remove(Persona persona);

    Persona find(Object id);

    List<Persona> findAll();

    List<Persona> findRange(int[] range);

    int count();
    
    Persona login(Long noidentificacion, String contraseña);
    
   
     List<Persona> listarJugadoresPorProfesor();
    List<Persona> buscarPorRol();
    List<Persona> buscarPorRolJugador();
    List<Persona> buscarPorRolProfesor();
    List<Persona> buscarPorRolNormal();
    List<Persona> buscarPorRolPadre();
   
}
