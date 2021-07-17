<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.sql.*" %>
<%@page import="java.text.DecimalFormat"%>
<%@ page import="Model.*,Dao.*,java.sql.*, java.util.*,Connection.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../css/styleMenu.css">

<link rel="icon" href="../img/favicon.png">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<link href="assets/css/custom.css" rel="stylesheet" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
<title>Order Details</title>
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
			<li><a><%=session.getAttribute("session_email")%></a></li>
		</ul>
	</nav>
	<div class="container">	
		<div class="col-lg-6 col-md-6">
			<div class="panel panel-primary">
       			<div class="panel-heading">
           		Default Panel
        			</div>
        				<div class="panel-body">
        				
        				<table class="table table-borderless">
        					<tbody>
        						<tr>
        							<td>ID</td>
        							<td><c:out value="${menu.id}" /></td>
        						</tr>
        						<tr>
        							<td>Name</td>
        							<td><c:out value="${menu.name}" /></td>
        						</tr>
        						<tr>
        							<td>Price</td>
        							
        							<td><c:out value="${menu.price}" /></td>
        						</tr>
        						
        						<form>
        							<tr> 
        							
        								<td>Quantity</td>
		        						<td>
		        						<a class="btn btn-sm btn-incre" href="quantityController?action=inc="><i class="fas fa-plus-square"></i></a>
		        						<input type="text" id="quantity" name="quantity" min="1" max="100" value="">
		        						<a class="btn btn-sm btn-decre" href="quantityController?action=dec="><i class="fas fa-minus-square"></i></a>
		        						</td>
        							</tr>
        						
        						</form>
        					</tbody>
        				</table>
		        			
        				</div>
         			<div class="panel-footer">
              			Panel Footer
         			</div>
        		</div>
			</div>
	</divs>
	
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
   <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="assets/js/bootstrap.min.js"></script>
      <!-- CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script>
</body>
</html>