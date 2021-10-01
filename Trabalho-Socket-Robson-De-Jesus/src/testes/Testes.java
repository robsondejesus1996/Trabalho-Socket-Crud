/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import Repositorio.RepositorioPessoa;
import model.Pessoa;

/**
 *
 * @author admin
 */
public class Testes {
    
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        RepositorioPessoa rp = new RepositorioPessoa();
        boolean salvo;
        
        pessoa.setCpf("0952");
        pessoa.setNome("Robson de Jesus");
        pessoa.setEndereco("Rua de teste");
        
        salvo = rp.salvarPessoa(pessoa);
        
        if(salvo){
            System.out.println(pessoa.getNome() + " salva com sucesso...");
        }
        
    }
    
}
