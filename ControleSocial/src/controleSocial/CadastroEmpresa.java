/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package controleSocial;

import Components.Menu;
import DBConnection.BDConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author midia
 */
public class CadastroEmpresa extends JFrame {
        public JLabel lblNome, lblCnpj, lblAtuacao,lblTempoPrograma,familiasAssist;
        public JTextField razaoSocial;
        public JFormattedTextField ftxtCnpj;    
        public JTextField txtAtuacao;
        public JComboBox cqdefamiliasAssist;
        public JComboBox jTempoPrograma;
        public JButton btnEnviar2;
        public JButton buttonTwo;
       private String[] qdefamiliasAssist = {"1", "2", "3", "4", "5","6"};
       private String[] tmpPrograma = {"0.5","1", "1.5" ,"2.0" , "2.5", "3.0"};

   
               public CadastroEmpresa() throws ParseException{
   
       setLayout(null);
       
       lblNome = new JLabel("RazaoSocial:");
       razaoSocial = new JTextField();
       lblCnpj = new JLabel("CNPJ:");
       ftxtCnpj = new JFormattedTextField(
                new MaskFormatter("##. ###. ###/####-##"));
       lblAtuacao = new JLabel("Área de atuação:");
       txtAtuacao = new JTextField("digite aqui...");
       
       lblTempoPrograma = new JLabel("Tempo no programa:");
       jTempoPrograma = new JComboBox(tmpPrograma);
       familiasAssist = new JLabel("Quantidade famílias assistidas");
       cqdefamiliasAssist = new JComboBox(qdefamiliasAssist);
       btnEnviar2 = new JButton("Enviar");
       buttonTwo = new JButton("Voltar");
       
       btnEnviar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cliqueBtnEnviar2();
            }
        });
       
       buttonTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cliqueTelaUm();
                } catch (ParseException ex) {
                    Logger.getLogger(CadastroSocial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
       
       
       lblNome.setBounds(10, 10, 200, 25);
       razaoSocial.setBounds(90, 10, 230, 25);
       lblCnpj.setBounds(10, 60, 200, 25);
       ftxtCnpj.setBounds(50, 60, 270, 25);
       lblAtuacao.setBounds(10, 110, 200, 25);
       txtAtuacao.setBounds(115, 110, 205, 25);
       lblTempoPrograma.setBounds(10,160, 200, 25);
       jTempoPrograma.setBounds(120, 190, 200, 25);
       familiasAssist.setBounds(10, 230, 200 , 25);
       cqdefamiliasAssist.setBounds(120, 260, 200, 25);
       buttonTwo.setBounds(60, 300, 100, 40);
       btnEnviar2.setBounds(190, 300, 100, 40);
       
       getContentPane().add(lblNome);
       getContentPane().add(razaoSocial);
       getContentPane().add(lblCnpj);
       getContentPane().add(ftxtCnpj);
       getContentPane().add(lblAtuacao);
       getContentPane().add(txtAtuacao);
       getContentPane().add(lblTempoPrograma);
       getContentPane().add(jTempoPrograma);
       getContentPane().add(familiasAssist);
       getContentPane().add(cqdefamiliasAssist);
       getContentPane().add(buttonTwo);
       getContentPane().add(btnEnviar2);
       
       setSize(400, 400);
       setTitle("Cadastro Empresa");
       setLocationRelativeTo(null);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

      
      private void cliqueBtnEnviar2(){
        String nome = razaoSocial.getText(),
               cnpj = ftxtCnpj.getText(),
               atuacao = txtAtuacao.getText();
        int familias =Integer.parseInt(cqdefamiliasAssist.getSelectedItem().toString());
        float tempo =Float.parseFloat((String)jTempoPrograma.getSelectedItem().toString());
               
        
        System.out.println("Razão Social: " + nome);
        System.out.println("Cnpj: " + cnpj);
        System.out.println("area de atuacao: " + atuacao);
        System.out.println("tempo no programa: " + tempo +" Anos");
        System.out.println("familias assistidas: " + familias );



        try(PrintWriter pw = new PrintWriter(new File("cadastroEmpresa.txt"))){
            pw.println("Razão Social: " + nome);
            pw.println("Cnpj: " + cnpj);
            pw.println("area de atuacao: " + atuacao);
            pw.println("tempo no programa: " + tempo);
            pw.println("familias assistidas: " + familias);
          

        }catch(FileNotFoundException e){
            System.out.println("Arquivo nÃo existe");
        }
        try {
             BDConnection.cadastroEmpresa(nome, cnpj, atuacao, tempo, familias);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
      private void cliqueTelaUm() throws ParseException{
       
       this.dispose();
        Menu menu = new Menu();
   
    }

}
