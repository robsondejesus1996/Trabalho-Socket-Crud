package clientes;

import controle.DepartamentoControle;
import controle.PessoaControle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Robson de Jesus
 */
public class Clientes {

    private static final int porta = 80;
    private static final String address = "localhost";

    private static PessoaControle controleP;
    private static DepartamentoControle controleDep;

    private static Socket socket;
    private static Scanner entrada;

    public static void main(String[] args) throws IOException {

        while (true) {
            opcoes();
        }

    }

    public static void sendData(String msg) throws IOException {
        socket = new Socket(address, porta);
        PrintWriter pr = new PrintWriter(socket.getOutputStream());
        pr.println(msg);
        pr.flush();
    }

    public static void receiveData() throws IOException {
        InputStreamReader inpput = new InputStreamReader(socket.getInputStream());
        BufferedReader buffer = new BufferedReader(inpput);
        String dados = buffer.readLine();
        System.out.println("Server: " + dados);
    }

    public static void opcoes() throws IOException {
        System.out.println("MENU DE OPÇÕES CRUD SOCKET"
                + "\n1 - INSERIR(PESSOA/DEPARTAMENTO) "
                + "\n2 - ATUALIZAR(PESSOA/DEPARTAMENTO)  "
                + "\n3 - BUSCAR(PESSOA/DEPARTAMENTO) "
                + "\n4 - EXCLUIR(PESSOA/DEPARTAMENTO) "
                + "\n5 - LISTAR(PESSOA/DEPARTAMENTO) "
                + "\n6 - SAIR");
        entrada = new Scanner(System.in);
        int operacao = entrada.nextInt();

        String[] operacoes = {"inserir", "atualizar", "buscar", "deletar", "listar"};
        System.out.println("Deseja " + operacoes[operacao - 1] + ": "
                + "\n1 - Pessoa"
                + "\n2 - Empresa");
        int modelo = entrada.nextInt();

        controleP = new PessoaControle();
        controleDep = new DepartamentoControle();

        String mensagem = "";
        switch (operacao) {
            case 1: // INSERT
                if (modelo == 1) {
                    mensagem = controleP.pessoaInserir();
                    sendData(mensagem);
                    receiveData();
                }
                if (modelo == 2) {
                    mensagem = controleDep.departamentoInserir();
                    sendData(mensagem);
                    receiveData();
                }
                opcoes();
                break;
            case 2: // UPDATE
                if (modelo == 1) {
                    mensagem = controleP.pessoasListAll();
                    sendData(mensagem);
                    receiveData();
                    mensagem = controleP.pessoaAtualizar();
                    sendData(mensagem);
                    receiveData();
                }
                if (modelo == 2) {
                    mensagem = controleDep.departamentoListAll();
                    sendData(mensagem);
                    receiveData();
                    mensagem = controleDep.departamentoAtualizar();
                    sendData(mensagem);
                    receiveData();
                }
                opcoes();
                break;
            case 3: // GET
                if (modelo == 1) {
                    mensagem = controleP.pessoaBuscar();
                    sendData(mensagem);
                    receiveData(); // retorno da pessoa
                }
                if (modelo == 2) {
                    mensagem = controleDep.departamentoBusca();
                    sendData(mensagem);
                    receiveData();
                }
                opcoes();
                break;
            case 4: //DELETE
                if (modelo == 1) {
                    mensagem = controleP.pessoaExcluir();
                    sendData(mensagem);
                    receiveData();
                }
                if (modelo == 2) {
                    mensagem = controleDep.departamentoExcluir();
                    sendData(mensagem);
                    receiveData();
                }
                opcoes();
                break;
            case 5: //LIST
                if (modelo == 1) {
                    mensagem = controleP.pessoasListAll();
                    sendData(mensagem);
                    receiveData();
                }
                if (modelo == 2) {
                    mensagem = controleDep.departamentoListAll();
                    sendData(mensagem);
                    receiveData();
                }
                opcoes();
                break;
            case 6: // SAIR DA APLICAÇÃO
                entrada.close();
                socket.close();
                break;
            default:
                System.out.println("ERRO DE OPÇÃO.");
                opcoes();
                break;
        }
    }


}
