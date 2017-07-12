/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.EntidadDeSalud;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cheswill
 */
@Local
public interface EntidadDeSaludFacadeLocal {

    void create(EntidadDeSalud entidadDeSalud);

    void edit(EntidadDeSalud entidadDeSalud);

    void remove(EntidadDeSalud entidadDeSalud);

    EntidadDeSalud find(Object id);

    List<EntidadDeSalud> findAll();

    List<EntidadDeSalud> findRange(int[] range);

    int count();
    
}
