<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tela de Login</title>
</head>
<body>
	<form action="usuLogin" method="post">
		<fieldset>
			<legend>TELA DE LOGIN</legend>
			<table>
				<tr>
					<td>Login</td>
					<td><input type="text" name="login" required="required"></td>
				</tr>
				<tr>
					<td>Senha</td>
					<td><input type="text" name="senha" required="required"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="entrar" value="Entrar"></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>