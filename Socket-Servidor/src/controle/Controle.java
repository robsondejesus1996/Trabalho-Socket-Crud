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

        pessoa = con.stringPessoa(mensagem);
        dadosPa.add(pessoa);

        return "PESSOA INSERIDA COM SUCESSO!";
    }

    public String adicionarDepartamento(String mensagem) {
        this.departamento = new Departamento();
        con = new Conversao();

        departamento = con.stringDepartamento(mensagem);
        dadosDep.add(departamento);

        return "DEPARTAMENTO INSERIDO COM SUCESSO!";
    }
}
