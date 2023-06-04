/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controller.TemplateMethod;

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
public class DBObjectIT {
    
    public DBObjectIT() {
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
     * Test of inserir method, of class DBObject.
     */
    @Test
    public void testInserir() {
        System.out.println("inserir");
        DBObject instance = new DBObjectImpl();
        instance.inserir();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizar method, of class DBObject.
     */
    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
        DBObject instance = new DBObjectImpl();
        instance.atualizar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletar method, of class DBObject.
     */
    @Test
    public void testDeletar() {
        System.out.println("deletar");
        DBObject instance = new DBObjectImpl();
        instance.deletar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletarTodos method, of class DBObject.
     */
    @Test
    public void testDeletarTodos() {
        System.out.println("deletarTodos");
        DBObject instance = new DBObjectImpl();
        instance.deletarTodos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrar method, of class DBObject.
     */
    @Test
    public void testMostrar() {
        System.out.println("mostrar");
        DBObject instance = new DBObjectImpl();
        instance.mostrar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class DBObjectImpl extends DBObject {
    }
    
}
