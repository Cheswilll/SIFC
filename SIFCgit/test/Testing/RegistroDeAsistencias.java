/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import DAO.AsistenciaFacadeLocal;
import DAO.PersonaFacadeLocal;
import Entities.Asistencia;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cheswill
 */
public class RegistroDeAsistencias {

    
    @EJB
    private PersonaFacadeLocal pfl;
    
    @EJB
    private AsistenciaFacadeLocal afl;
    
    private Asistencia asistencia;

    Integer diaNacimiento = 15;
    Integer mesNacimiento = 11;
    Integer añoNacimiento = 1999;
    Date fecha = new Date(añoNacimiento, mesNacimiento, diaNacimiento);
    
    @PostConstruct
    public void init(){
     asistencia = new Asistencia();
    }
    
    public RegistroDeAsistencias() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    public AsistenciaFacadeLocal getAfl() {
        return afl;
    }

    public void setAfl(AsistenciaFacadeLocal afl) {
        this.afl = afl;
    }

    public Asistencia getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Asistencia asistencia) {
        this.asistencia = asistencia;
    }
    
    
    
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void Nulo() {
  
     }
     
     @Test
     public void Registro(){
         afl.create(asistencia);
         init();
         
     }
}
