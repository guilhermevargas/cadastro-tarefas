<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <link type="text/css" href="resources/css/tarefas.css" rel="stylesheet" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h2>P�gina de login das tarefas</h2>

<form action="efetuaLogin" method="post">
	Login: <input type="text" name="login" /><br />
	Senha: <input type="password" name="senha" /><br />
	<input type="submit" value="Entrar nas tarefas" />  
</form>
</body>
</html>