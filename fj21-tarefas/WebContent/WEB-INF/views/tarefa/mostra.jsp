<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/resources/css/jquery-ui.css" rel="stylesheet">
    <script type="text/javascript" src="/resources/js/jquery.js" ></script>
    <script type="text/javascript" src="resources/js/jquery-ui.js"> </script>
<title>Insert title here</title>
</head>
<body>
	<h3>Alterar tarefa - ${tarefa.id}</h3>
	
	<form action="alteraTarefa" method="post">
		
		<input type="hidden" name="id" value="${tarefa.id}" /> 
		Descrição:<br />
		<textarea name="descricao" rows="5" cols="100">
		${tarefa.descricao}
		</textarea><br /> 
			
			Finalizado? <input type="checkbox" 
			name="finalizado"
			value="true" ${tarefa.finalizado? 'checked' : ''} /> <br /> 
			
			Data de finalização: <br />
    	
    	<input type="text" name="dataFinalizacao" 
      	value="<fmt:formatDate 
      	value="${tarefa.dataFinalizacao.time}" 
      	pattern="dd/MM/yyyy" />"/>
      	
      
    <br />
			
			<input type="submit" value="Alterar" />
	</form>

</body>
</html>