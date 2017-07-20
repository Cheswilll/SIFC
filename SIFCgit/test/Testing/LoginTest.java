/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import SIFC.login.controllers.SessionController;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cheswill
 */
public class LoginTest {
    
    private SessionController sc = new SessionController();
    
    public LoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        sc.setNoidentificacion(1239L);
        sc.setContraseña("1234");
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void Nulo() {
        assertNotNull("Valor nulo", sc.getNoidentificacion());
        assertNotNull("Valor nulo", sc.getContraseña());
    }
    
    @Test
    public void InicioSesion(){
        sc.inicioSesion();
        assertTrue("Inicio", sc.inicioSesion());
    }
}
