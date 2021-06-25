<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="Model.*,Dao.*,java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="logincust.css">
<link rel="icon" href="../img/favicon.png">
<meta charset="ISO-8859-1">
<title>Login</title>
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
		<div class="container">
			<div class="screen">
				<div class="screen__content">
					<form action="loginS.jsp" method="post" class="login">
					
						<div class="login__field">
							<i class="login__icon fas fa-user"></i>
							<input type="text" class="login__input" placeholder="Email" name="cust_email">
						</div>
						<div class="login__field">
							<i class="login__icon fas fa-lock"></i>
							<input type="password" class="login__input" placeholder="Password" name="cust_password">
						</div>
						<% 				
							}
							catch(SQLException sqe)
				
							{
								out.println("home"+sqe);
							}
							
						%>		
						<input type="submit" value="Log In Now">		
					</form>
					<a href="register.jsp">Register Now</a>
				</div>
				<div class="screen__background">
					<span class="screen__background__shape screen__background__shape4"></span>
					<span class="screen__background__shape screen__background__shape3"></span>		
					<span class="screen__background__shape screen__background__shape2"></span>
					<span class="screen__background__shape screen__background__shape1"></span>
				</div>		
			</div>
		</div>
	
	
	
</body>
</html>