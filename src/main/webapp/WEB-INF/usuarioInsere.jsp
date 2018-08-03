<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insere novo Usuario</title>
</head>
<body>

	<form action="usuController" method="post">
		<fieldset>
			<legend>CADASTRO</legend>
			<table>
				<tr>
					<td>ID</td>
					<td><input type="text" name="id" value="0" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>Nome</td>
					<td><input type="text" name="nome" value="" /></td>
				</tr>
				<tr>
					<td>Login</td>
					<td><input type="text" name="login" value="" /></td>
				</tr>
				<tr>
					<td>Senha</td>
					<td><input type="text" name="senha" value="" /></td>
				</tr>
				<tr>
					<td>Nascimento</td>
					<td><input type="text" name="nascimento" value="" /></td>
				</tr>
				<!--select -->
				<tr>
					<td>Nivel</td>
					<td>
						<select name="nivel">
							<option value="1" selected="selected">Administrador</option>
							<option value="2">Usuario Comun</option>
							<option value="3">Convidado</option>
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