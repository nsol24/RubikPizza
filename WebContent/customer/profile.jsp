<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.sql.*" %>
	<%@ page import="Model.*,Dao.*,java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/homepage.css">
<link rel="icon" href="../img/favicon.png">

<meta charset="ISO-8859-1">
<title>Profile</title>

</head>
<body>
	<div class="logo">
		<a href="homepage.jsp"><img src="../img/logo2.png"></a>
	</div>
	<nav>
		<ul>
		
			<li><a href="logout.jsp">LOGOUT</a></li>
			<li><a>MY ACCOUNT</a></li>
			<li><a href="homepage.jsp">HOMEPAGE</a></li>
			
			
		</ul>
	</nav>
	
	<table>
		<% String email = (String) session.getAttribute("email"); %>
		<% Customer cust = customerDAO.getCustomerByEmail(email); %>
		<b>name: </b><%=cust.getName()%><br>
		<b>name: </b><%=cust.getAddress()%><br>
		<b>name: </b><%=cust.getPhone()%><br>
		
	
	
	
	</table>
	
	
</body>
</html>