/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import conversao.Conversao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Departamento;
import modelo.Pessoa;

/**
 *
 * @author Robson de Jesus
 */
public class Controle {

    private Conversao con;
    private Pessoa pessoa;
    private Departamento departamento;
    private List<Pessoa> dadosPa = new ArrayList<>();
    private List<Departamento> dadosDep = new ArrayList();

    public Controle() {

    }

    public String adicionarPessoa(String mensagem) {
        pessoa = new Pessoa();
        con = new Conversao();

        pessoa = con.dadosPessoa(mensagem);
        dadosPa.add(pessoa);

        return "PESSOA INSERIDA COM SUCESSO!";
    }

    public String adicionarDepartamento(String mensagem) {
        this.departamento = new Departamento();
        con = new Conversao();

        departamento = con.dadosDepartamento(mensagem);
        dadosDep.add(departamento);

        return "DEPARTAMENTO INSERIDO COM SUCESSO!";
    }

    public String atualizarPessoa(String mensagem) {
        con = new Conversao();
        String cpf = con.conversao(mensagem.substring(7, 18));
        pessoa = con.dadosPessoa(mensagem);
        for (int i = 0; i < dadosPa.size(); i++) {
            if (dadosPa.get(i).getCpf().equalsIgnoreCase(cpf)) {
                dadosPa.set(i, pessoa);
                return "PESSOA ATUALIZADA COM SUCESSO!";
            }
        }
        return "ERRO DE ATUALIZAÇÃO PESSOA";

    }

    public String atualizarDepartamento(String mensagem) {
        con = new Conversao();
        String matricula = con.conversao(mensagem.substring(7, 21));
        departamento = con.dadosDepartamento(mensagem);
        for (int i = 0; i < dadosDep.size(); i++) {
            if (dadosDep.get(i).getMatricula().equalsIgnoreCase(matricula)) {
                dadosDep.set(i, departamento);
                return "DEPARTAMENTO ATUALIZADO COM SUCESSO!";
            }
        }
        return "ERRO DE ATUALIZAÇÃO DE DEPARTAMENTO";
    }

    public String pessoaBuscar(String cpf) {
        String pessoas = "";
        for (var pessoa : dadosPa) {
            if (pessoa.getCpf().equals(cpf)) {
                pessoas += "Nome: " + pessoa.getNome() + " CPF: " + pessoa.getCpf() + "Endereço: " + pessoa.getEndereco();
                return pessoas;
            }
        }
        return "PESSOA NÃO ENCONTRADA!";
    }

    public String departamentoBucar(String matricula) {
        String deps = "";
        for (var dep : dadosDep) {
            if (dep.getMatricula().equals(matricula)) {
                deps += "Nome: " + dep.getNome() + " CNPJ: " + dep.getMatricula() + "Endereço: " + dep.getEndereco();
                return deps;
            }
        }
        return "DEPARTAMENTO NÃO ENCONTADO!";
    }

    public String excluirPessoa(String cpf) {
        for (int i = 0; i < dadosPa.size(); i++) {
            System.out.println("DELETAR PESSOA: " + dadosPa.get(i).getCpf());
            if (dadosPa.get(i).getCpf().equals(cpf)) {
                dadosPa.remove(dadosPa.get(i));
                return "PESSOA EXCLUÍDA COM SUCESSO!";
            }
        }
        return "ERRO DE EXCLUSÃO PESSOA!";
    }

    public String excluirDepartamento(String matricula) {
        for (int i = 0; i < dadosDep.size(); i++) {
            System.out.println("DELETAR DEPARTAMENTO: " + dadosDep.get(i).getMatricula());
            if (dadosDep.get(i).getMatricula().equals(matricula)) {
                dadosDep.remove(dadosDep.get(i));
                return "DEPARTAMENTO EXCLUÍDO COM SUCESSO!";
            }
        }
        return "ERRO DE EXCLUSÃO DEPARTAMENTO!";
    }

    public String listarPessoas() {
        String pessoas = "";

        for (var pessoa : dadosPa) {
            pessoas += "NOME COMPLETO: " + pessoa.getNome()
                    + " CPF: " + pessoa.getCpf()
                    + " ENDERECO: " + pessoa.getEndereco()
                    + "DEPARTAMENTO: " + pessoa.getDepartamento()
                    + " || ";
        }
        return pessoas;
    }

    public String listarDepartamentos() {
        String departamentos = "";
        for (var departamento : dadosDep) {
            departamentos += "NOME COMPLETO: " + departamento.getNome()
                    + " MATRICULA: " + departamento.getMatricula()
                    + " ENDERECO: " + departamento.getEndereco()
                    + " || ";
        }
        return departamentos;
    }

}
