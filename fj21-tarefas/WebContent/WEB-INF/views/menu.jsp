<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <body>
    <h2>P�gina inicial da Lista de Tarefas</h2>
    <p>Bem vindo, ${usuarioLogado.login}</p> 
    <a href="listaTarefas">Clique aqui</a> para acessar a 
    lista de tarefas<br />
    <a href="logout">Sair do sistema</a>
  </body>
</html>