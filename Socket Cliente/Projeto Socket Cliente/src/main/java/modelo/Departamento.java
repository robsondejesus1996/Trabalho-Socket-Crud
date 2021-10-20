package modelo;


/**
 *
 * @author Robson de Jesus
 */
public class Departamento {

    private String nome;
    private String matricula;
    private String endereco;
    private String cpfPessoa;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }

    public void setCpfPessoa(String cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
    }

    @Override
    public String toString() {
        return "Empresa{" + "nome=" + nome + ", matricula=" + matricula + ", endereco=" + endereco + '}';
    }

}
