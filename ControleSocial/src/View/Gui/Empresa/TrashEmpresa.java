/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Gui.Empresa;

import Controller.Empresa;
import View.Gui.Menu.MenuTela;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author midia
 */
public class TrashEmpresa extends JFrame{

    private final JLabel lbl_razaoSocial;
    private final JFormattedTextField txt_cnpjEmpresa;
    private final JButton btnDeletar,btnBack;
    
    public TrashEmpresa() throws ParseException {
        setSize(400,400);
        setLayout(null);
        setResizable(false);
        this.setLocationRelativeTo(null);
        setTitle("Tela de deleção de Empressa");
        
        
        lbl_razaoSocial = new JLabel("Digite o cnpj da empresa que deseja deletar:");
        txt_cnpjEmpresa =new JFormattedTextField(new MaskFormatter("##. ###. ###/####-##"));
        
        btnDeletar = new JButton("Deletar");
        btnBack = new JButton("Voltar");
        
        lbl_razaoSocial.setBounds(90, 100, 250, 30);
        txt_cnpjEmpresa.setBounds(90, 160, 200, 30);
        
        btnDeletar.setBounds(90, 220, 200, 30);
        btnBack.setBounds(90, 280, 200, 30);
        
        
        btnDeletar.addActionListener((ActionEvent e) -> {
            deletar();
            voltar();
        });
        
        btnBack.addActionListener((ActionEvent e) -> {
            voltar();
        });
        
        add(lbl_razaoSocial);
        add(txt_cnpjEmpresa);
        add(btnDeletar);
        add(btnBack);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    }
    
    private void deletar(){
       String cnpj = txt_cnpjEmpresa.getText().replaceAll("\\D+", "");

        Empresa empresa = new Empresa();
         empresa.deletar(cnpj);
    }
    
    private void voltar(){
        this.dispose();
        MenuTela menu = new MenuTela();
    }
    
}
