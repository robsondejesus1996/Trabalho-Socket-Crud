/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author Robson de Jesus
 */
public class Departamento {
    
    private String nome;
    private String matricula;
    private String endereco;
    private List<String> pessoas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<String> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<String> pessoas) {
        this.pessoas = pessoas;
    }
    
    
    
    @Override
    public String toString() {
        return "[" + "Nome: " + nome + " Matricula: " + matricula + " Pessoas: " + pessoas + ']';
    }
}
