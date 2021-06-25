<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ page import="Model.*,Dao.*,java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<head>
<link rel="stylesheet" href="../css/style.css">
<link rel="icon" href="../img/favicon.png">
<title>Register | Rubiks Pizza</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<meta name="keywords" content="Rubiks Pizza">
</head>
<body>
	<!-- NAVIGATION BAR -->
	<nav><div class="logo">
		<a href="homepage.jsp"><img src="../img/logo2.png"></a>
	</div>
	</nav>
	

	<!-- ADD CUSTOMER FORM -->
	<div>
		<br>
		<br>
		<div class="container">
			<form id="signup" method="POST" action="RegisterController">
				<h1>Welcome</h1><br>
				<h3>Please fill in the details below</h3><br><br>
				
				<label class="name-txt">Name</label><br>
				<input placeholder="Name" class="name" type="text" name="cust_name" required><br><br>
				
				<label class="address-txt">Address:</label><br>
				<textarea placeholder="Enter you address" class="address" id="address" name="cust_address" rows="5" cols="30" required></textarea><br><br>
				
				<label class="phone-txt">Phone Number</label><br>
				<input placeholder="Enter phone number (e.g 0123456789)" class="phone" type="text" name="cust_phone" required><br><br>
				
				<label class="email-txt">Email</label><br>
				<input placeholder="Enter a valid email address" class="email" type="text" name="cust_email" required><br><br>
				
				<label class="password-txt">Password:</label><br>
				<input placeholder="Enter password" class="password" type="password" name="cust_password" required><br><br><br>
				
				<input type="submit" class="submit-btn" value="REGISTER">
			</form>
			<a href="login.jsp">LOGIN</a>
		</div>
	</div>
</body>
<footer class="footer">
    <p>#169 2021 <span style="font-weight: bold;">Rubik's Pizza Delivery System. </span>All rights reserved. Fully developed by <span style="font-weight: bold;">NETFREAK</span></p>
</footer>
</html>