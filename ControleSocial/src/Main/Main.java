/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Controller.InsertArquivo;
import View.Gui.Beneficiario.TrashBeneficiario;
import View.Gui.Login.LoginTela;
import View.Gui.Menu.MenuTela;
import java.text.ParseException;

/**
 *
 * @author midia
 */
public class Main {
    public static void main(String[] args) throws ParseException{
        
        InsertArquivo insertArquivo = new InsertArquivo();
        Thread thread = new Thread(insertArquivo);
        thread.start();
        
        LoginTela Login = new LoginTela();
        //MenuTela menu = new MenuTela();
             

}
}
