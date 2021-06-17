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
<title>Home</title>
</head>
	<body>
		
		<%
			Connection con= null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String driverName = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://us-cdbr-east-04.cleardb.com:3306/heroku_76c19b622dd9a4e";
			String user = "b9d191c32faac0";
			String password = "f4a019ef";
			String sql = "select cust_email from customer";
			
			try {
					Class.forName(driverName);
					con = DriverManager.getConnection(url, user, password);
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery(); 
		%>
		<div class="logo"><header>
		<a href="index.jsp"><img src="img/logo2.png"></a></header></div>
	<form class="box" method="post" action="loginS.jsp">
	<h1>CUSTOMER LOGIN</h1><br><br>
	
	<p style="color:white;font-size:18px">EMAIL  : </p><input type="text" name="cust_email" placeholder="Enter your email" required/>

	<p style="color:white; font-size:18px">PASSWORD  : </p><input type="password" name="cust_password"placeholder="Enter your password" required/>
			<% 				
			}
			catch(SQLException sqe)

			{
				out.println("home"+sqe);
			}
			
			%>
			
		<input type="submit" value="submit"/>
	</form>
</body>
</html>
