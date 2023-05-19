/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import controleSocial.CadastroEmpresa;
import controleSocial.CadastroSocial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;


/**
 *
 * @author midia
 */
public class Menu extends JFrame{
        public JButton btnCadEmpresa;
        public JButton btnCadSocial;
        public JButton btnSair;


        
    public Menu() throws ParseException{
         setLayout(null);
         
    btnCadEmpresa = new JButton("Cad. Empresas");
    btnCadSocial = new JButton("Cad. Social");
    btnCadSocial = new JButton("Cad. Social");
    btnSair = new JButton("Sair");
    
    btnCadEmpresa.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cliqueBtnEmpresa();
                } catch (ParseException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
    btnCadSocial.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cliqueBtnSocial();
                } catch (ParseException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
    
    btnSair.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cliqueBtnSair();
                } catch (ParseException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
    
    
     btnCadEmpresa.setBounds(30, 10, 120, 35);
     btnCadSocial.setBounds(155, 10, 120, 35);
     btnSair.setBounds(206, 60, 70, 25);
     
     getContentPane().add(btnCadEmpresa);
     getContentPane().add(btnCadSocial);
     getContentPane().add(btnSair);     
          
       setSize(320, 150);
       setTitle("Menu");
       setLocationRelativeTo(null);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    private void cliqueBtnEmpresa() throws ParseException{
       
       this.dispose();
       CadastroEmpresa cadastroEmpresa = new CadastroEmpresa();
    }
    
    private void cliqueBtnSocial() throws ParseException{
       
       this.dispose();
       CadastroSocial CadastroSocial = new CadastroSocial();
   
    }
    
    private void cliqueBtnSair() throws ParseException{
       
       this.dispose();
       Login login = new Login();
   
    }
}
