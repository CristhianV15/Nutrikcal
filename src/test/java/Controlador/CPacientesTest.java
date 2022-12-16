/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Controlador;

import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
public class CPacientesTest {
    
    public CPacientesTest() {
    }

    /**
     *
     * @throws Exception
     */
    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }

    /**
     * Test of mostrarPacientes method, of class CPacientes.
     */
    @org.junit.jupiter.api.Test
    public void testMostrarPacientes() {
        System.out.println("mostrarPacientes");
        JTable paramTablaPacientes = null;
        CPacientes instance = new CPacientes();
        instance.mostrarPacientes(paramTablaPacientes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SeleccionarPacientes method, of class CPacientes.
     */
    @org.junit.jupiter.api.Test
    public void testSeleccionarPacientes() {
        System.out.println("SeleccionarPacientes");
        JTable paramTablaPacientes = null;
        JTextField pCodigo = null;
        JTextField pNombre = null;
        JTextField pApellido = null;
        JTextField pTelefono = null;
        JTextField pCorreo = null;
        JTextField pSexo = null;
        JTextArea pDatosA = null;
        JDateChooser pFechaNac = null;
        JTextField pDNI = null;
        JTextField pFechaString = null;
        CPacientes instance = new CPacientes();
        instance.SeleccionarPacientes(paramTablaPacientes, pCodigo, pNombre, pApellido, pTelefono, pCorreo, pSexo, pDatosA, pFechaNac, pDNI, pFechaString);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of InsertarPacientes method, of class CPacientes.
     */
    @org.junit.jupiter.api.Test
    public void testInsertarPacientes() {
        System.out.println("InsertarPacientes");
        JTextField pNombre = new JTextField();
//    when(myLabel.getText()).thenReturn("some text");
//    assertEquals("some text", myLabel.getText());    
        pNombre.setText("Daniela");
        assertEquals("Daniela", pNombre.getText());
        JTextField pApellido = new JTextField();
        pApellido.setText("Sosa");
        JTextField pTelefono = new JTextField();
        pTelefono.setText("987456321");
        JTextField pCorreo = new JTextField();
        pCorreo.setText("daniela.sosa@gmail.com");
        JTextField pSexo = new JTextField();
        pSexo.setText("F");
        JTextArea pDatosA = new JTextArea();
        pSexo.setText("--");
        JDateChooser pFechaNac = new JDateChooser();
        Date fechaActual= new Date();
        pFechaNac.setDate(fechaActual);
        JTextField pDNI = new JTextField();
        pDNI.setText("72899564");
        CPacientes instance = new CPacientes();
        instance.InsertarPacientes(pNombre, pApellido, pTelefono, pCorreo, pSexo, pDatosA, pFechaNac, pDNI);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("Fallo el insertarPacientes");
    }

    /**
     * Test of ModificarPacientes method, of class CPacientes.
     */
    @org.junit.jupiter.api.Test
    public void testModificarPacientes() {
        System.out.println("ModificarPacientes");
        JTextField pCodigo = null;
        JTextField pNombre = null;
        JTextField pApellido = null;
        JTextField pTelefono = null;
        JTextField pCorreo = null;
        JTextField pSexo = null;
        JTextArea pDatosA = null;
        JDateChooser pFechaNac = null;
        JTextField pDNI = null;
        CPacientes instance = new CPacientes();
        instance.ModificarPacientes(pCodigo, pNombre, pApellido, pTelefono, pCorreo, pSexo, pDatosA, pFechaNac, pDNI);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPaciente method, of class CPacientes.
     */
    @org.junit.jupiter.api.Test
    public void testBuscarPaciente() {
        System.out.println("buscarPaciente");
        JTextField pDNI = null;
        JTable paramTablaPacientes = null;
        CPacientes instance = new CPacientes();
        instance.buscarPaciente(pDNI, paramTablaPacientes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularEdad method, of class CPacientes.
     */
    @org.junit.jupiter.api.Test
    public void testCalcularEdad() {
        System.out.println("calcularEdad");
        JTextField pDNI =  new JTextField();
        pDNI.setText("789456132");
        JTextField pSexo =  new JTextField();
        pSexo.setText("F");
        JTextField pEdad =  new JTextField();
        pEdad.setText("20");
        CPacientes instance = new CPacientes();
        instance.calcularEdad(pDNI, pSexo, pEdad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of EliminarPacientes method, of class CPacientes.
     */
    @org.junit.jupiter.api.Test
    public void testEliminarPacientes() {
        System.out.println("EliminarPacientes");
        JTextField pCodigo = null;
        CPacientes instance = new CPacientes();
        instance.EliminarPacientes(pCodigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
