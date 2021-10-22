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
    
    private DepartamentoControle(){
        
    }
    private static DepartamentoControle instance;
    
    public synchronized static DepartamentoControle getInstance(){
        if(instance == null){
            instance = new DepartamentoControle();
        }
        return instance;
    }

    Departamento departamento;
    Conversao conv;
    Scanner entrada;
    String mensagem;

    public String departamentoInserir() throws IOException {
        departamento = new Departamento();
        conv = Conversao.getInstance();
        entrada = new Scanner(System.in);

        System.out.println("INFORME O NOME DO DEPARTAMENTO: ");
        String nomeDep = entrada.nextLine();
        departamento.setNome(conv.padronizaInsercao(nomeDep, 100));

        System.out.println("INFORME A MATRICULA DO DEPARTAMENTO: ");
        String matricula = entrada.nextLine();
        departamento.setMatricula(conv.padronizaInsercao(matricula, 14));

        System.out.println("INFORME O ENDEREÇO DO DEPARTAMENTO: ");
        String departamentoEndereco = entrada.nextLine();
        departamento.setEndereco(conv.padronizaInsercao(departamentoEndereco, 100));

        String cpfPessoa = "*";
        departamento.setCpfPessoa(conv.padronizaInsercao(cpfPessoa, 11));

        mensagem = "2INSERT";               //   7 bytes
        mensagem += departamento.getMatricula();      //  14 bytes
        mensagem += departamento.getNome();      // 100 bytes
        mensagem += departamento.getEndereco();  // 100 bytes 
        mensagem += departamento.getCpfPessoa(); //  11 bytes  => 232 bytes

        System.out.println("Controler pessoa insert " + mensagem);

        return mensagem;
    }

    public String departamentoAtualizar() {
        departamento = new Departamento();
        conv = Conversao.getInstance();
        entrada = new Scanner(System.in);

        System.out.println("INFORME A MATRICULA DO DEPARTAMENTO:  ");
        String matricula = entrada.nextLine();
        departamento.setMatricula(conv.padronizaInsercao(matricula, 14));

        System.out.println("INFORME O NOME DO DEPARTAMENTO: ");
        String nomeDep = entrada.nextLine();
        departamento.setNome(conv.padronizaInsercao(nomeDep, 100));

        System.out.println("INFORME O ENDEREÇO DO DEPARTAMENTO: ");
        String departamentoEndereco = entrada.nextLine();
        departamento.setEndereco(conv.padronizaInsercao(departamentoEndereco, 100));

        String cpfPessoa = "*";
        departamento.setCpfPessoa(conv.padronizaInsercao(cpfPessoa, 11));

        mensagem = "2UPDATE";                //   7 bytes
        mensagem += departamento.getMatricula();       //  11 bytes
        mensagem += departamento.getNome();       // 100 bytes
        mensagem += departamento.getEndereco();   // 100 bytes 
        mensagem += departamento.getCpfPessoa();  //  14 bytes  => 232 bytes

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
