package controle;

import modelo.Departamento;
import conversao.Conversao;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Robson de Jesus
 */
public class DepartamentoControle {

    Departamento empresa;
    Conversao utils;
    Scanner in;
    String mensagem;

    public String departamentoInserir() throws IOException {
        empresa = new Departamento();
        utils = new Conversao();
        in = new Scanner(System.in);

        System.out.println("INFORME O NOME DO DEPARTAMENTO: ");
        String nomeDep = in.nextLine();
        empresa.setNome(utils.padronizaInsercao(nomeDep, 100));

        System.out.println("INFORME A MATRICULA DO DEPARTAMENTO: ");
        String matricula = in.nextLine();
        empresa.setMatricula(utils.padronizaInsercao(matricula, 14));

        System.out.println("INFORME O ENDEREÇO DO DEPARTAMENTO: ");
        String departamentoEndereco = in.nextLine();
        empresa.setEndereco(utils.padronizaInsercao(departamentoEndereco, 100));

        String cpfPessoa = "*";
        empresa.setCpfPessoa(utils.padronizaInsercao(cpfPessoa, 11));

        mensagem = "2INSERT";               //   7 bytes
        mensagem += empresa.getMatricula();      //  14 bytes
        mensagem += empresa.getNome();      // 100 bytes
        mensagem += empresa.getEndereco();  // 100 bytes 
        mensagem += empresa.getCpfPessoa(); //  11 bytes  => 232 bytes

        System.out.println("Controler pessoa insert " + mensagem);

        return mensagem;
    }

    public String departamentoAtualizar() {
        empresa = new Departamento();
        utils = new Conversao();
        in = new Scanner(System.in);

        System.out.println("INFORME A MATRICULA DO DEPARTAMENTO:  ");
        String matricula = in.nextLine();
        empresa.setMatricula(utils.padronizaInsercao(matricula, 14));

        System.out.println("INFORME O NOME DO DEPARTAMENTO: ");
        String nomeDep = in.nextLine();
        empresa.setNome(utils.padronizaInsercao(nomeDep, 100));

        System.out.println("INFORME O ENDEREÇO DO DEPARTAMENTO: ");
        String departamentoEndereco = in.nextLine();
        empresa.setEndereco(utils.padronizaInsercao(departamentoEndereco, 100));

        String cpfPessoa = "*";
        empresa.setCpfPessoa(utils.padronizaInsercao(cpfPessoa, 11));

        mensagem = "2UPDATE";                //   7 bytes
        mensagem += empresa.getMatricula();       //  11 bytes
        mensagem += empresa.getNome();       // 100 bytes
        mensagem += empresa.getEndereco();   // 100 bytes 
        mensagem += empresa.getCpfPessoa();  //  14 bytes  => 232 bytes

        return mensagem;
    }

    public String departamentoListAll() {
        return "2LIST**";
    }

    public String departamentoBusca() {
        Scanner entrada = new Scanner(System.in);
        String matricula = "";
        System.out.println("INFORME A MATRICULA DO DEPARTAMENTO: ");
        matricula = entrada.nextLine();
        return "2GET***" + matricula;
    }

    public String departamentoExcluir() {
        Scanner entrada = new Scanner(System.in);
        String matricula = "";
        System.out.println("INFORME A MATRICULA DO DEPARTAMENTO: ");
        matricula = entrada.nextLine();
        return "2DELETE" + matricula;
    }

}
