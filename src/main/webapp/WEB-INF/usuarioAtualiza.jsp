<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualiza Usuario</title>
</head>
<body>

	<form action="usuController" method="post">
		<fieldset>
			<legend>ATUALIZA</legend>
			<table>
				<tr>
					<td>ID</td>
					<td><input type="text" name="id" value="${objBuscado.id}" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>Nome</td>
					<td><input type="text" name="nome" value="${objBuscado.nome}" /></td>
				</tr>
				<tr>
					<td>Login</td>
					<td><input type="text" name="login" value="${objBuscado.login}" /></td>
				</tr>
				<tr>
					<td>Senha</td>
					<td><input type="text" name="senha" value="${objBuscado.senha}" /></td>
				</tr>
				<tr>
					<td>Nascimento</td>
					<td><input type="text" name="nascimento" value="<fmt:formatDate value="${objBuscado.nascimento.time}"/>" /></td>
				</tr>
				
				<!--nivel -->
				<tr>
					<td>Nivel</td>
					<td>
						<select name="nivel" id="nivel">
							<c:choose>
								<c:when test="${objBuscado.nivel.id==1}">
									<option value="1"selected="selected">Administrador</option>
									<option value="2">Usuario Comun</option>
									<option value="3">Convidado</option>
								</c:when>
								<c:when test="${objBuscado.nivel.id==2}">
									<option value="1">Administrador</option>
									<option value="2"selected="selected">Usuario Comun</option>
									<option value="3">Convidado</option>
								</c:when>
								<c:when test="${objBuscado.nivel.id==3}">
									<option value="1">Administrador</option>
									<option value="2">Usuario Comun</option>
									<option value="3"selected="selected">Convidado</option>
								</c:when>
							</c:choose>
						</select>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="inserir" value="Inserir" /></td>
				</tr>
			</table>
		</fieldset>
	</form>

</body>
</html>