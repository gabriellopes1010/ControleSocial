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
public class EmpresaIT {
    
    public EmpresaIT() {
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
     * Test of inserir method, of class Empresa.
     */
    @Test
    public void testInserir() {
        System.out.println("inserir");
        Empresa instance = new Empresa();
        instance.inserir();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizar method, of class Empresa.
     */
    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
        Empresa instance = new Empresa();
        instance.atualizar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletar method, of class Empresa.
     */
    @Test
    public void testDeletar() {
        System.out.println("deletar");
        String cnpj = "";
        Empresa instance = new Empresa();
        instance.deletar(cnpj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrar method, of class Empresa.
     */
    @Test
    public void testMostrar() {
        System.out.println("mostrar");
        Empresa instance = new Empresa();
        instance.mostrar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
