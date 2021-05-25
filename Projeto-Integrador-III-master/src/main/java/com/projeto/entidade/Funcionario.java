package com.projeto.entidade;

/**
 *
 * @author Icaro
 */
public class Funcionario extends Pessoa{
    
    private int ID_filial;
    private int ID_funcionario;
    private String Atuacao;
    private double Salario;

    public Funcionario(int ID_filial, int ID_funcionario, String Atuacao, double Salario, String CPF, String Nome, String Sobrenome) {
        super(CPF, Nome, Sobrenome);
        this.ID_filial = ID_filial;
        this.ID_funcionario = ID_funcionario;
        this.Atuacao = Atuacao;
        this.Salario = Salario;
    }

    public Funcionario(int ID_filial, String Atuacao, double Salario, String CPF, String Nome, String Sobrenome) {
        super(CPF, Nome, Sobrenome);
        this.ID_filial = ID_filial;
        this.Atuacao = Atuacao;
        this.Salario = Salario;
    }

    public Funcionario(int ID_funcionario, String Nome) {
        super(Nome);
        this.ID_funcionario = ID_funcionario;
    }
    
    public Funcionario(String Nome) {
        super(Nome);
    }
    
    public void setSalario(double Salario) {
        if (Salario <= 0) {
            throw new IllegalArgumentException("Erro salario 0");
        }else{
            this.Salario = Salario;
        }
    }

    public double getSalario() {
        return Salario;
    }
    
    public int getID_filial() {
        return ID_filial;
    }

    public void setID_filial(int ID_filial) {
        this.ID_filial = ID_filial;
    }

    public int getID_funcionario() {
        return ID_funcionario;
    }

    public void setID_funcionario(int ID_funcionario) {
        this.ID_funcionario = ID_funcionario;
    }

    public String getAtuacao() {
        return Atuacao;
    }

    public void setAtuacao(String Atuacao) {
        this.Atuacao = Atuacao;
    }
     
}