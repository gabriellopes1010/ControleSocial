/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import DBConnection.DBConnection;
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
import javax.swing.JTextField;

/**
 *
 * @author midia
 */
public class CadastroUsuario extends JFrame {
    public JLabel lblUsuario, lblSenha;
    public JTextField txtUsuario, password;
    public JButton cliqueBtnCriarUsuario;
    
    public CadastroUsuario() throws ParseException {
        setLayout(null);
        
        lblUsuario = new JLabel("Usuário:");
        txtUsuario = new JTextField();
        lblSenha = new JLabel("Senha:");
        password = new JTextField();
        cliqueBtnCriarUsuario = new JButton("Criar Cadastro");
        
        cliqueBtnCriarUsuario.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cliqueBtnCriarUsuario();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
         lblUsuario.setBounds(10, 10, 200, 25);
         txtUsuario.setBounds(70, 10, 250, 25);
         lblSenha.setBounds(10, 60, 200, 25);
         password.setBounds(70, 60, 250, 25);
         cliqueBtnCriarUsuario.setBounds(130, 120, 100, 40);

          getContentPane().add(lblUsuario);
          getContentPane().add(txtUsuario);
          getContentPane().add(lblSenha);
          getContentPane().add(password);
          getContentPane().add(cliqueBtnCriarUsuario);
          
       setSize(400, 250);
       setTitle("Cadastro de usuário");
       setLocationRelativeTo(null);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    private void cliqueBtnCriarUsuario() throws FileNotFoundException, ParseException{
         this.dispose();
        Login login = new Login();
        String usuariotxt = txtUsuario.getText(),
               passwordtxt = password.getText();
        
        System.out.println("usuário " + usuariotxt);
        System.out.println("Senha : " + passwordtxt);
        
        try(PrintWriter pw = new PrintWriter(new File("login.txt"))){
            pw.println("Usuário : " + usuariotxt);
            pw.println("Senha : " + passwordtxt);
    } catch (FileNotFoundException e){
           System.out.println(e);

     
    }
         try {
             DBConnection.users(usuariotxt, passwordtxt);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}

