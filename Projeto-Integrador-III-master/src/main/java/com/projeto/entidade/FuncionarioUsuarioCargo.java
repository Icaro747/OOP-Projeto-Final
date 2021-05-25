package com.projeto.entidade;

/**
 *
 * @author Icaro
 */
public class FuncionarioUsuarioCargo extends FuncionarioUsuario{

    private static boolean Vendedor;
    private static boolean RH;
    private static boolean ADM;
    private static boolean Gerente;
    private static boolean Suporte;

    public FuncionarioUsuarioCargo(String email, int ID_filial, int ID_funcionario, String Atuacao, double Salario, String CPF, String Nome, String Sobrenome) {
        super(email, ID_filial, ID_funcionario, Atuacao, Salario, CPF, Nome, Sobrenome);
    }

    public FuncionarioUsuarioCargo(String email, String senha, String Nome) {
        super(email, senha, Nome);
    }
    
    public void setCargo(){
        switch (getAtuacao()){
            case "Vendedor":
                Vendedor = true;
                RH = false;
                ADM = false;
                Gerente = false;
                Suporte = false;
            break;
            case "RH":
                Vendedor = false;
                RH = true;
                ADM = false;
                Gerente = false;
                Suporte = false;
            break;
            case "ADM":
                Vendedor = false;
                RH = false;
                ADM = true;
                Gerente = false;
                Suporte = false;
            break;
            case "Gerente":
                Vendedor = false;
                RH = false;
                ADM = false;
                Gerente = true;
                Suporte = false;
            break;
            case "Suporte":
                Vendedor = false;
                RH = false;
                ADM = false;
                Gerente = false;
                Suporte = true;
            break;
        }
    }

    public static boolean isVendedor() {
        if (ADM) {
            return ADM;
        }else
            return Vendedor;
    }

    public static boolean isRH() {
        if (ADM) {
            return ADM;
        }else
            return RH;
    }

    public static boolean isADM() {
        return ADM;
    }

    public static boolean isGerente() {
        if (ADM) {
            return ADM;
        }else
            return Gerente;
    }

    public static boolean isSuporte() {
        if (ADM) {
            return ADM;
        }else
            return Suporte;
    }
}
