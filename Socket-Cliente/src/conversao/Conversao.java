/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversao;

import modelo.Departamento;
import modelo.Pessoa;

/**
 *
 * @author Robson de Jesus
 */
public class Conversao {

    public Departamento dadosDepartamento(String mensagem) {
        Departamento departamento = new Departamento();
        String nome = mensagem.substring(21, 120);
        departamento.setNome(conversao(nome));
        String matricula = mensagem.substring(7, 20);
        departamento.setMatricula(conversao(matricula));
        String endereco = mensagem.substring(121, 220);
        departamento.setEndereco(conversao(endereco));
        return departamento;
    }

    public Pessoa dadosPessoa(String mensagem) {
        Pessoa pessoa = new Pessoa();
        String nome = mensagem.substring(18, 118);
        pessoa.setNome(conversao(nome));
        String cpf = mensagem.substring(7, 18);
        pessoa.setCpf(conversao(cpf));
        String endereco = mensagem.substring(118, 217);
        pessoa.setEndereco(conversao(endereco));
        String departamento = mensagem.substring(218, 232);
        pessoa.setDepartamento(conversao(departamento));
        return pessoa;
    }

    public String conversao(String converte) {
        return converte.replace("\\*", " ".trim());
    }

}