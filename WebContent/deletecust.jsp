<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<%
String cust_id = request.getParameter("cust_id");
try
{
	Class.forName("com.mysql.jdbc.Driver");
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-04.cleardb.com:3306/heroku_76c19b622dd9a4e", "b9d191c32faac0", "f4a019ef");
	Statement st = conn.createStatement();
	int i=st.executeUpdate("DELETE FROM customer WHERE cust_id =" + cust_id);
	response.sendRedirect("custview.jsp");
}
catch(Exception e)
{
	System.out.print(e);
	e.printStackTrace();
}
%>