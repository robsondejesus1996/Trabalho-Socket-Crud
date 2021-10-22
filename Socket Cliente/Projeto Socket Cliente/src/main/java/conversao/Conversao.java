package conversao;

import modelo.Pessoa;

/**
 *
 * @author Robson de Jesus
 */
public class Conversao {

    private Conversao() {

    }
    private static Conversao instance;

    public synchronized static Conversao getInstance() {
        if (instance == null) {
            instance = new Conversao();
        }
        return instance;
    }

    public String padronizaInsercao(String variavel, int tamanho) {
        if (variavel.length() > tamanho) {
            variavel = variavel.substring(0, tamanho);
        }
        variavel = String.format("%" + tamanho + "s", variavel);
        variavel = variavel.replaceAll(" ", "*");

        return variavel;
    }

    public Pessoa converteStringPessoa(String msg) {
        Pessoa pessoa = new Pessoa();
        String nome = msg.substring(18, 117);
        pessoa.setNome(reverteConversao(nome));
        String cpf = msg.substring(7, 17);
        pessoa.setCpf(reverteConversao(cpf));
        String endereco = msg.substring(118, 217);
        pessoa.setEndereco(reverteConversao(endereco));
        String cnpjEmpresa = msg.substring(218, 231);
        pessoa.setMatriculaDepartamento(reverteConversao(cnpjEmpresa));
        return pessoa;
    }

    public String reverteConversao(String variavel) {
        return variavel.replaceAll("\\*", " ").trim();
    }
}
