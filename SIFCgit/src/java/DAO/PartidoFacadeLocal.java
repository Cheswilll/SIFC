/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Partido;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cheswill
 */
@Local
public interface PartidoFacadeLocal {

    void create(Partido partido);

    void edit(Partido partido);

    void remove(Partido partido);

    Partido find(Object id);

    List<Partido> findAll();

    List<Partido> findRange(int[] range);

    int count();
    
    
    List<Partido> listarPartidosPorProfesor();
    
}
