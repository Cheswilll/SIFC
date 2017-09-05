/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.TestFisico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cheswill
 */
@Local
public interface TestFisicoFacadeLocal {

    void create(TestFisico testFisico);

    void edit(TestFisico testFisico);

    void remove(TestFisico testFisico);

    TestFisico find(Object id);

    List<TestFisico> findAll();

    List<TestFisico> findRange(int[] range);

    int count();
    
    List<TestFisico> listarTestPorProfesor();
    List<TestFisico> listarSeguimientoTestFisico();
    
}
