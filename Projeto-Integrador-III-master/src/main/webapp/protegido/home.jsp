<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Home</title>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/main.css">
    </head>
    
    <body>
        
        <c:import url="../header.jsp"/>

        <section class="container">
            <c:if test="${sessionScope.usuario.isRH()}">
                <article>
                    <h3>Funcionarios</h3>
                    <div class="elemento">
                        <a class="btnG1" href="Funcionarios/CadastroFuncionarios.jsp">Cadastro</a>
                        <a class="btnG1" href="../FuncionarioServlet">Lista</a>
                        <a class="btnG1" href="../FuncionarioServlet?send=Atualizar">Atualizar</a>
                        <a class="btnG1" href="../FuncionarioServlet?send=Excluir">Excluir</a>
                    </div>
                </article>
            </c:if>
            <c:if test="${sessionScope.usuario.isVendedor()}">
                <article>
                    <h3>Cliente</h3>
                    <div class="elemento">
                        <a class="btnG5" href="clientes/cadastro.jsp">Cadastro</a>
                        <a class="btnG5" href="../listaClientes">Lista</a>
                        <a class="btnG5" href="../listaClientes?send=Atualizar">Atualizar</a>
                        <a class="btnG5" href="../listaClientes?send=Excluir">Excluir</a>
                    </div>
                </article>
            </c:if>
        </section>

    </body>
</html>