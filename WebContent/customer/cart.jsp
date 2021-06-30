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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Cart</title>

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
			<li><a href="#menu">MENU</a></li>
			<li><a> <%=session.getAttribute("email")%></a></li>
		</ul>
	</nav>
	<div class="container">
		
		<div class="d-flex py-3"><h3>Total Price : </h3><a class="mx-3 btn btn-primary" href=#>Check Out</a></div>
		<table class="table table-loght">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Buy Now</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Beef</td>
					<td>pizza</td>
					<td>45</td>
					<td>
						<form action="" method="post" class="form-inline">
							<input type="hidden" name="id" value="1" class="form-input">
							<div class="form-group d-flex justify-content-between">
								<a class="btn btn-sm btn-incre" href="#"><i class="fas fa-plus-square"></i></a>
								<input type="text" name="quantity" class="form-control" value="1" readonly>
								<a class="btn btn-sm btn-decre" href="#"><i class="fas fa-minus-square"></i></a>
							</div>
							
						</form>
					</td>
					<td><a href="#" class="btn btn-sm btn-danger">Remove</a></td>
				</tr>
			</tbody>

		</table>
	</div>
	
	
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>