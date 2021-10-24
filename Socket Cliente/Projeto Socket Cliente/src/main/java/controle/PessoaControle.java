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

    private Pessoa pessoa;
    private Conversao conv;
    private Scanner entrada;
    private String mensagem;

    private PessoaControle() {

    }
    private static PessoaControle instance;

    public synchronized static PessoaControle getInstance() {
        if (instance == null) {
            instance = new PessoaControle();
        }
        return instance;
    }

    public String pessoaInserir() throws IOException {
        pessoa = new Pessoa();
        conv = Conversao.getInstance();
        entrada = new Scanner(System.in);

        System.out.println("INFORME O NOME DA PESSOA: ");
        String nomePessoa = entrada.nextLine();
        pessoa.setNome(conv.padronizaInsercao(nomePessoa, 100));

        System.out.println("INFORME O CPF DA PESSOA: ");
        String cpf = entrada.nextLine();
        pessoa.setCpf(conv.padronizaInsercao(cpf, 11));

        System.out.println("INFORME O ENDEREÇO DA PESSOA: ");
        String enderecoPessoa = entrada.nextLine();
        pessoa.setEndereco(conv.padronizaInsercao(enderecoPessoa, 100));

        System.out.println("CADASTRAR PESSOA COM O DEPARTAMENTO ? (S/N)");
        String opcao = entrada.nextLine();
        String matricula = "";
        if (opcao.equalsIgnoreCase("s")) {
            System.out.println("INFORME A MATRICULA DO DEPARTAMENTO ");
            matricula = entrada.nextLine();
        } else {
            matricula = "*";
        }
        pessoa.setMatriculaDepartamento(conv.padronizaInsercao(matricula, 14));

        mensagem = "1INSERT";                 
        mensagem += pessoa.getCpf();          
        mensagem += pessoa.getNome();        
        mensagem += pessoa.getEndereco();     
        mensagem += pessoa.getMatriculaDepartamento();  

        return mensagem;
    }

    public String pessoaAtualizar() {
        pessoa = new Pessoa();
        conv = Conversao.getInstance();
        entrada = new Scanner(System.in);

        System.out.println("INFORME O CPF DA PESSOA: ");
        String cpf = entrada.nextLine();
        pessoa.setCpf(conv.padronizaInsercao(cpf, 11));

        System.out.println("INFORME O NOME DA PESSOA:  ");
        String nomePessoa = entrada.nextLine();
        pessoa.setNome(conv.padronizaInsercao(nomePessoa, 100));

        System.out.println("INFORME O ENDEREÇO DA PESSOA: ");
        String enderecoPessoa = entrada.nextLine();
        pessoa.setEndereco(conv.padronizaInsercao(enderecoPessoa, 100));

        String matricula = "*";
        pessoa.setMatriculaDepartamento(conv.padronizaInsercao(matricula, 14));

        mensagem = "1UPDATE";                 
        mensagem += pessoa.getCpf();          
        mensagem += pessoa.getNome();         
        mensagem += pessoa.getEndereco();     
        mensagem += pessoa.getMatriculaDepartamento();  

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
