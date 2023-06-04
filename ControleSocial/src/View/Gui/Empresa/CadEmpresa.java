/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Gui.Empresa;

import Controller.Empresa;
import View.Gui.Menu.MenuTela;
import View.Gui.TelaDefault;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 * Classe que representa a tela de cadastro de empresas.
 */
public class CadEmpresa extends TelaDefault {
    private final JLabel lblNome, lblCnpj, lblAtuacao,lblTempoPrograma,familiasAssist;
    private final JTextField razaoSocial,txtAtuacao;
    private final JFormattedTextField ftxtCnpj;
    private final JButton btnCadastrar,btnBack;
    private final JComboBox cqdefamiliasAssist,jTempoPrograma;
    
      private final String[] qdefamiliasAssist = {"1", "2", "3", "4", "5","6"};
      private final String[] tmpPrograma = {"0.5","1", "1.5" ,"2.0" , "2.5", "3.0"};
    /**
     * Construtor da classe CadEmpresa.
     * Cria uma nova instância da tela de cadastro de empresas.
     * @throws ParseException Exceção lançada em caso de erro na formatação de dados.
     */
    public CadEmpresa() throws ParseException {
        
        //setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconeHeroi.png")));
        setTitle("Cadastro de Empresas");
        setResizable(false);
        
        lblNome = new JLabel("Razão social da empresa:");
        lblCnpj = new JLabel("CNPJ da empresa:");
        lblAtuacao = new JLabel("Área de atuação da empresa:");
        lblTempoPrograma = new JLabel("Tempo de de participação no programa:");
        familiasAssist = new JLabel("Quantidade de famílias assistidas");
        
        razaoSocial = new JTextField();
        ftxtCnpj = new JFormattedTextField(new MaskFormatter("##. ###. ###/####-##"));
        txtAtuacao = new JTextField("digite aqui...");
        jTempoPrograma = new JComboBox(tmpPrograma);
        cqdefamiliasAssist = new JComboBox(qdefamiliasAssist);
        btnCadastrar = new JButton("Enviar");
        btnBack = new JButton("Cad. empresa");
        
        // Configuração dos posicionamentos dos componentes na tela
        
        lblNome.setBounds(35, 20, 200, 50);
        lblCnpj.setBounds(35, 80, 200, 50);
        lblAtuacao.setBounds(35,140,200,50);
        lblTempoPrograma.setBounds(35,220,200,50);
        familiasAssist.setBounds(35,280,200,50);
        
        razaoSocial.setBounds(35,60,200,20);
        ftxtCnpj.setBounds(35, 120, 200, 20);
        txtAtuacao.setBounds(35,180,200,20);
        jTempoPrograma.setBounds(35,260,200,20);
        cqdefamiliasAssist.setBounds(35,320,200,20);
        
        btnCadastrar.setBounds(35, 360, 200, 40);
        btnBack.setBounds(35, 400, 200, 40);
        
        // Configuração dos eventos dos botões
        btnCadastrar.addActionListener((ActionEvent e) -> {
            try{
                cadastrarEmpresa();
            }catch(ParseException ex){
                System.out.println("Ocorreu um erro ao cadastrar no banco de dados :" + e);
            }
            try {
                BackMenu();
            } catch (ParseException ex) {
                Logger.getLogger(CadEmpresa.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btnBack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    BackMenu();
                } catch (ParseException ex) {
                    System.out.println("Ocorreu um erro ao mudar de tela :" + e);
                }
            }
        });
        // Adição dos componentes na tela    
        add(lblNome);
        add(lblCnpj);
        add(lblAtuacao);
        add(lblTempoPrograma);
        add(familiasAssist);
               
        add(razaoSocial);
        add(ftxtCnpj);
        add(txtAtuacao);
        add(jTempoPrograma);
        add(cqdefamiliasAssist);
        
        add(btnCadastrar);
        add(btnBack);

                
        
        setVisible(true);
    }
    /**
     * Retorna para a tela do menu principal.
     * @throws ParseException Exceção lançada em caso de erro na formatação de dados.
     */
    private void BackMenu() throws ParseException{
        this.dispose();
        MenuTela menu = new MenuTela();
    }
    /**
     * Cadastra a empresa.
     * @throws ParseException Exceção lançada em caso de erro na formatação de dados.
     */
    private void cadastrarEmpresa()throws ParseException{
        String nome = razaoSocial.getText(),
               cnpj = ftxtCnpj.getText();
               cnpj = cnpj.replaceAll("\\D+", "");
        String atuacao = txtAtuacao.getText();
        int familias =Integer.parseInt(cqdefamiliasAssist.getSelectedItem().toString());
        float tempo =Float.parseFloat((String)jTempoPrograma.getSelectedItem().toString());
       
        try {
            Empresa Empresa = new Empresa(nome, cnpj, atuacao, tempo,familias );
            Empresa.inserir();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao executar o evento :" + e);
        }
        
        
    }
    
}
