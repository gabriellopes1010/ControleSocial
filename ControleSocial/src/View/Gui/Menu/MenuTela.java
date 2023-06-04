/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Gui.Menu;

import Controller.Empresa;
import Controller.Beneficiario;
import Controller.Usuario;
import View.Gui.Beneficiario.CadBeneficiario;
import View.Gui.Beneficiario.RefreshBeneficiario;
import View.Gui.Beneficiario.TrashBeneficiario;
import View.Gui.Empresa.CadEmpresa;
import View.Gui.Empresa.RefreshEmpresa;
import View.Gui.Empresa.TrashEmpresa;
import View.Gui.Login.LoginTela;
import View.Gui.User.CadastroUser;
import View.Gui.User.RefreshUsuario;
import View.Gui.User.TrashUsuario;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * Classe que representa a tela de menu do sistema.
 */
public class MenuTela extends JFrame {

    private final JButton btn_cadBeneficiario, btn_cadEmpresa, btn_cadastroUser;
    private final JButton btn_mostrarBeneficiario, btn_mostraEmpresa, btn_mostrarUser;
    private final JButton btn_alteraBeneficiario, btn_alteraEmpresa, btn_alteraUser;
    private final JButton btn_deletaBeneficiario, btn_deletaEmpresa, btn_deletaUser, btn_sair;
 /**
     * Construtor da classe MenuTela.
     * Cria uma nova instância da tela de menu.
     */
    public MenuTela() {
        setSize(550, 300);
        setTitle("Menu");
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
         // Criação dos botões e configuração dos posicionamentos na tela
        
        // Botões para a seção de Beneficiário
        btn_cadBeneficiario = new JButton("Cadastrar Beneficiário");
        btn_cadBeneficiario.setBounds(20, 20, 150, 30);
        
        btn_mostrarBeneficiario = new JButton("Mostrar Beneficiário");
        btn_mostrarBeneficiario.setBounds(20, 60, 150, 30);
        
        btn_alteraBeneficiario = new JButton("Atualizar beneficiário");
        btn_alteraBeneficiario.setBounds(20, 100, 150, 30);
        
        btn_deletaBeneficiario = new JButton("Deletar beneficiário");
        btn_deletaBeneficiario.setBounds(20, 140, 150, 30);

        // Botões para a seção de Empresa
        btn_cadEmpresa = new JButton("Cadastrar Empresa");
        btn_cadEmpresa.setBounds(190, 20, 150, 30);
        
        btn_mostraEmpresa = new JButton("Mostrar Empresa");
        btn_mostraEmpresa.setBounds(190, 60, 150, 30);
        
        btn_alteraEmpresa = new JButton("Atualizar empresa");
        btn_alteraEmpresa.setBounds(190, 100, 150, 30);
        
        btn_deletaEmpresa = new JButton("Deletar empresa");
        btn_deletaEmpresa.setBounds(190, 140, 150, 30);
        
        // Botões para a seção de Usuário
        btn_cadastroUser = new JButton("Cadastrar Usuário");
        btn_cadastroUser.setBounds(360, 20, 150, 30);
        
        btn_mostrarUser = new JButton("Mostrar usuários");
        btn_mostrarUser.setBounds(360, 60, 150, 30);
        
        btn_alteraUser = new JButton("Atualizar usuário");
        btn_alteraUser.setBounds(360, 100, 150, 30);
        
        btn_deletaUser = new JButton("Deletar usuário");
        btn_deletaUser.setBounds(360, 140, 150, 30);
        
        // Botão para sair
        btn_sair = new JButton("Sair");
        btn_sair.setBounds(360, 200, 150, 30);
        btn_sair.setContentAreaFilled(false);
        btn_sair.setOpaque(true);

        // Adiciona ações aos botões

        btn_cadEmpresa.addActionListener((ActionEvent e) -> {
            try {
                this.dispose();
                CadEmpresa();
            } catch (ParseException ex) {
                System.out.println("Ocorreu um erro ao executar a ação :" + ex);
            }
        });

        btn_alteraEmpresa.addActionListener((ActionEvent e) -> {
            try {
                this.dispose();
                RefreshEmpresa();
            } catch (ParseException ex) {
                Logger.getLogger(MenuTela.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        btn_deletaEmpresa.addActionListener((ActionEvent e) -> {
            try {
                this.dispose();
                TrashEmpresa();
            } catch (ParseException ex) {
                Logger.getLogger(MenuTela.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        btn_mostraEmpresa.addActionListener((ActionEvent e) -> {
            try {
                mostrarEmpresa();
            } catch (ParseException ex) {
                Logger.getLogger(MenuTela.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        btn_cadBeneficiario.addActionListener((ActionEvent e) -> {
            try {
                this.dispose();
                CadBeneficiario();
            } catch (ParseException ex) {
                System.out.println("Ocorreu um erro ao executar a ação :" + ex);
            }
        });

        btn_mostrarBeneficiario.addActionListener((ActionEvent e) -> {
            mostrarBeneficiario();
        });

        btn_alteraBeneficiario.addActionListener((ActionEvent e) -> {
            try {
                this.dispose();
                RefreshBeneficiario();
            } catch (ParseException ex) {
                Logger.getLogger(MenuTela.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btn_deletaBeneficiario.addActionListener((ActionEvent e) -> {
            try {
                this.dispose();             
                TrashBeneficiario();
            } catch (ParseException ex) {
                Logger.getLogger(MenuTela.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        btn_cadastroUser.addActionListener((ActionEvent e) -> {
            try {
                this.dispose();                
                CadUser();
            } catch (ParseException ex) {
                System.out.println("Ocorreu um erro ao executar a ação :" + ex);
            }
        });

        btn_mostrarUser.addActionListener((ActionEvent e) -> {
            mostrarUsuario();
        });

        btn_alteraUser.addActionListener((ActionEvent e) -> {
            this.dispose();
            RefreshUsuario();
        });

        btn_deletaUser.addActionListener((ActionEvent e) -> {
           this.dispose();
            TrashUsuario();
        });

        btn_sair.addActionListener((ActionEvent e) -> {
            sair();
        });
        // Adiciona os botões à tela
        
        add(btn_cadBeneficiario);
        add(btn_mostrarBeneficiario);
        add(btn_alteraBeneficiario);
        add(btn_deletaBeneficiario);
        
        add(btn_cadEmpresa);
        add(btn_mostraEmpresa);
        add(btn_alteraEmpresa);
        add(btn_deletaEmpresa);
        
        add(btn_cadastroUser);
        add(btn_mostrarUser);
        add(btn_alteraUser);
        add(btn_deletaUser);

        add(btn_sair);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //Beneficario
    private void CadBeneficiario() throws ParseException {
        this.dispose();
        CadBeneficiario CadBeneficiario = new CadBeneficiario();
    }

    private void mostrarBeneficiario() {
        Beneficiario mostrarBene = new Beneficiario();
        mostrarBene.mostrar();
    }

    private void RefreshBeneficiario() throws ParseException {

        this.dispose();
        RefreshBeneficiario RefreshBeneficiario= new RefreshBeneficiario();
    }

    private void TrashBeneficiario() throws ParseException {
        this.dispose();
        TrashBeneficiario deletar = new TrashBeneficiario();
    }

    //Empresa
    private void CadEmpresa() throws ParseException {
        this.dispose();
        CadEmpresa CadEmpresa = new CadEmpresa();
    }

    private void mostrarEmpresa() throws ParseException {
        Empresa mostrarEmp = new Empresa();
        mostrarEmp.mostrar();
    }

    private void RefreshEmpresa() throws ParseException {

        this.dispose();
        RefreshEmpresa RefreshEmpresa= new RefreshEmpresa();
    }

    private void TrashEmpresa() throws ParseException {
        this.dispose();
        TrashEmpresa deletar = new TrashEmpresa();
    }

    //usuario
    private void CadUser() throws ParseException {
        this.dispose();
        CadastroUser cadastraUsuario = new CadastroUser();
    }

    private void mostrarUsuario() {
        Usuario user = new Usuario();
        user.mostrar();
    }

    private void RefreshUsuario() {
        this.dispose();
        RefreshUsuario atualizarUsuario = new RefreshUsuario();
    }
    
    private void TrashUsuario() {
        this.dispose();
        TrashUsuario user = new TrashUsuario();
    }

    //função da tela
    private void sair() {
        this.dispose();
       LoginTela loginTela = new LoginTela();
    }
}

