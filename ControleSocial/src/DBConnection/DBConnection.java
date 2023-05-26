/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBConnection;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
  
    
    public static void cadastroPessoal(String nomeCompleto, String cpf, String profissao, float tempoDesempregado, int dependentes) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String urlJDBC = "jdbc:mysql://localhost:3306/social";
        Connection conexao = (Connection) DriverManager.getConnection(urlJDBC,
                                                        "root", 
                                                        "12345");
       
        Statement comando = (Statement) conexao.createStatement();
        
            comando.execute("INSERT INTO cadastroPessoal (NOMECOMPLETO, CPF, PROFISSAO, TEMPODESEMPREGADO, DEPENDENTES)VALUES" + 
                    "('"+nomeCompleto+"','"+cpf+"','"+profissao+"', '"+tempoDesempregado+"','"+dependentes+"')");
        
        conexao.close();
        
    }
    
    public static void cadastroEmpresa(String nome, String cnpj, String atuacao, float tempo, int familias) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String urlJDBC = "jdbc:mysql://localhost:3306/social";
        Connection conexao = (Connection) DriverManager.getConnection(urlJDBC,
                                                        "root", 
                                                        "12345");
       
        Statement comando = (Statement) conexao.createStatement();
        
            comando.execute("INSERT INTO cadastroEmpresa (NOME, CNPJ, ATUACAO, TEMPO, FAMILIAS)VALUES" + 
                    "('"+nome+"','"+cnpj+"','"+atuacao+"', '"+tempo+"','"+familias+"')");
        
        conexao.close();
        
    }
    
    public static void users(String usuario, String password) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String urlJDBC = "jdbc:mysql://localhost:3306/social";
        Connection conexao = (Connection) DriverManager.getConnection(urlJDBC,
                                                        "root", 
                                                        "12345");
       
        Statement comando = (Statement) conexao.createStatement();
        
            comando.execute("INSERT INTO users (usuario, password)VALUES" + 
                    "('"+usuario+"','"+password+"')");
        
        conexao.close();
        
}
    
    
}
