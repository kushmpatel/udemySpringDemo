<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Customer Confirmation</title>

<style>
.error {
	color: red
}
</style>

</head>
<body>
	The customer is confirmed: ${customer.firstName } ${customer.lastName }
	
	<br><br>
	
	Free Passes: ${customer.freePasses }
	
	<br><br>
	
	PostalCode: ${customer.postalCode }
	
	<br><br>
	
	CourseCode: ${customer.courseCode }
	
</body>
</html>
