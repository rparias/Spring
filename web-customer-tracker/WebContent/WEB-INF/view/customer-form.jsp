<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Agregar soporte para Spring MVC form tags-->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Agregar Customer</title>
	
	<!-- referencia a los css -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<h3>Guardar Customer</h3>
			
			<!-- form: Agregar Customer -->
			<form:form action="guardarCustomer" modelAttribute="customer" method="POST">
				
				<table>
					<tbody>
						<tr>
							<td><label>Nombre:</label></td>
							<td><form:input path="firstName"/></td>
						</tr>
						<tr>
							<td><label>Apellido:</label></td>
							<td><form:input path="lastName"/></td>
						</tr>
						<tr>
							<td><label>Email:</label></td>
							<td><form:input path="email"/></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Guardar" class="save"/></td>
						</tr>
					</tbody>
				</table>
				
			</form:form>
			
			<!-- boton de navegacion para volver atras -->
			<div style="clear; both;"></div>
			<p>
				<a href="${pageContext.request.contextPath}/customer/list">Volver a la lista</a>
			</p>
		</div>
	</div>
</body>
</html>