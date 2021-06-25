<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/style.css">
<link rel="icon" href="../img/favicon.png">
<meta charset="ISO-8859-1">
<title>Online Pizza Delivery |HomePage</title>
</head>
<body>
	<div class="logo">
		<a href="homepage.jsp"><img src="../img/logo2.png"></a>
	</div>
	<nav>
		<ul>
		
			<li><a href="logout.jsp">LOGOUT</a></li>
			<li><a href="myaccout.jsp">MY ACCOUNT</a></li>
			<li><a href="history.jsp">HISTORY</a></li>
			<li><a href="order.jsp">ORDER</a></li>
			<li><a href="menu.jsp">MENU</a></li>
			<li><a> <%=session.getAttribute("email")%></a></li>
		</ul>
	</nav>
	
	<div style="width: 100%; height: 40px;">
		<img src="../img/banner.jpg" alt="banner" style="float: left; width: 100%; height: 750px; ">
	</div>
</body>
</html>