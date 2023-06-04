/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.TemplateMethod.DBObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Beneficiario extends DBObject {
     /**
     * Construtor da classe Beneficiario.
     * @param nomeBene O nome do beneficiário.
     * @param cpfBene O CPF do beneficiário.
     * @param profissaoBene A profissão do beneficiário.
     * @param tempoDesempregadoBene O tempo de desemprego do beneficiário.
     * @param dependentesBene O número de dependentes do beneficiário.
     */

    DBConnection inst = DBConnection.getInstance();
    Connection con = inst.getConexao();

    private String nome;
    private String cpf;
    private String profissao;
    private float tempoDesempregado;
    private int dependentes;
/**
     * Construtor vazio da classe Beneficiario.
 */
    public Beneficiario(String nomeBene, String cpfBene, String profissaoBene, float tempoDesempregadoBene, int dependentesBene) {
        nome = nomeBene;
        cpf = cpfBene;
        profissao = profissaoBene;
        tempoDesempregado = tempoDesempregadoBene;
        dependentes = dependentesBene;
    }

    public Beneficiario() {
    }
 /**
     * Insere um beneficiário no banco de dados.
     */
    public void inserir() {

        try {
            String query = "INSERT INTO beneficiario VALUES (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, nome);
            pst.setString(2, cpf);
            pst.setString(3, profissao);
            pst.setFloat(4, tempoDesempregado);
            pst.setInt(5, dependentes);

            pst.executeUpdate();

            System.out.println("Inerção realizada com sucesso");
            System.out.println("-"  + nome + "-");

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao inserir no banco de dados :" + ex);
        }
    }

   /**
     * Atualiza um beneficiário no banco de dados.
     */
    @Override
    public void atualizar() {
        try {

            String query = "UPDATE beneficiario SET nome_beneficiario = ? , profissao_beneficiario = ? , tempoDesempregado_beneficiario = ?,dependentes_beneficiario =? WHERE cpf_beneficiario = ?" ;
            PreparedStatement pst = con.prepareStatement(query);
            
            pst.setString(1, nome);
            pst.setString(2, profissao);
            pst.setFloat(3, tempoDesempregado);
            pst.setInt(4, dependentes);            
            pst.setString(5, cpf);

            int resultado = pst.executeUpdate();

            if (resultado > 0) {
               JOptionPane.showMessageDialog(null,"### Registro alterado com sucesso. ###");
            } else {
                JOptionPane.showMessageDialog(null,"### Nenhum registro alterado. ###");
            }

        } catch (SQLException e) {
            System.out.println("Erro:\n" + e);
        }
    }
/**
     * Deleta um beneficiário do banco de dados.
     * @param cpf O CPF do beneficiário a ser deletado.
     */
    public void deletar(String cpf) {
        try {
            String query = "DELETE FROM beneficiario WHERE cpf_beneficiario = ?";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, cpf);

            int resultado = pst.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum registro eliminado.");
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao tentar deletar o registro :" + e);
        }
    }

     /**
     * Mostra os beneficiários cadastrados em uma tabela.
     */
    @Override
    public void mostrar() {
        
        JFrame tela = new JFrame();
         
        tela.setTitle("Beneficiarios cadastrados");
        tela.setSize(500, 300);
        tela.setResizable(false);
        tela.setLocationRelativeTo(null);


        // Cria a tabela
        String[] colunas = {"Nome", "cpf","profissao","Tempo Desemp.","dependentes"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modelo);
        try {
            String query = "SELECT * FROM beneficiario";

            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rst = pst.executeQuery();

            System.out.println("Resultado da pesquisa");

            while (rst.next()) {
                String nome = rst.getString("nome_beneficiario");
                String cpf = rst.getString("cpf_beneficiario");
                String profissao = rst.getString("profissao_beneficiario");
                String tempoDesempregado = rst.getString("tempoDesempregado_beneficiario");
                String dependentes = rst.getString("dependentes_beneficiario");
                modelo.addRow(new Object[] {nome,cpf,profissao,tempoDesempregado,dependentes});
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao exibit os registros:" + ex);
        }
        tela.add(new JScrollPane(tabela));
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Exibe a janela
        tela.setVisible(true);
        
        
    }  
}
