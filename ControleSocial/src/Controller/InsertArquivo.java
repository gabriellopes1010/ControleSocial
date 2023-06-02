/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author midia
 */
public class InsertArquivo implements Runnable {

    DBConnection inst = DBConnection.getInstance();
    Connection con = inst.getConexao();
    private static final String ARQUIVO = "C:\\Users\\midia\\Documents\\NetBeansProjects\\ControleSocial\\insere.txt";

    @Override
    public void run() {
        Thread Monitor = new Thread(() -> {
            try {
                System.out.println("iniciada");
                BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO));
                String linha = null;
                while (true) {
                    linha = leitor.readLine();
                    if (linha != null) {
                        inserirNoBanco(linha);
                    }
                    Thread.sleep(20000); // aguarda 20 segundo antes de verificar novamente o arquivo
                }
            } catch (IOException | InterruptedException e) {
                System.out.println("Ocorreu um erro ao executar a thread " + e);
            }
        });
        Monitor.start();
    }

    private void inserirNoBanco(String valores) {
        try {

            String[] valoresSeparados = valores.split(",");

            if (valoresSeparados.length == 2) {
                System.out.println("Tamanho do array" + valoresSeparados.length);
                String queryUsuario = "INSERT INTO usuarios VALUES (?, ?)";
                PreparedStatement pst = con.prepareStatement(queryUsuario);

                pst.setString(1, valoresSeparados[0]);
                pst.setString(2, valoresSeparados[1]);

                pst.executeUpdate();
                System.out.println("Valores inseridos no banco: " + valores);
            } else if (valoresSeparados.length == 5) {

                String query = "INSERT INTO beneficiarios VALUES (?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(query);

                pst.setString(1, valoresSeparados[0]);
                pst.setString(2, valoresSeparados[1]);
                pst.setString(3, valoresSeparados[2]);
                pst.setFloat(4, Float.parseFloat(valoresSeparados[3]));
                pst.setInt(5, Integer.parseInt(valoresSeparados[4]));

                pst.executeUpdate();

                System.out.println("Inerção realizada com sucesso");
                System.out.println("-" + valoresSeparados[0] + "-");

            } else if (valoresSeparados.length == 5) {
                String query = "INSERT INTO empresa VALUES (?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(query);

                pst.setString(1, valoresSeparados[0]);
                pst.setString(2, valoresSeparados[1]);
                pst.setString(3,valoresSeparados[2]);
                pst.setInt(4, Integer.parseInt(valoresSeparados[3]));
                pst.setFloat(5, Float.parseFloat(valoresSeparados[4]));
                

                int resultado = pst.executeUpdate();

            }

        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao tentar inserir os dados :" + e);
        }
    }
}

