/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Components;

import Components.Menu;
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
public class CadastroSocial extends JFrame {
        public JLabel lblNome, lblCpf, lblprofissao,lbltempoDesempregado,qtdeDependentes;
        public JTextField txtNome;
        public JFormattedTextField ftxtCpf;    
        public JTextField txtProfissional;
        public JComboBox cqdeDependentes;
        public JComboBox jtempoDesempregado;
        public JButton btnEnviar;
        public JButton buttonOne;
    
       private String[] qdeDependentes = {"1", "2", "3", "4", "5","6"};
       private String[] tmpDesempregado = {"0.5","1", "1.5" ,"2.0" , "2.5", "3.0"};

   
               public CadastroSocial() throws ParseException{
   
       setLayout(null);
       
       lblNome = new JLabel("Nome:");
       txtNome = new JTextField();
       lblCpf = new JLabel("CPF:");
       ftxtCpf = new JFormattedTextField(
                new MaskFormatter("###.###.###-##"));
       lblprofissao = new JLabel("Profissão:");
       txtProfissional = new JTextField("digite aqui...");
       
       lbltempoDesempregado = new JLabel("Tempo desempregado:");
       jtempoDesempregado = new JComboBox(tmpDesempregado);
       qtdeDependentes = new JLabel("Quantidade de dependentes");
       cqdeDependentes = new JComboBox(qdeDependentes);
       btnEnviar = new JButton("Enviar");
       buttonOne = new JButton("Voltar");
       
       
       
       
       btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cliqueBtnEnviar();
            }
        });
       
       buttonOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cliqueTelaDois();
                } catch (ParseException ex) {
                    Logger.getLogger(CadastroSocial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
       
       
       lblNome.setBounds(10, 10, 200, 25);
       txtNome.setBounds(70, 10, 250, 25);
       lblCpf.setBounds(10, 60, 200, 25);
       ftxtCpf.setBounds(70, 60, 250, 25);
       lblprofissao.setBounds(10, 110, 200, 25);
       txtProfissional.setBounds(85, 110, 235, 25);
       lbltempoDesempregado.setBounds(10,160, 200, 25);
       jtempoDesempregado.setBounds(120, 190, 200, 25);
       qtdeDependentes.setBounds(10, 230, 200 , 25);
       cqdeDependentes.setBounds(120, 260, 200, 25);
       buttonOne.setBounds(60, 300, 115, 40);
       btnEnviar.setBounds(190, 300, 100, 40);
       
       getContentPane().add(lblNome);
       getContentPane().add(txtNome);
       getContentPane().add(lblCpf);
       getContentPane().add(ftxtCpf);
       getContentPane().add(lblprofissao);
       getContentPane().add(txtProfissional);
       getContentPane().add(lbltempoDesempregado);
       getContentPane().add(jtempoDesempregado);
       getContentPane().add(qtdeDependentes);
       getContentPane().add(cqdeDependentes);
       getContentPane().add(btnEnviar);
       getContentPane().add(buttonOne);

       
       setSize(400, 400);
       setTitle("Cadastro Pessoal");
       setLocationRelativeTo(null);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

      
      private void cliqueBtnEnviar(){
        String nomeCompleto = txtNome.getText(),
               cpf =ftxtCpf.getText();
        String profissao = txtProfissional.getText();
        int dependentes =Integer.parseInt((String) cqdeDependentes.getSelectedItem());
        float tempoDesempregado = Float.parseFloat((String) jtempoDesempregado.getSelectedItem());
        
     
               
        
        System.out.println("nome completo: " + nomeCompleto);
        System.out.println("cpf : " + cpf);
        System.out.println("profissão : " + profissao);
        System.out.println("Tempo desempregado: " + tempoDesempregado +" Anos");
        System.out.println("Dependentes: " + dependentes);



        try(PrintWriter pw = new PrintWriter(new File("cadastroSocial.txt"))){
            pw.println("nome : " + nomeCompleto);
            pw.println("cpf : " + cpf);
            pw.println("profissão : " + profissao);
            pw.println("Tempo desempregado : " + tempoDesempregado);
            pw.println("Dependentes : " + dependentes);
          

        }catch(FileNotFoundException e){
            System.out.println("Arquivo nÃo existe");
        }
        try {
             DBConnection.cadastroPessoal(nomeCompleto, cpf, profissao, tempoDesempregado, dependentes);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
      
   private void cliqueTelaDois() throws ParseException{
       
       this.dispose();
       Menu menu = new Menu();
   
    }

}
