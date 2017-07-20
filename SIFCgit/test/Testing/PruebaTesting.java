package Testing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Entities.Persona;
import SIFC.persona.controllers.RegistroController;
import org.junit.After;
import java.text.SimpleDateFormat;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cheswill
 */
public class PruebaTesting {
    
    private Persona persona = new Persona();
    private RegistroController rc = new RegistroController();
    
    public PruebaTesting() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        persona.setNombre1("Pedro");
        persona.setNombre2("Camilo");
        persona.setApellido1("Ruiz");
        persona.setApellido2("Guzman");
        persona.setContrasena("1234");
        persona.setDireccion("Crr 121 #76B-11");
        persona.setBarrio("Villas de granada");
        persona.setIdEstado(1);
        persona.setCorreoElectronico("wfmora98@misena.edu.co");
    }
    
    @After
    public void tearDown() {
    }

    
     @Test
     public void Nulo() {
         assertNotNull("Valor nulo",persona.getNombre1());
         assertNotNull("Valor nulo",persona.getNombre2());
         assertNotNull("Valor nulo",persona.getApellido1());
         assertNotNull("Valor nulo",persona.getApellido2());
         assertNotNull("Valor nulo",persona.getContrasena());
         assertNotNull("Valor nulo",persona.getDireccion());
         assertNotNull("Valor nulo",persona.getBarrio());
         assertNotNull("Valor nulo",persona.getIdEstado());
         assertNotNull("Valor nulo",persona.getCorreoElectronico());
     }
     
     @Test
     public void RegistrarPersona(){
        rc.setPersonaNueva(persona);
         assertNotNull("Registrado", persona);
     }
     
     
}
