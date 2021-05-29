<%@page import="java.sql.*"%>
<header>
</header>
<body>
<h2 align="center">
	<font><strong>CUSTOMER LIST</strong></font>
</h2>

<table align="center" cellpadding="10" cellspacing="3" border="1">
	<tr>

	</tr>
	<tr style="color: black" bgcolor="#99ff33">
		<td><b>ID</b></td>
		<td><b>NAME</b></td>
		<td><b>ADDRESS</b></td>
		<td><b>PHONE</b></td>
		<td><b>EMAIL</b></td>
		<td><b>PASSWORD</b></td>
		<td><b>ACTIONS</b></td>
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

		<td align="center"><a
			href="updatecust.jsp?cust_id=<%=rs.getString("cust_id")%>"><button
					type="button" class="update">Update</button></a> &nbsp; <a
			href="deletecust.jsp?cust_id=<%=rs.getString("cust_id") %>"><button
					type="button" class="delete">Delete</button></a></td>
	</tr>

	<% 
	}
	
	} catch (Exception e) {
	e.printStackTrace();
	}
	%>
</table>
</body>