package controle;

import modelo.Pessoa;
import conversao.Conversao;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Robson de Jesus
 */
public class PessoaControle {

    Pessoa pessoa;
    Conversao utils;
    Scanner in;
    String mensagem;

    public String pessoaInserir() throws IOException {
        pessoa = new Pessoa();
        utils = new Conversao();
        in = new Scanner(System.in);

        System.out.println("INFORME O NOME DA PESSOA: ");
        String nomePessoa = in.nextLine();
        pessoa.setNome(utils.padronizaInsercao(nomePessoa, 100));

        System.out.println("INFORME O CPF DA PESSOA: ");
        String cpf = in.nextLine();
        pessoa.setCpf(utils.padronizaInsercao(cpf, 11));

        System.out.println("INFORME O ENDEREÇO DA PESSOA: ");
        String enderecoPessoa = in.nextLine();
        pessoa.setEndereco(utils.padronizaInsercao(enderecoPessoa, 100));

        System.out.println("CADASTRAR PESSOA COM O DEPARTAMENTO ? (S/N)");
        String opcao = in.nextLine();
        String matricula = "";
        if (opcao.equalsIgnoreCase("s")) {
            System.out.println("INFORME A MATRICULA DO DEPARTAMENTO ");
            matricula = in.nextLine();
        } else {
            matricula = "*";
        }
        pessoa.setMatriculaDepartamento(utils.padronizaInsercao(matricula, 14));

        mensagem = "1INSERT";                 //   7 bytes
        mensagem += pessoa.getCpf();          //  11 bytes
        mensagem += pessoa.getNome();         // 100 bytes
        mensagem += pessoa.getEndereco();     // 100 bytes 
        mensagem += pessoa.getMatriculaDepartamento();  //  14 bytes  => 232 bytes

        return mensagem;
    }

    public String pessoaAtualizar() {
        pessoa = new Pessoa();
        utils = new Conversao();
        in = new Scanner(System.in);

        System.out.println("INFORME O CPF DA PESSOA: ");
        String cpf = in.nextLine();
        pessoa.setCpf(utils.padronizaInsercao(cpf, 11));

        System.out.println("INFORME O NOME DA PESSOA:  ");
        String nomePessoa = in.nextLine();
        pessoa.setNome(utils.padronizaInsercao(nomePessoa, 100));

        System.out.println("INFORME O ENDEREÇO DA PESSOA: ");
        String enderecoPessoa = in.nextLine();
        pessoa.setEndereco(utils.padronizaInsercao(enderecoPessoa, 100));

        String matricula = "*";
        pessoa.setMatriculaDepartamento(utils.padronizaInsercao(matricula, 14));

        mensagem = "1UPDATE";                 //   7 bytes
        mensagem += pessoa.getCpf();          //  11 bytes
        mensagem += pessoa.getNome();         // 100 bytes
        mensagem += pessoa.getEndereco();     // 100 bytes 
        mensagem += pessoa.getMatriculaDepartamento();  //  14 bytes  => 232 bytes

        return mensagem;
    }

    public String pessoaBuscar() {
        Scanner sc = new Scanner(System.in);
        String cpf = "";
        System.out.println("INFORME O CPF DA PESSOA: ");
        cpf = sc.nextLine();

        return "1GET***" + cpf;
    }

    public String pessoasListAll() {
        return "1LIST**";
    }

    public String pessoaExcluir() {
        Scanner sc = new Scanner(System.in);
        String cpf = "";
        System.out.println("INFORME O CPF DA PESSOA: ");
        cpf = sc.nextLine();
        return "1DELETE" + cpf;
    }

    public String atualizarPessoaPorCpf() {
        Scanner sc = new Scanner(System.in);
        String cpf = "";
        System.out.println("INFORME O CPF DA PESSOA: ");
        cpf = sc.nextLine();
        return "1GET***" + cpf;
    }
}
