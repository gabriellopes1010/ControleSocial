/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Gui.Login;

import Model.Autenticacao;
import View.Gui.Menu.MenuTela;
import View.Gui.TelaDefault;
import View.Gui.User.CadastroUser;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author midia
 */
public class LoginTela extends TelaDefault implements Runnable{

    private final JLabel lbl_nomeUsuario, lbl_senhaUsuario;
    private final JTextField txt_nomeUsuario, txt_senhaUsuario;
    private final JButton btn_logar,btn_cadastrar;

    public LoginTela() {
        setTitle("Tela de login");
        setSize(300, 250);
        setResizable(false);
        setLocationRelativeTo(null);


        lbl_nomeUsuario = new JLabel("Usuario:");
        lbl_senhaUsuario = new JLabel("Senha:");

        txt_nomeUsuario = new JTextField("");
        txt_senhaUsuario = new JPasswordField();

        btn_logar = new JButton("Logar");
        btn_cadastrar = new JButton("Cadastrar");
        
        lbl_nomeUsuario.setBounds(20, 10, 60, 50);
        txt_nomeUsuario.setBounds(75,26,180, 20);

        lbl_senhaUsuario.setBounds(26, 50, 40, 50);
        txt_senhaUsuario.setBounds(75, 66, 180, 20);

        btn_logar.setBounds(25, 105, 90, 30);
        btn_cadastrar.setBounds(140, 105, 120, 30);
        
        btn_logar.setContentAreaFilled(false);
        btn_logar.setOpaque(true);
        //btn_logar.setBackground(Color.GREEN);

        btn_cadastrar.setContentAreaFilled(false);
        btn_cadastrar.setOpaque(true);
        
        btn_logar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Logar();

                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao executar a ação :" + ex);
                }
            }
        });
        
        btn_cadastrar.addActionListener((ActionEvent e) -> {
            try {
                this.dispose();
                CadastrarUsuario();

            } catch (ParseException ex) {
                System.out.println("Ocorreu um erro ao carregar a tela de cadastro :" + ex);
            }
        });

        add(lbl_nomeUsuario);
        add(lbl_senhaUsuario);
        add(txt_nomeUsuario);
        add(txt_senhaUsuario);
        add(btn_logar);
        add(btn_cadastrar);
        setVisible(true);

    }

    //Pegando os valores dos Campos
    private  synchronized void Logar() throws ParseException {
        String nome = txt_nomeUsuario.getText();
        String senha = txt_senhaUsuario.getText();

        Autenticacao autent = new Autenticacao(nome, senha);

        //autent.Acessa(nome, senha);

        if (autent.Acessa(nome, senha) == true) {
            this.dispose();
            MenuTela menu = new MenuTela();

        }

    }
    
    private void CadastrarUsuario() throws ParseException {
        CadastroUser cadastraUsuario = new CadastroUser();
        
    }
    @Override
    public void run() {
        try {
            this.Logar();
        } catch (ParseException ex) {
            Logger.getLogger(LoginTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
