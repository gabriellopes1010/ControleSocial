/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Gui.Beneficiario;

import Controller.Beneficiario;
import View.Gui.Menu.MenuTela;
import View.Gui.TelaDefault;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author midia
 */
public class CadBeneficiario extends TelaDefault{
    
    private final JLabel lblNome, lblCpf, lblprofissao,lbltempoDesempregado,qtdeDependentes;
    private final JTextField txtNome,txtProfissional;
    private final JFormattedTextField ftxtCpf;
    private final JButton btnCadastrar,btnBack;
    private final JComboBox cqdeDependentes,jtempoDesempregado;
    
    private final String[] qdeDependentes = {"1", "2", "3", "4", "5","6"};
    private final String[] tmpDesempregado = {"0.5","1", "1.5" ,"2.0" , "2.5", "3.0"};

   
    public CadBeneficiario() throws ParseException {
        
        setTitle("Cadastro de Beneficiário");
        setResizable(false);
        
        lblNome = new JLabel("Nome do Beneficiário:");
        lblCpf = new JLabel("CPF do Beneficiário:");
        lblprofissao = new JLabel("Profissão do Beneficiário:");
        lbltempoDesempregado = new JLabel("Tempo de desempregado do Beneficiário:");
        qtdeDependentes = new JLabel("Quantidade de dependentes do Beneficiário");
        
        txtNome = new JTextField();
        ftxtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
        txtProfissional = new JTextField("digite aqui...");
        jtempoDesempregado = new JComboBox(tmpDesempregado);
        cqdeDependentes = new JComboBox(qdeDependentes);
        btnCadastrar = new JButton("Cadastrar");
        btnBack = new JButton("Voltar");
        
        lblNome.setBounds(20, 20, 200, 50);
        lblCpf.setBounds(20, 80, 200, 50);
        lblprofissao.setBounds(20,140,200,50);
        lbltempoDesempregado.setBounds(20,220,200,50);
        qtdeDependentes.setBounds(20,280,200,50);
        
        txtNome.setBounds(20,60,200,20);
        ftxtCpf.setBounds(20, 120, 200, 20);
        txtProfissional.setBounds(20,180,200,20);
        jtempoDesempregado.setBounds(20,260,200,20);
        cqdeDependentes.setBounds(20,320,200,20);
        
        btnCadastrar.setBounds(20, 360, 200, 40);
        btnBack.setBounds(20, 450, 200, 40);
        
        btnCadastrar.addActionListener((ActionEvent e) -> {
            try{
                cadastrarBeneficiario();
            }catch(ParseException ex){
                System.out.println("Ocorreu um erro ao cadastrar no banco de dados :" + e);
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
                
        add(lblNome);
        add(lblCpf);
        add(lblprofissao);
        add(lbltempoDesempregado);
        add(qtdeDependentes);
               
        add(txtNome);
        add(ftxtCpf);
        add(txtProfissional);
        add(jtempoDesempregado);
        add(cqdeDependentes);
        
        add(btnCadastrar);
        add(btnBack);

                
        
        setVisible(true);
    }
    
    private void BackMenu() throws ParseException{
        this.dispose();
        MenuTela menu = new MenuTela();
    }
    
    private void cadastrarBeneficiario()throws ParseException{
        String nome = txtNome.getText(),
               cpf =ftxtCpf.getText();
        String profissao = txtProfissional.getText();
        int dependentes =Integer.parseInt((String) cqdeDependentes.getSelectedItem());
        float tempoDesempregado = Float.parseFloat((String) jtempoDesempregado.getSelectedItem());
       
        try {
            Beneficiario Beneficiario = new Beneficiario(nome, cpf, profissao, tempoDesempregado, dependentes);
            Beneficiario.inserir();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao executar o evento :" + e);
        }
        
        
    }
    
}
