<%@page import="java.sql.*"%>
<head>
<link rel="stylesheet" href="css/style.css">
<link rel="icon" href="img/favicon.png">
<title>List of Customers | Rubiks Pizza</title>
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

	<div class="list-customer">
		<h1 align="center">CUSTOMER LIST</h1>
		<br>
		<table class="list-customer-table">
			<tr style="color: black" bgcolor="#99ff33">
				<th>ID</th>
				<th>NAME</th>
				<th>ADDRESS</th>
				<th>PHONE</th>
				<th>EMAIL</th>
				<th>PASSWORD</th>
				<th>ACTIONS</th>
			</tr>
	<%
	try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-04.cleardb.com:3306/heroku_76c19b622dd9a4e", "b9d191c32faac0", "f4a019ef");
	Statement st = con.createStatement();
	
	String sql ="SELECT * FROM customer";
	
	ResultSet rs = st.executeQuery(sql);
	while(rs.next()){
	%>
			<tr font-color="black" bgcolor="#99ff33">
				<td><%=rs.getString("cust_id") %></td>
				<td><%=rs.getString("cust_name") %></td>
				<td><%=rs.getString("cust_address") %></td>
				<td><%=rs.getString("cust_phone") %></td>
				<td><%=rs.getString("cust_email") %></td>
				<td><%=rs.getString("cust_password") %></td>
				<td align="center">
					<a href="updatecust.jsp?cust_id=<%=rs.getString("cust_id")%>">
						<button type="button" class="update">Update</button>
					</a>&nbsp;
					<a href="deletecust.jsp?cust_id=<%=rs.getString("cust_id")%>">
						<button type="button" class="delete">Delete</button>
					</a>
				</td>
			</tr>

			<% 
	}
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	%>
		</table>
	</div>
</body>
