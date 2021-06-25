<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@ page import="Model.*,Dao.*,java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>invalid</title>
</head>
<body>

<!-- get session -->
<% String email = (String) session.getAttribute("currentSessionUser");%>
Welcome <%=email%>

</body>
</html>