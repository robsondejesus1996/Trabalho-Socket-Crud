package conversao;

import modelo.Departamento;
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

    public Pessoa dadosPessoa(String mensagem) {
        Pessoa pessoa = new Pessoa();
        String nome = mensagem.substring(18, 118);
        pessoa.setNome(reverteConversao(nome));
        String cpf = mensagem.substring(7, 18);
        pessoa.setCpf(reverteConversao(cpf));
        String endereco = mensagem.substring(118, 217);
        pessoa.setEndereco(reverteConversao(endereco));
        String matricula = mensagem.substring(218, 232);
        pessoa.setMatriculaDepartamento(reverteConversao(matricula));
        return pessoa;
    }

    public Departamento dadosDepartamento(String mensagem) {
        Departamento dep = new Departamento();
        String nome = mensagem.substring(21, 120);
        dep.setNome(reverteConversao(nome));
        String matricula = mensagem.substring(7, 20);
        dep.setMatricula(reverteConversao(matricula));
        String endereco = mensagem.substring(121, 220);
        dep.setEndereco(reverteConversao(endereco));
        return dep;
    }

    public String reverteConversao(String variavel) {
        return variavel.replaceAll("\\*", " ").trim();
    }

}
