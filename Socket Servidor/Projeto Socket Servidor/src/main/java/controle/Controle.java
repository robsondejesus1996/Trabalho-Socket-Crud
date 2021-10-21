package controle;

import modelo.Departamento;
import modelo.Pessoa;
import conversao.Conversao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Robson de Jesus
 */
public class Controle {

    


    private Conversao con;
    private Pessoa pessoa;
    private Departamento departamento;
    private List<Pessoa> listaPessoas = new ArrayList<>();
    private List<Departamento> listaDepartamentos = new ArrayList();

    public void base() {
        System.out.println("BASE DE DADOS INICIADA...");
        Departamento departamento = new Departamento();
        departamento.setNome("Desenvolvimento de Sistemas");
        departamento.setMatricula("111");
        departamento.setEndereco("Rua do desenvolvimento");
        Departamento departamento2 = new Departamento();
        departamento2.setNome("Qualidade de Software");
        departamento2.setMatricula("222");
        departamento2.setEndereco("Rua da Qualidade");
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Maria tereza de Jesus");
        pessoa.setCpf("123");
        pessoa.setEndereco("Rua da casa");
        listaPessoas.add(pessoa);
        listaDepartamentos.add(departamento);
        listaDepartamentos.add(departamento2);

    }

    public Controle() {
        base();
    }

    public String adicionarPessoas(String mensagem) {
        pessoa = new Pessoa();
        con = Conversao.getInstance();

        pessoa = con.dadosPessoa(mensagem);
        listaPessoas.add(pessoa);

        return "PESSOA INSERIRDA COM SUCESSO!";
    }

    public String adicionarDepartamentos(String mensagem) {
        this.departamento = new Departamento();
        con = Conversao.getInstance();

        departamento = con.dadosDepartamento(mensagem);
        listaDepartamentos.add(departamento);

        return "DEPARTAMENTO INSERIDO COM SUCESSO!";
    }

    public List<Pessoa> getDadosPessoas() {
        return listaPessoas;
    }

    public void setDadosPessoas(List<Pessoa> dadosPessoas) {
        this.listaPessoas = dadosPessoas;
    }

    public List<Departamento> getDadosEmpresas() {
        return listaDepartamentos;
    }

    public void setDadosEmpresas(List<Departamento> dadosEmpresas) {
        this.listaDepartamentos = dadosEmpresas;
    }

    public String listAllPessoas() {
        String pessoas = "";
        for (var pessoa : listaPessoas) {
            pessoas += "Nome: " + pessoa.getNome()
                    + " CPF: " + pessoa.getCpf()
                    + " Endereço: " + pessoa.getEndereco()
                    + " Departamentos: " + pessoa.getMatriculaDepartamento()
                    + " || ";
        }
        return pessoas;
    }

    public String pessoasBuscar(String cpf) {
        String pessoas = "";
        for (var pessoa : listaPessoas) {
            if (pessoa.getCpf().equals(cpf)) {
                pessoas += " Nome: " + pessoa.getNome() + " CPF: " + pessoa.getCpf() + " Endereço: " + pessoa.getEndereco();
                return pessoas;
            }
        }
        return "PESSOA NÃO ENCONTRADA!";
    }

    public String excluirPessoas(String cpf) {
        for (int i = 0; i < listaPessoas.size(); i++) {
            System.out.println("deletar Pessoa: " + listaPessoas.get(i).getCpf());
            if (listaPessoas.get(i).getCpf().equalsIgnoreCase(cpf)) {
                listaPessoas.remove(listaPessoas.get(i));
                return "PESSOA EXCLUÍDA COM SUCESSO!";
            }
        }
        return "PESSOA NÃO ENCONTRADA!";
    }

    public String ListaEmpresas() {
        String departamentos = "";
        for (var dep : listaDepartamentos) {
            departamentos += " Nome: " + dep.getNome() + " Matricula: " + dep.getMatricula() + " Endereço: " + dep.getEndereco() + " || ";
        }
        return departamentos;
    }

    public String departamentosBusca(String matricula) {
        String departamentos = "";
        for (var dep : listaDepartamentos) {
            if (dep.getMatricula().equals(matricula)) {
                departamentos += " Nome: " + dep.getNome() + " Matricula: " + dep.getMatricula() + " Endereço: " + dep.getEndereco();
                return departamentos;
            }
        }
        return "DEPARTAMENTO NÃO ENCONTRADO!";
    }

    public String departamentoExcluir(String matricula) {
        for (int i = 0; i < listaDepartamentos.size(); i++) {
            System.out.println("deletar Departamento: " + listaDepartamentos.get(i).getMatricula());
            if (listaDepartamentos.get(i).getMatricula().equalsIgnoreCase(matricula)) {
                listaDepartamentos.remove(listaDepartamentos.get(i));
//                System.out.println("empresas: " + dadosEmpresas.get(i).getNome());
                return "DEPARTAMENTO EXCLUÍDO COM SUCESSO!";
            }
        }
        return "DEPARTAMENTO NÃO ENCONTRADO! ";
    }

    public String pessoaAtualizar(String mensagem) {
        con = Conversao.getInstance();
        String cpf = con.reverteConversao(mensagem.substring(7, 18));
        pessoa = con.dadosPessoa(mensagem);
        for (int i = 0; i < listaPessoas.size(); i++) {
            if (listaPessoas.get(i).getCpf().equalsIgnoreCase(cpf)) {
                listaPessoas.set(i, pessoa);
                return "PESSOA ATUALIZADA COM SUCESSO!";
            }
        }
        return "PESSOA NÃO PODE SER ATUALIZADA!";
    }

    public String departamentoAtualizar(String mensagem) {
        con = Conversao.getInstance();
        String matricula = con.reverteConversao(mensagem.substring(7, 21));
        departamento = con.dadosDepartamento(mensagem);
        for (int i = 0; i < listaDepartamentos.size(); i++) {
            if (listaDepartamentos.get(i).getMatricula().equalsIgnoreCase(matricula)) {
                listaDepartamentos.set(i, departamento);
                return "DEPARTAMENTO ATUALIZADO COM SUCESSO! ";
            }
        }
        return "DEPARTAMENTO NÃO PODE SER ATUALIZADO!";
    }

}
