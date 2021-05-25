package com.projeto.entidade;


/**
 *
 * @author Icaro
 */
public class Cliente extends Pessoa{
    
    private int ID_Cliente;
    
    public Cliente(int ID_Cliente, String CPF, String Nome) {
        super(CPF, Nome);
        this.ID_Cliente = ID_Cliente;
    }

    public Cliente(String CPF, String Nome) {
        super(CPF, Nome);
    }

    public Cliente(int ID_Cliente, String Nome) {
        super(Nome);
        this.ID_Cliente = ID_Cliente;
    }
    
    public Cliente(String Nome) {
        super(Nome);
    }
    
    public int getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }
    
}