/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Controlador;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author LENOVO
 */
public class CorreoTest {
    
    public CorreoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of enviarCorreo method, of class Correo.
     */
    @Test
    public void testEnviarCorreo() throws Exception {
        System.out.println("enviarCorreo");
        String correo = "correo.utpssoap@gmail.com";
        String pNombre = "Cristhian";
        String Pkcal = "2200";
        Correo instance = new Correo();
        instance.enviarCorreo(correo, pNombre, Pkcal);
        // TODO review the generated test code and remove the default call to fail.
  //      fail("The test case is a prototype.");
    }
    
}
