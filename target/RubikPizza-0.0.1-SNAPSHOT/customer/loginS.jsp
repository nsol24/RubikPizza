<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %>
<html>
<head>

<title>Online Pizza Delivery | Rubiks Pizza</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div class="logo">
	<header><a href="index.jsp"><img src="img/logo2.png"></a></header></div>
	<%! String userdbEmail;
		String userdbPsw;
	%>

	<%
		Connection con= null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://us-cdbr-east-04.cleardb.com:3306/heroku_76c19b622dd9a4e";
		String user = "b9d191c32faac0";
		String passw = "f4a019ef";
		String sql = "select * from customer where cust_email=? and cust_password=?";
		String email = request.getParameter("cust_email");
		String password = request.getParameter("cust_password");
		
		if((!(email.equals(null) || email.equals("")) && !(password.equals(null) || password.equals(""))))
		{
			try{
				
				Class.forName(driverName);
				con = DriverManager.getConnection(url, user, passw);
				ps = con.prepareStatement(sql);
				ps.setString(1, email);
				ps.setString(2, password);
				rs = ps.executeQuery();
			
				if(rs.next())
				{
					userdbEmail = rs.getString("cust_email");
					userdbPsw = rs.getString("cust_password");
				
					if(email.equals(userdbEmail) && password.equals(userdbPsw))
					{
						session.setAttribute("email",userdbEmail);
						response.sendRedirect("homepage.jsp"); 
					} 
				}

				else
					response.sendRedirect("error.jsp");

			rs.close();
			ps.close(); 
			}

			catch(SQLException sqe)
			{
				out.println(sqe);
			} 

		}
		else
		{

	%>

	<p style="color:red">Error In Login</p>

	<% 
			getServletContext().getRequestDispatcher("/login.jsp").include(request, response);
		}
	%>

</body>

</html>