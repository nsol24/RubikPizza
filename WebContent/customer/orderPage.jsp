<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.sql.*" %>
<%@ page import="Model.*,Dao.*,java.sql.*, java.util.*,Connection.*" %>
<%
	menuDAO dao = new menuDAO();
	List<Menu> menu = dao.getAllMenu();

%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/styleMenu.css">

<link rel="icon" href="../img/favicon.png">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Pizza</title>

</head>
<body>
	<div class="logo">
		<a href="homepage.jsp"><img src="../img/logo2.png"></a>
	</div>
	<nav>
		<ul>
		
			<li><a href="logout.jsp">LOGOUT</a></li>
			<li><a id="myAcc">MY ACCOUNT</a></li>
			<li><a href="history.jsp">HISTORY</a></li>
			<li><a href="order.jsp">ORDER</a></li>
			<li><a href="cart.jsp">MYCART</a></li>
			<li><a> <%=session.getAttribute("session_email")%></a></li>
		</ul>
	</nav>
	<div class="container">
		<div class="card-header my-3">All Products</div>		
		<div class="row">
		<c:forEach items = "${menu}" var="m">	
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<div class="card-body">
						<h5 class="card-title"><c:out value="${m.name}" /></h5>						
						<h6 class="price">Price:<c:out value="${m.price}" /></h6>						
						<h6 class="category">Description:<c:out value="${m.desc}" /></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a class="btn btn-primary" href="AddOrderController?id=<c:out value="${m.id}" />">Buy now</a> 							
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
		</div>
		
	</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>