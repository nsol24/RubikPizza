<!--WELCOME PAGE (NOT EDIT YET)-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<link rel="icon" href="img/favicon.png">
<meta charset="ISO-8859-1">
<title>Online Pizza Delivery | Rubiks Pizza</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Welcome</title>

</head>

<body>
	<div class="logo">
		<a href="index.jsp"><img src="img/logo2.png"></a>
	</div>
	
	<nav>
		<ul>
			<li><a href="logout.jsp">LOGOUT</a></li>
			<li><a href="myaccout.jsp">MY ACCOUNT</a></li>
			<li><a href="history.jsp">HISTORY</a></li>
			<li><a href="order.jsp">ORDER</a></li>
			<li><a href="menu.jsp">MENU</a></li>
		</ul>
	</nav>
<h1>Welcome,<%=session.getAttribute("email")%></h1>
</body>

</html>