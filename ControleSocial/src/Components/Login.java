/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author midia
 */
public class Login extends JFrame {
    public JLabel lblUsuario, lblSenha;
    public JTextField txtUsuario,password;
    public JButton btnLogar,btnCadastro ;
    
    public Login() throws ParseException {
        setLayout(null);
        
        lblUsuario = new JLabel("Usuário:");
        txtUsuario = new JTextField();
        lblSenha = new JLabel("Senha:");
        password = new JTextField();
        btnLogar = new JButton("Logar");
        btnCadastro = new JButton("Cadastro");
        
        btnLogar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cliqueBtnLogar();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        btnCadastro.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cliqueBtnCadastrar();
                }  catch (ParseException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
         lblUsuario.setBounds(10, 10, 200, 25);
         txtUsuario.setBounds(70, 10, 250, 25);
         lblSenha.setBounds(10, 60, 200, 25);
         password.setBounds(70, 60, 250, 25);
         btnLogar.setBounds(80, 120, 100, 40);
         btnCadastro.setBounds(200, 120, 100, 40);


          getContentPane().add(lblUsuario);
          getContentPane().add(txtUsuario);
          getContentPane().add(lblSenha);
          getContentPane().add(password);
          getContentPane().add(btnLogar);
          getContentPane().add(btnCadastro);

          
       setSize(400, 250);
       setTitle("Login");
       setLocationRelativeTo(null);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    private void cliqueBtnLogar() throws FileNotFoundException{
            String u = txtUsuario.getText(),
                   p = password.getText();
            
        }
    private void cliqueBtnCadastrar() throws FileNotFoundException, ParseException{
        this.dispose();
       CadastroUsuario cadastroUsuario = new CadastroUsuario();
        }
}

