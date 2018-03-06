<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Agregar soporte para tags JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Customers</title>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			<!-- tabla html de resultados -->
			<table>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Email</th>
				</tr>
				
				<!-- loop para imprimir los resultados -->
				<c:forEach var="tempCustomer" items="${customers}">
					<tr>
						<td> ${tempCustomer.firstName}</td>
						<td> ${tempCustomer.lastName}</td>
						<td> ${tempCustomer.email}</td>
					</tr>
				</c:forEach>
				
			</table>
		</div>
	</div>

</body>
</html>