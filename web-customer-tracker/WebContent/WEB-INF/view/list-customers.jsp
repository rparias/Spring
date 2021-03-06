<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Agregar soporte para tags JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Agregar soporte para Spring MVC form tags-->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>List Customers</title>
	
	<!-- referencia a los css -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			
			<!-- boton: Agregar Customer -->
			<input type="button" value="Agregar Customer" 
				   onclick="window.location.href='mostrarFormForAdd'; return false;"
				   class="add-button"
			/>
			
			<!-- agregar formulario para busqueda -->
			<form:form action="search" method="POST">
				Buscar customer:<input type="text" name="nombreIngresado"/>
				<input type="submit" value="Buscar" class="add-button">
			</form:form>
		
			<!-- tabla html de resultados -->
			<table>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Email</th>
					<th>Accion</th>
				</tr>
				
				<!-- loop para imprimir los resultados -->
				<c:forEach var="tempCustomer" items="${customers}">
					
					<!-- construir un link para "actualizar" con el customer id -->
					<c:url var="updateLink" value="/customer/mostrarFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}"/>
					</c:url>
					
					<!-- construir un link para "borrar" con el customer id -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}"/>
					</c:url>
					
					<tr>
						<td> ${tempCustomer.firstName}</td>
						<td> ${tempCustomer.lastName}</td>
						<td> ${tempCustomer.email}</td>
						
						<td>
							<!-- visualizar el updateLink y deleteLink de arriba de actualizar -->
							<a href="${updateLink}">Actualizar</a>
							|
							<a href="${deleteLink}" 
							onclick="if(!(confirm('Esta seguro de eliminar este customer?'))) return false">Eliminar</a>
						</td>
					</tr>
				</c:forEach>
				
			</table>
		</div>
	</div>

</body>
</html>