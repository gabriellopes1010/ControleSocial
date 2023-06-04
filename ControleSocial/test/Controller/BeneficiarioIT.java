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
public class BeneficiarioIT {
    
    public BeneficiarioIT() {
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
     * Test of inserir method, of class Beneficiario.
     */
    @Test
    public void testInserir() {
        System.out.println("inserir");
        Beneficiario instance = new Beneficiario();
        instance.inserir();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizar method, of class Beneficiario.
     */
    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
        Beneficiario instance = new Beneficiario();
        instance.atualizar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletar method, of class Beneficiario.
     */
    @Test
    public void testDeletar() {
        System.out.println("deletar");
        String cpf = "";
        Beneficiario instance = new Beneficiario();
        instance.deletar(cpf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrar method, of class Beneficiario.
     */
    @Test
    public void testMostrar() {
        System.out.println("mostrar");
        Beneficiario instance = new Beneficiario();
        instance.mostrar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
