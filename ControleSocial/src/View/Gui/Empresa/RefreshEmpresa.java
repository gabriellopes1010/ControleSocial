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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 * Classe que representa a tela de atualização de empresas.
 */
public class RefreshEmpresa extends TelaDefault{
    
    private final JLabel lblNome, lblCnpj, lblAtuacao,lblTempoPrograma,familiasAssist;
    private final JTextField razaoSocial,txtAtuacao;
    private final JFormattedTextField ftxtCnpj;
    private final JButton btnAtualizar,btnBack;
    private final JComboBox cqdefamiliasAssist,jTempoPrograma;
    
      private final String[] qdefamiliasAssist = {"1", "2", "3", "4", "5","6"};
      private final String[] tmpPrograma = {"0.5","1", "1.5" ,"2.0" , "2.5", "3.0"};
      /**
     * Construtor da classe RefreshEmpresa.
     * Cria uma nova instância da tela de atualização de empresas.
     * @throws ParseException Exceção lançada em caso de erro na formatação de dados.
     */
    public RefreshEmpresa() throws ParseException {
        
        //setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconeHeroi.png")));
        setTitle("Atualizar Empresa");
        setResizable(false);
        
                JOptionPane.showMessageDialog(null, "Digite CNPJ da empresa para atualizar os campos!");

        
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
        btnAtualizar = new JButton("Atualizar");
        btnBack = new JButton("Voltar");
        // Configuração dos posicionamentos dos componentes na tela
        lblNome.setBounds(20, 20, 200, 50);
        lblCnpj.setBounds(20, 80, 200, 50);
        lblAtuacao.setBounds(20,140,200,50);
        lblTempoPrograma.setBounds(20,220,200,50);
        familiasAssist.setBounds(20,280,200,50);
        
        razaoSocial.setBounds(20,60,200,20);
        ftxtCnpj.setBounds(20, 120, 200, 20);
        txtAtuacao.setBounds(20,180,200,20);
        jTempoPrograma.setBounds(20,260,200,20);
        cqdefamiliasAssist.setBounds(20,320,200,20);
              
        btnAtualizar.setBounds(20, 360, 200, 40);
        btnBack.setBounds(20, 450, 200, 40);
        // Configuração dos eventos dos botões
         btnAtualizar.addActionListener((ActionEvent e) -> {
            Atualizar();
            try {
                BackMenu();
            } catch (ParseException ex) {
                Logger.getLogger(RefreshEmpresa.class.getName()).log(Level.SEVERE, null, ex);
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
        add(btnAtualizar);
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
     * Atualiza os dados da empresa.
     */
    private void Atualizar(){
        String nome = razaoSocial.getText(),
               cnpj = ftxtCnpj.getText();
               cnpj = cnpj.replaceAll("\\D+", "");                
        String atuacao = txtAtuacao.getText();
        int familias =Integer.parseInt(cqdefamiliasAssist.getSelectedItem().toString());
        float tempo =Float.parseFloat((String)jTempoPrograma.getSelectedItem().toString());
       
       
       new Empresa(nome, cnpj, atuacao, tempo, familias).atualizar();
            
       
        
    }
    
}

