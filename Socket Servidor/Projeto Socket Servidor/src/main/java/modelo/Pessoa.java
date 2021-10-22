package modelo;

/**
 *
 * @author Robson de Jesus
 */
public class Pessoa {

    private String cpf;
    private String nome;
    private String endereco;
    private String matriculaDepartamento;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getMatriculaDepartamento() {
        return matriculaDepartamento;
    }

    public void setMatriculaDepartamento(String matriculaDepartamento) {
        this.matriculaDepartamento = matriculaDepartamento;
    }

    

    @Override
    public String toString() {
        return "[ Nome: " + nome + " CPF: " + cpf + " Endereco: " + endereco + " Matricula departamento: " + matriculaDepartamento + ']';
    }

}
