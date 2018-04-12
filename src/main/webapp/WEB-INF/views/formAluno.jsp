<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	
	<body>
		<form:form method="post" modelAttribute="alunoForm" action="alunos">
			Nome: <br>
			<form:input path="name" type="text"/> <br>
			CPF: <br>
			<form:input path="cpf" type="text"/> <br>
			
			<form:errors path="name" /> <br>
			<input type="submit" value="Salvar">	
		</form:form>
		
		<table >
              <tr>
                  <th>Nome</th>
                  <th>CPF</th>
              </tr>
			<c:forEach var="aluno" items="${alunos}">
 				<tr>
					<td>
						${aluno.name}
					</td>
					<td>
						${aluno.cpf}
					</td>
 				</tr>
			</c:forEach>
		</table>
		
	</body>
</html>