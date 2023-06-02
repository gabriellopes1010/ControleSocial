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
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class TrashUsuario extends JFrame {
    
    private final JLabel lbl_nome;
    private final JTextField txt_Usuario;
    private final JButton btnDeletar,btnBack;
    
    public TrashUsuario() {
        setLayout(null);
        setResizable(false);
        setTitle("Tela Exclusão de usuários");
        setSize(400,300);
        setLocationRelativeTo(null);

        
        lbl_nome = new JLabel("Digite o nome dousuario que deseja deletar:");
        txt_Usuario = new JTextField("");
        
        btnDeletar = new JButton("Deletar");
        btnBack = new JButton("Voltar");
        
        lbl_nome.setBounds(60, 20, 250, 30);
        txt_Usuario.setBounds(90, 80, 200, 30);
        
        btnDeletar.setBounds(90, 150, 200, 30);
        btnBack.setBounds(90, 200, 200, 30);
        
        
        btnDeletar.addActionListener((ActionEvent e) -> {
            deletar();
            voltar();
        });
        
        btnBack.addActionListener((ActionEvent e) -> {
            voltar();
        });
        
        add(lbl_nome);
        add(txt_Usuario);
        add(btnDeletar);
        add(btnBack);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    }
    
    private void deletar(){
       String nome = txt_Usuario.getText();
       System.out.println(nome);
       Usuario usuario = new Usuario();
       usuario.deletar(nome);
    }
    
    private void voltar(){
        this.dispose();
        MenuTela menu = new MenuTela();
    }
}
