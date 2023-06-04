/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Classe responsável pela autenticação do usuário.
 */
public class Autenticacao {

    DBConnection inst = DBConnection.getInstance();
    Connection con = inst.getConexao();
/**
     * Construtor da classe Autenticacao.
     *
     * @param nome O nome do usuário.
     * @param senha A senha do usuário.
     */
    public Autenticacao(String nome, String senha) {
        // Construtor vazio, não é necessário implementação.
    }
/**
     * Verifica se as credenciais de login são válidas.
     *
     * @param nome O nome do usuário.
     * @param senha A senha do usuário.
     * @return true se as credenciais forem válidas, false caso contrário.
     */
    public boolean Acessa(String nome, String senha) {

        try {
            String query = "SELECT * FROM usuarios WHERE nome_usuario =? AND senha_usuario=?";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, nome);
            pst.setString(2, senha);

            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Logado com sucesso");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos");
            }

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao realizar a consulta :" + ex);
        }
        return false;
    }
}
