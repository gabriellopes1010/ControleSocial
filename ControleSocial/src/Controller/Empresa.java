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

/**
 *
 * @author midia
 */
public class Empresa extends DBObject {

    DBConnection inst = DBConnection.getInstance();
    Connection con = inst.getConexao();

    private String nome;
    private String cnpj;
    private String atuacao;
    private float tempo;
    private int familias;

    public Empresa(String nomeEmp, String cnpjEmp, String atuacaoEmp, float tempoEmp, int familiasEmp) {
        nome = nomeEmp;
        cnpj = cnpjEmp;
        atuacao = atuacaoEmp;
        tempo = tempoEmp;
        familias = familiasEmp;
    }

    public Empresa() {
    }

    public void inserir() {

        try {
            String query = "INSERT INTO empresa VALUES (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, nome);
            pst.setString(2, cnpj);
            pst.setString(3, atuacao);
            pst.setFloat(4, tempo);
            pst.setInt(5, familias);

            pst.executeUpdate();

            System.out.println("Inerção realizada com sucesso");
            System.out.println("-"  + nome + "-");

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao inserir no banco de dados :" + ex);
        }
    }

    @Override
    public void atualizar() {
        try {

            String query = "UPDATE empresa SET nome_empresa = ?, atuacao_empresa = ?, tempo_empresa= ?,familias_empresa =? WHERE cnpj_empresa = ?" ;
            PreparedStatement pst = con.prepareStatement(query);
            
            pst.setString(1, nome);
            pst.setString(2, atuacao);
            pst.setFloat(3, tempo);
            pst.setInt(4, familias);
            pst.setString(5, cnpj);
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

    public void deletar(String cnpj) {
        try {
            String query = "DELETE FROM empresa WHERE cnpj_empresa = ?";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, cnpj);

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

    @Override
    public void mostrar() {
        
        JFrame tela = new JFrame();
         
        tela.setTitle("Empresas cadastradas");
        tela.setSize(500, 300);
        tela.setResizable(false);
        // Cria a tabela
        String[] colunas = {"Nome", "cnpj","atuação","Tempo no Prog.","Famílias Assist."};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modelo);
        try {
            String query = "SELECT * FROM empresa";

            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rst = pst.executeQuery();

            System.out.println("Resultado da pesquisa");

            while (rst.next()) {
                String nome = rst.getString("nome_empresa");
                String cnpj = rst.getString("cnpj_empresa");
                String atuacao = rst.getString("atuacao_empresa");
                String tempo = rst.getString("tempo_empresa");
                String familia = rst.getString("familias_empresa");
                modelo.addRow(new Object[] { nome,cnpj,atuacao,tempo,familia});
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
