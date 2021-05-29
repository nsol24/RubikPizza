<%@page import="java.sql.*"%>

<%!String driverName = "com.mysql.jdbc.Driver";%>
<%!String url = "jdbc:mysql://us-cdbr-east-04.cleardb.com:3306/heroku_76c19b622dd9a4e";%>
<%!String user = "b9d191c32faac0";%>
<%!String password = "f4a019ef";%>
<%

String cust_id = request.getParameter("cust_id");
String cust_name = request.getParameter("cust_name");
String cust_address = request.getParameter("cust_address");
String cust_phone =request.getParameter("cust_phone");
String cust_email = request.getParameter("cust_email");
String cust_password = request.getParameter("cust_password");

if(cust_id != null)
{
	Connection conn = null;
	PreparedStatement ps = null;
	
	try
	{
		Class.forName(driverName);
		conn = DriverManager.getConnection(url, user, password);
		
		String sql = "UPDATE customer SET cust_id=?, cust_name=?, cust_address=?, cust_phone=?, cust_email=?, cust_password=? WHERE cust_id = " + cust_id;
		ps = conn.prepareStatement(sql);
		ps.setString(1, cust_id);
		ps.setString(2, cust_name);
		ps.setString(3, cust_address);
		ps.setString(4, cust_phone);
		ps.setString(5, cust_email);
		ps.setString(6, cust_password);
		
		int i = ps.executeUpdate();
		if(i>0)
		{
		response.sendRedirect("updatesuccessful.jsp");
		}
		else
		{
		out.print("Update failed! Please try again.");
		}
		}	
		catch(SQLException sql)
		{
			request.setAttribute("error", sql);
			out.println(sql);
		}
	}
%>
