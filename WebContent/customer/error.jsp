<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Error</title>
</head>
<body>
	<p style="color:red; text-align: center;">Sorry, your record is not available.<br> Please make sure to enter the correct details.</p>
	<%
		getServletContext().getRequestDispatcher("/login.jsp").include(request, response);
	%>
</body>
</html>