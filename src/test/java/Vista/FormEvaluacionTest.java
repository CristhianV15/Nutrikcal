/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Vista;

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
public class FormEvaluacionTest {
    
    public FormEvaluacionTest() {
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
     * Test of Formula method, of class FormEvaluacion.
     */
    @Test
    public void testFormula() {
        System.out.println("Formula");
        int edad = 52;
        double peso = 80;
        int altura = 175;
        String sexo = "Masculino";
        FormEvaluacion instance = new FormEvaluacion();
        int expResult = 1938;
        int result = instance.Formula(edad, peso, altura, sexo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    public int suma(int a, int b){
        a=3;b=2;
//        int result= ()
        return a=+b;
    } 
    
    
            
    /**
     * Test of llenarComboNutricionista method, of class FormEvaluacion.
     */
    @Test
    public void testLlenarComboNutricionista() {
        System.out.println("llenarComboNutricionista");
        FormEvaluacion instance = new FormEvaluacion();
        instance.llenarComboNutricionista();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class FormEvaluacion.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        FormEvaluacion.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
