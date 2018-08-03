<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Usuarios</title>
</head>
<body>

	<form action="usuController" method="get">
		<fieldset>
			<legend>LISTA DE USUARIOS</legend>
			<table border="1">
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Login</th>
					<th>Senha</th>
					<th>Nascimento</th>
					<th>Nivel</th>
					<th>Editar</th>
					<th>Remover</th>
				</tr>
				<c:forEach items="${lista}" var="u">
					<tr>
						<td>${u.id}</td>
						<td>${u.nome}</td>
						<td>${u.login}</td>
						<td>${u.senha}</td>
						<td><fmt:formatDate value="${u.nascimento.time}" /></td>
						<td>${u.nivel.descricao}</td>
						<td><a href="usuController?acao=atualizar&id=${u.id}">Atualizar</a>
						</td>
						<td><a href="usuController?acao=excluir&id=${u.id}">Excluir</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</fieldset>
	</form>
	<table>
		<tr>
			<td><a href="usuController?acao=inserir">Novo</a></td>
			<td>||</td>
			<td><a href="usuLogin">Sair</a></td>
		</tr>
	</table>
	<table>
		<tr>
			<td>Bem Vindo : </td>
			<td><c:out value="${usuarioSessaoNome}"></c:out> </td>
		</tr>
	</table>

</body>
</html>