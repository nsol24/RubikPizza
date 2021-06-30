<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.sql.*" %>
	<%@ page import="Model.*,Dao.*,java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/homepage.css">
<link rel="icon" href="../img/favicon.png">

<meta charset="ISO-8859-1">
<title>Online Pizza Delivery |HomePage</title>

</head>
<body>
	<div class="logo">
		<a href="homepage.jsp"><img src="../img/logo2.png"></a>
	</div>
	<nav>
		<ul>
		
			<li><a href="logout.jsp">LOGOUT</a></li>
			<li><a href="profile.jsp">MY ACCOUNT</a></li>
			<li><a href="history.jsp">HISTORY</a></li>
			<li><a href="order.jsp">ORDER</a></li>
			<li><a href="">CART</a></li>
			<li><a> <%=session.getAttribute("email")%></a></li>
			
		</ul>
	</nav>
	
	<div style="width: 100%; height: 40px;">
		<img src="../img/homebanner.jpg" alt="banner" style="float: left; width: 100%; height: 750px; ">
	</div>
	
	<section style="background-color:  #ffe6cc;" class="categories" id="menu">
        <div class="container">
            <h2 class="text-center">Foods</h2>

            <a href="pizzaPage.jsp">
            <div class="box-3 float-container">
                <img src="../images/pizza.jpg" alt="Pizza" class="img-responsive img-curve">

                <h3 class="float-text text-white">Pizza</h3>
            </div>
            </a>

            <a href="spagetiPage.jsp">
            <div class="box-3 float-container">
                <img src="../images/speghatti.jpg" alt="Burger" class="img-responsive img-curve">

                <h3 class="float-text text-white">Spaghetti</h3>
            </div>
            </a>

            <a href="dishesPage.jsp">
            <div class="box-3 float-container">
                <img src="../images/momo.jpg" alt="Momo" class="img-responsive img-curve">

                <h3 class="float-text text-white">Side dishes</h3>
            </div>
            </a>

            <div class="clearfix"></div>
        </div>
    </section>
    
    <nav >
    
    	<div id="menu" style="width: 100%; height: 40px;">
		<img src="../img/menubanner.jpg" alt="banner" style="float: left; width: 100%; height: 750px; ">
	</div>
    
    </nav>
 
</body>
</html>