<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!Docktype html>
<html>
<head>
	<title>Student Registration Form</title>
</head>

<body>
	<form:form action="processForm" modelAttribute="student">
		First name: <form:input path="firstName"/>
		<br><br>
		Last name: <form:input path="lastName"/>
		<br><br>
		
		<!-- DropdownList -->
		Country:
		<form:select path="country">
			<form:options items="${student.countryOptions}" />
		</form:select>
		
		<br><br>
		
		<!-- Radiobutton -->
		Favorite Language:
		Java<form:radiobutton path="favoriteLanguage" value="Java"/>
		C#<form:radiobutton path="favoriteLanguage" value="C#"/>
		PHP<form:radiobutton path="favoriteLanguage" value="PHP"/>
		Python<form:radiobutton path="favoriteLanguage" value="Python"/>
		
		<br><br>
		
		<!-- Checkbox -->
		Operating Systems:
		Linux<form:checkbox path="operatingSystems" value="Linux"/>
		Mac OS<form:checkbox path="operatingSystems" value="Mac OS"/>
		Windows<form:checkbox path="operatingSystems" value="Windows"/>
		
		<br><br>
		<input type="submit" value="Submit" />
		
	</form:form>
</body>
</html>