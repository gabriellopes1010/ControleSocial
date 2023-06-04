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
 * Classe que representa a tela de deleção de beneficiário.
 */
public class TrashBeneficiario extends JFrame{

    private final JLabel lbl_titulo;
    private final JFormattedTextField txt_cpfDoBeneficiario;
    private final JButton btnDeletar,btnBack;

/**
     * Construtor da classe TrashBeneficiario.
     * Cria uma nova instância da tela de deleção de beneficiário.
     * @throws ParseException Exceção lançada em caso de erro na formatação de dados.
     */    
    public TrashBeneficiario() throws ParseException {
        setSize(400,400);
        setLayout(null);
        setResizable(false);
        this.setLocationRelativeTo(null);
        setTitle("Tela de deleção de Beneficiario");
        
        // Inicialização dos componentes da tela
        lbl_titulo = new JLabel("Digite o cpf do beneficiário que deseja deletar:");
        txt_cpfDoBeneficiario =new JFormattedTextField(new MaskFormatter("###.###.###-##"));
        
        btnDeletar = new JButton("Deletar");
        btnBack = new JButton("Voltar");
        // Configuração dos posicionamentos dos componentes na tela
        lbl_titulo.setBounds(90, 100, 250, 30);
        txt_cpfDoBeneficiario.setBounds(90, 160, 200, 30);
        
        btnDeletar.setBounds(90, 220, 200, 30);
        btnBack.setBounds(90, 280, 200, 30);
        
         // Configuração dos eventos dos botões
        btnDeletar.addActionListener((ActionEvent e) -> {
            deletar();
            voltar();
        });
        
        btnBack.addActionListener((ActionEvent e) -> {
            voltar();
        });
        // Adição dos componentes na tela
        add(lbl_titulo);
        add(txt_cpfDoBeneficiario);
        add(btnDeletar);
        add(btnBack);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    }
     /**
     * Deleta o beneficiário.
     */
    private void deletar(){
       String cpf = txt_cpfDoBeneficiario.getText();
              cpf = cpf.replaceAll("\\D+", "");
        Beneficiario beneficiario = new Beneficiario();
       beneficiario.deletar(cpf);
    }
     /**
     * Volta para a tela do menu principal.
     */
    private void voltar(){
        this.dispose();
        MenuTela menu = new MenuTela();
    }
    
}

