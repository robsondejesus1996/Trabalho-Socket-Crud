/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import controle.Controle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Robson de Jesus
 */
public class Servidor {

    private static Socket socket;
    private static ServerSocket socketServer;
    private static Controle controle = new Controle();
    private static PrintWriter print;

    public static void main(String[] args) {
        try {
            socketServer = new ServerSocket(80);
            socketServer.setReuseAddress(true);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERRO INICIALIZAÇÃO SERVER SOCKET: <SERVIDOR>");
        }

        while (true) {
            clientesOn();
        }
    }

    private static void clientesOn() {
        try {
            socket = socketServer.accept();
            JOptionPane.showMessageDialog(null, "Cliente Conectado com sucesso!");
            InputStreamReader entrada = new InputStreamReader(socket.getInputStream());
            BufferedReader buffer = new BufferedReader(entrada);
            String dados = buffer.readLine();
            controleDados(dados);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERRO DE CONEXÃO COM O CLIENTE <SERVIDOR>");
        }
    }

    public static void dadosCliente(String mensagem) {
        try {
            print = new PrintWriter(socket.getOutputStream());
            print.println(mensagem);
            print.flush();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERRO DE ENVIO DE DADOS <SERVIDOR>");
        }
    }

    public static void controleDados(String mensagem) {
        String modelo = mensagem.substring(0, 1);
        String funcao = mensagem.substring(1, 7);

        System.out.println("mensagem " + mensagem);
        System.out.println("modelo " + modelo);
        System.out.println("funcao " + funcao);

        switch (funcao) {
            case "INSERIR":
                if (modelo.equals("1")) {
                    mensagem = controle.adicionarPessoa(mensagem);
                    dadosCliente(mensagem);

                } else if (modelo.equals("2")) {
                    mensagem = controle.adicionarDepartamento(mensagem);
                    dadosCliente(mensagem);
                }
                break;
        }
    }
}
