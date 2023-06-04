/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Controller.InsertArquivo;
import View.Gui.Login.LoginTela;
import java.text.ParseException;

/**
 * Classe principal do programa.
 */
public class Main {
    /**
     * Método principal que inicia a aplicação.
     *
     * @param args Argumentos de linha de comando.
     * @throws ParseException Exceção lançada em caso de erro na análise.
     */
    public static void main(String[] args) throws ParseException{
        // Cria uma instância de InsertArquivo e inicia uma nova thread
        InsertArquivo insertArquivo = new InsertArquivo();
        Thread thread = new Thread(insertArquivo);
        thread.start();
        
        // Cria uma instância de LoginTela
        LoginTela Login = new LoginTela();
             

}
}
