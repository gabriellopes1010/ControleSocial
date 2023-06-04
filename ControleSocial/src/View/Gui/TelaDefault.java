/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Gui;

import java.awt.HeadlessException;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 * Classe que representa uma tela padrão em um aplicativo Swing.
 */
public class TelaDefault extends JFrame {
  /**
     * Construtor da classe TelaDefault.
     * Cria uma nova instância da tela padrão.
     */
    public TelaDefault(){
        try {
            setLayout(null);
            setSize(300, 600);
            setResizable(true);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            
        } catch (HeadlessException e) {
            System.out.println("Ocorreu um erro ao criar a janela :" + e);
        }
    }
    
}
