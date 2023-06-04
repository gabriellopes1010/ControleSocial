/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author midia
 */
public class UsuarioIT {
    
    public UsuarioIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of inserir method, of class Usuario.
     */
    @Test
    public void testInserir() {
        System.out.println("inserir");
        Usuario instance = new Usuario();
        instance.inserir();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrar method, of class Usuario.
     */
    @Test
    public void testMostrar() {
        System.out.println("mostrar");
        Usuario instance = new Usuario();
        instance.mostrar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizar method, of class Usuario.
     */
    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
        Usuario instance = new Usuario();
        instance.atualizar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletar method, of class Usuario.
     */
    @Test
    public void testDeletar() {
        System.out.println("deletar");
        String nome = "";
        Usuario instance = new Usuario();
        instance.deletar(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
