/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversao;

import modelo.Departamento;
import modelo.Pessoa;

/**
 *
 * @author Robson de Jesus
 */
public class Conversao {
    
    
    public Pessoa stringPessoa(String mensagem){
        Pessoa pessoa = new Pessoa();
        return pessoa;
    }
    
    public Departamento stringDepartamento(String mensagem){
        Departamento departamento = new Departamento();
        
        return departamento;
    }
}
