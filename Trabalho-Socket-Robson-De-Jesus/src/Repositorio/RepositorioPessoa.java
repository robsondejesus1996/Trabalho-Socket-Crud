/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Pessoa;

/**
 *
 * @author Robson de Jesus
 */
public class RepositorioPessoa implements IRepositorioPessoa {

    List<Pessoa> listaPessoas = new ArrayList<Pessoa>();

    @Override
    public boolean salvarPessoa(Pessoa pessoa) {
        try {

            listaPessoas.add(pessoa);
            System.out.println("Registro de pessoa inserido...");

        } catch (Exception e) {
            return false;
        }

        return true;

    }

    @Override
    public boolean deletarPessoaPorCPF(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pessoa> buscarPessoa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterarPessoa(Pessoa pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
