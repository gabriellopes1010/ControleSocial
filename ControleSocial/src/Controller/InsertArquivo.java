/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Esta classe representa a inserção de dados a partir de arquivos no banco de dados.
 * Implementa a interface Runnable para executar a inserção em uma thread separada.
 */
public class InsertArquivo implements Runnable {

    DBConnection inst = DBConnection.getInstance();
    Connection con = inst.getConexao();
    private final String ARQUIVO = "C:\\Users\\midia\\Documents\\NetBeansProjects\\ControleSocial\\insere.txt";
    private final String ARQUIVOBENE = "C:\\Users\\midia\\Documents\\NetBeansProjects\\ControleSocial\\insereBENE.txt";
    private final String ARQUIVOEMP = "C:\\Users\\midia\\Documents\\NetBeansProjects\\ControleSocial\\insereEMP.txt";

    /**
     * Executa a inserção dos dados dos arquivos no banco de dados em uma thread separada.
     */
    @Override
    public void run() {
        Thread Monitor = new Thread(() -> {
            try {
                System.out.println("iniciada");
                BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO));
                BufferedReader leitorBENE = new BufferedReader(new FileReader(ARQUIVOBENE));
                BufferedReader leitorEMP = new BufferedReader(new FileReader(ARQUIVOEMP));

                String linha = null;
                String linhaBENE = null;
                String linhaEMP = null;

                while (true) {
                    linha = leitor.readLine();
                    linhaBENE = leitorBENE.readLine();
                    linhaEMP = leitorEMP.readLine();
                   
                    if (linha != null) {
                        inserirNoBanco(linha);
                        
                    } 
                    
                    if (linhaBENE != null){
                        inserirNoBancoBENE(linhaBENE);

                    }
                    if(linhaEMP != null) {
                        inserirNoBancoEMP(linhaEMP);

                    }
                    Thread.sleep(2000); 
                    
                }
            } catch (IOException | InterruptedException e) {
                System.out.println("Ocorreu um erro ao executar a thread " + e);
            }
        });
        Monitor.start();
    }
/**
     * Insere os valores no banco de dados para a tabela de usuários.
     *
     * @param valores Os valores a serem inseridos no banco de dados.
     */
    private void inserirNoBanco(String valores) {
        try {

            String[] valoresSeparados = valores.split(",");

            if (valoresSeparados.length == 2) {
                System.out.println("Tamanho do array" + valoresSeparados.length);
                String queryUsuario = "INSERT INTO usuarios VALUES (?, ?)";
                PreparedStatement pst = con.prepareStatement(queryUsuario);

                pst.setString(1, valoresSeparados[0]);
                pst.setString(2, valoresSeparados[1].trim());

                pst.executeUpdate();
                System.out.println("Valores inseridos no banco: " + valores);
                JOptionPane.showMessageDialog(null, "O usuário " + valoresSeparados[0] +" foi adicionado com sucesso");
            

            }
        
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao tentar inserir os dados na tabela de usaurios:" + e);
        }
        
        limparArquivo();
    }
    /**
     * Insere os valores no banco de dados para a tabela de beneficiários.
     *
     * @param valores Os valores a serem inseridos no banco de dados.
     */
     private void inserirNoBancoBENE(String valores) {
        try {

            String[] valoresSeparados = valores.split(",");

           if (valoresSeparados.length == 5) {

                String query = "INSERT INTO beneficiario VALUES (?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(query);

                pst.setString(1, valoresSeparados[0]);
                pst.setString(2, valoresSeparados[1].trim());
                pst.setString(3, valoresSeparados[2]);
                pst.setFloat(4, Float.parseFloat((String)valoresSeparados[3].trim()));
                pst.setInt(5, Integer.parseInt((String)valoresSeparados[4].trim()));

                pst.executeUpdate();

                System.out.println("Inserção realizada com sucesso");
                System.out.println("-" + valoresSeparados[0] + "-");
                JOptionPane.showMessageDialog(null, "O beneficiário " + valoresSeparados[0] +" foi adicionado com sucesso");

            }

        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao tentar inserir os dados na tabela de beneficiarios:" + e);
        }
        limparArquivoBENE();

    }
     /**
     * Insere os valores no banco de dados para a tabela de empresas.
     *
     * @param valores Os valores a serem inseridos no banco de dados.
     */
     private void inserirNoBancoEMP(String valores) {
        try {

            String[] valoresSeparados = valores.split(",");

          if (valoresSeparados.length == 5) {
                String query = "INSERT INTO empresa VALUES (?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(query);

                pst.setString(1, valoresSeparados[0]);
                pst.setString(2, valoresSeparados[1].trim());
                pst.setString(3, valoresSeparados[2]);
                pst.setFloat(4, Float.parseFloat((String)valoresSeparados[3].trim()));
                pst.setInt(5, Integer.parseInt((String)valoresSeparados[4].trim()));
                int resultado = pst.executeUpdate();
                
                System.out.println("Inserção realizada com sucesso");
                System.out.println("-" + valoresSeparados[0] + "-");
                JOptionPane.showMessageDialog(null, "A empresa " + valoresSeparados[0] +" foi adicionada com sucesso");

          }

        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao tentar inserir os dados na tabela de Empresa:" + e);
        }
        limparArquivoEMP();

    };
      /**
     * Limpa o conteúdo do arquivo de entrada.
     */
         private void limparArquivo() {
        try {
            try (FileWriter writer = new FileWriter(ARQUIVO)) {
                writer.write("");
            }
            System.out.println("Arquivo limpo");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao limpar o arquivo: " + e);
        }
    }
         /**
     * Limpa o conteúdo do arquivo de entrada de beneficiários.
     */
         private void limparArquivoBENE() {
        try {
            FileWriter writer = new FileWriter(ARQUIVOBENE);
            writer.write("");
            writer.close();
            System.out.println("Arquivo limpo");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao limpar o arquivo: " + e);
        }
    }
           /**
     * Limpa o conteúdo do arquivo de entrada de empresas.
     */
         private void limparArquivoEMP() {
        try {
            FileWriter writer = new FileWriter(ARQUIVOEMP);
            writer.write("");
            writer.close();
            System.out.println("Arquivo limpo");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao limpar o arquivo: " + e);
        }
    }
}
    


