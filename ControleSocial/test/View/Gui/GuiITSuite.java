/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */
package View.Gui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author midia
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({View.Gui.Beneficiario.BeneficiarioITSuite.class, View.Gui.Menu.MenuITSuite.class, View.Gui.TelaDefaultIT.class, View.Gui.Empresa.EmpresaITSuite.class, View.Gui.Login.LoginITSuite.class, View.Gui.User.UserITSuite.class})
public class GuiITSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
