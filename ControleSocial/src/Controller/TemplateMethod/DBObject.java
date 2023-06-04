/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.TemplateMethod;

/**
 * Classe abstrata que representa um objeto de banco de dados.
 */
public abstract class DBObject {
/**
     * Construtor da classe.
     */
    public DBObject() {
    }
    
    
    /**
     * Método abstrato para inserir o objeto no banco de dados.
     */
    public  void inserir(){};
    /**
     * Método abstrato para atualizar o objeto no banco de dados.
     */
    public  void atualizar(){};
    /**
     * Método abstrato para deletar o objeto do banco de dados.
     */
    public  void deletar(){};
     /**
     * Método abstrato para deletar todos os objetos do banco de dados.
     */
    public  void deletarTodos(){};
    /**
     * Método abstrato para exibir os objetos do banco de dados.
     */
    public  void mostrar(){};
    
}

