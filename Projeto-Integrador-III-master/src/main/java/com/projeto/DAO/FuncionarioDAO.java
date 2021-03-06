package com.projeto.DAO;

import com.projeto.conexao.GerenciadorConexao;
import com.projeto.entidade.Funcionario;
import com.projeto.entidade.FuncionarioUsuario;
import com.projeto.entidade.FuncionarioUsuarioCargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas vinicius
 */
public class FuncionarioDAO {
    
    public static boolean cadastrar (FuncionarioUsuario funcionario){
       
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        String query = "insert into FUNCIONARIO (Nome, Sobrenome, Email, Senha, CPF, Atuacao, Salario, FK_Flial) VALUES (?,?,?,?,?,?,?,?)";
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement(query);
            instrucaoSQL.setString(1, funcionario.getNome());
            instrucaoSQL.setString(2, funcionario.getSobrenome());
            instrucaoSQL.setString(3, funcionario.getEmail());
            instrucaoSQL.setString(4, funcionario.getSenha());
            instrucaoSQL.setString(5, funcionario.getCPF());
            instrucaoSQL.setString(6, funcionario.getAtuacao());
            instrucaoSQL.setDouble(7, funcionario.getSalario());
            instrucaoSQL.setInt(8, funcionario.getID_filial());

            int linhaAfetadas = instrucaoSQL.executeUpdate();
            return linhaAfetadas > 0;
        } catch (SQLException e){
                throw new IllegalArgumentException(e.getMessage());
        }finally{
            try {
                if (instrucaoSQL!=null) {
                    instrucaoSQL.close();
                }
                if (conexao!=null) {
                    conexao.close();
                    GerenciadorConexao.fecharConexao();  
                }
            } catch (SQLException e) {
            }
        }
    }
   
    public static List<FuncionarioUsuario> getFuncionarios(){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        List<FuncionarioUsuario> Funcionarios = new ArrayList<>();
        
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM Funcionario");
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next()){
                int ID_funcionario = rs.getInt("ID_Funcionario");
                int IDFlial = rs.getInt("FK_Flial");
                String Nome = rs.getString("Nome");
                String Sobrenome = rs.getString("Sobrenome");
                String Email = rs.getString("Email");
                String CPF = rs.getString("CPF");
                String Atuacao = rs.getString("Atuacao");
                double Salario = rs.getDouble("Salario");
                
                FuncionarioUsuario fun = new FuncionarioUsuario(Email, IDFlial, ID_funcionario, Atuacao, Salario, CPF, Nome, Sobrenome);
                
                Funcionarios.add(fun);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }finally{
            try {
                if (rs!=null) {
                    rs.close();
                }
                if (instrucaoSQL!=null) {
                    instrucaoSQL.close();
                }
                if (conexao!=null) {
                    conexao.close();
                    GerenciadorConexao.fecharConexao();  
                }
            } catch (SQLException e) {
            }
        }
        return Funcionarios;
    }
    
    public static FuncionarioUsuario getFuncionario(FuncionarioUsuario fun){
        
        ResultSet rs;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareCall("SELECT * FROM Funcionario WHERE ID_Funcionario = ?");
            
            instrucaoSQL.setInt(1, fun.getID_funcionario());
            rs = instrucaoSQL.executeQuery();
            
            if (rs.next()) {
                fun.setID_funcionario(rs.getInt("ID_Funcionario"));
                fun.setNome(rs.getString("nome"));
                fun.setSobrenome(rs.getString("Sobrenome"));
                fun.setEmail(rs.getString("Email"));
                fun.setCPF(rs.getString("CPF"));
                fun.setAtuacao(rs.getString("Atuacao"));
                fun.setSalario(rs.getDouble("Salario"));
                fun.setID_filial(rs.getInt("FK_Flial"));
                return fun;
            }else{
                throw new IllegalArgumentException("erro");
            }
        }catch (SQLException e){
            throw new IllegalArgumentException(e);
        }finally{
            try {
                if (instrucaoSQL!=null) {
                    instrucaoSQL.close();
                }
                if (conexao!=null) {
                    conexao.close();
                    GerenciadorConexao.fecharConexao();  
                }
            } catch (SQLException e) {
            }
        }
    }
    
    public static boolean Excluir(Funcionario fun){
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("DELETE FROM Funcionario WHERE ID_Funcionario = ?");
            
            instrucaoSQL.setInt(1, fun.getID_funcionario());
            
            int linhaAfetadas = instrucaoSQL.executeUpdate();
            return linhaAfetadas > 0;
            
        } catch (SQLException e){
            throw new IllegalArgumentException(e.getMessage());
        }finally{
            try {
                if (instrucaoSQL!=null) {
                    instrucaoSQL.close();
                }
                if (conexao!=null) {
                    conexao.close();
                    GerenciadorConexao.fecharConexao();  
                }
            } catch (SQLException e) {
            }
        }
    }
    
    public static boolean Atualizar(FuncionarioUsuario fun){
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("UPDATE Funcionario SET Nome = ?, Sobrenome = ?, Email = ?, CPF = ?, Atuacao = ?, Salario = ?, FK_Flial = ? WHERE ID_Funcionario = ?");
            
            instrucaoSQL.setString(1, fun.getNome());
            instrucaoSQL.setString(2, fun.getSobrenome());
            instrucaoSQL.setString(3, fun.getEmail());
            instrucaoSQL.setString(4, fun.getCPF());
            instrucaoSQL.setString(5, fun.getAtuacao());
            instrucaoSQL.setDouble(6, fun.getSalario());
            instrucaoSQL.setInt(7, fun.getID_filial());
            instrucaoSQL.setInt(8, fun.getID_funcionario());
            
            int linhaAfetadas = instrucaoSQL.executeUpdate();
            return linhaAfetadas > 0;
            
        } catch (SQLException e){
            throw new IllegalArgumentException(e);
        }finally{
            try {
                if (instrucaoSQL!=null) {
                    instrucaoSQL.close();
                }
                if (conexao!=null) {
                    conexao.close();
                    GerenciadorConexao.fecharConexao();  
                }
            } catch (SQLException e) {
            }
        }
    }

    public static FuncionarioUsuarioCargo login(FuncionarioUsuarioCargo fun){
        
        ResultSet rs;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareCall("SELECT ID_Funcionario, Senha, nome, Atuacao, FK_Flial FROM Funcionario WHERE Email = ?");
            
            instrucaoSQL.setString(1, fun.getEmail());
            rs = instrucaoSQL.executeQuery();
            
            if (rs.next()) {
                fun.setID_funcionario(rs.getInt("ID_Funcionario"));
                fun.setSenhaFechada(rs.getString("Senha"));
                fun.setNome(rs.getString("nome"));
                fun.setAtuacao(rs.getString("Atuacao"));
                fun.setID_filial(rs.getInt("FK_Flial"));
                return fun;
            }else{
                throw new IllegalArgumentException("erro");
            }
        }catch (SQLException | IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }finally{
            try {
                if (instrucaoSQL!=null) {
                    instrucaoSQL.close();
                }
                if (conexao!=null) {
                    conexao.close();
                    GerenciadorConexao.fecharConexao();  
                }
            } catch (SQLException e) {
            }
        }
    }
}