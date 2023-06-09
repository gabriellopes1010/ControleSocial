/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta classe representa a conexão com o banco de dados.
 */
public class DBConnection {

    private Connection conexao;

    private static final String urlJDBC = "jdbc:mysql://localhost:3306/social";
    private static final String usuario = "root";
    private static final String senha = "12345";
    
    
 /**
     * Construtor privado da classe DBConnection.
     * Realiza a conexão com o banco de dados.
     */
    private static DBConnection instance;

    private DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(urlJDBC, usuario, senha);
            System.out.println("Conexão functionando");
        } catch (ClassNotFoundException ex) {
            System.out.println("O driver não foi encontrado" + ex);
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao efetuar a conexão" + ex.getMessage());
        }
    }
 /**
     * Obtém uma instância única da classe DBConnection (Singleton).
     * @return A instância única de DBConnection.
     */
    public static synchronized DBConnection getInstance() {

        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
 /**
     * Obtém a conexão com o banco de dados.
     * @return A conexão com o banco de dados.
     */
    public synchronized Connection getConexao() {
        return this.conexao;
    }
}
