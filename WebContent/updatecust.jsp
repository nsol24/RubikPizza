<%@page import="java.sql.*"%>
	<%
	String cust_id = request.getParameter("cust_id");
	String driver = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://us-cdbr-east-04.cleardb.com:3306/heroku_76c19b622dd9a4e";
	String userid = "b9d191c32faac0";
	String password = "f4a019ef";
	
	try {
	Class.forName(driver);
	} 
	catch (ClassNotFoundException e) {
	e.printStackTrace();
	}
	
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	%>
	<%
	try{
	connection = DriverManager.getConnection(connectionUrl, userid, password);
	statement = connection.createStatement();
	String sql ="SELECT * FROM customer WHERE cust_id = " + cust_id;
	resultSet = statement.executeQuery(sql);
	
	while(resultSet.next()){
	%>
	
	<!DOCTYPE html>
	<html>
	<body>
	<h1>Update Customer Details</h1>
	<form method="POST" action="updatecustcontroller.jsp">
	<input type="hidden" name="cust_id" value="<%=resultSet.getString("cust_id") %>">
	<input type="text" name="cust_id" value="<%=resultSet.getString("cust_id") %>">
	<br>
	Name:<br>
	<input type="text" name="cust_name" value="<%=resultSet.getString("cust_name") %>">
	<br>
	Address:<br>
	<input type="text" name="cust_address" value="<%=resultSet.getString("cust_address") %>">
	<br>
	Phone:<br>
	<input type="text" name="cust_phone" value="<%=resultSet.getString("cust_phone") %>">
	<br>
	Email:<br>
	<input type="text" name="cust_email" value="<%=resultSet.getString("cust_email") %>">
	<br><br>
	Password:<br>
	<input type="text" name="cust_password" value="<%=resultSet.getString("cust_password") %>">
	<br>
	<input type="submit" value="submit">
	</form>
	<%
	}
	connection.close();
	} catch (Exception e) {
	e.printStackTrace();
	}
	%>
	</body>
	</html>
