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
		
		<table >
              <tr>
                  <th>Nome</th>
                  <th>ID</th>
              </tr>
			<c:forEach var="item" items="${items}">
 				<tr>
					<td>
						${item.nome}
					</td>
					<td>
						${item.id}
					</td>
 				</tr>
			</c:forEach>
		</table>
		
	</body>
</html>