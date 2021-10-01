/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import java.util.List;
import model.Pessoa;

/**
 *
 * @author Robson de Jesus
 */
public interface IRepositorioPessoa {
    
    
    public boolean salvarPessoa(Pessoa pessoa);
    public boolean deletarPessoaPorCPF(String cpf);
    public List<Pessoa> buscarPessoa();//listar todos
    public boolean alterarPessoa(Pessoa pessoa);
    
}
