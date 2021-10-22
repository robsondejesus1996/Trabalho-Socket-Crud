package servidor;

import controle.Controle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Robson de Jesus
 */
public class Servidor {

    private Servidor() {

    }
    private static Servidor instance;

    public synchronized static Servidor getInstance() {
        if (instance == null) {
            instance = new Servidor();
        }
        return instance;
    }

    private static Socket socket;
    private static ServerSocket serverSocket;
    private static Controle controle = new Controle();
    private static PrintWriter escrever;

    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(80);
        serverSocket.setReuseAddress(true);

        while (true) {
            clienteOn();
        }

    }

    public static void clienteOn() throws IOException {
        socket = serverSocket.accept();
        System.out.println("CLIENTE CONECTADO");

        InputStreamReader input = new InputStreamReader(socket.getInputStream());
        BufferedReader buffer = new BufferedReader(input);
        String dados = buffer.readLine();
        trataDados(dados);
    }

    public static void sendData(String msg) throws IOException {
        escrever = new PrintWriter(socket.getOutputStream());
        escrever.println(msg);
        escrever.flush();
    }

    public static void trataDados(String mensagem) throws IOException {
        String modelo = mensagem.substring(0, 1);
        String funcoes = mensagem.substring(1, 7);

        System.out.println("mensagem " + mensagem);
        System.out.println("modelo " + modelo);
        System.out.println("funcao " + funcoes);

        switch (funcoes) {
            case "INSERT":
                if (modelo.equalsIgnoreCase("1")) {
                    mensagem = controle.adicionarPessoas(mensagem);
                    sendData(mensagem);
                }
                if (modelo.equalsIgnoreCase("2")) {
                    mensagem = controle.adicionarDepartamentos(mensagem);
                    sendData(mensagem);
                }
                break;
            case "UPDATE":
                if (modelo.equalsIgnoreCase("1")) {
                    mensagem = controle.pessoaAtualizar(mensagem);
                    sendData(mensagem);
                }
                if (modelo.equalsIgnoreCase("2")) {
                    mensagem = controle.departamentoAtualizar(mensagem);
                    sendData(mensagem);
                }
                break;
            case "GET***":
                if (modelo.equalsIgnoreCase("1")) {
                    String cpf = mensagem.substring(7, mensagem.length());
                    mensagem = controle.pessoasBuscar(cpf);
                    sendData(mensagem);
                }
                if (modelo.equalsIgnoreCase("2")) {
                    String cnpj = mensagem.substring(7, mensagem.length());
                    mensagem = controle.departamentosBusca(cnpj);
                    sendData(mensagem);
                }
                break;
            case "DELETE":
                if (modelo.equalsIgnoreCase("1")) {
                    String cpf = mensagem.substring(7, mensagem.length());
                    mensagem = controle.excluirPessoas(cpf);
                    sendData(mensagem);
                }
                if (modelo.equalsIgnoreCase("2")) {
                    String matricula = mensagem.substring(7, mensagem.length());
                    System.out.println("MATRICULA: " + matricula);
                    mensagem = controle.departamentoExcluir(matricula);
                    sendData(mensagem);
                }
                break;
            case "LIST**":
                if (modelo.equalsIgnoreCase("1")) {
                    mensagem = controle.listAllPessoas();
                    sendData(mensagem);
                    clienteOn();
                }
                if (modelo.equalsIgnoreCase("2")) {
                    mensagem = controle.ListaDepartamentos();
                    sendData(mensagem);
                    clienteOn();
                }
                break;
            default:
                System.out.println("OPÇÃO INVALIDA!");
                break;
        }
    }

}
