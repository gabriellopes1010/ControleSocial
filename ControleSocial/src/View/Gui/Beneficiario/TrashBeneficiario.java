/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Gui.Beneficiario;

import Controller.Beneficiario;
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
public class TrashBeneficiario extends JFrame{

    private final JLabel lbl_titulo;
    private final JFormattedTextField txt_cpfDoBeneficiario;
    private final JButton btnDeletar,btnBack;
    
    public TrashBeneficiario() throws ParseException {
        setSize(400,400);
        setLayout(null);
        setResizable(false);
        this.setLocationRelativeTo(null);
        setTitle("Tela de deleção de Beneficiario");
        
        
        lbl_titulo = new JLabel("Digite o cpf do beneficiário que deseja deletar:");
        txt_cpfDoBeneficiario =new JFormattedTextField(new MaskFormatter("###.###.###-##"));
        
        btnDeletar = new JButton("Deletar");
        btnBack = new JButton("Voltar");
        
        lbl_titulo.setBounds(90, 100, 250, 30);
        txt_cpfDoBeneficiario.setBounds(90, 160, 200, 30);
        
        btnDeletar.setBounds(90, 220, 200, 30);
        btnBack.setBounds(90, 280, 200, 30);
        
        
        btnDeletar.addActionListener((ActionEvent e) -> {
            deletar();
            voltar();
        });
        
        btnBack.addActionListener((ActionEvent e) -> {
            voltar();
        });
        
        add(lbl_titulo);
        add(txt_cpfDoBeneficiario);
        add(btnDeletar);
        add(btnBack);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    }
    
    private void deletar(){
       String cpf = txt_cpfDoBeneficiario.getText();
        Beneficiario beneficiario = new Beneficiario();
       beneficiario.deletar(cpf);
    }
    
    private void voltar(){
        this.dispose();
        MenuTela menu = new MenuTela();
    }
    
}

