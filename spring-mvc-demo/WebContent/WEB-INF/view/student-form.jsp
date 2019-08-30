<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
<title>Student Registration Form</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">
	
		First name: <form:input path="firstName" />

		<br>
		<br>
	
		Last name: <form:input path="lastName" />

		<br>
		<br>

		Favorite Language:
		
		Java:<form:radiobutton path="favoriteLanguage" value="Java"/>
		Pyhton:<form:radiobutton path="favoriteLanguage" value="python"/>
		C:<form:radiobutton path="favoriteLanguage" value="c"/>
		Php:<form:radiobutton path="favoriteLanguage" value="php"/>
		

		<br>
		<br>
		
		Linux <form:checkbox path="operatingSystems" value="Linux"/>		
		Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
		Windows <form:checkbox path="operatingSystems" value="MS Windows"/>
		
		<br>
		<br>
		

		<form:select path="country">
			<form:options items="${student.countryOptions}" />
		</form:select>
		
		<br>
		<br>
		
		

		<input type="submit" value="Submit" />

	</form:form>


</body>

</html>









