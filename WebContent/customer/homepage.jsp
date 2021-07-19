<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/homepage1.css">
<link rel="stylesheet" href="../css/homepage.css">
<link rel="icon" href="../img/favicon.png">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>Online Pizza Delivery |HomePage</title>
</head>
<body>
	<div class="logo">
		<a href="CustRedirectController?action=homepage"><img src="../img/logo2.png"></a>
	</div>
	<nav>
		<ul>		
			<li><a href="logout.jsp">LOGOUT</a></li>
			<li><a href="CustRedirectController?action=custprofile">MY ACCOUNT</a></li>
			<li><a href="history.jsp">HISTORY</a></li>
			
			<li><a href="">CART</a></li>
			<li><a> <%=session.getAttribute("session_email")%></a></li>			
		</ul>
	</nav>
	
	<div style="width: 100%; height: 40px;">
		<img src="../img/homebanner.jpg" alt="banner" style="float: left; width: 100%; height: 750px; ">
	</div>
	
	<section style="background-color:  #ffe6cc;" class="categories" id="menu">
        <div class="container">
        <h2 class="text-center">Foods</h2>
				<div class="card-header my-3">All Products</div>		
				<div class="row">
				<c:forEach items = "${menu}" var="m">	
					<div class="col-md-3 my-3">
						<div class="card w-100">
							<img class="card-img-top" src="data:image/jpg;base64,${m.base64Image}" width="240" height="300"/>
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
    </section>
    
    <nav >
    
    	<div id="menu" style="width: 100%; height: 40px;">
		<img src="../img/menubanner.jpg" alt="banner" style="float: left; width: 100%; height: 750px; ">
	</div>
    
    </nav>
 
</body>
</html>