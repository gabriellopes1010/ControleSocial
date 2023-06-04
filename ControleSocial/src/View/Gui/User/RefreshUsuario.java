/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Gui.User;

import Controller.Usuario;
import View.Gui.Menu.MenuTela;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * Classe que representa a tela de atualização de usuário.
 */
public class RefreshUsuario extends JFrame {

    private final JLabel lbl_nomeUsuario, lbl_senhaUsuario;
    private final JTextField txt_nomeUsuario, txt_senhaUsuario;
    private final JButton btn_atualizar, btn_voltar;
/**
     * Construtor da classe RefreshUsuario.
     * Cria e configura os componentes da tela.
     */
    public RefreshUsuario() {
        setLayout(null);
        setTitle("Atualização de usuario");
        setSize(300, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        
                        JOptionPane.showMessageDialog(null, "Digite o nome do usuario para atualizar a senha!");


        lbl_nomeUsuario = new JLabel("Nome:");
        lbl_senhaUsuario = new JLabel("nova senha:");

        txt_nomeUsuario = new JTextField();
        txt_senhaUsuario = new JPasswordField();

        btn_atualizar = new JButton("Atualizar");
        btn_voltar = new JButton("Voltar");

        lbl_nomeUsuario.setBounds(20, 0, 200, 50);
        lbl_senhaUsuario.setBounds(20, 60, 200, 50);

        txt_nomeUsuario.setBounds(20, 40, 200, 30);
        txt_senhaUsuario.setBounds(20, 100, 200, 30);

        btn_atualizar.setBounds(20, 150, 200, 30);
        btn_voltar.setBounds(20, 200, 200, 30);

        btn_atualizar.addActionListener((ActionEvent e) -> {
            AtualizarUser();
            voltar();
        });

        btn_voltar.addActionListener((ActionEvent e) -> {
            voltar();
        });

        add(lbl_nomeUsuario);
        add(lbl_senhaUsuario);
        add(txt_nomeUsuario);
        add(txt_senhaUsuario);
        add(btn_atualizar);
        add(btn_voltar);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
/**
     * Método que atualiza os dados do usuário.
     */
    private synchronized void AtualizarUser() {
       
        String nomeuser = txt_nomeUsuario.getText();
        String senhauser = txt_senhaUsuario.getText();
        
        new Usuario(nomeuser, senhauser).atualizar();
    }
  /**
     * Método que volta para a tela de menu.
     */
    private void voltar() {
        this.dispose();
        MenuTela menu = new MenuTela();
    }
}
