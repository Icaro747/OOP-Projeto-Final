package com.projeto.entidade;



/**
 *
 * @author Icaro
 */
public class FuncionarioUsuario extends Funcionario{
 
    private String email;
    private String senha;
    private String SenhaFechada;

    public FuncionarioUsuario(String email, int ID_filial, int ID_funcionario, String Atuacao, double Salario, String CPF, String Nome, String Sobrenome) {
        super(ID_filial, ID_funcionario, Atuacao, Salario, CPF, Nome, Sobrenome);
        this.email = email;
    }

    public FuncionarioUsuario(String email, String senha, int ID_filial, int ID_funcionario, String Atuacao, double Salario, String CPF, String Nome, String Sobrenome) {
        super(ID_filial, ID_funcionario, Atuacao, Salario, CPF, Nome, Sobrenome);
        this.email = email;
        this.senha = senha;
    }

    public FuncionarioUsuario(String email, String senha, String SenhaFechada, int ID_filial, int ID_funcionario, String Atuacao, double Salario, String CPF, String Nome, String Sobrenome) {
        super(ID_filial, ID_funcionario, Atuacao, Salario, CPF, Nome, Sobrenome);
        this.email = email;
        this.senha = senha;
        this.SenhaFechada = SenhaFechada;
    }

    public FuncionarioUsuario(String email, String senha, int ID_filial, String Atuacao, double Salario, String CPF, String Nome, String Sobrenome) {
        super(ID_filial, Atuacao, Salario, CPF, Nome, Sobrenome);
        this.email = email;
        this.senha = senha;
    }

    public FuncionarioUsuario(String email, String senha, String Nome) {
        super(Nome);
        this.email = email;
        this.senha = senha;
    }
    
    public FuncionarioUsuario(String Nome) {
        super(Nome);
    }
    
    public String getSenhaFechada() {
        return SenhaFechada;
    }

    public void setSenhaFechada(String SenhaFechada) {
        this.SenhaFechada = SenhaFechada;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public String getEmail() {
        return email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
}