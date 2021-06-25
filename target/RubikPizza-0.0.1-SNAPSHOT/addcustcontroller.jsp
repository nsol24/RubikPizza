
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = request.getParameter("cust_name");
		String address = request.getParameter("cust_address");
		String phone = request.getParameter("cust_phone");
		String email = request.getParameter("cust_email");
		String password = request.getParameter("cust_password");

		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-04.cleardb.com:3306/heroku_76c19b622dd9a4e", "b9d191c32faac0", "f4a019ef");
		Statement st = conn.createStatement();
		
		st.executeUpdate("INSERT INTO customer (cust_name, cust_address, cust_phone, cust_email, cust_password) values ('"+name+"','"+address+"','"+phone+"', '"+email+"', '"+password+"')");
		response.sendRedirect("custview.jsp");
		}
		catch(Exception e)
		{
		System.out.print(e);
		e.printStackTrace();
		}
	%>
</body>
</html>
