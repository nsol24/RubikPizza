<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<link rel="icon" href="img/favicon.png">
<title>Update Customer Details | Rubiks Pizza</title>
</head>
<body>
	<!-- NAVIGATION BAR -->
	<div class="logo">
		<a href="index.jsp"><img src="img/logo2.png"></a>
	</div>
	<nav>
		<ul>
			<li><a href="addcust.html">REGISTER</a></li>
			<li><a href="custview.jsp">VIEW LIST</a></li>
			<li><a href="index.jsp">HOME</a></li>
		</ul>
	</nav>

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
	<form class="update-customer-form" method="POST" action="updatecustcontroller.jsp">
		<h1>Update Customer Details</h1><br>
		<h3>Please make detail changes below</h3><br><br>
		
		<label class="id-txt">Customer ID</label><br>
		<input type="hidden" name="cust_id" value="<%=resultSet.getString("cust_id") %>">
		<input type="text" class="id" name="cust_id" value="<%=resultSet.getString("cust_id") %>"><br><br>
		
		<label class="name-txt">Name</label><br>
		<input type="text" class="name" name="cust_name" value="<%=resultSet.getString("cust_name") %>"><br><br>
		
		<label class="address-txt">Address:</label><br>
		<input type="text" class="address" name="cust_address" value="<%=resultSet.getString("cust_address") %>"><br><br>
		
		<label class="phone-txt">Phone Number</label><br>
		<input type="text" class="phone" name="cust_phone" value="<%=resultSet.getString("cust_phone") %>"><br><br>
		
		<label class="email-txt">Email</label><br>
		<input type="text" class="email" name="cust_email" value="<%=resultSet.getString("cust_email") %>"><br><br>
		
		<label class="password-txt">Password:</label><br>
		<input type="text" class="password" name="cust_password" value="<%=resultSet.getString("cust_password") %>"><br><br><br>
		
		<input type="submit" class="submit-btn" value="UPDATE">
	</form>
	<%
	}
	connection.close();
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	%>
</body>
</html>
